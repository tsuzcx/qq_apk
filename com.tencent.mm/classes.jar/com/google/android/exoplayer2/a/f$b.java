package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(19)
final class f$b
  extends f.a
{
  private final AudioTimestamp bgm;
  private long bgn;
  private long bgo;
  private long bgp;
  
  public f$b()
  {
    super((byte)0);
    AppMethodBeat.i(91780);
    this.bgm = new AudioTimestamp();
    AppMethodBeat.o(91780);
  }
  
  public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    AppMethodBeat.i(91781);
    super.a(paramAudioTrack, paramBoolean);
    this.bgn = 0L;
    this.bgo = 0L;
    this.bgp = 0L;
    AppMethodBeat.o(91781);
  }
  
  public final boolean tR()
  {
    AppMethodBeat.i(91782);
    boolean bool = this.bfq.getTimestamp(this.bgm);
    if (bool)
    {
      long l = this.bgm.framePosition;
      if (this.bgo > l) {
        this.bgn += 1L;
      }
      this.bgo = l;
      this.bgp = (l + (this.bgn << 32));
    }
    AppMethodBeat.o(91782);
    return bool;
  }
  
  public final long tS()
  {
    return this.bgm.nanoTime;
  }
  
  public final long tT()
  {
    return this.bgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.b
 * JD-Core Version:    0.7.0.1
 */