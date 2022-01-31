package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.af.d;
import com.tencent.mm.h.a.s;
import com.tencent.mm.h.a.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class f$a
  extends a
{
  public String appId = "";
  public String bFM = "";
  public int bFN;
  public int duration = 0;
  public int eCF;
  public int eaX;
  public String eaY;
  public boolean error = false;
  private i gfG;
  public int gfg;
  public c ggu;
  public String gio;
  public int startTime;
  
  public f$a(i parami, c paramc, int paramInt)
  {
    this.gfG = parami;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void ahX()
  {
    Object localObject = this.bFM;
    s locals = new s();
    locals.bFK.action = 6;
    locals.bFK.bFM = ((String)localObject);
    com.tencent.mm.plugin.music.b.a.a(locals);
    localObject = locals.bFL.bFR;
    if (localObject == null)
    {
      y.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", new Object[] { this.bFM });
      this.error = true;
      this.gio = "return parameter is invalid";
      pQ();
      return;
    }
    if ((((d)localObject).duration < 0) || (((d)localObject).bFN < 0))
    {
      y.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).bFN) });
      this.error = true;
      this.gio = "return parameter is invalid";
      pQ();
      return;
    }
    this.duration = ((d)localObject).duration;
    this.bFN = ((d)localObject).bFN;
    if (((d)localObject).jJ) {}
    for (int i = 1;; i = 0)
    {
      this.eCF = i;
      this.eaY = ((d)localObject).eaY;
      this.eaX = ((d)localObject).eaX;
      this.startTime = ((d)localObject).startTime;
      y.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.bFN), Integer.valueOf(this.eCF), Integer.valueOf(this.eaX), this.eaY, Integer.valueOf(this.startTime) });
      pQ();
      return;
    }
  }
  
  public final void pQ()
  {
    if (this.ggu == null)
    {
      y.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.duration));
    localHashMap.put("currentTime", Integer.valueOf(this.bFN));
    boolean bool;
    if (this.eCF == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Integer.valueOf(this.eaX));
      localHashMap.put("src", this.eaY);
      localHashMap.put("startTime", Integer.valueOf(this.startTime));
      if (!TextUtils.isEmpty(this.gio)) {
        break label201;
      }
    }
    label201:
    for (String str = "";; str = this.gio)
    {
      if (!this.error) {
        break label209;
      }
      y.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
      this.ggu.C(this.gfg, this.gfG.h("fail:" + str, null));
      return;
      bool = false;
      break;
    }
    label209:
    this.ggu.C(this.gfg, this.gfG.h("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f.a
 * JD-Core Version:    0.7.0.1
 */