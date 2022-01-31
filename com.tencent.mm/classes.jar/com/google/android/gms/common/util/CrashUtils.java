package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

public final class CrashUtils
{
  private static final String[] zzzc = { "android.", "com.android.", "dalvik.", "java.", "javax." };
  private static DropBoxManager zzzd = null;
  private static boolean zzze = false;
  private static boolean zzzf;
  private static boolean zzzg;
  private static int zzzh = -1;
  @GuardedBy("CrashUtils.class")
  private static int zzzi = 0;
  @GuardedBy("CrashUtils.class")
  private static int zzzj = 0;
  
  public static boolean addDynamiteErrorToDropBox(Context paramContext, Throwable paramThrowable)
  {
    AppMethodBeat.i(90135);
    boolean bool = addErrorToDropBoxInternal(paramContext, paramThrowable, 536870912);
    AppMethodBeat.o(90135);
    return bool;
  }
  
  @Deprecated
  public static boolean addErrorToDropBox(Context paramContext, Throwable paramThrowable)
  {
    AppMethodBeat.i(90136);
    boolean bool = addDynamiteErrorToDropBox(paramContext, paramThrowable);
    AppMethodBeat.o(90136);
    return bool;
  }
  
  public static boolean addErrorToDropBoxInternal(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(90138);
    boolean bool = zza(paramContext, paramString1, paramString2, paramInt, null);
    AppMethodBeat.o(90138);
    return bool;
  }
  
  public static boolean addErrorToDropBoxInternal(Context paramContext, Throwable paramThrowable, int paramInt)
  {
    AppMethodBeat.i(90137);
    try
    {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramThrowable);
      bool = isPackageSide();
      if (!bool)
      {
        AppMethodBeat.o(90137);
        return false;
      }
      Throwable localThrowable = paramThrowable;
      if (!zzdb())
      {
        paramThrowable = zza(paramThrowable);
        localThrowable = paramThrowable;
        if (paramThrowable == null)
        {
          AppMethodBeat.o(90137);
          return false;
        }
      }
      bool = zza(paramContext, Log.getStackTraceString(localThrowable), ProcessUtils.getMyProcessName(), paramInt, localThrowable);
      AppMethodBeat.o(90137);
      return bool;
    }
    catch (Exception paramContext)
    {
      try
      {
        bool = zzdb();
        if (bool)
        {
          AppMethodBeat.o(90137);
          throw paramContext;
        }
      }
      catch (Exception paramThrowable)
      {
        for (;;)
        {
          boolean bool = false;
        }
        AppMethodBeat.o(90137);
      }
    }
    return false;
  }
  
  private static boolean isPackageSide()
  {
    if (zzze) {
      return zzzf;
    }
    return false;
  }
  
  public static boolean isSystemClassPrefixInternal(String paramString)
  {
    AppMethodBeat.i(90140);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90140);
      return false;
    }
    String[] arrayOfString = zzzc;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.startsWith(arrayOfString[i]))
      {
        AppMethodBeat.o(90140);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(90140);
    return false;
  }
  
  @VisibleForTesting
  public static void setTestVariables(DropBoxManager paramDropBoxManager, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      zzze = true;
      zzzd = paramDropBoxManager;
      zzzg = paramBoolean1;
      zzzf = paramBoolean2;
      zzzh = paramInt;
      zzzi = 0;
      zzzj = 0;
      return;
    }
    finally
    {
      paramDropBoxManager = finally;
      throw paramDropBoxManager;
    }
  }
  
  /* Error */
  @VisibleForTesting
  private static String zza(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 136
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 138	java/lang/StringBuilder
    //   11: dup
    //   12: sipush 1024
    //   15: invokespecial 140	java/lang/StringBuilder:<init>	(I)V
    //   18: astore 9
    //   20: aload 9
    //   22: ldc 142
    //   24: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_2
    //   28: invokestatic 152	com/google/android/gms/common/util/Strings:nullToEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 154
    //   36: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 9
    //   42: ldc 156
    //   44: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: ldc 157
    //   50: istore 6
    //   52: ldc 159
    //   54: astore 8
    //   56: invokestatic 97	com/google/android/gms/common/util/CrashUtils:zzdb	()Z
    //   59: istore 7
    //   61: aload 8
    //   63: astore_2
    //   64: iload 6
    //   66: istore 4
    //   68: iload 7
    //   70: ifeq +65 -> 135
    //   73: iload 6
    //   75: istore 5
    //   77: aload_0
    //   78: invokestatic 165	com/google/android/gms/common/wrappers/Wrappers:packageManager	(Landroid/content/Context;)Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   81: aload_0
    //   82: invokevirtual 170	android/content/Context:getPackageName	()Ljava/lang/String;
    //   85: iconst_0
    //   86: invokevirtual 176	com/google/android/gms/common/wrappers/PackageManagerWrapper:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   89: astore 10
    //   91: iload 6
    //   93: istore 5
    //   95: aload 10
    //   97: getfield 181	android/content/pm/PackageInfo:versionCode	I
    //   100: istore 6
    //   102: aload 8
    //   104: astore_2
    //   105: iload 6
    //   107: istore 4
    //   109: iload 6
    //   111: istore 5
    //   113: aload 10
    //   115: getfield 185	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   118: ifnull +17 -> 135
    //   121: iload 6
    //   123: istore 5
    //   125: aload 10
    //   127: getfield 185	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   130: astore_2
    //   131: iload 6
    //   133: istore 4
    //   135: aload 9
    //   137: ldc 187
    //   139: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload 4
    //   144: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +80 -> 232
    //   155: aload_2
    //   156: astore 8
    //   158: aload_2
    //   159: ldc 192
    //   161: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   164: ifeq +50 -> 214
    //   167: aload_2
    //   168: astore 8
    //   170: aload_2
    //   171: ldc 197
    //   173: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   176: ifne +38 -> 214
    //   179: aload_2
    //   180: astore 8
    //   182: aload_2
    //   183: ldc 199
    //   185: invokevirtual 202	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   188: ifeq +14 -> 202
    //   191: aload_2
    //   192: invokestatic 206	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: ldc 208
    //   197: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 8
    //   202: aload 8
    //   204: invokestatic 206	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   207: ldc 197
    //   209: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 8
    //   214: aload 9
    //   216: ldc 213
    //   218: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 8
    //   223: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 197
    //   228: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 9
    //   234: ldc 154
    //   236: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 9
    //   242: ldc 215
    //   244: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: getstatic 220	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   250: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 154
    //   255: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: invokestatic 225	android/os/Debug:isDebuggerConnected	()Z
    //   262: ifeq +11 -> 273
    //   265: aload 9
    //   267: ldc 227
    //   269: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: iload_3
    //   274: ifeq +20 -> 294
    //   277: aload 9
    //   279: ldc 229
    //   281: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload_3
    //   285: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: ldc 154
    //   290: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 9
    //   296: ldc 154
    //   298: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_1
    //   303: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifne +10 -> 316
    //   309: aload 9
    //   311: aload_1
    //   312: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: invokestatic 97	com/google/android/gms/common/util/CrashUtils:zzdb	()Z
    //   319: ifeq +291 -> 610
    //   322: getstatic 44	com/google/android/gms/common/util/CrashUtils:zzzh	I
    //   325: iflt +192 -> 517
    //   328: getstatic 44	com/google/android/gms/common/util/CrashUtils:zzzh	I
    //   331: istore_3
    //   332: iload_3
    //   333: ifle +168 -> 501
    //   336: aload 9
    //   338: ldc 154
    //   340: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: new 231	java/lang/ProcessBuilder
    //   347: dup
    //   348: bipush 13
    //   350: anewarray 26	java/lang/String
    //   353: dup
    //   354: iconst_0
    //   355: ldc 233
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: ldc 235
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: ldc 237
    //   367: aastore
    //   368: dup
    //   369: iconst_3
    //   370: ldc 239
    //   372: aastore
    //   373: dup
    //   374: iconst_4
    //   375: ldc 241
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: ldc 239
    //   382: aastore
    //   383: dup
    //   384: bipush 6
    //   386: ldc 243
    //   388: aastore
    //   389: dup
    //   390: bipush 7
    //   392: ldc 239
    //   394: aastore
    //   395: dup
    //   396: bipush 8
    //   398: ldc 245
    //   400: aastore
    //   401: dup
    //   402: bipush 9
    //   404: ldc 239
    //   406: aastore
    //   407: dup
    //   408: bipush 10
    //   410: ldc 247
    //   412: aastore
    //   413: dup
    //   414: bipush 11
    //   416: ldc 249
    //   418: aastore
    //   419: dup
    //   420: bipush 12
    //   422: iload_3
    //   423: invokestatic 252	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   426: aastore
    //   427: invokespecial 255	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   430: iconst_1
    //   431: invokevirtual 259	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   434: invokevirtual 263	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 269	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   442: invokevirtual 274	java/io/OutputStream:close	()V
    //   445: aload_0
    //   446: invokevirtual 278	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   449: invokevirtual 281	java/io/InputStream:close	()V
    //   452: new 283	java/io/InputStreamReader
    //   455: dup
    //   456: aload_0
    //   457: invokevirtual 286	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   460: invokespecial 289	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   463: astore_0
    //   464: sipush 8192
    //   467: newarray char
    //   469: astore_1
    //   470: aload_0
    //   471: aload_1
    //   472: invokevirtual 293	java/io/InputStreamReader:read	([C)I
    //   475: istore_3
    //   476: iload_3
    //   477: ifle +55 -> 532
    //   480: aload 9
    //   482: aload_1
    //   483: iconst_0
    //   484: iload_3
    //   485: invokevirtual 296	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: goto -19 -> 470
    //   492: astore_1
    //   493: aload_0
    //   494: ifnull +7 -> 501
    //   497: aload_0
    //   498: invokevirtual 297	java/io/InputStreamReader:close	()V
    //   501: aload 9
    //   503: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: astore_0
    //   507: ldc 136
    //   509: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   512: ldc 2
    //   514: monitorexit
    //   515: aload_0
    //   516: areturn
    //   517: aload_0
    //   518: invokevirtual 304	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   521: ldc_w 306
    //   524: iconst_0
    //   525: invokestatic 312	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   528: istore_3
    //   529: goto -197 -> 332
    //   532: aload_0
    //   533: invokevirtual 297	java/io/InputStreamReader:close	()V
    //   536: goto -35 -> 501
    //   539: astore_0
    //   540: goto -39 -> 501
    //   543: astore_0
    //   544: aconst_null
    //   545: astore_1
    //   546: aload_1
    //   547: ifnull +7 -> 554
    //   550: aload_1
    //   551: invokevirtual 297	java/io/InputStreamReader:close	()V
    //   554: ldc 136
    //   556: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: aload_0
    //   560: athrow
    //   561: astore_0
    //   562: ldc 2
    //   564: monitorexit
    //   565: aload_0
    //   566: athrow
    //   567: astore_0
    //   568: goto -67 -> 501
    //   571: astore_1
    //   572: goto -18 -> 554
    //   575: astore_1
    //   576: aload_0
    //   577: astore_2
    //   578: aload_1
    //   579: astore_0
    //   580: aload_2
    //   581: astore_1
    //   582: goto -36 -> 546
    //   585: astore_0
    //   586: aconst_null
    //   587: astore_0
    //   588: goto -95 -> 493
    //   591: astore_1
    //   592: goto -140 -> 452
    //   595: astore_1
    //   596: goto -151 -> 445
    //   599: astore_2
    //   600: aload 8
    //   602: astore_2
    //   603: iload 5
    //   605: istore 4
    //   607: goto -472 -> 135
    //   610: iconst_0
    //   611: istore_3
    //   612: goto -280 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	paramContext	Context
    //   0	615	1	paramString1	String
    //   0	615	2	paramString2	String
    //   0	615	3	paramInt	int
    //   66	540	4	i	int
    //   75	529	5	j	int
    //   50	82	6	k	int
    //   59	10	7	bool	boolean
    //   54	547	8	str	String
    //   18	484	9	localStringBuilder	java.lang.StringBuilder
    //   89	37	10	localPackageInfo	android.content.pm.PackageInfo
    // Exception table:
    //   from	to	target	type
    //   464	470	492	java/io/IOException
    //   470	476	492	java/io/IOException
    //   480	489	492	java/io/IOException
    //   532	536	539	java/io/IOException
    //   344	438	543	finally
    //   438	445	543	finally
    //   445	452	543	finally
    //   452	464	543	finally
    //   3	48	561	finally
    //   56	61	561	finally
    //   77	91	561	finally
    //   95	102	561	finally
    //   113	121	561	finally
    //   125	131	561	finally
    //   135	155	561	finally
    //   158	167	561	finally
    //   170	179	561	finally
    //   182	202	561	finally
    //   202	214	561	finally
    //   214	232	561	finally
    //   232	273	561	finally
    //   277	294	561	finally
    //   294	316	561	finally
    //   316	332	561	finally
    //   336	344	561	finally
    //   497	501	561	finally
    //   501	512	561	finally
    //   517	529	561	finally
    //   532	536	561	finally
    //   550	554	561	finally
    //   554	561	561	finally
    //   497	501	567	java/io/IOException
    //   550	554	571	java/io/IOException
    //   464	470	575	finally
    //   470	476	575	finally
    //   480	489	575	finally
    //   344	438	585	java/io/IOException
    //   452	464	585	java/io/IOException
    //   445	452	591	java/io/IOException
    //   438	445	595	java/io/IOException
    //   77	91	599	java/lang/Exception
    //   95	102	599	java/lang/Exception
    //   113	121	599	java/lang/Exception
    //   125	131	599	java/lang/Exception
  }
  
  @VisibleForTesting
  private static Throwable zza(Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(90141);
        LinkedList localLinkedList = new LinkedList();
        if (paramThrowable != null)
        {
          localLinkedList.push(paramThrowable);
          paramThrowable = paramThrowable.getCause();
          continue;
          if (!localLinkedList.isEmpty())
          {
            Object localObject = (Throwable)localLinkedList.pop();
            StackTraceElement[] arrayOfStackTraceElement = ((Throwable)localObject).getStackTrace();
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new StackTraceElement(localObject.getClass().getName(), "<filtered>", "<filtered>", 1));
            int m = arrayOfStackTraceElement.length;
            int j = 0;
            if (j < m)
            {
              StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
              String str = localStackTraceElement.getClassName();
              localObject = localStackTraceElement.getFileName();
              if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith(":com.google.android.gms"))) {
                break label298;
              }
              k = 1;
              i |= k;
              localObject = localStackTraceElement;
              if (k == 0)
              {
                localObject = localStackTraceElement;
                if (!isSystemClassPrefixInternal(str)) {
                  localObject = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                }
              }
              localArrayList.add(localObject);
              j += 1;
              continue;
            }
            if (paramThrowable == null)
            {
              paramThrowable = new Throwable("<filtered>");
              paramThrowable.setStackTrace((StackTraceElement[])localArrayList.toArray(new StackTraceElement[0]));
              continue;
            }
            paramThrowable = new Throwable("<filtered>", paramThrowable);
            continue;
          }
          if (i == 0)
          {
            paramThrowable = null;
            AppMethodBeat.o(90141);
            return paramThrowable;
          }
          AppMethodBeat.o(90141);
          continue;
        }
        paramThrowable = null;
      }
      finally {}
      int i = 0;
      continue;
      label298:
      int k = 0;
    }
  }
  
  /* Error */
  private static boolean zza(Context paramContext, String paramString1, String paramString2, int paramInt, Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 386
    //   6: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 90	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: invokestatic 94	com/google/android/gms/common/util/CrashUtils:isPackageSide	()Z
    //   17: ifeq +10 -> 27
    //   20: aload_1
    //   21: invokestatic 389	com/google/android/gms/common/util/Strings:isEmptyOrWhitespace	(Ljava/lang/String;)Z
    //   24: ifeq +18 -> 42
    //   27: ldc_w 386
    //   30: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: istore 7
    //   36: ldc 2
    //   38: monitorexit
    //   39: iload 7
    //   41: ireturn
    //   42: aload_1
    //   43: invokevirtual 393	java/lang/String:hashCode	()I
    //   46: istore 6
    //   48: aload 4
    //   50: ifnonnull +36 -> 86
    //   53: getstatic 48	com/google/android/gms/common/util/CrashUtils:zzzj	I
    //   56: istore 5
    //   58: getstatic 46	com/google/android/gms/common/util/CrashUtils:zzzi	I
    //   61: iload 6
    //   63: if_icmpne +33 -> 96
    //   66: getstatic 48	com/google/android/gms/common/util/CrashUtils:zzzj	I
    //   69: iload 5
    //   71: if_icmpne +25 -> 96
    //   74: ldc_w 386
    //   77: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: istore 7
    //   83: goto -47 -> 36
    //   86: aload 4
    //   88: invokevirtual 394	java/lang/Object:hashCode	()I
    //   91: istore 5
    //   93: goto -35 -> 58
    //   96: iload 6
    //   98: putstatic 46	com/google/android/gms/common/util/CrashUtils:zzzi	I
    //   101: iload 5
    //   103: putstatic 48	com/google/android/gms/common/util/CrashUtils:zzzj	I
    //   106: getstatic 40	com/google/android/gms/common/util/CrashUtils:zzzd	Landroid/os/DropBoxManager;
    //   109: ifnull +36 -> 145
    //   112: getstatic 40	com/google/android/gms/common/util/CrashUtils:zzzd	Landroid/os/DropBoxManager;
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull +14 -> 133
    //   122: aload 4
    //   124: ldc_w 396
    //   127: invokevirtual 401	android/os/DropBoxManager:isTagEnabled	(Ljava/lang/String;)Z
    //   130: ifne +30 -> 160
    //   133: ldc_w 386
    //   136: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_0
    //   140: istore 7
    //   142: goto -106 -> 36
    //   145: aload_0
    //   146: ldc_w 403
    //   149: invokevirtual 407	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   152: checkcast 398	android/os/DropBoxManager
    //   155: astore 4
    //   157: goto -40 -> 117
    //   160: aload 4
    //   162: ldc_w 396
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iload_3
    //   169: invokestatic 409	com/google/android/gms/common/util/CrashUtils:zza	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   172: invokevirtual 413	android/os/DropBoxManager:addText	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iconst_1
    //   176: istore 7
    //   178: ldc_w 386
    //   181: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: goto -148 -> 36
    //   187: astore_0
    //   188: ldc 2
    //   190: monitorexit
    //   191: aload_0
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   0	193	1	paramString1	String
    //   0	193	2	paramString2	String
    //   0	193	3	paramInt	int
    //   0	193	4	paramThrowable	Throwable
    //   56	46	5	i	int
    //   46	51	6	j	int
    //   34	143	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	27	187	finally
    //   27	33	187	finally
    //   42	48	187	finally
    //   53	58	187	finally
    //   58	80	187	finally
    //   86	93	187	finally
    //   96	117	187	finally
    //   122	133	187	finally
    //   133	139	187	finally
    //   145	157	187	finally
    //   160	175	187	finally
    //   178	184	187	finally
  }
  
  private static boolean zzdb()
  {
    if (zzze) {
      return zzzg;
    }
    return false;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ErrorDialogData
  {
    public static final int AVG_CRASH_FREQ = 2;
    public static final int BINDER_CRASH = 268435456;
    public static final int DYNAMITE_CRASH = 536870912;
    public static final int FORCED_SHUSHED_BY_WRAPPER = 4;
    public static final int NONE = 0;
    public static final int POPUP_FREQ = 1;
    public static final int SUPPRESSED = 1073741824;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.util.CrashUtils
 * JD-Core Version:    0.7.0.1
 */