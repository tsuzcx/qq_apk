package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.n;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;", "Landroid/view/View$OnClickListener;", "luckyMoneyRoot", "Landroid/widget/LinearLayout;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/widget/LinearLayout;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "luckyMoneyArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "luckyMoneyIcon", "luckyMoneyTv", "Landroid/widget/TextView;", "checkLuckyMoneyStatusBySvrConfig", "", "goToSelectLuckyRoom", "onClick", "v", "Landroid/view/View;", "refreshLuckyMoneyChatroom", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  implements View.OnClickListener
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final LinearLayout Erv;
  private final TextView Erw;
  private final WeImageView Erx;
  private final WeImageView Ery;
  private final String TAG;
  
  public al(LinearLayout paramLinearLayout, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(361545);
    this.Erv = paramLinearLayout;
    this.CvU = parama;
    this.TAG = "Finder.FinderLiveLuckyMoneyWidget";
    this.Erw = ((TextView)this.Erv.findViewById(p.e.BND));
    this.Erx = ((WeImageView)this.Erv.findViewById(p.e.BNB));
    this.Ery = ((WeImageView)this.Erv.findViewById(p.e.BNz));
    this.Erv.setOnClickListener((View.OnClickListener)this);
    paramLinearLayout = aw.Gjk;
    if (aw.bgV())
    {
      paramLinearLayout = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jRI().bmg()).intValue() != 0) {
        paramLinearLayout = com.tencent.d.a.a.a.a.a.ahiX;
      }
    }
    for (int i = ((Number)com.tencent.d.a.a.a.a.a.jRI().bmg()).intValue();; i = ((e)this.CvU.business(e.class)).EdP.ZGu)
    {
      paramLinearLayout = this.TAG;
      parama = new StringBuilder("checkLuckyMoneyStatusBySvrConfig ").append(((e)this.CvU.business(e.class)).EdP.ZGu).append(" FINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE.value():");
      com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
      Log.i(paramLinearLayout, ((Number)com.tencent.d.a.a.a.a.a.jRI().bmg()).intValue() + " luckyMoneyConfig:" + i);
      this.CvU.business(e.class);
      if (!e.Qa(i)) {
        break label508;
      }
      this.CvU.business(e.class);
      if (!e.Qb(i)) {
        break;
      }
      this.Erx.setIconColor(this.Erv.getContext().getResources().getColor(a.c.transparent));
      this.Erx.setImageDrawable(this.Erv.getContext().getResources().getDrawable(p.d.BzW));
      this.Ery.setIconColor(this.Erv.getContext().getResources().getColor(p.b.Bzb));
      this.Erw.setTextColor(this.Erv.getContext().getResources().getColor(p.b.Bzb));
      this.Erv.setVisibility(0);
      AppMethodBeat.o(361545);
      return;
    }
    this.CvU.business(e.class);
    if (e.Qc(i))
    {
      this.Erx.setIconColor(this.Erv.getContext().getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.Erx.setImageDrawable(this.Erv.getContext().getResources().getDrawable(p.g.icon_finder_post_lucky_money));
      this.Ery.setIconColor(this.Erv.getContext().getResources().getColor(p.b.white_text_color));
      this.Erw.setTextColor(this.Erv.getContext().getResources().getColor(p.b.white_text_color));
      this.Erv.setVisibility(0);
      AppMethodBeat.o(361545);
      return;
    }
    label508:
    this.Erv.setVisibility(8);
    AppMethodBeat.o(361545);
  }
  
  public final void eBb()
  {
    AppMethodBeat.i(361554);
    int i = ((e)this.CvU.business(e.class)).EdQ.EbY.size();
    if ((((e)this.CvU.business(e.class)).eys()) && (i > 0))
    {
      this.Erw.setText((CharSequence)this.Erv.getContext().getResources().getString(p.h.Cnc, new Object[] { Integer.valueOf(i) }));
      this.Erw.setVisibility(0);
      AppMethodBeat.o(361554);
      return;
    }
    this.Erw.setVisibility(8);
    AppMethodBeat.o(361554);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361564);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BNC;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361564);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label87:
      if (paramView.intValue() == i)
      {
        paramView = this.Erv.getContext();
        localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
        paramView = new Intent(paramView, com.tencent.mm.plugin.findersdk.e.a.fsw());
        paramView.putExtra("titile", this.Erv.getContext().getResources().getString(p.h.Csn));
        paramView.putExtra("KBlockOpenImFav", true);
        paramView.putExtra("KEY_LUCKY_MONEY_CHAT_ROOM_MAX_COUNT", ((e)this.CvU.business(e.class)).EdP.ZGt);
        paramView.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", new ArrayList((Collection)((e)this.CvU.business(e.class)).EdQ.EbY));
        localObject = this.Erv.getContext();
        if (localObject == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(361564);
          throw paramView;
        }
        com.tencent.mm.hellhoundlib.a.a.a((Activity)localObject, c.a(1004, new com.tencent.mm.hellhoundlib.b.a()).cG(paramView).aYi(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget", "goToSelectLuckyRoom", "()V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.al
 * JD-Core Version:    0.7.0.1
 */