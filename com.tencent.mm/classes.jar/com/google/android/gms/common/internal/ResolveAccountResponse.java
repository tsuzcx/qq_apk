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
    AppMethodBeat.i(11861);
    CREATOR = new ResolveAccountResponseCreator();
    AppMethodBeat.o(11861);
  }
  
  public ResolveAccountResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null));
    AppMethodBeat.i(11856);
    AppMethodBeat.o(11856);
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
    AppMethodBeat.i(11860);
    if (this == paramObject)
    {
      AppMethodBeat.o(11860);
      return true;
    }
    if (!(paramObject instanceof ResolveAccountResponse))
    {
      AppMethodBeat.o(11860);
      return false;
    }
    paramObject = (ResolveAccountResponse)paramObject;
    if ((this.zzeu.equals(paramObject.zzeu)) && (getAccountAccessor().equals(paramObject.getAccountAccessor())))
    {
      AppMethodBeat.o(11860);
      return true;
    }
    AppMethodBeat.o(11860);
    return false;
  }
  
  public IAccountAccessor getAccountAccessor()
  {
    AppMethodBeat.i(11857);
    IAccountAccessor localIAccountAccessor = IAccountAccessor.Stub.asInterface(this.zzqv);
    AppMethodBeat.o(11857);
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
    AppMethodBeat.i(11858);
    if (paramIAccountAccessor == null) {}
    for (paramIAccountAccessor = null;; paramIAccountAccessor = paramIAccountAccessor.asBinder())
    {
      this.zzqv = paramIAccountAccessor;
      AppMethodBeat.o(11858);
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
    AppMethodBeat.i(11859);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzqv, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, getSaveDefaultAccount());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isFromCrossClientAuth());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(11859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * JD-Core Version:    0.7.0.1
 */