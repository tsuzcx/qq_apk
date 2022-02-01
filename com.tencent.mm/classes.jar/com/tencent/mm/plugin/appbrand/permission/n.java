package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.appbrand.jsapi.o.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.c;
import com.tencent.mm.plugin.appbrand.jsapi.y.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.y.c.a;
import java.util.Collection;
import java.util.HashSet;

public class n
  implements k
{
  public static final n nxG;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e>> nxH;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e>> nxI;
  
  static
  {
    AppMethodBeat.i(147665);
    nxG = new n();
    AppMethodBeat.o(147665);
  }
  
  protected n()
  {
    AppMethodBeat.i(147662);
    this.nxH = new HashSet();
    this.nxI = new HashSet();
    this.nxH.add(b.a.class);
    this.nxH.add(c.a.class);
    this.nxH.add(e.a.class);
    this.nxI.add(com.tencent.mm.plugin.appbrand.jsapi.b.f.class);
    this.nxI.add(c.class);
    this.nxI.add(h.class);
    this.nxI.add(JsApiGetMusicPlayerState.class);
    this.nxI.add(JsApiGetBackgroundAudioState.class);
    this.nxI.add(com.tencent.mm.plugin.appbrand.jsapi.audio.e.class);
    this.nxI.add(com.tencent.mm.plugin.appbrand.jsapi.audio.f.class);
    this.nxI.add(h.class);
    this.nxI.add(m.class);
    this.nxI.add(i.class);
    AppMethodBeat.o(147662);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(147663);
    if (parame == null)
    {
      AppMethodBeat.o(147663);
      return false;
    }
    boolean bool = aG(parame.getClass());
    AppMethodBeat.o(147663);
    return bool;
  }
  
  public final boolean aG(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass)
  {
    AppMethodBeat.i(147664);
    if (paramClass == null)
    {
      AppMethodBeat.o(147664);
      return false;
    }
    if ((this.nxI.contains(paramClass)) || (this.nxH.contains(paramClass)))
    {
      AppMethodBeat.o(147664);
      return true;
    }
    AppMethodBeat.o(147664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.n
 * JD-Core Version:    0.7.0.1
 */