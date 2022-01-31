package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import java.util.LinkedList;

public class V8Executor
  extends Thread
{
  private Exception exception = null;
  private volatile boolean forceTerminating = false;
  private boolean longRunning;
  private String messageHandler;
  private LinkedList<String[]> messageQueue = new LinkedList();
  private String result;
  private V8 runtime;
  private final String script;
  private volatile boolean shuttingDown = false;
  private volatile boolean terminated = false;
  
  public V8Executor(String paramString)
  {
    this(paramString, false, null);
  }
  
  public V8Executor(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.script = paramString1;
    this.longRunning = paramBoolean;
    this.messageHandler = paramString2;
  }
  
  public void forceTermination()
  {
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
    finally {}
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
    try
    {
      this.messageQueue.add(paramVarArgs);
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 89	com/eclipsesource/v8/V8:createV8Runtime	()Lcom/eclipsesource/v8/V8;
    //   6: putfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   9: aload_0
    //   10: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   13: new 6	com/eclipsesource/v8/utils/V8Executor$ExecutorTermination
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 92	com/eclipsesource/v8/utils/V8Executor$ExecutorTermination:<init>	(Lcom/eclipsesource/v8/utils/V8Executor;)V
    //   21: ldc 94
    //   23: invokevirtual 98	com/eclipsesource/v8/V8:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   26: pop
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   32: invokevirtual 102	com/eclipsesource/v8/utils/V8Executor:setup	(Lcom/eclipsesource/v8/V8;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_0
    //   38: getfield 37	com/eclipsesource/v8/utils/V8Executor:forceTerminating	Z
    //   41: ifne +79 -> 120
    //   44: aload_0
    //   45: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   48: new 104	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 106
    //   54: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 46	com/eclipsesource/v8/utils/V8Executor:script	Ljava/lang/String;
    //   61: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: aload_0
    //   68: invokevirtual 118	com/eclipsesource/v8/utils/V8Executor:getName	()Ljava/lang/String;
    //   71: iconst_m1
    //   72: invokevirtual 122	com/eclipsesource/v8/V8:executeScript	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Object;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +11 -> 88
    //   80: aload_0
    //   81: aload_3
    //   82: invokevirtual 123	java/lang/Object:toString	()Ljava/lang/String;
    //   85: putfield 71	com/eclipsesource/v8/utils/V8Executor:result	Ljava/lang/String;
    //   88: aload_3
    //   89: instanceof 125
    //   92: ifeq +12 -> 104
    //   95: aload_3
    //   96: checkcast 125	com/eclipsesource/v8/Releasable
    //   99: invokeinterface 128 1 0
    //   104: aload_3
    //   105: instanceof 125
    //   108: ifeq +12 -> 120
    //   111: aload_3
    //   112: checkcast 125	com/eclipsesource/v8/Releasable
    //   115: invokeinterface 128 1 0
    //   120: aload_0
    //   121: getfield 37	com/eclipsesource/v8/utils/V8Executor:forceTerminating	Z
    //   124: ifne +315 -> 439
    //   127: aload_0
    //   128: getfield 48	com/eclipsesource/v8/utils/V8Executor:longRunning	Z
    //   131: ifeq +308 -> 439
    //   134: aload_0
    //   135: monitorenter
    //   136: aload_0
    //   137: getfield 44	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   140: invokevirtual 131	java/util/LinkedList:isEmpty	()Z
    //   143: ifeq +14 -> 157
    //   146: aload_0
    //   147: getfield 35	com/eclipsesource/v8/utils/V8Executor:shuttingDown	Z
    //   150: ifne +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 134	java/lang/Object:wait	()V
    //   157: aload_0
    //   158: getfield 44	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   161: invokevirtual 131	java/util/LinkedList:isEmpty	()Z
    //   164: ifeq +10 -> 174
    //   167: aload_0
    //   168: getfield 35	com/eclipsesource/v8/utils/V8Executor:shuttingDown	Z
    //   171: ifne +10 -> 181
    //   174: aload_0
    //   175: getfield 37	com/eclipsesource/v8/utils/V8Executor:forceTerminating	Z
    //   178: ifeq +50 -> 228
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_0
    //   184: monitorenter
    //   185: aload_0
    //   186: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   189: invokevirtual 138	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   192: invokevirtual 143	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   195: ifeq +15 -> 210
    //   198: aload_0
    //   199: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   202: invokevirtual 144	com/eclipsesource/v8/V8:release	()V
    //   205: aload_0
    //   206: aconst_null
    //   207: putfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   210: aload_0
    //   211: iconst_1
    //   212: putfield 33	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   215: aload_0
    //   216: monitorexit
    //   217: return
    //   218: astore_3
    //   219: aload_0
    //   220: monitorexit
    //   221: aload_3
    //   222: athrow
    //   223: astore_3
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_3
    //   227: athrow
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_0
    //   231: getfield 44	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   234: invokevirtual 131	java/util/LinkedList:isEmpty	()Z
    //   237: ifne -117 -> 120
    //   240: aload_0
    //   241: getfield 44	com/eclipsesource/v8/utils/V8Executor:messageQueue	Ljava/util/LinkedList;
    //   244: iconst_0
    //   245: invokevirtual 148	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   248: checkcast 150	[Ljava/lang/String;
    //   251: astore 5
    //   253: new 152	com/eclipsesource/v8/V8Array
    //   256: dup
    //   257: aload_0
    //   258: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   261: invokespecial 154	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   264: astore_3
    //   265: new 152	com/eclipsesource/v8/V8Array
    //   268: dup
    //   269: aload_0
    //   270: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   273: invokespecial 154	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   276: astore 4
    //   278: aload 5
    //   280: arraylength
    //   281: istore_2
    //   282: iconst_0
    //   283: istore_1
    //   284: iload_1
    //   285: iload_2
    //   286: if_icmpge +71 -> 357
    //   289: aload 4
    //   291: aload 5
    //   293: iload_1
    //   294: aaload
    //   295: invokevirtual 158	com/eclipsesource/v8/V8Array:push	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Array;
    //   298: pop
    //   299: iload_1
    //   300: iconst_1
    //   301: iadd
    //   302: istore_1
    //   303: goto -19 -> 284
    //   306: astore_3
    //   307: aload_0
    //   308: monitorexit
    //   309: aload_3
    //   310: athrow
    //   311: astore_3
    //   312: aload_0
    //   313: aload_3
    //   314: putfield 39	com/eclipsesource/v8/utils/V8Executor:exception	Ljava/lang/Exception;
    //   317: aload_0
    //   318: monitorenter
    //   319: aload_0
    //   320: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   323: invokevirtual 138	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   326: invokevirtual 143	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   329: ifeq +15 -> 344
    //   332: aload_0
    //   333: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   336: invokevirtual 144	com/eclipsesource/v8/V8:release	()V
    //   339: aload_0
    //   340: aconst_null
    //   341: putfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   344: aload_0
    //   345: iconst_1
    //   346: putfield 33	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   349: aload_0
    //   350: monitorexit
    //   351: return
    //   352: astore_3
    //   353: aload_0
    //   354: monitorexit
    //   355: aload_3
    //   356: athrow
    //   357: aload_3
    //   358: aload 4
    //   360: invokevirtual 161	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   363: pop
    //   364: aload_0
    //   365: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   368: aload_0
    //   369: getfield 50	com/eclipsesource/v8/utils/V8Executor:messageHandler	Ljava/lang/String;
    //   372: aload_3
    //   373: invokevirtual 165	com/eclipsesource/v8/V8:executeVoidFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)V
    //   376: aload 4
    //   378: invokevirtual 166	com/eclipsesource/v8/V8Array:release	()V
    //   381: aload_3
    //   382: invokevirtual 166	com/eclipsesource/v8/V8Array:release	()V
    //   385: goto -265 -> 120
    //   388: astore_3
    //   389: aload_0
    //   390: monitorenter
    //   391: aload_0
    //   392: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   395: invokevirtual 138	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   398: invokevirtual 143	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   401: ifeq +15 -> 416
    //   404: aload_0
    //   405: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   408: invokevirtual 144	com/eclipsesource/v8/V8:release	()V
    //   411: aload_0
    //   412: aconst_null
    //   413: putfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   416: aload_0
    //   417: iconst_1
    //   418: putfield 33	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   421: aload_0
    //   422: monitorexit
    //   423: aload_3
    //   424: athrow
    //   425: astore 5
    //   427: aload 4
    //   429: invokevirtual 166	com/eclipsesource/v8/V8Array:release	()V
    //   432: aload_3
    //   433: invokevirtual 166	com/eclipsesource/v8/V8Array:release	()V
    //   436: aload 5
    //   438: athrow
    //   439: aload_0
    //   440: monitorenter
    //   441: aload_0
    //   442: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   445: invokevirtual 138	com/eclipsesource/v8/V8:getLocker	()Lcom/eclipsesource/v8/V8Locker;
    //   448: invokevirtual 143	com/eclipsesource/v8/V8Locker:hasLock	()Z
    //   451: ifeq +15 -> 466
    //   454: aload_0
    //   455: getfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   458: invokevirtual 144	com/eclipsesource/v8/V8:release	()V
    //   461: aload_0
    //   462: aconst_null
    //   463: putfield 55	com/eclipsesource/v8/utils/V8Executor:runtime	Lcom/eclipsesource/v8/V8;
    //   466: aload_0
    //   467: iconst_1
    //   468: putfield 33	com/eclipsesource/v8/utils/V8Executor:terminated	Z
    //   471: aload_0
    //   472: monitorexit
    //   473: return
    //   474: astore_3
    //   475: aload_0
    //   476: monitorexit
    //   477: aload_3
    //   478: athrow
    //   479: astore_3
    //   480: aload_0
    //   481: monitorexit
    //   482: aload_3
    //   483: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	V8Executor
    //   283	20	1	i	int
    //   281	6	2	j	int
    //   75	37	3	localObject1	Object
    //   218	4	3	localObject2	Object
    //   223	4	3	localObject3	Object
    //   264	1	3	localV8Array1	com.eclipsesource.v8.V8Array
    //   306	4	3	localObject4	Object
    //   311	3	3	localException	Exception
    //   352	30	3	localV8Array2	com.eclipsesource.v8.V8Array
    //   388	45	3	localObject5	Object
    //   474	4	3	localObject6	Object
    //   479	4	3	localObject7	Object
    //   276	152	4	localV8Array3	com.eclipsesource.v8.V8Array
    //   251	41	5	arrayOfString	String[]
    //   425	12	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	218	finally
    //   219	221	218	finally
    //   185	210	223	finally
    //   210	217	223	finally
    //   224	226	223	finally
    //   136	157	306	finally
    //   157	174	306	finally
    //   174	181	306	finally
    //   181	183	306	finally
    //   228	230	306	finally
    //   307	309	306	finally
    //   37	76	311	java/lang/Exception
    //   80	88	311	java/lang/Exception
    //   88	104	311	java/lang/Exception
    //   104	120	311	java/lang/Exception
    //   120	136	311	java/lang/Exception
    //   230	278	311	java/lang/Exception
    //   309	311	311	java/lang/Exception
    //   376	385	311	java/lang/Exception
    //   427	439	311	java/lang/Exception
    //   319	344	352	finally
    //   344	351	352	finally
    //   353	355	352	finally
    //   37	76	388	finally
    //   80	88	388	finally
    //   88	104	388	finally
    //   104	120	388	finally
    //   120	136	388	finally
    //   230	278	388	finally
    //   309	311	388	finally
    //   312	317	388	finally
    //   376	385	388	finally
    //   427	439	388	finally
    //   278	282	425	finally
    //   289	299	425	finally
    //   357	376	425	finally
    //   441	466	474	finally
    //   466	473	474	finally
    //   475	477	474	finally
    //   391	416	479	finally
    //   416	423	479	finally
    //   480	482	479	finally
  }
  
  protected void setup(V8 paramV8) {}
  
  public void shutdown()
  {
    try
    {
      this.shuttingDown = true;
      notify();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8Executor
 * JD-Core Version:    0.7.0.1
 */