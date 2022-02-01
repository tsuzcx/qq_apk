package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "", "mrDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "isConnectSuccess", "", "()Z", "setConnectSuccess", "(Z)V", "isConnecting", "setConnecting", "isSelected", "setSelected", "getMrDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "equals", "other", "hashCode", "", "toString", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  boolean isSelected;
  boolean myA;
  final c sRn;
  boolean sRo;
  
  public e(c paramc)
  {
    AppMethodBeat.i(139687);
    this.sRn = paramc;
    AppMethodBeat.o(139687);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(139684);
    if (this == paramObject)
    {
      AppMethodBeat.o(139684);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(139684);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.video.cast.MRDeviceWithStatus");
      AppMethodBeat.o(139684);
      throw paramObject;
    }
    if (!s.p(this.sRn, ((e)paramObject).sRn))
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
    int i = this.sRn.hashCode();
    AppMethodBeat.o(139685);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(139686);
    String str = "MRDeviceWithStatus(mrDevice=" + this.sRn + ", isSelected=" + this.isSelected + ", isConnectSuccess=" + this.sRo + ", isConnecting=" + this.myA + ')';
    AppMethodBeat.o(139686);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.e
 * JD-Core Version:    0.7.0.1
 */