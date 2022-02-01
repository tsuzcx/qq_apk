package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzt
  extends zzn
  implements zzr
{
  zzt(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
  }
  
  public final Bundle zza(Bundle paramBundle)
  {
    AppMethodBeat.i(2266);
    Object localObject = obtainAndWriteInterfaceToken();
    zzp.zza((Parcel)localObject, paramBundle);
    paramBundle = transactAndReadException(1, (Parcel)localObject);
    localObject = (Bundle)zzp.zza(paramBundle, Bundle.CREATOR);
    paramBundle.recycle();
    AppMethodBeat.o(2266);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzt
 * JD-Core Version:    0.7.0.1
 */