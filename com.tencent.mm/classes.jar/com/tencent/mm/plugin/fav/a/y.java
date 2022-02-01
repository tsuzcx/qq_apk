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
  
  public abstract boolean B(long paramLong, int paramInt);
  
  public abstract long C(long paramLong, int paramInt);
  
  public abstract LinkedList<Integer> D(long paramLong, int paramInt);
  
  public abstract long E(long paramLong, int paramInt);
  
  public abstract g Km(long paramLong);
  
  public abstract g Kn(long paramLong);
  
  public abstract int LH(int paramInt);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, x paramx);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, x paramx);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract g aAc(String paramString);
  
  public abstract void ag(int paramInt, long paramLong);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, x paramx);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract ISQLiteDatabase djV();
  
  public abstract int djW();
  
  public abstract List<g> djX();
  
  public abstract List<g> djY();
  
  public abstract List<g> djZ();
  
  public abstract List<g> dka();
  
  public abstract List<g> dkb();
  
  public abstract List<g> dkc();
  
  public abstract List<Long> dkd();
  
  public abstract void dke();
  
  public abstract List<Long> dkf();
  
  public abstract int getCount();
  
  public abstract List<g> gq(int paramInt1, int paramInt2);
  
  public abstract boolean z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.y
 * JD-Core Version:    0.7.0.1
 */