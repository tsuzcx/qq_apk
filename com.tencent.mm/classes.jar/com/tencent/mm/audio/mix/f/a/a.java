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
  protected static volatile AtomicInteger dfH = new AtomicInteger(0);
  protected static volatile AtomicInteger dfI = new AtomicInteger(0);
  protected volatile AudioTrack bfq;
  protected byte[] byteBuffer;
  protected long cfC = -1L;
  protected int channels = 0;
  protected d dcN;
  protected int dfC = 0;
  protected int dfD = 0;
  protected double dfE = 0.0D;
  protected f dfF;
  protected int dfG = 0;
  protected int sampleRate = 0;
  protected float volume = 1.0F;
  
  public a(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.dcN = paramd;
    this.dfF = paramf;
  }
  
  public void K(byte[] paramArrayOfByte) {}
  
  public void PB() {}
  
  protected abstract boolean createAudioTrack();
  
  public final long getCurrentPosition()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.bfq != null)
      {
        l1 = l2;
        if (this.bfq.getState() != 0)
        {
          l1 = l2;
          l2 = Math.round(this.bfq.getPlaybackHeadPosition() / this.bfq.getSampleRate() * 1000.0D);
          l1 = l2;
          this.cfC = l2;
          return l2;
        }
      }
      l1 = l2;
      l2 = this.cfC;
      return l2;
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "getCurrentPosition", new Object[0]);
    }
    return l1;
  }
  
  public final void h(double paramDouble)
  {
    this.dfE = paramDouble;
  }
  
  public final void i(double paramDouble)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", new Object[] { Double.valueOf(paramDouble) });
    }
    try
    {
      if ((this.bfq != null) && ((this.bfq.getState() == 1) || (this.bfq.getState() == 2)))
      {
        PlaybackParams localPlaybackParams = this.bfq.getPlaybackParams();
        localPlaybackParams.setSpeed((float)paramDouble);
        this.bfq.setPlaybackParams(localPlaybackParams);
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
    this.dfF = null;
    this.dcN = null;
    this.byteBuffer = null;
    this.dfC = 0;
    this.dfD = 0;
  }
  
  protected final void releaseAudioTrack()
  {
    try
    {
      if ((this.bfq != null) && (this.bfq.getState() != 0))
      {
        this.bfq.stop();
        this.bfq.flush();
      }
      if (this.bfq != null)
      {
        this.bfq.release();
        this.bfq = null;
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
    this.dfC = 0;
    this.dfD = 0;
    if (this.byteBuffer != null) {
      Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte)0);
    }
  }
  
  public void resume() {}
  
  public final void seek(int paramInt)
  {
    b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.dfG) });
    this.dfG = paramInt;
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      if ((this.bfq != null) && ((this.bfq.getState() == 1) || (this.bfq.getState() == 2))) {
        this.bfq.setStereoVolume(paramFloat1, paramFloat2);
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