package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.mm.audio.mix.h.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends a
{
  private static long cUt = 0L;
  private static long cUu = 0L;
  
  public c(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    super(paramInt1, paramInt2, paramd, paramf);
  }
  
  public final void K(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136952);
    if (this.aUW == null)
    {
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
      if (!createAudioTrack())
      {
        if (this.cUp != null) {
          this.cUp.onError(707);
        }
        b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
        AppMethodBeat.o(136952);
        return;
      }
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
    }
    try
    {
      i(this.cUo);
      this.aUW.play();
      this.aUW.setStereoVolume(this.volume, this.volume);
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
      if (this.cUp != null) {
        this.cUp.Nh();
      }
      this.aUW.setStereoVolume(this.volume, this.volume);
      this.aUW.write(paramArrayOfByte, 0, paramArrayOfByte.length);
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
  
  public final void NS()
  {
    AppMethodBeat.i(136953);
    super.NS();
    b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
    AppMethodBeat.o(136953);
  }
  
  protected final boolean createAudioTrack()
  {
    AppMethodBeat.i(136951);
    b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
    if (this.cUm > 1)
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
    if (this.cUo > 1.0D) {
      j = (int)(this.cUo * k);
    }
    if (this.aUW == null)
    {
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
      System.currentTimeMillis();
      this.aUW = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
      this.cUm += 1;
      cUs.incrementAndGet();
    }
    if ((this.aUW == null) || (this.aUW.getState() != 1))
    {
      cUr.incrementAndGet();
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(cUs.get()), Integer.valueOf(cUr.get()) });
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
      if (this.aUW != null) {
        b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.aUW.getState()) });
      }
      try
      {
        this.aUW.release();
        this.aUW = null;
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
    AppMethodBeat.o(136951);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.c
 * JD-Core Version:    0.7.0.1
 */