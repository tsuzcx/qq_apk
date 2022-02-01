package com.tencent.mm.audio.mix.g.a;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.g.f;
import com.tencent.mm.audio.mix.i.b;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
{
  protected static volatile AtomicInteger dxS = new AtomicInteger(0);
  protected static volatile AtomicInteger dxT = new AtomicInteger(0);
  protected static volatile AtomicInteger dxU = new AtomicInteger(0);
  protected int bNu = 0;
  protected volatile AudioTrack bfn;
  protected byte[] byteBuffer;
  protected int channels = 0;
  protected long cqe = -1L;
  protected d duL;
  protected int dxO = 0;
  protected int dxP = 0;
  protected double dxQ = 0.0D;
  protected f dxR;
  protected int sampleRate = 0;
  protected float volume = 1.0F;
  
  public a(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.duL = paramd;
    this.dxR = paramf;
  }
  
  public void Y(byte[] paramArrayOfByte) {}
  
  public void ZT() {}
  
  protected abstract boolean createAudioTrack();
  
  public final long getCurrentPosition()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.bfn != null)
      {
        l1 = l2;
        if (this.bfn.getState() != 0)
        {
          l1 = l2;
          l2 = Math.round(this.bfn.getPlaybackHeadPosition() / this.bfn.getSampleRate() * 1000.0D);
          l1 = l2;
          this.cqe = l2;
          return l2;
        }
      }
      l1 = l2;
      l2 = this.cqe;
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
    this.dxQ = paramDouble;
  }
  
  public final void j(double paramDouble)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", new Object[] { Double.valueOf(paramDouble) });
    }
    try
    {
      if ((this.bfn != null) && ((this.bfn.getState() == 1) || (this.bfn.getState() == 2)))
      {
        PlaybackParams localPlaybackParams = this.bfn.getPlaybackParams();
        localPlaybackParams.setSpeed((float)paramDouble);
        this.bfn.setPlaybackParams(localPlaybackParams);
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
    this.dxR = null;
    this.duL = null;
    this.byteBuffer = null;
    this.dxO = 0;
    this.dxP = 0;
  }
  
  protected final void releaseAudioTrack()
  {
    try
    {
      if (this.bfn != null) {
        dxU.decrementAndGet();
      }
      if ((this.bfn != null) && (this.bfn.getState() != 0))
      {
        this.bfn.stop();
        this.bfn.flush();
      }
      if (this.bfn != null)
      {
        this.bfn.release();
        this.bfn = null;
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
    this.dxO = 0;
    this.dxP = 0;
    if (this.byteBuffer != null) {
      Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte)0);
    }
  }
  
  public void resume() {}
  
  public final void seek(int paramInt)
  {
    b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.bNu) });
    this.bNu = paramInt;
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      if ((this.bfn != null) && ((this.bfn.getState() == 1) || (this.bfn.getState() == 2))) {
        this.bfn.setStereoVolume(paramFloat1, paramFloat2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.g.a.a
 * JD-Core Version:    0.7.0.1
 */