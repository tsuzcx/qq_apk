package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.c;
import com.tencent.mm.ai.d;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

final class h$a
  extends a
{
  public String appId = "";
  public int dCS;
  public String dtT;
  public String dtX = "";
  public int duration = 0;
  public int dvv;
  public boolean error = false;
  public double iJH;
  public String iJP = null;
  public int iJW;
  public String jFn;
  public int jnj;
  private p lAw;
  public f lAx;
  public int lqe;
  
  public h$a(p paramp, f paramf, int paramInt)
  {
    this.lAw = paramp;
    this.lAx = paramf;
    this.lqe = paramInt;
  }
  
  public final void YC()
  {
    AppMethodBeat.i(145709);
    Object localObject = this.dtX;
    x localx = new x();
    localx.dCQ.action = 6;
    localx.dCQ.dtX = ((String)localObject);
    com.tencent.mm.plugin.music.b.a.a(localx);
    localObject = localx.dCR.dCV;
    if (localObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "audioState is null, audioId:%s", new Object[] { this.dtX });
      this.error = true;
      this.jFn = "return parameter is invalid";
      callback();
      AppMethodBeat.o(145709);
      return;
    }
    if ((((d)localObject).duration < 0) || (((d)localObject).dCS < 0))
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[] { Integer.valueOf(((d)localObject).duration), Integer.valueOf(((d)localObject).dCS) });
      this.error = true;
      this.jFn = "return parameter is invalid";
      callback();
      AppMethodBeat.o(145709);
      return;
    }
    this.duration = ((d)localObject).duration;
    this.dCS = ((d)localObject).dCS;
    if (((d)localObject).tN) {}
    for (int i = 1;; i = 0)
    {
      this.jnj = i;
      this.dtT = ((d)localObject).dtT;
      this.iJW = ((d)localObject).iJW;
      this.dvv = ((d)localObject).dvv;
      this.iJP = ((d)localObject).iJP;
      localObject = c.LU(this.dtX);
      if (localObject != null) {
        this.iJH = ((b)localObject).iJH;
      }
      Log.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.dCS), Integer.valueOf(this.jnj), Integer.valueOf(this.iJW), this.dtT, Integer.valueOf(this.dvv), Double.valueOf(this.iJH) });
      callback();
      AppMethodBeat.o(145709);
      return;
    }
  }
  
  public final void callback()
  {
    AppMethodBeat.i(145710);
    if (this.lAx == null)
    {
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
      AppMethodBeat.o(145710);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.duration));
    localHashMap.put("currentTime", Integer.valueOf(this.dCS));
    boolean bool;
    if (this.jnj == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Integer.valueOf(this.iJW));
      localHashMap.put("src", this.dtT);
      localHashMap.put("startTime", Integer.valueOf(this.dvv));
      localHashMap.put("playbackRate", Double.valueOf(this.iJH));
      localHashMap.put("referrerPolicy", this.iJP);
      if (!TextUtils.isEmpty(this.jFn)) {
        break label238;
      }
    }
    label238:
    for (String str = "";; str = this.jFn)
    {
      if (!this.error) {
        break label246;
      }
      Log.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[] { str });
      this.lAx.i(this.lqe, this.lAw.h("fail:".concat(String.valueOf(str)), null));
      AppMethodBeat.o(145710);
      return;
      bool = false;
      break;
    }
    label246:
    this.lAx.i(this.lqe, this.lAw.n("ok", localHashMap));
    AppMethodBeat.o(145710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h.a
 * JD-Core Version:    0.7.0.1
 */