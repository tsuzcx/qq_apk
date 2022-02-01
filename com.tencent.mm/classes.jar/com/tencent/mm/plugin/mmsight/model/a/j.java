package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

@Deprecated
@TargetApi(18)
public final class j
  extends p
{
  public j(String paramString)
  {
    super(paramString);
  }
  
  public final void f(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(213679);
      try
      {
        if ((this.vQp != null) && (this.vQr == -1))
        {
          this.vQr = this.vQp.addTrack(paramMediaFormat);
          ad.i("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.vQr) });
          if ((!this.isStart) && (this.vQr != -1))
          {
            ad.i("MicroMsg.MMSightAACSystemMediaMuxer", "start!");
            this.vQp.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(213679);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
          AppMethodBeat.o(213679);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.j
 * JD-Core Version:    0.7.0.1
 */