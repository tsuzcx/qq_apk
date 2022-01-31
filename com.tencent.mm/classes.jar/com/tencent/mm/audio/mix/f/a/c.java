package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.mm.audio.mix.h.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends a
{
  private static long chX = 0L;
  private static long chY = 0L;
  
  public c(int paramInt1, int paramInt2, com.tencent.mm.audio.mix.a.c paramc, f paramf)
  {
    super(paramInt1, paramInt2, paramc, paramf);
  }
  
  public final void Em()
  {
    AppMethodBeat.i(137204);
    super.Em();
    b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
    AppMethodBeat.o(137204);
  }
  
  public final void F(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137203);
    if (this.ayN == null)
    {
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
      if (!createAudioTrack())
      {
        if (this.chS != null) {
          this.chS.onError(707);
        }
        b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
        AppMethodBeat.o(137203);
        return;
      }
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
    }
    try
    {
      this.ayN.play();
      this.ayN.setStereoVolume(1.0F, 1.0F);
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
      if (this.chS != null) {
        this.chS.DA();
      }
      this.ayN.setStereoVolume(1.0F, 1.0F);
      this.ayN.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      AppMethodBeat.o(137203);
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
  
  protected final boolean createAudioTrack()
  {
    AppMethodBeat.i(137202);
    b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
    if (this.chQ > 1)
    {
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack fail count reach MAX COUNT");
      AppMethodBeat.o(137202);
      return false;
    }
    if (this.channels == 1) {}
    int j;
    for (int i = 4;; i = 12)
    {
      j = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
      if (j > 0) {
        break;
      }
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack miniBufferSize %d is illegal", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(137202);
      return false;
    }
    if (this.ayN == null)
    {
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
      System.currentTimeMillis();
      this.ayN = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
      this.chQ += 1;
      chV.incrementAndGet();
    }
    if ((this.ayN == null) || (this.ayN.getState() != 1))
    {
      chU.incrementAndGet();
      b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(chV.get()), Integer.valueOf(chU.get()) });
      b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
      if (this.ayN != null) {
        b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.ayN.getState()) });
      }
      try
      {
        this.ayN.release();
        this.ayN = null;
        AppMethodBeat.o(137202);
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
    AppMethodBeat.o(137202);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.c
 * JD-Core Version:    0.7.0.1
 */