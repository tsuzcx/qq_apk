package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg
  extends zza
  implements zze
{
  zzg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.iid.IMessengerCompat");
  }
  
  public final void send(Message paramMessage)
  {
    AppMethodBeat.i(4113);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramMessage);
    transactOneway(1, localParcel);
    AppMethodBeat.o(4113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzg
 * JD-Core Version:    0.7.0.1
 */