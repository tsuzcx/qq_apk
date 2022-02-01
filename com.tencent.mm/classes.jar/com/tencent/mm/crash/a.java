package com.tencent.mm.crash;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.nativecrash.NativeCrash.b;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
  implements NativeCrash.b
{
  private static List<a.b> jxG;
  private static boolean sInitialized;
  public CrashMonitorForJni.CrashExtraMessageGetter jxF;
  
  static
  {
    AppMethodBeat.i(202339);
    sInitialized = false;
    jxG = new ArrayList();
    AppMethodBeat.o(202339);
  }
  
  private a()
  {
    AppMethodBeat.i(145679);
    sInitialized = true;
    Object localObject = MMApplicationContext.getContext();
    String str = MMApplicationContext.getProcessName().replace(':', '_');
    localObject = new File(((Context)localObject).getFilesDir(), "crash/NativeCrash_" + str + '_' + System.currentTimeMillis());
    ((File)localObject).getParentFile().mkdirs();
    NativeCrash.bCG(((File)localObject).getAbsolutePath());
    NativeCrash.ikn();
    NativeCrash.LC("Client Version: " + BuildInfo.CLIENT_VERSION);
    NativeCrash.LC("Base Version: " + com.tencent.mm.loader.j.a.CLIENT_VERSION);
    NativeCrash.a(this);
    AppMethodBeat.o(145679);
  }
  
  public static void LC(String paramString)
  {
    AppMethodBeat.i(145680);
    NativeCrash.LC(paramString);
    AppMethodBeat.o(145680);
  }
  
  public static void a(a.b paramb)
  {
    AppMethodBeat.i(202333);
    if (!jxG.contains(paramb)) {
      jxG.add(paramb);
    }
    AppMethodBeat.o(202333);
  }
  
  private static void a(BufferedReader paramBufferedReader, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(175951);
    ArrayList localArrayList1 = new ArrayList();
    String str;
    for (;;)
    {
      str = paramBufferedReader.readLine();
      if ((str == null) || (str.isEmpty())) {
        break;
      }
      i = str.indexOf(" -> ");
      if (i <= 0) {
        break;
      }
      localArrayList1.add(str.substring(i + 4));
    }
    if (localArrayList1.isEmpty())
    {
      AppMethodBeat.o(175951);
      return;
    }
    Collections.sort(localArrayList1);
    ArrayList localArrayList2 = new ArrayList();
    paramBufferedReader = (String)localArrayList1.get(0);
    int k = localArrayList1.size();
    int j = 1;
    int i = 1;
    Object localObject;
    if (j < k)
    {
      localObject = (String)localArrayList1.get(j);
      if (!((String)localObject).equals(paramBufferedReader))
      {
        localArrayList2.add(Pair.create(paramBufferedReader, Integer.valueOf(i)));
        i = 1;
        paramBufferedReader = (BufferedReader)localObject;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    localArrayList2.add(Pair.create(paramBufferedReader, Integer.valueOf(i)));
    Collections.sort(localArrayList2, new a.1());
    paramStringBuilder.append("[File Descriptors]\n");
    if ((str != null) && (str.startsWith("Total: "))) {
      paramStringBuilder.append(str).append('\n');
    }
    paramBufferedReader = localArrayList2.iterator();
    while (paramBufferedReader.hasNext())
    {
      localObject = (Pair)paramBufferedReader.next();
      paramStringBuilder.append('(').append(((Pair)localObject).second).append(") ").append((String)((Pair)localObject).first).append('\n');
    }
    paramStringBuilder.append('\n');
    AppMethodBeat.o(175951);
  }
  
  public static a ayx()
  {
    return c.jxI;
  }
  
  private static void ayy()
  {
    AppMethodBeat.i(202331);
    Iterator localIterator = jxG.iterator();
    while (localIterator.hasNext()) {
      ((a.b)localIterator.next()).ayz();
    }
    AppMethodBeat.o(202331);
  }
  
  public static void b(a.b paramb)
  {
    AppMethodBeat.i(202336);
    jxG.remove(paramb);
    AppMethodBeat.o(202336);
  }
  
  /* Error */
  public static a g(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 263
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   9: lstore_3
    //   10: new 71	java/lang/StringBuilder
    //   13: dup
    //   14: sipush 2048
    //   17: invokespecial 265	java/lang/StringBuilder:<init>	(I)V
    //   20: astore 6
    //   22: new 267	java/io/FileReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 268	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: astore 7
    //   32: aconst_null
    //   33: astore 5
    //   35: sipush 2048
    //   38: invokestatic 274	java/nio/CharBuffer:allocate	(I)Ljava/nio/CharBuffer;
    //   41: astore_1
    //   42: aload 7
    //   44: aload_1
    //   45: invokevirtual 278	java/io/FileReader:read	(Ljava/nio/CharBuffer;)I
    //   48: ifle +50 -> 98
    //   51: aload_1
    //   52: invokevirtual 282	java/nio/CharBuffer:flip	()Ljava/nio/Buffer;
    //   55: pop
    //   56: aload 6
    //   58: aload_1
    //   59: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: invokevirtual 288	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   67: pop
    //   68: goto -26 -> 42
    //   71: astore_2
    //   72: ldc_w 263
    //   75: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_2
    //   79: athrow
    //   80: astore_1
    //   81: aload_2
    //   82: ifnull +332 -> 414
    //   85: aload 7
    //   87: invokevirtual 291	java/io/FileReader:close	()V
    //   90: ldc_w 263
    //   93: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: athrow
    //   98: aload 6
    //   100: bipush 10
    //   102: invokevirtual 83	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 7
    //   108: invokevirtual 291	java/io/FileReader:close	()V
    //   111: new 8	com/tencent/mm/crash/a$a
    //   114: dup
    //   115: invokespecial 292	com/tencent/mm/crash/a$a:<init>	()V
    //   118: astore 5
    //   120: ldc_w 294
    //   123: invokestatic 300	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   126: aload 6
    //   128: invokevirtual 304	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 309	java/util/regex/Matcher:find	()Z
    //   136: ifeq +16 -> 152
    //   139: aload 5
    //   141: aload_1
    //   142: iconst_1
    //   143: invokevirtual 312	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   146: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   149: putfield 321	com/tencent/mm/crash/a$a:jxH	I
    //   152: ldc_w 323
    //   155: invokestatic 300	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   158: aload 6
    //   160: invokevirtual 304	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 309	java/util/regex/Matcher:find	()Z
    //   168: ifeq +254 -> 422
    //   171: aload 5
    //   173: aload_1
    //   174: iconst_1
    //   175: invokevirtual 312	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   178: putfield 326	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   181: iload_0
    //   182: ifeq +22 -> 204
    //   185: aload 6
    //   187: ldc_w 328
    //   190: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: iload_0
    //   194: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc_w 333
    //   200: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc_w 335
    //   207: ldc_w 337
    //   210: iconst_2
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: lload_3
    //   217: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   226: lload_3
    //   227: lsub
    //   228: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: aastore
    //   232: invokestatic 347	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_2
    //   236: ifnull +117 -> 353
    //   239: new 153	java/io/BufferedReader
    //   242: dup
    //   243: new 267	java/io/FileReader
    //   246: dup
    //   247: aload_2
    //   248: invokespecial 268	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   251: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   254: astore 7
    //   256: aconst_null
    //   257: astore_2
    //   258: aload 7
    //   260: invokevirtual 156	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull +197 -> 462
    //   268: iconst_m1
    //   269: istore_0
    //   270: aload_1
    //   271: invokevirtual 353	java/lang/String:hashCode	()I
    //   274: tableswitch	default:+222 -> 496, -539141342:+159->433
    //   293: iconst_3
    //   294: aload_1
    //   295: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: bipush 10
    //   300: invokevirtual 83	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: goto -46 -> 258
    //   307: astore_2
    //   308: ldc_w 263
    //   311: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aload_2
    //   315: athrow
    //   316: astore_1
    //   317: aload_2
    //   318: ifnull +163 -> 481
    //   321: aload 7
    //   323: invokevirtual 354	java/io/BufferedReader:close	()V
    //   326: ldc_w 263
    //   329: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aload_1
    //   333: athrow
    //   334: astore_1
    //   335: aload 6
    //   337: ldc_w 356
    //   340: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_1
    //   344: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   347: bipush 10
    //   349: invokevirtual 83	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 5
    //   355: aload 6
    //   357: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: putfield 359	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   363: ldc_w 335
    //   366: ldc_w 337
    //   369: iconst_2
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: lload_3
    //   376: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   379: aastore
    //   380: dup
    //   381: iconst_1
    //   382: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   385: lload_3
    //   386: lsub
    //   387: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   390: aastore
    //   391: invokestatic 347	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: ldc_w 263
    //   397: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload 5
    //   402: areturn
    //   403: astore 5
    //   405: aload_2
    //   406: aload 5
    //   408: invokevirtual 363	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   411: goto -321 -> 90
    //   414: aload 7
    //   416: invokevirtual 291	java/io/FileReader:close	()V
    //   419: goto -329 -> 90
    //   422: aload 5
    //   424: getstatic 124	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   427: putfield 326	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   430: goto -249 -> 181
    //   433: aload_1
    //   434: ldc_w 365
    //   437: invokevirtual 188	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   440: ifeq +56 -> 496
    //   443: iconst_0
    //   444: istore_0
    //   445: goto +51 -> 496
    //   448: aload 7
    //   450: aload 6
    //   452: invokestatic 367	com/tencent/mm/crash/a:a	(Ljava/io/BufferedReader;Ljava/lang/StringBuilder;)V
    //   455: goto -197 -> 258
    //   458: astore_1
    //   459: goto -142 -> 317
    //   462: aload 7
    //   464: invokevirtual 354	java/io/BufferedReader:close	()V
    //   467: goto -114 -> 353
    //   470: astore 7
    //   472: aload_2
    //   473: aload 7
    //   475: invokevirtual 363	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   478: goto -152 -> 326
    //   481: aload 7
    //   483: invokevirtual 354	java/io/BufferedReader:close	()V
    //   486: goto -160 -> 326
    //   489: astore_1
    //   490: aload 5
    //   492: astore_2
    //   493: goto -412 -> 81
    //   496: iload_0
    //   497: tableswitch	default:+19 -> 516, 0:+-49->448
    //   517: impdep2
    //   518: lload_2
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	paramInt	int
    //   0	519	1	paramString1	String
    //   0	519	2	paramString2	String
    //   9	377	3	l	long
    //   33	368	5	locala	a
    //   403	88	5	localThrowable1	java.lang.Throwable
    //   20	431	6	localStringBuilder	StringBuilder
    //   30	433	7	localObject	Object
    //   470	12	7	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   35	42	71	java/lang/Throwable
    //   42	68	71	java/lang/Throwable
    //   98	106	71	java/lang/Throwable
    //   72	80	80	finally
    //   258	264	307	java/lang/Throwable
    //   270	292	307	java/lang/Throwable
    //   292	304	307	java/lang/Throwable
    //   433	443	307	java/lang/Throwable
    //   448	455	307	java/lang/Throwable
    //   308	316	316	finally
    //   239	256	334	java/io/IOException
    //   321	326	334	java/io/IOException
    //   326	334	334	java/io/IOException
    //   462	467	334	java/io/IOException
    //   472	478	334	java/io/IOException
    //   481	486	334	java/io/IOException
    //   85	90	403	java/lang/Throwable
    //   258	264	458	finally
    //   270	292	458	finally
    //   292	304	458	finally
    //   433	443	458	finally
    //   448	455	458	finally
    //   321	326	470	java/lang/Throwable
    //   35	42	489	finally
    //   42	68	489	finally
    //   98	106	489	finally
  }
  
  /* Error */
  public final boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 370
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokestatic 372	com/tencent/mm/crash/a:g	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/a$a;
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 374	com/tencent/mm/crash/a:jxF	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   18: ifnull +55 -> 73
    //   21: aload_0
    //   22: getfield 374	com/tencent/mm/crash/a:jxF	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   25: invokeinterface 379 1 0
    //   30: astore 5
    //   32: aload 5
    //   34: ifnull +39 -> 73
    //   37: aload 5
    //   39: invokevirtual 159	java/lang/String:isEmpty	()Z
    //   42: ifne +31 -> 73
    //   45: aload 4
    //   47: new 71	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   54: aload 4
    //   56: getfield 359	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   59: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 5
    //   64: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putfield 359	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   73: aload 4
    //   75: getfield 321	com/tencent/mm/crash/a$a:jxH	I
    //   78: aload 4
    //   80: getfield 359	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   83: ldc_w 382
    //   86: invokestatic 388	com/tencent/mm/sdk/crash/CrashReportFactory:reportJniCrash	(ILjava/lang/String;Ljava/lang/String;)V
    //   89: invokestatic 393	com/tencent/recovery/Recovery:crash	()V
    //   92: aload_2
    //   93: ifnull +15 -> 108
    //   96: new 63	java/io/File
    //   99: dup
    //   100: aload_2
    //   101: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 397	java/io/File:delete	()Z
    //   107: pop
    //   108: aload_3
    //   109: ifnull +15 -> 124
    //   112: new 63	java/io/File
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: invokevirtual 397	java/io/File:delete	()Z
    //   123: pop
    //   124: invokestatic 399	com/tencent/mm/crash/a:ayy	()V
    //   127: ldc_w 335
    //   130: ldc_w 401
    //   133: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: new 153	java/io/BufferedReader
    //   139: dup
    //   140: new 267	java/io/FileReader
    //   143: dup
    //   144: new 71	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 407
    //   151: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: invokestatic 412	android/os/Process:myPid	()I
    //   157: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: ldc_w 414
    //   163: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 268	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   172: sipush 1024
    //   175: invokespecial 417	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   178: astore 5
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 5
    //   185: invokevirtual 156	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   188: astore_2
    //   189: aload_2
    //   190: ifnull +89 -> 279
    //   193: ldc_w 335
    //   196: aload_2
    //   197: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -17 -> 183
    //   203: astore 4
    //   205: ldc_w 370
    //   208: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload 4
    //   213: athrow
    //   214: astore_2
    //   215: aload 4
    //   217: ifnull +82 -> 299
    //   220: aload 5
    //   222: invokevirtual 354	java/io/BufferedReader:close	()V
    //   225: ldc_w 370
    //   228: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_2
    //   232: athrow
    //   233: astore_2
    //   234: ldc_w 335
    //   237: aload_2
    //   238: ldc_w 419
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_3
    //   248: aastore
    //   249: invokestatic 423	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
    //   255: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:appenderClose	()V
    //   258: invokestatic 432	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   261: ifeq +10 -> 271
    //   264: invokestatic 438	com/tencent/mm/recoveryv2/l:hqR	()Lcom/tencent/mm/recoveryv2/l;
    //   267: iconst_4
    //   268: invokevirtual 441	com/tencent/mm/recoveryv2/l:arP	(I)V
    //   271: ldc_w 370
    //   274: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload 5
    //   281: invokevirtual 354	java/io/BufferedReader:close	()V
    //   284: goto -32 -> 252
    //   287: astore 5
    //   289: aload 4
    //   291: aload 5
    //   293: invokevirtual 363	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   296: goto -71 -> 225
    //   299: aload 5
    //   301: invokevirtual 354	java/io/BufferedReader:close	()V
    //   304: goto -79 -> 225
    //   307: astore_2
    //   308: goto -93 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	a
    //   0	311	1	paramInt	int
    //   0	311	2	paramString1	String
    //   0	311	3	paramString2	String
    //   12	170	4	locala	a
    //   203	87	4	localThrowable1	java.lang.Throwable
    //   30	250	5	localObject	Object
    //   287	13	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   183	189	203	java/lang/Throwable
    //   193	200	203	java/lang/Throwable
    //   205	214	214	finally
    //   136	180	233	java/io/IOException
    //   220	225	233	java/io/IOException
    //   225	233	233	java/io/IOException
    //   279	284	233	java/io/IOException
    //   289	296	233	java/io/IOException
    //   299	304	233	java/io/IOException
    //   220	225	287	java/lang/Throwable
    //   183	189	307	finally
    //   193	200	307	finally
  }
  
  public static final class a
  {
    public String clientVersion;
    public int jxH;
    public String text;
  }
  
  static final class c
  {
    static a jxI;
    
    static
    {
      AppMethodBeat.i(145678);
      jxI = new a((byte)0);
      AppMethodBeat.o(145678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.crash.a
 * JD-Core Version:    0.7.0.1
 */