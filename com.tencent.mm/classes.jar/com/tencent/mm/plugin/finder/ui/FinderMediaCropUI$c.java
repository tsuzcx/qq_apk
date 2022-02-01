package com.tencent.mm.plugin.finder.ui;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.a.a.a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.a.a;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder_release"})
public final class FinderMediaCropUI$c
  extends a.a
{
  int dzl;
  private final a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> rIA;
  private int rIx;
  private int rIy;
  private int rIz;
  
  public FinderMediaCropUI$c(a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> parama)
  {
    AppMethodBeat.i(167345);
    this.rIA = localObject;
    this.dzl = -1;
    this.rIx = -1;
    this.rIy = -1;
    AppMethodBeat.o(167345);
  }
  
  public final float K(RecyclerView.w paramw)
  {
    AppMethodBeat.i(167342);
    k.h(paramw, "viewHolder");
    AppMethodBeat.o(167342);
    return 0.295858F;
  }
  
  public final void L(RecyclerView.w paramw)
  {
    AppMethodBeat.i(167341);
    k.h(paramw, "viewHolder");
    AppMethodBeat.o(167341);
  }
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.w paramw)
  {
    AppMethodBeat.i(167344);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw, "viewHolder");
    int i = a.a.dh(51);
    AppMethodBeat.o(167344);
    return i;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.w paramw, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(167343);
    k.h(paramCanvas, "c");
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw, "viewHolder");
    super.a(paramCanvas, paramRecyclerView, paramw, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
    AppMethodBeat.o(167343);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2)
  {
    AppMethodBeat.i(167338);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw1, "viewHolder");
    k.h(paramw2, "target");
    int i = paramw1.lv();
    int j = paramw2.lv();
    ac.d("Finder.MediaCropUI", "[onMove] from=" + i + " to=" + j);
    d.swap((List)this.rIw.cBO(), i, j);
    this.rIA.ap(i, j);
    this.rIy = j;
    AppMethodBeat.o(167338);
    return true;
  }
  
  public final void d(RecyclerView paramRecyclerView, final RecyclerView.w paramw)
  {
    AppMethodBeat.i(167340);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw, "viewHolder");
    super.d(paramRecyclerView, paramw);
    paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772077);
    paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramw));
    paramw.asD.startAnimation(paramRecyclerView);
    AppMethodBeat.o(167340);
  }
  
  public final void f(final RecyclerView.w paramw, final int paramInt)
  {
    AppMethodBeat.i(167339);
    super.f(paramw, paramInt);
    if (paramw != null)
    {
      Object localObject = paramw.asD;
      k.g(localObject, "viewHolder.itemView");
      localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772078);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramw, paramInt));
      paramw.asD.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(167339);
  }
  
  public final boolean mW()
  {
    return true;
  }
  
  public final boolean mX()
  {
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animation.AnimationListener
  {
    a(RecyclerView.w paramw) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(167333);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(null);
      ac.d("Finder.MediaCropUI", "finally change from=" + FinderMediaCropUI.c.b(this.rIB) + " to=" + FinderMediaCropUI.c.a(this.rIB));
      AppMethodBeat.o(167333);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(167334);
      k.h(paramAnimation, "animation");
      AppMethodBeat.o(167334);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(167332);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(new Object());
      AppMethodBeat.o(167332);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(FinderMediaCropUI.c paramc, RecyclerView.w paramw, int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(167336);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(null);
      AppMethodBeat.o(167336);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(167337);
      k.h(paramAnimation, "animation");
      AppMethodBeat.o(167337);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(167335);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(new Object());
      if (paramInt == 2)
      {
        FinderMediaCropUI.c.a(this.rIB, paramw.lv());
        FinderMediaCropUI.c.b(this.rIB, FinderMediaCropUI.c.a(this.rIB));
        this.rIB.dzl = FinderMediaCropUI.c.c(this.rIB);
      }
      AppMethodBeat.o(167335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.c
 * JD-Core Version:    0.7.0.1
 */