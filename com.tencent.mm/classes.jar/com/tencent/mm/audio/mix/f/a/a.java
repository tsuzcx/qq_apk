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
  protected static volatile AtomicInteger cWV = new AtomicInteger(0);
  protected static volatile AtomicInteger cWW = new AtomicInteger(0);
  protected volatile AudioTrack aUg;
  protected long bXG = -1L;
  protected byte[] byteBuffer;
  protected d cUa;
  protected int cWQ = 0;
  protected int cWR = 0;
  protected double cWS = 0.0D;
  protected f cWT;
  protected int cWU = 0;
  protected int channels = 0;
  protected int sampleRate = 0;
  protected float volume = 1.0F;
  
  public a(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.cUa = paramd;
    this.cWT = paramf;
  }
  
  public void M(byte[] paramArrayOfByte) {}
  
  public void NV() {}
  
  protected abstract boolean createAudioTrack();
  
  public final long getCurrentPosition()
  {
    long l1 = -1L;
    if ((this.aUg != null) && (this.aUg.getState() != 0))
    {
      try
      {
        long l2 = Math.round(this.aUg.getPlaybackHeadPosition() / this.aUg.getSampleRate() * 1000.0D);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "getCurrentPosition", new Object[0]);
        }
      }
      this.bXG = l1;
      return l1;
    }
    return this.bXG;
  }
  
  public final void h(double paramDouble)
  {
    this.cWS = paramDouble;
  }
  
  public final void i(double paramDouble)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", new Object[] { Double.valueOf(paramDouble) });
    }
    try
    {
      if ((this.aUg != null) && ((this.aUg.getState() == 1) || (this.aUg.getState() == 2)))
      {
        PlaybackParams localPlaybackParams = this.aUg.getPlaybackParams();
        localPlaybackParams.setSpeed((float)paramDouble);
        this.aUg.setPlaybackParams(localPlaybackParams);
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
    this.cWT = null;
    this.cUa = null;
    this.byteBuffer = null;
    this.cWQ = 0;
    this.cWR = 0;
  }
  
  protected final void releaseAudioTrack()
  {
    try
    {
      if ((this.aUg != null) && (this.aUg.getState() != 0))
      {
        this.aUg.stop();
        this.aUg.flush();
      }
      if (this.aUg != null)
      {
        this.aUg.release();
        this.aUg = null;
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
    this.cWQ = 0;
    this.cWR = 0;
    if (this.byteBuffer != null) {
      Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte)0);
    }
  }
  
  public void resume() {}
  
  public final void seek(int paramInt)
  {
    b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.cWU) });
    this.cWU = paramInt;
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      if ((this.aUg != null) && ((this.aUg.getState() == 1) || (this.aUg.getState() == 2))) {
        this.aUg.setStereoVolume(paramFloat1, paramFloat2);
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