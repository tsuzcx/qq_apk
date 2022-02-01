package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SimpleLoginUI$4
  implements View.OnClickListener
{
  SimpleLoginUI$4(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128761);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    SimpleLoginUI.b(this.jrl);
    a.a(this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.4
 * JD-Core Version:    0.7.0.1
 */