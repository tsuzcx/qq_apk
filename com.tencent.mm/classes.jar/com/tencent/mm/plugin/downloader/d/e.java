package com.tencent.mm.plugin.downloader.d;

public final class e
{
  /* Error */
  public static android.util.Pair<java.nio.ByteBuffer, java.lang.Long> H(com.tencent.mm.vfs.e parame)
  {
    // Byte code:
    //   0: ldc 7
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 19	com/tencent/mm/vfs/e:exists	()Z
    //   9: ifeq +10 -> 19
    //   12: aload_0
    //   13: invokevirtual 22	com/tencent/mm/vfs/e:isFile	()Z
    //   16: ifne +10 -> 26
    //   19: ldc 7
    //   21: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 29	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   30: invokestatic 35	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   33: iconst_0
    //   34: invokestatic 41	com/tencent/mm/vfs/i:dd	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   37: astore_0
    //   38: aload_0
    //   39: invokestatic 47	com/tencent/mm/plugin/downloader/d/a:g	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   42: astore_1
    //   43: aload_0
    //   44: aload_1
    //   45: getfield 53	android/util/Pair:second	Ljava/lang/Object;
    //   48: checkcast 55	java/lang/Long
    //   51: invokevirtual 59	java/lang/Long:longValue	()J
    //   54: invokestatic 65	com/tencent/mm/plugin/downloader/d/h:c	(Ljava/io/RandomAccessFile;J)Z
    //   57: ifeq +36 -> 93
    //   60: new 67	com/tencent/mm/plugin/downloader/d/a$b
    //   63: dup
    //   64: ldc 69
    //   66: invokespecial 73	com/tencent/mm/plugin/downloader/d/a$b:<init>	(Ljava/lang/String;)V
    //   69: astore_1
    //   70: ldc 7
    //   72: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   86: ldc 7
    //   88: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_1
    //   92: athrow
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   101: ldc 7
    //   103: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -33 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	parame	com.tencent.mm.vfs.e
    //   42	34	1	localObject1	Object
    //   77	30	1	localPair	android.util.Pair<java.nio.ByteBuffer, java.lang.Long>
    //   108	1	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	77	77	finally
    //   26	38	108	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.e
 * JD-Core Version:    0.7.0.1
 */