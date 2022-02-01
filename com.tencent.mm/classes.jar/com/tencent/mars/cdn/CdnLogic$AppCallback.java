package com.tencent.mars.cdn;

public abstract interface CdnLogic$AppCallback
{
  public abstract void onBadNetworkProbed();
  
  public abstract void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void requestGetCDN(int paramInt);
  
  public abstract String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.AppCallback
 * JD-Core Version:    0.7.0.1
 */