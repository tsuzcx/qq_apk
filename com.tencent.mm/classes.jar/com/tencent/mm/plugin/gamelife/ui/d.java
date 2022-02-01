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
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.v;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "bindHistoryConversation", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "item", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "reportConversationItem", "actionType", "", "plugin-gamelife_release"})
public final class d
  extends f
{
  b.c ycF;
  b.d ycG;
  
  public d(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(241469);
    AppMethodBeat.o(241469);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final b.b paramb, final int paramInt)
  {
    AppMethodBeat.i(241468);
    p.h(paramb, "holder");
    Object localObject2 = paramb.aus;
    p.g(localObject2, "holder.itemView");
    final com.tencent.mm.plugin.gamelife.e.a locala = this.ydp.OD(paramInt);
    paramb.et(locala);
    ((View)localObject2).setBackgroundResource(2131231898);
    ((TextView)((View)localObject2).findViewById(2131299497)).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    Object localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).eiy().aEx(locala.field_sessionId);
    Object localObject3;
    if ((localObject1 != null) && (((ca)localObject1).getStatus() == 5))
    {
      localObject1 = ((View)localObject2).getContext();
      p.g(localObject1, "itemView.context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2131691164);
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        ((TextView)((View)localObject2).findViewById(2131299497)).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
      }
    }
    else
    {
      TextView localTextView = (TextView)((View)localObject2).findViewById(2131299497);
      p.g(localTextView, "itemView.descTv");
      localObject1 = MMApplicationContext.getContext();
      if ((locala.field_digestFlag & 1L) > 0L)
      {
        locala.field_digestPrefix = com.tencent.mm.cb.a.aI((Context)localObject1, 2131761379);
        locala.field_digestFlag = 0L;
      }
      localObject3 = (CharSequence)locala.field_digestPrefix;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label694;
      }
      i = 1;
      label265:
      if (i == 0) {
        break label699;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)locala.field_digest);
      p.g(localObject1, "MMSpanManager.spanForSmiley(context, field_digest)");
      localObject1 = (CharSequence)localObject1;
      label299:
      localTextView.setText((CharSequence)localObject1);
      localObject1 = (TextView)((View)localObject2).findViewById(2131309090);
      p.g(localObject1, "itemView.timeTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.pluginsdk.i.f.c(((View)localObject2).getContext(), locala.field_updateTime, true)));
      localObject1 = (TextView)((View)localObject2).findViewById(2131309143);
      p.g(localObject1, "itemView.tipNomalTv");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (TextView)((View)localObject2).findViewById(2131309142);
      p.g(localObject1, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 0) {
        break label785;
      }
      i = 0;
      label411:
      ((TextView)localObject1).setVisibility(i);
      localTextView = (TextView)((View)localObject2).findViewById(2131309142);
      p.g(localTextView, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 99) {
        break label791;
      }
      localObject1 = (CharSequence)"...";
      label456:
      localTextView.setText((CharSequence)localObject1);
      ((TextView)((View)localObject2).findViewById(2131309142)).setBackgroundResource(v.aQ(((View)localObject2).getContext(), locala.field_unReadCount));
      if (!locala.dXj()) {
        break label812;
      }
      localObject1 = paramb.aus;
      localObject2 = (TextView)((View)localObject1).findViewById(2131309142);
      p.g(localObject2, "tipCountTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (TextView)((View)localObject1).findViewById(2131309143);
      p.g(localObject2, "tipNomalTv");
      if ((locala.field_unReadCount != 2147483647) && (locala.field_unReadCount != 0)) {
        break label807;
      }
    }
    label785:
    label791:
    label807:
    for (int i = 8;; i = 0)
    {
      ((TextView)localObject2).setVisibility(i);
      ((ImageView)((View)localObject1).findViewById(2131297121)).setImageResource(2131232982);
      localObject2 = (TextView)((View)localObject1).findViewById(2131299242);
      p.g(localObject2, "conversationName");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.cb.a.aI(((View)localObject1).getContext(), 2131761383));
      ((View)localObject1).setOnClickListener((View.OnClickListener)new a((View)localObject1, this, locala, paramInt, paramb));
      ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new b((View)localObject1, this, locala, paramInt, paramb));
      AppMethodBeat.o(241468);
      return;
      localObject1 = null;
      break;
      label694:
      i = 0;
      break label265;
      label699:
      localObject3 = new SpannableStringBuilder((CharSequence)locala.field_digestPrefix);
      ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(com.tencent.mm.cb.a.n((Context)localObject1, 2131099818)), 0, ((SpannableStringBuilder)localObject3).length(), 33);
      ((SpannableStringBuilder)localObject3).append((CharSequence)" ").append((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)locala.field_digest));
      localObject1 = (CharSequence)localObject3;
      break label299;
      i = 8;
      break label411;
      localObject1 = (CharSequence)String.valueOf(locala.field_unReadCount);
      break label456;
    }
    label812:
    ((View)localObject2).setOnClickListener((View.OnClickListener)new c((View)localObject2, this, locala, paramInt, paramb));
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)new d((View)localObject2, this, locala, paramInt, paramb));
    paramb = (TextView)((View)localObject2).findViewById(2131299242);
    p.g(paramb, "conversationName");
    paramb.setText(locala.tyr);
    com.tencent.mm.ui.g.a.a.c((ImageView)((View)localObject2).findViewById(2131297121), locala.field_sessionId);
    AppMethodBeat.o(241468);
  }
  
  public final b.b y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(241467);
    p.h(paramViewGroup, "parent");
    paramViewGroup = aa.jQ(paramViewGroup.getContext()).inflate(2131494976, paramViewGroup, false);
    p.g(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    paramViewGroup = new b.b(paramViewGroup);
    AppMethodBeat.o(241467);
    return paramViewGroup;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241463);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (locala.field_unReadCount != 2147483647)
      {
        locala.field_unReadCount = 2147483647;
        ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().update(locala.systemRowid, (IAutoDBItem)locala, false);
        ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage().doNotify("single", 4, locala);
      }
      d.a(jdField_this, locala, 7L, paramInt);
      ((c)g.af(c.class)).fV(this.tCl.getContext());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241463);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$2"})
  static final class b
    implements View.OnLongClickListener
  {
    b(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(241464);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.hgv();
      localObject = jdField_this.ycG;
      if (localObject != null)
      {
        View localView = this.tCl;
        p.g(localView, "this");
        int i = paramInt;
        p.g(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.ydp.dXo());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(241464);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$1"})
  static final class c
    implements View.OnClickListener
  {
    c(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241465);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      d.a(jdField_this, locala, 2L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.hgv();
      localObject = jdField_this.ycF;
      if (localObject != null)
      {
        View localView = this.tCl;
        p.g(paramView, "conversation");
        ((b.c)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241465);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$2"})
  static final class d
    implements View.OnLongClickListener
  {
    d(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(241466);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.hgv();
      localObject = jdField_this.ycG;
      if (localObject != null)
      {
        View localView = this.tCl;
        int i = paramInt;
        p.g(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.ydp.dXo());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(241466);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.d
 * JD-Core Version:    0.7.0.1
 */