package com.tencent.mm.plugin.gallery.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.a.a;
import com.tencent.mm.plugin.gallery.picker.a.a.c;
import com.tencent.mm.plugin.gallery.picker.a.a.d;
import com.tencent.mm.plugin.gallery.picker.a.b.b;
import com.tencent.mm.plugin.gallery.picker.c.e;
import com.tencent.mm.plugin.gallery.picker.c.f;
import com.tencent.mm.plugin.gallery.picker.manager.SpeedGirdLayoutManager;
import com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.recyclerview.d;
import d.a.j;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", "listener", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroid/support/v7/widget/RecyclerView;", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", "previewImage", "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"})
@SuppressLint({"ValidFragment"})
public final class GalleryPickerFragment
  extends Fragment
  implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem>
{
  public static final GalleryPickerFragment.a sLE;
  private ArrayList<GalleryItem.MediaItem> rJC;
  private int sLA;
  private boolean sLB;
  private int sLC;
  private GalleryPickerFragment.b sLD;
  private final a sLr;
  private final com.tencent.mm.plugin.gallery.picker.a.b sLs;
  private RecyclerView sLt;
  private RecyclerView sLu;
  private MMMediaCropLayout sLv;
  private AppBarLayout sLw;
  private ImageView sLx;
  private final Drawable sLy;
  private final Drawable sLz;
  
  static
  {
    AppMethodBeat.i(164843);
    sLE = new GalleryPickerFragment.a((byte)0);
    AppMethodBeat.o(164843);
  }
  
  public GalleryPickerFragment(ArrayList<GalleryItem.MediaItem> paramArrayList, GalleryPickerFragment.b paramb)
  {
    AppMethodBeat.i(164842);
    this.rJC = paramArrayList;
    this.sLD = paramb;
    paramArrayList = f.sMP;
    this.sLr = new a(f.cNn(), this.rJC);
    paramArrayList = f.sMP;
    this.sLs = new com.tencent.mm.plugin.gallery.picker.a.b(f.cNn());
    paramArrayList = ai.getContext();
    k.g(paramArrayList, "MMApplicationContext.getContext()");
    this.sLy = paramArrayList.getResources().getDrawable(2131234015);
    paramArrayList = ai.getContext();
    k.g(paramArrayList, "MMApplicationContext.getContext()");
    this.sLz = paramArrayList.getResources().getDrawable(2131234014);
    this.sLA = 1;
    this.sLB = true;
    AppMethodBeat.o(164842);
  }
  
