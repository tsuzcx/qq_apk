package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.notification.c;

public class DownloadReceiver
  extends ResultReceiver
{
  private static final String TAG;
  private s.c Gh;
  
  static
  {
    AppMethodBeat.i(88887);
    TAG = DownloadReceiver.class.getSimpleName();
    AppMethodBeat.o(88887);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(88886);
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 4657)
    {
      paramInt = paramBundle.getInt("progress");
      if (c.vpR == null)
      {
        AppMethodBeat.o(88886);
        return;
      }
      if (paramInt < 100)
      {
        this.Gh.b(100, paramInt, false).g("Download in progress:".concat(String.valueOf(paramInt)));
        c.vpR.notify(4657, this.Gh.build());
        AppMethodBeat.o(88886);
        return;
      }
      this.Gh.b(0, 0, false).g("Download Complete");
      c.vpR.notify(4658, this.Gh.build());
    }
    AppMethodBeat.o(88886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.intentservice.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */