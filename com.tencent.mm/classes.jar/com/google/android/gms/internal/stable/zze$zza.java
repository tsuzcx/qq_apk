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
    AppMethodBeat.i(90474);
    zzagq = new HashMap();
    AppMethodBeat.o(90474);
  }
  
  private static zzh zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    AppMethodBeat.i(90471);
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
      AppMethodBeat.o(90471);
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
        AppMethodBeat.o(90471);
      }
    }
  }
  
  /* Error */
  protected static String zza(ContentResolver paramContentResolver, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 83	com/google/android/gms/internal/stable/zze$zza:zza	(Landroid/content/ContentResolver;Landroid/net/Uri;)Lcom/google/android/gms/internal/stable/zzh;
    //   13: astore 5
    //   15: ldc 2
    //   17: monitorexit
    //   18: aload 5
    //   20: monitorenter
    //   21: aload 5
    //   23: getfield 77	com/google/android/gms/internal/stable/zzh:zzagt	Ljava/lang/Object;
    //   26: astore 6
    //   28: aload 5
    //   30: getfield 70	com/google/android/gms/internal/stable/zzh:zzags	Ljava/util/HashMap;
    //   33: aload_2
    //   34: invokevirtual 87	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   37: ifeq +37 -> 74
    //   40: aload 5
    //   42: getfield 70	com/google/android/gms/internal/stable/zzh:zzags	Ljava/util/HashMap;
    //   45: aload_2
    //   46: invokevirtual 39	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 89	java/lang/String
    //   52: astore_0
    //   53: aload 5
    //   55: monitorexit
    //   56: ldc 81
    //   58: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: areturn
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: ldc 81
    //   69: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: athrow
    //   74: aload 5
    //   76: monitorexit
    //   77: aload_0
    //   78: aload_1
    //   79: iconst_1
    //   80: anewarray 89	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: ldc 91
    //   87: aastore
    //   88: ldc 93
    //   90: iconst_1
    //   91: anewarray 89	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: aload_2
    //   97: aastore
    //   98: aconst_null
    //   99: invokevirtual 97	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +15 -> 119
    //   107: aload_3
    //   108: astore 4
    //   110: aload_3
    //   111: invokeinterface 103 1 0
    //   116: ifne +43 -> 159
    //   119: aload_3
    //   120: astore 4
    //   122: aload 5
    //   124: aload 6
    //   126: aload_2
    //   127: aconst_null
    //   128: invokestatic 106	com/google/android/gms/internal/stable/zze$zza:zza	(Lcom/google/android/gms/internal/stable/zzh;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_3
    //   132: ifnull +9 -> 141
    //   135: aload_3
    //   136: invokeinterface 109 1 0
    //   141: ldc 81
    //   143: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: aload 5
    //   151: monitorexit
    //   152: ldc 81
    //   154: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_0
    //   158: athrow
    //   159: aload_3
    //   160: astore 4
    //   162: aload_3
    //   163: iconst_0
    //   164: invokeinterface 113 2 0
    //   169: astore_0
    //   170: aload_3
    //   171: astore 4
    //   173: aload 5
    //   175: aload 6
    //   177: aload_2
    //   178: aload_0
    //   179: invokestatic 106	com/google/android/gms/internal/stable/zze$zza:zza	(Lcom/google/android/gms/internal/stable/zzh;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: astore_1
    //   184: aload_3
    //   185: ifnull +11 -> 196
    //   188: aload_3
    //   189: invokeinterface 109 1 0
    //   194: aload_0
    //   195: astore_1
    //   196: ldc 81
    //   198: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_1
    //   202: areturn
    //   203: astore_0
    //   204: aconst_null
    //   205: astore_3
    //   206: aconst_null
    //   207: astore_0
    //   208: aload_3
    //   209: astore 4
    //   211: new 115	java/lang/StringBuilder
    //   214: dup
    //   215: ldc 117
    //   217: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload_2
    //   221: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 126
    //   226: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_0
    //   235: astore_1
    //   236: aload_3
    //   237: ifnull -41 -> 196
    //   240: aload_3
    //   241: invokeinterface 109 1 0
    //   246: aload_0
    //   247: astore_1
    //   248: goto -52 -> 196
    //   251: astore_0
    //   252: aconst_null
    //   253: astore 4
    //   255: aload 4
    //   257: ifnull +10 -> 267
    //   260: aload 4
    //   262: invokeinterface 109 1 0
    //   267: ldc 81
    //   269: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload_0
    //   273: athrow
    //   274: astore_0
    //   275: goto -20 -> 255
    //   278: astore_0
    //   279: aconst_null
    //   280: astore_0
    //   281: goto -73 -> 208
    //   284: astore 4
    //   286: goto -78 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramContentResolver	ContentResolver
    //   0	289	1	paramUri	Uri
    //   0	289	2	paramString	String
    //   102	139	3	localCursor1	android.database.Cursor
    //   108	153	4	localCursor2	android.database.Cursor
    //   284	1	4	localSQLException	android.database.SQLException
    //   13	161	5	localzzh	zzh
    //   26	150	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	18	63	finally
    //   64	67	63	finally
    //   21	56	148	finally
    //   74	77	148	finally
    //   149	152	148	finally
    //   77	103	203	android/database/SQLException
    //   77	103	251	finally
    //   110	119	274	finally
    //   122	131	274	finally
    //   162	170	274	finally
    //   173	182	274	finally
    //   211	234	274	finally
    //   110	119	278	android/database/SQLException
    //   122	131	278	android/database/SQLException
    //   162	170	278	android/database/SQLException
    //   173	182	284	android/database/SQLException
  }
  
  private static void zza(zzh paramzzh, Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(90473);
    try
    {
      if (paramObject == paramzzh.zzagt) {
        paramzzh.zzags.put(paramString1, paramString2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(90473);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zze.zza
 * JD-Core Version:    0.7.0.1
 */