package com.tencent.mm.audio.d.a;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  private AudioRecord dhg;
  private boolean diW;
  
  public final boolean PG()
  {
    AppMethodBeat.i(146312);
    if (this.dhg == null) {
      ad.e("MicroMsg.RecorderPcm", "mAudioRecord is null, return");
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(146312);
      return false;
    }
    this.diW = false;
    try
    {
      this.dhg.stop();
      release();
      AppMethodBeat.o(146312);
      return true;
    }
    catch (Exception localException)
    {
      ad.m("MicroMsg.RecorderPcm", "", new Object[] { localException });
      AppMethodBeat.o(146312);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(146313);
    if (this.dhg != null)
    {
      this.dhg.setRecordPositionUpdateListener(null);
      this.dhg.release();
      this.dhg = null;
    }
    AppMethodBeat.o(146313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.b
 * JD-Core Version:    0.7.0.1
 */