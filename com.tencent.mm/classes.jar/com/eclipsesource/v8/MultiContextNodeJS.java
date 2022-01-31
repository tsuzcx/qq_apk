package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintWriter;

public final class MultiContextNodeJS
{
  private static final String GLOBAL = "global";
  private static final String STARTUP_CALLBACK = "__run";
  private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
  private static final String STARTUP_SCRIPT_NAME = "startup";
  private static final String TMP_JS_EXT = ".js.tmp";
  private static MultiContextNodeJS.IGetTmpFileDirectory sTmpFileDirectoryDelegate;
  private final V8Context mainContext;
  private final MultiContextV8 mv8;
  private V8Function require;
  
  static
  {
    AppMethodBeat.i(74975);
    sTmpFileDirectoryDelegate = new MultiContextNodeJS.2();
    AppMethodBeat.o(74975);
  }
  
  private MultiContextNodeJS(MultiContextV8 paramMultiContextV8, V8Context paramV8Context)
  {
    this.mv8 = paramMultiContextV8;
    this.mainContext = paramV8Context;
  }
  
  public static MultiContextNodeJS createMultiContextNodeJS(int paramInt)
  {
    AppMethodBeat.i(74964);
    MultiContextNodeJS localMultiContextNodeJS = createMultiContextNodeJS(paramInt, null, null);
    AppMethodBeat.o(74964);
    return localMultiContextNodeJS;
  }
  
  /* Error */
  public static MultiContextNodeJS createMultiContextNodeJS(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 10
    //   7: aload_1
    //   8: aload_2
    //   9: invokestatic 78	com/eclipsesource/v8/MultiContextV8:createMultiContextV8	(Ljava/lang/String;Ljava/lang/String;[B)Lcom/eclipsesource/v8/MultiContextV8;
    //   12: astore_1
    //   13: aload_1
    //   14: iload_0
    //   15: invokevirtual 82	com/eclipsesource/v8/MultiContextV8:createContext	(I)Lcom/eclipsesource/v8/V8Context;
    //   18: astore_3
    //   19: new 2	com/eclipsesource/v8/MultiContextNodeJS
    //   22: dup
    //   23: aload_1
    //   24: aload_3
    //   25: invokespecial 84	com/eclipsesource/v8/MultiContextNodeJS:<init>	(Lcom/eclipsesource/v8/MultiContextV8;Lcom/eclipsesource/v8/V8Context;)V
    //   28: astore_2
    //   29: aload_3
    //   30: new 86	com/eclipsesource/v8/MultiContextNodeJS$1
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 89	com/eclipsesource/v8/MultiContextNodeJS$1:<init>	(Lcom/eclipsesource/v8/MultiContextNodeJS;)V
    //   38: ldc 13
    //   40: invokeinterface 95 3 0
    //   45: pop
    //   46: ldc 16
    //   48: ldc 19
    //   50: invokestatic 99	com/eclipsesource/v8/MultiContextNodeJS:createTemporaryScriptFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   53: astore_3
    //   54: aload_1
    //   55: invokevirtual 103	com/eclipsesource/v8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/v8/V8Locker;
    //   58: invokevirtual 109	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   61: ifne +10 -> 71
    //   64: aload_1
    //   65: invokevirtual 103	com/eclipsesource/v8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/v8/V8Locker;
    //   68: invokevirtual 112	com/eclipsesource/v8/V8Locker:acquire	()V
    //   71: aload_1
    //   72: invokevirtual 116	com/eclipsesource/v8/MultiContextV8:getV8	()Lcom/eclipsesource/v8/V8;
    //   75: aload_3
    //   76: invokevirtual 122	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: invokevirtual 128	com/eclipsesource/v8/V8:createNodeRuntime	(Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 103	com/eclipsesource/v8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/v8/V8Locker;
    //   86: invokevirtual 131	com/eclipsesource/v8/V8Locker:release	()V
    //   89: aload_3
    //   90: invokevirtual 134	java/io/File:delete	()Z
    //   93: pop
    //   94: ldc 72
    //   96: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_1
    //   102: aload_3
    //   103: invokevirtual 134	java/io/File:delete	()Z
    //   106: pop
    //   107: ldc 72
    //   109: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_1
    //   113: athrow
    //   114: astore_1
    //   115: new 136	java/lang/RuntimeException
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 139	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   123: astore_1
    //   124: ldc 72
    //   126: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramInt	int
    //   0	131	1	paramString	String
    //   0	131	2	paramArrayOfByte	byte[]
    //   18	85	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	71	101	finally
    //   71	89	101	finally
    //   46	54	114	java/io/IOException
    //   89	94	114	java/io/IOException
    //   102	114	114	java/io/IOException
  }
  
  private static File createTemporaryScriptFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(74973);
    File localFile = File.createTempFile(paramString2, ".js.tmp", sTmpFileDirectoryDelegate.getDirectory());
    paramString2 = new PrintWriter(localFile, "UTF-8");
    try
    {
      paramString2.print(paramString1);
      return localFile;
    }
    finally
    {
      paramString2.close();
      AppMethodBeat.o(74973);
    }
  }
  
  private void init(V8Function paramV8Function)
  {
    this.require = paramV8Function;
  }
  
  public static void setGetTmpFileDirectoryDelegate(MultiContextNodeJS.IGetTmpFileDirectory paramIGetTmpFileDirectory)
  {
    if (paramIGetTmpFileDirectory == null) {
      return;
    }
    sTmpFileDirectoryDelegate = paramIGetTmpFileDirectory;
  }
  
  public final void closeUVLoop()
  {
    AppMethodBeat.i(74967);
    this.mv8.getV8().closeUVLoop();
    AppMethodBeat.o(74967);
  }
  
  public final void debuggerMessageLoop()
  {
    AppMethodBeat.i(74972);
    this.mv8.debuggerMessageLoop();
    AppMethodBeat.o(74972);
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
    AppMethodBeat.i(74968);
    this.mv8.getV8().checkThread();
    boolean bool = this.mv8.getV8().pumpMessageLoop();
    AppMethodBeat.o(74968);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(74969);
    this.mv8.getV8().checkThread();
    boolean bool = this.mv8.getV8().isRunning();
    AppMethodBeat.o(74969);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(74970);
    this.mv8.getV8().checkThread();
    if (!this.require.isReleased()) {
      this.require.release();
    }
    if (!this.mainContext.isReleased()) {
      this.mainContext.release();
    }
    this.mv8.release();
    AppMethodBeat.o(74970);
  }
  
  public final void waitForDebugger(String paramString)
  {
    AppMethodBeat.i(74971);
    this.mv8.waitForDebugger(paramString);
    AppMethodBeat.o(74971);
  }
  
  public final void wakeUpUVLoop()
  {
    AppMethodBeat.i(74966);
    this.mv8.getV8().wakeUpUVLoop();
    AppMethodBeat.o(74966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.MultiContextNodeJS
 * JD-Core Version:    0.7.0.1
 */