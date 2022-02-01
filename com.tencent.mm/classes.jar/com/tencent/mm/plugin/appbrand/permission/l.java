package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.e;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.m.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.c;
import com.tencent.mm.plugin.appbrand.jsapi.w.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.c.a;
import java.util.Collection;
import java.util.HashSet;

public class l
  implements i
{
  public static final l mii;
  protected Collection<Class<? extends b>> mij;
  protected Collection<Class<? extends b>> mik;
  
  static
  {
    AppMethodBeat.i(147665);
    mii = new l();
    AppMethodBeat.o(147665);
  }
  
  protected l()
  {
    AppMethodBeat.i(147662);
    this.mij = new HashSet();
    this.mik = new HashSet();
    this.mij.add(b.a.class);
    this.mij.add(c.a.class);
    this.mij.add(e.a.class);
    this.mik.add(com.tencent.mm.plugin.appbrand.jsapi.a.f.class);
    this.mik.add(c.class);
    this.mik.add(h.class);
    this.mik.add(JsApiGetMusicPlayerState.class);
    this.mik.add(JsApiGetBackgroundAudioState.class);
    this.mik.add(e.class);
    this.mik.add(com.tencent.mm.plugin.appbrand.jsapi.audio.f.class);
    this.mik.add(h.class);
    this.mik.add(m.class);
    this.mik.add(com.tencent.mm.plugin.appbrand.jsapi.audio.i.class);
    AppMethodBeat.o(147662);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(147663);
    if (paramb == null)
    {
      AppMethodBeat.o(147663);
      return false;
    }
    boolean bool = aG(paramb.getClass());
    AppMethodBeat.o(147663);
    return bool;
  }
  
  public final boolean aG(Class<? extends b> paramClass)
  {
    AppMethodBeat.i(147664);
    if (paramClass == null)
    {
      AppMethodBeat.o(147664);
      return false;
    }
    if ((this.mik.contains(paramClass)) || (this.mij.contains(paramClass)))
    {
      AppMethodBeat.o(147664);
      return true;
    }
    AppMethodBeat.o(147664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.l
 * JD-Core Version:    0.7.0.1
 */