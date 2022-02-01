package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public abstract interface ac
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(j.info, "FavSearchInfo") };
  
  public abstract boolean a(j paramj);
  
  public abstract boolean a(j paramj, String... paramVarArgs);
  
  public abstract boolean auk(String paramString);
  
  public abstract ArrayList<Long> b(List<String> paramList1, List<String> paramList2, List<Integer> paramList);
  
  public abstract void mM(long paramLong);
  
  public abstract j mN(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ac
 * JD-Core Version:    0.7.0.1
 */