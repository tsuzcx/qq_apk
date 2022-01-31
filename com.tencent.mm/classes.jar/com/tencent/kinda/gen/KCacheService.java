package com.tencent.kinda.gen;

public abstract interface KCacheService
{
  public abstract byte[] get(String paramString);
  
  public abstract boolean getBool(String paramString);
  
  public abstract boolean remove(String paramString);
  
  public abstract void set(String paramString, byte[] paramArrayOfByte, long paramLong);
  
  public abstract void setBool(String paramString, boolean paramBoolean, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KCacheService
 * JD-Core Version:    0.7.0.1
 */