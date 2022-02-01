package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.a.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145711);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      parame.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(145711);
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      parame.j(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(145711);
      return;
    }
    a locala = new a(this, parame, paramInt);
    locala.appId = parame.getAppId();
    locala.fmF = paramJSONObject;
    locala.bsM();
    AppMethodBeat.o(145711);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int currentTime;
    public int duration = 0;
    public boolean error = false;
    public String fmB;
    public String fmF = "";
    public int fod;
    public int lAb;
    public double lzL;
    public String lzT = null;
    public int mdj;
    public String mvQ;
    public int okO;
    private o ovN;
    public e ovO;
    
    public a(o paramo, e parame, int paramInt)
    {
      this.ovN = paramo;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void adj()
    {
      AppMethodBeat.i(145709);
      Object localObject = this.fmF;
      y localy = new y();
      localy.fvx.action = 6;
      localy.fvx.fmF = ((String)localObject);
      com.tencent.mm.plugin.music.b.b.a(localy);
      localObject = localy.fvy.fvB;
      if (localObject == null)
      {
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "audioState is null, audioId:%s", new Object[] { this.fmF });
        this.error = true;
        this.mvQ = "return parameter is invalid";
        callback();
        AppMethodBeat.o(145709);
        return;
      }
      if ((((d)localObject).duration < 0) || (((d)localObject).currentTime < 0))
      {
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).currentTime) });
        this.error = true;
        this.mvQ = "return parameter is invalid";
        callback();
        AppMethodBeat.o(145709);
        return;
      }
      this.duration = ((d)localObject).duration;
      this.currentTime = ((d)localObject).currentTime;
      if (((d)localObject).lzZ) {}
      for (int i = 1;; i = 0)
      {
        this.mdj = i;
        this.fmB = ((d)localObject).fmB;
        this.lAb = ((d)localObject).lAb;
        this.fod = ((d)localObject).fod;
        this.lzT = ((d)localObject).lzT;
        localObject = com.tencent.mm.al.c.Tp(this.fmF);
        if (localObject != null) {
          this.lzL = ((com.tencent.mm.al.b)localObject).lzL;
        }
        Log.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.currentTime), Integer.valueOf(this.mdj), Integer.valueOf(this.lAb), this.fmB, Integer.valueOf(this.fod), Double.valueOf(this.lzL) });
        callback();
        AppMethodBeat.o(145709);
        return;
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145710);
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
        AppMethodBeat.o(145710);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.duration));
      localHashMap.put("currentTime", Integer.valueOf(this.currentTime));
      boolean bool;
      if (this.mdj == 1)
      {
        bool = true;
        localHashMap.put("paused", Boolean.valueOf(bool));
        localHashMap.put("buffered", Integer.valueOf(this.lAb));
        localHashMap.put("src", this.fmB);
        localHashMap.put("startTime", Integer.valueOf(this.fod));
        localHashMap.put("playbackRate", Double.valueOf(this.lzL));
        localHashMap.put("referrerPolicy", this.lzT);
        if (!TextUtils.isEmpty(this.mvQ)) {
          break label238;
        }
      }
      label238:
      for (String str = "";; str = this.mvQ)
      {
        if (!this.error) {
          break label246;
        }
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
        this.ovO.j(this.okO, this.ovN.h("fail:".concat(String.valueOf(str)), null));
        AppMethodBeat.o(145710);
        return;
        bool = false;
        break;
      }
      label246:
      this.ovO.j(this.okO, this.ovN.m("ok", localHashMap));
      AppMethodBeat.o(145710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h
 * JD-Core Version:    0.7.0.1
 */