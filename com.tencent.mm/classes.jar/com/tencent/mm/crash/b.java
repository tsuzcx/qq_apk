package com.tencent.mm.crash;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.nativecrash.NativeCrash.CrashCallback;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
  implements NativeCrash.CrashCallback
{
  private static List<b.b> mbc;
  private static boolean sInitialized;
  public CrashMonitorForJni.CrashExtraMessageGetter mbb;
  
  static
  {
    AppMethodBeat.i(248410);
    sInitialized = false;
    mbc = new ArrayList();
    AppMethodBeat.o(248410);
  }
  
  private b()
  {
    AppMethodBeat.i(145679);
    sInitialized = true;
    Object localObject = MMApplicationContext.getContext();
    String str = MMApplicationContext.getProcessName().replace(':', '_');
    localObject = new File(((Context)localObject).getFilesDir(), "crash/NativeCrash_" + str + '_' + System.currentTimeMillis());
    ((File)localObject).getParentFile().mkdirs();
    NativeCrash.init(((File)localObject).getAbsolutePath(), 1871, 2048, false);
    NativeCrash.resetCustomInfo();
    NativeCrash.customInfo("Client Version: " + BuildInfo.CLIENT_VERSION);
    NativeCrash.customInfo("Base Version: " + a.CLIENT_VERSION);
    NativeCrash.crashCallback(this);
    AppMethodBeat.o(145679);
  }
  
  public static void a(b.b paramb)
  {
    AppMethodBeat.i(248396);
    if (!mbc.contains(paramb)) {
      mbc.add(paramb);
    }
    AppMethodBeat.o(248396);
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
    if (localArrayList1.size() < 900)
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
    Collections.sort(localArrayList2, new b.1());
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
  
  public static b aTa()
  {
    return c.mbe;
  }
  
  private static void aTb()
  {
    AppMethodBeat.i(248388);
    Iterator localIterator = mbc.iterator();
    while (localIterator.hasNext()) {
      ((b.b)localIterator.next()).aTc();
    }
    AppMethodBeat.o(248388);
  }
  
  public static void b(b.b paramb)
  {
    AppMethodBeat.i(248401);
    mbc.remove(paramb);
    AppMethodBeat.o(248401);
  }
  
  public static void customInfo(String paramString)
  {
    AppMethodBeat.i(145680);
    NativeCrash.customInfo(paramString);
    AppMethodBeat.o(145680);
  }
  
  /* Error */
  public static a i(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 261
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   9: lstore_3
    //   10: new 71	java/lang/StringBuilder
    //   13: dup
    //   14: sipush 2048
    //   17: invokespecial 263	java/lang/StringBuilder:<init>	(I)V
    //   20: astore 5
    //   22: new 265	java/io/FileReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 266	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: sipush 2048
    //   34: invokestatic 272	java/nio/CharBuffer:allocate	(I)Ljava/nio/CharBuffer;
    //   37: astore 6
    //   39: aload_1
    //   40: aload 6
    //   42: invokevirtual 276	java/io/FileReader:read	(Ljava/nio/CharBuffer;)I
    //   45: ifle +39 -> 84
    //   48: aload 6
    //   50: invokevirtual 280	java/nio/CharBuffer:flip	()Ljava/nio/Buffer;
    //   53: pop
    //   54: aload 5
    //   56: aload 6
    //   58: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 6
    //   64: invokevirtual 286	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   67: pop
    //   68: goto -29 -> 39
    //   71: astore_2
    //   72: aload_1
    //   73: invokevirtual 289	java/io/FileReader:close	()V
    //   76: ldc_w 261
    //   79: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_2
    //   83: athrow
    //   84: aload 5
    //   86: bipush 10
    //   88: invokevirtual 83	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_1
    //   93: invokevirtual 289	java/io/FileReader:close	()V
    //   96: new 8	com/tencent/mm/crash/b$a
    //   99: dup
    //   100: invokespecial 290	com/tencent/mm/crash/b$a:<init>	()V
    //   103: astore_1
    //   104: ldc_w 292
    //   107: invokestatic 298	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   110: aload 5
    //   112: invokevirtual 302	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   115: astore 6
    //   117: aload 6
    //   119: invokevirtual 307	java/util/regex/Matcher:find	()Z
    //   122: ifeq +16 -> 138
    //   125: aload_1
    //   126: aload 6
    //   128: iconst_1
    //   129: invokevirtual 310	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   132: invokestatic 315	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   135: putfield 319	com/tencent/mm/crash/b$a:mbd	I
    //   138: ldc_w 321
    //   141: invokestatic 298	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   144: aload 5
    //   146: invokevirtual 302	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   149: astore 6
    //   151: aload 6
    //   153: invokevirtual 307	java/util/regex/Matcher:find	()Z
    //   156: ifeq +231 -> 387
    //   159: aload_1
    //   160: aload 6
    //   162: iconst_1
    //   163: invokevirtual 310	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   166: putfield 324	com/tencent/mm/crash/b$a:clientVersion	Ljava/lang/String;
    //   169: iload_0
    //   170: ifeq +22 -> 192
    //   173: aload 5
    //   175: ldc_w 326
    //   178: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_0
    //   182: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc_w 331
    //   188: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: ldc_w 333
    //   195: ldc_w 335
    //   198: iconst_2
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: lload_3
    //   205: invokestatic 340	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   214: lload_3
    //   215: lsub
    //   216: invokestatic 340	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: aastore
    //   220: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aload_2
    //   224: ifnull +106 -> 330
    //   227: new 154	java/io/BufferedReader
    //   230: dup
    //   231: new 265	java/io/FileReader
    //   234: dup
    //   235: aload_2
    //   236: invokespecial 266	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   239: invokespecial 348	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   247: astore 6
    //   249: aload 6
    //   251: ifnull +171 -> 422
    //   254: iconst_m1
    //   255: istore_0
    //   256: aload 6
    //   258: invokevirtual 351	java/lang/String:hashCode	()I
    //   261: tableswitch	default:+178 -> 439, -539141342:+136->397
    //   281: iconst_2
    //   282: aload 6
    //   284: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: bipush 10
    //   289: invokevirtual 83	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: goto -50 -> 243
    //   296: astore 6
    //   298: aload_2
    //   299: invokevirtual 352	java/io/BufferedReader:close	()V
    //   302: ldc_w 261
    //   305: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 6
    //   310: athrow
    //   311: astore_2
    //   312: aload 5
    //   314: ldc_w 354
    //   317: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_2
    //   321: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: bipush 10
    //   326: invokevirtual 83	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_1
    //   331: aload 5
    //   333: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: putfield 357	com/tencent/mm/crash/b$a:text	Ljava/lang/String;
    //   339: ldc_w 333
    //   342: ldc_w 335
    //   345: iconst_2
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: lload_3
    //   352: invokestatic 340	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   361: lload_3
    //   362: lsub
    //   363: invokestatic 340	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   366: aastore
    //   367: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: ldc_w 261
    //   373: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: aload_1
    //   377: areturn
    //   378: astore_1
    //   379: aload_2
    //   380: aload_1
    //   381: invokevirtual 363	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   384: goto -308 -> 76
    //   387: aload_1
    //   388: getstatic 125	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION	Ljava/lang/String;
    //   391: putfield 324	com/tencent/mm/crash/b$a:clientVersion	Ljava/lang/String;
    //   394: goto -225 -> 169
    //   397: aload 6
    //   399: ldc_w 365
    //   402: invokevirtual 188	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   405: ifeq +34 -> 439
    //   408: iconst_0
    //   409: istore_0
    //   410: goto +29 -> 439
    //   413: aload_2
    //   414: aload 5
    //   416: invokestatic 367	com/tencent/mm/crash/b:a	(Ljava/io/BufferedReader;Ljava/lang/StringBuilder;)V
    //   419: goto -176 -> 243
    //   422: aload_2
    //   423: invokevirtual 352	java/io/BufferedReader:close	()V
    //   426: goto -96 -> 330
    //   429: astore_2
    //   430: aload 6
    //   432: aload_2
    //   433: invokevirtual 363	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   436: goto -134 -> 302
    //   439: iload_0
    //   440: tableswitch	default:+20 -> 460, 0:+-27->413
    //   461: impdep2
    //   462: astore_1
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	paramInt	int
    //   0	463	1	paramString1	String
    //   0	463	2	paramString2	String
    //   9	353	3	l	long
    //   20	395	5	localStringBuilder	StringBuilder
    //   37	246	6	localObject1	Object
    //   296	135	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	39	71	finally
    //   39	68	71	finally
    //   84	92	71	finally
    //   243	249	296	finally
    //   256	280	296	finally
    //   280	293	296	finally
    //   397	408	296	finally
    //   413	419	296	finally
    //   227	243	311	java/io/IOException
    //   302	311	311	java/io/IOException
    //   422	426	311	java/io/IOException
    //   430	436	311	java/io/IOException
    //   72	76	378	finally
    //   298	302	429	finally
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
    //   9: invokestatic 372	com/tencent/mm/crash/b:i	(ILjava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/crash/b$a;
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 374	com/tencent/mm/crash/b:mbb	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   18: ifnull +55 -> 73
    //   21: aload_0
    //   22: getfield 374	com/tencent/mm/crash/b:mbb	Lcom/tencent/mm/sdk/platformtools/CrashMonitorForJni$CrashExtraMessageGetter;
    //   25: invokeinterface 379 1 0
    //   30: astore 5
    //   32: aload 5
    //   34: ifnull +39 -> 73
    //   37: aload 5
    //   39: invokevirtual 160	java/lang/String:isEmpty	()Z
    //   42: ifne +31 -> 73
    //   45: aload 4
    //   47: new 71	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   54: aload 4
    //   56: getfield 357	com/tencent/mm/crash/b$a:text	Ljava/lang/String;
    //   59: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 5
    //   64: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putfield 357	com/tencent/mm/crash/b$a:text	Ljava/lang/String;
    //   73: aload 4
    //   75: getfield 319	com/tencent/mm/crash/b$a:mbd	I
    //   78: aload 4
    //   80: getfield 357	com/tencent/mm/crash/b$a:text	Ljava/lang/String;
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
    //   124: invokestatic 399	com/tencent/mm/crash/b:aTb	()V
    //   127: ldc_w 333
    //   130: ldc_w 401
    //   133: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: new 154	java/io/BufferedReader
    //   139: dup
    //   140: new 265	java/io/FileReader
    //   143: dup
    //   144: new 71	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 407
    //   151: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: invokestatic 412	android/os/Process:myPid	()I
    //   157: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: ldc_w 414
    //   163: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 266	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   172: sipush 1024
    //   175: invokespecial 417	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   183: astore 4
    //   185: aload 4
    //   187: ifnull +75 -> 262
    //   190: ldc_w 333
    //   193: aload 4
    //   195: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto -19 -> 179
    //   201: astore 4
    //   203: aload_2
    //   204: invokevirtual 352	java/io/BufferedReader:close	()V
    //   207: ldc_w 370
    //   210: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload 4
    //   215: athrow
    //   216: astore_2
    //   217: ldc_w 333
    //   220: aload_2
    //   221: ldc_w 419
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_3
    //   231: aastore
    //   232: invokestatic 423	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
    //   238: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:appenderClose	()V
    //   241: invokestatic 432	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   244: ifeq +10 -> 254
    //   247: invokestatic 438	com/tencent/mm/recoveryv2/l:iRc	()Lcom/tencent/mm/recoveryv2/l;
    //   250: iconst_4
    //   251: invokevirtual 441	com/tencent/mm/recoveryv2/l:axS	(I)V
    //   254: ldc_w 370
    //   257: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: iconst_0
    //   261: ireturn
    //   262: aload_2
    //   263: invokevirtual 352	java/io/BufferedReader:close	()V
    //   266: goto -31 -> 235
    //   269: astore_2
    //   270: aload 4
    //   272: aload_2
    //   273: invokevirtual 363	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   276: goto -69 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	b
    //   0	279	1	paramInt	int
    //   0	279	2	paramString1	String
    //   0	279	3	paramString2	String
    //   12	182	4	localObject1	Object
    //   201	70	4	localObject2	Object
    //   30	33	5	str	String
    // Exception table:
    //   from	to	target	type
    //   179	185	201	finally
    //   190	198	201	finally
    //   136	179	216	java/io/IOException
    //   207	216	216	java/io/IOException
    //   262	266	216	java/io/IOException
    //   270	276	216	java/io/IOException
    //   203	207	269	finally
  }
  
  public static final class a
  {
    public String clientVersion;
    public int mbd;
    public String text;
  }
  
  static final class c
  {
    static b mbe;
    
    static
    {
      AppMethodBeat.i(145678);
      mbe = new b((byte)0);
      AppMethodBeat.o(145678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.crash.b
 * JD-Core Version:    0.7.0.1
 */