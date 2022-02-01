package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(50459);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.kEW.kEP.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(50459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.3
 * JD-Core Version:    0.7.0.1
 */