package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/PendingPluginUpdateStatusChangeEvent;", "", "state", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "pluginAppId", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;Ljava/lang/String;)V", "getPluginAppId", "()Ljava/lang/String;", "getState", "()Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
{
  final c sVY;
  final String sVZ;
  
  public ar(c paramc, String paramString)
  {
    AppMethodBeat.i(320719);
    this.sVY = paramc;
    this.sVZ = paramString;
    AppMethodBeat.o(320719);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(320735);
    if (this == paramObject)
    {
      AppMethodBeat.o(320735);
      return true;
    }
    if (!(paramObject instanceof ar))
    {
      AppMethodBeat.o(320735);
      return false;
    }
    paramObject = (ar)paramObject;
    if (this.sVY != paramObject.sVY)
    {
      AppMethodBeat.o(320735);
      return false;
    }
    if (!s.p(this.sVZ, paramObject.sVZ))
    {
      AppMethodBeat.o(320735);
      return false;
    }
    AppMethodBeat.o(320735);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(320731);
    int i = this.sVY.hashCode();
    int j = this.sVZ.hashCode();
    AppMethodBeat.o(320731);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(320725);
    String str = "PendingPluginUpdateStatusChangeEvent(state=" + this.sVY + ", pluginAppId=" + this.sVZ + ')';
    AppMethodBeat.o(320725);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ar
 * JD-Core Version:    0.7.0.1
 */