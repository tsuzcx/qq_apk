package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.e;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.jsapi.j.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.c.a;
import java.util.Collection;
import java.util.HashSet;

public class k
  implements h
{
  public static final k lIV;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>> lIW;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>> lIX;
  
  static
  {
    AppMethodBeat.i(147665);
    lIV = new k();
    AppMethodBeat.o(147665);
  }
  
  protected k()
  {
    AppMethodBeat.i(147662);
    this.lIW = new HashSet();
    this.lIX = new HashSet();
    this.lIW.add(b.a.class);
    this.lIW.add(c.a.class);
    this.lIW.add(g.a.class);
    this.lIX.add(f.class);
    this.lIX.add(com.tencent.mm.plugin.appbrand.jsapi.k.b.class);
    this.lIX.add(g.class);
    this.lIX.add(JsApiGetMusicPlayerState.class);
    this.lIX.add(JsApiGetBackgroundAudioState.class);
    this.lIX.add(d.class);
    this.lIX.add(e.class);
    this.lIX.add(g.class);
    this.lIX.add(l.class);
    this.lIX.add(com.tencent.mm.plugin.appbrand.jsapi.audio.h.class);
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
    if ((this.lIX.contains(paramClass)) || (this.lIW.contains(paramClass)))
    {
      AppMethodBeat.o(147664);
      return true;
    }
    AppMethodBeat.o(147664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.k
 * JD-Core Version:    0.7.0.1
 */