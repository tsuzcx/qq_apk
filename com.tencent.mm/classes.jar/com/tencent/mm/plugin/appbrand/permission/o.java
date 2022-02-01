package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.k;
import com.tencent.mm.plugin.appbrand.jsapi.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.c;
import java.util.Collection;
import java.util.HashSet;

public class o
  implements l
{
  public static final o tEJ;
  protected Collection<Class<? extends e>> tEK;
  protected Collection<Class<? extends e>> tEL;
  
  static
  {
    AppMethodBeat.i(147665);
    tEJ = new o();
    AppMethodBeat.o(147665);
  }
  
  protected o()
  {
    AppMethodBeat.i(147662);
    this.tEK = new HashSet();
    this.tEL = new HashSet();
    this.tEK.add(b.a.class);
    this.tEK.add(c.a.class);
    this.tEK.add(e.a.class);
    this.tEL.add(f.class);
    this.tEL.add(c.class);
    this.tEL.add(j.class);
    this.tEL.add(JsApiGetMusicPlayerState.class);
    this.tEL.add(JsApiGetBackgroundAudioState.class);
    this.tEL.add(g.class);
    this.tEL.add(h.class);
    this.tEL.add(j.class);
    this.tEL.add(com.tencent.mm.plugin.appbrand.jsapi.audio.o.class);
    this.tEL.add(k.class);
    AppMethodBeat.o(147662);
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(147663);
    if (parame == null)
    {
      AppMethodBeat.o(147663);
      return false;
    }
    boolean bool = aZ(parame.getClass());
    AppMethodBeat.o(147663);
    return bool;
  }
  
  public final boolean aZ(Class<? extends e> paramClass)
  {
    AppMethodBeat.i(147664);
    if (paramClass == null)
    {
      AppMethodBeat.o(147664);
      return false;
    }
    if ((this.tEL.contains(paramClass)) || (this.tEK.contains(paramClass)))
    {
      AppMethodBeat.o(147664);
      return true;
    }
    AppMethodBeat.o(147664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.o
 * JD-Core Version:    0.7.0.1
 */