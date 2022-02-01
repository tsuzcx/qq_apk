package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a kzD;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145749);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.SX(paramc.getAppId()))
    {
      ae.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, e("fail:App is paused or background", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145749);
      return;
    }
    ae.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[] { paramJSONObject.toString() });
    String str = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("startTime", 0);
    Object localObject1 = paramJSONObject.optString("src");
    boolean bool1;
    boolean bool2;
    double d3;
    double d1;
    Object localObject2;
    Object localObject3;
    if (bu.isNullOrNil((String)localObject1))
    {
      ae.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
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
        break label621;
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
        break label634;
      }
      ae.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145749);
      return;
      if (((String)localObject1).startsWith("wxfile://"))
      {
        if (paramc.Fl() == null)
        {
          ae.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramc.Fl().MP((String)localObject1);
        if ((localObject1 == null) || (!((k)localObject1).exists()))
        {
          ae.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("file://")) {
            localObject1 = "file://".concat(String.valueOf(localObject2));
          }
        }
        ae.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
        break;
      }
      if (((String)localObject1).startsWith("wxblob://"))
      {
        if (paramc.Fl() == null)
        {
          ae.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramc.Fl().MM((String)localObject1);
        if ((localObject1 == null) || (!((k)localObject1).exists()))
        {
          ae.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = com.tencent.mm.vfs.w.B(((k)localObject1).fTh());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("file://")) {
            localObject1 = "file://".concat(String.valueOf(localObject2));
          }
        }
        ae.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
        break;
      }
      ae.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
      break;
      label621:
      localObject2 = Long.valueOf(0L);
      localObject3 = localObject4;
    }
    label634:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ae.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramc.h(paramInt, e("fail:src is empty", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (this.kzD == null) {
      this.kzD = new a(paramc);
    }
    this.kzD.appId = paramc.getAppId();
    this.kzD.aPa();
    Object localObject4 = new c(this, paramc, paramInt);
    ((c)localObject4).appId = paramc.getAppId();
    ((c)localObject4).ddg = str;
    ((c)localObject4).ddc = ((String)localObject1);
    ((c)localObject4).dez = i;
    ((c)localObject4).hOy = bool1;
    ((c)localObject4).loop = bool2;
    ((c)localObject4).kzG = e(paramc, (String)localObject1);
    ((c)localObject4).hOA = d3;
    ((c)localObject4).hOB = d1;
    ((c)localObject4).processName = ak.getProcessName();
    ((c)localObject4).hOD = ((Long)localObject3).longValue();
    ((c)localObject4).hOE = ((Long)localObject2).longValue();
    Object localObject6 = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
    if (localObject6 == null)
    {
      ae.w("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerHelper is null");
      paramc = new Pair(null, "invalidReferrer");
      ((c)localObject4).hOJ = ((String)paramc.first);
      ((c)localObject4).hOK = ((String)paramc.second);
      ((c)localObject4).aPa();
      paramc = new com.tencent.mm.plugin.appbrand.media.a.c();
      paramc.kzG = ((c)localObject4).kzG;
      paramc.kzF = paramJSONObject.toString();
      paramc.ddc = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramc);
      AppMethodBeat.o(145749);
      return;
    }
    Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject6).W(paramJSONObject);
    if (localObject5 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject6).Rd((String)localObject5);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject6).x(paramc);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.s.c.liO == localObject2) {
        paramc = null;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { localObject5, paramc });
      paramc = new Pair(localObject5, paramc);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.s.c.liN == localObject2) {
        paramc = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject6).y(paramc);
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
    private String kAp;
    private com.tencent.mm.sdk.b.c kAq;
    public com.tencent.mm.plugin.appbrand.jsapi.c kws;
    public String kzR;
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      AppMethodBeat.i(210896);
      this.appId = "";
      this.kAq = new com.tencent.mm.sdk.b.c() {};
      this.kws = paramc;
      AppMethodBeat.o(210896);
    }
    
    public final void BK()
    {
      AppMethodBeat.i(145746);
      if (this.kws == null)
      {
        ae.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145746);
        return;
      }
      ae.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.kzR });
      if (bu.isNullOrNil(this.kzR))
      {
        ae.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(145746);
        return;
      }
      new l.b().h(this.kws).PQ(this.kzR).a(c.kzo.PS(this.appId).PY(this.kAp));
      AppMethodBeat.o(145746);
    }
    
    public final void Ov()
    {
      AppMethodBeat.i(145745);
      ae.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.SW(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.kAq);
      AppMethodBeat.o(145745);
    }
  }
  
  static final class c
    extends a
  {
    public String appId = "";
    public String ddc = "";
    public String ddg = "";
    public int dez = 0;
    public boolean error = false;
    public double hOA;
    public double hOB;
    public long hOD;
    public long hOE;
    public String hOJ = null;
    public String hOK = null;
    public boolean hOy = false;
    public String iIJ;
    public int kmu;
    private m kuO;
    public com.tencent.mm.plugin.appbrand.jsapi.c kws;
    public WxaPkg.Info kzG;
    public boolean loop = false;
    public String processName = "";
    
    public c(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.kuO = paramm;
      this.kws = paramc;
      this.kmu = paramInt;
    }
    
    public final void BK()
    {
      AppMethodBeat.i(145748);
      super.BK();
      if (this.kws == null)
      {
        ae.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145748);
        return;
      }
      if (this.error)
      {
        this.kws.h(this.kmu, this.kuO.e("fail:" + this.iIJ, null));
        AppMethodBeat.o(145748);
        return;
      }
      this.kws.h(this.kmu, this.kuO.e("ok", null));
      AppMethodBeat.o(145748);
    }
    
    public final void Ov()
    {
      AppMethodBeat.i(145747);
      ae.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.iIJ = "";
      Object localObject1 = com.tencent.mm.ai.c.Dk(this.ddg);
      b localb = new b();
      localb.ddg = this.ddg;
      localb.der = this.ddc;
      localb.dez = this.dez;
      localb.hOx = this.dez;
      localb.hOy = this.hOy;
      localb.loop = this.loop;
      localb.processName = this.processName;
      localb.hOA = this.hOA;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.hOB = this.hOB;
      localb.hOF = this.hOD;
      localb.hOG = this.hOE;
      localb.hOJ = this.hOJ;
      localb.hOK = this.hOK;
      if ((localObject1 != null) && (this.ddc.equalsIgnoreCase(((b)localObject1).der)) && (com.tencent.mm.ai.c.Dj(this.ddg)))
      {
        ae.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        ae.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.ddg, localb.der });
        localObject1 = new v();
        ((v)localObject1).dlA.action = 18;
        ((v)localObject1).dlA.ddg = localb.ddg;
        ((v)localObject1).dlA.dlD = localb;
        com.tencent.mm.plugin.music.b.a.a((v)localObject1);
        if (!((v)localObject1).dlB.result)
        {
          this.error = true;
          this.iIJ = "not to set audio param, the audioId is err";
          ae.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        BK();
        AppMethodBeat.o(145747);
        return;
      }
      ae.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.ddg, this.ddc, Integer.valueOf(this.dez) });
      if (this.ddc.startsWith("file://"))
      {
        localb.filePath = this.ddc.substring(7);
        ae.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
      }
      while ((this.ddc.startsWith("http://")) || (this.ddc.startsWith("https://")))
      {
        if (!this.error)
        {
          ae.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { localb.ddg });
          localObject1 = new v();
          ((v)localObject1).dlA.action = 0;
          ((v)localObject1).dlA.ddg = localb.ddg;
          ((v)localObject1).dlA.dlD = localb;
          com.tencent.mm.plugin.music.b.a.a((v)localObject1);
        }
        BK();
        AppMethodBeat.o(145747);
        return;
      }
      com.tencent.mm.ai.e locale = f.c(this.kzG);
      if ((locale == null) || (!locale.isOpen()))
      {
        org.apache.commons.a.e.closeQuietly(locale);
        this.error = true;
        this.iIJ = "the file not exist for src";
        ae.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.ddc });
        BK();
        AppMethodBeat.o(145747);
        return;
      }
      if ((localObject1 != null) && (this.ddc.equalsIgnoreCase(((b)localObject1).der)) && (!TextUtils.isEmpty(((b)localObject1).filePath))) {
        localObject1 = ((b)localObject1).filePath;
      }
      for (;;)
      {
        localb.filePath = ((String)localObject1);
        localb.hOL = locale;
        break;
        Object localObject2 = this.kws;
        localObject1 = this.ddc;
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.e("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
        }
        else if (((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).Fl() == null)
        {
          ae.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).Fl().MP((String)localObject1);
          if ((localObject2 == null) || (!((k)localObject2).exists()))
          {
            ae.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
          }
          else
          {
            localObject1 = com.tencent.mm.vfs.w.B(((k)localObject2).fTh());
            ae.i("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { localObject1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l
 * JD-Core Version:    0.7.0.1
 */