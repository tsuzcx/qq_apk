package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;

public abstract interface s
  extends IStorage
{
  public static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(e.info, "FavConfigInfo") };
  
  public abstract void bE(byte[] paramArrayOfByte);
  
  public abstract byte[] cUN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.s
 * JD-Core Version:    0.7.0.1
 */