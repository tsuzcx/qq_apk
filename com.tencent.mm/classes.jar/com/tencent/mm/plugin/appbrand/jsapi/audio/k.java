package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.af.b;
import com.tencent.mm.af.e;
import com.tencent.mm.h.a.s;
import com.tencent.mm.h.a.s.b;
import com.tencent.mm.h.a.t;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private k.a gix;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!com.tencent.mm.plugin.appbrand.media.a.a.vb(paramc.getAppId()))
    {
      y.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramc.C(paramInt, h("fail:App is paused or background", null));
      return;
    }
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    y.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[] { paramJSONObject.toString() });
    String str = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("startTime", 0);
    Object localObject1 = paramJSONObject.optString("src");
    boolean bool1;
    boolean bool2;
    double d;
    Long localLong;
    Object localObject2;
    if (bk.bl((String)localObject1))
    {
      y.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
      localObject1 = "";
      bool1 = paramJSONObject.optBoolean("autoplay", false);
      bool2 = paramJSONObject.optBoolean("loop", false);
      d = paramJSONObject.optDouble("volume", 1.0D);
      localObject3 = Long.valueOf(paramJSONObject.optLong("timestamp", 0L));
      localLong = Long.valueOf(0L);
      localObject2 = Long.valueOf(System.currentTimeMillis());
      if (!bool1) {
        break label447;
      }
      if ((((Long)localObject3).longValue() <= 0L) || (((Long)localObject3).longValue() >= ((Long)localObject2).longValue())) {
        break label438;
      }
      localLong = Long.valueOf(((Long)localObject2).longValue() - ((Long)localObject3).longValue());
    }
    for (;;)
    {
      y.d("MicroMsg.Audio.JsApiSetAudioState", "leonlaudio setAudioState jsCallTime:%s jsInvokeTime:%s,invokeCallTime:%s", new Object[] { localObject3, localLong, localObject2 });
      if (!TextUtils.isEmpty(str)) {
        break label456;
      }
      y.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramc.C(paramInt, h("fail:audioId is empty", null));
      return;
      if (((String)localObject1).startsWith("wxfile://"))
      {
        if (paramc.Zl() == null)
        {
          y.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = paramc.Zl().rx((String)localObject1);
        if ((localObject1 == null) || (!((File)localObject1).exists()))
        {
          y.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = ((File)localObject1).getAbsolutePath();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("file://")) {
            localObject1 = "file://" + (String)localObject2;
          }
        }
        y.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
        break;
      }
      y.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { localObject1 });
      break;
      label438:
      localObject2 = Long.valueOf(0L);
      continue;
      label447:
      localObject2 = Long.valueOf(0L);
    }
    label456:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      y.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramc.C(paramInt, h("fail:src is empty", null));
      return;
    }
    if (this.gix == null) {
      this.gix = new k.a(this, paramc, paramInt);
    }
    this.gix.appId = paramc.getAppId();
    this.gix.ahU();
    Object localObject3 = new c(this, paramc, paramInt);
    ((c)localObject3).appId = paramc.getAppId();
    ((c)localObject3).bFM = str;
    ((c)localObject3).eaY = ((String)localObject1);
    ((c)localObject3).startTime = i;
    ((c)localObject3).eaO = bool1;
    ((c)localObject3).eaP = bool2;
    ((c)localObject3).fCl = f(paramc, (String)localObject1);
    ((c)localObject3).eaR = d;
    ((c)localObject3).processName = ae.getProcessName();
    ((c)localObject3).eaT = localLong.longValue();
    ((c)localObject3).eaU = ((Long)localObject2).longValue();
    ((c)localObject3).ahU();
    paramc = new com.tencent.mm.plugin.appbrand.media.a.c();
    paramc.fCl = ((c)localObject3).fCl;
    paramc.giz = paramJSONObject.toString();
    paramc.eaY = ((String)localObject1);
    com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramc);
  }
  
  public String f(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    return "";
  }
  
  public static final class b
    extends ac
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAudioStateChange";
  }
  
  private static final class c
    extends a
  {
    public String appId = "";
    public String bFM = "";
    public boolean eaO = false;
    public boolean eaP = false;
    public double eaR;
    public long eaT;
    public long eaU;
    public String eaY = "";
    public boolean error = false;
    public String fCl;
    private i gfG;
    public int gfg;
    public com.tencent.mm.plugin.appbrand.jsapi.c ggu;
    public String gio;
    public String processName = "";
    public int startTime = 0;
    
    public c(i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.gfG = parami;
      this.ggu = paramc;
      this.gfg = paramInt;
    }
    
    public final void ahX()
    {
      y.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.gio = "";
      Object localObject = com.tencent.mm.af.c.jQ(this.bFM);
      b localb = new b();
      localb.bFM = this.bFM;
      localb.ceM = this.eaY;
      localb.startTime = this.startTime;
      localb.eaN = this.startTime;
      localb.eaO = this.eaO;
      localb.eaP = this.eaP;
      localb.processName = this.processName;
      localb.eaR = this.eaR;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.eaT = this.eaT;
      localb.eaU = this.eaU;
      if ((localObject != null) && (this.eaY.equalsIgnoreCase(((b)localObject).ceM)) && (com.tencent.mm.af.c.jP(this.bFM)))
      {
        y.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        y.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.bFM, localb.ceM });
        localObject = new s();
        ((s)localObject).bFK.action = 18;
        ((s)localObject).bFK.bFM = localb.bFM;
        ((s)localObject).bFK.bFO = localb;
        com.tencent.mm.plugin.music.b.a.a((s)localObject);
        if (!((s)localObject).bFL.bFQ)
        {
          this.error = true;
          this.gio = "not to set audio param, the audioId is err";
          y.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        pQ();
        return;
      }
      y.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.bFM, this.eaY, Integer.valueOf(this.startTime) });
      if (this.eaY.startsWith("file://"))
      {
        localb.filePath = this.eaY.substring(7);
        y.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
      }
      for (;;)
      {
        pQ();
        if (this.error) {
          break;
        }
        y.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { localb.bFM });
        localObject = new s();
        ((s)localObject).bFK.action = 0;
        ((s)localObject).bFK.bFM = localb.bFM;
        ((s)localObject).bFK.bFO = localb;
        com.tencent.mm.plugin.music.b.a.a((s)localObject);
        return;
        if ((!this.eaY.startsWith("http://")) && (!this.eaY.startsWith("https://")))
        {
          localObject = f.bR(this.eaY, this.fCl);
          if (!((e)localObject).isOpen())
          {
            this.error = true;
            this.gio = "the file not exist for src";
            y.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.eaY });
            pQ();
            return;
          }
          localb.filePath = this.eaY;
          localb.eaV = ((e)localObject);
        }
      }
    }
    
    public final void pQ()
    {
      super.pQ();
      if (this.ggu == null)
      {
        y.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        return;
      }
      if (this.error)
      {
        this.ggu.C(this.gfg, this.gfG.h("fail:" + this.gio, null));
        return;
      }
      this.ggu.C(this.gfg, this.gfG.h("ok", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k
 * JD-Core Version:    0.7.0.1
 */