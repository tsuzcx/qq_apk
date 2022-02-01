package com.tencent.map.sdk.comps.offlinemap;

public abstract interface OfflineItemController
{
  public abstract boolean checkInvalidate();
  
  public abstract boolean close();
  
  public abstract boolean open();
  
  public abstract boolean removeCache();
  
  public abstract void startDownload();
  
  public abstract void stopDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.sdk.comps.offlinemap.OfflineItemController
 * JD-Core Version:    0.7.0.1
 */