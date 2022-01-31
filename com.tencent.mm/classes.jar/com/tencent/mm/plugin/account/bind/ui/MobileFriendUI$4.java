package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class MobileFriendUI$4
  implements View.OnClickListener
{
  MobileFriendUI$4(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13722);
    BackwardSupportUtil.c.a(MobileFriendUI.f(this.gwb));
    AppMethodBeat.o(13722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.4
 * JD-Core Version:    0.7.0.1
 */