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
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"})
public final class a
  extends f
{
  private boolean isFirst;
  b.b uyA;
  
  public a(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(211415);
    this.isFirst = true;
    AppMethodBeat.o(211415);
  }
  
  public static String k(Integer paramInteger)
  {
    AppMethodBeat.i(211414);
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
      paramInteger = com.tencent.mm.game.report.f.k((Map)paramInteger);
      p.g(paramInteger, "Report_12909.genExtInfo(map)");
      AppMethodBeat.o(211414);
      return paramInteger;
      i = 0;
      break;
      label82:
      ((Map)paramInteger).put("RedDot", "2");
    }
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(211413);
    p.h(paramb, "holder");
    Object localObject = paramb.auu;
    p.g(localObject, "holder.itemView");
    paramb = paramb.auu;
    paramb.setOnClickListener((View.OnClickListener)new a(paramb, this));
    if (al.isDarkMode()) {
      ((ImageView)((View)localObject).findViewById(2131296998)).setImageResource(2131691593);
    }
    for (;;)
    {
      ((View)localObject).setBackgroundResource(2131231818);
      ((TextView)((View)localObject).findViewById(2131308075)).setText(2131766897);
      paramb = (TextView)((View)localObject).findViewById(2131308084);
      p.g(paramb, "itemView.descTv");
      paramb.setVisibility(0);
      paramb = (TextView)((View)localObject).findViewById(2131305812);
      p.g(paramb, "itemView.timeTv");
      paramb.setVisibility(8);
      paramb = (TextView)((View)localObject).findViewById(2131308218);
      p.g(paramb, "itemView.tipCountTv");
      paramb.setVisibility(8);
      paramb = (TextView)((View)localObject).findViewById(2131308219);
      p.g(paramb, "itemView.tipNomalTv");
      paramb.setVisibility(8);
      paramb = (WeImageView)((View)localObject).findViewById(2131308188);
      p.g(paramb, "itemView.rightArrow");
      paramb.setVisibility(0);
      paramInt = ((c)g.ab(c.class)).Hy(1);
      if (paramInt > 0)
      {
        paramb = (TextView)((View)localObject).findViewById(2131308219);
        p.g(paramb, "itemView.tipNomalTv");
        paramb.setVisibility(0);
      }
      paramb = (TextView)((View)localObject).findViewById(2131308084);
      p.g(paramb, "itemView.descTv");
      paramb.setText((CharSequence)((c)g.ab(c.class)).Hz(1));
      if (this.isFirst)
      {
        this.isFirst = false;
        paramb = aj.getContext();
        localObject = com.tencent.mm.plugin.gamelife.h.a.uyu;
        com.tencent.mm.game.report.f.a(paramb, 21, 0, 0, 1, (int)com.tencent.mm.plugin.gamelife.h.a.daL(), null);
        paramb = aj.getContext();
        localObject = com.tencent.mm.plugin.gamelife.h.a.uyu;
        com.tencent.mm.game.report.f.a(paramb, 21, 2101, 1, 1, (int)com.tencent.mm.plugin.gamelife.h.a.daL(), k(Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(211413);
      return;
      ((ImageView)((View)localObject).findViewById(2131296998)).setImageResource(2131691592);
    }
  }
  
  public final b.b t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(211412);
    p.h(paramViewGroup, "parent");
    paramViewGroup = z.jO(paramViewGroup.getContext()).inflate(2131496407, paramViewGroup, false);
    p.g(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    this.uyA = new b.b(paramViewGroup);
    paramViewGroup = this.uyA;
    if (paramViewGroup == null) {
      p.gfZ();
    }
    AppMethodBeat.o(211412);
    return paramViewGroup;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211411);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = new Intent();
      ((Intent)localObject).putExtra("game_msg_center_tab_type", 1);
      d.b(this.rUd.getContext(), "game", ".ui.message.GameMsgCenterUI", (Intent)localObject);
      p.g(paramView, "view");
      paramView = paramView.getTag();
      if (paramView != null) {
        if ((paramView instanceof Integer)) {
          paramView = Integer.valueOf(((Number)paramView).intValue());
        }
      }
      for (;;)
      {
        localObject = aj.getContext();
        com.tencent.mm.plugin.gamelife.h.a locala = com.tencent.mm.plugin.gamelife.h.a.uyu;
        com.tencent.mm.game.report.f.a((Context)localObject, 21, 2101, 1, 6, (int)com.tencent.mm.plugin.gamelife.h.a.daL(), a.k(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211411);
        return;
        paramView = Integer.valueOf(0);
        continue;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.a
 * JD-Core Version:    0.7.0.1
 */