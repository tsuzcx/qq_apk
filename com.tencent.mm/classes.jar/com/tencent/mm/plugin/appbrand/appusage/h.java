package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"TAG", "", "component1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "component2", "", "plugin-appbrand-integration_release"})
public final class h
{
  public static final String a(AppIdentity paramAppIdentity)
  {
    AppMethodBeat.i(50273);
    p.h(paramAppIdentity, "$this$component1");
    paramAppIdentity = paramAppIdentity.username;
    AppMethodBeat.o(50273);
    return paramAppIdentity;
  }
  
  public static final int b(AppIdentity paramAppIdentity)
  {
    AppMethodBeat.i(50274);
    p.h(paramAppIdentity, "$this$component2");
    int i = paramAppIdentity.hSZ;
    AppMethodBeat.o(50274);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.h
 * JD-Core Version:    0.7.0.1
 */