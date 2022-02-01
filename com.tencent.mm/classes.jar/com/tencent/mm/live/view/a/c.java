package com.tencent.mm.live.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", "", "comment", "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-logic_release"})
public final class c
  extends RecyclerView.a<a>
{
  public final ArrayList<a> hbX;
  private final b hbY;
  
  public c()
  {
    AppMethodBeat.i(213065);
    this.hbX = new ArrayList();
    this.hbY = new b();
    AppMethodBeat.o(213065);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(213061);
    p.h(parama, "comment");
    int i = this.hbX.size();
    this.hbX.add(parama);
    ck(i);
    AppMethodBeat.o(213061);
  }
  
  public final void ab(List<a> paramList)
  {
    AppMethodBeat.i(213060);
    p.h(paramList, "commentList");
    this.hbX.clear();
    this.hbX.addAll((Collection)paramList);
    AppMethodBeat.o(213060);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(213063);
    int i = this.hbX.size();
    AppMethodBeat.o(213063);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView hbT;
    final ViewGroup hbZ;
    final TextView hca;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(213058);
      View localView = paramView.findViewById(2131307599);
      p.g(localView, "itemView.findViewById(R.…omment_item_avatar_group)");
      this.hbZ = ((ViewGroup)localView);
      localView = paramView.findViewById(2131307600);
      p.g(localView, "itemView.findViewById(R.…comment_item_avatar_icon)");
      this.hbT = ((ImageView)localView);
      paramView = paramView.findViewById(2131307601);
      p.g(paramView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.hca = ((TextView)paramView);
      AppMethodBeat.o(213058);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"})
  public static final class b
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(213059);
      Context localContext = aj.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      int i = localContext.getResources().getColor(2131100483);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null)
      {
        paramTextPaint.setUnderlineText(false);
        AppMethodBeat.o(213059);
        return;
      }
      AppMethodBeat.o(213059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c
 * JD-Core Version:    0.7.0.1
 */