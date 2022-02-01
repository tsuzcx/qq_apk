package com.tencent.mm.plugin.appbrand.pip;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;

public final class f$7
  implements View.OnClickListener
{
  public f$7(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(219544);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i(this.nDA.cDW, "onClick, mIsPipVideoRelatedPagePushed: " + this.nDA.nDk + ", mPipVideoRelatedPage: " + f.s(this.nDA.nDj));
    if (this.nDA.nDr)
    {
      Log.i(this.nDA.cDW, "onClick when mIsTransfering, return");
      a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(219544);
      return;
    }
    if ((!this.nDA.nDn) && (this.nDA.nDj != null))
    {
      if (!this.nDA.nDk) {
        break label199;
      }
      this.nDA.kAs.b(this.nDA.nDj, "scene_other");
    }
    for (;;)
    {
      this.nDA.nDn = true;
      a.a(this, "com/tencent/mm/plugin/appbrand/pip/AppBrandPipManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(219544);
      return;
      label199:
      paramView = this.nDA.nDj.getCurrentUrl();
      this.nDA.kAs.adC(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.7
 * JD-Core Version:    0.7.0.1
 */