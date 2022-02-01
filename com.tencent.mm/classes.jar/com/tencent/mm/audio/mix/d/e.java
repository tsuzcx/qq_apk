package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.audio.mix.g.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object duI;
  private a dvG;
  
  public e(com.tencent.mm.audio.mix.g.d paramd, com.tencent.mm.audio.mix.h.c paramc)
  {
    super(paramd, paramc);
    AppMethodBeat.i(136810);
    this.duI = new Object();
    AppMethodBeat.o(136810);
  }
  
  public final void YV()
  {
    AppMethodBeat.i(136813);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    je(5);
    this.dvr.set(true);
    this.dvt.set(false);
    Zc();
    AppMethodBeat.o(136813);
  }
  
  public final void YW() {}
  
  protected final void Zh()
  {
    AppMethodBeat.i(136815);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.Zh();
    synchronized (this.duI)
    {
      if (this.dvG != null) {
        this.dvG.reset();
      }
      AppMethodBeat.o(136815);
      return;
    }
  }
  
  protected final void Zi()
  {
    AppMethodBeat.i(136817);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.Zi();
    if (this.dvG != null)
    {
      this.dvG.ZT();
      if ((this.dvG instanceof com.tencent.mm.audio.mix.g.a.b)) {
        do
        {
          boolean bool = this.dvq.get();
          Zb();
          if (this.dvr.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.dvG.resume();
          }
        } while ((!this.dvr.get()) && (this.dvq.get()));
      }
    }
    AppMethodBeat.o(136817);
  }
  
  public final void Zj()
  {
    AppMethodBeat.i(136820);
    synchronized (this.duI)
    {
      if (this.dvG != null) {
        this.dvG.setVolume(0.0F, 0.0F);
      }
      AppMethodBeat.o(136820);
      return;
    }
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(136818);
    b(paramd, paramByteBuffer, paramInt);
    AppMethodBeat.o(136818);
  }
  
  protected final void b(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(136819);
    if (this.dvl != null) {
      this.dvl.YR();
    }
    c(paramd);
    paramd.complete();
    AppMethodBeat.o(136819);
  }
  
  protected final void c(com.tencent.mm.audio.mix.a.e parame)
  {
    AppMethodBeat.i(136816);
    byte[] arrayOfByte;
    com.tencent.mm.audio.mix.a.d locald;
    if (Za().dtU)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = parame.dtQ;
      if (!this.dvo.get()) {
        if (this.dvG == null)
        {
          locald = Za();
          if ((!locald.aBQ) || (locald.duration > 2000L)) {
            break label183;
          }
        }
      }
    }
    label183:
    for (this.dvG = new com.tencent.mm.audio.mix.g.a.b(this.sampleRate, this.channels, locald, this);; this.dvG = new com.tencent.mm.audio.mix.g.a.c(this.sampleRate, this.channels, locald, this))
    {
      this.dvG.i(this.dvk.iJH);
      this.dvG.setVolume((float)this.dvk.iJG, (float)this.dvk.iJG);
      if (this.dvG != null) {
        this.dvG.Y(arrayOfByte);
      }
      if (parame.dub) {
        com.tencent.mm.audio.mix.b.d.YH().b(parame);
      }
      AppMethodBeat.o(136816);
      return;
      this.sampleRate = parame.sampleRate;
      this.channels = parame.channels;
      break;
    }
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(177344);
    synchronized (this.duI)
    {
      if (this.dvG != null)
      {
        long l = this.dvG.getCurrentPosition();
        AppMethodBeat.o(177344);
        return l;
      }
      AppMethodBeat.o(177344);
      return -1L;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(136811);
    super.onRelease();
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
    synchronized (this.duI)
    {
      if (this.dvG != null)
      {
        this.dvG.release();
        this.dvG = null;
      }
      AppMethodBeat.o(136811);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136812);
    super.pause();
    synchronized (this.duI)
    {
      if (this.dvG != null) {
        this.dvG.pause();
      }
      AppMethodBeat.o(136812);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(136814);
    super.seek(paramInt);
    synchronized (this.duI)
    {
      if (this.dvG != null) {
        this.dvG.seek(paramInt);
      }
      AppMethodBeat.o(136814);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.e
 * JD-Core Version:    0.7.0.1
 */