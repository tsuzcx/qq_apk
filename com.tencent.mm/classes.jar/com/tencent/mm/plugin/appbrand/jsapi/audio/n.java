package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ab;
import com.tencent.mm.autogen.a.ab.b;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.a.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import org.apache.commons.b.d;
import org.json.JSONObject;

public class n
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a rDq;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145749);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.adB(paramf.getAppId()))
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramf.callback(paramInt, ZP("fail:App is paused or background"));
      AppMethodBeat.o(145749);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
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
        break label490;
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
        break label503;
      }
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramf.callback(paramInt, ZP("fail:audioId is empty"));
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
        localObject1 = paramf.getFileSystem().Wm((String)localObject1);
        if ((localObject1 == null) || (!((u)localObject1).jKS()))
        {
          Log.e("MicroMsg.Audio.WxaAudioUtils", "localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = ah.v(((u)localObject1).jKT());
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
      label490:
      localObject2 = Long.valueOf(0L);
      localObject3 = localObject4;
    }
    label503:
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramf.callback(paramInt, ZP("fail:src is empty"));
      AppMethodBeat.o(145749);
      return;
    }
    if (this.rDq == null) {
      this.rDq = new a(paramf);
    }
    this.rDq.appId = paramf.getAppId();
    this.rDq.bQt();
    Object localObject4 = new c(this, paramf, paramInt);
    ((c)localObject4).appId = paramf.getAppId();
    ((c)localObject4).hqQ = str;
    ((c)localObject4).hqM = ((String)localObject1);
    ((c)localObject4).startTime = i;
    ((c)localObject4).orj = bool1;
    ((c)localObject4).loop = bool2;
    ((c)localObject4).rDt = e(paramf, (String)localObject1);
    ((c)localObject4).orl = d3;
    ((c)localObject4).orm = d1;
    ((c)localObject4).processName = MMApplicationContext.getProcessName();
    ((c)localObject4).oro = ((Long)localObject3).longValue();
    ((c)localObject4).orp = ((Long)localObject2).longValue();
    Object localObject6 = (com.tencent.mm.plugin.appbrand.jsapi.y.a)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.y.a.class);
    if (localObject6 == null)
    {
      paramf = new Pair(null, "invalidReferrer");
      ((c)localObject4).oru = ((String)paramf.first);
      ((c)localObject4).orv = ((String)paramf.second);
      ((c)localObject4).bQt();
      paramf = new com.tencent.mm.plugin.appbrand.media.a.c();
      paramf.rDt = ((c)localObject4).rDt;
      paramf.rDs = paramJSONObject.toString();
      paramf.hqM = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.a.a.a(str, paramf);
      AppMethodBeat.o(145749);
      return;
    }
    Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.y.a)localObject6).at(paramJSONObject);
    if (localObject5 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.y.a)localObject6).abv((String)localObject5);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.y.a)localObject6).C(paramf);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.y.c.srt == localObject2) {
        paramf = null;
      }
    }
    for (;;)
    {
      paramf = new Pair(localObject5, paramf);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.y.c.srs == localObject2) {
        paramf = ((com.tencent.mm.plugin.appbrand.jsapi.y.a)localObject6).D(paramf);
      } else {
        paramf = "invalidReferrer";
      }
    }
  }
  
  public WxaPkg.Info e(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    return null;
  }
  
  public static final class a
    extends a
  {
    public int action;
    public String appId;
    public String rDE;
    private String rEc;
    private IListener rEd;
    public com.tencent.mm.plugin.appbrand.jsapi.f rzi;
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
    {
      AppMethodBeat.i(327780);
      this.appId = "";
      this.rEd = new JsApiSetAudioState.AudioPlayerEventListenerTask.1(this, com.tencent.mm.app.f.hfK);
      this.rzi = paramf;
      AppMethodBeat.o(327780);
    }
    
    public final void aFi()
    {
      AppMethodBeat.i(145745);
      Log.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.adA(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.rEd);
      AppMethodBeat.o(145745);
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145746);
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145746);
        return;
      }
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.rDE });
      if (Util.isNullOrNil(this.rDE))
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(145746);
        return;
      }
      n.b localb = new n.b();
      com.tencent.mm.plugin.appbrand.jsapi.base.a locala = c.rDb.ZX(this.appId);
      if ((locala != null) && (locala.aak(this.rEc) != null))
      {
        localb.i(this.rzi).ZR(this.rDE).b(locala.aak(this.rEc));
        AppMethodBeat.o(145746);
        return;
      }
      localb.i(this.rzi).ZR(this.rDE).cpV();
      AppMethodBeat.o(145746);
    }
  }
  
  static final class c
    extends a
  {
    public String appId = "";
    public boolean error = false;
    public String hqM = "";
    public String hqQ = "";
    public boolean loop = false;
    public boolean orj = false;
    public double orl;
    public double orm;
    public long oro;
    public long orp;
    public String oru = null;
    public String orv = null;
    public String ppp;
    public String processName = "";
    public WxaPkg.Info rDt;
    public int ror;
    private p rzh;
    public com.tencent.mm.plugin.appbrand.jsapi.f rzi;
    public int startTime = 0;
    
    public c(p paramp, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public final void aFi()
    {
      AppMethodBeat.i(145747);
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.ppp = "";
      Object localObject = com.tencent.mm.al.c.Lr(this.hqQ);
      com.tencent.mm.al.b localb = new com.tencent.mm.al.b();
      localb.hqQ = this.hqQ;
      localb.hsg = this.hqM;
      localb.startTime = this.startTime;
      localb.ori = this.startTime;
      localb.orj = this.orj;
      localb.loop = this.loop;
      localb.processName = this.processName;
      localb.orl = this.orl;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.orm = this.orm;
      localb.orq = this.oro;
      localb.orr = this.orp;
      localb.oru = this.oru;
      localb.orv = this.orv;
      if ((localObject != null) && (this.hqM.equalsIgnoreCase(((com.tencent.mm.al.b)localObject).hsg)) && (com.tencent.mm.al.c.Lq(this.hqQ)))
      {
        Log.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        Log.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.hqQ, localb.hsg });
        localObject = new ab();
        ((ab)localObject).hzS.action = 18;
        ((ab)localObject).hzS.hqQ = localb.hqQ;
        ((ab)localObject).hzS.hzU = localb;
        com.tencent.mm.plugin.music.b.b.a((ab)localObject);
        if (!((ab)localObject).hzT.result)
        {
          this.error = true;
          this.ppp = "not to set audio param, the audioId is err";
          Log.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        callback();
        AppMethodBeat.o(145747);
        return;
      }
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.hqQ, this.hqM, Integer.valueOf(this.startTime) });
      if (this.hqM.startsWith("file://"))
      {
        localb.filePath = this.hqM.substring(7);
        Log.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
      }
      do
      {
        for (;;)
        {
          if (!this.error) {
            com.tencent.mm.al.c.l(localb);
          }
          callback();
          AppMethodBeat.o(145747);
          return;
          if ((this.hqM.contains("base64")) && (this.hqM.startsWith("data:audio")))
          {
            localb.filePath = g.acs(this.hqM.substring(this.hqM.indexOf("base64,") + 7).trim());
            Log.i("MicroMsg.Audio.JsApiSetAudioState", "base64 decode filePath:%s", new Object[] { localb.filePath });
          }
          else
          {
            if (!this.hqM.startsWith("wxblob://")) {
              break;
            }
            localObject = new k();
            if (this.rzi.getFileSystem().b(this.hqM, (k)localObject) == r.qML)
            {
              localb.orz = ((ByteBuffer)((k)localObject).value);
              localb.filePath = this.hqM;
              Log.i("MicroMsg.Audio.JsApiSetAudioState", "wxblob read ok");
            }
            else
            {
              Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob read fail");
              localObject = this.rzi.getFileSystem().Wj(this.hqM);
              if ((localObject == null) || (!((u)localObject).jKS()))
              {
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob localFile is null");
                this.error = true;
                this.ppp = "wxblob localFile is null";
              }
              else
              {
                localb.filePath = ah.v(((u)localObject).jKT());
              }
            }
          }
        }
      } while ((this.hqM.startsWith("http://")) || (this.hqM.startsWith("https://")));
      com.tencent.mm.al.e locale = com.tencent.mm.plugin.appbrand.media.a.f.c(this.rDt);
      if ((locale == null) || (!locale.isOpen()))
      {
        d.closeQuietly(locale);
        this.error = true;
        this.ppp = "the file not exist for src";
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.hqM });
        callback();
        AppMethodBeat.o(145747);
        return;
      }
      if ((localObject != null) && (this.hqM.equalsIgnoreCase(((com.tencent.mm.al.b)localObject).hsg)) && (!TextUtils.isEmpty(((com.tencent.mm.al.b)localObject).filePath))) {}
      for (localb.filePath = ((com.tencent.mm.al.b)localObject).filePath;; localb.filePath = g.k(this.rzi, this.hqM))
      {
        localb.orw = locale;
        break;
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145748);
      super.callback();
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145748);
        return;
      }
      if (this.error)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail:" + this.ppp));
        AppMethodBeat.o(145748);
        return;
      }
      this.rzi.callback(this.ror, this.rzh.ZP("ok"));
      AppMethodBeat.o(145748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.n
 * JD-Core Version:    0.7.0.1
 */