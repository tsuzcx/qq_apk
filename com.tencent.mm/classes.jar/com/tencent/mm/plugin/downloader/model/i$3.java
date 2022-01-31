package com.tencent.mm.plugin.downloader.model;

final class i$3
  implements Runnable
{
  i$3(i parami) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 2454
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 14	com/tencent/mm/plugin/downloader/model/i$3:kZe	Lcom/tencent/mm/plugin/downloader/model/i;
    //   10: getfield 31	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   13: invokevirtual 37	java/util/concurrent/CopyOnWriteArraySet:iterator	()Ljava/util/Iterator;
    //   16: astore 7
    //   18: aload 7
    //   20: invokeinterface 43 1 0
    //   25: ifeq +668 -> 693
    //   28: aload 7
    //   30: invokeinterface 47 1 0
    //   35: checkcast 49	java/lang/Long
    //   38: invokevirtual 53	java/lang/Long:longValue	()J
    //   41: lstore 5
    //   43: aload_0
    //   44: getfield 14	com/tencent/mm/plugin/downloader/model/i$3:kZe	Lcom/tencent/mm/plugin/downloader/model/i;
    //   47: astore 8
    //   49: lload 5
    //   51: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: astore 9
    //   56: ldc 59
    //   58: ldc 61
    //   60: invokestatic 67	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 9
    //   65: invokevirtual 53	java/lang/Long:longValue	()J
    //   68: invokestatic 73	com/tencent/mm/plugin/downloader/model/d:iJ	(J)Lcom/tencent/mm/plugin/downloader/g/a;
    //   71: astore 10
    //   73: aload 10
    //   75: ifnull -57 -> 18
    //   78: new 75	android/app/DownloadManager$Query
    //   81: dup
    //   82: invokespecial 76	android/app/DownloadManager$Query:<init>	()V
    //   85: astore 11
    //   87: aload 11
    //   89: iconst_1
    //   90: newarray long
    //   92: dup
    //   93: iconst_0
    //   94: aload 10
    //   96: getfield 82	com/tencent/mm/plugin/downloader/g/a:field_sysDownloadId	J
    //   99: lastore
    //   100: invokevirtual 86	android/app/DownloadManager$Query:setFilterById	([J)Landroid/app/DownloadManager$Query;
    //   103: pop
    //   104: aload 8
    //   106: getfield 90	com/tencent/mm/plugin/downloader/model/i:kZb	Landroid/app/DownloadManager;
    //   109: aload 11
    //   111: invokevirtual 96	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   114: astore 11
    //   116: aload 11
    //   118: ifnonnull +107 -> 225
    //   121: ldc 59
    //   123: ldc 98
    //   125: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload 8
    //   130: getfield 31	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   133: aload 9
    //   135: invokevirtual 105	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: aload 10
    //   141: iconst_4
    //   142: putfield 109	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   145: aload 10
    //   147: invokestatic 112	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   150: pop2
    //   151: goto -133 -> 18
    //   154: astore 7
    //   156: ldc 59
    //   158: aload 7
    //   160: invokevirtual 116	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: sipush 2454
    //   169: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: return
    //   173: astore 11
    //   175: ldc 59
    //   177: ldc 121
    //   179: iconst_2
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 11
    //   187: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: aload 9
    //   195: aastore
    //   196: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aload 8
    //   201: getfield 31	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   204: aload 9
    //   206: invokevirtual 105	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   209: pop
    //   210: aload 10
    //   212: iconst_4
    //   213: putfield 109	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   216: aload 10
    //   218: invokestatic 112	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   221: pop2
    //   222: goto -204 -> 18
    //   225: aload 11
    //   227: invokeinterface 132 1 0
    //   232: ifeq +132 -> 364
    //   235: aload 11
    //   237: ldc 134
    //   239: invokeinterface 138 2 0
    //   244: istore 4
    //   246: aload 11
    //   248: ldc 140
    //   250: invokeinterface 138 2 0
    //   255: istore_1
    //   256: aload 11
    //   258: ldc 142
    //   260: invokeinterface 138 2 0
    //   265: istore_2
    //   266: aload 11
    //   268: ldc 144
    //   270: invokeinterface 138 2 0
    //   275: istore_3
    //   276: iload 4
    //   278: iconst_m1
    //   279: if_icmpeq +85 -> 364
    //   282: aload 11
    //   284: iload 4
    //   286: invokeinterface 148 2 0
    //   291: istore 4
    //   293: ldc 59
    //   295: ldc 150
    //   297: iconst_1
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: iload 4
    //   305: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: invokestatic 157	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: iload 4
    //   314: lookupswitch	default:+50->364, 1:+60->374, 2:+60->374, 4:+216->530, 8:+255->569, 16:+171->485
    //   365: fconst_0
    //   366: invokeinterface 160 1 0
    //   371: goto -353 -> 18
    //   374: iload_2
    //   375: iconst_m1
    //   376: if_icmpeq +16 -> 392
    //   379: aload 10
    //   381: aload 11
    //   383: iload_2
    //   384: invokeinterface 164 2 0
    //   389: putfield 167	com/tencent/mm/plugin/downloader/g/a:field_downloadedSize	J
    //   392: iload_3
    //   393: iconst_m1
    //   394: if_icmpeq +16 -> 410
    //   397: aload 10
    //   399: aload 11
    //   401: iload_3
    //   402: invokeinterface 164 2 0
    //   407: putfield 170	com/tencent/mm/plugin/downloader/g/a:field_totalSize	J
    //   410: aload 10
    //   412: iconst_1
    //   413: putfield 109	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   416: aload 10
    //   418: invokestatic 112	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   421: pop2
    //   422: aload 8
    //   424: getfield 174	com/tencent/mm/plugin/downloader/model/i:kYw	Lcom/tencent/mm/plugin/downloader/model/c;
    //   427: aload 9
    //   429: invokevirtual 53	java/lang/Long:longValue	()J
    //   432: invokevirtual 180	com/tencent/mm/plugin/downloader/model/c:iH	(J)V
    //   435: goto -71 -> 364
    //   438: astore 12
    //   440: aload 8
    //   442: getfield 31	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   445: aload 9
    //   447: invokevirtual 105	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   450: pop
    //   451: aload 10
    //   453: iconst_4
    //   454: putfield 109	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   457: aload 10
    //   459: invokestatic 112	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   462: pop2
    //   463: ldc 59
    //   465: ldc 182
    //   467: iconst_1
    //   468: anewarray 4	java/lang/Object
    //   471: dup
    //   472: iconst_0
    //   473: aload 12
    //   475: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   478: aastore
    //   479: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: goto -118 -> 364
    //   485: aload 8
    //   487: getfield 31	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   490: aload 9
    //   492: invokevirtual 105	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   495: pop
    //   496: getstatic 187	com/tencent/mm/plugin/downloader/a/a:kVA	I
    //   499: istore_1
    //   500: aload 10
    //   502: iconst_4
    //   503: putfield 109	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   506: aload 10
    //   508: invokestatic 112	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   511: pop2
    //   512: aload 8
    //   514: getfield 174	com/tencent/mm/plugin/downloader/model/i:kYw	Lcom/tencent/mm/plugin/downloader/model/c;
    //   517: aload 9
    //   519: invokevirtual 53	java/lang/Long:longValue	()J
    //   522: iload_1
    //   523: iconst_0
    //   524: invokevirtual 190	com/tencent/mm/plugin/downloader/model/c:d	(JIZ)V
    //   527: goto -163 -> 364
    //   530: aload 8
    //   532: getfield 31	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   535: aload 9
    //   537: invokevirtual 105	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   540: pop
    //   541: aload 10
    //   543: iconst_2
    //   544: putfield 109	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   547: aload 10
    //   549: invokestatic 112	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   552: pop2
    //   553: aload 8
    //   555: getfield 174	com/tencent/mm/plugin/downloader/model/i:kYw	Lcom/tencent/mm/plugin/downloader/model/c;
    //   558: aload 9
    //   560: invokevirtual 53	java/lang/Long:longValue	()J
    //   563: invokevirtual 193	com/tencent/mm/plugin/downloader/model/c:iG	(J)V
    //   566: goto -202 -> 364
    //   569: aload 8
    //   571: getfield 31	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   574: aload 9
    //   576: invokevirtual 105	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   579: pop
    //   580: iload_1
    //   581: iconst_m1
    //   582: if_icmpeq -218 -> 364
    //   585: aload 10
    //   587: getfield 197	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   590: invokestatic 203	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   593: ifne +14 -> 607
    //   596: aload 10
    //   598: getfield 197	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   601: invokestatic 208	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   604: ifne +37 -> 641
    //   607: ldc 59
    //   609: ldc 210
    //   611: iconst_1
    //   612: anewarray 4	java/lang/Object
    //   615: dup
    //   616: iconst_0
    //   617: aload 10
    //   619: getfield 197	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   622: aastore
    //   623: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   626: aload 10
    //   628: iconst_4
    //   629: putfield 109	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   632: aload 10
    //   634: invokestatic 112	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   637: pop2
    //   638: goto -620 -> 18
    //   641: new 212	android/content/Intent
    //   644: dup
    //   645: invokespecial 213	android/content/Intent:<init>	()V
    //   648: astore 12
    //   650: aload 12
    //   652: invokestatic 219	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   655: ldc 221
    //   657: invokevirtual 225	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   660: pop
    //   661: aload 12
    //   663: getstatic 228	com/tencent/mm/plugin/downloader/model/FileDownloadService:EXTRA_ID	Ljava/lang/String;
    //   666: aload 10
    //   668: getfield 231	com/tencent/mm/plugin/downloader/g/a:field_downloadId	J
    //   671: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   674: pop
    //   675: aload 12
    //   677: getstatic 238	com/tencent/mm/plugin/downloader/model/FileDownloadService:kYT	Ljava/lang/String;
    //   680: iconst_1
    //   681: invokevirtual 241	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   684: pop
    //   685: aload 12
    //   687: invokestatic 247	com/tencent/mm/bq/d:aG	(Landroid/content/Intent;)V
    //   690: goto -326 -> 364
    //   693: sipush 2454
    //   696: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   699: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	700	0	this	3
    //   255	328	1	i	int
    //   265	119	2	j	int
    //   275	127	3	k	int
    //   244	69	4	m	int
    //   41	9	5	l	long
    //   16	13	7	localIterator	java.util.Iterator
    //   154	5	7	localException1	java.lang.Exception
    //   47	523	8	locali	i
    //   54	521	9	localLong	java.lang.Long
    //   71	596	10	locala	com.tencent.mm.plugin.downloader.g.a
    //   85	32	11	localObject	Object
    //   173	227	11	localException2	java.lang.Exception
    //   438	36	12	localException3	java.lang.Exception
    //   648	38	12	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   6	18	154	java/lang/Exception
    //   18	73	154	java/lang/Exception
    //   78	104	154	java/lang/Exception
    //   121	151	154	java/lang/Exception
    //   175	222	154	java/lang/Exception
    //   225	276	154	java/lang/Exception
    //   364	371	154	java/lang/Exception
    //   440	482	154	java/lang/Exception
    //   104	116	173	java/lang/Exception
    //   282	312	438	java/lang/Exception
    //   379	392	438	java/lang/Exception
    //   397	410	438	java/lang/Exception
    //   410	435	438	java/lang/Exception
    //   485	527	438	java/lang/Exception
    //   530	566	438	java/lang/Exception
    //   569	580	438	java/lang/Exception
    //   585	607	438	java/lang/Exception
    //   607	638	438	java/lang/Exception
    //   641	690	438	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.i.3
 * JD-Core Version:    0.7.0.1
 */