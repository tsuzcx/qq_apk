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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.a.a.c;
import com.tencent.mm.plugin.gallery.picker.a.a.d;
import com.tencent.mm.plugin.gallery.picker.c.e;
import com.tencent.mm.plugin.gallery.picker.c.f;
import com.tencent.mm.plugin.gallery.picker.manager.SpeedGirdLayoutManager;
import com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", "listener", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroidx/recyclerview/widget/RecyclerView;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", "previewImage", "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"})
@SuppressLint({"ValidFragment"})
public final class GalleryPickerFragment
  extends Fragment
  implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem>
{
  public static final a BWJ;
  private ArrayList<GalleryItem.MediaItem> AtC;
  private MMMediaCropLayout BWA;
  private AppBarLayout BWB;
  private ImageView BWC;
  private final Drawable BWD;
  private final Drawable BWE;
  private int BWF;
  private boolean BWG;
  private int BWH;
  private b BWI;
  private final com.tencent.mm.plugin.gallery.picker.a.a BWw;
  private final com.tencent.mm.plugin.gallery.picker.a.b BWx;
  private RecyclerView BWy;
  private RecyclerView BWz;
  
  static
  {
    AppMethodBeat.i(164843);
    BWJ = new a((byte)0);
    AppMethodBeat.o(164843);
  }
  
  public GalleryPickerFragment(ArrayList<GalleryItem.MediaItem> paramArrayList, b paramb)
  {
    AppMethodBeat.i(164842);
    this.AtC = paramArrayList;
    this.BWI = paramb;
    paramArrayList = f.BXU;
    this.BWw = new com.tencent.mm.plugin.gallery.picker.a.a(f.euf(), this.AtC);
    paramArrayList = f.BXU;
    this.BWx = new com.tencent.mm.plugin.gallery.picker.a.b(f.euf());
    paramArrayList = MMApplicationContext.getContext();
    p.j(paramArrayList, "MMApplicationContext.getContext()");
    this.BWD = paramArrayList.getResources().getDrawable(b.d.shape_multi_item_green);
    paramArrayList = MMApplicationContext.getContext();
    p.j(paramArrayList, "MMApplicationContext.getContext()");
    this.BWE = paramArrayList.getResources().getDrawable(b.d.shape_multi_item_black);
    this.BWF = 1;
    this.BWG = true;
    AppMethodBeat.o(164842);
  }
  
