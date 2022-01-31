package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import java.util.Collections;
import java.util.List;

class zzcg
  implements zzaw
{
  private static final String zzaeu = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] { "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time" });
  private final Context mContext;
  private final zzcg.zzb zzbGW;
  private volatile zzad zzbGX;
  private final zzax zzbGY;
  private final String zzbGZ;
  private long zzbHa;
  private final int zzbHb;
  private zze zzuP;
  
  zzcg(zzax paramzzax, Context paramContext)
  {
    this(paramzzax, paramContext, "gtm_urls.db", 2000);
  }
  
  zzcg(zzax paramzzax, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzbGZ = paramString;
    this.zzbGY = paramzzax;
    this.zzuP = zzi.zzzc();
    this.zzbGW = new zzcg.zzb(this, this.mContext, this.zzbGZ);
    this.zzbGX = new zzde(this.mContext, new zzcg.zza(this));
    this.zzbHa = 0L;
    this.zzbHb = paramInt;
  }
  
  private void zzQZ()
  {
    int i = zzRa() - this.zzbHb + 1;
    if (i > 0)
    {
      List localList = zznG(i);
      i = localList.size();
      zzbo.v(51 + "Store full, deleting " + i + " hits to make room.");
      zzh((String[])localList.toArray(new String[0]));
    }
  }
  
  private void zzh(long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = zzhe("Error opening database for putHit");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    localContentValues.put("hit_url", paramString);
    localContentValues.put("hit_first_send_time", Integer.valueOf(0));
    try
    {
      localSQLiteDatabase.insert("gtm_hits", null, localContentValues);
      this.zzbGY.zzaS(false);
      return;
    }
    catch (SQLiteException paramString)
    {
      zzbo.zzbh("Error storing hit");
    }
  }
  
  private SQLiteDatabase zzhe(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzbGW.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbo.zzbh(paramString);
    }
    return null;
  }
  
  private void zzj(long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = zzhe("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_first_send_time", Long.valueOf(paramLong2));
    try
    {
      localSQLiteDatabase.update("gtm_hits", localContentValues, "hit_id=?", new String[] { String.valueOf(paramLong1) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzbo.zzbh(69 + "Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + paramLong1);
      zzv(paramLong1);
    }
  }
  
  private void zzv(long paramLong)
  {
    zzh(new String[] { String.valueOf(paramLong) });
  }
  
  public void dispatch()
  {
    zzbo.v("GTM Dispatch running...");
    if (!this.zzbGX.zzQE()) {}
    do
    {
      return;
      List localList = zznH(40);
      if (localList.isEmpty())
      {
        zzbo.v("...nothing to dispatch");
        this.zzbGY.zzaS(true);
        return;
      }
      this.zzbGX.zzP(localList);
    } while (zzRb() <= 0);
    zzdc.zzRx().dispatch();
  }
  
  int zzRa()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    Object localObject5 = zzhe("Error opening database for getNumStoredHits.");
    if (localObject5 == null) {}
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from gtm_hits", null);
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
        zzbo.zzbh("Error getting numStoredHits");
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
  
  /* Error */
  int zzRb()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc 221
    //   6: invokespecial 174	com/google/android/gms/tagmanager/zzcg:zzhe	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_3
    //   17: ldc 33
    //   19: iconst_2
    //   20: anewarray 43	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 35
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 41
    //   32: aastore
    //   33: ldc_w 289
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 293	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 296 1 0
    //   50: istore_2
    //   51: iload_2
    //   52: istore_1
    //   53: aload_3
    //   54: ifnull +11 -> 65
    //   57: aload_3
    //   58: invokeinterface 285 1 0
    //   63: iload_2
    //   64: istore_1
    //   65: iload_1
    //   66: ireturn
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_3
    //   70: ldc_w 298
    //   73: invokestatic 215	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   76: aload_3
    //   77: ifnull +64 -> 141
    //   80: aload_3
    //   81: invokeinterface 285 1 0
    //   86: iconst_0
    //   87: istore_1
    //   88: goto -23 -> 65
    //   91: astore_3
    //   92: aload 4
    //   94: ifnull +10 -> 104
    //   97: aload 4
    //   99: invokeinterface 285 1 0
    //   104: aload_3
    //   105: athrow
    //   106: astore 4
    //   108: aload_3
    //   109: astore 5
    //   111: aload 4
    //   113: astore_3
    //   114: aload 5
    //   116: astore 4
    //   118: goto -26 -> 92
    //   121: astore 4
    //   123: aload_3
    //   124: astore 5
    //   126: aload 4
    //   128: astore_3
    //   129: aload 5
    //   131: astore 4
    //   133: goto -41 -> 92
    //   136: astore 4
    //   138: goto -68 -> 70
    //   141: iconst_0
    //   142: istore_1
    //   143: goto -78 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	zzcg
    //   52	91	1	i	int
    //   50	14	2	j	int
    //   9	49	3	localObject1	Object
    //   67	1	3	localSQLiteException1	SQLiteException
    //   69	12	3	localObject2	Object
    //   91	18	3	localObject3	Object
    //   113	16	3	localObject4	Object
    //   1	97	4	localObject5	Object
    //   106	6	4	localObject6	Object
    //   116	1	4	localObject7	Object
    //   121	6	4	localObject8	Object
    //   131	1	4	localObject9	Object
    //   136	1	4	localSQLiteException2	SQLiteException
    //   109	21	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   16	44	67	android/database/sqlite/SQLiteException
    //   16	44	91	finally
    //   44	51	106	finally
    //   70	76	121	finally
    //   44	51	136	android/database/sqlite/SQLiteException
  }
  
  public void zzg(long paramLong, String paramString)
  {
    zzot();
    zzQZ();
    zzh(paramLong, paramString);
  }
  
  void zzh(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = zzhe("Error opening database for deleteHits.");
    } while (localSQLiteDatabase == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("gtm_hits", str, paramArrayOfString);
        paramArrayOfString = this.zzbGY;
        if (zzRa() == 0)
        {
          paramArrayOfString.zzaS(bool);
          return;
        }
      }
      catch (SQLiteException paramArrayOfString)
      {
        zzbo.zzbh("Error deleting hits");
        return;
      }
      bool = false;
    }
  }
  
  /* Error */
  List<String> zznG(int paramInt)
  {
    // Byte code:
    //   0: new 334	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 335	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +12 -> 22
    //   13: ldc_w 337
    //   16: invokestatic 215	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   19: aload 6
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 339
    //   26: invokespecial 174	com/google/android/gms/tagmanager/zzcg:zzhe	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +6 -> 37
    //   34: aload 6
    //   36: areturn
    //   37: ldc_w 341
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: ldc 35
    //   48: aastore
    //   49: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 4
    //   54: iload_1
    //   55: invokestatic 344	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   58: astore 5
    //   60: aload_3
    //   61: ldc 33
    //   63: iconst_1
    //   64: anewarray 43	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: ldc 35
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aload 4
    //   78: aload 5
    //   80: invokevirtual 347	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: invokeinterface 278 1 0
    //   95: ifeq +40 -> 135
    //   98: aload 4
    //   100: astore_3
    //   101: aload 6
    //   103: aload 4
    //   105: iconst_0
    //   106: invokeinterface 282 2 0
    //   111: invokestatic 226	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: invokeinterface 351 2 0
    //   119: pop
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokeinterface 354 1 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifne -34 -> 98
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokeinterface 285 1 0
    //   147: aload 6
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: aload 5
    //   160: invokevirtual 357	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   163: invokestatic 360	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: astore 5
    //   168: aload 4
    //   170: astore_3
    //   171: aload 5
    //   173: invokevirtual 363	java/lang/String:length	()I
    //   176: ifeq +39 -> 215
    //   179: aload 4
    //   181: astore_3
    //   182: ldc_w 365
    //   185: aload 5
    //   187: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 5
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: invokestatic 215	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   200: aload 4
    //   202: ifnull -55 -> 147
    //   205: aload 4
    //   207: invokeinterface 285 1 0
    //   212: goto -65 -> 147
    //   215: aload 4
    //   217: astore_3
    //   218: new 43	java/lang/String
    //   221: dup
    //   222: ldc_w 365
    //   225: invokespecial 371	java/lang/String:<init>	(Ljava/lang/String;)V
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
    //   248: invokeinterface 285 1 0
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
    //   0	267	0	this	zzcg
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
    //   7	141	6	localArrayList	java.util.ArrayList
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
  
  /* Error */
  public List<zzas> zznH(int paramInt)
  {
    // Byte code:
    //   0: new 334	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 335	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: ldc_w 375
    //   13: invokespecial 174	com/google/android/gms/tagmanager/zzcg:zzhe	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 8
    //   18: aload 8
    //   20: ifnonnull +10 -> 30
    //   23: aload 5
    //   25: astore 6
    //   27: aload 6
    //   29: areturn
    //   30: aconst_null
    //   31: astore 6
    //   33: ldc_w 341
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: ldc 35
    //   44: aastore
    //   45: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   48: astore 4
    //   50: iload_1
    //   51: invokestatic 344	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   54: astore 7
    //   56: aload 8
    //   58: ldc 33
    //   60: iconst_3
    //   61: anewarray 43	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 35
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc 37
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: ldc 41
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aload 4
    //   85: aload 7
    //   87: invokevirtual 347	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 4
    //   92: new 334	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 335	java/util/ArrayList:<init>	()V
    //   99: astore 7
    //   101: aload 4
    //   103: invokeinterface 278 1 0
    //   108: ifeq +54 -> 162
    //   111: aload 7
    //   113: new 377	com/google/android/gms/tagmanager/zzas
    //   116: dup
    //   117: aload 4
    //   119: iconst_0
    //   120: invokeinterface 282 2 0
    //   125: aload 4
    //   127: iconst_1
    //   128: invokeinterface 282 2 0
    //   133: aload 4
    //   135: iconst_2
    //   136: invokeinterface 282 2 0
    //   141: invokespecial 380	com/google/android/gms/tagmanager/zzas:<init>	(JJJ)V
    //   144: invokeinterface 351 2 0
    //   149: pop
    //   150: aload 4
    //   152: invokeinterface 354 1 0
    //   157: istore_3
    //   158: iload_3
    //   159: ifne -48 -> 111
    //   162: aload 4
    //   164: ifnull +10 -> 174
    //   167: aload 4
    //   169: invokeinterface 285 1 0
    //   174: aload 4
    //   176: astore 5
    //   178: ldc_w 341
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: ldc 35
    //   189: aastore
    //   190: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   193: astore 6
    //   195: aload 4
    //   197: astore 5
    //   199: iload_1
    //   200: invokestatic 344	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   203: astore 9
    //   205: aload 4
    //   207: astore 5
    //   209: aload 8
    //   211: ldc 33
    //   213: iconst_2
    //   214: anewarray 43	java/lang/String
    //   217: dup
    //   218: iconst_0
    //   219: ldc 35
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: ldc 39
    //   226: aastore
    //   227: aconst_null
    //   228: aconst_null
    //   229: aconst_null
    //   230: aconst_null
    //   231: aload 6
    //   233: aload 9
    //   235: invokevirtual 347	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   238: astore 6
    //   240: aload 6
    //   242: invokeinterface 278 1 0
    //   247: ifeq +53 -> 300
    //   250: iconst_0
    //   251: istore_1
    //   252: aload 6
    //   254: checkcast 382	android/database/sqlite/SQLiteCursor
    //   257: invokevirtual 386	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   260: invokevirtual 391	android/database/CursorWindow:getNumRows	()I
    //   263: ifle +149 -> 412
    //   266: aload 7
    //   268: iload_1
    //   269: invokeinterface 395 2 0
    //   274: checkcast 377	com/google/android/gms/tagmanager/zzas
    //   277: aload 6
    //   279: iconst_1
    //   280: invokeinterface 398 2 0
    //   285: invokevirtual 401	com/google/android/gms/tagmanager/zzas:zzhi	(Ljava/lang/String;)V
    //   288: aload 6
    //   290: invokeinterface 354 1 0
    //   295: istore_3
    //   296: iload_3
    //   297: ifne +427 -> 724
    //   300: aload 6
    //   302: ifnull +10 -> 312
    //   305: aload 6
    //   307: invokeinterface 285 1 0
    //   312: aload 7
    //   314: areturn
    //   315: astore 6
    //   317: aconst_null
    //   318: astore 7
    //   320: aload 5
    //   322: astore 4
    //   324: aload 7
    //   326: astore 5
    //   328: aload 6
    //   330: invokevirtual 357	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   333: invokestatic 360	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   336: astore 6
    //   338: aload 6
    //   340: invokevirtual 363	java/lang/String:length	()I
    //   343: ifeq +37 -> 380
    //   346: ldc_w 365
    //   349: aload 6
    //   351: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   354: astore 6
    //   356: aload 6
    //   358: invokestatic 215	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   361: aload 4
    //   363: astore 6
    //   365: aload 5
    //   367: ifnull -340 -> 27
    //   370: aload 5
    //   372: invokeinterface 285 1 0
    //   377: aload 4
    //   379: areturn
    //   380: new 43	java/lang/String
    //   383: dup
    //   384: ldc_w 365
    //   387: invokespecial 371	java/lang/String:<init>	(Ljava/lang/String;)V
    //   390: astore 6
    //   392: goto -36 -> 356
    //   395: astore 4
    //   397: aload 5
    //   399: ifnull +10 -> 409
    //   402: aload 5
    //   404: invokeinterface 285 1 0
    //   409: aload 4
    //   411: athrow
    //   412: ldc_w 403
    //   415: iconst_1
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: aload 7
    //   423: iload_1
    //   424: invokeinterface 395 2 0
    //   429: checkcast 377	com/google/android/gms/tagmanager/zzas
    //   432: invokevirtual 407	com/google/android/gms/tagmanager/zzas:zzQM	()J
    //   435: invokestatic 183	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: invokestatic 47	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   442: invokestatic 215	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   445: goto -157 -> 288
    //   448: astore 5
    //   450: aload 6
    //   452: astore 4
    //   454: aload 5
    //   456: astore 6
    //   458: aload 4
    //   460: astore 5
    //   462: aload 6
    //   464: invokevirtual 357	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   467: invokestatic 360	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   470: astore 6
    //   472: aload 4
    //   474: astore 5
    //   476: aload 6
    //   478: invokevirtual 363	java/lang/String:length	()I
    //   481: ifeq +143 -> 624
    //   484: aload 4
    //   486: astore 5
    //   488: ldc_w 409
    //   491: aload 6
    //   493: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   496: astore 6
    //   498: aload 4
    //   500: astore 5
    //   502: aload 6
    //   504: invokestatic 215	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   507: aload 4
    //   509: astore 5
    //   511: new 334	java/util/ArrayList
    //   514: dup
    //   515: invokespecial 335	java/util/ArrayList:<init>	()V
    //   518: astore 6
    //   520: aload 4
    //   522: astore 5
    //   524: aload 7
    //   526: invokeinterface 413 1 0
    //   531: astore 7
    //   533: iconst_0
    //   534: istore_1
    //   535: aload 4
    //   537: astore 5
    //   539: aload 7
    //   541: invokeinterface 418 1 0
    //   546: ifeq +97 -> 643
    //   549: aload 4
    //   551: astore 5
    //   553: aload 7
    //   555: invokeinterface 422 1 0
    //   560: checkcast 377	com/google/android/gms/tagmanager/zzas
    //   563: astore 8
    //   565: iload_1
    //   566: istore_2
    //   567: aload 4
    //   569: astore 5
    //   571: aload 8
    //   573: invokevirtual 425	com/google/android/gms/tagmanager/zzas:zzQO	()Ljava/lang/String;
    //   576: invokestatic 428	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   579: ifeq +9 -> 588
    //   582: iload_1
    //   583: ifne +60 -> 643
    //   586: iconst_1
    //   587: istore_2
    //   588: aload 4
    //   590: astore 5
    //   592: aload 6
    //   594: aload 8
    //   596: invokeinterface 351 2 0
    //   601: pop
    //   602: iload_2
    //   603: istore_1
    //   604: goto -69 -> 535
    //   607: astore 4
    //   609: aload 5
    //   611: ifnull +10 -> 621
    //   614: aload 5
    //   616: invokeinterface 285 1 0
    //   621: aload 4
    //   623: athrow
    //   624: aload 4
    //   626: astore 5
    //   628: new 43	java/lang/String
    //   631: dup
    //   632: ldc_w 409
    //   635: invokespecial 371	java/lang/String:<init>	(Ljava/lang/String;)V
    //   638: astore 6
    //   640: goto -142 -> 498
    //   643: aload 4
    //   645: ifnull +10 -> 655
    //   648: aload 4
    //   650: invokeinterface 285 1 0
    //   655: aload 6
    //   657: areturn
    //   658: astore 4
    //   660: aload 6
    //   662: astore 5
    //   664: goto -55 -> 609
    //   667: astore 6
    //   669: goto -211 -> 458
    //   672: astore 4
    //   674: aload 6
    //   676: astore 5
    //   678: goto -281 -> 397
    //   681: astore 6
    //   683: aload 4
    //   685: astore 5
    //   687: aload 6
    //   689: astore 4
    //   691: goto -294 -> 397
    //   694: astore 6
    //   696: aload 4
    //   698: astore 7
    //   700: aload 5
    //   702: astore 4
    //   704: aload 7
    //   706: astore 5
    //   708: goto -380 -> 328
    //   711: astore 6
    //   713: aload 4
    //   715: astore 5
    //   717: aload 7
    //   719: astore 4
    //   721: goto -393 -> 328
    //   724: iload_1
    //   725: iconst_1
    //   726: iadd
    //   727: istore_1
    //   728: goto -476 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	731	0	this	zzcg
    //   0	731	1	paramInt	int
    //   566	37	2	i	int
    //   157	140	3	bool	boolean
    //   48	330	4	localObject1	Object
    //   395	15	4	localObject2	Object
    //   452	137	4	localObject3	Object
    //   607	42	4	localObject4	Object
    //   658	1	4	localObject5	Object
    //   672	12	4	localObject6	Object
    //   689	31	4	localObject7	Object
    //   7	396	5	localObject8	Object
    //   448	7	5	localSQLiteException1	SQLiteException
    //   460	256	5	localObject9	Object
    //   25	281	6	localObject10	Object
    //   315	14	6	localSQLiteException2	SQLiteException
    //   336	325	6	localObject11	Object
    //   667	8	6	localSQLiteException3	SQLiteException
    //   681	7	6	localObject12	Object
    //   694	1	6	localSQLiteException4	SQLiteException
    //   711	1	6	localSQLiteException5	SQLiteException
    //   54	664	7	localObject13	Object
    //   16	579	8	localObject14	Object
    //   203	31	9	str	String
    // Exception table:
    //   from	to	target	type
    //   33	92	315	android/database/sqlite/SQLiteException
    //   328	356	395	finally
    //   356	361	395	finally
    //   380	392	395	finally
    //   240	250	448	android/database/sqlite/SQLiteException
    //   252	288	448	android/database/sqlite/SQLiteException
    //   288	296	448	android/database/sqlite/SQLiteException
    //   412	445	448	android/database/sqlite/SQLiteException
    //   178	195	607	finally
    //   199	205	607	finally
    //   209	240	607	finally
    //   462	472	607	finally
    //   476	484	607	finally
    //   488	498	607	finally
    //   502	507	607	finally
    //   511	520	607	finally
    //   524	533	607	finally
    //   539	549	607	finally
    //   553	565	607	finally
    //   571	582	607	finally
    //   592	602	607	finally
    //   628	640	607	finally
    //   240	250	658	finally
    //   252	288	658	finally
    //   288	296	658	finally
    //   412	445	658	finally
    //   178	195	667	android/database/sqlite/SQLiteException
    //   199	205	667	android/database/sqlite/SQLiteException
    //   209	240	667	android/database/sqlite/SQLiteException
    //   33	92	672	finally
    //   92	101	681	finally
    //   101	111	681	finally
    //   111	158	681	finally
    //   92	101	694	android/database/sqlite/SQLiteException
    //   101	111	711	android/database/sqlite/SQLiteException
    //   111	158	711	android/database/sqlite/SQLiteException
  }
  
  int zzot()
  {
    boolean bool = true;
    long l = this.zzuP.currentTimeMillis();
    if (l <= this.zzbHa + 86400000L) {}
    do
    {
      return 0;
      this.zzbHa = l;
      localObject = zzhe("Error opening database for deleteStaleHits.");
    } while (localObject == null);
    int i = ((SQLiteDatabase)localObject).delete("gtm_hits", "HIT_TIME < ?", new String[] { Long.toString(this.zzuP.currentTimeMillis() - 2592000000L) });
    Object localObject = this.zzbGY;
    if (zzRa() == 0) {}
    for (;;)
    {
      ((zzax)localObject).zzaS(bool);
      return i;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcg
 * JD-Core Version:    0.7.0.1
 */