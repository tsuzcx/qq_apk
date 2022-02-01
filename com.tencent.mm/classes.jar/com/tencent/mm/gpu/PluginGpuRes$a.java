package com.tencent.mm.gpu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.wxperf.jni.egl.EglHook.a;

final class PluginGpuRes$a
  implements EglHook.a
{
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209604);
    ae.e(paramString1, paramString2);
    AppMethodBeat.o(209604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.gpu.PluginGpuRes.a
 * JD-Core Version:    0.7.0.1
 */