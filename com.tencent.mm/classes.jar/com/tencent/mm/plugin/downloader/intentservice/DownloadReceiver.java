package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.x.c;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.notification.b;

public class DownloadReceiver
  extends ResultReceiver
{
  private static final String TAG = DownloadReceiver.class.getSimpleName();
  private x.c ym;
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 4657)
    {
      paramInt = paramBundle.getInt("progress");
      if (b.mIj != null) {}
    }
    else
    {
      return;
    }
    if (paramInt < 100)
    {
      this.ym.b(100, paramInt, false).d("Download in progress:" + paramInt);
      b.mIj.notify(4657, this.ym.build());
      return;
    }
    this.ym.b(0, 0, false).d("Download Complete");
    b.mIj.notify(4658, this.ym.build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.intentservice.DownloadReceiver
 * JD-Core Version:    0.7.0.1
 */