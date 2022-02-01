package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class j$12
  implements View.OnClickListener
{
  j$12(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26033);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    j.b(this.yzT);
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.12
 * JD-Core Version:    0.7.0.1
 */