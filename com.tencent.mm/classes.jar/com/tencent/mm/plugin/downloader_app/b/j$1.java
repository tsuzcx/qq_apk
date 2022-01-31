package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class j$1
  implements d.d
{
  public final void H(int paramInt, long paramLong)
  {
    AppMethodBeat.i(136147);
    a locala = d.iJ(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(136147);
      return;
    }
    ab.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", new Object[] { Integer.valueOf(paramInt), locala.field_appId });
    if (!j.contains(locala.field_appId))
    {
      AppMethodBeat.o(136147);
      return;
    }
    if (paramInt == 9)
    {
      j.ky(locala.field_appId);
      AppMethodBeat.o(136147);
      return;
    }
    if ((paramInt == 1) || (paramInt == 7))
    {
      f localf = g.ca(locala.field_appId, true);
      if ((localf != null) && (p.u(ah.getContext(), localf.field_packageName)))
      {
        ab.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
        AppMethodBeat.o(136147);
        return;
      }
      j.tQ(locala.field_appId);
    }
    AppMethodBeat.o(136147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.j.1
 * JD-Core Version:    0.7.0.1
 */