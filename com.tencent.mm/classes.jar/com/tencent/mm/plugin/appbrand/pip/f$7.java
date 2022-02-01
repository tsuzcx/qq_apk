package com.tencent.mm.plugin.appbrand.pip;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.platformtools.ae;

public final class f$7
  implements View.OnClickListener
{
  public f$7(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207942);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i(this.msR.crG, "onClick, mIsPipVideoRelatedPagePushed: " + this.msR.msA + ", mPipVideoRelatedPage: " + f.r(this.msR.msz));
    if (this.msR.msH)
    {
      ae.i(this.msR.crG, "onClick when mIsTransfering, return");
      a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207942);
      return;
    }
    if ((!this.msR.msD) && (this.msR.msz != null))
    {
      if (!this.msR.msA) {
        break label199;
      }
      this.msR.jzE.b(this.msR.msz, "scene_other");
    }
    for (;;)
    {
      this.msR.msD = true;
      a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207942);
      return;
      label199:
      paramView = this.msR.msz.getCurrentUrl();
      this.msR.jzE.TP(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.7
 * JD-Core Version:    0.7.0.1
 */