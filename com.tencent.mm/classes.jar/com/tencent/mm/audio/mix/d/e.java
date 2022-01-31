package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.f.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object ceY;
  private a cfT;
  
  public e(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(137062);
    this.ceY = new Object();
    AppMethodBeat.o(137062);
  }
  
  protected final void DB()
  {
    AppMethodBeat.i(137067);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.DB();
    if (this.cfT != null) {
      this.cfT.reset();
    }
    AppMethodBeat.o(137067);
  }
  
  protected final void DC()
  {
    AppMethodBeat.i(137069);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.DC();
    if (this.cfT != null)
    {
      this.cfT.Em();
      if ((this.cfT instanceof com.tencent.mm.audio.mix.f.a.b)) {
        do
        {
          boolean bool = this.cfJ.get();
          Dv();
          if (this.cfK.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.cfT.resume();
          }
        } while ((!this.cfK.get()) && (this.cfJ.get()));
      }
    }
    AppMethodBeat.o(137069);
  }
  
  public final void DD()
  {
    AppMethodBeat.i(137072);
    synchronized (this.ceY)
    {
      if (this.cfT != null) {
        this.cfT.DD();
      }
      AppMethodBeat.o(137072);
      return;
    }
  }
  
  public final void Dp()
  {
    AppMethodBeat.i(137065);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    gs(5);
    this.cfK.set(true);
    this.cfM.set(false);
    Dw();
    AppMethodBeat.o(137065);
  }
  
  public final void Dq() {}
  
  protected final void a(com.tencent.mm.audio.mix.a.c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(137070);
    b(paramc, paramByteBuffer, paramInt);
    AppMethodBeat.o(137070);
  }
  
  protected final void b(com.tencent.mm.audio.mix.a.c paramc)
  {
    AppMethodBeat.i(137071);
    if (this.cfD != null) {
      this.cfD.Dk();
    }
    c(paramc);
    paramc.complete();
    AppMethodBeat.o(137071);
  }
  
  protected final void c(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(137068);
    byte[] arrayOfByte;
    com.tencent.mm.audio.mix.a.c localc;
    if (Du().cer)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = paramd.cem;
      if (!this.cfH.get()) {
        if (this.cfT == null)
        {
          localc = Du();
          if ((!localc.cep) || (localc.duration > 2000L)) {
            break label139;
          }
        }
      }
    }
    label139:
    for (this.cfT = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, localc, this);; this.cfT = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, localc, this))
    {
      this.cfT.F(arrayOfByte);
      if (paramd.cey) {
        com.tencent.mm.audio.mix.b.b.Da().b(paramd);
      }
      AppMethodBeat.o(137068);
      return;
      this.sampleRate = paramd.sampleRate;
      this.channels = paramd.channels;
      break;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(137063);
    super.onRelease();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
    synchronized (this.ceY)
    {
      if (this.cfT != null)
      {
        this.cfT.release();
        this.cfT = null;
      }
      AppMethodBeat.o(137063);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137064);
    super.pause();
    synchronized (this.ceY)
    {
      if (this.cfT != null) {
        this.cfT.pause();
      }
      AppMethodBeat.o(137064);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(137066);
    super.seek(paramInt);
    synchronized (this.ceY)
    {
      if (this.cfT != null) {
        this.cfT.seek(paramInt);
      }
      AppMethodBeat.o(137066);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.e
 * JD-Core Version:    0.7.0.1
 */