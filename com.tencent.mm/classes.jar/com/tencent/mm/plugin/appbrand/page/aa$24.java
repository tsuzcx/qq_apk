package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class aa$24
  implements View.OnClickListener
{
  aa$24(aa paramaa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135140);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    boolean bool = f.aC(this.mcl.getContext());
    paramView = this.mcl;
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135139);
        if (!aa.24.this.mcl.isRunning())
        {
          AppMethodBeat.o(135139);
          return;
        }
        aa.a(aa.24.this.mcl, aa.24.this.mcl.buw());
        AppMethodBeat.o(135139);
      }
    };
    if (bool) {}
    for (int i = 100;; i = 0)
    {
      paramView.j((Runnable)localObject, i);
      a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(135140);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa.24
 * JD-Core Version:    0.7.0.1
 */