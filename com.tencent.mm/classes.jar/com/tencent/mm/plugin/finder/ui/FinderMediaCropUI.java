package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.v;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.finder.video.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import d.g;
import d.g.a.m;
import d.g.b.u;
import d.g.b.v.d;
import d.g.b.v.f;
import d.g.b.w;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "actionBarLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActionBarLayout", "()Landroid/view/View;", "actionBarLayout$delegate", "Lkotlin/Lazy;", "calculateCallback", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "getCalculateCallback", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "editBtn", "getEditBtn", "editBtn$delegate", "footer", "getFooter", "footer$delegate", "hasDestroyVideoView", "", "getHasDestroyVideoView", "()Z", "setHasDestroyVideoView", "(Z)V", "isFromAppBrand", "isFromAppBrand$delegate", "isPreviewTvChange", "isSwitchNormalMode", "mediaExtraMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "value", "", "previewId", "setPreviewId", "(J)V", "previewNumTv", "Landroid/widget/TextView;", "getPreviewNumTv", "()Landroid/widget/TextView;", "previewNumTv$delegate", "previewRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getPreviewRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "previewRecyclerView$delegate", "processDialogRunnable", "Ljava/lang/Runnable;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSelectPathList", "()Ljava/util/ArrayList;", "selectPathList$delegate", "switchVLogCheckbox", "Landroid/widget/CheckBox;", "getSwitchVLogCheckbox", "()Landroid/widget/CheckBox;", "switchVLogCheckbox$delegate", "switchVLogLayout", "getSwitchVLogLayout", "switchVLogLayout$delegate", "tipDialog", "Landroid/app/Dialog;", "vLogCropRect", "Landroid/graphics/Rect;", "vlogVideoPath", "getVlogVideoPath", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setVlogVideoPath", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "canEnableMultiImage", "checkCropInfo", "", "type", "", "path", "", "matrix", "Landroid/graphics/Matrix;", "cropRect", "contentRect", "viewRect", "position", "initCropRect", "checkIsAllImage", "defaultPreview", "getDefaultVideoVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getForceOrientation", "getLayoutId", "getMenuText", "initView", "isInVLogMode", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onGenerateMedia", "selectedMedias", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "isSuccessfully", "onPause", "onPreviewItem", "view", "item", "onResume", "reloadVLogFake", "setWindowStyle", "showProcessDialog", "delay", "updateOptionMenu", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "MediaExtra", "PreviewItemView", "plugin-finder_release"})
public final class FinderMediaCropUI
  extends MMFinderUI
{
  public static final FinderMediaCropUI.a rIv;
  private HashMap _$_findViewCache;
  private final Runnable rGT;
  private final LongSparseArray<FinderMediaCropUI.d> rIc;
  private final d.f rId;
  GalleryItem.MediaItem rIe;
  private final d.f rIf;
  private final d.f rIg;
  private final d.f rIh;
  private final d.f rIi;
  private final d.f rIj;
  private final d.f rIk;
  private final d.f rIl;
  private final d.f rIm;
  final d.f rIn;
  boolean rIo;
  private final WxMediaCropLayout.c rIp;
  private long rIq;
  private boolean rIr;
  private boolean rIs;
  private Rect rIt;
  private com.tencent.mm.plugin.gallery.picker.b.b rIu;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167382);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "selectPathList", "getSelectPathList()Ljava/util/ArrayList;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "cropLayout", "getCropLayout()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "actionBarLayout", "getActionBarLayout()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "previewRecyclerView", "getPreviewRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "footer", "getFooter()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "previewNumTv", "getPreviewNumTv()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "editBtn", "getEditBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "switchVLogLayout", "getSwitchVLogLayout()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "switchVLogCheckbox", "getSwitchVLogCheckbox()Landroid/widget/CheckBox;")), (d.l.k)w.a(new u(w.bn(FinderMediaCropUI.class), "isFromAppBrand", "isFromAppBrand()Z")) };
    rIv = new FinderMediaCropUI.a((byte)0);
    AppMethodBeat.o(167382);
  }
  
  public FinderMediaCropUI()
  {
    AppMethodBeat.i(167398);
    this.rIc = new LongSparseArray();
    this.rId = g.K((d.g.a.a)new FinderMediaCropUI.ac(this));
    this.rIf = g.K((d.g.a.a)new g(this));
    this.rIg = g.K((d.g.a.a)new e(this));
    this.rIh = g.K((d.g.a.a)new aa(this));
    this.rIi = g.K((d.g.a.a)new k(this));
    this.rIj = g.K((d.g.a.a)new z(this));
    this.rIk = g.K((d.g.a.a)new j(this));
    this.rIl = g.K((d.g.a.a)new ae(this));
    this.rIm = g.K((d.g.a.a)new ad(this));
    this.rIn = g.K((d.g.a.a)new FinderMediaCropUI.s(this));
    this.rIp = ((WxMediaCropLayout.c)new f(this));
    this.rGT = ((Runnable)new FinderMediaCropUI.ab(this));
    AppMethodBeat.o(167398);
  }
  
  private final void a(List<? extends GalleryItem.MediaItem> paramList, final m<? super List<? extends MediaSelectedData>, ? super Boolean, y> paramm)
  {
    AppMethodBeat.i(167396);
    com.tencent.mm.sdk.platformtools.ap.n(this.rGT, 300L);
    final v.d locald = new v.d();
    locald.KUO = ((Collection)paramList).size();
    final ArrayList localArrayList = new ArrayList(9);
    final v.f localf = new v.f();
    localf.KUQ = new Rect();
    paramList = ((Iterable)paramList).iterator();
    final int i = 0;
    if (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        d.a.j.fOc();
      }
      localObject1 = (GalleryItem.MediaItem)localObject1;
      localArrayList.add(new MediaSelectedData(-1));
      Object localObject2 = (FinderMediaCropUI.d)this.rIc.get(((GalleryItem.MediaItem)localObject1).sKk);
      String str = ((GalleryItem.MediaItem)localObject1).sKh;
      Matrix localMatrix = new Matrix(((FinderMediaCropUI.d)localObject2).rIF.cNu());
      Rect localRect1 = new Rect(((FinderMediaCropUI.d)localObject2).rIF.gUl);
      Rect localRect2 = new Rect(((FinderMediaCropUI.d)localObject2).rIF.pvE);
      localObject2 = new Rect(((FinderMediaCropUI.d)localObject2).rIF.viewRect);
      if (i == 0) {
        ((Rect)localf.KUQ).set(localRect1);
      }
      int j = ((GalleryItem.MediaItem)localObject1).getType();
      d.g.b.k.g(str, "path");
      Object localObject3 = (Rect)localf.KUQ;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if ((localRect1.isEmpty()) || (localRect2.isEmpty()))
      {
        localObject4 = getContext();
        d.g.b.k.g(localObject4, "context");
        localObject4 = new CropLayout((Context)localObject4);
        localObject5 = new View((Context)getContext());
        if (j != 2) {
          break label726;
        }
        localObject6 = com.tencent.mm.plugin.gallery.a.c.sTV;
        localObject6 = com.tencent.mm.plugin.gallery.a.c.aeB(str);
        CropLayout.a((CropLayout)localObject4, (View)localObject5, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height, null, null, null, 56);
        ((Rect)localObject2).set(0, 0, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        ((View)localObject5).setRight(((com.tencent.mm.plugin.sight.base.a)localObject6).width);
        ((View)localObject5).setBottom(((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        label399:
        ac.i("Finder.MediaCropUI", "[checkCropInfo] need to set default CropInfo. type=" + j + " position=" + i + " viewRect=" + localObject2 + " contentRect=" + localRect2 + " cropRect=" + localRect1);
        ((CropLayout)localObject4).getVisibilityRect().set((Rect)localObject3);
        localObject5 = cBP();
        d.g.b.k.g(localObject5, "cropLayout");
        j = ((WxMediaCropLayout)localObject5).getLeft();
        localObject5 = cBP();
        d.g.b.k.g(localObject5, "cropLayout");
        int k = ((WxMediaCropLayout)localObject5).getTop();
        localObject5 = cBP();
        d.g.b.k.g(localObject5, "cropLayout");
        int m = ((WxMediaCropLayout)localObject5).getRight();
        localObject5 = cBP();
        d.g.b.k.g(localObject5, "cropLayout");
        ((CropLayout)localObject4).f(true, j, k, m, ((WxMediaCropLayout)localObject5).getBottom());
        localMatrix.set(((CropLayout)localObject4).getMainMatrix());
        if (!((Rect)localObject3).isEmpty()) {
          break label795;
        }
        cBF().round(localRect1);
      }
      for (;;)
      {
        localRect2.set(((CropLayout)localObject4).getContentRect());
        ac.i("Finder.MediaCropUI", "onGenerateMedia, cropRect:" + localRect1 + ", contentRect:" + localRect1 + ", viewRect:" + localObject2);
        j = ((GalleryItem.MediaItem)localObject1).getType();
        localObject3 = this.rIu;
        if (localObject3 == null) {
          d.g.b.k.aVY("mediaTailor");
        }
        ((com.tencent.mm.plugin.gallery.picker.b.b)localObject3).a(str, j, localMatrix, localRect1, localRect2, (Rect)localObject2, i, cBX(), (m)new y((GalleryItem.MediaItem)localObject1, i, this, localArrayList, localf, paramm, locald));
        i += 1;
        break;
        label726:
        localObject6 = com.tencent.mm.sdk.platformtools.f.aKw(str);
        CropLayout.a((CropLayout)localObject4, (View)localObject5, ((BitmapFactory.Options)localObject6).outWidth, ((BitmapFactory.Options)localObject6).outHeight, null, null, null, 56);
        ((Rect)localObject2).set(0, 0, ((BitmapFactory.Options)localObject6).outWidth, ((BitmapFactory.Options)localObject6).outHeight);
        ((View)localObject5).setRight(((BitmapFactory.Options)localObject6).outWidth);
        ((View)localObject5).setBottom(((BitmapFactory.Options)localObject6).outHeight);
        break label399;
        label795:
        localRect1.set((Rect)localObject3);
      }
    }
    AppMethodBeat.o(167396);
  }
  
  private final RectF cBF()
  {
    AppMethodBeat.i(167392);
    Object localObject = getContext();
    d.g.b.k.g(localObject, "context");
    float f2 = ((AppCompatActivity)localObject).getResources().getDimension(2131165250);
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165298);
    localObject = cBP();
    d.g.b.k.g(localObject, "cropLayout");
    float f1 = ((WxMediaCropLayout)localObject).getWidth() * 3.5F / 3.0F;
    localObject = cBP();
    d.g.b.k.g(localObject, "cropLayout");
    int i = ((WxMediaCropLayout)localObject).getHeight();
    localObject = cBS();
    d.g.b.k.g(localObject, "footer");
    f2 = f2 + f3 + (i - ((View)localObject).getHeight() - f2 - f3 - aq.ej(getBaseContext()) - f1) / 2.0F;
    localObject = cBP();
    d.g.b.k.g(localObject, "cropLayout");
    f3 = ((WxMediaCropLayout)localObject).getLeft();
    localObject = cBP();
    d.g.b.k.g(localObject, "cropLayout");
    localObject = new RectF(f3, f2, ((WxMediaCropLayout)localObject).getRight(), f1 + f2);
    AppMethodBeat.o(167392);
    return localObject;
  }
  
  private TextView cBT()
  {
    AppMethodBeat.i(167388);
    TextView localTextView = (TextView)this.rIj.getValue();
    AppMethodBeat.o(167388);
    return localTextView;
  }
  
  private View cBU()
  {
    AppMethodBeat.i(203229);
    View localView = (View)this.rIl.getValue();
    AppMethodBeat.o(203229);
    return localView;
  }
  
  private final void cBW()
  {
    AppMethodBeat.i(167390);
    TextView localTextView = (TextView)findViewById(2131296376);
    Object localObject1 = cBO();
    d.g.b.k.g(localObject1, "selectPathList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label125:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localObject3;
      if (((FinderMediaCropUI.d)this.rIc.get(localMediaItem.sKk)).rIG != -1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label125;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    int i = ((List)localObject1).size();
    if (i > 0)
    {
      localObject1 = new StringBuilder();
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      localObject1 = ((AppCompatActivity)localObject2).getResources().getString(2131755779) + '(' + i + ')';
      localTextView.setText((CharSequence)localObject1);
      localObject1 = cBO();
      d.g.b.k.g(localObject1, "selectPathList");
      localObject2 = ((Iterable)localObject1).iterator();
      label228:
      if (!((Iterator)localObject2).hasNext()) {
        break label337;
      }
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (GalleryItem.MediaItem)localObject1;
      if (((FinderMediaCropUI.d)this.rIc.get(((GalleryItem.MediaItem)localObject3).sKk)).rIG == -1) {
        break label332;
      }
      i = 1;
      label276:
      if (i == 0) {
        break label335;
      }
      label280:
      if (localObject1 == null) {
        break label342;
      }
    }
    label332:
    label335:
    label337:
    label342:
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      AppMethodBeat.o(167390);
      return;
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131755779);
      d.g.b.k.g(localObject1, "context.resources.getString(R.string.app_finish)");
      break;
      i = 0;
      break label276;
      break label228;
      localObject1 = null;
      break label280;
    }
  }
  
  private static boolean cBX()
  {
    AppMethodBeat.i(203232);
    StringBuilder localStringBuilder = new StringBuilder("isInVLogMode: false, final check, IS_VLOG_BACKGROUND_MUX: ");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    ac.i("Finder.MediaCropUI", com.tencent.mm.plugin.finder.storage.b.czg());
    AppMethodBeat.o(203232);
    return false;
  }
  
  private final boolean cBY()
  {
    AppMethodBeat.i(203233);
    Object localObject = cBO();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((ArrayList)localObject).size());; localObject = null)
    {
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (((Integer)localObject).intValue() > 1) {
        break;
      }
      AppMethodBeat.o(203233);
      return false;
    }
    localObject = cBO();
    d.g.b.k.g(localObject, "selectPathList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
      d.g.b.k.g(localMediaItem, "it");
      if (localMediaItem.getType() == 2)
      {
        AppMethodBeat.o(203233);
        return false;
      }
    }
    AppMethodBeat.o(203233);
    return true;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203237);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(203237);
    return localView1;
  }
  
  public final void a(int paramInt, View paramView, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(203231);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramMediaItem, "item");
    if (paramView.getTag() != null)
    {
      ac.w("Finder.MediaCropUI", "this view is Animating");
      AppMethodBeat.o(203231);
      return;
    }
    Object localObject1 = cBR().m(this.rIq);
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.w)localObject1).asD;
      d.g.b.k.g(localObject1, "preHolder.itemView");
      ((View)localObject1).setFocusable(false);
    }
    this.rIq = paramMediaItem.sKk;
    localObject1 = cBO();
    d.g.b.k.g(localObject1, "selectPathList");
    localObject1 = (List)localObject1;
    int i = 0;
    localObject1 = ((List)localObject1).iterator();
    int j;
    label157:
    label162:
    Object localObject2;
    label267:
    long l;
    label340:
    boolean bool;
    if (((Iterator)localObject1).hasNext()) {
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).sKk == this.rIq)
      {
        j = 1;
        if (j == 0) {
          break label460;
        }
        if (i >= 0)
        {
          cBO().get(i);
          if (((FinderMediaCropUI.d)this.rIc.get(this.rIq)).rIG != -1) {
            break label475;
          }
          localObject1 = cBT();
          d.g.b.k.g(localObject1, "previewNumTv");
          ((TextView)localObject1).setText((CharSequence)"");
          localObject1 = cBT();
          d.g.b.k.g(localObject1, "previewNumTv");
          localObject2 = getContext();
          d.g.b.k.g(localObject2, "context");
          ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(2131233512));
        }
        paramView.setFocusable(true);
        paramView = cBR();
        d.g.b.k.g(paramView, "previewRecyclerView");
        paramView = paramView.getAdapter();
        if (paramView != null) {
          paramView.b(paramInt, new Object());
        }
        if (paramInt == 0) {
          cBP().setLockCropMediaId(paramMediaItem.sKk);
        }
        l = paramMediaItem.sKk;
        cBX();
        if (paramMediaItem.getType() != 2) {
          break label551;
        }
        paramInt = 1;
        localObject1 = (FinderMediaCropUI.d)this.rIc.get(this.rIq);
        paramView = cBP();
        paramMediaItem = paramMediaItem.cMQ();
        d.g.b.k.g(paramMediaItem, "item.originalPath");
        localObject2 = this.rIp;
        d.g.b.k.h(paramMediaItem, "mediaPath");
        ac.i("WxMediaCropLayout", "onPreview type: ".concat(String.valueOf(paramInt)));
        bool = false;
        if (paramView.oae != paramInt) {
          bool = true;
        }
        paramView.oae = paramInt;
        if (paramInt != 2) {
          break label556;
        }
        paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2, null, 16);
      }
    }
    for (;;)
    {
      ((FinderMediaCropUI.d)localObject1).a(paramView);
      AppMethodBeat.o(203231);
      return;
      j = 0;
      break label157;
      label460:
      i += 1;
      break;
      i = -1;
      break label162;
      label475:
      localObject1 = cBT();
      d.g.b.k.g(localObject1, "previewNumTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(i + 1));
      localObject1 = cBT();
      d.g.b.k.g(localObject1, "previewNumTv");
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(2131233534));
      break label267;
      label551:
      paramInt = 2;
      break label340;
      label556:
      if (paramInt == 1) {
        paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2);
      } else if (paramInt == 3) {
        paramView = WxMediaCropLayout.b(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2);
      } else {
        paramView = new WxMediaCropLayout.b(0L, "");
      }
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> cBO()
  {
    AppMethodBeat.i(167383);
    ArrayList localArrayList = (ArrayList)this.rId.getValue();
    AppMethodBeat.o(167383);
    return localArrayList;
  }
  
  public final WxMediaCropLayout cBP()
  {
    AppMethodBeat.i(167384);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.rIf.getValue();
    AppMethodBeat.o(167384);
    return localWxMediaCropLayout;
  }
  
  public final View cBQ()
  {
    AppMethodBeat.i(167385);
    View localView = (View)this.rIg.getValue();
    AppMethodBeat.o(167385);
    return localView;
  }
  
  public final RecyclerView cBR()
  {
    AppMethodBeat.i(167386);
    RecyclerView localRecyclerView = (RecyclerView)this.rIh.getValue();
    AppMethodBeat.o(167386);
    return localRecyclerView;
  }
  
  public final View cBS()
  {
    AppMethodBeat.i(167387);
    View localView = (View)this.rIi.getValue();
    AppMethodBeat.o(167387);
    return localView;
  }
  
  public final CheckBox cBV()
  {
    AppMethodBeat.i(203230);
    CheckBox localCheckBox = (CheckBox)this.rIm.getValue();
    AppMethodBeat.o(203230);
    return localCheckBox;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131494062;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167391);
    super.initView();
    cBP().setShowBorder(true);
    cBP().post((Runnable)new l(this));
    cBT().setOnClickListener((View.OnClickListener)new m(this));
    ((View)this.rIk.getValue()).setOnClickListener((View.OnClickListener)new n(this));
    cBR().setHasFixedSize(true);
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    Object localObject2 = cBR();
    d.g.b.k.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.i)localObject1);
    ((LinearLayoutManager)localObject1).aw(true);
    localObject1 = cBR();
    d.g.b.k.g(localObject1, "previewRecyclerView");
    ((RecyclerView)localObject1).setItemAnimator((RecyclerView.f)new v());
    cBR().b((RecyclerView.h)new o(this));
    localObject1 = new b();
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new FinderMediaCropUI.c(this, (com.tencent.mm.ui.base.a.a)localObject1)).j(cBR());
    localObject2 = cBR();
    d.g.b.k.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
    ((b)localObject1).HDz = ((com.tencent.mm.ui.base.a.a.a)new p(this));
    localObject2 = cBO();
    d.g.b.k.g(localObject2, "selectPathList");
    localObject2 = ((Iterable)localObject2).iterator();
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      d.g.b.k.g(localMediaItem, "it");
      if (localMediaItem.getType() == 2)
      {
        i = 0;
        if (i != 0) {
          this.rIr = true;
        }
        localObject2 = cBV();
        d.g.b.k.g(localObject2, "switchVLogCheckbox");
        ((CheckBox)localObject2).setChecked(this.rIr);
        if (!cBY()) {
          break label446;
        }
        localObject2 = cBU();
        d.g.b.k.g(localObject2, "switchVLogLayout");
        ((View)localObject2).setVisibility(0);
        cBV().setOnClickListener((View.OnClickListener)new q(this, (b)localObject1));
      }
    }
    for (;;)
    {
      cBX();
      ((b)localObject1).setItems((List)cBO());
      if ((this.rIe == null) || (!cBY())) {
        break label467;
      }
      cBR().postDelayed((Runnable)new r(this, (b)localObject1), 500L);
      AppMethodBeat.o(167391);
      return;
      i = 1;
      break;
      label446:
      localObject2 = cBU();
      d.g.b.k.g(localObject2, "switchVLogLayout");
      ((View)localObject2).setVisibility(8);
    }
    label467:
    cBR().post((Runnable)new h(this));
    cBR().postDelayed((Runnable)new i(this), 500L);
    AppMethodBeat.o(167391);
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(167397);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    label113:
    Object localObject1;
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {
          d.g.b.k.fOy();
        }
        paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        if (paramIntent == null) {
          d.g.b.k.fOy();
        }
        Object localObject2 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
        this.rIo = false;
        paramIntent = cBO();
        d.g.b.k.g(paramIntent, "selectPathList");
        paramIntent = (List)paramIntent;
        paramInt1 = 0;
        paramIntent = paramIntent.iterator();
        if (paramIntent.hasNext()) {
          if (((GalleryItem.MediaItem)paramIntent.next()).sKk == this.rIq)
          {
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label133;
            }
          }
        }
        for (;;)
        {
          if (paramInt1 >= 0) {
            break label145;
          }
          AppMethodBeat.o(167397);
          return;
          paramInt2 = 0;
          break label113;
          label133:
          paramInt1 += 1;
          break;
          paramInt1 = -1;
        }
        label145:
        paramIntent = cBR();
        d.g.b.k.g(paramIntent, "previewRecyclerView");
        localObject1 = paramIntent.getAdapter();
        paramIntent = (Intent)localObject1;
        if (!(localObject1 instanceof b)) {
          paramIntent = null;
        }
        localObject1 = (b)paramIntent;
        if (localObject1 != null)
        {
          paramIntent = (GalleryItem.MediaItem)((b)localObject1).getItemAtPosition(paramInt1);
          Boolean localBoolean = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).dvj();
          d.g.b.k.g(localBoolean, "model.photo");
          if (localBoolean.booleanValue())
          {
            paramIntent.sKo = true;
            paramIntent.sKh = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).auN();
            ac.i("Finder.MediaCropUI", "[onActivityResult] edit photo output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).auN());
            localObject1 = (FinderMediaCropUI.d)this.rIc.get(paramIntent.sKk);
            localObject2 = cBP();
            long l = paramIntent.sKk;
            d.g.b.k.g(paramIntent, "item");
            paramIntent = paramIntent.cMQ();
            d.g.b.k.g(paramIntent, "item.originalPath");
            ((FinderMediaCropUI.d)localObject1).a(WxMediaCropLayout.a((WxMediaCropLayout)localObject2, l, paramIntent, true, this.rIp, null, 16));
            paramIntent = cBR();
            d.g.b.k.g(paramIntent, "previewRecyclerView");
            paramIntent = paramIntent.getAdapter();
            if (paramIntent != null)
            {
              paramIntent.cj(paramInt1);
              AppMethodBeat.o(167397);
            }
          }
          else
          {
            ac.i("Finder.MediaCropUI", "[onActivityResult] edit video output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath());
            paramIntent = GalleryItem.MediaItem.a(2, 0L, ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath(), ((CaptureDataManager.CaptureVideoNormalModel)localObject2).auN(), "");
            cBO().clear();
            cBO().add(paramIntent);
            ((b)localObject1).setItems((List)cBO());
            ((b)localObject1).notifyDataSetChanged();
            paramIntent = new FinderMediaCropUI.d();
            paramIntent.rIG = 1;
            this.rIc.put(0L, paramIntent);
            paramIntent = cBR().ch(0);
            if (paramIntent != null) {}
            for (paramIntent = paramIntent.asD;; paramIntent = null)
            {
              if (paramIntent == null) {
                d.g.b.k.fOy();
              }
              d.g.b.k.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
              localObject1 = cBO().get(0);
              d.g.b.k.g(localObject1, "selectPathList[0]");
              a(0, paramIntent, (GalleryItem.MediaItem)localObject1);
              break;
            }
          }
          AppMethodBeat.o(167397);
          return;
        }
        AppMethodBeat.o(167397);
        return;
      }
      paramIntent = aj.cl((Context)getContext());
      localObject1 = n.rPN;
      n.fE(paramIntent.x, paramIntent.y);
      paramIntent = new Point(paramIntent.x, paramIntent.y);
      localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.AsH;
      com.tencent.mm.plugin.vlog.ui.manager.c.setPreviewSize(paramIntent.x, paramIntent.y);
      paramIntent = cBR().ch(0);
      if (paramIntent == null) {
        break label674;
      }
    }
    label674:
    for (paramIntent = paramIntent.asD;; paramIntent = null)
    {
      if (paramIntent == null) {
        d.g.b.k.fOy();
      }
      d.g.b.k.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      localObject1 = cBO().get(0);
      d.g.b.k.g(localObject1, "selectPathList[0]");
      a(0, paramIntent, (GalleryItem.MediaItem)localObject1);
      AppMethodBeat.o(167397);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167395);
    super.onBackPressed();
    setResult(0);
    finish();
    AppMethodBeat.o(167395);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167389);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    hideTitleView();
    setTheme(2131821149);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.nX(true);
    getWindow().setFormat(-3);
    paramBundle = getIntent().getParcelableArrayListExtra("front_vlog_video");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      this.rIe = ((GalleryItem.MediaItem)paramBundle.get(0));
    }
    cBQ().post((Runnable)new t(this));
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    paramBundle.bottomMargin = aq.ej(getBaseContext());
    paramBundle.gravity = 80;
    Object localObject = cBS();
    d.g.b.k.g(localObject, "footer");
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    cBS().post((Runnable)new u(this));
    setActionbarColor(getResources().getColor(2131101053));
    findViewById(2131296417).setOnClickListener((View.OnClickListener)new v(this));
    findViewById(2131296376).setOnClickListener((View.OnClickListener)new w(this));
    cBW();
    paramBundle = new b.b();
    localObject = p.rQw;
    paramBundle.agu(p.cDv());
    localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    paramBundle.maxHeight = com.tencent.mm.plugin.finder.storage.b.cyf();
    localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    paramBundle.maxWidth = com.tencent.mm.plugin.finder.storage.b.cyg();
    localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    paramBundle.sMo = com.tencent.mm.plugin.finder.storage.b.cyh();
    this.rIu = new com.tencent.mm.plugin.gallery.picker.b.b(paramBundle);
    localObject = this.rIu;
    if (localObject == null) {
      d.g.b.k.aVY("mediaTailor");
    }
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).a((com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.j(paramBundle));
    localObject = this.rIu;
    if (localObject == null) {
      d.g.b.k.aVY("mediaTailor");
    }
    paramBundle = (com.tencent.mm.plugin.gallery.picker.b.a)new h(paramBundle);
    d.g.b.k.h(paramBundle, "<set-?>");
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).sMk = paramBundle;
    initView();
    AppMethodBeat.o(167389);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203234);
    super.onDestroy();
    AppMethodBeat.o(203234);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(167394);
    super.onPause();
    if (!this.rIo) {
      cBP().onUIPause();
    }
    AppMethodBeat.o(167394);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167393);
    super.onResume();
    Object localObject2;
    if (this.rIo)
    {
      localObject1 = cBR();
      d.g.b.k.g(localObject1, "previewRecyclerView");
      localObject2 = ((RecyclerView)localObject1).getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof b)) {
        localObject1 = null;
      }
      localObject1 = (b)localObject1;
      localObject2 = cBO();
      d.g.b.k.g(localObject2, "selectPathList");
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      int j;
      if (((Iterator)localObject2).hasNext()) {
        if (((GalleryItem.MediaItem)((Iterator)localObject2).next()).sKk == this.rIq)
        {
          j = 1;
          label121:
          if (j == 0) {
            break label141;
          }
        }
      }
      for (;;)
      {
        if (i >= 0) {
          break label153;
        }
        AppMethodBeat.o(167393);
        return;
        j = 0;
        break label121;
        label141:
        i += 1;
        break;
        i = -1;
      }
      label153:
      if (localObject1 != null)
      {
        localObject2 = (GalleryItem.MediaItem)((b)localObject1).getItemAtPosition(i);
        cBX();
        localObject1 = cBP();
        long l = ((GalleryItem.MediaItem)localObject2).sKk;
        d.g.b.k.g(localObject2, "item");
        localObject2 = ((GalleryItem.MediaItem)localObject2).cMQ();
        d.g.b.k.g(localObject2, "item.originalPath");
        ((WxMediaCropLayout)localObject1).a(l, (String)localObject2, true, this.rIp, true);
      }
      this.rIo = false;
      AppMethodBeat.o(167393);
      return;
    }
    Object localObject1 = cBP();
    ac.i("WxMediaCropLayout", "onUIResume");
    if (((WxMediaCropLayout)localObject1).mnn != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).mnn;
      if (localObject2 != null) {
        ((CommonVideoView)localObject2).onUIResume();
      }
    }
    if (((WxMediaCropLayout)localObject1).sOk != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).sOk;
      if (localObject2 != null) {
        ((VLogCompositionPlayView)localObject2).resume();
      }
    }
    if (((WxMediaCropLayout)localObject1).sOl != null)
    {
      localObject1 = ((WxMediaCropLayout)localObject1).sOl;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject1).dwl();
        AppMethodBeat.o(167393);
        return;
      }
    }
    AppMethodBeat.o(167393);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
  public static final class PreviewItemView
    extends FrameLayout
  {
    private final ImageView dhf;
    private final View gGk;
    private final int padding;
    private final int rII;
    private final View rIJ;
    private final int size;
    
    public PreviewItemView(Context paramContext)
    {
      super();
      AppMethodBeat.i(167351);
      paramContext = ai.getContext();
      d.g.b.k.g(paramContext, "MMApplicationContext.getContext()");
      this.rII = paramContext.getResources().getColor(2131100726);
      this.dhf = new ImageView(getContext());
      this.gGk = new View(getContext());
      this.rIJ = new View(getContext());
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165274));
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165300));
      this.dhf.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.rIJ.setBackgroundColor(this.rII);
      addView(this.rIJ, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.dhf, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.gGk;
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(2131101179));
      this.gGk.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167351);
    }
    
    public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(167352);
      paramContext = ai.getContext();
      d.g.b.k.g(paramContext, "MMApplicationContext.getContext()");
      this.rII = paramContext.getResources().getColor(2131100726);
      this.dhf = new ImageView(getContext());
      this.gGk = new View(getContext());
      this.rIJ = new View(getContext());
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165274));
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165300));
      this.dhf.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.rIJ.setBackgroundColor(this.rII);
      addView(this.rIJ, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.dhf, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.gGk;
      paramAttributeSet = getContext();
      d.g.b.k.g(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101179));
      this.gGk.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167352);
    }
    
    public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(167353);
      paramContext = ai.getContext();
      d.g.b.k.g(paramContext, "MMApplicationContext.getContext()");
      this.rII = paramContext.getResources().getColor(2131100726);
      this.dhf = new ImageView(getContext());
      this.gGk = new View(getContext());
      this.rIJ = new View(getContext());
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165274));
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165300));
      this.dhf.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.rIJ.setBackgroundColor(this.rII);
      addView(this.rIJ, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.dhf, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.gGk;
      paramAttributeSet = getContext();
      d.g.b.k.g(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101179));
      this.gGk.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167353);
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
      AppMethodBeat.i(167349);
      super.setFocusable(paramBoolean);
      if (paramBoolean)
      {
        this.rIJ.setVisibility(0);
        AppMethodBeat.o(167349);
        return;
      }
      this.rIJ.setVisibility(4);
      AppMethodBeat.o(167349);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(167350);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.gGk.setVisibility(4);
        AppMethodBeat.o(167350);
        return;
      }
      this.gGk.setVisibility(0);
      AppMethodBeat.o(167350);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<RecyclerView>
  {
    aa(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ad
    extends d.g.b.l
    implements d.g.a.a<CheckBox>
  {
    ad(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ae
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    ae(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView>
  {
    public b()
    {
      AppMethodBeat.i(167331);
      av(true);
      AppMethodBeat.o(167331);
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(167327);
      d.g.b.k.h(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (FinderMediaCropUI.PreviewItemView)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
      Object localObject = com.tencent.mm.plugin.gallery.picker.c.f.sMP;
      localObject = com.tencent.mm.plugin.gallery.picker.c.f.cNn();
      d.g.b.k.g(localMediaItem, "media");
      ((com.tencent.mm.loader.d)localObject).bF(localMediaItem).a(paramb.getImageView(), true);
      d.g.b.k.g(paramb, "itemView");
      if (((FinderMediaCropUI.d)FinderMediaCropUI.a(this.rIw).get(localMediaItem.sKk)).rIG != -1)
      {
        bool1 = true;
        paramb.setSelected(bool1);
        if (localMediaItem.sKk != FinderMediaCropUI.b(this.rIw)) {
          break label143;
        }
      }
      label143:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramb.setFocusable(bool1);
        AppMethodBeat.o(167327);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(203223);
      d.g.b.k.h(paramb, "holder");
      d.g.b.k.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(203223);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(167330);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).sKk;
      AppMethodBeat.o(167330);
      return l;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    e(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$calculateCallback$1", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-finder_release"})
  public static final class f
    implements WxMediaCropLayout.c
  {
    public final void a(int[] paramArrayOfInt, RectF paramRectF, boolean paramBoolean)
    {
      AppMethodBeat.i(203224);
      d.g.b.k.h(paramArrayOfInt, "mediaWH");
      d.g.b.k.h(paramRectF, "maxCropRect");
      RectF localRectF = new RectF(paramRectF);
      if (!paramBoolean) {
        paramRectF.set(FinderMediaCropUI.l(this.rIw));
      }
      for (;;)
      {
        ac.i("Finder.MediaCropUI", "[calculate] NEW=" + paramRectF + " OLD=" + localRectF + " isAdaptSrc=" + paramBoolean);
        AppMethodBeat.o(203224);
        return;
        Object localObject = n.rPN;
        localObject = n.fE(paramArrayOfInt[0], paramArrayOfInt[1]);
        ((Bundle)localObject).getInt("media_layout_width", paramArrayOfInt[0]);
        int i = ((Bundle)localObject).getInt("media_layout_height", paramArrayOfInt[1]);
        float f = (paramRectF.height() - i) / 2.0F;
        paramRectF.top += f;
        paramRectF.bottom -= f;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<WxMediaCropLayout>
  {
    g(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167357);
      RecyclerView.w localw = this.rIw.cBR().ci(this.fOm);
      if (localw != null)
      {
        localw.asD.callOnClick();
        AppMethodBeat.o(167357);
        return;
      }
      AppMethodBeat.o(167357);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167358);
      RecyclerView.w localw = this.rIw.cBR().ci(this.fOm);
      if (localw != null)
      {
        localw.asD.callOnClick();
        AppMethodBeat.o(167358);
        return;
      }
      AppMethodBeat.o(167358);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    j(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    k(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167361);
      RectF localRectF = FinderMediaCropUI.f(this.rIw);
      WxMediaCropLayout.a(this.rIw.cBP(), localRectF.width() * 0.5625F, localRectF.height(), localRectF);
      AppMethodBeat.o(167361);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167362);
      paramView = this.rIw.cBO();
      d.g.b.k.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).sKk == FinderMediaCropUI.b(this.rIw))
        {
          j = 1;
          label65:
          if (j == 0) {
            break label84;
          }
        }
      }
      for (;;)
      {
        if (i >= 0) {
          break label96;
        }
        AppMethodBeat.o(167362);
        return;
        j = 0;
        break label65;
        label84:
        i += 1;
        break;
        i = -1;
      }
      label96:
      int j = this.rIw.cBO().size();
      Object localObject = (GalleryItem.MediaItem)this.rIw.cBO().get(i);
      FinderMediaCropUI.g(this.rIw);
      if ((j <= 1) || (FinderMediaCropUI.cBZ()))
      {
        paramView = new Intent();
        paramView.putExtra("clear_list", true);
        this.rIw.setResult(-1, paramView);
        this.rIw.finish();
        AppMethodBeat.o(167362);
        return;
      }
      if (i == 0) {}
      for (j = 1;; j = i - 1)
      {
        paramView = this.rIw.cBR().ch(j);
        this.rIw.cBO().remove(localObject);
        localObject = this.rIw.cBR();
        d.g.b.k.g(localObject, "previewRecyclerView");
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).cl(i);
        }
        if (paramView != null)
        {
          paramView = paramView.asD;
          if (paramView != null) {
            paramView.callOnClick();
          }
        }
        FinderMediaCropUI.h(this.rIw);
        AppMethodBeat.o(167362);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167363);
      paramView = this.rIw.cBO();
      d.g.b.k.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      int j;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).sKk == FinderMediaCropUI.b(this.rIw))
        {
          j = 1;
          label67:
          if (j == 0) {
            break label89;
          }
        }
      }
      for (;;)
      {
        if (i >= 0) {
          break label104;
        }
        AppMethodBeat.o(167363);
        return;
        j = 0;
        break label67;
        label89:
        i += 1;
        break;
        i = -1;
      }
      label104:
      paramView = this.rIw.cBR();
      d.g.b.k.g(paramView, "previewRecyclerView");
      Object localObject1 = paramView.getAdapter();
      paramView = (View)localObject1;
      if (!(localObject1 instanceof FinderMediaCropUI.b)) {
        paramView = null;
      }
      paramView = (FinderMediaCropUI.b)paramView;
      if (paramView != null)
      {
        paramView = (GalleryItem.MediaItem)paramView.getItemAtPosition(i);
        localObject1 = (CharSequence)paramView.sKi;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            paramView.sKi = paramView.sKh;
          }
          d.g.b.k.g(paramView, "item");
          if ((paramView.getType() != 2) && (!FinderMediaCropUI.cBZ())) {
            break;
          }
          this.rIw.rIo = true;
          localObject1 = this.rIw.cBP();
          ac.i("WxMediaCropLayout", "onUIRelease");
          if (((WxMediaCropLayout)localObject1).mnn != null)
          {
            localObject2 = ((WxMediaCropLayout)localObject1).mnn;
            if (localObject2 != null) {
              ((CommonVideoView)localObject2).onUIDestroy();
            }
            ((WxMediaCropLayout)localObject1).mnn = null;
          }
          if (((WxMediaCropLayout)localObject1).sOk != null)
          {
            localObject2 = ((WxMediaCropLayout)localObject1).sOk;
            if (localObject2 != null) {
              ((VLogCompositionPlayView)localObject2).stop();
            }
            localObject2 = ((WxMediaCropLayout)localObject1).sOk;
            if (localObject2 != null) {
              ((VLogCompositionPlayView)localObject2).release();
            }
            ((WxMediaCropLayout)localObject1).sOk = null;
          }
          if (((WxMediaCropLayout)localObject1).sOl != null)
          {
            localObject2 = ((WxMediaCropLayout)localObject1).sOl;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject2).release();
            }
            ((WxMediaCropLayout)localObject1).sOl = null;
          }
          localObject3 = this.rIw.cBP().getCurrentCropInfo();
          localObject1 = ((WxMediaCropLayout.b)localObject3).gUl;
          f1 = ((WxMediaCropLayout.b)localObject3).viewRect.height() * 1.0F / ((WxMediaCropLayout.b)localObject3).viewRect.width() * ((WxMediaCropLayout.b)localObject3).gUl.width();
          i = ((WxMediaCropLayout.b)localObject3).gUl.left;
          j = (int)(((WxMediaCropLayout.b)localObject3).gUl.centerY() - f1 / 2.0F);
          int k = ((WxMediaCropLayout.b)localObject3).gUl.right;
          f2 = ((WxMediaCropLayout.b)localObject3).gUl.centerY();
          localObject4 = new Rect(i, j, k, (int)(f1 / 2.0F + f2));
          localObject2 = this.rIw.cBP();
          d.g.b.k.g(localObject2, "cropLayout");
          i = ((WxMediaCropLayout)localObject2).getHeight() / 2 - ((WxMediaCropLayout.b)localObject3).sOx.centerY();
          ((Rect)localObject4).top += i;
          ((Rect)localObject4).bottom += i;
          f1 = ((WxMediaCropLayout.b)localObject3).pvE.width() * 1.0F / ((WxMediaCropLayout.b)localObject3).gUl.width();
          localObject2 = new Matrix();
          ((Matrix)localObject2).setScale(f1, f1);
          ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).pvE.left - ((Rect)localObject4).left, ((WxMediaCropLayout.b)localObject3).pvE.top - ((Rect)localObject4).top);
          f1 = ((WxMediaCropLayout.b)localObject3).pvE.centerX();
          f2 = ((WxMediaCropLayout.b)localObject3).gUl.centerX();
          float f3 = ((WxMediaCropLayout.b)localObject3).pvE.centerY();
          float f4 = ((WxMediaCropLayout.b)localObject3).gUl.centerY();
          float f5 = i;
          localObject3 = aj.cl((Context)this.rIw.getContext());
          localObject4 = n.rPN;
          n.fE(((Point)localObject3).x, ((Point)localObject3).y);
          localObject3 = new Point(((Point)localObject3).x, ((Point)localObject3).y);
          localObject4 = com.tencent.mm.plugin.vlog.ui.manager.c.AsH;
          com.tencent.mm.plugin.vlog.ui.manager.c.setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
          localObject3 = com.tencent.mm.plugin.finder.utils.a.rOv;
          localObject3 = this.rIw.getContext();
          d.g.b.k.g(localObject3, "context");
          localObject3 = (Activity)localObject3;
          localObject4 = paramView.sKi;
          d.g.b.k.g(localObject4, "item.mRawEditPath");
          i = paramView.getType();
          boolean bool = FinderMediaCropUI.cBZ();
          com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, i, (Matrix)localObject2, (Rect)localObject1, new float[] { f1 - f2, f3 - f4 - f5 }, bool);
          AppMethodBeat.o(167363);
          return;
        }
        Object localObject3 = this.rIw.cBP().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).gUl;
        Object localObject2 = new Matrix();
        Object localObject4 = new float[9];
        ((WxMediaCropLayout.b)localObject3).eY.getValues((float[])localObject4);
        float f1 = localObject4[0];
        float f2 = localObject4[3];
        double d1 = f1 * f1;
        double d2 = f2;
        f1 = (float)Math.sqrt(f2 * d2 + d1);
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).pvE.left, ((WxMediaCropLayout.b)localObject3).pvE.top);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject3 = this.rIw.getContext();
        d.g.b.k.g(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.sKi;
        d.g.b.k.g(localObject4, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, paramView.getType(), (Matrix)localObject2, (Rect)localObject1);
        AppMethodBeat.o(167363);
        return;
      }
      AppMethodBeat.o(167363);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$4", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class o
    extends RecyclerView.h
  {
    private final float offset;
    
    o()
    {
      AppMethodBeat.i(167365);
      Context localContext = ai.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(2131165289);
      AppMethodBeat.o(167365);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(167364);
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(paramt, "state");
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      paramView = paramRecyclerView.bh(paramView);
      d.g.b.k.g(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.lv();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.rIw.cBO().size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(167364);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$5", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203225);
      paramView = this.rIw;
      Object localObject1 = this.rIw.cBV();
      d.g.b.k.g(localObject1, "switchVLogCheckbox");
      FinderMediaCropUI.a(paramView, ((CheckBox)localObject1).isChecked());
      if (FinderMediaCropUI.i(this.rIw))
      {
        this.rIK.setItems((List)this.rIw.cBO());
        localObject1 = this.rIw;
        paramView = this.rIw.cBR().ch(0);
        if (paramView == null) {
          break label132;
        }
      }
      label132:
      for (paramView = paramView.asD;; paramView = null)
      {
        if (paramView == null) {
          d.g.b.k.fOy();
        }
        d.g.b.k.g(paramView, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        Object localObject2 = this.rIw.cBO().get(0);
        d.g.b.k.g(localObject2, "selectPathList[0]");
        ((FinderMediaCropUI)localObject1).a(0, paramView, (GalleryItem.MediaItem)localObject2);
        AppMethodBeat.o(203225);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(203226);
      this.rIK.setItems(this.rIw.cBO().subList(0, 1));
      FinderMediaCropUI.a(this.rIw).put(0L, new FinderMediaCropUI.d());
      FinderMediaCropUI localFinderMediaCropUI = this.rIw;
      Object localObject = this.rIw.cBR().ch(0);
      if (localObject != null) {}
      for (localObject = ((RecyclerView.w)localObject).asD;; localObject = null)
      {
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        d.g.b.k.g(localObject, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        GalleryItem.MediaItem localMediaItem = this.rIw.rIe;
        if (localMediaItem == null) {
          d.g.b.k.fOy();
        }
        localFinderMediaCropUI.a(0, (View)localObject, localMediaItem);
        AppMethodBeat.o(203226);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167369);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      Object localObject = this.rIw.getContext();
      d.g.b.k.g(localObject, "context");
      localLayoutParams.topMargin = ((int)((AppCompatActivity)localObject).getResources().getDimension(2131165303) + com.tencent.mm.ui.ap.Q(this.rIw.getBaseContext(), (int)this.rIw.getResources().getDimension(2131165298)));
      localObject = this.rIw.cBQ();
      d.g.b.k.g(localObject, "actionBarLayout");
      ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      this.rIw.cBQ().requestLayout();
      AppMethodBeat.o(167369);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167370);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.bottomMargin = aq.ej(this.rIw.getBaseContext());
      localLayoutParams.gravity = 80;
      View localView = this.rIw.cBS();
      d.g.b.k.g(localView, "footer");
      localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(167370);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167371);
      this.rIw.setResult(0);
      this.rIw.finish();
      AppMethodBeat.o(167371);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167372);
      FinderMediaCropUI.c(this.rIw);
      AppMethodBeat.o(167372);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "isSuccessfully", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements m<List<? extends MediaSelectedData>, Boolean, y>
  {
    x(FinderMediaCropUI paramFinderMediaCropUI, List paramList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onGenerateMedia$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$$special$$inlined$apply$lambda$1"})
  static final class y
    extends d.g.b.l
    implements m<Boolean, b.f, y>
  {
    y(GalleryItem.MediaItem paramMediaItem, int paramInt, FinderMediaCropUI paramFinderMediaCropUI, ArrayList paramArrayList, v.f paramf, m paramm, v.d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    z(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI
 * JD-Core Version:    0.7.0.1
 */