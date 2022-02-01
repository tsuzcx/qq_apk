package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.v;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import d.a.j;
import d.g;
import d.g.a.m;
import d.g.b.u;
import d.g.b.v.c;
import d.g.b.v.e;
import d.g.b.w;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "actionBarLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActionBarLayout", "()Landroid/view/View;", "actionBarLayout$delegate", "Lkotlin/Lazy;", "calculateCallback", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "getCalculateCallback", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "editBtn", "getEditBtn", "editBtn$delegate", "footer", "getFooter", "footer$delegate", "hasDestroyVideoView", "", "getHasDestroyVideoView", "()Z", "setHasDestroyVideoView", "(Z)V", "isFromAppBrand", "isFromAppBrand$delegate", "isPreviewTvChange", "isSwitchNormalMode", "mediaExtraMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "value", "", "previewId", "setPreviewId", "(J)V", "previewNumTv", "Landroid/widget/TextView;", "getPreviewNumTv", "()Landroid/widget/TextView;", "previewNumTv$delegate", "previewRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getPreviewRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "previewRecyclerView$delegate", "processDialogRunnable", "Ljava/lang/Runnable;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSelectPathList", "()Ljava/util/ArrayList;", "selectPathList$delegate", "switchVLogCheckbox", "Landroid/widget/CheckBox;", "getSwitchVLogCheckbox", "()Landroid/widget/CheckBox;", "switchVLogCheckbox$delegate", "switchVLogLayout", "getSwitchVLogLayout", "switchVLogLayout$delegate", "tipDialog", "Landroid/app/Dialog;", "vLogCropRect", "Landroid/graphics/Rect;", "vlogVideoPath", "getVlogVideoPath", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setVlogVideoPath", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "canEnableMultiImage", "checkCropInfo", "", "type", "", "path", "", "matrix", "Landroid/graphics/Matrix;", "cropRect", "contentRect", "viewRect", "position", "initCropRect", "checkIsAllImage", "defaultPreview", "getDefaultVideoVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getForceOrientation", "getLayoutId", "getMenuText", "initView", "isInVLogMode", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onGenerateMedia", "selectedMedias", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "isSuccessfully", "onPause", "onPreviewItem", "view", "item", "onResume", "reloadVLogFake", "setWindowStyle", "showProcessDialog", "delay", "updateOptionMenu", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "MediaExtra", "PreviewItemView", "plugin-finder_release"})
public final class FinderMediaCropUI
  extends MMFinderUI
{
  public static final a qMX;
  GalleryItem.MediaItem KYA;
  private final d.f KYB;
  private final d.f KYC;
  private boolean KYD;
  private boolean KYE;
  private Rect KYF;
  private HashMap _$_findViewCache;
  private final Runnable qLY;
  private final LongSparseArray<d> qMK;
  private final d.f qML;
  private final d.f qMM;
  private final d.f qMN;
  private final d.f qMO;
  private final d.f qMP;
  private final d.f qMQ;
  private final d.f qMR;
  final d.f qMS;
  boolean qMT;
  private final WxMediaCropLayout.c qMU;
  private long qMV;
  private com.tencent.mm.plugin.gallery.picker.b.b qMW;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167382);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "selectPathList", "getSelectPathList()Ljava/util/ArrayList;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "cropLayout", "getCropLayout()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "actionBarLayout", "getActionBarLayout()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "previewRecyclerView", "getPreviewRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "footer", "getFooter()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "previewNumTv", "getPreviewNumTv()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "editBtn", "getEditBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "switchVLogLayout", "getSwitchVLogLayout()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "switchVLogCheckbox", "getSwitchVLogCheckbox()Landroid/widget/CheckBox;")), (d.l.k)w.a(new u(w.bk(FinderMediaCropUI.class), "isFromAppBrand", "isFromAppBrand()Z")) };
    qMX = new a((byte)0);
    AppMethodBeat.o(167382);
  }
  
  public FinderMediaCropUI()
  {
    AppMethodBeat.i(167398);
    this.qMK = new LongSparseArray();
    this.qML = g.E((d.g.a.a)new aa(this));
    this.qMM = g.E((d.g.a.a)new g(this));
    this.qMN = g.E((d.g.a.a)new e(this));
    this.qMO = g.E((d.g.a.a)new y(this));
    this.qMP = g.E((d.g.a.a)new k(this));
    this.qMQ = g.E((d.g.a.a)new x(this));
    this.qMR = g.E((d.g.a.a)new j(this));
    this.KYB = g.E((d.g.a.a)new FinderMediaCropUI.ae(this));
    this.KYC = g.E((d.g.a.a)new FinderMediaCropUI.ad(this));
    this.qMS = g.E((d.g.a.a)new FinderMediaCropUI.q(this));
    this.qMU = ((WxMediaCropLayout.c)new f(this));
    this.qLY = ((Runnable)new FinderMediaCropUI.z(this));
    AppMethodBeat.o(167398);
  }
  
  private final void a(List<? extends GalleryItem.MediaItem> paramList, final m<? super List<? extends MediaSelectedData>, ? super Boolean, y> paramm)
  {
    AppMethodBeat.i(167396);
    com.tencent.mm.sdk.platformtools.aq.n(this.qLY, 300L);
    final v.c localc = new v.c();
    localc.Jhu = ((Collection)paramList).size();
    final ArrayList localArrayList = new ArrayList(9);
    final v.e locale = new v.e();
    locale.Jhw = new Rect();
    paramList = ((Iterable)paramList).iterator();
    final int i = 0;
    if (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        j.fvx();
      }
      localObject1 = (GalleryItem.MediaItem)localObject1;
      localArrayList.add(new MediaSelectedData(-1));
      Object localObject2 = (d)this.qMK.get(((GalleryItem.MediaItem)localObject1).rBs);
      String str = ((GalleryItem.MediaItem)localObject1).rBp;
      Matrix localMatrix = new Matrix(((d)localObject2).qNh.cAl());
      Rect localRect1 = new Rect(((d)localObject2).qNh.gtE);
      Rect localRect2 = new Rect(((d)localObject2).qNh.oSt);
      localObject2 = new Rect(((d)localObject2).qNh.viewRect);
      if (i == 0) {
        ((Rect)locale.Jhw).set(localRect1);
      }
      int j = ((GalleryItem.MediaItem)localObject1).getType();
      d.g.b.k.g(str, "path");
      Object localObject3 = (Rect)locale.Jhw;
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
        localObject6 = c.rMg;
        localObject6 = c.ZP(str);
        CropLayout.a((CropLayout)localObject4, (View)localObject5, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height, null, null, null, 56);
        ((Rect)localObject2).set(0, 0, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        ((View)localObject5).setRight(((com.tencent.mm.plugin.sight.base.a)localObject6).width);
        ((View)localObject5).setBottom(((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        label399:
        ad.i("Finder.MediaCropUI", "[checkCropInfo] need to set default CropInfo. type=" + j + " position=" + i + " viewRect=" + localObject2 + " contentRect=" + localRect2 + " cropRect=" + localRect1);
        ((CropLayout)localObject4).getVisibilityRect().set((Rect)localObject3);
        localObject5 = crd();
        d.g.b.k.g(localObject5, "cropLayout");
        j = ((WxMediaCropLayout)localObject5).getLeft();
        localObject5 = crd();
        d.g.b.k.g(localObject5, "cropLayout");
        int k = ((WxMediaCropLayout)localObject5).getTop();
        localObject5 = crd();
        d.g.b.k.g(localObject5, "cropLayout");
        int m = ((WxMediaCropLayout)localObject5).getRight();
        localObject5 = crd();
        d.g.b.k.g(localObject5, "cropLayout");
        ((CropLayout)localObject4).f(true, j, k, m, ((WxMediaCropLayout)localObject5).getBottom());
        localMatrix.set(((CropLayout)localObject4).getMainMatrix());
        if (!((Rect)localObject3).isEmpty()) {
          break label795;
        }
        cqX().round(localRect1);
      }
      for (;;)
      {
        localRect2.set(((CropLayout)localObject4).getContentRect());
        ad.i("Finder.MediaCropUI", "onGenerateMedia, cropRect:" + localRect1 + ", contentRect:" + localRect1 + ", viewRect:" + localObject2);
        j = ((GalleryItem.MediaItem)localObject1).getType();
        localObject3 = this.qMW;
        if (localObject3 == null) {
          d.g.b.k.aPZ("mediaTailor");
        }
        ((com.tencent.mm.plugin.gallery.picker.b.b)localObject3).a(str, j, localMatrix, localRect1, localRect2, (Rect)localObject2, i, fVy(), (m)new w((GalleryItem.MediaItem)localObject1, i, this, localArrayList, locale, paramm, localc));
        i += 1;
        break;
        label726:
        localObject6 = com.tencent.mm.sdk.platformtools.f.aFf(str);
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
  
  private final RectF cqX()
  {
    AppMethodBeat.i(167392);
    Object localObject = getContext();
    d.g.b.k.g(localObject, "context");
    float f2 = ((AppCompatActivity)localObject).getResources().getDimension(2131165250);
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165298);
    localObject = crd();
    d.g.b.k.g(localObject, "cropLayout");
    float f1 = ((WxMediaCropLayout)localObject).getWidth() * 3.5F / 3.0F;
    localObject = crd();
    d.g.b.k.g(localObject, "cropLayout");
    int i = ((WxMediaCropLayout)localObject).getHeight();
    localObject = crg();
    d.g.b.k.g(localObject, "footer");
    f2 = f2 + f3 + (i - ((View)localObject).getHeight() - f2 - f3 - com.tencent.mm.ui.aq.eb(getBaseContext()) - f1) / 2.0F;
    localObject = crd();
    d.g.b.k.g(localObject, "cropLayout");
    f3 = ((WxMediaCropLayout)localObject).getLeft();
    localObject = crd();
    d.g.b.k.g(localObject, "cropLayout");
    localObject = new RectF(f3, f2, ((WxMediaCropLayout)localObject).getRight(), f1 + f2);
    AppMethodBeat.o(167392);
    return localObject;
  }
  
  private TextView crh()
  {
    AppMethodBeat.i(167388);
    TextView localTextView = (TextView)this.qMQ.getValue();
    AppMethodBeat.o(167388);
    return localTextView;
  }
  
  private final void cri()
  {
    AppMethodBeat.i(167390);
    TextView localTextView = (TextView)findViewById(2131296376);
    Object localObject1 = crc();
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
      if (((d)this.qMK.get(localMediaItem.rBs)).qNi != -1) {}
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
      localObject1 = crc();
      d.g.b.k.g(localObject1, "selectPathList");
      localObject2 = ((Iterable)localObject1).iterator();
      label228:
      if (!((Iterator)localObject2).hasNext()) {
        break label337;
      }
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (GalleryItem.MediaItem)localObject1;
      if (((d)this.qMK.get(((GalleryItem.MediaItem)localObject3).rBs)).qNi == -1) {
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
  
  private View fVw()
  {
    AppMethodBeat.i(199258);
    View localView = (View)this.KYB.getValue();
    AppMethodBeat.o(199258);
    return localView;
  }
  
  private static boolean fVy()
  {
    AppMethodBeat.i(199261);
    StringBuilder localStringBuilder = new StringBuilder("isInVLogMode: false, final check, IS_VLOG_BACKGROUND_MUX: ");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    ad.i("Finder.MediaCropUI", com.tencent.mm.plugin.finder.storage.b.fUg());
    AppMethodBeat.o(199261);
    return false;
  }
  
  private final boolean fVz()
  {
    AppMethodBeat.i(199262);
    Object localObject = crc();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((ArrayList)localObject).size());; localObject = null)
    {
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if (((Integer)localObject).intValue() > 1) {
        break;
      }
      AppMethodBeat.o(199262);
      return false;
    }
    localObject = crc();
    d.g.b.k.g(localObject, "selectPathList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
      d.g.b.k.g(localMediaItem, "it");
      if (localMediaItem.getType() == 2)
      {
        AppMethodBeat.o(199262);
        return false;
      }
    }
    AppMethodBeat.o(199262);
    return true;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199266);
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
    AppMethodBeat.o(199266);
    return localView1;
  }
  
  public final void a(int paramInt, View paramView, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(199260);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramMediaItem, "item");
    if (paramView.getTag() != null)
    {
      ad.w("Finder.MediaCropUI", "this view is Animating");
      AppMethodBeat.o(199260);
      return;
    }
    Object localObject1 = crf().k(this.qMV);
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.v)localObject1).arI;
      d.g.b.k.g(localObject1, "preHolder.itemView");
      ((View)localObject1).setFocusable(false);
    }
    this.qMV = paramMediaItem.rBs;
    localObject1 = crc();
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
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).rBs == this.qMV)
      {
        j = 1;
        if (j == 0) {
          break label460;
        }
        if (i >= 0)
        {
          crc().get(i);
          if (((d)this.qMK.get(this.qMV)).qNi != -1) {
            break label475;
          }
          localObject1 = crh();
          d.g.b.k.g(localObject1, "previewNumTv");
          ((TextView)localObject1).setText((CharSequence)"");
          localObject1 = crh();
          d.g.b.k.g(localObject1, "previewNumTv");
          localObject2 = getContext();
          d.g.b.k.g(localObject2, "context");
          ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(2131233512));
        }
        paramView.setFocusable(true);
        paramView = crf();
        d.g.b.k.g(paramView, "previewRecyclerView");
        paramView = paramView.getAdapter();
        if (paramView != null) {
          paramView.b(paramInt, new Object());
        }
        if (paramInt == 0) {
          crd().setLockCropMediaId(paramMediaItem.rBs);
        }
        l = paramMediaItem.rBs;
        fVy();
        if (paramMediaItem.getType() != 2) {
          break label551;
        }
        paramInt = 1;
        localObject1 = (d)this.qMK.get(this.qMV);
        paramView = crd();
        paramMediaItem = paramMediaItem.czE();
        d.g.b.k.g(paramMediaItem, "item.originalPath");
        localObject2 = this.qMU;
        d.g.b.k.h(paramMediaItem, "mediaPath");
        ad.i("WxMediaCropLayout", "onPreview type: ".concat(String.valueOf(paramInt)));
        bool = false;
        if (paramView.nxe != paramInt) {
          bool = true;
        }
        paramView.nxe = paramInt;
        if (paramInt != 2) {
          break label556;
        }
        paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2, null, 16);
      }
    }
    for (;;)
    {
      ((d)localObject1).a(paramView);
      AppMethodBeat.o(199260);
      return;
      j = 0;
      break label157;
      label460:
      i += 1;
      break;
      i = -1;
      break label162;
      label475:
      localObject1 = crh();
      d.g.b.k.g(localObject1, "previewNumTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(i + 1));
      localObject1 = crh();
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
  
  public final ArrayList<GalleryItem.MediaItem> crc()
  {
    AppMethodBeat.i(167383);
    ArrayList localArrayList = (ArrayList)this.qML.getValue();
    AppMethodBeat.o(167383);
    return localArrayList;
  }
  
  public final WxMediaCropLayout crd()
  {
    AppMethodBeat.i(167384);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.qMM.getValue();
    AppMethodBeat.o(167384);
    return localWxMediaCropLayout;
  }
  
  public final View cre()
  {
    AppMethodBeat.i(167385);
    View localView = (View)this.qMN.getValue();
    AppMethodBeat.o(167385);
    return localView;
  }
  
  public final RecyclerView crf()
  {
    AppMethodBeat.i(167386);
    RecyclerView localRecyclerView = (RecyclerView)this.qMO.getValue();
    AppMethodBeat.o(167386);
    return localRecyclerView;
  }
  
  public final View crg()
  {
    AppMethodBeat.i(167387);
    View localView = (View)this.qMP.getValue();
    AppMethodBeat.o(167387);
    return localView;
  }
  
  public final CheckBox fVx()
  {
    AppMethodBeat.i(199259);
    CheckBox localCheckBox = (CheckBox)this.KYC.getValue();
    AppMethodBeat.o(199259);
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
    crd().setShowBorder(true);
    crd().post((Runnable)new l(this));
    crh().setOnClickListener((View.OnClickListener)new m(this));
    ((View)this.qMR.getValue()).setOnClickListener((View.OnClickListener)new n(this));
    crf().setHasFixedSize(true);
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    Object localObject2 = crf();
    d.g.b.k.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.i)localObject1);
    ((LinearLayoutManager)localObject1).aw(true);
    localObject1 = crf();
    d.g.b.k.g(localObject1, "previewRecyclerView");
    ((RecyclerView)localObject1).setItemAnimator((RecyclerView.f)new v());
    crf().b((RecyclerView.h)new o(this));
    localObject1 = new b();
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new c((com.tencent.mm.ui.base.a.a)localObject1)).j(crf());
    localObject2 = crf();
    d.g.b.k.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
    ((b)localObject1).GdK = ((com.tencent.mm.ui.base.a.a.a)new p(this));
    localObject2 = crc();
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
          this.KYD = true;
        }
        localObject2 = fVx();
        d.g.b.k.g(localObject2, "switchVLogCheckbox");
        ((CheckBox)localObject2).setChecked(this.KYD);
        if (!fVz()) {
          break label446;
        }
        localObject2 = fVw();
        d.g.b.k.g(localObject2, "switchVLogLayout");
        ((View)localObject2).setVisibility(0);
        fVx().setOnClickListener((View.OnClickListener)new FinderMediaCropUI.ab(this, (b)localObject1));
      }
    }
    for (;;)
    {
      fVy();
      ((b)localObject1).setItems((List)crc());
      if ((this.KYA == null) || (!fVz())) {
        break label467;
      }
      crf().postDelayed((Runnable)new FinderMediaCropUI.ac(this, (b)localObject1), 500L);
      AppMethodBeat.o(167391);
      return;
      i = 1;
      break;
      label446:
      localObject2 = fVw();
      d.g.b.k.g(localObject2, "switchVLogLayout");
      ((View)localObject2).setVisibility(8);
    }
    label467:
    crf().post((Runnable)new h(this));
    crf().postDelayed((Runnable)new i(this), 500L);
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
          d.g.b.k.fvU();
        }
        paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        if (paramIntent == null) {
          d.g.b.k.fvU();
        }
        Object localObject2 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
        this.qMT = false;
        paramIntent = crc();
        d.g.b.k.g(paramIntent, "selectPathList");
        paramIntent = (List)paramIntent;
        paramInt1 = 0;
        paramIntent = paramIntent.iterator();
        if (paramIntent.hasNext()) {
          if (((GalleryItem.MediaItem)paramIntent.next()).rBs == this.qMV)
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
        paramIntent = crf();
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
          Boolean localBoolean = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).dhC();
          d.g.b.k.g(localBoolean, "model.photo");
          if (localBoolean.booleanValue())
          {
            paramIntent.rBw = true;
            paramIntent.rBp = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).anX();
            ad.i("Finder.MediaCropUI", "[onActivityResult] edit photo output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).anX());
            localObject1 = (d)this.qMK.get(paramIntent.rBs);
            localObject2 = crd();
            long l = paramIntent.rBs;
            d.g.b.k.g(paramIntent, "item");
            paramIntent = paramIntent.czE();
            d.g.b.k.g(paramIntent, "item.originalPath");
            ((d)localObject1).a(WxMediaCropLayout.a((WxMediaCropLayout)localObject2, l, paramIntent, true, this.qMU, null, 16));
            paramIntent = crf();
            d.g.b.k.g(paramIntent, "previewRecyclerView");
            paramIntent = paramIntent.getAdapter();
            if (paramIntent != null)
            {
              paramIntent.ck(paramInt1);
              AppMethodBeat.o(167397);
            }
          }
          else
          {
            ad.i("Finder.MediaCropUI", "[onActivityResult] edit video output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath());
            paramIntent = GalleryItem.MediaItem.a(2, 0L, ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath(), ((CaptureDataManager.CaptureVideoNormalModel)localObject2).anX(), "");
            crc().clear();
            crc().add(paramIntent);
            ((b)localObject1).setItems((List)crc());
            ((b)localObject1).notifyDataSetChanged();
            paramIntent = new d();
            paramIntent.qNi = 1;
            this.qMK.put(0L, paramIntent);
            paramIntent = crf().ci(0);
            if (paramIntent != null) {}
            for (paramIntent = paramIntent.arI;; paramIntent = null)
            {
              if (paramIntent == null) {
                d.g.b.k.fvU();
              }
              d.g.b.k.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
              localObject1 = crc().get(0);
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
      paramIntent = ai.cf((Context)getContext());
      localObject1 = i.qTa;
      i.fA(paramIntent.x, paramIntent.y);
      paramIntent = new Point(paramIntent.x, paramIntent.y);
      localObject1 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
      com.tencent.mm.plugin.vlog.ui.manager.d.setPreviewSize(paramIntent.x, paramIntent.y);
      paramIntent = crf().ci(0);
      if (paramIntent == null) {
        break label674;
      }
    }
    label674:
    for (paramIntent = paramIntent.arI;; paramIntent = null)
    {
      if (paramIntent == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      localObject1 = crc().get(0);
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
    com.tencent.mm.plugin.mmsight.d.ne(true);
    getWindow().setFormat(-3);
    paramBundle = getIntent().getParcelableArrayListExtra("front_vlog_video");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      this.KYA = ((GalleryItem.MediaItem)paramBundle.get(0));
    }
    cre().post((Runnable)new r(this));
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    paramBundle.bottomMargin = com.tencent.mm.ui.aq.eb(getBaseContext());
    paramBundle.gravity = 80;
    Object localObject = crg();
    d.g.b.k.g(localObject, "footer");
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    crg().post((Runnable)new s(this));
    setActionbarColor(getResources().getColor(2131101053));
    findViewById(2131296417).setOnClickListener((View.OnClickListener)new t(this));
    findViewById(2131296376).setOnClickListener((View.OnClickListener)new u(this));
    cri();
    paramBundle = new b.b();
    localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
    paramBundle.abC(com.tencent.mm.plugin.finder.utils.k.csc());
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    paramBundle.maxHeight = com.tencent.mm.plugin.finder.storage.b.coH();
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    paramBundle.maxWidth = com.tencent.mm.plugin.finder.storage.b.coI();
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    paramBundle.rDv = com.tencent.mm.plugin.finder.storage.b.coJ();
    this.qMW = new com.tencent.mm.plugin.gallery.picker.b.b(paramBundle);
    localObject = this.qMW;
    if (localObject == null) {
      d.g.b.k.aPZ("mediaTailor");
    }
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).a((com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.d(paramBundle));
    localObject = this.qMW;
    if (localObject == null) {
      d.g.b.k.aPZ("mediaTailor");
    }
    paramBundle = (com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.k(paramBundle);
    d.g.b.k.h(paramBundle, "<set-?>");
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).Lmn = paramBundle;
    initView();
    AppMethodBeat.o(167389);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199263);
    super.onDestroy();
    AppMethodBeat.o(199263);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(167394);
    super.onPause();
    if (!this.qMT) {
      crd().onUIPause();
    }
    AppMethodBeat.o(167394);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167393);
    super.onResume();
    Object localObject2;
    if (this.qMT)
    {
      localObject1 = crf();
      d.g.b.k.g(localObject1, "previewRecyclerView");
      localObject2 = ((RecyclerView)localObject1).getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof b)) {
        localObject1 = null;
      }
      localObject1 = (b)localObject1;
      localObject2 = crc();
      d.g.b.k.g(localObject2, "selectPathList");
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      int j;
      if (((Iterator)localObject2).hasNext()) {
        if (((GalleryItem.MediaItem)((Iterator)localObject2).next()).rBs == this.qMV)
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
        fVy();
        localObject1 = crd();
        long l = ((GalleryItem.MediaItem)localObject2).rBs;
        d.g.b.k.g(localObject2, "item");
        localObject2 = ((GalleryItem.MediaItem)localObject2).czE();
        d.g.b.k.g(localObject2, "item.originalPath");
        ((WxMediaCropLayout)localObject1).a(l, (String)localObject2, true, this.qMU, true);
      }
      this.qMT = false;
      AppMethodBeat.o(167393);
      return;
    }
    Object localObject1 = crd();
    ad.i("WxMediaCropLayout", "onUIResume");
    if (((WxMediaCropLayout)localObject1).lLq != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).lLq;
      if (localObject2 != null) {
        ((CommonVideoView)localObject2).onUIResume();
      }
    }
    if (((WxMediaCropLayout)localObject1).Lmo != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).Lmo;
      if (localObject2 != null) {
        ((VLogCompositionPlayView)localObject2).resume();
      }
    }
    if (((WxMediaCropLayout)localObject1).vmF != null)
    {
      localObject1 = ((WxMediaCropLayout)localObject1).vmF;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject1).fYo();
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
  public static final class PreviewItemView
    extends FrameLayout
  {
    private final ImageView djK;
    private final View lRB;
    private final int padding;
    private final int qNk;
    private final View qNl;
    private final int size;
    
    public PreviewItemView(Context paramContext)
    {
      super();
      AppMethodBeat.i(167351);
      paramContext = aj.getContext();
      d.g.b.k.g(paramContext, "MMApplicationContext.getContext()");
      this.qNk = paramContext.getResources().getColor(2131100726);
      this.djK = new ImageView(getContext());
      this.lRB = new View(getContext());
      this.qNl = new View(getContext());
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165274));
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165300));
      this.djK.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.qNl.setBackgroundColor(this.qNk);
      addView(this.qNl, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.djK, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.lRB;
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(2131101179));
      this.lRB.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167351);
    }
    
    public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(167352);
      paramContext = aj.getContext();
      d.g.b.k.g(paramContext, "MMApplicationContext.getContext()");
      this.qNk = paramContext.getResources().getColor(2131100726);
      this.djK = new ImageView(getContext());
      this.lRB = new View(getContext());
      this.qNl = new View(getContext());
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165274));
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165300));
      this.djK.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.qNl.setBackgroundColor(this.qNk);
      addView(this.qNl, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.djK, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.lRB;
      paramAttributeSet = getContext();
      d.g.b.k.g(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101179));
      this.lRB.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167352);
    }
    
    public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(167353);
      paramContext = aj.getContext();
      d.g.b.k.g(paramContext, "MMApplicationContext.getContext()");
      this.qNk = paramContext.getResources().getColor(2131100726);
      this.djK = new ImageView(getContext());
      this.lRB = new View(getContext());
      this.qNl = new View(getContext());
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165274));
      paramContext = getContext();
      d.g.b.k.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165300));
      this.djK.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.qNl.setBackgroundColor(this.qNk);
      addView(this.qNl, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.djK, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.lRB;
      paramAttributeSet = getContext();
      d.g.b.k.g(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101179));
      this.lRB.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167353);
    }
    
    public final View getFocusedView()
    {
      return this.qNl;
    }
    
    public final ImageView getImageView()
    {
      return this.djK;
    }
    
    public final View getMaskView()
    {
      return this.lRB;
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
        this.qNl.setVisibility(0);
        AppMethodBeat.o(167349);
        return;
      }
      this.qNl.setVisibility(4);
      AppMethodBeat.o(167349);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(167350);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.lRB.setVisibility(4);
        AppMethodBeat.o(167350);
        return;
      }
      this.lRB.setVisibility(0);
      AppMethodBeat.o(167350);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$Companion;", "", "()V", "CLEAR_LIST", "", "FRONT_VLOG_VIDEO", "REQUEST_CODE_EDIT", "", "SELECT_PATH_LIST", "SELECT_VIDEO_DURATION", "SELECT_VIDEO_PATH", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<ArrayList<GalleryItem.MediaItem>>
  {
    aa(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
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
      Object localObject = com.tencent.mm.plugin.gallery.picker.c.f.rDX;
      localObject = com.tencent.mm.plugin.gallery.picker.c.f.cAb();
      d.g.b.k.g(localMediaItem, "media");
      ((com.tencent.mm.loader.d)localObject).bH(localMediaItem).a(paramb.getImageView(), true);
      d.g.b.k.g(paramb, "itemView");
      if (((FinderMediaCropUI.d)FinderMediaCropUI.a(this.qMY).get(localMediaItem.rBs)).qNi != -1)
      {
        bool1 = true;
        paramb.setSelected(bool1);
        if (localMediaItem.rBs != FinderMediaCropUI.b(this.qMY)) {
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
      AppMethodBeat.i(199252);
      d.g.b.k.h(paramb, "holder");
      d.g.b.k.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(199252);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(167330);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).rBs;
      AppMethodBeat.o(167330);
      return l;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder_release"})
  public final class c
    extends android.support.v7.widget.a.a.a
  {
    int dBx;
    private int qMZ;
    private int qNa;
    private int qNb;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> qNc;
    
    public c()
    {
      AppMethodBeat.i(167345);
      this.qNc = localObject;
      this.dBx = -1;
      this.qMZ = -1;
      this.qNa = -1;
      AppMethodBeat.o(167345);
    }
    
    public final float K(RecyclerView.v paramv)
    {
      AppMethodBeat.i(167342);
      d.g.b.k.h(paramv, "viewHolder");
      AppMethodBeat.o(167342);
      return 0.295858F;
    }
    
    public final void L(RecyclerView.v paramv)
    {
      AppMethodBeat.i(167341);
      d.g.b.k.h(paramv, "viewHolder");
      AppMethodBeat.o(167341);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(167344);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      d.g.b.k.h(paramv, "viewHolder");
      int i = android.support.v7.widget.a.a.a.di(51);
      AppMethodBeat.o(167344);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(167343);
      d.g.b.k.h(paramCanvas, "c");
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      d.g.b.k.h(paramv, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(167343);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(167338);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      d.g.b.k.h(paramv1, "viewHolder");
      d.g.b.k.h(paramv2, "target");
      int i = paramv1.ln();
      int j = paramv2.ln();
      ad.d("Finder.MediaCropUI", "[onMove] from=" + i + " to=" + j);
      com.tencent.mm.plugin.gallery.a.d.swap((List)FinderMediaCropUI.this.crc(), i, j);
      this.qNc.ap(i, j);
      this.qNa = j;
      AppMethodBeat.o(167338);
      return true;
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.v paramv)
    {
      AppMethodBeat.i(167340);
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      d.g.b.k.h(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772077);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramv));
      paramv.arI.startAnimation(paramRecyclerView);
      AppMethodBeat.o(167340);
    }
    
    public final void f(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(167339);
      super.f(paramv, paramInt);
      if (paramv != null)
      {
        Object localObject = paramv.arI;
        d.g.b.k.g(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772078);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramv, paramInt));
        paramv.arI.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(167339);
    }
    
    public final boolean mM()
    {
      return true;
    }
    
    public final boolean mN()
    {
      return false;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.v paramv) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(167333);
        d.g.b.k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        d.g.b.k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        ad.d("Finder.MediaCropUI", "finally change from=" + FinderMediaCropUI.c.b(this.qNd) + " to=" + FinderMediaCropUI.c.a(this.qNd));
        AppMethodBeat.o(167333);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(167334);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(167334);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(167332);
        d.g.b.k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        d.g.b.k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(167332);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(FinderMediaCropUI.c paramc, RecyclerView.v paramv, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(167336);
        d.g.b.k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        d.g.b.k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(167336);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(167337);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(167337);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(167335);
        d.g.b.k.h(paramAnimation, "animation");
        paramAnimation = paramv.arI;
        d.g.b.k.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          FinderMediaCropUI.c.a(this.qNd, paramv.ln());
          FinderMediaCropUI.c.b(this.qNd, FinderMediaCropUI.c.a(this.qNd));
          this.qNd.dBx = FinderMediaCropUI.c.c(this.qNd);
        }
        AppMethodBeat.o(167335);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder_release"})
  public static final class d
  {
    public static final a qNj;
    WxMediaCropLayout.b qNh;
    int qNi;
    
    static
    {
      AppMethodBeat.i(167348);
      qNj = new a((byte)0);
      AppMethodBeat.o(167348);
    }
    
    public d()
    {
      AppMethodBeat.i(167347);
      this.qNh = new WxMediaCropLayout.b(0L, "");
      this.qNi = -1;
      AppMethodBeat.o(167347);
    }
    
    public final void a(WxMediaCropLayout.b paramb)
    {
      AppMethodBeat.i(167346);
      d.g.b.k.h(paramb, "<set-?>");
      this.qNh = paramb;
      AppMethodBeat.o(167346);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder_release"})
    public static final class a {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    e(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$calculateCallback$1", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-finder_release"})
  public static final class f
    implements WxMediaCropLayout.c
  {
    public final void a(int[] paramArrayOfInt, RectF paramRectF, boolean paramBoolean)
    {
      AppMethodBeat.i(199253);
      d.g.b.k.h(paramArrayOfInt, "mediaWH");
      d.g.b.k.h(paramRectF, "maxCropRect");
      RectF localRectF = new RectF(paramRectF);
      if (!paramBoolean) {
        paramRectF.set(FinderMediaCropUI.l(this.qMY));
      }
      for (;;)
      {
        ad.i("Finder.MediaCropUI", "[calculate] NEW=" + paramRectF + " OLD=" + localRectF + " isAdaptSrc=" + paramBoolean);
        AppMethodBeat.o(199253);
        return;
        Object localObject = i.qTa;
        localObject = i.fA(paramArrayOfInt[0], paramArrayOfInt[1]);
        ((Bundle)localObject).getInt("media_layout_width", paramArrayOfInt[0]);
        int i = ((Bundle)localObject).getInt("media_layout_height", paramArrayOfInt[1]);
        float f = (paramRectF.height() - i) / 2.0F;
        paramRectF.top += f;
        paramRectF.bottom -= f;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<WxMediaCropLayout>
  {
    g(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167357);
      RecyclerView.v localv = this.qMY.crf().cj(this.fKG);
      if (localv != null)
      {
        localv.arI.callOnClick();
        AppMethodBeat.o(167357);
        return;
      }
      AppMethodBeat.o(167357);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167358);
      RecyclerView.v localv = this.qMY.crf().cj(this.fKG);
      if (localv != null)
      {
        localv.arI.callOnClick();
        AppMethodBeat.o(167358);
        return;
      }
      AppMethodBeat.o(167358);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    j(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    k(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167361);
      RectF localRectF = FinderMediaCropUI.e(this.qMY);
      WxMediaCropLayout.a(this.qMY.crd(), localRectF.width() * 0.5625F, localRectF.height(), localRectF);
      AppMethodBeat.o(167361);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167362);
      paramView = this.qMY.crc();
      d.g.b.k.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).rBs == FinderMediaCropUI.b(this.qMY))
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
      int j = this.qMY.crc().size();
      Object localObject = (GalleryItem.MediaItem)this.qMY.crc().get(i);
      FinderMediaCropUI.j(this.qMY);
      if ((j <= 1) || (FinderMediaCropUI.fVA()))
      {
        paramView = new Intent();
        paramView.putExtra("clear_list", true);
        this.qMY.setResult(-1, paramView);
        this.qMY.finish();
        AppMethodBeat.o(167362);
        return;
      }
      if (i == 0) {}
      for (j = 1;; j = i - 1)
      {
        paramView = this.qMY.crf().ci(j);
        this.qMY.crc().remove(localObject);
        localObject = this.qMY.crf();
        d.g.b.k.g(localObject, "previewRecyclerView");
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).cm(i);
        }
        if (paramView != null)
        {
          paramView = paramView.arI;
          if (paramView != null) {
            paramView.callOnClick();
          }
        }
        FinderMediaCropUI.f(this.qMY);
        AppMethodBeat.o(167362);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167363);
      paramView = this.qMY.crc();
      d.g.b.k.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      int j;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).rBs == FinderMediaCropUI.b(this.qMY))
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
      paramView = this.qMY.crf();
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
        localObject1 = (CharSequence)paramView.rBq;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            paramView.rBq = paramView.rBp;
          }
          d.g.b.k.g(paramView, "item");
          if ((paramView.getType() != 2) && (!FinderMediaCropUI.fVA())) {
            break;
          }
          this.qMY.qMT = true;
          localObject1 = this.qMY.crd();
          ad.i("WxMediaCropLayout", "onUIRelease");
          if (((WxMediaCropLayout)localObject1).lLq != null)
          {
            localObject2 = ((WxMediaCropLayout)localObject1).lLq;
            if (localObject2 != null) {
              ((CommonVideoView)localObject2).onUIDestroy();
            }
            ((WxMediaCropLayout)localObject1).lLq = null;
          }
          if (((WxMediaCropLayout)localObject1).Lmo != null)
          {
            localObject2 = ((WxMediaCropLayout)localObject1).Lmo;
            if (localObject2 != null) {
              ((VLogCompositionPlayView)localObject2).stop();
            }
            localObject2 = ((WxMediaCropLayout)localObject1).Lmo;
            if (localObject2 != null) {
              ((VLogCompositionPlayView)localObject2).release();
            }
            ((WxMediaCropLayout)localObject1).Lmo = null;
          }
          if (((WxMediaCropLayout)localObject1).vmF != null)
          {
            localObject2 = ((WxMediaCropLayout)localObject1).vmF;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject2).release();
            }
            ((WxMediaCropLayout)localObject1).vmF = null;
          }
          localObject3 = this.qMY.crd().getCurrentCropInfo();
          localObject1 = ((WxMediaCropLayout.b)localObject3).gtE;
          f1 = ((WxMediaCropLayout.b)localObject3).viewRect.height() * 1.0F / ((WxMediaCropLayout.b)localObject3).viewRect.width() * ((WxMediaCropLayout.b)localObject3).gtE.width();
          i = ((WxMediaCropLayout.b)localObject3).gtE.left;
          j = (int)(((WxMediaCropLayout.b)localObject3).gtE.centerY() - f1 / 2.0F);
          int k = ((WxMediaCropLayout.b)localObject3).gtE.right;
          f2 = ((WxMediaCropLayout.b)localObject3).gtE.centerY();
          localObject4 = new Rect(i, j, k, (int)(f1 / 2.0F + f2));
          localObject2 = this.qMY.crd();
          d.g.b.k.g(localObject2, "cropLayout");
          i = ((WxMediaCropLayout)localObject2).getHeight() / 2 - ((WxMediaCropLayout.b)localObject3).rGK.centerY();
          ((Rect)localObject4).top += i;
          ((Rect)localObject4).bottom += i;
          f1 = ((WxMediaCropLayout.b)localObject3).oSt.width() * 1.0F / ((WxMediaCropLayout.b)localObject3).gtE.width();
          localObject2 = new Matrix();
          ((Matrix)localObject2).setScale(f1, f1);
          ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).oSt.left - ((Rect)localObject4).left, ((WxMediaCropLayout.b)localObject3).oSt.top - ((Rect)localObject4).top);
          f1 = ((WxMediaCropLayout.b)localObject3).oSt.centerX();
          f2 = ((WxMediaCropLayout.b)localObject3).gtE.centerX();
          float f3 = ((WxMediaCropLayout.b)localObject3).oSt.centerY();
          float f4 = ((WxMediaCropLayout.b)localObject3).gtE.centerY();
          float f5 = i;
          localObject3 = ai.cf((Context)this.qMY.getContext());
          localObject4 = i.qTa;
          i.fA(((Point)localObject3).x, ((Point)localObject3).y);
          localObject3 = new Point(((Point)localObject3).x, ((Point)localObject3).y);
          localObject4 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
          com.tencent.mm.plugin.vlog.ui.manager.d.setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
          localObject3 = com.tencent.mm.plugin.finder.utils.a.qSb;
          localObject3 = this.qMY.getContext();
          d.g.b.k.g(localObject3, "context");
          localObject3 = (Activity)localObject3;
          localObject4 = paramView.rBq;
          d.g.b.k.g(localObject4, "item.mRawEditPath");
          i = paramView.getType();
          boolean bool = FinderMediaCropUI.fVA();
          com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, i, (Matrix)localObject2, (Rect)localObject1, new float[] { f1 - f2, f3 - f4 - f5 }, bool);
          AppMethodBeat.o(167363);
          return;
        }
        Object localObject3 = this.qMY.crd().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).gtE;
        Object localObject2 = new Matrix();
        Object localObject4 = new float[9];
        ((WxMediaCropLayout.b)localObject3).dY.getValues((float[])localObject4);
        float f1 = localObject4[0];
        float f2 = localObject4[3];
        double d1 = f1 * f1;
        double d2 = f2;
        f1 = (float)Math.sqrt(f2 * d2 + d1);
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).oSt.left, ((WxMediaCropLayout.b)localObject3).oSt.top);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject3 = this.qMY.getContext();
        d.g.b.k.g(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.rBq;
        d.g.b.k.g(localObject4, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, paramView.getType(), (Matrix)localObject2, (Rect)localObject1);
        AppMethodBeat.o(167363);
        return;
      }
      AppMethodBeat.o(167363);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$4", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class o
    extends RecyclerView.h
  {
    private final float offset;
    
    o()
    {
      AppMethodBeat.i(167365);
      Context localContext = aj.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(2131165289);
      AppMethodBeat.o(167365);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(167364);
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramView = paramRecyclerView.bh(paramView);
      d.g.b.k.g(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.ln();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.qMY.crc().size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(167364);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$5", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167369);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      Object localObject = this.qMY.getContext();
      d.g.b.k.g(localObject, "context");
      localLayoutParams.topMargin = ((int)((AppCompatActivity)localObject).getResources().getDimension(2131165303) + ap.M(this.qMY.getBaseContext(), (int)this.qMY.getResources().getDimension(2131165298)));
      localObject = this.qMY.cre();
      d.g.b.k.g(localObject, "actionBarLayout");
      ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      this.qMY.cre().requestLayout();
      AppMethodBeat.o(167369);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167370);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.ui.aq.eb(this.qMY.getBaseContext());
      localLayoutParams.gravity = 80;
      View localView = this.qMY.crg();
      d.g.b.k.g(localView, "footer");
      localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(167370);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167371);
      this.qMY.setResult(0);
      this.qMY.finish();
      AppMethodBeat.o(167371);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167372);
      FinderMediaCropUI.c(this.qMY);
      AppMethodBeat.o(167372);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "isSuccessfully", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements m<List<? extends MediaSelectedData>, Boolean, y>
  {
    v(FinderMediaCropUI paramFinderMediaCropUI, List paramList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onGenerateMedia$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$$special$$inlined$apply$lambda$1"})
  static final class w
    extends d.g.b.l
    implements m<Boolean, b.f, y>
  {
    w(GalleryItem.MediaItem paramMediaItem, int paramInt, FinderMediaCropUI paramFinderMediaCropUI, ArrayList paramArrayList, v.e parame, m paramm, v.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    x(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.a<RecyclerView>
  {
    y(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI
 * JD-Core Version:    0.7.0.1
 */