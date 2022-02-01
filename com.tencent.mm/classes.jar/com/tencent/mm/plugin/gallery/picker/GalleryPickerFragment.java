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
import com.tencent.mm.view.recyclerview.d;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", "listener", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroid/support/v7/widget/RecyclerView;", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", "previewImage", "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"})
@SuppressLint({"ValidFragment"})
public final class GalleryPickerFragment
  extends Fragment
  implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem>
{
  public static final GalleryPickerFragment.a tIl;
  private ArrayList<GalleryItem.MediaItem> sEC;
  private final com.tencent.mm.plugin.gallery.picker.a.a tHY;
  private final com.tencent.mm.plugin.gallery.picker.a.b tHZ;
  private RecyclerView tIa;
  private RecyclerView tIb;
  private MMMediaCropLayout tIc;
  private AppBarLayout tId;
  private ImageView tIe;
  private final Drawable tIf;
  private final Drawable tIg;
  private int tIh;
  private boolean tIi;
  private int tIj;
  private GalleryPickerFragment.b tIk;
  
  static
  {
    AppMethodBeat.i(164843);
    tIl = new GalleryPickerFragment.a((byte)0);
    AppMethodBeat.o(164843);
  }
  
  public GalleryPickerFragment(ArrayList<GalleryItem.MediaItem> paramArrayList, GalleryPickerFragment.b paramb)
  {
    AppMethodBeat.i(164842);
    this.sEC = paramArrayList;
    this.tIk = paramb;
    paramArrayList = f.tJx;
    this.tHY = new com.tencent.mm.plugin.gallery.picker.a.a(f.cVF(), this.sEC);
    paramArrayList = f.tJx;
    this.tHZ = new com.tencent.mm.plugin.gallery.picker.a.b(f.cVF());
    paramArrayList = aj.getContext();
    p.g(paramArrayList, "MMApplicationContext.getContext()");
    this.tIf = paramArrayList.getResources().getDrawable(2131234015);
    paramArrayList = aj.getContext();
    p.g(paramArrayList, "MMApplicationContext.getContext()");
    this.tIg = paramArrayList.getResources().getDrawable(2131234014);
    this.tIh = 1;
    this.tIi = true;
    AppMethodBeat.o(164842);
  }
  
