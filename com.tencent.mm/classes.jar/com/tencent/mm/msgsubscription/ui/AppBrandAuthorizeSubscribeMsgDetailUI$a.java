package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.ui.base.preference.Preference;

final class AppBrandAuthorizeSubscribeMsgDetailUI$a
  extends Preference
{
  private View.OnClickListener bwV;
  
  public AppBrandAuthorizeSubscribeMsgDetailUI$a(AppBrandAuthorizeSubscribeMsgDetailUI paramAppBrandAuthorizeSubscribeMsgDetailUI, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    AppMethodBeat.i(193079);
    this.bwV = null;
    this.bwV = paramOnClickListener;
    setLayoutResource(c.f.show_sample_preference_layout);
    AppMethodBeat.o(193079);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(193082);
    super.onBindView(paramView);
    AppMethodBeat.o(193082);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(193081);
    paramViewGroup = super.onCreateView(paramViewGroup);
    paramViewGroup.findViewById(c.e.text).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229340);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$ShowSamplePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (AppBrandAuthorizeSubscribeMsgDetailUI.a.a(AppBrandAuthorizeSubscribeMsgDetailUI.a.this) != null) {
          AppBrandAuthorizeSubscribeMsgDetailUI.a.a(AppBrandAuthorizeSubscribeMsgDetailUI.a.this).onClick(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$ShowSamplePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229340);
      }
    });
    AppMethodBeat.o(193081);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI.a
 * JD-Core Version:    0.7.0.1
 */