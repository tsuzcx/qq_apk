package com.tencent.tmdownloader.internal.a;

class j
  extends Thread
{
  private int b = 0;
  
  public j(h paramh, int paramInt)
  {
    this.b = paramInt;
    setName("download_thread_" + this.b);
    start();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 46
    //   2: new 19	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   9: ldc 48
    //   11: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 17	com/tencent/tmdownloader/internal/a/j:b	I
    //   18: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: ldc 50
    //   23: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 56	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   36: getfield 62	com/tencent/tmdownloader/internal/a/h:e	Ljava/lang/Object;
    //   39: astore_1
    //   40: aload_1
    //   41: monitorenter
    //   42: ldc 46
    //   44: new 19	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   51: ldc 48
    //   53: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 17	com/tencent/tmdownloader/internal/a/j:b	I
    //   60: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc 64
    //   65: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 56	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   78: getfield 62	com/tencent/tmdownloader/internal/a/h:e	Ljava/lang/Object;
    //   81: invokevirtual 69	java/lang/Object:wait	()V
    //   84: aload_1
    //   85: monitorexit
    //   86: invokestatic 73	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   89: invokevirtual 77	java/lang/Thread:isInterrupted	()Z
    //   92: ifeq +172 -> 264
    //   95: ldc 46
    //   97: new 19	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   104: ldc 48
    //   106: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 17	com/tencent/tmdownloader/internal/a/j:b	I
    //   113: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc 79
    //   118: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 56	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: return
    //   128: astore_2
    //   129: ldc 46
    //   131: new 19	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   138: ldc 48
    //   140: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: getfield 17	com/tencent/tmdownloader/internal/a/j:b	I
    //   147: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc 79
    //   152: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 56	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_2
    //   162: invokevirtual 82	java/lang/InterruptedException:printStackTrace	()V
    //   165: aload_1
    //   166: monitorexit
    //   167: return
    //   168: astore_2
    //   169: aload_1
    //   170: monitorexit
    //   171: aload_2
    //   172: athrow
    //   173: aload_1
    //   174: ifnull +62 -> 236
    //   177: ldc 46
    //   179: new 19	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   186: ldc 84
    //   188: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: invokevirtual 87	com/tencent/tmdownloader/internal/a/j:getName	()Ljava/lang/String;
    //   195: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 89
    //   200: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 93	com/tencent/tmdownloader/internal/a/g:c	()Ljava/lang/String;
    //   207: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 56	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: invokestatic 98	com/tencent/tmdownloader/internal/a/c:a	()Landroid/os/PowerManager$WakeLock;
    //   219: astore_2
    //   220: aload_1
    //   221: aload_0
    //   222: invokevirtual 87	com/tencent/tmdownloader/internal/a/j:getName	()Ljava/lang/String;
    //   225: invokevirtual 100	com/tencent/tmdownloader/internal/a/g:a	(Ljava/lang/String;)V
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 105	android/os/PowerManager$WakeLock:release	()V
    //   236: aload_0
    //   237: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   240: getfield 108	com/tencent/tmdownloader/internal/a/h:f	Ljava/lang/Object;
    //   243: astore_2
    //   244: aload_2
    //   245: monitorenter
    //   246: aload_1
    //   247: ifnull +15 -> 262
    //   250: aload_0
    //   251: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   254: getfield 111	com/tencent/tmdownloader/internal/a/h:c	Ljava/util/ArrayList;
    //   257: aload_1
    //   258: invokevirtual 117	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: aload_2
    //   263: monitorexit
    //   264: aload_0
    //   265: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   268: invokevirtual 119	com/tencent/tmdownloader/internal/a/h:b	()Z
    //   271: ifeq -239 -> 32
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_0
    //   277: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   280: getfield 108	com/tencent/tmdownloader/internal/a/h:f	Ljava/lang/Object;
    //   283: astore_2
    //   284: aload_2
    //   285: monitorenter
    //   286: aload_0
    //   287: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   290: getfield 122	com/tencent/tmdownloader/internal/a/h:b	Ljava/util/PriorityQueue;
    //   293: invokevirtual 128	java/util/PriorityQueue:size	()I
    //   296: ifle +29 -> 325
    //   299: aload_0
    //   300: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   303: getfield 122	com/tencent/tmdownloader/internal/a/h:b	Ljava/util/PriorityQueue;
    //   306: invokevirtual 131	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   309: checkcast 91	com/tencent/tmdownloader/internal/a/g
    //   312: astore_1
    //   313: aload_0
    //   314: getfield 12	com/tencent/tmdownloader/internal/a/j:a	Lcom/tencent/tmdownloader/internal/a/h;
    //   317: getfield 111	com/tencent/tmdownloader/internal/a/h:c	Ljava/util/ArrayList;
    //   320: aload_1
    //   321: invokevirtual 134	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   324: pop
    //   325: aload_2
    //   326: monitorexit
    //   327: invokestatic 73	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   330: invokevirtual 77	java/lang/Thread:isInterrupted	()Z
    //   333: ifeq -160 -> 173
    //   336: ldc 46
    //   338: new 19	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   345: ldc 48
    //   347: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_0
    //   351: getfield 17	com/tencent/tmdownloader/internal/a/j:b	I
    //   354: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: ldc 79
    //   359: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 56	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: return
    //   369: astore_1
    //   370: aload_2
    //   371: monitorexit
    //   372: aload_1
    //   373: athrow
    //   374: astore_1
    //   375: aload_2
    //   376: monitorexit
    //   377: aload_1
    //   378: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	j
    //   39	282	1	localObject1	java.lang.Object
    //   369	4	1	localObject2	java.lang.Object
    //   374	4	1	localObject3	java.lang.Object
    //   128	34	2	localInterruptedException	java.lang.InterruptedException
    //   168	4	2	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   42	84	128	java/lang/InterruptedException
    //   42	84	168	finally
    //   84	86	168	finally
    //   129	167	168	finally
    //   169	171	168	finally
    //   286	325	369	finally
    //   325	327	369	finally
    //   370	372	369	finally
    //   250	262	374	finally
    //   262	264	374	finally
    //   375	377	374	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.j
 * JD-Core Version:    0.7.0.1
 */