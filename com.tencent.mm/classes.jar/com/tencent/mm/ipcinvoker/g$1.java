package com.tencent.mm.ipcinvoker;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.ipcinvoker.h.c;
import java.util.Map;

public final class g$1
  implements d
{
  public g$1(Application paramApplication) {}
  
  public final void a(a parama)
  {
    AppMethodBeat.i(114036);
    com.tencent.mm.ipcinvoker.h.b.b(parama);
    AppMethodBeat.o(114036);
  }
  
  public final <T extends BaseIPCService> void b(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(114035);
    b localb = b.PK();
    Object localObject = c.T(paramString, this.eEn.getPackageName());
    paramString = (String)localObject + "/" + paramString;
    localObject = (Class)localb.eDU.get(paramString);
    if (localObject != null) {
      com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCBridgeManager", "warning: override ipc service: %s -> %s", new Object[] { paramString, localObject });
    }
    localb.eDU.put(paramString, paramClass);
    AppMethodBeat.o(114035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g.1
 * JD-Core Version:    0.7.0.1
 */