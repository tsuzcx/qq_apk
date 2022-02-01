package com.tencent.mm.plugin.gallery.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", "listener", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroid/support/v7/widget/RecyclerView;", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", "previewImage", "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"})
@SuppressLint({"ValidFragment"})
public final class GalleryPickerFragment
  extends Fragment
  implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem>
{
  public static final GalleryPickerFragment.a tTc;
  private ArrayList<GalleryItem.MediaItem> sPB;
  private final a tSP;
  private final com.tencent.mm.plugin.gallery.picker.a.b tSQ;
  private RecyclerView tSR;
  private RecyclerView tSS;
  private MMMediaCropLayout tST;
  private AppBarLayout tSU;
  private ImageView tSV;
  private final Drawable tSW;
  private final Drawable tSX;
  private int tSY;
  private boolean tSZ;
  private int tTa;
  private GalleryPickerFragment.b tTb;
  
  static
  {
    AppMethodBeat.i(164843);
    tTc = new GalleryPickerFragment.a((byte)0);
    AppMethodBeat.o(164843);
  }
  
  public GalleryPickerFragment(ArrayList<GalleryItem.MediaItem> paramArrayList, GalleryPickerFragment.b paramb)
  {
    AppMethodBeat.i(164842);
    this.sPB = paramArrayList;
    this.tTb = paramb;
    paramArrayList = f.tUo;
    this.tSP = new a(f.cYk(), this.sPB);
    paramArrayList = f.tUo;
    this.tSQ = new com.tencent.mm.plugin.gallery.picker.a.b(f.cYk());
    paramArrayList = ak.getContext();
    p.g(paramArrayList, "MMApplicationContext.getContext()");
    this.tSW = paramArrayList.getResources().getDrawable(2131234015);
    paramArrayList = ak.getContext();
    p.g(paramArrayList, "MMApplicationContext.getContext()");
    this.tSX = paramArrayList.getResources().getDrawable(2131234014);
    this.tSY = 1;
    this.tSZ = true;
    AppMethodBeat.o(164842);
  }
  
