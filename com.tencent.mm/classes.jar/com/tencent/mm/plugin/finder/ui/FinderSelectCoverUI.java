package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.j;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.ah.e;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "conentLayout", "Landroid/view/View;", "coverMarginTop", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "cropWindowView", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "isLongVideo", "longVideoCoverLayout", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "packageLongVideoCropInfoToIntent", "intent", "Landroid/content/Intent;", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSelectCoverUI
  extends MMFinderUI
{
  private final j AMa;
  private com.tencent.mm.plugin.finder.video.r FTk;
  private CropLayout FTl;
  private View FTm;
  private c FTn;
  private Canvas FTo;
  public Bitmap FTp;
  public Paint FTq;
  private final j FTr;
  private final j FTs;
  private View FTt;
  private View FTu;
  private View FTv;
  private float FTw;
  private boolean FTx;
  boolean FTy;
  private final String TAG;
  private boolean isLongVideo;
  private final LinkedList<dji> mediaList;
  private SeekBar uMM;
  
  public FinderSelectCoverUI()
  {
    AppMethodBeat.i(346679);
    this.TAG = "Finder.FinderSelectCoverUI";
    this.mediaList = new LinkedList();
    this.FTr = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.FTs = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.AMa = kotlin.k.cm((kotlin.g.a.a)FinderSelectCoverUI.i.FTJ);
    this.FTx = true;
    this.FTy = true;
    AppMethodBeat.o(346679);
  }
  
  private static final void a(FinderSelectCoverUI paramFinderSelectCoverUI)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(346763);
    s.u(paramFinderSelectCoverUI, "this$0");
    if (paramFinderSelectCoverUI.FTx)
    {
      localObject1 = paramFinderSelectCoverUI.uMM;
      if (localObject1 == null)
      {
        s.bIx("seekBar");
        localObject1 = null;
        ((SeekBar)localObject1).setThumb((Drawable)new BitmapDrawable(paramFinderSelectCoverUI.getResources(), paramFinderSelectCoverUI.fbH()));
        localObject1 = paramFinderSelectCoverUI.uMM;
        if (localObject1 != null) {
          break label95;
        }
        s.bIx("seekBar");
        localObject1 = localObject2;
      }
      label95:
      for (;;)
      {
        ((SeekBar)localObject1).setThumbOffset(0);
        paramFinderSelectCoverUI.FTx = false;
        AppMethodBeat.o(346763);
        return;
        break;
      }
    }
    paramFinderSelectCoverUI = paramFinderSelectCoverUI.uMM;
    if (paramFinderSelectCoverUI == null)
    {
      s.bIx("seekBar");
      paramFinderSelectCoverUI = (FinderSelectCoverUI)localObject1;
    }
    for (;;)
    {
      paramFinderSelectCoverUI = paramFinderSelectCoverUI.getThumb();
      if (paramFinderSelectCoverUI != null) {
        paramFinderSelectCoverUI.invalidateSelf();
      }
      AppMethodBeat.o(346763);
      return;
    }
  }
  
  private static final void a(FinderSelectCoverUI paramFinderSelectCoverUI, View paramView)
  {
    AppMethodBeat.i(346725);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSelectCoverUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderSelectCoverUI, "this$0");
    paramFinderSelectCoverUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346725);
  }
  
  private static final void a(final FinderSelectCoverUI paramFinderSelectCoverUI, final dji paramdji, int paramInt1, int paramInt2, LinkedList paramLinkedList, final Canvas paramCanvas, final Bitmap paramBitmap)
  {
    Object localObject2 = null;
    AppMethodBeat.i(346734);
    s.u(paramFinderSelectCoverUI, "this$0");
    s.u(paramLinkedList, "$times");
    s.u(paramCanvas, "$canvas");
    Object localObject1 = com.tencent.mm.plugin.finder.video.p.Grl;
    s.s(paramdji, "media");
    Object localObject3 = paramFinderSelectCoverUI.FTk;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("seeker");
      localObject1 = null;
    }
    if ((localObject1 instanceof com.tencent.mm.plugin.finder.video.i))
    {
      localObject1 = (com.tencent.mm.plugin.finder.video.i)localObject1;
      if (localObject1 != null) {
        break label177;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      paramFinderSelectCoverUI.FTn = com.tencent.mm.plugin.finder.video.p.a(paramdji, paramInt1, paramInt2, localObject1);
      localObject1 = paramFinderSelectCoverUI.FTn;
      if (localObject1 != null) {
        ((c)localObject1).setSize(paramInt1, paramInt2);
      }
      localObject1 = paramFinderSelectCoverUI.FTn;
      if (localObject1 != null) {
        ((c)localObject1).b((List)paramLinkedList, (m)new e(paramLinkedList, paramFinderSelectCoverUI, paramdji, paramCanvas, paramBitmap));
      }
      AppMethodBeat.o(346734);
      return;
      localObject1 = null;
      break;
      label177:
      localObject3 = ((com.tencent.mm.plugin.finder.video.i)localObject1).Goz.getPlayer();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject3).TFd;
      }
    }
  }
  
  private static final void a(FinderSelectCoverUI paramFinderSelectCoverUI, dji paramdji, View paramView)
  {
    AppMethodBeat.i(346757);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderSelectCoverUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramdji);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderSelectCoverUI, "this$0");
    localObject1 = paramFinderSelectCoverUI.FTm;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("selectBtn");
      paramView = null;
    }
    int j;
    int i;
    Object localObject3;
    dju localdju;
    if (paramView.isEnabled())
    {
      paramView = d.FAy;
      j = d.ePV().oCa;
      if (paramdji.aaPf) {}
      for (i = (int)(j / paramdji.width * paramdji.height);; i = (int)(f1 / paramView.getWidth() * j))
      {
        Log.i(paramFinderSelectCoverUI.TAG, "save cover, size: " + j + ", " + i);
        localObject2 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas((Bitmap)localObject2);
        localObject1 = paramFinderSelectCoverUI.FTk;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("seeker");
          paramView = null;
        }
        localObject1 = paramView.getBitmap();
        if (localObject1 != null) {
          break;
        }
        paramFinderSelectCoverUI.finish();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(346757);
        return;
        localObject1 = paramFinderSelectCoverUI.FTl;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("cropLayout");
          paramView = null;
        }
        f1 = paramView.getHeight();
        localObject1 = paramFinderSelectCoverUI.FTl;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("cropLayout");
          paramView = null;
        }
      }
      if (!paramdji.aaPf) {
        break label1250;
      }
      localdju = paramdji.EDC;
      paramView = paramFinderSelectCoverUI.FTl;
      paramdji = paramView;
      if (paramView == null)
      {
        s.bIx("cropLayout");
        paramdji = null;
      }
      f1 = paramdji.getContentViewScale()[0];
      paramView = paramFinderSelectCoverUI.FTl;
      paramdji = paramView;
      if (paramView == null)
      {
        s.bIx("cropLayout");
        paramdji = null;
      }
      f2 = -(paramdji.getContentViewTrans()[1] - paramFinderSelectCoverUI.FTw);
      String str = paramFinderSelectCoverUI.TAG;
      paramView = paramFinderSelectCoverUI.FTl;
      paramdji = paramView;
      if (paramView == null)
      {
        s.bIx("cropLayout");
        paramdji = null;
      }
      Log.i(str, s.X("getContentViewTrans y:", Float.valueOf(paramdji.getContentViewTrans()[1])));
      paramView = new fyb();
      if (localdju != null) {
        break label1218;
      }
      paramdji = null;
      if (paramdji == null) {
        break label1227;
      }
      paramView.left = paramdji.left;
      paramView.right = paramdji.right;
      paramView.top = ((int)(paramdji.top - paramdji.bottom + f2 / f1));
    }
    int k;
    for (paramView.bottom = ((int)(f2 / f1));; paramView.bottom = 0)
    {
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, new Rect(paramView.left, paramView.bottom, paramView.right, paramView.top), new Rect(0, 0, j, i), null);
      paramdji = new StringBuilder();
      paramView = bm.GlZ;
      paramdji = bm.fiu() + "cover_full" + System.currentTimeMillis();
      paramView = d.FAy;
      boolean bool1 = BitmapUtil.saveBitmapToImage((Bitmap)localObject1, d.eQz(), Bitmap.CompressFormat.JPEG, paramdji, false);
      paramView = new StringBuilder();
      localObject1 = bm.GlZ;
      paramView = bm.fiu() + "cover_" + System.currentTimeMillis();
      localObject1 = d.FAy;
      boolean bool2 = BitmapUtil.saveBitmapToImage((Bitmap)localObject2, d.eQz(), Bitmap.CompressFormat.JPEG, paramView, false);
      localObject1 = d.FAy;
      if (!d.eTA()) {
        break label1688;
      }
      localObject1 = d.FAy;
      k = d.ePY();
      localObject1 = d.FAy;
      i = AdaptiveAdjustBitrate.getVideoImageQuality(k, 0, j, i, d.eQz() / 100.0F);
      label709:
      localObject1 = new Intent();
      if (bool1)
      {
        localObject2 = com.tencent.mm.plugin.finder.widget.post.g.HaE;
        ((Intent)localObject1).putExtra(com.tencent.mm.plugin.finder.widget.post.g.fqR(), paramdji);
      }
      if (bool2)
      {
        paramdji = com.tencent.mm.plugin.finder.widget.post.g.HaE;
        ((Intent)localObject1).putExtra(com.tencent.mm.plugin.finder.widget.post.g.fqS(), paramView);
        paramdji = com.tencent.mm.plugin.finder.widget.post.g.HaE;
        ((Intent)localObject1).putExtra(com.tencent.mm.plugin.finder.widget.post.g.fqT(), i);
        if (paramFinderSelectCoverUI.isLongVideo)
        {
          localObject3 = (dji)paramFinderSelectCoverUI.mediaList.getFirst();
          localObject2 = new dju();
          localdju = ((dji)localObject3).EDC;
          if (localdju != null)
          {
            paramView = paramFinderSelectCoverUI.FTl;
            paramdji = paramView;
            if (paramView == null)
            {
              s.bIx("cropLayout");
              paramdji = null;
            }
            f1 = paramdji.getContentViewScale()[0];
            paramView = paramFinderSelectCoverUI.FTl;
            paramdji = paramView;
            if (paramView == null)
            {
              s.bIx("cropLayout");
              paramdji = null;
            }
            f2 = -(paramdji.getContentViewTrans()[1] - paramFinderSelectCoverUI.FTw);
            paramdji = new fyb();
            paramView = localdju.aaPL;
            s.checkNotNull(paramView);
            paramdji.left = paramView.left;
            paramView = localdju.aaPL;
            s.checkNotNull(paramView);
            paramdji.right = paramView.right;
            paramView = localdju.aaPL;
            s.checkNotNull(paramView);
            i = paramView.top;
            paramView = localdju.aaPL;
            s.checkNotNull(paramView);
            paramdji.top = ((int)(i - paramView.bottom + f2 / f1));
            paramdji.bottom = ((int)(f2 / f1));
            ((dju)localObject2).aaPL = paramdji;
            paramdji = ((dji)localObject3).EDC;
            s.checkNotNull(paramdji);
            paramView = paramdji.aaPJ;
            paramdji = new fyb();
            s.checkNotNull(paramView);
            paramdji.left = paramView.left;
            paramdji.bottom = ((int)f2);
            paramdji.top = (paramdji.bottom + Math.abs(paramView.bottom - paramView.top));
            paramdji.right = paramView.right;
            paramView = kotlin.ah.aiuX;
            ((dju)localObject2).aaPJ = paramdji;
            paramView = paramFinderSelectCoverUI.FTl;
            paramdji = paramView;
            if (paramView == null)
            {
              s.bIx("cropLayout");
              paramdji = null;
            }
            paramView = new Matrix(paramdji.getMainMatrix());
            paramView.postTranslate(0.0F, -paramFinderSelectCoverUI.FTw);
            paramdji = new float[9];
            paramView.getValues(paramdji);
            paramView = new byz();
            paramView.aaib.addAll((Collection)kotlin.a.k.D(paramdji));
            paramdji = kotlin.ah.aiuX;
            ((dju)localObject2).aaPK = paramView;
            paramdji = com.tencent.mm.plugin.finder.widget.post.g.HaE;
            paramdji = com.tencent.mm.plugin.finder.widget.post.g.fqU();
            paramView = new LocalVideoCropInfoParcelable();
            paramView.EDC = ((dju)localObject2);
            localObject2 = kotlin.ah.aiuX;
            ((Intent)localObject1).putExtra(paramdji, (Parcelable)paramView);
          }
        }
      }
      paramFinderSelectCoverUI.setResult(0, (Intent)localObject1);
      paramFinderSelectCoverUI.finish();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346757);
      return;
      label1218:
      paramdji = localdju.aaPL;
      break;
      label1227:
      paramView.left = 0;
      paramView.right = 0;
      paramView.top = 0;
    }
    label1250:
    paramView = paramFinderSelectCoverUI.FTl;
    paramdji = paramView;
    if (paramView == null)
    {
      s.bIx("cropLayout");
      paramdji = null;
    }
    float f2 = paramdji.getContentViewScale()[0];
    paramView = paramFinderSelectCoverUI.FTl;
    paramdji = paramView;
    if (paramView == null)
    {
      s.bIx("cropLayout");
      paramdji = null;
    }
    float f5 = paramdji.getContentViewScale()[1];
    paramView = paramFinderSelectCoverUI.FTl;
    paramdji = paramView;
    if (paramView == null)
    {
      s.bIx("cropLayout");
      paramdji = null;
    }
    float f3 = paramdji.getWidth() / f2;
    paramView = paramFinderSelectCoverUI.FTl;
    paramdji = paramView;
    if (paramView == null)
    {
      s.bIx("cropLayout");
      paramdji = null;
    }
    float f4 = paramdji.getHeight() / f5;
    paramView = paramFinderSelectCoverUI.FTl;
    paramdji = paramView;
    if (paramView == null)
    {
      s.bIx("cropLayout");
      paramdji = null;
    }
    float f1 = -paramdji.getContentViewTrans()[0] / f2;
    paramView = paramFinderSelectCoverUI.FTl;
    paramdji = paramView;
    if (paramView == null)
    {
      s.bIx("cropLayout");
      paramdji = null;
    }
    f5 = -paramdji.getContentViewTrans()[1] / f5;
    if (f1 < 0.5D) {
      f1 = 0.5F;
    }
    for (;;)
    {
      k = ((Bitmap)localObject1).getWidth();
      int m = ((Bitmap)localObject1).getHeight();
      paramdji = new RectF((k - f3) / 2.0F, (m - f4) / 2.0F, (k + f3) / 2.0F, (f4 + m) / 2.0F);
      f4 = f1 - paramdji.left;
      f5 -= paramdji.top;
      paramdji = new Rect((int)(paramdji.left + f4), (int)(paramdji.top + f5), (int)(paramdji.right + f4), (int)(f5 + paramdji.bottom));
      Log.i(paramFinderSelectCoverUI.TAG, "scaleX:" + f2 + "  translateX:" + f1 + " mappedWidth:" + f3 + " originWidth:" + k + " deltaX:" + f4 + " textureLeft:" + paramdji.left + " textureRight:" + paramdji.right);
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, new Rect(paramdji.left, paramdji.top, paramdji.right, paramdji.bottom), new Rect(0, 0, j, i), null);
      break;
      label1688:
      i = 0;
      break label709;
    }
  }
  
  private static final boolean a(FinderSelectCoverUI paramFinderSelectCoverUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346718);
    s.u(paramFinderSelectCoverUI, "this$0");
    paramFinderSelectCoverUI.finish();
    AppMethodBeat.o(346718);
    return true;
  }
  
  private static Rect c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    AppMethodBeat.i(346713);
    int j = Math.abs(paramInt3 - paramInt1);
    int k = Math.abs(paramInt4 - paramInt2);
    float f1;
    float f3;
    float f2;
    if (j * paramInt6 > paramInt5 * k)
    {
      f1 = paramInt6 / k;
      f3 = (j * f1 - paramInt5) * 0.5F;
      f2 = 0.0F;
      j = (int)(f3 / f1);
      paramInt6 = (int)(f2 / f1);
      paramInt5 = j;
      if (j < 0) {
        paramInt5 = 0;
      }
      if (paramInt6 >= 0) {
        break label168;
      }
      paramInt6 = i;
    }
    label168:
    for (;;)
    {
      Rect localRect = new Rect(paramInt1 + paramInt5, paramInt2 + paramInt6, paramInt3 - paramInt5, paramInt4 - paramInt6);
      AppMethodBeat.o(346713);
      return localRect;
      f1 = paramInt5 / j;
      f2 = (k * f1 - paramInt6) * 0.5F;
      f3 = 0.0F;
      break;
    }
  }
  
  private final Point dXX()
  {
    AppMethodBeat.i(346705);
    Point localPoint = (Point)this.AMa.getValue();
    AppMethodBeat.o(346705);
    return localPoint;
  }
  
  private Bitmap fbH()
  {
    AppMethodBeat.i(346683);
    Bitmap localBitmap = this.FTp;
    if (localBitmap != null)
    {
      AppMethodBeat.o(346683);
      return localBitmap;
    }
    s.bIx("thumbBitmap");
    AppMethodBeat.o(346683);
    return null;
  }
  
  private Paint fbI()
  {
    AppMethodBeat.i(346689);
    Paint localPaint = this.FTq;
    if (localPaint != null)
    {
      AppMethodBeat.o(346689);
      return localPaint;
    }
    s.bIx("thumbPaint");
    AppMethodBeat.o(346689);
    return null;
  }
  
  private final float fbJ()
  {
    AppMethodBeat.i(346696);
    float f = ((Number)this.FTr.getValue()).floatValue();
    AppMethodBeat.o(346696);
    return f;
  }
  
  private final float fbK()
  {
    AppMethodBeat.i(346699);
    float f = ((Number)this.FTs.getValue()).floatValue();
    AppMethodBeat.o(346699);
    return f;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return l.f.finder_select_cover_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(346903);
    super.initView();
    this.isLongVideo = getIntent().getBooleanExtra("isLongVideoPost", false);
    findViewById(l.e.select_cover_cancel).setOnClickListener(new FinderSelectCoverUI..ExternalSyntheticLambda1(this));
    Object localObject1 = findViewById(l.e.select_cover_seekbar);
    s.s(localObject1, "findViewById(R.id.select_cover_seekbar)");
    this.uMM = ((SeekBar)localObject1);
    localObject1 = findViewById(l.e.finder_crop_layout);
    s.s(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.FTl = ((CropLayout)localObject1);
    localObject1 = findViewById(l.e.select_cover_ok);
    s.s(localObject1, "findViewById(R.id.select_cover_ok)");
    this.FTm = ((View)localObject1);
    localObject1 = findViewById(l.e.long_video_cover_layout);
    s.s(localObject1, "findViewById<View>(R.id.long_video_cover_layout)");
    this.FTt = ((View)localObject1);
    localObject1 = findViewById(l.e.crop_window_view);
    s.s(localObject1, "findViewById<View>(R.id.crop_window_view)");
    this.FTu = ((View)localObject1);
    localObject1 = findViewById(l.e.content_layout);
    s.s(localObject1, "findViewById<View>(R.id.content_layout)");
    this.FTv = ((View)localObject1);
    localObject1 = (com.tencent.mm.bx.a)new djh();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    final dji localdji;
    final ah.e locale;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (djh)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new djh();
      }
      this.mediaList.addAll((Collection)((djh)localObject1).mediaList);
      localdji = (dji)this.mediaList.getFirst();
      i = 0;
      j = 0;
      locale = new ah.e();
      locale.aixc = (localdji.videoDuration * 1000L);
      localObject1 = av.GiL;
      if (av.i(localdji)) {
        if (y.ZC(localdji.url))
        {
          localObject1 = (Context)this;
          s.s(localdji, "media");
          this.FTk = ((com.tencent.mm.plugin.finder.video.r)new com.tencent.mm.plugin.finder.video.g((Context)localObject1, localdji));
          localObject1 = f.aVX(localdji.url);
          if (localObject1 != null)
          {
            locale.aixc = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration;
            localObject1 = com.tencent.mm.plugin.gallery.b.g.HRf;
            localObject1 = com.tencent.mm.plugin.gallery.b.g.aBH(localdji.url);
            i = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
            j = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
            k = (int)fbJ();
            int i1 = (int)fbK();
            m = j;
            n = i;
            j = i1;
            i = k;
            k = n;
            localObject3 = this.uMM;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("seekBar");
              localObject1 = null;
            }
            ((SeekBar)localObject1).setMax(Util.videoMsToSec(locale.aixc) * 10);
            f1 = 1.0F * localdji.height / localdji.width;
            localObject3 = this.FTl;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cropLayout");
              localObject1 = null;
            }
            ((CropLayout)localObject1).reset();
            if (!this.isLongVideo) {
              break label2125;
            }
            localObject4 = new RelativeLayout.LayoutParams(-1, -1);
            localObject3 = this.FTv;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("conentLayout");
              localObject1 = null;
            }
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            localObject3 = this.FTt;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("longVideoCoverLayout");
              localObject1 = null;
            }
            ((View)localObject1).setVisibility(0);
            localObject3 = this.FTl;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cropLayout");
              localObject1 = null;
            }
            ((CropLayout)localObject1).setEnableTouch(true);
            localObject3 = this.FTl;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cropLayout");
              localObject1 = null;
            }
            ((CropLayout)localObject1).setEnableFling(true);
            localObject3 = this.FTl;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cropLayout");
              localObject1 = null;
            }
            ((CropLayout)localObject1).setEnableOverScroll(false);
            localObject3 = this.FTl;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cropLayout");
              localObject1 = null;
            }
            ((CropLayout)localObject1).setEnableScale(false);
            localObject1 = localdji.EDC;
            Object localObject5;
            if (localObject1 != null)
            {
              localObject4 = ((dju)localObject1).aaPJ;
              if (localObject4 != null)
              {
                if (((fyb)localObject4).left > 0)
                {
                  localObject3 = this.FTl;
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    s.bIx("cropLayout");
                    localObject1 = null;
                  }
                  ((CropLayout)localObject1).setEnableTouch(false);
                  localObject3 = this.FTl;
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    s.bIx("cropLayout");
                    localObject1 = null;
                  }
                  ((CropLayout)localObject1).setEnableFling(false);
                }
                n = Math.abs(((fyb)localObject4).bottom - ((fyb)localObject4).top);
                this.FTw = ((dXX().y - getResources().getDimensionPixelOffset(l.c.finder_long_video_cover_margin_top_offset) - n) / 2.0F);
                localObject1 = findViewById(l.e.crop_window_top_shadow);
                localObject3 = ((View)localObject1).getLayoutParams();
                ((ViewGroup.LayoutParams)localObject3).height = ((int)this.FTw);
                ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject3 = this.FTu;
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  s.bIx("cropWindowView");
                  localObject1 = null;
                }
                localObject5 = ((View)localObject1).getLayoutParams();
                ((ViewGroup.LayoutParams)localObject5).height = n;
                localObject3 = this.FTu;
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  s.bIx("cropWindowView");
                  localObject1 = null;
                }
                ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                localObject3 = this.FTl;
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  s.bIx("cropLayout");
                  localObject1 = null;
                }
                localObject1 = ((CropLayout)localObject1).getVisibilityRect();
                f1 = ((fyb)localObject4).left;
                float f2 = this.FTw;
                float f3 = ((fyb)localObject4).right;
                float f4 = this.FTw;
                ((RectF)localObject1).set(new RectF(f1, f2, f3, n + f4));
                localObject1 = kotlin.ah.aiuX;
              }
            }
            localObject1 = localdji.EDC;
            if (localObject1 != null) {
              break label2310;
            }
            localObject1 = null;
            if (localObject1 == null) {
              break label2330;
            }
            localObject1 = localdji.EDC;
            if (localObject1 != null) {
              break label2320;
            }
            localObject1 = null;
            if ((localObject1 != null) && (((byz)localObject1).aaib.size() == 9))
            {
              localObject3 = new Matrix();
              localObject1 = ((byz)localObject1).aaib;
              s.s(localObject1, "it.value");
              ((Matrix)localObject3).setValues(kotlin.a.p.H((Collection)localObject1));
              localObject5 = new Matrix((Matrix)localObject3);
              if (this.isLongVideo) {
                ((Matrix)localObject5).postTranslate(0.0F, this.FTw);
              }
              localObject3 = this.FTl;
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("cropLayout");
                localObject1 = null;
              }
              localObject4 = this.FTk;
              localObject3 = localObject4;
              if (localObject4 == null)
              {
                s.bIx("seeker");
                localObject3 = null;
              }
              ((CropLayout)localObject1).a(((com.tencent.mm.plugin.finder.video.r)localObject3).getView(), k, m, new Matrix(), CropLayout.e.agdt, (kotlin.g.a.b)new FinderSelectCoverUI.c((Matrix)localObject5));
            }
            localObject3 = this.uMM;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("seekBar");
              localObject1 = null;
            }
            ((SeekBar)localObject1).setVisibility(4);
            localObject3 = this.uMM;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("seekBar");
              localObject1 = null;
            }
            ((SeekBar)localObject1).setEnabled(false);
            localObject3 = this.FTm;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("selectBtn");
              localObject1 = null;
            }
            ((View)localObject1).setEnabled(false);
            n = dXX().x - (int)getContext().getResources().getDimension(l.c.Edge_4A);
            m = (int)Math.ceil(n / fbJ());
            k = m;
            if (m < 2) {
              k = 2;
            }
            long l = locale.aixc / (k - 1);
            localObject3 = (Iterable)kotlin.k.k.qt(0, k);
            localObject1 = (Collection)new LinkedList();
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((Collection)localObject1).add(Long.valueOf(((kotlin.a.ah)localObject3).Zo() * l));
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      int i;
      int j;
      int n;
      for (;;)
      {
        int k;
        int m;
        float f1;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localObject2 = null;
        continue;
        Log.w(this.TAG, "initView: mediaInfo null");
        continue;
        localObject2 = (Context)this;
        s.s(localdji, "media");
        this.FTk = ((com.tencent.mm.plugin.finder.video.r)new com.tencent.mm.plugin.finder.video.i((Context)localObject2, localdji));
        i = (int)localdji.width;
        j = (int)localdji.height;
        continue;
        localObject2 = localdji.aaDI;
        if (localObject2 != null)
        {
          if (((afb)localObject2).TYB.Znw != null) {
            break label1993;
          }
          localObject3 = ((afb)localObject2).TYB.Znp;
          localObject4 = localdji.aaPl;
          if (localObject4 != null)
          {
            ((enx)localObject3).aaTg.set(0, Integer.valueOf((int)((bbn)localObject4).left));
            ((enx)localObject3).aaTg.set(1, Integer.valueOf((int)((bbn)localObject4).top));
            ((enx)localObject3).aaTg.set(2, Integer.valueOf((int)((bbn)localObject4).right));
            ((enx)localObject3).aaTg.set(3, Integer.valueOf((int)((bbn)localObject4).bottom));
          }
          localObject4 = ((enx)localObject3).aaTg.get(0);
          s.s(localObject4, "originRect.values[0]");
          i = ((Number)localObject4).intValue();
          localObject4 = ((enx)localObject3).aaTg.get(1);
          s.s(localObject4, "originRect.values[1]");
          j = ((Number)localObject4).intValue();
          localObject4 = ((enx)localObject3).aaTg.get(2);
          s.s(localObject4, "originRect.values[2]");
          k = ((Number)localObject4).intValue();
          localObject3 = ((enx)localObject3).aaTg.get(3);
          s.s(localObject3, "originRect.values[3]");
          localObject3 = new Rect(i, j, k, ((Number)localObject3).intValue());
          locale.aixc = (((afb)localObject2).Zni - ((afb)localObject2).Znh);
          localObject2 = ((afb)localObject2).TYB;
          if (localObject2 != null) {
            break label1983;
          }
        }
        label1983:
        for (i = 0;; i = ((afc)localObject2).nxO)
        {
          j = ((Rect)localObject3).height() * i / ((Rect)localObject3).width();
          localdji.height = (localdji.width * ((Rect)localObject3).height() / ((Rect)localObject3).width());
          localObject2 = kotlin.ah.aiuX;
          localObject2 = kotlin.ah.aiuX;
          k = i;
          localObject2 = (Context)this;
          s.s(localdji, "media");
          this.FTk = ((com.tencent.mm.plugin.finder.video.r)new com.tencent.mm.plugin.finder.video.b((Context)localObject2, localdji));
          f1 = Math.max(fbJ() / k, fbK() / j);
          i = (int)(k * f1);
          n = (int)(f1 * j);
          m = j;
          j = n;
          break;
        }
        label1993:
        localObject3 = new Rect();
        com.tencent.mm.plugin.vlog.model.h.a(((afb)localObject2).TYB.Znw.Zqq, (Rect)localObject3);
        localObject4 = kotlin.ah.aiuX;
        locale.aixc = (((afb)localObject2).Zni - ((afb)localObject2).Znh);
        localObject2 = ((afb)localObject2).TYB;
        if (localObject2 == null) {
          i = 0;
        }
        for (;;)
        {
          j = ((Rect)localObject3).height() * i / ((Rect)localObject3).width();
          localdji.height = (localdji.width * ((Rect)localObject3).height() / ((Rect)localObject3).width());
          break;
          localObject2 = ((afc)localObject2).Znw;
          if (localObject2 == null) {
            i = 0;
          } else {
            i = ((dzm)localObject2).nxO;
          }
        }
        label2125:
        localObject3 = this.FTl;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cropLayout");
          localObject2 = null;
        }
        localObject4 = ((CropLayout)localObject2).getLayoutParams();
        localObject2 = av.GiL;
        localObject2 = av.is(dXX().x, (int)(f1 * dXX().x));
        ((ViewGroup.LayoutParams)localObject4).width = ((Number)((kotlin.r)localObject2).bsC).intValue();
        ((ViewGroup.LayoutParams)localObject4).height = ((Number)((kotlin.r)localObject2).bsD).intValue();
        localObject3 = this.FTl;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cropLayout");
          localObject2 = null;
        }
        ((CropLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject3 = this.FTl;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cropLayout");
          localObject2 = null;
        }
        ((CropLayout)localObject2).setEnableTouch(true);
        localObject3 = this.FTl;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cropLayout");
          localObject2 = null;
        }
        ((CropLayout)localObject2).setEnableOverScroll(false);
        continue;
        label2310:
        localObject2 = ((dju)localObject2).aaPK;
        continue;
        label2320:
        localObject2 = ((dju)localObject2).aaPK;
        continue;
        label2330:
        localObject3 = this.FTl;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cropLayout");
          localObject2 = null;
        }
        localObject4 = this.FTk;
        localObject3 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("seeker");
          localObject3 = null;
        }
        ((CropLayout)localObject2).a(((com.tencent.mm.plugin.finder.video.r)localObject3).getView(), k, m, new Matrix(), CropLayout.e.agdt, (kotlin.g.a.b)FinderSelectCoverUI.d.FTB);
      }
      localObject2 = (LinkedList)localObject2;
      localObject3 = Bitmap.createBitmap(n, (int)fbK(), Bitmap.Config.ARGB_8888);
      Object localObject4 = new Canvas((Bitmap)localObject3);
      com.tencent.threadpool.h.ahAA.bn(new FinderSelectCoverUI..ExternalSyntheticLambda4(this, localdji, i, j, (LinkedList)localObject2, (Canvas)localObject4, (Bitmap)localObject3));
      localObject2 = this.FTk;
      if (localObject2 != null) {
        break label2587;
      }
    }
    s.bIx("seeker");
    Object localObject2 = null;
    label2587:
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.video.r)localObject2).a((kotlin.g.a.a)new f(this, localdji, locale), (kotlin.g.a.a)new g(this), (kotlin.g.a.b)new h(localdji, this));
      localObject3 = this.FTm;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("selectBtn");
        localObject2 = null;
      }
      ((View)localObject2).setOnClickListener(new FinderSelectCoverUI..ExternalSyntheticLambda2(this, localdji));
      AppMethodBeat.o(346903);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346863);
    setTheme(l.j.MMTheme_NoTitleTranslucent);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setStatusBarColor(-16777216);
    updataStatusBarIcon(true);
    setBackBtn(new FinderSelectCoverUI..ExternalSyntheticLambda0(this));
    initView();
    AppMethodBeat.o(346863);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(346911);
    super.onDestroy();
    com.tencent.mm.plugin.finder.video.r localr = this.FTk;
    Object localObject = localr;
    if (localr == null)
    {
      s.bIx("seeker");
      localObject = null;
    }
    ((com.tencent.mm.plugin.finder.video.r)localObject).destroy();
    localObject = this.FTn;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    AppMethodBeat.o(346911);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Float>
  {
    a(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Float>
  {
    b(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<Long, Bitmap, kotlin.ah>
  {
    e(LinkedList<Long> paramLinkedList, FinderSelectCoverUI paramFinderSelectCoverUI, dji paramdji, Canvas paramCanvas, Bitmap paramBitmap)
    {
      super();
    }
    
    private static final void a(FinderSelectCoverUI paramFinderSelectCoverUI, Bitmap paramBitmap)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(347166);
      s.u(paramFinderSelectCoverUI, "this$0");
      SeekBar localSeekBar = FinderSelectCoverUI.b(paramFinderSelectCoverUI);
      Object localObject1 = localSeekBar;
      if (localSeekBar == null)
      {
        s.bIx("seekBar");
        localObject1 = null;
      }
      ((SeekBar)localObject1).setVisibility(0);
      if (paramFinderSelectCoverUI.FTy)
      {
        localObject1 = FinderSelectCoverUI.b(paramFinderSelectCoverUI);
        if (localObject1 == null)
        {
          s.bIx("seekBar");
          localObject1 = localObject2;
        }
        for (;;)
        {
          ((SeekBar)localObject1).setProgressDrawable((Drawable)new BitmapDrawable(paramFinderSelectCoverUI.getResources(), paramBitmap));
          paramFinderSelectCoverUI.FTy = false;
          AppMethodBeat.o(347166);
          return;
        }
      }
      paramFinderSelectCoverUI = FinderSelectCoverUI.b(paramFinderSelectCoverUI);
      if (paramFinderSelectCoverUI == null)
      {
        s.bIx("seekBar");
        paramFinderSelectCoverUI = localObject3;
      }
      for (;;)
      {
        paramFinderSelectCoverUI = paramFinderSelectCoverUI.getProgressDrawable();
        if (paramFinderSelectCoverUI != null) {
          paramFinderSelectCoverUI.invalidateSelf();
        }
        AppMethodBeat.o(347166);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(FinderSelectCoverUI paramFinderSelectCoverUI, dji paramdji, ah.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Long, kotlin.ah>
  {
    h(dji paramdji, FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
    
    private static final void a(FinderSelectCoverUI paramFinderSelectCoverUI, dji paramdji)
    {
      AppMethodBeat.i(347170);
      s.u(paramFinderSelectCoverUI, "this$0");
      com.tencent.mm.plugin.finder.video.r localr = FinderSelectCoverUI.d(paramFinderSelectCoverUI);
      Object localObject = localr;
      if (localr == null)
      {
        s.bIx("seeker");
        localObject = null;
      }
      localObject = ((com.tencent.mm.plugin.finder.video.r)localObject).getBitmap();
      if (localObject != null)
      {
        s.s(paramdji, "media");
        FinderSelectCoverUI.a(paramFinderSelectCoverUI, paramdji, (Bitmap)localObject);
      }
      AppMethodBeat.o(347170);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI
 * JD-Core Version:    0.7.0.1
 */