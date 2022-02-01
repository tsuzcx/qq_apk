package com.tencent.mm.live.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", "", "comment", "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-logic_release"})
public final class c
  extends RecyclerView.a<a>
{
  public final ArrayList<a> BvI;
  private final c KBw;
  
  public c()
  {
    AppMethodBeat.i(203536);
    this.BvI = new ArrayList();
    this.KBw = new c();
    AppMethodBeat.o(203536);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(203532);
    k.h(parama, "comment");
    int i = this.BvI.size();
    this.BvI.add(parama);
    cl(i);
    AppMethodBeat.o(203532);
  }
  
  public final void fY(List<a> paramList)
  {
    AppMethodBeat.i(203531);
    k.h(paramList, "commentList");
    this.BvI.clear();
    this.BvI.addAll((Collection)paramList);
    AppMethodBeat.o(203531);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(203534);
    int i = this.BvI.size();
    AppMethodBeat.o(203534);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView KBu;
    final ViewGroup KBx;
    final TextView izX;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(203527);
      View localView = paramView.findViewById(2131307518);
      k.g(localView, "itemView.findViewById(R.…omment_item_avatar_group)");
      this.KBx = ((ViewGroup)localView);
      localView = paramView.findViewById(2131307519);
      k.g(localView, "itemView.findViewById(R.…comment_item_avatar_icon)");
      this.KBu = ((ImageView)localView);
      paramView = paramView.findViewById(2131307520);
      k.g(paramView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.izX = ((TextView)paramView);
      AppMethodBeat.o(203527);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveHeightSpan;", "Landroid/text/style/ImageSpan;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "getSize", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "plugin-logic_release"})
  public static final class b
    extends ImageSpan
  {
    private Context context;
    
    public b(Context paramContext)
    {
      super(2131234906);
      AppMethodBeat.i(203529);
      this.context = paramContext;
      AppMethodBeat.o(203529);
    }
    
    public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      AppMethodBeat.i(203528);
      k.h(paramPaint, "paint");
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.bottom - paramPaint.top;
      int i = com.tencent.mm.cd.a.ao(this.context, 2131165292);
      paramInt1 = i / 2 - paramInt2 / 4;
      i /= 2;
      paramInt2 = paramInt2 / 4 + i;
      if (paramFontMetricsInt != null) {
        paramFontMetricsInt.ascent = (-paramInt2);
      }
      if (paramFontMetricsInt != null) {
        paramFontMetricsInt.top = (-paramInt2);
      }
      if (paramFontMetricsInt != null) {
        paramFontMetricsInt.bottom = paramInt1;
      }
      if (paramFontMetricsInt != null) {
        paramFontMetricsInt.descent = paramInt1;
      }
      AppMethodBeat.o(203528);
      return 1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"})
  public static final class c
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(203530);
      Context localContext = aj.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      int i = localContext.getResources().getColor(2131100483);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null)
      {
        paramTextPaint.setUnderlineText(false);
        AppMethodBeat.o(203530);
        return;
      }
      AppMethodBeat.o(203530);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c
 * JD-Core Version:    0.7.0.1
 */