package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;
import java.util.List;

public abstract interface q
  extends com.tencent.mm.sdk.e.g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(c.info, "FavCdnInfo") };
  
  public abstract c NP(String paramString);
  
  public abstract void a(p paramp);
  
  public abstract boolean a(c paramc, String... paramVarArgs);
  
  public abstract void b(p paramp);
  
  public abstract boolean b(c paramc, String... paramVarArgs);
  
  public abstract LinkedList<c> bwD();
  
  public abstract Cursor bwE();
  
  public abstract Cursor bwF();
  
  public abstract boolean e(c paramc);
  
  public abstract List<c> jW(long paramLong);
  
  public abstract List<c> jX(long paramLong);
  
  public abstract void jY(long paramLong);
  
  public abstract boolean jZ(long paramLong);
  
  public abstract void startAll();
  
  public abstract int t(long paramLong, int paramInt);
  
  public abstract void x(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.q
 * JD-Core Version:    0.7.0.1
 */