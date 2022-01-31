package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements k
{
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      y.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", new Object[] { locala.field_appId, Boolean.valueOf(locala.field_downloadInWifi), Boolean.valueOf(aq.isWifi(ae.getContext())) });
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (aq.isWifi(ae.getContext()))) {
        break label122;
      }
    }
    label122:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_failed")
    {
      localAppbrandDownloadState.bFb = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.ghK = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
      return;
    }
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = c.dk(paramLong);
    if (paramString != null)
    {
      y.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + paramString.field_appId);
      if (paramString.field_downloadInWifi)
      {
        paramString.field_downloadInWifi = false;
        c.d(paramString);
      }
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_succ";
      localAppbrandDownloadState.bFb = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      localAppbrandDownloadState.bRL = 100L;
      localAppbrandDownloadState.ghK = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
  }
  
  public final void cy(long paramLong)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if (locala != null)
    {
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_progress_changed";
      localAppbrandDownloadState.bFb = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      if (locala.field_totalSize != 0L) {
        localAppbrandDownloadState.bRL = (((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F));
      }
      y.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", new Object[] { locala.field_appId, Long.valueOf(localAppbrandDownloadState.bRL) });
      localAppbrandDownloadState.ghK = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
  }
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString) {}
  
  public final void onTaskPaused(long paramLong)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      y.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + locala.field_appId);
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (aq.isWifi(ae.getContext()))) {
        break label127;
      }
    }
    label127:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_paused")
    {
      localAppbrandDownloadState.bFb = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.ghK = locala.field_totalSize;
      if (locala.field_totalSize != 0L) {
        localAppbrandDownloadState.bRL = (((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F));
      }
      b.a(localAppbrandDownloadState);
      return;
    }
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if (locala != null)
    {
      y.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + locala.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_removed";
      localAppbrandDownloadState.bFb = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.ghK = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    paramString = c.dk(paramLong);
    if (paramString != null)
    {
      y.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + paramString.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_started";
      localAppbrandDownloadState.bFb = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      if (paramString.field_totalSize != 0L) {
        localAppbrandDownloadState.bRL = (((float)paramString.field_downloadedSize / (float)paramString.field_totalSize * 100.0F));
      }
      localAppbrandDownloadState.ghK = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.a
 * JD-Core Version:    0.7.0.1
 */