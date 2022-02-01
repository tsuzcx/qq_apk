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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.d.e;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.tools.w;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "bindHistoryConversation", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "item", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "reportConversationItem", "actionType", "", "plugin-gamelife_release"})
public final class d
  extends f
{
  b.c Dik;
  b.d Dil;
  
  public d(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(204027);
    AppMethodBeat.o(204027);
  }
  
  public final b.b E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204025);
    p.k(paramViewGroup, "parent");
    paramViewGroup = ad.kS(paramViewGroup.getContext()).inflate(com.tencent.mm.plugin.gamelife.d.d.Dgg, paramViewGroup, false);
    p.j(paramViewGroup, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
    paramViewGroup = new b.b(paramViewGroup);
    AppMethodBeat.o(204025);
    return paramViewGroup;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final b.b paramb, final int paramInt)
  {
    AppMethodBeat.i(204026);
    p.k(paramb, "holder");
    Object localObject2 = paramb.amk;
    p.j(localObject2, "holder.itemView");
    final com.tencent.mm.plugin.gamelife.e.a locala = this.DiT.TY(paramInt);
    paramb.ez(locala);
    ((View)localObject2).setBackgroundResource(com.tencent.mm.plugin.gamelife.d.b.comm_list_item_selector);
    ((TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.descTv)).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((n)localObject1).eSe().aOH(locala.field_sessionId);
    Object localObject3;
    if ((localObject1 != null) && (((ca)localObject1).getStatus() == 5))
    {
      localObject1 = ((View)localObject2).getContext();
      p.j(localObject1, "itemView.context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(d.e.msg_state_failed);
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        ((TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.descTv)).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
      }
    }
    else
    {
      TextView localTextView = (TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.descTv);
      p.j(localTextView, "itemView.descTv");
      localObject1 = MMApplicationContext.getContext();
      if ((locala.field_digestFlag & 1L) > 0L)
      {
        locala.field_digestPrefix = com.tencent.mm.ci.a.ba((Context)localObject1, d.f.Dgy);
        locala.field_digestFlag = 0L;
      }
      localObject3 = (CharSequence)locala.field_digestPrefix;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label701;
      }
      i = 1;
      label272:
      if (i == 0) {
        break label706;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)locala.field_digest);
      p.j(localObject1, "MMSpanManager.spanForSmiley(context, field_digest)");
      localObject1 = (CharSequence)localObject1;
      label306:
      localTextView.setText((CharSequence)localObject1);
      localObject1 = (TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.timeTv);
      p.j(localObject1, "itemView.timeTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.pluginsdk.j.f.d(((View)localObject2).getContext(), locala.field_updateTime, true)));
      localObject1 = (TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.tipNomalTv);
      p.j(localObject1, "itemView.tipNomalTv");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.tipCountTv);
      p.j(localObject1, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 0) {
        break label792;
      }
      i = 0;
      label418:
      ((TextView)localObject1).setVisibility(i);
      localTextView = (TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.tipCountTv);
      p.j(localTextView, "itemView.tipCountTv");
      if (locala.field_unReadCount <= 99) {
        break label798;
      }
      localObject1 = (CharSequence)"...";
      label463:
      localTextView.setText((CharSequence)localObject1);
      ((TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.tipCountTv)).setBackgroundResource(w.bj(((View)localObject2).getContext(), locala.field_unReadCount));
      if (!locala.eAs()) {
        break label819;
      }
      localObject1 = paramb.amk;
      localObject2 = (TextView)((View)localObject1).findViewById(com.tencent.mm.plugin.gamelife.d.c.tipCountTv);
      p.j(localObject2, "tipCountTv");
      ((TextView)localObject2).setVisibility(8);
      localObject2 = (TextView)((View)localObject1).findViewById(com.tencent.mm.plugin.gamelife.d.c.tipNomalTv);
      p.j(localObject2, "tipNomalTv");
      if ((locala.field_unReadCount != 2147483647) && (locala.field_unReadCount != 0)) {
        break label814;
      }
    }
    label792:
    label798:
    label814:
    for (int i = 8;; i = 0)
    {
      ((TextView)localObject2).setVisibility(i);
      ((ImageView)((View)localObject1).findViewById(com.tencent.mm.plugin.gamelife.d.c.avatarIv)).setImageResource(com.tencent.mm.plugin.gamelife.d.b.DfD);
      localObject2 = (TextView)((View)localObject1).findViewById(com.tencent.mm.plugin.gamelife.d.c.conversationName);
      p.j(localObject2, "conversationName");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.ci.a.ba(((View)localObject1).getContext(), d.f.DgA));
      ((View)localObject1).setOnClickListener((View.OnClickListener)new a((View)localObject1, this, locala, paramInt, paramb));
      ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new b((View)localObject1, this, locala, paramInt, paramb));
      AppMethodBeat.o(204026);
      return;
      localObject1 = null;
      break;
      label701:
      i = 0;
      break label272;
      label706:
      localObject3 = new SpannableStringBuilder((CharSequence)locala.field_digestPrefix);
      ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(com.tencent.mm.ci.a.w((Context)localObject1, com.tencent.mm.plugin.gamelife.d.a.Red)), 0, ((SpannableStringBuilder)localObject3).length(), 33);
      ((SpannableStringBuilder)localObject3).append((CharSequence)" ").append((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)locala.field_digest));
      localObject1 = (CharSequence)localObject3;
      break label306;
      i = 8;
      break label418;
      localObject1 = (CharSequence)String.valueOf(locala.field_unReadCount);
      break label463;
    }
    label819:
    ((View)localObject2).setOnClickListener((View.OnClickListener)new c((View)localObject2, this, locala, paramInt, paramb));
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)new d((View)localObject2, this, locala, paramInt, paramb));
    paramb = (TextView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.conversationName);
    p.j(paramb, "conversationName");
    paramb.setText(locala.xgc);
    com.tencent.mm.ui.h.a.a.c((ImageView)((View)localObject2).findViewById(com.tencent.mm.plugin.gamelife.d.c.avatarIv), locala.field_sessionId);
    AppMethodBeat.o(204026);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204098);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (locala.field_unReadCount != 2147483647)
      {
        locala.field_unReadCount = 2147483647;
        ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().update(locala.systemRowid, (IAutoDBItem)locala, false);
        ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage().doNotify("single", 4, locala);
      }
      d.a(jdField_this, locala, 7L, paramInt);
      ((c)h.ae(c.class)).go(this.xkv.getContext());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204098);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$2"})
  static final class b
    implements View.OnLongClickListener
  {
    b(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(202694);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.ihX();
      localObject = jdField_this.Dil;
      if (localObject != null)
      {
        View localView = this.xkv;
        p.j(localView, "this");
        int i = paramInt;
        p.j(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.DiT.eAx());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(202694);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$1"})
  static final class c
    implements View.OnClickListener
  {
    c(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203907);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      d.a(jdField_this, locala, 2L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.ihX();
      localObject = jdField_this.Dik;
      if (localObject != null)
      {
        View localView = this.xkv;
        p.j(paramView, "conversation");
        ((b.c)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203907);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$2"})
  static final class d
    implements View.OnLongClickListener
  {
    d(View paramView, d paramd, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt, b.b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(204254);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
      d.a(jdField_this, locala, 72L, paramInt);
      paramView = (com.tencent.mm.plugin.gamelife.e.a)paramb.ihX();
      localObject = jdField_this.Dil;
      if (localObject != null)
      {
        View localView = this.xkv;
        int i = paramInt;
        p.j(paramView, "conversation");
        ((b.d)localObject).a(localView, i, paramView, jdField_this.DiT.eAx());
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(204254);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.d
 * JD-Core Version:    0.7.0.1
 */