package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver;

@a
public class d
  implements c<Intent, IPCVoid>
{
  public static void a(Intent paramIntent, f<IPCVoid> paramf)
  {
    AppMethodBeat.i(318707);
    AppBrandTaskPreloadReceiver.c("PreloadIPCTaskImpl", paramIntent);
    paramf.onCallback(IPCVoid.mzv);
    AppMethodBeat.o(318707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.d
 * JD-Core Version:    0.7.0.1
 */