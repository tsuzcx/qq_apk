package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataItemAssetParcelable
  extends AbstractSafeParcelable
  implements ReflectedParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR;
  private final String zzdm;
  private final String zzdn;
  
  static
  {
    AppMethodBeat.i(100925);
    CREATOR = new zzda();
    AppMethodBeat.o(100925);
  }
  
  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    AppMethodBeat.i(100922);
    this.zzdm = ((String)Preconditions.checkNotNull(paramDataItemAsset.getId()));
    this.zzdn = ((String)Preconditions.checkNotNull(paramDataItemAsset.getDataItemKey()));
    AppMethodBeat.o(100922);
  }
  
  DataItemAssetParcelable(String paramString1, String paramString2)
  {
    this.zzdm = paramString1;
    this.zzdn = paramString2;
  }
  
  public String getDataItemKey()
  {
    return this.zzdn;
  }
  
  public String getId()
  {
    return this.zzdm;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    AppMethodBeat.i(100924);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataItemAssetParcelable[");
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    if (this.zzdm == null) {
      ((StringBuilder)localObject).append(",noid");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(", key=");
      ((StringBuilder)localObject).append(this.zzdn);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(100924);
      return localObject;
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.zzdm);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(100923);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getDataItemKey(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(100923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.7.0.1
 */