package com.tencent.mm.plugin.appbrand.ui.collection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView;", "context", "Landroid/content/Context;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;)V", "mFloatViewHolder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "getRecyclerView", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "animateFloatViewHolderAppearance", "", "floatHolder", "attachDragCallback", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/ItemDragCallback;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "createFloatViewForCallback", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "holder", "getOffsetOfFloatAnimation", "", "onBindFloatViewHolder", "originHolder", "onCreateFloatViewHolder", "Landroid/view/ViewGroup;", "onListMayChanged", "onListMayChanged$plugin_appbrand_integration_release", "onViewAdded", "child", "resetFloatViewHolder", "setRubbishViewVisible", "visibility", "", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public class c
  extends DragFeatureView
{
  private n lGu;
  private final i lGv;
  
  public c(Context paramContext, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(51250);
    this.lGv = parami;
    AppMethodBeat.o(51250);
  }
  
  public final j<?> N(RecyclerView.v paramv)
  {
    AppMethodBeat.i(51247);
    if ((paramv != null) && (paramv.lp() == 1))
    {
      paramv = (FrameLayout)this;
      RecyclerView.a locala = this.lGv.getAdapter();
      if (locala == null)
      {
        paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionAdapter");
        AppMethodBeat.o(51247);
        throw paramv;
      }
      paramv = new com.tencent.mm.plugin.appbrand.widget.desktop.b.l(paramv, (List)((b)locala).dataList, (m)new b());
      paramv.a((g)new a(this));
      paramv = (j)paramv;
      AppMethodBeat.o(51247);
      return paramv;
    }
    AppMethodBeat.o(51247);
    return null;
  }
  
  public void bpl() {}
  
  public final i getRecyclerView()
  {
    return this.lGv;
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(51249);
    super.onViewAdded(paramView);
    Object localObject = this.lGu;
    n localn;
    ViewPropertyAnimator localViewPropertyAnimator;
    float f2;
    float f1;
    if (localObject != null)
    {
      localObject = ((n)localObject).arI;
      if (k.g(paramView, localObject))
      {
        localn = this.lGu;
        if (localn == null) {
          k.fvU();
        }
        localViewPropertyAnimator = localn.arI.animate();
        paramView = localn.arI;
        k.g(paramView, "floatHolder.itemView");
        f2 = paramView.getTranslationY();
        TextView localTextView = localn.lGG;
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
      localn.arI.animate().scaleX(1.3F).scaleY(1.3F).setDuration(200L).setListener(null).setUpdateListener(null).start();
      localn.arI.animate().alpha(0.6F).setDuration(200L).setListener(null).setUpdateListener(null).start();
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$2$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IItemDragResultCallback;", "isCanCancel", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "target", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "isCanMove", "holder", "from", "", "to", "itemContent", "", "isDragEnable", "onCreateFloatView", "Landroid/view/View;", "onDelete", "", "dragObject", "onDrag", "floatView", "area", "onDragEnd", "startPos", "endPos", "isInserted", "onDragRelease", "plugin-appbrand-integration_release"})
  public static final class a
    implements g
  {
    a(c paramc) {}
    
    public final boolean O(RecyclerView.v paramv)
    {
      return true;
    }
    
    public final boolean P(RecyclerView.v paramv)
    {
      return false;
    }
    
    public final void a(RecyclerView.v paramv, View paramView, Object paramObject, int paramInt) {}
    
    public final boolean a(RecyclerView.v paramv, Object paramObject)
    {
      return true;
    }
    
    public final void b(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
    {
      AppMethodBeat.i(51242);
      this.lGw.bpl();
      AppMethodBeat.o(51242);
    }
    
    public final void cA(Object paramObject)
    {
      AppMethodBeat.i(51243);
      this.lGw.bpl();
      AppMethodBeat.o(51243);
    }
    
    public final void cL(View paramView)
    {
      AppMethodBeat.i(51245);
      k.h(paramView, "floatView");
      AppMethodBeat.o(51245);
    }
    
    public final View e(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(51244);
      c localc = this.lGw;
      if (paramRecyclerView == null) {
        k.fvU();
      }
      if (paramv == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionViewHolder");
        AppMethodBeat.o(51244);
        throw paramRecyclerView;
      }
      paramRecyclerView = c.a(localc, paramRecyclerView, (n)paramv);
      AppMethodBeat.o(51244);
      return paramRecyclerView;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/OnDragCallback;", "getDragViewTransX", "", "getDragViewTransY", "getScaleView", "Landroid/view/View;", "floatView", "onDragObject", "", "o", "onPositionChanged", "", "dragObject", "targetPosition", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements m
  {
    public final float bpm()
    {
      return 0.0F;
    }
    
    public final float bpn()
    {
      return 0.0F;
    }
    
    public final Object cB(Object paramObject)
    {
      AppMethodBeat.i(51246);
      if (paramObject == null) {
        k.fvU();
      }
      AppMethodBeat.o(51246);
      return paramObject;
    }
    
    public final View cM(View paramView)
    {
      return null;
    }
    
    public final void g(Object paramObject, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.c
 * JD-Core Version:    0.7.0.1
 */