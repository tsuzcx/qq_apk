package com.tencent.mm.plugin.appbrand.phonenumber.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MMFormVerifyCodeInputView$2
  implements View.OnClickListener
{
  MMFormVerifyCodeInputView$2(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(169514);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (MMFormVerifyCodeInputView.e(this.nBM) != null) {
      MMFormVerifyCodeInputView.e(this.nBM).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(169514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView.2
 * JD-Core Version:    0.7.0.1
 */