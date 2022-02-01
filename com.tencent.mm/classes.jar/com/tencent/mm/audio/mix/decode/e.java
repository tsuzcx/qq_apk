package com.tencent.mm.audio.mix.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.audio.mix.f.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object fnq;
  private a fop;
  
  public e(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.c paramc)
  {
    super(paramd, paramc);
    AppMethodBeat.i(136810);
    this.fnq = new Object();
    AppMethodBeat.o(136810);
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(136818);
    b(paramd, paramByteBuffer, paramInt);
    AppMethodBeat.o(136818);
  }
  
  public final void adE()
  {
    AppMethodBeat.i(136813);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    ku(5);
    this.fnZ.set(true);
    this.fob.set(false);
    adL();
    AppMethodBeat.o(136813);
  }
  
  public final void adF() {}
  
  protected final void adQ()
  {
    AppMethodBeat.i(136815);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.adQ();
    synchronized (this.fnq)
    {
      if (this.fop != null) {
        this.fop.reset();
      }
      AppMethodBeat.o(136815);
      return;
    }
  }
  
  protected final void adR()
  {
    AppMethodBeat.i(136817);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.adR();
    if (this.fop != null)
    {
      this.fop.aeC();
      if ((this.fop instanceof com.tencent.mm.audio.mix.f.a.b)) {
        do
        {
          boolean bool = this.fnY.get();
          adK();
          if (this.fnZ.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.fop.resume();
          }
        } while ((!this.fnZ.get()) && (this.fnY.get()));
      }
    }
    AppMethodBeat.o(136817);
  }
  
  public final void adS()
  {
    AppMethodBeat.i(136820);
    synchronized (this.fnq)
    {
      if (this.fop != null) {
        this.fop.setVolume(0.0F, 0.0F);
      }
      AppMethodBeat.o(136820);
      return;
    }
  }
  
  protected final void b(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(136819);
    if (this.fnT != null) {
      this.fnT.ady();
    }
    c(paramd);
    paramd.ph();
    AppMethodBeat.o(136819);
  }
  
  protected final void c(com.tencent.mm.audio.mix.a.e parame)
  {
    AppMethodBeat.i(136816);
    byte[] arrayOfByte;
    com.tencent.mm.audio.mix.a.d locald;
    if (adJ().fmC)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = parame.fmy;
      if (!this.fnW.get()) {
        if (this.fop == null)
        {
          locald = adJ();
          if ((!locald.awf) || (locald.duration > 2000L)) {
            break label183;
          }
        }
      }
    }
    label183:
    for (this.fop = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, locald, this);; this.fop = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, locald, this))
    {
      this.fop.i(this.fnS.lzL);
      this.fop.setVolume((float)this.fnS.lzK, (float)this.fnS.lzK);
      if (this.fop != null) {
        this.fop.af(arrayOfByte);
      }
      if (parame.fmJ) {
        com.tencent.mm.audio.mix.b.d.ado().b(parame);
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
    synchronized (this.fnq)
    {
      if (this.fop != null)
      {
        long l = this.fop.getCurrentPosition();
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
    synchronized (this.fnq)
    {
      if (this.fop != null)
      {
        this.fop.release();
        this.fop = null;
      }
      AppMethodBeat.o(136811);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136812);
    super.pause();
    synchronized (this.fnq)
    {
      if (this.fop != null) {
        this.fop.pause();
      }
      AppMethodBeat.o(136812);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(136814);
    super.seek(paramInt);
    synchronized (this.fnq)
    {
      if (this.fop != null) {
        this.fop.seek(paramInt);
      }
      AppMethodBeat.o(136814);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.e
 * JD-Core Version:    0.7.0.1
 */