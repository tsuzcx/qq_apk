package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

final class h$a
  extends a
{
  public String appId = "";
  public String ddc;
  public String ddg = "";
  public int dez;
  public int dlC;
  public int duration = 0;
  public boolean error = false;
  public double hOB;
  public String hOJ = null;
  public int hOP;
  public String iIJ;
  public int irW;
  public int kmu;
  private m kuO;
  public com.tencent.mm.plugin.appbrand.jsapi.c kws;
  
  public h$a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    this.kuO = paramm;
    this.kws = paramc;
    this.kmu = paramInt;
  }
  
  public final void BK()
  {
    AppMethodBeat.i(145710);
    if (this.kws == null)
    {
      ae.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
      AppMethodBeat.o(145710);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.duration));
    localHashMap.put("currentTime", Integer.valueOf(this.dlC));
    boolean bool;
    if (this.irW == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Integer.valueOf(this.hOP));
      localHashMap.put("src", this.ddc);
      localHashMap.put("startTime", Integer.valueOf(this.dez));
      localHashMap.put("playbackRate", Double.valueOf(this.hOB));
      localHashMap.put("referrerPolicy", this.hOJ);
      if (!TextUtils.isEmpty(this.iIJ)) {
        break label238;
      }
    }
    label238:
    for (String str = "";; str = this.iIJ)
    {
      if (!this.error) {
        break label246;
      }
      ae.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
      this.kws.h(this.kmu, this.kuO.e("fail:".concat(String.valueOf(str)), null));
      AppMethodBeat.o(145710);
      return;
      bool = false;
      break;
    }
    label246:
    this.kws.h(this.kmu, this.kuO.n("ok", localHashMap));
    AppMethodBeat.o(145710);
  }
  
  public final void Ov()
  {
    AppMethodBeat.i(145709);
    Object localObject = this.ddg;
    v localv = new v();
    localv.dlA.action = 6;
    localv.dlA.ddg = ((String)localObject);
    com.tencent.mm.plugin.music.b.a.a(localv);
    localObject = localv.dlB.dlF;
    if (localObject == null)
    {
      ae.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", new Object[] { this.ddg });
      this.error = true;
      this.iIJ = "return parameter is invalid";
      BK();
      AppMethodBeat.o(145709);
      return;
    }
    if ((((d)localObject).duration < 0) || (((d)localObject).dlC < 0))
    {
      ae.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).dlC) });
      this.error = true;
      this.iIJ = "return parameter is invalid";
      BK();
      AppMethodBeat.o(145709);
      return;
    }
    this.duration = ((d)localObject).duration;
    this.dlC = ((d)localObject).dlC;
    if (((d)localObject).tG) {}
    for (int i = 1;; i = 0)
    {
      this.irW = i;
      this.ddc = ((d)localObject).ddc;
      this.hOP = ((d)localObject).hOP;
      this.dez = ((d)localObject).dez;
      this.hOJ = ((d)localObject).hOJ;
      localObject = com.tencent.mm.ai.c.Dk(this.ddg);
      if (localObject != null) {
        this.hOB = ((b)localObject).hOB;
      }
      ae.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.dlC), Integer.valueOf(this.irW), Integer.valueOf(this.hOP), this.ddc, Integer.valueOf(this.dez), Double.valueOf(this.hOB) });
      BK();
      AppMethodBeat.o(145709);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h.a
 * JD-Core Version:    0.7.0.1
 */