package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.l.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.widget.input.m.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends a<o>
{
  private static final int CTRL_INDEX = 105;
  private static final String NAME = "showToast";
  am fqP;
  View gAr;
  m.a gAs = null;
  
  private void lz(int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.gAr.findViewById(a.b.show_toast_view_container);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      y.w("MicroMsg.JsApiShowToast", "layoutParams is null");
      localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    }
    localLayoutParams1.bottomMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.d
 * JD-Core Version:    0.7.0.1
 */