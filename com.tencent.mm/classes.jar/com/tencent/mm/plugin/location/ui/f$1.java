package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class f$1
  implements AdapterView.OnItemClickListener
{
  f$1(f paramf) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(55893);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/plugin/location/ui/ShareHeaderAvatarViewMgr$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    paramAdapterView = (String)paramView.getTag();
    if (!Util.isNullOrNil(paramAdapterView))
    {
      h.CyF.a(10997, new Object[] { "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if (this.yIM.yIL != null) {
        this.yIM.yIL.aDg(paramAdapterView);
      }
    }
    a.a(this, "com/tencent/mm/plugin/location/ui/ShareHeaderAvatarViewMgr$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(55893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f.1
 * JD-Core Version:    0.7.0.1
 */