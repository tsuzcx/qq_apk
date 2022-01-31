package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.f.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends a
{
  private static long chX = 0L;
  private static long chY = 0L;
  private Thread chW;
  
  public b(int paramInt1, int paramInt2, c paramc, f paramf)
  {
    super(paramInt1, paramInt2, paramc, paramf);
  }
  
  public final void Em()
  {
    AppMethodBeat.i(137198);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(chV.get()), Integer.valueOf(chU.get()) });
    if (this.ayN != null)
    {
      if (this.chS != null) {
        this.chS.DA();
      }
      if ((this.ayN.getState() == 2) && (this.ayN.write(this.byteBuffer, 0, this.byteBuffer.length) <= 0))
      {
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", new Object[] { Integer.valueOf(this.byteBuffer.length) });
        this.chS.onError(708);
        AppMethodBeat.o(137198);
        return;
      }
      if (this.ayN.getState() == 1)
      {
        this.ayN.reloadStaticData();
        this.ayN.play();
        this.chW = Thread.currentThread();
        try
        {
          long l2 = this.cfb.duration;
          long l1 = l2;
          if (l2 <= 0L) {
            l1 = 2000L;
          }
          Thread.sleep(l1);
          AppMethodBeat.o(137198);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
        }
      }
    }
    AppMethodBeat.o(137198);
  }
  
  public final void F(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137197);
    if (this.ayN == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
      if (!createAudioTrack())
      {
        if (this.chS != null) {
          this.chS.onError(707);
        }
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
        AppMethodBeat.o(137197);
        return;
      }
    }
    try
    {
      this.ayN.setStereoVolume(1.0F, 1.0F);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
      if (this.byteBuffer == null)
      {
        if (this.cfb != null)
        {
          j = this.cfb.size() * 3536;
          int i = j;
          if (j == 0) {
            i = 3536;
          }
          j = i;
          if (paramArrayOfByte.length == 3536) {
            j = i + 1;
          }
          this.byteBuffer = new byte[j];
        }
      }
      else
      {
        if (this.chR + paramArrayOfByte.length <= this.byteBuffer.length)
        {
          System.arraycopy(paramArrayOfByte, 0, this.byteBuffer, this.chR, paramArrayOfByte.length);
          this.chR += paramArrayOfByte.length;
        }
        AppMethodBeat.o(137197);
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
        continue;
        int j = 3536;
      }
    }
  }
  
  protected final boolean createAudioTrack()
  {
    AppMethodBeat.i(137196);
    if (this.chQ > 1)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
      AppMethodBeat.o(137196);
      return false;
    }
    int i;
    if (this.channels == 1) {
      i = 4;
    }
    for (;;)
    {
      int k = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
      int j = k;
      if (this.cfb != null)
      {
        j = k;
        if (this.cfb.size() > 0) {
          j = this.cfb.size() * 3536;
        }
      }
      if (this.ayN == null)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
        System.currentTimeMillis();
        this.ayN = new AudioTrack(3, this.sampleRate, i, 2, j, 0);
        this.chQ += 1;
        chV.incrementAndGet();
      }
      if ((this.ayN == null) || (this.ayN.getState() != 2))
      {
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
        chU.incrementAndGet();
        if (this.ayN != null) {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.ayN.getState()) });
        }
        try
        {
          this.ayN.release();
          this.ayN = null;
          AppMethodBeat.o(137196);
          return false;
          i = 12;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localException, "AudioTrack release", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(137196);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137200);
    if (this.ayN != null)
    {
      int i = this.ayN.getState();
      int j = this.ayN.getPlayState();
      if ((i == 1) && (j == 3)) {
        try
        {
          this.ayN.pause();
          this.chT = this.ayN.getPlaybackHeadPosition();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", new Object[] { Integer.valueOf(this.chT) });
          if (this.chW != null) {
            this.chW.interrupt();
          }
          AppMethodBeat.o(137200);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localException, "pause", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(137200);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(137201);
    super.reset();
    Ej();
    this.chW = null;
    AppMethodBeat.o(137201);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137199);
    if ((this.ayN != null) && (this.ayN.getState() == 1))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
      if (this.chS != null) {
        this.chS.DA();
      }
      try
      {
        this.ayN.setStereoVolume(1.0F, 1.0F);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", new Object[] { Integer.valueOf(this.chT) });
        this.ayN.setPlaybackHeadPosition(this.chT);
        this.ayN.play();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          try
          {
            long l2 = this.cfb.duration;
            long l1 = l2;
            if (l2 <= 0L) {
              l1 = 2000L;
            }
            Thread.sleep(l1);
            AppMethodBeat.o(137199);
            return;
          }
          catch (Exception localException)
          {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
          }
          localIllegalStateException = localIllegalStateException;
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(137199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.b
 * JD-Core Version:    0.7.0.1
 */