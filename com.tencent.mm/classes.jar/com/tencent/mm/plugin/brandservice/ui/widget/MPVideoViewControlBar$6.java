package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;

final class MPVideoViewControlBar$6
  implements View.OnClickListener
{
  MPVideoViewControlBar$6(MPVideoViewControlBar paramMPVideoViewControlBar, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(193007);
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.fHA);
    paramView.putExtra("Contact_Scene", 179);
    paramView.putExtra("force_get_contact", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    d.b(this.noW.getContext(), "profile", ".ui.ContactInfoUI", paramView);
    m.yC(45);
    AppMethodBeat.o(193007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.6
 * JD-Core Version:    0.7.0.1
 */