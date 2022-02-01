package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
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
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import d.g;
import d.g.a.m;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "actionBarLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActionBarLayout", "()Landroid/view/View;", "actionBarLayout$delegate", "Lkotlin/Lazy;", "calculateCallback", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "getCalculateCallback", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "editBtn", "getEditBtn", "editBtn$delegate", "footer", "getFooter", "footer$delegate", "hasDestroyVideoView", "", "getHasDestroyVideoView", "()Z", "setHasDestroyVideoView", "(Z)V", "isFromAppBrand", "isFromAppBrand$delegate", "isPreviewTvChange", "isSwitchNormalMode", "mediaExtraMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "value", "", "previewId", "setPreviewId", "(J)V", "previewNumTv", "Landroid/widget/TextView;", "getPreviewNumTv", "()Landroid/widget/TextView;", "previewNumTv$delegate", "previewRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getPreviewRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "previewRecyclerView$delegate", "processDialogRunnable", "Ljava/lang/Runnable;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSelectPathList", "()Ljava/util/ArrayList;", "selectPathList$delegate", "switchVLogCheckbox", "Landroid/widget/CheckBox;", "getSwitchVLogCheckbox", "()Landroid/widget/CheckBox;", "switchVLogCheckbox$delegate", "switchVLogLayout", "getSwitchVLogLayout", "switchVLogLayout$delegate", "tipDialog", "Landroid/app/Dialog;", "vLogCropRect", "Landroid/graphics/Rect;", "vlogVideoPath", "getVlogVideoPath", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setVlogVideoPath", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "canEnableMultiImage", "checkCropInfo", "", "type", "", "path", "", "matrix", "Landroid/graphics/Matrix;", "cropRect", "contentRect", "viewRect", "position", "initCropRect", "checkIsAllImage", "defaultPreview", "getDefaultVideoVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getForceOrientation", "getLayoutId", "getMenuText", "initView", "isInVLogMode", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onGenerateMedia", "selectedMedias", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "isSuccessfully", "onPause", "onPreviewItem", "view", "item", "onResume", "reloadVLogFake", "setWindowStyle", "showProcessDialog", "delay", "updateOptionMenu", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "MediaExtra", "PreviewItemView", "plugin-finder_release"})
public final class FinderMediaCropUI
  extends MMFinderUI
{
  public static final FinderMediaCropUI.a sOr;
  private HashMap _$_findViewCache;
  private final LongSparseArray<FinderMediaCropUI.d> sNZ;
  private final Runnable sNh;
  private final d.f sOa;
  GalleryItem.MediaItem sOb;
  private final d.f sOc;
  private final d.f sOd;
  private final d.f sOe;
  private final d.f sOf;
  private final d.f sOg;
  private final d.f sOh;
  private final d.f sOi;
  private final d.f sOj;
  final d.f sOk;
  boolean sOl;
  private final WxMediaCropLayout.c sOm;
  private long sOn;
  private boolean sOo;
  private boolean sOp;
  private com.tencent.mm.plugin.gallery.picker.b.b sOq;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167382);
    sOr = new FinderMediaCropUI.a((byte)0);
    AppMethodBeat.o(167382);
  }
  
  public FinderMediaCropUI()
  {
    AppMethodBeat.i(167398);
    this.sNZ = new LongSparseArray();
    this.sOa = g.O((d.g.a.a)new ac(this));
    this.sOc = g.O((d.g.a.a)new g(this));
    this.sOd = g.O((d.g.a.a)new e(this));
    this.sOe = g.O((d.g.a.a)new aa(this));
    this.sOf = g.O((d.g.a.a)new k(this));
    this.sOg = g.O((d.g.a.a)new z(this));
    this.sOh = g.O((d.g.a.a)new j(this));
    this.sOi = g.O((d.g.a.a)new ae(this));
    this.sOj = g.O((d.g.a.a)new ad(this));
    this.sOk = g.O((d.g.a.a)new s(this));
    this.sOm = ((WxMediaCropLayout.c)new f(this));
    this.sNh = ((Runnable)new ab(this));
    AppMethodBeat.o(167398);
  }
  
  private final void a(List<? extends GalleryItem.MediaItem> paramList, final m<? super List<? extends MediaSelectedData>, ? super Boolean, z> paramm)
  {
    AppMethodBeat.i(167396);
    ar.o(this.sNh, 300L);
    final y.d locald = new y.d();
    locald.NiW = ((Collection)paramList).size();
    final ArrayList localArrayList = new ArrayList(9);
    final y.f localf = new y.f();
    localf.NiY = new Rect();
    paramList = ((Iterable)paramList).iterator();
    final int i = 0;
    if (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        d.a.j.gkd();
      }
      localObject1 = (GalleryItem.MediaItem)localObject1;
      localArrayList.add(new MediaSelectedData(-1));
      Object localObject2 = (FinderMediaCropUI.d)this.sNZ.get(((GalleryItem.MediaItem)localObject1).tRM);
      String str = ((GalleryItem.MediaItem)localObject1).tRJ;
      Matrix localMatrix = new Matrix(((FinderMediaCropUI.d)localObject2).sOB.cYr());
      Rect localRect1 = new Rect(((FinderMediaCropUI.d)localObject2).sOB.hpa);
      Rect localRect2 = new Rect(((FinderMediaCropUI.d)localObject2).sOB.qfO);
      localObject2 = new Rect(((FinderMediaCropUI.d)localObject2).sOB.viewRect);
      if (i == 0) {
        ((Rect)localf.NiY).set(localRect1);
      }
      int j = ((GalleryItem.MediaItem)localObject1).getType();
      d.g.b.p.g(str, "path");
      Object localObject3 = (Rect)localf.NiY;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if ((localRect1.isEmpty()) || (localRect2.isEmpty()))
      {
        localObject4 = getContext();
        d.g.b.p.g(localObject4, "context");
        localObject4 = new CropLayout((Context)localObject4);
        localObject5 = new View((Context)getContext());
        if (j != 2) {
          break label723;
        }
        localObject6 = c.ubl;
        localObject6 = c.ajS(str);
        CropLayout.a((CropLayout)localObject4, (View)localObject5, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height, null, null, null, 56);
        ((Rect)localObject2).set(0, 0, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        ((View)localObject5).setRight(((com.tencent.mm.plugin.sight.base.a)localObject6).width);
        ((View)localObject5).setBottom(((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        label399:
        ae.i("Finder.MediaCropUI", "[checkCropInfo] need to set default CropInfo. type=" + j + " position=" + i + " viewRect=" + localObject2 + " contentRect=" + localRect2 + " cropRect=" + localRect1);
        ((CropLayout)localObject4).getVisibilityRect().set((Rect)localObject3);
        localObject5 = cMs();
        d.g.b.p.g(localObject5, "cropLayout");
        j = ((WxMediaCropLayout)localObject5).getLeft();
        localObject5 = cMs();
        d.g.b.p.g(localObject5, "cropLayout");
        int k = ((WxMediaCropLayout)localObject5).getTop();
        localObject5 = cMs();
        d.g.b.p.g(localObject5, "cropLayout");
        int m = ((WxMediaCropLayout)localObject5).getRight();
        localObject5 = cMs();
        d.g.b.p.g(localObject5, "cropLayout");
        ((CropLayout)localObject4).e(true, j, k, m, ((WxMediaCropLayout)localObject5).getBottom());
        localMatrix.set(((CropLayout)localObject4).getMainMatrix());
        if (!((Rect)localObject3).isEmpty()) {
          break label792;
        }
        cMl().round(localRect1);
      }
      for (;;)
      {
        localRect2.set(((CropLayout)localObject4).getContentRect());
        ae.i("Finder.MediaCropUI", "onGenerateMedia, cropRect:" + localRect1 + ", contentRect:" + localRect1 + ", viewRect:" + localObject2);
        j = ((GalleryItem.MediaItem)localObject1).getType();
        localObject3 = this.sOq;
        if (localObject3 == null) {
          d.g.b.p.bdF("mediaTailor");
        }
        com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject3, str, j, localMatrix, localRect1, localRect2, (Rect)localObject2, i, (m)new y((GalleryItem.MediaItem)localObject1, i, this, localArrayList, localf, paramm, locald));
        i += 1;
        break;
        label723:
        localObject6 = com.tencent.mm.sdk.platformtools.h.aRz(str);
        CropLayout.a((CropLayout)localObject4, (View)localObject5, ((BitmapFactory.Options)localObject6).outWidth, ((BitmapFactory.Options)localObject6).outHeight, null, null, null, 56);
        ((Rect)localObject2).set(0, 0, ((BitmapFactory.Options)localObject6).outWidth, ((BitmapFactory.Options)localObject6).outHeight);
        ((View)localObject5).setRight(((BitmapFactory.Options)localObject6).outWidth);
        ((View)localObject5).setBottom(((BitmapFactory.Options)localObject6).outHeight);
        break label399;
        label792:
        localRect1.set((Rect)localObject3);
      }
    }
    AppMethodBeat.o(167396);
  }
  
  private final boolean cMA()
  {
    AppMethodBeat.i(204627);
    Object localObject = cMr();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((ArrayList)localObject).size());; localObject = null)
    {
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      if (((Integer)localObject).intValue() > 1) {
        break;
      }
      AppMethodBeat.o(204627);
      return false;
    }
    localObject = cMr();
    d.g.b.p.g(localObject, "selectPathList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
      d.g.b.p.g(localMediaItem, "it");
      if (localMediaItem.getType() == 2)
      {
        AppMethodBeat.o(204627);
        return false;
      }
    }
    AppMethodBeat.o(204627);
    return true;
  }
  
  private final RectF cMl()
  {
    AppMethodBeat.i(167392);
    Object localObject = getContext();
    d.g.b.p.g(localObject, "context");
    float f2 = ((AppCompatActivity)localObject).getResources().getDimension(2131165250);
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165298);
    localObject = cMs();
    d.g.b.p.g(localObject, "cropLayout");
    float f1 = ((WxMediaCropLayout)localObject).getWidth() * 3.5F / 3.0F;
    localObject = cMs();
    d.g.b.p.g(localObject, "cropLayout");
    int i = ((WxMediaCropLayout)localObject).getHeight();
    localObject = cMv();
    d.g.b.p.g(localObject, "footer");
    f2 = f2 + f3 + (i - ((View)localObject).getHeight() - f2 - f3 - as.en(getBaseContext()) - f1) / 2.0F;
    localObject = cMs();
    d.g.b.p.g(localObject, "cropLayout");
    f3 = ((WxMediaCropLayout)localObject).getLeft();
    localObject = cMs();
    d.g.b.p.g(localObject, "cropLayout");
    localObject = new RectF(f3, f2, ((WxMediaCropLayout)localObject).getRight(), f1 + f2);
    AppMethodBeat.o(167392);
    return localObject;
  }
  
  private TextView cMw()
  {
    AppMethodBeat.i(167388);
    TextView localTextView = (TextView)this.sOg.getValue();
    AppMethodBeat.o(167388);
    return localTextView;
  }
  
  private View cMx()
  {
    AppMethodBeat.i(204624);
    View localView = (View)this.sOi.getValue();
    AppMethodBeat.o(204624);
    return localView;
  }
  
  private final void cMz()
  {
    AppMethodBeat.i(167390);
    TextView localTextView = (TextView)findViewById(2131296376);
    Object localObject1 = cMr();
    d.g.b.p.g(localObject1, "selectPathList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label125:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localObject3;
      if (((FinderMediaCropUI.d)this.sNZ.get(localMediaItem.tRM)).sOC != -1) {}
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
      d.g.b.p.g(localObject2, "context");
      localObject1 = ((AppCompatActivity)localObject2).getResources().getString(2131755779) + '(' + i + ')';
      localTextView.setText((CharSequence)localObject1);
      localObject1 = cMr();
      d.g.b.p.g(localObject1, "selectPathList");
      localObject2 = ((Iterable)localObject1).iterator();
      label228:
      if (!((Iterator)localObject2).hasNext()) {
        break label337;
      }
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (GalleryItem.MediaItem)localObject1;
      if (((FinderMediaCropUI.d)this.sNZ.get(((GalleryItem.MediaItem)localObject3).tRM)).sOC == -1) {
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
      d.g.b.p.g(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131755779);
      d.g.b.p.g(localObject1, "context.resources.getString(R.string.app_finish)");
      break;
      i = 0;
      break label276;
      break label228;
      localObject1 = null;
      break label280;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204629);
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
    AppMethodBeat.o(204629);
    return localView1;
  }
  
  public final void a(int paramInt, View paramView, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(204626);
    d.g.b.p.h(paramView, "view");
    d.g.b.p.h(paramMediaItem, "item");
    if (paramView.getTag() != null)
    {
      ae.w("Finder.MediaCropUI", "this view is Animating");
      AppMethodBeat.o(204626);
      return;
    }
    Object localObject1 = cMu().m(this.sOn);
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.w)localObject1).auu;
      d.g.b.p.g(localObject1, "preHolder.itemView");
      ((View)localObject1).setFocusable(false);
    }
    this.sOn = paramMediaItem.tRM;
    localObject1 = cMr();
    d.g.b.p.g(localObject1, "selectPathList");
    localObject1 = (List)localObject1;
    int i = 0;
    localObject1 = ((List)localObject1).iterator();
    int j;
    label157:
    label162:
    Object localObject2;
    label267:
    long l;
    label336:
    boolean bool;
    if (((Iterator)localObject1).hasNext()) {
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).tRM == this.sOn)
      {
        j = 1;
        if (j == 0) {
          break label456;
        }
        if (i >= 0)
        {
          cMr().get(i);
          if (((FinderMediaCropUI.d)this.sNZ.get(this.sOn)).sOC != -1) {
            break label471;
          }
          localObject1 = cMw();
          d.g.b.p.g(localObject1, "previewNumTv");
          ((TextView)localObject1).setText((CharSequence)"");
          localObject1 = cMw();
          d.g.b.p.g(localObject1, "previewNumTv");
          localObject2 = getContext();
          d.g.b.p.g(localObject2, "context");
          ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(2131233512));
        }
        paramView.setFocusable(true);
        paramView = cMu();
        d.g.b.p.g(paramView, "previewRecyclerView");
        paramView = paramView.getAdapter();
        if (paramView != null) {
          paramView.b(paramInt, new Object());
        }
        if (paramInt == 0) {
          cMs().setLockCropMediaId(paramMediaItem.tRM);
        }
        l = paramMediaItem.tRM;
        if (paramMediaItem.getType() != 2) {
          break label547;
        }
        paramInt = 1;
        localObject1 = (FinderMediaCropUI.d)this.sNZ.get(this.sOn);
        paramView = cMs();
        paramMediaItem = paramMediaItem.cXO();
        d.g.b.p.g(paramMediaItem, "item.originalPath");
        localObject2 = this.sOm;
        d.g.b.p.h(paramMediaItem, "mediaPath");
        ae.i("WxMediaCropLayout", "onPreview type: ".concat(String.valueOf(paramInt)));
        bool = false;
        if (paramView.oKa != paramInt) {
          bool = true;
        }
        paramView.oKa = paramInt;
        if (paramInt != 2) {
          break label552;
        }
        paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2, null, 16);
      }
    }
    for (;;)
    {
      ((FinderMediaCropUI.d)localObject1).a(paramView);
      AppMethodBeat.o(204626);
      return;
      j = 0;
      break label157;
      label456:
      i += 1;
      break;
      i = -1;
      break label162;
      label471:
      localObject1 = cMw();
      d.g.b.p.g(localObject1, "previewNumTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(i + 1));
      localObject1 = cMw();
      d.g.b.p.g(localObject1, "previewNumTv");
      localObject2 = getContext();
      d.g.b.p.g(localObject2, "context");
      ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(2131233534));
      break label267;
      label547:
      paramInt = 2;
      break label336;
      label552:
      if (paramInt == 1) {
        paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2);
      } else {
        paramView = new WxMediaCropLayout.b(0L, "");
      }
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> cMr()
  {
    AppMethodBeat.i(167383);
    ArrayList localArrayList = (ArrayList)this.sOa.getValue();
    AppMethodBeat.o(167383);
    return localArrayList;
  }
  
  public final WxMediaCropLayout cMs()
  {
    AppMethodBeat.i(167384);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.sOc.getValue();
    AppMethodBeat.o(167384);
    return localWxMediaCropLayout;
  }
  
  public final View cMt()
  {
    AppMethodBeat.i(167385);
    View localView = (View)this.sOd.getValue();
    AppMethodBeat.o(167385);
    return localView;
  }
  
  public final RecyclerView cMu()
  {
    AppMethodBeat.i(167386);
    RecyclerView localRecyclerView = (RecyclerView)this.sOe.getValue();
    AppMethodBeat.o(167386);
    return localRecyclerView;
  }
  
  public final View cMv()
  {
    AppMethodBeat.i(167387);
    View localView = (View)this.sOf.getValue();
    AppMethodBeat.o(167387);
    return localView;
  }
  
  public final CheckBox cMy()
  {
    AppMethodBeat.i(204625);
    CheckBox localCheckBox = (CheckBox)this.sOj.getValue();
    AppMethodBeat.o(204625);
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
    cMs().setShowBorder(true);
    cMs().post((Runnable)new l(this));
    cMw().setOnClickListener((View.OnClickListener)new m(this));
    ((View)this.sOh.getValue()).setOnClickListener((View.OnClickListener)new n(this));
    cMu().setHasFixedSize(true);
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    Object localObject2 = cMu();
    d.g.b.p.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.i)localObject1);
    ((LinearLayoutManager)localObject1).aw(true);
    localObject1 = cMu();
    d.g.b.p.g(localObject1, "previewRecyclerView");
    ((RecyclerView)localObject1).setItemAnimator((RecyclerView.f)new v());
    cMu().b((RecyclerView.h)new o(this));
    localObject1 = new b();
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new c((com.tencent.mm.ui.base.a.a)localObject1)).j(cMu());
    localObject2 = cMu();
    d.g.b.p.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
    ((b)localObject1).JMe = ((com.tencent.mm.ui.base.a.a.a)new p(this));
    localObject2 = cMr();
    d.g.b.p.g(localObject2, "selectPathList");
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      d.g.b.p.g(localObject3, "it");
      if (((GalleryItem.MediaItem)localObject3).getType() == 2)
      {
        i = 0;
        if (i != 0) {
          this.sOo = true;
        }
        localObject2 = cMy();
        d.g.b.p.g(localObject2, "switchVLogCheckbox");
        ((CheckBox)localObject2).setChecked(this.sOo);
        if (!cMA()) {
          break label474;
        }
        localObject2 = cMx();
        d.g.b.p.g(localObject2, "switchVLogLayout");
        ((View)localObject2).setVisibility(0);
        cMy().setOnClickListener((View.OnClickListener)new q(this, (b)localObject1));
      }
    }
    for (;;)
    {
      localObject2 = new StringBuilder("isInVLogMode: false, final check, IS_VLOG_BACKGROUND_MUX: ");
      localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
      ae.i("Finder.MediaCropUI", com.tencent.mm.plugin.finder.storage.b.cHY());
      ((b)localObject1).setItems((List)cMr());
      if ((this.sOb == null) || (!cMA())) {
        break label495;
      }
      cMu().postDelayed((Runnable)new r(this, (b)localObject1), 500L);
      AppMethodBeat.o(167391);
      return;
      i = 1;
      break;
      label474:
      localObject2 = cMx();
      d.g.b.p.g(localObject2, "switchVLogLayout");
      ((View)localObject2).setVisibility(8);
    }
    label495:
    cMu().post((Runnable)new h(this));
    cMu().postDelayed((Runnable)new i(this), 500L);
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
          d.g.b.p.gkB();
        }
        paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        if (paramIntent == null) {
          d.g.b.p.gkB();
        }
        Object localObject2 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
        this.sOl = false;
        paramIntent = cMr();
        d.g.b.p.g(paramIntent, "selectPathList");
        paramIntent = (List)paramIntent;
        paramInt1 = 0;
        paramIntent = paramIntent.iterator();
        if (paramIntent.hasNext()) {
          if (((GalleryItem.MediaItem)paramIntent.next()).tRM == this.sOn)
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
        paramIntent = cMu();
        d.g.b.p.g(paramIntent, "previewRecyclerView");
        localObject1 = paramIntent.getAdapter();
        paramIntent = (Intent)localObject1;
        if (!(localObject1 instanceof b)) {
          paramIntent = null;
        }
        localObject1 = (b)paramIntent;
        if (localObject1 != null)
        {
          paramIntent = (GalleryItem.MediaItem)((b)localObject1).getItemAtPosition(paramInt1);
          Boolean localBoolean = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).dIV();
          d.g.b.p.g(localBoolean, "model.photo");
          if (localBoolean.booleanValue())
          {
            paramIntent.tRQ = true;
            paramIntent.tRJ = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).axP();
            ae.i("Finder.MediaCropUI", "[onActivityResult] edit photo output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).axP());
            localObject1 = (FinderMediaCropUI.d)this.sNZ.get(paramIntent.tRM);
            localObject2 = cMs();
            long l = paramIntent.tRM;
            d.g.b.p.g(paramIntent, "item");
            paramIntent = paramIntent.cXO();
            d.g.b.p.g(paramIntent, "item.originalPath");
            ((FinderMediaCropUI.d)localObject1).a(WxMediaCropLayout.a((WxMediaCropLayout)localObject2, l, paramIntent, true, this.sOm, null, 16));
            paramIntent = cMu();
            d.g.b.p.g(paramIntent, "previewRecyclerView");
            paramIntent = paramIntent.getAdapter();
            if (paramIntent != null)
            {
              paramIntent.cj(paramInt1);
              AppMethodBeat.o(167397);
            }
          }
          else
          {
            ae.i("Finder.MediaCropUI", "[onActivityResult] edit video output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath());
            paramIntent = GalleryItem.MediaItem.a(2, 0L, ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath(), ((CaptureDataManager.CaptureVideoNormalModel)localObject2).axP(), "");
            cMr().clear();
            cMr().add(paramIntent);
            ((b)localObject1).setItems((List)cMr());
            ((b)localObject1).notifyDataSetChanged();
            paramIntent = new FinderMediaCropUI.d();
            paramIntent.sOC = 1;
            this.sNZ.put(0L, paramIntent);
            paramIntent = cMu().ch(0);
            if (paramIntent != null) {}
            for (paramIntent = paramIntent.auu;; paramIntent = null)
            {
              if (paramIntent == null) {
                d.g.b.p.gkB();
              }
              d.g.b.p.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
              localObject1 = cMr().get(0);
              d.g.b.p.g(localObject1, "selectPathList[0]");
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
      paramIntent = cMu().ch(0);
      if (paramIntent == null) {
        break label614;
      }
    }
    label614:
    for (paramIntent = paramIntent.auu;; paramIntent = null)
    {
      if (paramIntent == null) {
        d.g.b.p.gkB();
      }
      d.g.b.p.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      localObject1 = cMr().get(0);
      d.g.b.p.g(localObject1, "selectPathList[0]");
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
    com.tencent.mm.plugin.mmsight.d.ow(true);
    getWindow().setFormat(-3);
    paramBundle = getIntent().getParcelableArrayListExtra("front_vlog_video");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      this.sOb = ((GalleryItem.MediaItem)paramBundle.get(0));
    }
    cMt().post((Runnable)new FinderMediaCropUI.t(this));
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    paramBundle.bottomMargin = as.en(getBaseContext());
    paramBundle.gravity = 80;
    Object localObject = cMv();
    d.g.b.p.g(localObject, "footer");
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    cMv().post((Runnable)new FinderMediaCropUI.u(this));
    setActionbarColor(getResources().getColor(2131101053));
    findViewById(2131296417).setOnClickListener((View.OnClickListener)new FinderMediaCropUI.v(this));
    findViewById(2131296376).setOnClickListener((View.OnClickListener)new FinderMediaCropUI.w(this));
    cMz();
    paramBundle = new b.b();
    localObject = r.sYn;
    paramBundle.alQ(r.cOx());
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    paramBundle.maxHeight = com.tencent.mm.plugin.finder.storage.b.cHe();
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    paramBundle.maxWidth = com.tencent.mm.plugin.finder.storage.b.cHf();
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    paramBundle.tTM = com.tencent.mm.plugin.finder.storage.b.cHg();
    this.sOq = new com.tencent.mm.plugin.gallery.picker.b.b(paramBundle);
    localObject = this.sOq;
    if (localObject == null) {
      d.g.b.p.bdF("mediaTailor");
    }
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).a((com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.j(paramBundle));
    localObject = this.sOq;
    if (localObject == null) {
      d.g.b.p.bdF("mediaTailor");
    }
    paramBundle = (com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.h(paramBundle);
    d.g.b.p.h(paramBundle, "<set-?>");
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).tTI = paramBundle;
    initView();
    AppMethodBeat.o(167389);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204628);
    super.onDestroy();
    AppMethodBeat.o(204628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(167394);
    super.onPause();
    if (!this.sOl) {
      cMs().onUIPause();
    }
    AppMethodBeat.o(167394);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167393);
    super.onResume();
    Object localObject2;
    if (this.sOl)
    {
      localObject1 = cMu();
      d.g.b.p.g(localObject1, "previewRecyclerView");
      localObject2 = ((RecyclerView)localObject1).getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof b)) {
        localObject1 = null;
      }
      localObject1 = (b)localObject1;
      localObject2 = cMr();
      d.g.b.p.g(localObject2, "selectPathList");
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      int j;
      if (((Iterator)localObject2).hasNext()) {
        if (((GalleryItem.MediaItem)((Iterator)localObject2).next()).tRM == this.sOn)
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
        localObject1 = cMs();
        long l = ((GalleryItem.MediaItem)localObject2).tRM;
        d.g.b.p.g(localObject2, "item");
        localObject2 = ((GalleryItem.MediaItem)localObject2).cXO();
        d.g.b.p.g(localObject2, "item.originalPath");
        ((WxMediaCropLayout)localObject1).a(l, (String)localObject2, true, this.sOm, true);
      }
      this.sOl = false;
      AppMethodBeat.o(167393);
      return;
    }
    Object localObject1 = cMs();
    ae.i("WxMediaCropLayout", "onUIResume");
    if (((WxMediaCropLayout)localObject1).mST != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).mST;
      if (localObject2 != null) {
        ((CommonVideoView)localObject2).onUIResume();
      }
    }
    if (((WxMediaCropLayout)localObject1).tVJ != null)
    {
      localObject1 = ((WxMediaCropLayout)localObject1).tVJ;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject1).dJW();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends q
    implements d.g.a.a<RecyclerView>
  {
    aa(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167380);
      Object localObject = FinderMediaCropUI.d(this.sOs);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        ae.d("Finder.MediaCropUI", "tipDialog is show!");
        AppMethodBeat.o(167380);
        return;
        localObject = this.sOs;
        Context localContext = (Context)localObject;
        ((FinderMediaCropUI)localObject).getString(2131755906);
        FinderMediaCropUI.a((FinderMediaCropUI)localObject, (Dialog)com.tencent.mm.ui.base.h.b(localContext, ((FinderMediaCropUI)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)FinderMediaCropUI.ab.a.sOQ));
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends q
    implements d.g.a.a<ArrayList<GalleryItem.MediaItem>>
  {
    ac(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ad
    extends q
    implements d.g.a.a<CheckBox>
  {
    ad(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ae
    extends q
    implements d.g.a.a<View>
  {
    ae(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
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
      d.g.b.p.h(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (FinderMediaCropUI.PreviewItemView)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
      Object localObject = com.tencent.mm.plugin.gallery.picker.c.f.tUo;
      localObject = com.tencent.mm.plugin.gallery.picker.c.f.cYk();
      d.g.b.p.g(localMediaItem, "media");
      ((com.tencent.mm.loader.d)localObject).bH(localMediaItem).a(paramb.getImageView(), true);
      d.g.b.p.g(paramb, "itemView");
      if (((FinderMediaCropUI.d)FinderMediaCropUI.a(this.sOs).get(localMediaItem.tRM)).sOC != -1)
      {
        bool1 = true;
        paramb.setSelected(bool1);
        if (localMediaItem.tRM != FinderMediaCropUI.b(this.sOs)) {
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
      AppMethodBeat.i(204619);
      d.g.b.p.h(paramb, "holder");
      d.g.b.p.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(204619);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(167330);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).tRM;
      AppMethodBeat.o(167330);
      return l;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder_release"})
  public final class c
    extends android.support.v7.widget.a.a.a
  {
    int dMM;
    private int sOt;
    private int sOu;
    private int sOv;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> sOw;
    
    public c()
    {
      AppMethodBeat.i(167345);
      this.sOw = localObject;
      this.dMM = -1;
      this.sOt = -1;
      this.sOu = -1;
      AppMethodBeat.o(167345);
    }
    
    public final float K(RecyclerView.w paramw)
    {
      AppMethodBeat.i(167342);
      d.g.b.p.h(paramw, "viewHolder");
      AppMethodBeat.o(167342);
      return 0.295858F;
    }
    
    public final void L(RecyclerView.w paramw)
    {
      AppMethodBeat.i(167341);
      d.g.b.p.h(paramw, "viewHolder");
      AppMethodBeat.o(167341);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      AppMethodBeat.i(167344);
      d.g.b.p.h(paramRecyclerView, "recyclerView");
      d.g.b.p.h(paramw, "viewHolder");
      int i = android.support.v7.widget.a.a.a.dh(51);
      AppMethodBeat.o(167344);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.w paramw, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(167343);
      d.g.b.p.h(paramCanvas, "c");
      d.g.b.p.h(paramRecyclerView, "recyclerView");
      d.g.b.p.h(paramw, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramw, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(167343);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2)
    {
      AppMethodBeat.i(167338);
      d.g.b.p.h(paramRecyclerView, "recyclerView");
      d.g.b.p.h(paramw1, "viewHolder");
      d.g.b.p.h(paramw2, "target");
      int i = paramw1.lN();
      int j = paramw2.lN();
      ae.d("Finder.MediaCropUI", "[onMove] from=" + i + " to=" + j);
      com.tencent.mm.plugin.gallery.a.d.swap((List)FinderMediaCropUI.this.cMr(), i, j);
      this.sOw.aq(i, j);
      this.sOu = j;
      AppMethodBeat.o(167338);
      return true;
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.w paramw)
    {
      AppMethodBeat.i(167340);
      d.g.b.p.h(paramRecyclerView, "recyclerView");
      d.g.b.p.h(paramw, "viewHolder");
      super.d(paramRecyclerView, paramw);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772077);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramw));
      paramw.auu.startAnimation(paramRecyclerView);
      AppMethodBeat.o(167340);
    }
    
    public final void f(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(167339);
      super.f(paramw, paramInt);
      if (paramw != null)
      {
        Object localObject = paramw.auu;
        d.g.b.p.g(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772078);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramw, paramInt));
        paramw.auu.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(167339);
    }
    
    public final boolean no()
    {
      return true;
    }
    
    public final boolean np()
    {
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.w paramw) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(167333);
        d.g.b.p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        d.g.b.p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        ae.d("Finder.MediaCropUI", "finally change from=" + FinderMediaCropUI.c.b(this.sOx) + " to=" + FinderMediaCropUI.c.a(this.sOx));
        AppMethodBeat.o(167333);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(167334);
        d.g.b.p.h(paramAnimation, "animation");
        AppMethodBeat.o(167334);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(167332);
        d.g.b.p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        d.g.b.p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(167332);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(FinderMediaCropUI.c paramc, RecyclerView.w paramw, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(167336);
        d.g.b.p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        d.g.b.p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(167336);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(167337);
        d.g.b.p.h(paramAnimation, "animation");
        AppMethodBeat.o(167337);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(167335);
        d.g.b.p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        d.g.b.p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          FinderMediaCropUI.c.a(this.sOx, paramw.lN());
          FinderMediaCropUI.c.b(this.sOx, FinderMediaCropUI.c.a(this.sOx));
          this.sOx.dMM = FinderMediaCropUI.c.c(this.sOx);
        }
        AppMethodBeat.o(167335);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<View>
  {
    e(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$calculateCallback$1", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-finder_release"})
  public static final class f
    implements WxMediaCropLayout.c
  {
    public final void a(int[] paramArrayOfInt, RectF paramRectF)
    {
      AppMethodBeat.i(167355);
      d.g.b.p.h(paramArrayOfInt, "mediaWH");
      d.g.b.p.h(paramRectF, "maxCropRect");
      RectF localRectF = new RectF(paramRectF);
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject = com.tencent.mm.plugin.finder.utils.p.fS(paramArrayOfInt[0], paramArrayOfInt[1]);
      ((Bundle)localObject).getInt("media_layout_width", paramArrayOfInt[0]);
      int i = ((Bundle)localObject).getInt("media_layout_height", paramArrayOfInt[1]);
      float f = (paramRectF.height() - i) / 2.0F;
      paramRectF.top += f;
      paramRectF.bottom -= f;
      ae.i("Finder.MediaCropUI", "[calculate] NEW=" + paramRectF + " OLD=" + localRectF + " isAdaptSrc=true");
      AppMethodBeat.o(167355);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<WxMediaCropLayout>
  {
    g(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167357);
      RecyclerView.w localw = this.sOs.cMu().ci(this.gke);
      if (localw != null)
      {
        localw.auu.callOnClick();
        AppMethodBeat.o(167357);
        return;
      }
      AppMethodBeat.o(167357);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167358);
      RecyclerView.w localw = this.sOs.cMu().ci(this.gke);
      if (localw != null)
      {
        localw.auu.callOnClick();
        AppMethodBeat.o(167358);
        return;
      }
      AppMethodBeat.o(167358);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<View>
  {
    j(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<View>
  {
    k(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167361);
      RectF localRectF = FinderMediaCropUI.e(this.sOs);
      WxMediaCropLayout.a(this.sOs.cMs(), localRectF.width() * 0.5625F, localRectF.height(), localRectF);
      AppMethodBeat.o(167361);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167362);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = this.sOs.cMr();
      d.g.b.p.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).tRM == FinderMediaCropUI.b(this.sOs))
        {
          j = 1;
          label97:
          if (j == 0) {
            break label128;
          }
        }
      }
      for (;;)
      {
        if (i >= 0) {
          break label140;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167362);
        return;
        j = 0;
        break label97;
        label128:
        i += 1;
        break;
        i = -1;
      }
      label140:
      int j = this.sOs.cMr().size();
      localObject = (GalleryItem.MediaItem)this.sOs.cMr().get(i);
      FinderMediaCropUI.f(this.sOs);
      if (j <= 1)
      {
        paramView = new Intent();
        paramView.putExtra("clear_list", true);
        this.sOs.setResult(-1, paramView);
        this.sOs.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167362);
        return;
      }
      if (i == 0) {}
      for (j = 1;; j = i - 1)
      {
        paramView = this.sOs.cMu().ch(j);
        this.sOs.cMr().remove(localObject);
        localObject = this.sOs.cMu();
        d.g.b.p.g(localObject, "previewRecyclerView");
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).cl(i);
        }
        if (paramView != null)
        {
          paramView = paramView.auu;
          if (paramView != null) {
            paramView.callOnClick();
          }
        }
        FinderMediaCropUI.g(this.sOs);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167362);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167363);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = this.sOs.cMr();
      d.g.b.p.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      int j;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).tRM == FinderMediaCropUI.b(this.sOs))
        {
          j = 1;
          label99:
          if (j == 0) {
            break label133;
          }
        }
      }
      for (;;)
      {
        if (i >= 0) {
          break label148;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167363);
        return;
        j = 0;
        break label99;
        label133:
        i += 1;
        break;
        i = -1;
      }
      label148:
      paramView = this.sOs.cMu();
      d.g.b.p.g(paramView, "previewRecyclerView");
      localObject1 = paramView.getAdapter();
      paramView = (View)localObject1;
      if (!(localObject1 instanceof FinderMediaCropUI.b)) {
        paramView = null;
      }
      paramView = (FinderMediaCropUI.b)paramView;
      Object localObject2;
      Object localObject3;
      float f1;
      float f2;
      Object localObject4;
      if (paramView != null)
      {
        paramView = (GalleryItem.MediaItem)paramView.getItemAtPosition(i);
        localObject1 = (CharSequence)paramView.tRK;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label801;
        }
        i = 1;
        if (i != 0) {
          paramView.tRK = paramView.tRJ;
        }
        d.g.b.p.g(paramView, "item");
        if (paramView.getType() != 2) {
          break label807;
        }
        this.sOs.sOl = true;
        localObject1 = this.sOs.cMs();
        ae.i("WxMediaCropLayout", "onUIRelease");
        if (((WxMediaCropLayout)localObject1).mST != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).mST;
          if (localObject2 != null) {
            ((CommonVideoView)localObject2).onUIDestroy();
          }
          ((WxMediaCropLayout)localObject1).mST = null;
        }
        if (((WxMediaCropLayout)localObject1).tVJ != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).tVJ;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject2).release();
          }
          ((WxMediaCropLayout)localObject1).tVJ = null;
        }
        localObject3 = this.sOs.cMs().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).hpa;
        f1 = ((WxMediaCropLayout.b)localObject3).viewRect.height() * 1.0F / ((WxMediaCropLayout.b)localObject3).viewRect.width() * ((WxMediaCropLayout.b)localObject3).hpa.width();
        i = ((WxMediaCropLayout.b)localObject3).hpa.left;
        j = (int)(((WxMediaCropLayout.b)localObject3).hpa.centerY() - f1 / 2.0F);
        int k = ((WxMediaCropLayout.b)localObject3).hpa.right;
        f2 = ((WxMediaCropLayout.b)localObject3).hpa.centerY();
        localObject4 = new Rect(i, j, k, (int)(f1 / 2.0F + f2));
        localObject2 = this.sOs.cMs();
        d.g.b.p.g(localObject2, "cropLayout");
        i = ((WxMediaCropLayout)localObject2).getHeight() / 2 - ((WxMediaCropLayout.b)localObject3).tVU.centerY();
        ((Rect)localObject4).top += i;
        ((Rect)localObject4).bottom += i;
        f1 = ((WxMediaCropLayout.b)localObject3).qfO.width() * 1.0F / ((WxMediaCropLayout.b)localObject3).hpa.width();
        localObject2 = new Matrix();
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).qfO.left - ((Rect)localObject4).left, ((WxMediaCropLayout.b)localObject3).qfO.top - ((Rect)localObject4).top);
        f1 = ((WxMediaCropLayout.b)localObject3).qfO.centerX();
        f2 = ((WxMediaCropLayout.b)localObject3).hpa.centerX();
        float f3 = ((WxMediaCropLayout.b)localObject3).qfO.centerY();
        float f4 = ((WxMediaCropLayout.b)localObject3).hpa.centerY();
        float f5 = i;
        localObject3 = al.ck((Context)this.sOs.getContext());
        localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.fS(((Point)localObject3).x, ((Point)localObject3).y);
        new Point(((Point)localObject3).x, ((Point)localObject3).y);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.sVQ;
        localObject3 = this.sOs.getContext();
        d.g.b.p.g(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.tRK;
        d.g.b.p.g(localObject4, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, paramView.getType(), (Matrix)localObject2, (Rect)localObject1, new float[] { f1 - f2, f3 - f4 - f5 });
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167363);
        return;
        label801:
        i = 0;
        break;
        label807:
        localObject3 = this.sOs.cMs().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).hpa;
        localObject2 = new Matrix();
        localObject4 = new float[9];
        ((WxMediaCropLayout.b)localObject3).gR.getValues((float[])localObject4);
        f1 = localObject4[0];
        f2 = localObject4[3];
        double d1 = f1 * f1;
        double d2 = f2;
        f1 = (float)Math.sqrt(f2 * d2 + d1);
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).qfO.left, ((WxMediaCropLayout.b)localObject3).qfO.top);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.sVQ;
        localObject3 = this.sOs.getContext();
        d.g.b.p.g(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.tRK;
        d.g.b.p.g(localObject4, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, paramView.getType(), (Matrix)localObject2, (Rect)localObject1);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$4", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class o
    extends RecyclerView.h
  {
    private final float offset;
    
    o()
    {
      AppMethodBeat.i(167365);
      Context localContext = ak.getContext();
      d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(2131165289);
      AppMethodBeat.o(167365);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(167364);
      d.g.b.p.h(paramRect, "outRect");
      d.g.b.p.h(paramView, "view");
      d.g.b.p.h(paramRecyclerView, "parent");
      d.g.b.p.h(paramt, "state");
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      paramView = paramRecyclerView.bh(paramView);
      d.g.b.p.g(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.lN();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.sOs.cMr().size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(167364);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$5", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204620);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = this.sOs;
      localObject1 = this.sOs.cMy();
      d.g.b.p.g(localObject1, "switchVLogCheckbox");
      FinderMediaCropUI.a(paramView, ((CheckBox)localObject1).isChecked());
      if (FinderMediaCropUI.h(this.sOs))
      {
        this.sOG.setItems((List)this.sOs.cMr());
        localObject1 = this.sOs;
        paramView = this.sOs.cMu().ch(0);
        if (paramView == null) {
          break label173;
        }
      }
      label173:
      for (paramView = paramView.auu;; paramView = null)
      {
        if (paramView == null) {
          d.g.b.p.gkB();
        }
        d.g.b.p.g(paramView, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        Object localObject2 = this.sOs.cMr().get(0);
        d.g.b.p.g(localObject2, "selectPathList[0]");
        ((FinderMediaCropUI)localObject1).a(0, paramView, (GalleryItem.MediaItem)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204620);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(204621);
      this.sOG.setItems(this.sOs.cMr().subList(0, 1));
      FinderMediaCropUI.a(this.sOs).put(0L, new FinderMediaCropUI.d());
      FinderMediaCropUI localFinderMediaCropUI = this.sOs;
      Object localObject = this.sOs.cMu().ch(0);
      if (localObject != null) {}
      for (localObject = ((RecyclerView.w)localObject).auu;; localObject = null)
      {
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        d.g.b.p.g(localObject, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        GalleryItem.MediaItem localMediaItem = this.sOs.sOb;
        if (localMediaItem == null) {
          d.g.b.p.gkB();
        }
        localFinderMediaCropUI.a(0, (View)localObject, localMediaItem);
        AppMethodBeat.o(204621);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements d.g.a.a<Boolean>
  {
    s(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "isSuccessfully", "", "invoke"})
  static final class x
    extends q
    implements m<List<? extends MediaSelectedData>, Boolean, z>
  {
    x(FinderMediaCropUI paramFinderMediaCropUI, List paramList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onGenerateMedia$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$$special$$inlined$apply$lambda$1"})
  static final class y
    extends q
    implements m<Boolean, b.f, z>
  {
    y(GalleryItem.MediaItem paramMediaItem, int paramInt, FinderMediaCropUI paramFinderMediaCropUI, ArrayList paramArrayList, y.f paramf, m paramm, y.d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends q
    implements d.g.a.a<TextView>
  {
    z(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI
 * JD-Core Version:    0.7.0.1
 */