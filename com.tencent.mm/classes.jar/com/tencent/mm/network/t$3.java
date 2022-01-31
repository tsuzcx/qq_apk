package com.tencent.mm.network;

import android.content.Context;
import com.tencent.mm.kernel.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class t$3
  implements Runnable
{
  t$3(t paramt) {}
  
  public final void run()
  {
    y.i("MicroMsg.AutoAuth", "makeSureAuth AUTH_HOLD_KEY hold  clearTaskAndCallback");
    aa.Uv().g(4, -100, ae.getContext().getString(i.a.main_err_auth));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.t.3
 * JD-Core Version:    0.7.0.1
 */