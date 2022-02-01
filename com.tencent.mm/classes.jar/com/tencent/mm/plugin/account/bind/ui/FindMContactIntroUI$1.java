package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FindMContactIntroUI$1
  implements View.OnClickListener
{
  FindMContactIntroUI$1(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110020);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    FindMContactIntroUI.a(this.kcj);
    a.a(this, "com/tencent/mm/plugin/account/bind/ui/FindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(110020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.1
 * JD-Core Version:    0.7.0.1
 */