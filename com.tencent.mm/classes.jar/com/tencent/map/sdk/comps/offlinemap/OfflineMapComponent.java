package com.tencent.map.sdk.comps.offlinemap;

import com.tencent.map.tools.Callback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component;
import java.util.List;

public abstract interface OfflineMapComponent
  extends TencentMapComponent.Component
{
  public abstract OfflineItemController getOfflineItemController(OfflineItem paramOfflineItem, OfflineStatusChangedListener paramOfflineStatusChangedListener);
  
  public abstract List<OfflineItem> getOfflineItemList();
  
  public abstract void getOfflineItemList(Callback<List<OfflineItem>> paramCallback);
  
  public abstract boolean isOfflineMapEnable();
  
  public abstract void syncLatestData(OfflineMapSyncedListener paramOfflineMapSyncedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
 * JD-Core Version:    0.7.0.1
 */