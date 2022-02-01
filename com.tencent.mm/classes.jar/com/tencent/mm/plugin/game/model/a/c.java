package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements m
{
  private static void aKc(String paramString)
  {
    AppMethodBeat.i(41670);
    d locald = new d();
    locald.field_appId = paramString;
    Log.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evq().delete(locald, new String[0])) });
    AppMethodBeat.o(41670);
  }
  
  private static void b(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(41671);
    Log.i("MicroMsg.GameSilentDownloadCallback", paramString);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      paramBoolean = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evq().bM(locala.field_appId, paramBoolean);
      Log.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", new Object[] { paramString, locala.field_appId, Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(41671);
  }
  
  public final void Hp(long paramLong)
  {
    AppMethodBeat.i(41666);
    Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      f.ar(locala.field_appId, 2, 0);
      aKc(locala.field_appId);
    }
    AppMethodBeat.o(41666);
  }
  
  public final void Hq(long paramLong)
  {
    AppMethodBeat.i(41667);
    b("onTaskPaused", paramLong, false);
    AppMethodBeat.o(41667);
  }
  
  public final void Hr(long paramLong) {}
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(201548);
    Log.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
    AppMethodBeat.o(201548);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41665);
    Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != com.tencent.mm.plugin.downloader.a.a.uen)
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
      if ((locala != null) && (locala.field_autoDownload))
      {
        f.ar(locala.field_appId, 1, paramInt);
        aKc(locala.field_appId);
      }
    }
    AppMethodBeat.o(41665);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41664);
    Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
    paramString = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if ((paramString != null) && (paramString.field_autoDownload))
    {
      f.ar(paramString.field_appId, 0, 0);
      aKc(paramString.field_appId);
    }
    AppMethodBeat.o(41664);
  }
  
  public final void m(long paramLong, String paramString)
  {
    AppMethodBeat.i(41663);
    b("onTaskStarted", paramLong, true);
    AppMethodBeat.o(41663);
  }
  
  public final void n(long paramLong, String paramString)
  {
    AppMethodBeat.i(41669);
    b("onTaskResumed", paramLong, true);
    AppMethodBeat.o(41669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.c
 * JD-Core Version:    0.7.0.1
 */