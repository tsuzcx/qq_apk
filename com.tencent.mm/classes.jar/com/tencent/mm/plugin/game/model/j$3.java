package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

final class j$3
  implements Runnable
{
  j$3(long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(111249);
    Object localObject1 = d.iJ(this.kXZ);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.GameDownloadEventBus", "fInfo is null");
      AppMethodBeat.o(111249);
      return;
    }
    b localb;
    Object localObject2;
    if (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status == 3)
    {
      if (e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath))
      {
        ab.i("MicroMsg.GameDownloadEventBus", "onInstallFinish, delete file: %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath });
        e.deleteFile(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath);
      }
      d.iK(this.kXZ);
      d.JF(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId);
      d.JE(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadUrl);
      localb = new b();
      localb.i((com.tencent.mm.plugin.downloader.g.a)localObject1);
      com.tencent.mm.plugin.downloader.f.a.a(5, localb);
      com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, 8L);
      localObject2 = (j.b)j.bGj().get(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadUrl);
      if (localObject2 == null)
      {
        com.tencent.mm.plugin.downloader.f.a.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_scene, 5, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_md5, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadUrl, "", ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_extInfo);
        AppMethodBeat.o(111249);
        return;
      }
      com.tencent.mm.plugin.downloader.f.a.a(((j.b)localObject2).appId, ((j.b)localObject2).scene, 5, ((j.b)localObject2).cqq, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadUrl, ((j.b)localObject2).nmH, ((j.b)localObject2).cpH);
      localObject1 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      localObject2 = ah.getContext().getSharedPreferences("install_begin_time", 0);
      if (localObject2 == null) {
        break label286;
      }
    }
    label286:
    for (long l = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);; l = 0L)
    {
      if (System.currentTimeMillis() - l <= 600000L) {
        com.tencent.mm.plugin.downloader.f.a.a(17, localb);
      }
      AppMethodBeat.o(111249);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.j.3
 * JD-Core Version:    0.7.0.1
 */