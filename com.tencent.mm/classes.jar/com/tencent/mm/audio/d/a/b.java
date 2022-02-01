package com.tencent.mm.audio.d.a;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  private AudioRecord cVQ;
  private boolean cXE;
  
  public final boolean NX()
  {
    AppMethodBeat.i(146312);
    if (this.cVQ == null) {
      ac.e("MicroMsg.RecorderPcm", "mAudioRecord is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146312);
      return false;
    }
    this.cXE = false;
    try
    {
      this.cVQ.stop();
      release();
      AppMethodBeat.o(146312);
      return true;
    }
    catch (Exception localException)
    {
      ac.m("MicroMsg.RecorderPcm", "", new Object[] { localException });
      AppMethodBeat.o(146312);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(146313);
    if (this.cVQ != null)
    {
      this.cVQ.setRecordPositionUpdateListener(null);
      this.cVQ.release();
      this.cVQ = null;
    }
    AppMethodBeat.o(146313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.b
 * JD-Core Version:    0.7.0.1
 */