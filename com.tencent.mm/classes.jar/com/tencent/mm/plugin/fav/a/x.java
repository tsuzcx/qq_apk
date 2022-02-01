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
  
  public abstract int DZ(int paramInt);
  
  public abstract long E(long paramLong, int paramInt);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract void ad(int paramInt, long paramLong);
  
  public abstract g agw(String paramString);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract e cvk();
  
  public abstract int cvl();
  
  public abstract List<g> cvm();
  
  public abstract List<g> cvn();
  
  public abstract List<g> cvo();
  
  public abstract List<g> cvp();
  
  public abstract List<g> cvq();
  
  public abstract List<g> cvr();
  
  public abstract List<Long> cvs();
  
  public abstract void cvt();
  
  public abstract List<Long> cvu();
  
  public abstract int getCount();
  
  public abstract g vE(long paramLong);
  
  public abstract g vF(long paramLong);
  
  public abstract boolean z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.x
 * JD-Core Version:    0.7.0.1
 */