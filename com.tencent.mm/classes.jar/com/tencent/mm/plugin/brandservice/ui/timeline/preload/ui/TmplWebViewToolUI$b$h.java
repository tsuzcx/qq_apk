package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.f;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class TmplWebViewToolUI$b$h
  implements View.OnLongClickListener
{
  TmplWebViewToolUI$b$h(TmplWebViewToolUI.b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(15056);
    paramView = new StringBuilder();
    paramView.append(this.keJ.keD.toString());
    h.J((Context)this.keJ.keI, paramView.toString(), "");
    AppMethodBeat.o(15056);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.b.h
 * JD-Core Version:    0.7.0.1
 */