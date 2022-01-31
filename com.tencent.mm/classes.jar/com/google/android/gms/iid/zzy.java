package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzy
{
  final Messenger zzab;
  final MessengerCompat zzcj;
  
  zzy(IBinder paramIBinder)
  {
    AppMethodBeat.i(57617);
    String str = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str))
    {
      this.zzab = new Messenger(paramIBinder);
      this.zzcj = null;
      AppMethodBeat.o(57617);
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str))
    {
      this.zzcj = new MessengerCompat(paramIBinder);
      this.zzab = null;
      AppMethodBeat.o(57617);
      return;
    }
    paramIBinder = String.valueOf(str);
    if (paramIBinder.length() != 0) {
      "Invalid interface descriptor: ".concat(paramIBinder);
    }
    for (;;)
    {
      paramIBinder = new RemoteException();
      AppMethodBeat.o(57617);
      throw paramIBinder;
      new String("Invalid interface descriptor: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.iid.zzy
 * JD-Core Version:    0.7.0.1
 */