package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.auth.zzd;
import com.google.android.gms.internal.auth.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzw
  extends zzd
  implements zzv
{
  zzw(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
  }
  
  public final void zzd(zzt paramzzt, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(50456);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzt);
    zzf.zzd(localParcel, paramGoogleSignInOptions);
    transactAndReadExceptionReturnVoid(101, localParcel);
    AppMethodBeat.o(50456);
  }
  
  public final void zze(zzt paramzzt, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(50457);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzt);
    zzf.zzd(localParcel, paramGoogleSignInOptions);
    transactAndReadExceptionReturnVoid(102, localParcel);
    AppMethodBeat.o(50457);
  }
  
  public final void zzf(zzt paramzzt, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(50458);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzt);
    zzf.zzd(localParcel, paramGoogleSignInOptions);
    transactAndReadExceptionReturnVoid(103, localParcel);
    AppMethodBeat.o(50458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzw
 * JD-Core Version:    0.7.0.1
 */