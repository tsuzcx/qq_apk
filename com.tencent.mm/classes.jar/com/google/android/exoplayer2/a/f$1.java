package com.google.android.exoplayer2.a;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  extends Thread
{
  f$1(f paramf, AudioTrack paramAudioTrack) {}
  
  public final void run()
  {
    AppMethodBeat.i(94660);
    try
    {
      this.azC.flush();
      this.azC.release();
      return;
    }
    finally
    {
      f.a(this.azD).open();
      AppMethodBeat.o(94660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.1
 * JD-Core Version:    0.7.0.1
 */