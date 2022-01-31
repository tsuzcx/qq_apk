package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.j;
import java.util.List;

public abstract interface t
  extends g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(f.info, "FavEditInfo") };
  
  public abstract boolean a(f paramf);
  
  public abstract boolean a(f paramf, String... paramVarArgs);
  
  public abstract List<f> bwH();
  
  public abstract f ka(long paramLong);
  
  public abstract void u(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.t
 * JD-Core Version:    0.7.0.1
 */