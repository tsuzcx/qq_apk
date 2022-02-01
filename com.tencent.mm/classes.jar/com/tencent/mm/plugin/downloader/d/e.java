package com.tencent.mm.plugin.downloader.d;

public final class e
{
  /* Error */
  public static android.util.Pair<java.nio.ByteBuffer, java.lang.Long> K(com.tencent.mm.vfs.q paramq)
  {
    // Byte code:
    //   0: ldc 7
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 19	com/tencent/mm/vfs/q:ifE	()Z
    //   9: ifeq +10 -> 19
    //   12: aload_0
    //   13: invokevirtual 22	com/tencent/mm/vfs/q:ifH	()Z
    //   16: ifne +10 -> 26
    //   19: ldc 7
    //   21: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 29	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   30: iconst_0
    //   31: invokestatic 35	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   34: astore_0
    //   35: aload_0
    //   36: invokestatic 41	com/tencent/mm/plugin/downloader/d/a:g	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   39: astore_1
    //   40: aload_0
    //   41: aload_1
    //   42: getfield 47	android/util/Pair:second	Ljava/lang/Object;
    //   45: checkcast 49	java/lang/Long
    //   48: invokevirtual 53	java/lang/Long:longValue	()J
    //   51: invokestatic 59	com/tencent/mm/plugin/downloader/d/h:c	(Ljava/io/RandomAccessFile;J)Z
    //   54: ifeq +36 -> 90
    //   57: new 61	com/tencent/mm/plugin/downloader/d/a$b
    //   60: dup
    //   61: ldc 63
    //   63: invokespecial 67	com/tencent/mm/plugin/downloader/d/a$b:<init>	(Ljava/lang/String;)V
    //   66: astore_1
    //   67: ldc 7
    //   69: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: ifnull +7 -> 83
    //   79: aload_0
    //   80: invokevirtual 73	java/io/RandomAccessFile:close	()V
    //   83: ldc 7
    //   85: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: athrow
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 73	java/io/RandomAccessFile:close	()V
    //   98: ldc 7
    //   100: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: areturn
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -33 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramq	com.tencent.mm.vfs.q
    //   39	34	1	localObject1	Object
    //   74	30	1	localPair	android.util.Pair<java.nio.ByteBuffer, java.lang.Long>
    //   105	1	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	74	74	finally
    //   26	35	105	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.e
 * JD-Core Version:    0.7.0.1
 */