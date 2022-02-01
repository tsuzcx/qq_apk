package com.tencent.tmdownloader.internal.b.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.internal.b.a.a;
import java.util.HashMap;

public class c
  implements com.tencent.tmassistant.common.a.c
{
  private static int a(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if ((paramString1 == null) || (paramString2 == null)) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        int j = paramSQLiteDatabase.update("settingInfo", localContentValues, "settingField = ?", new String[] { paramString1 });
        i = j;
        if (j > 0) {
          continue;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        k.c("DownloadSettingTable", "exception: ", paramString1);
        paramString1.printStackTrace();
        return -2;
      }
      finally {}
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if ((localSQLiteDatabase != null) && (a(paramString1, paramString2, paramString3, localSQLiteDatabase) <= 0))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        localSQLiteDatabase.insert("settingInfo", null, localContentValues);
      }
      return;
    }
    catch (Exception paramString1)
    {
      k.c("DownloadSettingTable", "exception: ", paramString1);
      paramString1.printStackTrace();
    }
  }
  
  public static HashMap c()
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Cursor localCursor2 = null;
    HashMap localHashMap = new HashMap();
    Cursor localCursor1 = localCursor2;
    Object localObject3 = localObject5;
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = a.c().getReadableDatabase();
        if (localSQLiteDatabase == null) {
          break label177;
        }
        localCursor1 = localCursor2;
        localObject3 = localObject5;
        localCursor2 = localSQLiteDatabase.rawQuery("select * from settingInfo", null);
        localObject4 = localCursor2;
        if (localCursor2 == null) {
          break label177;
        }
        localCursor1 = localCursor2;
        localObject3 = localCursor2;
        localObject4 = localCursor2;
        if (!localCursor2.moveToFirst()) {
          break label177;
        }
        localCursor1 = localCursor2;
        localObject3 = localCursor2;
        localHashMap.put(localCursor2.getString(localCursor2.getColumnIndex("settingField")), localCursor2.getString(localCursor2.getColumnIndex("value")));
        localCursor1 = localCursor2;
        localObject3 = localCursor2;
        boolean bool = localCursor2.moveToNext();
        if (bool) {
          continue;
        }
        if (localCursor2 == null) {
          continue;
        }
        localCursor1 = localCursor2;
      }
      catch (Exception localException)
      {
        localObject3 = localCursor1;
        k.c("DownloadSettingTable", "exception: ", localException);
        localObject3 = localCursor1;
        localException.printStackTrace();
        if (localCursor1 == null) {
          continue;
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        ((Cursor)localObject3).close();
      }
      localCursor1.close();
      return localHashMap;
      label177:
      if (localObject4 != null) {
        Object localObject2 = localObject4;
      }
    }
  }
  
  public String a()
  {
    return "settingInfo";
  }
  
  public String[] a(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public String b()
  {
    return "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.b.c.c
 * JD-Core Version:    0.7.0.1
 */