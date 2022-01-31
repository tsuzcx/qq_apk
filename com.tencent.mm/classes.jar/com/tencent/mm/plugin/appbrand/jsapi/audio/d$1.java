package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.media.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Vector;

final class d$1
  extends g.b
{
  d$1(d paramd, String paramString) {}
  
  public final void a(g.c paramc)
  {
    y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[] { this.val$appId });
    a.aj(this.val$appId, false);
    paramc = new d.a();
    paramc.bcw = 1;
    paramc.appId = this.val$appId;
    paramc.ahU();
  }
  
  public final void onCreate()
  {
    a.aj(this.val$appId, true);
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[] { this.val$appId });
    d.a locala = new d.a();
    locala.bcw = 2;
    locala.appId = this.val$appId;
    locala.ahV();
    g.b(this.val$appId, this);
    d.ahY().remove(this.val$appId);
  }
  
  public final void onResume()
  {
    a.aj(this.val$appId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d.1
 * JD-Core Version:    0.7.0.1
 */