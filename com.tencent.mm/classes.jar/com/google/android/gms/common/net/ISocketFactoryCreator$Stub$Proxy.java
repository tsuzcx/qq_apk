package com.google.android.gms.common.net;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ISocketFactoryCreator$Stub$Proxy
  extends zza
  implements ISocketFactoryCreator
{
  ISocketFactoryCreator$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.net.ISocketFactoryCreator");
  }
  
  public IObjectWrapper newSocketFactory(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, boolean paramBoolean)
  {
    AppMethodBeat.i(89897);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramIObjectWrapper1);
    zzc.zza(localParcel, paramIObjectWrapper2);
    zzc.zza(localParcel, paramIObjectWrapper3);
    zzc.zza(localParcel, paramBoolean);
    paramIObjectWrapper1 = transactAndReadException(1, localParcel);
    paramIObjectWrapper2 = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
    paramIObjectWrapper1.recycle();
    AppMethodBeat.o(89897);
    return paramIObjectWrapper2;
  }
  
  public IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, String paramString)
  {
    AppMethodBeat.i(89898);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramIObjectWrapper1);
    zzc.zza(localParcel, paramIObjectWrapper2);
    zzc.zza(localParcel, paramIObjectWrapper3);
    localParcel.writeString(paramString);
    paramIObjectWrapper1 = transactAndReadException(2, localParcel);
    paramIObjectWrapper2 = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
    paramIObjectWrapper1.recycle();
    AppMethodBeat.o(89898);
    return paramIObjectWrapper2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.net.ISocketFactoryCreator.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */