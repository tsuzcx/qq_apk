package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;

final class y$1
  implements Runnable
{
  y$1(long paramLong, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(226988);
    Log.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", new Object[] { Long.valueOf(System.currentTimeMillis() - this.msJ) });
    this.val$bundle.putInt("action", 2);
    h.a(MainProcessIPCService.dkO, this.val$bundle, a.class, null);
    AppMethodBeat.o(226988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.y.1
 * JD-Core Version:    0.7.0.1
 */