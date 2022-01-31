package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.y;

final class k$1$1
  implements Runnable
{
  k$1$1(k.1 param1, long paramLong, Bundle paramBundle) {}
  
  public final void run()
  {
    y.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", new Object[] { Long.valueOf(System.currentTimeMillis() - this.gBU) });
    this.gBV.putInt("action", 2);
    f.a("com.tencent.mm", this.gBV, a.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.k.1.1
 * JD-Core Version:    0.7.0.1
 */