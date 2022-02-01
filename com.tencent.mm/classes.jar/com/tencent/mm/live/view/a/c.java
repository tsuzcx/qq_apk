package com.tencent.mm.live.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "onItemCLickListener", "Lkotlin/Function1;", "", "", "getOnItemCLickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemCLickListener", "(Lkotlin/jvm/functions/Function1;)V", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", "comment", "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-logic_release"})
public final class c
  extends RecyclerView.a<a>
{
  public final ArrayList<a> kMd;
  private final c kMe;
  kotlin.g.a.b<? super String, x> kMf;
  
  public c()
  {
    AppMethodBeat.i(192966);
    this.kMd = new ArrayList();
    this.kMe = new c();
    AppMethodBeat.o(192966);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(192933);
    p.k(parama, "comment");
    int i = this.kMd.size();
    this.kMd.add(parama);
    cM(i);
    AppMethodBeat.o(192933);
  }
  
  public final void ah(List<a> paramList)
  {
    AppMethodBeat.i(192928);
    p.k(paramList, "commentList");
    this.kMd.clear();
    this.kMd.addAll((Collection)paramList);
    AppMethodBeat.o(192928);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192944);
    int i = this.kMd.size();
    AppMethodBeat.o(192944);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView kLZ;
    final ViewGroup kMg;
    final TextView kMh;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(195404);
      View localView = paramView.findViewById(b.e.live_comment_item_avatar_group);
      p.j(localView, "itemView.findViewById(R.…omment_item_avatar_group)");
      this.kMg = ((ViewGroup)localView);
      localView = paramView.findViewById(b.e.live_comment_item_avatar_icon);
      p.j(localView, "itemView.findViewById(R.…comment_item_avatar_icon)");
      this.kLZ = ((ImageView)localView);
      paramView = paramView.findViewById(b.e.live_comment_item_content_tv);
      p.j(paramView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.kMh = ((TextView)paramView);
      AppMethodBeat.o(195404);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197604);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/adapter/LiveCommentAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.kMi.kMf;
      if (paramView != null) {
        paramView.invoke(((a)this.kMi.kMd.get(this.jEN)).kLV);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveCommentAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(197604);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"})
  public static final class c
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(190151);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      int i = localContext.getResources().getColor(b.b.half_alpha_white);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null)
      {
        paramTextPaint.setUnderlineText(false);
        AppMethodBeat.o(190151);
        return;
      }
      AppMethodBeat.o(190151);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c
 * JD-Core Version:    0.7.0.1
 */