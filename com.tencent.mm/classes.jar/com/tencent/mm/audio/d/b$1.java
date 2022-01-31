package com.tencent.mm.audio.d;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(140630);
    try
    {
      Object localObject = this.clf.mAudioTrack;
      if (localObject == null)
      {
        AppMethodBeat.o(140630);
        return;
      }
      this.clf.mAudioTrack.play();
      Process.setThreadPriority(-19);
      localObject = new byte[this.clf.ckZ];
      while (this.clf.cla.available() > 0)
      {
        int i = this.clf.cla.read((byte[])localObject);
        if ((i != -3) && (i != -2) && (i != 0) && (i != -1)) {
          this.clf.mAudioTrack.write((byte[])localObject, 0, i);
        }
      }
      this.clf.Ez();
    }
    catch (Exception localException)
    {
      com.tencent.f.a.b.b("MicroMsg.VoicePlayerPcm", localException, "");
      AppMethodBeat.o(140630);
      return;
    }
    if (this.clf.clc != null) {
      this.clf.clc.EW();
    }
    AppMethodBeat.o(140630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.d.b.1
 * JD-Core Version:    0.7.0.1
 */