package com.tencent.mm.live.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "onItemCLickListener", "Lkotlin/Function1;", "", "", "getOnItemCLickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemCLickListener", "(Lkotlin/jvm/functions/Function1;)V", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", "comment", "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.a<a>
{
  public final ArrayList<a> nnY;
  private final b nnZ;
  private kotlin.g.a.b<? super String, ah> noa;
  
  public c()
  {
    AppMethodBeat.i(246205);
    this.nnY = new ArrayList();
    this.nnZ = new b();
    AppMethodBeat.o(246205);
  }
  
  private static final void a(c paramc, int paramInt, View paramView)
  {
    AppMethodBeat.i(246218);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/adapter/LiveCommentAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramView = paramc.noa;
    if (paramView != null) {
      paramView.invoke(((a)paramc.nnY.get(paramInt)).nnR);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/view/adapter/LiveCommentAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246218);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(246240);
    s.u(parama, "comment");
    int i = this.nnY.size();
    this.nnY.add(parama);
    fW(i);
    AppMethodBeat.o(246240);
  }
  
  public final void bI(List<a> paramList)
  {
    AppMethodBeat.i(246233);
    s.u(paramList, "commentList");
    this.nnY.clear();
    this.nnY.addAll((Collection)paramList);
    AppMethodBeat.o(246233);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(246247);
    int i = this.nnY.size();
    AppMethodBeat.o(246247);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView nnV;
    final ViewGroup nob;
    final TextView noc;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(246190);
      View localView = paramView.findViewById(b.e.live_comment_item_avatar_group);
      s.s(localView, "itemView.findViewById(R.…omment_item_avatar_group)");
      this.nob = ((ViewGroup)localView);
      localView = paramView.findViewById(b.e.live_comment_item_avatar_icon);
      s.s(localView, "itemView.findViewById(R.…comment_item_avatar_icon)");
      this.nnV = ((ImageView)localView);
      paramView = paramView.findViewById(b.e.live_comment_item_content_tv);
      s.s(paramView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.noc = ((TextView)paramView);
      AppMethodBeat.o(246190);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(246193);
      int i = MMApplicationContext.getContext().getResources().getColor(b.b.half_alpha_white);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null) {
        paramTextPaint.setUnderlineText(false);
      }
      AppMethodBeat.o(246193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c
 * JD-Core Version:    0.7.0.1
 */