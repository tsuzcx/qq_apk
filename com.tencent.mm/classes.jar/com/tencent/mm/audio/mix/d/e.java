package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.f.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object cTX;
  private a cUR;
  
  public e(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(136810);
    this.cTX = new Object();
    AppMethodBeat.o(136810);
  }
  
  public final void MY()
  {
    AppMethodBeat.i(136813);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    hR(5);
    this.cUH.set(true);
    this.cUJ.set(false);
    Nf();
    AppMethodBeat.o(136813);
  }
  
  public final void MZ() {}
  
  protected final void Nk()
  {
    AppMethodBeat.i(136815);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.Nk();
    synchronized (this.cTX)
    {
      if (this.cUR != null) {
        this.cUR.reset();
      }
      AppMethodBeat.o(136815);
      return;
    }
  }
  
  protected final void Nl()
  {
    AppMethodBeat.i(136817);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.Nl();
    if (this.cUR != null)
    {
      this.cUR.NV();
      if ((this.cUR instanceof com.tencent.mm.audio.mix.f.a.b)) {
        do
        {
          boolean bool = this.cUG.get();
          Ne();
          if (this.cUH.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.cUR.resume();
          }
        } while ((!this.cUH.get()) && (this.cUG.get()));
      }
    }
    AppMethodBeat.o(136817);
  }
  
  public final void Nm()
  {
    AppMethodBeat.i(136820);
    synchronized (this.cTX)
    {
      if (this.cUR != null) {
        this.cUR.setVolume(0.0F, 0.0F);
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
    if (this.cUA != null) {
      this.cUA.MT();
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
    if (Nd().cTo)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = parame.cTk;
      if (!this.cUE.get()) {
        if (this.cUR == null)
        {
          locald = Nd();
          if ((!locald.azh) || (locald.duration > 2000L)) {
            break label183;
          }
        }
      }
    }
    label183:
    for (this.cUR = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, locald, this);; this.cUR = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, locald, this))
    {
      this.cUR.h(this.cUz.gSR);
      this.cUR.setVolume((float)this.cUz.gSQ, (float)this.cUz.gSQ);
      if (this.cUR != null) {
        this.cUR.M(arrayOfByte);
      }
      if (parame.cTv) {
        com.tencent.mm.audio.mix.b.c.MJ().b(parame);
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
    synchronized (this.cTX)
    {
      if (this.cUR != null)
      {
        long l = this.cUR.getCurrentPosition();
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
    synchronized (this.cTX)
    {
      if (this.cUR != null)
      {
        this.cUR.release();
        this.cUR = null;
      }
      AppMethodBeat.o(136811);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136812);
    super.pause();
    synchronized (this.cTX)
    {
      if (this.cUR != null) {
        this.cUR.pause();
      }
      AppMethodBeat.o(136812);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(136814);
    super.seek(paramInt);
    synchronized (this.cTX)
    {
      if (this.cUR != null) {
        this.cUR.seek(paramInt);
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