package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import com.google.android.gms.internal.gcm.zzd;
import com.google.android.gms.internal.gcm.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzm
  extends zzd
  implements zzl
{
  zzm(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.iid.IMessengerCompat");
  }
  
  public final void send(Message paramMessage)
  {
    AppMethodBeat.i(2529);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zze.zzd(localParcel, paramMessage);
    transactOneway(1, localParcel);
    AppMethodBeat.o(2529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.zzm
 * JD-Core Version:    0.7.0.1
 */