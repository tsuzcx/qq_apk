package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class g$a
  extends a
{
  public String appId = "";
  public String ceq = "";
  public String ceu = "";
  public int cmU = 0;
  public boolean error = false;
  public long frc;
  public long frd;
  public String gUy;
  public String hBF;
  public String hBR = "";
  public String hBS;
  public int hry;
  private m hxs;
  public com.tencent.mm.plugin.appbrand.jsapi.c hyO;
  public String processName = "";
  
  public g$a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    this.hxs = paramm;
    this.hyO = paramc;
    this.hry = paramInt;
  }
  
  public final void Dh()
  {
    AppMethodBeat.i(137745);
    ab.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", new Object[] { this.hBR });
    this.error = false;
    Object localObject1 = this.hBR;
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("play"))
    {
      localObject2 = com.tencent.mm.ag.c.qJ(this.ceu);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ab.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
        localObject1 = com.tencent.mm.plugin.appbrand.media.a.b.b(this.appId, this.ceu, this.ceq, this.hBS, this.gUy, this.processName);
      }
      if (localObject1 != null)
      {
        ((com.tencent.mm.ag.b)localObject1).frg = this.frc;
        ((com.tencent.mm.ag.b)localObject1).frh = this.frd;
      }
      localObject2 = this.ceu;
      ab.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { localObject2 });
      s locals = new s();
      locals.cmS.action = 1;
      locals.cmS.ceu = ((String)localObject2);
      locals.cmS.cmV = ((com.tencent.mm.ag.b)localObject1);
      com.tencent.mm.plugin.music.b.a.a(locals);
      if (locals.cmT.cmX) {
        ab.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
      }
    }
    for (;;)
    {
      if (this.error) {
        ab.e("MicroMsg.Audio.JsApiOperateAudio", this.hBF);
      }
      tU();
      AppMethodBeat.o(137745);
      return;
      if (com.tencent.mm.ag.c.qI(this.ceu))
      {
        this.error = true;
        this.hBF = "audio is playing, don't play again";
      }
      else
      {
        this.error = true;
        this.hBF = "play audio fail";
        continue;
        if (((String)localObject1).equalsIgnoreCase("pause"))
        {
          localObject1 = this.ceu;
          ab.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { localObject1 });
          localObject2 = new s();
          ((s)localObject2).cmS.action = 2;
          ((s)localObject2).cmS.ceu = ((String)localObject1);
          com.tencent.mm.plugin.music.b.a.a((s)localObject2);
          if (((s)localObject2).cmT.cmX)
          {
            ab.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
          }
          else
          {
            this.error = true;
            this.hBF = "pause audio fail";
          }
        }
        else if (((String)localObject1).equalsIgnoreCase("seek"))
        {
          ab.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", new Object[] { Integer.valueOf(this.cmU) });
          if (this.cmU < 0)
          {
            ab.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[] { Integer.valueOf(this.cmU) });
            this.error = true;
            this.hBF = "currentTime is invalid";
          }
          else
          {
            localObject1 = this.ceu;
            int i = this.cmU;
            ab.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { localObject1, Integer.valueOf(i) });
            localObject2 = new s();
            ((s)localObject2).cmS.action = 4;
            ((s)localObject2).cmS.ceu = ((String)localObject1);
            ((s)localObject2).cmS.cmU = i;
            com.tencent.mm.plugin.music.b.a.a((s)localObject2);
            if (((s)localObject2).cmT.cmX)
            {
              ab.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
            }
            else
            {
              this.error = true;
              this.hBF = "seek audio fail";
            }
          }
        }
        else if (((String)localObject1).equalsIgnoreCase("stop"))
        {
          localObject1 = this.ceu;
          localObject2 = new s();
          ((s)localObject2).cmS.action = 13;
          ((s)localObject2).cmS.ceu = ((String)localObject1);
          com.tencent.mm.plugin.music.b.a.a((s)localObject2);
          boolean bool;
          if (((s)localObject2).cmT.cmX)
          {
            ab.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { localObject1 });
            localObject2 = new s();
            ((s)localObject2).cmS.action = 14;
            ((s)localObject2).cmS.ceu = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((s)localObject2);
            bool = ((s)localObject2).cmT.cmX;
          }
          for (;;)
          {
            if (!bool) {
              break label780;
            }
            ab.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
            break;
            localObject2 = new s();
            ((s)localObject2).cmS.action = 17;
            ((s)localObject2).cmS.ceu = ((String)localObject1);
            com.tencent.mm.plugin.music.b.a.a((s)localObject2);
            if (!((s)localObject2).cmT.cmX)
            {
              ab.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { localObject1 });
              localObject2 = new s();
              ((s)localObject2).cmS.action = 3;
              ((s)localObject2).cmS.ceu = ((String)localObject1);
              com.tencent.mm.plugin.music.b.a.a((s)localObject2);
              bool = ((s)localObject2).cmT.cmX;
            }
            else
            {
              bool = true;
            }
          }
          label780:
          this.error = true;
          this.hBF = "stop audio fail";
        }
        else
        {
          ab.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
          this.error = true;
          this.hBF = "operationType is invalid";
        }
      }
    }
  }
  
  public final void tU()
  {
    AppMethodBeat.i(137746);
    super.tU();
    if (this.hyO == null)
    {
      ab.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
      AppMethodBeat.o(137746);
      return;
    }
    if (this.error)
    {
      this.hyO.h(this.hry, this.hxs.j("fail:" + this.hBF, null));
      AppMethodBeat.o(137746);
      return;
    }
    this.hyO.h(this.hry, this.hxs.j("ok", null));
    AppMethodBeat.o(137746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g.a
 * JD-Core Version:    0.7.0.1
 */