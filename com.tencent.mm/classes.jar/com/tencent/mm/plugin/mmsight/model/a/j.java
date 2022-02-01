package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

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
      AppMethodBeat.i(210681);
      try
      {
        if ((this.wct != null) && (this.wcv == -1))
        {
          this.wcv = this.wct.addTrack(paramMediaFormat);
          ae.i("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.wcv) });
          if ((!this.isStart) && (this.wcv != -1))
          {
            ae.i("MicroMsg.MMSightAACSystemMediaMuxer", "start!");
            this.wct.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(210681);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
          AppMethodBeat.o(210681);
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