  private final void U(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(164841);
    ad.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + paramLong1 + " current=" + paramLong2);
    Object localObject1 = this.tIb;
    if (localObject1 == null) {
      p.bcb("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = d.c((d)localObject1, paramLong2);
    Object localObject2;
    if (localObject1 != null)
    {
      this.tIj = ((RecyclerView.w)localObject1).lN();
      localObject2 = this.tIb;
      if (localObject2 == null) {
        p.bcb("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null) {
        ((RecyclerView.a)localObject2).cj(((RecyclerView.w)localObject1).lN());
      }
    }
    localObject1 = this.tIb;
    if (localObject1 == null) {
      p.bcb("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject1 = d.c((d)localObject1, paramLong1);
    if (localObject1 != null)
    {
      localObject2 = this.tIb;
      if (localObject2 == null) {
        p.bcb("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null)
      {
        ((RecyclerView.a)localObject2).cj(((RecyclerView.w)localObject1).lN());
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
    if (this.sEC.isEmpty())
    {
      localObject = this.tIc;
      if (localObject == null) {
        p.bcb("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).tKB)
      {
        paramMediaItem = this.tIc;
        if (paramMediaItem == null) {
          p.bcb("previewContainer");
        }
        MMMediaCropLayout.b(paramMediaItem);
        AppMethodBeat.o(164835);
        return;
      }
    }
    if (this.sEC.size() == 1)
    {
      localObject = this.tIc;
      if (localObject == null) {
        p.bcb("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).tKB)
      {
        localObject = (GalleryItem.MediaItem)j.jc((List)this.sEC);
        if (paramBoolean)
        {
          if (paramMediaItem == null) {
            break label157;
          }
          if (paramMediaItem.tGV == ((GalleryItem.MediaItem)localObject).tGV)
          {
            paramMediaItem = this.tIc;
            if (paramMediaItem == null) {
              p.bcb("previewContainer");
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
  
  private final void cVC()
  {
    AppMethodBeat.i(164834);
    Iterator localIterator = ((Iterable)this.sEC).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (GalleryItem.MediaItem)localIterator.next();
      Object localObject2 = this.tIb;
      if (localObject2 == null) {
        p.bcb("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
        AppMethodBeat.o(164834);
        throw ((Throwable)localObject1);
      }
      localObject2 = d.c((d)localObject2, ((GalleryItem.MediaItem)localObject1).tGV);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.ui.base.a.b)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.ui.base.a.b)localObject1;
      if (localObject1 != null) {
        this.tHY.b(((com.tencent.mm.ui.base.a.b)localObject1).lN(), Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(164834);
  }
  
  private final void e(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164836);
    MMMediaCropLayout localMMMediaCropLayout = this.tIc;
    if (localMMMediaCropLayout == null) {
      p.bcb("previewContainer");
    }
    long l = localMMMediaCropLayout.getCurrentPreviewMediaId();
    if (this.sEC.size() == 2)
    {
      localMMMediaCropLayout = this.tIc;
      if (localMMMediaCropLayout == null) {
        p.bcb("previewContainer");
      }
      if (!localMMMediaCropLayout.tKB)
      {
        localMMMediaCropLayout = this.tIc;
        if (localMMMediaCropLayout == null) {
          p.bcb("previewContainer");
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
      U(l, paramMediaItem.tGV);
      AppMethodBeat.o(164836);
      return;
      f(paramMediaItem);
    }
  }
  
  private final void f(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164839);
    if ((this.tIi) && (this.tIh != 1))
    {
      AppMethodBeat.o(164839);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.tIc;
    if (localMMMediaCropLayout == null) {
      p.bcb("previewContainer");
    }
    MMMediaCropLayout.a(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164839);
  }
  
  private final void g(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164840);
    if ((this.tIi) && (this.tIh != 2))
    {
      AppMethodBeat.o(164840);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.tIc;
    if (localMMMediaCropLayout == null) {
      p.bcb("previewContainer");
    }
    MMMediaCropLayout.b(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164840);
  }
  
  private final void mM(boolean paramBoolean)
  {
    AppMethodBeat.i(164826);
    this.tIi = paramBoolean;
    this.tHY.tIi = paramBoolean;
    ad.i("MicroMsg.GalleryPickerFragment", "isMultiSelectedMode=".concat(String.valueOf(paramBoolean)));
    ad.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
    Object localObject1 = this.tIb;
    if (localObject1 == null) {
      p.bcb("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {
      p.gfZ();
    }
    Object localObject2 = this.tIb;
    if (localObject2 == null) {
      p.bcb("galleryView");
    }
    localObject2 = ((RecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.gfZ();
    }
    p.g(localObject2, "galleryView.adapter!!");
    ((RecyclerView.a)localObject1).e(0, ((RecyclerView.a)localObject2).getItemCount(), Integer.valueOf(2));
    AppMethodBeat.o(164826);
  }
  
  public final boolean c(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164830);
    p.h(paramMediaItem, "media");
    ad.i("MicroMsg.GalleryPickerFragment", "[onItemLongClick] media=" + paramMediaItem.toSimpleString());
    AppMethodBeat.o(164830);
    return true;
  }
  
  public final void d(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164833);
    p.h(paramMediaItem, "media");
    ad.i("MicroMsg.GalleryPickerFragment", "[onItemClick] media=" + paramMediaItem.toSimpleString());
    if ((this.sEC.size() >= 9) && (!this.sEC.contains(paramMediaItem)))
    {
      AppMethodBeat.o(164833);
      return;
    }
    e(paramMediaItem);
    Object localObject = this.tId;
    if (localObject == null) {
      p.bcb("appBarLayout");
    }
    ((AppBarLayout)localObject).bM();
    localObject = this.tIb;
    if (localObject == null) {
      p.bcb("galleryView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramMediaItem = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164833);
      throw paramMediaItem;
    }
    RecyclerView.w localw = d.c((d)localObject, paramMediaItem.tGV);
    localObject = localw;
    if (!(localw instanceof com.tencent.mm.ui.base.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.ui.base.a.b)localObject;
    if ((localObject != null) && (!this.tHY.tIA.contains(paramMediaItem)) && (this.sEC.size() < 9)) {
      ((MediaItemView)((com.tencent.mm.ui.base.a.b)localObject).getView()).mN(true);
    }
    AppMethodBeat.o(164833);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(164827);
    super.onActivityCreated(paramBundle);
    paramBundle = e.tJn;
    e.Dd();
    paramBundle = e.tJn;
    e.c((d.g.a.q)new i(this));
    paramBundle = e.tJn;
    e.d((m)new j(this));
    AppMethodBeat.o(164827);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(164829);
    p.h(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131494233, paramViewGroup, false);
    p.g(paramLayoutInflater, "view");
    paramViewGroup = paramLayoutInflater.findViewById(2131300343);
    p.g(paramViewGroup, "view.findViewById(R.id.gallery_view)");
    this.tIb = ((RecyclerView)paramViewGroup);
    paramViewGroup = paramLayoutInflater.findViewById(2131303393);
    p.g(paramViewGroup, "view.findViewById(R.id.preview_container)");
    this.tIc = ((MMMediaCropLayout)paramViewGroup);
    paramViewGroup = this.tIc;
    if (paramViewGroup == null) {
      p.bcb("previewContainer");
    }
    paramBundle = paramViewGroup.getLayoutParams();
    Object localObject = getResources();
    p.g(localObject, "resources");
    paramBundle.height = ((int)(((Resources)localObject).getDisplayMetrics().widthPixels * 3.5F / 3.0F));
    paramViewGroup.requestLayout();
    paramViewGroup.setOnClickListener((View.OnClickListener)new h(this));
    paramViewGroup = paramLayoutInflater.findViewById(2131302566);
    p.g(paramViewGroup, "view.findViewById(R.id.multi_selected_icon)");
    this.tIe = ((ImageView)paramViewGroup);
    paramViewGroup = this.tIe;
    if (paramViewGroup == null) {
      p.bcb("multiSelectedIcon");
    }
    paramViewGroup.setBackground(this.tIg);
    paramViewGroup = this.tIe;
    if (paramViewGroup == null) {
      p.bcb("multiSelectedIcon");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new GalleryPickerFragment.f(this));
    paramViewGroup = this.tIe;
    if (paramViewGroup == null) {
      p.bcb("multiSelectedIcon");
    }
    paramViewGroup.setVisibility(8);
    getContext();
    paramViewGroup = new SpeedGirdLayoutManager();
    paramBundle = this.tIb;
    if (paramBundle == null) {
      p.bcb("galleryView");
    }
    paramBundle.setLayoutManager((RecyclerView.i)paramViewGroup);
    paramBundle = this.tIb;
    if (paramBundle == null) {
      p.bcb("galleryView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.tHY);
    paramBundle = this.tIb;
    if (paramBundle == null) {
      p.bcb("galleryView");
    }
    paramBundle.b((RecyclerView.h)new c(this));
    paramBundle = new g();
    localObject = this.tIb;
    if (localObject == null) {
      p.bcb("galleryView");
    }
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)paramBundle);
    paramBundle = this.tIb;
    if (paramBundle == null) {
      p.bcb("galleryView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = new RecyclerView.n();
    paramBundle.aC(1, 80);
    paramBundle.aC(2, 60);
    localObject = this.tIb;
    if (localObject == null) {
      p.bcb("galleryView");
    }
    ((RecyclerView)localObject).setRecycledViewPool(paramBundle);
    paramViewGroup.aw(true);
    paramViewGroup.cb(30);
    this.tHY.tIx = ((a.c)this);
    this.tHY.tIz = ((MediaItemView.b)this);
    this.tHY.tIy = ((a.d)this);
    paramLayoutInflater.findViewById(2131300183).setOnClickListener((View.OnClickListener)new GalleryPickerFragment.e(this, (ImageView)paramLayoutInflater.findViewById(2131296942)));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131300183);
    paramBundle = paramLayoutInflater.findViewById(2131296878);
    p.g(paramBundle, "view.findViewById(R.id.appbar_layout)");
    this.tId = ((AppBarLayout)paramBundle);
    paramBundle = paramLayoutInflater.findViewById(2131300177);
    p.g(paramBundle, "view.findViewById(R.id.folder_chooser_view)");
    this.tIa = ((RecyclerView)paramBundle);
    paramBundle = this.tIa;
    if (paramBundle == null) {
      p.bcb("albumChooserView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramBundle = this.tIa;
    if (paramBundle == null) {
      p.bcb("albumChooserView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.tIa;
    if (paramBundle == null) {
      p.bcb("albumChooserView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.tHZ);
    this.tHZ.tID = ((b.b)new d(this, paramViewGroup));
    AppMethodBeat.o(164829);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(164828);
    super.onDestroy();
    e locale = e.tJn;
    e.onRelease();
    AppMethodBeat.o(164828);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(164838);
    super.onPause();
    MMMediaCropLayout localMMMediaCropLayout = this.tIc;
    if (localMMMediaCropLayout == null) {
      p.bcb("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIPause();
    AppMethodBeat.o(164838);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(164837);
    super.onResume();
    MMMediaCropLayout localMMMediaCropLayout = this.tIc;
    if (localMMMediaCropLayout == null) {
      p.bcb("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIResume();
    AppMethodBeat.o(164837);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"})
  public static final class c
    extends RecyclerView.h
  {
    private final Paint paint;
    private final int tIm;
    
    c()
    {
      AppMethodBeat.i(164813);
      Context localContext = aj.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      this.tIm = localContext.getResources().getColor(2131101171);
      this.paint = new Paint();
      this.paint.setColor(this.tIm);
      this.paint.setStrokeWidth(6.4F);
      this.paint.setStyle(Paint.Style.STROKE);
      AppMethodBeat.o(164813);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(164811);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
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
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      Object localObject = paramRecyclerView.ci(GalleryPickerFragment.g(this.tIn));
      if (localObject != null) {}
      for (localObject = ((RecyclerView.w)localObject).auu;; localObject = null)
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initAlbumChooserView$1", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static final class d
    implements b.b
  {
    d(TextView paramTextView) {}
    
    public final void a(final GalleryItem.AlbumItem paramAlbumItem)
    {
      AppMethodBeat.i(164816);
      p.h(paramAlbumItem, "media");
      e locale = e.tJn;
      e.a(System.currentTimeMillis(), paramAlbumItem, (d.g.a.q)new a(this, paramAlbumItem));
      AppMethodBeat.o(164816);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, z>
    {
      a(GalleryPickerFragment.d paramd, GalleryItem.AlbumItem paramAlbumItem)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$animator$1", "Landroid/support/v7/widget/DefaultItemAnimator;", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-gallery_release"})
  public static final class g
    extends android.support.v7.widget.v
  {
    public final boolean p(RecyclerView.w paramw)
    {
      AppMethodBeat.i(164819);
      p.h(paramw, "viewHolder");
      AppMethodBeat.o(164819);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164820);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      GalleryPickerFragment.h(this.tIn).bM();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164820);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, z>
  {
    i(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "cost", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements m<LinkedList<GalleryItem.AlbumItem>, Long, z>
  {
    j(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(164825);
      if (GalleryPickerFragment.a(this.tIn).getItemCount() > 0)
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)GalleryPickerFragment.a(this.tIn).getItemAtPosition(0);
        GalleryPickerFragment localGalleryPickerFragment = this.tIn;
        p.g(localMediaItem, "media");
        GalleryPickerFragment.a(localGalleryPickerFragment, localMediaItem);
        ad.i("MicroMsg.GalleryPickerFragment", "[onShowDefaultItem] media=".concat(String.valueOf(localMediaItem)));
      }
      AppMethodBeat.o(164825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment
 * JD-Core Version:    0.7.0.1
 */