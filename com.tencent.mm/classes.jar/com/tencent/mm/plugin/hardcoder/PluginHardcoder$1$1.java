package com.tencent.mm.plugin.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.io;
import com.tencent.mm.hardcoder.HardCoderJNI.SystemEventCallback;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginHardcoder$1$1
  implements HardCoderJNI.SystemEventCallback
{
  PluginHardcoder$1$1(PluginHardcoder.1 param1) {}
  
  public final void onEvent(int paramInt)
  {
    AppMethodBeat.i(60248);
    ab.i("MicroMsg.PluginHardcoder", "configure SystemEventCallback onEvent eventCode[%d]", new Object[] { Integer.valueOf(paramInt) });
    io localio = new io();
    localio.cxX.keycode = paramInt;
    a.ymk.l(localio);
    AppMethodBeat.o(60248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder.1.1
 * JD-Core Version:    0.7.0.1
 */