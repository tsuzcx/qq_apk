package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public abstract interface q
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(c.info, "FavCdnInfo") };
  
  public abstract List<c> DT(long paramLong);
  
  public abstract List<c> DU(long paramLong);
  
  public abstract void DV(long paramLong);
  
  public abstract boolean DW(long paramLong);
  
  public abstract void a(p paramp);
  
  public abstract boolean a(c paramc, String... paramVarArgs);
  
  public abstract c asa(String paramString);
  
  public abstract void b(p paramp);
  
  public abstract boolean b(c paramc, String... paramVarArgs);
  
  public abstract LinkedList<c> cUK();
  
  public abstract Cursor cUL();
  
  public abstract Cursor cUM();
  
  public abstract boolean f(c paramc);
  
  public abstract void startAll();
  
  public abstract int x(long paramLong, int paramInt);
  
  public abstract void y(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.q
 * JD-Core Version:    0.7.0.1
 */