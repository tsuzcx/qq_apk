package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class ForceNotifyListUI$b$2
  implements View.OnLongClickListener
{
  ForceNotifyListUI$b$2(ForceNotifyListUI.b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(51068);
    ab.i(ForceNotifyListUI.f(this.mHO.mHI), "OnLongClick!");
    new a((Context)this.mHO.mHI.getContext()).a(paramView, 0, 0L, (View.OnCreateContextMenuListener)this.mHO, (n.d)this.mHO, ForceNotifyListUI.e(this.mHO.mHI)[0], ForceNotifyListUI.e(this.mHO.mHI)[1]);
    AppMethodBeat.o(51068);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.b.2
 * JD-Core Version:    0.7.0.1
 */