package com.tencent.mm.plugin.location.ui.impl;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.location.ui.j;
import com.tencent.mm.plugin.location.ui.j.3;
import com.tencent.mm.plugin.location.ui.j.4;

final class h$9
  implements View.OnClickListener
{
  h$9(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56123);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = this.vtQ.vtF;
    com.tencent.mm.ui.base.h.e(paramView.mContext, paramView.mResources.getString(2131760734), "", paramView.mResources.getString(2131755728), paramView.mResources.getString(2131755691), new j.3(paramView), new j.4(paramView));
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(56123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.9
 * JD-Core Version:    0.7.0.1
 */