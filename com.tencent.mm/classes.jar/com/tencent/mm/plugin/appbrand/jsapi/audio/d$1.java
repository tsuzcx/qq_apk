package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.media.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Vector;

final class d$1
  extends e.c
{
  d$1(d paramd, String paramString) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(137717);
    ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
    a.ap(this.val$appId, false);
    paramd = new d.a();
    paramd.bsY = 1;
    paramd.appId = this.val$appId;
    paramd.aBL();
    AppMethodBeat.o(137717);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(137715);
    a.ap(this.val$appId, true);
    AppMethodBeat.o(137715);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(137718);
    ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
    d.a locala = new d.a();
    locala.bsY = 2;
    locala.appId = this.val$appId;
    locala.aBM();
    e.b(this.val$appId, this);
    d.aBO().remove(this.val$appId);
    AppMethodBeat.o(137718);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(137716);
    a.ap(this.val$appId, true);
    AppMethodBeat.o(137716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d.1
 * JD-Core Version:    0.7.0.1
 */