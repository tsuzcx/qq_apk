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
    AppMethodBeat.i(2274);
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
    AppMethodBeat.o(2274);
  }
  
  private static <T> T zza(HashMap<String, T> paramHashMap, String paramString, T paramT)
  {
    AppMethodBeat.i(2273);
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
      AppMethodBeat.o(2273);
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
    //   8: sipush 2268
    //   11: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 2
    //   16: monitorenter
    //   17: aload_0
    //   18: invokestatic 108	com/google/android/gms/internal/measurement/zzwn:zza	(Landroid/content/ContentResolver;)V
    //   21: getstatic 110	com/google/android/gms/internal/measurement/zzwn:zzbmq	Ljava/lang/Object;
    //   24: astore 7
    //   26: getstatic 112	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 98	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   33: ifeq +34 -> 67
    //   36: getstatic 112	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   39: aload_1
    //   40: invokevirtual 102	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 85	java/lang/String
    //   46: astore_1
    //   47: aload 6
    //   49: astore_0
    //   50: aload_1
    //   51: ifnull +5 -> 56
    //   54: aload_1
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: sipush 2268
    //   62: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: getstatic 87	com/google/android/gms/internal/measurement/zzwn:zzbms	[Ljava/lang/String;
    //   70: astore 6
    //   72: aload 6
    //   74: arraylength
    //   75: istore 4
    //   77: iconst_0
    //   78: istore_3
    //   79: iload_3
    //   80: iload 4
    //   82: if_icmpge +107 -> 189
    //   85: aload_1
    //   86: aload 6
    //   88: iload_3
    //   89: aaload
    //   90: invokevirtual 116	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   93: ifeq +89 -> 182
    //   96: getstatic 118	com/google/android/gms/internal/measurement/zzwn:zzbmr	Z
    //   99: ifeq +12 -> 111
    //   102: getstatic 112	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   105: invokevirtual 122	java/util/HashMap:isEmpty	()Z
    //   108: ifeq +63 -> 171
    //   111: getstatic 87	com/google/android/gms/internal/measurement/zzwn:zzbms	[Ljava/lang/String;
    //   114: astore_2
    //   115: getstatic 112	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   118: aload_0
    //   119: aload_2
    //   120: invokestatic 125	com/google/android/gms/internal/measurement/zzwn:zza	(Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   123: invokevirtual 129	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   126: iconst_1
    //   127: putstatic 118	com/google/android/gms/internal/measurement/zzwn:zzbmr	Z
    //   130: getstatic 112	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   133: aload_1
    //   134: invokevirtual 98	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   137: ifeq +34 -> 171
    //   140: getstatic 112	com/google/android/gms/internal/measurement/zzwn:zzbml	Ljava/util/HashMap;
    //   143: aload_1
    //   144: invokevirtual 102	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 85	java/lang/String
    //   150: astore_1
    //   151: aload 5
    //   153: astore_0
    //   154: aload_1
    //   155: ifnull +5 -> 160
    //   158: aload_1
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: sipush 2268
    //   166: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_0
    //   170: areturn
    //   171: ldc 2
    //   173: monitorexit
    //   174: sipush 2268
    //   177: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aconst_null
    //   181: areturn
    //   182: iload_3
    //   183: iconst_1
    //   184: iadd
    //   185: istore_3
    //   186: goto -107 -> 79
    //   189: ldc 2
    //   191: monitorexit
    //   192: aload_0
    //   193: getstatic 47	com/google/android/gms/internal/measurement/zzwn:CONTENT_URI	Landroid/net/Uri;
    //   196: aconst_null
    //   197: aconst_null
    //   198: iconst_1
    //   199: anewarray 85	java/lang/String
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: aconst_null
    //   207: invokevirtual 135	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   210: astore 6
    //   212: aload 6
    //   214: ifnull +13 -> 227
    //   217: aload 6
    //   219: invokeinterface 140 1 0
    //   224: ifne +42 -> 266
    //   227: aload 7
    //   229: aload_1
    //   230: aconst_null
    //   231: invokestatic 143	com/google/android/gms/internal/measurement/zzwn:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload 6
    //   236: ifnull +10 -> 246
    //   239: aload 6
    //   241: invokeinterface 146 1 0
    //   246: sipush 2268
    //   249: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: ldc 2
    //   257: monitorexit
    //   258: sipush 2268
    //   261: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_0
    //   265: athrow
    //   266: aload 6
    //   268: iconst_1
    //   269: invokeinterface 150 2 0
    //   274: astore 5
    //   276: aload 5
    //   278: astore_0
    //   279: aload 5
    //   281: ifnull +17 -> 298
    //   284: aload 5
    //   286: astore_0
    //   287: aload 5
    //   289: aconst_null
    //   290: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +5 -> 298
    //   296: aconst_null
    //   297: astore_0
    //   298: aload 7
    //   300: aload_1
    //   301: aload_0
    //   302: invokestatic 143	com/google/android/gms/internal/measurement/zzwn:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_2
    //   306: astore_1
    //   307: aload_0
    //   308: ifnull +5 -> 313
    //   311: aload_0
    //   312: astore_1
    //   313: aload 6
    //   315: ifnull +10 -> 325
    //   318: aload 6
    //   320: invokeinterface 146 1 0
    //   325: sipush 2268
    //   328: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_1
    //   332: areturn
    //   333: astore_0
    //   334: aload 6
    //   336: ifnull +10 -> 346
    //   339: aload 6
    //   341: invokeinterface 146 1 0
    //   346: sipush 2268
    //   349: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload_0
    //   353: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramContentResolver	ContentResolver
    //   0	354	1	paramString1	String
    //   0	354	2	paramString2	String
    //   78	108	3	i	int
    //   75	8	4	j	int
    //   1	287	5	str	String
    //   6	334	6	localObject1	Object
    //   24	275	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	47	254	finally
    //   56	59	254	finally
    //   67	77	254	finally
    //   85	111	254	finally
    //   111	151	254	finally
    //   160	163	254	finally
    //   171	174	254	finally
    //   189	192	254	finally
    //   255	258	254	finally
    //   217	227	333	finally
    //   227	234	333	finally
    //   266	276	333	finally
    //   287	296	333	finally
    //   298	305	333	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    AppMethodBeat.i(2271);
    paramContentResolver = paramContentResolver.query(zzbmh, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null)
    {
      AppMethodBeat.o(2271);
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
      AppMethodBeat.o(2271);
    }
  }
  
  private static void zza(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(2267);
    if (zzbml == null)
    {
      zzbmk.set(false);
      zzbml = new HashMap();
      zzbmq = new Object();
      zzbmr = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzwo(null));
      AppMethodBeat.o(2267);
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
    AppMethodBeat.o(2267);
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(2269);
    try
    {
      if (paramObject == zzbmq) {
        zzbml.put(paramString1, paramString2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(2269);
    }
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(2270);
    Object localObject2 = zzb(paramContentResolver);
    Object localObject1 = (Boolean)zza(zzbmm, paramString, Boolean.valueOf(paramBoolean));
    if (localObject1 != null)
    {
      paramBoolean = ((Boolean)localObject1).booleanValue();
      AppMethodBeat.o(2270);
      return paramBoolean;
    }
    String str = zza(paramContentResolver, paramString, null);
    paramContentResolver = (ContentResolver)localObject1;
    boolean bool = paramBoolean;
    if (str != null)
    {
      if (!str.equals("")) {
        break label123;
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
        label123:
        AppMethodBeat.o(2270);
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
    AppMethodBeat.i(2272);
    try
    {
      zza(paramContentResolver);
      paramContentResolver = zzbmq;
      return paramContentResolver;
    }
    finally
    {
      AppMethodBeat.o(2272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwn
 * JD-Core Version:    0.7.0.1
 */