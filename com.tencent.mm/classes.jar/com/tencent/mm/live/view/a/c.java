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
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", "", "comment", "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-logic_release"})
public final class c
  extends RecyclerView.a<a>
{
  public final ArrayList<a> gIn;
  private final b gIo;
  
  public c()
  {
    AppMethodBeat.i(190774);
    this.gIn = new ArrayList();
    this.gIo = new b();
    AppMethodBeat.o(190774);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(190770);
    k.h(parama, "comment");
    int i = this.gIn.size();
    this.gIn.add(parama);
    ck(i);
    AppMethodBeat.o(190770);
  }
  
  public final void aa(List<a> paramList)
  {
    AppMethodBeat.i(190769);
    k.h(paramList, "commentList");
    this.gIn.clear();
    this.gIn.addAll((Collection)paramList);
    AppMethodBeat.o(190769);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(190772);
    int i = this.gIn.size();
    AppMethodBeat.o(190772);
    return i;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView gIj;
    final ViewGroup gIp;
    final TextView gIq;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(190767);
      View localView = paramView.findViewById(2131307599);
      k.g(localView, "itemView.findViewById(R.…omment_item_avatar_group)");
      this.gIp = ((ViewGroup)localView);
      localView = paramView.findViewById(2131307600);
      k.g(localView, "itemView.findViewById(R.…comment_item_avatar_icon)");
      this.gIj = ((ImageView)localView);
      paramView = paramView.findViewById(2131307601);
      k.g(paramView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.gIq = ((TextView)paramView);
      AppMethodBeat.o(190767);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"})
  public static final class b
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(190768);
      Context localContext = ai.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      int i = localContext.getResources().getColor(2131100483);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null)
      {
        paramTextPaint.setUnderlineText(false);
        AppMethodBeat.o(190768);
        return;
      }
      AppMethodBeat.o(190768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c
 * JD-Core Version:    0.7.0.1
 */