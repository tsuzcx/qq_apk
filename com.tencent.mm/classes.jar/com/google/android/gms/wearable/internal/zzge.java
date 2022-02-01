package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzge
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzge> CREATOR;
  private final int statusCode;
  private final long zzep;
  private final List<zzfs> zzer;
  
  static
  {
    AppMethodBeat.i(101346);
    CREATOR = new zzgf();
    AppMethodBeat.o(101346);
  }
  
  public zzge(int paramInt, long paramLong, List<zzfs> paramList)
  {
    this.statusCode = paramInt;
    this.zzep = paramLong;
    this.zzer = paramList;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101345);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzep);
    SafeParcelWriter.writeTypedList(paramParcel, 4, this.zzer, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzge
 * JD-Core Version:    0.7.0.1
 */