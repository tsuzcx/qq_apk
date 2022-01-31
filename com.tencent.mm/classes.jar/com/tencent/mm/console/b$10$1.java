package com.tencent.mm.console;

import com.tencent.mm.sdk.platformtools.ap.a;

final class b$10$1
  implements ap.a
{
  b$10$1(b.10 param10) {}
  
  /* Error */
  public final boolean onTimerExpired()
  {
    // Byte code:
    //   0: sipush 16090
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: bipush 23
    //   8: invokestatic 36	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   11: ifeq +282 -> 293
    //   14: ldc 38
    //   16: ldc 40
    //   18: iconst_1
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: invokestatic 46	android/os/Debug:getRuntimeStats	()Ljava/util/Map;
    //   27: aastore
    //   28: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: invokestatic 55	android/os/Debug:getPss	()J
    //   34: lstore_1
    //   35: new 57	android/os/Debug$MemoryInfo
    //   38: dup
    //   39: invokespecial 58	android/os/Debug$MemoryInfo:<init>	()V
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 62	android/os/Debug:getMemoryInfo	(Landroid/os/Debug$MemoryInfo;)V
    //   47: bipush 23
    //   49: invokestatic 36	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   52: ifeq +273 -> 325
    //   55: ldc 38
    //   57: ldc 64
    //   59: iconst_2
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: lload_1
    //   66: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload_3
    //   73: invokevirtual 73	android/os/Debug$MemoryInfo:getMemoryStats	()Ljava/util/Map;
    //   76: aastore
    //   77: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: invokestatic 79	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   83: ldc 81
    //   85: invokevirtual 85	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   88: astore 5
    //   90: new 87	java/io/LineNumberReader
    //   93: dup
    //   94: new 89	java/io/InputStreamReader
    //   97: dup
    //   98: aload 5
    //   100: invokevirtual 95	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   103: invokespecial 98	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   106: invokespecial 101	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: aload 4
    //   116: invokevirtual 105	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnull +233 -> 356
    //   126: aload 4
    //   128: astore_3
    //   129: aload 6
    //   131: invokevirtual 111	java/lang/String:length	()I
    //   134: ifle -23 -> 111
    //   137: aload 4
    //   139: astore_3
    //   140: ldc 38
    //   142: aload 6
    //   144: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: goto -36 -> 111
    //   150: astore 5
    //   152: aload 4
    //   154: astore_3
    //   155: ldc 38
    //   157: ldc 116
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload 5
    //   167: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   170: aastore
    //   171: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload 4
    //   176: ifnull +8 -> 184
    //   179: aload 4
    //   181: invokevirtual 125	java/io/LineNumberReader:close	()V
    //   184: ldc 38
    //   186: ldc 127
    //   188: iconst_1
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: invokestatic 132	java/lang/Thread:activeCount	()I
    //   197: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aastore
    //   201: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: invokestatic 140	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   207: astore_3
    //   208: aload_3
    //   209: invokeinterface 146 1 0
    //   214: invokeinterface 152 1 0
    //   219: astore 4
    //   221: aload 4
    //   223: invokeinterface 157 1 0
    //   228: ifeq +240 -> 468
    //   231: aload 4
    //   233: invokeinterface 161 1 0
    //   238: checkcast 129	java/lang/Thread
    //   241: astore 5
    //   243: aload 5
    //   245: invokevirtual 165	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   248: getstatic 171	java/lang/Thread$State:RUNNABLE	Ljava/lang/Thread$State;
    //   251: if_acmpne -30 -> 221
    //   254: ldc 38
    //   256: ldc 173
    //   258: iconst_2
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload 5
    //   266: invokevirtual 176	java/lang/Thread:getName	()Ljava/lang/String;
    //   269: aastore
    //   270: dup
    //   271: iconst_1
    //   272: aload_3
    //   273: aload 5
    //   275: invokeinterface 180 2 0
    //   280: checkcast 182	[Ljava/lang/StackTraceElement;
    //   283: invokestatic 188	com/tencent/mm/sdk/platformtools/an:stackTraceToString	([Ljava/lang/StackTraceElement;)Ljava/lang/String;
    //   286: aastore
    //   287: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: goto -69 -> 221
    //   293: ldc 38
    //   295: ldc 190
    //   297: iconst_2
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: invokestatic 193	android/os/Debug:getGlobalGcInvocationCount	()I
    //   306: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: invokestatic 196	android/os/Debug:getThreadGcInvocationCount	()I
    //   315: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -291 -> 31
    //   325: ldc 38
    //   327: ldc 198
    //   329: iconst_2
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: lload_1
    //   336: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: aload_3
    //   343: getfield 202	android/os/Debug$MemoryInfo:nativePss	I
    //   346: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: goto -273 -> 80
    //   356: aload 4
    //   358: astore_3
    //   359: aload 5
    //   361: invokevirtual 205	java/lang/Process:waitFor	()I
    //   364: pop
    //   365: aload 4
    //   367: astore_3
    //   368: aload 5
    //   370: invokevirtual 208	java/lang/Process:destroy	()V
    //   373: aload 4
    //   375: invokevirtual 125	java/io/LineNumberReader:close	()V
    //   378: goto -194 -> 184
    //   381: astore_3
    //   382: ldc 38
    //   384: ldc 210
    //   386: iconst_1
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: aload_3
    //   393: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   396: aastore
    //   397: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: goto -216 -> 184
    //   403: astore_3
    //   404: ldc 38
    //   406: ldc 210
    //   408: iconst_1
    //   409: anewarray 4	java/lang/Object
    //   412: dup
    //   413: iconst_0
    //   414: aload_3
    //   415: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   418: aastore
    //   419: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: goto -238 -> 184
    //   425: astore 4
    //   427: aconst_null
    //   428: astore_3
    //   429: aload_3
    //   430: ifnull +7 -> 437
    //   433: aload_3
    //   434: invokevirtual 125	java/io/LineNumberReader:close	()V
    //   437: sipush 16090
    //   440: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: aload 4
    //   445: athrow
    //   446: astore_3
    //   447: ldc 38
    //   449: ldc 210
    //   451: iconst_1
    //   452: anewarray 4	java/lang/Object
    //   455: dup
    //   456: iconst_0
    //   457: aload_3
    //   458: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   461: aastore
    //   462: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: goto -28 -> 437
    //   468: sipush 16090
    //   471: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: iconst_1
    //   475: ireturn
    //   476: astore 4
    //   478: goto -49 -> 429
    //   481: astore 5
    //   483: aconst_null
    //   484: astore 4
    //   486: goto -334 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	1
    //   34	302	1	l	long
    //   42	326	3	localObject1	Object
    //   381	12	3	localException1	java.lang.Exception
    //   403	12	3	localException2	java.lang.Exception
    //   428	6	3	localObject2	Object
    //   446	12	3	localException3	java.lang.Exception
    //   109	265	4	localObject3	Object
    //   425	19	4	localObject4	Object
    //   476	1	4	localObject5	Object
    //   484	1	4	localObject6	Object
    //   88	11	5	localProcess	java.lang.Process
    //   150	16	5	localException4	java.lang.Exception
    //   241	128	5	localThread	java.lang.Thread
    //   481	1	5	localException5	java.lang.Exception
    //   119	24	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   114	121	150	java/lang/Exception
    //   129	137	150	java/lang/Exception
    //   140	147	150	java/lang/Exception
    //   359	365	150	java/lang/Exception
    //   368	373	150	java/lang/Exception
    //   373	378	381	java/lang/Exception
    //   179	184	403	java/lang/Exception
    //   80	111	425	finally
    //   433	437	446	java/lang/Exception
    //   114	121	476	finally
    //   129	137	476	finally
    //   140	147	476	finally
    //   155	174	476	finally
    //   359	365	476	finally
    //   368	373	476	finally
    //   80	111	481	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.b.10.1
 * JD-Core Version:    0.7.0.1
 */