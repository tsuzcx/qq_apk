package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ao
{
  final zzi bgE;
  final Messenger bgh;
  
  ao(IBinder paramIBinder)
  {
    AppMethodBeat.i(108834);
    String str = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str))
    {
      this.bgh = new Messenger(paramIBinder);
      this.bgE = null;
      AppMethodBeat.o(108834);
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str))
    {
      this.bgE = new zzi(paramIBinder);
      this.bgh = null;
      AppMethodBeat.o(108834);
      return;
    }
    paramIBinder = String.valueOf(str);
    if (paramIBinder.length() != 0) {
      "Invalid interface descriptor: ".concat(paramIBinder);
    }
    for (;;)
    {
      paramIBinder = new RemoteException();
      AppMethodBeat.o(108834);
      throw paramIBinder;
      new String("Invalid interface descriptor: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.firebase.iid.ao
 * JD-Core Version:    0.7.0.1
 */