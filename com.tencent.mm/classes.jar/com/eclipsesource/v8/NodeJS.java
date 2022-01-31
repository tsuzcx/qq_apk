package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintWriter;

public class NodeJS
{
  private static final String GLOBAL = "global";
  private static final String NEXT_TICK = "nextTick";
  private static final String NODE = "node";
  private static final String PROCESS = "process";
  private static final String STARTUP_CALLBACK = "__run";
  private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
  private static final String STARTUP_SCRIPT_NAME = "startup";
  private static final String TMP_JS_EXT = ".js.tmp";
  private static final String VERSIONS = "versions";
  private String nodeVersion = null;
  private V8Function require;
  private V8 v8;
  
  private NodeJS(V8 paramV8)
  {
    this.v8 = paramV8;
  }
  
  public static NodeJS createNodeJS()
  {
    AppMethodBeat.i(74993);
    NodeJS localNodeJS = createNodeJS(null);
    AppMethodBeat.o(74993);
    return localNodeJS;
  }
  
  /* Error */
  public static NodeJS createNodeJS(File paramFile)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 8
    //   7: invokestatic 84	com/eclipsesource/v8/V8:createV8Runtime	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8;
    //   10: astore_2
    //   11: new 2	com/eclipsesource/v8/NodeJS
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 86	com/eclipsesource/v8/NodeJS:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   19: astore_3
    //   20: aload_2
    //   21: new 88	com/eclipsesource/v8/NodeJS$1
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 91	com/eclipsesource/v8/NodeJS$1:<init>	(Lcom/eclipsesource/v8/NodeJS;)V
    //   29: ldc 20
    //   31: invokevirtual 95	com/eclipsesource/v8/V8:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   34: pop
    //   35: ldc 23
    //   37: ldc 26
    //   39: invokestatic 99	com/eclipsesource/v8/NodeJS:createTemporaryScriptFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   42: astore_1
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 105	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 109	com/eclipsesource/v8/V8:createNodeRuntime	(Ljava/lang/String;)V
    //   51: aload_1
    //   52: invokevirtual 113	java/io/File:delete	()Z
    //   55: pop
    //   56: aload_0
    //   57: ifnull +8 -> 65
    //   60: aload_3
    //   61: aload_0
    //   62: invokevirtual 117	com/eclipsesource/v8/NodeJS:exec	(Ljava/io/File;)V
    //   65: ldc 78
    //   67: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_3
    //   71: areturn
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual 113	java/io/File:delete	()Z
    //   77: pop
    //   78: ldc 78
    //   80: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: new 119	java/lang/RuntimeException
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 122	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   94: astore_0
    //   95: ldc 78
    //   97: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   42	32	1	localFile	File
    //   10	34	2	localV8	V8
    //   19	52	3	localNodeJS	NodeJS
    // Exception table:
    //   from	to	target	type
    //   43	51	72	finally
    //   35	43	85	java/io/IOException
    //   51	56	85	java/io/IOException
    //   73	85	85	java/io/IOException
  }
  
  private V8Function createScriptExecutionCallback(File paramFile)
  {
    AppMethodBeat.i(75001);
    paramFile = new V8Function(this.v8, new NodeJS.2(this, paramFile));
    AppMethodBeat.o(75001);
    return paramFile;
  }
  
  private static File createTemporaryScriptFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75003);
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
      AppMethodBeat.o(75003);
    }
  }
  
  private void init(V8Function paramV8Function)
  {
    this.require = paramV8Function;
  }
  
  private void safeRelease(Releasable paramReleasable)
  {
    AppMethodBeat.i(75002);
    if (paramReleasable != null) {
      paramReleasable.release();
    }
    AppMethodBeat.o(75002);
  }
  
  /* Error */
  public void exec(File paramFile)
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 163	com/eclipsesource/v8/NodeJS:createScriptExecutionCallback	(Ljava/io/File;)Lcom/eclipsesource/v8/V8Function;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 46	com/eclipsesource/v8/NodeJS:v8	Lcom/eclipsesource/v8/V8;
    //   16: ldc 17
    //   18: invokevirtual 167	com/eclipsesource/v8/V8:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   21: astore_3
    //   22: new 169	com/eclipsesource/v8/V8Array
    //   25: dup
    //   26: aload_0
    //   27: getfield 46	com/eclipsesource/v8/NodeJS:v8	Lcom/eclipsesource/v8/V8;
    //   30: invokespecial 170	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   33: astore_2
    //   34: aload_2
    //   35: aload 4
    //   37: invokevirtual 174	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   40: pop
    //   41: aload_3
    //   42: ldc 11
    //   44: aload_2
    //   45: invokevirtual 180	com/eclipsesource/v8/V8Object:executeObjectFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Lcom/eclipsesource/v8/V8Object;
    //   48: pop
    //   49: aload_0
    //   50: aload_3
    //   51: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   54: aload_0
    //   55: aload_2
    //   56: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   59: aload_0
    //   60: aload 4
    //   62: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   65: ldc 161
    //   67: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_3
    //   76: aload_0
    //   77: aload_3
    //   78: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   81: aload_0
    //   82: aload_2
    //   83: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   86: aload_0
    //   87: aload 4
    //   89: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   92: ldc 161
    //   94: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_2
    //   102: goto -26 -> 76
    //   105: astore_1
    //   106: goto -30 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	NodeJS
    //   0	109	1	paramFile	File
    //   33	69	2	localV8Array	V8Array
    //   21	57	3	localV8Object	V8Object
    //   10	78	4	localV8Function	V8Function
    // Exception table:
    //   from	to	target	type
    //   12	22	71	finally
    //   22	34	99	finally
    //   34	49	105	finally
  }
  
  /* Error */
  public String getNodeVersion()
  {
    // Byte code:
    //   0: ldc 184
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 44	com/eclipsesource/v8/NodeJS:nodeVersion	Ljava/lang/String;
    //   9: ifnull +15 -> 24
    //   12: aload_0
    //   13: getfield 44	com/eclipsesource/v8/NodeJS:nodeVersion	Ljava/lang/String;
    //   16: astore_1
    //   17: ldc 184
    //   19: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: getfield 46	com/eclipsesource/v8/NodeJS:v8	Lcom/eclipsesource/v8/V8;
    //   28: ldc 17
    //   30: invokevirtual 167	com/eclipsesource/v8/V8:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 32
    //   37: invokevirtual 185	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   40: astore_2
    //   41: aload_0
    //   42: aload_2
    //   43: ldc 14
    //   45: invokevirtual 189	com/eclipsesource/v8/V8Object:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: putfield 44	com/eclipsesource/v8/NodeJS:nodeVersion	Ljava/lang/String;
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   56: aload_0
    //   57: aload_2
    //   58: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   61: aload_0
    //   62: getfield 44	com/eclipsesource/v8/NodeJS:nodeVersion	Ljava/lang/String;
    //   65: astore_1
    //   66: ldc 184
    //   68: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_0
    //   79: aload_3
    //   80: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   83: aload_0
    //   84: aload_2
    //   85: invokespecial 182	com/eclipsesource/v8/NodeJS:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   88: ldc 184
    //   90: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_2
    //   98: goto -20 -> 78
    //   101: astore_1
    //   102: goto -24 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	NodeJS
    //   16	56	1	str	String
    //   73	21	1	localObject1	Object
    //   95	1	1	localObject2	Object
    //   101	1	1	localObject3	Object
    //   40	58	2	localV8Object1	V8Object
    //   33	47	3	localV8Object2	V8Object
    // Exception table:
    //   from	to	target	type
    //   24	34	73	finally
    //   34	41	95	finally
    //   41	51	101	finally
  }
  
  public V8 getRuntime()
  {
    return this.v8;
  }
  
  public boolean handleMessage()
  {
    AppMethodBeat.i(74996);
    this.v8.checkThread();
    boolean bool = this.v8.pumpMessageLoop();
    AppMethodBeat.o(74996);
    return bool;
  }
  
  public boolean isRunning()
  {
    AppMethodBeat.i(74998);
    this.v8.checkThread();
    boolean bool = this.v8.isRunning();
    AppMethodBeat.o(74998);
    return bool;
  }
  
  public void release()
  {
    AppMethodBeat.i(74997);
    this.v8.checkThread();
    if (!this.require.isReleased()) {
      this.require.release();
    }
    if (!this.v8.isReleased()) {
      this.v8.release();
    }
    AppMethodBeat.o(74997);
  }
  
  public V8Object require(File paramFile)
  {
    AppMethodBeat.i(74999);
    this.v8.checkThread();
    V8Array localV8Array = new V8Array(this.v8);
    try
    {
      localV8Array.push(paramFile.getAbsolutePath());
      paramFile = (V8Object)this.require.call(null, localV8Array);
      return paramFile;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(74999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.NodeJS
 * JD-Core Version:    0.7.0.1
 */