package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;

final class o$16
  implements MMToClientEvent.c
{
  o$16(o paramo) {}
  
  public final void aZ(Object paramObject)
  {
    AppMethodBeat.i(143034);
    if ((paramObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent)) {
      d.Ey(this.gRv.mAppId);
    }
    AppMethodBeat.o(143034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.16
 * JD-Core Version:    0.7.0.1
 */