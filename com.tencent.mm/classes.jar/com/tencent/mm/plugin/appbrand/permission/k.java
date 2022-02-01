package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.e;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.jsapi.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.j.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.u.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.u.c.a;
import java.util.Collection;
import java.util.HashSet;

public class k
  implements h
{
  public static final k ljd;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>> lje;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>> ljf;
  
  static
  {
    AppMethodBeat.i(147665);
    ljd = new k();
    AppMethodBeat.o(147665);
  }
  
  protected k()
  {
    AppMethodBeat.i(147662);
    this.lje = new HashSet();
    this.ljf = new HashSet();
    this.lje.add(b.a.class);
    this.lje.add(c.a.class);
    this.lje.add(g.a.class);
    this.ljf.add(f.class);
    this.ljf.add(com.tencent.mm.plugin.appbrand.jsapi.l.b.class);
    this.ljf.add(g.class);
    this.ljf.add(JsApiGetMusicPlayerState.class);
    this.ljf.add(JsApiGetBackgroundAudioState.class);
    this.ljf.add(d.class);
    this.ljf.add(e.class);
    this.ljf.add(g.class);
    this.ljf.add(l.class);
    this.ljf.add(com.tencent.mm.plugin.appbrand.jsapi.audio.h.class);
    AppMethodBeat.o(147662);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.b paramb)
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
  
  public final boolean aG(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147664);
    if (paramClass == null)
    {
      AppMethodBeat.o(147664);
      return false;
    }
    if ((this.ljf.contains(paramClass)) || (this.lje.contains(paramClass)))
    {
      AppMethodBeat.o(147664);
      return true;
    }
    AppMethodBeat.o(147664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.k
 * JD-Core Version:    0.7.0.1
 */