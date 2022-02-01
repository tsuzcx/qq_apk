package com.tencent.mm.plugin.appbrand.keylogger;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class KeyStepAnalyserActivity$4
  implements AdapterView.OnItemClickListener
{
  KeyStepAnalyserActivity$4(KeyStepAnalyserActivity paramKeyStepAnalyserActivity, KeyStepAnalyserActivity.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(319459);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    KeyStepAnalyserActivity.a(this.sTW, this.sTZ.BR(paramInt));
    a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(319459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.4
 * JD-Core Version:    0.7.0.1
 */