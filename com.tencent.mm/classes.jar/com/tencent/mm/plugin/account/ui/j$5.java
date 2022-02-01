package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class j$5
  implements View.OnClickListener
{
  j$5(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128277);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    j.a(this.knr);
    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j.5
 * JD-Core Version:    0.7.0.1
 */