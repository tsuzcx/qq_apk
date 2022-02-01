package com.tencent.e.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.e.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b
  extends SQLiteOpenHelper
  implements d
{
  private SQLiteDatabase LUj;
  
  public b(Context paramContext)
  {
    super(paramContext, "Scheduler.db", null, 1);
    AppMethodBeat.i(183214);
    try
    {
      this.LUj = getWritableDatabase();
      AppMethodBeat.o(183214);
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.e.d.LTy.e("ExperienceStorage", "%s", new Object[] { paramContext.toString() });
      AppMethodBeat.o(183214);
    }
  }
  
  public final void delete(long paramLong)
  {
    AppMethodBeat.i(183217);
    if (this.LUj == null)
    {
      AppMethodBeat.o(183217);
      return;
    }
    if (paramLong <= 0L) {}
    for (paramLong = System.currentTimeMillis();; paramLong = System.currentTimeMillis() + paramLong) {
      try
      {
        this.LUj.delete("DisposedTask", "timestamp<?", new String[] { String.valueOf(paramLong) });
        AppMethodBeat.o(183217);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.e.d.LTy.e("ExperienceStorage", "%s", new Object[] { localException.toString() });
        AppMethodBeat.o(183217);
      }
    }
  }
  
  public final Map<String, a.a> fVB()
  {
    AppMethodBeat.i(183218);
    localObject3 = new HashMap();
    if (this.LUj == null)
    {
      AppMethodBeat.o(183218);
      return localObject3;
    }
    try
    {
      localObject1 = this.LUj.query("DisposedTask", new String[] { "taskName", String.format("avg(%s)", new Object[] { "rate" }), String.format("avg(%s)", new Object[] { "threadTime" }) }, null, null, "taskName", null, null);
      try
      {
        ((Cursor)localObject1).moveToFirst();
        while (!((Cursor)localObject1).isAfterLast())
        {
          Object localObject4 = new a((Cursor)localObject1);
          String str = ((a)localObject4).getString(0);
          double d1 = ((a)localObject4).getDouble(1);
          double d2 = ((a)localObject4).getDouble(2);
          localObject4 = new a.a(str, (float)d1, d2);
          ((Map)localObject3).put(((a.a)localObject4).name, localObject4);
          ((Cursor)localObject1).moveToNext();
        }
        if (localObject3 == null) {
          break label204;
        }
      }
      finally
      {
        localObject3 = localObject1;
        localObject1 = localObject5;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        localObject3 = null;
      }
    }
    ((Cursor)localObject3).close();
    label204:
    AppMethodBeat.o(183218);
    throw ((Throwable)localObject1);
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    AppMethodBeat.o(183218);
    return localObject3;
  }
  
  public final void n(Collection<a.a> paramCollection)
  {
    AppMethodBeat.i(183216);
    if ((this.LUj == null) || (paramCollection.size() <= 0))
    {
      AppMethodBeat.o(183216);
      return;
    }
    try
    {
      this.LUj.beginTransaction();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = (a.a)paramCollection.next();
        localObject = new a.b(((a.a)localObject).name, ((a.a)localObject).LUc, ((a.a)localObject).dej, "");
        ((a.b)localObject).timestamp = System.currentTimeMillis();
        SQLiteDatabase localSQLiteDatabase = this.LUj;
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("taskName", ((a.b)localObject).name);
        localContentValues.put("threadTime", Long.valueOf(((a.b)localObject).wIM));
        localContentValues.put("time", Long.valueOf(((a.b)localObject).time));
        localContentValues.put("timestamp", Long.valueOf(((a.b)localObject).timestamp));
        localContentValues.put("rate", Float.valueOf(((a.b)localObject).rate));
        localContentValues.put("scheduler", ((a.b)localObject).LUi);
        localSQLiteDatabase.insert("DisposedTask", null, localContentValues);
      }
      this.LUj.setTransactionSuccessful();
    }
    finally
    {
      this.LUj.setTransactionSuccessful();
      this.LUj.endTransaction();
      AppMethodBeat.o(183216);
    }
    this.LUj.endTransaction();
    AppMethodBeat.o(183216);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(183215);
    if (paramSQLiteDatabase == null)
    {
      AppMethodBeat.o(183215);
      return;
    }
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DisposedTask(_ID INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL, taskName TEXT NOT NULL, threadTime LONG NOT NULL, time LONG NOT NULL, rate REAL NOT NULL, timestamp LONG NOT NULL, scheduler TEXT NOT NULL )");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS timestampIndex ON DisposedTask(timestamp)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS taskNameIndex ON DisposedTask(taskName)");
    AppMethodBeat.o(183215);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final class a
    extends CursorWrapper
  {
    a(Cursor paramCursor)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.b.b
 * JD-Core Version:    0.7.0.1
 */