package com.tencent.mm.performance.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static final a hQu;
  public final ActivityManager aGF;
  private volatile String activity;
  public boolean ctF;
  public int hQv;
  public int hQw;
  private int hQx;
  private boolean hQy;
  private long hQz;
  public String mProcessName;
  
  static
  {
    AppMethodBeat.i(145574);
    hQu = new a();
    AppMethodBeat.o(145574);
  }
  
  public a()
  {
    AppMethodBeat.i(145561);
    this.hQx = 0;
    this.hQy = true;
    this.ctF = true;
    this.aGF = ((ActivityManager)aj.getContext().getSystemService("activity"));
    this.hQz = 0L;
    AppMethodBeat.o(145561);
  }
  
  public static a aFM()
  {
    return hQu;
  }
  
  private int[] aFN()
  {
    AppMethodBeat.i(170135);
    List localList = this.aGF.getRunningAppProcesses();
    int[] arrayOfInt = new int[localList.size()];
    int i = 0;
    while (i < localList.size())
    {
      arrayOfInt[i] = ((ActivityManager.RunningAppProcessInfo)localList.get(i)).pid;
      i += 1;
    }
    ad.d("MicroMsg.MemoryWatchDog", "pids = %s", new Object[] { Arrays.toString(arrayOfInt) });
    AppMethodBeat.o(170135);
    return arrayOfInt;
  }
  
  private boolean aFO()
  {
    AppMethodBeat.i(145569);
    long l = SystemClock.uptimeMillis();
    if (l - this.hQz > 2000L) {}
    for (boolean bool = true;; bool = false)
    {
      this.hQz = l;
      AppMethodBeat.o(145569);
      return bool;
    }
  }
  
  private static int aFP()
  {
    AppMethodBeat.i(145573);
    if (aj.cbe())
    {
      AppMethodBeat.o(145573);
      return 1161;
    }
    if (aj.isAppBrandProcess())
    {
      AppMethodBeat.o(145573);
      return 1162;
    }
    if (aj.eFJ())
    {
      AppMethodBeat.o(145573);
      return 1163;
    }
    if (aj.eFH())
    {
      AppMethodBeat.o(145573);
      return 1164;
    }
    if (aj.eFK())
    {
      AppMethodBeat.o(145573);
      return 1165;
    }
    AppMethodBeat.o(145573);
    return -1;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(145567);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label61;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label61:
    AppMethodBeat.o(145567);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(145567);
    return paramInputStream;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(145568);
    Object localObject1 = new com.tencent.mm.vfs.e(paramString);
    paramString = null;
    try
    {
      localObject1 = com.tencent.mm.vfs.i.ah((com.tencent.mm.vfs.e)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(145568);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(145568);
    }
  }
  
  private static String getVmSize()
  {
    AppMethodBeat.i(145564);
    Object localObject = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      localObject = getStringFromFile((String)localObject).trim().split("\n");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        boolean bool = str.startsWith("VmSize");
        if (bool)
        {
          AppMethodBeat.o(145564);
          return str;
        }
        i += 1;
      }
      ad.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", new Object[] { localObject[12] });
      localObject = localObject[12];
      AppMethodBeat.o(145564);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(145564);
    }
    return "";
  }
  
  private void pu(int paramInt)
  {
    AppMethodBeat.i(145563);
    com.tencent.e.h.Iye.aP(new a.1(this, paramInt));
    AppMethodBeat.o(145563);
  }
  
  /* Error */
  public final a l(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 260
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   9: lstore 5
    //   11: new 10	com/tencent/mm/performance/a/a$a
    //   14: dup
    //   15: invokespecial 266	com/tencent/mm/performance/a/a$a:<init>	()V
    //   18: astore 9
    //   20: aload_0
    //   21: getfield 268	com/tencent/mm/performance/a/a:activity	Ljava/lang/String;
    //   24: ifnull +12 -> 36
    //   27: aload 9
    //   29: aload_0
    //   30: getfield 268	com/tencent/mm/performance/a/a:activity	Ljava/lang/String;
    //   33: putfield 269	com/tencent/mm/performance/a/a$a:activity	Ljava/lang/String;
    //   36: aload 9
    //   38: iload_2
    //   39: putfield 272	com/tencent/mm/performance/a/a$a:dep	I
    //   42: aload 9
    //   44: aload_0
    //   45: getfield 274	com/tencent/mm/performance/a/a:hQv	I
    //   48: i2l
    //   49: putfield 277	com/tencent/mm/performance/a/a$a:hQJ	J
    //   52: aload 9
    //   54: aload_0
    //   55: getfield 279	com/tencent/mm/performance/a/a:hQw	I
    //   58: i2l
    //   59: putfield 282	com/tencent/mm/performance/a/a$a:hQK	J
    //   62: iload_1
    //   63: ifeq +620 -> 683
    //   66: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   69: lstore 7
    //   71: aload_0
    //   72: getfield 70	com/tencent/mm/performance/a/a:aGF	Landroid/app/ActivityManager;
    //   75: iconst_1
    //   76: newarray int
    //   78: dup
    //   79: iconst_0
    //   80: invokestatic 202	android/os/Process:myPid	()I
    //   83: iastore
    //   84: invokevirtual 286	android/app/ActivityManager:getProcessMemoryInfo	([I)[Landroid/os/Debug$MemoryInfo;
    //   87: astore 10
    //   89: ldc 98
    //   91: new 145	java/lang/StringBuilder
    //   94: dup
    //   95: ldc_w 288
    //   98: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload 10
    //   103: arraylength
    //   104: invokevirtual 292	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 295	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload 10
    //   115: ifnull +44 -> 159
    //   118: aload 10
    //   120: arraylength
    //   121: iconst_1
    //   122: if_icmpne +37 -> 159
    //   125: aload 10
    //   127: iconst_0
    //   128: aaload
    //   129: astore 10
    //   131: aload 9
    //   133: aload 10
    //   135: invokevirtual 300	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   138: putfield 303	com/tencent/mm/performance/a/a$a:hQO	I
    //   141: getstatic 308	android/os/Build$VERSION:SDK_INT	I
    //   144: bipush 23
    //   146: if_icmplt +149 -> 295
    //   149: aload 9
    //   151: aload 10
    //   153: invokevirtual 312	android/os/Debug$MemoryInfo:getMemoryStats	()Ljava/util/Map;
    //   156: putfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   159: ldc 98
    //   161: ldc_w 318
    //   164: iconst_1
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   173: lload 7
    //   175: lsub
    //   176: invokestatic 323	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: aastore
    //   180: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: invokestatic 128	com/tencent/mm/sdk/platformtools/aj:cbe	()Z
    //   186: ifeq +497 -> 683
    //   189: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   192: lstore 7
    //   194: aload_0
    //   195: getfield 70	com/tencent/mm/performance/a/a:aGF	Landroid/app/ActivityManager;
    //   198: aload_0
    //   199: invokespecial 325	com/tencent/mm/performance/a/a:aFN	()[I
    //   202: invokevirtual 286	android/app/ActivityManager:getProcessMemoryInfo	([I)[Landroid/os/Debug$MemoryInfo;
    //   205: astore 10
    //   207: aload 10
    //   209: ifnull +700 -> 909
    //   212: ldc 98
    //   214: new 145	java/lang/StringBuilder
    //   217: dup
    //   218: ldc_w 288
    //   221: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload 10
    //   226: arraylength
    //   227: invokevirtual 292	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 295	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: iconst_0
    //   237: istore_3
    //   238: aload 10
    //   240: arraylength
    //   241: istore 4
    //   243: iconst_0
    //   244: istore_2
    //   245: iload_2
    //   246: iload 4
    //   248: if_icmpge +405 -> 653
    //   251: aload 10
    //   253: iload_2
    //   254: aaload
    //   255: astore 11
    //   257: ldc 98
    //   259: ldc_w 327
    //   262: iconst_1
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload 11
    //   270: invokevirtual 300	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   273: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: iload_3
    //   281: aload 11
    //   283: invokevirtual 300	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   286: iadd
    //   287: istore_3
    //   288: iload_2
    //   289: iconst_1
    //   290: iadd
    //   291: istore_2
    //   292: goto -47 -> 245
    //   295: ldc 98
    //   297: ldc_w 329
    //   300: invokestatic 295	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload 9
    //   305: new 331	java/util/HashMap
    //   308: dup
    //   309: invokespecial 332	java/util/HashMap:<init>	()V
    //   312: putfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   315: aload 9
    //   317: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   320: ldc_w 334
    //   323: aload 10
    //   325: getfield 337	android/os/Debug$MemoryInfo:dalvikPrivateDirty	I
    //   328: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   331: invokeinterface 346 3 0
    //   336: pop
    //   337: aload 9
    //   339: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   342: ldc_w 348
    //   345: aload 10
    //   347: getfield 351	android/os/Debug$MemoryInfo:nativePrivateDirty	I
    //   350: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   353: invokeinterface 346 3 0
    //   358: pop
    //   359: aload 9
    //   361: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   364: ldc_w 353
    //   367: ldc_w 355
    //   370: invokeinterface 346 3 0
    //   375: pop
    //   376: aload 9
    //   378: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   381: ldc_w 357
    //   384: ldc_w 355
    //   387: invokeinterface 346 3 0
    //   392: pop
    //   393: aload 9
    //   395: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   398: ldc_w 359
    //   401: ldc_w 355
    //   404: invokeinterface 346 3 0
    //   409: pop
    //   410: aload 9
    //   412: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   415: ldc_w 361
    //   418: ldc_w 355
    //   421: invokeinterface 346 3 0
    //   426: pop
    //   427: aload 9
    //   429: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   432: ldc_w 363
    //   435: aload 10
    //   437: invokevirtual 300	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   440: aload 10
    //   442: invokevirtual 366	android/os/Debug$MemoryInfo:getTotalPrivateClean	()I
    //   445: isub
    //   446: aload 10
    //   448: invokevirtual 369	android/os/Debug$MemoryInfo:getTotalPrivateDirty	()I
    //   451: isub
    //   452: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   455: invokeinterface 346 3 0
    //   460: pop
    //   461: aload 9
    //   463: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   466: ldc_w 371
    //   469: aload 10
    //   471: invokevirtual 300	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   474: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   477: invokeinterface 346 3 0
    //   482: pop
    //   483: aload 9
    //   485: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   488: ldc_w 373
    //   491: ldc_w 355
    //   494: invokeinterface 346 3 0
    //   499: pop
    //   500: ldc 98
    //   502: ldc_w 375
    //   505: iconst_1
    //   506: anewarray 4	java/lang/Object
    //   509: dup
    //   510: iconst_0
    //   511: aload 9
    //   513: getfield 316	com/tencent/mm/performance/a/a$a:map	Ljava/util/Map;
    //   516: aastore
    //   517: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: goto -361 -> 159
    //   523: astore 10
    //   525: ldc 98
    //   527: aload 10
    //   529: ldc 238
    //   531: iconst_0
    //   532: anewarray 4	java/lang/Object
    //   535: invokestatic 379	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: aload 9
    //   540: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   543: lload 5
    //   545: lsub
    //   546: putfield 382	com/tencent/mm/performance/a/a$a:hQL	J
    //   549: getstatic 387	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_RED	Z
    //   552: ifne +64 -> 616
    //   555: getstatic 390	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_PURPLE	Z
    //   558: ifne +58 -> 616
    //   561: iload_1
    //   562: ifne +54 -> 616
    //   565: aload 9
    //   567: getfield 382	com/tencent/mm/performance/a/a$a:hQL	J
    //   570: ldc2_w 391
    //   573: lcmp
    //   574: ifle +42 -> 616
    //   577: aload_0
    //   578: getfield 51	com/tencent/mm/performance/a/a:hQy	Z
    //   581: ifeq +35 -> 616
    //   584: aload_0
    //   585: aload_0
    //   586: getfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   589: iconst_1
    //   590: iadd
    //   591: putfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   594: aload_0
    //   595: getfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   598: bipush 10
    //   600: if_icmple +16 -> 616
    //   603: ldc 98
    //   605: ldc_w 394
    //   608: invokestatic 396	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: aload_0
    //   612: iconst_0
    //   613: putfield 51	com/tencent/mm/performance/a/a:hQy	Z
    //   616: aload 9
    //   618: getfield 400	com/tencent/mm/performance/a/a$a:hQN	Landroid/app/ActivityManager$MemoryInfo;
    //   621: ifnonnull +23 -> 644
    //   624: ldc 98
    //   626: ldc_w 402
    //   629: invokestatic 405	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: aload 9
    //   634: new 407	android/app/ActivityManager$MemoryInfo
    //   637: dup
    //   638: invokespecial 408	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   641: putfield 400	com/tencent/mm/performance/a/a$a:hQN	Landroid/app/ActivityManager$MemoryInfo;
    //   644: ldc_w 260
    //   647: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   650: aload 9
    //   652: areturn
    //   653: aload 9
    //   655: iload_3
    //   656: putfield 411	com/tencent/mm/performance/a/a$a:hQP	I
    //   659: ldc 98
    //   661: ldc_w 318
    //   664: iconst_1
    //   665: anewarray 4	java/lang/Object
    //   668: dup
    //   669: iconst_0
    //   670: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   673: lload 7
    //   675: lsub
    //   676: invokestatic 323	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   679: aastore
    //   680: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   683: ldc_w 413
    //   686: invokestatic 419	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   689: invokestatic 421	com/tencent/mm/performance/a/a:getVmSize	()Ljava/lang/String;
    //   692: invokevirtual 425	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   695: astore 10
    //   697: aload 10
    //   699: invokevirtual 430	java/util/regex/Matcher:find	()Z
    //   702: ifeq +16 -> 718
    //   705: aload 9
    //   707: aload 10
    //   709: invokevirtual 433	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   712: invokestatic 439	com/tencent/mm/sdk/platformtools/bt:aGh	(Ljava/lang/String;)I
    //   715: putfield 442	com/tencent/mm/performance/a/a$a:hQC	I
    //   718: aload 9
    //   720: invokestatic 447	android/os/Debug:getNativeHeapSize	()J
    //   723: putfield 450	com/tencent/mm/performance/a/a$a:hQD	J
    //   726: aload 9
    //   728: invokestatic 453	android/os/Debug:getNativeHeapAllocatedSize	()J
    //   731: putfield 456	com/tencent/mm/performance/a/a$a:hQE	J
    //   734: aload 9
    //   736: invokestatic 459	android/os/Debug:getNativeHeapFreeSize	()J
    //   739: putfield 462	com/tencent/mm/performance/a/a$a:hQF	J
    //   742: aload 9
    //   744: invokestatic 468	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   747: invokevirtual 471	java/lang/Runtime:totalMemory	()J
    //   750: putfield 474	com/tencent/mm/performance/a/a$a:hQG	J
    //   753: aload 9
    //   755: invokestatic 468	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   758: invokevirtual 477	java/lang/Runtime:freeMemory	()J
    //   761: putfield 480	com/tencent/mm/performance/a/a$a:hQH	J
    //   764: aload 9
    //   766: invokestatic 468	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   769: invokevirtual 483	java/lang/Runtime:maxMemory	()J
    //   772: putfield 486	com/tencent/mm/performance/a/a$a:hQI	J
    //   775: new 407	android/app/ActivityManager$MemoryInfo
    //   778: dup
    //   779: invokespecial 408	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   782: astore 10
    //   784: aload_0
    //   785: getfield 70	com/tencent/mm/performance/a/a:aGF	Landroid/app/ActivityManager;
    //   788: aload 10
    //   790: invokevirtual 490	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   793: aload 9
    //   795: aload 10
    //   797: putfield 400	com/tencent/mm/performance/a/a$a:hQN	Landroid/app/ActivityManager$MemoryInfo;
    //   800: aload 9
    //   802: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   805: lload 5
    //   807: lsub
    //   808: putfield 382	com/tencent/mm/performance/a/a$a:hQL	J
    //   811: getstatic 387	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_RED	Z
    //   814: ifne +64 -> 878
    //   817: getstatic 390	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_PURPLE	Z
    //   820: ifne +58 -> 878
    //   823: iload_1
    //   824: ifne +54 -> 878
    //   827: aload 9
    //   829: getfield 382	com/tencent/mm/performance/a/a$a:hQL	J
    //   832: ldc2_w 391
    //   835: lcmp
    //   836: ifle +42 -> 878
    //   839: aload_0
    //   840: getfield 51	com/tencent/mm/performance/a/a:hQy	Z
    //   843: ifeq +35 -> 878
    //   846: aload_0
    //   847: aload_0
    //   848: getfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   851: iconst_1
    //   852: iadd
    //   853: putfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   856: aload_0
    //   857: getfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   860: bipush 10
    //   862: if_icmple +16 -> 878
    //   865: ldc 98
    //   867: ldc_w 394
    //   870: invokestatic 396	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   873: aload_0
    //   874: iconst_0
    //   875: putfield 51	com/tencent/mm/performance/a/a:hQy	Z
    //   878: aload 9
    //   880: getfield 400	com/tencent/mm/performance/a/a$a:hQN	Landroid/app/ActivityManager$MemoryInfo;
    //   883: ifnonnull -239 -> 644
    //   886: ldc 98
    //   888: ldc_w 402
    //   891: invokestatic 405	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   894: aload 9
    //   896: new 407	android/app/ActivityManager$MemoryInfo
    //   899: dup
    //   900: invokespecial 408	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   903: putfield 400	com/tencent/mm/performance/a/a$a:hQN	Landroid/app/ActivityManager$MemoryInfo;
    //   906: goto -262 -> 644
    //   909: ldc 98
    //   911: ldc_w 492
    //   914: invokestatic 405	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   917: goto -258 -> 659
    //   920: astore 10
    //   922: aload 9
    //   924: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   927: lload 5
    //   929: lsub
    //   930: putfield 382	com/tencent/mm/performance/a/a$a:hQL	J
    //   933: getstatic 387	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_RED	Z
    //   936: ifne +64 -> 1000
    //   939: getstatic 390	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_PURPLE	Z
    //   942: ifne +58 -> 1000
    //   945: iload_1
    //   946: ifne +54 -> 1000
    //   949: aload 9
    //   951: getfield 382	com/tencent/mm/performance/a/a$a:hQL	J
    //   954: ldc2_w 391
    //   957: lcmp
    //   958: ifle +42 -> 1000
    //   961: aload_0
    //   962: getfield 51	com/tencent/mm/performance/a/a:hQy	Z
    //   965: ifeq +35 -> 1000
    //   968: aload_0
    //   969: aload_0
    //   970: getfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   973: iconst_1
    //   974: iadd
    //   975: putfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   978: aload_0
    //   979: getfield 49	com/tencent/mm/performance/a/a:hQx	I
    //   982: bipush 10
    //   984: if_icmple +16 -> 1000
    //   987: ldc 98
    //   989: ldc_w 394
    //   992: invokestatic 396	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   995: aload_0
    //   996: iconst_0
    //   997: putfield 51	com/tencent/mm/performance/a/a:hQy	Z
    //   1000: aload 9
    //   1002: getfield 400	com/tencent/mm/performance/a/a$a:hQN	Landroid/app/ActivityManager$MemoryInfo;
    //   1005: ifnonnull +23 -> 1028
    //   1008: ldc 98
    //   1010: ldc_w 402
    //   1013: invokestatic 405	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1016: aload 9
    //   1018: new 407	android/app/ActivityManager$MemoryInfo
    //   1021: dup
    //   1022: invokespecial 408	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   1025: putfield 400	com/tencent/mm/performance/a/a$a:hQN	Landroid/app/ActivityManager$MemoryInfo;
    //   1028: ldc_w 260
    //   1031: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1034: aload 10
    //   1036: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1037	0	this	a
    //   0	1037	1	paramBoolean	boolean
    //   0	1037	2	paramInt	int
    //   237	419	3	i	int
    //   241	8	4	j	int
    //   9	919	5	l1	long
    //   69	605	7	l2	long
    //   18	999	9	locala	a
    //   87	383	10	localObject1	Object
    //   523	5	10	localException	Exception
    //   695	101	10	localObject2	Object
    //   920	115	10	localObject3	Object
    //   255	27	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   66	113	523	java/lang/Exception
    //   118	125	523	java/lang/Exception
    //   131	159	523	java/lang/Exception
    //   159	207	523	java/lang/Exception
    //   212	236	523	java/lang/Exception
    //   238	243	523	java/lang/Exception
    //   257	288	523	java/lang/Exception
    //   295	520	523	java/lang/Exception
    //   653	659	523	java/lang/Exception
    //   659	683	523	java/lang/Exception
    //   683	718	523	java/lang/Exception
    //   718	800	523	java/lang/Exception
    //   909	917	523	java/lang/Exception
    //   66	113	920	finally
    //   118	125	920	finally
    //   131	159	920	finally
    //   159	207	920	finally
    //   212	236	920	finally
    //   238	243	920	finally
    //   257	288	920	finally
    //   295	520	920	finally
    //   525	538	920	finally
    //   653	659	920	finally
    //   659	683	920	finally
    //   683	718	920	finally
    //   718	800	920	finally
    //   909	917	920	finally
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(145570);
    this.activity = paramActivity.getClass().getSimpleName();
    if (aFO())
    {
      if (this.hQy)
      {
        ad.i("MicroMsg.MemoryWatchDog", "[onActivityResumed] activity:%s %s", new Object[] { this.activity, l(false, 1) });
        AppMethodBeat.o(145570);
        return;
      }
      pu(1);
    }
    AppMethodBeat.o(145570);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(145571);
    if (aFO())
    {
      if (this.hQy)
      {
        ad.i("MicroMsg.MemoryWatchDog", "[onActivityStopped] activity:%s %s", new Object[] { paramActivity.getClass().getSimpleName(), l(false, 2) });
        AppMethodBeat.o(145571);
        return;
      }
      pu(2);
    }
    AppMethodBeat.o(145571);
  }
  
  public final void run()
  {
    AppMethodBeat.i(145572);
    Object localObject = l(true, 3);
    new StringBuilder("[AutoCheck] ").append(localObject);
    ad.i("MicroMsg.MemoryWatchDog", "[AutoCheck] %s", new Object[] { localObject });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(959);
    localIDKey1.SetValue(1L);
    label155:
    label205:
    int i;
    if (((a)localObject).hQG - ((a)localObject).hQH < 104857600L)
    {
      localIDKey1.SetKey(120);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (((a)localObject).hQE >= 104857600L) {
        break label1270;
      }
      localIDKey1.SetKey(131);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (((a)localObject).hQC >= 2097152) {
        break label1442;
      }
      localIDKey1.SetKey(142);
      if (((a)localObject).hQC >= 3858759.8F)
      {
        IDKey localIDKey2 = new IDKey();
        localIDKey2.SetID(959);
        localIDKey2.SetValue(1L);
        localIDKey2.SetKey(149);
        localArrayList.add(localIDKey2);
      }
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      localIDKey1.SetKey(151);
      localArrayList.add(localIDKey1);
      com.tencent.mm.plugin.report.e.vIY.b(localArrayList, false);
      if (aFP() > 0)
      {
        localArrayList = new ArrayList();
        localIDKey1 = new IDKey();
        localIDKey1.SetID(aFP());
        localIDKey1.SetValue(1L);
        localIDKey1.SetKey(0);
        localArrayList.add(localIDKey1);
        localIDKey1 = new IDKey();
        localIDKey1.SetID(aFP());
        localIDKey1.SetValue(1L);
        if (!com.tencent.mm.sdk.platformtools.h.glZ) {
          break label1573;
        }
        i = 254;
        label398:
        localIDKey1.SetKey(i);
        localArrayList.add(localIDKey1);
        l = ((a)localObject).hQG - ((a)localObject).hQH;
        localIDKey1 = new IDKey();
        localIDKey1.SetID(aFP());
        localIDKey1.SetValue(1L);
        if (l >= 104857600L) {
          break label1580;
        }
        localIDKey1.SetKey(1);
        label461:
        localArrayList.add(localIDKey1);
        l = ((a)localObject).hQE;
        localIDKey1 = new IDKey();
        localIDKey1.SetID(aFP());
        localIDKey1.SetValue(1L);
        if (l >= 104857600L) {
          break label1748;
        }
        localIDKey1.SetKey(33);
        label513:
        localArrayList.add(localIDKey1);
        localIDKey1 = new IDKey();
        localIDKey1.SetID(aFP());
        localIDKey1.SetValue(1L);
        l = ((a)localObject).hQC;
        if (l >= 1572864.0D) {
          break label1920;
        }
        localIDKey1.SetKey(65);
        label567:
        localArrayList.add(localIDKey1);
        localIDKey1 = new IDKey();
        localIDKey1.SetID(aFP());
        localIDKey1.SetValue(1L);
        i = ((a)localObject).hQO;
        if (i >= 102400) {
          break label2254;
        }
        if (!com.tencent.mm.sdk.platformtools.h.glZ) {
          break label2248;
        }
        i = 154;
        label621:
        localIDKey1.SetKey(i);
        localArrayList.add(localIDKey1);
        if (aj.cbe())
        {
          localIDKey1 = new IDKey();
          localIDKey1.SetID(1308);
          localIDKey1.SetValue(1L);
          if (!com.tencent.mm.sdk.platformtools.h.glZ) {
            break label2572;
          }
          i = 1;
          label672:
          localIDKey1.SetKey(i);
          localArrayList.add(localIDKey1);
          localIDKey1 = new IDKey();
          localIDKey1.SetID(1308);
          localIDKey1.SetValue(1L);
          i = ((a)localObject).hQP;
          if (i >= 102400) {
            break label2582;
          }
          if (!com.tencent.mm.sdk.platformtools.h.glZ) {
            break label2577;
          }
          i = 42;
          label731:
          localIDKey1.SetKey(i);
          localArrayList.add(localIDKey1);
          localIDKey1 = new IDKey();
          localIDKey1.SetID(1308);
          localIDKey1.SetValue(1L);
          l = ((a)localObject).hQN.availMem;
          if (l >= 104857600L) {
            break label3012;
          }
          if (!com.tencent.mm.sdk.platformtools.h.glZ) {
            break label3006;
          }
          i = 113;
          label794:
          localIDKey1.SetKey(i);
          localArrayList.add(localIDKey1);
        }
        com.tencent.mm.plugin.report.e.vIY.b(localArrayList, false);
      }
      localArrayList = new ArrayList();
      i = 0;
      if (this.mProcessName != null)
      {
        if (!this.mProcessName.equals("com.tencent.mm")) {
          break label3356;
        }
        ad.d("MicroMsg.MemoryWatchDog", "main: " + this.mProcessName);
        i = 10;
        label876:
        localIDKey1 = new IDKey();
        localIDKey1.SetID(1031);
        localIDKey1.SetKey(i);
        localIDKey1.SetValue((((a)localObject).hQG - ((a)localObject).hQH) / 1024L / 1024L);
        localArrayList.add(localIDKey1);
        localIDKey1 = new IDKey();
        localIDKey1.SetID(1031);
        localIDKey1.SetKey(i + 1);
        localIDKey1.SetValue(((a)localObject).hQE / 1024L / 1024L);
        localArrayList.add(localIDKey1);
        localObject = new IDKey();
        ((IDKey)localObject).SetID(1031);
        ((IDKey)localObject).SetKey(i + 2);
        ((IDKey)localObject).SetValue(1L);
        localArrayList.add(localObject);
        com.tencent.mm.plugin.report.e.vIY.b(localArrayList, false);
      }
      localObject = com.tencent.e.h.Iye;
      if (!this.ctF) {
        break label3444;
      }
    }
    label1442:
    label1573:
    label1580:
    label1748:
    label3444:
    for (long l = 300000L;; l = 1800000L)
    {
      ((com.tencent.e.i)localObject).q(this, l);
      AppMethodBeat.o(145572);
      return;
      if (((a)localObject).hQG - ((a)localObject).hQH < 209715200L)
      {
        localIDKey1.SetKey(121);
        break;
      }
      if (((a)localObject).hQG - ((a)localObject).hQH < 314572800L)
      {
        localIDKey1.SetKey(122);
        break;
      }
      if (((a)localObject).hQG - ((a)localObject).hQH < 419430400L)
      {
        localIDKey1.SetKey(123);
        break;
      }
      if (((a)localObject).hQG - ((a)localObject).hQH < 524288000L)
      {
        localIDKey1.SetKey(124);
        break;
      }
      if (((a)localObject).hQG - ((a)localObject).hQH < 629145600L)
      {
        localIDKey1.SetKey(125);
        break;
      }
      if (((a)localObject).hQG - ((a)localObject).hQH < 734003200L)
      {
        localIDKey1.SetKey(126);
        break;
      }
      if (((a)localObject).hQG - ((a)localObject).hQH < 838860800L)
      {
        localIDKey1.SetKey(127);
        break;
      }
      localIDKey1.SetKey(128);
      break;
      label1270:
      if (((a)localObject).hQE < 209715200L)
      {
        localIDKey1.SetKey(132);
        break label155;
      }
      if (((a)localObject).hQE < 314572800L)
      {
        localIDKey1.SetKey(133);
        break label155;
      }
      if (((a)localObject).hQE < 419430400L)
      {
        localIDKey1.SetKey(134);
        break label155;
      }
      if (((a)localObject).hQE < 524288000L)
      {
        localIDKey1.SetKey(135);
        break label155;
      }
      if (((a)localObject).hQE < 629145600L)
      {
        localIDKey1.SetKey(136);
        break label155;
      }
      if (((a)localObject).hQE < 734003200L)
      {
        localIDKey1.SetKey(137);
        break label155;
      }
      if (((a)localObject).hQE < 838860800L)
      {
        localIDKey1.SetKey(138);
        break label155;
      }
      localIDKey1.SetKey(139);
      break label155;
      if (((a)localObject).hQC < 2516582.5F)
      {
        localIDKey1.SetKey(143);
        break label205;
      }
      if (((a)localObject).hQC < 2936012.8F)
      {
        localIDKey1.SetKey(144);
        break label205;
      }
      if (((a)localObject).hQC < 3145728.0F)
      {
        localIDKey1.SetKey(145);
        break label205;
      }
      if (((a)localObject).hQC < 3565158.5F)
      {
        localIDKey1.SetKey(146);
        break label205;
      }
      if (((a)localObject).hQC < 3984588.8F)
      {
        localIDKey1.SetKey(147);
        break label205;
      }
      localIDKey1.SetKey(148);
      break label205;
      i = 255;
      break label398;
      if (l < 209715200L)
      {
        localIDKey1.SetKey(2);
        break label461;
      }
      if (l < 314572800L)
      {
        localIDKey1.SetKey(3);
        break label461;
      }
      if (l < 419430400L)
      {
        localIDKey1.SetKey(4);
        break label461;
      }
      if (l < 524288000L)
      {
        localIDKey1.SetKey(5);
        break label461;
      }
      if (l < 629145600L)
      {
        localIDKey1.SetKey(6);
        break label461;
      }
      if (l < 734003200L)
      {
        localIDKey1.SetKey(7);
        break label461;
      }
      if (l < 838860800L)
      {
        localIDKey1.SetKey(8);
        break label461;
      }
      if (l < 943718400L)
      {
        localIDKey1.SetKey(9);
        break label461;
      }
      if (l < 1048576000L)
      {
        localIDKey1.SetKey(10);
        break label461;
      }
      localIDKey1.SetKey(11);
      break label461;
      if (l < 209715200L)
      {
        localIDKey1.SetKey(34);
        break label513;
      }
      if (l < 314572800L)
      {
        localIDKey1.SetKey(35);
        break label513;
      }
      if (l < 419430400L)
      {
        localIDKey1.SetKey(36);
        break label513;
      }
      if (l < 524288000L)
      {
        localIDKey1.SetKey(37);
        break label513;
      }
      if (l < 629145600L)
      {
        localIDKey1.SetKey(38);
        break label513;
      }
      if (l < 734003200L)
      {
        localIDKey1.SetKey(39);
        break label513;
      }
      if (l < 838860800L)
      {
        localIDKey1.SetKey(40);
        break label513;
      }
      if (l < 943718400L)
      {
        localIDKey1.SetKey(41);
        break label513;
      }
      if (l < 1048576000L)
      {
        localIDKey1.SetKey(42);
        break label513;
      }
      localIDKey1.SetKey(43);
      break label513;
      if (l < 2097152L)
      {
        localIDKey1.SetKey(66);
        break label567;
      }
      if (l < 2621440.0D)
      {
        localIDKey1.SetKey(67);
        break label567;
      }
      if (l < 3145728L)
      {
        localIDKey1.SetKey(68);
        break label567;
      }
      if (l < 3670016.0D)
      {
        localIDKey1.SetKey(69);
        break label567;
      }
      if (l < 4194304L)
      {
        localIDKey1.SetKey(70);
        break label567;
      }
      if (l < 4718592.0D)
      {
        localIDKey1.SetKey(71);
        break label567;
      }
      if (l < 5242880L)
      {
        localIDKey1.SetKey(72);
        break label567;
      }
      if (l < 5767168.0D)
      {
        localIDKey1.SetKey(73);
        break label567;
      }
      if (l < 6291456.0D)
      {
        localIDKey1.SetKey(74);
        break label567;
      }
      if (l < 6815744.0D)
      {
        localIDKey1.SetKey(75);
        break label567;
      }
      if (l < 7340032.0D)
      {
        localIDKey1.SetKey(76);
        break label567;
      }
      if (l < 7864320.0D)
      {
        localIDKey1.SetKey(77);
        break label567;
      }
      if (l < 8388608.0D)
      {
        localIDKey1.SetKey(78);
        break label567;
      }
      if (l < 8912896.0D)
      {
        localIDKey1.SetKey(79);
        break label567;
      }
      if (l < 9437184.0D)
      {
        localIDKey1.SetKey(80);
        break label567;
      }
      if (l < 9961472.0D)
      {
        localIDKey1.SetKey(81);
        break label567;
      }
      if (l < 10485760L)
      {
        localIDKey1.SetKey(82);
        break label567;
      }
      localIDKey1.SetKey(83);
      break label567;
      i = 122;
      break label621;
      if (i < 204800)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 155;; i = 123)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 307200)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 156;; i = 124)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 409600)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 157;; i = 125)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 512000)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 158;; i = 126)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 614400)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 159;; i = 127)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 716800)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 160;; i = 128)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 819200)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 161;; i = 129)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 921600)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 162;; i = 130)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 1024000)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 163;; i = 131)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (com.tencent.mm.sdk.platformtools.h.glZ) {}
      for (i = 164;; i = 132)
      {
        localIDKey1.SetKey(i);
        break;
      }
      i = 0;
      break label672;
      i = 2;
      break label731;
      if (i < 204800)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 43;; i = 3)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 307200)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 44;; i = 4)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 409600)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 45;; i = 5)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 512000)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 46;; i = 6)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 614400)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 47;; i = 7)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 716800)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 48;; i = 8)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 819200)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 49;; i = 9)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 921600)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 50;; i = 10)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 1024000)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 51;; i = 11)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 1126400)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 52;; i = 12)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 1228800)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 53;; i = 13)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 1331200)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 54;; i = 14)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 1433600)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 55;; i = 15)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (com.tencent.mm.sdk.platformtools.h.glZ) {}
      for (i = 56;; i = 16)
      {
        localIDKey1.SetKey(i);
        break;
      }
      i = 82;
      break label794;
      if (l < 209715200L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 114;; i = 83)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 314572800L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 115;; i = 84)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 419430400L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 116;; i = 85)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 524288000L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 117;; i = 86)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 629145600L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 118;; i = 87)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 734003200L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 119;; i = 88)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 838860800L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 120;; i = 89)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 943718400L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 121;; i = 90)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 1048576000L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 122;; i = 91)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (l < 1572864000L)
      {
        if (com.tencent.mm.sdk.platformtools.h.glZ) {}
        for (i = 123;; i = 92)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (com.tencent.mm.sdk.platformtools.h.glZ) {}
      for (i = 124;; i = 93)
      {
        localIDKey1.SetKey(i);
        break;
      }
      if (this.mProcessName.contains(":tools"))
      {
        ad.d("MicroMsg.MemoryWatchDog", "tools: " + this.mProcessName);
        i = 20;
        break label876;
      }
      if (!this.mProcessName.contains(":appbrand")) {
        break label876;
      }
      ad.d("MicroMsg.MemoryWatchDog", "appbrand: " + this.mProcessName);
      i = 30;
      break label876;
    }
  }
  
  public static final class a
  {
    String activity;
    int dep;
    int hQC;
    long hQD;
    long hQE;
    long hQF;
    long hQG;
    long hQH;
    long hQI;
    long hQJ;
    long hQK;
    long hQL;
    long hQM;
    ActivityManager.MemoryInfo hQN;
    int hQO;
    int hQP;
    Map<String, String> map;
    
    public a()
    {
      AppMethodBeat.i(145558);
      this.dep = 0;
      this.activity = "default";
      this.hQM = Thread.currentThread().getId();
      AppMethodBeat.o(145558);
    }
    
    private static String w(Map<String, String> paramMap)
    {
      AppMethodBeat.i(145560);
      if (paramMap == null)
      {
        AppMethodBeat.o(145560);
        return "null";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((!((String)localEntry.getKey()).equals("java-heap")) && (!((String)localEntry.getKey()).equals("native-heap"))) {
          localStringBuilder.append(((String)localEntry.getKey()).replaceFirst("summary.", "")).append("=").append((String)localEntry.getValue()).append(", ");
        }
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      paramMap = localStringBuilder.toString();
      AppMethodBeat.o(145560);
      return paramMap;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(145559);
      Object localObject = new StringBuilder(" \n");
      ((StringBuilder)localObject).append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { Long.valueOf(this.hQM) })).append("\n| Activity:\t ").append(this.activity).append("\n| Source:\t ").append(this.dep).append("\n| VmSize:\t ").append(this.hQC).append("kB\n| SystemMemoryInfo:\t totalMem=").append(this.hQN.totalMem).append(", availMem=").append(this.hQN.availMem).append(", lowMemory=").append(this.hQN.lowMemory).append(", threshold=").append(this.hQN.threshold).append("\n| Dalvik:\t memClass=").append(this.hQJ).append(", memLargeClass=").append(this.hQK).append(" B, TalMemory=").append(this.hQG).append(" B, FreeMemory=").append(this.hQH).append(" B, MaxMemory=").append(this.hQI).append(" B\n| NATIVE:\t HeapSize=").append(this.hQD).append(" B, AllocatedSize=").append(this.hQE).append(" B, FreeSize=").append(this.hQF).append(" B\n| Stats:\t pss-sum:").append(this.hQP).append(" KB, ").append(w(this.map)).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.hQL).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(145559);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.a.a
 * JD-Core Version:    0.7.0.1
 */