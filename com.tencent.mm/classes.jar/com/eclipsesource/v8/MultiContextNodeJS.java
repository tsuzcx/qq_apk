package com.eclipsesource.v8;

import java.io.File;
import java.io.PrintWriter;

public final class MultiContextNodeJS
{
  private static final String GLOBAL = "global";
  private static final String STARTUP_CALLBACK = "__run";
  private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
  private static final String STARTUP_SCRIPT_NAME = "startup";
  private static final String TMP_JS_EXT = ".js.tmp";
  private final V8Context mainContext;
  private final MultiContextV8 mv8;
  private V8Function require;
  
  private MultiContextNodeJS(MultiContextV8 paramMultiContextV8, V8Context paramV8Context)
  {
    this.mv8 = paramMultiContextV8;
    this.mainContext = paramV8Context;
  }
  
  /* Error */
  public static MultiContextNodeJS createMultiContextNodeJS(int paramInt)
  {
    // Byte code:
    //   0: ldc 8
    //   2: invokestatic 52	com/eclipsesource/v8/MultiContextV8:createMultiContextV8	(Ljava/lang/String;)Lcom/eclipsesource/v8/MultiContextV8;
    //   5: astore_1
    //   6: aload_1
    //   7: iload_0
    //   8: invokevirtual 56	com/eclipsesource/v8/MultiContextV8:createContext	(I)Lcom/eclipsesource/v8/V8Context;
    //   11: astore_3
    //   12: new 2	com/eclipsesource/v8/MultiContextNodeJS
    //   15: dup
    //   16: aload_1
    //   17: aload_3
    //   18: invokespecial 58	com/eclipsesource/v8/MultiContextNodeJS:<init>	(Lcom/eclipsesource/v8/MultiContextV8;Lcom/eclipsesource/v8/V8Context;)V
    //   21: astore_2
    //   22: aload_3
    //   23: new 60	com/eclipsesource/v8/MultiContextNodeJS$1
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 63	com/eclipsesource/v8/MultiContextNodeJS$1:<init>	(Lcom/eclipsesource/v8/MultiContextNodeJS;)V
    //   31: ldc 11
    //   33: invokeinterface 69 3 0
    //   38: pop
    //   39: ldc 14
    //   41: ldc 17
    //   43: invokestatic 73	com/eclipsesource/v8/MultiContextNodeJS:createTemporaryScriptFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   46: astore_3
    //   47: aload_1
    //   48: invokevirtual 77	com/eclipsesource/v8/MultiContextV8:getV8	()Lcom/eclipsesource/v8/V8;
    //   51: aload_3
    //   52: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokevirtual 89	com/eclipsesource/v8/V8:createNodeRuntime	(Ljava/lang/String;)V
    //   58: aload_3
    //   59: invokevirtual 93	java/io/File:delete	()Z
    //   62: pop
    //   63: aload_2
    //   64: areturn
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 93	java/io/File:delete	()Z
    //   70: pop
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: new 95	java/lang/RuntimeException
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 98	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramInt	int
    //   5	43	1	localMultiContextV8	MultiContextV8
    //   65	7	1	localObject1	Object
    //   73	6	1	localIOException	java.io.IOException
    //   21	43	2	localMultiContextNodeJS	MultiContextNodeJS
    //   11	56	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	58	65	finally
    //   39	47	73	java/io/IOException
    //   58	63	73	java/io/IOException
    //   66	73	73	java/io/IOException
  }
  
  private static File createTemporaryScriptFile(String paramString1, String paramString2)
  {
    File localFile = File.createTempFile(paramString2, ".js.tmp");
    paramString2 = new PrintWriter(localFile, "UTF-8");
    try
    {
      paramString2.print(paramString1);
      return localFile;
    }
    finally
    {
      paramString2.close();
    }
  }
  
  private void init(V8Function paramV8Function)
  {
    this.require = paramV8Function;
  }
  
  public final V8Context getMainContext()
  {
    return this.mainContext;
  }
  
  public final MultiContextV8 getRuntime()
  {
    return this.mv8;
  }
  
  public final boolean handleMessage()
  {
    this.mv8.getV8().checkThread();
    return this.mv8.getV8().pumpMessageLoop();
  }
  
  public final boolean isRunning()
  {
    this.mv8.getV8().checkThread();
    return this.mv8.getV8().isRunning();
  }
  
  public final void release()
  {
    this.mv8.getV8().checkThread();
    if (!this.require.isReleased()) {
      this.require.release();
    }
    this.mainContext.release();
    this.mv8.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.MultiContextNodeJS
 * JD-Core Version:    0.7.0.1
 */