package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.DataItemAsset;

@KeepName
public class DataItemAssetParcelable
  extends zza
  implements ReflectedParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzal();
  private final String zzAX;
  private final String zzGV;
  
  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    this.zzGV = ((String)zzac.zzw(paramDataItemAsset.getId()));
    this.zzAX = ((String)zzac.zzw(paramDataItemAsset.getDataItemKey()));
  }
  
  DataItemAssetParcelable(String paramString1, String paramString2)
  {
    this.zzGV = paramString1;
    this.zzAX = paramString2;
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
    localStringBuilder.append("DataItemAssetParcelable[");
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzal.zza(this, paramParcel, paramInt);
  }
  
  public DataItemAsset zzUv()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.7.0.1
 */