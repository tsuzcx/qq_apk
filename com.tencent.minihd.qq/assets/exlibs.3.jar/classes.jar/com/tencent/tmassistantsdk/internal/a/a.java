package com.tencent.tmassistantsdk.internal.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;

public class a
{
  protected String a = "";
  
  public a()
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        File localFile = Environment.getExternalStorageDirectory();
        this.a = (localFile.getPath() + "/tencent/assistant/");
        localFile = new File(this.a);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        this.a += ".SystemConfig.db";
      }
      return;
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {}
    try
    {
      paramSQLiteDatabase.close();
      return;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  private SQLiteDatabase b()
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= 20) {
        break label47;
      }
      try
      {
        localObject2 = SQLiteDatabase.openOrCreateDatabase(this.a, null);
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        label23:
        break label23;
      }
      if (localObject1 != null) {
        break;
      }
      SystemClock.sleep(50L);
      i += 1;
    }
    b(localObject1);
    Object localObject2 = localObject1;
    label47:
    return localObject2;
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = paramSQLiteDatabase.getVersion();
    if (i != 1)
    {
      paramSQLiteDatabase.beginTransaction();
      if (i != 0) {}
    }
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);");
      paramSQLiteDatabase.setVersion(1);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private SQLiteDatabase c()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      int i;
      try
      {
        boolean bool = new File(this.a).exists();
        if (!bool) {
          return localObject3;
        }
        i = 0;
        localObject3 = localObject1;
        if (i >= 20) {
          continue;
        }
      }
      finally {}
      try
      {
        localObject3 = SQLiteDatabase.openDatabase(this.a, null, 1);
        localObject1 = localObject3;
      }
      catch (SQLiteException localSQLiteException)
      {
        continue;
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        SystemClock.sleep(50L);
        i += 1;
      }
    }
  }
  
  public long a(c paramc)
  {
    if (paramc == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return -1L;
        paramc = paramc.a();
      } while (paramc == null);
      localSQLiteDatabase = b();
    } while (localSQLiteDatabase == null);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("itemData", paramc);
    long l = localSQLiteDatabase.insert("channeldata", "", localContentValues);
    a(localSQLiteDatabase);
    return l;
  }
  
  public ArrayList a()
  {
    Object localObject = null;
    c localc = null;
    SQLiteDatabase localSQLiteDatabase = c();
    if (localSQLiteDatabase != null)
    {
      Cursor localCursor = localSQLiteDatabase.rawQuery("select * from channeldata", null);
      localObject = localc;
      if (localCursor != null)
      {
        localObject = localc;
        if (localCursor.moveToFirst() == true)
        {
          int i = localCursor.getColumnIndex("itemId");
          int j = localCursor.getColumnIndex("itemData");
          localObject = new ArrayList();
          do
          {
            int k = localCursor.getInt(i);
            localc = c.a(localCursor.getBlob(j));
            if (localc != null)
            {
              localc.a = k;
              ((ArrayList)localObject).add(localc);
            }
          } while (localCursor.moveToNext());
          a(localSQLiteDatabase);
        }
      }
      localCursor.close();
      a(localSQLiteDatabase);
    }
    return localObject;
  }
  
  public boolean a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = b();
    if (localSQLiteDatabase != null)
    {
      localSQLiteDatabase.delete("channeldata", "itemId=?", new String[] { paramLong + "" });
      a(localSQLiteDatabase);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.a.a
 * JD-Core Version:    0.7.0.1
 */