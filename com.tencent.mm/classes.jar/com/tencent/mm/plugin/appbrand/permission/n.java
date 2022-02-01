package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.e;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.c;
import java.util.Collection;
import java.util.HashSet;

public class n
  implements k
{
  public static final n qzK;
  protected Collection<Class<? extends d>> qzL;
  protected Collection<Class<? extends d>> qzM;
  
  static
  {
    AppMethodBeat.i(147665);
    qzK = new n();
    AppMethodBeat.o(147665);
  }
  
  protected n()
  {
    AppMethodBeat.i(147662);
    this.qzL = new HashSet();
    this.qzM = new HashSet();
    this.qzL.add(b.a.class);
    this.qzL.add(c.a.class);
    this.qzL.add(e.a.class);
    this.qzM.add(com.tencent.mm.plugin.appbrand.jsapi.b.f.class);
    this.qzM.add(c.class);
    this.qzM.add(h.class);
    this.qzM.add(JsApiGetMusicPlayerState.class);
    this.qzM.add(JsApiGetBackgroundAudioState.class);
    this.qzM.add(e.class);
    this.qzM.add(com.tencent.mm.plugin.appbrand.jsapi.audio.f.class);
    this.qzM.add(h.class);
    this.qzM.add(m.class);
    this.qzM.add(i.class);
    AppMethodBeat.o(147662);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(147663);
    if (paramd == null)
    {
      AppMethodBeat.o(147663);
      return false;
    }
    boolean bool = aF(paramd.getClass());
    AppMethodBeat.o(147663);
    return bool;
  }
  
  public final boolean aF(Class<? extends d> paramClass)
  {
    AppMethodBeat.i(147664);
    if (paramClass == null)
    {
      AppMethodBeat.o(147664);
      return false;
    }
    if ((this.qzM.contains(paramClass)) || (this.qzL.contains(paramClass)))
    {
      AppMethodBeat.o(147664);
      return true;
    }
    AppMethodBeat.o(147664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.n
 * JD-Core Version:    0.7.0.1
 */