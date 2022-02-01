package com.tencent.mm.plugin.game.model.silent_download;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements m
{
  private static void aGS(String paramString)
  {
    AppMethodBeat.i(41670);
    d locald = new d();
    locald.field_appId = paramString;
    Log.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().delete(locald, new String[0])) });
    AppMethodBeat.o(41670);
  }
  
  private static void b(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(41671);
    Log.i("MicroMsg.GameSilentDownloadCallback", paramString);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      paramBoolean = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().ch(locala.field_appId, paramBoolean);
      Log.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", new Object[] { paramString, locala.field_appId, Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(41671);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(275448);
    Log.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
    AppMethodBeat.o(275448);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41664);
    Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
    paramString = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if ((paramString != null) && (paramString.field_autoDownload))
    {
      f.ay(paramString.field_appId, 0, 0);
      aGS(paramString.field_appId);
    }
    AppMethodBeat.o(41664);
  }
  
  public final void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41665);
    Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != com.tencent.mm.plugin.downloader.a.a.xkp)
    {
      com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
      if ((locala != null) && (locala.field_autoDownload))
      {
        f.ay(locala.field_appId, 1, paramInt);
        aGS(locala.field_appId);
      }
    }
    AppMethodBeat.o(41665);
  }
  
  public final void jF(long paramLong)
  {
    AppMethodBeat.i(41666);
    Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      f.ay(locala.field_appId, 2, 0);
      aGS(locala.field_appId);
    }
    AppMethodBeat.o(41666);
  }
  
  public final void jG(long paramLong)
  {
    AppMethodBeat.i(41667);
    b("onTaskPaused", paramLong, false);
    AppMethodBeat.o(41667);
  }
  
  public final void jH(long paramLong) {}
  
  public final void v(long paramLong, String paramString)
  {
    AppMethodBeat.i(41663);
    b("onTaskStarted", paramLong, true);
    AppMethodBeat.o(41663);
  }
  
  public final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(41669);
    b("onTaskResumed", paramLong, true);
    AppMethodBeat.o(41669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.silent_download.c
 * JD-Core Version:    0.7.0.1
 */