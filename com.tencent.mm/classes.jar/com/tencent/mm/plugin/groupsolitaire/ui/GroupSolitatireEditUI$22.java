package com.tencent.mm.plugin.groupsolitaire.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GroupSolitatireEditUI$22
  implements View.OnClickListener
{
  GroupSolitatireEditUI$22(GroupSolitatireEditUI paramGroupSolitatireEditUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110450);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    GroupSolitatireEditUI.a(this.Jkd);
    GroupSolitatireEditUI.j(this.Jkd);
    this.Jkd.Ye(2);
    a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(110450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.22
 * JD-Core Version:    0.7.0.1
 */