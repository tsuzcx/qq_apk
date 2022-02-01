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
  
  public abstract c ahs(String paramString);
  
  public abstract void b(p paramp);
  
  public abstract boolean b(c paramc, String... paramVarArgs);
  
  public abstract LinkedList<c> cwG();
  
  public abstract Cursor cwH();
  
  public abstract Cursor cwI();
  
  public abstract boolean f(c paramc);
  
  public abstract void startAll();
  
  public abstract List<c> vP(long paramLong);
  
  public abstract List<c> vQ(long paramLong);
  
  public abstract void vR(long paramLong);
  
  public abstract boolean vS(long paramLong);
  
  public abstract void y(g paramg);
  
  public abstract int z(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.q
 * JD-Core Version:    0.7.0.1
 */