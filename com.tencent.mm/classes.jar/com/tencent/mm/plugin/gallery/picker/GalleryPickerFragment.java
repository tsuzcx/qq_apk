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
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.d;
import d.a.j;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", "listener", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroid/support/v7/widget/RecyclerView;", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", "previewImage", "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"})
@SuppressLint({"ValidFragment"})
public final class GalleryPickerFragment
  extends Fragment
  implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem>
{
  public static final a rCK;
  private ArrayList<GalleryItem.MediaItem> qOo;
  private RecyclerView rCA;
  private MMMediaCropLayout rCB;
  private AppBarLayout rCC;
  private ImageView rCD;
  private final Drawable rCE;
  private final Drawable rCF;
  private int rCG;
  private boolean rCH;
  private int rCI;
  private GalleryPickerFragment.b rCJ;
  private final a rCx;
  private final com.tencent.mm.plugin.gallery.picker.a.b rCy;
  private RecyclerView rCz;
  
  static
  {
    AppMethodBeat.i(164843);
    rCK = new a((byte)0);
    AppMethodBeat.o(164843);
  }
  
  public GalleryPickerFragment(ArrayList<GalleryItem.MediaItem> paramArrayList, GalleryPickerFragment.b paramb)
  {
    AppMethodBeat.i(164842);
    this.qOo = paramArrayList;
    this.rCJ = paramb;
    paramArrayList = f.rDX;
    this.rCx = new a(f.cAb(), this.qOo);
    paramArrayList = f.rDX;
    this.rCy = new com.tencent.mm.plugin.gallery.picker.a.b(f.cAb());
    paramArrayList = aj.getContext();
    k.g(paramArrayList, "MMApplicationContext.getContext()");
    this.rCE = paramArrayList.getResources().getDrawable(2131234015);
    paramArrayList = aj.getContext();
    k.g(paramArrayList, "MMApplicationContext.getContext()");
    this.rCF = paramArrayList.getResources().getDrawable(2131234014);
    this.rCG = 1;
    this.rCH = true;
    AppMethodBeat.o(164842);
  }
  
