package com.google.android.gms.auth;

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
import java.util.List;

@SafeParcelable.Class(creator="AccountChangeEventsResponseCreator")
public class AccountChangeEventsResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzh;
  @SafeParcelable.Field(id=2)
  private final List<AccountChangeEvent> zzo;
  
  static
  {
    AppMethodBeat.i(76934);
    CREATOR = new zzf();
    AppMethodBeat.o(76934);
  }
  
  @SafeParcelable.Constructor
  AccountChangeEventsResponse(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) List<AccountChangeEvent> paramList)
  {
    AppMethodBeat.i(76931);
    this.zzh = paramInt;
    this.zzo = ((List)Preconditions.checkNotNull(paramList));
    AppMethodBeat.o(76931);
  }
  
  public AccountChangeEventsResponse(List<AccountChangeEvent> paramList)
  {
    AppMethodBeat.i(76932);
    this.zzh = 1;
    this.zzo = ((List)Preconditions.checkNotNull(paramList));
    AppMethodBeat.o(76932);
  }
  
  public List<AccountChangeEvent> getEvents()
  {
    return this.zzo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(76933);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzh);
    SafeParcelWriter.writeTypedList(paramParcel, 2, this.zzo, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(76933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsResponse
 * JD-Core Version:    0.7.0.1
 */