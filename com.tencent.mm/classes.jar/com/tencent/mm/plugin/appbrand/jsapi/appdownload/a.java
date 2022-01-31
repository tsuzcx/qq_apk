package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class a
  implements m
{
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(130640);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", new Object[] { locala.field_appId, Boolean.valueOf(locala.field_downloadInWifi), Boolean.valueOf(at.isWifi(ah.getContext())) });
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (at.isWifi(ah.getContext()))) {
        break label132;
      }
    }
    label132:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_failed")
    {
      localAppbrandDownloadState.cmm = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.hAO = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
      AppMethodBeat.o(130640);
      return;
    }
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(130639);
    paramString = d.iJ(paramLong);
    if (paramString != null)
    {
      ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + paramString.field_appId);
      if (paramString.field_downloadInWifi)
      {
        paramString.field_downloadInWifi = false;
        d.e(paramString);
      }
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_succ";
      localAppbrandDownloadState.cmm = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      localAppbrandDownloadState.progress = 100L;
      localAppbrandDownloadState.hAO = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(130639);
  }
  
  public final void hx(long paramLong)
  {
    AppMethodBeat.i(130643);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala != null)
    {
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_progress_changed";
      localAppbrandDownloadState.cmm = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      if (locala.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F));
        localAppbrandDownloadState.hAP = ((float)locala.field_downloadedSize * 100.0F / (float)locala.field_totalSize);
      }
      ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", new Object[] { locala.field_appId, Long.valueOf(localAppbrandDownloadState.progress) });
      localAppbrandDownloadState.hAO = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(130643);
  }
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString) {}
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(130642);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    AppbrandDownloadState localAppbrandDownloadState;
    if (locala != null)
    {
      ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + locala.field_appId);
      localAppbrandDownloadState = new AppbrandDownloadState();
      if ((!locala.field_downloadInWifi) || (at.isWifi(ah.getContext()))) {
        break label156;
      }
    }
    label156:
    for (localAppbrandDownloadState.state = "download_wait_wifi";; localAppbrandDownloadState.state = "download_paused")
    {
      localAppbrandDownloadState.cmm = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.hAO = locala.field_totalSize;
      if (locala.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)locala.field_downloadedSize / (float)locala.field_totalSize * 100.0F));
        localAppbrandDownloadState.hAP = ((float)locala.field_downloadedSize * 100.0F / (float)locala.field_totalSize);
      }
      b.a(localAppbrandDownloadState);
      AppMethodBeat.o(130642);
      return;
    }
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(130641);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala != null)
    {
      ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + locala.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_removed";
      localAppbrandDownloadState.cmm = locala.field_downloadId;
      localAppbrandDownloadState.appId = locala.field_appId;
      localAppbrandDownloadState.hAO = locala.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(130641);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(130638);
    paramString = d.iJ(paramLong);
    if (paramString != null)
    {
      ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + paramString.field_appId);
      AppbrandDownloadState localAppbrandDownloadState = new AppbrandDownloadState();
      localAppbrandDownloadState.state = "download_started";
      localAppbrandDownloadState.cmm = paramString.field_downloadId;
      localAppbrandDownloadState.appId = paramString.field_appId;
      if (paramString.field_totalSize != 0L)
      {
        localAppbrandDownloadState.progress = (((float)paramString.field_downloadedSize / (float)paramString.field_totalSize * 100.0F));
        localAppbrandDownloadState.hAP = ((float)paramString.field_downloadedSize * 100.0F / (float)paramString.field_totalSize);
      }
      localAppbrandDownloadState.hAO = paramString.field_totalSize;
      b.a(localAppbrandDownloadState);
    }
    AppMethodBeat.o(130638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.a
 * JD-Core Version:    0.7.0.1
 */