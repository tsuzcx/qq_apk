package com.tencent.mm.plugin.crashfix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class BinderProxyTransactNativeHook$b
  implements Runnable
{
  long startTime;
  
  BinderProxyTransactNativeHook$b()
  {
    AppMethodBeat.i(190268);
    this.startTime = 0L;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(190268);
  }
  
  public final void run()
  {
    AppMethodBeat.i(190269);
    ae.e("MicroMsg.BadBinder", hashCode() + "#send_bad#");
    AppMethodBeat.o(190269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook.b
 * JD-Core Version:    0.7.0.1
 */