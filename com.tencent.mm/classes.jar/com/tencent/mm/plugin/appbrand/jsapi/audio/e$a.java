package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.h.a.s;
import com.tencent.mm.h.a.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;

final class e$a
  extends a
{
  public String appId = "";
  public String bFM = "";
  public boolean error = false;
  private i gfG;
  public int gfg;
  public c ggu;
  
  public e$a(i parami, c paramc, int paramInt)
  {
    this.gfG = parami;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void ahX()
  {
    y.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
    String str = this.bFM;
    y.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { str });
    s locals = new s();
    locals.bFK.action = 5;
    locals.bFK.bFM = str;
    com.tencent.mm.plugin.music.b.a.a(locals);
    this.error = locals.bFL.bFQ;
    pQ();
  }
  
  public final void pQ()
  {
    super.pQ();
    y.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
    if (this.ggu == null)
    {
      y.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
      return;
    }
    if (this.error)
    {
      this.ggu.C(this.gfg, this.gfG.h("fail", null));
      return;
    }
    this.ggu.C(this.gfg, this.gfG.h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e.a
 * JD-Core Version:    0.7.0.1
 */