package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.j;

public abstract interface s
  extends g
{
  public static final String[] SQL_CREATE = { j.getCreateSQLs(e.info, "FavConfigInfo") };
  
  public abstract void bo(byte[] paramArrayOfByte);
  
  public abstract byte[] cvi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.s
 * JD-Core Version:    0.7.0.1
 */