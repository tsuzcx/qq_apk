package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzwn
{
  private static final Uri CONTENT_URI;
  private static final Uri zzbmh;
  public static final Pattern zzbmi;
  public static final Pattern zzbmj;
  private static final AtomicBoolean zzbmk;
  private static HashMap<String, String> zzbml;
  private static final HashMap<String, Boolean> zzbmm;
  private static final HashMap<String, Integer> zzbmn;
  private static final HashMap<String, Long> zzbmo;
  private static final HashMap<String, Float> zzbmp;
  private static Object zzbmq;
  private static boolean zzbmr;
  private static String[] zzbms;
  
  static
  {
    AppMethodBeat.i(69751);
    CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    zzbmh = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    zzbmi = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    zzbmj = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    zzbmk = new AtomicBoolean();
    zzbmm = new HashMap();
    zzbmn = new HashMap();
    zzbmo = new HashMap();
    zzbmp = new HashMap();
    zzbms = new String[0];
    AppMethodBeat.o(69751);
  }
  
  private static <T> T zza(HashMap<String, T> paramHashMap, String paramString, T paramT)
  {
    AppMethodBeat.i(69750);
    try
    {
      if (paramHashMap.containsKey(paramString))
      {
        paramHashMap = paramHashMap.get(paramString);
        if (paramHashMap != null) {}
        for (;;)
        {
          return paramHashMap;
          paramHashMap = paramT;
        }
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(69750);
    }
  }
  
  /* Error */
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 6
    //   8: ldc 108
    //   10: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: ldc 2
    //   15: monitorenter
    //   16: aload_0
    //   17: invokestatic 111	com/google/android/gms/internal/measurement/zzwn:zza	(Landroid/content/ContentResolver;)V
    //   20: getstatic 113	com/google/android/gms/internal/measurement/zzwn:zzbmq	Ljava/lang/Object;
    //   23: astore 7
    //   25: getstatic 115	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   28: aload_1
    //   29: invokevirtual 100	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +33 -> 65
    //   35: getstatic 115	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   38: aload_1
    //   39: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 86	java/lang/String
    //   45: astore_1
    //   46: aload 6
    //   48: astore_0
    //   49: aload_1
    //   50: ifnull +5 -> 55
    //   53: aload_1
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: ldc 108
    //   60: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: getstatic 88	com/google/android/gms/internal/measurement/zzwn:zzbms	[Ljava/lang/String;
    //   68: astore 6
    //   70: aload 6
    //   72: arraylength
    //   73: istore 4
    //   75: iconst_0
    //   76: istore_3
    //   77: iload_3
    //   78: iload 4
    //   80: if_icmpge +105 -> 185
    //   83: aload_1
    //   84: aload 6
    //   86: iload_3
    //   87: aaload
    //   88: invokevirtual 119	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   91: ifeq +87 -> 178
    //   94: getstatic 121	com/google/android/gms/internal/measurement/zzwn:zzbmr	Z
    //   97: ifeq +12 -> 109
    //   100: getstatic 115	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   103: invokevirtual 125	java/util/HashMap:isEmpty	()Z
    //   106: ifeq +62 -> 168
    //   109: getstatic 88	com/google/android/gms/internal/measurement/zzwn:zzbms	[Ljava/lang/String;
    //   112: astore_2
    //   113: getstatic 115	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   116: aload_0
    //   117: aload_2
    //   118: invokestatic 128	com/google/android/gms/internal/measurement/zzwn:zza	(Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   121: invokevirtual 132	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   124: iconst_1
    //   125: putstatic 121	com/google/android/gms/internal/measurement/zzwn:zzbmr	Z
    //   128: getstatic 115	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   131: aload_1
    //   132: invokevirtual 100	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   135: ifeq +33 -> 168
    //   138: getstatic 115	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   141: aload_1
    //   142: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 86	java/lang/String
    //   148: astore_1
    //   149: aload 5
    //   151: astore_0
    //   152: aload_1
    //   153: ifnull +5 -> 158
    //   156: aload_1
    //   157: astore_0
    //   158: ldc 2
    //   160: monitorexit
    //   161: ldc 108
    //   163: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_0
    //   167: areturn
    //   168: ldc 2
    //   170: monitorexit
    //   171: ldc 108
    //   173: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aconst_null
    //   177: areturn
    //   178: iload_3
    //   179: iconst_1
    //   180: iadd
    //   181: istore_3
    //   182: goto -105 -> 77
    //   185: ldc 2
    //   187: monitorexit
    //   188: aload_0
    //   189: getstatic 48	com/google/android/gms/internal/measurement/zzwn:CONTENT_URI	Landroid/net/Uri;
    //   192: aconst_null
    //   193: aconst_null
    //   194: iconst_1
    //   195: anewarray 86	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: aload_1
    //   201: aastore
    //   202: aconst_null
    //   203: invokevirtual 138	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   206: astore 6
    //   208: aload 6
    //   210: ifnull +13 -> 223
    //   213: aload 6
    //   215: invokeinterface 143 1 0
    //   220: ifne +40 -> 260
    //   223: aload 7
    //   225: aload_1
    //   226: aconst_null
    //   227: invokestatic 146	com/google/android/gms/internal/measurement/zzwn:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 6
    //   232: ifnull +10 -> 242
    //   235: aload 6
    //   237: invokeinterface 149 1 0
    //   242: ldc 108
    //   244: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: ldc 2
    //   252: monitorexit
    //   253: ldc 108
    //   255: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_0
    //   259: athrow
    //   260: aload 6
    //   262: iconst_1
    //   263: invokeinterface 153 2 0
    //   268: astore 5
    //   270: aload 5
    //   272: astore_0
    //   273: aload 5
    //   275: ifnull +17 -> 292
    //   278: aload 5
    //   280: astore_0
    //   281: aload 5
    //   283: aconst_null
    //   284: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifeq +5 -> 292
    //   290: aconst_null
    //   291: astore_0
    //   292: aload 7
    //   294: aload_1
    //   295: aload_0
    //   296: invokestatic 146	com/google/android/gms/internal/measurement/zzwn:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_2
    //   300: astore_1
    //   301: aload_0
    //   302: ifnull +5 -> 307
    //   305: aload_0
    //   306: astore_1
    //   307: aload 6
    //   309: ifnull +10 -> 319
    //   312: aload 6
    //   314: invokeinterface 149 1 0
    //   319: ldc 108
    //   321: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_1
    //   325: areturn
    //   326: astore_0
    //   327: aload 6
    //   329: ifnull +10 -> 339
    //   332: aload 6
    //   334: invokeinterface 149 1 0
    //   339: ldc 108
    //   341: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_0
    //   345: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramContentResolver	ContentResolver
    //   0	346	1	paramString1	String
    //   0	346	2	paramString2	String
    //   76	106	3	i	int
    //   73	8	4	j	int
    //   1	281	5	str	String
    //   6	327	6	localObject1	Object
    //   23	270	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	46	249	finally
    //   55	58	249	finally
    //   65	75	249	finally
    //   83	109	249	finally
    //   109	149	249	finally
    //   158	161	249	finally
    //   168	171	249	finally
    //   185	188	249	finally
    //   250	253	249	finally
    //   213	223	326	finally
    //   223	230	326	finally
    //   260	270	326	finally
    //   281	290	326	finally
    //   292	299	326	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    AppMethodBeat.i(69748);
    paramContentResolver = paramContentResolver.query(zzbmh, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null)
    {
      AppMethodBeat.o(69748);
      return paramVarArgs;
    }
    try
    {
      if (paramContentResolver.moveToNext()) {}
      return paramVarArgs;
    }
    finally
    {
      paramContentResolver.close();
      AppMethodBeat.o(69748);
    }
  }
  
  private static void zza(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(69744);
    if (zzbml == null)
    {
      zzbmk.set(false);
      zzbml = new HashMap();
      zzbmq = new Object();
      zzbmr = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzwo(null));
      AppMethodBeat.o(69744);
      return;
    }
    if (zzbmk.getAndSet(false))
    {
      zzbml.clear();
      zzbmm.clear();
      zzbmn.clear();
      zzbmo.clear();
      zzbmp.clear();
      zzbmq = new Object();
      zzbmr = false;
    }
    AppMethodBeat.o(69744);
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69746);
    try
    {
      if (paramObject == zzbmq) {
        zzbml.put(paramString1, paramString2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(69746);
    }
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69747);
    Object localObject2 = zzb(paramContentResolver);
    Object localObject1 = (Boolean)zza(zzbmm, paramString, Boolean.valueOf(paramBoolean));
    if (localObject1 != null)
    {
      paramBoolean = ((Boolean)localObject1).booleanValue();
      AppMethodBeat.o(69747);
      return paramBoolean;
    }
    String str = zza(paramContentResolver, paramString, null);
    paramContentResolver = (ContentResolver)localObject1;
    boolean bool = paramBoolean;
    if (str != null)
    {
      if (!str.equals("")) {
        break label120;
      }
      bool = paramBoolean;
      paramContentResolver = (ContentResolver)localObject1;
    }
    for (;;)
    {
      localObject1 = zzbmm;
      try
      {
        if (localObject2 == zzbmq)
        {
          ((HashMap)localObject1).put(paramString, paramContentResolver);
          zzbml.remove(paramString);
        }
        return bool;
      }
      finally
      {
        label120:
        AppMethodBeat.o(69747);
      }
      if (zzbmi.matcher(str).matches())
      {
        bool = true;
        paramContentResolver = Boolean.TRUE;
      }
      else if (zzbmj.matcher(str).matches())
      {
        bool = false;
        paramContentResolver = Boolean.FALSE;
      }
      else
      {
        new StringBuilder("attempt to read gservices key ").append(paramString).append(" (value \"").append(str).append("\") as boolean");
        paramContentResolver = (ContentResolver)localObject1;
        bool = paramBoolean;
      }
    }
  }
  
  private static Object zzb(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(69749);
    try
    {
      zza(paramContentResolver);
      paramContentResolver = zzbmq;
      return paramContentResolver;
    }
    finally
    {
      AppMethodBeat.o(69749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwn
 * JD-Core Version:    0.7.0.1
 */