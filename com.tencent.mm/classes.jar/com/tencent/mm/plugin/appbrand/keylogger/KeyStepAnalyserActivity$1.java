package com.tencent.mm.plugin.appbrand.keylogger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class KeyStepAnalyserActivity$1
  implements View.OnClickListener
{
  KeyStepAnalyserActivity$1(KeyStepAnalyserActivity paramKeyStepAnalyserActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(221244);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    KeyStepAnalyserActivity.a(this.mOD);
    a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(221244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.1
 * JD-Core Version:    0.7.0.1
 */