  private final void W(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(164841);
    ad.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + paramLong1 + " current=" + paramLong2);
    Object localObject1 = this.rCA;
    if (localObject1 == null) {
      k.aPZ("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = d.a((d)localObject1, paramLong2);
    Object localObject2;
    if (localObject1 != null)
    {
      this.rCI = ((RecyclerView.v)localObject1).ln();
      localObject2 = this.rCA;
      if (localObject2 == null) {
        k.aPZ("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null) {
        ((RecyclerView.a)localObject2).ck(((RecyclerView.v)localObject1).ln());
      }
    }
    localObject1 = this.rCA;
    if (localObject1 == null) {
      k.aPZ("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = d.a((d)localObject1, paramLong1);
    if (localObject1 != null)
    {
      localObject2 = this.rCA;
      if (localObject2 == null) {
        k.aPZ("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null)
      {
        ((RecyclerView.a)localObject2).ck(((RecyclerView.v)localObject1).ln());
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
    if (this.qOo.isEmpty())
    {
      localObject = this.rCB;
      if (localObject == null) {
        k.aPZ("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).rFb)
      {
        paramMediaItem = this.rCB;
        if (paramMediaItem == null) {
          k.aPZ("previewContainer");
        }
        MMMediaCropLayout.b(paramMediaItem);
        AppMethodBeat.o(164835);
        return;
      }
    }
    if (this.qOo.size() == 1)
    {
      localObject = this.rCB;
      if (localObject == null) {
        k.aPZ("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).rFb)
      {
        localObject = (GalleryItem.MediaItem)j.iy((List)this.qOo);
        if (paramBoolean)
        {
          if (paramMediaItem == null) {
            break label157;
          }
          if (paramMediaItem.rBs == ((GalleryItem.MediaItem)localObject).rBs)
          {
            paramMediaItem = this.rCB;
            if (paramMediaItem == null) {
              k.aPZ("previewContainer");
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
  
  private final void czY()
  {
    AppMethodBeat.i(164834);
    Iterator localIterator = ((Iterable)this.qOo).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (GalleryItem.MediaItem)localIterator.next();
      Object localObject2 = this.rCA;
      if (localObject2 == null) {
        k.aPZ("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
        AppMethodBeat.o(164834);
        throw ((Throwable)localObject1);
      }
      localObject2 = d.a((d)localObject2, ((GalleryItem.MediaItem)localObject1).rBs);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.ui.base.a.b)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.ui.base.a.b)localObject1;
      if (localObject1 != null) {
        this.rCx.b(((com.tencent.mm.ui.base.a.b)localObject1).ln(), Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(164834);
  }
  
  private final void d(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164836);
    MMMediaCropLayout localMMMediaCropLayout = this.rCB;
    if (localMMMediaCropLayout == null) {
      k.aPZ("previewContainer");
    }
    long l = localMMMediaCropLayout.getCurrentPreviewMediaId();
    if (this.qOo.size() == 2)
    {
      localMMMediaCropLayout = this.rCB;
      if (localMMMediaCropLayout == null) {
        k.aPZ("previewContainer");
      }
      if (!localMMMediaCropLayout.rFb)
      {
        localMMMediaCropLayout = this.rCB;
        if (localMMMediaCropLayout == null) {
          k.aPZ("previewContainer");
        }
        MMMediaCropLayout.a(localMMMediaCropLayout);
      }
    }
    a(paramMediaItem, true);
    if (paramMediaItem.getType() == 2) {
      f(paramMediaItem);
    }
    for (;;)
    {
      W(l, paramMediaItem.rBs);
      AppMethodBeat.o(164836);
      return;
      e(paramMediaItem);
    }
  }
  
  private final void e(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164839);
    if ((this.rCH) && (this.rCG != 1))
    {
      AppMethodBeat.o(164839);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.rCB;
    if (localMMMediaCropLayout == null) {
      k.aPZ("previewContainer");
    }
    MMMediaCropLayout.a(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164839);
  }
  
  private final void f(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164840);
    if ((this.rCH) && (this.rCG != 2))
    {
      AppMethodBeat.o(164840);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.rCB;
    if (localMMMediaCropLayout == null) {
      k.aPZ("previewContainer");
    }
    MMMediaCropLayout.b(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164840);
  }
  
  private final void lD(boolean paramBoolean)
  {
    AppMethodBeat.i(164826);
    this.rCH = paramBoolean;
    this.rCx.rCH = paramBoolean;
    ad.i("MicroMsg.GalleryPickerFragment", "isMultiSelectedMode=".concat(String.valueOf(paramBoolean)));
    ad.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
    Object localObject1 = this.rCA;
    if (localObject1 == null) {
      k.aPZ("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {
      k.fvU();
    }
    Object localObject2 = this.rCA;
    if (localObject2 == null) {
      k.aPZ("galleryView");
    }
    localObject2 = ((RecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      k.fvU();
    }
    k.g(localObject2, "galleryView.adapter!!");
    ((RecyclerView.a)localObject1).e(0, ((RecyclerView.a)localObject2).getItemCount(), Integer.valueOf(2));
    AppMethodBeat.o(164826);
  }
  
  public final boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164830);
    k.h(paramMediaItem, "media");
    ad.i("MicroMsg.GalleryPickerFragment", "[onItemLongClick] media=" + paramMediaItem.toSimpleString());
    AppMethodBeat.o(164830);
    return true;
  }
  
  public final void c(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164833);
    k.h(paramMediaItem, "media");
    ad.i("MicroMsg.GalleryPickerFragment", "[onItemClick] media=" + paramMediaItem.toSimpleString());
    if ((this.qOo.size() >= 9) && (!this.qOo.contains(paramMediaItem)))
    {
      AppMethodBeat.o(164833);
      return;
    }
    d(paramMediaItem);
    Object localObject = this.rCC;
    if (localObject == null) {
      k.aPZ("appBarLayout");
    }
    ((AppBarLayout)localObject).bq();
    localObject = this.rCA;
    if (localObject == null) {
      k.aPZ("galleryView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramMediaItem = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164833);
      throw paramMediaItem;
    }
    RecyclerView.v localv = d.a((d)localObject, paramMediaItem.rBs);
    localObject = localv;
    if (!(localv instanceof com.tencent.mm.ui.base.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.ui.base.a.b)localObject;
    if ((localObject != null) && (!this.rCx.rCZ.contains(paramMediaItem)) && (this.qOo.size() < 9)) {
      ((MediaItemView)((com.tencent.mm.ui.base.a.b)localObject).getView()).lE(true);
    }
    AppMethodBeat.o(164833);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(164827);
    super.onActivityCreated(paramBundle);
    paramBundle = e.rDN;
    e.Ca();
    paramBundle = e.rDN;
    e.b((q)new i(this));
    paramBundle = e.rDN;
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
    this.rCA = ((RecyclerView)paramViewGroup);
    paramViewGroup = paramLayoutInflater.findViewById(2131303393);
    k.g(paramViewGroup, "view.findViewById(R.id.preview_container)");
    this.rCB = ((MMMediaCropLayout)paramViewGroup);
    paramViewGroup = this.rCB;
    if (paramViewGroup == null) {
      k.aPZ("previewContainer");
    }
    paramBundle = paramViewGroup.getLayoutParams();
    Object localObject = getResources();
    k.g(localObject, "resources");
    paramBundle.height = ((int)(((Resources)localObject).getDisplayMetrics().widthPixels * 3.5F / 3.0F));
    paramViewGroup.requestLayout();
    paramViewGroup.setOnClickListener((View.OnClickListener)new h(this));
    paramViewGroup = paramLayoutInflater.findViewById(2131302566);
    k.g(paramViewGroup, "view.findViewById(R.id.multi_selected_icon)");
    this.rCD = ((ImageView)paramViewGroup);
    paramViewGroup = this.rCD;
    if (paramViewGroup == null) {
      k.aPZ("multiSelectedIcon");
    }
    paramViewGroup.setBackground(this.rCF);
    paramViewGroup = this.rCD;
    if (paramViewGroup == null) {
      k.aPZ("multiSelectedIcon");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new f(this));
    paramViewGroup = this.rCD;
    if (paramViewGroup == null) {
      k.aPZ("multiSelectedIcon");
    }
    paramViewGroup.setVisibility(8);
    getContext();
    paramViewGroup = new SpeedGirdLayoutManager();
    paramBundle = this.rCA;
    if (paramBundle == null) {
      k.aPZ("galleryView");
    }
    paramBundle.setLayoutManager((RecyclerView.i)paramViewGroup);
    paramBundle = this.rCA;
    if (paramBundle == null) {
      k.aPZ("galleryView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.rCx);
    paramBundle = this.rCA;
    if (paramBundle == null) {
      k.aPZ("galleryView");
    }
    paramBundle.b((RecyclerView.h)new c(this));
    paramBundle = new g();
    localObject = this.rCA;
    if (localObject == null) {
      k.aPZ("galleryView");
    }
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)paramBundle);
    paramBundle = this.rCA;
    if (paramBundle == null) {
      k.aPZ("galleryView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = new RecyclerView.n();
    paramBundle.aB(1, 80);
    paramBundle.aB(2, 60);
    localObject = this.rCA;
    if (localObject == null) {
      k.aPZ("galleryView");
    }
    ((RecyclerView)localObject).setRecycledViewPool(paramBundle);
    paramViewGroup.aw(true);
    paramViewGroup.cb(30);
    this.rCx.rCW = ((a.c)this);
    this.rCx.rCY = ((MediaItemView.b)this);
    this.rCx.rCX = ((a.d)this);
    paramLayoutInflater.findViewById(2131300183).setOnClickListener((View.OnClickListener)new e(this, (ImageView)paramLayoutInflater.findViewById(2131296942)));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131300183);
    paramBundle = paramLayoutInflater.findViewById(2131296878);
    k.g(paramBundle, "view.findViewById(R.id.appbar_layout)");
    this.rCC = ((AppBarLayout)paramBundle);
    paramBundle = paramLayoutInflater.findViewById(2131300177);
    k.g(paramBundle, "view.findViewById(R.id.folder_chooser_view)");
    this.rCz = ((RecyclerView)paramBundle);
    paramBundle = this.rCz;
    if (paramBundle == null) {
      k.aPZ("albumChooserView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramBundle = this.rCz;
    if (paramBundle == null) {
      k.aPZ("albumChooserView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.rCz;
    if (paramBundle == null) {
      k.aPZ("albumChooserView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.rCy);
    this.rCy.rDd = ((b.b)new d(this, paramViewGroup));
    AppMethodBeat.o(164829);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(164828);
    super.onDestroy();
    e locale = e.rDN;
    e.onRelease();
    AppMethodBeat.o(164828);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(164838);
    super.onPause();
    MMMediaCropLayout localMMMediaCropLayout = this.rCB;
    if (localMMMediaCropLayout == null) {
      k.aPZ("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIPause();
    AppMethodBeat.o(164838);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(164837);
    super.onResume();
    MMMediaCropLayout localMMMediaCropLayout = this.rCB;
    if (localMMMediaCropLayout == null) {
      k.aPZ("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIResume();
    AppMethodBeat.o(164837);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$Companion;", "", "()V", "LIMIT_SELECTED_COUNT", "", "MARGIN_GRID", "ROW_ITEM_COUNT", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"})
  public static final class c
    extends RecyclerView.h
  {
    private final Paint paint;
    private final int rCL;
    
    c()
    {
      AppMethodBeat.i(164813);
      Context localContext = aj.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      this.rCL = localContext.getResources().getColor(2131101171);
      this.paint = new Paint();
      this.paint.setColor(this.rCL);
      this.paint.setStrokeWidth(6.4F);
      this.paint.setStyle(Paint.Style.STROKE);
      AppMethodBeat.o(164813);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(164811);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
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
    
    public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(164812);
      k.h(paramCanvas, "c");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
      Object localObject = paramRecyclerView.cj(GalleryPickerFragment.g(this.rCM));
      if (localObject != null) {}
      for (localObject = ((RecyclerView.v)localObject).arI;; localObject = null)
      {
        if (localObject != null) {
          paramCanvas.drawRect(new Rect(((View)localObject).getLeft() + 2, ((View)localObject).getTop() + 2, ((View)localObject).getRight() - 2, ((View)localObject).getBottom() - 2), this.paint);
        }
        super.a(paramCanvas, paramRecyclerView, params);
        AppMethodBeat.o(164812);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initAlbumChooserView$1", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static final class d
    implements b.b
  {
    d(TextView paramTextView) {}
    
    public final void a(final GalleryItem.AlbumItem paramAlbumItem)
    {
      AppMethodBeat.i(164816);
      k.h(paramAlbumItem, "media");
      e locale = e.rDN;
      e.a(System.currentTimeMillis(), paramAlbumItem, (q)new a(this, paramAlbumItem));
      AppMethodBeat.o(164816);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(GalleryPickerFragment paramGalleryPickerFragment, ImageView paramImageView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164817);
      if (GalleryPickerFragment.e(this.rCM).getVisibility() == 0)
      {
        GalleryPickerFragment.e(this.rCM).setVisibility(8);
        GalleryPickerFragment.f(this.rCM).setVisibility(0);
        paramView = this.rCS;
        localContext1 = this.rCM.getContext();
        localContext2 = this.rCM.getContext();
        if (localContext2 == null) {
          k.fvU();
        }
        k.g(localContext2, "context!!");
        paramView.setImageDrawable(am.i(localContext1, 2131689710, localContext2.getResources().getColor(2131100021)));
        AppMethodBeat.o(164817);
        return;
      }
      GalleryPickerFragment.e(this.rCM).setVisibility(0);
      GalleryPickerFragment.f(this.rCM).setVisibility(8);
      paramView = this.rCS;
      Context localContext1 = this.rCM.getContext();
      Context localContext2 = this.rCM.getContext();
      if (localContext2 == null) {
        k.fvU();
      }
      k.g(localContext2, "context!!");
      paramView.setImageDrawable(am.i(localContext1, 2131689707, localContext2.getResources().getColor(2131100021)));
      AppMethodBeat.o(164817);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164818);
      paramView = this.rCM;
      if (!GalleryPickerFragment.d(this.rCM)) {}
      for (boolean bool = true;; bool = false)
      {
        GalleryPickerFragment.a(paramView, bool);
        AppMethodBeat.o(164818);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$animator$1", "Landroid/support/v7/widget/DefaultItemAnimator;", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-gallery_release"})
  public static final class g
    extends android.support.v7.widget.v
  {
    public final boolean p(RecyclerView.v paramv)
    {
      AppMethodBeat.i(164819);
      k.h(paramv, "viewHolder");
      AppMethodBeat.o(164819);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164820);
      GalleryPickerFragment.h(this.rCM).bq();
      AppMethodBeat.o(164820);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, y>
  {
    i(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "cost", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements m<LinkedList<GalleryItem.AlbumItem>, Long, y>
  {
    j(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(164825);
      if (GalleryPickerFragment.a(this.rCM).getItemCount() > 0)
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)GalleryPickerFragment.a(this.rCM).getItemAtPosition(0);
        GalleryPickerFragment localGalleryPickerFragment = this.rCM;
        k.g(localMediaItem, "media");
        GalleryPickerFragment.a(localGalleryPickerFragment, localMediaItem);
        ad.i("MicroMsg.GalleryPickerFragment", "[onShowDefaultItem] media=".concat(String.valueOf(localMediaItem)));
      }
      AppMethodBeat.o(164825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment
 * JD-Core Version:    0.7.0.1
 */