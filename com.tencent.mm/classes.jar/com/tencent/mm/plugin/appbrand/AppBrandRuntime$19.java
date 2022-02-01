package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;

final class AppBrandRuntime$19
  implements ViewGroup.OnHierarchyChangeListener
{
  AppBrandRuntime$19(AppBrandRuntime paramAppBrandRuntime, View paramView) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2) {}
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    AppMethodBeat.i(197177);
    if ((paramView2 == this.jxz) && (!this.jxm.isDestroyed()))
    {
      paramView1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197176);
          if (AppBrandRuntime.19.this.jxm.mResumed) {
            AppBrandRuntime.19.this.jxm.aVN().setActuallyVisible(true);
          }
          AppMethodBeat.o(197176);
        }
      };
      this.jxm.aVU();
      if (this.jxm.aVN() == null)
      {
        this.jxm.L(paramView1);
        AppMethodBeat.o(197177);
        return;
      }
      paramView1.run();
    }
    AppMethodBeat.o(197177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.19
 * JD-Core Version:    0.7.0.1
 */