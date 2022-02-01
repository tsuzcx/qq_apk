package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.c;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;

final class i$a
  extends a
{
  public String appId = "";
  public int dCS = 0;
  public String dtT = "";
  public String dtX = "";
  public boolean error = false;
  public long iJJ;
  public long iJK;
  public String jFn;
  private p lAw;
  public f lAx;
  public String lDX = "";
  public String lDY;
  public WxaPkg.Info lDZ;
  public int lqe;
  public String processName = "";
  
  public i$a(p paramp, f paramf, int paramInt)
  {
    this.lAw = paramp;
    this.lAx = paramf;
    this.lqe = paramInt;
  }
  
  public final void YC()
  {
    AppMethodBeat.i(145727);
    Log.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.lDX });
    this.error = false;
    Object localObject1 = this.lDX;
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("play"))
    {
      localObject2 = c.LU(this.dtX);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Log.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
        localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.a(this.lAx, this.appId, this.dtX, this.dtT, this.lDY, this.lDZ, this.processName);
      }
      if (localObject1 != null)
      {
        ((com.tencent.mm.ai.b)localObject1).iJN = this.iJJ;
        ((com.tencent.mm.ai.b)localObject1).iJO = this.iJK;
      }
      localObject2 = this.dtX;
      Log.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
      x localx = new x();
      localx.dCQ.action = 1;
      localx.dCQ.dtX = ((String)localObject2);
      localx.dCQ.dCT = ((com.tencent.mm.ai.b)localObject1);
      com.tencent.mm.plugin.music.b.a.a(localx);
      if (localx.dCR.result) {
        Log.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
      }
    }
    for (;;)
    {
      if (this.error) {
        Log.e("MicroMsg.Audio.JsApiOperateAudio", this.jFn);
      }
      callback();
      AppMethodBeat.o(145727);
      return;
      if (c.LT(this.dtX))
      {
        this.error = true;
        this.jFn = "audio is playing, don't play again";
      }
      else
      {
        this.error = true;
        this.jFn = "play audio fail";
        continue;
        if (((String)localObject1).equalsIgnoreCase("pause"))
        {
          localObject1 = this.dtX;
          Log.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
          localObject2 = new x();
          ((x)localObject2).dCQ.action = 2;
          ((x)localObject2).dCQ.dtX = ((String)localObject1);
          com.tencent.mm.plugin.music.b.a.a((x)localObject2);
          if (((x)localObject2).dCR.result)
          {
            Log.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
          }
          else
          {
            this.error = true;
            this.jFn = "pause audio fail";
          }
        }
        else if (((String)localObject1).equalsIgnoreCase("seek"))
        {
          Log.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.dCS) });
          if (this.dCS < 0)
          {
            Log.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.dCS) });
            this.error = true;
            this.jFn = "currentTime is invalid";
          }
          else
          {
            localObject1 = this.dtX;
            int i = this.dCS;
            Log.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
            localObject2 = new x();
            ((x)localObject2).dCQ.action = 4;
            ((x)localObject2).dCQ.dtX = ((String)localObject1);
            ((x)localObject2).dCQ.dCS = i;
            com.tencent.mm.plugin.music.b.a.a((x)localObject2);
            if (((x)localObject2).dCR.result)
            {
              Log.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
            }
            else
            {
              this.error = true;
              this.jFn = "seek audio fail";
            }
          }
        }
        else if (((String)localObject1).equalsIgnoreCase("stop"))
        {
          localObject1 = this.dtX;
          localObject2 = new x();
          ((x)localObject2).dCQ.action = 13;
          ((x)localObject2).dCQ.dtX = ((String)localObject1);
          com.tencent.mm.plugin.music.b.a.a((x)localObject2);
          boolean bool;
          if (((x)localObject2).dCR.result)
          {
            Log.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
            localObject2 = new x();
            ((x)localObject2).dCQ.action = 14;
            ((x)localObject2).dCQ.dtX = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((x)localObject2);
            bool = ((x)localObject2).dCR.result;
          }
          for (;;)
          {
            if (!bool) {
              break label784;
            }
            Log.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
            break;
            localObject2 = new x();
            ((x)localObject2).dCQ.action = 17;
            ((x)localObject2).dCQ.dtX = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((x)localObject2);
            if (!((x)localObject2).dCR.result)
            {
              Log.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { localObject1 });
              localObject2 = new x();
              ((x)localObject2).dCQ.action = 3;
              ((x)localObject2).dCQ.dtX = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((x)localObject2);
              bool = ((x)localObject2).dCR.result;
            }
            else
            {
              bool = true;
            }
          }
          label784:
          this.error = true;
          this.jFn = "stop audio fail";
        }
        else
        {
          Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
          this.error = true;
          this.jFn = "operationType is invalid";
        }
      }
    }
  }
  
  public final void callback()
  {
    AppMethodBeat.i(145728);
    super.callback();
    if (this.lAx == null)
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
      AppMethodBeat.o(145728);
      return;
    }
    if (this.error)
    {
      this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
      AppMethodBeat.o(145728);
      return;
    }
    this.lAx.i(this.lqe, this.lAw.h("ok", null));
    AppMethodBeat.o(145728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i.a
 * JD-Core Version:    0.7.0.1
 */