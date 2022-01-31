package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class V8Executor
  extends Thread
{
  private Exception exception;
  private volatile boolean forceTerminating;
  private boolean longRunning;
  private String messageHandler;
  private LinkedList<String[]> messageQueue;
  private String result;
  private V8 runtime;
  private final String script;
  private volatile boolean shuttingDown;
  private volatile boolean terminated;
  
  public V8Executor(String paramString)
  {
    this(paramString, false, null);
  }
  
  public V8Executor(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(75085);
    this.terminated = false;
    this.shuttingDown = false;
    this.forceTerminating = false;
    this.exception = null;
    this.messageQueue = new LinkedList();
    this.script = paramString1;
    this.longRunning = paramBoolean;
    this.messageHandler = paramString2;
    AppMethodBeat.o(75085);
  }
  
  public void forceTermination()
  {
    AppMethodBeat.i(75088);
    try
    {
      this.forceTerminating = true;
      this.shuttingDown = true;
      if (this.runtime != null) {
        this.runtime.terminateExecution();
      }
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(75088);
    }
  }
  
  public Exception getException()
  {
    return this.exception;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public boolean hasException()
  {
    return this.exception != null;
  }
  
  public boolean hasTerminated()
  {
    return this.terminated;
  }
  
  public boolean isShuttingDown()
  {
    return this.shuttingDown;
  }
  
  public boolean isTerminating()
  {
    return this.forceTerminating;
  }
  
  public void postMessage(String... paramVarArgs)
  {
    AppMethodBeat.i(75086);
    try
    {
      this.messageQueue.add(paramVarArgs);
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(75086);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: invokestatic 102	com/eclipsesource/v8/V8:createV8Runtime	()Lcom/eclipsesource/v8/V8;
    //   11: putfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   14: aload_0
    //   15: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   18: new 6	com/eclipsesource/v8/utils/V8Executor$ExecutorTermination
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 105	com/eclipsesource/v8/utils/V8Executor$ExecutorTermination:<init>	(Lcom/eclipsesource/v8/utils/V8Executor;)V
    //   26: ldc 107
    //   28: invokevirtual 111	com/eclipsesource/v8/V8:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   31: pop
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   37: invokevirtual 115	com/eclipsesource/v8/utils/V8Executor:setup	(Lcom/eclipsesource/v8/V8;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 44	com/eclipsesource/v8/utils/V8Executor:forceTerminating	Z
    //   46: ifne +79 -> 125
    //   49: aload_0
    //   50: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   53: new 117	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 119
    //   59: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 53	com/eclipsesource/v8/utils/V8Executor:script	Ljava/lang/String;
    //   66: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aload_0
    //   73: invokevirtual 131	com/eclipsesource/v8/utils/V8Executor:getName	()Ljava/lang/String;
    //   76: iconst_m1
    //   77: invokevirtual 135	com/eclipsesource/v8/V8:executeScript	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Object;
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull +11 -> 93
    //   85: aload_0
    //   86: aload_3
    //   87: invokevirtual 136	java/lang/Object:toString	()Ljava/lang/String;
    //   90: putfield 82	com/eclipsesource/v8/utils/V8Executor:result	Ljava/lang/String;
    //   93: aload_3
    //   94: instanceof 138
    //   97: ifeq +12 -> 109
    //   100: aload_3
    //   101: checkcast 138	com/eclipsesource/v8/Releasable
    //   104: invokeinterface 141 1 0
    //   109: aload_3
    //   110: instanceof 138
    //   113: ifeq +12 -> 125
    //   116: aload_3
    //   117: checkcast 138	com/eclipsesource/v8/Releasable
    //   120: invokeinterface 141 1 0
    //   125: aload_0
    //   126: getfield 44	com/eclipsesource/v8/utils/V8Executor:forceTerminating	Z
    //   129: ifne +345 -> 474
    //   132: aload_0
    //   133: getfield 55	com/eclipsesource/v8/utils/V8Executor:longRunning	Z
    //   136: ifeq +338 -> 474
    //   139: aload_0
    //   140: monitorenter
    //   141: aload_0
    //   142: getfield 51	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   145: invokevirtual 144	java/util/LinkedList:isEmpty	()Z
    //   148: ifeq +14 -> 162
    //   151: aload_0
    //   152: getfield 42	com/eclipsesource/v8/utils/V8Executor:shuttingDown	Z
    //   155: ifne +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 147	java/lang/Object:wait	()V
    //   162: aload_0
    //   163: getfield 51	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   166: invokevirtual 144	java/util/LinkedList:isEmpty	()Z
    //   169: ifeq +10 -> 179
    //   172: aload_0
    //   173: getfield 42	com/eclipsesource/v8/utils/V8Executor:shuttingDown	Z
    //   176: ifne +10 -> 186
    //   179: aload_0
    //   180: getfield 44	com/eclipsesource/v8/utils/V8Executor:forceTerminating	Z
    //   183: ifeq +65 -> 248
    //   186: aload_0
    //   187: monitorexit
    //   188: aload_0
    //   189: monitorenter
    //   190: aload_0
    //   191: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   194: invokevirtual 151	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   197: invokevirtual 156	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   200: ifeq +15 -> 215
    //   203: aload_0
    //   204: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   207: invokevirtual 157	com/eclipsesource/v8/V8:release	()V
    //   210: aload_0
    //   211: aconst_null
    //   212: putfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   215: aload_0
    //   216: iconst_1
    //   217: putfield 40	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   220: aload_0
    //   221: monitorexit
    //   222: ldc 98
    //   224: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: astore_3
    //   229: aload_0
    //   230: monitorexit
    //   231: ldc 98
    //   233: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_3
    //   237: athrow
    //   238: astore_3
    //   239: aload_0
    //   240: monitorexit
    //   241: ldc 98
    //   243: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_3
    //   247: athrow
    //   248: aload_0
    //   249: monitorexit
    //   250: aload_0
    //   251: getfield 51	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   254: invokevirtual 144	java/util/LinkedList:isEmpty	()Z
    //   257: ifne -132 -> 125
    //   260: aload_0
    //   261: getfield 51	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   264: iconst_0
    //   265: invokevirtual 161	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   268: checkcast 163	[Ljava/lang/String;
    //   271: astore 5
    //   273: new 165	com/eclipsesource/v8/V8Array
    //   276: dup
    //   277: aload_0
    //   278: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   281: invokespecial 167	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   284: astore_3
    //   285: new 165	com/eclipsesource/v8/V8Array
    //   288: dup
    //   289: aload_0
    //   290: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   293: invokespecial 167	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   296: astore 4
    //   298: aload 5
    //   300: arraylength
    //   301: istore_2
    //   302: iconst_0
    //   303: istore_1
    //   304: iload_1
    //   305: iload_2
    //   306: if_icmpge +76 -> 382
    //   309: aload 4
    //   311: aload 5
    //   313: iload_1
    //   314: aaload
    //   315: invokevirtual 171	com/eclipsesource/v8/V8Array:push	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Array;
    //   318: pop
    //   319: iload_1
    //   320: iconst_1
    //   321: iadd
    //   322: istore_1
    //   323: goto -19 -> 304
    //   326: astore_3
    //   327: aload_0
    //   328: monitorexit
    //   329: ldc 98
    //   331: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload_3
    //   335: athrow
    //   336: astore_3
    //   337: aload_0
    //   338: aload_3
    //   339: putfield 46	com/eclipsesource/v8/utils/V8Executor:exception	Ljava/lang/Exception;
    //   342: aload_0
    //   343: monitorenter
    //   344: aload_0
    //   345: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   348: invokevirtual 151	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   351: invokevirtual 156	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   354: ifeq +15 -> 369
    //   357: aload_0
    //   358: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   361: invokevirtual 157	com/eclipsesource/v8/V8:release	()V
    //   364: aload_0
    //   365: aconst_null
    //   366: putfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   369: aload_0
    //   370: iconst_1
    //   371: putfield 40	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   374: aload_0
    //   375: monitorexit
    //   376: ldc 98
    //   378: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: return
    //   382: aload_3
    //   383: aload 4
    //   385: invokevirtual 174	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   388: pop
    //   389: aload_0
    //   390: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   393: aload_0
    //   394: getfield 57	com/eclipsesource/v8/utils/V8Executor:messageHandler	Ljava/lang/String;
    //   397: aload_3
    //   398: invokevirtual 178	com/eclipsesource/v8/V8:executeVoidFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)V
    //   401: aload 4
    //   403: invokevirtual 179	com/eclipsesource/v8/V8Array:release	()V
    //   406: aload_3
    //   407: invokevirtual 179	com/eclipsesource/v8/V8Array:release	()V
    //   410: goto -285 -> 125
    //   413: astore_3
    //   414: aload_0
    //   415: monitorenter
    //   416: aload_0
    //   417: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   420: invokevirtual 151	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   423: invokevirtual 156	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   426: ifeq +15 -> 441
    //   429: aload_0
    //   430: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   433: invokevirtual 157	com/eclipsesource/v8/V8:release	()V
    //   436: aload_0
    //   437: aconst_null
    //   438: putfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   441: aload_0
    //   442: iconst_1
    //   443: putfield 40	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   446: aload_0
    //   447: monitorexit
    //   448: ldc 98
    //   450: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: aload_3
    //   454: athrow
    //   455: astore 5
    //   457: aload 4
    //   459: invokevirtual 179	com/eclipsesource/v8/V8Array:release	()V
    //   462: aload_3
    //   463: invokevirtual 179	com/eclipsesource/v8/V8Array:release	()V
    //   466: ldc 98
    //   468: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: aload 5
    //   473: athrow
    //   474: aload_0
    //   475: monitorenter
    //   476: aload_0
    //   477: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   480: invokevirtual 151	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   483: invokevirtual 156	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   486: ifeq +15 -> 501
    //   489: aload_0
    //   490: getfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   493: invokevirtual 157	com/eclipsesource/v8/V8:release	()V
    //   496: aload_0
    //   497: aconst_null
    //   498: putfield 66	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   501: aload_0
    //   502: iconst_1
    //   503: putfield 40	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   506: aload_0
    //   507: monitorexit
    //   508: ldc 98
    //   510: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   513: return
    //   514: astore_3
    //   515: aload_0
    //   516: monitorexit
    //   517: ldc 98
    //   519: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   522: aload_3
    //   523: athrow
    //   524: astore_3
    //   525: aload_0
    //   526: monitorexit
    //   527: ldc 98
    //   529: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: aload_3
    //   533: athrow
    //   534: astore_3
    //   535: aload_0
    //   536: monitorexit
    //   537: ldc 98
    //   539: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload_3
    //   543: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	V8Executor
    //   303	20	1	i	int
    //   301	6	2	j	int
    //   80	37	3	localObject1	Object
    //   228	9	3	localObject2	Object
    //   238	9	3	localObject3	Object
    //   284	1	3	localV8Array1	com.eclipsesource.v8.V8Array
    //   326	9	3	localObject4	Object
    //   336	71	3	localException	Exception
    //   413	50	3	localObject5	Object
    //   514	9	3	localObject6	Object
    //   524	9	3	localObject7	Object
    //   534	9	3	localObject8	Object
    //   296	162	4	localV8Array2	com.eclipsesource.v8.V8Array
    //   271	41	5	arrayOfString	String[]
    //   455	17	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   7	42	228	finally
    //   229	231	228	finally
    //   190	215	238	finally
    //   215	222	238	finally
    //   239	241	238	finally
    //   141	162	326	finally
    //   162	179	326	finally
    //   179	186	326	finally
    //   186	188	326	finally
    //   248	250	326	finally
    //   327	329	326	finally
    //   42	81	336	java/lang/Exception
    //   85	93	336	java/lang/Exception
    //   93	109	336	java/lang/Exception
    //   109	125	336	java/lang/Exception
    //   125	141	336	java/lang/Exception
    //   250	298	336	java/lang/Exception
    //   329	336	336	java/lang/Exception
    //   401	410	336	java/lang/Exception
    //   457	474	336	java/lang/Exception
    //   42	81	413	finally
    //   85	93	413	finally
    //   93	109	413	finally
    //   109	125	413	finally
    //   125	141	413	finally
    //   250	298	413	finally
    //   329	336	413	finally
    //   337	342	413	finally
    //   401	410	413	finally
    //   457	474	413	finally
    //   298	302	455	finally
    //   309	319	455	finally
    //   382	401	455	finally
    //   476	501	514	finally
    //   501	508	514	finally
    //   515	517	514	finally
    //   344	369	524	finally
    //   369	376	524	finally
    //   525	527	524	finally
    //   416	441	534	finally
    //   441	448	534	finally
    //   535	537	534	finally
  }
  
  protected void setup(V8 paramV8) {}
  
  public void shutdown()
  {
    AppMethodBeat.i(75089);
    try
    {
      this.shuttingDown = true;
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(75089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8Executor
 * JD-Core Version:    0.7.0.1
 */