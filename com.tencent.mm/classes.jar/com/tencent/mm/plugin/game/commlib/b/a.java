package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Iterator;

public abstract class a<T>
  extends d
{
  public a(h paramh)
  {
    super(paramh);
  }
  
  protected abstract void a(SQLiteStatement paramSQLiteStatement, T paramT);
  
  public final void b(Iterable<? extends T> paramIterable)
  {
    SQLiteStatement localSQLiteStatement = fEe();
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        a(localSQLiteStatement, paramIterable.next());
        localSQLiteStatement.executeInsert();
      }
    }
    finally
    {
      a(localSQLiteStatement);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b.a
 * JD-Core Version:    0.7.0.1
 */