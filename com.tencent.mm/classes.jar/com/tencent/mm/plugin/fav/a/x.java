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
  
  public abstract g NQ(String paramString);
  
  public abstract void O(int paramInt, long paramLong);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract e bwI();
  
  public abstract int bwJ();
  
  public abstract List<g> bwK();
  
  public abstract List<g> bwL();
  
  public abstract List<g> bwM();
  
  public abstract List<g> bwN();
  
  public abstract List<g> bwO();
  
  public abstract List<g> bwP();
  
  public abstract List<Long> bwQ();
  
  public abstract void bwR();
  
  public abstract List<Long> bwS();
  
  public abstract int getCount();
  
  public abstract g kb(long paramLong);
  
  public abstract g kc(long paramLong);
  
  public abstract boolean v(long paramLong, int paramInt);
  
  public abstract int vU(int paramInt);
  
  public abstract long w(long paramLong, int paramInt);
  
  public abstract LinkedList<Integer> x(long paramLong, int paramInt);
  
  public abstract long y(long paramLong, int paramInt);
  
  public abstract boolean y(g paramg);
  
  public abstract void z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.x
 * JD-Core Version:    0.7.0.1
 */