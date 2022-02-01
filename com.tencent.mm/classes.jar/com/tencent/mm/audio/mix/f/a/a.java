package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.mm.audio.mix.h.b;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
{
  protected static long fqA = 120L;
  protected static long fqB = 240L;
  protected static volatile AtomicInteger fqG = new AtomicInteger(0);
  protected static volatile AtomicInteger fqH = new AtomicInteger(0);
  protected static volatile AtomicInteger fqI = new AtomicInteger(0);
  protected volatile AudioTrack aOO;
  protected int bPt = 0;
  protected byte[] byteBuffer;
  protected int channels = 0;
  protected long clF = -1L;
  protected d fnt;
  protected int fqC = 0;
  protected int fqD = 0;
  protected double fqE = 0.0D;
  protected f fqF;
  protected int sampleRate = 0;
  protected float volume = 1.0F;
  
  public a(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.fnt = paramd;
    this.fqF = paramf;
  }
  
  public void aeC() {}
  
  public void af(byte[] paramArrayOfByte) {}
  
  protected abstract boolean createAudioTrack();
  
  public final long getCurrentPosition()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.aOO != null)
      {
        l1 = l2;
        if (this.aOO.getState() != 0)
        {
          l1 = l2;
          l2 = Math.round(this.aOO.getPlaybackHeadPosition() / this.aOO.getSampleRate() * 1000.0D);
          l1 = l2;
          this.clF = l2;
          return l2;
        }
      }
      l1 = l2;
      l2 = this.clF;
      return l2;
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "getCurrentPosition", new Object[0]);
    }
    return l1;
  }
  
  public final void i(double paramDouble)
  {
    this.fqE = paramDouble;
  }
  
  public final void j(double paramDouble)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", new Object[] { Double.valueOf(paramDouble) });
    }
    try
    {
      if ((this.aOO != null) && ((this.aOO.getState() == 1) || (this.aOO.getState() == 2)))
      {
        PlaybackParams localPlaybackParams = this.aOO.getPlaybackParams();
        localPlaybackParams.setSpeed((float)paramDouble);
        this.aOO.setPlaybackParams(localPlaybackParams);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localIllegalStateException, "setPlaybackRate", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "setPlaybackRate", new Object[0]);
    }
  }
  
  public void pause() {}
  
  public final void release()
  {
    releaseAudioTrack();
    this.fqF = null;
    this.fnt = null;
    this.byteBuffer = null;
    this.fqC = 0;
    this.fqD = 0;
  }
  
  protected final void releaseAudioTrack()
  {
    try
    {
      if (this.aOO != null) {
        fqI.decrementAndGet();
      }
      if ((this.aOO != null) && (this.aOO.getState() != 0))
      {
        this.aOO.stop();
        this.aOO.flush();
      }
      if (this.aOO != null)
      {
        this.aOO.release();
        this.aOO = null;
      }
      return;
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "releaseAudioTrack", new Object[0]);
    }
  }
  
  public void reset()
  {
    this.fqC = 0;
    this.fqD = 0;
    if (this.byteBuffer != null) {
      Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte)0);
    }
  }
  
  public void resume() {}
  
  public final void seek(int paramInt)
  {
    b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.bPt) });
    this.bPt = paramInt;
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      if ((this.aOO != null) && ((this.aOO.getState() == 1) || (this.aOO.getState() == 2))) {
        this.aOO.setStereoVolume(paramFloat1, paramFloat2);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localIllegalStateException, "setVolume", new Object[0]);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "setVolume", new Object[0]);
      }
    }
    this.volume = paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.a
 * JD-Core Version:    0.7.0.1
 */