package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import android.os.RemoteException;

final class f$1
  implements Runnable
{
  f$1(String paramString, Class paramClass, Parcelable paramParcelable, c paramc) {}
  
  public final void run()
  {
    if (e.fE(this.dGw))
    {
      localObject = (a)k.a(this.dGI, a.class);
      if (localObject == null)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", new Object[] { this.dGI });
        return;
      }
      ((a)localObject).a(this.dGJ, this.dGE);
      return;
    }
    com.tencent.mm.ipcinvoker.b.a locala = b.BT().fB(this.dGw);
    if (locala == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[] { this.dGw });
      return;
    }
    Object localObject = null;
    try
    {
      if (this.dGE != null) {
        localObject = new f.a(this.dGw, this.dGE);
      }
      locala.a(f.b(this.dGJ), this.dGI.getName(), (com.tencent.mm.ipcinvoker.b.b)localObject);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[] { localRemoteException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.1
 * JD-Core Version:    0.7.0.1
 */