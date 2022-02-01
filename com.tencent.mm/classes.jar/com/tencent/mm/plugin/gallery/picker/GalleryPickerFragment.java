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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.v;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.g;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", "listener", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroid/support/v7/widget/RecyclerView;", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", "previewImage", "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"})
@SuppressLint({"ValidFragment"})
public final class GalleryPickerFragment
  extends Fragment
  implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem>
{
  public static final a xkp;
  private ArrayList<GalleryItem.MediaItem> vML;
  private final com.tencent.mm.plugin.gallery.picker.a.a xkc;
  private final com.tencent.mm.plugin.gallery.picker.a.b xkd;
  private RecyclerView xke;
  private RecyclerView xkf;
  private MMMediaCropLayout xkg;
  private AppBarLayout xkh;
  private ImageView xki;
  private final Drawable xkj;
  private final Drawable xkk;
  private int xkl;
  private boolean xkm;
  private int xkn;
  private b xko;
  
  static
  {
    AppMethodBeat.i(164843);
    xkp = new a((byte)0);
    AppMethodBeat.o(164843);
  }
  
  public GalleryPickerFragment(ArrayList<GalleryItem.MediaItem> paramArrayList, b paramb)
  {
    AppMethodBeat.i(164842);
    this.vML = paramArrayList;
    this.xko = paramb;
    paramArrayList = f.xlA;
    this.xkc = new com.tencent.mm.plugin.gallery.picker.a.a(f.dRD(), this.vML);
    paramArrayList = f.xlA;
    this.xkd = new com.tencent.mm.plugin.gallery.picker.a.b(f.dRD());
    paramArrayList = MMApplicationContext.getContext();
    p.g(paramArrayList, "MMApplicationContext.getContext()");
    this.xkj = paramArrayList.getResources().getDrawable(2131234852);
    paramArrayList = MMApplicationContext.getContext();
    p.g(paramArrayList, "MMApplicationContext.getContext()");
    this.xkk = paramArrayList.getResources().getDrawable(2131234851);
    this.xkl = 1;
    this.xkm = true;
    AppMethodBeat.o(164842);
  }
  
