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
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"})
public final class a
  extends f
{
  private boolean isFirst;
  private b.b ycy;
  
  public a(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(241435);
    this.isFirst = true;
    AppMethodBeat.o(241435);
  }
  
  public static String k(Integer paramInteger)
  {
    AppMethodBeat.i(241434);
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
      paramInteger = com.tencent.mm.game.report.f.t((Map)paramInteger);
      p.g(paramInteger, "Report_12909.genExtInfo(map)");
      AppMethodBeat.o(241434);
      return paramInteger;
      i = 0;
      break;
      label82:
      ((Map)paramInteger).put("RedDot", "2");
    }
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(241432);
    p.h(paramb, "holder");
    Object localObject = paramb.aus;
    p.g(localObject, "holder.itemView");
    paramb = paramb.aus;
    paramb.setOnClickListener((View.OnClickListener)new a(paramb, this));
    TextView localTextView;
    if (ao.isDarkMode())
    {
      ((ImageView)((View)localObject).findViewById(2131297121)).setImageResource(2131690426);
      ((View)localObject).setBackgroundResource(2131231898);
      ((TextView)((View)localObject).findViewById(2131299242)).setText(2131761384);
      paramb = (TextView)((View)localObject).findViewById(2131299497);
      p.g(paramb, "itemView.descTv");
      paramb.setVisibility(0);
      paramb = (TextView)((View)localObject).findViewById(2131309090);
      p.g(paramb, "itemView.timeTv");
      paramb.setVisibility(8);
      paramb = (TextView)((View)localObject).findViewById(2131309142);
      p.g(paramb, "itemView.tipCountTv");
      paramb.setVisibility(8);
      paramb = (TextView)((View)localObject).findViewById(2131309143);
      p.g(paramb, "itemView.tipNomalTv");
      paramb.setVisibility(8);
      paramb = (WeImageView)((View)localObject).findViewById(2131307074);
      p.g(paramb, "itemView.rightArrow");
      paramb.setVisibility(0);
      paramInt = ((com.tencent.mm.plugin.game.api.c)g.af(com.tencent.mm.plugin.game.api.c.class)).NY(1);
      if (paramInt > 0)
      {
        paramb = (TextView)((View)localObject).findViewById(2131309142);
        p.g(paramb, "itemView.tipCountTv");
        paramb.setVisibility(0);
        localTextView = (TextView)((View)localObject).findViewById(2131309142);
        p.g(localTextView, "itemView.tipCountTv");
        if (paramInt <= 99) {
          break label411;
        }
      }
    }
    label411:
    for (paramb = (CharSequence)"...";; paramb = (CharSequence)String.valueOf(paramInt))
    {
      localTextView.setText(paramb);
      ((TextView)((View)localObject).findViewById(2131309142)).setBackgroundResource(v.aQ(((View)localObject).getContext(), paramInt));
      paramb = (TextView)((View)localObject).findViewById(2131299497);
      p.g(paramb, "itemView.descTv");
      paramb.setText((CharSequence)((com.tencent.mm.plugin.game.api.c)g.af(com.tencent.mm.plugin.game.api.c.class)).NZ(1));
      if (this.isFirst)
      {
        this.isFirst = false;
        paramb = MMApplicationContext.getContext();
        localObject = com.tencent.mm.plugin.gamelife.i.a.ycs;
        com.tencent.mm.game.report.f.a(paramb, 21, 0, 0, 1, (int)com.tencent.mm.plugin.gamelife.i.a.dXm(), null);
        paramb = MMApplicationContext.getContext();
        localObject = com.tencent.mm.plugin.gamelife.i.a.ycs;
        com.tencent.mm.game.report.f.a(paramb, 21, 2101, 1, 1, (int)com.tencent.mm.plugin.gamelife.i.a.dXm(), k(Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(241432);
      return;
      ((ImageView)((View)localObject).findViewById(2131297121)).setImageResource(2131690425);
      break;
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(241433);
    b.b localb = this.ycy;
    if (localb != null)
    {
      a(localb, 0);
      AppMethodBeat.o(241433);
      return;
    }
    AppMethodBeat.o(241433);
  }
  
  public final b.b y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(241431);
    p.h(paramViewGroup, "parent");
    paramViewGroup = aa.jQ(paramViewGroup.getContext()).inflate(2131494976, paramViewGroup, false);
    p.g(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    this.ycy = new b.b(paramViewGroup);
    paramViewGroup = this.ycy;
    if (paramViewGroup == null) {
      p.hyc();
    }
    AppMethodBeat.o(241431);
    return paramViewGroup;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241430);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent();
      ((Intent)localObject).putExtra("game_msg_center_tab_type", 1);
      com.tencent.mm.br.c.b(this.tCl.getContext(), "game", ".ui.message.GameMsgCenterUI", (Intent)localObject);
      p.g(paramView, "view");
      paramView = paramView.getTag();
      if (paramView != null) {
        if ((paramView instanceof Integer)) {
          paramView = Integer.valueOf(((Number)paramView).intValue());
        }
      }
      for (;;)
      {
        localObject = MMApplicationContext.getContext();
        com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.ycs;
        com.tencent.mm.game.report.f.a((Context)localObject, 21, 2101, 1, 6, (int)com.tencent.mm.plugin.gamelife.i.a.dXm(), a.k(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241430);
        return;
        paramView = Integer.valueOf(0);
        continue;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.a
 * JD-Core Version:    0.7.0.1
 */