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
  
  public abstract List<f> chX();
  
  public abstract f pR(long paramLong);
  
  public abstract void y(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.t
 * JD-Core Version:    0.7.0.1
 */