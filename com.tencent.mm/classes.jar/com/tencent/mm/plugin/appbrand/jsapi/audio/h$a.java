package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.h.a.s;
import com.tencent.mm.h.a.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;

final class h$a
  extends a
{
  public String appId = "";
  public String bFM = "";
  public int bFN = 0;
  public long eaT;
  public long eaU;
  public String eaY = "";
  public boolean error = false;
  public String fCl;
  private i gfG;
  public int gfg;
  public com.tencent.mm.plugin.appbrand.jsapi.c ggu;
  public String gio;
  public String giy = "";
  public String giz;
  public String processName = "";
  
  public h$a(i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    this.gfG = parami;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void ahX()
  {
    y.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.giy });
    this.error = false;
    Object localObject1 = this.giy;
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("play"))
    {
      localObject2 = com.tencent.mm.af.c.jQ(this.bFM);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        y.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
        localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.b(this.appId, this.bFM, this.eaY, this.giz, this.fCl, this.processName);
      }
      if (localObject1 != null)
      {
        ((com.tencent.mm.af.b)localObject1).eaT = this.eaT;
        ((com.tencent.mm.af.b)localObject1).eaU = this.eaU;
      }
      localObject2 = this.bFM;
      y.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
      s locals = new s();
      locals.bFK.action = 1;
      locals.bFK.bFM = ((String)localObject2);
      locals.bFK.bFO = ((com.tencent.mm.af.b)localObject1);
      com.tencent.mm.plugin.music.b.a.a(locals);
      if (locals.bFL.bFQ) {
        y.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
      }
    }
    for (;;)
    {
      if (this.error) {
        y.e("MicroMsg.Audio.JsApiOperateAudio", this.gio);
      }
      pQ();
      return;
      if (com.tencent.mm.af.c.jP(this.bFM))
      {
        this.error = true;
        this.gio = "audio is playing, don't play again";
      }
      else
      {
        this.error = true;
        this.gio = "play audio fail";
        continue;
        if (((String)localObject1).equalsIgnoreCase("pause"))
        {
          localObject1 = this.bFM;
          y.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
          localObject2 = new s();
          ((s)localObject2).bFK.action = 2;
          ((s)localObject2).bFK.bFM = ((String)localObject1);
          com.tencent.mm.plugin.music.b.a.a((s)localObject2);
          if (((s)localObject2).bFL.bFQ)
          {
            y.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
          }
          else
          {
            this.error = true;
            this.gio = "pause audio fail";
          }
        }
        else if (((String)localObject1).equalsIgnoreCase("seek"))
        {
          y.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.bFN) });
          if (this.bFN < 0)
          {
            y.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.bFN) });
            this.error = true;
            this.gio = "currentTime is invalid";
          }
          else
          {
            localObject1 = this.bFM;
            int i = this.bFN;
            y.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
            localObject2 = new s();
            ((s)localObject2).bFK.action = 4;
            ((s)localObject2).bFK.bFM = ((String)localObject1);
            ((s)localObject2).bFK.bFN = i;
            com.tencent.mm.plugin.music.b.a.a((s)localObject2);
            if (((s)localObject2).bFL.bFQ)
            {
              y.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
            }
            else
            {
              this.error = true;
              this.gio = "seek audio fail";
            }
          }
        }
        else if (((String)localObject1).equalsIgnoreCase("stop"))
        {
          localObject1 = this.bFM;
          localObject2 = new s();
          ((s)localObject2).bFK.action = 13;
          ((s)localObject2).bFK.bFM = ((String)localObject1);
          com.tencent.mm.plugin.music.b.a.a((s)localObject2);
          boolean bool;
          if (((s)localObject2).bFL.bFQ)
          {
            y.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
            localObject2 = new s();
            ((s)localObject2).bFK.action = 14;
            ((s)localObject2).bFK.bFM = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((s)localObject2);
            bool = ((s)localObject2).bFL.bFQ;
          }
          for (;;)
          {
            if (!bool) {
              break label770;
            }
            y.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
            break;
            localObject2 = new s();
            ((s)localObject2).bFK.action = 17;
            ((s)localObject2).bFK.bFM = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((s)localObject2);
            if (!((s)localObject2).bFL.bFQ)
            {
              y.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { localObject1 });
              localObject2 = new s();
              ((s)localObject2).bFK.action = 3;
              ((s)localObject2).bFK.bFM = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((s)localObject2);
              bool = ((s)localObject2).bFL.bFQ;
            }
            else
            {
              bool = true;
            }
          }
          label770:
          this.error = true;
          this.gio = "stop audio fail";
        }
        else
        {
          y.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
          this.error = true;
          this.gio = "operationType is invalid";
        }
      }
    }
  }
  
  public final void pQ()
  {
    super.pQ();
    if (this.ggu == null)
    {
      y.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.h.a
 * JD-Core Version:    0.7.0.1
 */