package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class zze$zza
  implements BaseColumns
{
  private static HashMap<Uri, zzh> zzagq;
  
  static
  {
    AppMethodBeat.i(5495);
    zzagq = new HashMap();
    AppMethodBeat.o(5495);
  }
  
  private static zzh zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    AppMethodBeat.i(5492);
    zzh localzzh = (zzh)zzagq.get(paramUri);
    if (localzzh == null)
    {
      localzzh = new zzh();
      zzagq.put(paramUri, localzzh);
      paramContentResolver.registerContentObserver(paramUri, true, new zzf(null, localzzh));
      paramContentResolver = localzzh;
    }
    for (;;)
    {
      AppMethodBeat.o(5492);
      return paramContentResolver;
      paramContentResolver = localzzh;
      if (!localzzh.zzagu.getAndSet(false)) {
        continue;
      }
      try
      {
        localzzh.zzags.clear();
        localzzh.zzagt = new Object();
        paramContentResolver = localzzh;
      }
      finally
      {
        AppMethodBeat.o(5492);
      }
    }
  }
  
  /* Error */
  protected static String zza(ContentResolver paramContentResolver, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: sipush 5493
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_1
    //   11: invokestatic 80	com/google/android/gms/internal/stable/zze$zza:zza	(Landroid/content/ContentResolver;Landroid/net/Uri;)Lcom/google/android/gms/internal/stable/zzh;
    //   14: astore 5
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload 5
    //   21: monitorenter
    //   22: aload 5
    //   24: getfield 75	com/google/android/gms/internal/stable/zzh:zzagt	Ljava/lang/Object;
    //   27: astore 6
    //   29: aload 5
    //   31: getfield 68	com/google/android/gms/internal/stable/zzh:zzags	Ljava/util/HashMap;
    //   34: aload_2
    //   35: invokevirtual 84	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +39 -> 77
    //   41: aload 5
    //   43: getfield 68	com/google/android/gms/internal/stable/zzh:zzags	Ljava/util/HashMap;
    //   46: aload_2
    //   47: invokevirtual 37	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 86	java/lang/String
    //   53: astore_0
    //   54: aload 5
    //   56: monitorexit
    //   57: sipush 5493
    //   60: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: sipush 5493
    //   72: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: athrow
    //   77: aload 5
    //   79: monitorexit
    //   80: aload_0
    //   81: aload_1
    //   82: iconst_1
    //   83: anewarray 86	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: ldc 88
    //   90: aastore
    //   91: ldc 90
    //   93: iconst_1
    //   94: anewarray 86	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: aload_2
    //   100: aastore
    //   101: aconst_null
    //   102: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore_3
    //   106: aload_3
    //   107: ifnull +15 -> 122
    //   110: aload_3
    //   111: astore 4
    //   113: aload_3
    //   114: invokeinterface 100 1 0
    //   119: ifne +45 -> 164
    //   122: aload_3
    //   123: astore 4
    //   125: aload 5
    //   127: aload 6
    //   129: aload_2
    //   130: aconst_null
    //   131: invokestatic 103	com/google/android/gms/internal/stable/zze$zza:zza	(Lcom/google/android/gms/internal/stable/zzh;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_3
    //   135: ifnull +9 -> 144
    //   138: aload_3
    //   139: invokeinterface 106 1 0
    //   144: sipush 5493
    //   147: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: aload 5
    //   155: monitorexit
    //   156: sipush 5493
    //   159: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_0
    //   163: athrow
    //   164: aload_3
    //   165: astore 4
    //   167: aload_3
    //   168: iconst_0
    //   169: invokeinterface 110 2 0
    //   174: astore_0
    //   175: aload_3
    //   176: astore 4
    //   178: aload 5
    //   180: aload 6
    //   182: aload_2
    //   183: aload_0
    //   184: invokestatic 103	com/google/android/gms/internal/stable/zze$zza:zza	(Lcom/google/android/gms/internal/stable/zzh;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: astore_1
    //   189: aload_3
    //   190: ifnull +11 -> 201
    //   193: aload_3
    //   194: invokeinterface 106 1 0
    //   199: aload_0
    //   200: astore_1
    //   201: sipush 5493
    //   204: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_1
    //   208: areturn
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_3
    //   212: aconst_null
    //   213: astore_0
    //   214: aload_3
    //   215: astore 4
    //   217: new 112	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 114
    //   223: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_2
    //   227: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 123
    //   232: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_1
    //   236: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_0
    //   241: astore_1
    //   242: aload_3
    //   243: ifnull -42 -> 201
    //   246: aload_3
    //   247: invokeinterface 106 1 0
    //   252: aload_0
    //   253: astore_1
    //   254: goto -53 -> 201
    //   257: astore_0
    //   258: aconst_null
    //   259: astore 4
    //   261: aload 4
    //   263: ifnull +10 -> 273
    //   266: aload 4
    //   268: invokeinterface 106 1 0
    //   273: sipush 5493
    //   276: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload_0
    //   280: athrow
    //   281: astore_0
    //   282: goto -21 -> 261
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_0
    //   288: goto -74 -> 214
    //   291: astore 4
    //   293: goto -79 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramContentResolver	ContentResolver
    //   0	296	1	paramUri	Uri
    //   0	296	2	paramString	String
    //   105	142	3	localCursor1	android.database.Cursor
    //   111	156	4	localCursor2	android.database.Cursor
    //   291	1	4	localSQLException	android.database.SQLException
    //   14	165	5	localzzh	zzh
    //   27	154	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	19	65	finally
    //   66	69	65	finally
    //   22	57	152	finally
    //   77	80	152	finally
    //   153	156	152	finally
    //   80	106	209	android/database/SQLException
    //   80	106	257	finally
    //   113	122	281	finally
    //   125	134	281	finally
    //   167	175	281	finally
    //   178	187	281	finally
    //   217	240	281	finally
    //   113	122	285	android/database/SQLException
    //   125	134	285	android/database/SQLException
    //   167	175	285	android/database/SQLException
    //   178	187	291	android/database/SQLException
  }
  
  private static void zza(zzh paramzzh, Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5494);
    try
    {
      if (paramObject == paramzzh.zzagt) {
        paramzzh.zzags.put(paramString1, paramString2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(5494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zze.zza
 * JD-Core Version:    0.7.0.1
 */