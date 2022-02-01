package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
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
    AppMethodBeat.i(61598);
    sTmpFileDirectoryDelegate = new MultiContextNodeJS.2();
    AppMethodBeat.o(61598);
  }
  
  private MultiContextNodeJS(MultiContextV8 paramMultiContextV8, V8Context paramV8Context)
  {
    this.mv8 = paramMultiContextV8;
    this.mainContext = paramV8Context;
  }
  
  public static MultiContextNodeJS createMultiContextNodeJS(int paramInt)
  {
    AppMethodBeat.i(61587);
    MultiContextNodeJS localMultiContextNodeJS = createMultiContextNodeJS(paramInt, null, null, false);
    AppMethodBeat.o(61587);
    return localMultiContextNodeJS;
  }
  
  /* Error */
  public static MultiContextNodeJS createMultiContextNodeJS(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 12
    //   7: aload_1
    //   8: aload_2
    //   9: invokestatic 80	com/eclipsesource/v8/MultiContextV8:createMultiContextV8	(Ljava/lang/String;Ljava/lang/String;[B)Lcom/eclipsesource/v8/MultiContextV8;
    //   12: astore_1
    //   13: aload_1
    //   14: iload_0
    //   15: invokevirtual 84	com/eclipsesource/v8/MultiContextV8:createContext	(I)Lcom/eclipsesource/v8/V8Context;
    //   18: astore 4
    //   20: new 2	com/eclipsesource/v8/MultiContextNodeJS
    //   23: dup
    //   24: aload_1
    //   25: aload 4
    //   27: invokespecial 86	com/eclipsesource/v8/MultiContextNodeJS:<init>	(Lcom/eclipsesource/v8/MultiContextV8;Lcom/eclipsesource/v8/V8Context;)V
    //   30: astore_2
    //   31: iload_3
    //   32: ifeq +10 -> 42
    //   35: aload_1
    //   36: invokevirtual 90	com/eclipsesource/v8/MultiContextV8:getV8	()Lcom/eclipsesource/v8/V8;
    //   39: invokevirtual 95	com/eclipsesource/v8/V8:enableNativeTrans	()V
    //   42: aload 4
    //   44: new 6	com/eclipsesource/v8/MultiContextNodeJS$1
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 98	com/eclipsesource/v8/MultiContextNodeJS$1:<init>	(Lcom/eclipsesource/v8/MultiContextNodeJS;)V
    //   52: ldc 15
    //   54: invokeinterface 104 3 0
    //   59: pop
    //   60: ldc 18
    //   62: ldc 106
    //   64: iconst_3
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: ldc 21
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: invokestatic 112	android/os/Process:myPid	()I
    //   78: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: invokestatic 124	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 128	java/lang/Thread:getId	()J
    //   90: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   93: aastore
    //   94: invokestatic 139	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokestatic 143	com/eclipsesource/v8/MultiContextNodeJS:createTemporaryScriptFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   100: astore 4
    //   102: aload_1
    //   103: invokevirtual 147	com/eclipsesource/v8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/v8/V8Locker;
    //   106: invokevirtual 153	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   109: ifne +10 -> 119
    //   112: aload_1
    //   113: invokevirtual 147	com/eclipsesource/v8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/v8/V8Locker;
    //   116: invokevirtual 156	com/eclipsesource/v8/V8Locker:acquire	()V
    //   119: aload_1
    //   120: invokevirtual 90	com/eclipsesource/v8/MultiContextV8:getV8	()Lcom/eclipsesource/v8/V8;
    //   123: aload 4
    //   125: invokevirtual 162	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: invokevirtual 166	com/eclipsesource/v8/V8:createNodeRuntime	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: invokevirtual 147	com/eclipsesource/v8/MultiContextV8:getV8Locker	()Lcom/eclipsesource/v8/V8Locker;
    //   135: invokevirtual 169	com/eclipsesource/v8/V8Locker:release	()V
    //   138: aload 4
    //   140: invokevirtual 172	java/io/File:delete	()Z
    //   143: pop
    //   144: ldc 74
    //   146: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_2
    //   150: areturn
    //   151: astore_1
    //   152: aload 4
    //   154: invokevirtual 172	java/io/File:delete	()Z
    //   157: pop
    //   158: ldc 74
    //   160: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: new 174	java/lang/RuntimeException
    //   169: dup
    //   170: aload_1
    //   171: invokespecial 177	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   174: astore_1
    //   175: ldc 74
    //   177: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramInt	int
    //   0	182	1	paramString	String
    //   0	182	2	paramArrayOfByte	byte[]
    //   0	182	3	paramBoolean	boolean
    //   18	135	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   102	119	151	finally
    //   119	138	151	finally
    //   60	102	165	java/io/IOException
    //   138	144	165	java/io/IOException
    //   152	165	165	java/io/IOException
  }
  
  private static File createTemporaryScriptFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61596);
    try
    {
      localObject = File.createTempFile(paramString2, ".js.tmp", sTmpFileDirectoryDelegate.getDirectory());
      paramString2 = (String)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          ((PrintWriter)localObject).print(paramString1);
          return paramString2;
        }
        finally
        {
          localIOException.close();
          AppMethodBeat.o(61596);
        }
        localIOException = localIOException;
        paramString2 = File.createTempFile(paramString2, ".js.tmp", sTmpFileDirectoryDelegate.getDirectory());
      }
    }
    localObject = new PrintWriter(paramString2, "UTF-8");
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
    AppMethodBeat.i(61590);
    this.mv8.getV8().closeUVLoop();
    AppMethodBeat.o(61590);
  }
  
  public final void debuggerMessageLoop()
  {
    AppMethodBeat.i(61595);
    this.mv8.debuggerMessageLoop();
    AppMethodBeat.o(61595);
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
    AppMethodBeat.i(61591);
    this.mv8.getV8().checkThread();
    boolean bool = this.mv8.getV8().pumpMessageLoop();
    AppMethodBeat.o(61591);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(61592);
    this.mv8.getV8().checkThread();
    boolean bool = this.mv8.getV8().isRunning();
    AppMethodBeat.o(61592);
    return bool;
  }
  
  public final void nativeDispatch()
  {
    AppMethodBeat.i(194293);
    this.mv8.getV8().nativeDispatch();
    AppMethodBeat.o(194293);
  }
  
  public final void nativeMessageLoop()
  {
    AppMethodBeat.i(194292);
    this.mv8.getV8().checkThread();
    this.mv8.getV8().nativeMessageLoop();
    AppMethodBeat.o(194292);
  }
  
  public final void release()
  {
    AppMethodBeat.i(61593);
    this.mv8.getV8().checkThread();
    if (!this.require.isReleased()) {
      this.require.release();
    }
    if (!this.mainContext.isReleased()) {
      this.mainContext.release();
    }
    this.mv8.release();
    AppMethodBeat.o(61593);
  }
  
  public final void waitForDebugger(String paramString)
  {
    AppMethodBeat.i(61594);
    this.mv8.waitForDebugger(paramString);
    AppMethodBeat.o(61594);
  }
  
  public final void wakeUpUVLoop()
  {
    AppMethodBeat.i(61589);
    this.mv8.getV8().wakeUpUVLoop();
    AppMethodBeat.o(61589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.MultiContextNodeJS
 * JD-Core Version:    0.7.0.1
 */