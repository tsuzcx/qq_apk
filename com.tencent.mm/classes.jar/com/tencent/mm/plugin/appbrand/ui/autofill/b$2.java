package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.a.d;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (b.a(this.hfr) != null) {
      b.a(this.hfr).apn();
    }
    paramView = new d(this.hfr.getContext(), 1, false);
    paramView.phH = new b.2.1(this);
    paramView.phI = new b.2.2(this);
    paramView.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b.2
 * JD-Core Version:    0.7.0.1
 */