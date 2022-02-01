package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public abstract interface aa
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(j.info, "FavSearchInfo") };
  
  public abstract void Ea(long paramLong);
  
  public abstract j Eb(long paramLong);
  
  public abstract boolean a(j paramj);
  
  public abstract boolean a(j paramj, String... paramVarArgs);
  
  public abstract boolean asc(String paramString);
  
  public abstract ArrayList<Long> b(List<String> paramList1, List<String> paramList2, List<Integer> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aa
 * JD-Core Version:    0.7.0.1
 */