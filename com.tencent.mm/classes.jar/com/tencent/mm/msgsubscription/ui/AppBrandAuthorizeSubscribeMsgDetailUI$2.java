package com.tencent.mm.msgsubscription.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.ui.widget.a.j;

final class AppBrandAuthorizeSubscribeMsgDetailUI$2
  implements View.OnClickListener
{
  AppBrandAuthorizeSubscribeMsgDetailUI$2(AppBrandAuthorizeSubscribeMsgDetailUI paramAppBrandAuthorizeSubscribeMsgDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236652);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    paramView = LayoutInflater.from(this.pkM).inflate(c.f.show_sample_layout, null);
    localObject1 = (LinearLayout)paramView.findViewById(c.e.container);
    Object localObject2 = com.tencent.mm.msgsubscription.util.b.pmS;
    ((LinearLayout)localObject1).addView(com.tencent.mm.msgsubscription.util.b.a(this.pkM, AppBrandAuthorizeSubscribeMsgDetailUI.b(this.pkM).phS, 0));
    localObject2 = (TextView)paramView.findViewById(c.e.sample_view_title);
    localObject1 = paramView.findViewById(c.e.close_wiv);
    ((TextView)localObject2).setText(AppBrandAuthorizeSubscribeMsgDetailUI.b(this.pkM).title);
    localObject2 = new j(this.pkM);
    ((j)localObject2).F(paramView, 0, 0);
    ((j)localObject2).dDn();
    ((View)localObject1).setOnClickListener(new AppBrandAuthorizeSubscribeMsgDetailUI.2.1(this, (j)localObject2));
    ((View)localObject1).setContentDescription(this.pkM.getResources().getString(c.h.app_close));
    a.a(this, "com/tencent/mm/msgsubscription/ui/AppBrandAuthorizeSubscribeMsgDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI.2
 * JD-Core Version:    0.7.0.1
 */