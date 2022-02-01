package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private k.a jBt;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(145729);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.KE(paramc.getAppId()))
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
    if (this.jBt == null) {
      this.jBt = new k.a(this, paramc, paramInt);
    }
    this.jBt.appId = paramc.getAppId();
    this.jBt.aEC();
    a locala = new a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.cTr = str1;
    locala.dbJ = i;
    locala.jBu = str2;
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
      locala.gST = l1;
      locala.gSU = l3;
    }
    paramc = com.tencent.mm.plugin.appbrand.media.a.a.KC(str1);
    if (paramc != null)
    {
      locala.jBv = paramc.jBv;
      locala.jBw = paramc.jBw;
      locala.cTn = paramc.cTn;
    }
    locala.processName = aj.getProcessName();
    locala.aEC();
    AppMethodBeat.o(145729);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String cTn = "";
    public String cTr = "";
    public int dbJ = 0;
    public boolean error = false;
    public long gST;
    public long gSU;
    public String hMd;
    public String jBu = "";
    public String jBv;
    public WxaPkg.Info jBw;
    public int joH;
    private m jwG;
    public com.tencent.mm.plugin.appbrand.jsapi.c jyl;
    public String processName = "";
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.jwG = paramm;
      this.jyl = paramc;
      this.joH = paramInt;
    }
    
    public final void AI()
    {
      AppMethodBeat.i(145728);
      super.AI();
      if (this.jyl == null)
      {
        ad.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        AppMethodBeat.o(145728);
        return;
      }
      if (this.error)
      {
        this.jyl.h(this.joH, this.jwG.e("fail:" + this.hMd, null));
        AppMethodBeat.o(145728);
        return;
      }
      this.jyl.h(this.joH, this.jwG.e("ok", null));
      AppMethodBeat.o(145728);
    }
    
    public final void MQ()
    {
      AppMethodBeat.i(145727);
      ad.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.jBu });
      this.error = false;
      Object localObject1 = this.jBu;
      Object localObject2;
      if (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject2 = com.tencent.mm.aj.c.vD(this.cTr);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          ad.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
          localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.a(this.appId, this.cTr, this.cTn, this.jBv, this.jBw, this.processName);
        }
        if (localObject1 != null)
        {
          ((com.tencent.mm.aj.b)localObject1).gSX = this.gST;
          ((com.tencent.mm.aj.b)localObject1).gSY = this.gSU;
        }
        localObject2 = this.cTr;
        ad.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
        u localu = new u();
        localu.dbH.action = 1;
        localu.dbH.cTr = ((String)localObject2);
        localu.dbH.dbK = ((com.tencent.mm.aj.b)localObject1);
        com.tencent.mm.plugin.music.b.a.a(localu);
        if (localu.dbI.result) {
          ad.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          ad.e("MicroMsg.Audio.JsApiOperateAudio", this.hMd);
        }
        AI();
        AppMethodBeat.o(145727);
        return;
        if (com.tencent.mm.aj.c.vC(this.cTr))
        {
          this.error = true;
          this.hMd = "audio is playing, don't play again";
        }
        else
        {
          this.error = true;
          this.hMd = "play audio fail";
          continue;
          if (((String)localObject1).equalsIgnoreCase("pause"))
          {
            localObject1 = this.cTr;
            ad.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
            localObject2 = new u();
            ((u)localObject2).dbH.action = 2;
            ((u)localObject2).dbH.cTr = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((u)localObject2);
            if (((u)localObject2).dbI.result)
            {
              ad.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            }
            else
            {
              this.error = true;
              this.hMd = "pause audio fail";
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("seek"))
          {
            ad.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.dbJ) });
            if (this.dbJ < 0)
            {
              ad.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.dbJ) });
              this.error = true;
              this.hMd = "currentTime is invalid";
            }
            else
            {
              localObject1 = this.cTr;
              int i = this.dbJ;
              ad.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
              localObject2 = new u();
              ((u)localObject2).dbH.action = 4;
              ((u)localObject2).dbH.cTr = ((String)localObject1);
              ((u)localObject2).dbH.dbJ = i;
              com.tencent.mm.plugin.music.b.a.a((u)localObject2);
              if (((u)localObject2).dbI.result)
              {
                ad.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
              }
              else
              {
                this.error = true;
                this.hMd = "seek audio fail";
              }
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("stop"))
          {
            localObject1 = this.cTr;
            localObject2 = new u();
            ((u)localObject2).dbH.action = 13;
            ((u)localObject2).dbH.cTr = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((u)localObject2);
            boolean bool;
            if (((u)localObject2).dbI.result)
            {
              ad.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
              localObject2 = new u();
              ((u)localObject2).dbH.action = 14;
              ((u)localObject2).dbH.cTr = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((u)localObject2);
              bool = ((u)localObject2).dbI.result;
            }
            for (;;)
            {
              if (!bool) {
                break label780;
              }
              ad.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
              break;
              localObject2 = new u();
              ((u)localObject2).dbH.action = 17;
              ((u)localObject2).dbH.cTr = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((u)localObject2);
              if (!((u)localObject2).dbI.result)
              {
                ad.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { localObject1 });
                localObject2 = new u();
                ((u)localObject2).dbH.action = 3;
                ((u)localObject2).dbH.cTr = ((String)localObject1);
                com.tencent.mm.plugin.music.b.a.a((u)localObject2);
                bool = ((u)localObject2).dbI.result;
              }
              else
              {
                bool = true;
              }
            }
            label780:
            this.error = true;
            this.hMd = "stop audio fail";
          }
          else
          {
            ad.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.error = true;
            this.hMd = "operationType is invalid";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h
 * JD-Core Version:    0.7.0.1
 */