package com.tencent.mm.audio.mix.g.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.g.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends a
{
  private static long dxV = 0L;
  private static long dxW = 0L;
  private Thread aGs;
  
  public b(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    super(paramInt1, paramInt2, paramd, paramf);
  }
  
  public final void Y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136946);
    if (this.bfn == null)
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
      if (!createAudioTrack())
      {
        if (this.dxR != null) {
          this.dxR.onError(707);
        }
        com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
        AppMethodBeat.o(136946);
        return;
      }
    }
    try
    {
      AudioTrack localAudioTrack = this.bfn;
      if (localAudioTrack != null) {
        localAudioTrack.setStereoVolume(this.volume, this.volume);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        int i;
        com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
        continue;
        int j = 3536;
      }
    }
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
    if (this.byteBuffer == null)
    {
      if (this.duL != null)
      {
        j = this.duL.size() * 3536;
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
      if (this.dxP + paramArrayOfByte.length <= this.byteBuffer.length)
      {
        System.arraycopy(paramArrayOfByte, 0, this.byteBuffer, this.dxP, paramArrayOfByte.length);
        this.dxP += paramArrayOfByte.length;
      }
      AppMethodBeat.o(136946);
      return;
    }
  }
  
  public final void ZT()
  {
    AppMethodBeat.i(136947);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(dxT.get()), Integer.valueOf(dxS.get()) });
    if (this.bfn != null)
    {
      if (this.dxR != null) {
        this.dxR.Zg();
      }
      AudioTrack localAudioTrack = this.bfn;
      if ((localAudioTrack.getState() == 2) && (localAudioTrack.write(this.byteBuffer, 0, this.byteBuffer.length) <= 0))
      {
        com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", new Object[] { Integer.valueOf(this.byteBuffer.length) });
        this.dxR.onError(708);
        AppMethodBeat.o(136947);
        return;
      }
      if (localAudioTrack.getState() == 1)
      {
        localAudioTrack.reloadStaticData();
        j(this.dxQ);
        localAudioTrack.play();
        this.aGs = Thread.currentThread();
        try
        {
          long l2 = this.duL.duration;
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
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
        }
      }
    }
    AppMethodBeat.o(136947);
  }
  
  protected final boolean createAudioTrack()
  {
    AppMethodBeat.i(136945);
    if (this.dxO > 1)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
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
      if (this.duL != null)
      {
        i = k;
        if (this.duL.size() > 0) {
          i = this.duL.size() * 3536;
        }
      }
      if (this.dxQ <= 1.0D) {
        break label305;
      }
      double d = this.dxQ;
      i = (int)(i * d);
    }
    label305:
    for (;;)
    {
      for (;;)
      {
        if (this.bfn == null)
        {
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
          System.currentTimeMillis();
          this.bfn = new AudioTrack(3, this.sampleRate, j, 2, i, 0);
          this.dxO += 1;
          dxT.incrementAndGet();
        }
        if ((this.bfn == null) || (this.bfn.getState() != 2))
        {
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
          dxS.incrementAndGet();
          if (this.bfn != null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.bfn.getState()) });
          }
          try
          {
            this.bfn.release();
            this.bfn = null;
            AppMethodBeat.o(136945);
            return false;
            j = 12;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localException, "AudioTrack release", new Object[0]);
            }
          }
        }
      }
      dxU.incrementAndGet();
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audioTrackCount:%d", new Object[] { Integer.valueOf(dxU.get()) });
      AppMethodBeat.o(136945);
      return true;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(136949);
    AudioTrack localAudioTrack = this.bfn;
    if (localAudioTrack != null)
    {
      int i = localAudioTrack.getState();
      int j = localAudioTrack.getPlayState();
      if ((i == 1) && (j == 3)) {
        try
        {
          localAudioTrack.pause();
          this.bNu = localAudioTrack.getPlaybackHeadPosition();
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", new Object[] { Integer.valueOf(this.bNu) });
          if (this.aGs != null) {
            this.aGs.interrupt();
          }
          AppMethodBeat.o(136949);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localException, "pause", new Object[0]);
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
    this.aGs = null;
    AppMethodBeat.o(136950);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(136948);
    AudioTrack localAudioTrack = this.bfn;
    if ((localAudioTrack != null) && (localAudioTrack.getState() == 1))
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
      if (this.dxR != null) {
        this.dxR.Zg();
      }
      try
      {
        localAudioTrack.setStereoVolume(this.volume, this.volume);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", new Object[] { Integer.valueOf(this.bNu) });
        localAudioTrack.setPlaybackHeadPosition(this.bNu);
        localAudioTrack.play();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          try
          {
            long l2 = this.duL.duration;
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
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
          }
          localIllegalStateException = localIllegalStateException;
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(136948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.g.a.b
 * JD-Core Version:    0.7.0.1
 */