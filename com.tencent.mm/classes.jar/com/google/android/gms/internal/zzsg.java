package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzo;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;

class zzsg
  extends zzsa
  implements Closeable
{
  private static final String zzaeu = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  private static final String zzaev = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[] { "hit_time", "hits2" });
  private final zzsg.zza zzaew;
  private final zztj zzaex = new zztj(zznR());
  private final zztj zzaey = new zztj(zznR());
  
  zzsg(zzsc paramzzsc)
  {
    super(paramzzsc);
    String str = zzow();
    this.zzaew = new zzsg.zza(this, paramzzsc.getContext(), str);
  }
  
  private static String zzT(Map<String, String> paramMap)
  {
    zzac.zzw(paramMap);
    Object localObject = new Uri.Builder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      ((Uri.Builder)localObject).appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localObject = ((Uri.Builder)localObject).build().getEncodedQuery();
    paramMap = (Map<String, String>)localObject;
    if (localObject == null) {
      paramMap = "";
    }
    return paramMap;
  }
  
  private long zza(String paramString, String[] paramArrayOfString, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      long l;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        paramLong = paramArrayOfString.getLong(0);
        l = paramLong;
        if (paramArrayOfString != null)
        {
          paramArrayOfString.close();
          l = paramLong;
        }
      }
      do
      {
        return l;
        l = paramLong;
      } while (paramArrayOfString == null);
      paramArrayOfString.close();
      return paramLong;
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzd("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  private long zzb(String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        long l = paramArrayOfString.getLong(0);
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
        return l;
      }
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      throw new SQLiteException("Database returned empty set");
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzd("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  private String zzd(zzsz paramzzsz)
  {
    if (paramzzsz.zzpS()) {
      return zznT().zzpj();
    }
    return zznT().zzpk();
  }
  
  private static String zze(zzsz paramzzsz)
  {
    zzac.zzw(paramzzsz);
    Object localObject = new Uri.Builder();
    paramzzsz = paramzzsz.zzfE().entrySet().iterator();
    while (paramzzsz.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramzzsz.next();
      String str = (String)localEntry.getKey();
      if ((!"ht".equals(str)) && (!"qt".equals(str)) && (!"AppUID".equals(str))) {
        ((Uri.Builder)localObject).appendQueryParameter(str, (String)localEntry.getValue());
      }
    }
    localObject = ((Uri.Builder)localObject).build().getEncodedQuery();
    paramzzsz = (zzsz)localObject;
    if (localObject == null) {
      paramzzsz = "";
    }
    return paramzzsz;
  }
  
  private void zzov()
  {
    int i = zznT().zzpt();
    long l = zzom();
    if (l > i - 1)
    {
      List localList = zzt(l - i + 1L);
      zzd("Store full, deleting hits to make room, count", Integer.valueOf(localList.size()));
      zzr(localList);
    }
  }
  
  private String zzow()
  {
    return zznT().zzpv();
  }
  
  public void beginTransaction()
  {
    zzob();
    getWritableDatabase().beginTransaction();
  }
  
  public void close()
  {
    try
    {
      this.zzaew.close();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Sql error closing database", localSQLiteException);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zze("Error closing database", localIllegalStateException);
    }
  }
  
  public void endTransaction()
  {
    zzob();
    getWritableDatabase().endTransaction();
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzaew.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzd("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  boolean isEmpty()
  {
    return zzom() == 0L;
  }
  
  public void setTransactionSuccessful()
  {
    zzob();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  public long zza(long paramLong, String paramString1, String paramString2)
  {
    zzac.zzdr(paramString1);
    zzac.zzdr(paramString2);
    zzob();
    zzmR();
    return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[] { String.valueOf(paramLong), paramString1, paramString2 }, 0L);
  }
  
  public void zza(long paramLong, String paramString)
  {
    zzac.zzdr(paramString);
    zzob();
    zzmR();
    int i = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[] { String.valueOf(paramLong), paramString });
    if (i > 0) {
      zza("Deleted property records", Integer.valueOf(i));
    }
  }
  
  public void zzb(zzse paramzzse)
  {
    zzac.zzw(paramzzse);
    zzob();
    zzmR();
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    String str = zzT(paramzzse.zzfE());
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_uid", Long.valueOf(paramzzse.zzoj()));
    localContentValues.put("cid", paramzzse.zzmy());
    localContentValues.put("tid", paramzzse.zzok());
    if (paramzzse.zzol()) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("adid", Integer.valueOf(i));
      localContentValues.put("hits_count", Long.valueOf(paramzzse.zzom()));
      localContentValues.put("params", str);
      try
      {
        if (localSQLiteDatabase.insertWithOnConflict("properties", null, localContentValues, 5) == -1L) {
          zzbT("Failed to insert/update a property (got -1)");
        }
        return;
      }
      catch (SQLiteException paramzzse)
      {
        zze("Error storing a property", paramzzse);
      }
    }
  }
  
  Map<String, String> zzbU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap(0);
    }
    try
    {
      if (paramString.startsWith("?")) {}
      for (;;)
      {
        return zzo.zza(new URI(paramString), "UTF-8");
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "?".concat(paramString);
        } else {
          paramString = new String("?");
        }
      }
      return new HashMap(0);
    }
    catch (URISyntaxException paramString)
    {
      zze("Error parsing hit parameters", paramString);
    }
  }
  
  Map<String, String> zzbV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap(0);
    }
    try
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "?".concat(paramString);; paramString = new String("?")) {
        return zzo.zza(new URI(paramString), "UTF-8");
      }
      return new HashMap(0);
    }
    catch (URISyntaxException paramString)
    {
      zze("Error parsing property parameters", paramString);
    }
  }
  
  public void zzc(zzsz paramzzsz)
  {
    zzac.zzw(paramzzsz);
    zzmR();
    zzob();
    String str = zze(paramzzsz);
    if (str.length() > 8192)
    {
      zznS().zza(paramzzsz, "Hit length exceeds the maximum allowed size");
      return;
    }
    zzov();
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", str);
    localContentValues.put("hit_time", Long.valueOf(paramzzsz.zzpQ()));
    localContentValues.put("hit_app_id", Integer.valueOf(paramzzsz.zzpO()));
    localContentValues.put("hit_url", zzd(paramzzsz));
    long l;
    try
    {
      l = localSQLiteDatabase.insert("hits2", null, localContentValues);
      if (l == -1L)
      {
        zzbT("Failed to insert a hit (got -1)");
        return;
      }
    }
    catch (SQLiteException paramzzsz)
    {
      zze("Error storing a hit", paramzzsz);
      return;
    }
    zzb("Hit saved to database. db-id, hit", Long.valueOf(l), paramzzsz);
  }
  
  protected void zzmS() {}
  
  public long zzom()
  {
    zzmR();
    zzob();
    return zzb("SELECT COUNT(*) FROM hits2", null);
  }
  
  public void zzor()
  {
    zzmR();
    zzob();
    getWritableDatabase().delete("hits2", null, null);
  }
  
  public void zzos()
  {
    zzmR();
    zzob();
    getWritableDatabase().delete("properties", null, null);
  }
  
  public int zzot()
  {
    zzmR();
    zzob();
    if (!this.zzaex.zzA(86400000L)) {
      return 0;
    }
    this.zzaex.start();
    zzbP("Deleting stale hits (if any)");
    int i = getWritableDatabase().delete("hits2", "hit_time < ?", new String[] { Long.toString(zznR().currentTimeMillis() - 2592000000L) });
    zza("Deleted stale hits, count", Integer.valueOf(i));
    return i;
  }
  
  public long zzou()
  {
    zzmR();
    zzob();
    return zza(zzaev, null, 0L);
  }
  
  public void zzr(List<Long> paramList)
  {
    zzac.zzw(paramList);
    zzmR();
    zzob();
    if (paramList.isEmpty()) {}
    for (;;)
    {
      return;
      Object localObject1 = new StringBuilder("hit_id");
      ((StringBuilder)localObject1).append(" in (");
      int i = 0;
      Object localObject2;
      while (i < paramList.size())
      {
        localObject2 = (Long)paramList.get(i);
        if ((localObject2 == null) || (((Long)localObject2).longValue() == 0L)) {
          throw new SQLiteException("Invalid hit id");
        }
        if (i > 0) {
          ((StringBuilder)localObject1).append(",");
        }
        ((StringBuilder)localObject1).append(localObject2);
        i += 1;
      }
      ((StringBuilder)localObject1).append(")");
      localObject1 = ((StringBuilder)localObject1).toString();
      try
      {
        localObject2 = getWritableDatabase();
        zza("Deleting dispatched hits. count", Integer.valueOf(paramList.size()));
        i = ((SQLiteDatabase)localObject2).delete("hits2", (String)localObject1, null);
        if (i == paramList.size()) {
          continue;
        }
        zzb("Deleted fewer hits then expected", Integer.valueOf(paramList.size()), Integer.valueOf(i), localObject1);
        return;
      }
      catch (SQLiteException paramList)
      {
        zze("Error deleting hits", paramList);
        throw paramList;
      }
    }
  }
  
  /* Error */
  public List<Long> zzt(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 282	com/google/android/gms/internal/zzsg:zzmR	()V
    //   7: aload_0
    //   8: invokevirtual 253	com/google/android/gms/internal/zzsg:zzob	()V
    //   11: lload_1
    //   12: lconst_0
    //   13: lcmp
    //   14: ifgt +7 -> 21
    //   17: invokestatic 529	java/util/Collections:emptyList	()Ljava/util/List;
    //   20: areturn
    //   21: aload_0
    //   22: invokevirtual 146	com/google/android/gms/internal/zzsg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 4
    //   27: new 531	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 532	java/util/ArrayList:<init>	()V
    //   34: astore 7
    //   36: ldc_w 534
    //   39: iconst_1
    //   40: anewarray 22	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: ldc 26
    //   47: aastore
    //   48: invokestatic 40	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   51: astore 6
    //   53: lload_1
    //   54: invokestatic 481	java/lang/Long:toString	(J)Ljava/lang/String;
    //   57: astore 8
    //   59: aload 4
    //   61: ldc 24
    //   63: iconst_1
    //   64: anewarray 36	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 26
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aload 6
    //   78: aload 8
    //   80: invokevirtual 538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 4
    //   85: aload 4
    //   87: astore 5
    //   89: aload 5
    //   91: astore 4
    //   93: aload 5
    //   95: invokeinterface 157 1 0
    //   100: ifeq +42 -> 142
    //   103: aload 5
    //   105: astore 4
    //   107: aload 7
    //   109: aload 5
    //   111: iconst_0
    //   112: invokeinterface 161 2 0
    //   117: invokestatic 321	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: invokeinterface 541 2 0
    //   125: pop
    //   126: aload 5
    //   128: astore 4
    //   130: aload 5
    //   132: invokeinterface 544 1 0
    //   137: istore_3
    //   138: iload_3
    //   139: ifne -36 -> 103
    //   142: aload 5
    //   144: ifnull +10 -> 154
    //   147: aload 5
    //   149: invokeinterface 164 1 0
    //   154: aload 7
    //   156: areturn
    //   157: astore 6
    //   159: aconst_null
    //   160: astore 5
    //   162: aload 5
    //   164: astore 4
    //   166: aload_0
    //   167: ldc_w 546
    //   170: aload 6
    //   172: invokevirtual 241	com/google/android/gms/internal/zzsg:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   175: aload 5
    //   177: ifnull -23 -> 154
    //   180: aload 5
    //   182: invokeinterface 164 1 0
    //   187: goto -33 -> 154
    //   190: astore 4
    //   192: aload 5
    //   194: ifnull +10 -> 204
    //   197: aload 5
    //   199: invokeinterface 164 1 0
    //   204: aload 4
    //   206: athrow
    //   207: astore 6
    //   209: aload 4
    //   211: astore 5
    //   213: aload 6
    //   215: astore 4
    //   217: goto -25 -> 192
    //   220: astore 6
    //   222: goto -60 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	zzsg
    //   0	225	1	paramLong	long
    //   137	2	3	bool	boolean
    //   25	140	4	localObject1	Object
    //   190	20	4	localObject2	Object
    //   215	1	4	localObject3	Object
    //   1	211	5	localObject4	Object
    //   51	26	6	str1	String
    //   157	14	6	localSQLiteException1	SQLiteException
    //   207	7	6	localObject5	Object
    //   220	1	6	localSQLiteException2	SQLiteException
    //   34	121	7	localArrayList	ArrayList
    //   57	22	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   36	85	157	android/database/sqlite/SQLiteException
    //   36	85	190	finally
    //   93	103	207	finally
    //   107	126	207	finally
    //   130	138	207	finally
    //   166	175	207	finally
    //   93	103	220	android/database/sqlite/SQLiteException
    //   107	126	220	android/database/sqlite/SQLiteException
    //   130	138	220	android/database/sqlite/SQLiteException
  }
  
  public List<zzsz> zzu(long paramLong)
  {
    boolean bool = true;
    Cursor localCursor = null;
    if (paramLong >= 0L) {}
    for (;;)
    {
      zzac.zzax(bool);
      zzmR();
      zzob();
      Object localObject5 = getWritableDatabase();
      localObject1 = localCursor;
      try
      {
        str1 = String.format("%s ASC", new Object[] { "hit_id" });
        localObject1 = localCursor;
        str2 = Long.toString(paramLong);
        localObject1 = localCursor;
        localCursor = ((SQLiteDatabase)localObject5).query("hits2", new String[] { "hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id" }, null, null, null, null, str1, str2);
        localObject1 = localCursor;
      }
      catch (SQLiteException localSQLiteException1)
      {
        String str1;
        String str2;
        localObject1 = null;
        try
        {
          zze("Error loading hits from the database", localSQLiteException1);
          throw localSQLiteException1;
        }
        finally
        {
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
        }
      }
      finally
      {
        break label300;
      }
      try
      {
        localObject5 = new ArrayList();
        localObject1 = localCursor;
        if (localCursor.moveToFirst()) {
          do
          {
            localObject1 = localCursor;
            paramLong = localCursor.getLong(0);
            localObject1 = localCursor;
            long l = localCursor.getLong(1);
            localObject1 = localCursor;
            str1 = localCursor.getString(2);
            localObject1 = localCursor;
            str2 = localCursor.getString(3);
            localObject1 = localCursor;
            int i = localCursor.getInt(4);
            localObject1 = localCursor;
            ((List)localObject5).add(new zzsz(this, zzbU(str1), l, zztm.zzcj(str2), paramLong, i));
            localObject1 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
        }
        if (localCursor != null) {
          localCursor.close();
        }
        return localObject5;
      }
      catch (SQLiteException localSQLiteException2)
      {
        localObject1 = localObject3;
        Object localObject4 = localSQLiteException2;
        break;
      }
      bool = false;
    }
  }
  
  public void zzv(long paramLong)
  {
    zzmR();
    zzob();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Long.valueOf(paramLong));
    zza("Deleting hit, id", Long.valueOf(paramLong));
    zzr(localArrayList);
  }
  
  /* Error */
  public List<zzse> zzw(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 253	com/google/android/gms/internal/zzsg:zzob	()V
    //   4: aload_0
    //   5: invokevirtual 282	com/google/android/gms/internal/zzsg:zzmR	()V
    //   8: aload_0
    //   9: invokevirtual 146	com/google/android/gms/internal/zzsg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 8
    //   17: aload 8
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 189	com/google/android/gms/internal/zzsg:zznT	()Lcom/google/android/gms/internal/zzsp;
    //   25: invokevirtual 581	com/google/android/gms/internal/zzsp:zzpu	()I
    //   28: istore_3
    //   29: aload 8
    //   31: astore 7
    //   33: aload 9
    //   35: ldc_w 292
    //   38: iconst_5
    //   39: anewarray 36	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 327
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc_w 335
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: ldc_w 343
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: ldc_w 348
    //   65: aastore
    //   66: dup
    //   67: iconst_4
    //   68: ldc_w 351
    //   71: aastore
    //   72: ldc_w 583
    //   75: iconst_1
    //   76: anewarray 36	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: lload_1
    //   82: invokestatic 287	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: iload_3
    //   90: invokestatic 585	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: invokevirtual 538	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore 8
    //   98: aload 8
    //   100: astore 7
    //   102: new 531	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 532	java/util/ArrayList:<init>	()V
    //   109: astore 9
    //   111: aload 8
    //   113: astore 7
    //   115: aload 8
    //   117: invokeinterface 157 1 0
    //   122: ifeq +135 -> 257
    //   125: aload 8
    //   127: astore 7
    //   129: aload 8
    //   131: iconst_0
    //   132: invokeinterface 556 2 0
    //   137: astore 10
    //   139: aload 8
    //   141: astore 7
    //   143: aload 8
    //   145: iconst_1
    //   146: invokeinterface 556 2 0
    //   151: astore 11
    //   153: aload 8
    //   155: astore 7
    //   157: aload 8
    //   159: iconst_2
    //   160: invokeinterface 560 2 0
    //   165: ifeq +133 -> 298
    //   168: iconst_1
    //   169: istore 6
    //   171: aload 8
    //   173: astore 7
    //   175: aload 8
    //   177: iconst_3
    //   178: invokeinterface 560 2 0
    //   183: i2l
    //   184: lstore 4
    //   186: aload 8
    //   188: astore 7
    //   190: aload_0
    //   191: aload 8
    //   193: iconst_4
    //   194: invokeinterface 556 2 0
    //   199: invokevirtual 587	com/google/android/gms/internal/zzsg:zzbV	(Ljava/lang/String;)Ljava/util/Map;
    //   202: astore 12
    //   204: aload 8
    //   206: astore 7
    //   208: aload 10
    //   210: invokestatic 373	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   213: ifne +15 -> 228
    //   216: aload 8
    //   218: astore 7
    //   220: aload 11
    //   222: invokestatic 373	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifeq +79 -> 304
    //   228: aload 8
    //   230: astore 7
    //   232: aload_0
    //   233: ldc_w 589
    //   236: aload 10
    //   238: aload 11
    //   240: invokevirtual 591	com/google/android/gms/internal/zzsg:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   243: aload 8
    //   245: astore 7
    //   247: aload 8
    //   249: invokeinterface 544 1 0
    //   254: ifne -129 -> 125
    //   257: aload 8
    //   259: astore 7
    //   261: aload 9
    //   263: invokeinterface 232 1 0
    //   268: iload_3
    //   269: if_icmplt +14 -> 283
    //   272: aload 8
    //   274: astore 7
    //   276: aload_0
    //   277: ldc_w 593
    //   280: invokevirtual 596	com/google/android/gms/internal/zzsg:zzbS	(Ljava/lang/String;)V
    //   283: aload 8
    //   285: ifnull +10 -> 295
    //   288: aload 8
    //   290: invokeinterface 164 1 0
    //   295: aload 9
    //   297: areturn
    //   298: iconst_0
    //   299: istore 6
    //   301: goto -130 -> 171
    //   304: aload 8
    //   306: astore 7
    //   308: aload 9
    //   310: new 305	com/google/android/gms/internal/zzse
    //   313: dup
    //   314: lload_1
    //   315: aload 10
    //   317: aload 11
    //   319: iload 6
    //   321: lload 4
    //   323: aload 12
    //   325: invokespecial 599	com/google/android/gms/internal/zzse:<init>	(JLjava/lang/String;Ljava/lang/String;ZJLjava/util/Map;)V
    //   328: invokeinterface 541 2 0
    //   333: pop
    //   334: goto -91 -> 243
    //   337: astore 9
    //   339: aload 8
    //   341: astore 7
    //   343: aload 9
    //   345: astore 8
    //   347: aload_0
    //   348: ldc_w 572
    //   351: aload 8
    //   353: invokevirtual 262	com/google/android/gms/internal/zzsg:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   356: aload 8
    //   358: athrow
    //   359: astore 8
    //   361: aload 7
    //   363: ifnull +10 -> 373
    //   366: aload 7
    //   368: invokeinterface 164 1 0
    //   373: aload 8
    //   375: athrow
    //   376: astore 8
    //   378: goto -17 -> 361
    //   381: astore 8
    //   383: aconst_null
    //   384: astore 7
    //   386: goto -39 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	zzsg
    //   0	389	1	paramLong	long
    //   28	242	3	i	int
    //   184	138	4	l	long
    //   169	151	6	bool	boolean
    //   19	366	7	localObject1	Object
    //   15	342	8	localObject2	Object
    //   359	15	8	localObject3	Object
    //   376	1	8	localObject4	Object
    //   381	1	8	localSQLiteException1	SQLiteException
    //   12	297	9	localObject5	Object
    //   337	7	9	localSQLiteException2	SQLiteException
    //   137	179	10	str1	String
    //   151	167	11	str2	String
    //   202	122	12	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   102	111	337	android/database/sqlite/SQLiteException
    //   115	125	337	android/database/sqlite/SQLiteException
    //   129	139	337	android/database/sqlite/SQLiteException
    //   143	153	337	android/database/sqlite/SQLiteException
    //   157	168	337	android/database/sqlite/SQLiteException
    //   175	186	337	android/database/sqlite/SQLiteException
    //   190	204	337	android/database/sqlite/SQLiteException
    //   208	216	337	android/database/sqlite/SQLiteException
    //   220	228	337	android/database/sqlite/SQLiteException
    //   232	243	337	android/database/sqlite/SQLiteException
    //   247	257	337	android/database/sqlite/SQLiteException
    //   261	272	337	android/database/sqlite/SQLiteException
    //   276	283	337	android/database/sqlite/SQLiteException
    //   308	334	337	android/database/sqlite/SQLiteException
    //   347	359	359	finally
    //   21	29	376	finally
    //   33	98	376	finally
    //   102	111	376	finally
    //   115	125	376	finally
    //   129	139	376	finally
    //   143	153	376	finally
    //   157	168	376	finally
    //   175	186	376	finally
    //   190	204	376	finally
    //   208	216	376	finally
    //   220	228	376	finally
    //   232	243	376	finally
    //   247	257	376	finally
    //   261	272	376	finally
    //   276	283	376	finally
    //   308	334	376	finally
    //   21	29	381	android/database/sqlite/SQLiteException
    //   33	98	381	android/database/sqlite/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzsg
 * JD-Core Version:    0.7.0.1
 */