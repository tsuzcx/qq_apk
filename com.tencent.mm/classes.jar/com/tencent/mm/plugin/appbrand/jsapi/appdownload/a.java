package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class a
  implements m
{
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(45728);
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      ad.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", new Object[] { locala.field_appId, Boolean.valueOf(locala.field_downloadInWifi), Boolean.valueOf(ay.isWifi(aj.getContext())) });
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (ay.isWifi(aj.getContext()))) {
        break label132;
      }
    }
    label132:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_failed")
    {
      localAppbrandDownloadState.djM = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.kvk = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
      AppMethodBeat.o(45728);
      return;
    }
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(188276);
    paramString = d.ua(paramLong1);
    if (paramString != null)
    {
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_progress_changed";
      localAppbrandDownloadState.djM = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      if (paramString.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)paramString.field_downloadedSize / (float)paramString.field_totalSize * 100.0F));
        localAppbrandDownloadState.kvl = ((float)paramString.field_downloadedSize * 100.0F / (float)paramString.field_totalSize);
      }
      ad.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", new Object[] { paramString.field_appId, Long.valueOf(localAppbrandDownloadState.progress) });
      localAppbrandDownloadState.kvk = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(188276);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(45727);
    paramString = d.ua(paramLong);
    if (paramString != null)
    {
      ad.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + paramString.field_appId);
      if (paramString.field_downloadInWifi)
      {
        paramString.field_downloadInWifi = false;
        d.e(paramString);
      }
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_succ";
      localAppbrandDownloadState.djM = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      localAppbrandDownloadState.progress = 100L;
      localAppbrandDownloadState.kvk = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(45727);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(45726);
    paramString = d.ua(paramLong);
    if (paramString != null)
    {
      ad.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + paramString.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_started";
      localAppbrandDownloadState.djM = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      if (paramString.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)paramString.field_downloadedSize / (float)paramString.field_totalSize * 100.0F));
        localAppbrandDownloadState.kvl = ((float)paramString.field_downloadedSize * 100.0F / (float)paramString.field_totalSize);
      }
      localAppbrandDownloadState.kvk = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(45726);
  }
  
  public final void k(long paramLong, String paramString) {}
  
  public final void sL(long paramLong)
  {
    AppMethodBeat.i(45729);
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if (locala != null)
    {
      ad.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + locala.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_removed";
      localAppbrandDownloadState.djM = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.kvk = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(45729);
  }
  
  public final void sM(long paramLong)
  {
    AppMethodBeat.i(45730);
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      ad.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + locala.field_appId);
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (ay.isWifi(aj.getContext()))) {
        break label156;
      }
    }
    label156:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_paused")
    {
      localAppbrandDownloadState.djM = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.kvk = locala.field_totalSize;
      if (locala.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F));
        localAppbrandDownloadState.kvl = ((float)locala.field_downloadedSize * 100.0F / (float)locala.field_totalSize);
      }
      b.a(localAppbrandDownloadState);
      AppMethodBeat.o(45730);
      return;
    }
  }
  
  public final void sN(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.a
 * JD-Core Version:    0.7.0.1
 */