package com.tencent.mm.plugin.finder.vlog;

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
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder_release"})
public final class a$c
  extends a.a
{
  int dzl;
  private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, a.d> rIA;
  private int rIx;
  private int rIy;
  private int rIz;
  
  public a$c(com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, a.d> parama)
  {
    AppMethodBeat.i(204764);
    this.rIA = localObject;
    this.dzl = -1;
    this.rIx = -1;
    this.rIy = -1;
    AppMethodBeat.o(204764);
  }
  
  public final float K(RecyclerView.w paramw)
  {
    AppMethodBeat.i(204761);
    k.h(paramw, "viewHolder");
    AppMethodBeat.o(204761);
    return 0.295858F;
  }
  
  public final void L(RecyclerView.w paramw)
  {
    AppMethodBeat.i(204760);
    k.h(paramw, "viewHolder");
    AppMethodBeat.o(204760);
  }
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.w paramw)
  {
    AppMethodBeat.i(204763);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw, "viewHolder");
    int i = a.a.dh(51);
    AppMethodBeat.o(204763);
    return i;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.w paramw, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204762);
    k.h(paramCanvas, "c");
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw, "viewHolder");
    super.a(paramCanvas, paramRecyclerView, paramw, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
    AppMethodBeat.o(204762);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2)
  {
    AppMethodBeat.i(204757);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw1, "viewHolder");
    k.h(paramw2, "target");
    int i = paramw1.lv();
    int j = paramw2.lv();
    ac.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + i + " to=" + j);
    d.swap((List)this.sgf.sgc, i, j);
    this.rIA.ap(i, j);
    this.rIy = j;
    AppMethodBeat.o(204757);
    return true;
  }
  
  public final void d(RecyclerView paramRecyclerView, final RecyclerView.w paramw)
  {
    AppMethodBeat.i(204759);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramw, "viewHolder");
    super.d(paramRecyclerView, paramw);
    paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772091);
    paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramw));
    paramw.asD.startAnimation(paramRecyclerView);
    AppMethodBeat.o(204759);
  }
  
  public final void f(final RecyclerView.w paramw, final int paramInt)
  {
    AppMethodBeat.i(204758);
    super.f(paramw, paramInt);
    if (paramw != null)
    {
      Object localObject = paramw.asD;
      k.g(localObject, "viewHolder.itemView");
      localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772092);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramw, paramInt));
      paramw.asD.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(204758);
  }
  
  public final boolean mW()
  {
    return true;
  }
  
  public final boolean mX()
  {
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animation.AnimationListener
  {
    a(RecyclerView.w paramw) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(204752);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(null);
      ac.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + a.c.b(this.sgh) + " to=" + a.c.a(this.sgh));
      AppMethodBeat.o(204752);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(204753);
      k.h(paramAnimation, "animation");
      AppMethodBeat.o(204753);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(204751);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(new Object());
      AppMethodBeat.o(204751);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(a.c paramc, RecyclerView.w paramw, int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(204755);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(null);
      AppMethodBeat.o(204755);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(204756);
      k.h(paramAnimation, "animation");
      AppMethodBeat.o(204756);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(204754);
      k.h(paramAnimation, "animation");
      paramAnimation = paramw.asD;
      k.g(paramAnimation, "viewHolder.itemView");
      paramAnimation.setTag(new Object());
      if (paramInt == 2)
      {
        a.c.a(this.sgh, paramw.lv());
        a.c.b(this.sgh, a.c.a(this.sgh));
        this.sgh.dzl = a.c.c(this.sgh);
      }
      AppMethodBeat.o(204754);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.a.c
 * JD-Core Version:    0.7.0.1
 */