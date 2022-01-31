package com.tencent.mm.graphics.ui;

import com.tencent.mm.graphics.b.b;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class WxBaseImageView$2
  implements Runnable
{
  WxBaseImageView$2(WxBaseImageView paramWxBaseImageView) {}
  
  public final void run()
  {
    try
    {
      y.i("MicroMsg.WxBaseImageView", "alvinluo reportPerformanceInfo threadId: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      b localb = d.dDu.BL();
      a locala = a.dDA;
      a.a(localb);
      WxBaseImageView.b(this.dEa);
      WxBaseImageView.c(this.dEa);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView.2
 * JD-Core Version:    0.7.0.1
 */