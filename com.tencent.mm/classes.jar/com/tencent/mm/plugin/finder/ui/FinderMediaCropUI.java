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
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.r;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "actionBarLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActionBarLayout", "()Landroid/view/View;", "actionBarLayout$delegate", "Lkotlin/Lazy;", "calculateCallback", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "getCalculateCallback", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "editBtn", "getEditBtn", "editBtn$delegate", "footer", "getFooter", "footer$delegate", "hasDestroyVideoView", "", "getHasDestroyVideoView", "()Z", "setHasDestroyVideoView", "(Z)V", "isFromAppBrand", "isFromAppBrand$delegate", "isPreviewTvChange", "isSwitchNormalMode", "mediaExtraMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "value", "", "previewId", "setPreviewId", "(J)V", "previewNumTv", "Landroid/widget/TextView;", "getPreviewNumTv", "()Landroid/widget/TextView;", "previewNumTv$delegate", "previewRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getPreviewRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "previewRecyclerView$delegate", "processDialogRunnable", "Ljava/lang/Runnable;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSelectPathList", "()Ljava/util/ArrayList;", "selectPathList$delegate", "switchVLogCheckbox", "Landroid/widget/CheckBox;", "getSwitchVLogCheckbox", "()Landroid/widget/CheckBox;", "switchVLogCheckbox$delegate", "switchVLogLayout", "getSwitchVLogLayout", "switchVLogLayout$delegate", "tipDialog", "Landroid/app/Dialog;", "vLogCropRect", "Landroid/graphics/Rect;", "vlogVideoPath", "getVlogVideoPath", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setVlogVideoPath", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "canEnableMultiImage", "checkCropInfo", "", "type", "", "path", "", "matrix", "Landroid/graphics/Matrix;", "cropRect", "contentRect", "viewRect", "position", "initCropRect", "checkIsAllImage", "defaultPreview", "getDefaultVideoVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getForceOrientation", "getLayoutId", "getMenuText", "initView", "isInVLogMode", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onGenerateMedia", "selectedMedias", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "isSuccessfully", "onPause", "onPreviewItem", "view", "item", "onResume", "reloadVLogFake", "setWindowStyle", "showProcessDialog", "delay", "updateOptionMenu", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "MediaExtra", "PreviewItemView", "plugin-finder_release"})
public final class FinderMediaCropUI
  extends MMFinderUI
{
  public static final a vLv;
  private HashMap _$_findViewCache;
  private Dialog tipDialog;
  private final Runnable vJC;
  private final LongSparseArray<d> vLd;
  private final kotlin.f vLe;
  GalleryItem.MediaItem vLf;
  private final kotlin.f vLg;
  private final kotlin.f vLh;
  private final kotlin.f vLi;
  private final kotlin.f vLj;
  private final kotlin.f vLk;
  private final kotlin.f vLl;
  private final kotlin.f vLm;
  private final kotlin.f vLn;
  final kotlin.f vLo;
  boolean vLp;
  private final WxMediaCropLayout.c vLq;
  private long vLr;
  private boolean vLs;
  private boolean vLt;
  private com.tencent.mm.plugin.gallery.picker.b.b vLu;
  
  static
  {
    AppMethodBeat.i(167382);
    vLv = new a((byte)0);
    AppMethodBeat.o(167382);
  }
  
  public FinderMediaCropUI()
  {
    AppMethodBeat.i(167398);
    this.vLd = new LongSparseArray();
    this.vLe = g.ah((kotlin.g.a.a)new ac(this));
    this.vLg = g.ah((kotlin.g.a.a)new g(this));
    this.vLh = g.ah((kotlin.g.a.a)new e(this));
    this.vLi = g.ah((kotlin.g.a.a)new aa(this));
    this.vLj = g.ah((kotlin.g.a.a)new k(this));
    this.vLk = g.ah((kotlin.g.a.a)new z(this));
    this.vLl = g.ah((kotlin.g.a.a)new j(this));
    this.vLm = g.ah((kotlin.g.a.a)new ae(this));
    this.vLn = g.ah((kotlin.g.a.a)new ad(this));
    this.vLo = g.ah((kotlin.g.a.a)new s(this));
    this.vLq = ((WxMediaCropLayout.c)new f(this));
    this.vJC = ((Runnable)new ab(this));
    AppMethodBeat.o(167398);
  }
  
  private final void a(List<? extends GalleryItem.MediaItem> paramList, final m<? super List<? extends MediaSelectedData>, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(167396);
    MMHandlerThread.postToMainThreadDelayed(this.vJC, 300L);
    final z.d locald = new z.d();
    locald.SYE = ((Collection)paramList).size();
    final ArrayList localArrayList = new ArrayList(9);
    final z.f localf = new z.f();
    localf.SYG = new Rect();
    paramList = ((Iterable)paramList).iterator();
    final int i = 0;
    if (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject1 = (GalleryItem.MediaItem)localObject1;
      localArrayList.add(new MediaSelectedData(-1));
      Object localObject2 = (d)this.vLd.get(((GalleryItem.MediaItem)localObject1).xiZ);
      String str = ((GalleryItem.MediaItem)localObject1).xiW;
      Matrix localMatrix = new Matrix(((d)localObject2).vLF.dRK());
      Rect localRect1 = new Rect(((d)localObject2).vLF.iiw);
      Rect localRect2 = new Rect(((d)localObject2).vLF.rwL);
      localObject2 = new Rect(((d)localObject2).vLF.viewRect);
      if (i == 0) {
        ((Rect)localf.SYG).set(localRect1);
      }
      int j = ((GalleryItem.MediaItem)localObject1).getType();
      p.g(str, "path");
      Object localObject3 = (Rect)localf.SYG;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if ((localRect1.isEmpty()) || (localRect2.isEmpty()))
      {
        localObject4 = getContext();
        p.g(localObject4, "context");
        localObject4 = new CropLayout((Context)localObject4);
        localObject5 = new View((Context)getContext());
        if (j != 2) {
          break label723;
        }
        localObject6 = com.tencent.mm.plugin.gallery.a.c.xsz;
        localObject6 = com.tencent.mm.plugin.gallery.a.c.awl(str);
        CropLayout.a((CropLayout)localObject4, (View)localObject5, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height, null, null, null, 56);
        ((Rect)localObject2).set(0, 0, ((com.tencent.mm.plugin.sight.base.a)localObject6).width, ((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        ((View)localObject5).setRight(((com.tencent.mm.plugin.sight.base.a)localObject6).width);
        ((View)localObject5).setBottom(((com.tencent.mm.plugin.sight.base.a)localObject6).height);
        label399:
        Log.i("Finder.MediaCropUI", "[checkCropInfo] need to set default CropInfo. type=" + j + " position=" + i + " viewRect=" + localObject2 + " contentRect=" + localRect2 + " cropRect=" + localRect1);
        ((CropLayout)localObject4).getVisibilityRect().set((Rect)localObject3);
        localObject5 = dzH();
        p.g(localObject5, "cropLayout");
        j = ((WxMediaCropLayout)localObject5).getLeft();
        localObject5 = dzH();
        p.g(localObject5, "cropLayout");
        int k = ((WxMediaCropLayout)localObject5).getTop();
        localObject5 = dzH();
        p.g(localObject5, "cropLayout");
        int m = ((WxMediaCropLayout)localObject5).getRight();
        localObject5 = dzH();
        p.g(localObject5, "cropLayout");
        ((CropLayout)localObject4).e(true, j, k, m, ((WxMediaCropLayout)localObject5).getBottom());
        localMatrix.set(((CropLayout)localObject4).getMainMatrix());
        if (!((Rect)localObject3).isEmpty()) {
          break label792;
        }
        dzt().round(localRect1);
      }
      for (;;)
      {
        localRect2.set(((CropLayout)localObject4).getContentRect());
        Log.i("Finder.MediaCropUI", "onGenerateMedia, cropRect:" + localRect1 + ", contentRect:" + localRect1 + ", viewRect:" + localObject2);
        j = ((GalleryItem.MediaItem)localObject1).getType();
        localObject3 = this.vLu;
        if (localObject3 == null) {
          p.btv("mediaTailor");
        }
        com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject3, str, j, localMatrix, localRect1, localRect2, (Rect)localObject2, i, (m)new y((GalleryItem.MediaItem)localObject1, i, this, localArrayList, localf, paramm, locald));
        i += 1;
        break;
        label723:
        localObject6 = BitmapUtil.getImageOptions(str);
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
  
  private TextView dzL()
  {
    AppMethodBeat.i(167388);
    TextView localTextView = (TextView)this.vLk.getValue();
    AppMethodBeat.o(167388);
    return localTextView;
  }
  
  private View dzM()
  {
    AppMethodBeat.i(252509);
    View localView = (View)this.vLm.getValue();
    AppMethodBeat.o(252509);
    return localView;
  }
  
  private final void dzO()
  {
    AppMethodBeat.i(167390);
    TextView localTextView = (TextView)findViewById(2131296401);
    Object localObject1 = dzG();
    p.g(localObject1, "selectPathList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label125:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localObject3;
      if (((d)this.vLd.get(localMediaItem.xiZ)).vLG != -1) {}
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
      p.g(localObject2, "context");
      localObject1 = ((AppCompatActivity)localObject2).getResources().getString(2131755858) + '(' + i + ')';
      localTextView.setText((CharSequence)localObject1);
      localObject1 = dzG();
      p.g(localObject1, "selectPathList");
      localObject2 = ((Iterable)localObject1).iterator();
      label228:
      if (!((Iterator)localObject2).hasNext()) {
        break label337;
      }
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (GalleryItem.MediaItem)localObject1;
      if (((d)this.vLd.get(((GalleryItem.MediaItem)localObject3).xiZ)).vLG == -1) {
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
      p.g(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131755858);
      p.g(localObject1, "context.resources.getString(R.string.app_finish)");
      break;
      i = 0;
      break label276;
      break label228;
      localObject1 = null;
      break label280;
    }
  }
  
  private final boolean dzP()
  {
    AppMethodBeat.i(252512);
    Object localObject = dzG();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((ArrayList)localObject).size());; localObject = null)
    {
      if (localObject == null) {
        p.hyc();
      }
      if (((Integer)localObject).intValue() > 1) {
        break;
      }
      AppMethodBeat.o(252512);
      return false;
    }
    localObject = dzG();
    p.g(localObject, "selectPathList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
      p.g(localMediaItem, "it");
      if (localMediaItem.getType() == 2)
      {
        AppMethodBeat.o(252512);
        return false;
      }
    }
    AppMethodBeat.o(252512);
    return true;
  }
  
  private final RectF dzt()
  {
    AppMethodBeat.i(167392);
    Object localObject = getContext();
    p.g(localObject, "context");
    float f2 = ((AppCompatActivity)localObject).getResources().getDimension(2131165254);
    localObject = getContext();
    p.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165308);
    localObject = dzH();
    p.g(localObject, "cropLayout");
    float f1 = ((WxMediaCropLayout)localObject).getWidth() * 3.5F / 3.0F;
    localObject = dzH();
    p.g(localObject, "cropLayout");
    int i = ((WxMediaCropLayout)localObject).getHeight();
    localObject = dzK();
    p.g(localObject, "footer");
    f2 = f2 + f3 + (i - ((View)localObject).getHeight() - f2 - f3 - av.aD(getBaseContext()) - f1) / 2.0F;
    localObject = dzH();
    p.g(localObject, "cropLayout");
    f3 = ((WxMediaCropLayout)localObject).getLeft();
    localObject = dzH();
    p.g(localObject, "cropLayout");
    localObject = new RectF(f3, f2, ((WxMediaCropLayout)localObject).getRight(), f1 + f2);
    AppMethodBeat.o(167392);
    return localObject;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252515);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252515);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252514);
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
    AppMethodBeat.o(252514);
    return localView1;
  }
  
  public final void a(int paramInt, View paramView, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(252511);
    p.h(paramView, "view");
    p.h(paramMediaItem, "item");
    if (paramView.getTag() != null)
    {
      Log.w("Finder.MediaCropUI", "this view is Animating");
      AppMethodBeat.o(252511);
      return;
    }
    Object localObject1 = dzJ().m(this.vLr);
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.v)localObject1).aus;
      p.g(localObject1, "preHolder.itemView");
      ((View)localObject1).setFocusable(false);
    }
    this.vLr = paramMediaItem.xiZ;
    localObject1 = dzG();
    p.g(localObject1, "selectPathList");
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
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).xiZ == this.vLr)
      {
        j = 1;
        if (j == 0) {
          break label456;
        }
        if (i >= 0)
        {
          dzG().get(i);
          if (((d)this.vLd.get(this.vLr)).vLG != -1) {
            break label471;
          }
          localObject1 = dzL();
          p.g(localObject1, "previewNumTv");
          ((TextView)localObject1).setText((CharSequence)"");
          localObject1 = dzL();
          p.g(localObject1, "previewNumTv");
          localObject2 = getContext();
          p.g(localObject2, "context");
          ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(2131234316));
        }
        paramView.setFocusable(true);
        paramView = dzJ();
        p.g(paramView, "previewRecyclerView");
        paramView = paramView.getAdapter();
        if (paramView != null) {
          paramView.b(paramInt, new Object());
        }
        if (paramInt == 0) {
          dzH().setLockCropMediaId(paramMediaItem.xiZ);
        }
        l = paramMediaItem.xiZ;
        if (paramMediaItem.getType() != 2) {
          break label547;
        }
        paramInt = 1;
        localObject1 = (d)this.vLd.get(this.vLr);
        paramView = dzH();
        paramMediaItem = paramMediaItem.dRh();
        p.g(paramMediaItem, "item.originalPath");
        localObject2 = this.vLq;
        p.h(paramMediaItem, "mediaPath");
        Log.i("WxMediaCropLayout", "onPreview type: ".concat(String.valueOf(paramInt)));
        bool = false;
        if (paramView.pXO != paramInt) {
          bool = true;
        }
        paramView.pXO = paramInt;
        if (paramInt != 2) {
          break label552;
        }
        paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2, null, 16);
      }
    }
    for (;;)
    {
      ((d)localObject1).a(paramView);
      AppMethodBeat.o(252511);
      return;
      j = 0;
      break label157;
      label456:
      i += 1;
      break;
      i = -1;
      break label162;
      label471:
      localObject1 = dzL();
      p.g(localObject1, "previewNumTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(i + 1));
      localObject1 = dzL();
      p.g(localObject1, "previewNumTv");
      localObject2 = getContext();
      p.g(localObject2, "context");
      ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(2131234338));
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
  
  public final ArrayList<GalleryItem.MediaItem> dzG()
  {
    AppMethodBeat.i(167383);
    ArrayList localArrayList = (ArrayList)this.vLe.getValue();
    AppMethodBeat.o(167383);
    return localArrayList;
  }
  
  public final WxMediaCropLayout dzH()
  {
    AppMethodBeat.i(167384);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.vLg.getValue();
    AppMethodBeat.o(167384);
    return localWxMediaCropLayout;
  }
  
  public final View dzI()
  {
    AppMethodBeat.i(167385);
    View localView = (View)this.vLh.getValue();
    AppMethodBeat.o(167385);
    return localView;
  }
  
  public final RecyclerView dzJ()
  {
    AppMethodBeat.i(167386);
    RecyclerView localRecyclerView = (RecyclerView)this.vLi.getValue();
    AppMethodBeat.o(167386);
    return localRecyclerView;
  }
  
  public final View dzK()
  {
    AppMethodBeat.i(167387);
    View localView = (View)this.vLj.getValue();
    AppMethodBeat.o(167387);
    return localView;
  }
  
  public final CheckBox dzN()
  {
    AppMethodBeat.i(252510);
    CheckBox localCheckBox = (CheckBox)this.vLn.getValue();
    AppMethodBeat.o(252510);
    return localCheckBox;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131494500;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167391);
    super.initView();
    dzH().setShowBorder(true);
    dzH().post((Runnable)new l(this));
    dzL().setOnClickListener((View.OnClickListener)new m(this));
    ((View)this.vLl.getValue()).setOnClickListener((View.OnClickListener)new n(this));
    dzJ().setHasFixedSize(true);
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    Object localObject2 = dzJ();
    p.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    ((LinearLayoutManager)localObject1).setItemPrefetchEnabled(true);
    localObject1 = dzJ();
    p.g(localObject1, "previewRecyclerView");
    ((RecyclerView)localObject1).setItemAnimator((RecyclerView.f)new v());
    dzJ().b((RecyclerView.h)new o(this));
    localObject1 = new b();
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new FinderMediaCropUI.c(this, (com.tencent.mm.ui.base.a.a)localObject1)).f(dzJ());
    localObject2 = dzJ();
    p.g(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
    ((b)localObject1).OXb = ((com.tencent.mm.ui.base.a.a.a)new p(this));
    localObject2 = dzG();
    p.g(localObject2, "selectPathList");
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      p.g(localObject3, "it");
      if (((GalleryItem.MediaItem)localObject3).getType() == 2)
      {
        i = 0;
        if (i != 0) {
          this.vLs = true;
        }
        localObject2 = dzN();
        p.g(localObject2, "switchVLogCheckbox");
        ((CheckBox)localObject2).setChecked(this.vLs);
        if (!dzP()) {
          break label474;
        }
        localObject2 = dzM();
        p.g(localObject2, "switchVLogLayout");
        ((View)localObject2).setVisibility(0);
        dzN().setOnClickListener((View.OnClickListener)new q(this, (b)localObject1));
      }
    }
    for (;;)
    {
      localObject2 = new StringBuilder("isInVLogMode: false, final check, IS_VLOG_BACKGROUND_MUX: ");
      localObject3 = com.tencent.mm.plugin.finder.storage.c.vCb;
      Log.i("Finder.MediaCropUI", com.tencent.mm.plugin.finder.storage.c.drJ());
      ((b)localObject1).setItems((List)dzG());
      if ((this.vLf == null) || (!dzP())) {
        break label495;
      }
      dzJ().postDelayed((Runnable)new r(this, (b)localObject1), 500L);
      AppMethodBeat.o(167391);
      return;
      i = 1;
      break;
      label474:
      localObject2 = dzM();
      p.g(localObject2, "switchVLogLayout");
      ((View)localObject2).setVisibility(8);
    }
    label495:
    dzJ().post((Runnable)new h(this));
    dzJ().postDelayed((Runnable)new i(this), 500L);
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
          p.hyc();
        }
        paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        if (paramIntent == null) {
          p.hyc();
        }
        Object localObject2 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
        this.vLp = false;
        paramIntent = dzG();
        p.g(paramIntent, "selectPathList");
        paramIntent = (List)paramIntent;
        paramInt1 = 0;
        paramIntent = paramIntent.iterator();
        if (paramIntent.hasNext()) {
          if (((GalleryItem.MediaItem)paramIntent.next()).xiZ == this.vLr)
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
        paramIntent = dzJ();
        p.g(paramIntent, "previewRecyclerView");
        localObject1 = paramIntent.getAdapter();
        paramIntent = (Intent)localObject1;
        if (!(localObject1 instanceof b)) {
          paramIntent = null;
        }
        localObject1 = (b)paramIntent;
        if (localObject1 != null)
        {
          paramIntent = (GalleryItem.MediaItem)((b)localObject1).getItemAtPosition(paramInt1);
          Boolean localBoolean = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).eJI();
          p.g(localBoolean, "model.photo");
          if (localBoolean.booleanValue())
          {
            paramIntent.xjd = true;
            paramIntent.xiW = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).aQn();
            Log.i("Finder.MediaCropUI", "[onActivityResult] edit photo output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).aQn());
            localObject1 = (d)this.vLd.get(paramIntent.xiZ);
            localObject2 = dzH();
            long l = paramIntent.xiZ;
            p.g(paramIntent, "item");
            paramIntent = paramIntent.dRh();
            p.g(paramIntent, "item.originalPath");
            ((d)localObject1).a(WxMediaCropLayout.a((WxMediaCropLayout)localObject2, l, paramIntent, true, this.vLq, null, 16));
            paramIntent = dzJ();
            p.g(paramIntent, "previewRecyclerView");
            paramIntent = paramIntent.getAdapter();
            if (paramIntent != null)
            {
              paramIntent.ci(paramInt1);
              AppMethodBeat.o(167397);
            }
          }
          else
          {
            Log.i("Finder.MediaCropUI", "[onActivityResult] edit video output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath());
            paramIntent = GalleryItem.MediaItem.a(2, 0L, ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath(), ((CaptureDataManager.CaptureVideoNormalModel)localObject2).aQn(), "");
            dzG().clear();
            dzG().add(paramIntent);
            ((b)localObject1).setItems((List)dzG());
            ((b)localObject1).notifyDataSetChanged();
            paramIntent = new d();
            paramIntent.vLG = 1;
            this.vLd.put(0L, paramIntent);
            paramIntent = dzJ().cg(0);
            if (paramIntent != null) {}
            for (paramIntent = paramIntent.aus;; paramIntent = null)
            {
              if (paramIntent == null) {
                p.hyc();
              }
              p.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
              localObject1 = dzG().get(0);
              p.g(localObject1, "selectPathList[0]");
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
      paramIntent = dzJ().cg(0);
      if (paramIntent == null) {
        break label614;
      }
    }
    label614:
    for (paramIntent = paramIntent.aus;; paramIntent = null)
    {
      if (paramIntent == null) {
        p.hyc();
      }
      p.g(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      localObject1 = dzG().get(0);
      p.g(localObject1, "selectPathList[0]");
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
    setTheme(2131821178);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.rb(true);
    getWindow().setFormat(-3);
    paramBundle = getIntent().getParcelableArrayListExtra("front_vlog_video");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      this.vLf = ((GalleryItem.MediaItem)paramBundle.get(0));
    }
    dzI().post((Runnable)new t(this));
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    paramBundle.bottomMargin = av.aD(getBaseContext());
    paramBundle.gravity = 80;
    Object localObject = dzK();
    p.g(localObject, "footer");
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    dzK().post((Runnable)new u(this));
    setActionbarColor(getResources().getColor(2131101287));
    findViewById(2131296449).setOnClickListener((View.OnClickListener)new v(this));
    findViewById(2131296401).setOnClickListener((View.OnClickListener)new w(this));
    dzO();
    paramBundle = new b.b();
    localObject = al.waC;
    paramBundle.ayU(al.dEG());
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    paramBundle.maxHeight = com.tencent.mm.plugin.finder.storage.c.dqO();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    paramBundle.maxWidth = com.tencent.mm.plugin.finder.storage.c.dqP();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    paramBundle.xkY = com.tencent.mm.plugin.finder.storage.c.dqQ();
    this.vLu = new com.tencent.mm.plugin.gallery.picker.b.b(paramBundle);
    localObject = this.vLu;
    if (localObject == null) {
      p.btv("mediaTailor");
    }
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).a((com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.l(paramBundle));
    localObject = this.vLu;
    if (localObject == null) {
      p.btv("mediaTailor");
    }
    paramBundle = (com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.j(paramBundle);
    p.h(paramBundle, "<set-?>");
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).xkU = paramBundle;
    initView();
    AppMethodBeat.o(167389);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252513);
    super.onDestroy();
    AppMethodBeat.o(252513);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(167394);
    super.onPause();
    if (!this.vLp) {
      dzH().onUIPause();
    }
    AppMethodBeat.o(167394);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167393);
    super.onResume();
    Object localObject2;
    if (this.vLp)
    {
      localObject1 = dzJ();
      p.g(localObject1, "previewRecyclerView");
      localObject2 = ((RecyclerView)localObject1).getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof b)) {
        localObject1 = null;
      }
      localObject1 = (b)localObject1;
      localObject2 = dzG();
      p.g(localObject2, "selectPathList");
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      int j;
      if (((Iterator)localObject2).hasNext()) {
        if (((GalleryItem.MediaItem)((Iterator)localObject2).next()).xiZ == this.vLr)
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
        localObject1 = dzH();
        long l = ((GalleryItem.MediaItem)localObject2).xiZ;
        p.g(localObject2, "item");
        localObject2 = ((GalleryItem.MediaItem)localObject2).dRh();
        p.g(localObject2, "item.originalPath");
        ((WxMediaCropLayout)localObject1).a(l, (String)localObject2, true, this.vLq, true);
      }
      this.vLp = false;
      AppMethodBeat.o(167393);
      return;
    }
    Object localObject1 = dzH();
    Log.i("WxMediaCropLayout", "onUIResume");
    if (((WxMediaCropLayout)localObject1).ofW != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).ofW;
      if (localObject2 != null) {
        ((CommonVideoView)localObject2).onUIResume();
      }
    }
    if (((WxMediaCropLayout)localObject1).wgF != null)
    {
      localObject1 = ((WxMediaCropLayout)localObject1).wgF;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject1).eKR();
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
  public static final class PreviewItemView
    extends FrameLayout
  {
    private final ImageView dKU;
    private final View maskView;
    private final int padding;
    private final int size;
    private final int vLI;
    private final View vLJ;
    
    public PreviewItemView(Context paramContext)
    {
      super();
      AppMethodBeat.i(167351);
      paramContext = MMApplicationContext.getContext();
      p.g(paramContext, "MMApplicationContext.getContext()");
      this.vLI = paramContext.getResources().getColor(2131100920);
      this.dKU = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.vLJ = new View(getContext());
      paramContext = getContext();
      p.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165277));
      paramContext = getContext();
      p.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165311));
      this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.vLJ.setBackgroundColor(this.vLI);
      addView(this.vLJ, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.dKU, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.maskView;
      localObject = getContext();
      p.g(localObject, "context");
      paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(2131101424));
      this.maskView.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167351);
    }
    
    public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(167352);
      paramContext = MMApplicationContext.getContext();
      p.g(paramContext, "MMApplicationContext.getContext()");
      this.vLI = paramContext.getResources().getColor(2131100920);
      this.dKU = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.vLJ = new View(getContext());
      paramContext = getContext();
      p.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165277));
      paramContext = getContext();
      p.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165311));
      this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.vLJ.setBackgroundColor(this.vLI);
      addView(this.vLJ, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.dKU, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.maskView;
      paramAttributeSet = getContext();
      p.g(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101424));
      this.maskView.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167352);
    }
    
    public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(167353);
      paramContext = MMApplicationContext.getContext();
      p.g(paramContext, "MMApplicationContext.getContext()");
      this.vLI = paramContext.getResources().getColor(2131100920);
      this.dKU = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.vLJ = new View(getContext());
      paramContext = getContext();
      p.g(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(2131165277));
      paramContext = getContext();
      p.g(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(2131165311));
      this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.vLJ.setBackgroundColor(this.vLI);
      addView(this.vLJ, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.dKU, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.maskView;
      paramAttributeSet = getContext();
      p.g(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101424));
      this.maskView.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167353);
    }
    
    public final View getFocusedView()
    {
      return this.vLJ;
    }
    
    public final ImageView getImageView()
    {
      return this.dKU;
    }
    
    public final View getMaskView()
    {
      return this.maskView;
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
        this.vLJ.setVisibility(0);
        AppMethodBeat.o(167349);
        return;
      }
      this.vLJ.setVisibility(4);
      AppMethodBeat.o(167349);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(167350);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.maskView.setVisibility(4);
        AppMethodBeat.o(167350);
        return;
      }
      this.maskView.setVisibility(0);
      AppMethodBeat.o(167350);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$Companion;", "", "()V", "CLEAR_LIST", "", "FRONT_VLOG_VIDEO", "REQUEST_CODE_EDIT", "", "SELECT_PATH_LIST", "SELECT_VIDEO_DURATION", "SELECT_VIDEO_PATH", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    aa(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167380);
      Object localObject = FinderMediaCropUI.d(this.vLw);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        Log.d("Finder.MediaCropUI", "tipDialog is show!");
        AppMethodBeat.o(167380);
        return;
        localObject = this.vLw;
        Context localContext = (Context)localObject;
        ((FinderMediaCropUI)localObject).getString(2131755998);
        FinderMediaCropUI.a((FinderMediaCropUI)localObject, (Dialog)h.a(localContext, ((FinderMediaCropUI)localObject).getString(2131756029), false, (DialogInterface.OnCancelListener)a.vLT));
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a vLT;
      
      static
      {
        AppMethodBeat.i(167379);
        vLT = new a();
        AppMethodBeat.o(167379);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends q
    implements kotlin.g.a.a<ArrayList<GalleryItem.MediaItem>>
  {
    ac(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ad
    extends q
    implements kotlin.g.a.a<CheckBox>
  {
    ad(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.a<View>
  {
    ae(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView>
  {
    public b()
    {
      AppMethodBeat.i(167331);
      au(true);
      AppMethodBeat.o(167331);
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(167327);
      p.h(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (FinderMediaCropUI.PreviewItemView)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
      Object localObject = com.tencent.mm.plugin.gallery.picker.c.f.xlA;
      localObject = com.tencent.mm.plugin.gallery.picker.c.f.dRD();
      p.g(localMediaItem, "media");
      ((com.tencent.mm.loader.d)localObject).bP(localMediaItem).a(paramb.getImageView(), true);
      p.g(paramb, "itemView");
      if (((FinderMediaCropUI.d)FinderMediaCropUI.a(this.vLw).get(localMediaItem.xiZ)).vLG != -1)
      {
        bool1 = true;
        paramb.setSelected(bool1);
        if (localMediaItem.xiZ != FinderMediaCropUI.b(this.vLw)) {
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
      AppMethodBeat.i(252504);
      p.h(paramb, "holder");
      p.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(252504);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(167330);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).xiZ;
      AppMethodBeat.o(167330);
      return l;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder_release"})
  public static final class d
  {
    public static final a vLH;
    WxMediaCropLayout.b vLF;
    int vLG;
    
    static
    {
      AppMethodBeat.i(167348);
      vLH = new a((byte)0);
      AppMethodBeat.o(167348);
    }
    
    public d()
    {
      AppMethodBeat.i(167347);
      this.vLF = new WxMediaCropLayout.b(0L, "");
      this.vLG = -1;
      AppMethodBeat.o(167347);
    }
    
    public final void a(WxMediaCropLayout.b paramb)
    {
      AppMethodBeat.i(167346);
      p.h(paramb, "<set-?>");
      this.vLF = paramb;
      AppMethodBeat.o(167346);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder_release"})
    public static final class a {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$calculateCallback$1", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-finder_release"})
  public static final class f
    implements WxMediaCropLayout.c
  {
    public final void a(int[] paramArrayOfInt, RectF paramRectF)
    {
      AppMethodBeat.i(167355);
      p.h(paramArrayOfInt, "mediaWH");
      p.h(paramRectF, "maxCropRect");
      RectF localRectF = new RectF(paramRectF);
      Object localObject = y.vXH;
      localObject = this.vLw.getBaseContext();
      p.g(localObject, "baseContext");
      paramArrayOfInt = y.g((Context)localObject, paramArrayOfInt[0], paramArrayOfInt[1]);
      ((Number)paramArrayOfInt.second).intValue();
      int i = ((Number)paramArrayOfInt.SWY).intValue();
      float f = (paramRectF.height() - i) / 2.0F;
      paramRectF.top += f;
      paramRectF.bottom -= f;
      Log.i("Finder.MediaCropUI", "[calculate] NEW=" + paramRectF + " OLD=" + localRectF + " isAdaptSrc=true");
      AppMethodBeat.o(167355);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<WxMediaCropLayout>
  {
    g(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167357);
      RecyclerView.v localv = this.vLw.dzJ().ch(this.gUj);
      if (localv != null)
      {
        localv.aus.callOnClick();
        AppMethodBeat.o(167357);
        return;
      }
      AppMethodBeat.o(167357);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167358);
      RecyclerView.v localv = this.vLw.dzJ().ch(this.gUj);
      if (localv != null)
      {
        localv.aus.callOnClick();
        AppMethodBeat.o(167358);
        return;
      }
      AppMethodBeat.o(167358);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<View>
  {
    j(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167361);
      RectF localRectF = FinderMediaCropUI.e(this.vLw);
      WxMediaCropLayout.a(this.vLw.dzH(), localRectF.width() * 0.5625F, localRectF.height(), localRectF);
      AppMethodBeat.o(167361);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167362);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.vLw.dzG();
      p.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).xiZ == FinderMediaCropUI.b(this.vLw))
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
      int j = this.vLw.dzG().size();
      localObject = (GalleryItem.MediaItem)this.vLw.dzG().get(i);
      FinderMediaCropUI.f(this.vLw);
      if (j <= 1)
      {
        paramView = new Intent();
        paramView.putExtra("clear_list", true);
        this.vLw.setResult(-1, paramView);
        this.vLw.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167362);
        return;
      }
      if (i == 0) {}
      for (j = 1;; j = i - 1)
      {
        paramView = this.vLw.dzJ().cg(j);
        this.vLw.dzG().remove(localObject);
        localObject = this.vLw.dzJ();
        p.g(localObject, "previewRecyclerView");
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).ck(i);
        }
        if (paramView != null)
        {
          paramView = paramView.aus;
          if (paramView != null) {
            paramView.callOnClick();
          }
        }
        FinderMediaCropUI.g(this.vLw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167362);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167363);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = this.vLw.dzG();
      p.g(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      int j;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).xiZ == FinderMediaCropUI.b(this.vLw))
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
      paramView = this.vLw.dzJ();
      p.g(paramView, "previewRecyclerView");
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
        localObject1 = (CharSequence)paramView.xiX;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label820;
        }
        i = 1;
        if (i != 0) {
          paramView.xiX = paramView.xiW;
        }
        p.g(paramView, "item");
        if (paramView.getType() != 2) {
          break label826;
        }
        this.vLw.vLp = true;
        localObject1 = this.vLw.dzH();
        Log.i("WxMediaCropLayout", "onUIRelease");
        if (((WxMediaCropLayout)localObject1).ofW != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).ofW;
          if (localObject2 != null) {
            ((CommonVideoView)localObject2).onUIDestroy();
          }
          ((WxMediaCropLayout)localObject1).ofW = null;
        }
        if (((WxMediaCropLayout)localObject1).wgF != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).wgF;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject2).release();
          }
          ((WxMediaCropLayout)localObject1).wgF = null;
        }
        localObject3 = this.vLw.dzH().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).iiw;
        f1 = ((WxMediaCropLayout.b)localObject3).viewRect.height() * 1.0F / ((WxMediaCropLayout.b)localObject3).viewRect.width() * ((WxMediaCropLayout.b)localObject3).iiw.width();
        i = ((WxMediaCropLayout.b)localObject3).iiw.left;
        j = (int)(((WxMediaCropLayout.b)localObject3).iiw.centerY() - f1 / 2.0F);
        int k = ((WxMediaCropLayout.b)localObject3).iiw.right;
        f2 = ((WxMediaCropLayout.b)localObject3).iiw.centerY();
        localObject4 = new Rect(i, j, k, (int)(f1 / 2.0F + f2));
        localObject2 = this.vLw.dzH();
        p.g(localObject2, "cropLayout");
        i = ((WxMediaCropLayout)localObject2).getHeight() / 2 - ((WxMediaCropLayout.b)localObject3).xne.centerY();
        ((Rect)localObject4).top += i;
        ((Rect)localObject4).bottom += i;
        f1 = ((WxMediaCropLayout.b)localObject3).rwL.width() * 1.0F / ((WxMediaCropLayout.b)localObject3).iiw.width();
        localObject2 = new Matrix();
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).rwL.left - ((Rect)localObject4).left, ((WxMediaCropLayout.b)localObject3).rwL.top - ((Rect)localObject4).top);
        f1 = ((WxMediaCropLayout.b)localObject3).rwL.centerX();
        f2 = ((WxMediaCropLayout.b)localObject3).iiw.centerX();
        float f3 = ((WxMediaCropLayout.b)localObject3).rwL.centerY();
        float f4 = ((WxMediaCropLayout.b)localObject3).iiw.centerY();
        float f5 = i;
        localObject3 = ao.az((Context)this.vLw.getContext());
        localObject4 = y.vXH;
        localObject4 = this.vLw.getBaseContext();
        p.g(localObject4, "baseContext");
        y.g((Context)localObject4, ((Point)localObject3).x, ((Point)localObject3).y);
        new Point(((Point)localObject3).x, ((Point)localObject3).y);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject3 = this.vLw.getContext();
        p.g(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.xiX;
        p.g(localObject4, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, paramView.getType(), (Matrix)localObject2, (Rect)localObject1, new float[] { f1 - f2, f3 - f4 - f5 });
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167363);
        return;
        label820:
        i = 0;
        break;
        label826:
        localObject3 = this.vLw.dzH().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).iiw;
        localObject2 = new Matrix();
        localObject4 = new float[9];
        ((WxMediaCropLayout.b)localObject3).gT.getValues((float[])localObject4);
        f1 = localObject4[0];
        f2 = localObject4[3];
        double d1 = f1 * f1;
        double d2 = f2;
        f1 = (float)Math.sqrt(f2 * d2 + d1);
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).rwL.left, ((WxMediaCropLayout.b)localObject3).rwL.top);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject3 = this.vLw.getContext();
        p.g(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.xiX;
        p.g(localObject4, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, paramView.getType(), (Matrix)localObject2, (Rect)localObject1);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$4", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class o
    extends RecyclerView.h
  {
    private final float offset;
    
    o()
    {
      AppMethodBeat.i(167365);
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(2131165296);
      AppMethodBeat.o(167365);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(167364);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramView = paramRecyclerView.bi(paramView);
      p.g(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.lR();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.vLw.dzG().size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(167364);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$5", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252505);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = this.vLw;
      localObject1 = this.vLw.dzN();
      p.g(localObject1, "switchVLogCheckbox");
      FinderMediaCropUI.a(paramView, ((CheckBox)localObject1).isChecked());
      if (FinderMediaCropUI.h(this.vLw))
      {
        this.vLK.setItems((List)this.vLw.dzG());
        localObject1 = this.vLw;
        paramView = this.vLw.dzJ().cg(0);
        if (paramView == null) {
          break label173;
        }
      }
      label173:
      for (paramView = paramView.aus;; paramView = null)
      {
        if (paramView == null) {
          p.hyc();
        }
        p.g(paramView, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        Object localObject2 = this.vLw.dzG().get(0);
        p.g(localObject2, "selectPathList[0]");
        ((FinderMediaCropUI)localObject1).a(0, paramView, (GalleryItem.MediaItem)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252505);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(252506);
      this.vLK.setItems(this.vLw.dzG().subList(0, 1));
      FinderMediaCropUI.a(this.vLw).put(0L, new FinderMediaCropUI.d());
      FinderMediaCropUI localFinderMediaCropUI = this.vLw;
      Object localObject = this.vLw.dzJ().cg(0);
      if (localObject != null) {}
      for (localObject = ((RecyclerView.v)localObject).aus;; localObject = null)
      {
        if (localObject == null) {
          p.hyc();
        }
        p.g(localObject, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        GalleryItem.MediaItem localMediaItem = this.vLw.vLf;
        if (localMediaItem == null) {
          p.hyc();
        }
        localFinderMediaCropUI.a(0, (View)localObject, localMediaItem);
        AppMethodBeat.o(252506);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    s(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167369);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      Object localObject = this.vLw.getContext();
      p.g(localObject, "context");
      localLayoutParams.topMargin = ((int)((AppCompatActivity)localObject).getResources().getDimension(2131165314) + au.D(this.vLw.getBaseContext(), (int)this.vLw.getResources().getDimension(2131165308)));
      localObject = this.vLw.dzI();
      p.g(localObject, "actionBarLayout");
      ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      this.vLw.dzI().requestLayout();
      AppMethodBeat.o(167369);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167370);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.bottomMargin = av.aD(this.vLw.getBaseContext());
      localLayoutParams.gravity = 80;
      View localView = this.vLw.dzK();
      p.g(localView, "footer");
      localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(167370);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167371);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vLw.setResult(0);
      this.vLw.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167371);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167372);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderMediaCropUI.c(this.vLw);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167372);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "isSuccessfully", "", "invoke"})
  static final class x
    extends q
    implements m<List<? extends MediaSelectedData>, Boolean, x>
  {
    x(FinderMediaCropUI paramFinderMediaCropUI, List paramList)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onGenerateMedia$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$$special$$inlined$apply$lambda$1"})
  static final class y
    extends q
    implements m<Boolean, b.f, x>
  {
    y(GalleryItem.MediaItem paramMediaItem, int paramInt, FinderMediaCropUI paramFinderMediaCropUI, ArrayList paramArrayList, z.f paramf, m paramm, z.d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.a<TextView>
  {
    z(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI
 * JD-Core Version:    0.7.0.1
 */