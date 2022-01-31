package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzak
  implements DataItemAsset
{
  private final String zzAX;
  private final String zzGV;
  
  public zzak(DataItemAsset paramDataItemAsset)
  {
    this.zzGV = paramDataItemAsset.getId();
    this.zzAX = paramDataItemAsset.getDataItemKey();
  }
  
  public String getDataItemKey()
  {
    return this.zzAX;
  }
  
  public String getId()
  {
    return this.zzGV;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzGV == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.zzAX);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.zzGV);
    }
  }
  
  public DataItemAsset zzUv()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzak
 * JD-Core Version:    0.7.0.1
 */