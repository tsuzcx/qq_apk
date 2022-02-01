package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public abstract interface r
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(c.info, "FavCdnInfo") };
  
  public abstract List<c> Kh(long paramLong);
  
  public abstract List<c> Ki(long paramLong);
  
  public abstract void Kj(long paramLong);
  
  public abstract boolean Kk(long paramLong);
  
  public abstract void a(q paramq);
  
  public abstract boolean a(c paramc, String... paramVarArgs);
  
  public abstract c aAb(String paramString);
  
  public abstract void b(q paramq);
  
  public abstract boolean b(c paramc, String... paramVarArgs);
  
  public abstract LinkedList<c> djQ();
  
  public abstract Cursor djR();
  
  public abstract Cursor djS();
  
  public abstract boolean f(c paramc);
  
  public abstract void startAll();
  
  public abstract void y(g paramg);
  
  public abstract int z(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.r
 * JD-Core Version:    0.7.0.1
 */