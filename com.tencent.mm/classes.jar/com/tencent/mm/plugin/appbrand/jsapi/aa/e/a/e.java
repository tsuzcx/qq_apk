package com.tencent.mm.plugin.appbrand.jsapi.aa.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b.c;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "", "mrDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "isConnectSuccess", "", "()Z", "setConnectSuccess", "(Z)V", "isConnecting", "setConnecting", "isSelected", "setSelected", "getMrDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "equals", "other", "hashCode", "", "toString", "", "luggage-xweb-ext_release"})
public final class e
{
  boolean fZj;
  boolean ira;
  boolean kBg;
  final c kBh;
  
  public e(c paramc)
  {
    AppMethodBeat.i(139687);
    this.kBh = paramc;
    AppMethodBeat.o(139687);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(139684);
    if ((e)this == paramObject)
    {
      AppMethodBeat.o(139684);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (k.g(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(139684);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.video.cast.MRDeviceWithStatus");
      AppMethodBeat.o(139684);
      throw paramObject;
    }
    if ((k.g(this.kBh, ((e)paramObject).kBh) ^ true))
    {
      AppMethodBeat.o(139684);
      return false;
    }
    AppMethodBeat.o(139684);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(139685);
    int i = this.kBh.hashCode();
    AppMethodBeat.o(139685);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(139686);
    String str = "MRDeviceWithStatus(mrDevice=" + this.kBh + ", isSelected=" + this.ira + ", isConnectSuccess=" + this.kBg + ", isConnecting=" + this.fZj + ')';
    AppMethodBeat.o(139686);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.e
 * JD-Core Version:    0.7.0.1
 */