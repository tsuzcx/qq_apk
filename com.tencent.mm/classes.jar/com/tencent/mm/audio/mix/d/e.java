package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.f.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object ddM;
  private a deF;
  
  public e(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(136810);
    this.ddM = new Object();
    AppMethodBeat.o(136810);
  }
  
  public final void OD()
  {
    AppMethodBeat.i(136813);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    hK(5);
    this.dev.set(true);
    this.dex.set(false);
    OK();
    AppMethodBeat.o(136813);
  }
  
  public final void OE() {}
  
  protected final void OP()
  {
    AppMethodBeat.i(136815);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.OP();
    synchronized (this.ddM)
    {
      if (this.deF != null) {
        this.deF.reset();
      }
      AppMethodBeat.o(136815);
      return;
    }
  }
  
  protected final void OQ()
  {
    AppMethodBeat.i(136817);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.OQ();
    if (this.deF != null)
    {
      this.deF.Pz();
      if ((this.deF instanceof com.tencent.mm.audio.mix.f.a.b)) {
        do
        {
          boolean bool = this.deu.get();
          OJ();
          if (this.dev.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.deF.resume();
          }
        } while ((!this.dev.get()) && (this.deu.get()));
      }
    }
    AppMethodBeat.o(136817);
  }
  
  public final void OR()
  {
    AppMethodBeat.i(136820);
    synchronized (this.ddM)
    {
      if (this.deF != null) {
        this.deF.setVolume(0.0F, 0.0F);
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
    if (this.dep != null) {
      this.dep.Oy();
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
    if (OI().ddd)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = parame.dcZ;
      if (!this.des.get()) {
        if (this.deF == null)
        {
          locald = OI();
          if ((!locald.aBS) || (locald.duration > 2000L)) {
            break label183;
          }
        }
      }
    }
    label183:
    for (this.deF = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, locald, this);; this.deF = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, locald, this))
    {
      this.deF.h(this.deo.hOB);
      this.deF.setVolume((float)this.deo.hOA, (float)this.deo.hOA);
      if (this.deF != null) {
        this.deF.K(arrayOfByte);
      }
      if (parame.ddk) {
        com.tencent.mm.audio.mix.b.c.Oo().b(parame);
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
    synchronized (this.ddM)
    {
      if (this.deF != null)
      {
        long l = this.deF.getCurrentPosition();
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
    synchronized (this.ddM)
    {
      if (this.deF != null)
      {
        this.deF.release();
        this.deF = null;
      }
      AppMethodBeat.o(136811);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136812);
    super.pause();
    synchronized (this.ddM)
    {
      if (this.deF != null) {
        this.deF.pause();
      }
      AppMethodBeat.o(136812);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(136814);
    super.seek(paramInt);
    synchronized (this.ddM)
    {
      if (this.deF != null) {
        this.deF.seek(paramInt);
      }
      AppMethodBeat.o(136814);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.e
 * JD-Core Version:    0.7.0.1
 */