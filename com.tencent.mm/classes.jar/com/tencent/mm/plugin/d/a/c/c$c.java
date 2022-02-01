package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

public final class c$c
  implements h
{
  private b pjJ;
  private a pjK;
  private volatile boolean pjO;
  private volatile Runnable pjP;
  private OutputStream pjQ;
  private final LinkedList<byte[]> pjR;
  private final LinkedList<byte[]> pjS;
  
  public c$c(b paramb, a parama, BluetoothSocket paramBluetoothSocket)
  {
    AppMethodBeat.i(22603);
    this.pjP = null;
    this.pjQ = null;
    this.pjR = new LinkedList();
    this.pjS = new LinkedList();
    this.pjJ = null;
    this.pjK = null;
    this.pjO = false;
    this.pjJ = paramb;
    this.pjK = parama;
    try
    {
      paramb = paramBluetoothSocket.getOutputStream();
      this.pjP = this;
      this.pjQ = paramb;
      AppMethodBeat.o(22603);
      return;
    }
    catch (IOException paramb)
    {
      Log.e("MicroMsg.exdevice.SendThread", "temp sockets not created", new Object[] { paramb });
      this.pjQ = null;
      if (this.pjK != null) {
        this.pjK.pjA.c(this.pjJ.mSessionId, 11, "Can not get write stream");
      }
      AppMethodBeat.o(22603);
    }
  }
  
  public final boolean aZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22605);
    Log.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    if (this.pjP == null)
    {
      Log.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
      AppMethodBeat.o(22605);
      return false;
    }
    try
    {
      this.pjR.add(paramArrayOfByte);
      notify();
      return true;
    }
    finally
    {
      AppMethodBeat.o(22605);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(22606);
    this.pjP = null;
    this.pjO = true;
    try
    {
      notify();
      this.pjS.clear();
      this.pjR.clear();
      AppMethodBeat.o(22606);
      return;
    }
    finally
    {
      AppMethodBeat.o(22606);
    }
  }
  
  public final String getKey()
  {
    return "BluetoothChatSession_send";
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 22604
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 64
    //   8: ldc 129
    //   10: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 40	com/tencent/mm/plugin/d/a/c/c$c:pjQ	Ljava/io/OutputStream;
    //   17: ifnonnull +36 -> 53
    //   20: sipush 22604
    //   23: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 51	com/tencent/mm/plugin/d/a/c/c$c:pjK	Lcom/tencent/mm/plugin/d/a/c/a;
    //   32: ifnull +21 -> 53
    //   35: aload_0
    //   36: getfield 51	com/tencent/mm/plugin/d/a/c/c$c:pjK	Lcom/tencent/mm/plugin/d/a/c/a;
    //   39: getfield 78	com/tencent/mm/plugin/d/a/c/a:pjA	Lcom/tencent/mm/plugin/d/a/c/a$a;
    //   42: aload_0
    //   43: getfield 49	com/tencent/mm/plugin/d/a/c/c$c:pjJ	Lcom/tencent/mm/plugin/d/a/c/b;
    //   46: getfield 84	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
    //   49: iconst_0
    //   50: invokevirtual 135	com/tencent/mm/plugin/d/a/c/a$a:m	(JZ)V
    //   53: aload_0
    //   54: getfield 53	com/tencent/mm/plugin/d/a/c/c$c:pjO	Z
    //   57: ifne +180 -> 237
    //   60: aload_0
    //   61: getfield 38	com/tencent/mm/plugin/d/a/c/c$c:pjP	Ljava/lang/Runnable;
    //   64: ifnonnull +17 -> 81
    //   67: ldc 64
    //   69: ldc 137
    //   71: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: sipush 22604
    //   77: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: aload_0
    //   82: getfield 47	com/tencent/mm/plugin/d/a/c/c$c:pjS	Ljava/util/LinkedList;
    //   85: invokevirtual 144	java/util/LinkedList:isEmpty	()Z
    //   88: ifne +50 -> 138
    //   91: aload_0
    //   92: getfield 47	com/tencent/mm/plugin/d/a/c/c$c:pjS	Ljava/util/LinkedList;
    //   95: invokevirtual 148	java/util/LinkedList:pop	()Ljava/lang/Object;
    //   98: checkcast 150	[B
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 40	com/tencent/mm/plugin/d/a/c/c$c:pjQ	Ljava/io/OutputStream;
    //   106: aload_1
    //   107: invokevirtual 156	java/io/OutputStream:write	([B)V
    //   110: aload_0
    //   111: getfield 51	com/tencent/mm/plugin/d/a/c/c$c:pjK	Lcom/tencent/mm/plugin/d/a/c/a;
    //   114: ifnull -61 -> 53
    //   117: aload_0
    //   118: getfield 51	com/tencent/mm/plugin/d/a/c/c$c:pjK	Lcom/tencent/mm/plugin/d/a/c/a;
    //   121: getfield 78	com/tencent/mm/plugin/d/a/c/a:pjA	Lcom/tencent/mm/plugin/d/a/c/a$a;
    //   124: aload_0
    //   125: getfield 49	com/tencent/mm/plugin/d/a/c/c$c:pjJ	Lcom/tencent/mm/plugin/d/a/c/b;
    //   128: getfield 84	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
    //   131: iconst_1
    //   132: invokevirtual 135	com/tencent/mm/plugin/d/a/c/a$a:m	(JZ)V
    //   135: goto -82 -> 53
    //   138: aload_0
    //   139: getfield 45	com/tencent/mm/plugin/d/a/c/c$c:pjR	Ljava/util/LinkedList;
    //   142: invokevirtual 144	java/util/LinkedList:isEmpty	()Z
    //   145: ifne +47 -> 192
    //   148: aload_0
    //   149: getfield 45	com/tencent/mm/plugin/d/a/c/c$c:pjR	Ljava/util/LinkedList;
    //   152: astore_1
    //   153: aload_1
    //   154: monitorenter
    //   155: aload_0
    //   156: getfield 47	com/tencent/mm/plugin/d/a/c/c$c:pjS	Ljava/util/LinkedList;
    //   159: aload_0
    //   160: getfield 45	com/tencent/mm/plugin/d/a/c/c$c:pjR	Ljava/util/LinkedList;
    //   163: invokevirtual 160	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   166: invokestatic 166	junit/framework/Assert:assertTrue	(Z)V
    //   169: aload_0
    //   170: getfield 45	com/tencent/mm/plugin/d/a/c/c$c:pjR	Ljava/util/LinkedList;
    //   173: invokevirtual 120	java/util/LinkedList:clear	()V
    //   176: aload_1
    //   177: monitorexit
    //   178: goto -125 -> 53
    //   181: astore_2
    //   182: aload_1
    //   183: monitorexit
    //   184: sipush 22604
    //   187: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_2
    //   191: athrow
    //   192: aload_0
    //   193: monitorenter
    //   194: aload_0
    //   195: invokevirtual 169	java/lang/Object:wait	()V
    //   198: aload_0
    //   199: monitorexit
    //   200: goto -147 -> 53
    //   203: astore_1
    //   204: aload_0
    //   205: monitorexit
    //   206: sipush 22604
    //   209: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: ldc 64
    //   217: aload_1
    //   218: ldc 171
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: ldc 64
    //   229: ldc 177
    //   231: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: goto -36 -> 198
    //   237: sipush 22604
    //   240: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	c
    //   27	1	1	localIOException	IOException
    //   101	82	1	localObject1	Object
    //   203	10	1	localObject2	Object
    //   214	4	1	localInterruptedException	java.lang.InterruptedException
    //   181	10	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   102	110	27	java/io/IOException
    //   155	178	181	finally
    //   182	184	181	finally
    //   194	198	203	finally
    //   198	200	203	finally
    //   204	206	203	finally
    //   215	234	203	finally
    //   194	198	214	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.c.c
 * JD-Core Version:    0.7.0.1
 */