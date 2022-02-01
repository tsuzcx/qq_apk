package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.ui.al;

final class h$1
  implements AppBrandUILoadingSplash.a
{
  h$1(o paramo) {}
  
  public final void a(ViewStub paramViewStub)
  {
    AppMethodBeat.i(188861);
    if ((c.gz(this.jvI.aXc().jXJ)) && (((b)g.ab(b.class)).a(b.a.qHW, 0) == 1))
    {
      paramViewStub.setLayoutResource(2131496380);
      paramViewStub.inflate();
    }
    AppMethodBeat.o(188861);
  }
  
  @SuppressLint({"ResourceType"})
  public final void b(ViewStub paramViewStub)
  {
    AppMethodBeat.i(188862);
    if ((c.gA(this.jvI.aXc().jXI)) && (((b)g.ab(b.class)).a(b.a.qFF, 0) == 1))
    {
      paramViewStub.setLayoutResource(2131496381);
      paramViewStub = (ImageView)paramViewStub.inflate().findViewById(2131300874);
      if (!al.isDarkMode()) {
        break label81;
      }
    }
    label81:
    for (int i = 2131691563;; i = 2131691562)
    {
      paramViewStub.setImageResource(i);
      AppMethodBeat.o(188862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.1
 * JD-Core Version:    0.7.0.1
 */