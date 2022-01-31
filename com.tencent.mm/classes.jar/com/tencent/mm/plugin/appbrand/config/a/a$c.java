package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$c
{
  a.a hkL;
  a.b hkM;
  String name;
  boolean success;
  
  private a$c(a.a parama, a.b paramb, boolean paramBoolean, String paramString)
  {
    this.hkL = parama;
    this.hkM = paramb;
    this.success = paramBoolean;
    this.name = paramString;
  }
  
  final void execute()
  {
    AppMethodBeat.i(86910);
    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.name });
    if (this.hkL == null)
    {
      ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
      AppMethodBeat.o(86910);
      return;
    }
    this.hkL.a(this.hkM, this.success);
    AppMethodBeat.o(86910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a.c
 * JD-Core Version:    0.7.0.1
 */