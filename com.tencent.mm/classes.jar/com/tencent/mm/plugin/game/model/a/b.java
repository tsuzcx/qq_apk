package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b
{
  public static boolean Cp(long paramLong)
  {
    AppMethodBeat.i(41662);
    f.cBv().qIA = true;
    boolean bool = f.cBv().Cp(paramLong);
    AppMethodBeat.o(41662);
    return bool;
  }
  
  public static long a(d paramd, int paramInt)
  {
    AppMethodBeat.i(41661);
    a locala = new a();
    locala.appId = paramd.field_appId;
    locala.downloadUrl = paramd.field_downloadUrl;
    locala.qKt = paramd.field_SecondaryUrl;
    locala.packageName = paramd.field_packageName;
    locala.qKv = paramd.field_size;
    locala.mYc = paramd.field_md5;
    locala.qKw = false;
    locala.scene = 7001;
    locala.qKx = true;
    if (paramd.field_sectionMd5Byte != null) {}
    try
    {
      q localq = new q();
      localq.parseFrom(paramd.field_sectionMd5Byte);
      locala.qKz = localq.qGz;
      label124:
      locala.appName = h.a(MMApplicationContext.getContext(), h.o(paramd.field_appId, true, false), null);
      locala.dNv = paramInt;
      long l = ((c)g.af(c.class)).a(locala, null);
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