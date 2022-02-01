package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  implements m
{
  private static void amZ(String paramString)
  {
    AppMethodBeat.i(41670);
    d locald = new d();
    locald.field_appId = paramString;
    ae.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().delete(locald, new String[0])) });
    AppMethodBeat.o(41670);
  }
  
  private static void c(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(41671);
    ae.i("MicroMsg.GameSilentDownloadCallback", paramString);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      paramBoolean = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().bt(locala.field_appId, paramBoolean);
      ae.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", new Object[] { paramString, locala.field_appId, Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(41671);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41665);
    ae.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != com.tencent.mm.plugin.downloader.a.a.ppG)
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
      if ((locala != null) && (locala.field_autoDownload))
      {
        f.am(locala.field_appId, 1, paramInt);
        amZ(locala.field_appId);
      }
    }
    AppMethodBeat.o(41665);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(195658);
    ae.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
    AppMethodBeat.o(195658);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41664);
    ae.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
    paramString = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
    if ((paramString != null) && (paramString.field_autoDownload))
    {
      f.am(paramString.field_appId, 0, 0);
      amZ(paramString.field_appId);
    }
    AppMethodBeat.o(41664);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(41663);
    c("onTaskStarted", paramLong, true);
    AppMethodBeat.o(41663);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(41669);
    c("onTaskResumed", paramLong, true);
    AppMethodBeat.o(41669);
  }
  
  public final void sY(long paramLong)
  {
    AppMethodBeat.i(41666);
    ae.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      f.am(locala.field_appId, 2, 0);
      amZ(locala.field_appId);
    }
    AppMethodBeat.o(41666);
  }
  
  public final void sZ(long paramLong)
  {
    AppMethodBeat.i(41667);
    c("onTaskPaused", paramLong, false);
    AppMethodBeat.o(41667);
  }
  
  public final void ta(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.c
 * JD-Core Version:    0.7.0.1
 */