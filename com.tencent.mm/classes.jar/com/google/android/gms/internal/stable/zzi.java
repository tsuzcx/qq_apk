package com.google.android.gms.internal.stable;

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

public class zzi
{
  private static final Uri CONTENT_URI;
  private static HashMap<String, String> zzagq;
  private static final Uri zzagv;
  private static final Pattern zzagw;
  private static final Pattern zzagx;
  private static final AtomicBoolean zzagy;
  private static final HashMap<String, Boolean> zzagz;
  private static final HashMap<String, Integer> zzaha;
  private static final HashMap<String, Long> zzahb;
  private static final HashMap<String, Float> zzahc;
  private static Object zzahd;
  private static boolean zzahe;
  private static String[] zzahf;
  
  static
  {
    AppMethodBeat.i(90491);
    CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    zzagv = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    zzagw = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    zzagx = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    zzagy = new AtomicBoolean();
    zzagz = new HashMap();
    zzaha = new HashMap();
    zzahb = new HashMap();
    zzahc = new HashMap();
    zzahf = new String[0];
    AppMethodBeat.o(90491);
  }
  
  public static int getInt(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    AppMethodBeat.i(90484);
    Object localObject = zzb(paramContentResolver);
    Integer localInteger = (Integer)zza(zzaha, paramString, Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      paramInt = localInteger.intValue();
      AppMethodBeat.o(90484);
      return paramInt;
    }
    paramContentResolver = zza(paramContentResolver, paramString, null);
    if (paramContentResolver == null) {
      paramContentResolver = localInteger;
    }
    for (;;)
    {
      zza(localObject, zzaha, paramString, paramContentResolver);
      AppMethodBeat.o(90484);
      return paramInt;
      try
      {
        int i = Integer.parseInt(paramContentResolver);
        paramContentResolver = Integer.valueOf(i);
        paramInt = i;
      }
      catch (NumberFormatException paramContentResolver)
      {
        paramContentResolver = localInteger;
      }
    }
  }
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    AppMethodBeat.i(90485);
    Object localObject = zzb(paramContentResolver);
    Long localLong = (Long)zza(zzahb, paramString, Long.valueOf(paramLong));
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(90485);
      return paramLong;
    }
    paramContentResolver = zza(paramContentResolver, paramString, null);
    if (paramContentResolver == null) {
      paramContentResolver = localLong;
    }
    for (;;)
    {
      zza(localObject, zzahb, paramString, paramContentResolver);
      AppMethodBeat.o(90485);
      return paramLong;
      try
      {
        long l = Long.parseLong(paramContentResolver);
        paramContentResolver = Long.valueOf(l);
        paramLong = l;
      }
      catch (NumberFormatException paramContentResolver)
      {
        paramContentResolver = localLong;
      }
    }
  }
  
  private static <T> T zza(HashMap<String, T> paramHashMap, String paramString, T paramT)
  {
    AppMethodBeat.i(90489);
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
      AppMethodBeat.o(90489);
    }
  }
  
  /* Error */
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: invokestatic 157	com/google/android/gms/internal/stable/zzi:zza	(Landroid/content/ContentResolver;)V
    //   12: getstatic 159	com/google/android/gms/internal/stable/zzi:zzahd	Ljava/lang/Object;
    //   15: astore 7
    //   17: getstatic 161	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   20: aload_1
    //   21: invokevirtual 147	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   24: ifeq +30 -> 54
    //   27: getstatic 161	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   30: aload_1
    //   31: invokevirtual 151	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 86	java/lang/String
    //   37: astore_0
    //   38: aload_0
    //   39: ifnull +5 -> 44
    //   42: aload_0
    //   43: astore_2
    //   44: ldc 2
    //   46: monitorexit
    //   47: ldc 154
    //   49: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_2
    //   53: areturn
    //   54: getstatic 88	com/google/android/gms/internal/stable/zzi:zzahf	[Ljava/lang/String;
    //   57: astore 5
    //   59: aload 5
    //   61: arraylength
    //   62: istore 4
    //   64: iconst_0
    //   65: istore_3
    //   66: iload_3
    //   67: iload 4
    //   69: if_icmpge +104 -> 173
    //   72: aload_1
    //   73: aload 5
    //   75: iload_3
    //   76: aaload
    //   77: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   80: ifeq +86 -> 166
    //   83: getstatic 167	com/google/android/gms/internal/stable/zzi:zzahe	Z
    //   86: ifeq +12 -> 98
    //   89: getstatic 161	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   92: invokevirtual 171	java/util/HashMap:isEmpty	()Z
    //   95: ifeq +61 -> 156
    //   98: getstatic 88	com/google/android/gms/internal/stable/zzi:zzahf	[Ljava/lang/String;
    //   101: astore 5
    //   103: getstatic 161	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   106: aload_0
    //   107: aload 5
    //   109: invokestatic 174	com/google/android/gms/internal/stable/zzi:zza	(Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   112: invokevirtual 178	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   115: iconst_1
    //   116: putstatic 167	com/google/android/gms/internal/stable/zzi:zzahe	Z
    //   119: getstatic 161	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   122: aload_1
    //   123: invokevirtual 147	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   126: ifeq +30 -> 156
    //   129: getstatic 161	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   132: aload_1
    //   133: invokevirtual 151	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 86	java/lang/String
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull +5 -> 146
    //   144: aload_0
    //   145: astore_2
    //   146: ldc 2
    //   148: monitorexit
    //   149: ldc 154
    //   151: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_2
    //   155: areturn
    //   156: ldc 2
    //   158: monitorexit
    //   159: ldc 154
    //   161: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_2
    //   165: areturn
    //   166: iload_3
    //   167: iconst_1
    //   168: iadd
    //   169: istore_3
    //   170: goto -104 -> 66
    //   173: ldc 2
    //   175: monitorexit
    //   176: aload_0
    //   177: getstatic 48	com/google/android/gms/internal/stable/zzi:CONTENT_URI	Landroid/net/Uri;
    //   180: aconst_null
    //   181: aconst_null
    //   182: iconst_1
    //   183: anewarray 86	java/lang/String
    //   186: dup
    //   187: iconst_0
    //   188: aload_1
    //   189: aastore
    //   190: aconst_null
    //   191: invokevirtual 184	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   194: astore 6
    //   196: aload 6
    //   198: ifnull +13 -> 211
    //   201: aload 6
    //   203: invokeinterface 189 1 0
    //   208: ifne +40 -> 248
    //   211: aload 7
    //   213: aload_1
    //   214: aconst_null
    //   215: invokestatic 192	com/google/android/gms/internal/stable/zzi:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 6
    //   220: ifnull +10 -> 230
    //   223: aload 6
    //   225: invokeinterface 195 1 0
    //   230: ldc 154
    //   232: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_2
    //   236: areturn
    //   237: astore_0
    //   238: ldc 2
    //   240: monitorexit
    //   241: ldc 154
    //   243: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_0
    //   247: athrow
    //   248: aload 6
    //   250: iconst_1
    //   251: invokeinterface 199 2 0
    //   256: astore 5
    //   258: aload 5
    //   260: astore_0
    //   261: aload 5
    //   263: ifnull +17 -> 280
    //   266: aload 5
    //   268: astore_0
    //   269: aload 5
    //   271: aload_2
    //   272: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifeq +5 -> 280
    //   278: aload_2
    //   279: astore_0
    //   280: aload 7
    //   282: aload_1
    //   283: aload_0
    //   284: invokestatic 192	com/google/android/gms/internal/stable/zzi:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: ifnull +5 -> 293
    //   291: aload_0
    //   292: astore_2
    //   293: aload 6
    //   295: ifnull +10 -> 305
    //   298: aload 6
    //   300: invokeinterface 195 1 0
    //   305: ldc 154
    //   307: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aload_2
    //   311: areturn
    //   312: astore_0
    //   313: aload 6
    //   315: ifnull +10 -> 325
    //   318: aload 6
    //   320: invokeinterface 195 1 0
    //   325: ldc 154
    //   327: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_0
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramContentResolver	ContentResolver
    //   0	332	1	paramString1	String
    //   0	332	2	paramString2	String
    //   65	105	3	i	int
    //   62	8	4	j	int
    //   57	213	5	localObject1	Object
    //   194	125	6	localCursor	Cursor
    //   15	266	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	38	237	finally
    //   44	47	237	finally
    //   54	64	237	finally
    //   72	98	237	finally
    //   98	140	237	finally
    //   146	149	237	finally
    //   156	159	237	finally
    //   173	176	237	finally
    //   238	241	237	finally
    //   201	211	312	finally
    //   211	218	312	finally
    //   248	258	312	finally
    //   269	278	312	finally
    //   280	287	312	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    AppMethodBeat.i(90487);
    paramContentResolver = paramContentResolver.query(zzagv, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null)
    {
      AppMethodBeat.o(90487);
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
      AppMethodBeat.o(90487);
    }
  }
  
  private static void zza(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(90481);
    if (zzagq == null)
    {
      zzagy.set(false);
      zzagq = new HashMap();
      zzahd = new Object();
      zzahe = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzj(null));
      AppMethodBeat.o(90481);
      return;
    }
    if (zzagy.getAndSet(false))
    {
      zzagq.clear();
      zzagz.clear();
      zzaha.clear();
      zzahb.clear();
      zzahc.clear();
      zzahd = new Object();
      zzahe = false;
    }
    AppMethodBeat.o(90481);
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(90483);
    try
    {
      if (paramObject == zzahd) {
        zzagq.put(paramString1, paramString2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(90483);
    }
  }
  
  private static <T> void zza(Object paramObject, HashMap<String, T> paramHashMap, String paramString, T paramT)
  {
    AppMethodBeat.i(90490);
    try
    {
      if (paramObject == zzahd)
      {
        paramHashMap.put(paramString, paramT);
        zzagq.remove(paramString);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(90490);
    }
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90486);
    Object localObject = zzb(paramContentResolver);
    Boolean localBoolean = (Boolean)zza(zzagz, paramString, Boolean.valueOf(paramBoolean));
    if (localBoolean != null)
    {
      paramBoolean = localBoolean.booleanValue();
      AppMethodBeat.o(90486);
      return paramBoolean;
    }
    String str = zza(paramContentResolver, paramString, null);
    paramContentResolver = localBoolean;
    boolean bool = paramBoolean;
    if (str != null)
    {
      if (!str.equals("")) {
        break label95;
      }
      bool = paramBoolean;
      paramContentResolver = localBoolean;
    }
    for (;;)
    {
      zza(localObject, zzagz, paramString, paramContentResolver);
      AppMethodBeat.o(90486);
      return bool;
      label95:
      if (zzagw.matcher(str).matches())
      {
        bool = true;
        paramContentResolver = Boolean.TRUE;
      }
      else if (zzagx.matcher(str).matches())
      {
        bool = false;
        paramContentResolver = Boolean.FALSE;
      }
      else
      {
        new StringBuilder("attempt to read gservices key ").append(paramString).append(" (value \"").append(str).append("\") as boolean");
        paramContentResolver = localBoolean;
        bool = paramBoolean;
      }
    }
  }
  
  private static Object zzb(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(90488);
    try
    {
      zza(paramContentResolver);
      paramContentResolver = zzahd;
      return paramContentResolver;
    }
    finally
    {
      AppMethodBeat.o(90488);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzi
 * JD-Core Version:    0.7.0.1
 */