package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class k$1
  implements d.d
{
  public final void X(int paramInt, String paramString)
  {
    y.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (!k.contains(paramString)) {
      return;
    }
    if (paramInt == 9)
    {
      k.er(paramString);
      return;
    }
    f localf = g.by(paramString, true);
    if ((localf != null) && (p.o(ae.getContext(), localf.field_packageName)))
    {
      y.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
      return;
    }
    k.mG(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.k.1
 * JD-Core Version:    0.7.0.1
 */