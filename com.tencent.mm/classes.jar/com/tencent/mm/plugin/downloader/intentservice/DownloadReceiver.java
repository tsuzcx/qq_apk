package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.notification.c;

public class DownloadReceiver
  extends ResultReceiver
{
  private static final String TAG;
  private s.c yO;
  
  static
  {
    AppMethodBeat.i(2339);
    TAG = DownloadReceiver.class.getSimpleName();
    AppMethodBeat.o(2339);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(2338);
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 4657)
    {
      paramInt = paramBundle.getInt("progress");
      if (c.piq == null)
      {
        AppMethodBeat.o(2338);
        return;
      }
      if (paramInt < 100)
      {
        this.yO.b(100, paramInt, false).f("Download in progress:".concat(String.valueOf(paramInt)));
        c.piq.notify(4657, this.yO.build());
        AppMethodBeat.o(2338);
        return;
      }
      this.yO.b(0, 0, false).f("Download Complete");
      c.piq.notify(4658, this.yO.build());
    }
    AppMethodBeat.o(2338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.intentservice.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */