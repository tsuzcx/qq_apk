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

public final class CrashUtils
{
  private static final String[] zzzc = { "android.", "com.android.", "dalvik.", "java.", "javax." };
  private static DropBoxManager zzzd = null;
  private static boolean zzze = false;
  private static boolean zzzf;
  private static boolean zzzg;
  private static int zzzh = -1;
  private static int zzzi = 0;
  private static int zzzj = 0;
  
  public static boolean addDynamiteErrorToDropBox(Context paramContext, Throwable paramThrowable)
  {
    AppMethodBeat.i(5157);
    boolean bool = addErrorToDropBoxInternal(paramContext, paramThrowable, 536870912);
    AppMethodBeat.o(5157);
    return bool;
  }
  
  @Deprecated
  public static boolean addErrorToDropBox(Context paramContext, Throwable paramThrowable)
  {
    AppMethodBeat.i(5158);
    boolean bool = addDynamiteErrorToDropBox(paramContext, paramThrowable);
    AppMethodBeat.o(5158);
    return bool;
  }
  
  public static boolean addErrorToDropBoxInternal(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(5160);
    boolean bool = zza(paramContext, paramString1, paramString2, paramInt, null);
    AppMethodBeat.o(5160);
    return bool;
  }
  
  public static boolean addErrorToDropBoxInternal(Context paramContext, Throwable paramThrowable, int paramInt)
  {
    AppMethodBeat.i(5159);
    try
    {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramThrowable);
      bool = isPackageSide();
      if (!bool)
      {
        AppMethodBeat.o(5159);
        return false;
      }
      Throwable localThrowable = paramThrowable;
      if (!zzdb())
      {
        paramThrowable = zza(paramThrowable);
        localThrowable = paramThrowable;
        if (paramThrowable == null)
        {
          AppMethodBeat.o(5159);
          return false;
        }
      }
      bool = zza(paramContext, Log.getStackTraceString(localThrowable), ProcessUtils.getMyProcessName(), paramInt, localThrowable);
      AppMethodBeat.o(5159);
      return bool;
    }
    catch (Exception paramContext)
    {
      try
      {
        bool = zzdb();
        if (bool)
        {
          AppMethodBeat.o(5159);
          throw paramContext;
        }
      }
      catch (Exception paramThrowable)
      {
        for (;;)
        {
          boolean bool = false;
        }
        AppMethodBeat.o(5159);
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
    AppMethodBeat.i(5162);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(5162);
      return false;
    }
    String[] arrayOfString = zzzc;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.startsWith(arrayOfString[i]))
      {
        AppMethodBeat.o(5162);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(5162);
    return false;
  }
  
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
  private static String zza(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 5164
    //   6: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 127	java/lang/StringBuilder
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 129	java/lang/StringBuilder:<init>	(I)V
    //   19: astore 9
    //   21: aload 9
    //   23: ldc 131
    //   25: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokestatic 141	com/google/android/gms/common/util/Strings:nullToEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 143
    //   37: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 9
    //   43: ldc 145
    //   45: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 146
    //   51: istore 6
    //   53: ldc 148
    //   55: astore 8
    //   57: invokestatic 90	com/google/android/gms/common/util/CrashUtils:zzdb	()Z
    //   60: istore 7
    //   62: aload 8
    //   64: astore_2
    //   65: iload 6
    //   67: istore 4
    //   69: iload 7
    //   71: ifeq +65 -> 136
    //   74: iload 6
    //   76: istore 5
    //   78: aload_0
    //   79: invokestatic 154	com/google/android/gms/common/wrappers/Wrappers:packageManager	(Landroid/content/Context;)Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   82: aload_0
    //   83: invokevirtual 159	android/content/Context:getPackageName	()Ljava/lang/String;
    //   86: iconst_0
    //   87: invokevirtual 165	com/google/android/gms/common/wrappers/PackageManagerWrapper:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   90: astore 10
    //   92: iload 6
    //   94: istore 5
    //   96: aload 10
    //   98: getfield 170	android/content/pm/PackageInfo:versionCode	I
    //   101: istore 6
    //   103: aload 8
    //   105: astore_2
    //   106: iload 6
    //   108: istore 4
    //   110: iload 6
    //   112: istore 5
    //   114: aload 10
    //   116: getfield 174	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   119: ifnull +17 -> 136
    //   122: iload 6
    //   124: istore 5
    //   126: aload 10
    //   128: getfield 174	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   131: astore_2
    //   132: iload 6
    //   134: istore 4
    //   136: aload 9
    //   138: ldc 176
    //   140: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload 4
    //   145: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne +80 -> 233
    //   156: aload_2
    //   157: astore 8
    //   159: aload_2
    //   160: ldc 181
    //   162: invokevirtual 184	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +50 -> 215
    //   168: aload_2
    //   169: astore 8
    //   171: aload_2
    //   172: ldc 186
    //   174: invokevirtual 184	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   177: ifne +38 -> 215
    //   180: aload_2
    //   181: astore 8
    //   183: aload_2
    //   184: ldc 188
    //   186: invokevirtual 191	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   189: ifeq +14 -> 203
    //   192: aload_2
    //   193: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: ldc 197
    //   198: invokevirtual 200	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   201: astore 8
    //   203: aload 8
    //   205: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   208: ldc 186
    //   210: invokevirtual 200	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   213: astore 8
    //   215: aload 9
    //   217: ldc 202
    //   219: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 8
    //   224: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 186
    //   229: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 9
    //   235: ldc 143
    //   237: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 9
    //   243: ldc 204
    //   245: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: getstatic 209	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   251: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc 143
    //   256: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: invokestatic 214	android/os/Debug:isDebuggerConnected	()Z
    //   263: ifeq +11 -> 274
    //   266: aload 9
    //   268: ldc 216
    //   270: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: iload_3
    //   275: ifeq +20 -> 295
    //   278: aload 9
    //   280: ldc 218
    //   282: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: iload_3
    //   286: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: ldc 143
    //   291: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 9
    //   297: ldc 143
    //   299: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_1
    //   304: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifne +10 -> 317
    //   310: aload 9
    //   312: aload_1
    //   313: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: invokestatic 90	com/google/android/gms/common/util/CrashUtils:zzdb	()Z
    //   320: ifeq +293 -> 613
    //   323: getstatic 41	com/google/android/gms/common/util/CrashUtils:zzzh	I
    //   326: iflt +193 -> 519
    //   329: getstatic 41	com/google/android/gms/common/util/CrashUtils:zzzh	I
    //   332: istore_3
    //   333: iload_3
    //   334: ifle +168 -> 502
    //   337: aload 9
    //   339: ldc 143
    //   341: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: new 220	java/lang/ProcessBuilder
    //   348: dup
    //   349: bipush 13
    //   351: anewarray 23	java/lang/String
    //   354: dup
    //   355: iconst_0
    //   356: ldc 222
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: ldc 224
    //   363: aastore
    //   364: dup
    //   365: iconst_2
    //   366: ldc 226
    //   368: aastore
    //   369: dup
    //   370: iconst_3
    //   371: ldc 228
    //   373: aastore
    //   374: dup
    //   375: iconst_4
    //   376: ldc 230
    //   378: aastore
    //   379: dup
    //   380: iconst_5
    //   381: ldc 228
    //   383: aastore
    //   384: dup
    //   385: bipush 6
    //   387: ldc 232
    //   389: aastore
    //   390: dup
    //   391: bipush 7
    //   393: ldc 228
    //   395: aastore
    //   396: dup
    //   397: bipush 8
    //   399: ldc 234
    //   401: aastore
    //   402: dup
    //   403: bipush 9
    //   405: ldc 228
    //   407: aastore
    //   408: dup
    //   409: bipush 10
    //   411: ldc 236
    //   413: aastore
    //   414: dup
    //   415: bipush 11
    //   417: ldc 238
    //   419: aastore
    //   420: dup
    //   421: bipush 12
    //   423: iload_3
    //   424: invokestatic 241	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   427: aastore
    //   428: invokespecial 244	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   431: iconst_1
    //   432: invokevirtual 248	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   435: invokevirtual 252	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   438: astore_0
    //   439: aload_0
    //   440: invokevirtual 258	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   443: invokevirtual 263	java/io/OutputStream:close	()V
    //   446: aload_0
    //   447: invokevirtual 267	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   450: invokevirtual 270	java/io/InputStream:close	()V
    //   453: new 272	java/io/InputStreamReader
    //   456: dup
    //   457: aload_0
    //   458: invokevirtual 275	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   461: invokespecial 278	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   464: astore_0
    //   465: sipush 8192
    //   468: newarray char
    //   470: astore_1
    //   471: aload_0
    //   472: aload_1
    //   473: invokevirtual 282	java/io/InputStreamReader:read	([C)I
    //   476: istore_3
    //   477: iload_3
    //   478: ifle +56 -> 534
    //   481: aload 9
    //   483: aload_1
    //   484: iconst_0
    //   485: iload_3
    //   486: invokevirtual 285	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: goto -19 -> 471
    //   493: astore_1
    //   494: aload_0
    //   495: ifnull +7 -> 502
    //   498: aload_0
    //   499: invokevirtual 286	java/io/InputStreamReader:close	()V
    //   502: aload 9
    //   504: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: astore_0
    //   508: sipush 5164
    //   511: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   514: ldc 2
    //   516: monitorexit
    //   517: aload_0
    //   518: areturn
    //   519: aload_0
    //   520: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   523: ldc_w 295
    //   526: iconst_0
    //   527: invokestatic 301	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   530: istore_3
    //   531: goto -198 -> 333
    //   534: aload_0
    //   535: invokevirtual 286	java/io/InputStreamReader:close	()V
    //   538: goto -36 -> 502
    //   541: astore_0
    //   542: goto -40 -> 502
    //   545: astore_0
    //   546: aconst_null
    //   547: astore_1
    //   548: aload_1
    //   549: ifnull +7 -> 556
    //   552: aload_1
    //   553: invokevirtual 286	java/io/InputStreamReader:close	()V
    //   556: sipush 5164
    //   559: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: aload_0
    //   563: athrow
    //   564: astore_0
    //   565: ldc 2
    //   567: monitorexit
    //   568: aload_0
    //   569: athrow
    //   570: astore_0
    //   571: goto -69 -> 502
    //   574: astore_1
    //   575: goto -19 -> 556
    //   578: astore_1
    //   579: aload_0
    //   580: astore_2
    //   581: aload_1
    //   582: astore_0
    //   583: aload_2
    //   584: astore_1
    //   585: goto -37 -> 548
    //   588: astore_0
    //   589: aconst_null
    //   590: astore_0
    //   591: goto -97 -> 494
    //   594: astore_1
    //   595: goto -142 -> 453
    //   598: astore_1
    //   599: goto -153 -> 446
    //   602: astore_2
    //   603: aload 8
    //   605: astore_2
    //   606: iload 5
    //   608: istore 4
    //   610: goto -474 -> 136
    //   613: iconst_0
    //   614: istore_3
    //   615: goto -282 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	paramContext	Context
    //   0	618	1	paramString1	String
    //   0	618	2	paramString2	String
    //   0	618	3	paramInt	int
    //   67	542	4	i	int
    //   76	531	5	j	int
    //   51	82	6	k	int
    //   60	10	7	bool	boolean
    //   55	549	8	str	String
    //   19	484	9	localStringBuilder	java.lang.StringBuilder
    //   90	37	10	localPackageInfo	android.content.pm.PackageInfo
    // Exception table:
    //   from	to	target	type
    //   465	471	493	java/io/IOException
    //   471	477	493	java/io/IOException
    //   481	490	493	java/io/IOException
    //   534	538	541	java/io/IOException
    //   345	439	545	finally
    //   439	446	545	finally
    //   446	453	545	finally
    //   453	465	545	finally
    //   3	49	564	finally
    //   57	62	564	finally
    //   78	92	564	finally
    //   96	103	564	finally
    //   114	122	564	finally
    //   126	132	564	finally
    //   136	156	564	finally
    //   159	168	564	finally
    //   171	180	564	finally
    //   183	203	564	finally
    //   203	215	564	finally
    //   215	233	564	finally
    //   233	274	564	finally
    //   278	295	564	finally
    //   295	317	564	finally
    //   317	333	564	finally
    //   337	345	564	finally
    //   498	502	564	finally
    //   502	514	564	finally
    //   519	531	564	finally
    //   534	538	564	finally
    //   552	556	564	finally
    //   556	564	564	finally
    //   498	502	570	java/io/IOException
    //   552	556	574	java/io/IOException
    //   465	471	578	finally
    //   471	477	578	finally
    //   481	490	578	finally
    //   345	439	588	java/io/IOException
    //   453	465	588	java/io/IOException
    //   446	453	594	java/io/IOException
    //   439	446	598	java/io/IOException
    //   78	92	602	java/lang/Exception
    //   96	103	602	java/lang/Exception
    //   114	122	602	java/lang/Exception
    //   126	132	602	java/lang/Exception
  }
  
  private static Throwable zza(Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(5163);
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
            AppMethodBeat.o(5163);
            return paramThrowable;
          }
          AppMethodBeat.o(5163);
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
    //   3: sipush 5161
    //   6: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 83	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: invokestatic 87	com/google/android/gms/common/util/CrashUtils:isPackageSide	()Z
    //   17: ifeq +10 -> 27
    //   20: aload_1
    //   21: invokestatic 376	com/google/android/gms/common/util/Strings:isEmptyOrWhitespace	(Ljava/lang/String;)Z
    //   24: ifeq +18 -> 42
    //   27: sipush 5161
    //   30: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: istore 7
    //   36: ldc 2
    //   38: monitorexit
    //   39: iload 7
    //   41: ireturn
    //   42: aload_1
    //   43: invokevirtual 380	java/lang/String:hashCode	()I
    //   46: istore 6
    //   48: aload 4
    //   50: ifnonnull +36 -> 86
    //   53: getstatic 45	com/google/android/gms/common/util/CrashUtils:zzzj	I
    //   56: istore 5
    //   58: getstatic 43	com/google/android/gms/common/util/CrashUtils:zzzi	I
    //   61: iload 6
    //   63: if_icmpne +33 -> 96
    //   66: getstatic 45	com/google/android/gms/common/util/CrashUtils:zzzj	I
    //   69: iload 5
    //   71: if_icmpne +25 -> 96
    //   74: sipush 5161
    //   77: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: istore 7
    //   83: goto -47 -> 36
    //   86: aload 4
    //   88: invokevirtual 381	java/lang/Object:hashCode	()I
    //   91: istore 5
    //   93: goto -35 -> 58
    //   96: iload 6
    //   98: putstatic 43	com/google/android/gms/common/util/CrashUtils:zzzi	I
    //   101: iload 5
    //   103: putstatic 45	com/google/android/gms/common/util/CrashUtils:zzzj	I
    //   106: getstatic 37	com/google/android/gms/common/util/CrashUtils:zzzd	Landroid/os/DropBoxManager;
    //   109: ifnull +36 -> 145
    //   112: getstatic 37	com/google/android/gms/common/util/CrashUtils:zzzd	Landroid/os/DropBoxManager;
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull +14 -> 133
    //   122: aload 4
    //   124: ldc_w 383
    //   127: invokevirtual 388	android/os/DropBoxManager:isTagEnabled	(Ljava/lang/String;)Z
    //   130: ifne +30 -> 160
    //   133: sipush 5161
    //   136: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_0
    //   140: istore 7
    //   142: goto -106 -> 36
    //   145: aload_0
    //   146: ldc_w 390
    //   149: invokevirtual 394	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   152: checkcast 385	android/os/DropBoxManager
    //   155: astore 4
    //   157: goto -40 -> 117
    //   160: aload 4
    //   162: ldc_w 383
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iload_3
    //   169: invokestatic 396	com/google/android/gms/common/util/CrashUtils:zza	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   172: invokevirtual 400	android/os/DropBoxManager:addText	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iconst_1
    //   176: istore 7
    //   178: sipush 5161
    //   181: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.CrashUtils
 * JD-Core Version:    0.7.0.1
 */