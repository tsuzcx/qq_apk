package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  implements m
{
  private static void Qg(String paramString)
  {
    AppMethodBeat.i(111505);
    d locald = new d();
    locald.field_appId = paramString;
    ab.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(((e)com.tencent.mm.kernel.g.E(e.class)).bEU().delete(locald, new String[0])) });
    AppMethodBeat.o(111505);
  }
  
  private static void e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(111506);
    ab.i("MicroMsg.GameSilentDownloadCallback", paramString);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      paramBoolean = ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().aW(locala.field_appId, paramBoolean);
      ab.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", new Object[] { paramString, locala.field_appId, Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(111506);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111500);
    ab.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != com.tencent.mm.plugin.downloader.a.a.kVo)
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
      if ((locala != null) && (locala.field_autoDownload))
      {
        f.aj(locala.field_appId, 1, paramInt);
        Qg(locala.field_appId);
      }
    }
    AppMethodBeat.o(111500);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111499);
    ab.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
    paramString = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((paramString != null) && (paramString.field_autoDownload))
    {
      f.aj(paramString.field_appId, 0, 0);
      Qg(paramString.field_appId);
    }
    AppMethodBeat.o(111499);
  }
  
  public final void hx(long paramLong)
  {
    AppMethodBeat.i(111503);
    ab.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
    AppMethodBeat.o(111503);
  }
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(111504);
    e("onTaskResumed", paramLong, true);
    AppMethodBeat.o(111504);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(111502);
    e("onTaskPaused", paramLong, false);
    AppMethodBeat.o(111502);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(111501);
    ab.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      f.aj(locala.field_appId, 2, 0);
      Qg(locala.field_appId);
    }
    AppMethodBeat.o(111501);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(111498);
    e("onTaskStarted", paramLong, true);
    AppMethodBeat.o(111498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.c
 * JD-Core Version:    0.7.0.1
 */