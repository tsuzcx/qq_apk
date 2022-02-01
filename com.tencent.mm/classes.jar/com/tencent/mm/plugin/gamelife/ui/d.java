package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "bindHistoryConversation", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "item", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "reportConversationItem", "actionType", "", "plugin-gamelife_release"})
public final class d
  extends f
{
  b.c uyH;
  b.d uyI;
  
  public d(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(211447);
    AppMethodBeat.o(211447);
  }
  
  public final void a(final b.b paramb, final int paramInt)
  {
    AppMethodBeat.i(211446);
    p.h(paramb, "holder");
    Object localObject2 = paramb.auu;
    p.g(localObject2, "holder.itemView");
    final com.tencent.mm.plugin.gamelife.e.a locala = this.uzq.Ie(paramInt);
    paramb.em(locala);
    ((View)localObject2).setBackgroundResource(2131231818);
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131308084);
    p.g(localTextView, "itemView.descTv");
    Object localObject1 = aj.getContext();
    int i;
    if ((locala.field_digestFlag & 1L) > 0L)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)com.tencent.mm.cc.a.az((Context)localObject1, 2131766894));
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.cc.a.n((Context)localObject1, 2131099803)), 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append((CharSequence)" ").append((CharSequence)k.c((Context)localObject1, (CharSequence)locala.field_digest));
      localObject1 = (CharSequence)localSpannableStringBuilder;
      localTextView.setText((CharSequence)localObject1);
      localObject1 = (TextView)((View)localObject2).findViewById(2131305812);
      p.g(localObject1, "itemView.timeTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(i.c(((View)localObject2).getContext(), locala.field_updateTime, true)));
      localObject1 = (TextView)((View)localObject2).findViewById(2131308219);
      p.g(localObject1, "itemView.tipNomalTv");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (TextView)((View)localObject2).findViewById(2131308218);
      p.g(localObject1, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 0) {
        break label514;
      }
      i = 0;
      label280:
      ((TextView)localObject1).setVisibility(i);
      localTextView = (TextView)((View)localObject2).findViewById(2131308218);
      p.g(localTextView, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 999) {
        break label520;
      }
    }
    label514:
    label520:
    for (localObject1 = (CharSequence)"...";; localObject1 = (CharSequence)String.valueOf(locala.field_unReadCount))
    {
      localTextView.setText((CharSequence)localObject1);
      ((TextView)((View)localObject2).findViewById(2131308218)).setBackgroundResource(u.aP(((View)localObject2).getContext(), locala.field_unReadCount));
      if (!locala.daI()) {
        break label536;
      }
      localObject1 = paramb.auu;
      ((ImageView)((View)localObject1).findViewById(2131296998)).setImageResource(2131235005);
      localObject2 = (TextView)((View)localObject1).findViewById(2131308075);
      p.g(localObject2, "conversationName");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cc.a.az(((View)localObject1).getContext(), 2131766896));
      ((View)localObject1).setOnClickListener((View.OnClickListener)new a((View)localObject1, this, locala, paramInt, paramb));
      ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new b((View)localObject1, this, locala, paramInt, paramb));
      AppMethodBeat.o(211446);
      return;
      localObject1 = k.c((Context)localObject1, (CharSequence)locala.field_digest);
      p.g(localObject1, "MMSpanManager.spanForSmiley(context, field_digest)");
      localObject1 = (CharSequence)localObject1;
      break;
      i = 8;
      break label280;
    }
    label536:
    ((View)localObject2).setOnClickListener((View.OnClickListener)new c((View)localObject2, this, locala, paramInt, paramb));
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)new d((View)localObject2, this, locala, paramInt, paramb));
    paramb = (TextView)((View)localObject2).findViewById(2131308075);
    p.g(paramb, "conversationName");
    paramb.setText(locala.rLm);
    com.tencent.mm.ui.f.a.a.c((ImageView)((View)localObject2).findViewById(2131296998), locala.field_sessionId);
    AppMethodBeat.o(211446);
  }
  
  public final b.b t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(211445);
    p.h(paramViewGroup, "parent");
    paramViewGroup = z.jO(paramViewGroup.getContext()).inflate(2131496407, paramViewGroup, false);
    p.g(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    paramViewGroup = new b.b(paramViewGroup);
    AppMethodBeat.o(211445);
    return paramViewGroup;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211441);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      d.a(jdField_this, locala, 7L, paramInt);
      ((c)g.ab(c.class)).fl(this.rUd.getContext());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211441);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$2"})
  static final class b
    implements View.OnLongClickListener
  {
    b(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(211442);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.fQC();
      localObject = jdField_this.uyI;
      if (localObject != null)
      {
        View localView = this.rUd;
        p.g(localView, "this");
        int i = paramInt;
        p.g(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.uzq.daM());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(211442);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211443);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      d.a(jdField_this, locala, 2L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.fQC();
      localObject = jdField_this.uyH;
      if (localObject != null)
      {
        View localView = this.rUd;
        p.g(paramView, "conversation");
        ((b.c)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211443);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$1$2"})
  static final class d
    implements View.OnLongClickListener
  {
    d(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(211444);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.fQC();
      localObject = jdField_this.uyI;
      if (localObject != null)
      {
        View localView = this.rUd;
        int i = paramInt;
        p.g(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.uzq.daM());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(211444);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.d
 * JD-Core Version:    0.7.0.1
 */