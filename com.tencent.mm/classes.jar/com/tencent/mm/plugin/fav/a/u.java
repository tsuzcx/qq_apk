package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public abstract interface u
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(f.info, "FavEditInfo") };
  
  public abstract void K(long paramLong, int paramInt);
  
  public abstract boolean a(f paramf);
  
  public abstract boolean a(f paramf, String... paramVarArgs);
  
  public abstract List<f> dQE();
  
  public abstract f mJ(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.u
 * JD-Core Version:    0.7.0.1
 */