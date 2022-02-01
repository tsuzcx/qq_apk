package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AnyProcessAvatarAttacher$DispatchResult;", "", "(Ljava/lang/String;I)V", "DISPATCH_HD_AVATAR", "DISPATCH_NOT_HD_AVATAR", "DISPATCH_NOTHING", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
 enum c$b
{
  static
  {
    AppMethodBeat.i(317476);
    uqp = new b("DISPATCH_HD_AVATAR", 0);
    uqq = new b("DISPATCH_NOT_HD_AVATAR", 1);
    uqr = new b("DISPATCH_NOTHING", 2);
    uqs = new b[] { uqp, uqq, uqr };
    AppMethodBeat.o(317476);
  }
  
  private c$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c.b
 * JD-Core Version:    0.7.0.1
 */