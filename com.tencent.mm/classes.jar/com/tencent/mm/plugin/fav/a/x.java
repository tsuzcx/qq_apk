package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract interface x
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(g.info, "FavItemInfo") };
  
  public abstract long A(long paramLong, int paramInt);
  
  public abstract void A(g paramg);
  
  public abstract LinkedList<Integer> B(long paramLong, int paramInt);
  
  public abstract long C(long paramLong, int paramInt);
  
  public abstract g DY(long paramLong);
  
  public abstract g DZ(long paramLong);
  
  public abstract int HX(int paramInt);
  
  public abstract ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw);
  
  public abstract List<g> a(int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean a(g paramg, String... paramVarArgs);
  
  public abstract void af(int paramInt, long paramLong);
  
  public abstract g asb(String paramString);
  
  public abstract List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw);
  
  public abstract boolean b(g paramg, String... paramVarArgs);
  
  public abstract ISQLiteDatabase cUP();
  
  public abstract int cUQ();
  
  public abstract List<g> cUR();
  
  public abstract List<g> cUS();
  
  public abstract List<g> cUT();
  
  public abstract List<g> cUU();
  
  public abstract List<g> cUV();
  
  public abstract List<g> cUW();
  
  public abstract List<Long> cUX();
  
  public abstract void cUY();
  
  public abstract List<Long> cUZ();
  
  public abstract List<g> fT(int paramInt1, int paramInt2);
  
  public abstract int getCount();
  
  public abstract boolean z(long paramLong, int paramInt);
  
  public abstract boolean z(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.x
 * JD-Core Version:    0.7.0.1
 */