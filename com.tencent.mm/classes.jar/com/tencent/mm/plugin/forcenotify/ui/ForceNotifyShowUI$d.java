package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.c.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ForceNotifyShowUI$d
  implements View.OnClickListener
{
  ForceNotifyShowUI$d(ForceNotifyShowUI paramForceNotifyShowUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51086);
    if (ForceNotifyShowUI.c(this.mHX).field_CreateTime > 0L)
    {
      paramView = String.valueOf(ForceNotifyShowUI.c(this.mHX).field_CreateTime / 1000L) + ForceNotifyShowUI.c(this.mHX).field_UserName;
      ((a)g.E(a.class)).b(ForceNotifyShowUI.c(this.mHX).field_ForcePushId, paramView, 2, cb.abq() / 1000L);
    }
    this.mHX.finish();
    this.mHX.overridePendingTransition(0, 2131034228);
    AppMethodBeat.o(51086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI.d
 * JD-Core Version:    0.7.0.1
 */