package com.tencent.mm.plugin.gamelife.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f
{
  private b.b JbU;
  private boolean isFirst;
  
  public a(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(267877);
    this.isFirst = true;
    AppMethodBeat.o(267877);
  }
  
  private static final void a(View paramView1, a parama, View paramView2)
  {
    AppMethodBeat.i(267897);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView1);
    localb.cH(parama);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$this_apply");
    s.u(parama, "this$0");
    parama = new Intent();
    parama.putExtra("game_msg_center_tab_type", 1);
    com.tencent.mm.br.c.b(paramView1.getContext(), "game", ".ui.message.GameMsgCenterUI", parama);
    paramView1 = paramView2.getTag();
    if (paramView1 == null)
    {
      paramView1 = null;
      parama = MMApplicationContext.getContext();
      paramView2 = com.tencent.mm.plugin.gamelife.j.a.JbN;
      g.a(parama, 21, 2101, 1, 6, (int)com.tencent.mm.plugin.gamelife.j.a.fIw(), v(paramView1));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267897);
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
    AppMethodBeat.i(267887);
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
      paramInteger = g.s((Map)paramInteger);
      s.s(paramInteger, "genExtInfo(map)");
      AppMethodBeat.o(267887);
      return paramInteger;
      i = paramInteger.intValue();
      break;
      label82:
      ((Map)paramInteger).put("RedDot", "2");
    }
  }
  
  public final b.b O(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(267914);
    s.u(paramViewGroup, "parent");
    paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(d.d.Jab, paramViewGroup, false);
    s.s(paramViewGroup, "getInflater(parent.conte…rmal_item, parent, false)");
    this.JbU = new b.b(paramViewGroup);
    paramViewGroup = this.JbU;
    s.checkNotNull(paramViewGroup);
    AppMethodBeat.o(267914);
    return paramViewGroup;
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(267932);
    s.u(paramb, "holder");
    Object localObject = paramb.caK;
    s.s(localObject, "holder.itemView");
    paramb = paramb.caK;
    paramb.setOnClickListener(new a..ExternalSyntheticLambda0(paramb, this));
    TextView localTextView;
    if (aw.isDarkMode())
    {
      ((ImageView)((View)localObject).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_thumbs_dark);
      ((View)localObject).setBackgroundResource(d.b.comm_list_item_selector);
      ((TextView)((View)localObject).findViewById(d.c.conversationName)).setText(d.f.Jav);
      ((TextView)((View)localObject).findViewById(d.c.descTv)).setVisibility(0);
      ((TextView)((View)localObject).findViewById(d.c.timeTv)).setVisibility(8);
      ((TextView)((View)localObject).findViewById(d.c.tipCountTv)).setVisibility(8);
      ((TextView)((View)localObject).findViewById(d.c.tipNomalTv)).setVisibility(8);
      ((WeImageView)((View)localObject).findViewById(d.c.IZR)).setVisibility(0);
      paramInt = ((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).WY(1);
      if (paramInt > 0)
      {
        ((TextView)((View)localObject).findViewById(d.c.tipCountTv)).setVisibility(0);
        localTextView = (TextView)((View)localObject).findViewById(d.c.tipCountTv);
        if (paramInt <= 99) {
          break label364;
        }
      }
    }
    label364:
    for (paramb = (CharSequence)"...";; paramb = (CharSequence)String.valueOf(paramInt))
    {
      localTextView.setText(paramb);
      ((TextView)((View)localObject).findViewById(d.c.tipCountTv)).setBackgroundResource(v.bC(((View)localObject).getContext(), paramInt));
      ((TextView)((View)localObject).findViewById(d.c.descTv)).setText((CharSequence)((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).WZ(1));
      if (this.isFirst)
      {
        this.isFirst = false;
        paramb = MMApplicationContext.getContext();
        localObject = com.tencent.mm.plugin.gamelife.j.a.JbN;
        g.a(paramb, 21, 0, 0, 1, (int)com.tencent.mm.plugin.gamelife.j.a.fIw(), null);
        paramb = MMApplicationContext.getContext();
        localObject = com.tencent.mm.plugin.gamelife.j.a.JbN;
        g.a(paramb, 21, 2101, 1, 1, (int)com.tencent.mm.plugin.gamelife.j.a.fIw(), v(Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(267932);
      return;
      ((ImageView)((View)localObject).findViewById(d.c.avatarIv)).setImageResource(d.e.ic_filled_thumbs);
      break;
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(267939);
    b.b localb = this.JbU;
    if (localb != null) {
      a(localb, 0);
    }
    AppMethodBeat.o(267939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.a
 * JD-Core Version:    0.7.0.1
 */