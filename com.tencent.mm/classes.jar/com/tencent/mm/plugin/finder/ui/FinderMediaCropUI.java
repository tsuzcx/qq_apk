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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.gallery.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.ay;
import com.tencent.mm.ui.base.a.a.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.r;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "actionBarLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActionBarLayout", "()Landroid/view/View;", "actionBarLayout$delegate", "Lkotlin/Lazy;", "calculateCallback", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "getCalculateCallback", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "editBtn", "getEditBtn", "editBtn$delegate", "footer", "getFooter", "footer$delegate", "hasDestroyVideoView", "", "getHasDestroyVideoView", "()Z", "setHasDestroyVideoView", "(Z)V", "isFromAppBrand", "isFromAppBrand$delegate", "isPreviewTvChange", "isSwitchNormalMode", "mediaExtraMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "value", "", "previewId", "setPreviewId", "(J)V", "previewNumTv", "Landroid/widget/TextView;", "getPreviewNumTv", "()Landroid/widget/TextView;", "previewNumTv$delegate", "previewRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getPreviewRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "previewRecyclerView$delegate", "processDialogRunnable", "Ljava/lang/Runnable;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSelectPathList", "()Ljava/util/ArrayList;", "selectPathList$delegate", "switchVLogCheckbox", "Landroid/widget/CheckBox;", "getSwitchVLogCheckbox", "()Landroid/widget/CheckBox;", "switchVLogCheckbox$delegate", "switchVLogLayout", "getSwitchVLogLayout", "switchVLogLayout$delegate", "tipDialog", "Landroid/app/Dialog;", "vLogCropRect", "Landroid/graphics/Rect;", "vlogVideoPath", "getVlogVideoPath", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setVlogVideoPath", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "canEnableMultiImage", "checkCropInfo", "", "type", "", "path", "", "matrix", "Landroid/graphics/Matrix;", "cropRect", "contentRect", "viewRect", "position", "initCropRect", "checkIsAllImage", "defaultPreview", "getDefaultVideoVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getForceOrientation", "getLayoutId", "getMenuText", "initView", "isInVLogMode", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onGenerateMedia", "selectedMedias", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "isSuccessfully", "onPause", "onPreviewItem", "view", "item", "onResume", "reloadVLogFake", "setWindowStyle", "showProcessDialog", "delay", "updateOptionMenu", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "MediaExtra", "PreviewItemView", "plugin-finder_release"})
public final class FinderMediaCropUI
  extends MMFinderUI
{
  public static final a Asi;
  private final Runnable Aqu;
  private final LongSparseArray<d> ArQ;
  private final kotlin.f ArR;
  GalleryItem.MediaItem ArS;
  private final kotlin.f ArT;
  private final kotlin.f ArU;
  private final kotlin.f ArV;
  private final kotlin.f ArW;
  private final kotlin.f ArX;
  private final kotlin.f ArY;
  private final kotlin.f ArZ;
  private final kotlin.f Asa;
  final kotlin.f Asb;
  boolean Asc;
  private final WxMediaCropLayout.c Asd;
  private long Ase;
  private boolean Asf;
  private boolean Asg;
  private com.tencent.mm.plugin.gallery.picker.b.b Ash;
  private HashMap _$_findViewCache;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167382);
    Asi = new a((byte)0);
    AppMethodBeat.o(167382);
  }
  
  public FinderMediaCropUI()
  {
    AppMethodBeat.i(167398);
    this.ArQ = new LongSparseArray();
    this.ArR = kotlin.g.ar((kotlin.g.a.a)new ac(this));
    this.ArT = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.ArU = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.ArV = kotlin.g.ar((kotlin.g.a.a)new aa(this));
    this.ArW = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.ArX = kotlin.g.ar((kotlin.g.a.a)new z(this));
    this.ArY = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.ArZ = kotlin.g.ar((kotlin.g.a.a)new ae(this));
    this.Asa = kotlin.g.ar((kotlin.g.a.a)new ad(this));
    this.Asb = kotlin.g.ar((kotlin.g.a.a)new s(this));
    this.Asd = ((WxMediaCropLayout.c)new f(this));
    this.Aqu = ((Runnable)new ab(this));
    AppMethodBeat.o(167398);
  }
  
  private final void a(List<? extends GalleryItem.MediaItem> paramList, final kotlin.g.a.m<? super List<? extends MediaSelectedData>, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(167396);
    MMHandlerThread.postToMainThreadDelayed(this.Aqu, 300L);
    final aa.d locald = new aa.d();
    locald.aaBA = ((Collection)paramList).size();
    final ArrayList localArrayList = new ArrayList(9);
    final aa.f localf = new aa.f();
    localf.aaBC = new Rect();
    paramList = ((Iterable)paramList).iterator();
    final int i = 0;
    if (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (GalleryItem.MediaItem)localObject1;
      localArrayList.add(new MediaSelectedData(-1));
      Object localObject2 = (d)this.ArQ.get(((GalleryItem.MediaItem)localObject1).BVl);
      String str = ((GalleryItem.MediaItem)localObject1).AAz;
      Matrix localMatrix = new Matrix(((d)localObject2).Ass.eum());
      Rect localRect1 = new Rect(((d)localObject2).Ass.kXj);
      Rect localRect2 = new Rect(((d)localObject2).Ass.vcr);
      localObject2 = new Rect(((d)localObject2).Ass.viewRect);
      if (i == 0) {
        ((Rect)localf.aaBC).set(localRect1);
      }
      int j = ((GalleryItem.MediaItem)localObject1).getType();
      p.j(str, "path");
      Object localObject3 = (Rect)localf.aaBC;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if ((localRect1.isEmpty()) || (localRect2.isEmpty()))
      {
        localObject4 = getContext();
        p.j(localObject4, "context");
        localObject4 = new CropLayout((Context)localObject4);
        localObject5 = new View((Context)getContext());
        if (j != 2) {
          break label723;
        }
        localObject6 = com.tencent.mm.plugin.gallery.a.d.CeY;
        localObject6 = com.tencent.mm.plugin.gallery.a.d.aFG(str);
        CropLayout.a((CropLayout)localObject4, (View)localObject5, ((com.tencent.mm.plugin.sight.base.b)localObject6).width, ((com.tencent.mm.plugin.sight.base.b)localObject6).height, null, null, null, 56);
        ((Rect)localObject2).set(0, 0, ((com.tencent.mm.plugin.sight.base.b)localObject6).width, ((com.tencent.mm.plugin.sight.base.b)localObject6).height);
        ((View)localObject5).setRight(((com.tencent.mm.plugin.sight.base.b)localObject6).width);
        ((View)localObject5).setBottom(((com.tencent.mm.plugin.sight.base.b)localObject6).height);
        label399:
        Log.i("Finder.MediaCropUI", "[checkCropInfo] need to set default CropInfo. type=" + j + " position=" + i + " viewRect=" + localObject2 + " contentRect=" + localRect2 + " cropRect=" + localRect1);
        ((CropLayout)localObject4).getVisibilityRect().set((Rect)localObject3);
        localObject5 = eax();
        p.j(localObject5, "cropLayout");
        j = ((WxMediaCropLayout)localObject5).getLeft();
        localObject5 = eax();
        p.j(localObject5, "cropLayout");
        int k = ((WxMediaCropLayout)localObject5).getTop();
        localObject5 = eax();
        p.j(localObject5, "cropLayout");
        int m = ((WxMediaCropLayout)localObject5).getRight();
        localObject5 = eax();
        p.j(localObject5, "cropLayout");
        ((CropLayout)localObject4).e(true, j, k, m, ((WxMediaCropLayout)localObject5).getBottom());
        localMatrix.set(((CropLayout)localObject4).getMainMatrix());
        if (!((Rect)localObject3).isEmpty()) {
          break label792;
        }
        ean().round(localRect1);
      }
      for (;;)
      {
        localRect2.set(((CropLayout)localObject4).getContentRect());
        Log.i("Finder.MediaCropUI", "onGenerateMedia, cropRect:" + localRect1 + ", contentRect:" + localRect1 + ", viewRect:" + localObject2);
        j = ((GalleryItem.MediaItem)localObject1).getType();
        localObject3 = this.Ash;
        if (localObject3 == null) {
          p.bGy("mediaTailor");
        }
        com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject3, str, j, localMatrix, localRect1, localRect2, (Rect)localObject2, i, (kotlin.g.a.m)new y((GalleryItem.MediaItem)localObject1, i, this, localArrayList, localf, paramm, locald));
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
  
  private TextView eaB()
  {
    AppMethodBeat.i(167388);
    TextView localTextView = (TextView)this.ArX.getValue();
    AppMethodBeat.o(167388);
    return localTextView;
  }
  
  private View eaC()
  {
    AppMethodBeat.i(227725);
    View localView = (View)this.ArZ.getValue();
    AppMethodBeat.o(227725);
    return localView;
  }
  
  private final void eaE()
  {
    AppMethodBeat.i(167390);
    TextView localTextView = (TextView)findViewById(com.tencent.mm.plugin.finder.b.f.action_option_icon);
    Object localObject1 = eaw();
    p.j(localObject1, "selectPathList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label125:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localObject3;
      if (((d)this.ArQ.get(localMediaItem.BVl)).Ast != -1) {}
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
      p.j(localObject2, "context");
      localObject1 = ((AppCompatActivity)localObject2).getResources().getString(b.j.app_finish) + '(' + i + ')';
      localTextView.setText((CharSequence)localObject1);
      localObject1 = eaw();
      p.j(localObject1, "selectPathList");
      localObject2 = ((Iterable)localObject1).iterator();
      label228:
      if (!((Iterator)localObject2).hasNext()) {
        break label337;
      }
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (GalleryItem.MediaItem)localObject1;
      if (((d)this.ArQ.get(((GalleryItem.MediaItem)localObject3).BVl)).Ast == -1) {
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
      p.j(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(b.j.app_finish);
      p.j(localObject1, "context.resources.getString(R.string.app_finish)");
      break;
      i = 0;
      break label276;
      break label228;
      localObject1 = null;
      break label280;
    }
  }
  
  private final boolean eaF()
  {
    AppMethodBeat.i(227780);
    Object localObject = eaw();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((ArrayList)localObject).size());; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      if (((Integer)localObject).intValue() > 1) {
        break;
      }
      AppMethodBeat.o(227780);
      return false;
    }
    localObject = eaw();
    p.j(localObject, "selectPathList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
      p.j(localMediaItem, "it");
      if (localMediaItem.getType() == 2)
      {
        AppMethodBeat.o(227780);
        return false;
      }
    }
    AppMethodBeat.o(227780);
    return true;
  }
  
  private final RectF ean()
  {
    AppMethodBeat.i(167392);
    Object localObject = getContext();
    p.j(localObject, "context");
    float f2 = ((AppCompatActivity)localObject).getResources().getDimension(b.d.DefaultActionbarHeight);
    localObject = getContext();
    p.j(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(b.d.Edge_6A);
    localObject = eax();
    p.j(localObject, "cropLayout");
    float f1 = ((WxMediaCropLayout)localObject).getWidth() * 3.5F / 3.0F;
    localObject = eax();
    p.j(localObject, "cropLayout");
    int i = ((WxMediaCropLayout)localObject).getHeight();
    localObject = eaA();
    p.j(localObject, "footer");
    f2 = f2 + f3 + (i - ((View)localObject).getHeight() - f2 - f3 - ay.aB(getBaseContext()) - f1) / 2.0F;
    localObject = eax();
    p.j(localObject, "cropLayout");
    f3 = ((WxMediaCropLayout)localObject).getLeft();
    localObject = eax();
    p.j(localObject, "cropLayout");
    localObject = new RectF(f3, f2, ((WxMediaCropLayout)localObject).getRight(), f1 + f2);
    AppMethodBeat.o(167392);
    return localObject;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(227889);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(227889);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(227887);
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
    AppMethodBeat.o(227887);
    return localView1;
  }
  
  public final void a(int paramInt, View paramView, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(227772);
    p.k(paramView, "view");
    p.k(paramMediaItem, "item");
    if (paramView.getTag() != null)
    {
      Log.w("Finder.MediaCropUI", "this view is Animating");
      AppMethodBeat.o(227772);
      return;
    }
    Object localObject1 = eaz().k(this.Ase);
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.v)localObject1).amk;
      p.j(localObject1, "preHolder.itemView");
      ((View)localObject1).setFocusable(false);
    }
    this.Ase = paramMediaItem.BVl;
    localObject1 = eaw();
    p.j(localObject1, "selectPathList");
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
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).BVl == this.Ase)
      {
        j = 1;
        if (j == 0) {
          break label456;
        }
        if (i >= 0)
        {
          eaw().get(i);
          if (((d)this.ArQ.get(this.Ase)).Ast != -1) {
            break label471;
          }
          localObject1 = eaB();
          p.j(localObject1, "previewNumTv");
          ((TextView)localObject1).setText((CharSequence)"");
          localObject1 = eaB();
          p.j(localObject1, "previewNumTv");
          localObject2 = getContext();
          p.j(localObject2, "context");
          ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(b.e.num_checkbox_unselected));
        }
        paramView.setFocusable(true);
        paramView = eaz();
        p.j(paramView, "previewRecyclerView");
        paramView = paramView.getAdapter();
        if (paramView != null) {
          paramView.d(paramInt, new Object());
        }
        if (paramInt == 0) {
          eax().setLockCropMediaId(paramMediaItem.BVl);
        }
        l = paramMediaItem.BVl;
        if (paramMediaItem.getType() != 2) {
          break label547;
        }
        paramInt = 1;
        localObject1 = (d)this.ArQ.get(this.Ase);
        paramView = eax();
        paramMediaItem = paramMediaItem.etI();
        p.j(paramMediaItem, "item.originalPath");
        localObject2 = this.Asd;
        p.k(paramMediaItem, "mediaPath");
        Log.i("WxMediaCropLayout", "onPreview type: ".concat(String.valueOf(paramInt)));
        bool = false;
        if (paramView.ttK != paramInt) {
          bool = true;
        }
        paramView.ttK = paramInt;
        if (paramInt != 2) {
          break label552;
        }
        paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, (WxMediaCropLayout.c)localObject2, null, 16);
      }
    }
    for (;;)
    {
      ((d)localObject1).a(paramView);
      AppMethodBeat.o(227772);
      return;
      j = 0;
      break label157;
      label456:
      i += 1;
      break;
      i = -1;
      break label162;
      label471:
      localObject1 = eaB();
      p.j(localObject1, "previewNumTv");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(i + 1));
      localObject1 = eaB();
      p.j(localObject1, "previewNumTv");
      localObject2 = getContext();
      p.j(localObject2, "context");
      ((TextView)localObject1).setBackground(((AppCompatActivity)localObject2).getResources().getDrawable(b.e.orange_oval_shape));
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
  
  public final View eaA()
  {
    AppMethodBeat.i(167387);
    View localView = (View)this.ArW.getValue();
    AppMethodBeat.o(167387);
    return localView;
  }
  
  public final CheckBox eaD()
  {
    AppMethodBeat.i(227726);
    CheckBox localCheckBox = (CheckBox)this.Asa.getValue();
    AppMethodBeat.o(227726);
    return localCheckBox;
  }
  
  public final ArrayList<GalleryItem.MediaItem> eaw()
  {
    AppMethodBeat.i(167383);
    ArrayList localArrayList = (ArrayList)this.ArR.getValue();
    AppMethodBeat.o(167383);
    return localArrayList;
  }
  
  public final WxMediaCropLayout eax()
  {
    AppMethodBeat.i(167384);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.ArT.getValue();
    AppMethodBeat.o(167384);
    return localWxMediaCropLayout;
  }
  
  public final View eay()
  {
    AppMethodBeat.i(167385);
    View localView = (View)this.ArU.getValue();
    AppMethodBeat.o(167385);
    return localView;
  }
  
  public final RecyclerView eaz()
  {
    AppMethodBeat.i(227723);
    RecyclerView localRecyclerView = (RecyclerView)this.ArV.getValue();
    AppMethodBeat.o(227723);
    return localRecyclerView;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_media_edit_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167391);
    super.initView();
    eax().setShowBorder(true);
    eax().post((Runnable)new l(this));
    eaB().setOnClickListener((View.OnClickListener)new m(this));
    ((View)this.ArY.getValue()).setOnClickListener((View.OnClickListener)new n(this));
    eaz().setHasFixedSize(true);
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    Object localObject2 = eaz();
    p.j(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    ((LinearLayoutManager)localObject1).setItemPrefetchEnabled(true);
    localObject1 = eaz();
    p.j(localObject1, "previewRecyclerView");
    ((RecyclerView)localObject1).setItemAnimator((RecyclerView.f)new androidx.recyclerview.widget.g());
    eaz().b((RecyclerView.h)new o(this));
    localObject1 = new b();
    new androidx.recyclerview.widget.l((l.a)new c((com.tencent.mm.ui.base.a.a)localObject1)).a(eaz());
    localObject2 = eaz();
    p.j(localObject2, "previewRecyclerView");
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
    ((b)localObject1).Wqm = ((a.a)new p(this));
    localObject2 = eaw();
    p.j(localObject2, "selectPathList");
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      p.j(localObject3, "it");
      if (((GalleryItem.MediaItem)localObject3).getType() == 2)
      {
        i = 0;
        if (i != 0) {
          this.Asf = true;
        }
        localObject2 = eaD();
        p.j(localObject2, "switchVLogCheckbox");
        ((CheckBox)localObject2).setChecked(this.Asf);
        if (!eaF()) {
          break label474;
        }
        localObject2 = eaC();
        p.j(localObject2, "switchVLogLayout");
        ((View)localObject2).setVisibility(0);
        eaD().setOnClickListener((View.OnClickListener)new q(this, (b)localObject1));
      }
    }
    for (;;)
    {
      localObject2 = new StringBuilder("isInVLogMode: false, final check, IS_VLOG_BACKGROUND_MUX: ");
      localObject3 = com.tencent.mm.plugin.finder.storage.d.AjH;
      Log.i("Finder.MediaCropUI", com.tencent.mm.plugin.finder.storage.d.dSZ());
      ((b)localObject1).setItems((List)eaw());
      if ((this.ArS == null) || (!eaF())) {
        break label495;
      }
      eaz().postDelayed((Runnable)new r(this, (b)localObject1), 500L);
      AppMethodBeat.o(167391);
      return;
      i = 1;
      break;
      label474:
      localObject2 = eaC();
      p.j(localObject2, "switchVLogLayout");
      ((View)localObject2).setVisibility(8);
    }
    label495:
    eaz().post((Runnable)new h(this));
    eaz().postDelayed((Runnable)new i(this), 500L);
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
          p.iCn();
        }
        paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        if (paramIntent == null) {
          p.iCn();
        }
        Object localObject2 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
        this.Asc = false;
        paramIntent = eaw();
        p.j(paramIntent, "selectPathList");
        paramIntent = (List)paramIntent;
        paramInt1 = 0;
        paramIntent = paramIntent.iterator();
        if (paramIntent.hasNext()) {
          if (((GalleryItem.MediaItem)paramIntent.next()).BVl == this.Ase)
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
        paramIntent = eaz();
        p.j(paramIntent, "previewRecyclerView");
        localObject1 = paramIntent.getAdapter();
        paramIntent = (Intent)localObject1;
        if (!(localObject1 instanceof b)) {
          paramIntent = null;
        }
        localObject1 = (b)paramIntent;
        if (localObject1 != null)
        {
          paramIntent = (GalleryItem.MediaItem)((b)localObject1).auB(paramInt1);
          Boolean localBoolean = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).fvT();
          p.j(localBoolean, "model.photo");
          if (localBoolean.booleanValue())
          {
            paramIntent.BVs = true;
            paramIntent.AAz = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).aZe();
            Log.i("Finder.MediaCropUI", "[onActivityResult] edit photo output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).aZe());
            localObject1 = (d)this.ArQ.get(paramIntent.BVl);
            localObject2 = eax();
            long l = paramIntent.BVl;
            p.j(paramIntent, "item");
            paramIntent = paramIntent.etI();
            p.j(paramIntent, "item.originalPath");
            ((d)localObject1).a(WxMediaCropLayout.a((WxMediaCropLayout)localObject2, l, paramIntent, true, this.Asd, null, 16));
            paramIntent = eaz();
            p.j(paramIntent, "previewRecyclerView");
            paramIntent = paramIntent.getAdapter();
            if (paramIntent != null)
            {
              paramIntent.cL(paramInt1);
              AppMethodBeat.o(167397);
            }
          }
          else
          {
            Log.i("Finder.MediaCropUI", "[onActivityResult] edit video output=" + ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath());
            paramIntent = GalleryItem.MediaItem.a(2, 0L, ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath(), ((CaptureDataManager.CaptureVideoNormalModel)localObject2).aZe(), "");
            eaw().clear();
            eaw().add(paramIntent);
            ((b)localObject1).setItems((List)eaw());
            ((b)localObject1).notifyDataSetChanged();
            paramIntent = new d();
            paramIntent.Ast = 1;
            this.ArQ.put(0L, paramIntent);
            paramIntent = eaz().cJ(0);
            if (paramIntent != null) {}
            for (paramIntent = paramIntent.amk;; paramIntent = null)
            {
              if (paramIntent == null) {
                p.iCn();
              }
              p.j(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
              localObject1 = eaw().get(0);
              p.j(localObject1, "selectPathList[0]");
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
      paramIntent = eaz().cJ(0);
      if (paramIntent == null) {
        break label614;
      }
    }
    label614:
    for (paramIntent = paramIntent.amk;; paramIntent = null)
    {
      if (paramIntent == null) {
        p.iCn();
      }
      p.j(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      localObject1 = eaw().get(0);
      p.j(localObject1, "selectPathList[0]");
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
    setTheme(b.k.MMTheme_NoTitleTranslucent);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ue(true);
    getWindow().setFormat(-3);
    paramBundle = getIntent().getParcelableArrayListExtra("front_vlog_video");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      this.ArS = ((GalleryItem.MediaItem)paramBundle.get(0));
    }
    eay().post((Runnable)new t(this));
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    paramBundle.bottomMargin = ay.aB(getBaseContext());
    paramBundle.gravity = 80;
    Object localObject = eaA();
    p.j(localObject, "footer");
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    eaA().post((Runnable)new u(this));
    setActionbarColor(getResources().getColor(b.c.transparent));
    findViewById(com.tencent.mm.plugin.finder.b.f.actionbar_up_indicator_btn).setOnClickListener((View.OnClickListener)new v(this));
    findViewById(com.tencent.mm.plugin.finder.b.f.action_option_icon).setOnClickListener((View.OnClickListener)new w(this));
    eaE();
    paramBundle = new b.b();
    localObject = av.AJz;
    paramBundle.aIu(av.egt());
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    paramBundle.maxHeight = com.tencent.mm.plugin.finder.storage.d.dSb();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    paramBundle.maxWidth = com.tencent.mm.plugin.finder.storage.d.dSc();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    paramBundle.BXs = com.tencent.mm.plugin.finder.storage.d.dSd();
    this.Ash = new com.tencent.mm.plugin.gallery.picker.b.b(paramBundle);
    localObject = this.Ash;
    if (localObject == null) {
      p.bGy("mediaTailor");
    }
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).a((com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.m(paramBundle));
    localObject = this.Ash;
    if (localObject == null) {
      p.bGy("mediaTailor");
    }
    paramBundle = (com.tencent.mm.plugin.gallery.picker.b.a)new k(paramBundle);
    p.k(paramBundle, "<set-?>");
    ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).BXo = paramBundle;
    initView();
    AppMethodBeat.o(167389);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(227816);
    super.onDestroy();
    AppMethodBeat.o(227816);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(167394);
    super.onPause();
    if (!this.Asc) {
      eax().onUIPause();
    }
    AppMethodBeat.o(167394);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167393);
    super.onResume();
    Object localObject2;
    if (this.Asc)
    {
      localObject1 = eaz();
      p.j(localObject1, "previewRecyclerView");
      localObject2 = ((RecyclerView)localObject1).getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof b)) {
        localObject1 = null;
      }
      localObject1 = (b)localObject1;
      localObject2 = eaw();
      p.j(localObject2, "selectPathList");
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      int j;
      if (((Iterator)localObject2).hasNext()) {
        if (((GalleryItem.MediaItem)((Iterator)localObject2).next()).BVl == this.Ase)
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
        localObject2 = (GalleryItem.MediaItem)((b)localObject1).auB(i);
        localObject1 = eax();
        long l = ((GalleryItem.MediaItem)localObject2).BVl;
        p.j(localObject2, "item");
        localObject2 = ((GalleryItem.MediaItem)localObject2).etI();
        p.j(localObject2, "item.originalPath");
        ((WxMediaCropLayout)localObject1).a(l, (String)localObject2, true, this.Asd, true);
      }
      this.Asc = false;
      AppMethodBeat.o(167393);
      return;
    }
    Object localObject1 = eax();
    Log.i("WxMediaCropLayout", "onUIResume");
    if (((WxMediaCropLayout)localObject1).rhH != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).rhH;
      if (localObject2 != null) {
        ((CommonVideoView)localObject2).onUIResume();
      }
    }
    if (((WxMediaCropLayout)localObject1).AQa != null)
    {
      localObject1 = ((WxMediaCropLayout)localObject1).AQa;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject1).fxl();
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
  public static final class PreviewItemView
    extends FrameLayout
  {
    private final int Asv;
    private final View Asw;
    private final ImageView fDJ;
    private final View maskView;
    private final int padding;
    private final int size;
    
    public PreviewItemView(Context paramContext)
    {
      super();
      AppMethodBeat.i(167351);
      paramContext = MMApplicationContext.getContext();
      p.j(paramContext, "MMApplicationContext.getContext()");
      this.Asv = paramContext.getResources().getColor(b.c.orange_bg_color);
      this.fDJ = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.Asw = new View(getContext());
      paramContext = getContext();
      p.j(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(b.d.Edge_0_5_A));
      paramContext = getContext();
      p.j(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(b.d.Edge_7_5_A));
      this.fDJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.Asw.setBackgroundColor(this.Asv);
      addView(this.Asw, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.fDJ, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.maskView;
      localObject = getContext();
      p.j(localObject, "context");
      paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(b.c.white));
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
      p.j(paramContext, "MMApplicationContext.getContext()");
      this.Asv = paramContext.getResources().getColor(b.c.orange_bg_color);
      this.fDJ = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.Asw = new View(getContext());
      paramContext = getContext();
      p.j(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(b.d.Edge_0_5_A));
      paramContext = getContext();
      p.j(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(b.d.Edge_7_5_A));
      this.fDJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.Asw.setBackgroundColor(this.Asv);
      addView(this.Asw, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.fDJ, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.maskView;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(b.c.white));
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
      p.j(paramContext, "MMApplicationContext.getContext()");
      this.Asv = paramContext.getResources().getColor(b.c.orange_bg_color);
      this.fDJ = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.Asw = new View(getContext());
      paramContext = getContext();
      p.j(paramContext, "context");
      this.padding = ((int)paramContext.getResources().getDimension(b.d.Edge_0_5_A));
      paramContext = getContext();
      p.j(paramContext, "context");
      this.size = ((int)paramContext.getResources().getDimension(b.d.Edge_7_5_A));
      this.fDJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.Asw.setBackgroundColor(this.Asv);
      addView(this.Asw, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.fDJ, (ViewGroup.LayoutParams)localLayoutParams);
      paramContext = this.maskView;
      paramAttributeSet = getContext();
      p.j(paramAttributeSet, "context");
      paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(b.c.white));
      this.maskView.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167353);
    }
    
    public final View getFocusedView()
    {
      return this.Asw;
    }
    
    public final ImageView getImageView()
    {
      return this.fDJ;
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
        this.Asw.setVisibility(0);
        AppMethodBeat.o(167349);
        return;
      }
      this.Asw.setVisibility(4);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$Companion;", "", "()V", "CLEAR_LIST", "", "FRONT_VLOG_VIDEO", "REQUEST_CODE_EDIT", "", "SELECT_PATH_LIST", "SELECT_VIDEO_DURATION", "SELECT_VIDEO_PATH", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    aa(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167380);
      Object localObject = FinderMediaCropUI.d(this.Asj);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        Log.d("Finder.MediaCropUI", "tipDialog is show!");
        AppMethodBeat.o(167380);
        return;
        localObject = this.Asj;
        Context localContext = (Context)localObject;
        ((FinderMediaCropUI)localObject).getString(b.j.app_tip);
        FinderMediaCropUI.a((FinderMediaCropUI)localObject, (Dialog)h.a(localContext, ((FinderMediaCropUI)localObject).getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.AsG));
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a AsG;
      
      static
      {
        AppMethodBeat.i(167379);
        AsG = new a();
        AppMethodBeat.o(167379);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends q
    implements kotlin.g.a.a<ArrayList<GalleryItem.MediaItem>>
  {
    ac(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ad
    extends q
    implements kotlin.g.a.a<CheckBox>
  {
    ad(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.a<View>
  {
    ae(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView>
  {
    public b()
    {
      AppMethodBeat.i(167331);
      aw(true);
      AppMethodBeat.o(167331);
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(167327);
      p.k(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (FinderMediaCropUI.PreviewItemView)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)auB(paramInt);
      Object localObject = com.tencent.mm.plugin.gallery.picker.c.f.BXU;
      localObject = com.tencent.mm.plugin.gallery.picker.c.f.euf();
      p.j(localMediaItem, "media");
      ((com.tencent.mm.loader.d)localObject).bP(localMediaItem).a(paramb.getImageView(), true);
      p.j(paramb, "itemView");
      if (((FinderMediaCropUI.d)FinderMediaCropUI.a(this.Asj).get(localMediaItem.BVl)).Ast != -1)
      {
        bool1 = true;
        paramb.setSelected(bool1);
        if (localMediaItem.BVl != FinderMediaCropUI.b(this.Asj)) {
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
      AppMethodBeat.i(271719);
      p.k(paramb, "holder");
      p.k(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(271719);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(167330);
      long l = ((GalleryItem.MediaItem)auB(paramInt)).BVl;
      AppMethodBeat.o(167330);
      return l;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder_release"})
  public final class c
    extends l.a
  {
    private int Ask;
    private int Asl;
    private int Asm;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> Asn;
    int fYT;
    
    public c()
    {
      AppMethodBeat.i(167345);
      this.Asn = localObject;
      this.fYT = -1;
      this.Ask = -1;
      this.Asl = -1;
      AppMethodBeat.o(167345);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(255708);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      int i = l.a.cA(51);
      AppMethodBeat.o(255708);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(255704);
      p.k(paramCanvas, "c");
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(255704);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(255696);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv1, "viewHolder");
      p.k(paramv2, "target");
      int i = paramv1.md();
      int j = paramv2.md();
      Log.d("Finder.MediaCropUI", "[onMove] from=" + i + " to=" + j);
      e.e((List)FinderMediaCropUI.this.eaw(), i, j);
      this.Asn.aF(i, j);
      this.Asl = j;
      AppMethodBeat.o(255696);
      return true;
    }
    
    public final void b(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(255697);
      super.b(paramv, paramInt);
      if (paramv != null)
      {
        Object localObject = paramv.amk;
        p.j(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), b.a.move_scale_out);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramv, paramInt));
        paramv.amk.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(255697);
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.v paramv)
    {
      AppMethodBeat.i(255698);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), b.a.move_scale_in);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramv));
      paramv.amk.startAnimation(paramRecyclerView);
      AppMethodBeat.o(255698);
    }
    
    public final float f(RecyclerView.v paramv)
    {
      AppMethodBeat.i(255701);
      p.k(paramv, "viewHolder");
      AppMethodBeat.o(255701);
      return 0.295858F;
    }
    
    public final void g(RecyclerView.v paramv)
    {
      AppMethodBeat.i(255699);
      p.k(paramv, "viewHolder");
      AppMethodBeat.o(255699);
    }
    
    public final boolean kA()
    {
      return false;
    }
    
    public final boolean kz()
    {
      return true;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.v paramv) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(167333);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        Log.d("Finder.MediaCropUI", "finally change from=" + FinderMediaCropUI.c.b(this.Aso) + " to=" + FinderMediaCropUI.c.a(this.Aso));
        AppMethodBeat.o(167333);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(167334);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(167334);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(167332);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(167332);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(FinderMediaCropUI.c paramc, RecyclerView.v paramv, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(167336);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(167336);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(167337);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(167337);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(167335);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          FinderMediaCropUI.c.a(this.Aso, paramv.md());
          FinderMediaCropUI.c.b(this.Aso, FinderMediaCropUI.c.a(this.Aso));
          this.Aso.fYT = FinderMediaCropUI.c.c(this.Aso);
        }
        AppMethodBeat.o(167335);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", "stats", "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder_release"})
  public static final class d
  {
    public static final a Asu;
    WxMediaCropLayout.b Ass;
    int Ast;
    
    static
    {
      AppMethodBeat.i(167348);
      Asu = new a((byte)0);
      AppMethodBeat.o(167348);
    }
    
    public d()
    {
      AppMethodBeat.i(167347);
      this.Ass = new WxMediaCropLayout.b(0L, "");
      this.Ast = -1;
      AppMethodBeat.o(167347);
    }
    
    public final void a(WxMediaCropLayout.b paramb)
    {
      AppMethodBeat.i(167346);
      p.k(paramb, "<set-?>");
      this.Ass = paramb;
      AppMethodBeat.o(167346);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder_release"})
    public static final class a {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$calculateCallback$1", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-finder_release"})
  public static final class f
    implements WxMediaCropLayout.c
  {
    public final void a(int[] paramArrayOfInt, RectF paramRectF)
    {
      AppMethodBeat.i(167355);
      p.k(paramArrayOfInt, "mediaWH");
      p.k(paramRectF, "maxCropRect");
      RectF localRectF = new RectF(paramRectF);
      Object localObject = aj.AGc;
      localObject = this.Asj.getBaseContext();
      p.j(localObject, "baseContext");
      paramArrayOfInt = aj.g((Context)localObject, paramArrayOfInt[0], paramArrayOfInt[1]);
      ((Number)paramArrayOfInt.My).intValue();
      int i = ((Number)paramArrayOfInt.aazK).intValue();
      float f = (paramRectF.height() - i) / 2.0F;
      paramRectF.top += f;
      paramRectF.bottom -= f;
      Log.i("Finder.MediaCropUI", "[calculate] NEW=" + paramRectF + " OLD=" + localRectF + " isAdaptSrc=true");
      AppMethodBeat.o(167355);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<WxMediaCropLayout>
  {
    g(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167357);
      RecyclerView.v localv = this.Asj.eaz().cK(this.jEN);
      if (localv != null)
      {
        localv.amk.callOnClick();
        AppMethodBeat.o(167357);
        return;
      }
      AppMethodBeat.o(167357);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167358);
      RecyclerView.v localv = this.Asj.eaz().cK(this.jEN);
      if (localv != null)
      {
        localv.amk.callOnClick();
        AppMethodBeat.o(167358);
        return;
      }
      AppMethodBeat.o(167358);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<View>
  {
    j(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167361);
      RectF localRectF = FinderMediaCropUI.e(this.Asj);
      WxMediaCropLayout.a(this.Asj.eax(), localRectF.width() * 0.5625F, localRectF.height(), localRectF);
      AppMethodBeat.o(167361);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167362);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.Asj.eaw();
      p.j(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).BVl == FinderMediaCropUI.b(this.Asj))
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
      int j = this.Asj.eaw().size();
      localObject = (GalleryItem.MediaItem)this.Asj.eaw().get(i);
      FinderMediaCropUI.f(this.Asj);
      if (j <= 1)
      {
        paramView = new Intent();
        paramView.putExtra("clear_list", true);
        this.Asj.setResult(-1, paramView);
        this.Asj.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167362);
        return;
      }
      if (i == 0) {}
      for (j = 1;; j = i - 1)
      {
        paramView = this.Asj.eaz().cJ(j);
        this.Asj.eaw().remove(localObject);
        localObject = this.Asj.eaz();
        p.j(localObject, "previewRecyclerView");
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).cN(i);
        }
        if (paramView != null)
        {
          paramView = paramView.amk;
          if (paramView != null) {
            paramView.callOnClick();
          }
        }
        FinderMediaCropUI.g(this.Asj);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167362);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167363);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = this.Asj.eaw();
      p.j(paramView, "selectPathList");
      paramView = ((List)paramView).iterator();
      int i = 0;
      int j;
      if (paramView.hasNext()) {
        if (((GalleryItem.MediaItem)paramView.next()).BVl == FinderMediaCropUI.b(this.Asj))
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
      paramView = this.Asj.eaz();
      p.j(paramView, "previewRecyclerView");
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
        paramView = (GalleryItem.MediaItem)paramView.auB(i);
        localObject1 = (CharSequence)paramView.BVj;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label820;
        }
        i = 1;
        if (i != 0) {
          paramView.BVj = paramView.AAz;
        }
        p.j(paramView, "item");
        if (paramView.getType() != 2) {
          break label826;
        }
        this.Asj.Asc = true;
        localObject1 = this.Asj.eax();
        Log.i("WxMediaCropLayout", "onUIRelease");
        if (((WxMediaCropLayout)localObject1).rhH != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).rhH;
          if (localObject2 != null) {
            ((CommonVideoView)localObject2).onUIDestroy();
          }
          ((WxMediaCropLayout)localObject1).rhH = null;
        }
        if (((WxMediaCropLayout)localObject1).AQa != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).AQa;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject2).release();
          }
          ((WxMediaCropLayout)localObject1).AQa = null;
        }
        localObject3 = this.Asj.eax().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).kXj;
        f1 = ((WxMediaCropLayout.b)localObject3).viewRect.height() * 1.0F / ((WxMediaCropLayout.b)localObject3).viewRect.width() * ((WxMediaCropLayout.b)localObject3).kXj.width();
        i = ((WxMediaCropLayout.b)localObject3).kXj.left;
        j = (int)(((WxMediaCropLayout.b)localObject3).kXj.centerY() - f1 / 2.0F);
        int k = ((WxMediaCropLayout.b)localObject3).kXj.right;
        f2 = ((WxMediaCropLayout.b)localObject3).kXj.centerY();
        localObject4 = new Rect(i, j, k, (int)(f1 / 2.0F + f2));
        localObject2 = this.Asj.eax();
        p.j(localObject2, "cropLayout");
        i = ((WxMediaCropLayout)localObject2).getHeight() / 2 - ((WxMediaCropLayout.b)localObject3).BZw.centerY();
        ((Rect)localObject4).top += i;
        ((Rect)localObject4).bottom += i;
        f1 = ((WxMediaCropLayout.b)localObject3).vcr.width() * 1.0F / ((WxMediaCropLayout.b)localObject3).kXj.width();
        localObject2 = new Matrix();
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).vcr.left - ((Rect)localObject4).left, ((WxMediaCropLayout.b)localObject3).vcr.top - ((Rect)localObject4).top);
        f1 = ((WxMediaCropLayout.b)localObject3).vcr.centerX();
        f2 = ((WxMediaCropLayout.b)localObject3).kXj.centerX();
        float f3 = ((WxMediaCropLayout.b)localObject3).vcr.centerY();
        float f4 = ((WxMediaCropLayout.b)localObject3).kXj.centerY();
        float f5 = i;
        localObject3 = ar.au((Context)this.Asj.getContext());
        localObject4 = aj.AGc;
        localObject4 = this.Asj.getBaseContext();
        p.j(localObject4, "baseContext");
        aj.g((Context)localObject4, ((Point)localObject3).x, ((Point)localObject3).y);
        new Point(((Point)localObject3).x, ((Point)localObject3).y);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject3 = this.Asj.getContext();
        p.j(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.BVj;
        p.j(localObject4, "item.mRawEditPath");
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
        localObject3 = this.Asj.eax().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).kXj;
        localObject2 = new Matrix();
        localObject4 = new float[9];
        ((WxMediaCropLayout.b)localObject3).aHZ.getValues((float[])localObject4);
        f1 = localObject4[0];
        f2 = localObject4[3];
        double d1 = f1 * f1;
        double d2 = f2;
        f1 = (float)Math.sqrt(f2 * d2 + d1);
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).vcr.left, ((WxMediaCropLayout.b)localObject3).vcr.top);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject3 = this.Asj.getContext();
        p.j(localObject3, "context");
        localObject3 = (Activity)localObject3;
        localObject4 = paramView.BVj;
        p.j(localObject4, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, (String)localObject4, paramView.getType(), (Matrix)localObject2, (Rect)localObject1);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$4", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class o
    extends RecyclerView.h
  {
    private final float offset;
    
    o()
    {
      AppMethodBeat.i(167365);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(b.d.Edge_2A);
      AppMethodBeat.o(167365);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(268371);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramView = paramRecyclerView.aQ(paramView);
      p.j(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.md();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.Asj.eaw().size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(268371);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$5", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
  public static final class p
    implements a.a<GalleryItem.MediaItem>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269811);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = this.Asj;
      localObject1 = this.Asj.eaD();
      p.j(localObject1, "switchVLogCheckbox");
      FinderMediaCropUI.a(paramView, ((CheckBox)localObject1).isChecked());
      if (FinderMediaCropUI.h(this.Asj))
      {
        this.Asx.setItems((List)this.Asj.eaw());
        localObject1 = this.Asj;
        paramView = this.Asj.eaz().cJ(0);
        if (paramView == null) {
          break label173;
        }
      }
      label173:
      for (paramView = paramView.amk;; paramView = null)
      {
        if (paramView == null) {
          p.iCn();
        }
        p.j(paramView, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        Object localObject2 = this.Asj.eaw().get(0);
        p.j(localObject2, "selectPathList[0]");
        ((FinderMediaCropUI)localObject1).a(0, paramView, (GalleryItem.MediaItem)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(269811);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(291920);
      this.Asx.setItems(this.Asj.eaw().subList(0, 1));
      FinderMediaCropUI.a(this.Asj).put(0L, new FinderMediaCropUI.d());
      FinderMediaCropUI localFinderMediaCropUI = this.Asj;
      Object localObject = this.Asj.eaz().cJ(0);
      if (localObject != null) {}
      for (localObject = ((RecyclerView.v)localObject).amk;; localObject = null)
      {
        if (localObject == null) {
          p.iCn();
        }
        p.j(localObject, "previewRecyclerView.find…utPosition(0)?.itemView!!");
        GalleryItem.MediaItem localMediaItem = this.Asj.ArS;
        if (localMediaItem == null) {
          p.iCn();
        }
        localFinderMediaCropUI.a(0, (View)localObject, localMediaItem);
        AppMethodBeat.o(291920);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    s(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167369);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      Object localObject = this.Asj.getContext();
      p.j(localObject, "context");
      localLayoutParams.topMargin = ((int)((AppCompatActivity)localObject).getResources().getDimension(b.d.Edge_A) + ax.F(this.Asj.getBaseContext(), (int)this.Asj.getResources().getDimension(b.d.Edge_6A)));
      localObject = this.Asj.eay();
      p.j(localObject, "actionBarLayout");
      ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      this.Asj.eay().requestLayout();
      AppMethodBeat.o(167369);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167370);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.bottomMargin = ay.aB(this.Asj.getBaseContext());
      localLayoutParams.gravity = 80;
      View localView = this.Asj.eaA();
      p.j(localView, "footer");
      localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(167370);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167371);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Asj.setResult(0);
      this.Asj.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167371);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167372);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderMediaCropUI.c(this.Asj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167372);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "isSuccessfully", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.m<List<? extends MediaSelectedData>, Boolean, x>
  {
    x(FinderMediaCropUI paramFinderMediaCropUI, List paramList)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onGenerateMedia$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$$special$$inlined$apply$lambda$1"})
  static final class y
    extends q
    implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.gallery.picker.b.b.f, x>
  {
    y(GalleryItem.MediaItem paramMediaItem, int paramInt, FinderMediaCropUI paramFinderMediaCropUI, ArrayList paramArrayList, aa.f paramf, kotlin.g.a.m paramm, aa.d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI
 * JD-Core Version:    0.7.0.1
 */