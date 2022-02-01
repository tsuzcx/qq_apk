package com.tencent.mm.live.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "onItemCLickListener", "Lkotlin/Function1;", "", "", "getOnItemCLickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemCLickListener", "(Lkotlin/jvm/functions/Function1;)V", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", "comment", "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-logic_release"})
public final class c
  extends RecyclerView.a<a>
{
  kotlin.g.a.b<? super String, x> hXA;
  public final ArrayList<a> hXy;
  private final c hXz;
  
  public c()
  {
    AppMethodBeat.i(208669);
    this.hXy = new ArrayList();
    this.hXz = new c();
    AppMethodBeat.o(208669);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(208665);
    p.h(parama, "comment");
    int i = this.hXy.size();
    this.hXy.add(parama);
    cj(i);
    AppMethodBeat.o(208665);
  }
  
  public final void aj(List<a> paramList)
  {
    AppMethodBeat.i(208664);
    p.h(paramList, "commentList");
    this.hXy.clear();
    this.hXy.addAll((Collection)paramList);
    AppMethodBeat.o(208664);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(208667);
    int i = this.hXy.size();
    AppMethodBeat.o(208667);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ViewGroup hXB;
    final TextView hXC;
    final ImageView hXu;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(208661);
      View localView = paramView.findViewById(2131303361);
      p.g(localView, "itemView.findViewById(R.…omment_item_avatar_group)");
      this.hXB = ((ViewGroup)localView);
      localView = paramView.findViewById(2131303362);
      p.g(localView, "itemView.findViewById(R.…comment_item_avatar_icon)");
      this.hXu = ((ImageView)localView);
      paramView = paramView.findViewById(2131303363);
      p.g(paramView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.hXC = ((TextView)paramView);
      AppMethodBeat.o(208661);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208662);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/adapter/LiveCommentAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.hXD.hXA;
      if (paramView != null) {
        paramView.invoke(((a)this.hXD.hXy.get(this.gUj)).hXp);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveCommentAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208662);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"})
  public static final class c
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(208663);
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      int i = localContext.getResources().getColor(2131100585);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null)
      {
        paramTextPaint.setUnderlineText(false);
        AppMethodBeat.o(208663);
        return;
      }
      AppMethodBeat.o(208663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c
 * JD-Core Version:    0.7.0.1
 */