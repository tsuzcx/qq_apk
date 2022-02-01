package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

public final class a
  implements m
{
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(45728);
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      ae.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", new Object[] { locala.field_appId, Boolean.valueOf(locala.field_downloadInWifi), Boolean.valueOf(az.isWifi(ak.getContext())) });
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (az.isWifi(ak.getContext()))) {
        break label132;
      }
    }
    label132:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_failed")
    {
      localAppbrandDownloadState.dkO = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.kyz = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
      AppMethodBeat.o(45728);
      return;
    }
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(222402);
    paramString = d.ur(paramLong1);
    if (paramString != null)
    {
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_progress_changed";
      localAppbrandDownloadState.dkO = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      if (paramString.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)paramString.field_downloadedSize / (float)paramString.field_totalSize * 100.0F));
        localAppbrandDownloadState.kyA = ((float)paramString.field_downloadedSize * 100.0F / (float)paramString.field_totalSize);
      }
      ae.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", new Object[] { paramString.field_appId, Long.valueOf(localAppbrandDownloadState.progress) });
      localAppbrandDownloadState.kyz = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(222402);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(45727);
    paramString = d.ur(paramLong);
    if (paramString != null)
    {
      ae.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + paramString.field_appId);
      if (paramString.field_downloadInWifi)
      {
        paramString.field_downloadInWifi = false;
        d.e(paramString);
      }
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_succ";
      localAppbrandDownloadState.dkO = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      localAppbrandDownloadState.progress = 100L;
      localAppbrandDownloadState.kyz = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(45727);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(45726);
    paramString = d.ur(paramLong);
    if (paramString != null)
    {
      ae.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + paramString.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_started";
      localAppbrandDownloadState.dkO = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      if (paramString.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)paramString.field_downloadedSize / (float)paramString.field_totalSize * 100.0F));
        localAppbrandDownloadState.kyA = ((float)paramString.field_downloadedSize * 100.0F / (float)paramString.field_totalSize);
      }
      localAppbrandDownloadState.kyz = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(45726);
  }
  
  public final void k(long paramLong, String paramString) {}
  
  public final void sY(long paramLong)
  {
    AppMethodBeat.i(45729);
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if (locala != null)
    {
      ae.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + locala.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_removed";
      localAppbrandDownloadState.dkO = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.kyz = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(45729);
  }
  
  public final void sZ(long paramLong)
  {
    AppMethodBeat.i(45730);
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      ae.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + locala.field_appId);
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (az.isWifi(ak.getContext()))) {
        break label156;
      }
    }
    label156:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_paused")
    {
      localAppbrandDownloadState.dkO = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.kyz = locala.field_totalSize;
      if (locala.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F));
        localAppbrandDownloadState.kyA = ((float)locala.field_downloadedSize * 100.0F / (float)locala.field_totalSize);
      }
      b.a(localAppbrandDownloadState);
      AppMethodBeat.o(45730);
      return;
    }
  }
  
  public final void ta(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.a
 * JD-Core Version:    0.7.0.1
 */