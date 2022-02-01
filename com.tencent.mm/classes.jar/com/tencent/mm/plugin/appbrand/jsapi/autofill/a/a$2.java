package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(50458);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    switch (this.kEW.kEO.size())
    {
    default: 
      this.kEW.kEV.invoke();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(50458);
      return;
      this.kEW.kEU.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.2
 * JD-Core Version:    0.7.0.1
 */