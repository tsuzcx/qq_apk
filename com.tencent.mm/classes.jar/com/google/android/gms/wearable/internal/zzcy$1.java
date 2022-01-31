package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzabh.zzc;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;

final class zzcy$1
  implements zzabh.zzc<DataApi.DataListener>
{
  zzcy$1(DataHolder paramDataHolder) {}
  
  public final void zza(DataApi.DataListener paramDataListener)
  {
    try
    {
      paramDataListener.onDataChanged(new DataEventBuffer(this.zzbTr));
      return;
    }
    finally
    {
      this.zzbTr.close();
    }
  }
  
  public final void zzwc()
  {
    this.zzbTr.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcy.1
 * JD-Core Version:    0.7.0.1
 */