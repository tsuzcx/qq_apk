package com.tencent.mm.plugin.finder.vlog;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.a.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "previewId", "", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "initRecyclerView", "", "onDetach", "select", "index", "", "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-finder_release"})
public final class a
  implements t
{
  public static final a.a sge;
  private final RecyclerView fNZ;
  long rIq;
  d rTT;
  final ArrayList<GalleryItem.MediaItem> sgc;
  b sgd;
  
  static
  {
    AppMethodBeat.i(204775);
    sge = new a.a((byte)0);
    AppMethodBeat.o(204775);
  }
  
  public a(RecyclerView paramRecyclerView, d paramd)
  {
    AppMethodBeat.i(204774);
    this.fNZ = paramRecyclerView;
    this.rTT = paramd;
    this.sgc = new ArrayList();
    this.fNZ.setHasFixedSize(true);
    this.fNZ.getContext();
    paramRecyclerView = new LinearLayoutManager();
    paramRecyclerView.setOrientation(0);
    paramRecyclerView.aw(true);
    this.fNZ.setLayoutManager((RecyclerView.i)paramRecyclerView);
    this.fNZ.setItemAnimator((RecyclerView.f)new v());
    this.fNZ.b((RecyclerView.h)new e(this));
    this.sgd = new b();
    paramRecyclerView = this.sgd;
    if (paramRecyclerView == null) {
      k.aVY("adapter");
    }
    paramRecyclerView.setItems((List)this.sgc);
    paramRecyclerView = this.sgd;
    if (paramRecyclerView == null) {
      k.aVY("adapter");
    }
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new a.c(this, (com.tencent.mm.ui.base.a.a)paramRecyclerView)).j(this.fNZ);
    paramRecyclerView = this.fNZ;
    paramd = this.sgd;
    if (paramd == null) {
      k.aVY("adapter");
    }
    paramRecyclerView.setAdapter((RecyclerView.a)paramd);
    paramRecyclerView = this.sgd;
    if (paramRecyclerView == null) {
      k.aVY("adapter");
    }
    paramRecyclerView.HDz = ((com.tencent.mm.ui.base.a.a.a)new f(this));
    this.fNZ.setVisibility(0);
    AppMethodBeat.o(204774);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(204773);
    b localb = this.sgd;
    if (localb == null) {
      k.aVY("adapter");
    }
    localb.clearItems();
    AppMethodBeat.o(204773);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(204772);
    this.fNZ.setVisibility(paramInt);
    AppMethodBeat.o(204772);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, a.d>
  {
    public b()
    {
      AppMethodBeat.i(204750);
      av(true);
      AppMethodBeat.o(204750);
    }
    
    public final void a(b paramb, int paramInt)
    {
      AppMethodBeat.i(204745);
      k.h(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (a.d)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
      ImageView localImageView = paramb.getImageView();
      k.g(localMediaItem, "media");
      h.a(localImageView, localMediaItem.getType(), localMediaItem.auN(), localMediaItem.cMQ(), localMediaItem.sKk, (h.a)a.sgg, localMediaItem.sKl);
      k.g(paramb, "itemView");
      if (localMediaItem.sKk == a.a(this.sgf))
      {
        bool = true;
        paramb.setSelected(bool);
        if (localMediaItem.sKk != a.a(this.sgf)) {
          break label147;
        }
      }
      label147:
      for (boolean bool = true;; bool = false)
      {
        paramb.setFocusable(bool);
        AppMethodBeat.o(204745);
        return;
        bool = false;
        break;
      }
    }
    
    public final void a(b paramb, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(204747);
      k.h(paramb, "holder");
      k.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(204747);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(204749);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).sKk;
      AppMethodBeat.o(204749);
      return l;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "attached"})
    static final class a
      implements h.a
    {
      public static final a sgg;
      
      static
      {
        AppMethodBeat.i(204743);
        sgg = new a();
        AppMethodBeat.o(204743);
      }
      
      public final void cGk() {}
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
  public final class d
    extends FrameLayout
  {
    private final ImageView dhf;
    private final View gGk;
    private final int padding;
    private final int rII;
    private final View rIJ;
    private final int size;
    
    public d()
    {
      super();
      AppMethodBeat.i(204767);
      this$1 = ai.getContext();
      k.g(a.this, "MMApplicationContext.getContext()");
      this.rII = a.this.getResources().getColor(2131100726);
      this.dhf = new ImageView(getContext());
      this.gGk = new View(getContext());
      this.rIJ = new View(getContext());
      this$1 = getContext();
      k.g(a.this, "context");
      this.padding = ((int)a.this.getResources().getDimension(2131165274));
      this$1 = getContext();
      k.g(a.this, "context");
      this.size = ((int)a.this.getResources().getDimension(2131165300));
      this.dhf.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this$1 = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      a.this.gravity = 17;
      localLayoutParams.gravity = 17;
      this.rIJ.setBackgroundColor(this.rII);
      addView(this.rIJ, (ViewGroup.LayoutParams)a.this);
      addView((View)this.dhf, (ViewGroup.LayoutParams)localLayoutParams);
      this$1 = this.gGk;
      localObject = getContext();
      k.g(localObject, "context");
      a.this.setBackgroundColor(((Context)localObject).getResources().getColor(2131101179));
      this.gGk.setAlpha(0.5F);
      this$1 = new FrameLayout.LayoutParams(-2, -1);
      a.this.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)a.this);
      AppMethodBeat.o(204767);
    }
    
    public final View getFocusedView()
    {
      return this.rIJ;
    }
    
    public final ImageView getImageView()
    {
      return this.dhf;
    }
    
    public final View getMaskView()
    {
      return this.gGk;
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
      AppMethodBeat.i(204765);
      super.setFocusable(paramBoolean);
      if (paramBoolean)
      {
        this.rIJ.setVisibility(0);
        AppMethodBeat.o(204765);
        return;
      }
      this.rIJ.setVisibility(4);
      AppMethodBeat.o(204765);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(204766);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.gGk.setVisibility(4);
        AppMethodBeat.o(204766);
        return;
      }
      this.gGk.setVisibility(0);
      AppMethodBeat.o(204766);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.h
  {
    private final float offset;
    
    e()
    {
      AppMethodBeat.i(204769);
      Context localContext = ai.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(2131165289);
      AppMethodBeat.o(204769);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(204768);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(paramt, "state");
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      paramView = paramRecyclerView.bh(paramView);
      k.g(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.lv();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.sgf.sgc.size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(204768);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.a
 * JD-Core Version:    0.7.0.1
 */