package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static final byte[] hFK = "GSMW".getBytes();
  private ah hNA = new ah(Looper.getMainLooper());
  private DataOutputStream hNB = null;
  private int hNC = 0;
  private int hND = 0;
  private long hNE = 0L;
  private Boolean hNx = Boolean.valueOf(false);
  private ServerSocket hNy = null;
  private ah hNz = null;
  private Socket hmE = null;
  private Object lock = new Object();
  
  public b()
  {
    avx();
  }
  
  private void a(DataInputStream paramDataInputStream)
  {
    try
    {
      for (;;)
      {
        int j;
        if ((!this.hNx.booleanValue()) && (this.hNC != 4))
        {
          j = paramDataInputStream.readByte();
          if (hFK[this.hNC] == j)
          {
            this.hNC += 1;
            continue;
          }
        }
        try
        {
          paramDataInputStream.close();
          if (!this.hNx.booleanValue()) {
            a(true, 0, 10006, ("read_error " + localException).getBytes());
          }
          avw();
          return;
          long l1 = bk.UX();
          long l2 = this.hNE;
          if (this.hND - (l1 - l2) < 10L)
          {
            if (this.hND < 0) {
              this.hND = 0;
            }
            this.hND += 1;
            this.hNE = l1;
            i = 0;
            String str;
            if (i == 0)
            {
              str = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[] { Integer.valueOf(this.hNC + 1), Integer.valueOf(hFK[this.hNC] & 0xFF), Integer.valueOf(j & 0xFF) });
              y.e("MicroMsg.BakOldJavaEngine", str);
              a(true, 0, 10007, str.getBytes());
            }
            this.hNC = 0;
            continue;
            this.hNC = 0;
            j = paramDataInputStream.readInt();
            short s1 = paramDataInputStream.readShort();
            s2 = paramDataInputStream.readShort();
            int k = paramDataInputStream.readInt();
            if (k > 16777216)
            {
              str = String.format("loopRead size to large:%d", new Object[] { Integer.valueOf(k) });
              y.e("MicroMsg.BakOldJavaEngine", str);
              this.hNx = Boolean.valueOf(true);
              a(true, 0, 10007, str.getBytes());
              return;
            }
            int m = paramDataInputStream.readInt();
            y.i("MicroMsg.BakOldJavaEngine", "read buf size:" + k);
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
            localObject1 = hFK;
            if (s1 != 1)
            {
              localObject1 = String.format("unpack failed, getVersion:%d", new Object[] { Short.valueOf(s1) });
              y.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -1;
              y.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label745;
              }
              if (localPByteArray.value != null) {
                break label728;
              }
            }
            for (localObject1 = "";; localObject1 = new String(localPByteArray.value))
            {
              a(true, 0, 10007, ((String)localObject1).getBytes());
              return;
              if (com.tencent.mm.plugin.backup.g.b.atq() != 1) {
                break label804;
              }
              i = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a((byte[])localObject1, j, s1, s2, k, (byte[])localObject2);
              if (m == i) {
                break label804;
              }
              localObject1 = new CRC32();
              ((CRC32)localObject1).update((byte[])localObject2);
              localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.U((byte[])localObject2);
              localObject1 = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Short.valueOf(s2), Integer.valueOf(k), Integer.valueOf((int)((CRC32)localObject1).getValue()), localObject2 });
              y.e("MicroMsg.BakOldPacker", (String)localObject1);
              localPByteArray.value = ((String)localObject1).getBytes();
              i = -2;
              break;
              for (;;)
              {
                localPByteArray.value = ((byte[])localObject1);
                i = 0;
                break;
                localObject1 = k.a((byte[])localObject2, d.atr());
              }
            }
            y.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Short.valueOf(s2) });
            a(false, j, s2, localPByteArray.value);
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
      y.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[] { localException });
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.hNA.post(new b.2(this, paramBoolean, paramInt1, paramInt2, paramArrayOfByte));
  }
  
  /* Error */
  private void avw()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 75	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hNC	I
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 77	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hND	I
    //   10: aload_0
    //   11: lconst_0
    //   12: putfield 79	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hNE	J
    //   15: aload_0
    //   16: iconst_1
    //   17: invokestatic 48	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   20: putfield 50	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hNx	Ljava/lang/Boolean;
    //   23: aload_0
    //   24: getfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:lock	Ljava/lang/Object;
    //   27: astore_1
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hNB	Ljava/io/DataOutputStream;
    //   34: ifnull +10 -> 44
    //   37: aload_0
    //   38: getfield 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hNB	Ljava/io/DataOutputStream;
    //   41: invokevirtual 355	java/io/DataOutputStream:close	()V
    //   44: aload_1
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 54	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hmE	Ljava/net/Socket;
    //   50: ifnull +10 -> 60
    //   53: aload_0
    //   54: getfield 54	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/b:hmE	Ljava/net/Socket;
    //   57: invokevirtual 356	java/net/Socket:close	()V
    //   60: return
    //   61: astore_2
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore_1
    //   67: goto -21 -> 46
    //   70: astore_1
    //   71: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	b
    //   66	1	1	localException1	Exception
    //   70	1	1	localException2	Exception
    //   61	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	44	61	finally
    //   44	46	61	finally
    //   62	64	61	finally
    //   23	30	66	java/lang/Exception
    //   64	66	66	java/lang/Exception
    //   46	60	70	java/lang/Exception
  }
  
  private void avx()
  {
    if ((this.hNz == null) || (!this.hNz.getLooper().getThread().isAlive())) {
      e.b(new b.5(this), "BackupJavaEngine_handler").start();
    }
  }
  
  public final void V(byte[] paramArrayOfByte)
  {
    if (this.hNx.booleanValue())
    {
      y.e("MicroMsg.BakOldJavaEngine", "engine has stop");
      return;
    }
    this.hNz.post(new b.4(this, paramArrayOfByte));
  }
  
  public final void avv()
  {
    y.i("MicroMsg.BakOldJavaEngine", "close connect");
    avw();
    a(true, 0, 10003, null);
  }
  
  public final void d(int paramInt, List<ri> paramList)
  {
    y.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[] { Integer.valueOf(paramInt) });
    avx();
    e.post(new b.1(this, paramInt, paramList), "BackupJavaEngine_connect");
  }
  
  public final void j(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.hNz != null)
    {
      V(paramArrayOfByte);
      return;
    }
    this.hNA.postDelayed(new b.3(this, paramInt, paramArrayOfByte), 200L);
  }
  
  public final int k(int paramInt, byte[] paramArrayOfByte)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b
 * JD-Core Version:    0.7.0.1
 */