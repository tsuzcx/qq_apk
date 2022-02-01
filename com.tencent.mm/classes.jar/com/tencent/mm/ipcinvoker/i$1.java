package com.tencent.mm.ipcinvoker;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.ipcinvoker.h.b;
import java.util.Map;

public final class i$1
  implements d
{
  public i$1(Application paramApplication) {}
  
  public final void a(a parama)
  {
    AppMethodBeat.i(158746);
    b.b(parama);
    AppMethodBeat.o(158746);
  }
  
  public final <T extends BaseIPCService> void a(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(158745);
    c localc = c.ads();
    Object localObject = com.tencent.mm.ipcinvoker.h.c.ak(paramString, this.fZs.getPackageName());
    paramString = (String)localObject + "/" + paramString;
    localObject = (Class)localc.fYY.get(paramString);
    if (localObject != null) {
      b.w("IPC.IPCBridgeManager", "warning: override ipc service: %s -> %s", new Object[] { paramString, localObject });
    }
    localc.fYY.put(paramString, paramClass);
    AppMethodBeat.o(158745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.i.1
 * JD-Core Version:    0.7.0.1
 */