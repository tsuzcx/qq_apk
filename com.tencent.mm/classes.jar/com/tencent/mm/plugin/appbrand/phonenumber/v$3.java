package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class v$3
  implements View.OnClickListener
{
  v$3(v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(148125);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    switch (this.mpt.kEO.size())
    {
    default: 
      this.mpt.kEV.invoke();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(148125);
      return;
      this.mpt.kEU.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v.3
 * JD-Core Version:    0.7.0.1
 */