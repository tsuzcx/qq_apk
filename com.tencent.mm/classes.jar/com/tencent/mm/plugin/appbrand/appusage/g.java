package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "component1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "component2", "", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final String b(AppIdentity paramAppIdentity)
  {
    AppMethodBeat.i(50273);
    s.u(paramAppIdentity, "<this>");
    paramAppIdentity = paramAppIdentity.username;
    AppMethodBeat.o(50273);
    return paramAppIdentity;
  }
  
  public static final int c(AppIdentity paramAppIdentity)
  {
    AppMethodBeat.i(50274);
    s.u(paramAppIdentity, "<this>");
    int i = paramAppIdentity.euz;
    AppMethodBeat.o(50274);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.g
 * JD-Core Version:    0.7.0.1
 */