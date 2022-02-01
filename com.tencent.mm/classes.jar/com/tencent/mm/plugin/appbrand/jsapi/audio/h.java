package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private k.a kbP;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(145729);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.OL(paramc.getAppId()))
    {
      ac.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, e("fail:App is paused or background", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145729);
      return;
    }
    ac.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      ac.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      ac.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramc.h(paramInt, e("fail:operationType is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (this.kbP == null) {
      this.kbP = new k.a(this, paramc, paramInt);
    }
    this.kbP.appId = paramc.getAppId();
    this.kbP.aLt();
    a locala = new a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.cQO = str1;
    locala.cZi = i;
    locala.kbQ = str2;
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
      locala.hts = l1;
      locala.htt = l3;
    }
    paramc = com.tencent.mm.plugin.appbrand.media.a.a.OJ(str1);
    if (paramc != null)
    {
      locala.kbR = paramc.kbR;
      locala.kbS = paramc.kbS;
      locala.cQK = paramc.cQK;
    }
    locala.processName = ai.getProcessName();
    locala.aLt();
    AppMethodBeat.o(145729);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String cQK = "";
    public String cQO = "";
    public int cZi = 0;
    public boolean error = false;
    public long hts;
    public long htt;
    public String imz;
    public int jOT;
    private m jXc;
    public com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    public String kbQ = "";
    public String kbR;
    public WxaPkg.Info kbS;
    public String processName = "";
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.jXc = paramm;
      this.jYG = paramc;
      this.jOT = paramInt;
    }
    
    public final void Am()
    {
      AppMethodBeat.i(145728);
      super.Am();
      if (this.jYG == null)
      {
        ac.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        AppMethodBeat.o(145728);
        return;
      }
      if (this.error)
      {
        this.jYG.h(this.jOT, this.jXc.e("fail:" + this.imz, null));
        AppMethodBeat.o(145728);
        return;
      }
      this.jYG.h(this.jOT, this.jXc.e("ok", null));
      AppMethodBeat.o(145728);
    }
    
    public final void MO()
    {
      AppMethodBeat.i(145727);
      ac.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.kbQ });
      this.error = false;
      Object localObject1 = this.kbQ;
      Object localObject2;
      if (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject2 = com.tencent.mm.ai.c.zJ(this.cQO);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          ac.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
          localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.a(this.appId, this.cQO, this.cQK, this.kbR, this.kbS, this.processName);
        }
        if (localObject1 != null)
        {
          ((com.tencent.mm.ai.b)localObject1).htw = this.hts;
          ((com.tencent.mm.ai.b)localObject1).htx = this.htt;
        }
        localObject2 = this.cQO;
        ac.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
        v localv = new v();
        localv.cZg.action = 1;
        localv.cZg.cQO = ((String)localObject2);
        localv.cZg.cZj = ((com.tencent.mm.ai.b)localObject1);
        com.tencent.mm.plugin.music.b.a.a(localv);
        if (localv.cZh.result) {
          ac.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          ac.e("MicroMsg.Audio.JsApiOperateAudio", this.imz);
        }
        Am();
        AppMethodBeat.o(145727);
        return;
        if (com.tencent.mm.ai.c.zI(this.cQO))
        {
          this.error = true;
          this.imz = "audio is playing, don't play again";
        }
        else
        {
          this.error = true;
          this.imz = "play audio fail";
          continue;
          if (((String)localObject1).equalsIgnoreCase("pause"))
          {
            localObject1 = this.cQO;
            ac.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
            localObject2 = new v();
            ((v)localObject2).cZg.action = 2;
            ((v)localObject2).cZg.cQO = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((v)localObject2);
            if (((v)localObject2).cZh.result)
            {
              ac.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            }
            else
            {
              this.error = true;
              this.imz = "pause audio fail";
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("seek"))
          {
            ac.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.cZi) });
            if (this.cZi < 0)
            {
              ac.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.cZi) });
              this.error = true;
              this.imz = "currentTime is invalid";
            }
            else
            {
              localObject1 = this.cQO;
              int i = this.cZi;
              ac.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
              localObject2 = new v();
              ((v)localObject2).cZg.action = 4;
              ((v)localObject2).cZg.cQO = ((String)localObject1);
              ((v)localObject2).cZg.cZi = i;
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              if (((v)localObject2).cZh.result)
              {
                ac.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
              }
              else
              {
                this.error = true;
                this.imz = "seek audio fail";
              }
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("stop"))
          {
            localObject1 = this.cQO;
            localObject2 = new v();
            ((v)localObject2).cZg.action = 13;
            ((v)localObject2).cZg.cQO = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((v)localObject2);
            boolean bool;
            if (((v)localObject2).cZh.result)
            {
              ac.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
              localObject2 = new v();
              ((v)localObject2).cZg.action = 14;
              ((v)localObject2).cZg.cQO = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              bool = ((v)localObject2).cZh.result;
            }
            for (;;)
            {
              if (!bool) {
                break label780;
              }
              ac.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
              break;
              localObject2 = new v();
              ((v)localObject2).cZg.action = 17;
              ((v)localObject2).cZg.cQO = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              if (!((v)localObject2).cZh.result)
              {
                ac.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { localObject1 });
                localObject2 = new v();
                ((v)localObject2).cZg.action = 3;
                ((v)localObject2).cZg.cQO = ((String)localObject1);
                com.tencent.mm.plugin.music.b.a.a((v)localObject2);
                bool = ((v)localObject2).cZh.result;
              }
              else
              {
                bool = true;
              }
            }
            label780:
            this.error = true;
            this.imz = "stop audio fail";
          }
          else
          {
            ac.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.error = true;
            this.imz = "operationType is invalid";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h
 * JD-Core Version:    0.7.0.1
 */