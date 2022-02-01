package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.GoogleCertificatesQuery;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IGoogleCertificatesApi
  extends IInterface
{
  public abstract IObjectWrapper getGoogleCertificates();
  
  public abstract IObjectWrapper getGoogleReleaseCertificates();
  
  public abstract boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery paramGoogleCertificatesQuery, IObjectWrapper paramIObjectWrapper);
  
  public abstract boolean isGoogleReleaseSigned(String paramString, IObjectWrapper paramIObjectWrapper);
  
  public abstract boolean isGoogleSigned(String paramString, IObjectWrapper paramIObjectWrapper);
  
  public static abstract class Stub
    extends zzb
    implements IGoogleCertificatesApi
  {
    public Stub()
    {
      super();
    }
    
    public static IGoogleCertificatesApi asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      if ((localIInterface instanceof IGoogleCertificatesApi)) {
        return (IGoogleCertificatesApi)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return false;
      case 1: 
        paramParcel1 = getGoogleCertificates();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = getGoogleReleaseCertificates();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
        continue;
        boolean bool = isGoogleReleaseSigned(paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, bool);
        continue;
        bool = isGoogleSigned(paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, bool);
        continue;
        bool = isGoogleOrPlatformSigned((GoogleCertificatesQuery)zzc.zza(paramParcel1, GoogleCertificatesQuery.CREATOR), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, bool);
      }
    }
    
    public static class Proxy
      extends zza
      implements IGoogleCertificatesApi
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      }
      
      public IObjectWrapper getGoogleCertificates()
      {
        AppMethodBeat.i(4696);
        Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        AppMethodBeat.o(4696);
        return localIObjectWrapper;
      }
      
      public IObjectWrapper getGoogleReleaseCertificates()
      {
        AppMethodBeat.i(4697);
        Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        AppMethodBeat.o(4697);
        return localIObjectWrapper;
      }
      
      public boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery paramGoogleCertificatesQuery, IObjectWrapper paramIObjectWrapper)
      {
        AppMethodBeat.i(4700);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramGoogleCertificatesQuery);
        zzc.zza(localParcel, paramIObjectWrapper);
        paramGoogleCertificatesQuery = transactAndReadException(5, localParcel);
        boolean bool = zzc.zza(paramGoogleCertificatesQuery);
        paramGoogleCertificatesQuery.recycle();
        AppMethodBeat.o(4700);
        return bool;
      }
      
      public boolean isGoogleReleaseSigned(String paramString, IObjectWrapper paramIObjectWrapper)
      {
        AppMethodBeat.i(4698);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        localParcel.writeString(paramString);
        zzc.zza(localParcel, paramIObjectWrapper);
        paramString = transactAndReadException(3, localParcel);
        boolean bool = zzc.zza(paramString);
        paramString.recycle();
        AppMethodBeat.o(4698);
        return bool;
      }
      
      public boolean isGoogleSigned(String paramString, IObjectWrapper paramIObjectWrapper)
      {
        AppMethodBeat.i(4699);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        localParcel.writeString(paramString);
        zzc.zza(localParcel, paramIObjectWrapper);
        paramString = transactAndReadException(4, localParcel);
        boolean bool = zzc.zza(paramString);
        paramString.recycle();
        AppMethodBeat.o(4699);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.IGoogleCertificatesApi
 * JD-Core Version:    0.7.0.1
 */