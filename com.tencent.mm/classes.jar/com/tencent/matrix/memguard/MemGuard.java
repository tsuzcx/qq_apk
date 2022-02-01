package com.tencent.matrix.memguard;

import com.tencent.matrix.e.c;

public final class MemGuard
{
  private static final boolean[] eWF = { false };
  private static a eWG = new a()
  {
    /* Error */
    public final void gM(String paramAnonymousString)
    {
      // Byte code:
      //   0: new 17	java/io/File
      //   3: dup
      //   4: aload_1
      //   5: invokespecial 19	java/io/File:<init>	(Ljava/lang/String;)V
      //   8: astore_2
      //   9: aload_2
      //   10: invokevirtual 23	java/io/File:exists	()Z
      //   13: ifne +19 -> 32
      //   16: ldc 25
      //   18: ldc 27
      //   20: iconst_1
      //   21: anewarray 4	java/lang/Object
      //   24: dup
      //   25: iconst_0
      //   26: aload_1
      //   27: aastore
      //   28: invokestatic 33	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   31: return
      //   32: new 35	java/io/BufferedReader
      //   35: dup
      //   36: new 37	java/io/FileReader
      //   39: dup
      //   40: aload_2
      //   41: invokespecial 40	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   44: invokespecial 43	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   47: astore_2
      //   48: aload_2
      //   49: invokevirtual 47	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   52: astore_1
      //   53: aload_1
      //   54: ifnull +32 -> 86
      //   57: ldc 25
      //   59: ldc 49
      //   61: iconst_1
      //   62: anewarray 4	java/lang/Object
      //   65: dup
      //   66: iconst_0
      //   67: aload_1
      //   68: aastore
      //   69: invokestatic 52	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   72: goto -24 -> 48
      //   75: astore_1
      //   76: aload_2
      //   77: ifnull +7 -> 84
      //   80: aload_2
      //   81: invokevirtual 55	java/io/BufferedReader:close	()V
      //   84: aload_1
      //   85: athrow
      //   86: aload_2
      //   87: invokevirtual 55	java/io/BufferedReader:close	()V
      //   90: return
      //   91: astore_1
      //   92: return
      //   93: astore_2
      //   94: goto -10 -> 84
      //   97: astore_1
      //   98: aconst_null
      //   99: astore_2
      //   100: goto -24 -> 76
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	1
      //   0	103	1	paramAnonymousString	String
      //   8	79	2	localObject1	Object
      //   93	1	2	localObject2	Object
      //   99	1	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   48	53	75	finally
      //   57	72	75	finally
      //   86	90	91	finally
      //   80	84	93	finally
      //   32	48	97	finally
    }
  };
  
  private static void c2jNotifyOnIssueDumped(String paramString)
  {
    paramString = new Thread(new Runnable()
    {
      public final void run()
      {
        try
        {
          MemGuard.ayH().gM(this.eWH);
          return;
        }
        finally
        {
          c.printErrStackTrace("MemGuard", localThrowable, "Exception was thrown when onIssueDumpped was called.", new Object[0]);
        }
      }
    }, "MemGuard.IssueCB");
    long l = System.currentTimeMillis();
    paramString.start();
    try
    {
      paramString.join(5000L);
      if (System.currentTimeMillis() - l > 5000L) {
        c.w("MemGuard", "Timeout when call issue callback.", new Object[0]);
      }
      return;
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        c.w("MemGuard", "Issue callback was interrupted.", new Object[0]);
      }
    }
  }
  
  public static boolean isInstalled()
  {
    synchronized (eWF)
    {
      int i = eWF[0];
      return i;
    }
  }
  
  private static native String nativeGetIssueDumpFilePath();
  
  private static native boolean nativeInstall(MemGuard.Options paramOptions);
  
  public static abstract interface a
  {
    public abstract void gM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.memguard.MemGuard
 * JD-Core Version:    0.7.0.1
 */