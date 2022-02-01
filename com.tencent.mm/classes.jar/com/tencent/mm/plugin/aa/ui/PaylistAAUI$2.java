package com.tencent.mm.plugin.aa.ui;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class PaylistAAUI$2
  implements View.OnClickListener
{
  PaylistAAUI$2(PaylistAAUI paramPaylistAAUI, TextView paramTextView, SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(271656);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/aa/ui/PaylistAAUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.isSelected())
    {
      this.jip.setText(this.mQa);
      this.jip.setSelected(false);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271656);
      return;
      this.jip.setText(this.mQb);
      this.jip.setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.2
 * JD-Core Version:    0.7.0.1
 */