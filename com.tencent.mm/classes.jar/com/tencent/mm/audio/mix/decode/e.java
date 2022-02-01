package com.tencent.mm.audio.mix.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.audio.mix.f.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object hrB;
  private a hsz;
  
  public e(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.c paramc)
  {
    super(paramd, paramc);
    AppMethodBeat.i(136810);
    this.hrB = new Object();
    AppMethodBeat.o(136810);
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(136818);
    b(paramd, paramByteBuffer, paramInt);
    AppMethodBeat.o(136818);
  }
  
  public final void aFC()
  {
    AppMethodBeat.i(136813);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    ob(5);
    this.hsk.set(true);
    this.hsm.set(false);
    aFK();
    AppMethodBeat.o(136813);
  }
  
  public final void aFD() {}
  
  protected final void aFP()
  {
    AppMethodBeat.i(136815);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.aFP();
    synchronized (this.hrB)
    {
      if (this.hsz != null) {
        this.hsz.reset();
      }
      AppMethodBeat.o(136815);
      return;
    }
  }
  
  protected final void aFQ()
  {
    AppMethodBeat.i(136817);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.aFQ();
    if (this.hsz != null)
    {
      this.hsz.aGA();
      if ((this.hsz instanceof com.tencent.mm.audio.mix.f.a.b)) {
        do
        {
          boolean bool = this.hsj.get();
          aFJ();
          if (this.hsk.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.hsz.resume();
          }
        } while ((!this.hsk.get()) && (this.hsj.get()));
      }
    }
    AppMethodBeat.o(136817);
  }
  
  protected final void b(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(136819);
    if (this.hse != null) {
      this.hse.aFx();
    }
    c(paramd);
    paramd.GK();
    AppMethodBeat.o(136819);
  }
  
  protected final void c(com.tencent.mm.audio.mix.a.e parame)
  {
    AppMethodBeat.i(136816);
    byte[] arrayOfByte;
    com.tencent.mm.audio.mix.a.d locald;
    if (aFI().hqN)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = parame.hqJ;
      if (!this.hsh.get()) {
        if (this.hsz == null)
        {
          locald = aFI();
          if ((!locald.ckB) || (locald.duration > 2000L)) {
            break label183;
          }
        }
      }
    }
    label183:
    for (this.hsz = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, locald, this);; this.hsz = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, locald, this))
    {
      this.hsz.y(this.hsd.orm);
      this.hsz.setVolume((float)this.hsd.orl, (float)this.hsd.orl);
      if (this.hsz != null) {
        this.hsz.af(arrayOfByte);
      }
      if (parame.hqU) {
        com.tencent.mm.audio.mix.b.d.aFn().b(parame);
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
    synchronized (this.hrB)
    {
      if (this.hsz != null)
      {
        long l = this.hsz.getCurrentPosition();
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
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
    synchronized (this.hrB)
    {
      if (this.hsz != null)
      {
        this.hsz.release();
        this.hsz = null;
      }
      AppMethodBeat.o(136811);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136812);
    super.pause();
    synchronized (this.hrB)
    {
      if (this.hsz != null) {
        this.hsz.pause();
      }
      AppMethodBeat.o(136812);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(136814);
    super.seek(paramInt);
    synchronized (this.hrB)
    {
      if (this.hsz != null) {
        this.hsz.seek(paramInt);
      }
      AppMethodBeat.o(136814);
      return;
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(236230);
    synchronized (this.hrB)
    {
      if (this.hsz != null) {
        this.hsz.setVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(236230);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.e
 * JD-Core Version:    0.7.0.1
 */