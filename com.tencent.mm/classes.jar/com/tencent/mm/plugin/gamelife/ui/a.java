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
import com.tencent.mm.game.report.g;
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
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"})
public final class a
  extends f
{
  b.b Did;
  private boolean isFirst;
  
  public a(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(204132);
    this.isFirst = true;
    AppMethodBeat.o(204132);
  }
  
  public static String o(Integer paramInteger)
  {
    AppMethodBeat.i(204131);
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
      paramInteger = g.l((Map)paramInteger);
      p.j(paramInteger, "Report_12909.genExtInfo(map)");
      AppMethodBeat.o(204131);
      return paramInteger;
      i = 0;
      break;
      label82:
      ((Map)paramInteger).put("RedDot", "2");
    }
  }
  
  public final b.b E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204129);
    p.k(paramViewGroup, "parent");
    paramViewGroup = ad.kS(paramViewGroup.getContext()).inflate(d.d.Dgg, paramViewGroup, false);
    p.j(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    this.Did = new b.b(paramViewGroup);
    paramViewGroup = this.Did;
    if (paramViewGroup == null) {
      p.iCn();
    }
    AppMethodBeat.o(204129);
    return paramViewGroup;
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(204130);
    p.k(paramb, "holder");
    Object localObject = paramb.amk;
    p.j(localObject, "holder.itemView");
    paramb = paramb.amk;
    paramb.setOnClickListener((View.OnClickListener)new a(paramb, this));
    TextView localTextView;
    if (ar.isDarkMode())
    {
      ((ImageView)((View)localObject).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_thumbs_dark);
      ((View)localObject).setBackgroundResource(d.b.comm_list_item_selector);
      ((TextView)((View)localObject).findViewById(d.c.conversationName)).setText(d.f.DgB);
      paramb = (TextView)((View)localObject).findViewById(d.c.descTv);
      p.j(paramb, "itemView.descTv");
      paramb.setVisibility(0);
      paramb = (TextView)((View)localObject).findViewById(d.c.timeTv);
      p.j(paramb, "itemView.timeTv");
      paramb.setVisibility(8);
      paramb = (TextView)((View)localObject).findViewById(d.c.tipCountTv);
      p.j(paramb, "itemView.tipCountTv");
      paramb.setVisibility(8);
      paramb = (TextView)((View)localObject).findViewById(d.c.tipNomalTv);
      p.j(paramb, "itemView.tipNomalTv");
      paramb.setVisibility(8);
      paramb = (WeImageView)((View)localObject).findViewById(d.c.DfW);
      p.j(paramb, "itemView.rightArrow");
      paramb.setVisibility(0);
      paramInt = ((com.tencent.mm.plugin.game.api.c)h.ae(com.tencent.mm.plugin.game.api.c.class)).Tn(1);
      if (paramInt > 0)
      {
        paramb = (TextView)((View)localObject).findViewById(d.c.tipCountTv);
        p.j(paramb, "itemView.tipCountTv");
        paramb.setVisibility(0);
        localTextView = (TextView)((View)localObject).findViewById(d.c.tipCountTv);
        p.j(localTextView, "itemView.tipCountTv");
        if (paramInt <= 99) {
          break label427;
        }
      }
    }
    label427:
    for (paramb = (CharSequence)"...";; paramb = (CharSequence)String.valueOf(paramInt))
    {
      localTextView.setText(paramb);
      ((TextView)((View)localObject).findViewById(d.c.tipCountTv)).setBackgroundResource(w.bj(((View)localObject).getContext(), paramInt));
      paramb = (TextView)((View)localObject).findViewById(d.c.descTv);
      p.j(paramb, "itemView.descTv");
      paramb.setText((CharSequence)((com.tencent.mm.plugin.game.api.c)h.ae(com.tencent.mm.plugin.game.api.c.class)).To(1));
      if (this.isFirst)
      {
        this.isFirst = false;
        paramb = MMApplicationContext.getContext();
        localObject = com.tencent.mm.plugin.gamelife.i.a.DhX;
        g.a(paramb, 21, 0, 0, 1, (int)com.tencent.mm.plugin.gamelife.i.a.eAv(), null);
        paramb = MMApplicationContext.getContext();
        localObject = com.tencent.mm.plugin.gamelife.i.a.DhX;
        g.a(paramb, 21, 2101, 1, 1, (int)com.tencent.mm.plugin.gamelife.i.a.eAv(), o(Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(204130);
      return;
      ((ImageView)((View)localObject).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_thumbs);
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203154);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = new Intent();
      ((Intent)localObject).putExtra("game_msg_center_tab_type", 1);
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
        g.a((Context)localObject, 21, 2101, 1, 6, (int)com.tencent.mm.plugin.gamelife.i.a.eAv(), a.o(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203154);
        return;
        paramView = Integer.valueOf(0);
        continue;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.a
 * JD-Core Version:    0.7.0.1
 */