  private final void T(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(164841);
    ae.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + paramLong1 + " current=" + paramLong2);
    Object localObject1 = this.tSS;
    if (localObject1 == null) {
      p.bdF("galleryView");
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
      this.tTa = ((RecyclerView.w)localObject1).lN();
      localObject2 = this.tSS;
      if (localObject2 == null) {
        p.bdF("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 != null) {
        ((RecyclerView.a)localObject2).cj(((RecyclerView.w)localObject1).lN());
      }
    }
    localObject1 = this.tSS;
    if (localObject1 == null) {
      p.bdF("galleryView");
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
      localObject2 = this.tSS;
      if (localObject2 == null) {
        p.bdF("galleryView");
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
    if (this.sPB.isEmpty())
    {
      localObject = this.tST;
      if (localObject == null) {
        p.bdF("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).tVs)
      {
        paramMediaItem = this.tST;
        if (paramMediaItem == null) {
          p.bdF("previewContainer");
        }
        MMMediaCropLayout.b(paramMediaItem);
        AppMethodBeat.o(164835);
        return;
      }
    }
    if (this.sPB.size() == 1)
    {
      localObject = this.tST;
      if (localObject == null) {
        p.bdF("previewContainer");
      }
      if (((MMMediaCropLayout)localObject).tVs)
      {
        localObject = (GalleryItem.MediaItem)j.jl((List)this.sPB);
        if (paramBoolean)
        {
          if (paramMediaItem == null) {
            break label157;
          }
          if (paramMediaItem.tRM == ((GalleryItem.MediaItem)localObject).tRM)
          {
            paramMediaItem = this.tST;
            if (paramMediaItem == null) {
              p.bdF("previewContainer");
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
  
  private final void cYh()
  {
    AppMethodBeat.i(164834);
    Iterator localIterator = ((Iterable)this.sPB).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (GalleryItem.MediaItem)localIterator.next();
      Object localObject2 = this.tSS;
      if (localObject2 == null) {
        p.bdF("galleryView");
      }
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
        AppMethodBeat.o(164834);
        throw ((Throwable)localObject1);
      }
      localObject2 = d.c((d)localObject2, ((GalleryItem.MediaItem)localObject1).tRM);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.ui.base.a.b)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.ui.base.a.b)localObject1;
      if (localObject1 != null) {
        this.tSP.b(((com.tencent.mm.ui.base.a.b)localObject1).lN(), Integer.valueOf(1));
      }
    }
    AppMethodBeat.o(164834);
  }
  
  private final void e(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164836);
    MMMediaCropLayout localMMMediaCropLayout = this.tST;
    if (localMMMediaCropLayout == null) {
      p.bdF("previewContainer");
    }
    long l = localMMMediaCropLayout.getCurrentPreviewMediaId();
    if (this.sPB.size() == 2)
    {
      localMMMediaCropLayout = this.tST;
      if (localMMMediaCropLayout == null) {
        p.bdF("previewContainer");
      }
      if (!localMMMediaCropLayout.tVs)
      {
        localMMMediaCropLayout = this.tST;
        if (localMMMediaCropLayout == null) {
          p.bdF("previewContainer");
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
      T(l, paramMediaItem.tRM);
      AppMethodBeat.o(164836);
      return;
      f(paramMediaItem);
    }
  }
  
  private final void f(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164839);
    if ((this.tSZ) && (this.tSY != 1))
    {
      AppMethodBeat.o(164839);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.tST;
    if (localMMMediaCropLayout == null) {
      p.bdF("previewContainer");
    }
    MMMediaCropLayout.a(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164839);
  }
  
  private final void g(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164840);
    if ((this.tSZ) && (this.tSY != 2))
    {
      AppMethodBeat.o(164840);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout = this.tST;
    if (localMMMediaCropLayout == null) {
      p.bdF("previewContainer");
    }
    MMMediaCropLayout.b(localMMMediaCropLayout, paramMediaItem);
    AppMethodBeat.o(164840);
  }
  
  private final void mQ(boolean paramBoolean)
  {
    AppMethodBeat.i(164826);
    this.tSZ = paramBoolean;
    this.tSP.tSZ = paramBoolean;
    ae.i("MicroMsg.GalleryPickerFragment", "isMultiSelectedMode=".concat(String.valueOf(paramBoolean)));
    ae.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
    Object localObject1 = this.tSS;
    if (localObject1 == null) {
      p.bdF("galleryView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {
      p.gkB();
    }
    Object localObject2 = this.tSS;
    if (localObject2 == null) {
      p.bdF("galleryView");
    }
    localObject2 = ((RecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.gkB();
    }
    p.g(localObject2, "galleryView.adapter!!");
    ((RecyclerView.a)localObject1).e(0, ((RecyclerView.a)localObject2).getItemCount(), Integer.valueOf(2));
    AppMethodBeat.o(164826);
  }
  
  public final boolean c(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164830);
    p.h(paramMediaItem, "media");
    ae.i("MicroMsg.GalleryPickerFragment", "[onItemLongClick] media=" + paramMediaItem.toSimpleString());
    AppMethodBeat.o(164830);
    return true;
  }
  
  public final void d(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164833);
    p.h(paramMediaItem, "media");
    ae.i("MicroMsg.GalleryPickerFragment", "[onItemClick] media=" + paramMediaItem.toSimpleString());
    if ((this.sPB.size() >= 9) && (!this.sPB.contains(paramMediaItem)))
    {
      AppMethodBeat.o(164833);
      return;
    }
    e(paramMediaItem);
    Object localObject = this.tSU;
    if (localObject == null) {
      p.bdF("appBarLayout");
    }
    ((AppBarLayout)localObject).bM();
    localObject = this.tSS;
    if (localObject == null) {
      p.bdF("galleryView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramMediaItem = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(164833);
      throw paramMediaItem;
    }
    RecyclerView.w localw = d.c((d)localObject, paramMediaItem.tRM);
    localObject = localw;
    if (!(localw instanceof com.tencent.mm.ui.base.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.ui.base.a.b)localObject;
    if ((localObject != null) && (!this.tSP.tTr.contains(paramMediaItem)) && (this.sPB.size() < 9)) {
      ((MediaItemView)((com.tencent.mm.ui.base.a.b)localObject).getView()).mR(true);
    }
    AppMethodBeat.o(164833);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(164827);
    super.onActivityCreated(paramBundle);
    paramBundle = e.tUe;
    e.Dg();
    paramBundle = e.tUe;
    e.c((d.g.a.q)new i(this));
    paramBundle = e.tUe;
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
    this.tSS = ((RecyclerView)paramViewGroup);
    paramViewGroup = paramLayoutInflater.findViewById(2131303393);
    p.g(paramViewGroup, "view.findViewById(R.id.preview_container)");
    this.tST = ((MMMediaCropLayout)paramViewGroup);
    paramViewGroup = this.tST;
    if (paramViewGroup == null) {
      p.bdF("previewContainer");
    }
    paramBundle = paramViewGroup.getLayoutParams();
    Object localObject = getResources();
    p.g(localObject, "resources");
    paramBundle.height = ((int)(((Resources)localObject).getDisplayMetrics().widthPixels * 3.5F / 3.0F));
    paramViewGroup.requestLayout();
    paramViewGroup.setOnClickListener((View.OnClickListener)new GalleryPickerFragment.h(this));
    paramViewGroup = paramLayoutInflater.findViewById(2131302566);
    p.g(paramViewGroup, "view.findViewById(R.id.multi_selected_icon)");
    this.tSV = ((ImageView)paramViewGroup);
    paramViewGroup = this.tSV;
    if (paramViewGroup == null) {
      p.bdF("multiSelectedIcon");
    }
    paramViewGroup.setBackground(this.tSX);
    paramViewGroup = this.tSV;
    if (paramViewGroup == null) {
      p.bdF("multiSelectedIcon");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)new GalleryPickerFragment.f(this));
    paramViewGroup = this.tSV;
    if (paramViewGroup == null) {
      p.bdF("multiSelectedIcon");
    }
    paramViewGroup.setVisibility(8);
    getContext();
    paramViewGroup = new SpeedGirdLayoutManager();
    paramBundle = this.tSS;
    if (paramBundle == null) {
      p.bdF("galleryView");
    }
    paramBundle.setLayoutManager((RecyclerView.i)paramViewGroup);
    paramBundle = this.tSS;
    if (paramBundle == null) {
      p.bdF("galleryView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.tSP);
    paramBundle = this.tSS;
    if (paramBundle == null) {
      p.bdF("galleryView");
    }
    paramBundle.b((RecyclerView.h)new GalleryPickerFragment.c(this));
    paramBundle = new g();
    localObject = this.tSS;
    if (localObject == null) {
      p.bdF("galleryView");
    }
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)paramBundle);
    paramBundle = this.tSS;
    if (paramBundle == null) {
      p.bdF("galleryView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = new RecyclerView.n();
    paramBundle.aC(1, 80);
    paramBundle.aC(2, 60);
    localObject = this.tSS;
    if (localObject == null) {
      p.bdF("galleryView");
    }
    ((RecyclerView)localObject).setRecycledViewPool(paramBundle);
    paramViewGroup.aw(true);
    paramViewGroup.cb(30);
    this.tSP.tTo = ((a.c)this);
    this.tSP.tTq = ((MediaItemView.b)this);
    this.tSP.tTp = ((a.d)this);
    paramLayoutInflater.findViewById(2131300183).setOnClickListener((View.OnClickListener)new GalleryPickerFragment.e(this, (ImageView)paramLayoutInflater.findViewById(2131296942)));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131300183);
    paramBundle = paramLayoutInflater.findViewById(2131296878);
    p.g(paramBundle, "view.findViewById(R.id.appbar_layout)");
    this.tSU = ((AppBarLayout)paramBundle);
    paramBundle = paramLayoutInflater.findViewById(2131300177);
    p.g(paramBundle, "view.findViewById(R.id.folder_chooser_view)");
    this.tSR = ((RecyclerView)paramBundle);
    paramBundle = this.tSR;
    if (paramBundle == null) {
      p.bdF("albumChooserView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramBundle = this.tSR;
    if (paramBundle == null) {
      p.bdF("albumChooserView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.tSR;
    if (paramBundle == null) {
      p.bdF("albumChooserView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.tSQ);
    this.tSQ.tTu = ((b.b)new d(this, paramViewGroup));
    AppMethodBeat.o(164829);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(164828);
    super.onDestroy();
    e locale = e.tUe;
    e.onRelease();
    AppMethodBeat.o(164828);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(164838);
    super.onPause();
    MMMediaCropLayout localMMMediaCropLayout = this.tST;
    if (localMMMediaCropLayout == null) {
      p.bdF("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIPause();
    AppMethodBeat.o(164838);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(164837);
    super.onResume();
    MMMediaCropLayout localMMMediaCropLayout = this.tST;
    if (localMMMediaCropLayout == null) {
      p.bdF("previewContainer");
    }
    localMMMediaCropLayout.getVideoView().onUIResume();
    AppMethodBeat.o(164837);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initAlbumChooserView$1", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
  public static final class d
    implements b.b
  {
    d(TextView paramTextView) {}
    
    public final void a(final GalleryItem.AlbumItem paramAlbumItem)
    {
      AppMethodBeat.i(164816);
      p.h(paramAlbumItem, "media");
      e locale = e.tUe;
      e.a(System.currentTimeMillis(), paramAlbumItem, (d.g.a.q)new a(this, paramAlbumItem));
      AppMethodBeat.o(164816);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$animator$1", "Landroid/support/v7/widget/DefaultItemAnimator;", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-gallery_release"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, z>
  {
    i(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "cost", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements m<LinkedList<GalleryItem.AlbumItem>, Long, z>
  {
    j(GalleryPickerFragment paramGalleryPickerFragment)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(GalleryPickerFragment paramGalleryPickerFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(164825);
      if (GalleryPickerFragment.a(this.tTe).getItemCount() > 0)
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)GalleryPickerFragment.a(this.tTe).getItemAtPosition(0);
        GalleryPickerFragment localGalleryPickerFragment = this.tTe;
        p.g(localMediaItem, "media");
        GalleryPickerFragment.a(localGalleryPickerFragment, localMediaItem);
        ae.i("MicroMsg.GalleryPickerFragment", "[onShowDefaultItem] media=".concat(String.valueOf(localMediaItem)));
      }
      AppMethodBeat.o(164825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment
 * JD-Core Version:    0.7.0.1
 */