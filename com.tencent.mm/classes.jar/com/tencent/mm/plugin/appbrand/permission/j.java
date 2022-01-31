package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.f;
import com.tencent.mm.plugin.appbrand.jsapi.audio.k;
import com.tencent.mm.plugin.appbrand.jsapi.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.q.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.c.a;
import java.util.Collection;
import java.util.HashSet;

public class j
  implements g
{
  public static final j iCe;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>> iCf;
  protected Collection<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>> iCg;
  
  static
  {
    AppMethodBeat.i(102307);
    iCe = new j();
    AppMethodBeat.o(102307);
  }
  
  protected j()
  {
    AppMethodBeat.i(102304);
    this.iCf = new HashSet();
    this.iCg = new HashSet();
    this.iCf.add(b.a.class);
    this.iCf.add(c.a.class);
    this.iCg.add(e.class);
    this.iCg.add(com.tencent.mm.plugin.appbrand.jsapi.l.b.class);
    this.iCg.add(f.class);
    this.iCg.add(JsApiGetMusicPlayerState.class);
    this.iCg.add(JsApiGetBackgroundAudioState.class);
    this.iCg.add(d.class);
    this.iCg.add(f.class);
    this.iCg.add(k.class);
    this.iCg.add(com.tencent.mm.plugin.appbrand.jsapi.audio.g.class);
    AppMethodBeat.o(102304);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.b paramb)
  {
    AppMethodBeat.i(102305);
    if (paramb == null)
    {
      AppMethodBeat.o(102305);
      return false;
    }
    boolean bool = ad(paramb.getClass());
    AppMethodBeat.o(102305);
    return bool;
  }
  
  public final boolean ad(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(102306);
    if (paramClass == null)
    {
      AppMethodBeat.o(102306);
      return false;
    }
    if ((this.iCg.contains(paramClass)) || (this.iCf.contains(paramClass)))
    {
      AppMethodBeat.o(102306);
      return true;
    }
    AppMethodBeat.o(102306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.j
 * JD-Core Version:    0.7.0.1
 */