package com.tencent.mm.gpu.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.ae;

final class GpuHookService$1
  implements Runnable
{
  GpuHookService$1(GpuHookService paramGpuHookService) {}
  
  public final void run()
  {
    AppMethodBeat.i(209674);
    ae.e("Gpu.GpuHookService", "kill self in 120s！");
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/gpu/service/GpuHookService$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)locala.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/gpu/service/GpuHookService$1", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(209674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.gpu.service.GpuHookService.1
 * JD-Core Version:    0.7.0.1
 */