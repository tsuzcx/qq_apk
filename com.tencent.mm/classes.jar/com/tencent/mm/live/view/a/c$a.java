package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
public final class c$a
  extends RecyclerView.w
{
  final ImageView heH;
  final ViewGroup heN;
  final TextView heO;
  
  public c$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(216688);
    View localView = paramView.findViewById(2131307599);
    p.g(localView, "itemView.findViewById(R.…omment_item_avatar_group)");
    this.heN = ((ViewGroup)localView);
    localView = paramView.findViewById(2131307600);
    p.g(localView, "itemView.findViewById(R.…comment_item_avatar_icon)");
    this.heH = ((ImageView)localView);
    paramView = paramView.findViewById(2131307601);
    p.g(paramView, "itemView.findViewById(R.…_comment_item_content_tv)");
    this.heO = ((TextView)paramView);
    AppMethodBeat.o(216688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c.a
 * JD-Core Version:    0.7.0.1
 */