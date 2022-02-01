package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "", "()V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "versionType", "", "getVersionType", "()I", "setVersionType", "(I)V", "plugin-appbrand-integration_release"})
final class a$a
{
  int cBU;
  String username = "";
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(283408);
    p.k(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(283408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.a.a
 * JD-Core Version:    0.7.0.1
 */