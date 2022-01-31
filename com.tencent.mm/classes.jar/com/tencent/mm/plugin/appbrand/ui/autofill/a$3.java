package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
    if (a.a(this.heZ) != null) {
      a.a(this.heZ).apm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.a.3
 * JD-Core Version:    0.7.0.1
 */