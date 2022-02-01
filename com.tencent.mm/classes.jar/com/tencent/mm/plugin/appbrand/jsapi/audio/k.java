package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.b;
import com.tencent.mm.g.a.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import org.apache.commons.a.d;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a jBt;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145749);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.KE(paramc.getAppId()))
    {
      ad.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, e("fail:App is paused or background", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145749);
      return;
    }
    ad.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[] { paramJSONObject.toString() });
    String str = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("startTime", 0);
    Object localObject1 = paramJSONObject.optString("src");
    boolean bool1;
    boolean bool2;
    double d3;
    double d1;
    Object localObject2;
    Object localObject3;
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
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
        break label482;
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
        break label495;
      }
      ad.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145749);
      return;
      if (((String)localObject1).startsWith("wxfile://"))
      {
        if (paramc.Ee() == null)
        {
          ad.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramc.Ee().EP((String)localObject1);
        if ((localObject1 == null) || (!((com.tencent.mm.vfs.e)localObject1).exists()))
        {
          ad.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("file://")) {
            localObject1 = "file://".concat(String.valueOf(localObject2));
          }
        }
        ad.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
        break;
      }
      ad.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
      break;
      label482:
      localObject2 = Long.valueOf(0L);
      localObject3 = localObject4;
    }
    label495:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ad.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramc.h(paramInt, e("fail:src is empty", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (this.jBt == null) {
      this.jBt = new a(this, paramc, paramInt);
    }
    this.jBt.appId = paramc.getAppId();
    this.jBt.aEC();
    Object localObject4 = new c(this, paramc, paramInt);
    ((c)localObject4).appId = paramc.getAppId();
    ((c)localObject4).cTr = str;
    ((c)localObject4).cTn = ((String)localObject1);
    ((c)localObject4).cUL = i;
    ((c)localObject4).gSN = bool1;
    ((c)localObject4).loop = bool2;
    ((c)localObject4).jBw = e(paramc, (String)localObject1);
    ((c)localObject4).gSQ = d3;
    ((c)localObject4).gSR = d1;
    ((c)localObject4).processName = aj.getProcessName();
    ((c)localObject4).gST = ((Long)localObject3).longValue();
    ((c)localObject4).gSU = ((Long)localObject2).longValue();
    Object localObject6 = (com.tencent.mm.plugin.appbrand.jsapi.q.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.q.a.class);
    if (localObject6 == null)
    {
      ad.w("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerHelper is null");
      paramc = new Pair(null, "invalidReferrer");
      ((c)localObject4).gSZ = ((String)paramc.first);
      ((c)localObject4).gTa = ((String)paramc.second);
      ((c)localObject4).aEC();
      paramc = new com.tencent.mm.plugin.appbrand.media.a.c();
      paramc.jBw = ((c)localObject4).jBw;
      paramc.jBv = paramJSONObject.toString();
      paramc.cTn = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramc);
      AppMethodBeat.o(145749);
      return;
    }
    Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject6).U(paramJSONObject);
    if (localObject5 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject6).IU((String)localObject5);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject6).x(paramc);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.q.c.khR == localObject2) {
        paramc = null;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { localObject5, paramc });
      paramc = new Pair(localObject5, paramc);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.q.c.khQ == localObject2) {
        paramc = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject6).y(paramc);
      } else {
        paramc = "invalidReferrer";
      }
    }
  }
  
  public WxaPkg.Info e(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    return null;
  }
  
  public static final class a
    extends a
  {
    public int action;
    public String appId;
    public String jBH;
    private com.tencent.mm.sdk.b.c jCf;
    public int joH;
    private m jwG;
    public com.tencent.mm.plugin.appbrand.jsapi.c jyl;
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      AppMethodBeat.i(145744);
      this.appId = "";
      this.jCf = new com.tencent.mm.sdk.b.c() {};
      this.jwG = paramm;
      this.jyl = paramc;
      this.joH = paramInt;
      AppMethodBeat.o(145744);
    }
    
    public final void AI()
    {
      AppMethodBeat.i(145746);
      if (this.jyl == null)
      {
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145746);
        return;
      }
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.jBH });
      if (bt.isNullOrNil(this.jBH))
      {
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(145746);
        return;
      }
      new k.b().h(this.jyl).HK(this.jBH).aXQ();
      AppMethodBeat.o(145746);
    }
    
    public final void MQ()
    {
      AppMethodBeat.i(145745);
      ad.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.KD(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.jCf);
      AppMethodBeat.o(145745);
    }
  }
  
  public static final class b
    extends ar
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAudioStateChange";
  }
  
  static final class c
    extends a
  {
    public String appId = "";
    public String cTn = "";
    public String cTr = "";
    public int cUL = 0;
    public boolean error = false;
    public boolean gSN = false;
    public double gSQ;
    public double gSR;
    public long gST;
    public long gSU;
    public String gSZ = null;
    public String gTa = null;
    public String hMd;
    public WxaPkg.Info jBw;
    public int joH;
    private m jwG;
    public com.tencent.mm.plugin.appbrand.jsapi.c jyl;
    public boolean loop = false;
    public String processName = "";
    
    public c(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.jwG = paramm;
      this.jyl = paramc;
      this.joH = paramInt;
    }
    
    public final void AI()
    {
      AppMethodBeat.i(145748);
      super.AI();
      if (this.jyl == null)
      {
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145748);
        return;
      }
      if (this.error)
      {
        this.jyl.h(this.joH, this.jwG.e("fail:" + this.hMd, null));
        AppMethodBeat.o(145748);
        return;
      }
      this.jyl.h(this.joH, this.jwG.e("ok", null));
      AppMethodBeat.o(145748);
    }
    
    public final void MQ()
    {
      AppMethodBeat.i(145747);
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.hMd = "";
      Object localObject1 = com.tencent.mm.aj.c.vD(this.cTr);
      b localb = new b();
      localb.cTr = this.cTr;
      localb.cUD = this.cTn;
      localb.cUL = this.cUL;
      localb.gSM = this.cUL;
      localb.gSN = this.gSN;
      localb.loop = this.loop;
      localb.processName = this.processName;
      localb.gSQ = this.gSQ;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.gSR = this.gSR;
      localb.gSV = this.gST;
      localb.gSW = this.gSU;
      localb.gSZ = this.gSZ;
      localb.gTa = this.gTa;
      if ((localObject1 != null) && (this.cTn.equalsIgnoreCase(((b)localObject1).cUD)) && (com.tencent.mm.aj.c.vC(this.cTr)))
      {
        ad.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        ad.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.cTr, localb.cUD });
        localObject1 = new u();
        ((u)localObject1).dbH.action = 18;
        ((u)localObject1).dbH.cTr = localb.cTr;
        ((u)localObject1).dbH.dbK = localb;
        com.tencent.mm.plugin.music.b.a.a((u)localObject1);
        if (!((u)localObject1).dbI.result)
        {
          this.error = true;
          this.hMd = "not to set audio param, the audioId is err";
          ad.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        AI();
        AppMethodBeat.o(145747);
        return;
      }
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.cTr, this.cTn, Integer.valueOf(this.cUL) });
      if (this.cTn.startsWith("file://"))
      {
        localb.filePath = this.cTn.substring(7);
        ad.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
      }
      while ((this.cTn.startsWith("http://")) || (this.cTn.startsWith("https://")))
      {
        if (!this.error)
        {
          ad.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { localb.cTr });
          localObject1 = new u();
          ((u)localObject1).dbH.action = 0;
          ((u)localObject1).dbH.cTr = localb.cTr;
          ((u)localObject1).dbH.dbK = localb;
          com.tencent.mm.plugin.music.b.a.a((u)localObject1);
        }
        AI();
        AppMethodBeat.o(145747);
        return;
      }
      com.tencent.mm.aj.e locale = f.c(this.jBw);
      if ((locale == null) || (!locale.isOpen()))
      {
        d.closeQuietly(locale);
        this.error = true;
        this.hMd = "the file not exist for src";
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.cTn });
        AI();
        AppMethodBeat.o(145747);
        return;
      }
      if ((localObject1 != null) && (this.cTn.equalsIgnoreCase(((b)localObject1).cUD)) && (!TextUtils.isEmpty(((b)localObject1).filePath))) {
        localObject1 = ((b)localObject1).filePath;
      }
      for (;;)
      {
        localb.filePath = ((String)localObject1);
        localb.gTb = locale;
        break;
        Object localObject2 = this.jyl;
        localObject1 = this.cTn;
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.e("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
        }
        else if (((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).Ee() == null)
        {
          ad.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).Ee().EP((String)localObject1);
          if ((localObject2 == null) || (!((com.tencent.mm.vfs.e)localObject2).exists()))
          {
            ad.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
          }
          else
          {
            localObject1 = q.B(((com.tencent.mm.vfs.e)localObject2).fhU());
            ad.i("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { localObject1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k
 * JD-Core Version:    0.7.0.1
 */