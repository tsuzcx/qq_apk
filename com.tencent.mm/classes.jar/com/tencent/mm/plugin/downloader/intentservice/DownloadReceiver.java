package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.notification.f;

public class DownloadReceiver
  extends ResultReceiver
{
  private static final String TAG;
  private f.d bpk;
  
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
      if (f.MvN == null)
      {
        AppMethodBeat.o(88886);
        return;
      }
      if (paramInt < 100)
      {
        this.bpk.d(100, paramInt, false).m("Download in progress:".concat(String.valueOf(paramInt)));
        f.MvN.c(4657, this.bpk.DA());
        AppMethodBeat.o(88886);
        return;
      }
      this.bpk.d(0, 0, false).m("Download Complete");
      f.MvN.c(4658, this.bpk.DA());
    }
    AppMethodBeat.o(88886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.intentservice.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */