package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.f.a.a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends d
{
  private Object dcK;
  private a ddD;
  
  public e(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(136810);
    this.dcK = new Object();
    AppMethodBeat.o(136810);
  }
  
  public final void OF()
  {
    AppMethodBeat.i(136813);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
    hI(5);
    this.ddt.set(true);
    this.ddv.set(false);
    OM();
    AppMethodBeat.o(136813);
  }
  
  public final void OG() {}
  
  protected final void OR()
  {
    AppMethodBeat.i(136815);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
    super.OR();
    synchronized (this.dcK)
    {
      if (this.ddD != null) {
        this.ddD.reset();
      }
      AppMethodBeat.o(136815);
      return;
    }
  }
  
  protected final void OS()
  {
    AppMethodBeat.i(136817);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
    super.OS();
    if (this.ddD != null)
    {
      this.ddD.PB();
      if ((this.ddD instanceof com.tencent.mm.audio.mix.f.a.b)) {
        do
        {
          boolean bool = this.dds.get();
          OL();
          if (this.ddt.get()) {
            break;
          }
          if (bool)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
            this.ddD.resume();
          }
        } while ((!this.ddt.get()) && (this.dds.get()));
      }
    }
    AppMethodBeat.o(136817);
  }
  
  public final void OT()
  {
    AppMethodBeat.i(136820);
    synchronized (this.dcK)
    {
      if (this.ddD != null) {
        this.ddD.setVolume(0.0F, 0.0F);
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
    if (this.ddn != null) {
      this.ddn.OA();
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
    if (OK().dcb)
    {
      this.sampleRate = 44100;
      this.channels = 2;
      arrayOfByte = parame.dbX;
      if (!this.ddq.get()) {
        if (this.ddD == null)
        {
          locald = OK();
          if ((!locald.aBS) || (locald.duration > 2000L)) {
            break label183;
          }
        }
      }
    }
    label183:
    for (this.ddD = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, locald, this);; this.ddD = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, locald, this))
    {
      this.ddD.h(this.ddm.hLI);
      this.ddD.setVolume((float)this.ddm.hLH, (float)this.ddm.hLH);
      if (this.ddD != null) {
        this.ddD.K(arrayOfByte);
      }
      if (parame.dci) {
        com.tencent.mm.audio.mix.b.c.Oq().b(parame);
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
    synchronized (this.dcK)
    {
      if (this.ddD != null)
      {
        long l = this.ddD.getCurrentPosition();
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
    synchronized (this.dcK)
    {
      if (this.ddD != null)
      {
        this.ddD.release();
        this.ddD = null;
      }
      AppMethodBeat.o(136811);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136812);
    super.pause();
    synchronized (this.dcK)
    {
      if (this.ddD != null) {
        this.ddD.pause();
      }
      AppMethodBeat.o(136812);
      return;
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(136814);
    super.seek(paramInt);
    synchronized (this.dcK)
    {
      if (this.ddD != null) {
        this.ddD.seek(paramInt);
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