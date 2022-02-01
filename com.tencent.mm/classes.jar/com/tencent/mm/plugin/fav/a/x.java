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
  
  public abstract boolean A(long paramLong, int paramInt);
  
  public abstract long B(long paramLong, int paramInt);
  
  public abstract LinkedList<Integer> C(long paramLong, int paramInt);
  
  public abstract long D(long paramLong, int paramInt);
  
  public abstract int Dh(int paramInt);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract void aa(int paramInt, long paramLong);
  
  public abstract g acH(String paramString);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract e cpF();
  
  public abstract int cpG();
  
  public abstract List<g> cpH();
  
  public abstract List<g> cpI();
  
  public abstract List<g> cpJ();
  
  public abstract List<g> cpK();
  
  public abstract List<g> cpL();
  
  public abstract List<g> cpM();
  
  public abstract List<Long> cpN();
  
  public abstract void cpO();
  
  public abstract List<Long> cpP();
  
  public abstract int getCount();
  
  public abstract g tH(long paramLong);
  
  public abstract g tI(long paramLong);
  
  public abstract boolean z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.x
 * JD-Core Version:    0.7.0.1
 */