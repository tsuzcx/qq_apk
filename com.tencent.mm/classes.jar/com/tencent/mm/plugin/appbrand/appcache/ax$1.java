package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class ax$1
  implements Runnable
{
  ax$1(boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(44337);
    if (this.qFY)
    {
      Log.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
      h.baE().ban().set(at.a.acNd, Long.valueOf(Util.nowSecond() - 1L));
    }
    ax.access$000();
    AppMethodBeat.o(44337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax.1
 * JD-Core Version:    0.7.0.1
 */