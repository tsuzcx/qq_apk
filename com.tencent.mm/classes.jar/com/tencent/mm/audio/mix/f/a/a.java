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
  protected static long huJ = 120L;
  protected static long huK = 240L;
  protected static volatile AtomicInteger huP = new AtomicInteger(0);
  protected static volatile AtomicInteger huQ = new AtomicInteger(0);
  protected static volatile AtomicInteger huR = new AtomicInteger(0);
  protected byte[] byteBuffer;
  protected volatile AudioTrack cIK;
  protected int channels = 0;
  protected int dIY = 0;
  protected long ebZ = -1L;
  protected d hrE;
  protected int huL = 0;
  protected int huM = 0;
  protected double huN = 0.0D;
  protected f huO;
  protected int sampleRate = 0;
  protected float volume = 1.0F;
  
  public a(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.hrE = paramd;
    this.huO = paramf;
  }
  
  public void aGA() {}
  
  public void af(byte[] paramArrayOfByte) {}
  
  protected abstract boolean createAudioTrack();
  
  public final long getCurrentPosition()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.cIK != null)
      {
        l1 = l2;
        if (this.cIK.getState() != 0)
        {
          l1 = l2;
          l2 = Math.round(this.cIK.getPlaybackHeadPosition() / this.cIK.getSampleRate() * 1000.0D);
          l1 = l2;
          this.ebZ = l2;
          return l2;
        }
      }
      l1 = l2;
      l2 = this.ebZ;
      return l2;
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "getCurrentPosition", new Object[0]);
    }
    return l1;
  }
  
  public void pause() {}
  
  public final void release()
  {
    releaseAudioTrack();
    this.huO = null;
    this.hrE = null;
    this.byteBuffer = null;
    this.huL = 0;
    this.huM = 0;
  }
  
  protected final void releaseAudioTrack()
  {
    try
    {
      if (this.cIK != null) {
        huR.decrementAndGet();
      }
      if ((this.cIK != null) && (this.cIK.getState() != 0))
      {
        this.cIK.stop();
        this.cIK.flush();
      }
      if (this.cIK != null)
      {
        this.cIK.release();
        this.cIK = null;
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
    this.huL = 0;
    this.huM = 0;
    if (this.byteBuffer != null) {
      Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte)0);
    }
  }
  
  public void resume() {}
  
  public final void seek(int paramInt)
  {
    b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.dIY) });
    this.dIY = paramInt;
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      if ((this.cIK != null) && ((this.cIK.getState() == 1) || (this.cIK.getState() == 2))) {
        this.cIK.setStereoVolume(paramFloat1, paramFloat2);
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
  
  public final void y(double paramDouble)
  {
    this.huN = paramDouble;
  }
  
  public final void z(double paramDouble)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", new Object[] { Double.valueOf(paramDouble) });
    }
    try
    {
      if ((this.cIK != null) && ((this.cIK.getState() == 1) || (this.cIK.getState() == 2)))
      {
        PlaybackParams localPlaybackParams = this.cIK.getPlaybackParams();
        localPlaybackParams.setSpeed((float)paramDouble);
        this.cIK.setPlaybackParams(localPlaybackParams);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.a
 * JD-Core Version:    0.7.0.1
 */