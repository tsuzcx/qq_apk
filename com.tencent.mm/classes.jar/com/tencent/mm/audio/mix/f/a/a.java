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
  protected static volatile AtomicInteger cUr = new AtomicInteger(0);
  protected static volatile AtomicInteger cUs = new AtomicInteger(0);
  protected volatile AudioTrack aUW;
  protected long bVo = -1L;
  protected byte[] byteBuffer;
  protected d cRx;
  protected int cUm = 0;
  protected int cUn = 0;
  protected double cUo = 0.0D;
  protected f cUp;
  protected int cUq = 0;
  protected int channels = 0;
  protected int sampleRate = 0;
  protected float volume = 1.0F;
  
  public a(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.cRx = paramd;
    this.cUp = paramf;
  }
  
  public void K(byte[] paramArrayOfByte) {}
  
  public void NS() {}
  
  protected abstract boolean createAudioTrack();
  
  public final long getCurrentPosition()
  {
    long l1 = -1L;
    if ((this.aUW != null) && (this.aUW.getState() != 0))
    {
      try
      {
        long l2 = Math.round(this.aUW.getPlaybackHeadPosition() / this.aUW.getSampleRate() * 1000.0D);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "getCurrentPosition", new Object[0]);
        }
      }
      this.bVo = l1;
      return l1;
    }
    return this.bVo;
  }
  
  public final void h(double paramDouble)
  {
    this.cUo = paramDouble;
  }
  
  public final void i(double paramDouble)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", new Object[] { Double.valueOf(paramDouble) });
    }
    try
    {
      if ((this.aUW != null) && ((this.aUW.getState() == 1) || (this.aUW.getState() == 2)))
      {
        PlaybackParams localPlaybackParams = this.aUW.getPlaybackParams();
        localPlaybackParams.setSpeed((float)paramDouble);
        this.aUW.setPlaybackParams(localPlaybackParams);
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
    this.cUp = null;
    this.cRx = null;
    this.byteBuffer = null;
    this.cUm = 0;
    this.cUn = 0;
  }
  
  protected final void releaseAudioTrack()
  {
    try
    {
      if ((this.aUW != null) && (this.aUW.getState() != 0))
      {
        this.aUW.stop();
        this.aUW.flush();
      }
      if (this.aUW != null)
      {
        this.aUW.release();
        this.aUW = null;
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
    this.cUm = 0;
    this.cUn = 0;
    if (this.byteBuffer != null) {
      Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte)0);
    }
  }
  
  public void resume() {}
  
  public final void seek(int paramInt)
  {
    b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.cUq) });
    this.cUq = paramInt;
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      if ((this.aUW != null) && ((this.aUW.getState() == 1) || (this.aUW.getState() == 2))) {
        this.aUW.setStereoVolume(paramFloat1, paramFloat2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.a
 * JD-Core Version:    0.7.0.1
 */