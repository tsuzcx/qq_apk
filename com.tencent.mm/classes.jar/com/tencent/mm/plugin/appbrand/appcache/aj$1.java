package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class aj$1
  implements Runnable
{
  aj$1(boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(129412);
    if (this.gVt)
    {
      ab.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
      g.RL().Ru().set(ac.a.yCG, Long.valueOf(bo.aox() - 1L));
    }
    aj.access$000();
    AppMethodBeat.o(129412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.1
 * JD-Core Version:    0.7.0.1
 */