package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.b.o;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
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
  public static final byte[] rLo;
  private ServerSocket aFm;
  private Socket aFp;
  private Object lock;
  private Boolean rTh;
  private MMHandler rTi;
  private MMHandler rTj;
  private DataOutputStream rTk;
  private int rTl;
  private int rTm;
  private long rTn;
  
  static
  {
    AppMethodBeat.i(21882);
    rLo = "GSMW".getBytes();
    AppMethodBeat.o(21882);
  }
  
  public b()
  {
    AppMethodBeat.i(21869);
    this.rTh = Boolean.FALSE;
    this.aFm = null;
    this.aFp = null;
    this.rTi = null;
    this.rTj = new MMHandler(Looper.getMainLooper());
    this.rTk = null;
    this.lock = new Object();
    this.rTl = 0;
    this.rTm = 0;
    this.rTn = 0L;
    cuq();
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
        if ((!this.rTh.booleanValue()) && (this.rTl != 4))
        {
          j = paramDataInputStream.readByte();
          if (rLo[this.rTl] == j)
          {
            this.rTl += 1;
            continue;
          }
        }
        try
        {
          paramDataInputStream.close();
          if (!this.rTh.booleanValue()) {
            a(true, 0, 10006, "read_error ".concat(String.valueOf(localException)).getBytes());
          }
          cup();
          AppMethodBeat.o(21877);
          return;
          long l1 = Util.nowSecond();
          long l2 = this.rTn;
          if (this.rTm - (l1 - l2) < 10L)
          {
            if (this.rTm < 0) {
              this.rTm = 0;
            }
            this.rTm += 1;
            this.rTn = l1;
            i = 0;
            String str;
            if (i == 0)
            {
              str = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[] { Integer.valueOf(this.rTl + 1), Integer.valueOf(rLo[this.rTl] & 0xFF), Integer.valueOf(j & 0xFF) });
              Log.e("MicroMsg.BakOldJavaEngine", str);
              a(true, 0, 10007, str.getBytes());
            }
            this.rTl = 0;
            continue;
            this.rTl = 0;
            j = paramDataInputStream.readInt();
            short s1 = paramDataInputStream.readShort();
            s2 = paramDataInputStream.readShort();
            int k = paramDataInputStream.readInt();
            if (k > 16777216)
            {
              str = String.format("loopRead size to large:%d", new Object[] { Integer.valueOf(k) });
              Log.e("MicroMsg.BakOldJavaEngine", str);
              this.rTh = Boolean.TRUE;
              a(true, 0, 10007, str.getBytes());
              AppMethodBeat.o(21877);
              return;
            }
            int m = paramDataInputStream.readInt();
            Log.i("MicroMsg.BakOldJavaEngine", "read buf size:".concat(String.valueOf(k)));
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
            localObject1 = rLo;
            if (s1 != 1)
            {
              localObject1 = String.format("unpack failed, getVersion:%d", new Object[] { Short.valueOf(s1) });
              Log.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -1;
              Log.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[] { Integer.valueOf(i) });
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
              if (com.tencent.mm.plugin.backup.g.b.csc() != 1) {
                break label821;
              }
              i = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a((byte[])localObject1, j, s1, s2, k, (byte[])localObject2);
              if (m == i) {
                break label821;
              }
              localObject1 = new CRC32();
              ((CRC32)localObject1).update((byte[])localObject2);
              localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.bg((byte[])localObject2);
              localObject1 = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Short.valueOf(s2), Integer.valueOf(k), Integer.valueOf((int)((CRC32)localObject1).getValue()), localObject2 });
              Log.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -2;
              break;
              for (;;)
              {
                localPByteArray.value = ((byte[])localObject1);
                i = 0;
                break;
                localObject1 = l.d((byte[])localObject2, d.csd());
              }
            }
            Log.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Short.valueOf(s2) });
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
      Log.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[] { localException });
    }
  }
  
  private void a(final boolean paramBoolean, final int paramInt1, final int paramInt2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21873);
    this.rTj.post(new Runnable()
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
  private void cup()
  {
    // Byte code:
    //   0: sipush 21872
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 91	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:rTl	I
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 93	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:rTm	I
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield 95	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:rTn	J
    //   21: aload_0
    //   22: getstatic 287	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   25: putfield 66	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:rTh	Ljava/lang/Boolean;
    //   28: aload_0
    //   29: getfield 89	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:lock	Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 87	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:rTk	Ljava/io/DataOutputStream;
    //   39: ifnull +10 -> 49
    //   42: aload_0
    //   43: getfield 87	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:rTk	Ljava/io/DataOutputStream;
    //   46: invokevirtual 378	java/io/DataOutputStream:close	()V
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 70	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:aFp	Ljava/net/Socket;
    //   55: ifnull +10 -> 65
    //   58: aload_0
    //   59: getfield 70	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:aFp	Ljava/net/Socket;
    //   62: invokevirtual 379	java/net/Socket:close	()V
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
    //   28	35	83	java/lang/Exception
    //   73	83	83	java/lang/Exception
    //   51	65	87	java/lang/Exception
  }
  
  private void cuq()
  {
    AppMethodBeat.i(21876);
    if ((this.rTi == null) || (this.rTi.isQuit())) {
      this.rTi = new MMHandler("BackupJavaEngine_handler");
    }
    AppMethodBeat.o(21876);
  }
  
  public final void bh(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21875);
    if (this.rTh.booleanValue())
    {
      Log.e("MicroMsg.BakOldJavaEngine", "engine has stop");
      AppMethodBeat.o(21875);
      return;
    }
    this.rTi.post(new Runnable()
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
          Log.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[] { localException });
          b.c(b.this);
          b.a(b.this, 10008, "send_error ".concat(String.valueOf(localException)).getBytes());
          AppMethodBeat.o(21867);
        }
      }
    });
    AppMethodBeat.o(21875);
  }
  
  public final void cuo()
  {
    AppMethodBeat.i(21871);
    Log.i("MicroMsg.BakOldJavaEngine", "close connect");
    cup();
    a(true, 0, 10003, null);
    AppMethodBeat.o(21871);
  }
  
  public final void f(final int paramInt, final List<adp> paramList)
  {
    AppMethodBeat.i(21870);
    Log.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[] { Integer.valueOf(paramInt) });
    cuq();
    ThreadPool.post(new Runnable()
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
          localObject = (WifiManager)MMApplicationContext.getContext().getSystemService("wifi");
          int j = ConnectivityCompat.Companion.getWiFiIpAddress();
          localObject = ((WifiManager)localObject).getDhcpInfo();
          if (localObject == null)
          {
            AppMethodBeat.o(21864);
            return;
          }
          k = ((DhcpInfo)localObject).netmask;
          str = (j & 0xFF) + "." + (j >> 8 & 0xFF) + "." + (j >> 16 & 0xFF) + "." + (j >> 24 & 0xFF);
          Log.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", new Object[] { str, Integer.valueOf(k) });
          localObject = null;
          i = 0;
          Iterator localIterator = paramList.iterator();
          label191:
          while (localIterator.hasNext())
          {
            adp localadp = (adp)localIterator.next();
            Log.i("MicroMsg.BakOldJavaEngine", "try ip:%s", new Object[] { localadp.Slg });
            if (localadp.Slg != null)
            {
              String[] arrayOfString = localadp.Slg.split("\\.");
              if (arrayOfString.length >= 4)
              {
                int m = o.Y(new byte[] { (byte)(Util.getInt(arrayOfString[0], 0) & 0xFF), (byte)(Util.getInt(arrayOfString[1], 0) & 0xFF), (byte)(Util.getInt(arrayOfString[2], 0) & 0xFF), (byte)(Util.getInt(arrayOfString[3], 0) & 0xFF) });
                if ((k & m) == (k & j))
                {
                  b.a(b.this, localadp.Slg, ((Integer)localadp.SpS.getFirst()).intValue());
                  AppMethodBeat.o(21864);
                  return;
                }
                if ((m & 0xFFFF) != (0xFFFF & j)) {
                  break label555;
                }
                localObject = localadp.Slg;
                i = ((Integer)localadp.SpS.getFirst()).intValue();
              }
            }
          }
        }
        label555:
        for (;;)
        {
          break label191;
          if (localObject != null)
          {
            Log.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", new Object[] { localObject, Integer.valueOf(i) });
            b.a(b.this, (String)localObject, i);
            AppMethodBeat.o(21864);
            return;
          }
          b.a(b.this, 10009, String.format("not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str }).getBytes());
          Log.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", new Object[] { Integer.valueOf(k), str });
          AppMethodBeat.o(21864);
          return;
          b.a(b.this, ((Integer)((adp)paramList.get(0)).SpS.getFirst()).intValue());
          break;
        }
      }
    }, "BackupJavaEngine_connect");
    AppMethodBeat.o(21870);
  }
  
  public final void m(final int paramInt, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21874);
    if (this.rTi != null)
    {
      bh(paramArrayOfByte);
      AppMethodBeat.o(21874);
      return;
    }
    this.rTj.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21866);
        b.this.bh(paramArrayOfByte);
        AppMethodBeat.o(21866);
      }
    }, 200L);
    AppMethodBeat.o(21874);
  }
  
  public final int n(int paramInt, byte[] paramArrayOfByte)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b
 * JD-Core Version:    0.7.0.1
 */