package com.tencent.mm.plugin.gallery.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
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
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.f;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.a.a.c;
import com.tencent.mm.plugin.gallery.picker.a.a.d;
import com.tencent.mm.plugin.gallery.picker.c.e;
import com.tencent.mm.plugin.gallery.picker.manager.SpeedGirdLayoutManager;
import com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", "listener", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroidx/recyclerview/widget/RecyclerView;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", "previewImage", "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GalleryPickerFragment
  extends Fragment
  implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem>
{
  public static final GalleryPickerFragment.a HIT;
  private ArrayList<GalleryItem.MediaItem> HIU;
  private final com.tencent.mm.plugin.gallery.picker.a.a HIV;
  private final com.tencent.mm.plugin.gallery.picker.a.b HIW;
  private RecyclerView HIX;
  private RecyclerView HIY;
  private MMMediaCropLayout HIZ;
  private AppBarLayout HJa;
  private ImageView HJb;
  private final Drawable HJc;
  private int HJd;
  private boolean HJe;
  private int HJf;
  
  static
  {
    AppMethodBeat.i(164843);
    HIT = new GalleryPickerFragment.a((byte)0);
    AppMethodBeat.o(164843);
  }
  
  private final void a(GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    Object localObject2 = null;
    MMMediaCropLayout localMMMediaCropLayout1 = null;
    AppMethodBeat.i(164835);
    Object localObject1;
    if (this.HIU.isEmpty())
    {
      MMMediaCropLayout localMMMediaCropLayout2 = this.HIZ;
      localObject1 = localMMMediaCropLayout2;
      if (localMMMediaCropLayout2 == null)
      {
        s.bIx("previewContainer");
        localObject1 = null;
      }
      if (((MMMediaCropLayout)localObject1).HKZ)
      {
        paramMediaItem = this.HIZ;
        if (paramMediaItem == null)
        {
          s.bIx("previewContainer");
          paramMediaItem = localMMMediaCropLayout1;
        }
        for (;;)
        {
          MMMediaCropLayout.b(paramMediaItem);
          AppMethodBeat.o(164835);
          return;
        }
      }
    }
    int i;
    if (this.HIU.size() == 1)
    {
      localMMMediaCropLayout1 = this.HIZ;
      localObject1 = localMMMediaCropLayout1;
      if (localMMMediaCropLayout1 == null)
      {
        s.bIx("previewContainer");
        localObject1 = null;
      }
      if (((MMMediaCropLayout)localObject1).HKZ)
      {
        localObject1 = (GalleryItem.MediaItem)p.oK((List)this.HIU);
        if (paramBoolean)
        {
          if ((paramMediaItem == null) || (paramMediaItem.HHJ != ((GalleryItem.MediaItem)localObject1).HHJ)) {
            break label193;
          }
          i = 1;
          if (i != 0)
          {
            paramMediaItem = this.HIZ;
            if (paramMediaItem != null) {
              break label198;
            }
            s.bIx("previewContainer");
            paramMediaItem = localObject2;
          }
        }
      }
    }
    label193:
    label198:
    for (;;)
    {
      MMMediaCropLayout.b(paramMediaItem);
      AppMethodBeat.o(164835);
      return;
      i = 0;
      break;
    }
  }
  
