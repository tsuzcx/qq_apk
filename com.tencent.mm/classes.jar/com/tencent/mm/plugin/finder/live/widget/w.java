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
import com.tencent.mm.cr.a.c;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;", "Landroid/view/View$OnClickListener;", "luckyMoneyRoot", "Landroid/widget/LinearLayout;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/widget/LinearLayout;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "luckyMoneyArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "luckyMoneyIcon", "luckyMoneyTv", "Landroid/widget/TextView;", "checkLuckyMoneyStatusBySvrConfig", "", "goToSelectLuckyRoom", "onClick", "v", "Landroid/view/View;", "refreshLuckyMoneyChatroom", "plugin-finder_release"})
public final class w
  implements View.OnClickListener
{
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final TextView zoQ;
  private final WeImageView zoR;
  private final WeImageView zoS;
  private final LinearLayout zoT;
  
  public w(LinearLayout paramLinearLayout, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(288863);
    this.zoT = paramLinearLayout;
    this.xYp = parama;
    this.TAG = "Finder.FinderLiveLuckyMoneyWidget";
    this.zoQ = ((TextView)this.zoT.findViewById(b.f.finder_live_lucky_money_text));
    this.zoR = ((WeImageView)this.zoT.findViewById(b.f.finder_live_lucky_money_icon));
    this.zoS = ((WeImageView)this.zoT.findViewById(b.f.finder_live_lucky_money_arrow));
    this.zoT.setOnClickListener((View.OnClickListener)this);
    paramLinearLayout = aj.AGc;
    if (aj.eej())
    {
      paramLinearLayout = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Number)com.tencent.c.a.a.a.a.a.ili().aSr()).intValue() != 0) {
        paramLinearLayout = com.tencent.c.a.a.a.a.a.Zlt;
      }
    }
    for (int i = ((Number)com.tencent.c.a.a.a.a.a.ili().aSr()).intValue();; i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfZ.SES)
    {
      paramLinearLayout = this.TAG;
      parama = new StringBuilder("checkLuckyMoneyStatusBySvrConfig ").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfZ.SES).append(" FINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE.value():");
      com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
      Log.i(paramLinearLayout, ((Number)com.tencent.c.a.a.a.a.a.ili().aSr()).intValue() + " luckyMoneyConfig:" + i);
      this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (!com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.NV(i)) {
        break label588;
      }
      this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (!com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.NW(i)) {
        break;
      }
      paramLinearLayout = this.zoR;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setIconColor(parama.getResources().getColor(a.c.transparent));
      paramLinearLayout = this.zoR;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setImageDrawable(parama.getResources().getDrawable(b.e.finder_live_comment_lucky_money));
      paramLinearLayout = this.zoS;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setIconColor(parama.getResources().getColor(b.c.finder_live_lucky_money_txt_color));
      paramLinearLayout = this.zoQ;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setTextColor(parama.getResources().getColor(b.c.finder_live_lucky_money_txt_color));
      this.zoT.setVisibility(0);
      AppMethodBeat.o(288863);
      return;
    }
    this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.NX(i))
    {
      paramLinearLayout = this.zoR;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setIconColor(parama.getResources().getColor(a.c.BW_100_Alpha_0_8));
      paramLinearLayout = this.zoR;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setImageDrawable(parama.getResources().getDrawable(b.i.icon_finder_post_lucky_money));
      paramLinearLayout = this.zoS;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setIconColor(parama.getResources().getColor(b.c.white_text_color));
      paramLinearLayout = this.zoQ;
      parama = this.zoT.getContext();
      p.j(parama, "luckyMoneyRoot.context");
      paramLinearLayout.setTextColor(parama.getResources().getColor(b.c.white_text_color));
      this.zoT.setVisibility(0);
      AppMethodBeat.o(288863);
      return;
    }
    label588:
    this.zoT.setVisibility(8);
    AppMethodBeat.o(288863);
  }
  
  public final void dIt()
  {
    AppMethodBeat.i(288861);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeT.size();
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGG()) && (i > 0))
    {
      localTextView = this.zoQ;
      p.j(localTextView, "luckyMoneyTv");
      Context localContext = this.zoT.getContext();
      p.j(localContext, "luckyMoneyRoot.context");
      localTextView.setText((CharSequence)localContext.getResources().getString(b.j.finder_live_lucky_money_selected_tips, new Object[] { Integer.valueOf(i) }));
      localTextView = this.zoQ;
      p.j(localTextView, "luckyMoneyTv");
      localTextView.setVisibility(0);
      AppMethodBeat.o(288861);
      return;
    }
    TextView localTextView = this.zoQ;
    p.j(localTextView, "luckyMoneyTv");
    localTextView.setVisibility(8);
    AppMethodBeat.o(288861);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(288862);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_lucky_money_layout;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288862);
      return;
      paramView = null;
      break;
      label87:
      if (paramView.intValue() == i)
      {
        paramView = this.zoT.getContext();
        localObject = com.tencent.mm.plugin.findersdk.e.a.Bxf;
        paramView = new Intent(paramView, com.tencent.mm.plugin.findersdk.e.a.enH());
        localObject = this.zoT.getContext();
        p.j(localObject, "luckyMoneyRoot.context");
        paramView.putExtra("titile", ((Context)localObject).getResources().getString(b.j.finder_live_select_room_lucky_money_title));
        paramView.putExtra("KBlockOpenImFav", true);
        paramView.putExtra("KEY_LUCKY_MONEY_CHAT_ROOM_MAX_COUNT", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfZ.SER);
        paramView.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", new ArrayList((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zga.zeT));
        localObject = this.zoT.getContext();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(288862);
          throw paramView;
        }
        ((Activity)localObject).startActivityForResult(paramView, 1004);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.w
 * JD-Core Version:    0.7.0.1
 */