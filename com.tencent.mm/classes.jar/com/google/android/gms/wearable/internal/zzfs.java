package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfs
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfs> CREATOR;
  private final String label;
  private final String packageName;
  private final long zzep;
  
  static
  {
    AppMethodBeat.i(101321);
    CREATOR = new zzft();
    AppMethodBeat.o(101321);
  }
  
  public zzfs(String paramString1, String paramString2, long paramLong)
  {
    this.packageName = paramString1;
    this.label = paramString2;
    this.zzep = paramLong;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101320);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.label, false);
    SafeParcelWriter.writeLong(paramParcel, 4, this.zzep);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfs
 * JD-Core Version:    0.7.0.1
 */