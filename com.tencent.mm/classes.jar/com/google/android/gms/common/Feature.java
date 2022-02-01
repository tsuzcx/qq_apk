package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="FeatureCreator")
public class Feature
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Feature> CREATOR;
  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;
  @Deprecated
  @SafeParcelable.Field(getter="getOldVersion", id=2)
  private final int zzaq;
  @SafeParcelable.Field(defaultValue="-1", getter="getVersion", id=3)
  private final long zzar;
  
  static
  {
    AppMethodBeat.i(4378);
    CREATOR = new FeatureCreator();
    AppMethodBeat.o(4378);
  }
  
  @SafeParcelable.Constructor
  public Feature(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) long paramLong)
  {
    this.name = paramString;
    this.zzaq = paramInt;
    this.zzar = paramLong;
  }
  
  public Feature(String paramString, long paramLong)
  {
    this.name = paramString;
    this.zzar = paramLong;
    this.zzaq = -1;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4375);
    if ((paramObject instanceof Feature))
    {
      paramObject = (Feature)paramObject;
      if (((getName() != null) && (getName().equals(paramObject.getName()))) || ((getName() == null) && (paramObject.getName() == null) && (getVersion() == paramObject.getVersion())))
      {
        AppMethodBeat.o(4375);
        return true;
      }
      AppMethodBeat.o(4375);
      return false;
    }
    AppMethodBeat.o(4375);
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getVersion()
  {
    if (this.zzar == -1L) {
      return this.zzaq;
    }
    return this.zzar;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(4376);
    int i = Objects.hashCode(new Object[] { getName(), Long.valueOf(getVersion()) });
    AppMethodBeat.o(4376);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(4377);
    String str = Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
    AppMethodBeat.o(4377);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4374);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzaq);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(4374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.Feature
 * JD-Core Version:    0.7.0.1
 */