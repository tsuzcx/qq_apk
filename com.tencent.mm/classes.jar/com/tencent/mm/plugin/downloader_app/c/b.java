package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static c aGs()
  {
    if (g.DN().Dc())
    {
      g.DN();
      if (!com.tencent.mm.kernel.a.CW()) {}
    }
    else
    {
      y.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
      return null;
    }
    if (g.r(com.tencent.mm.plugin.downloader.a.c.class) == null)
    {
      y.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
      return null;
    }
    return ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).aGe();
  }
  
  public static boolean br(String paramString, int paramInt)
  {
    if (aGs() == null) {
      return false;
    }
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_status = paramInt;
    locala.field_modifyTime = System.currentTimeMillis();
    return aGs().c(locala, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.b
 * JD-Core Version:    0.7.0.1
 */