package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.mm.audio.mix.h.b;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
{
  protected static volatile AtomicInteger chU = new AtomicInteger(0);
  protected static volatile AtomicInteger chV = new AtomicInteger(0);
  protected AudioTrack ayN;
  protected byte[] byteBuffer;
  protected c cfb;
  protected int chQ = 0;
  protected int chR = 0;
  protected f chS;
  protected int chT = 0;
  protected int channels = 0;
  protected int sampleRate = 0;
  
  public a(int paramInt1, int paramInt2, c paramc, f paramf)
  {
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.cfb = paramc;
    this.chS = paramf;
  }
  
  public final void DD()
  {
    try
    {
      if ((this.ayN != null) && ((this.ayN.getState() == 1) || (this.ayN.getState() == 2))) {
        this.ayN.setStereoVolume(0.0F, 0.0F);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localIllegalStateException, "setVolume", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "setVolume", new Object[0]);
    }
  }
  
  protected final void Ej()
  {
    try
    {
      if ((this.ayN != null) && (this.ayN.getState() != 0))
      {
        this.ayN.stop();
        this.ayN.flush();
      }
      if (this.ayN != null)
      {
        this.ayN.release();
        this.ayN = null;
      }
      return;
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "releaseAudioTrack", new Object[0]);
    }
  }
  
  public void Em() {}
  
  public void F(byte[] paramArrayOfByte) {}
  
  protected abstract boolean createAudioTrack();
  
  public void pause() {}
  
  public final void release()
  {
    Ej();
    this.chS = null;
    this.cfb = null;
    this.byteBuffer = null;
    this.chQ = 0;
    this.chR = 0;
  }
  
  public void reset()
  {
    this.chQ = 0;
    this.chR = 0;
    if (this.byteBuffer != null) {
      Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte)0);
    }
  }
  
  public void resume() {}
  
  public final void seek(int paramInt)
  {
    b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.chT) });
    this.chT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a.a
 * JD-Core Version:    0.7.0.1
 */