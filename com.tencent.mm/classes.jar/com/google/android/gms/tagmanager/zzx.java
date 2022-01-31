package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzx
  implements DataLayer.zzc
{
  private static final String zzbFP = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] { "datalayer", "ID", "key", "value", "expires" });
  private final Context mContext;
  private final Executor zzbFQ;
  private zzx.zza zzbFR;
  private int zzbFS;
  private zze zzuP;
  
  public zzx(Context paramContext)
  {
    this(paramContext, zzi.zzzc(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  zzx(Context paramContext, zze paramzze, String paramString, int paramInt, Executor paramExecutor)
  {
    this.mContext = paramContext;
    this.zzuP = paramzze;
    this.zzbFS = paramInt;
    this.zzbFQ = paramExecutor;
    this.zzbFR = new zzx.zza(this, this.mContext, paramString);
  }
  
  /* Error */
  private byte[] zzJ(Object paramObject)
  {
    // Byte code:
    //   0: new 86	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 87	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 89	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 92	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 96	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   22: aload_3
    //   23: invokevirtual 100	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   31: aload_3
    //   32: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +7 -> 48
    //   44: aload_2
    //   45: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   48: aload_3
    //   49: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_1
    //   55: aconst_null
    //   56: areturn
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 103	java/io/ObjectOutputStream:close	()V
    //   68: aload_3
    //   69: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: astore_2
    //   75: goto -3 -> 72
    //   78: astore_1
    //   79: goto -19 -> 60
    //   82: astore_1
    //   83: goto -43 -> 40
    //   86: astore_2
    //   87: aload_1
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	zzx
    //   0	89	1	paramObject	Object
    //   16	49	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   74	1	2	localIOException1	java.io.IOException
    //   86	1	2	localIOException2	java.io.IOException
    //   7	62	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   8	17	37	java/io/IOException
    //   44	48	54	java/io/IOException
    //   48	52	54	java/io/IOException
    //   8	17	57	finally
    //   64	68	74	java/io/IOException
    //   68	72	74	java/io/IOException
    //   17	27	78	finally
    //   17	27	82	java/io/IOException
    //   27	35	86	java/io/IOException
  }
  
  /* Error */
  private Object zzL(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 110	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 113	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore 4
    //   10: new 115	java/io/ObjectInputStream
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 118	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 122	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   24: astore_2
    //   25: aload_1
    //   26: invokevirtual 123	java/io/ObjectInputStream:close	()V
    //   29: aload 4
    //   31: invokevirtual 124	java/io/ByteArrayInputStream:close	()V
    //   34: aload_2
    //   35: areturn
    //   36: astore_1
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 123	java/io/ObjectInputStream:close	()V
    //   47: aload 4
    //   49: invokevirtual 124	java/io/ByteArrayInputStream:close	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_1
    //   55: aconst_null
    //   56: areturn
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 123	java/io/ObjectInputStream:close	()V
    //   68: aload 4
    //   70: invokevirtual 124	java/io/ByteArrayInputStream:close	()V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 123	java/io/ObjectInputStream:close	()V
    //   89: aload 4
    //   91: invokevirtual 124	java/io/ByteArrayInputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore_2
    //   97: goto -3 -> 94
    //   100: astore_2
    //   101: aload_1
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: goto -26 -> 81
    //   110: astore_2
    //   111: goto -51 -> 60
    //   114: astore_2
    //   115: goto -76 -> 39
    //   118: astore_1
    //   119: aload_2
    //   120: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	zzx
    //   0	121	1	paramArrayOfByte	byte[]
    //   24	62	2	localObject1	Object
    //   96	1	2	localIOException1	java.io.IOException
    //   100	4	2	localObject2	Object
    //   106	1	2	localObject3	Object
    //   110	1	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   114	6	2	localIOException2	java.io.IOException
    //   102	4	3	arrayOfByte	byte[]
    //   8	82	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   10	20	36	java/io/IOException
    //   43	47	54	java/io/IOException
    //   47	52	54	java/io/IOException
    //   10	20	57	java/lang/ClassNotFoundException
    //   64	68	75	java/io/IOException
    //   68	73	75	java/io/IOException
    //   10	20	78	finally
    //   85	89	96	java/io/IOException
    //   89	94	96	java/io/IOException
    //   20	25	100	finally
    //   20	25	110	java/lang/ClassNotFoundException
    //   20	25	114	java/io/IOException
    //   25	34	118	java/io/IOException
  }
  
  private List<DataLayer.zza> zzN(List<zzb> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzb localzzb = (zzb)paramList.next();
      localArrayList.add(new DataLayer.zza(localzzb.zzAX, zzL(localzzb.zzbFY)));
    }
    return localArrayList;
  }
  
  private List<zzb> zzO(List<DataLayer.zza> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataLayer.zza localzza = (DataLayer.zza)paramList.next();
      localArrayList.add(new zzb(localzza.zzAX, zzJ(localzza.mValue)));
    }
    return localArrayList;
  }
  
  private List<zzb> zzQA()
  {
    Object localObject = zzhe("Error opening database for loadSerialized.");
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SQLiteDatabase)localObject).query("datalayer", new String[] { "key", "value" }, null, null, null, null, "ID", null);
    try
    {
      if (((Cursor)localObject).moveToNext()) {
        localArrayList.add(new zzb(((Cursor)localObject).getString(0), ((Cursor)localObject).getBlob(1)));
      }
      return localList;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  private int zzQB()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = zzhe("Error opening database for getNumStoredEntries.");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from datalayer", null);
        localObject1 = localObject5;
        localObject3 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          localObject1 = localObject5;
          localObject3 = localObject5;
          long l = ((Cursor)localObject5).getLong(0);
          i = (int)l;
        }
        j = i;
        if (localObject5 == null) {
          continue;
        }
        ((Cursor)localObject5).close();
        return i;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject4 = localObject1;
        zzbo.zzbh("Error getting numStoredEntries");
        return 0;
      }
      finally
      {
        Object localObject4;
        if (localObject4 != null) {
          localObject4.close();
        }
      }
    }
  }
  
  private void zzQC()
  {
    try
    {
      this.zzbFR.close();
      return;
    }
    catch (SQLiteException localSQLiteException) {}
  }
  
  private List<DataLayer.zza> zzQz()
  {
    try
    {
      zzaz(this.zzuP.currentTimeMillis());
      List localList = zzN(zzQA());
      return localList;
    }
    finally
    {
      zzQC();
    }
  }
  
  private void zzaz(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = zzhe("Error opening database for deleteOlderThan.");
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      int i = localSQLiteDatabase.delete("datalayer", "expires <= ?", new String[] { Long.toString(paramLong) });
      zzbo.v(33 + "Deleted " + i + " expired items");
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbo.zzbh("Error deleting old entries.");
    }
  }
  
  /* Error */
  private void zzb(List<zzb> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/google/android/gms/tagmanager/zzx:zzuP	Lcom/google/android/gms/common/util/zze;
    //   6: invokeinterface 243 1 0
    //   11: lstore 4
    //   13: aload_0
    //   14: lload 4
    //   16: invokespecial 247	com/google/android/gms/tagmanager/zzx:zzaz	(J)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 307 1 0
    //   26: invokespecial 310	com/google/android/gms/tagmanager/zzx:zznA	(I)V
    //   29: aload_0
    //   30: aload_1
    //   31: lload 4
    //   33: lload_2
    //   34: ladd
    //   35: invokespecial 313	com/google/android/gms/tagmanager/zzx:zzc	(Ljava/util/List;J)V
    //   38: aload_0
    //   39: invokespecial 253	com/google/android/gms/tagmanager/zzx:zzQC	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: invokespecial 253	com/google/android/gms/tagmanager/zzx:zzQC	()V
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	zzx
    //   0	57	1	paramList	List<zzb>
    //   0	57	2	paramLong	long
    //   11	21	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	38	45	finally
    //   38	42	52	finally
    //   46	52	52	finally
  }
  
  private void zzc(List<zzb> paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = zzhe("Error opening database for writeEntryToDatabase.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        zzb localzzb = (zzb)paramList.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("expires", Long.valueOf(paramLong));
        localContentValues.put("key", localzzb.zzAX);
        localContentValues.put("value", localzzb.zzbFY);
        localSQLiteDatabase.insert("datalayer", null, localContentValues);
      }
    }
  }
  
  private void zzg(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = zzhe("Error opening database for deleteEntries.");
    } while (localSQLiteDatabase == null);
    String str = String.format("%s in (%s)", new Object[] { "ID", TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    try
    {
      localSQLiteDatabase.delete("datalayer", str, paramArrayOfString);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      paramArrayOfString = String.valueOf(Arrays.toString(paramArrayOfString));
      if (paramArrayOfString.length() == 0) {}
    }
    for (paramArrayOfString = "Error deleting entries ".concat(paramArrayOfString);; paramArrayOfString = new String("Error deleting entries "))
    {
      zzbo.zzbh(paramArrayOfString);
      return;
    }
  }
  
  private void zzhd(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = zzhe("Error opening database for clearKeysWithPrefix.");
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      int i = localSQLiteDatabase.delete("datalayer", "key = ? OR key LIKE ?", new String[] { paramString, String.valueOf(paramString).concat(".%") });
      zzbo.v(25 + "Cleared " + i + " items");
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      String str = String.valueOf(localSQLiteException);
      zzbo.zzbh(String.valueOf(paramString).length() + 44 + String.valueOf(str).length() + "Error deleting entries with key prefix: " + paramString + " (" + str + ").");
      return;
    }
    finally
    {
      zzQC();
    }
  }
  
  private SQLiteDatabase zzhe(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzbFR.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbo.zzbh(paramString);
    }
    return null;
  }
  
  private void zznA(int paramInt)
  {
    paramInt = zzQB() - this.zzbFS + paramInt;
    if (paramInt > 0)
    {
      List localList = zznB(paramInt);
      paramInt = localList.size();
      zzbo.zzbg(64 + "DataLayer store full, deleting " + paramInt + " entries to make room.");
      zzg((String[])localList.toArray(new String[0]));
    }
  }
  
  /* Error */
  private List<String> zznB(int paramInt)
  {
    // Byte code:
    //   0: new 128	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 129	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +12 -> 22
    //   13: ldc_w 420
    //   16: invokestatic 232	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   19: aload 6
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 422
    //   26: invokespecial 184	com/google/android/gms/tagmanager/zzx:zzhe	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +6 -> 37
    //   34: aload 6
    //   36: areturn
    //   37: ldc_w 424
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: ldc 31
    //   48: aastore
    //   49: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 4
    //   54: iload_1
    //   55: invokestatic 428	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   58: astore 5
    //   60: aload_3
    //   61: ldc 29
    //   63: iconst_1
    //   64: anewarray 39	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 31
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aload 4
    //   78: aload 5
    //   80: invokevirtual 190	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: invokeinterface 220 1 0
    //   95: ifeq +40 -> 135
    //   98: aload 4
    //   100: astore_3
    //   101: aload 6
    //   103: aload 4
    //   105: iconst_0
    //   106: invokeinterface 224 2 0
    //   111: invokestatic 430	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: invokeinterface 162 2 0
    //   119: pop
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokeinterface 195 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne -34 -> 98
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokeinterface 204 1 0
    //   147: aload 6
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: aload 5
    //   160: invokevirtual 433	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   163: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: astore 5
    //   168: aload 4
    //   170: astore_3
    //   171: aload 5
    //   173: invokevirtual 369	java/lang/String:length	()I
    //   176: ifeq +39 -> 215
    //   179: aload 4
    //   181: astore_3
    //   182: ldc_w 435
    //   185: aload 5
    //   187: invokevirtual 375	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 5
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: invokestatic 232	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   200: aload 4
    //   202: ifnull -55 -> 147
    //   205: aload 4
    //   207: invokeinterface 204 1 0
    //   212: goto -65 -> 147
    //   215: aload 4
    //   217: astore_3
    //   218: new 39	java/lang/String
    //   221: dup
    //   222: ldc_w 435
    //   225: invokespecial 377	java/lang/String:<init>	(Ljava/lang/String;)V
    //   228: astore 5
    //   230: goto -38 -> 192
    //   233: astore 5
    //   235: aload_3
    //   236: astore 4
    //   238: aload 5
    //   240: astore_3
    //   241: aload 4
    //   243: ifnull +10 -> 253
    //   246: aload 4
    //   248: invokeinterface 204 1 0
    //   253: aload_3
    //   254: athrow
    //   255: astore_3
    //   256: aconst_null
    //   257: astore 4
    //   259: goto -18 -> 241
    //   262: astore 5
    //   264: goto -109 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	zzx
    //   0	267	1	paramInt	int
    //   130	2	2	bool	boolean
    //   29	225	3	localObject1	Object
    //   255	1	3	localObject2	Object
    //   52	206	4	localObject3	Object
    //   58	21	5	str1	String
    //   150	9	5	localSQLiteException1	SQLiteException
    //   166	63	5	str2	String
    //   233	6	5	localObject4	Object
    //   262	1	5	localSQLiteException2	SQLiteException
    //   7	141	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   37	85	150	android/database/sqlite/SQLiteException
    //   88	98	233	finally
    //   101	120	233	finally
    //   123	131	233	finally
    //   158	168	233	finally
    //   171	179	233	finally
    //   182	192	233	finally
    //   195	200	233	finally
    //   218	230	233	finally
    //   37	85	255	finally
    //   88	98	262	android/database/sqlite/SQLiteException
    //   101	120	262	android/database/sqlite/SQLiteException
    //   123	131	262	android/database/sqlite/SQLiteException
  }
  
  public void zza(DataLayer.zzc.zza paramzza)
  {
    this.zzbFQ.execute(new zzx.2(this, paramzza));
  }
  
  public void zza(List<DataLayer.zza> paramList, long paramLong)
  {
    paramList = zzO(paramList);
    this.zzbFQ.execute(new zzx.1(this, paramList, paramLong));
  }
  
  public void zzhc(String paramString)
  {
    this.zzbFQ.execute(new zzx.3(this, paramString));
  }
  
  private static class zzb
  {
    final String zzAX;
    final byte[] zzbFY;
    
    zzb(String paramString, byte[] paramArrayOfByte)
    {
      this.zzAX = paramString;
      this.zzbFY = paramArrayOfByte;
    }
    
    public String toString()
    {
      String str = this.zzAX;
      int i = Arrays.hashCode(this.zzbFY);
      return String.valueOf(str).length() + 54 + "KeyAndSerialized: key = " + str + " serialized hash = " + i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzx
 * JD-Core Version:    0.7.0.1
 */