package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.ui.base.preference.Preference;

final class AppBrandAuthorizeSubscribeMsgDetailUI$a
  extends Preference
{
  private View.OnClickListener dpY;
  
  public AppBrandAuthorizeSubscribeMsgDetailUI$a(AppBrandAuthorizeSubscribeMsgDetailUI paramAppBrandAuthorizeSubscribeMsgDetailUI, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    AppMethodBeat.i(236596);
    this.dpY = null;
    this.dpY = paramOnClickListener;
    setLayoutResource(c.f.show_sample_preference_layout);
    AppMethodBeat.o(236596);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(236612);
    super.onBindView(paramView);
    AppMethodBeat.o(236612);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(236609);
    paramViewGroup = super.onCreateView(paramViewGroup);
    View localView = paramViewGroup.findViewById(c.e.text);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(236575);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$ShowSamplePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (AppBrandAuthorizeSubscribeMsgDetailUI.a.a(AppBrandAuthorizeSubscribeMsgDetailUI.a.this) != null) {
          AppBrandAuthorizeSubscribeMsgDetailUI.a.a(AppBrandAuthorizeSubscribeMsgDetailUI.a.this).onClick(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$ShowSamplePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(236575);
      }
    });
    localView.setContentDescription(this.pkM.getResources().getString(c.h.biz_subscribe_msg_show_message_sample) + "," + this.pkM.getResources().getString(c.h.biz_subscribe_msg_button));
    AppMethodBeat.o(236609);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI.a
 * JD-Core Version:    0.7.0.1
 */