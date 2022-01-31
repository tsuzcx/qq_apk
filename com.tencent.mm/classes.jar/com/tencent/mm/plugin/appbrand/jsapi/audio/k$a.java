package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k$a
  extends a
{
  public int action;
  public String appId = "";
  private i gfG;
  public int gfg;
  public com.tencent.mm.plugin.appbrand.jsapi.c ggu;
  public String giJ;
  private com.tencent.mm.sdk.b.c gjh = new k.a.1(this);
  
  public k$a(i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    this.gfG = parami;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void ahX()
  {
    y.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
    com.tencent.mm.plugin.appbrand.media.a.a.va(this.appId);
    com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.gjh);
  }
  
  public final void pQ()
  {
    if (this.ggu == null)
    {
      y.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
      return;
    }
    y.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.giJ });
    if (bk.bl(this.giJ))
    {
      y.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
      return;
    }
    new k.b().e(this.ggu).tM(this.giJ).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k.a
 * JD-Core Version:    0.7.0.1
 */