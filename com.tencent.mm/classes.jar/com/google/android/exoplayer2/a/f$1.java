package com.google.android.exoplayer2.a;

import android.media.AudioTrack;
import android.os.ConditionVariable;

final class f$1
  extends Thread
{
  f$1(f paramf, AudioTrack paramAudioTrack) {}
  
  public final void run()
  {
    try
    {
      this.axm.flush();
      this.axm.release();
      return;
    }
    finally
    {
      f.a(this.axn).open();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.1
 * JD-Core Version:    0.7.0.1
 */