package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.processor.ResponseProcessor;

public class ll
  implements ResponseProcessor
{
  /* Error */
  public void onResponse(com.tencent.map.tools.net.NetResponse paramNetResponse)
  {
    // Byte code:
    //   0: ldc 16
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 28	com/tencent/map/tools/net/NetResponse:available	()Z
    //   9: ifeq +14 -> 23
    //   12: aload_1
    //   13: aload_1
    //   14: getfield 32	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   17: invokestatic 38	com/tencent/map/tools/net/NetUtil:toBytesThrow	(Ljava/io/InputStream;)[B
    //   20: putfield 42	com/tencent/map/tools/net/NetResponse:data	[B
    //   23: aload_1
    //   24: getfield 32	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   27: invokestatic 48	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   30: aload_1
    //   31: aconst_null
    //   32: putfield 32	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   35: ldc 16
    //   37: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: astore_2
    //   42: aload_1
    //   43: getfield 32	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   46: invokestatic 48	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: aconst_null
    //   51: putfield 32	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   54: ldc 16
    //   56: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore_2
    //   61: aload_1
    //   62: getfield 32	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   65: invokestatic 48	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   68: aload_1
    //   69: aconst_null
    //   70: putfield 32	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   73: ldc 16
    //   75: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ll
    //   0	80	1	paramNetResponse	com.tencent.map.tools.net.NetResponse
    //   41	1	2	localIOException	java.io.IOException
    //   60	19	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	23	41	java/io/IOException
    //   5	23	60	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ll
 * JD-Core Version:    0.7.0.1
 */