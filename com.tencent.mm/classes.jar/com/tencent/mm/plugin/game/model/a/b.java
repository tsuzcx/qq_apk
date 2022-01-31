package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements k
{
  private static void EO(String paramString)
  {
    c localc = new c();
    localc.field_appId = paramString;
    y.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().a(localc, new String[0])) });
  }
  
  private static void e(String paramString, long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.GameSilentDownloadCallback", paramString);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.c.dk(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      paramBoolean = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().aH(locala.field_appId, paramBoolean);
      y.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", new Object[] { paramString, locala.field_appId, Boolean.valueOf(paramBoolean) });
    }
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != com.tencent.mm.plugin.downloader.a.a.iOi)
    {
      com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.c.dk(paramLong);
      if ((locala != null) && (locala.field_autoDownload))
      {
        e.T(locala.field_appId, 1, paramInt);
        EO(locala.field_appId);
      }
    }
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
    paramString = com.tencent.mm.plugin.downloader.model.c.dk(paramLong);
    if ((paramString != null) && (paramString.field_autoDownload))
    {
      e.T(paramString.field_appId, 0, 0);
      EO(paramString.field_appId);
    }
  }
  
  public final void cy(long paramLong)
  {
    y.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
  }
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString)
  {
    e("onTaskResumed", paramLong, true);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    e("onTaskPaused", paramLong, false);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    y.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.c.dk(paramLong);
    if ((locala != null) && (locala.field_autoDownload))
    {
      e.T(locala.field_appId, 2, 0);
      EO(locala.field_appId);
    }
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    e("onTaskStarted", paramLong, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.b
 * JD-Core Version:    0.7.0.1
 */