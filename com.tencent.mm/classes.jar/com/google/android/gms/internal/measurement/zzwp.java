package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzwp
{
  private static final ConcurrentHashMap<Uri, zzwp> zzbmt;
  private static final String[] zzbna;
  private final Uri uri;
  private final ContentResolver zzbmu;
  private final ContentObserver zzbmv;
  private final Object zzbmw;
  private volatile Map<String, String> zzbmx;
  private final Object zzbmy;
  private final List<zzwr> zzbmz;
  
  static
  {
    AppMethodBeat.i(2282);
    zzbmt = new ConcurrentHashMap();
    zzbna = new String[] { "key", "value" };
    AppMethodBeat.o(2282);
  }
  
  private zzwp(ContentResolver paramContentResolver, Uri paramUri)
  {
    AppMethodBeat.i(2276);
    this.zzbmw = new Object();
    this.zzbmy = new Object();
    this.zzbmz = new ArrayList();
    this.zzbmu = paramContentResolver;
    this.uri = paramUri;
    this.zzbmv = new zzwq(this, null);
    AppMethodBeat.o(2276);
  }
  
  public static zzwp zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    AppMethodBeat.i(2277);
    zzwp localzzwp = (zzwp)zzbmt.get(paramUri);
    Object localObject = localzzwp;
    if (localzzwp == null)
    {
      paramContentResolver = new zzwp(paramContentResolver, paramUri);
      paramUri = (zzwp)zzbmt.putIfAbsent(paramUri, paramContentResolver);
      localObject = paramUri;
      if (paramUri == null)
      {
        paramContentResolver.zzbmu.registerContentObserver(paramContentResolver.uri, false, paramContentResolver.zzbmv);
        localObject = paramContentResolver;
      }
    }
    AppMethodBeat.o(2277);
    return localObject;
  }
  
  /* Error */
  private final Map<String, String> zzrv()
  {
    // Byte code:
    //   0: sipush 2279
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 103	java/util/HashMap
    //   9: dup
    //   10: invokespecial 104	java/util/HashMap:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 64	com/google/android/gms/internal/measurement/zzwp:zzbmu	Landroid/content/ContentResolver;
    //   18: aload_0
    //   19: getfield 66	com/google/android/gms/internal/measurement/zzwp:uri	Landroid/net/Uri;
    //   22: getstatic 47	com/google/android/gms/internal/measurement/zzwp:zzbna	[Ljava/lang/String;
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 108	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +66 -> 99
    //   36: aload_1
    //   37: invokeinterface 114 1 0
    //   42: ifeq +51 -> 93
    //   45: aload_2
    //   46: aload_1
    //   47: iconst_0
    //   48: invokeinterface 118 2 0
    //   53: aload_1
    //   54: iconst_1
    //   55: invokeinterface 118 2 0
    //   60: invokeinterface 123 3 0
    //   65: pop
    //   66: goto -30 -> 36
    //   69: astore_2
    //   70: aload_1
    //   71: invokeinterface 126 1 0
    //   76: sipush 2279
    //   79: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_2
    //   83: athrow
    //   84: astore_1
    //   85: sipush 2279
    //   88: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_1
    //   94: invokeinterface 126 1 0
    //   99: sipush 2279
    //   102: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_1
    //   108: goto -23 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	zzwp
    //   31	40	1	localCursor	android.database.Cursor
    //   84	10	1	localSecurityException	java.lang.SecurityException
    //   107	1	1	localSQLiteException	android.database.sqlite.SQLiteException
    //   13	33	2	localHashMap	java.util.HashMap
    //   69	37	2	localMap	Map<String, String>
    // Exception table:
    //   from	to	target	type
    //   36	66	69	finally
    //   6	32	84	java/lang/SecurityException
    //   70	84	84	java/lang/SecurityException
    //   93	99	84	java/lang/SecurityException
    //   6	32	107	android/database/sqlite/SQLiteException
    //   70	84	107	android/database/sqlite/SQLiteException
    //   93	99	107	android/database/sqlite/SQLiteException
  }
  
  private final void zzrw()
  {
    AppMethodBeat.i(2280);
    synchronized (this.zzbmy)
    {
      Iterator localIterator = this.zzbmz.iterator();
      if (localIterator.hasNext()) {
        ((zzwr)localIterator.next()).zzrx();
      }
    }
    AppMethodBeat.o(2280);
  }
  
  public final Map<String, String> zzrt()
  {
    AppMethodBeat.i(2278);
    Object localObject1;
    if (zzws.zzd("gms:phenotype:phenotype_flag:debug_disable_caching", false)) {
      localObject1 = zzrv();
    }
    for (;;)
    {
      Object localObject3 = localObject1;
      if (localObject1 == null) {}
      synchronized (this.zzbmw)
      {
        localObject3 = this.zzbmx;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = zzrv();
          this.zzbmx = ((Map)localObject1);
        }
        localObject3 = localObject1;
        if (localObject3 != null)
        {
          AppMethodBeat.o(2278);
          return localObject3;
          localObject1 = this.zzbmx;
        }
      }
    }
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(2278);
    return localMap;
  }
  
  public final void zzru()
  {
    synchronized (this.zzbmw)
    {
      this.zzbmx = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwp
 * JD-Core Version:    0.7.0.1
 */