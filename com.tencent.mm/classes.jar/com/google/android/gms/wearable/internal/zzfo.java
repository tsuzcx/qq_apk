package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfo
  extends AbstractSafeParcelable
  implements Node
{
  public static final Parcelable.Creator<zzfo> CREATOR;
  private final String zzbk;
  private final String zzdm;
  private final int zzen;
  private final boolean zzeo;
  
  static
  {
    AppMethodBeat.i(101315);
    CREATOR = new zzfp();
    AppMethodBeat.o(101315);
  }
  
  public zzfo(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.zzdm = paramString1;
    this.zzbk = paramString2;
    this.zzen = paramInt;
    this.zzeo = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101312);
    if (!(paramObject instanceof zzfo))
    {
      AppMethodBeat.o(101312);
      return false;
    }
    boolean bool = ((zzfo)paramObject).zzdm.equals(this.zzdm);
    AppMethodBeat.o(101312);
    return bool;
  }
  
  public final String getDisplayName()
  {
    return this.zzbk;
  }
  
  public final String getId()
  {
    return this.zzdm;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101313);
    int i = this.zzdm.hashCode();
    AppMethodBeat.o(101313);
    return i;
  }
  
  public final boolean isNearby()
  {
    return this.zzeo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101314);
    String str1 = this.zzbk;
    String str2 = this.zzdm;
    int i = this.zzen;
    boolean bool = this.zzeo;
    str1 = String.valueOf(str1).length() + 45 + String.valueOf(str2).length() + "Node{" + str1 + ", id=" + str2 + ", hops=" + i + ", isNearby=" + bool + "}";
    AppMethodBeat.o(101314);
    return str1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101311);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getDisplayName(), false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzen);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isNearby());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfo
 * JD-Core Version:    0.7.0.1
 */