package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IAfterReport;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter;
import java.io.File;

public final class l
{
  /* Error */
  private static String bI(Context paramContext)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 27	android/os/Process:myPid	()I
    //   8: istore_1
    //   9: aload_0
    //   10: ldc 29
    //   12: invokevirtual 35	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 37	android/app/ActivityManager
    //   18: invokevirtual 41	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 45	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: astore_0
    //   28: aload 4
    //   30: invokeinterface 51 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 57 1 0
    //   44: ifeq +57 -> 101
    //   47: aload 4
    //   49: invokeinterface 61 1 0
    //   54: checkcast 63	android/app/ActivityManager$RunningAppProcessInfo
    //   57: astore 5
    //   59: aload 5
    //   61: getfield 67	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   64: iload_1
    //   65: if_icmpne -28 -> 37
    //   68: aload_0
    //   69: aload 5
    //   71: getfield 71	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   74: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -40 -> 37
    //   80: aload 5
    //   82: getfield 71	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: ldc 15
    //   88: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: ldc 82
    //   96: ldc 84
    //   98: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: sipush 128
    //   104: newarray byte
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: new 92	java/io/FileInputStream
    //   114: dup
    //   115: new 94	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 96
    //   121: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: iload_1
    //   125: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc 106
    //   130: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   139: astore_0
    //   140: aload_0
    //   141: aload 5
    //   143: invokevirtual 117	java/io/FileInputStream:read	([B)I
    //   146: istore_3
    //   147: iload_3
    //   148: ifle +40 -> 188
    //   151: iconst_0
    //   152: istore_1
    //   153: goto +142 -> 295
    //   156: new 73	java/lang/String
    //   159: dup
    //   160: aload 5
    //   162: iconst_0
    //   163: iload_2
    //   164: invokespecial 120	java/lang/String:<init>	([BII)V
    //   167: astore 4
    //   169: aload_0
    //   170: invokevirtual 124	java/io/FileInputStream:close	()V
    //   173: ldc 15
    //   175: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload 4
    //   180: areturn
    //   181: iload_1
    //   182: iconst_1
    //   183: iadd
    //   184: istore_1
    //   185: goto +110 -> 295
    //   188: aload_0
    //   189: invokevirtual 124	java/io/FileInputStream:close	()V
    //   192: ldc 15
    //   194: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: ldc 126
    //   199: areturn
    //   200: astore_0
    //   201: aload 4
    //   203: astore_0
    //   204: ldc 82
    //   206: ldc 128
    //   208: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_0
    //   212: ifnull -20 -> 192
    //   215: aload_0
    //   216: invokevirtual 124	java/io/FileInputStream:close	()V
    //   219: goto -27 -> 192
    //   222: astore_0
    //   223: goto -31 -> 192
    //   226: astore_0
    //   227: aconst_null
    //   228: astore 4
    //   230: aload 4
    //   232: ifnull +8 -> 240
    //   235: aload 4
    //   237: invokevirtual 124	java/io/FileInputStream:close	()V
    //   240: ldc 15
    //   242: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: goto -75 -> 173
    //   251: astore_0
    //   252: goto -60 -> 192
    //   255: astore 4
    //   257: goto -17 -> 240
    //   260: astore 4
    //   262: aload_0
    //   263: astore 5
    //   265: aload 4
    //   267: astore_0
    //   268: aload 5
    //   270: astore 4
    //   272: goto -42 -> 230
    //   275: astore 4
    //   277: aload_0
    //   278: astore 5
    //   280: aload 4
    //   282: astore_0
    //   283: aload 5
    //   285: astore 4
    //   287: goto -57 -> 230
    //   290: astore 4
    //   292: goto -88 -> 204
    //   295: iload_3
    //   296: istore_2
    //   297: iload_1
    //   298: iload_3
    //   299: if_icmpge -143 -> 156
    //   302: aload 5
    //   304: iload_1
    //   305: baload
    //   306: ifgt -125 -> 181
    //   309: iload_1
    //   310: istore_2
    //   311: goto -155 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramContext	Context
    //   8	302	1	i	int
    //   163	148	2	j	int
    //   146	154	3	k	int
    //   21	215	4	localObject1	Object
    //   255	1	4	localIOException	java.io.IOException
    //   260	6	4	localObject2	Object
    //   270	1	4	localObject3	Object
    //   275	6	4	localObject4	Object
    //   285	1	4	localObject5	Object
    //   290	1	4	localException	java.lang.Exception
    //   57	246	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   9	37	93	java/lang/Exception
    //   37	86	93	java/lang/Exception
    //   111	140	200	java/lang/Exception
    //   215	219	222	java/io/IOException
    //   111	140	226	finally
    //   169	173	247	java/io/IOException
    //   188	192	251	java/io/IOException
    //   235	240	255	java/io/IOException
    //   140	147	260	finally
    //   156	169	260	finally
    //   204	211	275	finally
    //   140	147	290	java/lang/Exception
    //   156	169	290	java/lang/Exception
  }
  
  static String bJ(Context paramContext)
  {
    AppMethodBeat.i(248949);
    if ("com.tencent.mm:isolated_process0".equalsIgnoreCase(bI(paramContext)))
    {
      AppMethodBeat.o(248949);
      return "/sdcard";
    }
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath();
    AppMethodBeat.o(248949);
    return paramContext;
  }
  
  public static String g(Application paramApplication)
  {
    AppMethodBeat.i(248943);
    final String str = bI(paramApplication.getApplicationContext());
    if (!(MMApplicationContext.getApplicationId() + ":cuploader").equals(str))
    {
      MMUncaughtExceptionHandler.setReporter(new MMUncaughtExceptionHandler.IReporter()
      {
        /* Error */
        public final void reportException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, java.lang.Throwable paramAnonymousThrowable)
        {
          // Byte code:
          //   0: ldc 30
          //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 38
          //   7: ldc 40
          //   9: invokestatic 46	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   12: aload_0
          //   13: getfield 19	com/tencent/mm/app/l$1:fbw	Landroid/app/Application;
          //   16: astore 6
          //   18: aload_0
          //   19: getfield 21	com/tencent/mm/app/l$1:fcJ	Ljava/lang/String;
          //   22: astore 4
          //   24: ldc 38
          //   26: ldc 48
          //   28: aload_2
          //   29: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   32: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   35: invokestatic 46	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   38: new 60	java/lang/StringBuilder
          //   41: dup
          //   42: sipush 2560
          //   45: invokespecial 62	java/lang/StringBuilder:<init>	(I)V
          //   48: astore 7
          //   50: new 64	android/util/StringBuilderPrinter
          //   53: dup
          //   54: aload 7
          //   56: invokespecial 67	android/util/StringBuilderPrinter:<init>	(Ljava/lang/StringBuilder;)V
          //   59: astore 8
          //   61: aload 8
          //   63: new 60	java/lang/StringBuilder
          //   66: dup
          //   67: ldc 69
          //   69: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   72: getstatic 77	com/tencent/mm/loader/j/a:CLIENT_VERSION	Ljava/lang/String;
          //   75: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   78: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   81: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   84: getstatic 94	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
          //   87: ifeq +745 -> 832
          //   90: aload 8
          //   92: ldc 96
          //   94: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   97: aload 6
          //   99: ldc 98
          //   101: invokestatic 102	com/tencent/mm/app/l:r	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
          //   104: astore 5
          //   106: aload 5
          //   108: ifnull +16 -> 124
          //   111: aload 5
          //   113: astore_1
          //   114: aload 5
          //   116: ldc 98
          //   118: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   121: ifeq +44 -> 165
          //   124: new 60	java/lang/StringBuilder
          //   127: dup
          //   128: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   131: getstatic 112	android/os/Build:DEVICE	Ljava/lang/String;
          //   134: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   137: getstatic 115	android/os/Build:FINGERPRINT	Ljava/lang/String;
          //   140: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   143: getstatic 118	android/os/Build:MANUFACTURER	Ljava/lang/String;
          //   146: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   149: getstatic 121	android/os/Build:MODEL	Ljava/lang/String;
          //   152: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   155: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   158: invokevirtual 125	java/lang/String:hashCode	()I
          //   161: invokestatic 130	java/lang/Integer:toString	(I)Ljava/lang/String;
          //   164: astore_1
          //   165: aload 8
          //   167: ldc 132
          //   169: aload_1
          //   170: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   173: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   176: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   179: new 60	java/lang/StringBuilder
          //   182: dup
          //   183: ldc 134
          //   185: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   188: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
          //   191: getstatic 146	com/tencent/mm/app/d:fcc	J
          //   194: lsub
          //   195: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   198: ldc 151
          //   200: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   203: astore 5
          //   205: aload 4
          //   207: ifnonnull +659 -> 866
          //   210: ldc 153
          //   212: astore_1
          //   213: aload 8
          //   215: aload 5
          //   217: aload_1
          //   218: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   221: ldc 155
          //   223: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   226: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   229: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   232: getstatic 94	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
          //   235: ifeq +637 -> 872
          //   238: aload 8
          //   240: ldc 157
          //   242: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   245: invokestatic 163	android/os/Environment:getDataDirectory	()Ljava/io/File;
          //   248: invokestatic 169	com/tencent/mm/vfs/q:Q	(Ljava/io/File;)Lcom/tencent/mm/vfs/q;
          //   251: astore_1
          //   252: new 171	android/os/StatFs
          //   255: dup
          //   256: aload_1
          //   257: invokevirtual 174	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
          //   260: invokespecial 175	android/os/StatFs:<init>	(Ljava/lang/String;)V
          //   263: astore 5
          //   265: new 171	android/os/StatFs
          //   268: dup
          //   269: aload 6
          //   271: invokestatic 179	com/tencent/mm/app/l:bJ	(Landroid/content/Context;)Ljava/lang/String;
          //   274: invokespecial 175	android/os/StatFs:<init>	(Ljava/lang/String;)V
          //   277: astore 9
          //   279: ldc 181
          //   281: bipush 10
          //   283: anewarray 4	java/lang/Object
          //   286: dup
          //   287: iconst_0
          //   288: aload 6
          //   290: ldc 183
          //   292: invokevirtual 189	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   295: checkcast 191	android/app/ActivityManager
          //   298: invokevirtual 194	android/app/ActivityManager:getMemoryClass	()I
          //   301: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   304: aastore
          //   305: dup
          //   306: iconst_1
          //   307: aload 6
          //   309: ldc 183
          //   311: invokevirtual 189	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   314: checkcast 191	android/app/ActivityManager
          //   317: invokevirtual 200	android/app/ActivityManager:getLargeMemoryClass	()I
          //   320: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   323: aastore
          //   324: dup
          //   325: iconst_2
          //   326: aload_1
          //   327: invokevirtual 203	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
          //   330: aastore
          //   331: dup
          //   332: iconst_3
          //   333: aload 5
          //   335: invokevirtual 206	android/os/StatFs:getBlockSize	()I
          //   338: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   341: aastore
          //   342: dup
          //   343: iconst_4
          //   344: aload 5
          //   346: invokevirtual 209	android/os/StatFs:getBlockCount	()I
          //   349: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   352: aastore
          //   353: dup
          //   354: iconst_5
          //   355: aload 5
          //   357: invokevirtual 212	android/os/StatFs:getAvailableBlocks	()I
          //   360: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   363: aastore
          //   364: dup
          //   365: bipush 6
          //   367: aload 6
          //   369: invokestatic 179	com/tencent/mm/app/l:bJ	(Landroid/content/Context;)Ljava/lang/String;
          //   372: aastore
          //   373: dup
          //   374: bipush 7
          //   376: aload 9
          //   378: invokevirtual 206	android/os/StatFs:getBlockSize	()I
          //   381: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   384: aastore
          //   385: dup
          //   386: bipush 8
          //   388: aload 9
          //   390: invokevirtual 209	android/os/StatFs:getBlockCount	()I
          //   393: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   396: aastore
          //   397: dup
          //   398: bipush 9
          //   400: aload 9
          //   402: invokevirtual 212	android/os/StatFs:getAvailableBlocks	()I
          //   405: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   408: aastore
          //   409: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   412: astore_1
          //   413: aload_3
          //   414: invokestatic 221	com/tencent/mm/app/ah:e	(Ljava/lang/Throwable;)V
          //   417: aload 8
          //   419: ldc 223
          //   421: aload_1
          //   422: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   425: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   428: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   431: new 225	java/util/Date
          //   434: dup
          //   435: invokespecial 226	java/util/Date:<init>	()V
          //   438: astore_1
          //   439: new 228	java/text/SimpleDateFormat
          //   442: dup
          //   443: ldc 230
          //   445: invokestatic 236	java/util/Locale:getDefault	()Ljava/util/Locale;
          //   448: invokespecial 239	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
          //   451: astore_3
          //   452: aload 8
          //   454: new 60	java/lang/StringBuilder
          //   457: dup
          //   458: ldc 241
          //   460: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   463: aload_3
          //   464: aload_1
          //   465: invokevirtual 244	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
          //   468: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   471: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   474: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   477: aload 8
          //   479: ldc 246
          //   481: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   484: aload_2
          //   485: astore_1
          //   486: aload 6
          //   488: invokestatic 252	com/tencent/mm/app/h:bG	(Landroid/content/Context;)I
          //   491: iconst_1
          //   492: if_icmpne +14 -> 506
          //   495: aload_2
          //   496: iconst_0
          //   497: aload 6
          //   499: invokestatic 255	com/tencent/mm/app/h:bH	(Landroid/content/Context;)I
          //   502: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
          //   505: astore_1
          //   506: aload 6
          //   508: aload 4
          //   510: ldc_w 261
          //   513: invokestatic 265	com/tencent/mm/app/h:d	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
          //   516: aload 8
          //   518: aload_1
          //   519: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   522: ldc 38
          //   524: ldc_w 267
          //   527: aload_1
          //   528: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   531: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   534: invokestatic 46	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   537: new 269	android/content/Intent
          //   540: dup
          //   541: invokespecial 270	android/content/Intent:<init>	()V
          //   544: astore_1
          //   545: aload_1
          //   546: ldc_w 272
          //   549: invokevirtual 276	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
          //   552: pop
          //   553: aload_1
          //   554: ldc_w 278
          //   557: aload 6
          //   559: new 60	java/lang/StringBuilder
          //   562: dup
          //   563: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   566: aload 6
          //   568: invokevirtual 281	android/content/Context:getPackageName	()Ljava/lang/String;
          //   571: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   574: ldc_w 283
          //   577: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   580: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   583: iconst_0
          //   584: invokevirtual 287	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
          //   587: ldc_w 289
          //   590: ldc_w 291
          //   593: invokeinterface 297 3 0
          //   598: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   601: pop
          //   602: aload_1
          //   603: ldc_w 303
          //   606: aload 7
          //   608: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   611: invokevirtual 307	java/lang/String:getBytes	()[B
          //   614: iconst_2
          //   615: invokestatic 313	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
          //   618: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   621: pop
          //   622: aload_1
          //   623: ldc_w 315
          //   626: new 60	java/lang/StringBuilder
          //   629: dup
          //   630: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   633: aload 6
          //   635: invokevirtual 318	android/content/Context:getFilesDir	()Ljava/io/File;
          //   638: invokevirtual 323	java/io/File:getParentFile	()Ljava/io/File;
          //   641: invokevirtual 326	java/io/File:getAbsolutePath	()Ljava/lang/String;
          //   644: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   647: ldc_w 328
          //   650: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   653: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   656: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   659: pop
          //   660: aload_1
          //   661: ldc_w 330
          //   664: new 60	java/lang/StringBuilder
          //   667: dup
          //   668: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   671: aload 6
          //   673: invokestatic 179	com/tencent/mm/app/l:bJ	(Landroid/content/Context;)Ljava/lang/String;
          //   676: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   679: ldc_w 332
          //   682: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   685: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   688: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   691: pop
          //   692: aload_1
          //   693: ldc_w 334
          //   696: aload 6
          //   698: ldc 98
          //   700: invokestatic 102	com/tencent/mm/app/l:r	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
          //   703: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   706: pop
          //   707: aload_1
          //   708: ldc_w 336
          //   711: getstatic 77	com/tencent/mm/loader/j/a:CLIENT_VERSION	Ljava/lang/String;
          //   714: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   717: pop
          //   718: aload_1
          //   719: ldc_w 338
          //   722: getstatic 341	com/tencent/mm/loader/j/a:kQZ	Ljava/lang/String;
          //   725: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   728: pop
          //   729: aload_1
          //   730: ldc_w 343
          //   733: ldc_w 345
          //   736: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   739: pop
          //   740: aload 6
          //   742: ldc_w 347
          //   745: iconst_0
          //   746: invokevirtual 287	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
          //   749: astore_2
          //   750: new 60	java/lang/StringBuilder
          //   753: dup
          //   754: ldc_w 349
          //   757: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   760: astore_3
          //   761: getstatic 354	com/tencent/mm/loader/j/c:kRi	Ljava/lang/String;
          //   764: astore 4
          //   766: aload_1
          //   767: ldc_w 356
          //   770: aload_3
          //   771: aload_2
          //   772: aload 4
          //   774: aload 4
          //   776: invokeinterface 297 3 0
          //   781: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   784: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   787: invokevirtual 301	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   790: pop
          //   791: aload_1
          //   792: aload 6
          //   794: new 60	java/lang/StringBuilder
          //   797: dup
          //   798: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   801: invokestatic 361	com/tencent/mm/sdk/platformtools/MMApplicationContext:getSourcePackageName	()Ljava/lang/String;
          //   804: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   807: ldc_w 363
          //   810: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   813: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   816: invokevirtual 367	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
          //   819: pop
          //   820: aload 6
          //   822: aload_1
          //   823: invokevirtual 371	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
          //   826: ldc 30
          //   828: invokestatic 374	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   831: return
          //   832: aload 8
          //   834: new 60	java/lang/StringBuilder
          //   837: dup
          //   838: ldc_w 376
          //   841: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   844: invokestatic 379	com/tencent/mm/loader/j/a:aSx	()Ljava/lang/String;
          //   847: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   850: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   853: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   856: goto -759 -> 97
          //   859: astore_1
          //   860: ldc 30
          //   862: invokestatic 374	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   865: return
          //   866: aload 4
          //   868: astore_1
          //   869: goto -656 -> 213
          //   872: aload 8
          //   874: new 60	java/lang/StringBuilder
          //   877: dup
          //   878: ldc_w 381
          //   881: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   884: getstatic 384	com/tencent/mm/loader/j/a:TIME	Ljava/lang/String;
          //   887: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   890: ldc_w 386
          //   893: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   896: getstatic 389	com/tencent/mm/loader/j/a:HOSTNAME	Ljava/lang/String;
          //   899: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   902: ldc_w 391
          //   905: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   908: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   911: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   914: goto -669 -> 245
          //   917: astore_1
          //   918: ldc 153
          //   920: astore_1
          //   921: goto -508 -> 413
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	924	0	this	1
          //   0	924	1	paramAnonymousMMUncaughtExceptionHandler	MMUncaughtExceptionHandler
          //   0	924	2	paramAnonymousString	String
          //   0	924	3	paramAnonymousThrowable	java.lang.Throwable
          //   22	845	4	str	String
          //   104	252	5	localObject	Object
          //   16	805	6	localApplication	Application
          //   48	559	7	localStringBuilder	java.lang.StringBuilder
          //   59	814	8	localStringBuilderPrinter	android.util.StringBuilderPrinter
          //   277	124	9	localStatFs	android.os.StatFs
          // Exception table:
          //   from	to	target	type
          //   38	97	859	java/lang/Exception
          //   97	106	859	java/lang/Exception
          //   114	124	859	java/lang/Exception
          //   124	165	859	java/lang/Exception
          //   165	205	859	java/lang/Exception
          //   213	245	859	java/lang/Exception
          //   413	484	859	java/lang/Exception
          //   486	506	859	java/lang/Exception
          //   506	826	859	java/lang/Exception
          //   832	856	859	java/lang/Exception
          //   872	914	859	java/lang/Exception
          //   245	413	917	java/lang/Exception
        }
      });
      MMUncaughtExceptionHandler.setAfterReport(new MMUncaughtExceptionHandler.IAfterReport()
      {
        public final void afterReport()
        {
          String str = a.kRa;
        }
      });
    }
    AppMethodBeat.o(248943);
    return str;
  }
  
  static String r(Context paramContext, String paramString)
  {
    AppMethodBeat.i(248947);
    paramContext = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("last_login_uin", paramString);
    AppMethodBeat.o(248947);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.l
 * JD-Core Version:    0.7.0.1
 */