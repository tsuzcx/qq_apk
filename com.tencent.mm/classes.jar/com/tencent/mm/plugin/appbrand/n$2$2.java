package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.y;

final class n$2$2
  implements Runnable
{
  n$2$2(n.2 param2) {}
  
  public final void run()
  {
    y.d("MicroMsg.AppBrandRuntimeWC", "AppBrandPrepareTask done. runOnUiThread");
    n.d(this.fzP.fzM, this.fzP.fzN);
    n.f(this.fzP.fzM);
    n localn = this.fzP.fzM;
    localn.getContext().runOnUiThread(new i.11(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.2.2
 * JD-Core Version:    0.7.0.1
 */