package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;
import java.util.List;

public abstract interface q
  extends com.tencent.mm.sdk.e.g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(c.info, "FavCdnInfo") };
  
  public abstract void a(p paramp);
  
  public abstract boolean a(c paramc, String... paramVarArgs);
  
  public abstract c acG(String paramString);
  
  public abstract void b(p paramp);
  
  public abstract boolean b(c paramc, String... paramVarArgs);
  
  public abstract LinkedList<c> cpA();
  
  public abstract Cursor cpB();
  
  public abstract Cursor cpC();
  
  public abstract boolean f(c paramc);
  
  public abstract void startAll();
  
  public abstract List<c> tC(long paramLong);
  
  public abstract List<c> tD(long paramLong);
  
  public abstract void tE(long paramLong);
  
  public abstract boolean tF(long paramLong);
  
  public abstract int y(long paramLong, int paramInt);
  
  public abstract void y(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.q
 * JD-Core Version:    0.7.0.1
 */