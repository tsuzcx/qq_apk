package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

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
      AppMethodBeat.i(241183);
      try
      {
        if ((this.mediaMuxer != null) && (this.zww == -1))
        {
          this.zww = this.mediaMuxer.addTrack(paramMediaFormat);
          Log.i("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[] { Integer.valueOf(this.zww) });
          if ((!this.isStart) && (this.zww != -1))
          {
            Log.i("MicroMsg.MMSightAACSystemMediaMuxer", "start!");
            this.mediaMuxer.start();
            this.isStart = true;
          }
        }
        AppMethodBeat.o(241183);
      }
      catch (Exception paramMediaFormat)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack error: %s", new Object[] { paramMediaFormat.getMessage() });
          AppMethodBeat.o(241183);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.j
 * JD-Core Version:    0.7.0.1
 */