package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.f.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends a
{
  private static long cWX = 0L;
  private static long cWY = 0L;
  private Thread aDS;
  
  public b(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    super(paramInt1, paramInt2, paramd, paramf);
  }
  
  public final void M(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136946);
    if (this.aUg == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
      if (!createAudioTrack())
      {
        if (this.cWT != null) {
          this.cWT.onError(707);
        }
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
        AppMethodBeat.o(136946);
        return;
      }
    }
    try
    {
      AudioTrack localAudioTrack = this.aUg;
      if (localAudioTrack != null) {
        localAudioTrack.setStereoVolume(this.volume, this.volume);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        int i;
        com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
        continue;
        int j = 3536;
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
    if (this.byteBuffer == null)
    {
      if (this.cUa != null)
      {
        j = this.cUa.size() * 3536;
        i = j;
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
      if (this.cWR + paramArrayOfByte.length <= this.byteBuffer.length)
      {
        System.arraycopy(paramArrayOfByte, 0, this.byteBuffer, this.cWR, paramArrayOfByte.length);
        this.cWR += paramArrayOfByte.length;
      }
      AppMethodBeat.o(136946);
      return;
    }
  }
  
  public final void NV()
  {
    AppMethodBeat.i(136947);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(cWW.get()), Integer.valueOf(cWV.get()) });
    if (this.aUg != null)
    {
      if (this.cWT != null) {
        this.cWT.Nj();
      }
      AudioTrack localAudioTrack = this.aUg;
      if ((localAudioTrack.getState() == 2) && (localAudioTrack.write(this.byteBuffer, 0, this.byteBuffer.length) <= 0))
      {
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", new Object[] { Integer.valueOf(this.byteBuffer.length) });
        this.cWT.onError(708);
        AppMethodBeat.o(136947);
        return;
      }
      if (localAudioTrack.getState() == 1)
      {
        localAudioTrack.reloadStaticData();
        i(this.cWS);
        localAudioTrack.play();
        this.aDS = Thread.currentThread();
        try
        {
          long l2 = this.cUa.duration;
          long l1 = l2;
          if (l2 <= 0L) {
            l1 = 2000L;
          }
          Thread.sleep(l1);
          AppMethodBeat.o(136947);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
        }
      }
    }
    AppMethodBeat.o(136947);
  }
  
  protected final boolean createAudioTrack()
  {
    AppMethodBeat.i(136945);
    if (this.cWQ > 1)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
      AppMethodBeat.o(136945);
      return false;
    }
    int j;
    int i;
    if (this.channels == 1)
    {
      j = 4;
      int k = AudioTrack.getMinBufferSize(this.sampleRate, j, 2);
      i = k;
      if (this.cUa != null)
      {
        i = k;
        if (this.cUa.size() > 0) {
          i = this.cUa.size() * 3536;
        }
      }
      if (this.cWS <= 1.0D) {
        break label275;
      }
      double d = this.cWS;
      i = (int)(i * d);
    }
    label275:
    for (;;)
    {
      for (;;)
      {
        if (this.aUg == null)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
          System.currentTimeMillis();
          this.aUg = new AudioTrack(3, this.sampleRate, j, 2, i, 0);
          this.cWQ += 1;
          cWW.incrementAndGet();
        }
        if ((this.aUg == null) || (this.aUg.getState() != 2))
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
          cWV.incrementAndGet();
          if (this.aUg != null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.aUg.getState()) });
          }
          try
          {
            this.aUg.release();
            this.aUg = null;
            AppMethodBeat.o(136945);
            return false;
            j = 12;
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
      AppMethodBeat.o(136945);
      return true;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136949);
    AudioTrack localAudioTrack = this.aUg;
    if (localAudioTrack != null)
    {
      int i = localAudioTrack.getState();
      int j = localAudioTrack.getPlayState();
      if ((i == 1) && (j == 3)) {
        try
        {
          localAudioTrack.pause();
          this.cWU = localAudioTrack.getPlaybackHeadPosition();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", new Object[] { Integer.valueOf(this.cWU) });
          if (this.aDS != null) {
            this.aDS.interrupt();
          }
          AppMethodBeat.o(136949);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localException, "pause", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(136949);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(136950);
    super.reset();
    releaseAudioTrack();
    this.aDS = null;
    AppMethodBeat.o(136950);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(136948);
    AudioTrack localAudioTrack = this.aUg;
    if ((localAudioTrack != null) && (localAudioTrack.getState() == 1))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
      if (this.cWT != null) {
        this.cWT.Nj();
      }
      try
      {
        localAudioTrack.setStereoVolume(this.volume, this.volume);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", new Object[] { Integer.valueOf(this.cWU) });
        localAudioTrack.setPlaybackHeadPosition(this.cWU);
        localAudioTrack.play();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          try
          {
            long l2 = this.cUa.duration;
            long l1 = l2;
            if (l2 <= 0L) {
              l1 = 2000L;
            }
            Thread.sleep(l1);
            AppMethodBeat.o(136948);
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
    AppMethodBeat.o(136948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.b
 * JD-Core Version:    0.7.0.1
 */