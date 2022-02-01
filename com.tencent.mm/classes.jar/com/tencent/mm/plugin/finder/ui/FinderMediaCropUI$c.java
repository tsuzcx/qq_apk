package com.tencent.mm.plugin.finder.ui;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.a.a.a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder_release"})
public final class FinderMediaCropUI$c
  extends a.a
{
  int eeE;
  private final a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> vLA;
  private int vLx;
  private int vLy;
  private int vLz;
  
  public FinderMediaCropUI$c(a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> parama)
  {
    AppMethodBeat.i(167345);
    this.vLA = localObject;
    this.eeE = -1;
    this.vLx = -1;
    this.vLy = -1;
    AppMethodBeat.o(167345);
  }
  
  public final float M(RecyclerView.v paramv)
  {
    AppMethodBeat.i(167342);
    p.h(paramv, "viewHolder");
    AppMethodBeat.o(167342);
    return 0.295858F;
  }
  
  public final void N(RecyclerView.v paramv)
  {
    AppMethodBeat.i(167341);
    p.h(paramv, "viewHolder");
    AppMethodBeat.o(167341);
  }
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(167344);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramv, "viewHolder");
    int i = a.a.db(51);
    AppMethodBeat.o(167344);
    return i;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(167343);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramv, "viewHolder");
    super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
    AppMethodBeat.o(167343);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    AppMethodBeat.i(167338);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramv1, "viewHolder");
    p.h(paramv2, "target");
    int i = paramv1.lR();
    int j = paramv2.lR();
    Log.d("Finder.MediaCropUI", "[onMove] from=" + i + " to=" + j);
    d.swap((List)this.vLw.dzG(), i, j);
    this.vLA.ar(i, j);
    this.vLy = j;
    AppMethodBeat.o(167338);
    return true;
  }
  
  public final void d(RecyclerView paramRecyclerView, final RecyclerView.v paramv)
  {
    AppMethodBeat.i(167340);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramv, "viewHolder");
    super.d(paramRecyclerView, paramv);
    paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772096);
    paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramv));
    paramv.aus.startAnimation(paramRecyclerView);
    AppMethodBeat.o(167340);
  }
  
  public final void f(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(167339);
    super.f(paramv, paramInt);
    if (paramv != null)
    {
      Object localObject = paramv.aus;
      p.g(localObject, "viewHolder.itemView");
      localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772097);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramv, paramInt));
      paramv.aus.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(167339);
  }
  
  public final boolean nq()
  {
    return true;
  }
  
  public final boolean nr()
  {
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animation.AnimationListener
  {
    a(RecyclerView.v paramv) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(167333);
      p.h(paramAnimation, "animation");
      paramAnimation = paramv.aus;
      p.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(null);
      Log.d("Finder.MediaCropUI", "finally change from=" + FinderMediaCropUI.c.b(this.vLB) + " to=" + FinderMediaCropUI.c.a(this.vLB));
      AppMethodBeat.o(167333);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(167334);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(167334);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(167332);
      p.h(paramAnimation, "animation");
      paramAnimation = paramv.aus;
      p.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(new Object());
      AppMethodBeat.o(167332);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(FinderMediaCropUI.c paramc, RecyclerView.v paramv, int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(167336);
      p.h(paramAnimation, "animation");
      paramAnimation = paramv.aus;
      p.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(null);
      AppMethodBeat.o(167336);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(167337);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(167337);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(167335);
      p.h(paramAnimation, "animation");
      paramAnimation = paramv.aus;
      p.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(new Object());
      if (paramInt == 2)
      {
        FinderMediaCropUI.c.a(this.vLB, paramv.lR());
        FinderMediaCropUI.c.b(this.vLB, FinderMediaCropUI.c.a(this.vLB));
        this.vLB.eeE = FinderMediaCropUI.c.c(this.vLB);
      }
      AppMethodBeat.o(167335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.c
 * JD-Core Version:    0.7.0.1
 */