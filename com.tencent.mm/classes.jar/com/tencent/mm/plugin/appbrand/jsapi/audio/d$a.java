package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$a
  extends a
{
  public String appId = "";
  public int bsY = 0;
  public String ceu = "";
  public String hBF = "";
  
  public final void Dh()
  {
    AppMethodBeat.i(137719);
    ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", new Object[] { Integer.valueOf(this.bsY) });
    this.hBF = "";
    String str;
    Object localObject;
    if (this.bsY == 0)
    {
      str = this.appId;
      localObject = this.ceu;
      ab.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { str, localObject });
      s locals = new s();
      locals.cmS.action = 10;
      locals.cmS.appId = str;
      locals.cmS.ceu = ((String)localObject);
      com.tencent.mm.plugin.music.b.a.a(locals);
      this.ceu = locals.cmS.ceu;
      ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", new Object[] { this.ceu });
      if (TextUtils.isEmpty(this.ceu)) {
        this.hBF = "fail to create audio instance";
      }
    }
    for (;;)
    {
      tU();
      AppMethodBeat.o(137719);
      return;
      if (this.bsY == 1)
      {
        ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
        str = this.appId;
        ab.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { str });
        localObject = new s();
        ((s)localObject).cmS.action = 12;
        ((s)localObject).cmS.appId = str;
        com.tencent.mm.plugin.music.b.a.a((s)localObject);
      }
      else if (this.bsY == 2)
      {
        ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
        str = this.appId;
        ab.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { str });
        localObject = new s();
        ((s)localObject).cmS.action = 9;
        ((s)localObject).cmS.appId = str;
        com.tencent.mm.plugin.music.b.a.a((s)localObject);
        com.tencent.mm.plugin.appbrand.media.a.a.Dw(this.appId);
      }
    }
  }
  
  public final void tU()
  {
    AppMethodBeat.i(137720);
    super.tU();
    if (this.bsY == 0)
    {
      if (!TextUtils.isEmpty(this.ceu))
      {
        ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
        AppMethodBeat.o(137720);
        return;
      }
      ab.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
      AppMethodBeat.o(137720);
      return;
    }
    if (this.bsY != 1) {
      ab.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
    }
    AppMethodBeat.o(137720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d.a
 * JD-Core Version:    0.7.0.1
 */