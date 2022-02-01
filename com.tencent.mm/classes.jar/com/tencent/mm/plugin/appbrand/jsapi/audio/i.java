package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private l.a kwo;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(145729);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.So(paramc.getAppId()))
    {
      ad.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, e("fail:App is paused or background", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145729);
      return;
    }
    ad.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      ad.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      ad.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramc.h(paramInt, e("fail:operationType is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (this.kwo == null) {
      this.kwo = new l.a(paramc);
    }
    this.kwo.appId = paramc.getAppId();
    this.kwo.aOD();
    a locala = new a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.dce = str1;
    locala.dkA = i;
    locala.kwp = str2;
    if (str2.equalsIgnoreCase("play"))
    {
      long l4 = paramJSONObject.optLong("timestamp", 0L);
      long l3 = System.currentTimeMillis();
      long l1 = l2;
      if (l4 > 0L)
      {
        l1 = l2;
        if (l4 < l3) {
          l1 = l3 - l4;
        }
      }
      locala.hLK = l1;
      locala.hLL = l3;
    }
    paramc = com.tencent.mm.plugin.appbrand.media.a.a.Sm(str1);
    if (paramc != null)
    {
      locala.kwq = paramc.kwq;
      locala.kwr = paramc.kwr;
      locala.dca = paramc.dca;
    }
    locala.processName = aj.getProcessName();
    locala.aOD();
    AppMethodBeat.o(145729);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String dca = "";
    public String dce = "";
    public int dkA = 0;
    public boolean error = false;
    public long hLK;
    public long hLL;
    public String iFQ;
    public int kje;
    private m kry;
    public com.tencent.mm.plugin.appbrand.jsapi.c ktc;
    public String kwp = "";
    public String kwq;
    public WxaPkg.Info kwr;
    public String processName = "";
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.kry = paramm;
      this.ktc = paramc;
      this.kje = paramInt;
    }
    
    public final void BJ()
    {
      AppMethodBeat.i(145728);
      super.BJ();
      if (this.ktc == null)
      {
        ad.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        AppMethodBeat.o(145728);
        return;
      }
      if (this.error)
      {
        this.ktc.h(this.kje, this.kry.e("fail:" + this.iFQ, null));
        AppMethodBeat.o(145728);
        return;
      }
      this.ktc.h(this.kje, this.kry.e("ok", null));
      AppMethodBeat.o(145728);
    }
    
    public final void Ox()
    {
      AppMethodBeat.i(145727);
      ad.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.kwp });
      this.error = false;
      Object localObject1 = this.kwp;
      Object localObject2;
      if (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject2 = com.tencent.mm.aj.c.CI(this.dce);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          ad.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
          localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.a(this.appId, this.dce, this.dca, this.kwq, this.kwr, this.processName);
        }
        if (localObject1 != null)
        {
          ((com.tencent.mm.aj.b)localObject1).hLO = this.hLK;
          ((com.tencent.mm.aj.b)localObject1).hLP = this.hLL;
        }
        localObject2 = this.dce;
        ad.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
        v localv = new v();
        localv.dky.action = 1;
        localv.dky.dce = ((String)localObject2);
        localv.dky.dkB = ((com.tencent.mm.aj.b)localObject1);
        com.tencent.mm.plugin.music.b.a.a(localv);
        if (localv.dkz.result) {
          ad.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          ad.e("MicroMsg.Audio.JsApiOperateAudio", this.iFQ);
        }
        BJ();
        AppMethodBeat.o(145727);
        return;
        if (com.tencent.mm.aj.c.CH(this.dce))
        {
          this.error = true;
          this.iFQ = "audio is playing, don't play again";
        }
        else
        {
          this.error = true;
          this.iFQ = "play audio fail";
          continue;
          if (((String)localObject1).equalsIgnoreCase("pause"))
          {
            localObject1 = this.dce;
            ad.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
            localObject2 = new v();
            ((v)localObject2).dky.action = 2;
            ((v)localObject2).dky.dce = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((v)localObject2);
            if (((v)localObject2).dkz.result)
            {
              ad.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            }
            else
            {
              this.error = true;
              this.iFQ = "pause audio fail";
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("seek"))
          {
            ad.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.dkA) });
            if (this.dkA < 0)
            {
              ad.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.dkA) });
              this.error = true;
              this.iFQ = "currentTime is invalid";
            }
            else
            {
              localObject1 = this.dce;
              int i = this.dkA;
              ad.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
              localObject2 = new v();
              ((v)localObject2).dky.action = 4;
              ((v)localObject2).dky.dce = ((String)localObject1);
              ((v)localObject2).dky.dkA = i;
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              if (((v)localObject2).dkz.result)
              {
                ad.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
              }
              else
              {
                this.error = true;
                this.iFQ = "seek audio fail";
              }
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("stop"))
          {
            localObject1 = this.dce;
            localObject2 = new v();
            ((v)localObject2).dky.action = 13;
            ((v)localObject2).dky.dce = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((v)localObject2);
            boolean bool;
            if (((v)localObject2).dkz.result)
            {
              ad.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
              localObject2 = new v();
              ((v)localObject2).dky.action = 14;
              ((v)localObject2).dky.dce = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              bool = ((v)localObject2).dkz.result;
            }
            for (;;)
            {
              if (!bool) {
                break label780;
              }
              ad.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
              break;
              localObject2 = new v();
              ((v)localObject2).dky.action = 17;
              ((v)localObject2).dky.dce = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              if (!((v)localObject2).dkz.result)
              {
                ad.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { localObject1 });
                localObject2 = new v();
                ((v)localObject2).dky.action = 3;
                ((v)localObject2).dky.dce = ((String)localObject1);
                com.tencent.mm.plugin.music.b.a.a((v)localObject2);
                bool = ((v)localObject2).dkz.result;
              }
              else
              {
                bool = true;
              }
            }
            label780:
            this.error = true;
            this.iFQ = "stop audio fail";
          }
          else
          {
            ad.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.error = true;
            this.iFQ = "operationType is invalid";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i
 * JD-Core Version:    0.7.0.1
 */