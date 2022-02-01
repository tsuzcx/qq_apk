package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.av.d;
import java.io.File;

public final class l
{
  /* Error */
  private static String bp(Context paramContext)
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
    //   98: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   208: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  static String bq(Context paramContext)
  {
    AppMethodBeat.i(211729);
    if ("com.tencent.mm:isolated_process0".equalsIgnoreCase(bp(paramContext)))
    {
      AppMethodBeat.o(211729);
      return "/sdcard";
    }
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath();
    AppMethodBeat.o(211729);
    return paramContext;
  }
  
  public static String f(Application paramApplication)
  {
    AppMethodBeat.i(211726);
    final String str = bp(paramApplication.getApplicationContext());
    if (!"com.tencent.mm:cuploader".equals(str))
    {
      av.a(new av.d()
      {
        /* Error */
        public final void b(av paramAnonymousav, String paramAnonymousString, java.lang.Throwable paramAnonymousThrowable)
        {
          // Byte code:
          //   0: ldc 30
          //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 38
          //   7: ldc 40
          //   9: invokestatic 46	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   12: aload_0
          //   13: getfield 19	com/tencent/mm/app/l$1:cTy	Landroid/app/Application;
          //   16: astore 6
          //   18: aload_0
          //   19: getfield 21	com/tencent/mm/app/l$1:cUJ	Ljava/lang/String;
          //   22: astore 4
          //   24: ldc 38
          //   26: ldc 48
          //   28: aload_2
          //   29: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   32: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   35: invokestatic 46	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
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
          //   72: getstatic 77	com/tencent/mm/loader/j/a:hju	Ljava/lang/String;
          //   75: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   78: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   81: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   84: getstatic 94	com/tencent/mm/sdk/platformtools/j:DEBUG	Z
          //   87: ifeq +748 -> 835
          //   90: aload 8
          //   92: ldc 96
          //   94: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   97: aload 6
          //   99: ldc 98
          //   101: invokestatic 102	com/tencent/mm/app/l:p	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
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
          //   188: invokestatic 140	com/tencent/mm/sdk/platformtools/bu:fpO	()J
          //   191: getstatic 146	com/tencent/mm/app/d:cUa	J
          //   194: lsub
          //   195: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   198: ldc 151
          //   200: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   203: astore 5
          //   205: aload 4
          //   207: ifnonnull +662 -> 869
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
          //   232: getstatic 94	com/tencent/mm/sdk/platformtools/j:DEBUG	Z
          //   235: ifeq +640 -> 875
          //   238: aload 8
          //   240: ldc 157
          //   242: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   245: invokestatic 163	android/os/Environment:getDataDirectory	()Ljava/io/File;
          //   248: invokestatic 169	com/tencent/mm/vfs/k:W	(Ljava/io/File;)Lcom/tencent/mm/vfs/k;
          //   251: astore_1
          //   252: new 171	android/os/StatFs
          //   255: dup
          //   256: aload_1
          //   257: getfield 175	com/tencent/mm/vfs/k:mUri	Landroid/net/Uri;
          //   260: invokestatic 181	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
          //   263: invokespecial 182	android/os/StatFs:<init>	(Ljava/lang/String;)V
          //   266: astore 5
          //   268: new 171	android/os/StatFs
          //   271: dup
          //   272: aload 6
          //   274: invokestatic 186	com/tencent/mm/app/l:bq	(Landroid/content/Context;)Ljava/lang/String;
          //   277: invokespecial 182	android/os/StatFs:<init>	(Ljava/lang/String;)V
          //   280: astore 9
          //   282: ldc 188
          //   284: bipush 10
          //   286: anewarray 4	java/lang/Object
          //   289: dup
          //   290: iconst_0
          //   291: aload 6
          //   293: ldc 190
          //   295: invokevirtual 196	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   298: checkcast 198	android/app/ActivityManager
          //   301: invokevirtual 201	android/app/ActivityManager:getMemoryClass	()I
          //   304: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   307: aastore
          //   308: dup
          //   309: iconst_1
          //   310: aload 6
          //   312: ldc 190
          //   314: invokevirtual 196	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   317: checkcast 198	android/app/ActivityManager
          //   320: invokevirtual 207	android/app/ActivityManager:getLargeMemoryClass	()I
          //   323: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   326: aastore
          //   327: dup
          //   328: iconst_2
          //   329: aload_1
          //   330: invokevirtual 211	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
          //   333: invokestatic 181	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
          //   336: aastore
          //   337: dup
          //   338: iconst_3
          //   339: aload 5
          //   341: invokevirtual 214	android/os/StatFs:getBlockSize	()I
          //   344: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   347: aastore
          //   348: dup
          //   349: iconst_4
          //   350: aload 5
          //   352: invokevirtual 217	android/os/StatFs:getBlockCount	()I
          //   355: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   358: aastore
          //   359: dup
          //   360: iconst_5
          //   361: aload 5
          //   363: invokevirtual 220	android/os/StatFs:getAvailableBlocks	()I
          //   366: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   369: aastore
          //   370: dup
          //   371: bipush 6
          //   373: aload 6
          //   375: invokestatic 186	com/tencent/mm/app/l:bq	(Landroid/content/Context;)Ljava/lang/String;
          //   378: aastore
          //   379: dup
          //   380: bipush 7
          //   382: aload 9
          //   384: invokevirtual 214	android/os/StatFs:getBlockSize	()I
          //   387: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   390: aastore
          //   391: dup
          //   392: bipush 8
          //   394: aload 9
          //   396: invokevirtual 217	android/os/StatFs:getBlockCount	()I
          //   399: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   402: aastore
          //   403: dup
          //   404: bipush 9
          //   406: aload 9
          //   408: invokevirtual 220	android/os/StatFs:getAvailableBlocks	()I
          //   411: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   414: aastore
          //   415: invokestatic 224	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   418: astore_1
          //   419: aload_3
          //   420: invokestatic 229	com/tencent/mm/app/af:e	(Ljava/lang/Throwable;)V
          //   423: aload 8
          //   425: ldc 231
          //   427: aload_1
          //   428: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   431: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   434: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   437: new 233	java/util/Date
          //   440: dup
          //   441: invokespecial 234	java/util/Date:<init>	()V
          //   444: astore_1
          //   445: new 236	java/text/SimpleDateFormat
          //   448: dup
          //   449: ldc 238
          //   451: invokestatic 244	java/util/Locale:getDefault	()Ljava/util/Locale;
          //   454: invokespecial 247	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
          //   457: astore_3
          //   458: aload 8
          //   460: new 60	java/lang/StringBuilder
          //   463: dup
          //   464: ldc 249
          //   466: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   469: aload_3
          //   470: aload_1
          //   471: invokevirtual 252	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
          //   474: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   477: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   480: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   483: aload 8
          //   485: ldc 254
          //   487: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   490: aload_2
          //   491: astore_1
          //   492: aload 6
          //   494: invokestatic 260	com/tencent/mm/app/h:bn	(Landroid/content/Context;)I
          //   497: iconst_1
          //   498: if_icmpne +14 -> 512
          //   501: aload_2
          //   502: iconst_0
          //   503: aload 6
          //   505: invokestatic 263	com/tencent/mm/app/h:bo	(Landroid/content/Context;)I
          //   508: invokevirtual 267	java/lang/String:substring	(II)Ljava/lang/String;
          //   511: astore_1
          //   512: aload 6
          //   514: aload 4
          //   516: ldc_w 269
          //   519: invokestatic 273	com/tencent/mm/app/h:d	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
          //   522: aload 8
          //   524: aload_1
          //   525: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   528: ldc 38
          //   530: ldc_w 275
          //   533: aload_1
          //   534: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   537: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   540: invokestatic 46	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   543: new 277	android/content/Intent
          //   546: dup
          //   547: invokespecial 278	android/content/Intent:<init>	()V
          //   550: astore_1
          //   551: aload_1
          //   552: ldc_w 280
          //   555: invokevirtual 284	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
          //   558: pop
          //   559: aload_1
          //   560: ldc_w 286
          //   563: aload 6
          //   565: new 60	java/lang/StringBuilder
          //   568: dup
          //   569: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   572: aload 6
          //   574: invokevirtual 289	android/content/Context:getPackageName	()Ljava/lang/String;
          //   577: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   580: ldc_w 291
          //   583: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   586: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   589: iconst_0
          //   590: invokevirtual 295	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
          //   593: ldc_w 297
          //   596: ldc_w 299
          //   599: invokeinterface 305 3 0
          //   604: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   607: pop
          //   608: aload_1
          //   609: ldc_w 311
          //   612: aload 7
          //   614: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   617: invokevirtual 315	java/lang/String:getBytes	()[B
          //   620: iconst_2
          //   621: invokestatic 321	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
          //   624: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   627: pop
          //   628: aload_1
          //   629: ldc_w 323
          //   632: new 60	java/lang/StringBuilder
          //   635: dup
          //   636: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   639: aload 6
          //   641: invokevirtual 326	android/content/Context:getFilesDir	()Ljava/io/File;
          //   644: invokevirtual 331	java/io/File:getParentFile	()Ljava/io/File;
          //   647: invokevirtual 334	java/io/File:getAbsolutePath	()Ljava/lang/String;
          //   650: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   653: ldc_w 336
          //   656: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   659: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   662: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   665: pop
          //   666: aload_1
          //   667: ldc_w 338
          //   670: new 60	java/lang/StringBuilder
          //   673: dup
          //   674: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   677: aload 6
          //   679: invokestatic 186	com/tencent/mm/app/l:bq	(Landroid/content/Context;)Ljava/lang/String;
          //   682: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   685: ldc_w 340
          //   688: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   691: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   694: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   697: pop
          //   698: aload_1
          //   699: ldc_w 342
          //   702: aload 6
          //   704: ldc 98
          //   706: invokestatic 102	com/tencent/mm/app/l:p	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
          //   709: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   712: pop
          //   713: aload_1
          //   714: ldc_w 344
          //   717: getstatic 77	com/tencent/mm/loader/j/a:hju	Ljava/lang/String;
          //   720: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   723: pop
          //   724: aload_1
          //   725: ldc_w 346
          //   728: getstatic 349	com/tencent/mm/loader/j/a:hjv	Ljava/lang/String;
          //   731: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   734: pop
          //   735: aload_1
          //   736: ldc_w 351
          //   739: ldc_w 353
          //   742: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   745: pop
          //   746: aload 6
          //   748: ldc_w 355
          //   751: iconst_0
          //   752: invokevirtual 295	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
          //   755: astore_2
          //   756: aload_1
          //   757: ldc_w 357
          //   760: new 60	java/lang/StringBuilder
          //   763: dup
          //   764: ldc_w 359
          //   767: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   770: aload_2
          //   771: ldc_w 361
          //   774: ldc_w 361
          //   777: invokeinterface 305 3 0
          //   782: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   785: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   788: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   791: pop
          //   792: aload_1
          //   793: aload 6
          //   795: new 60	java/lang/StringBuilder
          //   798: dup
          //   799: invokespecial 107	java/lang/StringBuilder:<init>	()V
          //   802: aload 6
          //   804: invokevirtual 289	android/content/Context:getPackageName	()Ljava/lang/String;
          //   807: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   810: ldc_w 363
          //   813: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   816: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   819: invokevirtual 367	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
          //   822: pop
          //   823: aload 6
          //   825: aload_1
          //   826: invokevirtual 371	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
          //   829: ldc 30
          //   831: invokestatic 374	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   834: return
          //   835: aload 8
          //   837: new 60	java/lang/StringBuilder
          //   840: dup
          //   841: ldc_w 376
          //   844: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   847: invokestatic 379	com/tencent/mm/loader/j/a:arV	()Ljava/lang/String;
          //   850: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   853: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   856: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   859: goto -762 -> 97
          //   862: astore_1
          //   863: ldc 30
          //   865: invokestatic 374	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   868: return
          //   869: aload 4
          //   871: astore_1
          //   872: goto -659 -> 213
          //   875: aload 8
          //   877: new 60	java/lang/StringBuilder
          //   880: dup
          //   881: ldc_w 381
          //   884: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   887: getstatic 384	com/tencent/mm/loader/j/a:TIME	Ljava/lang/String;
          //   890: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   893: ldc_w 386
          //   896: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   899: getstatic 389	com/tencent/mm/loader/j/a:HOSTNAME	Ljava/lang/String;
          //   902: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   905: ldc_w 391
          //   908: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   911: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   914: invokevirtual 88	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   917: goto -672 -> 245
          //   920: astore_1
          //   921: ldc 153
          //   923: astore_1
          //   924: goto -505 -> 419
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	927	0	this	1
          //   0	927	1	paramAnonymousav	av
          //   0	927	2	paramAnonymousString	String
          //   0	927	3	paramAnonymousThrowable	java.lang.Throwable
          //   22	848	4	str	String
          //   104	258	5	localObject	Object
          //   16	808	6	localApplication	Application
          //   48	565	7	localStringBuilder	java.lang.StringBuilder
          //   59	817	8	localStringBuilderPrinter	android.util.StringBuilderPrinter
          //   280	127	9	localStatFs	android.os.StatFs
          // Exception table:
          //   from	to	target	type
          //   38	97	862	java/lang/Exception
          //   97	106	862	java/lang/Exception
          //   114	124	862	java/lang/Exception
          //   124	165	862	java/lang/Exception
          //   165	205	862	java/lang/Exception
          //   213	245	862	java/lang/Exception
          //   419	490	862	java/lang/Exception
          //   492	512	862	java/lang/Exception
          //   512	829	862	java/lang/Exception
          //   835	859	862	java/lang/Exception
          //   875	917	862	java/lang/Exception
          //   245	419	920	java/lang/Exception
        }
      });
      av.a(new av.a()
      {
        public final void Mc()
        {
          String str = a.hjw;
        }
      });
    }
    AppMethodBeat.o(211726);
    return str;
  }
  
  static String p(Context paramContext, String paramString)
  {
    AppMethodBeat.i(211728);
    paramContext = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("last_login_uin", paramString);
    AppMethodBeat.o(211728);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.l
 * JD-Core Version:    0.7.0.1
 */