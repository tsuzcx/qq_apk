package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;

final class MPVideoViewControlBar$6
  implements View.OnClickListener
{
  MPVideoViewControlBar$6(MPVideoViewControlBar paramMPVideoViewControlBar, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209600);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.geH);
    paramView.putExtra("Contact_Scene", 179);
    paramView.putExtra("force_get_contact", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    d.b(this.ouE.getContext(), "profile", ".ui.ContactInfoUI", paramView);
    m.Ac(45);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(209600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.6
 * JD-Core Version:    0.7.0.1
 */