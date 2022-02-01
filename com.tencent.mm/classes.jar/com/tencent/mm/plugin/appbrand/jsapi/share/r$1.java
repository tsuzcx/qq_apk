package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ae;

final class r$1
  implements Runnable
{
  r$1(long paramLong, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(222676);
    ae.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", new Object[] { Long.valueOf(System.currentTimeMillis() - this.lmC) });
    this.val$bundle.putInt("action", 2);
    h.a("com.tencent.mm", this.val$bundle, a.class, null);
    AppMethodBeat.o(222676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.r.1
 * JD-Core Version:    0.7.0.1
 */