  private static final void a(GalleryPickerFragment paramGalleryPickerFragment)
  {
    AppMethodBeat.i(289334);
    s.u(paramGalleryPickerFragment, "this$0");
    if (paramGalleryPickerFragment.HIV.getItemCount() > 0)
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramGalleryPickerFragment.HIV.aBc(0);
      s.s(localMediaItem, "media");
      paramGalleryPickerFragment.f(localMediaItem);
      Log.i("MicroMsg.GalleryPickerFragment", s.X("[onShowDefaultItem] media=", localMediaItem));
    }
    AppMethodBeat.o(289334);
  }
  
  private static final void a(GalleryPickerFragment paramGalleryPickerFragment, View paramView)
  {
    AppMethodBeat.i(289339);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramGalleryPickerFragment);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryPickerFragment, "this$0");
    if (!paramGalleryPickerFragment.HJe) {}
    for (boolean bool = true;; bool = false)
    {
      paramGalleryPickerFragment.vR(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289339);
      return;
    }
  }
  
  private static final void a(GalleryPickerFragment paramGalleryPickerFragment, ImageView paramImageView, View paramView)
  {
    RecyclerView localRecyclerView2 = null;
    RecyclerView localRecyclerView1 = null;
    AppMethodBeat.i(289343);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramGalleryPickerFragment);
    localb.cH(paramImageView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryPickerFragment, "this$0");
    localObject = paramGalleryPickerFragment.HIY;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("galleryView");
      paramView = null;
    }
    int i;
    if (paramView.getVisibility() == 0)
    {
      localRecyclerView2 = paramGalleryPickerFragment.HIY;
      paramView = localRecyclerView2;
      if (localRecyclerView2 == null)
      {
        s.bIx("galleryView");
        paramView = null;
      }
      paramView.setVisibility(8);
      paramView = paramGalleryPickerFragment.HIX;
      if (paramView == null)
      {
        s.bIx("albumChooserView");
        paramView = localRecyclerView1;
      }
      for (;;)
      {
        paramView.setVisibility(0);
        paramView = paramGalleryPickerFragment.getContext();
        i = b.h.arrow_up;
        paramGalleryPickerFragment = paramGalleryPickerFragment.getContext();
        s.checkNotNull(paramGalleryPickerFragment);
        paramImageView.setImageDrawable(bb.m(paramView, i, paramGalleryPickerFragment.getResources().getColor(b.b.black_text_color)));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289343);
        return;
      }
    }
    localRecyclerView1 = paramGalleryPickerFragment.HIY;
    paramView = localRecyclerView1;
    if (localRecyclerView1 == null)
    {
      s.bIx("galleryView");
      paramView = null;
    }
    paramView.setVisibility(0);
    paramView = paramGalleryPickerFragment.HIX;
    if (paramView == null)
    {
      s.bIx("albumChooserView");
      paramView = localRecyclerView2;
    }
    for (;;)
    {
      paramView.setVisibility(8);
      paramView = paramGalleryPickerFragment.getContext();
      i = b.h.arrow_down;
      paramGalleryPickerFragment = paramGalleryPickerFragment.getContext();
      s.checkNotNull(paramGalleryPickerFragment);
      paramImageView.setImageDrawable(bb.m(paramView, i, paramGalleryPickerFragment.getResources().getColor(b.b.black_text_color)));
      break;
    }
  }
  
  private final void aH(long paramLong1, long paramLong2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(164841);
    Log.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + paramLong1 + " current=" + paramLong2);
    Object localObject3 = this.HIY;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("galleryView");
      localObject1 = null;
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    RecyclerView.v localv = i.c((i)localObject1, paramLong2);
    if (localv != null)
    {
      this.HJf = localv.KJ();
      localObject3 = this.HIY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("galleryView");
        localObject1 = null;
      }
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 != null) {
        ((RecyclerView.a)localObject1).fV(localv.KJ());
      }
    }
    localObject3 = this.HIY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("galleryView");
      localObject1 = null;
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
      AppMethodBeat.o(164841);
      throw ((Throwable)localObject1);
    }
    localObject3 = i.c((i)localObject1, paramLong1);
    if (localObject3 != null)
    {
      localObject1 = this.HIY;
      if (localObject1 != null) {
        break label292;
      }
      s.bIx("galleryView");
      localObject1 = localObject2;
    }
    label292:
    for (;;)
    {
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 != null) {
        ((RecyclerView.a)localObject1).fV(((RecyclerView.v)localObject3).KJ());
      }
      AppMethodBeat.o(164841);
      return;
    }
  }
  
  private static final void b(GalleryPickerFragment paramGalleryPickerFragment, View paramView)
  {
    AppMethodBeat.i(289346);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramGalleryPickerFragment);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryPickerFragment, "this$0");
    paramView = paramGalleryPickerFragment.HJa;
    paramGalleryPickerFragment = paramView;
    if (paramView == null)
    {
      s.bIx("appBarLayout");
      paramGalleryPickerFragment = null;
    }
    paramGalleryPickerFragment.c(true, true, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289346);
  }
  
  private final void f(GalleryItem.MediaItem paramMediaItem)
  {
    Object localObject2 = null;
    AppMethodBeat.i(164836);
    MMMediaCropLayout localMMMediaCropLayout = this.HIZ;
    Object localObject1 = localMMMediaCropLayout;
    if (localMMMediaCropLayout == null)
    {
      s.bIx("previewContainer");
      localObject1 = null;
    }
    long l = ((MMMediaCropLayout)localObject1).getCurrentPreviewMediaId();
    if (this.HIU.size() == 2)
    {
      localMMMediaCropLayout = this.HIZ;
      localObject1 = localMMMediaCropLayout;
      if (localMMMediaCropLayout == null)
      {
        s.bIx("previewContainer");
        localObject1 = null;
      }
      if (!((MMMediaCropLayout)localObject1).HKZ)
      {
        localObject1 = this.HIZ;
        if (localObject1 != null) {
          break label140;
        }
        s.bIx("previewContainer");
        localObject1 = localObject2;
        MMMediaCropLayout.a((MMMediaCropLayout)localObject1);
      }
    }
    a(paramMediaItem, true);
    if (paramMediaItem.getType() == 2) {
      h(paramMediaItem);
    }
    for (;;)
    {
      aH(l, paramMediaItem.HHJ);
      AppMethodBeat.o(164836);
      return;
      label140:
      break;
      g(paramMediaItem);
    }
  }
  
  private final void fAZ()
  {
    AppMethodBeat.i(164834);
    Iterator localIterator = ((Iterable)this.HIU).iterator();
    label136:
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      RecyclerView localRecyclerView = this.HIY;
      Object localObject = localRecyclerView;
      if (localRecyclerView == null)
      {
        s.bIx("galleryView");
        localObject = null;
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
        AppMethodBeat.o(164834);
        throw ((Throwable)localObject);
      }
      localObject = i.c((i)localObject, localMediaItem.HHJ);
      if ((localObject instanceof com.tencent.mm.ui.base.a.b)) {}
      for (localObject = (com.tencent.mm.ui.base.a.b)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label136;
        }
        this.HIV.t(((com.tencent.mm.ui.base.a.b)localObject).KJ(), Integer.valueOf(1));
        break;
      }
    }
    AppMethodBeat.o(164834);
  }
  
  private final void g(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164839);
    if ((this.HJe) && (this.HJd != 1))
    {
      AppMethodBeat.o(164839);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout2 = this.HIZ;
    MMMediaCropLayout localMMMediaCropLayout1 = localMMMediaCropLayout2;
    if (localMMMediaCropLayout2 == null)
    {
      s.bIx("previewContainer");
      localMMMediaCropLayout1 = null;
    }
    MMMediaCropLayout.a(localMMMediaCropLayout1, paramMediaItem);
    AppMethodBeat.o(164839);
  }
  
  private final void h(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164840);
    if ((this.HJe) && (this.HJd != 2))
    {
      AppMethodBeat.o(164840);
      return;
    }
    MMMediaCropLayout localMMMediaCropLayout2 = this.HIZ;
    MMMediaCropLayout localMMMediaCropLayout1 = localMMMediaCropLayout2;
    if (localMMMediaCropLayout2 == null)
    {
      s.bIx("previewContainer");
      localMMMediaCropLayout1 = null;
    }
    MMMediaCropLayout.b(localMMMediaCropLayout1, paramMediaItem);
    AppMethodBeat.o(164840);
  }
  
  private final void vR(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(164826);
    this.HJe = paramBoolean;
    this.HIV.HJe = paramBoolean;
    Log.i("MicroMsg.GalleryPickerFragment", s.X("isMultiSelectedMode=", Boolean.valueOf(paramBoolean)));
    Log.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
    Object localObject3 = this.HIY;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("galleryView");
      localObject1 = null;
    }
    localObject3 = ((RecyclerView)localObject1).getAdapter();
    s.checkNotNull(localObject3);
    localObject1 = this.HIY;
    if (localObject1 == null)
    {
      s.bIx("galleryView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      s.checkNotNull(localObject1);
      ((RecyclerView.a)localObject3).e(0, ((RecyclerView.a)localObject1).getItemCount(), Integer.valueOf(2));
      AppMethodBeat.o(164826);
      return;
    }
  }
  
  public final boolean d(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164830);
    s.u(paramMediaItem, "media");
    Log.i("MicroMsg.GalleryPickerFragment", s.X("[onItemLongClick] media=", paramMediaItem.toSimpleString()));
    AppMethodBeat.o(164830);
    return true;
  }
  
  public final void e(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(164833);
    s.u(paramMediaItem, "media");
    Log.i("MicroMsg.GalleryPickerFragment", s.X("[onItemClick] media=", paramMediaItem.toSimpleString()));
    if ((this.HIU.size() >= 9) && (!this.HIU.contains(paramMediaItem)))
    {
      AppMethodBeat.o(164833);
      return;
    }
    f(paramMediaItem);
    Object localObject2 = this.HJa;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("appBarLayout");
      localObject1 = null;
    }
    ((AppBarLayout)localObject1).c(true, true, true);
    localObject2 = this.HIY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("galleryView");
      localObject1 = null;
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      paramMediaItem = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
      AppMethodBeat.o(164833);
      throw paramMediaItem;
    }
    localObject1 = i.c((i)localObject1, paramMediaItem.HHJ);
    if ((localObject1 instanceof com.tencent.mm.ui.base.a.b)) {}
    for (localObject1 = (com.tencent.mm.ui.base.a.b)localObject1;; localObject1 = null)
    {
      if ((localObject1 != null) && (!this.HIV.HJm.contains(paramMediaItem)) && (this.HIU.size() < 9)) {
        ((MediaItemView)((com.tencent.mm.ui.base.a.b)localObject1).view).uu(true);
      }
      AppMethodBeat.o(164833);
      return;
    }
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(164827);
    super.onActivityCreated(paramBundle);
    paramBundle = e.HJS;
    e.apC();
    e.a(e.HJS, (q)new GalleryPickerFragment.e(this));
    paramBundle = e.HJS;
    e.p((m)new GalleryPickerFragment.f(this));
    AppMethodBeat.o(164827);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(164829);
    s.u(paramLayoutInflater, "inflater");
    paramBundle = paramLayoutInflater.inflate(b.f.gallery_picker_view, paramViewGroup, false);
    s.s(paramBundle, "view");
    paramLayoutInflater = paramBundle.findViewById(b.e.gallery_view);
    s.s(paramLayoutInflater, "view.findViewById(R.id.gallery_view)");
    this.HIY = ((RecyclerView)paramLayoutInflater);
    paramLayoutInflater = paramBundle.findViewById(b.e.preview_container);
    s.s(paramLayoutInflater, "view.findViewById(R.id.preview_container)");
    this.HIZ = ((MMMediaCropLayout)paramLayoutInflater);
    paramViewGroup = this.HIZ;
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null)
    {
      s.bIx("previewContainer");
      paramLayoutInflater = null;
    }
    paramLayoutInflater.getLayoutParams().height = ((int)(getResources().getDisplayMetrics().widthPixels * 3.5F / 3.0F));
    paramLayoutInflater.requestLayout();
    paramLayoutInflater.setOnClickListener(new GalleryPickerFragment..ExternalSyntheticLambda0(this));
    paramLayoutInflater = paramBundle.findViewById(b.e.multi_selected_icon);
    s.s(paramLayoutInflater, "view.findViewById(R.id.multi_selected_icon)");
    this.HJb = ((ImageView)paramLayoutInflater);
    paramViewGroup = this.HJb;
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null)
    {
      s.bIx("multiSelectedIcon");
      paramLayoutInflater = null;
    }
    paramLayoutInflater.setBackground(this.HJc);
    paramViewGroup = this.HJb;
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null)
    {
      s.bIx("multiSelectedIcon");
      paramLayoutInflater = null;
    }
    paramLayoutInflater.setOnClickListener(new GalleryPickerFragment..ExternalSyntheticLambda1(this));
    paramViewGroup = this.HJb;
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null)
    {
      s.bIx("multiSelectedIcon");
      paramLayoutInflater = null;
    }
    paramLayoutInflater.setVisibility(8);
    Object localObject1 = new SpeedGirdLayoutManager(getContext());
    paramLayoutInflater = this.HIY;
    if (paramLayoutInflater == null)
    {
      s.bIx("galleryView");
      paramLayoutInflater = null;
      paramLayoutInflater.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      paramLayoutInflater = this.HIY;
      if (paramLayoutInflater != null) {
        break label695;
      }
      s.bIx("galleryView");
      paramLayoutInflater = null;
      label299:
      paramLayoutInflater.setAdapter((RecyclerView.a)this.HIV);
      paramLayoutInflater = this.HIY;
      if (paramLayoutInflater != null) {
        break label698;
      }
      s.bIx("galleryView");
      paramLayoutInflater = null;
      label327:
      paramLayoutInflater.a((RecyclerView.h)new GalleryPickerFragment.b(this));
      Object localObject2 = new d();
      paramViewGroup = this.HIY;
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        s.bIx("galleryView");
        paramLayoutInflater = null;
      }
      paramLayoutInflater.setItemAnimator((RecyclerView.f)localObject2);
      paramViewGroup = this.HIY;
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        s.bIx("galleryView");
        paramLayoutInflater = null;
      }
      paramLayoutInflater.setHasFixedSize(true);
      localObject2 = new RecyclerView.m();
      ((RecyclerView.m)localObject2).bD(1, 80);
      ((RecyclerView.m)localObject2).bD(2, 60);
      paramViewGroup = this.HIY;
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        s.bIx("galleryView");
        paramLayoutInflater = null;
      }
      paramLayoutInflater.setRecycledViewPool((RecyclerView.m)localObject2);
      ((SpeedGirdLayoutManager)localObject1).setItemPrefetchEnabled(true);
      ((LinearLayoutManager)localObject1).bXK = 30;
      this.HIV.HJn = ((a.c)this);
      this.HIV.HJp = ((MediaItemView.b)this);
      this.HIV.HJo = ((a.d)this);
      paramBundle.findViewById(b.e.folder_name_tv).setOnClickListener(new GalleryPickerFragment..ExternalSyntheticLambda2(this, (ImageView)paramBundle.findViewById(b.e.arrow_iv)));
      localObject1 = (TextView)paramBundle.findViewById(b.e.folder_name_tv);
      paramLayoutInflater = paramBundle.findViewById(b.e.appbar_layout);
      s.s(paramLayoutInflater, "view.findViewById(R.id.appbar_layout)");
      this.HJa = ((AppBarLayout)paramLayoutInflater);
      paramLayoutInflater = paramBundle.findViewById(b.e.folder_chooser_view);
      s.s(paramLayoutInflater, "view.findViewById(R.id.folder_chooser_view)");
      this.HIX = ((RecyclerView)paramLayoutInflater);
      paramLayoutInflater = this.HIX;
      if (paramLayoutInflater != null) {
        break label701;
      }
      s.bIx("albumChooserView");
      paramLayoutInflater = null;
      label602:
      getContext();
      paramLayoutInflater.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramViewGroup = this.HIX;
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        s.bIx("albumChooserView");
        paramLayoutInflater = null;
      }
      paramLayoutInflater.setHasFixedSize(true);
      paramLayoutInflater = this.HIX;
      if (paramLayoutInflater != null) {
        break label704;
      }
      s.bIx("albumChooserView");
      paramLayoutInflater = null;
    }
    label695:
    label698:
    label701:
    label704:
    for (;;)
    {
      paramLayoutInflater.setAdapter((RecyclerView.a)this.HIW);
      new GalleryPickerFragment.c((TextView)localObject1, this);
      AppMethodBeat.o(164829);
      throw null;
      break;
      break label299;
      break label327;
      break label602;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(164828);
    super.onDestroy();
    e locale = e.HJS;
    e.onRelease();
    AppMethodBeat.o(164828);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(164838);
    super.onPause();
    MMMediaCropLayout localMMMediaCropLayout2 = this.HIZ;
    MMMediaCropLayout localMMMediaCropLayout1 = localMMMediaCropLayout2;
    if (localMMMediaCropLayout2 == null)
    {
      s.bIx("previewContainer");
      localMMMediaCropLayout1 = null;
    }
    localMMMediaCropLayout1.getVideoView().onUIPause();
    AppMethodBeat.o(164838);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(164837);
    super.onResume();
    MMMediaCropLayout localMMMediaCropLayout2 = this.HIZ;
    MMMediaCropLayout localMMMediaCropLayout1 = localMMMediaCropLayout2;
    if (localMMMediaCropLayout2 == null)
    {
      s.bIx("previewContainer");
      localMMMediaCropLayout1 = null;
    }
    localMMMediaCropLayout1.getVideoView().onUIResume();
    AppMethodBeat.o(164837);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$animator$1", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends f
  {
    public final boolean t(RecyclerView.v paramv)
    {
      AppMethodBeat.i(289287);
      s.u(paramv, "viewHolder");
      AppMethodBeat.o(289287);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment
 * JD-Core Version:    0.7.0.1
 */