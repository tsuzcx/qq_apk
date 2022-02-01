package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ao
{
  final zzi bMP;
  final Messenger bMs;
  
  ao(IBinder paramIBinder)
  {
    AppMethodBeat.i(4270);
    String str = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str))
    {
      this.bMs = new Messenger(paramIBinder);
      this.bMP = null;
      AppMethodBeat.o(4270);
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str))
    {
      this.bMP = new zzi(paramIBinder);
      this.bMs = null;
      AppMethodBeat.o(4270);
      return;
    }
    paramIBinder = String.valueOf(str);
    if (paramIBinder.length() != 0) {
      "Invalid interface descriptor: ".concat(paramIBinder);
    }
    for (;;)
    {
      paramIBinder = new RemoteException();
      AppMethodBeat.o(4270);
      throw paramIBinder;
      new String("Invalid interface descriptor: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.iid.ao
 * JD-Core Version:    0.7.0.1
 */