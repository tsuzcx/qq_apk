package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145711);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145711);
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ad.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145711);
      return;
    }
    a locala = new a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.dce = paramJSONObject;
    locala.aOD();
    AppMethodBeat.o(145711);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String dca;
    public String dce = "";
    public int ddx;
    public int dkA;
    public int duration = 0;
    public boolean error = false;
    public double hLI;
    public String hLQ = null;
    public int hLW;
    public String iFQ;
    public int ipb;
    public int kje;
    private m kry;
    public com.tencent.mm.plugin.appbrand.jsapi.c ktc;
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.kry = paramm;
      this.ktc = paramc;
      this.kje = paramInt;
    }
    
    public final void BJ()
    {
      AppMethodBeat.i(145710);
      if (this.ktc == null)
      {
        ad.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
        AppMethodBeat.o(145710);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.duration));
      localHashMap.put("currentTime", Integer.valueOf(this.dkA));
      boolean bool;
      if (this.ipb == 1)
      {
        bool = true;
        localHashMap.put("paused", Boolean.valueOf(bool));
        localHashMap.put("buffered", Integer.valueOf(this.hLW));
        localHashMap.put("src", this.dca);
        localHashMap.put("startTime", Integer.valueOf(this.ddx));
        localHashMap.put("playbackRate", Double.valueOf(this.hLI));
        localHashMap.put("referrerPolicy", this.hLQ);
        if (!TextUtils.isEmpty(this.iFQ)) {
          break label238;
        }
      }
      label238:
      for (String str = "";; str = this.iFQ)
      {
        if (!this.error) {
          break label246;
        }
        ad.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
        this.ktc.h(this.kje, this.kry.e("fail:".concat(String.valueOf(str)), null));
        AppMethodBeat.o(145710);
        return;
        bool = false;
        break;
      }
      label246:
      this.ktc.h(this.kje, this.kry.m("ok", localHashMap));
      AppMethodBeat.o(145710);
    }
    
    public final void Ox()
    {
      AppMethodBeat.i(145709);
      Object localObject = this.dce;
      v localv = new v();
      localv.dky.action = 6;
      localv.dky.dce = ((String)localObject);
      com.tencent.mm.plugin.music.b.a.a(localv);
      localObject = localv.dkz.dkD;
      if (localObject == null)
      {
        ad.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", new Object[] { this.dce });
        this.error = true;
        this.iFQ = "return parameter is invalid";
        BJ();
        AppMethodBeat.o(145709);
        return;
      }
      if ((((d)localObject).duration < 0) || (((d)localObject).dkA < 0))
      {
        ad.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).dkA) });
        this.error = true;
        this.iFQ = "return parameter is invalid";
        BJ();
        AppMethodBeat.o(145709);
        return;
      }
      this.duration = ((d)localObject).duration;
      this.dkA = ((d)localObject).dkA;
      if (((d)localObject).tG) {}
      for (int i = 1;; i = 0)
      {
        this.ipb = i;
        this.dca = ((d)localObject).dca;
        this.hLW = ((d)localObject).hLW;
        this.ddx = ((d)localObject).ddx;
        this.hLQ = ((d)localObject).hLQ;
        localObject = com.tencent.mm.aj.c.CI(this.dce);
        if (localObject != null) {
          this.hLI = ((b)localObject).hLI;
        }
        ad.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.dkA), Integer.valueOf(this.ipb), Integer.valueOf(this.hLW), this.dca, Integer.valueOf(this.ddx), Double.valueOf(this.hLI) });
        BJ();
        AppMethodBeat.o(145709);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h
 * JD-Core Version:    0.7.0.1
 */