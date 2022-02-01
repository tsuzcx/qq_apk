package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public abstract interface t
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(f.info, "FavEditInfo") };
  
  public abstract f DX(long paramLong);
  
  public abstract boolean a(f paramf);
  
  public abstract boolean a(f paramf, String... paramVarArgs);
  
  public abstract List<f> cUO();
  
  public abstract void y(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.t
 * JD-Core Version:    0.7.0.1
 */