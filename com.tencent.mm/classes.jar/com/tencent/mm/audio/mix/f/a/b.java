package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.f.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends a
{
  private static long huT = 0L;
  private static long huU = 0L;
  private Thread huS;
  
  public b(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    super(paramInt1, paramInt2, paramd, paramf);
  }
  
  public final void aGA()
  {
    AppMethodBeat.i(136947);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(huQ.get()), Integer.valueOf(huP.get()) });
    if (this.cIK != null)
    {
      if (this.huO != null) {
        this.huO.aFO();
      }
      AudioTrack localAudioTrack = this.cIK;
      if ((localAudioTrack.getState() == 2) && (localAudioTrack.write(this.byteBuffer, 0, this.byteBuffer.length) <= 0))
      {
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", new Object[] { Integer.valueOf(this.byteBuffer.length) });
        this.huO.oc(708);
        AppMethodBeat.o(136947);
        return;
      }
      if (localAudioTrack.getState() == 1)
      {
        localAudioTrack.reloadStaticData();
        z(this.huN);
        localAudioTrack.play();
        this.huS = Thread.currentThread();
        try
        {
          long l1 = this.hrE.duration;
          if (l1 <= 0L) {
            l1 = 2000L;
          }
          for (;;)
          {
            Thread.sleep(l1);
            AppMethodBeat.o(136947);
            return;
            if (l1 < 1000L)
            {
              l1 += huK;
            }
            else
            {
              long l2 = huJ;
              l1 += l2;
            }
          }
          AppMethodBeat.o(136947);
        }
        catch (Exception localException)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
        }
      }
    }
  }
  
  public final void af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136946);
    if (this.cIK == null)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
      if (!createAudioTrack())
      {
        if (this.huO != null) {
          this.huO.oc(707);
        }
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
        AppMethodBeat.o(136946);
        return;
      }
    }
    try
    {
      AudioTrack localAudioTrack = this.cIK;
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
      if (this.hrE != null)
      {
        j = this.hrE.size() * 3536;
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
      if (this.huM + paramArrayOfByte.length <= this.byteBuffer.length)
      {
        System.arraycopy(paramArrayOfByte, 0, this.byteBuffer, this.huM, paramArrayOfByte.length);
        this.huM += paramArrayOfByte.length;
      }
      AppMethodBeat.o(136946);
      return;
    }
  }
  
  protected final boolean createAudioTrack()
  {
    AppMethodBeat.i(136945);
    if (this.huL > 1)
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
      if (this.hrE != null)
      {
        i = k;
        if (this.hrE.size() > 0) {
          i = this.hrE.size() * 3536;
        }
      }
      if (this.huN <= 1.0D) {
        break label305;
      }
      double d = this.huN;
      i = (int)(i * d);
    }
    label305:
    for (;;)
    {
      for (;;)
      {
        if (this.cIK == null)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
          System.currentTimeMillis();
          this.cIK = new AudioTrack(3, this.sampleRate, j, 2, i, 0);
          this.huL += 1;
          huQ.incrementAndGet();
        }
        if ((this.cIK == null) || (this.cIK.getState() != 2))
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
          huP.incrementAndGet();
          if (this.cIK != null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.cIK.getState()) });
          }
          try
          {
            this.cIK.release();
            this.cIK = null;
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
      huR.incrementAndGet();
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audioTrackCount:%d", new Object[] { Integer.valueOf(huR.get()) });
      AppMethodBeat.o(136945);
      return true;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136949);
    AudioTrack localAudioTrack = this.cIK;
    if (localAudioTrack != null)
    {
      int i = localAudioTrack.getState();
      int j = localAudioTrack.getPlayState();
      if ((i == 1) && (j == 3)) {
        try
        {
          localAudioTrack.pause();
          this.dIY = localAudioTrack.getPlaybackHeadPosition();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", new Object[] { Integer.valueOf(this.dIY) });
          if (this.huS != null) {
            this.huS.interrupt();
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
    this.huS = null;
    AppMethodBeat.o(136950);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(136948);
    AudioTrack localAudioTrack = this.cIK;
    if ((localAudioTrack != null) && (localAudioTrack.getState() == 1))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
      if (this.huO != null) {
        this.huO.aFO();
      }
      try
      {
        localAudioTrack.setStereoVolume(this.volume, this.volume);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", new Object[] { Integer.valueOf(this.dIY) });
        localAudioTrack.setPlaybackHeadPosition(this.dIY);
        localAudioTrack.play();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        try
        {
          long l1 = this.hrE.duration;
          if (l1 <= 0L) {
            l1 = 2000L;
          }
          for (;;)
          {
            Thread.sleep(l1);
            AppMethodBeat.o(136948);
            return;
            localIllegalStateException = localIllegalStateException;
            com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
            break;
            if (l1 < 1000L)
            {
              l1 += huK;
            }
            else
            {
              long l2 = huJ;
              l1 += l2;
            }
          }
          AppMethodBeat.o(136948);
        }
        catch (Exception localException)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.b
 * JD-Core Version:    0.7.0.1
 */