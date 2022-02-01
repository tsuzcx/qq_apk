package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="NotifyCompletionRequestCreator")
public final class zzae
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzae> CREATOR;
  @SafeParcelable.Field(id=2)
  private final String accountType;
  @SafeParcelable.Field(id=3)
  private final int zzcg;
  @SafeParcelable.VersionField(id=1)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10746);
    CREATOR = new zzaf();
    AppMethodBeat.o(10746);
  }
  
  @SafeParcelable.Constructor
  zzae(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt2)
  {
    AppMethodBeat.i(10744);
    this.zzy = 1;
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    this.zzcg = paramInt2;
    AppMethodBeat.o(10744);
  }
  
  public zzae(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10745);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzcg);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzae
 * JD-Core Version:    0.7.0.1
 */