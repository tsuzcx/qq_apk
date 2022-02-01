package com.tencent.mm.audio.mix.g.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.g.f;
import com.tencent.mm.audio.mix.i.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends a
{
  private static long dxV = 0L;
  private static long dxW = 0L;
  
  public c(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    super(paramInt1, paramInt2, paramd, paramf);
  }
  
  public final void Y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136952);
    if (this.bfn == null)
    {
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
      if (!createAudioTrack())
      {
        if (this.dxR != null) {
          this.dxR.onError(707);
        }
        b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
        AppMethodBeat.o(136952);
        return;
      }
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
    }
    try
    {
      j(this.dxQ);
      this.bfn.play();
      this.bfn.setStereoVolume(this.volume, this.volume);
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
      if (this.dxR != null) {
        this.dxR.Zg();
      }
      this.bfn.setStereoVolume(this.volume, this.volume);
      this.bfn.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      AppMethodBeat.o(136952);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
      }
    }
  }
  
  public final void ZT()
  {
    AppMethodBeat.i(136953);
    super.ZT();
    b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
    AppMethodBeat.o(136953);
  }
  
  protected final boolean createAudioTrack()
  {
    AppMethodBeat.i(136951);
    b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
    if (this.dxO > 1)
    {
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack fail count reach MAX COUNT");
      AppMethodBeat.o(136951);
      return false;
    }
    if (this.channels == 1) {}
    int k;
    for (int i = 4;; i = 12)
    {
      k = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
      if (k > 0) {
        break;
      }
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack miniBufferSize %d is illegal", new Object[] { Integer.valueOf(k) });
      AppMethodBeat.o(136951);
      return false;
    }
    int j = k;
    if (this.dxQ > 1.0D) {
      j = (int)(this.dxQ * k);
    }
    if (this.bfn == null)
    {
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
      System.currentTimeMillis();
      this.bfn = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
      this.dxO += 1;
      dxT.incrementAndGet();
    }
    if ((this.bfn == null) || (this.bfn.getState() != 1))
    {
      dxS.incrementAndGet();
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(dxT.get()), Integer.valueOf(dxS.get()) });
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
      if (this.bfn != null) {
        b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.bfn.getState()) });
      }
      try
      {
        this.bfn.release();
        this.bfn = null;
        AppMethodBeat.o(136951);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", localException, "AudioTrack release", new Object[0]);
        }
      }
    }
    dxU.incrementAndGet();
    b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audioTrackCount:%d", new Object[] { Integer.valueOf(dxU.get()) });
    AppMethodBeat.o(136951);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.g.a.c
 * JD-Core Version:    0.7.0.1
 */