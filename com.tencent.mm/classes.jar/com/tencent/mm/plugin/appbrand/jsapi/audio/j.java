package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.e;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.b;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.json.JSONObject;

public class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a hBQ;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137768);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.Dx(paramc.getAppId()))
    {
      ab.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, j("fail:App is paused or background", null));
      AppMethodBeat.o(137768);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(137768);
      return;
    }
    ab.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[] { paramJSONObject.toString() });
    String str = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("startTime", 0);
    Object localObject1 = paramJSONObject.optString("src");
    boolean bool1;
    boolean bool2;
    double d;
    Object localObject2;
    Object localObject3;
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
      localObject1 = "";
      bool1 = paramJSONObject.optBoolean("autoplay", false);
      bool2 = paramJSONObject.optBoolean("loop", false);
      d = paramJSONObject.optDouble("volume", 1.0D);
      Long localLong2 = Long.valueOf(paramJSONObject.optLong("timestamp", 0L));
      localObject4 = Long.valueOf(0L);
      Long localLong1 = Long.valueOf(System.currentTimeMillis());
      if (!bool1) {
        break label445;
      }
      localObject2 = localLong1;
      localObject3 = localObject4;
      if (localLong2.longValue() > 0L)
      {
        localObject2 = localLong1;
        localObject3 = localObject4;
        if (localLong2.longValue() <= localLong1.longValue())
        {
          localObject3 = Long.valueOf(localLong1.longValue() - localLong2.longValue());
          localObject2 = localLong1;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        break label458;
      }
      ab.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramc.h(paramInt, j("fail:audioId is empty", null));
      AppMethodBeat.o(137768);
      return;
      if (((String)localObject1).startsWith("wxfile://"))
      {
        if (paramc.wX() == null)
        {
          ab.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramc.wX().zg((String)localObject1);
        if ((localObject1 == null) || (!((File)localObject1).exists()))
        {
          ab.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = ((File)localObject1).getAbsolutePath();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("file://")) {
            localObject1 = "file://".concat(String.valueOf(localObject2));
          }
        }
        ab.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
        break;
      }
      ab.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
      break;
      label445:
      localObject2 = Long.valueOf(0L);
      localObject3 = localObject4;
    }
    label458:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ab.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramc.h(paramInt, j("fail:src is empty", null));
      AppMethodBeat.o(137768);
      return;
    }
    if (this.hBQ == null) {
      this.hBQ = new a(this, paramc, paramInt);
    }
    this.hBQ.appId = paramc.getAppId();
    this.hBQ.aBL();
    Object localObject4 = new c(this, paramc, paramInt);
    ((c)localObject4).appId = paramc.getAppId();
    ((c)localObject4).ceu = str;
    ((c)localObject4).ceq = ((String)localObject1);
    ((c)localObject4).startTime = i;
    ((c)localObject4).fqX = bool1;
    ((c)localObject4).fqY = bool2;
    ((c)localObject4).gUy = f(paramc, (String)localObject1);
    ((c)localObject4).fra = d;
    ((c)localObject4).processName = ah.getProcessName();
    ((c)localObject4).frc = ((Long)localObject3).longValue();
    ((c)localObject4).frd = ((Long)localObject2).longValue();
    ((c)localObject4).aBL();
    paramc = new com.tencent.mm.plugin.appbrand.media.a.c();
    paramc.gUy = ((c)localObject4).gUy;
    paramc.hBS = paramJSONObject.toString();
    paramc.ceq = ((String)localObject1);
    com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramc);
    AppMethodBeat.o(137768);
  }
  
  public String f(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    return "";
  }
  
  public static final class a
    extends a
  {
    public int action;
    public String appId;
    private com.tencent.mm.sdk.b.c hCB;
    public String hCd;
    public int hry;
    private m hxs;
    public com.tencent.mm.plugin.appbrand.jsapi.c hyO;
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      AppMethodBeat.i(137763);
      this.appId = "";
      this.hCB = new j.a.1(this);
      this.hxs = paramm;
      this.hyO = paramc;
      this.hry = paramInt;
      AppMethodBeat.o(137763);
    }
    
    public final void Dh()
    {
      AppMethodBeat.i(137764);
      ab.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.Dw(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.hCB);
      AppMethodBeat.o(137764);
    }
    
    public final void tU()
    {
      AppMethodBeat.i(137765);
      if (this.hyO == null)
      {
        ab.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(137765);
        return;
      }
      ab.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.hCd });
      if (bo.isNullOrNil(this.hCd))
      {
        ab.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(137765);
        return;
      }
      new j.b().j(this.hyO).BN(this.hCd).aBz();
      AppMethodBeat.o(137765);
    }
  }
  
  static final class c
    extends a
  {
    public String appId = "";
    public String ceq = "";
    public String ceu = "";
    public boolean error = false;
    public boolean fqX = false;
    public boolean fqY = false;
    public double fra;
    public long frc;
    public long frd;
    public String gUy;
    public String hBF;
    public int hry;
    private m hxs;
    public com.tencent.mm.plugin.appbrand.jsapi.c hyO;
    public String processName = "";
    public int startTime = 0;
    
    public c(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.hxs = paramm;
      this.hyO = paramc;
      this.hry = paramInt;
    }
    
    public final void Dh()
    {
      AppMethodBeat.i(137766);
      ab.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.hBF = "";
      Object localObject1 = com.tencent.mm.ag.c.qJ(this.ceu);
      b localb = new b();
      localb.ceu = this.ceu;
      localb.cfG = this.ceq;
      localb.startTime = this.startTime;
      localb.fqW = this.startTime;
      localb.fqX = this.fqX;
      localb.fqY = this.fqY;
      localb.processName = this.processName;
      localb.fra = this.fra;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.fre = this.frc;
      localb.frf = this.frd;
      if ((localObject1 != null) && (this.ceq.equalsIgnoreCase(((b)localObject1).cfG)) && (com.tencent.mm.ag.c.qI(this.ceu)))
      {
        ab.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        ab.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.ceu, localb.cfG });
        localObject1 = new s();
        ((s)localObject1).cmS.action = 18;
        ((s)localObject1).cmS.ceu = localb.ceu;
        ((s)localObject1).cmS.cmV = localb;
        com.tencent.mm.plugin.music.b.a.a((s)localObject1);
        if (!((s)localObject1).cmT.cmX)
        {
          this.error = true;
          this.hBF = "not to set audio param, the audioId is err";
          ab.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        tU();
        AppMethodBeat.o(137766);
        return;
      }
      ab.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.ceu, this.ceq, Integer.valueOf(this.startTime) });
      if (this.ceq.startsWith("file://"))
      {
        localb.filePath = this.ceq.substring(7);
        ab.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
      }
      while ((this.ceq.startsWith("http://")) || (this.ceq.startsWith("https://")))
      {
        if (!this.error)
        {
          ab.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { localb.ceu });
          localObject1 = new s();
          ((s)localObject1).cmS.action = 0;
          ((s)localObject1).cmS.ceu = localb.ceu;
          ((s)localObject1).cmS.cmV = localb;
          com.tencent.mm.plugin.music.b.a.a((s)localObject1);
        }
        tU();
        AppMethodBeat.o(137766);
        return;
      }
      e locale = f.cG(this.ceq, this.gUy);
      if (!locale.isOpen())
      {
        this.error = true;
        this.hBF = "the file not exist for src";
        ab.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.ceq });
        tU();
        AppMethodBeat.o(137766);
        return;
      }
      if ((localObject1 != null) && (this.ceq.equalsIgnoreCase(((b)localObject1).cfG)) && (!TextUtils.isEmpty(((b)localObject1).filePath))) {
        localObject1 = ((b)localObject1).filePath;
      }
      for (;;)
      {
        localb.filePath = ((String)localObject1);
        localb.fri = locale;
        break;
        Object localObject2 = this.hyO;
        localObject1 = this.ceq;
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.e("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
        }
        else if (((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).wX() == null)
        {
          ab.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
        }
        else
        {
          localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2).wX().zg((String)localObject1);
          if ((localObject2 == null) || (!((File)localObject2).exists()))
          {
            ab.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
          }
          else
          {
            localObject1 = ((File)localObject2).getAbsolutePath();
            ab.i("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { localObject1 });
          }
        }
      }
    }
    
    public final void tU()
    {
      AppMethodBeat.i(137767);
      super.tU();
      if (this.hyO == null)
      {
        ab.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(137767);
        return;
      }
      if (this.error)
      {
        this.hyO.h(this.hry, this.hxs.j("fail:" + this.hBF, null));
        AppMethodBeat.o(137767);
        return;
      }
      this.hyO.h(this.hry, this.hxs.j("ok", null));
      AppMethodBeat.o(137767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j
 * JD-Core Version:    0.7.0.1
 */