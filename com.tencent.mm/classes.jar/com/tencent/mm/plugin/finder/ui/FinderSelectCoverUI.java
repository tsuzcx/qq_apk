package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
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
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.z.e;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "conentLayout", "Landroid/view/View;", "coverMarginTop", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "cropWindowView", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "isLongVideo", "longVideoCoverLayout", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "packageLongVideoCropInfoToIntent", "intent", "Landroid/content/Intent;", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder_release"})
public final class FinderSelectCoverUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean isLongVideo;
  private final LinkedList<cjl> mediaList;
  private SeekBar oyP;
  private final kotlin.f tFJ;
  private com.tencent.mm.plugin.finder.video.p vNg;
  private CropLayout vNh;
  private View vNi;
  private com.tencent.mm.videocomposition.g vNj;
  private Canvas vNk;
  public Bitmap vNl;
  public Paint vNm;
  private final kotlin.f vNn;
  private final kotlin.f vNo;
  private View vNp;
  private View vNq;
  private View vNr;
  private float vNs;
  boolean vNt;
  boolean vNu;
  
  public FinderSelectCoverUI()
  {
    AppMethodBeat.i(252638);
    this.TAG = "Finder.FinderSelectCoverUI";
    this.mediaList = new LinkedList();
    this.vNn = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.vNo = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.tFJ = kotlin.g.ah((kotlin.g.a.a)FinderSelectCoverUI.m.vNJ);
    this.vNt = true;
    this.vNu = true;
    AppMethodBeat.o(252638);
  }
  
  private static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    AppMethodBeat.i(252636);
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
      AppMethodBeat.o(252636);
      return localRect;
      f1 = paramInt5 / j;
      f2 = (k * f1 - paramInt6) * 0.5F;
      f3 = 0.0F;
      break;
    }
  }
  
  private final Point cZM()
  {
    AppMethodBeat.i(252633);
    Point localPoint = (Point)this.tFJ.getValue();
    AppMethodBeat.o(252633);
    return localPoint;
  }
  
  private final float dzX()
  {
    AppMethodBeat.i(252631);
    float f = ((Number)this.vNn.getValue()).floatValue();
    AppMethodBeat.o(252631);
    return f;
  }
  
  private final float dzY()
  {
    AppMethodBeat.i(252632);
    float f = ((Number)this.vNo.getValue()).floatValue();
    AppMethodBeat.o(252632);
    return f;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252649);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252649);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252648);
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
    AppMethodBeat.o(252648);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494614;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252635);
    super.initView();
    this.isLongVideo = getIntent().getBooleanExtra("isLongVideoPost", false);
    findViewById(2131307521).setOnClickListener((View.OnClickListener)new c(this));
    Object localObject1 = findViewById(2131307524);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.select_cover_seekbar)");
    this.oyP = ((SeekBar)localObject1);
    localObject1 = findViewById(2131300800);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.vNh = ((CropLayout)localObject1);
    localObject1 = findViewById(2131307523);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.select_cover_ok)");
    this.vNi = ((View)localObject1);
    localObject1 = findViewById(2131303831);
    kotlin.g.b.p.g(localObject1, "findViewById<View>(R.id.long_video_cover_layout)");
    this.vNp = ((View)localObject1);
    localObject1 = findViewById(2131299340);
    kotlin.g.b.p.g(localObject1, "findViewById<View>(R.id.crop_window_view)");
    this.vNq = ((View)localObject1);
    localObject1 = findViewById(2131299205);
    kotlin.g.b.p.g(localObject1, "findViewById<View>(R.id.content_layout)");
    this.vNr = ((View)localObject1);
    localObject1 = (com.tencent.mm.bw.a)new cjk();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (cjk)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new cjk();
      }
      this.mediaList.addAll((Collection)((cjk)localObject1).mediaList);
      localObject3 = (cjl)this.mediaList.getFirst();
      locale = new z.e();
      locale.SYF = (((cjl)localObject3).videoDuration * 1000L);
      localObject1 = y.vXH;
      if (y.h((cjl)localObject3))
      {
        localObject1 = (Context)this;
        kotlin.g.b.p.g(localObject3, "media");
        this.vNg = ((com.tencent.mm.plugin.finder.video.p)new com.tencent.mm.plugin.finder.video.f((Context)localObject1, (cjl)localObject3));
        localObject1 = e.aNx(((cjl)localObject3).url);
        if (localObject1 != null)
        {
          locale.SYF = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.xsz;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.awl(((cjl)localObject3).url);
          j = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
          i = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
          m = (int)dzX();
          k = (int)dzY();
          localObject1 = this.oyP;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("seekBar");
          }
          ((SeekBar)localObject1).setMax(Util.videoMsToSec(locale.SYF) * 10);
          localObject1 = o.wfX;
          this.vNj = o.m((cjl)localObject3);
          localObject1 = this.vNj;
          if (localObject1 != null)
          {
            ((com.tencent.mm.videocomposition.g)localObject1).setSize(m, k);
            localObject1 = x.SXb;
          }
          f1 = 1.0F * ((cjl)localObject3).height / ((cjl)localObject3).width;
          localObject1 = this.vNh;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("cropLayout");
          }
          ((CropLayout)localObject1).setEnableScale(false);
          localObject1 = this.vNh;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("cropLayout");
          }
          ((CropLayout)localObject1).reset();
          if (!this.isLongVideo) {
            break label1842;
          }
          localObject1 = new RelativeLayout.LayoutParams(-1, -1);
          localObject4 = this.vNr;
          if (localObject4 == null) {
            kotlin.g.b.p.btv("conentLayout");
          }
          ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = this.vNp;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("longVideoCoverLayout");
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = this.vNh;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("cropLayout");
          }
          ((CropLayout)localObject1).setEnableTouch(true);
          localObject1 = this.vNh;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("cropLayout");
          }
          ((CropLayout)localObject1).setEnableFling(true);
          localObject1 = this.vNh;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("cropLayout");
          }
          ((CropLayout)localObject1).setEnableOverScroll(false);
          localObject1 = ((cjl)localObject3).uOR;
          if (localObject1 != null)
          {
            localObject1 = ((cjx)localObject1).Mpq;
            if (localObject1 != null)
            {
              if (((erf)localObject1).left > 0)
              {
                localObject4 = this.vNh;
                if (localObject4 == null) {
                  kotlin.g.b.p.btv("cropLayout");
                }
                ((CropLayout)localObject4).setEnableTouch(false);
                localObject4 = this.vNh;
                if (localObject4 == null) {
                  kotlin.g.b.p.btv("cropLayout");
                }
                ((CropLayout)localObject4).setEnableFling(false);
              }
              k = Math.abs(((erf)localObject1).bottom - ((erf)localObject1).top);
              this.vNs = ((cZM().y - getResources().getDimensionPixelOffset(2131166372) - k) / 2.0F);
              localObject4 = findViewById(2131299339);
              kotlin.g.b.p.g(localObject4, "shadowView");
              localObject5 = ((View)localObject4).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject5).height = ((int)this.vNs);
              ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              localObject4 = this.vNq;
              if (localObject4 == null) {
                kotlin.g.b.p.btv("cropWindowView");
              }
              localObject4 = ((View)localObject4).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject4).height = k;
              localObject5 = this.vNq;
              if (localObject5 == null) {
                kotlin.g.b.p.btv("cropWindowView");
              }
              ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              localObject4 = this.vNh;
              if (localObject4 == null) {
                kotlin.g.b.p.btv("cropLayout");
              }
              localObject4 = ((CropLayout)localObject4).getVisibilityRect();
              f1 = ((erf)localObject1).left;
              float f2 = this.vNs;
              float f3 = ((erf)localObject1).right;
              float f4 = this.vNs;
              ((RectF)localObject4).set(new RectF(f1, f2, f3, k + f4));
              localObject1 = x.SXb;
            }
          }
          localObject1 = ((cjl)localObject3).uOR;
          if (localObject1 == null) {
            break label1983;
          }
          localObject1 = ((cjx)localObject1).Mpr;
          if (localObject1 == null) {
            break label1995;
          }
          localObject1 = ((cjl)localObject3).uOR;
          if (localObject1 == null) {
            break label1989;
          }
          localObject1 = ((cjx)localObject1).Mpr;
          if ((localObject1 != null) && (((bej)localObject1).LOe.size() == 9))
          {
            localObject4 = new Matrix();
            localObject1 = ((bej)localObject1).LOe;
            kotlin.g.b.p.g(localObject1, "it.value");
            ((Matrix)localObject4).setValues(kotlin.a.j.t((Collection)localObject1));
            localObject1 = new Matrix((Matrix)localObject4);
            if (this.isLongVideo) {
              ((Matrix)localObject1).postTranslate(0.0F, this.vNs);
            }
            localObject4 = this.vNh;
            if (localObject4 == null) {
              kotlin.g.b.p.btv("cropLayout");
            }
            localObject5 = this.vNg;
            if (localObject5 == null) {
              kotlin.g.b.p.btv("seeker");
            }
            ((CropLayout)localObject4).a(((com.tencent.mm.plugin.finder.video.p)localObject5).getView(), j, i, new Matrix(), CropLayout.e.QMD, (kotlin.g.a.b)new e((Matrix)localObject1));
          }
          localObject1 = this.oyP;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("seekBar");
          }
          ((SeekBar)localObject1).setVisibility(4);
          localObject1 = this.oyP;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("seekBar");
          }
          ((SeekBar)localObject1).setEnabled(false);
          localObject1 = this.vNi;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("selectBtn");
          }
          ((View)localObject1).setEnabled(false);
          i = cZM().x;
          localObject1 = getContext();
          kotlin.g.b.p.g(localObject1, "context");
          k = i - (int)((AppCompatActivity)localObject1).getResources().getDimension(2131165303);
          j = (int)Math.ceil(k / dzX());
          i = j;
          if (j < 2) {
            i = 2;
          }
          long l = locale.SYF / (i - 1);
          localObject4 = (Iterable)kotlin.k.j.mY(0, i);
          localObject1 = (Collection)new LinkedList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject1).add(Long.valueOf(((ab)localObject4).nextInt() * l));
          }
        }
      }
    }
    catch (Exception localException)
    {
      final z.e locale;
      int k;
      for (;;)
      {
        int i;
        int m;
        float f1;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localObject2 = null;
        continue;
        Log.w(this.TAG, "initView: mediaInfo null");
        continue;
        localObject2 = ((cjl)localObject3).MfU;
        if (localObject2 != null)
        {
          localObject4 = ((acn)localObject2).Gxw.Lnm;
          localObject5 = ((cjl)localObject3).MoU;
          if (localObject5 != null)
          {
            ((dlh)localObject4).Msu.set(0, Integer.valueOf((int)((aty)localObject5).left));
            ((dlh)localObject4).Msu.set(1, Integer.valueOf((int)((aty)localObject5).top));
            ((dlh)localObject4).Msu.set(2, Integer.valueOf((int)((aty)localObject5).right));
            ((dlh)localObject4).Msu.set(3, Integer.valueOf((int)((aty)localObject5).bottom));
          }
          localObject5 = ((dlh)localObject4).Msu.get(0);
          kotlin.g.b.p.g(localObject5, "originRect.values[0]");
          i = ((Number)localObject5).intValue();
          localObject5 = ((dlh)localObject4).Msu.get(1);
          kotlin.g.b.p.g(localObject5, "originRect.values[1]");
          j = ((Number)localObject5).intValue();
          localObject5 = ((dlh)localObject4).Msu.get(2);
          kotlin.g.b.p.g(localObject5, "originRect.values[2]");
          k = ((Number)localObject5).intValue();
          localObject4 = ((dlh)localObject4).Msu.get(3);
          kotlin.g.b.p.g(localObject4, "originRect.values[3]");
          localObject4 = new Rect(i, j, k, ((Number)localObject4).intValue());
          locale.SYF = (((acn)localObject2).Lnf - ((acn)localObject2).Lne);
          localObject2 = ((acn)localObject2).Gxw;
          if (localObject2 != null)
          {
            i = ((aco)localObject2).targetWidth;
            label1699:
            j = ((Rect)localObject4).height() * i / ((Rect)localObject4).width();
            ((cjl)localObject3).height = (((cjl)localObject3).width * ((Rect)localObject4).height() / ((Rect)localObject4).width());
            localObject2 = x.SXb;
            k = i;
            i = j;
          }
        }
        for (int j = k;; j = 0)
        {
          localObject2 = (Context)this;
          kotlin.g.b.p.g(localObject3, "media");
          this.vNg = ((com.tencent.mm.plugin.finder.video.p)new com.tencent.mm.plugin.finder.video.b((Context)localObject2, (cjl)localObject3));
          f1 = Math.max(dzX() / j, dzY() / i);
          m = (int)(j * f1);
          k = (int)(f1 * i);
          break;
          i = 0;
          break label1699;
          i = 0;
        }
        label1842:
        localObject2 = this.vNh;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("cropLayout");
        }
        localObject2 = ((CropLayout)localObject2).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = cZM().x;
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(f1 * ((ViewGroup.LayoutParams)localObject2).width));
        localObject4 = this.vNh;
        if (localObject4 == null) {
          kotlin.g.b.p.btv("cropLayout");
        }
        ((CropLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.vNh;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("cropLayout");
        }
        ((CropLayout)localObject2).setEnableTouch(false);
        localObject2 = this.vNh;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("cropLayout");
        }
        ((CropLayout)localObject2).setEnableFling(false);
        localObject2 = this.vNh;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("cropLayout");
        }
        ((CropLayout)localObject2).setEnableOverScroll(false);
        continue;
        label1983:
        localObject2 = null;
        continue;
        label1989:
        localObject2 = null;
        continue;
        label1995:
        localObject2 = this.vNh;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("cropLayout");
        }
        localObject4 = this.vNg;
        if (localObject4 == null) {
          kotlin.g.b.p.btv("seeker");
        }
        ((CropLayout)localObject2).a(((com.tencent.mm.plugin.finder.video.p)localObject4).getView(), j, i, new Matrix(), CropLayout.e.QMD, (kotlin.g.a.b)f.vNy);
      }
      Object localObject2 = (LinkedList)localObject2;
      Object localObject4 = Bitmap.createBitmap(k, (int)dzY(), Bitmap.Config.ARGB_8888);
      Object localObject5 = new Canvas((Bitmap)localObject4);
      com.tencent.mm.videocomposition.g localg = this.vNj;
      if (localg != null)
      {
        localg.b((List)localObject2, (m)new g(this, (LinkedList)localObject2, (cjl)localObject3, (Canvas)localObject5, (Bitmap)localObject4));
        localObject2 = x.SXb;
      }
      localObject2 = this.vNg;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("seeker");
      }
      ((com.tencent.mm.plugin.finder.video.p)localObject2).a((kotlin.g.a.a)new h(this, locale, (cjl)localObject3), (kotlin.g.a.a)new i(this), (kotlin.g.a.b)new j(this, (cjl)localObject3));
      localObject2 = this.vNi;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("selectBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new d(this, (cjl)localObject3));
      AppMethodBeat.o(252635);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252634);
    setTheme(2131821178);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    kotlin.g.b.p.g(paramBundle, "window");
    paramBundle.setStatusBarColor(-16777216);
    updataStatusBarIcon(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    initView();
    AppMethodBeat.o(252634);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252637);
    super.onDestroy();
    Object localObject = this.vNg;
    if (localObject == null) {
      kotlin.g.b.p.btv("seeker");
    }
    ((com.tencent.mm.plugin.finder.video.p)localObject).destroy();
    localObject = this.vNj;
    if (localObject != null)
    {
      ((com.tencent.mm.videocomposition.g)localObject).destroy();
      AppMethodBeat.o(252637);
      return;
    }
    AppMethodBeat.o(252637);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Float>
  {
    a(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Float>
  {
    b(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252612);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vNv.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252612);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSelectCoverUI paramFinderSelectCoverUI, cjl paramcjl) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252613);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      int j;
      Object localObject2;
      Bitmap localBitmap;
      erf localerf;
      label310:
      label358:
      boolean bool;
      int k;
      if (FinderSelectCoverUI.d(this.vNv).isEnabled())
      {
        paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
        i = com.tencent.mm.plugin.finder.storage.c.dqx().iTf;
        j = (int)(i / this.vNw.width * this.vNw.height);
        Log.i(FinderSelectCoverUI.g(this.vNv), "save cover, size: " + i + ", " + j);
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localObject2 = new Canvas((Bitmap)localObject1);
        localBitmap = FinderSelectCoverUI.e(this.vNv).getBitmap();
        if (localBitmap == null)
        {
          this.vNv.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252613);
          return;
        }
        if (!this.vNw.MoO) {
          break label579;
        }
        paramView = this.vNw.uOR;
        float f1 = FinderSelectCoverUI.h(this.vNv).getContentViewScale()[0];
        float f2 = -(FinderSelectCoverUI.h(this.vNv).getContentViewTrans()[1] - FinderSelectCoverUI.i(this.vNv));
        localerf = new erf();
        if (paramView == null) {
          break label547;
        }
        paramView = paramView.Mps;
        if (paramView == null) {
          break label552;
        }
        localerf.left = paramView.left;
        localerf.right = paramView.right;
        localerf.top = ((int)(paramView.top - paramView.bottom + f2 / f1));
        localerf.bottom = ((int)(f2 / f1));
        ((Canvas)localObject2).drawBitmap(localBitmap, new Rect(localerf.left, localerf.bottom, localerf.right, localerf.top), new Rect(0, 0, i, j), null);
        paramView = new StringBuilder();
        localObject2 = al.waC;
        paramView = al.dEH() + "cover_" + System.currentTimeMillis();
        localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bool = BitmapUtil.saveBitmapToImage((Bitmap)localObject1, com.tencent.mm.plugin.finder.storage.c.dqY(), Bitmap.CompressFormat.JPEG, paramView, false);
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.dtU()) {
          break label622;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        k = com.tencent.mm.plugin.finder.storage.c.dqC();
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      }
      label547:
      label552:
      label579:
      label622:
      for (int i = AdaptiveAdjustBitrate.getVideoImageQuality(k, 0, i, j, com.tencent.mm.plugin.finder.storage.c.dqY() / 100.0F);; i = 0)
      {
        localObject1 = new Intent();
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.f.wDt;
          ((Intent)localObject1).putExtra(com.tencent.mm.plugin.finder.widget.post.f.dJr(), paramView);
          paramView = com.tencent.mm.plugin.finder.widget.post.f.wDt;
          ((Intent)localObject1).putExtra(com.tencent.mm.plugin.finder.widget.post.f.dJs(), i);
          FinderSelectCoverUI.a(this.vNv, (Intent)localObject1);
        }
        this.vNv.setResult(0, (Intent)localObject1);
        this.vNv.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252613);
        return;
        paramView = null;
        break;
        localerf.left = 0;
        localerf.right = 0;
        localerf.top = 0;
        localerf.bottom = 0;
        break label310;
        ((Canvas)localObject2).drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new Rect(0, 0, i, j), null);
        break label358;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    e(Matrix paramMatrix)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    public static final f vNy;
    
    static
    {
      AppMethodBeat.i(252616);
      vNy = new f();
      AppMethodBeat.o(252616);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class g
    extends q
    implements m<Long, Bitmap, x>
  {
    g(FinderSelectCoverUI paramFinderSelectCoverUI, LinkedList paramLinkedList, cjl paramcjl, Canvas paramCanvas, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(FinderSelectCoverUI paramFinderSelectCoverUI, z.e parame, cjl paramcjl)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Long, x>
  {
    j(FinderSelectCoverUI paramFinderSelectCoverUI, cjl paramcjl)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252627);
      this.vNv.finish();
      AppMethodBeat.o(252627);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252628);
      if (this.vNv.vNt)
      {
        localObject = FinderSelectCoverUI.c(this.vNv);
        Resources localResources = this.vNv.getResources();
        Bitmap localBitmap = this.vNv.vNl;
        if (localBitmap == null) {
          kotlin.g.b.p.btv("thumbBitmap");
        }
        ((SeekBar)localObject).setThumb((Drawable)new BitmapDrawable(localResources, localBitmap));
        FinderSelectCoverUI.c(this.vNv).setThumbOffset(0);
        this.vNv.vNt = false;
        AppMethodBeat.o(252628);
        return;
      }
      Object localObject = FinderSelectCoverUI.c(this.vNv).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).invalidateSelf();
        AppMethodBeat.o(252628);
        return;
      }
      AppMethodBeat.o(252628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI
 * JD-Core Version:    0.7.0.1
 */