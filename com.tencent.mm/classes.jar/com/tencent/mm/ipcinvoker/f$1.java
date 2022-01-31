package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  implements Runnable
{
  f$1(String paramString, Class paramClass, Parcelable paramParcelable, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(114025);
    if (e.lZ(this.eDZ))
    {
      localObject = (a)k.b(this.eEk, a.class);
      if (localObject == null)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", new Object[] { this.eEk });
        AppMethodBeat.o(114025);
        return;
      }
      ((a)localObject).a(this.eEl, this.eEg);
      AppMethodBeat.o(114025);
      return;
    }
    com.tencent.mm.ipcinvoker.b.a locala = b.PK().lW(this.eDZ);
    if (locala == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[] { this.eDZ });
      AppMethodBeat.o(114025);
      return;
    }
    Object localObject = null;
    try
    {
      if (this.eEg != null) {
        localObject = new f.a(this.eDZ, this.eEg);
      }
      locala.a(f.d(this.eEl), this.eEk.getName(), (com.tencent.mm.ipcinvoker.b.b)localObject);
      AppMethodBeat.o(114025);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[] { localRemoteException });
      AppMethodBeat.o(114025);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[] { localIllegalArgumentException });
      AppMethodBeat.o(114025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.1
 * JD-Core Version:    0.7.0.1
 */