package com.tencent.mm.plugin.forcenotify.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.forcenotify.c.d;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ForceNotifyShowUI$d
  implements View.OnClickListener
{
  ForceNotifyShowUI$d(ForceNotifyShowUI paramForceNotifyShowUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149233);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (ForceNotifyShowUI.c(this.tky).field_CreateTime > 0L)
    {
      paramView = String.valueOf(ForceNotifyShowUI.c(this.tky).field_CreateTime / 1000L) + ForceNotifyShowUI.c(this.tky).field_UserName;
      ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).f(ForceNotifyShowUI.c(this.tky).field_ForcePushId, paramView, 2, cf.aCL() / 1000L);
    }
    this.tky.finish();
    this.tky.overridePendingTransition(0, 2130772106);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(149233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI.d
 * JD-Core Version:    0.7.0.1
 */