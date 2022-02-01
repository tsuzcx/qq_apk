package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.ICertData.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="GoogleCertificatesQueryCreator")
public class GoogleCertificatesQuery
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GoogleCertificatesQuery> CREATOR;
  @SafeParcelable.Field(getter="getCallingPackage", id=1)
  private final String zzbh;
  @Nullable
  @SafeParcelable.Field(getter="getCallingCertificateBinder", id=2, type="android.os.IBinder")
  private final GoogleCertificates.CertData zzbi;
  @SafeParcelable.Field(getter="getAllowTestKeys", id=3)
  private final boolean zzbj;
  
  static
  {
    AppMethodBeat.i(4411);
    CREATOR = new GoogleCertificatesQueryCreator();
    AppMethodBeat.o(4411);
  }
  
  @SafeParcelable.Constructor
  GoogleCertificatesQuery(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) @Nullable IBinder paramIBinder, @SafeParcelable.Param(id=3) boolean paramBoolean)
  {
    AppMethodBeat.i(4407);
    this.zzbh = paramString;
    this.zzbi = zza(paramIBinder);
    this.zzbj = paramBoolean;
    AppMethodBeat.o(4407);
  }
  
  GoogleCertificatesQuery(String paramString, @Nullable GoogleCertificates.CertData paramCertData, boolean paramBoolean)
  {
    this.zzbh = paramString;
    this.zzbi = paramCertData;
    this.zzbj = paramBoolean;
  }
  
  @Nullable
  private static GoogleCertificates.CertData zza(@Nullable IBinder paramIBinder)
  {
    AppMethodBeat.i(4410);
    if (paramIBinder == null)
    {
      AppMethodBeat.o(4410);
      return null;
    }
    for (;;)
    {
      try
      {
        paramIBinder = ICertData.Stub.asInterface(paramIBinder).getBytesWrapped();
        if (paramIBinder == null)
        {
          paramIBinder = null;
          if (paramIBinder == null) {
            break label75;
          }
          paramIBinder = new zzb(paramIBinder);
          AppMethodBeat.o(4410);
          return paramIBinder;
        }
      }
      catch (RemoteException paramIBinder)
      {
        AppMethodBeat.o(4410);
        return null;
      }
      paramIBinder = (byte[])ObjectWrapper.unwrap(paramIBinder);
      continue;
      label75:
      paramIBinder = null;
    }
  }
  
  public boolean getAllowTestKeys()
  {
    return this.zzbj;
  }
  
  @Nullable
  public IBinder getCallingCertificateBinder()
  {
    AppMethodBeat.i(4408);
    if (this.zzbi == null)
    {
      AppMethodBeat.o(4408);
      return null;
    }
    IBinder localIBinder = this.zzbi.asBinder();
    AppMethodBeat.o(4408);
    return localIBinder;
  }
  
  public String getCallingPackage()
  {
    return this.zzbh;
  }
  
  @Nullable
  public GoogleCertificates.CertData getCertificate()
  {
    return this.zzbi;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4409);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getCallingPackage(), false);
    SafeParcelWriter.writeIBinder(paramParcel, 2, getCallingCertificateBinder(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, getAllowTestKeys());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(4409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.GoogleCertificatesQuery
 * JD-Core Version:    0.7.0.1
 */