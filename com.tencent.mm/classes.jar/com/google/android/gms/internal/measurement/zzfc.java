package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfc
  extends zzhh
{
  private final zzfd zzaig;
  private boolean zzaih;
  
  zzfc(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(1325);
    this.zzaig = new zzfd(this, getContext(), "google_app_measurement_local.db");
    AppMethodBeat.o(1325);
  }
  
  private final SQLiteDatabase getWritableDatabase()
  {
    AppMethodBeat.i(1332);
    if (this.zzaih)
    {
      AppMethodBeat.o(1332);
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = this.zzaig.getWritableDatabase();
    if (localSQLiteDatabase == null)
    {
      this.zzaih = true;
      AppMethodBeat.o(1332);
      return null;
    }
    AppMethodBeat.o(1332);
    return localSQLiteDatabase;
  }
  
  private final boolean zza(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(1327);
    zzab();
    if (this.zzaih)
    {
      AppMethodBeat.o(1327);
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(paramInt));
    localContentValues.put("entry", paramArrayOfByte);
    int j = 5;
    paramInt = 0;
    while (paramInt < 5)
    {
      Object localObject5 = null;
      Object localObject7 = null;
      Object localObject1 = null;
      Object localObject3 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Cursor localCursor1 = null;
      Cursor localCursor2 = localCursor1;
      Object localObject4 = localObject8;
      Object localObject6 = localObject9;
      paramArrayOfByte = localObject10;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        if (localSQLiteDatabase == null)
        {
          localCursor2 = localCursor1;
          localObject3 = localSQLiteDatabase;
          localObject4 = localObject8;
          localObject5 = localSQLiteDatabase;
          localObject6 = localObject9;
          localObject7 = localSQLiteDatabase;
          paramArrayOfByte = localObject10;
          localObject1 = localSQLiteDatabase;
          this.zzaih = true;
          if (localSQLiteDatabase != null) {
            localSQLiteDatabase.close();
          }
          AppMethodBeat.o(1327);
          return false;
        }
        localCursor2 = localCursor1;
        localObject3 = localSQLiteDatabase;
        localObject4 = localObject8;
        localObject5 = localSQLiteDatabase;
        localObject6 = localObject9;
        localObject7 = localSQLiteDatabase;
        paramArrayOfByte = localObject10;
        localObject1 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        long l2 = 0L;
        localCursor2 = localCursor1;
        localObject3 = localSQLiteDatabase;
        localObject4 = localObject8;
        localObject5 = localSQLiteDatabase;
        localObject6 = localObject9;
        localObject7 = localSQLiteDatabase;
        paramArrayOfByte = localObject10;
        localObject1 = localSQLiteDatabase;
        localCursor1 = localSQLiteDatabase.rawQuery("select count(1) from messages", null);
        l1 = l2;
        if (localCursor1 != null)
        {
          l1 = l2;
          localCursor2 = localCursor1;
          localObject3 = localSQLiteDatabase;
          localObject4 = localCursor1;
          localObject5 = localSQLiteDatabase;
          localObject6 = localCursor1;
          localObject7 = localSQLiteDatabase;
          paramArrayOfByte = localCursor1;
          localObject1 = localSQLiteDatabase;
          if (localCursor1.moveToFirst())
          {
            localCursor2 = localCursor1;
            localObject3 = localSQLiteDatabase;
            localObject4 = localCursor1;
            localObject5 = localSQLiteDatabase;
            localObject6 = localCursor1;
            localObject7 = localSQLiteDatabase;
            paramArrayOfByte = localCursor1;
            localObject1 = localSQLiteDatabase;
            l1 = localCursor1.getLong(0);
          }
        }
        if (l1 >= 100000L)
        {
          localCursor2 = localCursor1;
          localObject3 = localSQLiteDatabase;
          localObject4 = localCursor1;
          localObject5 = localSQLiteDatabase;
          localObject6 = localCursor1;
          localObject7 = localSQLiteDatabase;
          paramArrayOfByte = localCursor1;
          localObject1 = localSQLiteDatabase;
          zzge().zzim().log("Data loss, local db full");
          l1 = 100000L - l1 + 1L;
          localCursor2 = localCursor1;
          localObject3 = localSQLiteDatabase;
          localObject4 = localCursor1;
          localObject5 = localSQLiteDatabase;
          localObject6 = localCursor1;
          localObject7 = localSQLiteDatabase;
          paramArrayOfByte = localCursor1;
          localObject1 = localSQLiteDatabase;
          l2 = localSQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[] { Long.toString(l1) });
          if (l2 != l1)
          {
            localCursor2 = localCursor1;
            localObject3 = localSQLiteDatabase;
            localObject4 = localCursor1;
            localObject5 = localSQLiteDatabase;
            localObject6 = localCursor1;
            localObject7 = localSQLiteDatabase;
            paramArrayOfByte = localCursor1;
            localObject1 = localSQLiteDatabase;
            zzge().zzim().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l1 - l2));
          }
        }
        localCursor2 = localCursor1;
        localObject3 = localSQLiteDatabase;
        localObject4 = localCursor1;
        localObject5 = localSQLiteDatabase;
        localObject6 = localCursor1;
        localObject7 = localSQLiteDatabase;
        paramArrayOfByte = localCursor1;
        localObject1 = localSQLiteDatabase;
        localSQLiteDatabase.insertOrThrow("messages", null, localContentValues);
        localCursor2 = localCursor1;
        localObject3 = localSQLiteDatabase;
        localObject4 = localCursor1;
        localObject5 = localSQLiteDatabase;
        localObject6 = localCursor1;
        localObject7 = localSQLiteDatabase;
        paramArrayOfByte = localCursor1;
        localObject1 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
        localCursor2 = localCursor1;
        localObject3 = localSQLiteDatabase;
        localObject4 = localCursor1;
        localObject5 = localSQLiteDatabase;
        localObject6 = localCursor1;
        localObject7 = localSQLiteDatabase;
        paramArrayOfByte = localCursor1;
        localObject1 = localSQLiteDatabase;
        localSQLiteDatabase.endTransaction();
        return true;
      }
      catch (SQLiteFullException localSQLiteFullException)
      {
        paramArrayOfByte = localCursor2;
        localObject1 = localObject3;
        zzge().zzim().zzg("Error writing entry to local database", localSQLiteFullException);
        paramArrayOfByte = localCursor2;
        localObject1 = localObject3;
        this.zzaih = true;
        if (localCursor2 != null) {
          localCursor2.close();
        }
        i = j;
        if (localObject3 != null)
        {
          localObject3.close();
          i = j;
        }
        paramInt += 1;
        j = i;
      }
      catch (SQLiteDatabaseLockedException paramArrayOfByte)
      {
        for (;;)
        {
          long l1 = j;
          paramArrayOfByte = (byte[])localObject4;
          localObject1 = localObject5;
          SystemClock.sleep(l1);
          j += 20;
          if (localObject4 != null) {
            ((Cursor)localObject4).close();
          }
          i = j;
          if (localObject5 != null)
          {
            localObject5.close();
            i = j;
          }
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          if (localObject7 != null)
          {
            paramArrayOfByte = (byte[])localObject6;
            localObject1 = localObject7;
            if (localObject7.inTransaction())
            {
              paramArrayOfByte = (byte[])localObject6;
              localObject1 = localObject7;
              localObject7.endTransaction();
            }
          }
          paramArrayOfByte = (byte[])localObject6;
          localObject1 = localObject7;
          zzge().zzim().zzg("Error writing entry to local database", localSQLiteException);
          paramArrayOfByte = (byte[])localObject6;
          localObject1 = localObject7;
          this.zzaih = true;
          if (localObject6 != null) {
            ((Cursor)localObject6).close();
          }
          int i = j;
          if (localObject7 != null)
          {
            localObject7.close();
            i = j;
          }
        }
      }
      finally
      {
        if (paramArrayOfByte != null) {
          paramArrayOfByte.close();
        }
        if (localObject1 != null) {
          localObject1.close();
        }
        AppMethodBeat.o(1327);
      }
    }
    zzge().zzip().log("Failed to write entry to local database");
    AppMethodBeat.o(1327);
    return false;
  }
  
  public final void resetAnalyticsData()
  {
    AppMethodBeat.i(1326);
    zzab();
    try
    {
      int i = getWritableDatabase().delete("messages", null, null) + 0;
      if (i > 0) {
        zzge().zzit().zzg("Reset local analytics data. records", Integer.valueOf(i));
      }
      AppMethodBeat.o(1326);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzge().zzim().zzg("Error resetting local analytics data. error", localSQLiteException);
      AppMethodBeat.o(1326);
    }
  }
  
  public final boolean zza(zzeu paramzzeu)
  {
    AppMethodBeat.i(1328);
    Parcel localParcel = Parcel.obtain();
    paramzzeu.writeToParcel(localParcel, 0);
    paramzzeu = localParcel.marshall();
    localParcel.recycle();
    if (paramzzeu.length > 131072)
    {
      zzge().zzip().log("Event is too long for local database. Sending event directly to service");
      AppMethodBeat.o(1328);
      return false;
    }
    boolean bool = zza(0, paramzzeu);
    AppMethodBeat.o(1328);
    return bool;
  }
  
  public final boolean zza(zzjx paramzzjx)
  {
    AppMethodBeat.i(1329);
    Parcel localParcel = Parcel.obtain();
    paramzzjx.writeToParcel(localParcel, 0);
    paramzzjx = localParcel.marshall();
    localParcel.recycle();
    if (paramzzjx.length > 131072)
    {
      zzge().zzip().log("User property too long for local database. Sending directly to service");
      AppMethodBeat.o(1329);
      return false;
    }
    boolean bool = zza(1, paramzzjx);
    AppMethodBeat.o(1329);
    return bool;
  }
  
  public final boolean zzc(zzed paramzzed)
  {
    AppMethodBeat.i(1330);
    zzgb();
    paramzzed = zzka.zza(paramzzed);
    if (paramzzed.length > 131072)
    {
      zzge().zzip().log("Conditional user property too long for local database. Sending directly to service");
      AppMethodBeat.o(1330);
      return false;
    }
    boolean bool = zza(2, paramzzed);
    AppMethodBeat.o(1330);
    return bool;
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  /* Error */
  public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzp(int paramInt)
  {
    // Byte code:
    //   0: sipush 1331
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 55	com/google/android/gms/internal/measurement/zzhg:zzab	()V
    //   10: aload_0
    //   11: getfield 41	com/google/android/gms/internal/measurement/zzfc:zzaih	Z
    //   14: ifeq +11 -> 25
    //   17: sipush 1331
    //   20: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: new 298	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 299	java/util/ArrayList:<init>	()V
    //   32: astore 14
    //   34: aload_0
    //   35: invokevirtual 26	com/google/android/gms/internal/measurement/zzhg:getContext	()Landroid/content/Context;
    //   38: ldc 28
    //   40: invokevirtual 305	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   43: invokevirtual 310	java/io/File:exists	()Z
    //   46: ifne +12 -> 58
    //   49: sipush 1331
    //   52: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload 14
    //   57: areturn
    //   58: iconst_5
    //   59: istore_1
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_5
    //   64: if_icmpge +868 -> 932
    //   67: aconst_null
    //   68: astore 13
    //   70: aconst_null
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 12
    //   76: aconst_null
    //   77: astore 11
    //   79: aload_0
    //   80: invokespecial 77	com/google/android/gms/internal/measurement/zzfc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   83: astore 8
    //   85: aload 8
    //   87: ifnonnull +26 -> 113
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield 41	com/google/android/gms/internal/measurement/zzfc:zzaih	Z
    //   95: aload 8
    //   97: ifnull +8 -> 105
    //   100: aload 8
    //   102: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   105: sipush 1331
    //   108: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aconst_null
    //   112: areturn
    //   113: aload 8
    //   115: invokevirtual 85	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   118: bipush 100
    //   120: invokestatic 313	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   123: astore 9
    //   125: aload 8
    //   127: ldc 123
    //   129: iconst_3
    //   130: anewarray 127	java/lang/String
    //   133: dup
    //   134: iconst_0
    //   135: ldc_w 315
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: ldc 61
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: ldc 73
    //   148: aastore
    //   149: aconst_null
    //   150: aconst_null
    //   151: aconst_null
    //   152: aconst_null
    //   153: ldc_w 317
    //   156: aload 9
    //   158: invokevirtual 321	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   161: astore 9
    //   163: ldc2_w 322
    //   166: lstore 4
    //   168: aload 9
    //   170: invokeinterface 326 1 0
    //   175: ifeq +671 -> 846
    //   178: aload 9
    //   180: iconst_0
    //   181: invokeinterface 101 2 0
    //   186: lstore 6
    //   188: aload 9
    //   190: iconst_1
    //   191: invokeinterface 330 2 0
    //   196: istore_3
    //   197: aload 9
    //   199: iconst_2
    //   200: invokeinterface 334 2 0
    //   205: astore 12
    //   207: iload_3
    //   208: ifne +355 -> 563
    //   211: invokestatic 193	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   214: astore 10
    //   216: aload 10
    //   218: aload 12
    //   220: iconst_0
    //   221: aload 12
    //   223: arraylength
    //   224: invokevirtual 338	android/os/Parcel:unmarshall	([BII)V
    //   227: aload 10
    //   229: iconst_0
    //   230: invokevirtual 341	android/os/Parcel:setDataPosition	(I)V
    //   233: getstatic 345	com/google/android/gms/internal/measurement/zzeu:CREATOR	Landroid/os/Parcelable$Creator;
    //   236: aload 10
    //   238: invokeinterface 351 2 0
    //   243: checkcast 195	com/google/android/gms/internal/measurement/zzeu
    //   246: astore 11
    //   248: aload 10
    //   250: invokevirtual 206	android/os/Parcel:recycle	()V
    //   253: lload 6
    //   255: lstore 4
    //   257: aload 11
    //   259: ifnull -91 -> 168
    //   262: aload 14
    //   264: aload 11
    //   266: invokeinterface 357 2 0
    //   271: pop
    //   272: lload 6
    //   274: lstore 4
    //   276: goto -108 -> 168
    //   279: astore 12
    //   281: aload 8
    //   283: astore 11
    //   285: aload 9
    //   287: astore 10
    //   289: aload 10
    //   291: astore 9
    //   293: aload 11
    //   295: astore 8
    //   297: aload_0
    //   298: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   301: invokevirtual 113	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   304: ldc_w 359
    //   307: aload 12
    //   309: invokevirtual 163	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   312: aload 10
    //   314: astore 9
    //   316: aload 11
    //   318: astore 8
    //   320: aload_0
    //   321: iconst_1
    //   322: putfield 41	com/google/android/gms/internal/measurement/zzfc:zzaih	Z
    //   325: aload 10
    //   327: ifnull +10 -> 337
    //   330: aload 10
    //   332: invokeinterface 157 1 0
    //   337: aload 11
    //   339: ifnull +707 -> 1046
    //   342: aload 11
    //   344: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   347: iload_2
    //   348: iconst_1
    //   349: iadd
    //   350: istore_2
    //   351: goto -289 -> 62
    //   354: astore 11
    //   356: aload_0
    //   357: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   360: invokevirtual 113	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   363: ldc_w 361
    //   366: invokevirtual 121	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   369: aload 10
    //   371: invokevirtual 206	android/os/Parcel:recycle	()V
    //   374: lload 6
    //   376: lstore 4
    //   378: goto -210 -> 168
    //   381: astore 10
    //   383: aload 8
    //   385: astore 11
    //   387: aload 9
    //   389: astore 10
    //   391: iload_1
    //   392: i2l
    //   393: lstore 4
    //   395: aload 10
    //   397: astore 9
    //   399: aload 11
    //   401: astore 8
    //   403: lload 4
    //   405: invokestatic 169	android/os/SystemClock:sleep	(J)V
    //   408: iload_1
    //   409: bipush 20
    //   411: iadd
    //   412: istore_3
    //   413: aload 10
    //   415: ifnull +10 -> 425
    //   418: aload 10
    //   420: invokeinterface 157 1 0
    //   425: iload_3
    //   426: istore_1
    //   427: aload 11
    //   429: ifnull -82 -> 347
    //   432: aload 11
    //   434: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   437: iload_3
    //   438: istore_1
    //   439: goto -92 -> 347
    //   442: astore 11
    //   444: aload 10
    //   446: invokevirtual 206	android/os/Parcel:recycle	()V
    //   449: sipush 1331
    //   452: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   455: aload 11
    //   457: athrow
    //   458: astore 12
    //   460: aload 8
    //   462: astore 11
    //   464: aload 9
    //   466: astore 10
    //   468: aload 11
    //   470: ifnull +32 -> 502
    //   473: aload 10
    //   475: astore 9
    //   477: aload 11
    //   479: astore 8
    //   481: aload 11
    //   483: invokevirtual 172	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   486: ifeq +16 -> 502
    //   489: aload 10
    //   491: astore 9
    //   493: aload 11
    //   495: astore 8
    //   497: aload 11
    //   499: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   502: aload 10
    //   504: astore 9
    //   506: aload 11
    //   508: astore 8
    //   510: aload_0
    //   511: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   514: invokevirtual 113	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   517: ldc_w 359
    //   520: aload 12
    //   522: invokevirtual 163	com/google/android/gms/internal/measurement/zzfi:zzg	(Ljava/lang/String;Ljava/lang/Object;)V
    //   525: aload 10
    //   527: astore 9
    //   529: aload 11
    //   531: astore 8
    //   533: aload_0
    //   534: iconst_1
    //   535: putfield 41	com/google/android/gms/internal/measurement/zzfc:zzaih	Z
    //   538: aload 10
    //   540: ifnull +10 -> 550
    //   543: aload 10
    //   545: invokeinterface 157 1 0
    //   550: aload 11
    //   552: ifnull +494 -> 1046
    //   555: aload 11
    //   557: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   560: goto -213 -> 347
    //   563: iload_3
    //   564: iconst_1
    //   565: if_icmpne +146 -> 711
    //   568: invokestatic 193	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   571: astore 11
    //   573: aload 11
    //   575: aload 12
    //   577: iconst_0
    //   578: aload 12
    //   580: arraylength
    //   581: invokevirtual 338	android/os/Parcel:unmarshall	([BII)V
    //   584: aload 11
    //   586: iconst_0
    //   587: invokevirtual 341	android/os/Parcel:setDataPosition	(I)V
    //   590: getstatic 362	com/google/android/gms/internal/measurement/zzjx:CREATOR	Landroid/os/Parcelable$Creator;
    //   593: aload 11
    //   595: invokeinterface 351 2 0
    //   600: checkcast 214	com/google/android/gms/internal/measurement/zzjx
    //   603: astore 10
    //   605: aload 11
    //   607: invokevirtual 206	android/os/Parcel:recycle	()V
    //   610: lload 6
    //   612: lstore 4
    //   614: aload 10
    //   616: ifnull -448 -> 168
    //   619: aload 14
    //   621: aload 10
    //   623: invokeinterface 357 2 0
    //   628: pop
    //   629: lload 6
    //   631: lstore 4
    //   633: goto -465 -> 168
    //   636: astore 10
    //   638: aload 9
    //   640: ifnull +10 -> 650
    //   643: aload 9
    //   645: invokeinterface 157 1 0
    //   650: aload 8
    //   652: ifnull +8 -> 660
    //   655: aload 8
    //   657: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   660: sipush 1331
    //   663: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   666: aload 10
    //   668: athrow
    //   669: astore 10
    //   671: aload_0
    //   672: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   675: invokevirtual 113	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   678: ldc_w 364
    //   681: invokevirtual 121	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   684: aload 11
    //   686: invokevirtual 206	android/os/Parcel:recycle	()V
    //   689: aconst_null
    //   690: astore 10
    //   692: goto -82 -> 610
    //   695: astore 10
    //   697: aload 11
    //   699: invokevirtual 206	android/os/Parcel:recycle	()V
    //   702: sipush 1331
    //   705: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   708: aload 10
    //   710: athrow
    //   711: iload_3
    //   712: iconst_2
    //   713: if_icmpne +113 -> 826
    //   716: invokestatic 193	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   719: astore 11
    //   721: aload 11
    //   723: aload 12
    //   725: iconst_0
    //   726: aload 12
    //   728: arraylength
    //   729: invokevirtual 338	android/os/Parcel:unmarshall	([BII)V
    //   732: aload 11
    //   734: iconst_0
    //   735: invokevirtual 341	android/os/Parcel:setDataPosition	(I)V
    //   738: getstatic 367	com/google/android/gms/internal/measurement/zzed:CREATOR	Landroid/os/Parcelable$Creator;
    //   741: aload 11
    //   743: invokeinterface 351 2 0
    //   748: checkcast 366	com/google/android/gms/internal/measurement/zzed
    //   751: astore 10
    //   753: aload 11
    //   755: invokevirtual 206	android/os/Parcel:recycle	()V
    //   758: lload 6
    //   760: lstore 4
    //   762: aload 10
    //   764: ifnull -596 -> 168
    //   767: aload 14
    //   769: aload 10
    //   771: invokeinterface 357 2 0
    //   776: pop
    //   777: lload 6
    //   779: lstore 4
    //   781: goto -613 -> 168
    //   784: astore 10
    //   786: aload_0
    //   787: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   790: invokevirtual 113	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   793: ldc_w 364
    //   796: invokevirtual 121	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   799: aload 11
    //   801: invokevirtual 206	android/os/Parcel:recycle	()V
    //   804: aconst_null
    //   805: astore 10
    //   807: goto -49 -> 758
    //   810: astore 10
    //   812: aload 11
    //   814: invokevirtual 206	android/os/Parcel:recycle	()V
    //   817: sipush 1331
    //   820: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   823: aload 10
    //   825: athrow
    //   826: aload_0
    //   827: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   830: invokevirtual 113	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   833: ldc_w 369
    //   836: invokevirtual 121	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   839: lload 6
    //   841: lstore 4
    //   843: goto -675 -> 168
    //   846: aload 8
    //   848: ldc 123
    //   850: ldc_w 371
    //   853: iconst_1
    //   854: anewarray 127	java/lang/String
    //   857: dup
    //   858: iconst_0
    //   859: lload 4
    //   861: invokestatic 133	java/lang/Long:toString	(J)Ljava/lang/String;
    //   864: aastore
    //   865: invokevirtual 137	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   868: aload 14
    //   870: invokeinterface 375 1 0
    //   875: if_icmpge +16 -> 891
    //   878: aload_0
    //   879: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   882: invokevirtual 113	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   885: ldc_w 377
    //   888: invokevirtual 121	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   891: aload 8
    //   893: invokevirtual 153	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   896: aload 8
    //   898: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   901: aload 9
    //   903: ifnull +10 -> 913
    //   906: aload 9
    //   908: invokeinterface 157 1 0
    //   913: aload 8
    //   915: ifnull +8 -> 923
    //   918: aload 8
    //   920: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   923: sipush 1331
    //   926: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   929: aload 14
    //   931: areturn
    //   932: aload_0
    //   933: invokevirtual 107	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   936: invokevirtual 175	com/google/android/gms/internal/measurement/zzfg:zzip	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   939: ldc_w 379
    //   942: invokevirtual 121	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   945: sipush 1331
    //   948: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   951: aconst_null
    //   952: areturn
    //   953: astore 10
    //   955: aconst_null
    //   956: astore 9
    //   958: aload 12
    //   960: astore 8
    //   962: goto -324 -> 638
    //   965: astore 10
    //   967: aconst_null
    //   968: astore 9
    //   970: goto -332 -> 638
    //   973: astore 10
    //   975: goto -337 -> 638
    //   978: astore 12
    //   980: aconst_null
    //   981: astore 10
    //   983: aload 9
    //   985: astore 11
    //   987: goto -519 -> 468
    //   990: astore 12
    //   992: aconst_null
    //   993: astore 10
    //   995: aload 8
    //   997: astore 11
    //   999: goto -531 -> 468
    //   1002: astore 8
    //   1004: aconst_null
    //   1005: astore 10
    //   1007: aload 13
    //   1009: astore 11
    //   1011: goto -620 -> 391
    //   1014: astore 9
    //   1016: aconst_null
    //   1017: astore 10
    //   1019: aload 8
    //   1021: astore 11
    //   1023: goto -632 -> 391
    //   1026: astore 12
    //   1028: aconst_null
    //   1029: astore 10
    //   1031: goto -742 -> 289
    //   1034: astore 12
    //   1036: aconst_null
    //   1037: astore 10
    //   1039: aload 8
    //   1041: astore 11
    //   1043: goto -754 -> 289
    //   1046: goto -699 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1049	0	this	zzfc
    //   0	1049	1	paramInt	int
    //   61	290	2	i	int
    //   196	518	3	j	int
    //   166	694	4	l1	long
    //   186	654	6	l2	long
    //   83	913	8	localObject1	Object
    //   1002	38	8	localSQLiteDatabaseLockedException1	SQLiteDatabaseLockedException
    //   71	913	9	localObject2	Object
    //   1014	1	9	localSQLiteDatabaseLockedException2	SQLiteDatabaseLockedException
    //   214	156	10	localObject3	Object
    //   381	1	10	localSQLiteDatabaseLockedException3	SQLiteDatabaseLockedException
    //   389	233	10	localObject4	Object
    //   636	31	10	localObject5	Object
    //   669	1	10	localParseException1	com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException
    //   690	1	10	localObject6	Object
    //   695	14	10	localObject7	Object
    //   751	19	10	localzzed	zzed
    //   784	1	10	localParseException2	com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException
    //   805	1	10	localObject8	Object
    //   810	14	10	localObject9	Object
    //   953	1	10	localObject10	Object
    //   965	1	10	localObject11	Object
    //   973	1	10	localObject12	Object
    //   981	57	10	localObject13	Object
    //   77	266	11	localObject14	Object
    //   354	1	11	localParseException3	com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException
    //   385	48	11	localObject15	Object
    //   442	14	11	localObject16	Object
    //   462	580	11	localObject17	Object
    //   74	148	12	arrayOfByte	byte[]
    //   279	29	12	localSQLiteFullException1	SQLiteFullException
    //   458	501	12	localSQLiteException1	SQLiteException
    //   978	1	12	localSQLiteException2	SQLiteException
    //   990	1	12	localSQLiteException3	SQLiteException
    //   1026	1	12	localSQLiteFullException2	SQLiteFullException
    //   1034	1	12	localSQLiteFullException3	SQLiteFullException
    //   68	940	13	localObject18	Object
    //   32	898	14	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   168	207	279	android/database/sqlite/SQLiteFullException
    //   211	216	279	android/database/sqlite/SQLiteFullException
    //   248	253	279	android/database/sqlite/SQLiteFullException
    //   262	272	279	android/database/sqlite/SQLiteFullException
    //   369	374	279	android/database/sqlite/SQLiteFullException
    //   444	458	279	android/database/sqlite/SQLiteFullException
    //   568	573	279	android/database/sqlite/SQLiteFullException
    //   605	610	279	android/database/sqlite/SQLiteFullException
    //   619	629	279	android/database/sqlite/SQLiteFullException
    //   684	689	279	android/database/sqlite/SQLiteFullException
    //   697	711	279	android/database/sqlite/SQLiteFullException
    //   716	721	279	android/database/sqlite/SQLiteFullException
    //   753	758	279	android/database/sqlite/SQLiteFullException
    //   767	777	279	android/database/sqlite/SQLiteFullException
    //   799	804	279	android/database/sqlite/SQLiteFullException
    //   812	826	279	android/database/sqlite/SQLiteFullException
    //   826	839	279	android/database/sqlite/SQLiteFullException
    //   846	891	279	android/database/sqlite/SQLiteFullException
    //   891	901	279	android/database/sqlite/SQLiteFullException
    //   216	248	354	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   168	207	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   211	216	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   248	253	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   262	272	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   369	374	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   444	458	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   568	573	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   605	610	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   619	629	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   684	689	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   697	711	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   716	721	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   753	758	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   767	777	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   799	804	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   812	826	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   826	839	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   846	891	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   891	901	381	android/database/sqlite/SQLiteDatabaseLockedException
    //   216	248	442	finally
    //   356	369	442	finally
    //   168	207	458	android/database/sqlite/SQLiteException
    //   211	216	458	android/database/sqlite/SQLiteException
    //   248	253	458	android/database/sqlite/SQLiteException
    //   262	272	458	android/database/sqlite/SQLiteException
    //   369	374	458	android/database/sqlite/SQLiteException
    //   444	458	458	android/database/sqlite/SQLiteException
    //   568	573	458	android/database/sqlite/SQLiteException
    //   605	610	458	android/database/sqlite/SQLiteException
    //   619	629	458	android/database/sqlite/SQLiteException
    //   684	689	458	android/database/sqlite/SQLiteException
    //   697	711	458	android/database/sqlite/SQLiteException
    //   716	721	458	android/database/sqlite/SQLiteException
    //   753	758	458	android/database/sqlite/SQLiteException
    //   767	777	458	android/database/sqlite/SQLiteException
    //   799	804	458	android/database/sqlite/SQLiteException
    //   812	826	458	android/database/sqlite/SQLiteException
    //   826	839	458	android/database/sqlite/SQLiteException
    //   846	891	458	android/database/sqlite/SQLiteException
    //   891	901	458	android/database/sqlite/SQLiteException
    //   168	207	636	finally
    //   211	216	636	finally
    //   248	253	636	finally
    //   262	272	636	finally
    //   369	374	636	finally
    //   444	458	636	finally
    //   568	573	636	finally
    //   605	610	636	finally
    //   619	629	636	finally
    //   684	689	636	finally
    //   697	711	636	finally
    //   716	721	636	finally
    //   753	758	636	finally
    //   767	777	636	finally
    //   799	804	636	finally
    //   812	826	636	finally
    //   826	839	636	finally
    //   846	891	636	finally
    //   891	901	636	finally
    //   573	605	669	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   573	605	695	finally
    //   671	684	695	finally
    //   721	753	784	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
    //   721	753	810	finally
    //   786	799	810	finally
    //   79	85	953	finally
    //   90	95	965	finally
    //   113	163	965	finally
    //   297	312	973	finally
    //   320	325	973	finally
    //   403	408	973	finally
    //   481	489	973	finally
    //   497	502	973	finally
    //   510	525	973	finally
    //   533	538	973	finally
    //   79	85	978	android/database/sqlite/SQLiteException
    //   90	95	990	android/database/sqlite/SQLiteException
    //   113	163	990	android/database/sqlite/SQLiteException
    //   79	85	1002	android/database/sqlite/SQLiteDatabaseLockedException
    //   90	95	1014	android/database/sqlite/SQLiteDatabaseLockedException
    //   113	163	1014	android/database/sqlite/SQLiteDatabaseLockedException
    //   79	85	1026	android/database/sqlite/SQLiteFullException
    //   90	95	1034	android/database/sqlite/SQLiteFullException
    //   113	163	1034	android/database/sqlite/SQLiteFullException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfc
 * JD-Core Version:    0.7.0.1
 */