package com.tencent.mm.plugin.gamelife.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.z;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "bindHistoryConversation", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "item", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "reportConversationItem", "actionType", "", "plugin-gamelife_release"})
public final class d
  extends f
{
  b.c uKk;
  b.d uKl;
  
  public d(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(212226);
    AppMethodBeat.o(212226);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final b.b paramb, final int paramInt)
  {
    AppMethodBeat.i(212225);
    p.h(paramb, "holder");
    Object localObject2 = paramb.auu;
    p.g(localObject2, "holder.itemView");
    final com.tencent.mm.plugin.gamelife.e.a locala = this.uKV.IC(paramInt);
    paramb.ep(locala);
    ((View)localObject2).setBackgroundResource(2131231818);
    ((TextView)((View)localObject2).findViewById(2131308084)).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).doJ().arc(locala.field_sessionId);
    TextView localTextView;
    Object localObject3;
    int i;
    if ((localObject1 != null) && (((bv)localObject1).getStatus() == 5))
    {
      localObject1 = ((View)localObject2).getContext();
      p.g(localObject1, "itemView.context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2131690877);
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        ((TextView)((View)localObject2).findViewById(2131308084)).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
      }
    }
    else
    {
      localTextView = (TextView)((View)localObject2).findViewById(2131308084);
      p.g(localTextView, "itemView.descTv");
      localObject1 = ak.getContext();
      if ((locala.field_digestFlag & 1L) > 0L)
      {
        locala.field_digestPrefix = com.tencent.mm.cb.a.az((Context)localObject1, 2131766894);
        locala.field_digestFlag = 0L;
      }
      localObject3 = (CharSequence)locala.field_digestPrefix;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label617;
      }
      i = 1;
      label265:
      if (i == 0) {
        break label622;
      }
      localObject1 = k.c((Context)localObject1, (CharSequence)locala.field_digest);
      p.g(localObject1, "MMSpanManager.spanForSmiley(context, field_digest)");
      localObject1 = (CharSequence)localObject1;
      label299:
      localTextView.setText((CharSequence)localObject1);
      localObject1 = (TextView)((View)localObject2).findViewById(2131305812);
      p.g(localObject1, "itemView.timeTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.pluginsdk.i.i.c(((View)localObject2).getContext(), locala.field_updateTime, true)));
      localObject1 = (TextView)((View)localObject2).findViewById(2131308219);
      p.g(localObject1, "itemView.tipNomalTv");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (TextView)((View)localObject2).findViewById(2131308218);
      p.g(localObject1, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 0) {
        break label708;
      }
      i = 0;
      label411:
      ((TextView)localObject1).setVisibility(i);
      localTextView = (TextView)((View)localObject2).findViewById(2131308218);
      p.g(localTextView, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 99) {
        break label714;
      }
    }
    label708:
    label714:
    for (localObject1 = (CharSequence)"...";; localObject1 = (CharSequence)String.valueOf(locala.field_unReadCount))
    {
      localTextView.setText((CharSequence)localObject1);
      ((TextView)((View)localObject2).findViewById(2131308218)).setBackgroundResource(u.aP(((View)localObject2).getContext(), locala.field_unReadCount));
      if (!locala.ddy()) {
        break label730;
      }
      localObject1 = paramb.auu;
      ((ImageView)((View)localObject1).findViewById(2131296998)).setImageResource(2131235005);
      localObject2 = (TextView)((View)localObject1).findViewById(2131308075);
      p.g(localObject2, "conversationName");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cb.a.az(((View)localObject1).getContext(), 2131766896));
      ((View)localObject1).setOnClickListener((View.OnClickListener)new a((View)localObject1, this, locala, paramInt, paramb));
      ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new b((View)localObject1, this, locala, paramInt, paramb));
      AppMethodBeat.o(212225);
      return;
      localObject1 = null;
      break;
      label617:
      i = 0;
      break label265;
      label622:
      localObject3 = new SpannableStringBuilder((CharSequence)locala.field_digestPrefix);
      ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(com.tencent.mm.cb.a.n((Context)localObject1, 2131099803)), 0, ((SpannableStringBuilder)localObject3).length(), 33);
      ((SpannableStringBuilder)localObject3).append((CharSequence)" ").append((CharSequence)k.c((Context)localObject1, (CharSequence)locala.field_digest));
      localObject1 = (CharSequence)localObject3;
      break label299;
      i = 8;
      break label411;
    }
    label730:
    ((View)localObject2).setOnClickListener((View.OnClickListener)new c((View)localObject2, this, locala, paramInt, paramb));
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)new d((View)localObject2, this, locala, paramInt, paramb));
    paramb = (TextView)((View)localObject2).findViewById(2131308075);
    p.g(paramb, "conversationName");
    paramb.setText(locala.rTA);
    com.tencent.mm.ui.f.a.a.c((ImageView)((View)localObject2).findViewById(2131296998), locala.field_sessionId);
    AppMethodBeat.o(212225);
  }
  
  public final b.b t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(212224);
    p.h(paramViewGroup, "parent");
    paramViewGroup = z.jV(paramViewGroup.getContext()).inflate(2131496407, paramViewGroup, false);
    p.g(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    paramViewGroup = new b.b(paramViewGroup);
    AppMethodBeat.o(212224);
    return paramViewGroup;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212220);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      d.a(jdField_this, locala, 7L, paramInt);
      ((c)g.ab(c.class)).fp(this.scH.getContext());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212220);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$2"})
  static final class b
    implements View.OnLongClickListener
  {
    b(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(212221);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.fUY();
      localObject = jdField_this.uKl;
      if (localObject != null)
      {
        View localView = this.scH;
        p.g(localView, "this");
        int i = paramInt;
        p.g(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.uKV.ddD());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(212221);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$1"})
  static final class c
    implements View.OnClickListener
  {
    c(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212222);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      d.a(jdField_this, locala, 2L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.fUY();
      localObject = jdField_this.uKk;
      if (localObject != null)
      {
        View localView = this.scH;
        p.g(paramView, "conversation");
        ((b.c)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212222);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$2"})
  static final class d
    implements View.OnLongClickListener
  {
    d(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(212223);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.fUY();
      localObject = jdField_this.uKl;
      if (localObject != null)
      {
        View localView = this.scH;
        int i = paramInt;
        p.g(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.uKV.ddD());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(212223);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.d
 * JD-Core Version:    0.7.0.1
 */