package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.vending.b.b;

final class PluginMessengerFoundation$10
  implements d
{
  PluginMessengerFoundation$10(PluginMessengerFoundation paramPluginMessengerFoundation) {}
  
  public final b a(c paramc)
  {
    AppMethodBeat.i(1048);
    paramc = a.a(paramc);
    AppMethodBeat.o(1048);
    return paramc;
  }
  
  public final void a(bdt parambdt, String paramString)
  {
    AppMethodBeat.i(1047);
    a.a(parambdt, paramString, null, true, false);
    AppMethodBeat.o(1047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation.10
 * JD-Core Version:    0.7.0.1
 */