package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public class l
  extends d
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a lDW;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145749);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.acB(paramf.getAppId()))
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramf.i(paramInt, h("fail:App is paused or background", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramf.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(145749);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[] { paramJSONObject.toString() });
    String str = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("startTime", 0);
    Object localObject1 = paramJSONObject.optString("src");
    boolean bool1;
    boolean bool2;
    double d3;
    double d1;
    Object localObject2;
    Object localObject3;
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.Audio.WxaAudioUtils", "src is empty");
      localObject1 = "";
      bool1 = paramJSONObject.optBoolean("autoplay", false);
      bool2 = paramJSONObject.optBoolean("loop", false);
      d3 = paramJSONObject.optDouble("volume", 1.0D);
      double d2 = paramJSONObject.optDouble("playbackRate", 1.0D);
      if (d2 >= 0.5D)
      {
        d1 = d2;
        if (d2 <= 2.0D) {}
      }
      else
      {
        d1 = 1.0D;
      }
      localObject6 = Long.valueOf(paramJSONObject.optLong("timestamp", 0L));
      localObject4 = Long.valueOf(0L);
      localObject5 = Long.valueOf(System.currentTimeMillis());
      if (!bool1) {
        break label493;
      }
      localObject2 = localObject5;
      localObject3 = localObject4;
      if (((Long)localObject6).longValue() > 0L)
      {
        localObject2 = localObject5;
        localObject3 = localObject4;
        if (((Long)localObject6).longValue() <= ((Long)localObject5).longValue())
        {
          localObject3 = Long.valueOf(((Long)localObject5).longValue() - ((Long)localObject6).longValue());
          localObject2 = localObject5;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        break label506;
      }
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramf.i(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(145749);
      return;
      if (((String)localObject1).startsWith("wxfile://"))
      {
        if (paramf.getFileSystem() == null)
        {
          Log.e("MicroMsg.Audio.WxaAudioUtils", "getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramf.getFileSystem().VY((String)localObject1);
        if ((localObject1 == null) || (!((o)localObject1).exists()))
        {
          Log.e("MicroMsg.Audio.WxaAudioUtils", "localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = aa.z(((o)localObject1).her());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("file://")) {
            localObject1 = "file://".concat(String.valueOf(localObject2));
          }
        }
        Log.i("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
        break;
      }
      if (((String)localObject1).length() <= 250) {
        Log.i("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
      }
      break;
      label493:
      localObject2 = Long.valueOf(0L);
      localObject3 = localObject4;
    }
    label506:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramf.i(paramInt, h("fail:src is empty", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (this.lDW == null) {
      this.lDW = new a(paramf);
    }
    this.lDW.appId = paramf.getAppId();
    this.lDW.bjm();
    Object localObject4 = new l.c(this, paramf, paramInt);
    ((l.c)localObject4).appId = paramf.getAppId();
    ((l.c)localObject4).dtX = str;
    ((l.c)localObject4).dtT = ((String)localObject1);
    ((l.c)localObject4).dvv = i;
    ((l.c)localObject4).iJE = bool1;
    ((l.c)localObject4).loop = bool2;
    ((l.c)localObject4).lDZ = e(paramf, (String)localObject1);
    ((l.c)localObject4).iJG = d3;
    ((l.c)localObject4).iJH = d1;
    ((l.c)localObject4).processName = MMApplicationContext.getProcessName();
    ((l.c)localObject4).iJJ = ((Long)localObject3).longValue();
    ((l.c)localObject4).iJK = ((Long)localObject2).longValue();
    Object localObject6 = (com.tencent.mm.plugin.appbrand.jsapi.u.a)e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
    if (localObject6 == null)
    {
      paramf = new Pair(null, "invalidReferrer");
      ((l.c)localObject4).iJP = ((String)paramf.first);
      ((l.c)localObject4).iJQ = ((String)paramf.second);
      ((l.c)localObject4).bjm();
      paramf = new com.tencent.mm.plugin.appbrand.media.a.c();
      paramf.lDZ = ((l.c)localObject4).lDZ;
      paramf.lDY = paramJSONObject.toString();
      paramf.dtT = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramf);
      AppMethodBeat.o(145749);
      return;
    }
    Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject6).af(paramJSONObject);
    if (localObject5 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject6).aaF((String)localObject5);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject6).x(paramf);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.u.c.mou == localObject2) {
        paramf = null;
      }
    }
    for (;;)
    {
      paramf = new Pair(localObject5, paramf);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.u.c.mot == localObject2) {
        paramf = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject6).y(paramf);
      } else {
        paramf = "invalidReferrer";
      }
    }
  }
  
  public WxaPkg.Info e(f paramf, String paramString)
  {
    return null;
  }
  
  public static final class a
    extends a
  {
    public int action;
    public String appId;
    public f lAx;
    private String lEI;
    private IListener lEJ;
    public String lEk;
    
    public a(f paramf)
    {
      AppMethodBeat.i(256425);
      this.appId = "";
      this.lEJ = new IListener() {};
      this.lAx = paramf;
      AppMethodBeat.o(256425);
    }
    
    public final void YC()
    {
      AppMethodBeat.i(145745);
      Log.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.acA(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.lEJ);
      AppMethodBeat.o(145745);
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145746);
      if (this.lAx == null)
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145746);
        return;
      }
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.lEk });
      if (Util.isNullOrNil(this.lEk))
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(145746);
        return;
      }
      new l.b().h(this.lAx).Zh(this.lEk).a(c.lDH.Zm(this.appId).Zz(this.lEI));
      AppMethodBeat.o(145746);
    }
  }
  
  public static final class b
    extends bc
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAudioStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l
 * JD-Core Version:    0.7.0.1
 */