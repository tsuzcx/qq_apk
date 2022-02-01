package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;

final class x$1
  implements Runnable
{
  x$1(long paramLong, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(326390);
    Log.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", new Object[] { Long.valueOf(System.currentTimeMillis() - this.svC) });
    this.val$bundle.putInt("action", 2);
    j.a(MainProcessIPCService.PROCESS_NAME, this.val$bundle, a.class, null);
    AppMethodBeat.o(326390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.x.1
 * JD-Core Version:    0.7.0.1
 */