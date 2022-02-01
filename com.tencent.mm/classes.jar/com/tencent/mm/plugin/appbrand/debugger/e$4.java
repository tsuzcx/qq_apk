package com.tencent.mm.plugin.appbrand.debugger;

final class e$4
  implements Runnable
{
  e$4(String paramString1, String paramString2, String paramString3, Runnable paramRunnable) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 42	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   12: invokestatic 49	com/tencent/mm/loader/j/b:aSR	()Ljava/lang/String;
    //   15: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: getfield 20	com/tencent/mm/plugin/appbrand/debugger/e$4:val$appId	Ljava/lang/String;
    //   22: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 55
    //   27: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: getfield 22	com/tencent/mm/plugin/appbrand/debugger/e$4:val$name	Ljava/lang/String;
    //   34: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 55
    //   39: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   45: invokevirtual 64	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: ldc 66
    //   50: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 24	com/tencent/mm/plugin/appbrand/debugger/e$4:val$url	Ljava/lang/String;
    //   62: aconst_null
    //   63: invokestatic 74	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
    //   66: astore_1
    //   67: aload_1
    //   68: sipush 10000
    //   71: invokeinterface 79 2 0
    //   76: aload_1
    //   77: sipush 20000
    //   80: invokeinterface 82 2 0
    //   85: aload_1
    //   86: ldc 84
    //   88: invokeinterface 88 2 0
    //   93: aload_1
    //   94: invokeinterface 92 1 0
    //   99: pop
    //   100: aload_1
    //   101: invokeinterface 96 1 0
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +313 -> 421
    //   111: aload 6
    //   113: invokestatic 102	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   116: astore_3
    //   117: aload_3
    //   118: astore_2
    //   119: aload_1
    //   120: astore 4
    //   122: aload_3
    //   123: astore 5
    //   125: aload_1
    //   126: aload_3
    //   127: invokestatic 108	org/apache/commons/a/d:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   130: pop
    //   131: aload_3
    //   132: astore_2
    //   133: aload_1
    //   134: astore 4
    //   136: aload_3
    //   137: astore 5
    //   139: aload_3
    //   140: invokevirtual 113	java/io/OutputStream:flush	()V
    //   143: aload_3
    //   144: astore_2
    //   145: aload_1
    //   146: astore 4
    //   148: aload_3
    //   149: astore 5
    //   151: aload_0
    //   152: getfield 20	com/tencent/mm/plugin/appbrand/debugger/e$4:val$appId	Ljava/lang/String;
    //   155: astore 7
    //   157: aload_3
    //   158: astore_2
    //   159: aload_1
    //   160: astore 4
    //   162: aload_3
    //   163: astore 5
    //   165: aload_0
    //   166: getfield 22	com/tencent/mm/plugin/appbrand/debugger/e$4:val$name	Ljava/lang/String;
    //   169: astore 8
    //   171: aload_3
    //   172: astore_2
    //   173: aload_1
    //   174: astore 4
    //   176: aload_3
    //   177: astore 5
    //   179: ldc 115
    //   181: ldc 117
    //   183: iconst_4
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload 7
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: aload 8
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: aload 6
    //   201: aastore
    //   202: dup
    //   203: iconst_3
    //   204: new 119	com/tencent/mm/vfs/q
    //   207: dup
    //   208: aload 6
    //   210: invokespecial 121	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   213: invokestatic 125	com/tencent/mm/plugin/appbrand/debugger/e:n	(Lcom/tencent/mm/vfs/q;)Ljava/lang/String;
    //   216: aastore
    //   217: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload_3
    //   221: astore_2
    //   222: aload_1
    //   223: astore 4
    //   225: aload_3
    //   226: astore 5
    //   228: ldc 132
    //   230: iconst_2
    //   231: invokestatic 138	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;I)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   234: new 42	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   241: aload 7
    //   243: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc 55
    //   248: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 8
    //   253: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: aload 6
    //   261: invokevirtual 142	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   264: invokeinterface 148 1 0
    //   269: pop
    //   270: aload_1
    //   271: invokestatic 152	org/apache/commons/a/d:T	(Ljava/io/InputStream;)V
    //   274: aload_3
    //   275: invokestatic 156	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   278: aload_0
    //   279: getfield 26	com/tencent/mm/plugin/appbrand/debugger/e$4:nxa	Ljava/lang/Runnable;
    //   282: invokeinterface 158 1 0
    //   287: ldc 34
    //   289: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: return
    //   293: astore 6
    //   295: aconst_null
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_1
    //   299: aload_3
    //   300: astore_2
    //   301: aload_1
    //   302: astore 4
    //   304: ldc 115
    //   306: ldc 163
    //   308: iconst_4
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload_0
    //   315: getfield 20	com/tencent/mm/plugin/appbrand/debugger/e$4:val$appId	Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload_0
    //   322: getfield 22	com/tencent/mm/plugin/appbrand/debugger/e$4:val$name	Ljava/lang/String;
    //   325: aastore
    //   326: dup
    //   327: iconst_2
    //   328: aload_0
    //   329: getfield 24	com/tencent/mm/plugin/appbrand/debugger/e$4:val$url	Ljava/lang/String;
    //   332: aastore
    //   333: dup
    //   334: iconst_3
    //   335: aload 6
    //   337: aastore
    //   338: invokestatic 165	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_1
    //   342: invokestatic 152	org/apache/commons/a/d:T	(Ljava/io/InputStream;)V
    //   345: aload_3
    //   346: invokestatic 156	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   349: aload_0
    //   350: getfield 26	com/tencent/mm/plugin/appbrand/debugger/e$4:nxa	Ljava/lang/Runnable;
    //   353: invokeinterface 158 1 0
    //   358: ldc 34
    //   360: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: return
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_2
    //   367: aconst_null
    //   368: astore_1
    //   369: aload_1
    //   370: invokestatic 152	org/apache/commons/a/d:T	(Ljava/io/InputStream;)V
    //   373: aload_2
    //   374: invokestatic 156	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   377: aload_0
    //   378: getfield 26	com/tencent/mm/plugin/appbrand/debugger/e$4:nxa	Ljava/lang/Runnable;
    //   381: invokeinterface 158 1 0
    //   386: ldc 34
    //   388: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: aload_3
    //   392: athrow
    //   393: astore_3
    //   394: aconst_null
    //   395: astore_2
    //   396: goto -27 -> 369
    //   399: astore_3
    //   400: aload 4
    //   402: astore_1
    //   403: goto -34 -> 369
    //   406: astore 6
    //   408: aconst_null
    //   409: astore_3
    //   410: goto -111 -> 299
    //   413: astore 6
    //   415: aload 5
    //   417: astore_3
    //   418: goto -119 -> 299
    //   421: aconst_null
    //   422: astore_3
    //   423: goto -280 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	4
    //   66	337	1	localObject1	Object
    //   118	278	2	localOutputStream1	java.io.OutputStream
    //   116	230	3	localOutputStream2	java.io.OutputStream
    //   364	28	3	localObject2	Object
    //   393	1	3	localObject3	Object
    //   399	1	3	localObject4	Object
    //   409	14	3	localObject5	Object
    //   120	281	4	localObject6	Object
    //   123	293	5	localOutputStream3	java.io.OutputStream
    //   56	204	6	str1	String
    //   293	43	6	localException1	java.lang.Exception
    //   406	1	6	localException2	java.lang.Exception
    //   413	1	6	localException3	java.lang.Exception
    //   155	87	7	str2	String
    //   169	83	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   58	107	293	java/lang/Exception
    //   58	107	364	finally
    //   111	117	393	finally
    //   125	131	399	finally
    //   139	143	399	finally
    //   151	157	399	finally
    //   165	171	399	finally
    //   179	220	399	finally
    //   228	270	399	finally
    //   304	341	399	finally
    //   111	117	406	java/lang/Exception
    //   125	131	413	java/lang/Exception
    //   139	143	413	java/lang/Exception
    //   151	157	413	java/lang/Exception
    //   165	171	413	java/lang/Exception
    //   179	220	413	java/lang/Exception
    //   228	270	413	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.e.4
 * JD-Core Version:    0.7.0.1
 */