package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.f.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object cRu;
  private a cSn;
  
  public e(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(136810);
    this.cRu = new Object();
    AppMethodBeat.o(136810);
  }
  
  public final void MW()
  {
    AppMethodBeat.i(136813);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    hB(5);
    this.cSd.set(true);
    this.cSf.set(false);
    Nd();
    AppMethodBeat.o(136813);
  }
  
  public final void MX() {}
  
  protected final void Ni()
  {
    AppMethodBeat.i(136815);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.Ni();
    synchronized (this.cRu)
    {
      if (this.cSn != null) {
        this.cSn.reset();
      }
      AppMethodBeat.o(136815);
      return;
    }
  }
  
  protected final void Nj()
  {
    AppMethodBeat.i(136817);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.Nj();
    if (this.cSn != null)
    {
      this.cSn.NS();
      if ((this.cSn instanceof com.tencent.mm.audio.mix.f.a.b)) {
        do
        {
          boolean bool = this.cSc.get();
          Nc();
          if (this.cSd.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.cSn.resume();
          }
        } while ((!this.cSd.get()) && (this.cSc.get()));
      }
    }
    AppMethodBeat.o(136817);
  }
  
  public final void Nk()
  {
    AppMethodBeat.i(136820);
    synchronized (this.cRu)
    {
      if (this.cSn != null) {
        this.cSn.setVolume(0.0F, 0.0F);
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
    if (this.cRX != null) {
      this.cRX.MR();
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
    if (Nb().cQL)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = parame.cQH;
      if (!this.cSa.get()) {
        if (this.cSn == null)
        {
          locald = Nb();
          if ((!locald.aAb) || (locald.duration > 2000L)) {
            break label183;
          }
        }
      }
    }
    label183:
    for (this.cSn = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, locald, this);; this.cSn = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, locald, this))
    {
      this.cSn.h(this.cRW.htq);
      this.cSn.setVolume((float)this.cRW.htp, (float)this.cRW.htp);
      if (this.cSn != null) {
        this.cSn.K(arrayOfByte);
      }
      if (parame.cQS) {
        com.tencent.mm.audio.mix.b.c.MH().b(parame);
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
    synchronized (this.cRu)
    {
      if (this.cSn != null)
      {
        long l = this.cSn.getCurrentPosition();
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
    synchronized (this.cRu)
    {
      if (this.cSn != null)
      {
        this.cSn.release();
        this.cSn = null;
      }
      AppMethodBeat.o(136811);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136812);
    super.pause();
    synchronized (this.cRu)
    {
      if (this.cSn != null) {
        this.cSn.pause();
      }
      AppMethodBeat.o(136812);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(136814);
    super.seek(paramInt);
    synchronized (this.cRu)
    {
      if (this.cSn != null) {
        this.cSn.seek(paramInt);
      }
      AppMethodBeat.o(136814);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.e
 * JD-Core Version:    0.7.0.1
 */