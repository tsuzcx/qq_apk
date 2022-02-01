package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderWordingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "removeItemListener", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "getRemoveItemListener", "()Lkotlin/jvm/functions/Function1;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "extendTouch", "Landroid/view/View;", "size", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cy
  extends f<n>
{
  private final kotlin.g.a.b<n, ah> AMZ;
  
  public cy(kotlin.g.a.b<? super n, ah> paramb)
  {
    AppMethodBeat.i(349795);
    this.AMZ = paramb;
    AppMethodBeat.o(349795);
  }
  
  private static final void a(View paramView1, int paramInt, View paramView2)
  {
    AppMethodBeat.i(349807);
    s.u(paramView1, "$this_extendTouch");
    s.u(paramView2, "$parent");
    Rect localRect = new Rect();
    paramView1.getHitRect(localRect);
    localRect.left -= paramInt;
    localRect.top -= paramInt;
    localRect.right += paramInt;
    localRect.bottom += paramInt;
    paramView2.setTouchDelegate(new TouchDelegate(localRect, paramView1));
    AppMethodBeat.o(349807);
  }
  
  private static final void a(cy paramcy, n paramn, View paramView)
  {
    AppMethodBeat.i(349814);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcy);
    localb.cH(paramn);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderWordingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcy, "this$0");
    s.u(paramn, "$item");
    paramcy.AMZ.invoke(paramn);
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderWordingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349814);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349851);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramj.caK.setEnabled(true);
    paramRecyclerView = (TextView)paramj.UH(e.e.finder_wording_content);
    if (paramRecyclerView != null) {
      paramRecyclerView.setTextSize(1, 14.0F);
    }
    paramRecyclerView = (TextView)paramj.UH(e.e.finder_wording_count);
    if (paramRecyclerView != null) {
      paramRecyclerView.setTextSize(1, 12.0F);
    }
    paramRecyclerView = (WeImageView)paramj.UH(e.e.finder_wording_delete);
    View localView;
    if (paramRecyclerView != null)
    {
      localView = (View)paramRecyclerView;
      paramInt = (int)paramj.context.getResources().getDimension(e.c.Edge_0_5_A);
      paramRecyclerView = localView.getParent();
      if (!(paramRecyclerView instanceof View)) {
        break label149;
      }
    }
    label149:
    for (paramRecyclerView = (View)paramRecyclerView;; paramRecyclerView = null)
    {
      if (paramRecyclerView != null) {
        paramRecyclerView.post(new cy..ExternalSyntheticLambda1(localView, paramInt, paramRecyclerView));
      }
      AppMethodBeat.o(349851);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_feed_wording_content_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cy
 * JD-Core Version:    0.7.0.1
 */