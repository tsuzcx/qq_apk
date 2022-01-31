package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
@TargetApi(18)
public final class o
  implements e
{
  boolean isStart;
  MediaMuxer oJC;
  int oJD;
  int oJE;
  long oJF;
  
  public final boolean bRm()
  {
    return false;
  }
  
  public final void e(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(76661);
    try
    {
      if ((this.oJC != null) && (this.oJD == -1))
      {
        this.oJD = this.oJC.addTrack(paramMediaFormat);
        ab.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[] { Integer.valueOf(this.oJD) });
        if ((!this.isStart) && (this.oJD != -1) && (this.oJE != -1))
        {
          ab.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.oJC.start();
          this.isStart = true;
        }
      }
      AppMethodBeat.o(76661);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ab.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[] { paramMediaFormat.getMessage() });
      AppMethodBeat.o(76661);
    }
  }
  
  public final void f(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(76662);
    try
    {
      if ((this.oJC != null) && (this.oJE == -1))
      {
        this.oJE = this.oJC.addTrack(paramMediaFormat);
        ab.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.oJE) });
        if ((!this.isStart) && (this.oJE != -1) && (this.oJD != -1))
        {
          ab.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
          this.oJC.start();
          this.isStart = true;
        }
      }
      AppMethodBeat.o(76662);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ab.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
      AppMethodBeat.o(76662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o
 * JD-Core Version:    0.7.0.1
 */