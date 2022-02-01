package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a kwo;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145749);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.So(paramc.getAppId()))
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
        if (paramc.Fg() == null)
        {
          ad.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramc.Fg().Mj((String)localObject1);
        if ((localObject1 == null) || (!((com.tencent.mm.vfs.e)localObject1).exists()))
        {
          ad.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = q.B(((com.tencent.mm.vfs.e)localObject1).fOK());
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
    if (this.kwo == null) {
      this.kwo = new a(paramc);
    }
    this.kwo.appId = paramc.getAppId();
    this.kwo.aOD();
    Object localObject4 = new c(this, paramc, paramInt);
    ((c)localObject4).appId = paramc.getAppId();
    ((c)localObject4).dce = str;
    ((c)localObject4).dca = ((String)localObject1);
    ((c)localObject4).ddx = i;
    ((c)localObject4).hLF = bool1;
    ((c)localObject4).loop = bool2;
    ((c)localObject4).kwr = e(paramc, (String)localObject1);
    ((c)localObject4).hLH = d3;
    ((c)localObject4).hLI = d1;
    ((c)localObject4).processName = aj.getProcessName();
    ((c)localObject4).hLK = ((Long)localObject3).longValue();
    ((c)localObject4).hLL = ((Long)localObject2).longValue();
    Object localObject6 = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
    if (localObject6 == null)
    {
      ad.w("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerHelper is null");
      paramc = new Pair(null, "invalidReferrer");
      ((c)localObject4).hLQ = ((String)paramc.first);
      ((c)localObject4).hLR = ((String)paramc.second);
      ((c)localObject4).aOD();
      paramc = new com.tencent.mm.plugin.appbrand.media.a.c();
      paramc.kwr = ((c)localObject4).kwr;
      paramc.kwq = paramJSONObject.toString();
      paramc.dca = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramc);
      AppMethodBeat.o(145749);
      return;
    }
    Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject6).W(paramJSONObject);
    if (localObject5 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject6).Qu((String)localObject5);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject6).x(paramc);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.s.c.lfc == localObject2) {
        paramc = null;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { localObject5, paramc });
      paramc = new Pair(localObject5, paramc);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.s.c.lfb == localObject2) {
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
    public com.tencent.mm.plugin.appbrand.jsapi.c ktc;
    public String kwC;
    private String kxa;
    private com.tencent.mm.sdk.b.c kxb;
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
    {
      AppMethodBeat.i(198674);
      this.appId = "";
      this.kxb = new com.tencent.mm.sdk.b.c() {};
      this.ktc = paramc;
      AppMethodBeat.o(198674);
    }
    
    public final void BJ()
    {
      AppMethodBeat.i(145746);
      if (this.ktc == null)
      {
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145746);
        return;
      }
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.kwC });
      if (bt.isNullOrNil(this.kwC))
      {
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(145746);
        return;
      }
      new l.b().h(this.ktc).Pi(this.kwC).a(c.kvZ.Pk(this.appId).Pq(this.kxa));
      AppMethodBeat.o(145746);
    }
    
    public final void Ox()
    {
      AppMethodBeat.i(145745);
      ad.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.Sn(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.kxb);
      AppMethodBeat.o(145745);
    }
  }
  
  static final class c
    extends a
  {
    public String appId = "";
    public String dca = "";
    public String dce = "";
    public int ddx = 0;
    public boolean error = false;
    public boolean hLF = false;
    public double hLH;
    public double hLI;
    public long hLK;
    public long hLL;
    public String hLQ = null;
    public String hLR = null;
    public String iFQ;
    public int kje;
    private m kry;
    public com.tencent.mm.plugin.appbrand.jsapi.c ktc;
    public WxaPkg.Info kwr;
    public boolean loop = false;
    public String processName = "";
    
    public c(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.kry = paramm;
      this.ktc = paramc;
      this.kje = paramInt;
    }
    
    public final void BJ()
    {
      AppMethodBeat.i(145748);
      super.BJ();
      if (this.ktc == null)
      {
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145748);
        return;
      }
      if (this.error)
      {
        this.ktc.h(this.kje, this.kry.e("fail:" + this.iFQ, null));
        AppMethodBeat.o(145748);
        return;
      }
      this.ktc.h(this.kje, this.kry.e("ok", null));
      AppMethodBeat.o(145748);
    }
    
    public final void Ox()
    {
      AppMethodBeat.i(145747);
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.iFQ = "";
      Object localObject1 = com.tencent.mm.aj.c.CI(this.dce);
      b localb = new b();
      localb.dce = this.dce;
      localb.ddp = this.dca;
      localb.ddx = this.ddx;
      localb.hLE = this.ddx;
      localb.hLF = this.hLF;
      localb.loop = this.loop;
      localb.processName = this.processName;
      localb.hLH = this.hLH;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.hLI = this.hLI;
      localb.hLM = this.hLK;
      localb.hLN = this.hLL;
      localb.hLQ = this.hLQ;
      localb.hLR = this.hLR;
      if ((localObject1 != null) && (this.dca.equalsIgnoreCase(((b)localObject1).ddp)) && (com.tencent.mm.aj.c.CH(this.dce)))
      {
        ad.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        ad.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.dce, localb.ddp });
        localObject1 = new v();
        ((v)localObject1).dky.action = 18;
        ((v)localObject1).dky.dce = localb.dce;
        ((v)localObject1).dky.dkB = localb;
        com.tencent.mm.plugin.music.b.a.a((v)localObject1);
        if (!((v)localObject1).dkz.result)
        {
          this.error = true;
          this.iFQ = "not to set audio param, the audioId is err";
          ad.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        BJ();
        AppMethodBeat.o(145747);
        return;
      }
      ad.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.dce, this.dca, Integer.valueOf(this.ddx) });
      if (this.dca.startsWith("file://"))
      {
        localb.filePath = this.dca.substring(7);
        ad.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
      }
      while ((this.dca.startsWith("http://")) || (this.dca.startsWith("https://")))
      {
        if (!this.error)
        {
          ad.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { localb.dce });
          localObject1 = new v();
          ((v)localObject1).dky.action = 0;
          ((v)localObject1).dky.dce = localb.dce;
          ((v)localObject1).dky.dkB = localb;
          com.tencent.mm.plugin.music.b.a.a((v)localObject1);
        }
        BJ();
        AppMethodBeat.o(145747);
        return;
      }
      com.tencent.mm.aj.e locale = f.c(this.kwr);
      if ((locale == null) || (!locale.isOpen()))
      {
        org.apache.commons.a.e.closeQuietly(locale);
        this.error = true;
        this.iFQ = "the file not exist for src";
        ad.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.dca });
        BJ();
        AppMethodBeat.o(145747);
        return;
      }
      if ((localObject1 != null) && (this.dca.equalsIgnoreCase(((b)localObject1).ddp)) && (!TextUtils.isEmpty(((b)localObject1).filePath))) {
        localObject1 = ((b)localObject1).filePath;
      }
      for (;;)
      {
        localb.filePath = ((String)localObject1);
        localb.hLS = locale;
        break;
        Object localObject2 = this.ktc;
        localObject1 = this.dca;
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.e("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
        }
        else if (((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).Fg() == null)
        {
          ad.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).Fg().Mj((String)localObject1);
          if ((localObject2 == null) || (!((com.tencent.mm.vfs.e)localObject2).exists()))
          {
            ad.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
          }
          else
          {
            localObject1 = q.B(((com.tencent.mm.vfs.e)localObject2).fOK());
            ad.i("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { localObject1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l
 * JD-Core Version:    0.7.0.1
 */