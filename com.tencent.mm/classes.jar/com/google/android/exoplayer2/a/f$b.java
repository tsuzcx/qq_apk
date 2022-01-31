package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
final class f$b
  extends f.a
{
  private final AudioTimestamp axv = new AudioTimestamp();
  private long axw;
  private long axx;
  private long axy;
  
  public f$b()
  {
    super((byte)0);
  }
  
  public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    super.a(paramAudioTrack, paramBoolean);
    this.axw = 0L;
    this.axx = 0L;
    this.axy = 0L;
  }
  
  public final boolean lp()
  {
    boolean bool = this.awx.getTimestamp(this.axv);
    if (bool)
    {
      long l = this.axv.framePosition;
      if (this.axx > l) {
        this.axw += 1L;
      }
      this.axx = l;
      this.axy = (l + (this.axw << 32));
    }
    return bool;
  }
  
  public final long lq()
  {
    return this.axv.nanoTime;
  }
  
  public final long lr()
  {
    return this.axy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.b
 * JD-Core Version:    0.7.0.1
 */