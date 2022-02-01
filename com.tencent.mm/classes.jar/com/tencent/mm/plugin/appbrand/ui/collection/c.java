package com.tencent.mm.plugin.appbrand.ui.collection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.j;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.m;
import d.g.b.k;
import d.v;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView;", "context", "Landroid/content/Context;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;)V", "mFloatViewHolder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "getRecyclerView", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "animateFloatViewHolderAppearance", "", "floatHolder", "attachDragCallback", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/ItemDragCallback;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "createFloatViewForCallback", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "holder", "getOffsetOfFloatAnimation", "", "onBindFloatViewHolder", "originHolder", "onCreateFloatViewHolder", "Landroid/view/ViewGroup;", "onListMayChanged", "onListMayChanged$plugin_appbrand_integration_release", "onViewAdded", "child", "resetFloatViewHolder", "setRubbishViewVisible", "visibility", "", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public class c
  extends DragFeatureView
{
  private n mip;
  private final i miq;
  
  public c(Context paramContext, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(51250);
    this.miq = parami;
    AppMethodBeat.o(51250);
  }
  
  public final j<?> N(RecyclerView.w paramw)
  {
    AppMethodBeat.i(51247);
    if ((paramw != null) && (paramw.ly() == 1))
    {
      paramw = (FrameLayout)this;
      RecyclerView.a locala = this.miq.getAdapter();
      if (locala == null)
      {
        paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionAdapter");
        AppMethodBeat.o(51247);
        throw paramw;
      }
      paramw = new com.tencent.mm.plugin.appbrand.widget.desktop.b.l(paramw, (List)((b)locala).dataList, (m)new b());
      paramw.a((g)new a(this));
      paramw = (j)paramw;
      AppMethodBeat.o(51247);
      return paramw;
    }
    AppMethodBeat.o(51247);
    return null;
  }
  
  public void bwg() {}
  
  public final i getRecyclerView()
  {
    return this.miq;
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(51249);
    super.onViewAdded(paramView);
    Object localObject = this.mip;
    n localn;
    ViewPropertyAnimator localViewPropertyAnimator;
    float f2;
    float f1;
    if (localObject != null)
    {
      localObject = ((n)localObject).asD;
      if (k.g(paramView, localObject))
      {
        localn = this.mip;
        if (localn == null) {
          k.fOy();
        }
        localViewPropertyAnimator = localn.asD.animate();
        paramView = localn.asD;
        k.g(paramView, "floatHolder.itemView");
        f2 = paramView.getTranslationY();
        TextView localTextView = localn.miB;
        localObject = localTextView.getLayoutParams();
        paramView = (View)localObject;
        if (!(localObject instanceof RelativeLayout.LayoutParams)) {
          paramView = null;
        }
        paramView = (RelativeLayout.LayoutParams)paramView;
        f1 = localTextView.getHeight();
        if (paramView == null) {
          break label235;
        }
        int i = paramView.topMargin;
        f1 = paramView.bottomMargin + i + f1;
      }
    }
    label235:
    for (;;)
    {
      localViewPropertyAnimator.translationY(f1 / 2.0F + f2).setDuration(1L).start();
      localn.asD.animate().scaleX(1.3F).scaleY(1.3F).setDuration(200L).setListener(null).setUpdateListener(null).start();
      localn.asD.animate().alpha(0.6F).setDuration(200L).setListener(null).setUpdateListener(null).start();
      AppMethodBeat.o(51249);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void setRubbishViewVisible(int paramInt)
  {
    AppMethodBeat.i(51248);
    super.setRubbishViewVisible(paramInt);
    AppMethodBeat.o(51248);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$2$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IItemDragResultCallback;", "isCanCancel", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "target", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "isCanMove", "holder", "from", "", "to", "itemContent", "", "isDragEnable", "onCreateFloatView", "Landroid/view/View;", "onDelete", "", "dragObject", "onDrag", "floatView", "area", "onDragEnd", "startPos", "endPos", "isInserted", "onDragRelease", "plugin-appbrand-integration_release"})
  public static final class a
    implements g
  {
    a(c paramc) {}
    
    public final boolean O(RecyclerView.w paramw)
    {
      return true;
    }
    
    public final boolean P(RecyclerView.w paramw)
    {
      return false;
    }
    
    public final void a(RecyclerView.w paramw, View paramView, Object paramObject, int paramInt) {}
    
    public final boolean a(RecyclerView.w paramw, Object paramObject)
    {
      return true;
    }
    
    public final void b(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
    {
      AppMethodBeat.i(51242);
      this.mir.bwg();
      AppMethodBeat.o(51242);
    }
    
    public final void cN(View paramView)
    {
      AppMethodBeat.i(51245);
      k.h(paramView, "floatView");
      AppMethodBeat.o(51245);
    }
    
    public final void cz(Object paramObject)
    {
      AppMethodBeat.i(51243);
      this.mir.bwg();
      AppMethodBeat.o(51243);
    }
    
    public final View e(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      AppMethodBeat.i(51244);
      c localc = this.mir;
      if (paramRecyclerView == null) {
        k.fOy();
      }
      if (paramw == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionViewHolder");
        AppMethodBeat.o(51244);
        throw paramRecyclerView;
      }
      paramRecyclerView = c.a(localc, paramRecyclerView, (n)paramw);
      AppMethodBeat.o(51244);
      return paramRecyclerView;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/OnDragCallback;", "getDragViewTransX", "", "getDragViewTransY", "getScaleView", "Landroid/view/View;", "floatView", "onDragObject", "", "o", "onPositionChanged", "", "dragObject", "targetPosition", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements m
  {
    public final float bwh()
    {
      return 0.0F;
    }
    
    public final float bwi()
    {
      return 0.0F;
    }
    
    public final Object cA(Object paramObject)
    {
      AppMethodBeat.i(51246);
      if (paramObject == null) {
        k.fOy();
      }
      AppMethodBeat.o(51246);
      return paramObject;
    }
    
    public final View cO(View paramView)
    {
      return null;
    }
    
    public final void g(Object paramObject, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.c
 * JD-Core Version:    0.7.0.1
 */