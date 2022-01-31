package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ForceNotifyAcceptUI$e
  implements View.OnClickListener
{
  ForceNotifyAcceptUI$e(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(140607);
    ab.i(this.mHy.TAG, "Cancel!");
    this.mHy.finish();
    AppMethodBeat.o(140607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.e
 * JD-Core Version:    0.7.0.1
 */