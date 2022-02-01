package com.tencent.tmdownloader.internal.b.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.a.k;

public class a
  implements c
{
  private static int a(com.tencent.tmdownloader.internal.b.b.a parama, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (parama == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        a(localContentValues, parama);
        int j = paramSQLiteDatabase.update("clientinfo", localContentValues, "clientId = ? and taskUrl = ?", new String[] { parama.a, parama.c });
        i = j;
        if (j <= 0) {
          return 0;
        }
      }
      catch (Exception parama)
      {
        k.c("ClientInfoTable", "exception: ", parama);
        parama.printStackTrace();
      }
    }
    return -2;
  }
  
  private static void a(ContentValues paramContentValues, com.tencent.tmdownloader.internal.b.b.a parama)
  {
    if (parama != null)
    {
      paramContentValues.put("clientId", parama.a);
      paramContentValues.put("taskId", Integer.valueOf(parama.b));
      paramContentValues.put("taskUrl", parama.c);
    }
  }
  
  public static void a(com.tencent.tmdownloader.internal.b.b.a parama)
  {
    if (parama != null) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = com.tencent.tmdownloader.internal.b.a.a.c().getWritableDatabase();
      if ((localSQLiteDatabase != null) && (a(parama, localSQLiteDatabase) <= 0))
      {
        ContentValues localContentValues = new ContentValues();
        a(localContentValues, parama);
        localSQLiteDatabase.insert("clientinfo", null, localContentValues);
      }
      return;
    }
    catch (Exception parama)
    {
      k.c("ClientInfoTable", "exception: ", parama);
      parama.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = com.tencent.tmdownloader.internal.b.a.a.c().getWritableDatabase();
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.delete("clientinfo", "taskUrl = ?", new String[] { paramString });
      }
      return;
    }
    catch (Exception paramString)
    {
      k.c("ClientInfoTable", "exception: ", paramString);
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    com.tencent.tmdownloader.internal.b.b.a locala = new com.tencent.tmdownloader.internal.b.b.a();
    locala.a = paramString1;
    locala.c = paramString2;
    a(locala);
  }
  
  public String a()
  {
    return "clientinfo";
  }
  
  public String[] a(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public String b()
  {
    return "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.b.c.a
 * JD-Core Version:    0.7.0.1
 */