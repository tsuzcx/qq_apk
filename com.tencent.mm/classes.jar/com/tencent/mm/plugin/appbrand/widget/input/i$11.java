package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import java.lang.ref.WeakReference;

final class i$11
  implements View.OnFocusChangeListener
{
  i$11(i parami) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(141611);
    if (paramBoolean) {
      o.b((v)this.jlw.jlj.get(), this.jlw);
    }
    i.a(this.jlw, paramBoolean);
    if ((paramBoolean) && ((!this.jlw.jli.jqE) || (com.tencent.mm.plugin.appbrand.ui.o.cy(this.jlw.jll)))) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.jlw.jll != null) && (this.jlw.jlm != null))
      {
        this.jlw.jll.requestFocus();
        this.jlw.jlm.show();
      }
      AppMethodBeat.o(141611);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.11
 * JD-Core Version:    0.7.0.1
 */