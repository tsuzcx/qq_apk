package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(19)
final class f$b
  extends f.a
{
  private final AudioTimestamp azL;
  private long azM;
  private long azN;
  private long azO;
  
  public f$b()
  {
    super((byte)0);
    AppMethodBeat.i(94669);
    this.azL = new AudioTimestamp();
    AppMethodBeat.o(94669);
  }
  
  public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    AppMethodBeat.i(94670);
    super.a(paramAudioTrack, paramBoolean);
    this.azM = 0L;
    this.azN = 0L;
    this.azO = 0L;
    AppMethodBeat.o(94670);
  }
  
  public final boolean nx()
  {
    AppMethodBeat.i(94671);
    boolean bool = this.ayN.getTimestamp(this.azL);
    if (bool)
    {
      long l = this.azL.framePosition;
      if (this.azN > l) {
        this.azM += 1L;
      }
      this.azN = l;
      this.azO = (l + (this.azM << 32));
    }
    AppMethodBeat.o(94671);
    return bool;
  }
  
  public final long ny()
  {
    return this.azL.nanoTime;
  }
  
  public final long nz()
  {
    return this.azO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.b
 * JD-Core Version:    0.7.0.1
 */