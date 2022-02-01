package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.game.report.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.d.a;
import com.tencent.mm.plugin.gamelife.d.b;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.plugin.gamelife.d.e;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.plugin.gamelife.f.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "bindHistoryConversation", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "item", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "reportConversationItem", "actionType", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f
{
  b.c Jcb;
  b.d Jcc;
  
  public d(f.a parama)
  {
    super(parama);
    AppMethodBeat.i(267902);
    AppMethodBeat.o(267902);
  }
  
  private final void a(com.tencent.mm.plugin.gamelife.f.a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(267917);
    String str = null;
    if (paramLong == 72L) {
      str = "2";
    }
    Object localObject1;
    int i;
    long l1;
    if (!parama.fIs())
    {
      Object localObject2 = ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(parama.field_selfUserName);
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.game.report.c.mtx;
        i = fIE().fIy();
        localObject1 = parama.field_sessionId;
        s.s(localObject1, "item.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject2).fIh();
        localObject2 = parama.field_selfUserName;
        s.s(localObject2, "item.field_selfUserName");
        Object localObject3 = parama.Jbs;
        s.checkNotNull(localObject3);
        long l2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject3).field_accountType;
        localObject3 = parama.field_talker;
        s.s(localObject3, "item.field_talker");
        long l3 = parama.fIr();
        parama = com.tencent.mm.plugin.gamelife.j.a.JbN;
        c.a.a(paramInt - 2 + 1, paramLong, i, (String)localObject1, l1, (String)localObject2, l2, (String)localObject3, l3, com.tencent.mm.plugin.gamelife.j.a.fIw(), str);
        AppMethodBeat.o(267917);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.game.report.c.mtx;
      i = fIE().fIy();
      localObject1 = parama.field_sessionId;
      s.s(localObject1, "item.field_sessionId");
      l1 = parama.fIr();
      parama = com.tencent.mm.plugin.gamelife.j.a.JbN;
      c.a.a(paramInt - 2 + 1, paramLong, i, (String)localObject1, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.j.a.fIw(), str);
    }
    AppMethodBeat.o(267917);
  }
  
  private static final void a(com.tencent.mm.plugin.gamelife.f.a parama, d paramd, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(267953);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$item");
    s.u(paramd, "this$0");
    s.u(paramView1, "$this_apply");
    if (parama.field_unReadCount != 2147483647)
    {
      parama.field_unReadCount = 2147483647;
      ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().update(parama.systemRowid, (IAutoDBItem)parama, false);
      ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage().doNotify("single", 4, parama);
    }
    paramd.a(parama, 7L, paramInt);
    ((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).hH(paramView1.getContext());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267953);
  }
  
  private static final void a(d paramd, com.tencent.mm.plugin.gamelife.f.a parama, int paramInt, b.b paramb, View paramView1, View paramView2)
  {
    AppMethodBeat.i(267930);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramb);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(parama, "$item");
    s.u(paramb, "$holder");
    s.u(paramView1, "$this_apply");
    paramd.a(parama, 2L, paramInt);
    parama = (com.tencent.mm.plugin.gamelife.f.a)paramb.CSA;
    paramd = paramd.Jcb;
    if (paramd != null)
    {
      s.s(parama, "conversation");
      paramd.a(paramView1, parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267930);
  }
  
  private static final boolean b(d paramd, com.tencent.mm.plugin.gamelife.f.a parama, int paramInt, b.b paramb, View paramView1, View paramView2)
  {
    AppMethodBeat.i(267941);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramb);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(parama, "$item");
    s.u(paramb, "$holder");
    s.u(paramView1, "$this_apply");
    paramd.a(parama, 72L, paramInt);
    parama = (com.tencent.mm.plugin.gamelife.f.a)paramb.CSA;
    paramb = paramd.Jcc;
    if (paramb != null)
    {
      s.s(parama, "conversation");
      paramb.a(paramView1, paramInt, parama, paramd.fIE().fIy());
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(267941);
    return true;
  }
  
  private static final boolean c(d paramd, com.tencent.mm.plugin.gamelife.f.a parama, int paramInt, b.b paramb, View paramView1, View paramView2)
  {
    AppMethodBeat.i(267992);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramb);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(parama, "$item");
    s.u(paramb, "$holder");
    s.u(paramView1, "$this_apply");
    paramd.a(parama, 72L, paramInt);
    parama = (com.tencent.mm.plugin.gamelife.f.a)paramb.CSA;
    paramb = paramd.Jcc;
    if (paramb != null)
    {
      s.s(parama, "conversation");
      paramb.a(paramView1, paramInt, parama, paramd.fIE().fIy());
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(267992);
    return true;
  }
  
  public final b.b O(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(268033);
    s.u(paramViewGroup, "parent");
    paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(d.d.Jab, paramViewGroup, false);
    s.s(paramViewGroup, "getInflater(parent.conte…rmal_item, parent, false)");
    paramViewGroup = new b.b(paramViewGroup);
    AppMethodBeat.o(268033);
    return paramViewGroup;
  }
  
  public final void a(b.b paramb, int paramInt)
  {
    AppMethodBeat.i(268056);
    s.u(paramb, "holder");
    Object localObject2 = paramb.caK;
    s.s(localObject2, "holder.itemView");
    com.tencent.mm.plugin.gamelife.f.a locala = fIE().XT(paramInt);
    paramb.CSA = locala;
    ((View)localObject2).setBackgroundResource(d.b.comm_list_item_selector);
    ((TextView)((View)localObject2).findViewById(d.c.descTv)).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    Object localObject1 = ((n)h.ax(n.class)).gaZ().aLG(locala.field_sessionId);
    Object localObject3;
    if ((localObject1 != null) && (((fi)localObject1).field_status == 5))
    {
      localObject1 = ((View)localObject2).getContext().getResources().getDrawable(d.e.msg_state_failed);
      if (localObject1 == null)
      {
        localObject1 = null;
        ((TextView)((View)localObject2).findViewById(d.c.descTv)).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
      }
    }
    else
    {
      TextView localTextView = (TextView)((View)localObject2).findViewById(d.c.descTv);
      localObject1 = MMApplicationContext.getContext();
      if ((locala.field_digestFlag & 1L) > 0L)
      {
        locala.field_digestPrefix = com.tencent.mm.cd.a.bt((Context)localObject1, d.f.Jas);
        locala.field_digestFlag = 0L;
      }
      localObject3 = (CharSequence)locala.field_digestPrefix;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label594;
      }
      i = 1;
      label230:
      if (i == 0) {
        break label599;
      }
      localObject1 = p.b((Context)localObject1, (CharSequence)locala.field_digest);
      s.s(localObject1, "spanForSmiley(context, field_digest)");
      localObject1 = (CharSequence)localObject1;
      label264:
      localTextView.setText((CharSequence)localObject1);
      ((TextView)((View)localObject2).findViewById(d.c.timeTv)).setText((CharSequence)String.valueOf(com.tencent.mm.pluginsdk.platformtools.f.d(((View)localObject2).getContext(), locala.field_updateTime, true)));
      ((TextView)((View)localObject2).findViewById(d.c.tipNomalTv)).setVisibility(8);
      localObject1 = (TextView)((View)localObject2).findViewById(d.c.tipCountTv);
      if (locala.field_unReadCount <= 0) {
        break label685;
      }
      i = 0;
      label344:
      ((TextView)localObject1).setVisibility(i);
      localTextView = (TextView)((View)localObject2).findViewById(d.c.tipCountTv);
      if (locala.field_unReadCount <= 99) {
        break label691;
      }
      localObject1 = (CharSequence)"...";
      label381:
      localTextView.setText((CharSequence)localObject1);
      ((TextView)((View)localObject2).findViewById(d.c.tipCountTv)).setBackgroundResource(v.bC(((View)localObject2).getContext(), locala.field_unReadCount));
      if (!locala.fIs()) {
        break label712;
      }
      localObject1 = paramb.caK;
      ((TextView)((View)localObject1).findViewById(d.c.tipCountTv)).setVisibility(8);
      localObject2 = (TextView)((View)localObject1).findViewById(d.c.tipNomalTv);
      if ((locala.field_unReadCount != 2147483647) && (locala.field_unReadCount != 0)) {
        break label707;
      }
    }
    label685:
    label691:
    label707:
    for (int i = 8;; i = 0)
    {
      ((TextView)localObject2).setVisibility(i);
      ((ImageView)((View)localObject1).findViewById(d.c.avatarIv)).setImageResource(d.b.IZy);
      ((TextView)((View)localObject1).findViewById(d.c.conversationName)).setText((CharSequence)com.tencent.mm.cd.a.bt(((View)localObject1).getContext(), d.f.Jau));
      ((View)localObject1).setOnClickListener(new d..ExternalSyntheticLambda0(locala, this, paramInt, (View)localObject1));
      ((View)localObject1).setOnLongClickListener(new d..ExternalSyntheticLambda2(this, locala, paramInt, paramb, (View)localObject1));
      AppMethodBeat.o(268056);
      return;
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      break;
      label594:
      i = 0;
      break label230;
      label599:
      localObject3 = new SpannableStringBuilder((CharSequence)locala.field_digestPrefix);
      ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(com.tencent.mm.cd.a.w((Context)localObject1, d.a.Red)), 0, ((SpannableStringBuilder)localObject3).length(), 33);
      ((SpannableStringBuilder)localObject3).append((CharSequence)" ").append((CharSequence)p.b((Context)localObject1, (CharSequence)locala.field_digest));
      localObject1 = (CharSequence)localObject3;
      break label264;
      i = 8;
      break label344;
      localObject1 = (CharSequence)String.valueOf(locala.field_unReadCount);
      break label381;
    }
    label712:
    ((View)localObject2).setOnClickListener(new d..ExternalSyntheticLambda1(this, locala, paramInt, paramb, (View)localObject2));
    ((View)localObject2).setOnLongClickListener(new d..ExternalSyntheticLambda3(this, locala, paramInt, paramb, (View)localObject2));
    ((TextView)((View)localObject2).findViewById(d.c.conversationName)).setText(locala.AFy);
    com.tencent.mm.ui.i.a.a.g((ImageView)((View)localObject2).findViewById(d.c.avatarIv), locala.field_sessionId);
    AppMethodBeat.o(268056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.d
 * JD-Core Version:    0.7.0.1
 */