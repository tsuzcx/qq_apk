package com.google.android.exoplayer2.a;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class f$a
{
  protected AudioTrack ayN;
  private boolean azE;
  private long azF;
  private long azG;
  private long azH;
  private long azI;
  private long azJ;
  private long azK;
  private int sampleRate;
  
  public final void D(long paramLong)
  {
    AppMethodBeat.i(94663);
    this.azJ = nv();
    this.azI = (SystemClock.elapsedRealtime() * 1000L);
    this.azK = paramLong;
    this.ayN.stop();
    AppMethodBeat.o(94663);
  }
  
  public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    AppMethodBeat.i(94662);
    this.ayN = paramAudioTrack;
    this.azE = paramBoolean;
    this.azI = -9223372036854775807L;
    this.azF = 0L;
    this.azG = 0L;
    this.azH = 0L;
    if (paramAudioTrack != null) {
      this.sampleRate = paramAudioTrack.getSampleRate();
    }
    AppMethodBeat.o(94662);
  }
  
  public final long nv()
  {
    AppMethodBeat.i(94665);
    if (this.azI != -9223372036854775807L)
    {
      l1 = (SystemClock.elapsedRealtime() * 1000L - this.azI) * this.sampleRate / 1000000L;
      l1 = Math.min(this.azK, l1 + this.azJ);
      AppMethodBeat.o(94665);
      return l1;
    }
    int i = this.ayN.getPlayState();
    if (i == 1)
    {
      AppMethodBeat.o(94665);
      return 0L;
    }
    long l2 = 0xFFFFFFFF & this.ayN.getPlaybackHeadPosition();
    long l1 = l2;
    if (this.azE)
    {
      if ((i == 2) && (l2 == 0L)) {
        this.azH = this.azF;
      }
      l1 = l2 + this.azH;
    }
    if (this.azF > l1) {
      this.azG += 1L;
    }
    this.azF = l1;
    l2 = this.azG;
    AppMethodBeat.o(94665);
    return l1 + (l2 << 32);
  }
  
  public final long nw()
  {
    AppMethodBeat.i(94666);
    long l = nv() * 1000000L / this.sampleRate;
    AppMethodBeat.o(94666);
    return l;
  }
  
  public boolean nx()
  {
    return false;
  }
  
  public long ny()
  {
    AppMethodBeat.i(94667);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(94667);
    throw localUnsupportedOperationException;
  }
  
  public long nz()
  {
    AppMethodBeat.i(94668);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(94668);
    throw localUnsupportedOperationException;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(94664);
    if (this.azI != -9223372036854775807L)
    {
      AppMethodBeat.o(94664);
      return;
    }
    this.ayN.pause();
    AppMethodBeat.o(94664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.a
 * JD-Core Version:    0.7.0.1
 */