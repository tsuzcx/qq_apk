package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  public static final byte[] jzh;
  private Socket iZd;
  private Boolean jGZ;
  private ServerSocket jHa;
  private ak jHb;
  private ak jHc;
  private DataOutputStream jHd;
  private int jHe;
  private int jHf;
  private long jHg;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(17825);
    jzh = "GSMW".getBytes();
    AppMethodBeat.o(17825);
  }
  
  public b()
  {
    AppMethodBeat.i(17812);
    this.jGZ = Boolean.FALSE;
    this.jHa = null;
    this.iZd = null;
    this.jHb = null;
    this.jHc = new ak(Looper.getMainLooper());
    this.jHd = null;
    this.lock = new Object();
    this.jHe = 0;
    this.jHf = 0;
    this.jHg = 0L;
    aVa();
    AppMethodBeat.o(17812);
  }
  
  private void a(DataInputStream paramDataInputStream)
  {
    AppMethodBeat.i(17820);
    try
    {
      for (;;)
      {
        int j;
        if ((!this.jGZ.booleanValue()) && (this.jHe != 4))
        {
          j = paramDataInputStream.readByte();
          if (jzh[this.jHe] == j)
          {
            this.jHe += 1;
            continue;
          }
        }
        try
        {
          paramDataInputStream.close();
          if (!this.jGZ.booleanValue()) {
            a(true, 0, 10006, "read_error ".concat(String.valueOf(localException)).getBytes());
          }
          aUZ();
          AppMethodBeat.o(17820);
          return;
          long l1 = bo.aox();
          long l2 = this.jHg;
          if (this.jHf - (l1 - l2) < 10L)
          {
            if (this.jHf < 0) {
              this.jHf = 0;
            }
            this.jHf += 1;
            this.jHg = l1;
            i = 0;
            String str;
            if (i == 0)
            {
              str = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[] { Integer.valueOf(this.jHe + 1), Integer.valueOf(jzh[this.jHe] & 0xFF), Integer.valueOf(j & 0xFF) });
              ab.e("MicroMsg.BakOldJavaEngine", str);
              a(true, 0, 10007, str.getBytes());
            }
            this.jHe = 0;
            continue;
            this.jHe = 0;
            j = paramDataInputStream.readInt();
            short s1 = paramDataInputStream.readShort();
            s2 = paramDataInputStream.readShort();
            int k = paramDataInputStream.readInt();
            if (k > 16777216)
            {
              str = String.format("loopRead size to large:%d", new Object[] { Integer.valueOf(k) });
              ab.e("MicroMsg.BakOldJavaEngine", str);
              this.jGZ = Boolean.TRUE;
              a(true, 0, 10007, str.getBytes());
              AppMethodBeat.o(17820);
              return;
            }
            int m = paramDataInputStream.readInt();
            ab.i("MicroMsg.BakOldJavaEngine", "read buf size:".concat(String.valueOf(k)));
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
            localObject1 = jzh;
            if (s1 != 1)
            {
              localObject1 = String.format("unpack failed, getVersion:%d", new Object[] { Short.valueOf(s1) });
              ab.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -1;
              ab.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[] { Integer.valueOf(i) });
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
              AppMethodBeat.o(17820);
              return;
              if (com.tencent.mm.plugin.backup.g.b.aSO() != 1) {
                break label820;
              }
              i = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a((byte[])localObject1, j, s1, s2, k, (byte[])localObject2);
              if (m == i) {
                break label820;
              }
              localObject1 = new CRC32();
              ((CRC32)localObject1).update((byte[])localObject2);
              localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.ao((byte[])localObject2);
              localObject1 = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Short.valueOf(s2), Integer.valueOf(k), Integer.valueOf((int)((CRC32)localObject1).getValue()), localObject2 });
              ab.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -2;
              break;
              for (;;)
              {
                localPByteArray.value = ((byte[])localObject1);
                i = 0;
                break;
                localObject1 = l.c((byte[])localObject2, com.tencent.mm.plugin.backup.b.d.aSP());
              }
            }
            ab.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Short.valueOf(s2) });
            a(false, j, s2, localPByteArray.value);
            AppMethodBeat.o(17820);
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
      ab.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[] { localException });
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17816);
    this.jHc.post(new b.2(this, paramBoolean, paramInt1, paramInt2, paramArrayOfByte));
    AppMethodBeat.o(17816);
  }
  
  /* Error */
  private void aUZ()
  {
    // Byte code:
    //   0: sipush 17815
    //   3: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 83	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:jHe	I
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 85	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:jHf	I
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield 87	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:jHg	J
    //   21: aload_0
    //   22: getstatic 280	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   25: putfield 58	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:jGZ	Ljava/lang/Boolean;
    //   28: aload_0
    //   29: getfield 81	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:lock	Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 79	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:jHd	Ljava/io/DataOutputStream;
    //   39: ifnull +10 -> 49
    //   42: aload_0
    //   43: getfield 79	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:jHd	Ljava/io/DataOutputStream;
    //   46: invokevirtual 370	java/io/DataOutputStream:close	()V
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 62	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:iZd	Ljava/net/Socket;
    //   55: ifnull +10 -> 65
    //   58: aload_0
    //   59: getfield 62	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:iZd	Ljava/net/Socket;
    //   62: invokevirtual 371	java/net/Socket:close	()V
    //   65: sipush 17815
    //   68: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: astore_2
    //   73: aload_1
    //   74: monitorexit
    //   75: sipush 17815
    //   78: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: athrow
    //   83: astore_1
    //   84: goto -33 -> 51
    //   87: astore_1
    //   88: sipush 17815
    //   91: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void aVa()
  {
    AppMethodBeat.i(17819);
    if ((this.jHb == null) || (!this.jHb.getLooper().getThread().isAlive())) {
      com.tencent.mm.sdk.g.d.h(new b.5(this), "BackupJavaEngine_handler").start();
    }
    AppMethodBeat.o(17819);
  }
  
  public final void aUY()
  {
    AppMethodBeat.i(17814);
    ab.i("MicroMsg.BakOldJavaEngine", "close connect");
    aUZ();
    a(true, 0, 10003, null);
    AppMethodBeat.o(17814);
  }
  
  public final void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17818);
    if (this.jGZ.booleanValue())
    {
      ab.e("MicroMsg.BakOldJavaEngine", "engine has stop");
      AppMethodBeat.o(17818);
      return;
    }
    this.jHb.post(new b.4(this, paramArrayOfByte));
    AppMethodBeat.o(17818);
  }
  
  public final void e(int paramInt, List<vd> paramList)
  {
    AppMethodBeat.i(17813);
    ab.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[] { Integer.valueOf(paramInt) });
    aVa();
    com.tencent.mm.sdk.g.d.post(new b.1(this, paramInt, paramList), "BackupJavaEngine_connect");
    AppMethodBeat.o(17813);
  }
  
  public final void j(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17817);
    if (this.jHb != null)
    {
      ap(paramArrayOfByte);
      AppMethodBeat.o(17817);
      return;
    }
    this.jHc.postDelayed(new b.3(this, paramInt, paramArrayOfByte), 200L);
    AppMethodBeat.o(17817);
  }
  
  public final int k(int paramInt, byte[] paramArrayOfByte)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b
 * JD-Core Version:    0.7.0.1
 */