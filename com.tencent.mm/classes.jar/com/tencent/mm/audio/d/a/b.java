package com.tencent.mm.audio.d.a;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private boolean dBi;
  private AudioRecord dzu;
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(146312);
    if (this.dzu == null) {
      Log.e("MicroMsg.RecorderPcm", "mAudioRecord is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146312);
      return false;
    }
    this.dBi = false;
    try
    {
      this.dzu.stop();
      release();
      AppMethodBeat.o(146312);
      return true;
    }
    catch (Exception localException)
    {
      Log.printInfoStack("MicroMsg.RecorderPcm", "", new Object[] { localException });
      AppMethodBeat.o(146312);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(146313);
    if (this.dzu != null)
    {
      this.dzu.setRecordPositionUpdateListener(null);
      this.dzu.release();
      this.dzu = null;
    }
    AppMethodBeat.o(146313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.b
 * JD-Core Version:    0.7.0.1
 */