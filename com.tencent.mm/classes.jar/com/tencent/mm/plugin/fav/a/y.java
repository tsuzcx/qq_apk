package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract interface y
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(g.info, "FavItemInfo") };
  
  public abstract void A(g paramg);
  
  public abstract boolean L(long paramLong, int paramInt);
  
  public abstract long M(long paramLong, int paramInt);
  
  public abstract int ME(int paramInt);
  
  public abstract LinkedList<Integer> N(long paramLong, int paramInt);
  
  public abstract long O(long paramLong, int paramInt);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, x paramx, boolean paramBoolean);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, x paramx);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract void ak(int paramInt, long paramLong);
  
  public abstract g auj(String paramString);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, x paramx);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract ISQLiteDatabase dQF();
  
  public abstract int dQG();
  
  public abstract List<g> dQH();
  
  public abstract List<g> dQI();
  
  public abstract List<g> dQJ();
  
  public abstract List<g> dQK();
  
  public abstract List<g> dQL();
  
  public abstract List<g> dQM();
  
  public abstract List<Long> dQN();
  
  public abstract void dQO();
  
  public abstract List<Long> dQP();
  
  public abstract int getCount();
  
  public abstract List<g> hj(int paramInt1, int paramInt2);
  
  public abstract g mK(long paramLong);
  
  public abstract g mL(long paramLong);
  
  public abstract boolean z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.y
 * JD-Core Version:    0.7.0.1
 */