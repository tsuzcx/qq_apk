package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;

class WearableListenerService$zzc$1
  implements Runnable
{
  WearableListenerService$zzc$1(WearableListenerService.zzc paramzzc, DataHolder paramDataHolder) {}
  
  public void run()
  {
    DataEventBuffer localDataEventBuffer = new DataEventBuffer(this.zzbTr);
    try
    {
      this.zzbTs.zzbTp.onDataChanged(localDataEventBuffer);
      return;
    }
    finally
    {
      localDataEventBuffer.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzc.1
 * JD-Core Version:    0.7.0.1
 */