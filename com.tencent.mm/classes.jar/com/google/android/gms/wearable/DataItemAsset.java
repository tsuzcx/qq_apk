package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public abstract interface DataItemAsset
  extends Freezable<DataItemAsset>
{
  public abstract String getDataItemKey();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.DataItemAsset
 * JD-Core Version:    0.7.0.1
 */