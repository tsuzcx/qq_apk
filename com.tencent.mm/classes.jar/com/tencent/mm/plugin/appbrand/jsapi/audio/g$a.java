package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

final class g$a
  extends a
{
  public String appId = "";
  public String cTn;
  public String cTr = "";
  public int cUL;
  public int dbJ;
  public int duration = 0;
  public boolean error = false;
  public double gSR;
  public String gSZ = null;
  public int gTf;
  public String hMd;
  public int hvf;
  public int joH;
  private m jwG;
  public com.tencent.mm.plugin.appbrand.jsapi.c jyl;
  
  public g$a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    this.jwG = paramm;
    this.jyl = paramc;
    this.joH = paramInt;
  }
  
  public final void AI()
  {
    AppMethodBeat.i(145710);
    if (this.jyl == null)
    {
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
      AppMethodBeat.o(145710);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.duration));
    localHashMap.put("currentTime", Integer.valueOf(this.dbJ));
    boolean bool;
    if (this.hvf == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Integer.valueOf(this.gTf));
      localHashMap.put("src", this.cTn);
      localHashMap.put("startTime", Integer.valueOf(this.cUL));
      localHashMap.put("playbackRate", Double.valueOf(this.gSR));
      localHashMap.put("referrerPolicy", this.gSZ);
      if (!TextUtils.isEmpty(this.hMd)) {
        break label238;
      }
    }
    label238:
    for (String str = "";; str = this.hMd)
    {
      if (!this.error) {
        break label246;
      }
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
      this.jyl.h(this.joH, this.jwG.e("fail:".concat(String.valueOf(str)), null));
      AppMethodBeat.o(145710);
      return;
      bool = false;
      break;
    }
    label246:
    this.jyl.h(this.joH, this.jwG.k("ok", localHashMap));
    AppMethodBeat.o(145710);
  }
  
  public final void MQ()
  {
    AppMethodBeat.i(145709);
    Object localObject = this.cTr;
    u localu = new u();
    localu.dbH.action = 6;
    localu.dbH.cTr = ((String)localObject);
    com.tencent.mm.plugin.music.b.a.a(localu);
    localObject = localu.dbI.dbM;
    if (localObject == null)
    {
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", new Object[] { this.cTr });
      this.error = true;
      this.hMd = "return parameter is invalid";
      AI();
      AppMethodBeat.o(145709);
      return;
    }
    if ((((d)localObject).duration < 0) || (((d)localObject).dbJ < 0))
    {
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).dbJ) });
      this.error = true;
      this.hMd = "return parameter is invalid";
      AI();
      AppMethodBeat.o(145709);
      return;
    }
    this.duration = ((d)localObject).duration;
    this.dbJ = ((d)localObject).dbJ;
    if (((d)localObject).qM) {}
    for (int i = 1;; i = 0)
    {
      this.hvf = i;
      this.cTn = ((d)localObject).cTn;
      this.gTf = ((d)localObject).gTf;
      this.cUL = ((d)localObject).cUL;
      this.gSZ = ((d)localObject).gSZ;
      localObject = com.tencent.mm.aj.c.vD(this.cTr);
      if (localObject != null) {
        this.gSR = ((b)localObject).gSR;
      }
      ad.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.dbJ), Integer.valueOf(this.hvf), Integer.valueOf(this.gTf), this.cTn, Integer.valueOf(this.cUL), Double.valueOf(this.gSR) });
      AI();
      AppMethodBeat.o(145709);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g.a
 * JD-Core Version:    0.7.0.1
 */