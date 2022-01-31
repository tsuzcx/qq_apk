package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.d;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class f$a
  extends a
{
  public String appId = "";
  public String ceq;
  public String ceu = "";
  public int cmU;
  public int duration = 0;
  public boolean error = false;
  public int fSw;
  public int frm;
  public String hBF;
  public int hry;
  private m hxs;
  public c hyO;
  public int startTime;
  
  public f$a(m paramm, c paramc, int paramInt)
  {
    this.hxs = paramm;
    this.hyO = paramc;
    this.hry = paramInt;
  }
  
  public final void Dh()
  {
    AppMethodBeat.i(137726);
    Object localObject = this.ceu;
    s locals = new s();
    locals.cmS.action = 6;
    locals.cmS.ceu = ((String)localObject);
    com.tencent.mm.plugin.music.b.a.a(locals);
    localObject = locals.cmT.cmY;
    if (localObject == null)
    {
      ab.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", new Object[] { this.ceu });
      this.error = true;
      this.hBF = "return parameter is invalid";
      tU();
      AppMethodBeat.o(137726);
      return;
    }
    if ((((d)localObject).duration < 0) || (((d)localObject).cmU < 0))
    {
      ab.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).cmU) });
      this.error = true;
      this.hBF = "return parameter is invalid";
      tU();
      AppMethodBeat.o(137726);
      return;
    }
    this.duration = ((d)localObject).duration;
    this.cmU = ((d)localObject).cmU;
    if (((d)localObject).kH) {}
    for (int i = 1;; i = 0)
    {
      this.fSw = i;
      this.ceq = ((d)localObject).ceq;
      this.frm = ((d)localObject).frm;
      this.startTime = ((d)localObject).startTime;
      ab.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.cmU), Integer.valueOf(this.fSw), Integer.valueOf(this.frm), this.ceq, Integer.valueOf(this.startTime) });
      tU();
      AppMethodBeat.o(137726);
      return;
    }
  }
  
  public final void tU()
  {
    AppMethodBeat.i(137727);
    if (this.hyO == null)
    {
      ab.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
      AppMethodBeat.o(137727);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.duration));
    localHashMap.put("currentTime", Integer.valueOf(this.cmU));
    boolean bool;
    if (this.fSw == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Integer.valueOf(this.frm));
      localHashMap.put("src", this.ceq);
      localHashMap.put("startTime", Integer.valueOf(this.startTime));
      if (!TextUtils.isEmpty(this.hBF)) {
        break label209;
      }
    }
    label209:
    for (String str = "";; str = this.hBF)
    {
      if (!this.error) {
        break label217;
      }
      ab.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
      this.hyO.h(this.hry, this.hxs.j("fail:".concat(String.valueOf(str)), null));
      AppMethodBeat.o(137727);
      return;
      bool = false;
      break;
    }
    label217:
    this.hyO.h(this.hry, this.hxs.j("ok", localHashMap));
    AppMethodBeat.o(137727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f.a
 * JD-Core Version:    0.7.0.1
 */