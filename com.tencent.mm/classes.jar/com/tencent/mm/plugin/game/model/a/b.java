package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b
{
  public static boolean Iy(long paramLong)
  {
    AppMethodBeat.i(41662);
    f.cPZ().uhA = true;
    boolean bool = f.cPZ().Iy(paramLong);
    AppMethodBeat.o(41662);
    return bool;
  }
  
  public static long a(d paramd, int paramInt)
  {
    AppMethodBeat.i(41661);
    a locala = new a();
    locala.appId = paramd.field_appId;
    locala.downloadUrl = paramd.field_downloadUrl;
    locala.ulF = paramd.field_SecondaryUrl;
    locala.packageName = paramd.field_packageName;
    locala.ulH = paramd.field_size;
    locala.pYB = paramd.field_md5;
    locala.ulI = false;
    locala.scene = 7001;
    locala.ulJ = true;
    if (paramd.field_sectionMd5Byte != null) {}
    try
    {
      q localq = new q();
      localq.parseFrom(paramd.field_sectionMd5Byte);
      locala.ulL = localq.ufA;
      label124:
      locala.appName = com.tencent.mm.pluginsdk.model.app.h.a(MMApplicationContext.getContext(), com.tencent.mm.pluginsdk.model.app.h.o(paramd.field_appId, true, false), null);
      locala.fGH = paramInt;
      long l = ((c)com.tencent.mm.kernel.h.ae(c.class)).a(locala, null);
      Log.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
      AppMethodBeat.o(41661);
      return l;
    }
    catch (IOException localIOException)
    {
      break label124;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.b
 * JD-Core Version:    0.7.0.1
 */