package com.tencent.mm.crash;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.nativecrash.NativeCrash.c;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class a
  implements NativeCrash.c
{
  private static boolean sInitialized = false;
  public CrashMonitorForJni.CrashExtraMessageGetter gNl;
  
  private a()
  {
    AppMethodBeat.i(145679);
    sInitialized = true;
    Object localObject = MMApplicationContext.getContext();
    String str = MMApplicationContext.getProcessName().replace(':', '_');
    localObject = new File(((Context)localObject).getFilesDir(), "crash/NativeCrash_" + str + '_' + System.currentTimeMillis());
    ((File)localObject).getParentFile().mkdirs();
    NativeCrash.bpJ(((File)localObject).getAbsolutePath());
    NativeCrash.hiE();
    NativeCrash.EJ("Client Version: " + BuildInfo.CLIENT_VERSION);
    NativeCrash.EJ("Base Version: " + com.tencent.mm.loader.j.a.CLIENT_VERSION);
    NativeCrash.a(this);
    AppMethodBeat.o(145679);
  }
  
  public static void EJ(String paramString)
  {
    AppMethodBeat.i(145680);
    NativeCrash.EJ(paramString);
    AppMethodBeat.o(145680);
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
  
  public static a arO()
  {
    return b.gNn;
  }
  
  /* Error */
  public static a g(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 236
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   8: lstore_3
    //   9: new 57	java/lang/StringBuilder
    //   12: dup
    //   13: sipush 2048
    //   16: invokespecial 238	java/lang/StringBuilder:<init>	(I)V
    //   19: astore 6
    //   21: new 240	java/io/FileReader
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 241	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   29: astore 7
    //   31: aconst_null
    //   32: astore 5
    //   34: sipush 2048
    //   37: invokestatic 247	java/nio/CharBuffer:allocate	(I)Ljava/nio/CharBuffer;
    //   40: astore_1
    //   41: aload 7
    //   43: aload_1
    //   44: invokevirtual 251	java/io/FileReader:read	(Ljava/nio/CharBuffer;)I
    //   47: ifle +48 -> 95
    //   50: aload_1
    //   51: invokevirtual 255	java/nio/CharBuffer:flip	()Ljava/nio/Buffer;
    //   54: pop
    //   55: aload 6
    //   57: aload_1
    //   58: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: invokevirtual 261	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   66: pop
    //   67: goto -26 -> 41
    //   70: astore_2
    //   71: ldc 236
    //   73: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: athrow
    //   78: astore_1
    //   79: aload_2
    //   80: ifnull +327 -> 407
    //   83: aload 7
    //   85: invokevirtual 264	java/io/FileReader:close	()V
    //   88: ldc 236
    //   90: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    //   95: aload 6
    //   97: bipush 10
    //   99: invokevirtual 69	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: invokevirtual 264	java/io/FileReader:close	()V
    //   108: new 8	com/tencent/mm/crash/a$a
    //   111: dup
    //   112: invokespecial 265	com/tencent/mm/crash/a$a:<init>	()V
    //   115: astore 5
    //   117: ldc_w 267
    //   120: invokestatic 273	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   123: aload 6
    //   125: invokevirtual 277	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 282	java/util/regex/Matcher:find	()Z
    //   133: ifeq +16 -> 149
    //   136: aload 5
    //   138: aload_1
    //   139: iconst_1
    //   140: invokevirtual 285	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   143: invokestatic 290	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   146: putfield 294	com/tencent/mm/crash/a$a:gNm	I
    //   149: ldc_w 296
    //   152: invokestatic 273	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   155: aload 6
    //   157: invokevirtual 277	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 282	java/util/regex/Matcher:find	()Z
    //   165: ifeq +250 -> 415
    //   168: aload 5
    //   170: aload_1
    //   171: iconst_1
    //   172: invokevirtual 285	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   175: putfield 299	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   178: iload_0
    //   179: ifeq +22 -> 201
    //   182: aload 6
    //   184: ldc_w 301
    //   187: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_0
    //   191: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 306
    //   197: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc_w 308
    //   204: ldc_w 310
    //   207: iconst_2
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: lload_3
    //   214: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   223: lload_3
    //   224: lsub
    //   225: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   228: aastore
    //   229: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: ifnull +114 -> 347
    //   236: new 134	java/io/BufferedReader
    //   239: dup
    //   240: new 240	java/io/FileReader
    //   243: dup
    //   244: aload_2
    //   245: invokespecial 241	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   248: invokespecial 323	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   251: astore 7
    //   253: aconst_null
    //   254: astore_2
    //   255: aload 7
    //   257: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   260: astore_1
    //   261: aload_1
    //   262: ifnull +193 -> 455
    //   265: iconst_m1
    //   266: istore_0
    //   267: aload_1
    //   268: invokevirtual 326	java/lang/String:hashCode	()I
    //   271: tableswitch	default:+218 -> 489, -539141342:+155->426
    //   289: iconst_3
    //   290: aload_1
    //   291: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: bipush 10
    //   296: invokevirtual 69	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: goto -45 -> 255
    //   303: astore_2
    //   304: ldc 236
    //   306: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_2
    //   310: athrow
    //   311: astore_1
    //   312: aload_2
    //   313: ifnull +161 -> 474
    //   316: aload 7
    //   318: invokevirtual 327	java/io/BufferedReader:close	()V
    //   321: ldc 236
    //   323: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: athrow
    //   328: astore_1
    //   329: aload 6
    //   331: ldc_w 329
    //   334: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_1
    //   338: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: bipush 10
    //   343: invokevirtual 69	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 5
    //   349: aload 6
    //   351: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: putfield 332	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   357: ldc_w 308
    //   360: ldc_w 310
    //   363: iconst_2
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: lload_3
    //   370: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   373: aastore
    //   374: dup
    //   375: iconst_1
    //   376: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   379: lload_3
    //   380: lsub
    //   381: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   384: aastore
    //   385: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc 236
    //   390: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: aload 5
    //   395: areturn
    //   396: astore 5
    //   398: aload_2
    //   399: aload 5
    //   401: invokevirtual 336	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   404: goto -316 -> 88
    //   407: aload 7
    //   409: invokevirtual 264	java/io/FileReader:close	()V
    //   412: goto -324 -> 88
    //   415: aload 5
    //   417: getstatic 110	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   420: putfield 299	com/tencent/mm/crash/a$a:clientVersion	Ljava/lang/String;
    //   423: goto -245 -> 178
    //   426: aload_1
    //   427: ldc_w 338
    //   430: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +56 -> 489
    //   436: iconst_0
    //   437: istore_0
    //   438: goto +51 -> 489
    //   441: aload 7
    //   443: aload 6
    //   445: invokestatic 340	com/tencent/mm/crash/a:a	(Ljava/io/BufferedReader;Ljava/lang/StringBuilder;)V
    //   448: goto -193 -> 255
    //   451: astore_1
    //   452: goto -140 -> 312
    //   455: aload 7
    //   457: invokevirtual 327	java/io/BufferedReader:close	()V
    //   460: goto -113 -> 347
    //   463: astore 7
    //   465: aload_2
    //   466: aload 7
    //   468: invokevirtual 336	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   471: goto -150 -> 321
    //   474: aload 7
    //   476: invokevirtual 327	java/io/BufferedReader:close	()V
    //   479: goto -158 -> 321
    //   482: astore_1
    //   483: aload 5
    //   485: astore_2
    //   486: goto -407 -> 79
    //   489: iload_0
    //   490: tableswitch	default:+18 -> 508, 0:+-49->441
    //   509: impdep2
    //   510: fload_2
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	paramInt	int
    //   0	511	1	paramString1	String
    //   0	511	2	paramString2	String
    //   8	372	3	l	long
    //   32	362	5	locala	a
    //   396	88	5	localThrowable1	java.lang.Throwable
    //   19	425	6	localStringBuilder	StringBuilder
    //   29	427	7	localObject	Object
    //   463	12	7	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   34	41	70	java/lang/Throwable
    //   41	67	70	java/lang/Throwable
    //   95	103	70	java/lang/Throwable
    //   71	78	78	finally
    //   255	261	303	java/lang/Throwable
    //   267	288	303	java/lang/Throwable
    //   288	300	303	java/lang/Throwable
    //   426	436	303	java/lang/Throwable
    //   441	448	303	java/lang/Throwable
    //   304	311	311	finally
    //   236	253	328	java/io/IOException
    //   316	321	328	java/io/IOException
    //   321	328	328	java/io/IOException
    //   455	460	328	java/io/IOException
    //   465	471	328	java/io/IOException
    //   474	479	328	java/io/IOException
    //   83	88	396	java/lang/Throwable
    //   255	261	451	finally
    //   267	288	451	finally
    //   288	300	451	finally
    //   426	436	451	finally
    //   441	448	451	finally
    //   316	321	463	java/lang/Throwable
    //   34	41	482	finally
    //   41	67	482	finally
    //   95	103	482	finally
  }
  
  /* Error */
  public final boolean onCrashDumped(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokestatic 345	com/tencent/mm/crash/a:g	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/a$a;
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 347	com/tencent/mm/crash/a:gNl	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   18: ifnull +55 -> 73
    //   21: aload_0
    //   22: getfield 347	com/tencent/mm/crash/a:gNl	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   25: invokeinterface 352 1 0
    //   30: astore 5
    //   32: aload 5
    //   34: ifnull +39 -> 73
    //   37: aload 5
    //   39: invokevirtual 140	java/lang/String:isEmpty	()Z
    //   42: ifne +31 -> 73
    //   45: aload 4
    //   47: new 57	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   54: aload 4
    //   56: getfield 332	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   59: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 5
    //   64: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putfield 332	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   73: aload 4
    //   75: getfield 294	com/tencent/mm/crash/a$a:gNm	I
    //   78: aload 4
    //   80: getfield 332	com/tencent/mm/crash/a$a:text	Ljava/lang/String;
    //   83: ldc_w 355
    //   86: invokestatic 361	com/tencent/mm/sdk/crash/CrashReportFactory:reportJniCrash	(ILjava/lang/String;Ljava/lang/String;)V
    //   89: invokestatic 366	com/tencent/recovery/Recovery:crash	()V
    //   92: aload_2
    //   93: ifnull +15 -> 108
    //   96: new 49	java/io/File
    //   99: dup
    //   100: aload_2
    //   101: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 370	java/io/File:delete	()Z
    //   107: pop
    //   108: aload_3
    //   109: ifnull +15 -> 124
    //   112: new 49	java/io/File
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 367	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: invokevirtual 370	java/io/File:delete	()Z
    //   123: pop
    //   124: ldc_w 308
    //   127: ldc_w 372
    //   130: invokestatic 376	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: new 134	java/io/BufferedReader
    //   136: dup
    //   137: new 240	java/io/FileReader
    //   140: dup
    //   141: new 57	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 378
    //   148: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: invokestatic 383	android/os/Process:myPid	()I
    //   154: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: ldc_w 385
    //   160: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 241	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   169: sipush 1024
    //   172: invokespecial 388	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   175: astore 5
    //   177: aconst_null
    //   178: astore 4
    //   180: aload 5
    //   182: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +89 -> 276
    //   190: ldc_w 308
    //   193: aload_2
    //   194: invokestatic 376	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: goto -17 -> 180
    //   200: astore 4
    //   202: ldc_w 343
    //   205: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload 4
    //   210: athrow
    //   211: astore_2
    //   212: aload 4
    //   214: ifnull +82 -> 296
    //   217: aload 5
    //   219: invokevirtual 327	java/io/BufferedReader:close	()V
    //   222: ldc_w 343
    //   225: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_2
    //   229: athrow
    //   230: astore_2
    //   231: ldc_w 308
    //   234: aload_2
    //   235: ldc_w 390
    //   238: iconst_1
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload_3
    //   245: aastore
    //   246: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
    //   252: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:appenderClose	()V
    //   255: invokestatic 403	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   258: ifeq +10 -> 268
    //   261: invokestatic 409	com/tencent/mm/recoveryv2/k:guX	()Lcom/tencent/mm/recoveryv2/k;
    //   264: iconst_4
    //   265: invokevirtual 412	com/tencent/mm/recoveryv2/k:ajx	(I)V
    //   268: ldc_w 343
    //   271: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: iconst_0
    //   275: ireturn
    //   276: aload 5
    //   278: invokevirtual 327	java/io/BufferedReader:close	()V
    //   281: goto -32 -> 249
    //   284: astore 5
    //   286: aload 4
    //   288: aload 5
    //   290: invokevirtual 336	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   293: goto -71 -> 222
    //   296: aload 5
    //   298: invokevirtual 327	java/io/BufferedReader:close	()V
    //   301: goto -79 -> 222
    //   304: astore_2
    //   305: goto -93 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	a
    //   0	308	1	paramInt	int
    //   0	308	2	paramString1	String
    //   0	308	3	paramString2	String
    //   12	167	4	locala	a
    //   200	87	4	localThrowable1	java.lang.Throwable
    //   30	247	5	localObject	Object
    //   284	13	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   180	186	200	java/lang/Throwable
    //   190	197	200	java/lang/Throwable
    //   202	211	211	finally
    //   133	177	230	java/io/IOException
    //   217	222	230	java/io/IOException
    //   222	230	230	java/io/IOException
    //   276	281	230	java/io/IOException
    //   286	293	230	java/io/IOException
    //   296	301	230	java/io/IOException
    //   217	222	284	java/lang/Throwable
    //   180	186	304	finally
    //   190	197	304	finally
  }
  
  public static final class a
  {
    public String clientVersion;
    public int gNm;
    public String text;
  }
  
  static final class b
  {
    static a gNn;
    
    static
    {
      AppMethodBeat.i(145678);
      gNn = new a((byte)0);
      AppMethodBeat.o(145678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.crash.a
 * JD-Core Version:    0.7.0.1
 */