package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;

public abstract interface t
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(e.info, "FavConfigInfo") };
  
  public abstract void bS(byte[] paramArrayOfByte);
  
  public abstract byte[] djT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.t
 * JD-Core Version:    0.7.0.1
 */