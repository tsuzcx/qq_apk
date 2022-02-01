package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class AccountChangeEventsResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR;
  private final int zzh;
  private final List<AccountChangeEvent> zzo;
  
  static
  {
    AppMethodBeat.i(10593);
    CREATOR = new zzf();
    AppMethodBeat.o(10593);
  }
  
  AccountChangeEventsResponse(int paramInt, List<AccountChangeEvent> paramList)
  {
    AppMethodBeat.i(10590);
    this.zzh = paramInt;
    this.zzo = ((List)Preconditions.checkNotNull(paramList));
    AppMethodBeat.o(10590);
  }
  
  public AccountChangeEventsResponse(List<AccountChangeEvent> paramList)
  {
    AppMethodBeat.i(10591);
    this.zzh = 1;
    this.zzo = ((List)Preconditions.checkNotNull(paramList));
    AppMethodBeat.o(10591);
  }
  
  public List<AccountChangeEvent> getEvents()
  {
    return this.zzo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10592);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzh);
    SafeParcelWriter.writeTypedList(paramParcel, 2, this.zzo, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsResponse
 * JD-Core Version:    0.7.0.1
 */