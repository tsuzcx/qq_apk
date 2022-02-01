package c.t.m.g;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;

public final class ch
{
  private static final FilenameFilter a = new FilenameFilter()
  {
    public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return paramAnonymousString.endsWith(".stacktrace");
    }
  };
  private static boolean b;
  
  public static CountDownLatch a(bf parambf, final String paramString1, final String paramString2, final String paramString3)
  {
    try
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      new Thread()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: invokestatic 40	c/t/m/g/ch:a	()Z
          //   3: ifne +134 -> 137
          //   6: iconst_1
          //   7: invokestatic 43	c/t/m/g/ch:a	(Z)Z
          //   10: pop
          //   11: ldc 45
          //   13: ldc 47
          //   15: invokestatic 52	c/t/m/g/cj:a	(Ljava/lang/String;Ljava/lang/String;)V
          //   18: aload_0
          //   19: getfield 20	c/t/m/g/ch$2:a	Lc/t/m/g/bf;
          //   22: aload_0
          //   23: getfield 22	c/t/m/g/ch$2:b	Ljava/lang/String;
          //   26: new 54	java/io/File
          //   29: dup
          //   30: aload_0
          //   31: getfield 24	c/t/m/g/ch$2:c	Ljava/lang/String;
          //   34: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
          //   37: invokevirtual 61	java/io/File:getParentFile	()Ljava/io/File;
          //   40: invokestatic 64	c/t/m/g/ch:a	(Lc/t/m/g/bf;Ljava/lang/String;Ljava/io/File;)V
          //   43: aload_0
          //   44: getfield 20	c/t/m/g/ch$2:a	Lc/t/m/g/bf;
          //   47: aload_0
          //   48: getfield 22	c/t/m/g/ch$2:b	Ljava/lang/String;
          //   51: aload_0
          //   52: getfield 26	c/t/m/g/ch$2:d	Ljava/lang/String;
          //   55: invokevirtual 70	java/lang/String:getBytes	()[B
          //   58: invokevirtual 75	c/t/m/g/bf:a	(Ljava/lang/String;[B)Ljava/lang/String;
          //   61: pop
          //   62: iconst_0
          //   63: invokestatic 43	c/t/m/g/ch:a	(Z)Z
          //   66: pop
          //   67: aload_0
          //   68: getfield 28	c/t/m/g/ch$2:e	Ljava/util/concurrent/CountDownLatch;
          //   71: invokevirtual 80	java/util/concurrent/CountDownLatch:countDown	()V
          //   74: return
          //   75: astore_1
          //   76: ldc 45
          //   78: ldc 82
          //   80: aload_1
          //   81: invokestatic 85	c/t/m/g/cj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
          //   84: new 87	java/io/BufferedWriter
          //   87: dup
          //   88: new 89	java/io/FileWriter
          //   91: dup
          //   92: aload_0
          //   93: getfield 24	c/t/m/g/ch$2:c	Ljava/lang/String;
          //   96: invokespecial 90	java/io/FileWriter:<init>	(Ljava/lang/String;)V
          //   99: invokespecial 93	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
          //   102: astore_1
          //   103: aload_1
          //   104: aload_0
          //   105: getfield 26	c/t/m/g/ch$2:d	Ljava/lang/String;
          //   108: invokevirtual 96	java/io/BufferedWriter:write	(Ljava/lang/String;)V
          //   111: aload_1
          //   112: invokevirtual 99	java/io/BufferedWriter:flush	()V
          //   115: aload_1
          //   116: invokevirtual 102	java/io/BufferedWriter:close	()V
          //   119: goto -57 -> 62
          //   122: astore_1
          //   123: aload_1
          //   124: invokevirtual 105	java/io/IOException:printStackTrace	()V
          //   127: goto -65 -> 62
          //   130: astore_2
          //   131: aload_1
          //   132: invokevirtual 102	java/io/BufferedWriter:close	()V
          //   135: aload_2
          //   136: athrow
          //   137: ldc 45
          //   139: ldc 107
          //   141: invokestatic 52	c/t/m/g/cj:a	(Ljava/lang/String;Ljava/lang/String;)V
          //   144: goto -77 -> 67
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	147	0	this	2
          //   75	6	1	localException	java.lang.Exception
          //   102	14	1	localBufferedWriter	java.io.BufferedWriter
          //   122	10	1	localIOException	java.io.IOException
          //   130	6	2	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   43	62	75	java/lang/Exception
          //   84	103	122	java/io/IOException
          //   115	119	122	java/io/IOException
          //   131	137	122	java/io/IOException
          //   103	115	130	finally
        }
      }.start();
      return localCountDownLatch;
    }
    finally
    {
      parambf = finally;
      throw parambf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.ch
 * JD-Core Version:    0.7.0.1
 */