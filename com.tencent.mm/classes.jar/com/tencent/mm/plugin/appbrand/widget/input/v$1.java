package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.q;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.sdk.platformtools.y;

final class v$1
  implements Runnable
{
  v$1(v paramv) {}
  
  public final void run()
  {
    if ((v.a(this.hvf) == null) || (!q.ao(v.a(this.hvf)))) {
      return;
    }
    if (v.b(this.hvf).asd())
    {
      y.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
      this.hvf.post(this);
      return;
    }
    v.c(this.hvf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v.1
 * JD-Core Version:    0.7.0.1
 */