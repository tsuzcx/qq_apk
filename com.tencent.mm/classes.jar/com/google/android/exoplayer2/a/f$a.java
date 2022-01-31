package com.google.android.exoplayer2.a;

import android.media.AudioTrack;
import android.os.SystemClock;

class f$a
{
  protected AudioTrack awx;
  private boolean axo;
  private long axp;
  private long axq;
  private long axr;
  private long axs;
  private long axt;
  private long axu;
  private int sampleRate;
  
  public final void E(long paramLong)
  {
    this.axt = ln();
    this.axs = (SystemClock.elapsedRealtime() * 1000L);
    this.axu = paramLong;
    this.awx.stop();
  }
  
  public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    this.awx = paramAudioTrack;
    this.axo = paramBoolean;
    this.axs = -9223372036854775807L;
    this.axp = 0L;
    this.axq = 0L;
    this.axr = 0L;
    if (paramAudioTrack != null) {
      this.sampleRate = paramAudioTrack.getSampleRate();
    }
  }
  
  public final long ln()
  {
    if (this.axs != -9223372036854775807L)
    {
      l1 = (SystemClock.elapsedRealtime() * 1000L - this.axs) * this.sampleRate / 1000000L;
      return Math.min(this.axu, l1 + this.axt);
    }
    int i = this.awx.getPlayState();
    if (i == 1) {
      return 0L;
    }
    long l2 = 0xFFFFFFFF & this.awx.getPlaybackHeadPosition();
    long l1 = l2;
    if (this.axo)
    {
      if ((i == 2) && (l2 == 0L)) {
        this.axr = this.axp;
      }
      l1 = l2 + this.axr;
    }
    if (this.axp > l1) {
      this.axq += 1L;
    }
    this.axp = l1;
    return l1 + (this.axq << 32);
  }
  
  public final long lo()
  {
    return ln() * 1000000L / this.sampleRate;
  }
  
  public boolean lp()
  {
    return false;
  }
  
  public long lq()
  {
    throw new UnsupportedOperationException();
  }
  
  public long lr()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void pause()
  {
    if (this.axs != -9223372036854775807L) {
      return;
    }
    this.awx.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.a
 * JD-Core Version:    0.7.0.1
 */