  private final void a(GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(164835);
    Object localObject;
    if (this.AtC.isEmpty())
    {
      localObject = this.BWA;
      if (localObject == null) {
        p.bGy("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).BYW)
      {
        paramMediaItem = this.BWA;
        if (paramMediaItem == null) {
          p.bGy("previewContainer");
        }
        MMMediaCropLayout.b(paramMediaItem);
        AppMethodBeat.o(164835);
        return;
      }
    }
    if (this.AtC.size() == 1)
    {
      localObject = this.BWA;
      if (localObject == null) {
        p.bGy("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).BYW)
      {
        localObject = (GalleryItem.MediaItem)j.lo((List)this.AtC);
        if (paramBoolean)
        {
          if (paramMediaItem == null) {
            break label157;
          }
          if (paramMediaItem.BVl == ((GalleryItem.MediaItem)localObject).BVl)
          {
            paramMediaItem = this.BWA;
            if (paramMediaItem == null) {
              p.bGy("previewContainer");
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
  
  private final void ae(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(164841);
    Log.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + paramLong1 + " current=" + paramLong2);
    Object localObject1 = this.BWz;
    if (localObject1 == null) {
      p.bGy("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = h.c((h)localObject1, paramLong2);
    Object localObject2;
    if (localObject1 != null)
    {
      this.BWH = ((RecyclerView.v)localObject1).md();
      localObject2 = this.BWz;
      if (localObject2 == null) {
        p.bGy("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null) {
        ((RecyclerView.a)localObject2).cL(((RecyclerView.v)localObject1).md());
      }
    }
    localObject1 = this.BWz;
    if (localObject1 == null) {
      p.bGy("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = h.c((h)localObject1, paramLong1);
    if (localObject1 != null)
    {
      localObject2 = this.BWz;
      if (localObject2 == null) {
        p.bGy("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null)
      {
        ((RecyclerView.a)localObject2).cL(((RecyclerView.v)localObject1).md());
        AppMethodBeat.o(164841);
        return;
      }
    }
    AppMethodBeat.o(164841);
  }
  
  private final void euc()
  {
    AppMethodBeat.i(164834);
    Iterator localIterator = ((Iterable)this.AtC).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (GalleryItem.MediaItem)localIterator.next();
      Object localObject2 = this.BWz;
      if (localObject2 == null) {
        p.bGy("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
        AppMethodBeat.o(164834);
        throw ((Throwable)localObject1);
      }
      localObject2 = h.c((h)localObject2, ((GalleryItem.MediaItem)localObject1).BVl);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.ui.base.a.b)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.ui.base.a.b)localObject1;
      if (localObject1 != null) {
        this.BWw.d(((com.tencent.mm.ui.base.a.b)localObject1).md(), Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(164834);
  }
  
  private final void g(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164836);
    MMMediaCropLayout localMMMediaCropLayout = this.BWA;
    if (localMMMediaCropLayout == null) {
      p.bGy("previewContainer");
    }
    long l = localMMMediaCropLayout.getCurrentPreviewMediaId();
    if (this.AtC.size() == 2)
    {
      localMMMediaCropLayout = this.BWA;
      if (localMMMediaCropLayout == null) {
        p.bGy("previewContainer");
      }
      if (!localMMMediaCropLayout.BYW)
      {
        localMMMediaCropLayout = this.BWA;
        if (localMMMediaCropLayout == null) {
          p.bGy("previewContainer");
        }
        MMMediaCropLayout.a(localMMMediaCropLayout);
      }
    }
    a(paramMediaItem, true);
    if (paramMediaItem.getType() == 2) {
      i(paramMediaItem);
    }
    for (;;)
    {
      ae(l, paramMediaItem.BVl);
      AppMethodBeat.o(164836);
      return;
      h(paramMediaItem);
    }
  }
  
  private final void h(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164839);
    if ((this.BWG) && (this.BWF != 1))
    {
      AppMethodBeat.o(164839);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.BWA;
    if (localMMMediaCropLayout == null) {
      p.bGy("previewContainer");
    }
    MMMediaCropLayout.a(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164839);
  }
  
  private final void i(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164840);
    if ((this.BWG) && (this.BWF != 2))
    {
      AppMethodBeat.o(164840);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.BWA;
    if (localMMMediaCropLayout == null) {
      p.bGy("previewContainer");
    }
    MMMediaCropLayout.b(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164840);
  }
  
  private final void rS(boolean paramBoolean)
  {
    AppMethodBeat.i(164826);
    this.BWG = paramBoolean;
    this.BWw.BWG = paramBoolean;
    Log.i("MicroMsg.GalleryPickerFragment", "isMultiSelectedMode=".concat(String.valueOf(paramBoolean)));
    Log.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
    Object localObject1 = this.BWz;
    if (localObject1 == null) {
      p.bGy("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {
      p.iCn();
    }
    Object localObject2 = this.BWz;
    if (localObject2 == null) {
      p.bGy("galleryView");
    }
    localObject2 = ((RecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.iCn();
    }
    p.j(localObject2, "galleryView.adapter!!");
    ((RecyclerView.a)localObject1).e(0, ((RecyclerView.a)localObject2).getItemCount(), Integer.valueOf(2));
    AppMethodBeat.o(164826);
  }
  
  public final boolean e(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164830);
    p.k(paramMediaItem, "media");
    Log.i("MicroMsg.GalleryPickerFragment", "[onItemLongClick] media=" + paramMediaItem.toSimpleString());
    AppMethodBeat.o(164830);
    return true;
  }
  
  public final void f(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164833);
    p.k(paramMediaItem, "media");
    Log.i("MicroMsg.GalleryPickerFragment", "[onItemClick] media=" + paramMediaItem.toSimpleString());
    if ((this.AtC.size() >= 9) && (!this.AtC.contains(paramMediaItem)))
    {
      AppMethodBeat.o(164833);
      return;
    }
    g(paramMediaItem);
    Object localObject = this.BWB;
    if (localObject == null) {
      p.bGy("appBarLayout");
    }
    ((AppBarLayout)localObject).h(true, true);
    localObject = this.BWz;
    if (localObject == null) {
      p.bGy("galleryView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramMediaItem = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164833);
      throw paramMediaItem;
    }
    RecyclerView.v localv = h.c((h)localObject, paramMediaItem.BVl);
    localObject = localv;
    if (!(localv instanceof com.tencent.mm.ui.base.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.ui.base.a.b)localObject;
    if ((localObject != null) && (!this.BWw.BWY.contains(paramMediaItem)) && (this.AtC.size() < 9)) {
      ((MediaItemView)((com.tencent.mm.ui.base.a.b)localObject).getView()).rT(true);
    }
    AppMethodBeat.o(164833);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(164827);
    super.onActivityCreated(paramBundle);
    paramBundle = e.BXL;
    e.Pu();
    e.a(e.BXL, (kotlin.g.a.q)new i(this));
    paramBundle = e.BXL;
    e.f((m)new j(this));
    AppMethodBeat.o(164827);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(164829);
    p.k(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(b.f.gallery_picker_view, paramViewGroup, false);
    p.j(paramLayoutInflater, "view");
    paramViewGroup = paramLayoutInflater.findViewById(b.e.gallery_view);
    p.j(paramViewGroup, "view.findViewById(R.id.gallery_view)");
    this.BWz = ((RecyclerView)paramViewGroup);
    paramViewGroup = paramLayoutInflater.findViewById(b.e.preview_container);
    p.j(paramViewGroup, "view.findViewById(R.id.preview_container)");
    this.BWA = ((MMMediaCropLayout)paramViewGroup);
    paramViewGroup = this.BWA;
    if (paramViewGroup == null) {
      p.bGy("previewContainer");
    }
    paramBundle = paramViewGroup.getLayoutParams();
    Object localObject = getResources();
    p.j(localObject, "resources");
    paramBundle.height = ((int)(((Resources)localObject).getDisplayMetrics().widthPixels * 3.5F / 3.0F));
    paramViewGroup.requestLayout();
    paramViewGroup.setOnClickListener((View.OnClickListener)new h(this));
    paramViewGroup = paramLayoutInflater.findViewById(b.e.multi_selected_icon);
    p.j(paramViewGroup, "view.findViewById(R.id.multi_selected_icon)");
    this.BWC = ((ImageView)paramViewGroup);
    paramViewGroup = this.BWC;
    if (paramViewGroup == null) {
      p.bGy("multiSelectedIcon");
    }
    paramViewGroup.setBackground(this.BWE);
    paramViewGroup = this.BWC;
    if (paramViewGroup == null) {
      p.bGy("multiSelectedIcon");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new f(this));
    paramViewGroup = this.BWC;
    if (paramViewGroup == null) {
      p.bGy("multiSelectedIcon");
    }
    paramViewGroup.setVisibility(8);
    paramViewGroup = new SpeedGirdLayoutManager(getContext());
    paramBundle = this.BWz;
    if (paramBundle == null) {
      p.bGy("galleryView");
    }
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)paramViewGroup);
    paramBundle = this.BWz;
    if (paramBundle == null) {
      p.bGy("galleryView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.BWw);
    paramBundle = this.BWz;
    if (paramBundle == null) {
      p.bGy("galleryView");
    }
    paramBundle.b((RecyclerView.h)new c(this));
    paramBundle = new g();
    localObject = this.BWz;
    if (localObject == null) {
      p.bGy("galleryView");
    }
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)paramBundle);
    paramBundle = this.BWz;
    if (paramBundle == null) {
      p.bGy("galleryView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = new RecyclerView.m();
    paramBundle.aJ(1, 80);
    paramBundle.aJ(2, 60);
    localObject = this.BWz;
    if (localObject == null) {
      p.bGy("galleryView");
    }
    ((RecyclerView)localObject).setRecycledViewPool(paramBundle);
    paramViewGroup.setItemPrefetchEnabled(true);
    paramViewGroup.cC(30);
    this.BWw.BWV = ((a.c)this);
    this.BWw.BWX = ((MediaItemView.b)this);
    this.BWw.BWW = ((a.d)this);
    paramLayoutInflater.findViewById(b.e.folder_name_tv).setOnClickListener((View.OnClickListener)new e(this, (ImageView)paramLayoutInflater.findViewById(b.e.arrow_iv)));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(b.e.folder_name_tv);
    paramBundle = paramLayoutInflater.findViewById(b.e.appbar_layout);
    p.j(paramBundle, "view.findViewById(R.id.appbar_layout)");
    this.BWB = ((AppBarLayout)paramBundle);
    paramBundle = paramLayoutInflater.findViewById(b.e.folder_chooser_view);
    p.j(paramBundle, "view.findViewById(R.id.folder_chooser_view)");
    this.BWy = ((RecyclerView)paramBundle);
    paramBundle = this.BWy;
    if (paramBundle == null) {
      p.bGy("albumChooserView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle = this.BWy;
    if (paramBundle == null) {
      p.bGy("albumChooserView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.BWy;
    if (paramBundle == null) {
      p.bGy("albumChooserView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.BWx);
    this.BWx.BXb = ((com.tencent.mm.plugin.gallery.picker.a.b.b)new d(this, paramViewGroup));
    AppMethodBeat.o(164829);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(164828);
    super.onDestroy();
    e locale = e.BXL;
    e.onRelease();
    AppMethodBeat.o(164828);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(164838);
    super.onPause();
    MMMediaCropLayout localMMMediaCropLayout = this.BWA;
    if (localMMMediaCropLayout == null) {
      p.bGy("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIPause();
    AppMethodBeat.o(164838);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(164837);
    super.onResume();
    MMMediaCropLayout localMMMediaCropLayout = this.BWA;
    if (localMMMediaCropLayout == null) {
      p.bGy("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIResume();
    AppMethodBeat.o(164837);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$Companion;", "", "()V", "LIMIT_SELECTED_COUNT", "", "MARGIN_GRID", "ROW_ITEM_COUNT", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "", "onChange", "", "size", "", "plugin-gallery_release"})
  public static abstract interface b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"})
  public static final class c
    extends RecyclerView.h
  {
    private final int BWK;
    private final Paint paint;
    
    c()
    {
      AppMethodBeat.i(164813);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      this.BWK = localContext.getResources().getColor(com.tencent.mm.plugin.gallery.b.b.wechat_green);
      this.paint = new Paint();
      this.paint.setColor(this.BWK);
      this.paint.setStrokeWidth(6.4F);
      this.paint.setStyle(Paint.Style.STROKE);
      AppMethodBeat.o(164813);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(240953);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int i = RecyclerView.bi(paramView);
      if (i % 4 == 0) {
        paramRect.left = 4;
      }
      paramRect.right = 4;
      paramRect.bottom = 4;
      if (i < 0)
      {
        AppMethodBeat.o(240953);
        return;
      }
      if (4 > i) {
        paramRect.top = 4;
      }
      AppMethodBeat.o(240953);
    }
    
    public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(240954);
      p.k(paramCanvas, "c");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      Object localObject = paramRecyclerView.cK(GalleryPickerFragment.g(this.BWL));
      if (localObject != null) {}
      for (localObject = ((RecyclerView.v)localObject).amk;; localObject = null)
      {
        if (localObject != null) {
          paramCanvas.drawRect(new Rect(((View)localObject).getLeft() + 2, ((View)localObject).getTop() + 2, ((View)localObject).getRight() - 2, ((View)localObject).getBottom() - 2), this.paint);
        }
        super.a(paramCanvas, paramRecyclerView, params);
        AppMethodBeat.o(240954);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initAlbumChooserView$1", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static final class d
    implements com.tencent.mm.plugin.gallery.picker.a.b.b
  {
    d(TextView paramTextView) {}
    
    public final void a(final GalleryItem.AlbumItem paramAlbumItem)
    {
      AppMethodBeat.i(164816);
      p.k(paramAlbumItem, "media");
      e locale = e.BXL;
      e.a(System.currentTimeMillis(), paramAlbumItem, (kotlin.g.a.q)new a(this, paramAlbumItem));
      AppMethodBeat.o(164816);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, x>
    {
      a(GalleryPickerFragment.d paramd, GalleryItem.AlbumItem paramAlbumItem)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(GalleryPickerFragment paramGalleryPickerFragment, ImageView paramImageView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164817);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      int i;
      Context localContext;
      if (GalleryPickerFragment.e(this.BWL).getVisibility() == 0)
      {
        GalleryPickerFragment.e(this.BWL).setVisibility(8);
        GalleryPickerFragment.f(this.BWL).setVisibility(0);
        paramView = this.BWR;
        localObject = this.BWL.getContext();
        i = b.h.arrow_up;
        localContext = this.BWL.getContext();
        if (localContext == null) {
          p.iCn();
        }
        p.j(localContext, "context!!");
        paramView.setImageDrawable(au.o((Context)localObject, i, localContext.getResources().getColor(com.tencent.mm.plugin.gallery.b.b.black_text_color)));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164817);
        return;
        GalleryPickerFragment.e(this.BWL).setVisibility(0);
        GalleryPickerFragment.f(this.BWL).setVisibility(8);
        paramView = this.BWR;
        localObject = this.BWL.getContext();
        i = b.h.arrow_down;
        localContext = this.BWL.getContext();
        if (localContext == null) {
          p.iCn();
        }
        p.j(localContext, "context!!");
        paramView.setImageDrawable(au.o((Context)localObject, i, localContext.getResources().getColor(com.tencent.mm.plugin.gallery.b.b.black_text_color)));
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164818);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.BWL;
      if (!GalleryPickerFragment.d(this.BWL)) {}
      for (boolean bool = true;; bool = false)
      {
        GalleryPickerFragment.a(paramView, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164818);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$animator$1", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-gallery_release"})
  public static final class g
    extends g
  {
    public final boolean s(RecyclerView.v paramv)
    {
      AppMethodBeat.i(241365);
      p.k(paramv, "viewHolder");
      AppMethodBeat.o(241365);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164820);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      GalleryPickerFragment.h(this.BWL).h(true, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164820);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, x>
  {
    i(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "cost", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements m<LinkedList<GalleryItem.AlbumItem>, Long, x>
  {
    j(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(164825);
      if (GalleryPickerFragment.a(this.BWL).getItemCount() > 0)
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)GalleryPickerFragment.a(this.BWL).auB(0);
        GalleryPickerFragment localGalleryPickerFragment = this.BWL;
        p.j(localMediaItem, "media");
        GalleryPickerFragment.a(localGalleryPickerFragment, localMediaItem);
        Log.i("MicroMsg.GalleryPickerFragment", "[onShowDefaultItem] media=".concat(String.valueOf(localMediaItem)));
      }
      AppMethodBeat.o(164825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment
 * JD-Core Version:    0.7.0.1
 */