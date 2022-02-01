package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class v$2
  implements View.OnClickListener
{
  v$2(v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(148124);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.mpt.kET.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(148124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v.2
 * JD-Core Version:    0.7.0.1
 */