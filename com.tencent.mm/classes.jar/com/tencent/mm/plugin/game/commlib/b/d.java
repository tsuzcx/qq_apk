package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d
{
  private final AtomicBoolean IsW = new AtomicBoolean(false);
  private final h IsX;
  private volatile SQLiteStatement IsY;
  
  public d(h paramh)
  {
    this.IsX = paramh;
  }
  
  private SQLiteStatement fEd()
  {
    String str = fCI();
    return this.IsX.jef().compileStatement(str);
  }
  
  public final void a(SQLiteStatement paramSQLiteStatement)
  {
    if (paramSQLiteStatement == this.IsY) {
      this.IsW.set(false);
    }
  }
  
  protected abstract String fCI();
  
  public final SQLiteStatement fEe()
  {
    if (this.IsW.compareAndSet(false, true))
    {
      if (this.IsY == null) {
        this.IsY = fEd();
      }
      return this.IsY;
    }
    return fEd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.b.d
 * JD-Core Version:    0.7.0.1
 */