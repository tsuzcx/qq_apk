package com.tencent.mm.plugin.game.model.silent_download;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.b.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b
{
  public static long a(d paramd, int paramInt)
  {
    AppMethodBeat.i(41661);
    a locala = new a();
    locala.appId = paramd.field_appId;
    locala.downloadUrl = paramd.field_downloadUrl;
    locala.xrR = paramd.field_SecondaryUrl;
    locala.packageName = paramd.field_packageName;
    locala.xrT = paramd.field_size;
    locala.tdo = paramd.field_md5;
    locala.xrU = false;
    locala.scene = 7001;
    locala.xrV = true;
    if (paramd.field_sectionMd5Byte != null) {}
    try
    {
      q localq = new q();
      localq.parseFrom(paramd.field_sectionMd5Byte);
      locala.xrX = localq.xlB;
      label124:
      locala.appName = com.tencent.mm.pluginsdk.model.app.h.a(MMApplicationContext.getContext(), com.tencent.mm.pluginsdk.model.app.h.s(paramd.field_appId, true, false), null);
      locala.hMd = paramInt;
      long l = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(locala, null);
      Log.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
      AppMethodBeat.o(41661);
      return l;
    }
    catch (IOException localIOException)
    {
      break label124;
    }
  }
  
  public static boolean kT(long paramLong)
  {
    AppMethodBeat.i(41662);
    f.duv().xnG = true;
    boolean bool = f.duv().kT(paramLong);
    AppMethodBeat.o(41662);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.silent_download.b
 * JD-Core Version:    0.7.0.1
 */