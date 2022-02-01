package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ab;
import com.tencent.mm.autogen.a.ab.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private n.a rDq;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(145729);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.adB(paramf.getAppId()))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramf.callback(paramInt, ZP("fail:App is paused or background"));
      AppMethodBeat.o(145729);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(145729);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramf.callback(paramInt, ZP("fail:audioId is empty"));
      AppMethodBeat.o(145729);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramf.callback(paramInt, ZP("fail:operationType is empty"));
      AppMethodBeat.o(145729);
      return;
    }
    if (this.rDq == null) {
      this.rDq = new n.a(paramf);
    }
    this.rDq.appId = paramf.getAppId();
    this.rDq.bQt();
    a locala = new a(this, paramf, paramInt);
    locala.appId = paramf.getAppId();
    locala.hqQ = str1;
    locala.currentTime = i;
    locala.rDr = str2;
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
      locala.oro = l1;
      locala.orp = l3;
    }
    paramf = com.tencent.mm.plugin.appbrand.media.a.a.adz(str1);
    if (paramf != null)
    {
      locala.rDs = paramf.rDs;
      locala.rDt = paramf.rDt;
      locala.hqM = paramf.hqM;
    }
    locala.processName = MMApplicationContext.getProcessName();
    locala.bQt();
    AppMethodBeat.o(145729);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int currentTime = 0;
    public boolean error = false;
    public String hqM = "";
    public String hqQ = "";
    public long oro;
    public long orp;
    public String ppp;
    public String processName = "";
    public String rDr = "";
    public String rDs;
    public WxaPkg.Info rDt;
    public int ror;
    private p rzh;
    public f rzi;
    
    public a(p paramp, f paramf, int paramInt)
    {
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public final void aFi()
    {
      AppMethodBeat.i(145727);
      Log.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.rDr });
      this.error = false;
      Object localObject1 = this.rDr;
      Object localObject2;
      if (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject2 = com.tencent.mm.al.c.Lr(this.hqQ);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          Log.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
          localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.a(this.rzi, this.appId, this.hqQ, this.hqM, this.rDs, this.rDt, this.processName);
        }
        if (localObject1 != null)
        {
          ((com.tencent.mm.al.b)localObject1).ors = this.oro;
          ((com.tencent.mm.al.b)localObject1).ort = this.orp;
        }
        localObject2 = this.hqQ;
        Log.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
        ab localab = new ab();
        localab.hzS.action = 1;
        localab.hzS.hqQ = ((String)localObject2);
        localab.hzS.hzU = ((com.tencent.mm.al.b)localObject1);
        com.tencent.mm.plugin.music.b.b.a(localab);
        if (localab.hzT.result) {
          Log.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          Log.e("MicroMsg.Audio.JsApiOperateAudio", this.ppp);
        }
        callback();
        AppMethodBeat.o(145727);
        return;
        if (com.tencent.mm.al.c.Lq(this.hqQ))
        {
          this.error = true;
          this.ppp = "audio is playing, don't play again";
        }
        else
        {
          this.error = true;
          this.ppp = "play audio fail";
          continue;
          if (((String)localObject1).equalsIgnoreCase("pause"))
          {
            localObject1 = this.hqQ;
            Log.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
            localObject2 = new ab();
            ((ab)localObject2).hzS.action = 2;
            ((ab)localObject2).hzS.hqQ = ((String)localObject1);
            com.tencent.mm.plugin.music.b.b.a((ab)localObject2);
            if (((ab)localObject2).hzT.result)
            {
              Log.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            }
            else
            {
              this.error = true;
              this.ppp = "pause audio fail";
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("seek"))
          {
            Log.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.currentTime) });
            if (this.currentTime < 0)
            {
              Log.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.currentTime) });
              this.error = true;
              this.ppp = "currentTime is invalid";
            }
            else
            {
              localObject1 = this.hqQ;
              int i = this.currentTime;
              Log.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
              localObject2 = new ab();
              ((ab)localObject2).hzS.action = 4;
              ((ab)localObject2).hzS.hqQ = ((String)localObject1);
              ((ab)localObject2).hzS.currentTime = i;
              com.tencent.mm.plugin.music.b.b.a((ab)localObject2);
              if (((ab)localObject2).hzT.result)
              {
                Log.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
              }
              else
              {
                this.error = true;
                this.ppp = "seek audio fail";
              }
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("stop"))
          {
            localObject1 = this.hqQ;
            localObject2 = new ab();
            ((ab)localObject2).hzS.action = 13;
            ((ab)localObject2).hzS.hqQ = ((String)localObject1);
            com.tencent.mm.plugin.music.b.b.a((ab)localObject2);
            boolean bool;
            if (((ab)localObject2).hzT.result)
            {
              Log.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
              localObject2 = new ab();
              ((ab)localObject2).hzS.action = 14;
              ((ab)localObject2).hzS.hqQ = ((String)localObject1);
              com.tencent.mm.plugin.music.b.b.a((ab)localObject2);
              bool = ((ab)localObject2).hzT.result;
            }
            for (;;)
            {
              if (!bool) {
                break label732;
              }
              Log.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
              break;
              localObject2 = new ab();
              ((ab)localObject2).hzS.action = 17;
              ((ab)localObject2).hzS.hqQ = ((String)localObject1);
              com.tencent.mm.plugin.music.b.b.a((ab)localObject2);
              if (!((ab)localObject2).hzT.result) {
                bool = com.tencent.mm.al.c.Lo((String)localObject1);
              } else {
                bool = true;
              }
            }
            label732:
            this.error = true;
            this.ppp = "stop audio fail";
          }
          else
          {
            Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.error = true;
            this.ppp = "operationType is invalid";
          }
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145728);
      super.callback();
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        AppMethodBeat.o(145728);
        return;
      }
      if (this.error)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail:" + this.ppp));
        AppMethodBeat.o(145728);
        return;
      }
      this.rzi.callback(this.ror, this.rzh.ZP("ok"));
      AppMethodBeat.o(145728);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k
 * JD-Core Version:    0.7.0.1
 */