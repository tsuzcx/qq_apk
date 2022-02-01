package com.tencent.mm.plugin.finder.vlog;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.a.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "previewId", "", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "initRecyclerView", "", "onDetach", "select", "index", "", "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-finder_release"})
public final class a
  implements t
{
  public static final a Lkx;
  final ArrayList<GalleryItem.MediaItem> Lkv;
  b Lkw;
  private final RecyclerView fKt;
  long qMV;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  
  static
  {
    AppMethodBeat.i(200644);
    Lkx = new a((byte)0);
    AppMethodBeat.o(200644);
  }
  
  public a(RecyclerView paramRecyclerView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(200643);
    this.fKt = paramRecyclerView;
    this.vjo = paramd;
    this.Lkv = new ArrayList();
    this.fKt.setHasFixedSize(true);
    this.fKt.getContext();
    paramRecyclerView = new LinearLayoutManager();
    paramRecyclerView.setOrientation(0);
    paramRecyclerView.aw(true);
    this.fKt.setLayoutManager((RecyclerView.i)paramRecyclerView);
    this.fKt.setItemAnimator((RecyclerView.f)new v());
    this.fKt.b((RecyclerView.h)new e(this));
    this.Lkw = new b();
    paramRecyclerView = this.Lkw;
    if (paramRecyclerView == null) {
      k.aPZ("adapter");
    }
    paramRecyclerView.setItems((List)this.Lkv);
    paramRecyclerView = this.Lkw;
    if (paramRecyclerView == null) {
      k.aPZ("adapter");
    }
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new c((com.tencent.mm.ui.base.a.a)paramRecyclerView)).j(this.fKt);
    paramRecyclerView = this.fKt;
    paramd = this.Lkw;
    if (paramd == null) {
      k.aPZ("adapter");
    }
    paramRecyclerView.setAdapter((RecyclerView.a)paramd);
    paramRecyclerView = this.Lkw;
    if (paramRecyclerView == null) {
      k.aPZ("adapter");
    }
    paramRecyclerView.GdK = ((com.tencent.mm.ui.base.a.a.a)new f(this));
    this.fKt.setVisibility(0);
    AppMethodBeat.o(200643);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(200642);
    b localb = this.Lkw;
    if (localb == null) {
      k.aPZ("adapter");
    }
    localb.clearItems();
    AppMethodBeat.o(200642);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(200641);
    this.fKt.setVisibility(paramInt);
    AppMethodBeat.o(200641);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, a.d>
  {
    public b()
    {
      AppMethodBeat.i(200619);
      av(true);
      AppMethodBeat.o(200619);
    }
    
    public final void a(b paramb, int paramInt)
    {
      AppMethodBeat.i(200614);
      k.h(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (a.d)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
      ImageView localImageView = paramb.getImageView();
      k.g(localMediaItem, "media");
      h.a(localImageView, localMediaItem.getType(), localMediaItem.anX(), localMediaItem.czE(), localMediaItem.rBs, (h.a)a.Lkz, localMediaItem.rBt);
      k.g(paramb, "itemView");
      if (localMediaItem.rBs == a.a(this.Lky))
      {
        bool = true;
        paramb.setSelected(bool);
        if (localMediaItem.rBs != a.a(this.Lky)) {
          break label147;
        }
      }
      label147:
      for (boolean bool = true;; bool = false)
      {
        paramb.setFocusable(bool);
        AppMethodBeat.o(200614);
        return;
        bool = false;
        break;
      }
    }
    
    public final void a(b paramb, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(200616);
      k.h(paramb, "holder");
      k.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(200616);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(200618);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).rBs;
      AppMethodBeat.o(200618);
      return l;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "attached"})
    static final class a
      implements h.a
    {
      public static final a Lkz;
      
      static
      {
        AppMethodBeat.i(200612);
        Lkz = new a();
        AppMethodBeat.o(200612);
      }
      
      public final void cAN() {}
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder_release"})
  public final class c
    extends android.support.v7.widget.a.a.a
  {
    int dBx;
    private int qMZ;
    private int qNa;
    private int qNb;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, a.d> qNc;
    
    public c()
    {
      AppMethodBeat.i(200633);
      this.qNc = localObject;
      this.dBx = -1;
      this.qMZ = -1;
      this.qNa = -1;
      AppMethodBeat.o(200633);
    }
    
    public final float K(RecyclerView.v paramv)
    {
      AppMethodBeat.i(200630);
      k.h(paramv, "viewHolder");
      AppMethodBeat.o(200630);
      return 0.295858F;
    }
    
    public final void L(RecyclerView.v paramv)
    {
      AppMethodBeat.i(200629);
      k.h(paramv, "viewHolder");
      AppMethodBeat.o(200629);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(200632);
      k.h(paramRecyclerView, "recyclerView");
      k.h(paramv, "viewHolder");
      int i = android.support.v7.widget.a.a.a.di(51);
      AppMethodBeat.o(200632);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(200631);
      k.h(paramCanvas, "c");
      k.h(paramRecyclerView, "recyclerView");
      k.h(paramv, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(200631);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(200626);
      k.h(paramRecyclerView, "recyclerView");
      k.h(paramv1, "viewHolder");
      k.h(paramv2, "target");
      int i = paramv1.ln();
      int j = paramv2.ln();
      ad.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + i + " to=" + j);
      com.tencent.mm.plugin.gallery.a.d.swap((List)a.this.Lkv, i, j);
      this.qNc.ap(i, j);
      this.qNa = j;
      AppMethodBeat.o(200626);
      return true;
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.v paramv)
    {
      AppMethodBeat.i(200628);
      k.h(paramRecyclerView, "recyclerView");
      k.h(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772091);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramv));
      paramv.arI.startAnimation(paramRecyclerView);
      AppMethodBeat.o(200628);
    }
    
    public final void f(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(200627);
      super.f(paramv, paramInt);
      if (paramv != null)
      {
        Object localObject = paramv.arI;
        k.g(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772092);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramv, paramInt));
        paramv.arI.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(200627);
    }
    
    public final boolean mM()
    {
      return true;
    }
    
    public final boolean mN()
    {
      return false;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.v paramv) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(200621);
        k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        ad.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + a.c.b(this.LkA) + " to=" + a.c.a(this.LkA));
        AppMethodBeat.o(200621);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(200622);
        k.h(paramAnimation, "animation");
        AppMethodBeat.o(200622);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(200620);
        k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(200620);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(a.c paramc, RecyclerView.v paramv, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(200624);
        k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(200624);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(200625);
        k.h(paramAnimation, "animation");
        AppMethodBeat.o(200625);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(200623);
        k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          a.c.a(this.LkA, paramv.ln());
          a.c.b(this.LkA, a.c.a(this.LkA));
          this.LkA.dBx = a.c.c(this.LkA);
        }
        AppMethodBeat.o(200623);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
  public final class d
    extends FrameLayout
  {
    private final ImageView djK;
    private final View lRB;
    private final int padding;
    private final int qNk;
    private final View qNl;
    private final int size;
    
    public d()
    {
      super();
      AppMethodBeat.i(200636);
      this$1 = aj.getContext();
      k.g(a.this, "MMApplicationContext.getContext()");
      this.qNk = a.this.getResources().getColor(2131100726);
      this.djK = new ImageView(getContext());
      this.lRB = new View(getContext());
      this.qNl = new View(getContext());
      this$1 = getContext();
      k.g(a.this, "context");
      this.padding = ((int)a.this.getResources().getDimension(2131165274));
      this$1 = getContext();
      k.g(a.this, "context");
      this.size = ((int)a.this.getResources().getDimension(2131165300));
      this.djK.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this$1 = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      a.this.gravity = 17;
      localLayoutParams.gravity = 17;
      this.qNl.setBackgroundColor(this.qNk);
      addView(this.qNl, (ViewGroup.LayoutParams)a.this);
      addView((View)this.djK, (ViewGroup.LayoutParams)localLayoutParams);
      this$1 = this.lRB;
      localObject = getContext();
      k.g(localObject, "context");
      a.this.setBackgroundColor(((Context)localObject).getResources().getColor(2131101179));
      this.lRB.setAlpha(0.5F);
      this$1 = new FrameLayout.LayoutParams(-2, -1);
      a.this.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)a.this);
      AppMethodBeat.o(200636);
    }
    
    public final View getFocusedView()
    {
      return this.qNl;
    }
    
    public final ImageView getImageView()
    {
      return this.djK;
    }
    
    public final View getMaskView()
    {
      return this.lRB;
    }
    
    public final int getPadding()
    {
      return this.padding;
    }
    
    public final int getSize()
    {
      return this.size;
    }
    
    public final void setFocusable(boolean paramBoolean)
    {
      AppMethodBeat.i(200634);
      super.setFocusable(paramBoolean);
      if (paramBoolean)
      {
        this.qNl.setVisibility(0);
        AppMethodBeat.o(200634);
        return;
      }
      this.qNl.setVisibility(4);
      AppMethodBeat.o(200634);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(200635);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.lRB.setVisibility(4);
        AppMethodBeat.o(200635);
        return;
      }
      this.lRB.setVisibility(0);
      AppMethodBeat.o(200635);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.h
  {
    private final float offset;
    
    e()
    {
      AppMethodBeat.i(200638);
      Context localContext = aj.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(2131165289);
      AppMethodBeat.o(200638);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(200637);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramView = paramRecyclerView.bh(paramView);
      k.g(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.ln();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.Lky.Lkv.size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(200637);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.a
 * JD-Core Version:    0.7.0.1
 */