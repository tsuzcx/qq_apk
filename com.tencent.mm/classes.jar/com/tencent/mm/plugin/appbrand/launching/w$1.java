package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.concurrent.FutureTask;

final class w$1
  implements c
{
  w$1(w paramw, FutureTask paramFutureTask) {}
  
  public final void A(Runnable paramRunnable)
  {
    if (this.gLe == paramRunnable)
    {
      this.gLf.gLc = bk.UY();
      this.gLf.gLd = (this.gLf.gLc - this.gLf.gLb);
      e.c(this);
    }
  }
  
  public final void z(Runnable paramRunnable)
  {
    if (this.gLe == paramRunnable) {
      this.gLf.gLb = bk.UY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w.1
 * JD-Core Version:    0.7.0.1
 */