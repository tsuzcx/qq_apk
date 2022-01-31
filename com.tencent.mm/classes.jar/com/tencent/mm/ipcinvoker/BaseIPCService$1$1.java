package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseIPCService$1$1
  implements Runnable
{
  BaseIPCService$1$1(BaseIPCService.1 param1, a parama, Parcelable paramParcelable, com.tencent.mm.ipcinvoker.b.b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(113997);
    try
    {
      this.eDL.a(this.eDM, new BaseIPCService.a(this.eDN));
      AppMethodBeat.o(113997);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invoke task, clazz=%s, npe=%s", new Object[] { this.eDO, localNullPointerException });
      AppMethodBeat.o(113997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService.1.1
 * JD-Core Version:    0.7.0.1
 */