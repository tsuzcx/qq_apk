package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.g;
import java.util.ArrayList;
import java.util.List;

public abstract interface aa
  extends g
{
  public static final String[] SQL_CREATE = { com.tencent.mm.sdk.e.j.getCreateSQLs(j.info, "FavSearchInfo") };
  
  public abstract boolean a(j paramj);
  
  public abstract boolean a(j paramj, String... paramVarArgs);
  
  public abstract boolean acI(String paramString);
  
  public abstract ArrayList<Long> b(List<String> paramList1, List<String> paramList2, List<Integer> paramList);
  
  public abstract void tJ(long paramLong);
  
  public abstract j tK(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aa
 * JD-Core Version:    0.7.0.1
 */