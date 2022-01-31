package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

public final class c$c
  implements Runnable
{
  private b hXc = null;
  private a hXd = null;
  private volatile boolean hXh = false;
  private volatile Runnable hXi = null;
  private OutputStream hXj = null;
  private final LinkedList<byte[]> hXk = new LinkedList();
  private final LinkedList<byte[]> hXl = new LinkedList();
  
  public c$c(b paramb, a parama, BluetoothSocket paramBluetoothSocket)
  {
    this.hXc = paramb;
    this.hXd = parama;
    try
    {
      paramb = paramBluetoothSocket.getOutputStream();
      this.hXi = this;
      this.hXj = paramb;
      return;
    }
    catch (IOException paramb)
    {
      do
      {
        y.e("MicroMsg.exdevice.SendThread", "temp sockets not created", new Object[] { paramb });
        this.hXj = null;
      } while (this.hXd == null);
      this.hXd.hWS.c(this.hXc.mSessionId, 11, "Can not get write stream");
    }
  }
  
  public final boolean ab(byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (this.hXi == null)
    {
      y.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
      return false;
    }
    try
    {
      this.hXk.add(paramArrayOfByte);
      notify();
      return true;
    }
    finally {}
  }
  
  public final void cancel()
  {
    this.hXi = null;
    this.hXh = true;
    try
    {
      notify();
      this.hXl.clear();
      this.hXk.clear();
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 55
    //   2: ldc 117
    //   4: invokestatic 119	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 34	com/tencent/mm/plugin/f/a/c/c$c:hXj	Ljava/io/OutputStream;
    //   11: ifnonnull +30 -> 41
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 45	com/tencent/mm/plugin/f/a/c/c$c:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   20: ifnull +21 -> 41
    //   23: aload_0
    //   24: getfield 45	com/tencent/mm/plugin/f/a/c/c$c:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   27: getfield 69	com/tencent/mm/plugin/f/a/c/a:hWS	Lcom/tencent/mm/plugin/f/a/c/a$a;
    //   30: aload_0
    //   31: getfield 43	com/tencent/mm/plugin/f/a/c/c$c:hXc	Lcom/tencent/mm/plugin/f/a/c/b;
    //   34: getfield 75	com/tencent/mm/plugin/f/a/c/b:mSessionId	J
    //   37: iconst_0
    //   38: invokevirtual 123	com/tencent/mm/plugin/f/a/c/a$a:j	(JZ)V
    //   41: aload_0
    //   42: getfield 47	com/tencent/mm/plugin/f/a/c/c$c:hXh	Z
    //   45: ifne -31 -> 14
    //   48: aload_0
    //   49: getfield 32	com/tencent/mm/plugin/f/a/c/c$c:hXi	Ljava/lang/Runnable;
    //   52: ifnonnull +11 -> 63
    //   55: ldc 55
    //   57: ldc 125
    //   59: invokestatic 128	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: return
    //   63: aload_0
    //   64: getfield 41	com/tencent/mm/plugin/f/a/c/c$c:hXl	Ljava/util/LinkedList;
    //   67: invokevirtual 132	java/util/LinkedList:isEmpty	()Z
    //   70: ifne +50 -> 120
    //   73: aload_0
    //   74: getfield 41	com/tencent/mm/plugin/f/a/c/c$c:hXl	Ljava/util/LinkedList;
    //   77: invokevirtual 136	java/util/LinkedList:pop	()Ljava/lang/Object;
    //   80: checkcast 138	[B
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 34	com/tencent/mm/plugin/f/a/c/c$c:hXj	Ljava/io/OutputStream;
    //   88: aload_1
    //   89: invokevirtual 144	java/io/OutputStream:write	([B)V
    //   92: aload_0
    //   93: getfield 45	com/tencent/mm/plugin/f/a/c/c$c:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   96: ifnull -55 -> 41
    //   99: aload_0
    //   100: getfield 45	com/tencent/mm/plugin/f/a/c/c$c:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   103: getfield 69	com/tencent/mm/plugin/f/a/c/a:hWS	Lcom/tencent/mm/plugin/f/a/c/a$a;
    //   106: aload_0
    //   107: getfield 43	com/tencent/mm/plugin/f/a/c/c$c:hXc	Lcom/tencent/mm/plugin/f/a/c/b;
    //   110: getfield 75	com/tencent/mm/plugin/f/a/c/b:mSessionId	J
    //   113: iconst_1
    //   114: invokevirtual 123	com/tencent/mm/plugin/f/a/c/a$a:j	(JZ)V
    //   117: goto -76 -> 41
    //   120: aload_0
    //   121: getfield 39	com/tencent/mm/plugin/f/a/c/c$c:hXk	Ljava/util/LinkedList;
    //   124: invokevirtual 132	java/util/LinkedList:isEmpty	()Z
    //   127: ifne +41 -> 168
    //   130: aload_0
    //   131: getfield 39	com/tencent/mm/plugin/f/a/c/c$c:hXk	Ljava/util/LinkedList;
    //   134: astore_1
    //   135: aload_1
    //   136: monitorenter
    //   137: aload_0
    //   138: getfield 41	com/tencent/mm/plugin/f/a/c/c$c:hXl	Ljava/util/LinkedList;
    //   141: aload_0
    //   142: getfield 39	com/tencent/mm/plugin/f/a/c/c$c:hXk	Ljava/util/LinkedList;
    //   145: invokevirtual 148	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   148: invokestatic 154	junit/framework/Assert:assertTrue	(Z)V
    //   151: aload_0
    //   152: getfield 39	com/tencent/mm/plugin/f/a/c/c$c:hXk	Ljava/util/LinkedList;
    //   155: invokevirtual 112	java/util/LinkedList:clear	()V
    //   158: aload_1
    //   159: monitorexit
    //   160: goto -119 -> 41
    //   163: astore_2
    //   164: aload_1
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    //   168: aload_0
    //   169: monitorenter
    //   170: aload_0
    //   171: invokevirtual 157	java/lang/Object:wait	()V
    //   174: aload_0
    //   175: monitorexit
    //   176: goto -135 -> 41
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: ldc 55
    //   187: aload_1
    //   188: ldc 159
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 163	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 55
    //   199: ldc 165
    //   201: invokestatic 128	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto -30 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	c
    //   15	1	1	localIOException	IOException
    //   83	82	1	localObject1	Object
    //   179	4	1	localObject2	Object
    //   184	4	1	localInterruptedException	java.lang.InterruptedException
    //   163	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   84	92	15	java/io/IOException
    //   137	160	163	finally
    //   164	166	163	finally
    //   170	174	179	finally
    //   174	176	179	finally
    //   180	182	179	finally
    //   185	204	179	finally
    //   170	174	184	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.c.c
 * JD-Core Version:    0.7.0.1
 */