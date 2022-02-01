package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver;

public class d
  implements b<Intent, IPCVoid>
{
  public static void a(Intent paramIntent, com.tencent.mm.ipcinvoker.d<IPCVoid> paramd)
  {
    AppMethodBeat.i(227541);
    AppBrandTaskPreloadReceiver.c("PreloadIPCTaskImpl", paramIntent);
    paramd.bn(IPCVoid.hnE);
    AppMethodBeat.o(227541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.d
 * JD-Core Version:    0.7.0.1
 */