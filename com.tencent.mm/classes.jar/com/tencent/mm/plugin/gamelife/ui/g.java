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
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"})
public final class g
  extends f
{
  private boolean isFirst;
  b.b uKd;
  
  public g(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(212289);
    this.isFirst = true;
    AppMethodBeat.o(212289);
  }
  
  public static String l(Integer paramInteger)
  {
    AppMethodBeat.i(212288);
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
      paramInteger = com.tencent.mm.game.report.f.r((Map)paramInteger);
      p.g(paramInteger, "Report_12909.genExtInfo(map)");
      AppMethodBeat.o(212288);
      return paramInteger;
      i = 0;
      break;
      label82:
      ((Map)paramInteger).put("RedDot", "2");
    }
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(212287);
    p.h(paramb, "holder");
    Object localObject1 = paramb.auu;
    p.g(localObject1, "holder.itemView");
    Object localObject2 = paramb.auu;
    ((View)localObject2).setOnClickListener((View.OnClickListener)new a((View)localObject2, this));
    if (al.isDarkMode()) {
      ((ImageView)((View)localObject1).findViewById(2131296998)).setImageResource(2131691591);
    }
    for (;;)
    {
      ((View)localObject1).setBackgroundResource(2131231818);
      ((TextView)((View)localObject1).findViewById(2131308075)).setText(2131766901);
      localObject2 = (TextView)((View)localObject1).findViewById(2131308084);
      p.g(localObject2, "itemView.descTv");
      ((TextView)localObject2).setVisibility(0);
      localObject2 = (TextView)((View)localObject1).findViewById(2131305812);
      p.g(localObject2, "itemView.timeTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (TextView)((View)localObject1).findViewById(2131308218);
      p.g(localObject2, "itemView.tipCountTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (TextView)((View)localObject1).findViewById(2131308219);
      p.g(localObject2, "itemView.tipNomalTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (WeImageView)((View)localObject1).findViewById(2131308188);
      p.g(localObject2, "itemView.rightArrow");
      ((WeImageView)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131308094);
      p.g(localObject2, "itemView.divider_2px");
      ((View)localObject2).setVisibility(8);
      localObject2 = ((View)localObject1).findViewById(2131308095);
      p.g(localObject2, "itemView.divider_8dp");
      ((View)localObject2).setVisibility(0);
      paramInt = ((c)com.tencent.mm.kernel.g.ab(c.class)).HV(2);
      paramb = paramb.auu;
      p.g(paramb, "holder.itemView");
      paramb.setTag(Integer.valueOf(paramInt));
      if (paramInt > 0)
      {
        paramb = (TextView)((View)localObject1).findViewById(2131308219);
        p.g(paramb, "itemView.tipNomalTv");
        paramb.setVisibility(0);
      }
      paramb = (TextView)((View)localObject1).findViewById(2131308084);
      p.g(paramb, "itemView.descTv");
      paramb.setText((CharSequence)((c)com.tencent.mm.kernel.g.ab(c.class)).HW(2));
      if (this.isFirst)
      {
        this.isFirst = false;
        paramb = ak.getContext();
        localObject1 = com.tencent.mm.plugin.gamelife.i.a.uJX;
        com.tencent.mm.game.report.f.a(paramb, 21, 2101, 2, 1, (int)com.tencent.mm.plugin.gamelife.i.a.ddC(), l(Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(212287);
      return;
      ((ImageView)((View)localObject1).findViewById(2131296998)).setImageResource(2131689656);
    }
  }
  
  public final b.b t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(212286);
    p.h(paramViewGroup, "parent");
    paramViewGroup = z.jV(paramViewGroup.getContext()).inflate(2131496407, paramViewGroup, false);
    p.g(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    this.uKd = new b.b(paramViewGroup);
    paramViewGroup = this.uKd;
    if (paramViewGroup == null) {
      p.gkB();
    }
    AppMethodBeat.o(212286);
    return paramViewGroup;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212285);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent();
      ((Intent)localObject).putExtra("game_msg_center_tab_type", 2);
      d.b(this.scH.getContext(), "game", ".ui.message.GameMsgCenterUI", (Intent)localObject);
      p.g(paramView, "view");
      paramView = paramView.getTag();
      if (paramView != null) {
        if ((paramView instanceof Integer)) {
          paramView = Integer.valueOf(((Number)paramView).intValue());
        }
      }
      for (;;)
      {
        localObject = ak.getContext();
        com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.uJX;
        com.tencent.mm.game.report.f.a((Context)localObject, 21, 2101, 2, 6, (int)com.tencent.mm.plugin.gamelife.i.a.ddC(), g.l(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212285);
        return;
        paramView = Integer.valueOf(0);
        continue;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.g
 * JD-Core Version:    0.7.0.1
 */