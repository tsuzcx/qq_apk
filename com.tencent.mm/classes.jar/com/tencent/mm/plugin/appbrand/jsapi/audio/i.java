package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private l.a kzD;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(145729);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.SX(paramc.getAppId()))
    {
      ae.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramc.h(paramInt, e("fail:App is paused or background", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(145729);
      return;
    }
    ae.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      ae.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramc.h(paramInt, e("fail:audioId is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      ae.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramc.h(paramInt, e("fail:operationType is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (this.kzD == null) {
      this.kzD = new l.a(paramc);
    }
    this.kzD.appId = paramc.getAppId();
    this.kzD.aPa();
    a locala = new a(this, paramc, paramInt);
    locala.appId = paramc.getAppId();
    locala.ddg = str1;
    locala.dlC = i;
    locala.kzE = str2;
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
      locala.hOD = l1;
      locala.hOE = l3;
    }
    paramc = com.tencent.mm.plugin.appbrand.media.a.a.SV(str1);
    if (paramc != null)
    {
      locala.kzF = paramc.kzF;
      locala.kzG = paramc.kzG;
      locala.ddc = paramc.ddc;
    }
    locala.processName = ak.getProcessName();
    locala.aPa();
    AppMethodBeat.o(145729);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public String ddc = "";
    public String ddg = "";
    public int dlC = 0;
    public boolean error = false;
    public long hOD;
    public long hOE;
    public String iIJ;
    public int kmu;
    private m kuO;
    public com.tencent.mm.plugin.appbrand.jsapi.c kws;
    public String kzE = "";
    public String kzF;
    public WxaPkg.Info kzG;
    public String processName = "";
    
    public a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.kuO = paramm;
      this.kws = paramc;
      this.kmu = paramInt;
    }
    
    public final void BK()
    {
      AppMethodBeat.i(145728);
      super.BK();
      if (this.kws == null)
      {
        ae.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        AppMethodBeat.o(145728);
        return;
      }
      if (this.error)
      {
        this.kws.h(this.kmu, this.kuO.e("fail:" + this.iIJ, null));
        AppMethodBeat.o(145728);
        return;
      }
      this.kws.h(this.kmu, this.kuO.e("ok", null));
      AppMethodBeat.o(145728);
    }
    
    public final void Ov()
    {
      AppMethodBeat.i(145727);
      ae.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.kzE });
      this.error = false;
      Object localObject1 = this.kzE;
      Object localObject2;
      if (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject2 = com.tencent.mm.ai.c.Dk(this.ddg);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          ae.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
          localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.a(this.appId, this.ddg, this.ddc, this.kzF, this.kzG, this.processName);
        }
        if (localObject1 != null)
        {
          ((com.tencent.mm.ai.b)localObject1).hOH = this.hOD;
          ((com.tencent.mm.ai.b)localObject1).hOI = this.hOE;
        }
        localObject2 = this.ddg;
        ae.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
        v localv = new v();
        localv.dlA.action = 1;
        localv.dlA.ddg = ((String)localObject2);
        localv.dlA.dlD = ((com.tencent.mm.ai.b)localObject1);
        com.tencent.mm.plugin.music.b.a.a(localv);
        if (localv.dlB.result) {
          ae.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          ae.e("MicroMsg.Audio.JsApiOperateAudio", this.iIJ);
        }
        BK();
        AppMethodBeat.o(145727);
        return;
        if (com.tencent.mm.ai.c.Dj(this.ddg))
        {
          this.error = true;
          this.iIJ = "audio is playing, don't play again";
        }
        else
        {
          this.error = true;
          this.iIJ = "play audio fail";
          continue;
          if (((String)localObject1).equalsIgnoreCase("pause"))
          {
            localObject1 = this.ddg;
            ae.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
            localObject2 = new v();
            ((v)localObject2).dlA.action = 2;
            ((v)localObject2).dlA.ddg = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((v)localObject2);
            if (((v)localObject2).dlB.result)
            {
              ae.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            }
            else
            {
              this.error = true;
              this.iIJ = "pause audio fail";
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("seek"))
          {
            ae.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.dlC) });
            if (this.dlC < 0)
            {
              ae.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.dlC) });
              this.error = true;
              this.iIJ = "currentTime is invalid";
            }
            else
            {
              localObject1 = this.ddg;
              int i = this.dlC;
              ae.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
              localObject2 = new v();
              ((v)localObject2).dlA.action = 4;
              ((v)localObject2).dlA.ddg = ((String)localObject1);
              ((v)localObject2).dlA.dlC = i;
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              if (((v)localObject2).dlB.result)
              {
                ae.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
              }
              else
              {
                this.error = true;
                this.iIJ = "seek audio fail";
              }
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("stop"))
          {
            localObject1 = this.ddg;
            localObject2 = new v();
            ((v)localObject2).dlA.action = 13;
            ((v)localObject2).dlA.ddg = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((v)localObject2);
            boolean bool;
            if (((v)localObject2).dlB.result)
            {
              ae.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
              localObject2 = new v();
              ((v)localObject2).dlA.action = 14;
              ((v)localObject2).dlA.ddg = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              bool = ((v)localObject2).dlB.result;
            }
            for (;;)
            {
              if (!bool) {
                break label780;
              }
              ae.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
              break;
              localObject2 = new v();
              ((v)localObject2).dlA.action = 17;
              ((v)localObject2).dlA.ddg = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((v)localObject2);
              if (!((v)localObject2).dlB.result)
              {
                ae.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { localObject1 });
                localObject2 = new v();
                ((v)localObject2).dlA.action = 3;
                ((v)localObject2).dlA.ddg = ((String)localObject1);
                com.tencent.mm.plugin.music.b.a.a((v)localObject2);
                bool = ((v)localObject2).dlB.result;
              }
              else
              {
                bool = true;
              }
            }
            label780:
            this.error = true;
            this.iIJ = "stop audio fail";
          }
          else
          {
            ae.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.error = true;
            this.iIJ = "operationType is invalid";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i
 * JD-Core Version:    0.7.0.1
 */