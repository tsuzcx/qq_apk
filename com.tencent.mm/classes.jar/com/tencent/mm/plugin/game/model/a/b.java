package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.IOException;

public final class b
{
  public static long a(d paramd, int paramInt)
  {
    AppMethodBeat.i(41661);
    a locala = new a();
    locala.appId = paramd.field_appId;
    locala.downloadUrl = paramd.field_downloadUrl;
    locala.pve = paramd.field_SecondaryUrl;
    locala.packageName = paramd.field_packageName;
    locala.pvg = paramd.field_size;
    locala.lQS = paramd.field_md5;
    locala.pvh = false;
    locala.scene = 7001;
    locala.pvi = true;
    if (paramd.field_sectionMd5Byte != null) {}
    try
    {
      q localq = new q();
      localq.parseFrom(paramd.field_sectionMd5Byte);
      locala.pvk = localq.pqU;
      label124:
      locala.appName = h.a(ak.getContext(), h.m(paramd.field_appId, true, false), null);
      locala.dvO = paramInt;
      long l = ((c)g.ab(c.class)).a(locala, null);
      ae.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
      AppMethodBeat.o(41661);
      return l;
    }
    catch (IOException localIOException)
    {
      break label124;
    }
  }
  
  public static boolean uk(long paramLong)
  {
    AppMethodBeat.i(41662);
    f.cdA().psW = true;
    boolean bool = f.cdA().uk(paramLong);
    AppMethodBeat.o(41662);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.b
 * JD-Core Version:    0.7.0.1
 */