package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a kbP;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145749);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.OL(paramc.getAppId()))
    {
      ac.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, e("fail:App is paused or background", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145749);
      return;
    }
    ac.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[] { paramJSONObject.toString() });
    String str = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("startTime", 0);
    Object localObject1 = paramJSONObject.optString("src");
    boolean bool1;
    boolean bool2;
    double d3;
    double d1;
    Object localObject2;
    Object localObject3;
    if (bs.isNullOrNil((String)localObject1))
    {
      ac.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
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
      ac.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145749);
      return;
      if (((String)localObject1).startsWith("wxfile://"))
      {
        if (paramc.DH() == null)
        {
          ac.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramc.DH().IS((String)localObject1);
        if ((localObject1 == null) || (!((com.tencent.mm.vfs.e)localObject1).exists()))
        {
          ac.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("file://")) {
            localObject1 = "file://".concat(String.valueOf(localObject2));
          }
        }
        ac.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
        break;
      }
      ac.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
      break;
      label482:
      localObject2 = Long.valueOf(0L);
      localObject3 = localObject4;
    }
    label495:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ac.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramc.h(paramInt, e("fail:src is empty", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (this.kbP == null) {
      this.kbP = new a(this, paramc, paramInt);
    }
    this.kbP.appId = paramc.getAppId();
    this.kbP.aLt();
    Object localObject4 = new c(this, paramc, paramInt);
    ((c)localObject4).appId = paramc.getAppId();
    ((c)localObject4).cQO = str;
    ((c)localObject4).cQK = ((String)localObject1);
    ((c)localObject4).cSh = i;
    ((c)localObject4).htn = bool1;
    ((c)localObject4).loop = bool2;
    ((c)localObject4).kbS = e(paramc, (String)localObject1);
    ((c)localObject4).htp = d3;
    ((c)localObject4).htq = d1;
    ((c)localObject4).processName = ai.getProcessName();
    ((c)localObject4).hts = ((Long)localObject3).longValue();
    ((c)localObject4).htt = ((Long)localObject2).longValue();
    Object localObject6 = (com.tencent.mm.plugin.appbrand.jsapi.p.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.p.a.class);
    if (localObject6 == null)
    {
      ac.w("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerHelper is null");
      paramc = new Pair(null, "invalidReferrer");
      ((c)localObject4).hty = ((String)paramc.first);
      ((c)localObject4).htz = ((String)paramc.second);
      ((c)localObject4).aLt();
      paramc = new com.tencent.mm.plugin.appbrand.media.a.c();
      paramc.kbS = ((c)localObject4).kbS;
      paramc.kbR = paramJSONObject.toString();
      paramc.cQK = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramc);
      AppMethodBeat.o(145749);
      return;
    }
    Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject6).U(paramJSONObject);
    if (localObject5 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject6).MX((String)localObject5);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject6).x(paramc);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ == localObject2) {
        paramc = null;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.Audio.JsApiSetAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { localObject5, paramc });
      paramc = new Pair(localObject5, paramc);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.p.c.kII == localObject2) {
        paramc = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject6).y(paramc);
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
    public int jOT;
    private m jXc;
    public com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    private com.tencent.mm.sdk.b.c kcB;
    public String kcd;
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      AppMethodBeat.i(145744);
      this.appId = "";
      this.kcB = new com.tencent.mm.sdk.b.c() {};
      this.jXc = paramm;
      this.jYG = paramc;
      this.jOT = paramInt;
      AppMethodBeat.o(145744);
    }
    
    public final void Am()
    {
      AppMethodBeat.i(145746);
      if (this.jYG == null)
      {
        ac.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145746);
        return;
      }
      ac.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.kcd });
      if (bs.isNullOrNil(this.kcd))
      {
        ac.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(145746);
        return;
      }
      new k.b().h(this.jYG).LO(this.kcd).beN();
      AppMethodBeat.o(145746);
    }
    
    public final void MO()
    {
      AppMethodBeat.i(145745);
      ac.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.OK(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.kcB);
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
    public String cQK = "";
    public String cQO = "";
    public int cSh = 0;
    public boolean error = false;
    public boolean htn = false;
    public double htp;
    public double htq;
    public long hts;
    public long htt;
    public String hty = null;
    public String htz = null;
    public String imz;
    public int jOT;
    private m jXc;
    public com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    public WxaPkg.Info kbS;
    public boolean loop = false;
    public String processName = "";
    
    public c(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.jXc = paramm;
      this.jYG = paramc;
      this.jOT = paramInt;
    }
    
    public final void Am()
    {
      AppMethodBeat.i(145748);
      super.Am();
      if (this.jYG == null)
      {
        ac.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145748);
        return;
      }
      if (this.error)
      {
        this.jYG.h(this.jOT, this.jXc.e("fail:" + this.imz, null));
        AppMethodBeat.o(145748);
        return;
      }
      this.jYG.h(this.jOT, this.jXc.e("ok", null));
      AppMethodBeat.o(145748);
    }
    
    public final void MO()
    {
      AppMethodBeat.i(145747);
      ac.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.imz = "";
      Object localObject1 = com.tencent.mm.ai.c.zJ(this.cQO);
      b localb = new b();
      localb.cQO = this.cQO;
      localb.cRZ = this.cQK;
      localb.cSh = this.cSh;
      localb.htm = this.cSh;
      localb.htn = this.htn;
      localb.loop = this.loop;
      localb.processName = this.processName;
      localb.htp = this.htp;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.htq = this.htq;
      localb.htu = this.hts;
      localb.htv = this.htt;
      localb.hty = this.hty;
      localb.htz = this.htz;
      if ((localObject1 != null) && (this.cQK.equalsIgnoreCase(((b)localObject1).cRZ)) && (com.tencent.mm.ai.c.zI(this.cQO)))
      {
        ac.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        ac.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.cQO, localb.cRZ });
        localObject1 = new v();
        ((v)localObject1).cZg.action = 18;
        ((v)localObject1).cZg.cQO = localb.cQO;
        ((v)localObject1).cZg.cZj = localb;
        com.tencent.mm.plugin.music.b.a.a((v)localObject1);
        if (!((v)localObject1).cZh.result)
        {
          this.error = true;
          this.imz = "not to set audio param, the audioId is err";
          ac.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        Am();
        AppMethodBeat.o(145747);
        return;
      }
      ac.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.cQO, this.cQK, Integer.valueOf(this.cSh) });
      if (this.cQK.startsWith("file://"))
      {
        localb.filePath = this.cQK.substring(7);
        ac.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
      }
      while ((this.cQK.startsWith("http://")) || (this.cQK.startsWith("https://")))
      {
        if (!this.error)
        {
          ac.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { localb.cQO });
          localObject1 = new v();
          ((v)localObject1).cZg.action = 0;
          ((v)localObject1).cZg.cQO = localb.cQO;
          ((v)localObject1).cZg.cZj = localb;
          com.tencent.mm.plugin.music.b.a.a((v)localObject1);
        }
        Am();
        AppMethodBeat.o(145747);
        return;
      }
      com.tencent.mm.ai.e locale = f.c(this.kbS);
      if ((locale == null) || (!locale.isOpen()))
      {
        org.apache.commons.a.e.closeQuietly(locale);
        this.error = true;
        this.imz = "the file not exist for src";
        ac.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.cQK });
        Am();
        AppMethodBeat.o(145747);
        return;
      }
      if ((localObject1 != null) && (this.cQK.equalsIgnoreCase(((b)localObject1).cRZ)) && (!TextUtils.isEmpty(((b)localObject1).filePath))) {
        localObject1 = ((b)localObject1).filePath;
      }
      for (;;)
      {
        localb.filePath = ((String)localObject1);
        localb.htA = locale;
        break;
        Object localObject2 = this.jYG;
        localObject1 = this.cQK;
        if (bs.isNullOrNil((String)localObject1))
        {
          ac.e("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
        }
        else if (((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).DH() == null)
        {
          ac.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).DH().IS((String)localObject1);
          if ((localObject2 == null) || (!((com.tencent.mm.vfs.e)localObject2).exists()))
          {
            ac.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
          }
          else
          {
            localObject1 = q.B(((com.tencent.mm.vfs.e)localObject2).fxV());
            ac.i("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { localObject1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k
 * JD-Core Version:    0.7.0.1
 */