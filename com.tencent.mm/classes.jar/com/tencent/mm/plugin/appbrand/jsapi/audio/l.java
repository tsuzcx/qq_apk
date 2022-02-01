package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.a.y.b;
import com.tencent.mm.f.a.z;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.plugin.appbrand.media.a.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import org.apache.commons.a.d;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private a ozx;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145749);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.akv(parame.getAppId()))
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      parame.j(paramInt, h("fail:App is paused or background", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      parame.j(paramInt, h("fail:data is null", null));
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
      parame.j(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(145749);
      return;
      if (((String)localObject1).startsWith("wxfile://"))
      {
        if (parame.getFileSystem() == null)
        {
          Log.e("MicroMsg.Audio.WxaAudioUtils", "getFileSystem() is null");
          localObject1 = "";
          break;
        }
        localObject1 = parame.getFileSystem().adL((String)localObject1);
        if ((localObject1 == null) || (!((q)localObject1).ifE()))
        {
          Log.e("MicroMsg.Audio.WxaAudioUtils", "localFile is null");
          localObject1 = "";
          break;
        }
        localObject2 = ((q)localObject1).bOF();
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
      parame.j(paramInt, h("fail:src is empty", null));
      AppMethodBeat.o(145749);
      return;
    }
    if (this.ozx == null) {
      this.ozx = new a(parame);
    }
    this.ozx.appId = parame.getAppId();
    this.ozx.bsM();
    Object localObject4 = new c(this, parame, paramInt);
    ((c)localObject4).appId = parame.getAppId();
    ((c)localObject4).fmF = str;
    ((c)localObject4).fmB = ((String)localObject1);
    ((c)localObject4).fod = i;
    ((c)localObject4).lzI = bool1;
    ((c)localObject4).loop = bool2;
    ((c)localObject4).ozA = e(parame, (String)localObject1);
    ((c)localObject4).lzK = d3;
    ((c)localObject4).lzL = d1;
    ((c)localObject4).processName = MMApplicationContext.getProcessName();
    ((c)localObject4).lzN = ((Long)localObject3).longValue();
    ((c)localObject4).lzO = ((Long)localObject2).longValue();
    Object localObject6 = (com.tencent.mm.plugin.appbrand.jsapi.v.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.v.a.class);
    if (localObject6 == null)
    {
      parame = new Pair(null, "invalidReferrer");
      ((c)localObject4).lzT = ((String)parame.first);
      ((c)localObject4).lzU = ((String)parame.second);
      ((c)localObject4).bsM();
      parame = new com.tencent.mm.plugin.appbrand.media.a.c();
      parame.ozA = ((c)localObject4).ozA;
      parame.ozz = paramJSONObject.toString();
      parame.fmB = ((String)localObject1);
      com.tencent.mm.plugin.appbrand.media.a.a.a(str, parame);
      AppMethodBeat.o(145749);
      return;
    }
    Object localObject5 = ((com.tencent.mm.plugin.appbrand.jsapi.v.a)localObject6).aj(paramJSONObject);
    if (localObject5 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.v.a)localObject6).aix((String)localObject5);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.v.a)localObject6).A(parame);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.v.c.pmz == localObject2) {
        parame = null;
      }
    }
    for (;;)
    {
      parame = new Pair(localObject5, parame);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.v.c.pmy == localObject2) {
        parame = ((com.tencent.mm.plugin.appbrand.jsapi.v.a)localObject6).B(parame);
      } else {
        parame = "invalidReferrer";
      }
    }
  }
  
  public WxaPkg.Info e(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString)
  {
    return null;
  }
  
  public static final class a
    extends a
  {
    public int action;
    public String appId;
    private String oAj;
    private IListener oAk;
    public com.tencent.mm.plugin.appbrand.jsapi.e ovO;
    public String ozL;
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.e parame)
    {
      AppMethodBeat.i(226280);
      this.appId = "";
      this.oAk = new IListener() {};
      this.ovO = parame;
      AppMethodBeat.o(226280);
    }
    
    public final void adj()
    {
      AppMethodBeat.i(145745);
      Log.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
      com.tencent.mm.plugin.appbrand.media.a.a.aku(this.appId);
      com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.oAk);
      AppMethodBeat.o(145745);
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145746);
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145746);
        return;
      }
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.ozL });
      if (Util.isNullOrNil(this.ozL))
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
        AppMethodBeat.o(145746);
        return;
      }
      l.b localb = new l.b();
      com.tencent.mm.plugin.appbrand.jsapi.base.a locala = c.ozj.agZ(this.appId);
      if ((locala != null) && (locala.ahn(this.oAj) != null))
      {
        localb.j(this.ovO).agU(this.ozL).b(locala.ahn(this.oAj));
        AppMethodBeat.o(145746);
        return;
      }
      localb.j(this.ovO).agU(this.ozL).bPO();
      AppMethodBeat.o(145746);
    }
  }
  
  public static final class b
    extends az
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAudioStateChange";
  }
  
  static final class c
    extends a
  {
    public String appId = "";
    public boolean error = false;
    public String fmB = "";
    public String fmF = "";
    public int fod = 0;
    public boolean loop = false;
    public boolean lzI = false;
    public double lzK;
    public double lzL;
    public long lzN;
    public long lzO;
    public String lzT = null;
    public String lzU = null;
    public String mvQ;
    public int okO;
    private o ovN;
    public com.tencent.mm.plugin.appbrand.jsapi.e ovO;
    public WxaPkg.Info ozA;
    public String processName = "";
    
    public c(o paramo, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      this.ovN = paramo;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void adj()
    {
      AppMethodBeat.i(145747);
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
      this.error = false;
      this.mvQ = "";
      Object localObject = com.tencent.mm.al.c.Tp(this.fmF);
      com.tencent.mm.al.b localb = new com.tencent.mm.al.b();
      localb.fmF = this.fmF;
      localb.fnV = this.fmB;
      localb.fod = this.fod;
      localb.lzH = this.fod;
      localb.lzI = this.lzI;
      localb.loop = this.loop;
      localb.processName = this.processName;
      localb.lzK = this.lzK;
      localb.appId = this.appId;
      localb.fromScene = 0;
      localb.lzL = this.lzL;
      localb.lzP = this.lzN;
      localb.lzQ = this.lzO;
      localb.lzT = this.lzT;
      localb.lzU = this.lzU;
      if ((localObject != null) && (this.fmB.equalsIgnoreCase(((com.tencent.mm.al.b)localObject).fnV)) && (com.tencent.mm.al.c.To(this.fmF)))
      {
        Log.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
        Log.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.fmF, localb.fnV });
        localObject = new y();
        ((y)localObject).fvx.action = 18;
        ((y)localObject).fvx.fmF = localb.fmF;
        ((y)localObject).fvx.fvz = localb;
        com.tencent.mm.plugin.music.b.b.a((y)localObject);
        if (!((y)localObject).fvy.result)
        {
          this.error = true;
          this.mvQ = "not to set audio param, the audioId is err";
          Log.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
        }
        callback();
        AppMethodBeat.o(145747);
        return;
      }
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.fmF, this.fmB, Integer.valueOf(this.fod) });
      if (this.fmB.startsWith("file://"))
      {
        localb.filePath = this.fmB.substring(7);
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
          if ((this.fmB.contains("base64")) && (this.fmB.startsWith("data:audio")))
          {
            localb.filePath = g.ajr(this.fmB.substring(this.fmB.indexOf("base64,") + 7).trim());
            Log.i("MicroMsg.Audio.JsApiSetAudioState", "base64 decode filePath:%s", new Object[] { localb.filePath });
          }
          else
          {
            if (!this.fmB.startsWith("wxblob://")) {
              break;
            }
            localObject = new i();
            if (this.ovO.getFileSystem().b(this.fmB, (i)localObject) == m.nMR)
            {
              localb.lzY = ((ByteBuffer)((i)localObject).value);
              localb.filePath = this.fmB;
              Log.i("MicroMsg.Audio.JsApiSetAudioState", "wxblob read ok");
            }
            else
            {
              Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob read fail");
              localObject = this.ovO.getFileSystem().adI(this.fmB);
              if ((localObject == null) || (!((q)localObject).ifE()))
              {
                Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob localFile is null");
                this.error = true;
                this.mvQ = "wxblob localFile is null";
              }
              else
              {
                localb.filePath = ((q)localObject).bOF();
              }
            }
          }
        }
      } while ((this.fmB.startsWith("http://")) || (this.fmB.startsWith("https://")));
      com.tencent.mm.al.e locale = f.c(this.ozA);
      if ((locale == null) || (!locale.isOpen()))
      {
        d.closeQuietly(locale);
        this.error = true;
        this.mvQ = "the file not exist for src";
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.fmB });
        callback();
        AppMethodBeat.o(145747);
        return;
      }
      if ((localObject != null) && (this.fmB.equalsIgnoreCase(((com.tencent.mm.al.b)localObject).fnV)) && (!TextUtils.isEmpty(((com.tencent.mm.al.b)localObject).filePath))) {}
      for (localb.filePath = ((com.tencent.mm.al.b)localObject).filePath;; localb.filePath = g.l(this.ovO, this.fmB))
      {
        localb.lzV = locale;
        break;
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145748);
      super.callback();
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        AppMethodBeat.o(145748);
        return;
      }
      if (this.error)
      {
        this.ovO.j(this.okO, this.ovN.h("fail:" + this.mvQ, null));
        AppMethodBeat.o(145748);
        return;
      }
      this.ovO.j(this.okO, this.ovN.h("ok", null));
      AppMethodBeat.o(145748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l
 * JD-Core Version:    0.7.0.1
 */