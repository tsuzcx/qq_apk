package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;
import java.util.List;

public abstract interface q
  extends com.tencent.mm.sdk.e.g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(c.info, "FavCdnInfo") };
  
  public abstract c Yk(String paramString);
  
  public abstract void a(p paramp);
  
  public abstract boolean a(c paramc, String... paramVarArgs);
  
  public abstract void b(p paramp);
  
  public abstract boolean b(c paramc, String... paramVarArgs);
  
  public abstract LinkedList<c> chT();
  
  public abstract Cursor chU();
  
  public abstract Cursor chV();
  
  public abstract boolean f(c paramc);
  
  public abstract List<c> pN(long paramLong);
  
  public abstract List<c> pO(long paramLong);
  
  public abstract void pP(long paramLong);
  
  public abstract boolean pQ(long paramLong);
  
  public abstract void startAll();
  
  public abstract int x(long paramLong, int paramInt);
  
  public abstract void y(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.q
 * JD-Core Version:    0.7.0.1
 */