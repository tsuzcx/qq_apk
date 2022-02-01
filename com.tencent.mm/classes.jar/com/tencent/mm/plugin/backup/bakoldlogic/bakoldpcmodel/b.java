package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

public final class b
  implements b.a
{
  public static final byte[] mSH;
  private Object lock;
  private Boolean nat;
  private ao nau;
  private ao nav;
  private DataOutputStream naw;
  private int nax;
  private int nay;
  private long naz;
  private ServerSocket serverSocket;
  private Socket socket;
  
  static
  {
    AppMethodBeat.i(21882);
    mSH = "GSMW".getBytes();
    AppMethodBeat.o(21882);
  }
  
  public b()
  {
    AppMethodBeat.i(21869);
    this.nat = Boolean.FALSE;
    this.serverSocket = null;
    this.socket = null;
    this.nau = null;
    this.nav = new ao(Looper.getMainLooper());
    this.naw = null;
    this.lock = new Object();
    this.nax = 0;
    this.nay = 0;
    this.naz = 0L;
    bFf();
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
        if ((!this.nat.booleanValue()) && (this.nax != 4))
        {
          j = paramDataInputStream.readByte();
          if (mSH[this.nax] == j)
          {
            this.nax += 1;
            continue;
          }
        }
        try
        {
          paramDataInputStream.close();
          if (!this.nat.booleanValue()) {
            a(true, 0, 10006, "read_error ".concat(String.valueOf(localException)).getBytes());
          }
          bFe();
          AppMethodBeat.o(21877);
          return;
          long l1 = bs.aNx();
          long l2 = this.naz;
          if (this.nay - (l1 - l2) < 10L)
          {
            if (this.nay < 0) {
              this.nay = 0;
            }
            this.nay += 1;
            this.naz = l1;
            i = 0;
            String str;
            if (i == 0)
            {
              str = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[] { Integer.valueOf(this.nax + 1), Integer.valueOf(mSH[this.nax] & 0xFF), Integer.valueOf(j & 0xFF) });
              ac.e("MicroMsg.BakOldJavaEngine", str);
              a(true, 0, 10007, str.getBytes());
            }
            this.nax = 0;
            continue;
            this.nax = 0;
            j = paramDataInputStream.readInt();
            short s1 = paramDataInputStream.readShort();
            s2 = paramDataInputStream.readShort();
            int k = paramDataInputStream.readInt();
            if (k > 16777216)
            {
              str = String.format("loopRead size to large:%d", new Object[] { Integer.valueOf(k) });
              ac.e("MicroMsg.BakOldJavaEngine", str);
              this.nat = Boolean.TRUE;
              a(true, 0, 10007, str.getBytes());
              AppMethodBeat.o(21877);
              return;
            }
            int m = paramDataInputStream.readInt();
            ac.i("MicroMsg.BakOldJavaEngine", "read buf size:".concat(String.valueOf(k)));
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
            localObject1 = mSH;
            if (s1 != 1)
            {
              localObject1 = String.format("unpack failed, getVersion:%d", new Object[] { Short.valueOf(s1) });
              ac.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -1;
              ac.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label755;
              }
              if (localPByteArray.value != null) {
                break label738;
              }
            }
            for (localObject1 = "";; localObject1 = new String(localPByteArray.value))
            {
              a(true, 0, 10007, ((String)localObject1).getBytes());
              AppMethodBeat.o(21877);
              return;
              if (com.tencent.mm.plugin.backup.g.b.bCS() != 1) {
                break label820;
              }
              i = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a((byte[])localObject1, j, s1, s2, k, (byte[])localObject2);
              if (m == i) {
                break label820;
              }
              localObject1 = new CRC32();
              ((CRC32)localObject1).update((byte[])localObject2);
              localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.aC((byte[])localObject2);
              localObject1 = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Short.valueOf(s2), Integer.valueOf(k), Integer.valueOf((int)((CRC32)localObject1).getValue()), localObject2 });
              ac.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -2;
              break;
              for (;;)
              {
                localPByteArray.value = ((byte[])localObject1);
                i = 0;
                break;
                localObject1 = l.d((byte[])localObject2, d.bCT());
              }
            }
            ac.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Short.valueOf(s2) });
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
      ac.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[] { localException });
    }
  }
  
  private void a(final boolean paramBoolean, final int paramInt1, final int paramInt2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21873);
    this.nav.post(new Runnable()
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
  private void bFe()
  {
    // Byte code:
    //   0: sipush 21872
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 89	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:nax	I
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 91	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:nay	I
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield 93	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:naz	J
    //   21: aload_0
    //   22: getstatic 285	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   25: putfield 64	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:nat	Ljava/lang/Boolean;
    //   28: aload_0
    //   29: getfield 87	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:lock	Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 85	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:naw	Ljava/io/DataOutputStream;
    //   39: ifnull +10 -> 49
    //   42: aload_0
    //   43: getfield 85	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:naw	Ljava/io/DataOutputStream;
    //   46: invokevirtual 374	java/io/DataOutputStream:close	()V
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 68	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:socket	Ljava/net/Socket;
    //   55: ifnull +10 -> 65
    //   58: aload_0
    //   59: getfield 68	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:socket	Ljava/net/Socket;
    //   62: invokevirtual 375	java/net/Socket:close	()V
    //   65: sipush 21872
    //   68: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: astore_2
    //   73: aload_1
    //   74: monitorexit
    //   75: sipush 21872
    //   78: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: athrow
    //   83: astore_1
    //   84: goto -33 -> 51
    //   87: astore_1
    //   88: sipush 21872
    //   91: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void bFf()
  {
    AppMethodBeat.i(21876);
    if ((this.nau == null) || (this.nau.isQuit())) {
      this.nau = new ao("BackupJavaEngine_handler");
    }
    AppMethodBeat.o(21876);
  }
  
  public final void aD(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21875);
    if (this.nat.booleanValue())
    {
      ac.e("MicroMsg.BakOldJavaEngine", "engine has stop");
      AppMethodBeat.o(21875);
      return;
    }
    this.nau.post(new Runnable()
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
          ac.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[] { localException });
          b.c(b.this);
          b.a(b.this, 10008, "send_error ".concat(String.valueOf(localException)).getBytes());
          AppMethodBeat.o(21867);
        }
      }
    });
    AppMethodBeat.o(21875);
  }
  
  public final void bFd()
  {
    AppMethodBeat.i(21871);
    ac.i("MicroMsg.BakOldJavaEngine", "close connect");
    bFe();
    a(true, 0, 10003, null);
    AppMethodBeat.o(21871);
  }
  
  public final void f(int paramInt, List<za> paramList)
  {
    AppMethodBeat.i(21870);
    ac.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[] { Integer.valueOf(paramInt) });
    bFf();
    com.tencent.mm.sdk.g.b.c(new b.1(this, paramInt, paramList), "BackupJavaEngine_connect");
    AppMethodBeat.o(21870);
  }
  
  public final void l(final int paramInt, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21874);
    if (this.nau != null)
    {
      aD(paramArrayOfByte);
      AppMethodBeat.o(21874);
      return;
    }
    this.nav.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21866);
        b.this.aD(paramArrayOfByte);
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