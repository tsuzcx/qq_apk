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
  
  public abstract long A(long paramLong, int paramInt);
  
  public abstract void A(g paramg);
  
  public abstract LinkedList<Integer> B(long paramLong, int paramInt);
  
  public abstract long C(long paramLong, int paramInt);
  
  public abstract int Cm(int paramInt);
  
  public abstract g Yl(String paramString);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract void ab(int paramInt, long paramLong);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract e chY();
  
  public abstract int chZ();
  
  public abstract List<g> cia();
  
  public abstract List<g> cib();
  
  public abstract List<g> cic();
  
  public abstract List<g> cid();
  
  public abstract List<g> cie();
  
  public abstract List<g> cif();
  
  public abstract List<Long> cig();
  
  public abstract void cih();
  
  public abstract List<Long> cii();
  
  public abstract int getCount();
  
  public abstract g pS(long paramLong);
  
  public abstract g pT(long paramLong);
  
  public abstract boolean z(long paramLong, int paramInt);
  
  public abstract boolean z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.x
 * JD-Core Version:    0.7.0.1
 */