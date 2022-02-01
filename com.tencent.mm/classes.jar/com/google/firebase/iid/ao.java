package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ao
{
  final Messenger bBO;
  final zzi bCl;
  
  ao(IBinder paramIBinder)
  {
    AppMethodBeat.i(4270);
    String str = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str))
    {
      this.bBO = new Messenger(paramIBinder);
      this.bCl = null;
      AppMethodBeat.o(4270);
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str))
    {
      this.bCl = new zzi(paramIBinder);
      this.bBO = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.firebase.iid.ao
 * JD-Core Version:    0.7.0.1
 */