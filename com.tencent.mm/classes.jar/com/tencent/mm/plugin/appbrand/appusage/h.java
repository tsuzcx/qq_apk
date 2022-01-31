package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"TAG", "", "component1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "component2", "", "plugin-appbrand-integration_release"})
public final class h
{
  public static final String a(AppIdentity paramAppIdentity)
  {
    AppMethodBeat.i(134537);
    j.q(paramAppIdentity, "receiver$0");
    paramAppIdentity = paramAppIdentity.username;
    AppMethodBeat.o(134537);
    return paramAppIdentity;
  }
  
  public static final int b(AppIdentity paramAppIdentity)
  {
    AppMethodBeat.i(134538);
    j.q(paramAppIdentity, "receiver$0");
    int i = paramAppIdentity.hcr;
    AppMethodBeat.o(134538);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.h
 * JD-Core Version:    0.7.0.1
 */