package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AnyProcessAvatarAttacher$StringHolder;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c$c
{
  String value;
  
  private c$c(String paramString)
  {
    AppMethodBeat.i(317462);
    this.value = paramString;
    AppMethodBeat.o(317462);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(317474);
    s.u(paramString, "<set-?>");
    this.value = paramString;
    AppMethodBeat.o(317474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c.c
 * JD-Core Version:    0.7.0.1
 */