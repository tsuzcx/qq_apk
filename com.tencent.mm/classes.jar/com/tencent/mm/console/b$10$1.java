package com.tencent.mm.console;

import com.tencent.mm.sdk.platformtools.am.a;

final class b$10$1
  implements am.a
{
  b$10$1(b.10 param10) {}
  
  /* Error */
  public final boolean tC()
  {
    // Byte code:
    //   0: bipush 23
    //   2: invokestatic 30	com/tencent/mm/compatible/util/d:gF	(I)Z
    //   5: ifeq +282 -> 287
    //   8: ldc 32
    //   10: ldc 34
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: invokestatic 40	android/os/Debug:getRuntimeStats	()Ljava/util/Map;
    //   21: aastore
    //   22: invokestatic 46	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: invokestatic 50	android/os/Debug:getPss	()J
    //   28: lstore_1
    //   29: new 52	android/os/Debug$MemoryInfo
    //   32: dup
    //   33: invokespecial 53	android/os/Debug$MemoryInfo:<init>	()V
    //   36: astore_3
    //   37: aload_3
    //   38: invokestatic 57	android/os/Debug:getMemoryInfo	(Landroid/os/Debug$MemoryInfo;)V
    //   41: bipush 23
    //   43: invokestatic 30	com/tencent/mm/compatible/util/d:gF	(I)Z
    //   46: ifeq +273 -> 319
    //   49: ldc 32
    //   51: ldc 59
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: lload_1
    //   60: invokestatic 65	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_3
    //   67: invokevirtual 68	android/os/Debug$MemoryInfo:getMemoryStats	()Ljava/util/Map;
    //   70: aastore
    //   71: invokestatic 46	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: invokestatic 74	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   77: ldc 76
    //   79: invokevirtual 80	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   82: astore 5
    //   84: new 82	java/io/LineNumberReader
    //   87: dup
    //   88: new 84	java/io/InputStreamReader
    //   91: dup
    //   92: aload 5
    //   94: invokevirtual 90	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   97: invokespecial 93	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 96	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   103: astore 4
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: invokevirtual 100	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   113: astore 6
    //   115: aload 6
    //   117: ifnull +233 -> 350
    //   120: aload 4
    //   122: astore_3
    //   123: aload 6
    //   125: invokevirtual 106	java/lang/String:length	()I
    //   128: ifle -23 -> 105
    //   131: aload 4
    //   133: astore_3
    //   134: ldc 32
    //   136: aload 6
    //   138: invokestatic 109	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: goto -36 -> 105
    //   144: astore 5
    //   146: aload 4
    //   148: astore_3
    //   149: ldc 32
    //   151: ldc 111
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload 5
    //   161: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 117	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 4
    //   170: ifnull +8 -> 178
    //   173: aload 4
    //   175: invokevirtual 120	java/io/LineNumberReader:close	()V
    //   178: ldc 32
    //   180: ldc 122
    //   182: iconst_1
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: invokestatic 127	java/lang/Thread:activeCount	()I
    //   191: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: invokestatic 46	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: invokestatic 135	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   201: astore_3
    //   202: aload_3
    //   203: invokeinterface 141 1 0
    //   208: invokeinterface 147 1 0
    //   213: astore 4
    //   215: aload 4
    //   217: invokeinterface 152 1 0
    //   222: ifeq +234 -> 456
    //   225: aload 4
    //   227: invokeinterface 156 1 0
    //   232: checkcast 124	java/lang/Thread
    //   235: astore 5
    //   237: aload 5
    //   239: invokevirtual 160	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   242: getstatic 166	java/lang/Thread$State:RUNNABLE	Ljava/lang/Thread$State;
    //   245: if_acmpne -30 -> 215
    //   248: ldc 32
    //   250: ldc 168
    //   252: iconst_2
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload 5
    //   260: invokevirtual 171	java/lang/Thread:getName	()Ljava/lang/String;
    //   263: aastore
    //   264: dup
    //   265: iconst_1
    //   266: aload_3
    //   267: aload 5
    //   269: invokeinterface 175 2 0
    //   274: checkcast 177	[Ljava/lang/StackTraceElement;
    //   277: invokestatic 183	com/tencent/mm/sdk/platformtools/ak:b	([Ljava/lang/StackTraceElement;)Ljava/lang/String;
    //   280: aastore
    //   281: invokestatic 46	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: goto -69 -> 215
    //   287: ldc 32
    //   289: ldc 185
    //   291: iconst_2
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: invokestatic 188	android/os/Debug:getGlobalGcInvocationCount	()I
    //   300: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: invokestatic 191	android/os/Debug:getThreadGcInvocationCount	()I
    //   309: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: aastore
    //   313: invokestatic 46	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: goto -291 -> 25
    //   319: ldc 32
    //   321: ldc 193
    //   323: iconst_2
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: lload_1
    //   330: invokestatic 65	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_3
    //   337: getfield 197	android/os/Debug$MemoryInfo:nativePss	I
    //   340: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: aastore
    //   344: invokestatic 46	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   347: goto -273 -> 74
    //   350: aload 4
    //   352: astore_3
    //   353: aload 5
    //   355: invokevirtual 200	java/lang/Process:waitFor	()I
    //   358: pop
    //   359: aload 4
    //   361: astore_3
    //   362: aload 5
    //   364: invokevirtual 203	java/lang/Process:destroy	()V
    //   367: aload 4
    //   369: invokevirtual 120	java/io/LineNumberReader:close	()V
    //   372: goto -194 -> 178
    //   375: astore_3
    //   376: ldc 32
    //   378: ldc 205
    //   380: iconst_1
    //   381: anewarray 4	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload_3
    //   387: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   390: aastore
    //   391: invokestatic 117	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: goto -216 -> 178
    //   397: astore_3
    //   398: ldc 32
    //   400: ldc 205
    //   402: iconst_1
    //   403: anewarray 4	java/lang/Object
    //   406: dup
    //   407: iconst_0
    //   408: aload_3
    //   409: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   412: aastore
    //   413: invokestatic 117	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: goto -238 -> 178
    //   419: astore 4
    //   421: aconst_null
    //   422: astore_3
    //   423: aload_3
    //   424: ifnull +7 -> 431
    //   427: aload_3
    //   428: invokevirtual 120	java/io/LineNumberReader:close	()V
    //   431: aload 4
    //   433: athrow
    //   434: astore_3
    //   435: ldc 32
    //   437: ldc 205
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload_3
    //   446: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   449: aastore
    //   450: invokestatic 117	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   453: goto -22 -> 431
    //   456: iconst_1
    //   457: ireturn
    //   458: astore 4
    //   460: goto -37 -> 423
    //   463: astore 5
    //   465: aconst_null
    //   466: astore 4
    //   468: goto -322 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	1
    //   28	302	1	l	long
    //   36	326	3	localObject1	Object
    //   375	12	3	localException1	java.lang.Exception
    //   397	12	3	localException2	java.lang.Exception
    //   422	6	3	localObject2	Object
    //   434	12	3	localException3	java.lang.Exception
    //   103	265	4	localObject3	Object
    //   419	13	4	localObject4	Object
    //   458	1	4	localObject5	Object
    //   466	1	4	localObject6	Object
    //   82	11	5	localProcess	java.lang.Process
    //   144	16	5	localException4	java.lang.Exception
    //   235	128	5	localThread	java.lang.Thread
    //   463	1	5	localException5	java.lang.Exception
    //   113	24	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   108	115	144	java/lang/Exception
    //   123	131	144	java/lang/Exception
    //   134	141	144	java/lang/Exception
    //   353	359	144	java/lang/Exception
    //   362	367	144	java/lang/Exception
    //   367	372	375	java/lang/Exception
    //   173	178	397	java/lang/Exception
    //   74	105	419	finally
    //   427	431	434	java/lang/Exception
    //   108	115	458	finally
    //   123	131	458	finally
    //   134	141	458	finally
    //   149	168	458	finally
    //   353	359	458	finally
    //   362	367	458	finally
    //   74	105	463	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.b.10.1
 * JD-Core Version:    0.7.0.1
 */