package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.ui.widget.b.c;

final class k$1$1
  implements Runnable
{
  k$1$1(k.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(131354);
    b localb = new b(this.hTy.hLy.getContext());
    localb.setTitle(2131297149);
    localb.zai.setVisibility(0);
    localb.zag.setVisibility(0);
    localb.zag.setText(2131297148);
    localb.setCanceledOnTouchOutside(false);
    localb.a(2131297018, new k.1.1.1(this));
    this.hTy.hLy.getRuntime().gPE.b(localb);
    AppMethodBeat.o(131354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.1.1
 * JD-Core Version:    0.7.0.1
 */