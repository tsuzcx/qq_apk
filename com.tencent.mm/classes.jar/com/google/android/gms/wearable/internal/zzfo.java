package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="NodeParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzfo
  extends AbstractSafeParcelable
  implements Node
{
  public static final Parcelable.Creator<zzfo> CREATOR;
  @SafeParcelable.Field(getter="getDisplayName", id=3)
  private final String zzbk;
  @SafeParcelable.Field(getter="getId", id=2)
  private final String zzdm;
  @SafeParcelable.Field(getter="getHopCount", id=4)
  private final int zzen;
  @SafeParcelable.Field(getter="isNearby", id=5)
  private final boolean zzeo;
  
  static
  {
    AppMethodBeat.i(71332);
    CREATOR = new zzfp();
    AppMethodBeat.o(71332);
  }
  
  @SafeParcelable.Constructor
  public zzfo(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) int paramInt, @SafeParcelable.Param(id=5) boolean paramBoolean)
  {
    this.zzdm = paramString1;
    this.zzbk = paramString2;
    this.zzen = paramInt;
    this.zzeo = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(71329);
    if (!(paramObject instanceof zzfo))
    {
      AppMethodBeat.o(71329);
      return false;
    }
    boolean bool = ((zzfo)paramObject).zzdm.equals(this.zzdm);
    AppMethodBeat.o(71329);
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
    AppMethodBeat.i(71330);
    int i = this.zzdm.hashCode();
    AppMethodBeat.o(71330);
    return i;
  }
  
  public final boolean isNearby()
  {
    return this.zzeo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71331);
    String str1 = this.zzbk;
    String str2 = this.zzdm;
    int i = this.zzen;
    boolean bool = this.zzeo;
    str1 = String.valueOf(str1).length() + 45 + String.valueOf(str2).length() + "Node{" + str1 + ", id=" + str2 + ", hops=" + i + ", isNearby=" + bool + "}";
    AppMethodBeat.o(71331);
    return str1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(71328);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getDisplayName(), false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzen);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isNearby());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(71328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfo
 * JD-Core Version:    0.7.0.1
 */