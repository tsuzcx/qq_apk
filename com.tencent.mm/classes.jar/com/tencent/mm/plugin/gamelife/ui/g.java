package com.tencent.mm.plugin.gamelife.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f
{
  b.b JbU;
  private boolean isFirst;
  
  public g(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(267899);
    this.isFirst = true;
    AppMethodBeat.o(267899);
  }
  
  private static final void a(View paramView1, g paramg, View paramView2)
  {
    AppMethodBeat.i(267926);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView1);
    localb.cH(paramg);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$this_apply");
    s.u(paramg, "this$0");
    paramg = new Intent();
    paramg.putExtra("game_msg_center_tab_type", 2);
    com.tencent.mm.br.c.b(paramView1.getContext(), "game", ".ui.message.GameMsgCenterUI", paramg);
    paramView1 = paramView2.getTag();
    if (paramView1 == null)
    {
      paramView1 = null;
      paramg = MMApplicationContext.getContext();
      paramView2 = com.tencent.mm.plugin.gamelife.j.a.JbN;
      com.tencent.mm.game.report.g.a(paramg, 21, 2101, 2, 6, (int)com.tencent.mm.plugin.gamelife.j.a.fIw(), v(paramView1));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267926);
      return;
    }
    if ((paramView1 instanceof Integer)) {}
    for (int i = ((Number)paramView1).intValue();; i = 0)
    {
      paramView1 = Integer.valueOf(i);
      break;
    }
  }
  
  private static String v(Integer paramInteger)
  {
    AppMethodBeat.i(267911);
    int i;
    if (paramInteger == null)
    {
      i = 0;
      paramInteger = new HashMap();
      if (i <= 0) {
        break label82;
      }
      ((Map)paramInteger).put("RedDot", "1");
    }
    for (;;)
    {
      ((Map)paramInteger).put("TotalNum", String.valueOf(i));
      paramInteger = com.tencent.mm.game.report.g.s((Map)paramInteger);
      s.s(paramInteger, "genExtInfo(map)");
      AppMethodBeat.o(267911);
      return paramInteger;
      i = paramInteger.intValue();
      break;
      label82:
      ((Map)paramInteger).put("RedDot", "2");
    }
  }
  
  public final b.b O(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(267942);
    s.u(paramViewGroup, "parent");
    paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(d.d.Jab, paramViewGroup, false);
    s.s(paramViewGroup, "getInflater(parent.conte…rmal_item, parent, false)");
    this.JbU = new b.b(paramViewGroup);
    paramViewGroup = this.JbU;
    s.checkNotNull(paramViewGroup);
    AppMethodBeat.o(267942);
    return paramViewGroup;
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(267981);
    s.u(paramb, "holder");
    Object localObject = paramb.caK;
    s.s(localObject, "holder.itemView");
    View localView = paramb.caK;
    localView.setOnClickListener(new g..ExternalSyntheticLambda0(localView, this));
    if (aw.isDarkMode()) {
      ((ImageView)((View)localObject).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_bell_dark);
    }
    for (;;)
    {
      ((View)localObject).setBackgroundResource(d.b.comm_list_item_selector);
      ((TextView)((View)localObject).findViewById(d.c.conversationName)).setText(d.f.Jay);
      ((TextView)((View)localObject).findViewById(d.c.descTv)).setVisibility(0);
      ((TextView)((View)localObject).findViewById(d.c.timeTv)).setVisibility(8);
      ((TextView)((View)localObject).findViewById(d.c.tipCountTv)).setVisibility(8);
      ((TextView)((View)localObject).findViewById(d.c.tipNomalTv)).setVisibility(8);
      ((WeImageView)((View)localObject).findViewById(d.c.IZR)).setVisibility(0);
      ((View)localObject).findViewById(d.c.IZE).setVisibility(8);
      ((View)localObject).findViewById(d.c.IZF).setVisibility(0);
      paramInt = ((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).WY(2);
      paramb.caK.setTag(Integer.valueOf(paramInt));
      if (paramInt > 0) {
        ((TextView)((View)localObject).findViewById(d.c.tipNomalTv)).setVisibility(0);
      }
      ((TextView)((View)localObject).findViewById(d.c.descTv)).setText((CharSequence)((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).WZ(2));
      if (this.isFirst)
      {
        this.isFirst = false;
        paramb = MMApplicationContext.getContext();
        localObject = com.tencent.mm.plugin.gamelife.j.a.JbN;
        com.tencent.mm.game.report.g.a(paramb, 21, 2101, 2, 1, (int)com.tencent.mm.plugin.gamelife.j.a.fIw(), v(Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(267981);
      return;
      ((ImageView)((View)localObject).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_bell);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.g
 * JD-Core Version:    0.7.0.1
 */