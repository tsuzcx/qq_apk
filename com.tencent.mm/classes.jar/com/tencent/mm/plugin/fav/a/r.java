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
  
  public abstract int J(long paramLong, int paramInt);
  
  public abstract void a(q paramq);
  
  public abstract boolean a(c paramc, String... paramVarArgs);
  
  public abstract c aui(String paramString);
  
  public abstract void b(q paramq);
  
  public abstract boolean b(c paramc, String... paramVarArgs);
  
  public abstract LinkedList<c> dQA();
  
  public abstract Cursor dQB();
  
  public abstract Cursor dQC();
  
  public abstract boolean f(c paramc);
  
  public abstract List<c> mF(long paramLong);
  
  public abstract List<c> mG(long paramLong);
  
  public abstract void mH(long paramLong);
  
  public abstract boolean mI(long paramLong);
  
  public abstract void startAll();
  
  public abstract void y(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.r
 * JD-Core Version:    0.7.0.1
 */