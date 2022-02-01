package com.tencent.kinda.gen;

public abstract interface KNetworkService
{
  public abstract byte[] getBaseRequest(int paramInt);
  
  public abstract void invoke(KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KNetworkService
 * JD-Core Version:    0.7.0.1
 */