  private final void X(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(164841);
    Log.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + paramLong1 + " current=" + paramLong2);
    Object localObject1 = this.xkf;
    if (localObject1 == null) {
      p.btv("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = g.c((g)localObject1, paramLong2);
    Object localObject2;
    if (localObject1 != null)
    {
      this.xkn = ((RecyclerView.v)localObject1).lR();
      localObject2 = this.xkf;
      if (localObject2 == null) {
        p.btv("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null) {
        ((RecyclerView.a)localObject2).ci(((RecyclerView.v)localObject1).lR());
      }
    }
    localObject1 = this.xkf;
    if (localObject1 == null) {
      p.btv("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = g.c((g)localObject1, paramLong1);
    if (localObject1 != null)
    {
      localObject2 = this.xkf;
      if (localObject2 == null) {
        p.btv("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null)
      {
        ((RecyclerView.a)localObject2).ci(((RecyclerView.v)localObject1).lR());
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
    if (this.vML.isEmpty())
    {
      localObject = this.xkg;
      if (localObject == null) {
        p.btv("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).xmE)
      {
        paramMediaItem = this.xkg;
        if (paramMediaItem == null) {
          p.btv("previewContainer");
        }
        MMMediaCropLayout.b(paramMediaItem);
        AppMethodBeat.o(164835);
        return;
      }
    }
    if (this.vML.size() == 1)
    {
      localObject = this.xkg;
      if (localObject == null) {
        p.btv("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).xmE)
      {
        localObject = (GalleryItem.MediaItem)j.ks((List)this.vML);
        if (paramBoolean)
        {
          if (paramMediaItem == null) {
            break label157;
          }
          if (paramMediaItem.xiZ == ((GalleryItem.MediaItem)localObject).xiZ)
          {
            paramMediaItem = this.xkg;
            if (paramMediaItem == null) {
              p.btv("previewContainer");
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
  
  private final void dRA()
  {
    AppMethodBeat.i(164834);
    Iterator localIterator = ((Iterable)this.vML).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (GalleryItem.MediaItem)localIterator.next();
      Object localObject2 = this.xkf;
      if (localObject2 == null) {
        p.btv("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
        AppMethodBeat.o(164834);
        throw ((Throwable)localObject1);
      }
      localObject2 = g.c((g)localObject2, ((GalleryItem.MediaItem)localObject1).xiZ);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.ui.base.a.b)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.ui.base.a.b)localObject1;
      if (localObject1 != null) {
        this.xkc.b(((com.tencent.mm.ui.base.a.b)localObject1).lR(), Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(164834);
  }
  
  private final void f(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164836);
    MMMediaCropLayout localMMMediaCropLayout = this.xkg;
    if (localMMMediaCropLayout == null) {
      p.btv("previewContainer");
    }
    long l = localMMMediaCropLayout.getCurrentPreviewMediaId();
    if (this.vML.size() == 2)
    {
      localMMMediaCropLayout = this.xkg;
      if (localMMMediaCropLayout == null) {
        p.btv("previewContainer");
      }
      if (!localMMMediaCropLayout.xmE)
      {
        localMMMediaCropLayout = this.xkg;
        if (localMMMediaCropLayout == null) {
          p.btv("previewContainer");
        }
        MMMediaCropLayout.a(localMMMediaCropLayout);
      }
    }
    a(paramMediaItem, true);
    if (paramMediaItem.getType() == 2) {
      h(paramMediaItem);
    }
    for (;;)
    {
      X(l, paramMediaItem.xiZ);
      AppMethodBeat.o(164836);
      return;
      g(paramMediaItem);
    }
  }
  
  private final void g(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164839);
    if ((this.xkm) && (this.xkl != 1))
    {
      AppMethodBeat.o(164839);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.xkg;
    if (localMMMediaCropLayout == null) {
      p.btv("previewContainer");
    }
    MMMediaCropLayout.a(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164839);
  }
  
  private final void h(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164840);
    if ((this.xkm) && (this.xkl != 2))
    {
      AppMethodBeat.o(164840);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.xkg;
    if (localMMMediaCropLayout == null) {
      p.btv("previewContainer");
    }
    MMMediaCropLayout.b(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164840);
  }
  
  private final void px(boolean paramBoolean)
  {
    AppMethodBeat.i(164826);
    this.xkm = paramBoolean;
    this.xkc.xkm = paramBoolean;
    Log.i("MicroMsg.GalleryPickerFragment", "isMultiSelectedMode=".concat(String.valueOf(paramBoolean)));
    Log.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
    Object localObject1 = this.xkf;
    if (localObject1 == null) {
      p.btv("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {
      p.hyc();
    }
    Object localObject2 = this.xkf;
    if (localObject2 == null) {
      p.btv("galleryView");
    }
    localObject2 = ((RecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.hyc();
    }
    p.g(localObject2, "galleryView.adapter!!");
    ((RecyclerView.a)localObject1).e(0, ((RecyclerView.a)localObject2).getItemCount(), Integer.valueOf(2));
    AppMethodBeat.o(164826);
  }
  
  public final boolean d(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164830);
    p.h(paramMediaItem, "media");
    Log.i("MicroMsg.GalleryPickerFragment", "[onItemLongClick] media=" + paramMediaItem.toSimpleString());
    AppMethodBeat.o(164830);
    return true;
  }
  
  public final void e(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164833);
    p.h(paramMediaItem, "media");
    Log.i("MicroMsg.GalleryPickerFragment", "[onItemClick] media=" + paramMediaItem.toSimpleString());
    if ((this.vML.size() >= 9) && (!this.vML.contains(paramMediaItem)))
    {
      AppMethodBeat.o(164833);
      return;
    }
    f(paramMediaItem);
    Object localObject = this.xkh;
    if (localObject == null) {
      p.btv("appBarLayout");
    }
    ((AppBarLayout)localObject).bO();
    localObject = this.xkf;
    if (localObject == null) {
      p.btv("galleryView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramMediaItem = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164833);
      throw paramMediaItem;
    }
    RecyclerView.v localv = g.c((g)localObject, paramMediaItem.xiZ);
    localObject = localv;
    if (!(localv instanceof com.tencent.mm.ui.base.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.ui.base.a.b)localObject;
    if ((localObject != null) && (!this.xkc.xkE.contains(paramMediaItem)) && (this.vML.size() < 9)) {
      ((MediaItemView)((com.tencent.mm.ui.base.a.b)localObject).getView()).py(true);
    }
    AppMethodBeat.o(164833);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(164827);
    super.onActivityCreated(paramBundle);
    paramBundle = e.xlq;
    e.MC();
    e.a(e.xlq, (kotlin.g.a.q)new i(this));
    paramBundle = e.xlq;
    e.g((m)new j(this));
    AppMethodBeat.o(164827);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(164829);
    p.h(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131494794, paramViewGroup, false);
    p.g(paramLayoutInflater, "view");
    paramViewGroup = paramLayoutInflater.findViewById(2131301865);
    p.g(paramViewGroup, "view.findViewById(R.id.gallery_view)");
    this.xkf = ((RecyclerView)paramViewGroup);
    paramViewGroup = paramLayoutInflater.findViewById(2131306107);
    p.g(paramViewGroup, "view.findViewById(R.id.preview_container)");
    this.xkg = ((MMMediaCropLayout)paramViewGroup);
    paramViewGroup = this.xkg;
    if (paramViewGroup == null) {
      p.btv("previewContainer");
    }
    paramBundle = paramViewGroup.getLayoutParams();
    Object localObject = getResources();
    p.g(localObject, "resources");
    paramBundle.height = ((int)(((Resources)localObject).getDisplayMetrics().widthPixels * 3.5F / 3.0F));
    paramViewGroup.requestLayout();
    paramViewGroup.setOnClickListener((View.OnClickListener)new h(this));
    paramViewGroup = paramLayoutInflater.findViewById(2131304998);
    p.g(paramViewGroup, "view.findViewById(R.id.multi_selected_icon)");
    this.xki = ((ImageView)paramViewGroup);
    paramViewGroup = this.xki;
    if (paramViewGroup == null) {
      p.btv("multiSelectedIcon");
    }
    paramViewGroup.setBackground(this.xkk);
    paramViewGroup = this.xki;
    if (paramViewGroup == null) {
      p.btv("multiSelectedIcon");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new f(this));
    paramViewGroup = this.xki;
    if (paramViewGroup == null) {
      p.btv("multiSelectedIcon");
    }
    paramViewGroup.setVisibility(8);
    paramViewGroup = new SpeedGirdLayoutManager(getContext());
    paramBundle = this.xkf;
    if (paramBundle == null) {
      p.btv("galleryView");
    }
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)paramViewGroup);
    paramBundle = this.xkf;
    if (paramBundle == null) {
      p.btv("galleryView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.xkc);
    paramBundle = this.xkf;
    if (paramBundle == null) {
      p.btv("galleryView");
    }
    paramBundle.b((RecyclerView.h)new c(this));
    paramBundle = new g();
    localObject = this.xkf;
    if (localObject == null) {
      p.btv("galleryView");
    }
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)paramBundle);
    paramBundle = this.xkf;
    if (paramBundle == null) {
      p.btv("galleryView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = new RecyclerView.m();
    paramBundle.aw(1, 80);
    paramBundle.aw(2, 60);
    localObject = this.xkf;
    if (localObject == null) {
      p.btv("galleryView");
    }
    ((RecyclerView)localObject).setRecycledViewPool(paramBundle);
    paramViewGroup.setItemPrefetchEnabled(true);
    paramViewGroup.ca(30);
    this.xkc.xkB = ((a.c)this);
    this.xkc.xkD = ((MediaItemView.b)this);
    this.xkc.xkC = ((a.d)this);
    paramLayoutInflater.findViewById(2131301639).setOnClickListener((View.OnClickListener)new e(this, (ImageView)paramLayoutInflater.findViewById(2131297049)));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131301639);
    paramBundle = paramLayoutInflater.findViewById(2131296972);
    p.g(paramBundle, "view.findViewById(R.id.appbar_layout)");
    this.xkh = ((AppBarLayout)paramBundle);
    paramBundle = paramLayoutInflater.findViewById(2131301633);
    p.g(paramBundle, "view.findViewById(R.id.folder_chooser_view)");
    this.xke = ((RecyclerView)paramBundle);
    paramBundle = this.xke;
    if (paramBundle == null) {
      p.btv("albumChooserView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle = this.xke;
    if (paramBundle == null) {
      p.btv("albumChooserView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.xke;
    if (paramBundle == null) {
      p.btv("albumChooserView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.xkd);
    this.xkd.xkH = ((b.b)new d(this, paramViewGroup));
    AppMethodBeat.o(164829);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(164828);
    super.onDestroy();
    e locale = e.xlq;
    e.onRelease();
    AppMethodBeat.o(164828);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(164838);
    super.onPause();
    MMMediaCropLayout localMMMediaCropLayout = this.xkg;
    if (localMMMediaCropLayout == null) {
      p.btv("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIPause();
    AppMethodBeat.o(164838);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(164837);
    super.onResume();
    MMMediaCropLayout localMMMediaCropLayout = this.xkg;
    if (localMMMediaCropLayout == null) {
      p.btv("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIResume();
    AppMethodBeat.o(164837);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$Companion;", "", "()V", "LIMIT_SELECTED_COUNT", "", "MARGIN_GRID", "ROW_ITEM_COUNT", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "", "onChange", "", "size", "", "plugin-gallery_release"})
  public static abstract interface b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"})
  public static final class c
    extends RecyclerView.h
  {
    private final Paint paint;
    private final int xkq;
    
    c()
    {
      AppMethodBeat.i(164813);
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      this.xkq = localContext.getResources().getColor(2131101414);
      this.paint = new Paint();
      this.paint.setColor(this.xkq);
      this.paint.setStrokeWidth(6.4F);
      this.paint.setStyle(Paint.Style.STROKE);
      AppMethodBeat.o(164813);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(164811);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
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
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      Object localObject = paramRecyclerView.ch(GalleryPickerFragment.g(this.xkr));
      if (localObject != null) {}
      for (localObject = ((RecyclerView.v)localObject).aus;; localObject = null)
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initAlbumChooserView$1", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static final class d
    implements b.b
  {
    d(TextView paramTextView) {}
    
    public final void a(final GalleryItem.AlbumItem paramAlbumItem)
    {
      AppMethodBeat.i(164816);
      p.h(paramAlbumItem, "media");
      e locale = e.xlq;
      e.a(System.currentTimeMillis(), paramAlbumItem, (kotlin.g.a.q)new a(this, paramAlbumItem));
      AppMethodBeat.o(164816);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(GalleryPickerFragment paramGalleryPickerFragment, ImageView paramImageView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164817);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      Context localContext;
      if (GalleryPickerFragment.e(this.xkr).getVisibility() == 0)
      {
        GalleryPickerFragment.e(this.xkr).setVisibility(8);
        GalleryPickerFragment.f(this.xkr).setVisibility(0);
        paramView = this.xkx;
        localObject = this.xkr.getContext();
        localContext = this.xkr.getContext();
        if (localContext == null) {
          p.hyc();
        }
        p.g(localContext, "context!!");
        paramView.setImageDrawable(ar.m((Context)localObject, 2131689717, localContext.getResources().getColor(2131100047)));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164817);
        return;
        GalleryPickerFragment.e(this.xkr).setVisibility(0);
        GalleryPickerFragment.f(this.xkr).setVisibility(8);
        paramView = this.xkx;
        localObject = this.xkr.getContext();
        localContext = this.xkr.getContext();
        if (localContext == null) {
          p.hyc();
        }
        p.g(localContext, "context!!");
        paramView.setImageDrawable(ar.m((Context)localObject, 2131689714, localContext.getResources().getColor(2131100047)));
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164818);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.xkr;
      if (!GalleryPickerFragment.d(this.xkr)) {}
      for (boolean bool = true;; bool = false)
      {
        GalleryPickerFragment.a(paramView, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164818);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$animator$1", "Landroid/support/v7/widget/DefaultItemAnimator;", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-gallery_release"})
  public static final class g
    extends v
  {
    public final boolean p(RecyclerView.v paramv)
    {
      AppMethodBeat.i(164819);
      p.h(paramv, "viewHolder");
      AppMethodBeat.o(164819);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164820);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      GalleryPickerFragment.h(this.xkr).bO();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164820);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, x>
  {
    i(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "cost", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements m<LinkedList<GalleryItem.AlbumItem>, Long, x>
  {
    j(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(164825);
      if (GalleryPickerFragment.a(this.xkr).getItemCount() > 0)
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)GalleryPickerFragment.a(this.xkr).getItemAtPosition(0);
        GalleryPickerFragment localGalleryPickerFragment = this.xkr;
        p.g(localMediaItem, "media");
        GalleryPickerFragment.a(localGalleryPickerFragment, localMediaItem);
        Log.i("MicroMsg.GalleryPickerFragment", "[onShowDefaultItem] media=".concat(String.valueOf(localMediaItem)));
      }
      AppMethodBeat.o(164825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment
 * JD-Core Version:    0.7.0.1
 */