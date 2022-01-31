package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.h.a.s;
import com.tencent.mm.h.a.s.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$a
  extends a
{
  public String appId = "";
  public String bFM = "";
  public int bcw = 0;
  public String gio = "";
  
  public final void ahX()
  {
    y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.bcw) });
    this.gio = "";
    String str;
    Object localObject;
    if (this.bcw == 0)
    {
      str = this.appId;
      localObject = this.bFM;
      y.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { str, localObject });
      s locals = new s();
      locals.bFK.action = 10;
      locals.bFK.appId = str;
      locals.bFK.bFM = ((String)localObject);
      com.tencent.mm.plugin.music.b.a.a(locals);
      this.bFM = locals.bFK.bFM;
      y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.bFM });
      if (TextUtils.isEmpty(this.bFM)) {
        this.gio = "fail to create audio instance";
      }
    }
    for (;;)
    {
      pQ();
      return;
      if (this.bcw == 1)
      {
        y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
        str = this.appId;
        y.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
        localObject = new s();
        ((s)localObject).bFK.action = 12;
        ((s)localObject).bFK.appId = str;
        com.tencent.mm.plugin.music.b.a.a((s)localObject);
      }
      else if (this.bcw == 2)
      {
        y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
        str = this.appId;
        y.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
        localObject = new s();
        ((s)localObject).bFK.action = 9;
        ((s)localObject).bFK.appId = str;
        com.tencent.mm.plugin.music.b.a.a((s)localObject);
        com.tencent.mm.plugin.appbrand.media.a.a.va(this.appId);
      }
    }
  }
  
  public final void pQ()
  {
    super.pQ();
    if (this.bcw == 0) {
      if (!TextUtils.isEmpty(this.bFM)) {
        y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
      }
    }
    while (this.bcw == 1)
    {
      return;
      y.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
      return;
    }
    y.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d.a
 * JD-Core Version:    0.7.0.1
 */