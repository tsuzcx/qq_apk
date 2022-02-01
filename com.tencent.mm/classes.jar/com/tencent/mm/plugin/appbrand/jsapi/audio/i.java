package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.a.y.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private l.a ozx;
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(145729);
    if (!com.tencent.mm.plugin.appbrand.media.a.a.akv(parame.getAppId()))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      parame.j(paramInt, h("fail:App is paused or background", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      parame.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(145729);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { parame.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      parame.j(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      parame.j(paramInt, h("fail:operationType is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (this.ozx == null) {
      this.ozx = new l.a(parame);
    }
    this.ozx.appId = parame.getAppId();
    this.ozx.bsM();
    a locala = new a(this, parame, paramInt);
    locala.appId = parame.getAppId();
    locala.fmF = str1;
    locala.currentTime = i;
    locala.ozy = str2;
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
      locala.lzN = l1;
      locala.lzO = l3;
    }
    parame = com.tencent.mm.plugin.appbrand.media.a.a.akt(str1);
    if (parame != null)
    {
      locala.ozz = parame.ozz;
      locala.ozA = parame.ozA;
      locala.fmB = parame.fmB;
    }
    locala.processName = MMApplicationContext.getProcessName();
    locala.bsM();
    AppMethodBeat.o(145729);
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public int currentTime = 0;
    public boolean error = false;
    public String fmB = "";
    public String fmF = "";
    public long lzN;
    public long lzO;
    public String mvQ;
    public int okO;
    private o ovN;
    public e ovO;
    public WxaPkg.Info ozA;
    public String ozy = "";
    public String ozz;
    public String processName = "";
    
    public a(o paramo, e parame, int paramInt)
    {
      this.ovN = paramo;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void adj()
    {
      AppMethodBeat.i(145727);
      Log.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.ozy });
      this.error = false;
      Object localObject1 = this.ozy;
      Object localObject2;
      if (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject2 = com.tencent.mm.al.c.Tp(this.fmF);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          Log.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
          localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.a(this.ovO, this.appId, this.fmF, this.fmB, this.ozz, this.ozA, this.processName);
        }
        if (localObject1 != null)
        {
          ((com.tencent.mm.al.b)localObject1).lzR = this.lzN;
          ((com.tencent.mm.al.b)localObject1).lzS = this.lzO;
        }
        localObject2 = this.fmF;
        Log.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
        y localy = new y();
        localy.fvx.action = 1;
        localy.fvx.fmF = ((String)localObject2);
        localy.fvx.fvz = ((com.tencent.mm.al.b)localObject1);
        com.tencent.mm.plugin.music.b.b.a(localy);
        if (localy.fvy.result) {
          Log.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          Log.e("MicroMsg.Audio.JsApiOperateAudio", this.mvQ);
        }
        callback();
        AppMethodBeat.o(145727);
        return;
        if (com.tencent.mm.al.c.To(this.fmF))
        {
          this.error = true;
          this.mvQ = "audio is playing, don't play again";
        }
        else
        {
          this.error = true;
          this.mvQ = "play audio fail";
          continue;
          if (((String)localObject1).equalsIgnoreCase("pause"))
          {
            localObject1 = this.fmF;
            Log.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
            localObject2 = new y();
            ((y)localObject2).fvx.action = 2;
            ((y)localObject2).fvx.fmF = ((String)localObject1);
            com.tencent.mm.plugin.music.b.b.a((y)localObject2);
            if (((y)localObject2).fvy.result)
            {
              Log.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            }
            else
            {
              this.error = true;
              this.mvQ = "pause audio fail";
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("seek"))
          {
            Log.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.currentTime) });
            if (this.currentTime < 0)
            {
              Log.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.currentTime) });
              this.error = true;
              this.mvQ = "currentTime is invalid";
            }
            else
            {
              localObject1 = this.fmF;
              int i = this.currentTime;
              Log.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
              localObject2 = new y();
              ((y)localObject2).fvx.action = 4;
              ((y)localObject2).fvx.fmF = ((String)localObject1);
              ((y)localObject2).fvx.currentTime = i;
              com.tencent.mm.plugin.music.b.b.a((y)localObject2);
              if (((y)localObject2).fvy.result)
              {
                Log.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
              }
              else
              {
                this.error = true;
                this.mvQ = "seek audio fail";
              }
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("stop"))
          {
            localObject1 = this.fmF;
            localObject2 = new y();
            ((y)localObject2).fvx.action = 13;
            ((y)localObject2).fvx.fmF = ((String)localObject1);
            com.tencent.mm.plugin.music.b.b.a((y)localObject2);
            boolean bool;
            if (((y)localObject2).fvy.result)
            {
              Log.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
              localObject2 = new y();
              ((y)localObject2).fvx.action = 14;
              ((y)localObject2).fvx.fmF = ((String)localObject1);
              com.tencent.mm.plugin.music.b.b.a((y)localObject2);
              bool = ((y)localObject2).fvy.result;
            }
            for (;;)
            {
              if (!bool) {
                break label732;
              }
              Log.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
              break;
              localObject2 = new y();
              ((y)localObject2).fvx.action = 17;
              ((y)localObject2).fvx.fmF = ((String)localObject1);
              com.tencent.mm.plugin.music.b.b.a((y)localObject2);
              if (!((y)localObject2).fvy.result) {
                bool = com.tencent.mm.al.c.Tm((String)localObject1);
              } else {
                bool = true;
              }
            }
            label732:
            this.error = true;
            this.mvQ = "stop audio fail";
          }
          else
          {
            Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.error = true;
            this.mvQ = "operationType is invalid";
          }
        }
      }
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145728);
      super.callback();
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        AppMethodBeat.o(145728);
        return;
      }
      if (this.error)
      {
        this.ovO.j(this.okO, this.ovN.h("fail:" + this.mvQ, null));
        AppMethodBeat.o(145728);
        return;
      }
      this.ovO.j(this.okO, this.ovN.h("ok", null));
      AppMethodBeat.o(145728);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i
 * JD-Core Version:    0.7.0.1
 */