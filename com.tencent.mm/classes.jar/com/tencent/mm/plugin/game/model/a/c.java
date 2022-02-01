package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  implements m
{
  private static void ahx(String paramString)
  {
    AppMethodBeat.i(41670);
    d locald = new d();
    locald.field_appId = paramString;
    ac.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(((e)com.tencent.mm.kernel.g.ab(e.class)).cOo().delete(locald, new String[0])) });
    AppMethodBeat.o(41670);
  }
  
  private static void e(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(41671);
    ac.i("MicroMsg.GameSilentDownloadCallback", paramString);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.sc(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      paramBoolean = ((e)com.tencent.mm.kernel.g.ab(e.class)).cOo().bl(locala.field_appId, paramBoolean);
      ac.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", new Object[] { paramString, locala.field_appId, Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(41671);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41665);
    ac.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != com.tencent.mm.plugin.downloader.a.a.oFx)
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.sc(paramLong);
      if ((locala != null) && (locala.field_autoDownload))
      {
        f.ai(locala.field_appId, 1, paramInt);
        ahx(locala.field_appId);
      }
    }
    AppMethodBeat.o(41665);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41664);
    ac.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
    paramString = com.tencent.mm.plugin.downloader.model.d.sc(paramLong);
    if ((paramString != null) && (paramString.field_autoDownload))
    {
      f.ai(paramString.field_appId, 0, 0);
      ahx(paramString.field_appId);
    }
    AppMethodBeat.o(41664);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(41669);
    e("onTaskResumed", paramLong, true);
    AppMethodBeat.o(41669);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(41667);
    e("onTaskPaused", paramLong, false);
    AppMethodBeat.o(41667);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(41666);
    ac.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.sc(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      f.ai(locala.field_appId, 2, 0);
      ahx(locala.field_appId);
    }
    AppMethodBeat.o(41666);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(41663);
    e("onTaskStarted", paramLong, true);
    AppMethodBeat.o(41663);
  }
  
  public final void qN(long paramLong)
  {
    AppMethodBeat.i(41668);
    ac.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
    AppMethodBeat.o(41668);
  }
  
  public final void qO(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.c
 * JD-Core Version:    0.7.0.1
 */