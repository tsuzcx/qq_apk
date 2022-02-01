package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.ag.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class k$d
  implements ag.d
{
  k$d(a<ah> parama) {}
  
  public final void done()
  {
    AppMethodBeat.i(322973);
    Log.i("MicroMsg.WxaAppGetUserAuthorizeScopeListWithAttrs", "doFetch, batch sync done");
    h.ahAA.bn((Runnable)new k.e(this.ujz));
    AppMethodBeat.o(322973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.k.d
 * JD-Core Version:    0.7.0.1
 */