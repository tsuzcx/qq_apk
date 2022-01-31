package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoHeaderView$1
  implements View.OnClickListener
{
  MPVideoHeaderView$1(MPVideoHeaderView paramMPVideoHeaderView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(15251);
    if ((MPVideoHeaderView.e(this.kgT).fgk & 0x1) != 0)
    {
      ab.w(MPVideoHeaderView.g(this.kgT), "not allow jump to profile " + MPVideoHeaderView.e(this.kgT).fgk);
      AppMethodBeat.o(15251);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", MPVideoHeaderView.c(this.kgT));
    paramView.putExtra("Contact_Scene", 152);
    d.b(this.hEq, "profile", ".ui.ContactInfoUI", paramView);
    AppMethodBeat.o(15251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView.1
 * JD-Core Version:    0.7.0.1
 */