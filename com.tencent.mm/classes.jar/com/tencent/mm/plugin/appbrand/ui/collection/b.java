package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import a.v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.f;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView;", "context", "Landroid/content/Context;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;)V", "mFloatViewHolder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "getRecyclerView", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "animateFloatViewHolderAppearance", "", "floatHolder", "attachDragCallback", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/ItemDragCallback;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "createFloatViewForCallback", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "holder", "getOffsetOfFloatAnimation", "", "onBindFloatViewHolder", "originHolder", "onCreateFloatViewHolder", "Landroid/view/ViewGroup;", "onListMayChanged", "onListMayChanged$plugin_appbrand_integration_release", "onViewAdded", "child", "resetFloatViewHolder", "setRubbishViewVisible", "visibility", "", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public class b
  extends DragFeatureView
{
  private m iRU;
  private final h iRV;
  
  public b(Context paramContext, h paramh)
  {
    super(paramContext);
    AppMethodBeat.i(135086);
    this.iRV = paramh;
    AppMethodBeat.o(135086);
  }
  
  public final c<?> N(RecyclerView.v paramv)
  {
    AppMethodBeat.i(135083);
    if ((paramv != null) && (paramv.jO() == 1))
    {
      paramv = (FrameLayout)this;
      RecyclerView.a locala = this.iRV.getAdapter();
      if (locala == null)
      {
        paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionAdapter");
        AppMethodBeat.o(135083);
        throw paramv;
      }
      paramv = new e(paramv, (List)((a)locala).iRT, (f)new b.b());
      paramv.a((com.tencent.mm.plugin.appbrand.widget.desktop.a.a)new b.a(this));
      paramv = (c)paramv;
      AppMethodBeat.o(135083);
      return paramv;
    }
    AppMethodBeat.o(135083);
    return null;
  }
  
  public void aMV() {}
  
  public final h getRecyclerView()
  {
    return this.iRV;
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(135085);
    super.onViewAdded(paramView);
    Object localObject = this.iRU;
    m localm;
    ViewPropertyAnimator localViewPropertyAnimator;
    float f2;
    float f1;
    if (localObject != null)
    {
      localObject = ((m)localObject).aku;
      if (j.e(paramView, localObject))
      {
        localm = this.iRU;
        if (localm == null) {
          j.ebi();
        }
        localViewPropertyAnimator = localm.aku.animate();
        paramView = localm.aku;
        j.p(paramView, "floatHolder.itemView");
        f2 = paramView.getTranslationY();
        TextView localTextView = localm.iSf;
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
      localm.aku.animate().scaleX(1.3F).scaleY(1.3F).setDuration(200L).setListener(null).setUpdateListener(null).start();
      localm.aku.animate().alpha(0.6F).setDuration(200L).setListener(null).setUpdateListener(null).start();
      AppMethodBeat.o(135085);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void setRubbishViewVisible(int paramInt)
  {
    AppMethodBeat.i(135084);
    super.setRubbishViewVisible(paramInt);
    AppMethodBeat.o(135084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b
 * JD-Core Version:    0.7.0.1
 */