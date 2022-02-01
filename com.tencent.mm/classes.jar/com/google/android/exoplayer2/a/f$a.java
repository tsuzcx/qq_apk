package com.google.android.exoplayer2.a;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class f$a
{
  protected AudioTrack bfq;
  private boolean bgf;
  private long bgg;
  private long bgh;
  private long bgi;
  private long bgj;
  private long bgk;
  private long bgl;
  private int sampleRate;
  
  public final void K(long paramLong)
  {
    AppMethodBeat.i(91774);
    this.bgk = tP();
    this.bgj = (SystemClock.elapsedRealtime() * 1000L);
    this.bgl = paramLong;
    this.bfq.stop();
    AppMethodBeat.o(91774);
  }
  
  public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    AppMethodBeat.i(91773);
    this.bfq = paramAudioTrack;
    this.bgf = paramBoolean;
    this.bgj = -9223372036854775807L;
    this.bgg = 0L;
    this.bgh = 0L;
    this.bgi = 0L;
    if (paramAudioTrack != null) {
      this.sampleRate = paramAudioTrack.getSampleRate();
    }
    AppMethodBeat.o(91773);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(91775);
    if (this.bgj != -9223372036854775807L)
    {
      AppMethodBeat.o(91775);
      return;
    }
    this.bfq.pause();
    AppMethodBeat.o(91775);
  }
  
  public final long tP()
  {
    AppMethodBeat.i(91776);
    if (this.bgj != -9223372036854775807L)
    {
      l1 = (SystemClock.elapsedRealtime() * 1000L - this.bgj) * this.sampleRate / 1000000L;
      l1 = Math.min(this.bgl, l1 + this.bgk);
      AppMethodBeat.o(91776);
      return l1;
    }
    int i = this.bfq.getPlayState();
    if (i == 1)
    {
      AppMethodBeat.o(91776);
      return 0L;
    }
    long l2 = 0xFFFFFFFF & this.bfq.getPlaybackHeadPosition();
    long l1 = l2;
    if (this.bgf)
    {
      if ((i == 2) && (l2 == 0L)) {
        this.bgi = this.bgg;
      }
      l1 = l2 + this.bgi;
    }
    if (this.bgg > l1) {
      this.bgh += 1L;
    }
    this.bgg = l1;
    l2 = this.bgh;
    AppMethodBeat.o(91776);
    return l1 + (l2 << 32);
  }
  
  public final long tQ()
  {
    AppMethodBeat.i(91777);
    long l = tP() * 1000000L / this.sampleRate;
    AppMethodBeat.o(91777);
    return l;
  }
  
  public boolean tR()
  {
    return false;
  }
  
  public long tS()
  {
    AppMethodBeat.i(91778);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(91778);
    throw localUnsupportedOperationException;
  }
  
  public long tT()
  {
    AppMethodBeat.i(91779);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(91779);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.a
 * JD-Core Version:    0.7.0.1
 */