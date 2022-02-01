package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import com.tencent.mm.plugin.finder.publish.l.a;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.d;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.publish.l.j;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.gallery.b.h;
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
import com.tencent.mm.ui.base.a.a.a;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.bg;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.j;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "actionBarLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActionBarLayout", "()Landroid/view/View;", "actionBarLayout$delegate", "Lkotlin/Lazy;", "calculateCallback", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "getCalculateCallback", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "editBtn", "getEditBtn", "editBtn$delegate", "footer", "getFooter", "footer$delegate", "hasDestroyVideoView", "", "getHasDestroyVideoView", "()Z", "setHasDestroyVideoView", "(Z)V", "isFromAppBrand", "isFromAppBrand$delegate", "isPreviewTvChange", "isSwitchNormalMode", "mediaExtraMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "value", "", "previewId", "setPreviewId", "(J)V", "previewNumTv", "Landroid/widget/TextView;", "getPreviewNumTv", "()Landroid/widget/TextView;", "previewNumTv$delegate", "previewRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getPreviewRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "previewRecyclerView$delegate", "processDialogRunnable", "Ljava/lang/Runnable;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSelectPathList", "()Ljava/util/ArrayList;", "selectPathList$delegate", "switchVLogCheckbox", "Landroid/widget/CheckBox;", "getSwitchVLogCheckbox", "()Landroid/widget/CheckBox;", "switchVLogCheckbox$delegate", "switchVLogLayout", "getSwitchVLogLayout", "switchVLogLayout$delegate", "tipDialog", "Landroid/app/Dialog;", "vLogCropRect", "Landroid/graphics/Rect;", "vlogVideoPath", "getVlogVideoPath", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setVlogVideoPath", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "canEnableMultiImage", "checkCropInfo", "", "type", "", "path", "", "matrix", "Landroid/graphics/Matrix;", "cropRect", "contentRect", "viewRect", "position", "initCropRect", "checkIsAllImage", "defaultPreview", "getDefaultVideoVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getForceOrientation", "getLayoutId", "getMenuText", "initView", "isInVLogMode", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onGenerateMedia", "selectedMedias", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "isSuccessfully", "onPause", "onPreviewItem", "view", "item", "onResume", "reloadVLogFake", "setWindowStyle", "showProcessDialog", "delay", "updateOptionMenu", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "MediaExtra", "PreviewItemView", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMediaCropUI
  extends MMFinderUI
{
  public static final FinderMediaCropUI.a FRr;
  private final Runnable FQo;
  private final j FRA;
  private final j FRB;
  private final j FRC;
  final j FRD;
  private boolean FRE;
  private final WxMediaCropLayout.c FRF;
  private long FRG;
  private boolean FRH;
  private boolean FRI;
  private com.tencent.mm.plugin.gallery.picker.b.b FRJ;
  private final LongSparseArray<FinderMediaCropUI.d> FRs;
  private final j FRt;
  GalleryItem.MediaItem FRu;
  private final j FRv;
  private final j FRw;
  private final j FRx;
  private final j FRy;
  private final j FRz;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167382);
    FRr = new FinderMediaCropUI.a((byte)0);
    AppMethodBeat.o(167382);
  }
  
  public FinderMediaCropUI()
  {
    AppMethodBeat.i(167398);
    this.FRs = new LongSparseArray();
    this.FRt = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.FRv = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.FRw = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.FRx = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.FRy = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.FRz = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.FRA = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.FRB = kotlin.k.cm((kotlin.g.a.a)new s(this));
    this.FRC = kotlin.k.cm((kotlin.g.a.a)new r(this));
    this.FRD = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.FRF = ((WxMediaCropLayout.c)new f(this));
    this.FQo = new FinderMediaCropUI..ExternalSyntheticLambda9(this);
    AppMethodBeat.o(167398);
  }
  
  private static final void a(b paramb, FinderMediaCropUI paramFinderMediaCropUI)
  {
    AppMethodBeat.i(346887);
    s.u(paramb, "$adapter");
    s.u(paramFinderMediaCropUI, "this$0");
    paramb.setItems(paramFinderMediaCropUI.fbm().subList(0, 1));
    paramFinderMediaCropUI.FRs.put(0L, new FinderMediaCropUI.d());
    paramb = paramFinderMediaCropUI.fbp().w(0, false);
    if (paramb == null) {}
    for (paramb = null;; paramb = paramb.caK)
    {
      s.checkNotNull(paramb);
      s.s(paramb, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      GalleryItem.MediaItem localMediaItem = paramFinderMediaCropUI.FRu;
      s.checkNotNull(localMediaItem);
      paramFinderMediaCropUI.a(0, paramb, localMediaItem);
      AppMethodBeat.o(346887);
      return;
    }
  }
  
  private static final void a(FinderMediaCropUI paramFinderMediaCropUI)
  {
    AppMethodBeat.i(346804);
    s.u(paramFinderMediaCropUI, "this$0");
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = ((int)paramFinderMediaCropUI.getContext().getResources().getDimension(l.c.Edge_A) + bf.I(paramFinderMediaCropUI.getBaseContext(), (int)paramFinderMediaCropUI.getResources().getDimension(l.c.Edge_6A)));
    paramFinderMediaCropUI.fbo().setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    paramFinderMediaCropUI.fbo().requestLayout();
    AppMethodBeat.o(346804);
  }
  
  private static final void a(FinderMediaCropUI paramFinderMediaCropUI, int paramInt)
  {
    AppMethodBeat.i(346892);
    s.u(paramFinderMediaCropUI, "this$0");
    paramFinderMediaCropUI = paramFinderMediaCropUI.fbp().fU(paramInt);
    if (paramFinderMediaCropUI != null) {
      paramFinderMediaCropUI.caK.callOnClick();
    }
    AppMethodBeat.o(346892);
  }
  
  private static final void a(FinderMediaCropUI paramFinderMediaCropUI, View paramView)
  {
    AppMethodBeat.i(346821);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderMediaCropUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMediaCropUI, "this$0");
    paramFinderMediaCropUI.setResult(0);
    paramFinderMediaCropUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346821);
  }
  
  private static final void a(FinderMediaCropUI paramFinderMediaCropUI, b paramb, View paramView)
  {
    AppMethodBeat.i(346882);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderMediaCropUI);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMediaCropUI, "this$0");
    s.u(paramb, "$adapter");
    paramFinderMediaCropUI.FRH = paramFinderMediaCropUI.fbt().isChecked();
    if (paramFinderMediaCropUI.FRH)
    {
      paramb.setItems((List)paramFinderMediaCropUI.fbm());
      paramb = paramFinderMediaCropUI.fbp().fT(0);
      if (paramb != null) {
        break label186;
      }
    }
    label186:
    for (paramb = null;; paramb = paramb.caK)
    {
      s.checkNotNull(paramb);
      s.s(paramb, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      paramView = paramFinderMediaCropUI.fbm().get(0);
      s.s(paramView, "selectPathList[0]");
      paramFinderMediaCropUI.a(0, paramb, (GalleryItem.MediaItem)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346882);
      return;
    }
  }
  
  private final void a(List<? extends GalleryItem.MediaItem> paramList, final kotlin.g.a.m<? super List<? extends MediaSelectedData>, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(167396);
    MMHandlerThread.postToMainThreadDelayed(this.FQo, 300L);
    final ah.d locald = new ah.d();
    locald.aixb = ((Collection)paramList).size();
    final ArrayList localArrayList = new ArrayList(9);
    Rect localRect1 = new Rect();
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramList;
      localArrayList.add(new MediaSelectedData(-1));
      paramList = (FinderMediaCropUI.d)this.FRs.get(localMediaItem.HHJ);
      String str = localMediaItem.Gcc;
      Matrix localMatrix = new Matrix(paramList.FRT.fBj());
      Rect localRect2 = new Rect(paramList.FRT.Gl);
      Rect localRect3 = new Rect(paramList.FRT.yok);
      Rect localRect4 = new Rect(paramList.FRT.viewRect);
      if (i == 0) {
        localRect1.set(localRect2);
      }
      int j = localMediaItem.getType();
      s.s(str, "path");
      View localView;
      Object localObject;
      if ((localRect2.isEmpty()) || (localRect3.isEmpty()))
      {
        paramList = getContext();
        s.s(paramList, "context");
        paramList = new CropLayout((Context)paramList);
        localView = new View((Context)getContext());
        if (j == 2)
        {
          localObject = g.HRf;
          localObject = g.aBH(str);
          CropLayout.a(paramList, localView, ((com.tencent.mm.plugin.sight.base.b)localObject).width, ((com.tencent.mm.plugin.sight.base.b)localObject).height, null, null, null, 56);
          localRect4.set(0, 0, ((com.tencent.mm.plugin.sight.base.b)localObject).width, ((com.tencent.mm.plugin.sight.base.b)localObject).height);
          localView.setRight(((com.tencent.mm.plugin.sight.base.b)localObject).width);
          localView.setBottom(((com.tencent.mm.plugin.sight.base.b)localObject).height);
          label362:
          Log.i("Finder.MediaCropUI", "[checkCropInfo] need to set default CropInfo. type=" + j + " position=" + i + " viewRect=" + localRect4 + " contentRect=" + localRect3 + " cropRect=" + localRect2);
          paramList.getVisibilityRect().set(localRect1);
          paramList.e(true, fbn().getLeft(), fbn().getTop(), fbn().getRight(), fbn().getBottom());
          localMatrix.set(paramList.getMainMatrix());
          if (!localRect1.isEmpty()) {
            break label686;
          }
          fba().round(localRect2);
          label497:
          localRect3.set(paramList.getContentRect());
        }
      }
      else
      {
        Log.i("Finder.MediaCropUI", "onGenerateMedia, cropRect:" + localRect2 + ", contentRect:" + localRect2 + ", viewRect:" + localRect4);
        j = localMediaItem.getType();
        paramList = this.FRJ;
        if (paramList != null) {
          break label696;
        }
        s.bIx("mediaTailor");
        paramList = null;
      }
      label686:
      label696:
      for (;;)
      {
        com.tencent.mm.plugin.gallery.picker.b.b.a(paramList, str, j, localMatrix, localRect2, localRect3, localRect4, i, (kotlin.g.a.m)new n(localMediaItem, this, localArrayList, locald, paramm));
        i += 1;
        break;
        localObject = BitmapUtil.getImageOptions(str);
        CropLayout.a(paramList, localView, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, null, null, null, 56);
        localRect4.set(0, 0, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
        localView.setRight(((BitmapFactory.Options)localObject).outWidth);
        localView.setBottom(((BitmapFactory.Options)localObject).outHeight);
        break label362;
        localRect2.set(localRect1);
        break label497;
      }
    }
    AppMethodBeat.o(167396);
  }
  
  private static final void b(FinderMediaCropUI paramFinderMediaCropUI)
  {
    AppMethodBeat.i(346814);
    s.u(paramFinderMediaCropUI, "this$0");
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.bottomMargin = bg.bk(paramFinderMediaCropUI.getBaseContext());
    localLayoutParams.gravity = 80;
    paramFinderMediaCropUI.fbq().setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(346814);
  }
  
  private static final void b(FinderMediaCropUI paramFinderMediaCropUI, int paramInt)
  {
    AppMethodBeat.i(346898);
    s.u(paramFinderMediaCropUI, "this$0");
    paramFinderMediaCropUI = paramFinderMediaCropUI.fbp().fU(paramInt);
    if (paramFinderMediaCropUI != null) {
      paramFinderMediaCropUI.caK.callOnClick();
    }
    AppMethodBeat.o(346898);
  }
  
  private static final void b(FinderMediaCropUI paramFinderMediaCropUI, View paramView)
  {
    AppMethodBeat.i(346829);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderMediaCropUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMediaCropUI, "this$0");
    paramFinderMediaCropUI.onFinish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346829);
  }
  
  private static final void c(FinderMediaCropUI paramFinderMediaCropUI)
  {
    AppMethodBeat.i(346838);
    s.u(paramFinderMediaCropUI, "this$0");
    RectF localRectF = paramFinderMediaCropUI.fba();
    paramFinderMediaCropUI = paramFinderMediaCropUI.fbn();
    s.s(paramFinderMediaCropUI, "cropLayout");
    WxMediaCropLayout.a(paramFinderMediaCropUI, localRectF.width() * 0.5625F, localRectF.height(), localRectF);
    AppMethodBeat.o(346838);
  }
  
  private static final void c(FinderMediaCropUI paramFinderMediaCropUI, View paramView)
  {
    AppMethodBeat.i(346857);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderMediaCropUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderMediaCropUI, "this$0");
    paramView = ((List)paramFinderMediaCropUI.fbm()).iterator();
    int i = 0;
    if (paramView.hasNext()) {
      if (((GalleryItem.MediaItem)paramView.next()).HHJ == paramFinderMediaCropUI.FRG)
      {
        j = 1;
        label111:
        if (j == 0) {
          break label153;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label165;
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346857);
      return;
      j = 0;
      break label111;
      label153:
      i += 1;
      break;
      i = -1;
    }
    label165:
    int j = paramFinderMediaCropUI.fbm().size();
    localObject = (GalleryItem.MediaItem)paramFinderMediaCropUI.fbm().get(i);
    paramFinderMediaCropUI.FRI = true;
    if (j <= 1)
    {
      paramView = new Intent();
      paramView.putExtra("clear_list", true);
      paramFinderMediaCropUI.setResult(-1, paramView);
      paramFinderMediaCropUI.finish();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346857);
      return;
    }
    if (i == 0) {}
    for (j = 1;; j = i - 1)
    {
      paramView = paramFinderMediaCropUI.fbp().fT(j);
      paramFinderMediaCropUI.fbm().remove(localObject);
      localObject = paramFinderMediaCropUI.fbp().getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).fX(i);
      }
      if (paramView != null)
      {
        paramView = paramView.caK;
        if (paramView != null) {
          paramView.callOnClick();
        }
      }
      paramFinderMediaCropUI.fbu();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346857);
      return;
    }
  }
  
  private static final void d(FinderMediaCropUI paramFinderMediaCropUI)
  {
    AppMethodBeat.i(346908);
    s.u(paramFinderMediaCropUI, "this$0");
    Object localObject = paramFinderMediaCropUI.tipDialog;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = (Context)paramFinderMediaCropUI;
        paramFinderMediaCropUI.getString(l.i.app_tip);
        paramFinderMediaCropUI.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a((Context)localObject, paramFinderMediaCropUI.getString(l.i.app_waiting), false, FinderMediaCropUI..ExternalSyntheticLambda0.INSTANCE));
      }
      Log.d("Finder.MediaCropUI", "tipDialog is show!");
      AppMethodBeat.o(346908);
      return;
      ((Dialog)localObject).show();
    }
  }
  
  private static final void d(FinderMediaCropUI paramFinderMediaCropUI, View paramView)
  {
    AppMethodBeat.i(346874);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderMediaCropUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderMediaCropUI, "this$0");
    paramView = ((List)paramFinderMediaCropUI.fbm()).iterator();
    int i = 0;
    int j;
    if (paramView.hasNext()) {
      if (((GalleryItem.MediaItem)paramView.next()).HHJ == paramFinderMediaCropUI.FRG)
      {
        j = 1;
        label113:
        if (j == 0) {
          break label158;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label173;
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346874);
      return;
      j = 0;
      break label113;
      label158:
      i += 1;
      break;
      i = -1;
    }
    label173:
    paramView = paramFinderMediaCropUI.fbp().getAdapter();
    label234:
    Object localObject3;
    float f1;
    float f2;
    Object localObject4;
    if ((paramView instanceof b))
    {
      paramView = (b)paramView;
      if (paramView != null)
      {
        paramView = (GalleryItem.MediaItem)paramView.aBc(i);
        localObject1 = (CharSequence)paramView.HHH;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label802;
        }
        i = 1;
        if (i != 0) {
          paramView.HHH = paramView.Gcc;
        }
        if (paramView.getType() != 2) {
          break label808;
        }
        paramFinderMediaCropUI.FRE = true;
        localObject1 = paramFinderMediaCropUI.fbn();
        Log.i("WxMediaCropLayout", "onUIRelease");
        if (((WxMediaCropLayout)localObject1).upC != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).upC;
          if (localObject2 != null) {
            ((CommonVideoView)localObject2).onUIDestroy();
          }
          ((WxMediaCropLayout)localObject1).upC = null;
        }
        if (((WxMediaCropLayout)localObject1).Gsn != null)
        {
          localObject2 = ((WxMediaCropLayout)localObject1).Gsn;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject2).release();
          }
          ((WxMediaCropLayout)localObject1).Gsn = null;
        }
        localObject3 = paramFinderMediaCropUI.fbn().getCurrentCropInfo();
        localObject1 = ((WxMediaCropLayout.b)localObject3).Gl;
        f1 = ((WxMediaCropLayout.b)localObject3).viewRect.height() * 1.0F / ((WxMediaCropLayout.b)localObject3).viewRect.width() * ((WxMediaCropLayout.b)localObject3).Gl.width();
        i = ((WxMediaCropLayout.b)localObject3).Gl.left;
        j = (int)(((WxMediaCropLayout.b)localObject3).Gl.centerY() - f1 / 2.0F);
        int k = ((WxMediaCropLayout.b)localObject3).Gl.right;
        f2 = ((WxMediaCropLayout.b)localObject3).Gl.centerY();
        localObject4 = new Rect(i, j, k, (int)(f1 / 2.0F + f2));
        i = paramFinderMediaCropUI.fbn().getHeight() / 2 - ((WxMediaCropLayout.b)localObject3).HLr.centerY();
        ((Rect)localObject4).top += i;
        ((Rect)localObject4).bottom += i;
        f1 = ((WxMediaCropLayout.b)localObject3).yok.width() * 1.0F / ((WxMediaCropLayout.b)localObject3).Gl.width();
        localObject2 = new Matrix();
        ((Matrix)localObject2).setScale(f1, f1);
        ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).yok.left - ((Rect)localObject4).left, ((WxMediaCropLayout.b)localObject3).yok.top - ((Rect)localObject4).top);
        f1 = ((WxMediaCropLayout.b)localObject3).yok.centerX();
        f2 = ((WxMediaCropLayout.b)localObject3).Gl.centerX();
        float f3 = ((WxMediaCropLayout.b)localObject3).yok.centerY();
        float f4 = ((WxMediaCropLayout.b)localObject3).Gl.centerY();
        float f5 = i;
        localObject3 = com.tencent.mm.ui.aw.bf((Context)paramFinderMediaCropUI.getContext());
        localObject4 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        localObject4 = paramFinderMediaCropUI.getBaseContext();
        s.s(localObject4, "baseContext");
        com.tencent.mm.plugin.finder.utils.aw.i((Context)localObject4, ((Point)localObject3).x, ((Point)localObject3).y);
        new Point(((Point)localObject3).x, ((Point)localObject3).y);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramFinderMediaCropUI = paramFinderMediaCropUI.getContext();
        s.s(paramFinderMediaCropUI, "context");
        paramFinderMediaCropUI = (Activity)paramFinderMediaCropUI;
        localObject3 = paramView.HHH;
        s.s(localObject3, "item.mRawEditPath");
        com.tencent.mm.plugin.finder.utils.a.a(paramFinderMediaCropUI, (String)localObject3, paramView.getType(), (Matrix)localObject2, (Rect)localObject1, new float[] { f1 - f2, f3 - f4 - f5 });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346874);
      return;
      paramView = null;
      break;
      label802:
      i = 0;
      break label234;
      label808:
      localObject3 = paramFinderMediaCropUI.fbn().getCurrentCropInfo();
      localObject1 = ((WxMediaCropLayout.b)localObject3).Gl;
      localObject2 = new Matrix();
      localObject4 = new float[9];
      ((WxMediaCropLayout.b)localObject3).matrix.getValues((float[])localObject4);
      f1 = localObject4[0];
      f2 = localObject4[3];
      double d1 = f1 * f1;
      double d2 = f2;
      f1 = (float)Math.sqrt(f2 * d2 + d1);
      ((Matrix)localObject2).setScale(f1, f1);
      ((Matrix)localObject2).postTranslate(((WxMediaCropLayout.b)localObject3).yok.left, ((WxMediaCropLayout.b)localObject3).yok.top);
      localObject3 = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderMediaCropUI = paramFinderMediaCropUI.getContext();
      s.s(paramFinderMediaCropUI, "context");
      paramFinderMediaCropUI = (Activity)paramFinderMediaCropUI;
      localObject3 = paramView.HHH;
      s.s(localObject3, "item.mRawEditPath");
      com.tencent.mm.plugin.finder.utils.a.a(paramFinderMediaCropUI, (String)localObject3, paramView.getType(), (Matrix)localObject2, (Rect)localObject1);
    }
  }
  
  private final RectF fba()
  {
    AppMethodBeat.i(167392);
    float f2 = getContext().getResources().getDimension(l.c.DefaultActionbarHeight);
    float f3 = getContext().getResources().getDimension(l.c.Edge_6A);
    float f1 = fbn().getWidth() * 3.5F / 3.0F;
    f2 = f2 + f3 + (fbn().getHeight() - fbq().getHeight() - f2 - f3 - bg.bk(getBaseContext()) - f1) / 2.0F;
    RectF localRectF = new RectF(fbn().getLeft(), f2, fbn().getRight(), f1 + f2);
    AppMethodBeat.o(167392);
    return localRectF;
  }
  
  private WxMediaCropLayout fbn()
  {
    AppMethodBeat.i(167384);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.FRv.getValue();
    AppMethodBeat.o(167384);
    return localWxMediaCropLayout;
  }
  
  private View fbo()
  {
    AppMethodBeat.i(167385);
    View localView = (View)this.FRw.getValue();
    AppMethodBeat.o(167385);
    return localView;
  }
  
  private RecyclerView fbp()
  {
    AppMethodBeat.i(346737);
    RecyclerView localRecyclerView = (RecyclerView)this.FRx.getValue();
    AppMethodBeat.o(346737);
    return localRecyclerView;
  }
  
  private View fbq()
  {
    AppMethodBeat.i(167387);
    View localView = (View)this.FRy.getValue();
    AppMethodBeat.o(167387);
    return localView;
  }
  
  private TextView fbr()
  {
    AppMethodBeat.i(167388);
    TextView localTextView = (TextView)this.FRz.getValue();
    AppMethodBeat.o(167388);
    return localTextView;
  }
  
  private View fbs()
  {
    AppMethodBeat.i(346751);
    View localView = (View)this.FRB.getValue();
    AppMethodBeat.o(346751);
    return localView;
  }
  
  private CheckBox fbt()
  {
    AppMethodBeat.i(346755);
    CheckBox localCheckBox = (CheckBox)this.FRC.getValue();
    AppMethodBeat.o(346755);
    return localCheckBox;
  }
  
  private final void fbu()
  {
    AppMethodBeat.i(167390);
    TextView localTextView = (TextView)findViewById(l.e.action_option_icon);
    Object localObject2 = (Iterable)fbm();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label116:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localObject3;
      if (((FinderMediaCropUI.d)this.FRs.get(localMediaItem.HHJ)).FRU != -1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label116;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    int i = ((List)localObject1).size();
    if (i > 0)
    {
      localObject1 = getContext().getResources().getString(l.i.app_finish) + '(' + i + ')';
      localTextView.setText((CharSequence)localObject1);
      localObject2 = ((Iterable)fbm()).iterator();
      label196:
      if (!((Iterator)localObject2).hasNext()) {
        break label296;
      }
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (GalleryItem.MediaItem)localObject1;
      if (((FinderMediaCropUI.d)this.FRs.get(((GalleryItem.MediaItem)localObject3).HHJ)).FRU == -1) {
        break label291;
      }
      i = 1;
      label244:
      if (i == 0) {
        break label294;
      }
      label248:
      if (localObject1 == null) {
        break label301;
      }
    }
    label291:
    label294:
    label296:
    label301:
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      AppMethodBeat.o(167390);
      return;
      localObject1 = getContext().getResources().getString(l.i.app_finish);
      s.s(localObject1, "context.resources.getString(R.string.app_finish)");
      break;
      i = 0;
      break label244;
      break label196;
      localObject1 = null;
      break label248;
    }
  }
  
  private final boolean fbv()
  {
    AppMethodBeat.i(346771);
    Object localObject = fbm();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((ArrayList)localObject).size()))
    {
      s.checkNotNull(localObject);
      if (((Integer)localObject).intValue() > 1) {
        break;
      }
      AppMethodBeat.o(346771);
      return false;
    }
    localObject = ((Iterable)fbm()).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((GalleryItem.MediaItem)((Iterator)localObject).next()).getType() == 2)
      {
        AppMethodBeat.o(346771);
        return false;
      }
    }
    AppMethodBeat.o(346771);
    return true;
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(346760);
    Object localObject2 = (Iterable)fbm();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label99:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localObject3;
      if (((FinderMediaCropUI.d)this.FRs.get(localMediaItem.HHJ)).FRU != -1) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label99;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (List)localObject1;
    a((List)localObject1, (kotlin.g.a.m)new m(this, (List)localObject1));
    AppMethodBeat.o(346760);
  }
  
  private static final void p(DialogInterface paramDialogInterface) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(int paramInt, View paramView, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(347048);
    s.u(paramView, "view");
    s.u(paramMediaItem, "item");
    if (paramView.getTag() != null)
    {
      Log.w("Finder.MediaCropUI", "this view is Animating");
      AppMethodBeat.o(347048);
      return;
    }
    Object localObject = fbp().bz(this.FRG);
    if (localObject != null) {
      ((RecyclerView.v)localObject).caK.setFocusable(false);
    }
    this.FRG = paramMediaItem.HHJ;
    localObject = (List)fbm();
    int i = 0;
    localObject = ((List)localObject).iterator();
    int j;
    label133:
    label138:
    label207:
    long l;
    label267:
    WxMediaCropLayout.c localc;
    boolean bool;
    if (((Iterator)localObject).hasNext()) {
      if (((GalleryItem.MediaItem)((Iterator)localObject).next()).HHJ == this.FRG)
      {
        j = 1;
        if (j == 0) {
          break label403;
        }
        if (i >= 0)
        {
          fbm().get(i);
          if (((FinderMediaCropUI.d)this.FRs.get(this.FRG)).FRU != -1) {
            break label418;
          }
          fbr().setText((CharSequence)"");
          fbr().setBackground(getContext().getResources().getDrawable(l.d.num_checkbox_unselected));
        }
        paramView.setFocusable(true);
        paramView = fbp().getAdapter();
        if (paramView != null) {
          paramView.t(paramInt, new Object());
        }
        if (paramInt == 0) {
          fbn().setLockCropMediaId(paramMediaItem.HHJ);
        }
        l = paramMediaItem.HHJ;
        if (paramMediaItem.getType() != 2) {
          break label458;
        }
        paramInt = 1;
        localObject = (FinderMediaCropUI.d)this.FRs.get(this.FRG);
        paramView = fbn();
        paramMediaItem = paramMediaItem.Gcc;
        s.s(paramMediaItem, "item.originalPath");
        localc = this.FRF;
        s.u(paramMediaItem, "mediaPath");
        Log.i("WxMediaCropLayout", s.X("onPreview type: ", Integer.valueOf(paramInt)));
        bool = false;
        if (paramView.wyh != paramInt) {
          bool = true;
        }
        paramView.wyh = paramInt;
        switch (paramInt)
        {
        default: 
          paramView = new WxMediaCropLayout.b(0L, "");
        }
      }
    }
    for (;;)
    {
      ((FinderMediaCropUI.d)localObject).a(paramView);
      AppMethodBeat.o(347048);
      return;
      j = 0;
      break label133;
      label403:
      i += 1;
      break;
      i = -1;
      break label138;
      label418:
      fbr().setText((CharSequence)String.valueOf(i + 1));
      fbr().setBackground(getContext().getResources().getDrawable(l.d.orange_oval_shape));
      break label207;
      label458:
      paramInt = 2;
      break label267;
      paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, localc, null, 16);
      continue;
      paramView = WxMediaCropLayout.a(paramView, l, paramMediaItem, bool, localc);
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> fbm()
  {
    AppMethodBeat.i(167383);
    ArrayList localArrayList = (ArrayList)this.FRt.getValue();
    AppMethodBeat.o(167383);
    return localArrayList;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return l.f.finder_media_edit_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167391);
    super.initView();
    fbn().setShowBorder(true);
    fbn().post(new FinderMediaCropUI..ExternalSyntheticLambda10(this));
    fbr().setOnClickListener(new FinderMediaCropUI..ExternalSyntheticLambda2(this));
    ((View)this.FRA.getValue()).setOnClickListener(new FinderMediaCropUI..ExternalSyntheticLambda4(this));
    fbp().setHasFixedSize(true);
    getContext();
    Object localObject1 = new LinearLayoutManager();
    ((LinearLayoutManager)localObject1).setOrientation(0);
    fbp().setLayoutManager((RecyclerView.LayoutManager)localObject1);
    ((LinearLayoutManager)localObject1).setItemPrefetchEnabled(true);
    fbp().setItemAnimator((RecyclerView.f)new androidx.recyclerview.widget.f());
    fbp().a((RecyclerView.h)new j(this));
    localObject1 = new b();
    new androidx.recyclerview.widget.k((k.a)new c((com.tencent.mm.ui.base.a.a)localObject1)).a(fbp());
    fbp().setAdapter((RecyclerView.a)localObject1);
    ((b)localObject1).adXy = ((a.a)new k(this));
    Object localObject2 = ((Iterable)fbm()).iterator();
    int i;
    while (((Iterator)localObject2).hasNext()) {
      if (((GalleryItem.MediaItem)((Iterator)localObject2).next()).getType() == 2)
      {
        i = 0;
        if (i != 0) {
          this.FRH = true;
        }
        fbt().setChecked(this.FRH);
        if (!fbv()) {
          break label383;
        }
        fbs().setVisibility(0);
        fbt().setOnClickListener(new FinderMediaCropUI..ExternalSyntheticLambda5(this, (b)localObject1));
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      Log.i("Finder.MediaCropUI", s.X("isInVLogMode: false, final check, IS_VLOG_BACKGROUND_MUX: ", Boolean.valueOf(com.tencent.mm.plugin.finder.storage.d.eRo())));
      ((b)localObject1).setItems((List)fbm());
      if ((this.FRu == null) || (!fbv())) {
        break label395;
      }
      fbp().postDelayed(new FinderMediaCropUI..ExternalSyntheticLambda6((b)localObject1, this), 500L);
      AppMethodBeat.o(167391);
      return;
      i = 1;
      break;
      label383:
      fbs().setVisibility(8);
    }
    label395:
    fbp().post(new FinderMediaCropUI..ExternalSyntheticLambda11(this, 0));
    fbp().postDelayed(new FinderMediaCropUI..ExternalSyntheticLambda12(this, 0), 500L);
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
    Object localObject1;
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        s.checkNotNull(paramIntent);
        paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        s.checkNotNull(paramIntent);
        s.s(paramIntent, "data!!.getParcelableExtr…geUI.KSEGMENTMEDIAINFO)!!");
        localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
        this.FRE = false;
        paramIntent = (List)fbm();
        paramInt1 = 0;
        paramIntent = paramIntent.iterator();
        if (paramIntent.hasNext()) {
          if (((GalleryItem.MediaItem)paramIntent.next()).HHJ == this.FRG)
          {
            paramInt2 = 1;
            label105:
            if (paramInt2 == 0) {
              break label125;
            }
          }
        }
        for (;;)
        {
          if (paramInt1 >= 0) {
            break label137;
          }
          AppMethodBeat.o(167397);
          return;
          paramInt2 = 0;
          break label105;
          label125:
          paramInt1 += 1;
          break;
          paramInt1 = -1;
        }
        label137:
        paramIntent = fbp().getAdapter();
        if ((paramIntent instanceof b)) {}
        for (paramIntent = (b)paramIntent;; paramIntent = null)
        {
          if (paramIntent == null) {
            break label546;
          }
          Object localObject2 = (GalleryItem.MediaItem)paramIntent.aBc(paramInt1);
          Boolean localBoolean = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).NHK;
          s.s(localBoolean, "model.photo");
          if (!localBoolean.booleanValue()) {
            break;
          }
          ((GalleryItem.MediaItem)localObject2).HHQ = true;
          ((GalleryItem.MediaItem)localObject2).Gcc = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath;
          Log.i("Finder.MediaCropUI", s.X("[onActivityResult] edit photo output=", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath));
          paramIntent = (FinderMediaCropUI.d)this.FRs.get(((GalleryItem.MediaItem)localObject2).HHJ);
          localObject1 = fbn();
          s.s(localObject1, "cropLayout");
          long l = ((GalleryItem.MediaItem)localObject2).HHJ;
          localObject2 = ((GalleryItem.MediaItem)localObject2).Gcc;
          s.s(localObject2, "item.originalPath");
          paramIntent.a(WxMediaCropLayout.a((WxMediaCropLayout)localObject1, l, (String)localObject2, true, this.FRF, null, 16));
          paramIntent = fbp().getAdapter();
          if (paramIntent != null) {
            paramIntent.fV(paramInt1);
          }
          AppMethodBeat.o(167397);
          return;
        }
        Log.i("Finder.MediaCropUI", s.X("[onActivityResult] edit video output=", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath));
        localObject1 = GalleryItem.MediaItem.a(2, 0L, ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath, ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath, "");
        fbm().clear();
        fbm().add(localObject1);
        paramIntent.setItems((List)fbm());
        paramIntent.bZE.notifyChanged();
        paramIntent = new FinderMediaCropUI.d();
        paramIntent.FRU = 1;
        this.FRs.put(0L, paramIntent);
        paramIntent = fbp().w(0, false);
        if (paramIntent == null) {}
        for (paramIntent = null;; paramIntent = paramIntent.caK)
        {
          s.checkNotNull(paramIntent);
          s.s(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
          localObject1 = fbm().get(0);
          s.s(localObject1, "selectPathList[0]");
          a(0, paramIntent, (GalleryItem.MediaItem)localObject1);
          break;
        }
      }
      paramIntent = fbp().w(0, false);
      if (paramIntent != null) {
        break label553;
      }
    }
    label546:
    label553:
    for (paramIntent = null;; paramIntent = paramIntent.caK)
    {
      s.checkNotNull(paramIntent);
      s.s(paramIntent, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      localObject1 = fbm().get(0);
      s.s(localObject1, "selectPathList[0]");
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
    com.tencent.mm.plugin.gallery.picker.b.a locala1 = null;
    AppMethodBeat.i(167389);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    hideTitleView();
    setTheme(l.j.MMTheme_NoTitleTranslucent);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ys(true);
    getWindow().setFormat(-3);
    paramBundle = getIntent().getParcelableArrayListExtra("front_vlog_video");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      this.FRu = ((GalleryItem.MediaItem)paramBundle.get(0));
    }
    fbo().post(new FinderMediaCropUI..ExternalSyntheticLambda7(this));
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    paramBundle.bottomMargin = bg.bk(getBaseContext());
    paramBundle.gravity = 80;
    fbq().setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    fbq().post(new FinderMediaCropUI..ExternalSyntheticLambda8(this));
    setActionbarColor(getResources().getColor(l.b.transparent));
    findViewById(l.e.actionbar_up_indicator_btn).setOnClickListener(new FinderMediaCropUI..ExternalSyntheticLambda1(this));
    findViewById(l.e.action_option_icon).setOnClickListener(new FinderMediaCropUI..ExternalSyntheticLambda3(this));
    fbu();
    b.b localb = new b.b();
    paramBundle = bm.GlZ;
    localb.aES(bm.fit());
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    localb.maxHeight = com.tencent.mm.plugin.finder.storage.d.eQo();
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    localb.maxWidth = com.tencent.mm.plugin.finder.storage.d.eQp();
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    localb.HJF = com.tencent.mm.plugin.finder.storage.d.eQq();
    this.FRJ = new com.tencent.mm.plugin.gallery.picker.b.b(localb);
    paramBundle = this.FRJ;
    if (paramBundle == null)
    {
      s.bIx("mediaTailor");
      paramBundle = null;
      com.tencent.mm.plugin.gallery.picker.b.a locala2 = (com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.m(localb);
      s.u(locala2, "<set-?>");
      paramBundle.HJB = locala2;
      paramBundle = this.FRJ;
      if (paramBundle != null) {
        break label394;
      }
      s.bIx("mediaTailor");
      paramBundle = locala1;
    }
    label394:
    for (;;)
    {
      locala1 = (com.tencent.mm.plugin.gallery.picker.b.a)new com.tencent.mm.plugin.finder.video.k(localb);
      s.u(locala1, "<set-?>");
      paramBundle.HJC = locala1;
      initView();
      AppMethodBeat.o(167389);
      return;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347059);
    super.onDestroy();
    AppMethodBeat.o(347059);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(167394);
    super.onPause();
    if (!this.FRE) {
      fbn().onUIPause();
    }
    AppMethodBeat.o(167394);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167393);
    super.onResume();
    Object localObject2;
    if (this.FRE)
    {
      localObject1 = fbp().getAdapter();
      int i;
      label57:
      int j;
      if ((localObject1 instanceof b))
      {
        localObject1 = (b)localObject1;
        localObject2 = ((List)fbm()).iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label123;
        }
        if (((GalleryItem.MediaItem)((Iterator)localObject2).next()).HHJ != this.FRG) {
          break label111;
        }
        j = 1;
        label90:
        if (j == 0) {
          break label116;
        }
      }
      for (;;)
      {
        if (i >= 0) {
          break label128;
        }
        AppMethodBeat.o(167393);
        return;
        localObject1 = null;
        break;
        label111:
        j = 0;
        break label90;
        label116:
        i += 1;
        break label57;
        label123:
        i = -1;
      }
      label128:
      if (localObject1 != null)
      {
        localObject2 = (GalleryItem.MediaItem)((b)localObject1).aBc(i);
        localObject1 = fbn();
        long l = ((GalleryItem.MediaItem)localObject2).HHJ;
        localObject2 = ((GalleryItem.MediaItem)localObject2).Gcc;
        s.s(localObject2, "item.originalPath");
        ((WxMediaCropLayout)localObject1).a(l, (String)localObject2, true, this.FRF, true);
      }
      this.FRE = false;
      AppMethodBeat.o(167393);
      return;
    }
    Object localObject1 = fbn();
    Log.i("WxMediaCropLayout", "onUIResume");
    if (((WxMediaCropLayout)localObject1).upC != null)
    {
      localObject2 = ((WxMediaCropLayout)localObject1).upC;
      if (localObject2 != null) {
        ((CommonVideoView)localObject2).onUIResume();
      }
    }
    if (((WxMediaCropLayout)localObject1).Gsn != null)
    {
      localObject1 = ((WxMediaCropLayout)localObject1).Gsn;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.recordvideo.plugin.a.b)localObject1).gIX();
      }
    }
    AppMethodBeat.o(167393);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class PreviewItemView
    extends FrameLayout
  {
    private final View FRV;
    private final int Fbw;
    private final ImageView hIz;
    private final View maskView;
    private final int padding;
    private final int size;
    
    public PreviewItemView(Context paramContext)
    {
      super();
      AppMethodBeat.i(167351);
      this.Fbw = MMApplicationContext.getContext().getResources().getColor(l.b.orange_bg_color);
      this.hIz = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.FRV = new View(getContext());
      this.padding = ((int)getContext().getResources().getDimension(l.c.Edge_0_5_A));
      this.size = ((int)getContext().getResources().getDimension(l.c.Edge_7_5_A));
      this.hIz.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(this.size, this.size);
      localLayoutParams1.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams2.gravity = 17;
      this.FRV.setBackgroundColor(this.Fbw);
      addView(this.FRV, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.hIz, (ViewGroup.LayoutParams)localLayoutParams2);
      this.maskView.setBackgroundColor(getContext().getResources().getColor(l.b.white));
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
      this.Fbw = MMApplicationContext.getContext().getResources().getColor(l.b.orange_bg_color);
      this.hIz = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.FRV = new View(getContext());
      this.padding = ((int)getContext().getResources().getDimension(l.c.Edge_0_5_A));
      this.size = ((int)getContext().getResources().getDimension(l.c.Edge_7_5_A));
      this.hIz.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.FRV.setBackgroundColor(this.Fbw);
      addView(this.FRV, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.hIz, (ViewGroup.LayoutParams)localLayoutParams);
      this.maskView.setBackgroundColor(getContext().getResources().getColor(l.b.white));
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
      this.Fbw = MMApplicationContext.getContext().getResources().getColor(l.b.orange_bg_color);
      this.hIz = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.FRV = new View(getContext());
      this.padding = ((int)getContext().getResources().getDimension(l.c.Edge_0_5_A));
      this.size = ((int)getContext().getResources().getDimension(l.c.Edge_7_5_A));
      this.hIz.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      paramAttributeSet.gravity = 17;
      paramContext.gravity = 17;
      localLayoutParams.gravity = 17;
      this.FRV.setBackgroundColor(this.Fbw);
      addView(this.FRV, (ViewGroup.LayoutParams)paramContext);
      addView((View)this.hIz, (ViewGroup.LayoutParams)localLayoutParams);
      this.maskView.setBackgroundColor(getContext().getResources().getColor(l.b.white));
      this.maskView.setAlpha(0.5F);
      paramContext = new FrameLayout.LayoutParams(-2, -1);
      paramContext.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)paramContext);
      AppMethodBeat.o(167353);
    }
    
    public final View getFocusedView()
    {
      return this.FRV;
    }
    
    public final ImageView getImageView()
    {
      return this.hIz;
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
        this.FRV.setVisibility(0);
        AppMethodBeat.o(167349);
        return;
      }
      this.FRV.setVisibility(4);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView>
  {
    public b()
    {
      AppMethodBeat.i(167331);
      bf(true);
      AppMethodBeat.o(167331);
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(167327);
      s.u(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (FinderMediaCropUI.PreviewItemView)paramb.view;
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)aBc(paramInt);
      Object localObject = com.tencent.mm.plugin.gallery.picker.c.f.HJZ;
      localObject = com.tencent.mm.plugin.gallery.picker.c.f.fBb();
      s.s(localMediaItem, "media");
      ((com.tencent.mm.loader.d)localObject).dj(localMediaItem).a(paramb.getImageView(), true);
      if (((FinderMediaCropUI.d)FinderMediaCropUI.f(this.FRK).get(localMediaItem.HHJ)).FRU != -1)
      {
        bool1 = true;
        paramb.setSelected(bool1);
        if (localMediaItem.HHJ != FinderMediaCropUI.g(this.FRK)) {
          break label137;
        }
      }
      label137:
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
      AppMethodBeat.i(346491);
      s.u(paramb, "holder");
      s.u(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(346491);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(167330);
      long l = ((GalleryItem.MediaItem)aBc(paramInt)).HHJ;
      AppMethodBeat.o(167330);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends k.a
  {
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, FinderMediaCropUI.PreviewItemView> FRL;
    private int FRM;
    private int FRN;
    private int FRO;
    int ieV;
    
    public c()
    {
      AppMethodBeat.i(167345);
      this.FRL = localObject;
      this.ieV = -1;
      this.FRM = -1;
      this.FRN = -1;
      AppMethodBeat.o(167345);
    }
    
    public final boolean Ji()
    {
      return true;
    }
    
    public final boolean Jj()
    {
      return false;
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(346544);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      int i = k.a.bk(51, 0);
      AppMethodBeat.o(346544);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(346538);
      s.u(paramCanvas, "c");
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(346538);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(346508);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv1, "viewHolder");
      s.u(paramv2, "target");
      int i = paramv1.KJ();
      int j = paramv2.KJ();
      Log.d("Finder.MediaCropUI", "[onMove] from=" + i + " to=" + j);
      h.m((List)FinderMediaCropUI.this.fbm(), i, j);
      this.FRL.bz(i, j);
      this.FRN = j;
      AppMethodBeat.o(346508);
      return true;
    }
    
    public final void b(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(346516);
      super.b(paramv, paramInt);
      if (paramv != null)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(paramv.caK.getContext(), l.a.move_scale_out);
        localAnimation.setAnimationListener((Animation.AnimationListener)new b(paramv, paramInt, this));
        paramv.caK.startAnimation(localAnimation);
      }
      AppMethodBeat.o(346516);
    }
    
    public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(346521);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), l.a.move_scale_in);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(paramv, this));
      paramv.caK.startAnimation(paramRecyclerView);
      AppMethodBeat.o(346521);
    }
    
    public final float g(RecyclerView.v paramv)
    {
      AppMethodBeat.i(346533);
      s.u(paramv, "viewHolder");
      AppMethodBeat.o(346533);
      return 0.295858F;
    }
    
    public final void h(RecyclerView.v paramv)
    {
      AppMethodBeat.i(346526);
      s.u(paramv, "viewHolder");
      AppMethodBeat.o(346526);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.v paramv, FinderMediaCropUI.c paramc) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(167333);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(null);
        Log.d("Finder.MediaCropUI", "finally change from=" + FinderMediaCropUI.c.a(jdField_this) + " to=" + FinderMediaCropUI.c.b(jdField_this));
        AppMethodBeat.o(167333);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(167334);
        s.u(paramAnimation, "animation");
        AppMethodBeat.o(167334);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(167332);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(new Object());
        AppMethodBeat.o(167332);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Animation.AnimationListener
    {
      b(RecyclerView.v paramv, int paramInt, FinderMediaCropUI.c paramc) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(347859);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(null);
        AppMethodBeat.o(347859);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(347866);
        s.u(paramAnimation, "animation");
        AppMethodBeat.o(347866);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(347853);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(new Object());
        if (paramInt == 2)
        {
          FinderMediaCropUI.c.a(jdField_this, this.FRP.KJ());
          FinderMediaCropUI.c.b(jdField_this, FinderMediaCropUI.c.b(jdField_this));
          jdField_this.ieV = FinderMediaCropUI.c.c(jdField_this);
        }
        AppMethodBeat.o(347853);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    e(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$calculateCallback$1", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements WxMediaCropLayout.c
  {
    f(FinderMediaCropUI paramFinderMediaCropUI) {}
    
    public final void a(int[] paramArrayOfInt, RectF paramRectF)
    {
      AppMethodBeat.i(167355);
      s.u(paramArrayOfInt, "mediaWH");
      s.u(paramRectF, "maxCropRect");
      RectF localRectF = new RectF(paramRectF);
      Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      localObject = this.FRK.getBaseContext();
      s.s(localObject, "baseContext");
      paramArrayOfInt = com.tencent.mm.plugin.finder.utils.aw.i((Context)localObject, paramArrayOfInt[0], paramArrayOfInt[1]);
      ((Number)paramArrayOfInt.bsD).intValue();
      int i = ((Number)paramArrayOfInt.aiuN).intValue();
      float f = (paramRectF.height() - i) / 2.0F;
      paramRectF.top += f;
      paramRectF.bottom -= f;
      Log.i("Finder.MediaCropUI", "[calculate] NEW=" + paramRectF + " OLD=" + localRectF + " isAdaptSrc=true");
      AppMethodBeat.o(167355);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<WxMediaCropLayout>
  {
    g(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    h(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    i(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$4", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends RecyclerView.h
  {
    private final float offset;
    
    j(FinderMediaCropUI paramFinderMediaCropUI)
    {
      AppMethodBeat.i(167365);
      this.offset = MMApplicationContext.getContext().getResources().getDimension(l.c.Edge_2A);
      AppMethodBeat.o(167365);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(346578);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int i = paramRecyclerView.bj(paramView).KJ();
      paramView = this.FRK;
      paramRect.left = ((int)this.offset);
      if (i + 1 == paramView.fbm().size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(346578);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$5", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements a.a<GalleryItem.MediaItem>
  {
    k(FinderMediaCropUI paramFinderMediaCropUI) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    l(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "isSuccessfully", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.m<List<? extends MediaSelectedData>, Boolean, ah>
  {
    m(FinderMediaCropUI paramFinderMediaCropUI, List<? extends GalleryItem.MediaItem> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Boolean, b.f, ah>
  {
    n(GalleryItem.MediaItem paramMediaItem, FinderMediaCropUI paramFinderMediaCropUI, ArrayList<MediaSelectedData> paramArrayList, ah.d paramd, kotlin.g.a.m<? super List<? extends MediaSelectedData>, ? super Boolean, ah> paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    o(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<RecyclerView>
  {
    p(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ArrayList<GalleryItem.MediaItem>>
  {
    q(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<CheckBox>
  {
    r(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    s(FinderMediaCropUI paramFinderMediaCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI
 * JD-Core Version:    0.7.0.1
 */