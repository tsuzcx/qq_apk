package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract interface x
  extends com.tencent.mm.sdk.e.g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(g.info, "FavItemInfo") };
  
  public abstract void A(g paramg);
  
  public abstract boolean B(long paramLong, int paramInt);
  
  public abstract long C(long paramLong, int paramInt);
  
  public abstract LinkedList<Integer> D(long paramLong, int paramInt);
  
  public abstract long E(long paramLong, int paramInt);
  
  public abstract int Em(int paramInt);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract void ac(int paramInt, long paramLong);
  
  public abstract g aht(String paramString);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract e cwL();
  
  public abstract int cwM();
  
  public abstract List<g> cwN();
  
  public abstract List<g> cwO();
  
  public abstract List<g> cwP();
  
  public abstract List<g> cwQ();
  
  public abstract List<g> cwR();
  
  public abstract List<g> cwS();
  
  public abstract List<Long> cwT();
  
  public abstract void cwU();
  
  public abstract List<Long> cwV();
  
  public abstract int getCount();
  
  public abstract g vU(long paramLong);
  
  public abstract g vV(long paramLong);
  
  public abstract boolean z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.x
 * JD-Core Version:    0.7.0.1
 */