  private final void T(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(164841);
    ac.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + paramLong1 + " current=" + paramLong2);
    Object localObject1 = this.sLu;
    if (localObject1 == null) {
      k.aVY("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = d.c((d)localObject1, paramLong2);
    Object localObject2;
    if (localObject1 != null)
    {
      this.sLC = ((RecyclerView.w)localObject1).lv();
      localObject2 = this.sLu;
      if (localObject2 == null) {
        k.aVY("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null) {
        ((RecyclerView.a)localObject2).cj(((RecyclerView.w)localObject1).lv());
      }
    }
    localObject1 = this.sLu;
    if (localObject1 == null) {
      k.aVY("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = d.c((d)localObject1, paramLong1);
    if (localObject1 != null)
    {
      localObject2 = this.sLu;
      if (localObject2 == null) {
        k.aVY("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null)
      {
        ((RecyclerView.a)localObject2).cj(((RecyclerView.w)localObject1).lv());
        AppMethodBeat.o(164841);
        return;
      }
    }
    AppMethodBeat.o(164841);
  }
  
  private final void a(GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(164835);
    Object localObject;
    if (this.rJC.isEmpty())
    {
      localObject = this.sLv;
      if (localObject == null) {
        k.aVY("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).sNT)
      {
        paramMediaItem = this.sLv;
        if (paramMediaItem == null) {
          k.aVY("previewContainer");
        }
        MMMediaCropLayout.b(paramMediaItem);
        AppMethodBeat.o(164835);
        return;
      }
    }
    if (this.rJC.size() == 1)
    {
      localObject = this.sLv;
      if (localObject == null) {
        k.aVY("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).sNT)
      {
        localObject = (GalleryItem.MediaItem)j.iO((List)this.rJC);
        if (paramBoolean)
        {
          if (paramMediaItem == null) {
            break label157;
          }
          if (paramMediaItem.sKk == ((GalleryItem.MediaItem)localObject).sKk)
          {
            paramMediaItem = this.sLv;
            if (paramMediaItem == null) {
              k.aVY("previewContainer");
            }
            MMMediaCropLayout.b(paramMediaItem);
          }
        }
      }
    }
    AppMethodBeat.o(164835);
    return;
    label157:
    AppMethodBeat.o(164835);
  }
  
  private final void cNk()
  {
    AppMethodBeat.i(164834);
    Iterator localIterator = ((Iterable)this.rJC).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (GalleryItem.MediaItem)localIterator.next();
      Object localObject2 = this.sLu;
      if (localObject2 == null) {
        k.aVY("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
        AppMethodBeat.o(164834);
        throw ((Throwable)localObject1);
      }
      localObject2 = d.c((d)localObject2, ((GalleryItem.MediaItem)localObject1).sKk);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.ui.base.a.b)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.ui.base.a.b)localObject1;
      if (localObject1 != null) {
        this.sLr.b(((com.tencent.mm.ui.base.a.b)localObject1).lv(), Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(164834);
  }
  
  private final void e(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164836);
    MMMediaCropLayout localMMMediaCropLayout = this.sLv;
    if (localMMMediaCropLayout == null) {
      k.aVY("previewContainer");
    }
    long l = localMMMediaCropLayout.getCurrentPreviewMediaId();
    if (this.rJC.size() == 2)
    {
      localMMMediaCropLayout = this.sLv;
      if (localMMMediaCropLayout == null) {
        k.aVY("previewContainer");
      }
      if (!localMMMediaCropLayout.sNT)
      {
        localMMMediaCropLayout = this.sLv;
        if (localMMMediaCropLayout == null) {
          k.aVY("previewContainer");
        }
        MMMediaCropLayout.a(localMMMediaCropLayout);
      }
    }
    a(paramMediaItem, true);
    if (paramMediaItem.getType() == 2) {
      g(paramMediaItem);
    }
    for (;;)
    {
      T(l, paramMediaItem.sKk);
      AppMethodBeat.o(164836);
      return;
      f(paramMediaItem);
    }
  }
  
  private final void f(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164839);
    if ((this.sLB) && (this.sLA != 1))
    {
      AppMethodBeat.o(164839);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.sLv;
    if (localMMMediaCropLayout == null) {
      k.aVY("previewContainer");
    }
    MMMediaCropLayout.a(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164839);
  }
  
  private final void g(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164840);
    if ((this.sLB) && (this.sLA != 2))
    {
      AppMethodBeat.o(164840);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.sLv;
    if (localMMMediaCropLayout == null) {
      k.aVY("previewContainer");
    }
    MMMediaCropLayout.b(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164840);
  }
  
  private final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(164826);
    this.sLB = paramBoolean;
    this.sLr.sLB = paramBoolean;
    ac.i("MicroMsg.GalleryPickerFragment", "isMultiSelectedMode=".concat(String.valueOf(paramBoolean)));
    ac.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
    Object localObject1 = this.sLu;
    if (localObject1 == null) {
      k.aVY("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {
      k.fOy();
    }
    Object localObject2 = this.sLu;
    if (localObject2 == null) {
      k.aVY("galleryView");
    }
    localObject2 = ((RecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      k.fOy();
    }
    k.g(localObject2, "galleryView.adapter!!");
    ((RecyclerView.a)localObject1).e(0, ((RecyclerView.a)localObject2).getItemCount(), Integer.valueOf(2));
    AppMethodBeat.o(164826);
  }
  
  public final boolean c(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164830);
    k.h(paramMediaItem, "media");
    ac.i("MicroMsg.GalleryPickerFragment", "[onItemLongClick] media=" + paramMediaItem.toSimpleString());
    AppMethodBeat.o(164830);
    return true;
  }
  
  public final void d(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164833);
    k.h(paramMediaItem, "media");
    ac.i("MicroMsg.GalleryPickerFragment", "[onItemClick] media=" + paramMediaItem.toSimpleString());
    if ((this.rJC.size() >= 9) && (!this.rJC.contains(paramMediaItem)))
    {
      AppMethodBeat.o(164833);
      return;
    }
    e(paramMediaItem);
    Object localObject = this.sLw;
    if (localObject == null) {
      k.aVY("appBarLayout");
    }
    ((AppBarLayout)localObject).bx();
    localObject = this.sLu;
    if (localObject == null) {
      k.aVY("galleryView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramMediaItem = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164833);
      throw paramMediaItem;
    }
    RecyclerView.w localw = d.c((d)localObject, paramMediaItem.sKk);
    localObject = localw;
    if (!(localw instanceof com.tencent.mm.ui.base.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.ui.base.a.b)localObject;
    if ((localObject != null) && (!this.sLr.sLT.contains(paramMediaItem)) && (this.rJC.size() < 9)) {
      ((MediaItemView)((com.tencent.mm.ui.base.a.b)localObject).getView()).mw(true);
    }
    AppMethodBeat.o(164833);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(164827);
    super.onActivityCreated(paramBundle);
    paramBundle = e.sMF;
    e.BE();
    paramBundle = e.sMF;
    e.c((q)new i(this));
    paramBundle = e.sMF;
    e.c((m)new j(this));
    AppMethodBeat.o(164827);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(164829);
    k.h(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131494233, paramViewGroup, false);
    k.g(paramLayoutInflater, "view");
    paramViewGroup = paramLayoutInflater.findViewById(2131300343);
    k.g(paramViewGroup, "view.findViewById(R.id.gallery_view)");
    this.sLu = ((RecyclerView)paramViewGroup);
    paramViewGroup = paramLayoutInflater.findViewById(2131303393);
    k.g(paramViewGroup, "view.findViewById(R.id.preview_container)");
    this.sLv = ((MMMediaCropLayout)paramViewGroup);
    paramViewGroup = this.sLv;
    if (paramViewGroup == null) {
      k.aVY("previewContainer");
    }
    paramBundle = paramViewGroup.getLayoutParams();
    Object localObject = getResources();
    k.g(localObject, "resources");
    paramBundle.height = ((int)(((Resources)localObject).getDisplayMetrics().widthPixels * 3.5F / 3.0F));
    paramViewGroup.requestLayout();
    paramViewGroup.setOnClickListener((View.OnClickListener)new h(this));
    paramViewGroup = paramLayoutInflater.findViewById(2131302566);
    k.g(paramViewGroup, "view.findViewById(R.id.multi_selected_icon)");
    this.sLx = ((ImageView)paramViewGroup);
    paramViewGroup = this.sLx;
    if (paramViewGroup == null) {
      k.aVY("multiSelectedIcon");
    }
    paramViewGroup.setBackground(this.sLz);
    paramViewGroup = this.sLx;
    if (paramViewGroup == null) {
      k.aVY("multiSelectedIcon");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new f(this));
    paramViewGroup = this.sLx;
    if (paramViewGroup == null) {
      k.aVY("multiSelectedIcon");
    }
    paramViewGroup.setVisibility(8);
    getContext();
    paramViewGroup = new SpeedGirdLayoutManager();
    paramBundle = this.sLu;
    if (paramBundle == null) {
      k.aVY("galleryView");
    }
    paramBundle.setLayoutManager((RecyclerView.i)paramViewGroup);
    paramBundle = this.sLu;
    if (paramBundle == null) {
      k.aVY("galleryView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.sLr);
    paramBundle = this.sLu;
    if (paramBundle == null) {
      k.aVY("galleryView");
    }
    paramBundle.b((RecyclerView.h)new c(this));
    paramBundle = new GalleryPickerFragment.g();
    localObject = this.sLu;
    if (localObject == null) {
      k.aVY("galleryView");
    }
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)paramBundle);
    paramBundle = this.sLu;
    if (paramBundle == null) {
      k.aVY("galleryView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = new RecyclerView.n();
    paramBundle.aB(1, 80);
    paramBundle.aB(2, 60);
    localObject = this.sLu;
    if (localObject == null) {
      k.aVY("galleryView");
    }
    ((RecyclerView)localObject).setRecycledViewPool(paramBundle);
    paramViewGroup.aw(true);
    paramViewGroup.cb(30);
    this.sLr.sLQ = ((a.c)this);
    this.sLr.sLS = ((MediaItemView.b)this);
    this.sLr.sLR = ((a.d)this);
    paramLayoutInflater.findViewById(2131300183).setOnClickListener((View.OnClickListener)new GalleryPickerFragment.e(this, (ImageView)paramLayoutInflater.findViewById(2131296942)));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131300183);
    paramBundle = paramLayoutInflater.findViewById(2131296878);
    k.g(paramBundle, "view.findViewById(R.id.appbar_layout)");
    this.sLw = ((AppBarLayout)paramBundle);
    paramBundle = paramLayoutInflater.findViewById(2131300177);
    k.g(paramBundle, "view.findViewById(R.id.folder_chooser_view)");
    this.sLt = ((RecyclerView)paramBundle);
    paramBundle = this.sLt;
    if (paramBundle == null) {
      k.aVY("albumChooserView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramBundle = this.sLt;
    if (paramBundle == null) {
      k.aVY("albumChooserView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.sLt;
    if (paramBundle == null) {
      k.aVY("albumChooserView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.sLs);
    this.sLs.sLW = ((b.b)new d(this, paramViewGroup));
    AppMethodBeat.o(164829);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(164828);
    super.onDestroy();
    e locale = e.sMF;
    e.onRelease();
    AppMethodBeat.o(164828);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(164838);
    super.onPause();
    MMMediaCropLayout localMMMediaCropLayout = this.sLv;
    if (localMMMediaCropLayout == null) {
      k.aVY("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIPause();
    AppMethodBeat.o(164838);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(164837);
    super.onResume();
    MMMediaCropLayout localMMMediaCropLayout = this.sLv;
    if (localMMMediaCropLayout == null) {
      k.aVY("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIResume();
    AppMethodBeat.o(164837);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"})
  public static final class c
    extends RecyclerView.h
  {
    private final Paint paint;
    private final int sLF;
    
    c()
    {
      AppMethodBeat.i(164813);
      Context localContext = ai.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      this.sLF = localContext.getResources().getColor(2131101171);
      this.paint = new Paint();
      this.paint.setColor(this.sLF);
      this.paint.setStrokeWidth(6.4F);
      this.paint.setStyle(Paint.Style.STROKE);
      AppMethodBeat.o(164813);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(164811);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(paramt, "state");
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      int i = RecyclerView.bx(paramView);
      if (i % 4 == 0) {
        paramRect.left = 4;
      }
      paramRect.right = 4;
      paramRect.bottom = 4;
      if (i < 0)
      {
        AppMethodBeat.o(164811);
        return;
      }
      if (4 > i) {
        paramRect.top = 4;
      }
      AppMethodBeat.o(164811);
    }
    
    public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(164812);
      k.h(paramCanvas, "c");
      k.h(paramRecyclerView, "parent");
      k.h(paramt, "state");
      Object localObject = paramRecyclerView.ci(GalleryPickerFragment.g(this.sLG));
      if (localObject != null) {}
      for (localObject = ((RecyclerView.w)localObject).asD;; localObject = null)
      {
        if (localObject != null) {
          paramCanvas.drawRect(new Rect(((View)localObject).getLeft() + 2, ((View)localObject).getTop() + 2, ((View)localObject).getRight() - 2, ((View)localObject).getBottom() - 2), this.paint);
        }
        super.a(paramCanvas, paramRecyclerView, paramt);
        AppMethodBeat.o(164812);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initAlbumChooserView$1", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static final class d
    implements b.b
  {
    d(TextView paramTextView) {}
    
    public final void a(final GalleryItem.AlbumItem paramAlbumItem)
    {
      AppMethodBeat.i(164816);
      k.h(paramAlbumItem, "media");
      e locale = e.sMF;
      e.a(System.currentTimeMillis(), paramAlbumItem, (q)new a(this, paramAlbumItem));
      AppMethodBeat.o(164816);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, y>
    {
      a(GalleryPickerFragment.d paramd, GalleryItem.AlbumItem paramAlbumItem)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164818);
      paramView = this.sLG;
      if (!GalleryPickerFragment.d(this.sLG)) {}
      for (boolean bool = true;; bool = false)
      {
        GalleryPickerFragment.a(paramView, bool);
        AppMethodBeat.o(164818);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164820);
      GalleryPickerFragment.h(this.sLG).bx();
      AppMethodBeat.o(164820);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, y>
  {
    i(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "cost", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements m<LinkedList<GalleryItem.AlbumItem>, Long, y>
  {
    j(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(164825);
      if (GalleryPickerFragment.a(this.sLG).getItemCount() > 0)
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)GalleryPickerFragment.a(this.sLG).getItemAtPosition(0);
        GalleryPickerFragment localGalleryPickerFragment = this.sLG;
        k.g(localMediaItem, "media");
        GalleryPickerFragment.a(localGalleryPickerFragment, localMediaItem);
        ac.i("MicroMsg.GalleryPickerFragment", "[onShowDefaultItem] media=".concat(String.valueOf(localMediaItem)));
      }
      AppMethodBeat.o(164825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment
 * JD-Core Version:    0.7.0.1
 */