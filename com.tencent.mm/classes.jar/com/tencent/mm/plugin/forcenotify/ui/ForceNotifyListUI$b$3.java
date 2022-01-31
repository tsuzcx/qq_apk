package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ForceNotifyListUI$b$3
  implements View.OnClickListener
{
  ForceNotifyListUI$b$3(ForceNotifyListUI.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51070);
    ab.i(ForceNotifyListUI.f(this.mHO.mHI), "resetView onClick! username:%s", new Object[] { this.mHO.username });
    c.mHu.Ol(this.mHO.username);
    this.mHO.mHM.animate().rotation(360.0F).setDuration(300L).withEndAction((Runnable)new ForceNotifyListUI.b.3.1(this)).start();
    AppMethodBeat.o(51070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.b.3
 * JD-Core Version:    0.7.0.1
 */