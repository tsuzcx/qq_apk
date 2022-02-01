package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepName
@SafeParcelable.Class(creator="DataItemAssetParcelableCreator")
@SafeParcelable.Reserved({1})
public class DataItemAssetParcelable
  extends AbstractSafeParcelable
  implements ReflectedParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR;
  @SafeParcelable.Field(getter="getId", id=2)
  private final String zzdm;
  @SafeParcelable.Field(getter="getDataItemKey", id=3)
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
  
  @SafeParcelable.Constructor
  DataItemAssetParcelable(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.7.0.1
 */