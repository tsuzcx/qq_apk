package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.d.b;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.plugin.gamelife.d.e;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"})
public final class g
  extends f
{
  b.b Did;
  private boolean isFirst;
  
  public g(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(203439);
    this.isFirst = true;
    AppMethodBeat.o(203439);
  }
  
  public static String o(Integer paramInteger)
  {
    AppMethodBeat.i(203437);
    int i;
    if (paramInteger != null)
    {
      i = paramInteger.intValue();
      paramInteger = new HashMap();
      if (i <= 0) {
        break label82;
      }
      ((Map)paramInteger).put("RedDot", "1");
    }
    for (;;)
    {
      ((Map)paramInteger).put("TotalNum", String.valueOf(i));
      paramInteger = com.tencent.mm.game.report.g.l((Map)paramInteger);
      p.j(paramInteger, "Report_12909.genExtInfo(map)");
      AppMethodBeat.o(203437);
      return paramInteger;
      i = 0;
      break;
      label82:
      ((Map)paramInteger).put("RedDot", "2");
    }
  }
  
  public final b.b E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203428);
    p.k(paramViewGroup, "parent");
    paramViewGroup = ad.kS(paramViewGroup.getContext()).inflate(d.d.Dgg, paramViewGroup, false);
    p.j(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    this.Did = new b.b(paramViewGroup);
    paramViewGroup = this.Did;
    if (paramViewGroup == null) {
      p.iCn();
    }
    AppMethodBeat.o(203428);
    return paramViewGroup;
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(203433);
    p.k(paramb, "holder");
    Object localObject1 = paramb.amk;
    p.j(localObject1, "holder.itemView");
    Object localObject2 = paramb.amk;
    ((View)localObject2).setOnClickListener((View.OnClickListener)new a((View)localObject2, this));
    if (ar.isDarkMode()) {
      ((ImageView)((View)localObject1).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_bell_dark);
    }
    for (;;)
    {
      ((View)localObject1).setBackgroundResource(d.b.comm_list_item_selector);
      ((TextView)((View)localObject1).findViewById(d.c.conversationName)).setText(d.f.DgE);
      localObject2 = (TextView)((View)localObject1).findViewById(d.c.descTv);
      p.j(localObject2, "itemView.descTv");
      ((TextView)localObject2).setVisibility(0);
      localObject2 = (TextView)((View)localObject1).findViewById(d.c.timeTv);
      p.j(localObject2, "itemView.timeTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (TextView)((View)localObject1).findViewById(d.c.tipCountTv);
      p.j(localObject2, "itemView.tipCountTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (TextView)((View)localObject1).findViewById(d.c.tipNomalTv);
      p.j(localObject2, "itemView.tipNomalTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (WeImageView)((View)localObject1).findViewById(d.c.DfW);
      p.j(localObject2, "itemView.rightArrow");
      ((WeImageView)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(d.c.DfJ);
      p.j(localObject2, "itemView.divider_2px");
      ((View)localObject2).setVisibility(8);
      localObject2 = ((View)localObject1).findViewById(d.c.DfK);
      p.j(localObject2, "itemView.divider_8dp");
      ((View)localObject2).setVisibility(0);
      paramInt = ((com.tencent.mm.plugin.game.api.c)h.ae(com.tencent.mm.plugin.game.api.c.class)).Tn(2);
      paramb = paramb.amk;
      p.j(paramb, "holder.itemView");
      paramb.setTag(Integer.valueOf(paramInt));
      if (paramInt > 0)
      {
        paramb = (TextView)((View)localObject1).findViewById(d.c.tipNomalTv);
        p.j(paramb, "itemView.tipNomalTv");
        paramb.setVisibility(0);
      }
      paramb = (TextView)((View)localObject1).findViewById(d.c.descTv);
      p.j(paramb, "itemView.descTv");
      paramb.setText((CharSequence)((com.tencent.mm.plugin.game.api.c)h.ae(com.tencent.mm.plugin.game.api.c.class)).To(2));
      if (this.isFirst)
      {
        this.isFirst = false;
        paramb = MMApplicationContext.getContext();
        localObject1 = com.tencent.mm.plugin.gamelife.i.a.DhX;
        com.tencent.mm.game.report.g.a(paramb, 21, 2101, 2, 1, (int)com.tencent.mm.plugin.gamelife.i.a.eAv(), o(Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(203433);
      return;
      ((ImageView)((View)localObject1).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_bell);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203400);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = new Intent();
      ((Intent)localObject).putExtra("game_msg_center_tab_type", 2);
      com.tencent.mm.by.c.b(this.xkv.getContext(), "game", ".ui.message.GameMsgCenterUI", (Intent)localObject);
      p.j(paramView, "view");
      paramView = paramView.getTag();
      if (paramView != null) {
        if ((paramView instanceof Integer)) {
          paramView = Integer.valueOf(((Number)paramView).intValue());
        }
      }
      for (;;)
      {
        localObject = MMApplicationContext.getContext();
        com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.DhX;
        com.tencent.mm.game.report.g.a((Context)localObject, 21, 2101, 2, 6, (int)com.tencent.mm.plugin.gamelife.i.a.eAv(), g.o(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203400);
        return;
        paramView = Integer.valueOf(0);
        continue;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.g
 * JD-Core Version:    0.7.0.1
 */