package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.b.o;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;

public final class b
  implements b.a
{
  public static final byte[] mqF;
  private Object lock;
  private Boolean mys;
  private ap myt;
  private ap myu;
  private DataOutputStream myv;
  private int myw;
  private int myx;
  private long myy;
  private ServerSocket serverSocket;
  private Socket socket;
  
  static
  {
    AppMethodBeat.i(21882);
    mqF = "GSMW".getBytes();
    AppMethodBeat.o(21882);
  }
  
  public b()
  {
    AppMethodBeat.i(21869);
    this.mys = Boolean.FALSE;
    this.serverSocket = null;
    this.socket = null;
    this.myt = null;
    this.myu = new ap(Looper.getMainLooper());
    this.myv = null;
    this.lock = new Object();
    this.myw = 0;
    this.myx = 0;
    this.myy = 0L;
    byj();
    AppMethodBeat.o(21869);
  }
  
  private void a(DataInputStream paramDataInputStream)
  {
    AppMethodBeat.i(21877);
    try
    {
      for (;;)
      {
        int j;
        if ((!this.mys.booleanValue()) && (this.myw != 4))
        {
          j = paramDataInputStream.readByte();
          if (mqF[this.myw] == j)
          {
            this.myw += 1;
            continue;
          }
        }
        try
        {
          paramDataInputStream.close();
          if (!this.mys.booleanValue()) {
            a(true, 0, 10006, "read_error ".concat(String.valueOf(localException)).getBytes());
          }
          byi();
          AppMethodBeat.o(21877);
          return;
          long l1 = bt.aGK();
          long l2 = this.myy;
          if (this.myx - (l1 - l2) < 10L)
          {
            if (this.myx < 0) {
              this.myx = 0;
            }
            this.myx += 1;
            this.myy = l1;
            i = 0;
            String str;
            if (i == 0)
            {
              str = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[] { Integer.valueOf(this.myw + 1), Integer.valueOf(mqF[this.myw] & 0xFF), Integer.valueOf(j & 0xFF) });
              ad.e("MicroMsg.BakOldJavaEngine", str);
              a(true, 0, 10007, str.getBytes());
            }
            this.myw = 0;
            continue;
            this.myw = 0;
            j = paramDataInputStream.readInt();
            short s1 = paramDataInputStream.readShort();
            s2 = paramDataInputStream.readShort();
            int k = paramDataInputStream.readInt();
            if (k > 16777216)
            {
              str = String.format("loopRead size to large:%d", new Object[] { Integer.valueOf(k) });
              ad.e("MicroMsg.BakOldJavaEngine", str);
              this.mys = Boolean.TRUE;
              a(true, 0, 10007, str.getBytes());
              AppMethodBeat.o(21877);
              return;
            }
            int m = paramDataInputStream.readInt();
            ad.i("MicroMsg.BakOldJavaEngine", "read buf size:".concat(String.valueOf(k)));
            localObject2 = new byte[k - 20];
            i = 0;
            while (i < localObject2.length)
            {
              int n = paramDataInputStream.read((byte[])localObject2, i, localObject2.length - i);
              if (n == -1) {
                try
                {
                  Thread.sleep(200L);
                }
                catch (InterruptedException localInterruptedException) {}
              } else {
                i += n;
              }
            }
            PByteArray localPByteArray = new PByteArray();
            localObject1 = mqF;
            if (s1 != 1)
            {
              localObject1 = String.format("unpack failed, getVersion:%d", new Object[] { Short.valueOf(s1) });
              ad.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -1;
              ad.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label756;
              }
              if (localPByteArray.value != null) {
                break label739;
              }
            }
            for (localObject1 = "";; localObject1 = new String(localPByteArray.value))
            {
              a(true, 0, 10007, ((String)localObject1).getBytes());
              AppMethodBeat.o(21877);
              return;
              if (com.tencent.mm.plugin.backup.g.b.bvW() != 1) {
                break label821;
              }
              i = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a((byte[])localObject1, j, s1, s2, k, (byte[])localObject2);
              if (m == i) {
                break label821;
              }
              localObject1 = new CRC32();
              ((CRC32)localObject1).update((byte[])localObject2);
              localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.aD((byte[])localObject2);
              localObject1 = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Short.valueOf(s2), Integer.valueOf(k), Integer.valueOf((int)((CRC32)localObject1).getValue()), localObject2 });
              ad.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -2;
              break;
              for (;;)
              {
                localPByteArray.value = ((byte[])localObject1);
                i = 0;
                break;
                localObject1 = l.d((byte[])localObject2, d.bvX());
              }
            }
            ad.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Short.valueOf(s2) });
            a(false, j, s2, localPByteArray.value);
            AppMethodBeat.o(21877);
            return;
          }
        }
        catch (IOException paramDataInputStream)
        {
          for (;;)
          {
            short s2;
            Object localObject2;
            continue;
            int i = 1;
            continue;
            Object localObject1 = localObject2;
            if (s2 != 1) {
              if (s2 == 2) {
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[] { localException });
    }
  }
  
  private void a(final boolean paramBoolean, final int paramInt1, final int paramInt2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21873);
    this.myu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21865);
        com.tencent.mm.plugin.backup.g.b.b(paramBoolean, paramInt1, paramInt2, paramArrayOfByte);
        AppMethodBeat.o(21865);
      }
    });
    AppMethodBeat.o(21873);
  }
  
  /* Error */
  private void byi()
  {
    // Byte code:
    //   0: sipush 21872
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 91	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:myw	I
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 93	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:myx	I
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield 95	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:myy	J
    //   21: aload_0
    //   22: getstatic 287	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   25: putfield 66	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:mys	Ljava/lang/Boolean;
    //   28: aload_0
    //   29: getfield 89	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:lock	Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 87	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:myv	Ljava/io/DataOutputStream;
    //   39: ifnull +10 -> 49
    //   42: aload_0
    //   43: getfield 87	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:myv	Ljava/io/DataOutputStream;
    //   46: invokevirtual 376	java/io/DataOutputStream:close	()V
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 70	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:socket	Ljava/net/Socket;
    //   55: ifnull +10 -> 65
    //   58: aload_0
    //   59: getfield 70	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:socket	Ljava/net/Socket;
    //   62: invokevirtual 377	java/net/Socket:close	()V
    //   65: sipush 21872
    //   68: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: astore_2
    //   73: aload_1
    //   74: monitorexit
    //   75: sipush 21872
    //   78: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: athrow
    //   83: astore_1
    //   84: goto -33 -> 51
    //   87: astore_1
    //   88: sipush 21872
    //   91: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	b
    //   83	1	1	localException1	Exception
    //   87	1	1	localException2	Exception
    //   72	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	49	72	finally
    //   49	51	72	finally
    //   73	75	72	finally
    //   28	35	83	java/lang/Exception
    //   75	83	83	java/lang/Exception
    //   51	65	87	java/lang/Exception
  }
  
  private void byj()
  {
    AppMethodBeat.i(21876);
    if ((this.myt == null) || (this.myt.isQuit())) {
      this.myt = new ap("BackupJavaEngine_handler");
    }
    AppMethodBeat.o(21876);
  }
  
  public final void aE(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21875);
    if (this.mys.booleanValue())
    {
      ad.e("MicroMsg.BakOldJavaEngine", "engine has stop");
      AppMethodBeat.o(21875);
      return;
    }
    this.myt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21867);
        try
        {
          synchronized (b.a(b.this))
          {
            b.b(b.this).write(paramArrayOfByte);
            b.b(b.this).flush();
            AppMethodBeat.o(21867);
            return;
          }
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[] { localException });
          b.c(b.this);
          b.a(b.this, 10008, "send_error ".concat(String.valueOf(localException)).getBytes());
          AppMethodBeat.o(21867);
        }
      }
    });
    AppMethodBeat.o(21875);
  }
  
  public final void byh()
  {
    AppMethodBeat.i(21871);
    ad.i("MicroMsg.BakOldJavaEngine", "close connect");
    byi();
    a(true, 0, 10003, null);
    AppMethodBeat.o(21871);
  }
  
  public final void f(final int paramInt, final List<yf> paramList)
  {
    AppMethodBeat.i(21870);
    ad.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[] { Integer.valueOf(paramInt) });
    byj();
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21864);
        Object localObject;
        int k;
        String str;
        int i;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(21864);
          return;
        case 1: 
          localObject = (WifiManager)aj.getContext().getSystemService("wifi");
          int j = ((WifiManager)localObject).getConnectionInfo().getIpAddress();
          localObject = ((WifiManager)localObject).getDhcpInfo();
          if (localObject == null)
          {
            AppMethodBeat.o(21864);
            return;
          }
          k = ((DhcpInfo)localObject).netmask;
          str = (j & 0xFF) + "." + (j >> 8 & 0xFF) + "." + (j >> 16 & 0xFF) + "." + (j >> 24 & 0xFF);
          ad.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", new Object[] { str, Integer.valueOf(k) });
          localObject = null;
          i = 0;
          Iterator localIterator = paramList.iterator();
          label193:
          while (localIterator.hasNext())
          {
            yf localyf = (yf)localIterator.next();
            ad.i("MicroMsg.BakOldJavaEngine", "try ip:%s", new Object[] { localyf.CWU });
            if (localyf.CWU != null)
            {
              String[] arrayOfString = localyf.CWU.split("\\.");
              if (arrayOfString.length >= 4)
              {
                int m = o.G(new byte[] { (byte)(bt.getInt(arrayOfString[0], 0) & 0xFF), (byte)(bt.getInt(arrayOfString[1], 0) & 0xFF), (byte)(bt.getInt(arrayOfString[2], 0) & 0xFF), (byte)(bt.getInt(arrayOfString[3], 0) & 0xFF) });
                if ((k & m) == (k & j))
                {
                  b.a(b.this, localyf.CWU, ((Integer)localyf.Dai.getFirst()).intValue());
                  AppMethodBeat.o(21864);
                  return;
                }
                if ((m & 0xFFFF) != (0xFFFF & j)) {
                  break label557;
                }
                localObject = localyf.CWU;
                i = ((Integer)localyf.Dai.getFirst()).intValue();
              }
            }
          }
        }
        label557:
        for (;;)
        {
          break label193;
          if (localObject != null)
          {
            ad.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", new Object[] { localObject, Integer.valueOf(i) });
            b.a(b.this, (String)localObject, i);
            AppMethodBeat.o(21864);
            return;
          }
          b.a(b.this, 10009, String.format("not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str }).getBytes());
          ad.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str });
          AppMethodBeat.o(21864);
          return;
          b.a(b.this, ((Integer)((yf)paramList.get(0)).Dai.getFirst()).intValue());
          break;
        }
      }
    }, "BackupJavaEngine_connect");
    AppMethodBeat.o(21870);
  }
  
  public final void l(final int paramInt, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21874);
    if (this.myt != null)
    {
      aE(paramArrayOfByte);
      AppMethodBeat.o(21874);
      return;
    }
    this.myu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21866);
        b.this.aE(paramArrayOfByte);
        AppMethodBeat.o(21866);
      }
    }, 200L);
    AppMethodBeat.o(21874);
  }
  
  public final int m(int paramInt, byte[] paramArrayOfByte)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b
 * JD-Core Version:    0.7.0.1
 */