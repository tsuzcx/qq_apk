package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145711);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145711);
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ac.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145711);
      return;
    }
    a locala = new a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.cQO = paramJSONObject;
    locala.aLt();
    AppMethodBeat.o(145711);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String cQK;
    public String cQO = "";
    public int cSh;
    public int cZi;
    public int duration = 0;
    public boolean error = false;
    public int hVG;
    public int htE;
    public double htq;
    public String hty = null;
    public String imz;
    public int jOT;
    private m jXc;
    public com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.jXc = paramm;
      this.jYG = paramc;
      this.jOT = paramInt;
    }
    
    public final void Am()
    {
      AppMethodBeat.i(145710);
      if (this.jYG == null)
      {
        ac.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
        AppMethodBeat.o(145710);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.duration));
      localHashMap.put("currentTime", Integer.valueOf(this.cZi));
      boolean bool;
      if (this.hVG == 1)
      {
        bool = true;
        localHashMap.put("paused", Boolean.valueOf(bool));
        localHashMap.put("buffered", Integer.valueOf(this.htE));
        localHashMap.put("src", this.cQK);
        localHashMap.put("startTime", Integer.valueOf(this.cSh));
        localHashMap.put("playbackRate", Double.valueOf(this.htq));
        localHashMap.put("referrerPolicy", this.hty);
        if (!TextUtils.isEmpty(this.imz)) {
          break label238;
        }
      }
      label238:
      for (String str = "";; str = this.imz)
      {
        if (!this.error) {
          break label246;
        }
        ac.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
        this.jYG.h(this.jOT, this.jXc.e("fail:".concat(String.valueOf(str)), null));
        AppMethodBeat.o(145710);
        return;
        bool = false;
        break;
      }
      label246:
      this.jYG.h(this.jOT, this.jXc.k("ok", localHashMap));
      AppMethodBeat.o(145710);
    }
    
    public final void MO()
    {
      AppMethodBeat.i(145709);
      Object localObject = this.cQO;
      v localv = new v();
      localv.cZg.action = 6;
      localv.cZg.cQO = ((String)localObject);
      com.tencent.mm.plugin.music.b.a.a(localv);
      localObject = localv.cZh.cZl;
      if (localObject == null)
      {
        ac.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", new Object[] { this.cQO });
        this.error = true;
        this.imz = "return parameter is invalid";
        Am();
        AppMethodBeat.o(145709);
        return;
      }
      if ((((d)localObject).duration < 0) || (((d)localObject).cZi < 0))
      {
        ac.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).cZi) });
        this.error = true;
        this.imz = "return parameter is invalid";
        Am();
        AppMethodBeat.o(145709);
        return;
      }
      this.duration = ((d)localObject).duration;
      this.cZi = ((d)localObject).cZi;
      if (((d)localObject).rM) {}
      for (int i = 1;; i = 0)
      {
        this.hVG = i;
        this.cQK = ((d)localObject).cQK;
        this.htE = ((d)localObject).htE;
        this.cSh = ((d)localObject).cSh;
        this.hty = ((d)localObject).hty;
        localObject = com.tencent.mm.ai.c.zJ(this.cQO);
        if (localObject != null) {
          this.htq = ((b)localObject).htq;
        }
        ac.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.cZi), Integer.valueOf(this.hVG), Integer.valueOf(this.htE), this.cQK, Integer.valueOf(this.cSh), Double.valueOf(this.htq) });
        Am();
        AppMethodBeat.o(145709);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */