package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayCardManagerUI$1
  implements AdapterView.OnItemClickListener
{
  HoneyPayCardManagerUI$1(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(64684);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    paramAdapterView = (cio)paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView != null) && (!bt.isNullOrNil(paramAdapterView.url)))
    {
      ad.i(this.uGB.TAG, "click item: %s, %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramAdapterView.Hcv) });
      e.o(this.uGB.getContext(), paramAdapterView.url, false);
      g.yhR.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
    }
    a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(64684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.1
 * JD-Core Version:    0.7.0.1
 */