package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ISignInButtonCreator$Stub$Proxy
  extends zza
  implements ISignInButtonCreator
{
  ISignInButtonCreator$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
  }
  
  public IObjectWrapper newSignInButton(IObjectWrapper paramIObjectWrapper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61352);
    Object localObject = obtainAndWriteInterfaceToken();
    zzc.zza((Parcel)localObject, paramIObjectWrapper);
    ((Parcel)localObject).writeInt(paramInt1);
    ((Parcel)localObject).writeInt(paramInt2);
    paramIObjectWrapper = transactAndReadException(1, (Parcel)localObject);
    localObject = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    AppMethodBeat.o(61352);
    return localObject;
  }
  
  public IObjectWrapper newSignInButtonFromConfig(IObjectWrapper paramIObjectWrapper, SignInButtonConfig paramSignInButtonConfig)
  {
    AppMethodBeat.i(61353);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramIObjectWrapper);
    zzc.zza(localParcel, paramSignInButtonConfig);
    paramIObjectWrapper = transactAndReadException(2, localParcel);
    paramSignInButtonConfig = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    AppMethodBeat.o(61353);
    return paramSignInButtonConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.internal.ISignInButtonCreator.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */