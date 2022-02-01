package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d;
import com.tencent.mm.autogen.a.ab;
import com.tencent.mm.autogen.a.ab.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class j
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145711);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(145711);
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramf.callback(paramInt, ZP("fail:audioId is empty"));
      AppMethodBeat.o(145711);
      return;
    }
    a locala = new a(this, paramf, paramInt);
    locala.appId = paramf.getAppId();
    locala.hqQ = paramJSONObject;
    locala.bQt();
    AppMethodBeat.o(145711);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int currentTime;
    public int duration = 0;
    public boolean error = false;
    public String hqM;
    public String hqQ = "";
    public int oWc;
    public int orC;
    public double orm;
    public String oru = null;
    public String ppp;
    public int ror;
    private p rzh;
    public f rzi;
    public int startTime;
    
    public a(p paramp, f paramf, int paramInt)
    {
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public final void aFi()
    {
      AppMethodBeat.i(145709);
      Object localObject = this.hqQ;
      ab localab = new ab();
      localab.hzS.action = 6;
      localab.hzS.hqQ = ((String)localObject);
      com.tencent.mm.plugin.music.b.b.a(localab);
      localObject = localab.hzT.hzW;
      if (localObject == null)
      {
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "audioState is null, audioId:%s", new Object[] { this.hqQ });
        this.error = true;
        this.ppp = "return parameter is invalid";
        callback();
        AppMethodBeat.o(145709);
        return;
      }
      if ((((d)localObject).duration < 0) || (((d)localObject).currentTime < 0))
      {
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).currentTime) });
        this.error = true;
        this.ppp = "return parameter is invalid";
        callback();
        AppMethodBeat.o(145709);
        return;
      }
      this.duration = ((d)localObject).duration;
      this.currentTime = ((d)localObject).currentTime;
      if (((d)localObject).orA) {}
      for (int i = 1;; i = 0)
      {
        this.oWc = i;
        this.hqM = ((d)localObject).hqM;
        this.orC = ((d)localObject).orC;
        this.startTime = ((d)localObject).startTime;
        this.oru = ((d)localObject).oru;
        localObject = com.tencent.mm.al.c.Lr(this.hqQ);
        if (localObject != null) {
          this.orm = ((com.tencent.mm.al.b)localObject).orm;
        }
        Log.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.currentTime), Integer.valueOf(this.oWc), Integer.valueOf(this.orC), this.hqM, Integer.valueOf(this.startTime), Double.valueOf(this.orm) });
        callback();
        AppMethodBeat.o(145709);
        return;
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145710);
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
        AppMethodBeat.o(145710);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.duration));
      localHashMap.put("currentTime", Integer.valueOf(this.currentTime));
      boolean bool;
      if (this.oWc == 1)
      {
        bool = true;
        localHashMap.put("paused", Boolean.valueOf(bool));
        localHashMap.put("buffered", Integer.valueOf(this.orC));
        localHashMap.put("src", this.hqM);
        localHashMap.put("startTime", Integer.valueOf(this.startTime));
        localHashMap.put("playbackRate", Double.valueOf(this.orm));
        localHashMap.put("referrerPolicy", this.oru);
        if (!TextUtils.isEmpty(this.ppp)) {
          break label237;
        }
      }
      label237:
      for (String str = "";; str = this.ppp)
      {
        if (!this.error) {
          break label245;
        }
        Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
        this.rzi.callback(this.ror, this.rzh.ZP("fail:".concat(String.valueOf(str))));
        AppMethodBeat.o(145710);
        return;
        bool = false;
        break;
      }
      label245:
      this.rzi.callback(this.ror, this.rzh.m("ok", localHashMap));
      AppMethodBeat.o(145710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j
 * JD-Core Version:    0.7.0.1
 */