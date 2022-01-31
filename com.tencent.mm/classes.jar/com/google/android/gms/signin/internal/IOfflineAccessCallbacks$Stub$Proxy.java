package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class IOfflineAccessCallbacks$Stub$Proxy
  extends zza
  implements IOfflineAccessCallbacks
{
  IOfflineAccessCallbacks$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
  }
  
  public void checkServerAuthorization(String paramString, List<Scope> paramList, ISignInService paramISignInService)
  {
    AppMethodBeat.i(61664);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    localParcel.writeTypedList(paramList);
    zzc.zza(localParcel, paramISignInService);
    transactAndReadExceptionReturnVoid(2, localParcel);
    AppMethodBeat.o(61664);
  }
  
  public void uploadServerAuthCode(String paramString1, String paramString2, ISignInService paramISignInService)
  {
    AppMethodBeat.i(61665);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzc.zza(localParcel, paramISignInService);
    transactAndReadExceptionReturnVoid(3, localParcel);
    AppMethodBeat.o(61665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.signin.internal.IOfflineAccessCallbacks.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */