package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.e;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.m.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.c;
import com.tencent.mm.plugin.appbrand.jsapi.w.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.c.a;
import java.util.Collection;
import java.util.HashSet;

public class n
  implements k
{
  public static final n mng;
  protected Collection<Class<? extends b>> mnh;
  protected Collection<Class<? extends b>> mni;
  
  static
  {
    AppMethodBeat.i(147665);
    mng = new n();
    AppMethodBeat.o(147665);
  }
  
  protected n()
  {
    AppMethodBeat.i(147662);
    this.mnh = new HashSet();
    this.mni = new HashSet();
    this.mnh.add(b.a.class);
    this.mnh.add(c.a.class);
    this.mnh.add(e.a.class);
    this.mni.add(com.tencent.mm.plugin.appbrand.jsapi.a.f.class);
    this.mni.add(c.class);
    this.mni.add(h.class);
    this.mni.add(JsApiGetMusicPlayerState.class);
    this.mni.add(JsApiGetBackgroundAudioState.class);
    this.mni.add(e.class);
    this.mni.add(com.tencent.mm.plugin.appbrand.jsapi.audio.f.class);
    this.mni.add(h.class);
    this.mni.add(m.class);
    this.mni.add(i.class);
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
    if ((this.mni.contains(paramClass)) || (this.mnh.contains(paramClass)))
    {
      AppMethodBeat.o(147664);
      return true;
    }
    AppMethodBeat.o(147664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.n
 * JD-Core Version:    0.7.0.1
 */