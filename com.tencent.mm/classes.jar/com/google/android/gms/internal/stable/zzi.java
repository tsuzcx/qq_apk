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
    AppMethodBeat.i(5512);
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
    AppMethodBeat.o(5512);
  }
  
  public static int getInt(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    AppMethodBeat.i(5505);
    Object localObject = zzb(paramContentResolver);
    Integer localInteger = (Integer)zza(zzaha, paramString, Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      paramInt = localInteger.intValue();
      AppMethodBeat.o(5505);
      return paramInt;
    }
    paramContentResolver = zza(paramContentResolver, paramString, null);
    if (paramContentResolver == null) {
      paramContentResolver = localInteger;
    }
    for (;;)
    {
      zza(localObject, zzaha, paramString, paramContentResolver);
      AppMethodBeat.o(5505);
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
    AppMethodBeat.i(5506);
    Object localObject = zzb(paramContentResolver);
    Long localLong = (Long)zza(zzahb, paramString, Long.valueOf(paramLong));
    if (localLong != null)
    {
      paramLong = localLong.longValue();
      AppMethodBeat.o(5506);
      return paramLong;
    }
    paramContentResolver = zza(paramContentResolver, paramString, null);
    if (paramContentResolver == null) {
      paramContentResolver = localLong;
    }
    for (;;)
    {
      zza(localObject, zzahb, paramString, paramContentResolver);
      AppMethodBeat.o(5506);
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
    AppMethodBeat.i(5510);
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
      AppMethodBeat.o(5510);
    }
  }
  
  /* Error */
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 5503
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: invokestatic 152	com/google/android/gms/internal/stable/zzi:zza	(Landroid/content/ContentResolver;)V
    //   13: getstatic 154	com/google/android/gms/internal/stable/zzi:zzahd	Ljava/lang/Object;
    //   16: astore 7
    //   18: getstatic 156	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   21: aload_1
    //   22: invokevirtual 143	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   25: ifeq +31 -> 56
    //   28: getstatic 156	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   31: aload_1
    //   32: invokevirtual 147	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 85	java/lang/String
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +5 -> 45
    //   43: aload_0
    //   44: astore_2
    //   45: ldc 2
    //   47: monitorexit
    //   48: sipush 5503
    //   51: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_2
    //   55: areturn
    //   56: getstatic 87	com/google/android/gms/internal/stable/zzi:zzahf	[Ljava/lang/String;
    //   59: astore 5
    //   61: aload 5
    //   63: arraylength
    //   64: istore 4
    //   66: iconst_0
    //   67: istore_3
    //   68: iload_3
    //   69: iload 4
    //   71: if_icmpge +106 -> 177
    //   74: aload_1
    //   75: aload 5
    //   77: iload_3
    //   78: aaload
    //   79: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +88 -> 170
    //   85: getstatic 162	com/google/android/gms/internal/stable/zzi:zzahe	Z
    //   88: ifeq +12 -> 100
    //   91: getstatic 156	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   94: invokevirtual 166	java/util/HashMap:isEmpty	()Z
    //   97: ifeq +62 -> 159
    //   100: getstatic 87	com/google/android/gms/internal/stable/zzi:zzahf	[Ljava/lang/String;
    //   103: astore 5
    //   105: getstatic 156	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   108: aload_0
    //   109: aload 5
    //   111: invokestatic 169	com/google/android/gms/internal/stable/zzi:zza	(Landroid/content/ContentResolver;[Ljava/lang/String;)Ljava/util/Map;
    //   114: invokevirtual 173	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   117: iconst_1
    //   118: putstatic 162	com/google/android/gms/internal/stable/zzi:zzahe	Z
    //   121: getstatic 156	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   124: aload_1
    //   125: invokevirtual 143	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   128: ifeq +31 -> 159
    //   131: getstatic 156	com/google/android/gms/internal/stable/zzi:zzagq	Ljava/util/HashMap;
    //   134: aload_1
    //   135: invokevirtual 147	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 85	java/lang/String
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +5 -> 148
    //   146: aload_0
    //   147: astore_2
    //   148: ldc 2
    //   150: monitorexit
    //   151: sipush 5503
    //   154: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_2
    //   158: areturn
    //   159: ldc 2
    //   161: monitorexit
    //   162: sipush 5503
    //   165: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_2
    //   169: areturn
    //   170: iload_3
    //   171: iconst_1
    //   172: iadd
    //   173: istore_3
    //   174: goto -106 -> 68
    //   177: ldc 2
    //   179: monitorexit
    //   180: aload_0
    //   181: getstatic 47	com/google/android/gms/internal/stable/zzi:CONTENT_URI	Landroid/net/Uri;
    //   184: aconst_null
    //   185: aconst_null
    //   186: iconst_1
    //   187: anewarray 85	java/lang/String
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: aastore
    //   194: aconst_null
    //   195: invokevirtual 179	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   198: astore 6
    //   200: aload 6
    //   202: ifnull +13 -> 215
    //   205: aload 6
    //   207: invokeinterface 184 1 0
    //   212: ifne +42 -> 254
    //   215: aload 7
    //   217: aload_1
    //   218: aconst_null
    //   219: invokestatic 187	com/google/android/gms/internal/stable/zzi:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 6
    //   224: ifnull +10 -> 234
    //   227: aload 6
    //   229: invokeinterface 190 1 0
    //   234: sipush 5503
    //   237: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_2
    //   241: areturn
    //   242: astore_0
    //   243: ldc 2
    //   245: monitorexit
    //   246: sipush 5503
    //   249: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: athrow
    //   254: aload 6
    //   256: iconst_1
    //   257: invokeinterface 194 2 0
    //   262: astore 5
    //   264: aload 5
    //   266: astore_0
    //   267: aload 5
    //   269: ifnull +17 -> 286
    //   272: aload 5
    //   274: astore_0
    //   275: aload 5
    //   277: aload_2
    //   278: invokevirtual 197	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifeq +5 -> 286
    //   284: aload_2
    //   285: astore_0
    //   286: aload 7
    //   288: aload_1
    //   289: aload_0
    //   290: invokestatic 187	com/google/android/gms/internal/stable/zzi:zza	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: ifnull +5 -> 299
    //   297: aload_0
    //   298: astore_2
    //   299: aload 6
    //   301: ifnull +10 -> 311
    //   304: aload 6
    //   306: invokeinterface 190 1 0
    //   311: sipush 5503
    //   314: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload_2
    //   318: areturn
    //   319: astore_0
    //   320: aload 6
    //   322: ifnull +10 -> 332
    //   325: aload 6
    //   327: invokeinterface 190 1 0
    //   332: sipush 5503
    //   335: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_0
    //   339: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContentResolver	ContentResolver
    //   0	340	1	paramString1	String
    //   0	340	2	paramString2	String
    //   67	107	3	i	int
    //   64	8	4	j	int
    //   59	217	5	localObject1	Object
    //   198	128	6	localCursor	Cursor
    //   16	271	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	39	242	finally
    //   45	48	242	finally
    //   56	66	242	finally
    //   74	100	242	finally
    //   100	142	242	finally
    //   148	151	242	finally
    //   159	162	242	finally
    //   177	180	242	finally
    //   243	246	242	finally
    //   205	215	319	finally
    //   215	222	319	finally
    //   254	264	319	finally
    //   275	284	319	finally
    //   286	293	319	finally
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    AppMethodBeat.i(5508);
    paramContentResolver = paramContentResolver.query(zzagv, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null)
    {
      AppMethodBeat.o(5508);
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
      AppMethodBeat.o(5508);
    }
  }
  
  private static void zza(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(5502);
    if (zzagq == null)
    {
      zzagy.set(false);
      zzagq = new HashMap();
      zzahd = new Object();
      zzahe = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzj(null));
      AppMethodBeat.o(5502);
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
    AppMethodBeat.o(5502);
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5504);
    try
    {
      if (paramObject == zzahd) {
        zzagq.put(paramString1, paramString2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(5504);
    }
  }
  
  private static <T> void zza(Object paramObject, HashMap<String, T> paramHashMap, String paramString, T paramT)
  {
    AppMethodBeat.i(5511);
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
      AppMethodBeat.o(5511);
    }
  }
  
  public static boolean zza(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5507);
    Object localObject = zzb(paramContentResolver);
    Boolean localBoolean = (Boolean)zza(zzagz, paramString, Boolean.valueOf(paramBoolean));
    if (localBoolean != null)
    {
      paramBoolean = localBoolean.booleanValue();
      AppMethodBeat.o(5507);
      return paramBoolean;
    }
    String str = zza(paramContentResolver, paramString, null);
    paramContentResolver = localBoolean;
    boolean bool = paramBoolean;
    if (str != null)
    {
      if (!str.equals("")) {
        break label98;
      }
      bool = paramBoolean;
      paramContentResolver = localBoolean;
    }
    for (;;)
    {
      zza(localObject, zzagz, paramString, paramContentResolver);
      AppMethodBeat.o(5507);
      return bool;
      label98:
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
    AppMethodBeat.i(5509);
    try
    {
      zza(paramContentResolver);
      paramContentResolver = zzahd;
      return paramContentResolver;
    }
    finally
    {
      AppMethodBeat.o(5509);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzi
 * JD-Core Version:    0.7.0.1
 */