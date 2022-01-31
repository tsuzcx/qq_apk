package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ResolveAccountResponseCreator")
public class ResolveAccountResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getConnectionResult", id=3)
  private ConnectionResult zzeu;
  @SafeParcelable.Field(getter="getSaveDefaultAccount", id=4)
  private boolean zzhs;
  @SafeParcelable.Field(id=2)
  private IBinder zzqv;
  @SafeParcelable.Field(getter="isFromCrossClientAuth", id=5)
  private boolean zzuv;
  
  static
  {
    AppMethodBeat.i(61369);
    CREATOR = new ResolveAccountResponseCreator();
    AppMethodBeat.o(61369);
  }
  
  public ResolveAccountResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null));
    AppMethodBeat.i(61364);
    AppMethodBeat.o(61364);
  }
  
  @SafeParcelable.Constructor
  ResolveAccountResponse(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) ConnectionResult paramConnectionResult, @SafeParcelable.Param(id=4) boolean paramBoolean1, @SafeParcelable.Param(id=5) boolean paramBoolean2)
  {
    this.zzal = paramInt;
    this.zzqv = paramIBinder;
    this.zzeu = paramConnectionResult;
    this.zzhs = paramBoolean1;
    this.zzuv = paramBoolean2;
  }
  
  public ResolveAccountResponse(ConnectionResult paramConnectionResult)
  {
    this(1, null, paramConnectionResult, false, false);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61368);
    if (this == paramObject)
    {
      AppMethodBeat.o(61368);
      return true;
    }
    if (!(paramObject instanceof ResolveAccountResponse))
    {
      AppMethodBeat.o(61368);
      return false;
    }
    paramObject = (ResolveAccountResponse)paramObject;
    if ((this.zzeu.equals(paramObject.zzeu)) && (getAccountAccessor().equals(paramObject.getAccountAccessor())))
    {
      AppMethodBeat.o(61368);
      return true;
    }
    AppMethodBeat.o(61368);
    return false;
  }
  
  public IAccountAccessor getAccountAccessor()
  {
    AppMethodBeat.i(61365);
    IAccountAccessor localIAccountAccessor = IAccountAccessor.Stub.asInterface(this.zzqv);
    AppMethodBeat.o(61365);
    return localIAccountAccessor;
  }
  
  public ConnectionResult getConnectionResult()
  {
    return this.zzeu;
  }
  
  public boolean getSaveDefaultAccount()
  {
    return this.zzhs;
  }
  
  public boolean isFromCrossClientAuth()
  {
    return this.zzuv;
  }
  
  public ResolveAccountResponse setAccountAccessor(IAccountAccessor paramIAccountAccessor)
  {
    AppMethodBeat.i(61366);
    if (paramIAccountAccessor == null) {}
    for (paramIAccountAccessor = null;; paramIAccountAccessor = paramIAccountAccessor.asBinder())
    {
      this.zzqv = paramIAccountAccessor;
      AppMethodBeat.o(61366);
      return this;
    }
  }
  
  public ResolveAccountResponse setIsFromCrossClientAuth(boolean paramBoolean)
  {
    this.zzuv = paramBoolean;
    return this;
  }
  
  public ResolveAccountResponse setSaveDefaultAccount(boolean paramBoolean)
  {
    this.zzhs = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61367);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzqv, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, getSaveDefaultAccount());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isFromCrossClientAuth());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(61367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * JD-Core Version:    0.7.0.1
 */