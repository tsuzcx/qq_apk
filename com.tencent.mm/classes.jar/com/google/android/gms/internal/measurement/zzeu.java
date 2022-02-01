package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzeu
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzeu> CREATOR;
  @SafeParcelable.Field(id=2)
  public final String name;
  @SafeParcelable.Field(id=4)
  public final String origin;
  @SafeParcelable.Field(id=3)
  public final zzer zzafq;
  @SafeParcelable.Field(id=5)
  public final long zzagb;
  
  static
  {
    AppMethodBeat.i(1271);
    CREATOR = new zzev();
    AppMethodBeat.o(1271);
  }
  
  zzeu(zzeu paramzzeu, long paramLong)
  {
    AppMethodBeat.i(1268);
    Preconditions.checkNotNull(paramzzeu);
    this.name = paramzzeu.name;
    this.zzafq = paramzzeu.zzafq;
    this.origin = paramzzeu.origin;
    this.zzagb = paramLong;
    AppMethodBeat.o(1268);
  }
  
  @SafeParcelable.Constructor
  public zzeu(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) zzer paramzzer, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) long paramLong)
  {
    this.name = paramString1;
    this.zzafq = paramzzer;
    this.origin = paramString2;
    this.zzagb = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(1269);
    String str1 = this.origin;
    String str2 = this.name;
    String str3 = String.valueOf(this.zzafq);
    str1 = String.valueOf(str1).length() + 21 + String.valueOf(str2).length() + String.valueOf(str3).length() + "origin=" + str1 + ",name=" + str2 + ",params=" + str3;
    AppMethodBeat.o(1269);
    return str1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(1270);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzafq, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.origin, false);
    SafeParcelWriter.writeLong(paramParcel, 5, this.zzagb);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(1270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzeu
 * JD-Core Version:    0.7.0.1
 */