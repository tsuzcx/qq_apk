package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcz
  implements DataItemAsset
{
  private final String zzdm;
  private final String zzdn;
  
  public zzcz(DataItemAsset paramDataItemAsset)
  {
    AppMethodBeat.i(71181);
    this.zzdm = paramDataItemAsset.getId();
    this.zzdn = paramDataItemAsset.getDataItemKey();
    AppMethodBeat.o(71181);
  }
  
  public final String getDataItemKey()
  {
    return this.zzdn;
  }
  
  public final String getId()
  {
    return this.zzdm;
  }
  
  public final boolean isDataValid()
  {
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71182);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataItemAssetEntity[");
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
      AppMethodBeat.o(71182);
      return localObject;
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.zzdm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcz
 * JD-Core Version:    0.7.0.1
 */