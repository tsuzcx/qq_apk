package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver;

public class c
  implements b<Intent, IPCVoid>
{
  public static void a(Intent paramIntent, d<IPCVoid> paramd)
  {
    AppMethodBeat.i(186981);
    AppBrandTaskPreloadReceiver.c("PreloadIPCTaskImpl", paramIntent);
    paramd.bc(IPCVoid.gey);
    AppMethodBeat.o(186981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.c
 * JD-Core Version:    0.7.0.1
 */