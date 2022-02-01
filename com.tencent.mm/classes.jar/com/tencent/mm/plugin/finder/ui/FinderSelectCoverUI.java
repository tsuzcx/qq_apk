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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.videocomposition.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.aa.e;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "conentLayout", "Landroid/view/View;", "coverMarginTop", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "cropWindowView", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "isLongVideo", "longVideoCoverLayout", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "packageLongVideoCropInfoToIntent", "intent", "Landroid/content/Intent;", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder_release"})
public final class FinderSelectCoverUI
  extends MMFinderUI
{
  private com.tencent.mm.plugin.finder.video.q AtY;
  private CropLayout AtZ;
  private View Aua;
  private c Aub;
  private Canvas Auc;
  public Bitmap Aud;
  public Paint Aue;
  private final kotlin.f Auf;
  private final kotlin.f Aug;
  private View Auh;
  private View Aui;
  private View Auj;
  private float Auk;
  boolean Aul;
  boolean Aum;
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean isLongVideo;
  private final LinkedList<csg> mediaList;
  private SeekBar rBx;
  private final kotlin.f xos;
  
  public FinderSelectCoverUI()
  {
    AppMethodBeat.i(283612);
    this.TAG = "Finder.FinderSelectCoverUI";
    this.mediaList = new LinkedList();
    this.Auf = g.ar((kotlin.g.a.a)new b(this));
    this.Aug = g.ar((kotlin.g.a.a)new a(this));
    this.xos = g.ar((kotlin.g.a.a)m.AuB);
    this.Aul = true;
    this.Aum = true;
    AppMethodBeat.o(283612);
  }
  
  private static Rect c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    AppMethodBeat.i(283610);
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
      AppMethodBeat.o(283610);
      return localRect;
      f1 = paramInt5 / j;
      f2 = (k * f1 - paramInt6) * 0.5F;
      f3 = 0.0F;
      break;
    }
  }
  
  private final Point dpI()
  {
    AppMethodBeat.i(283607);
    Point localPoint = (Point)this.xos.getValue();
    AppMethodBeat.o(283607);
    return localPoint;
  }
  
  private final float eaO()
  {
    AppMethodBeat.i(283605);
    float f = ((Number)this.Auf.getValue()).floatValue();
    AppMethodBeat.o(283605);
    return f;
  }
  
  private final float eaP()
  {
    AppMethodBeat.i(283606);
    float f = ((Number)this.Aug.getValue()).floatValue();
    AppMethodBeat.o(283606);
    return f;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(283628);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(283628);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(283626);
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
    AppMethodBeat.o(283626);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_select_cover_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(283609);
    super.initView();
    this.isLongVideo = getIntent().getBooleanExtra("isLongVideoPost", false);
    findViewById(b.f.select_cover_cancel).setOnClickListener((View.OnClickListener)new c(this));
    Object localObject1 = findViewById(b.f.select_cover_seekbar);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.select_cover_seekbar)");
    this.rBx = ((SeekBar)localObject1);
    localObject1 = findViewById(b.f.finder_crop_layout);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.AtZ = ((CropLayout)localObject1);
    localObject1 = findViewById(b.f.select_cover_ok);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.select_cover_ok)");
    this.Aua = ((View)localObject1);
    localObject1 = findViewById(b.f.long_video_cover_layout);
    kotlin.g.b.p.j(localObject1, "findViewById<View>(R.id.long_video_cover_layout)");
    this.Auh = ((View)localObject1);
    localObject1 = findViewById(b.f.crop_window_view);
    kotlin.g.b.p.j(localObject1, "findViewById<View>(R.id.crop_window_view)");
    this.Aui = ((View)localObject1);
    localObject1 = findViewById(b.f.content_layout);
    kotlin.g.b.p.j(localObject1, "findViewById<View>(R.id.content_layout)");
    this.Auj = ((View)localObject1);
    localObject1 = (com.tencent.mm.cd.a)new csf();
    Object localObject3 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (csf)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new csf();
      }
      this.mediaList.addAll((Collection)((csf)localObject1).mediaList);
      localObject3 = (csg)this.mediaList.getFirst();
      locale = new aa.e();
      locale.aaBB = (((csg)localObject3).videoDuration * 1000L);
      localObject1 = aj.AGc;
      if (aj.g((csg)localObject3))
      {
        localObject1 = (Context)this;
        kotlin.g.b.p.j(localObject3, "media");
        this.AtY = ((com.tencent.mm.plugin.finder.video.q)new com.tencent.mm.plugin.finder.video.f((Context)localObject1, (csg)localObject3));
        localObject1 = com.tencent.mm.plugin.sight.base.f.aYg(((csg)localObject3).url);
        if (localObject1 != null)
        {
          locale.aaBB = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration;
          localObject1 = com.tencent.mm.plugin.gallery.a.d.CeY;
          localObject1 = com.tencent.mm.plugin.gallery.a.d.aFG(((csg)localObject3).url);
          j = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
          i = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
          m = (int)eaO();
          k = (int)eaP();
          localObject1 = this.rBx;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("seekBar");
          }
          ((SeekBar)localObject1).setMax(Util.videoMsToSec(locale.aaBB) * 10);
          localObject1 = com.tencent.mm.plugin.finder.video.p.AOS;
          this.Aub = com.tencent.mm.plugin.finder.video.p.j((csg)localObject3);
          localObject1 = this.Aub;
          if (localObject1 != null)
          {
            ((c)localObject1).setSize(m, k);
            localObject1 = x.aazN;
          }
          f1 = 1.0F * ((csg)localObject3).height / ((csg)localObject3).width;
          localObject1 = this.AtZ;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("cropLayout");
          }
          ((CropLayout)localObject1).setEnableScale(false);
          localObject1 = this.AtZ;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("cropLayout");
          }
          ((CropLayout)localObject1).reset();
          if (!this.isLongVideo) {
            break label1991;
          }
          localObject1 = new RelativeLayout.LayoutParams(-1, -1);
          localObject4 = this.Auj;
          if (localObject4 == null) {
            kotlin.g.b.p.bGy("conentLayout");
          }
          ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = this.Auh;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("longVideoCoverLayout");
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = this.AtZ;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("cropLayout");
          }
          ((CropLayout)localObject1).setEnableTouch(true);
          localObject1 = this.AtZ;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("cropLayout");
          }
          ((CropLayout)localObject1).setEnableFling(true);
          localObject1 = this.AtZ;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("cropLayout");
          }
          ((CropLayout)localObject1).setEnableOverScroll(false);
          localObject1 = ((csg)localObject3).zBo;
          if (localObject1 != null)
          {
            localObject1 = ((css)localObject1).TAv;
            if (localObject1 != null)
            {
              if (((fbq)localObject1).left > 0)
              {
                localObject4 = this.AtZ;
                if (localObject4 == null) {
                  kotlin.g.b.p.bGy("cropLayout");
                }
                ((CropLayout)localObject4).setEnableTouch(false);
                localObject4 = this.AtZ;
                if (localObject4 == null) {
                  kotlin.g.b.p.bGy("cropLayout");
                }
                ((CropLayout)localObject4).setEnableFling(false);
              }
              k = Math.abs(((fbq)localObject1).bottom - ((fbq)localObject1).top);
              this.Auk = ((dpI().y - getResources().getDimensionPixelOffset(b.d.finder_long_video_cover_margin_top_offset) - k) / 2.0F);
              localObject4 = findViewById(b.f.crop_window_top_shadow);
              kotlin.g.b.p.j(localObject4, "shadowView");
              localObject5 = ((View)localObject4).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject5).height = ((int)this.Auk);
              ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              localObject4 = this.Aui;
              if (localObject4 == null) {
                kotlin.g.b.p.bGy("cropWindowView");
              }
              localObject4 = ((View)localObject4).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject4).height = k;
              localObject5 = this.Aui;
              if (localObject5 == null) {
                kotlin.g.b.p.bGy("cropWindowView");
              }
              ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              localObject4 = this.AtZ;
              if (localObject4 == null) {
                kotlin.g.b.p.bGy("cropLayout");
              }
              localObject4 = ((CropLayout)localObject4).getVisibilityRect();
              f1 = ((fbq)localObject1).left;
              float f2 = this.Auk;
              float f3 = ((fbq)localObject1).right;
              float f4 = this.Auk;
              ((RectF)localObject4).set(new RectF(f1, f2, f3, k + f4));
              localObject1 = x.aazN;
            }
          }
          localObject1 = ((csg)localObject3).zBo;
          if (localObject1 == null) {
            break label2132;
          }
          localObject1 = ((css)localObject1).TAw;
          if (localObject1 == null) {
            break label2144;
          }
          localObject1 = ((csg)localObject3).zBo;
          if (localObject1 == null) {
            break label2138;
          }
          localObject1 = ((css)localObject1).TAw;
          if ((localObject1 != null) && (((blk)localObject1).SWx.size() == 9))
          {
            localObject4 = new Matrix();
            localObject1 = ((blk)localObject1).SWx;
            kotlin.g.b.p.j(localObject1, "it.value");
            ((Matrix)localObject4).setValues(j.r((Collection)localObject1));
            localObject1 = new Matrix((Matrix)localObject4);
            if (this.isLongVideo) {
              ((Matrix)localObject1).postTranslate(0.0F, this.Auk);
            }
            localObject4 = this.AtZ;
            if (localObject4 == null) {
              kotlin.g.b.p.bGy("cropLayout");
            }
            localObject5 = this.AtY;
            if (localObject5 == null) {
              kotlin.g.b.p.bGy("seeker");
            }
            ((CropLayout)localObject4).a(((com.tencent.mm.plugin.finder.video.q)localObject5).getView(), j, i, new Matrix(), CropLayout.e.Ylv, (kotlin.g.a.b)new e((Matrix)localObject1));
          }
          localObject1 = this.rBx;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("seekBar");
          }
          ((SeekBar)localObject1).setVisibility(4);
          localObject1 = this.rBx;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("seekBar");
          }
          ((SeekBar)localObject1).setEnabled(false);
          localObject1 = this.Aua;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("selectBtn");
          }
          ((View)localObject1).setEnabled(false);
          i = dpI().x;
          localObject1 = getContext();
          kotlin.g.b.p.j(localObject1, "context");
          k = i - (int)((AppCompatActivity)localObject1).getResources().getDimension(b.d.Edge_4A);
          j = (int)Math.ceil(k / eaO());
          i = j;
          if (j < 2) {
            i = 2;
          }
          long l = locale.aaBB / (i - 1);
          localObject4 = (Iterable)kotlin.k.i.ou(0, i);
          localObject1 = (Collection)new LinkedList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject1).add(Long.valueOf(((ab)localObject4).zD() * l));
          }
        }
      }
    }
    catch (Exception localException)
    {
      final aa.e locale;
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
        localObject2 = ((csg)localObject3).TpG;
        if (localObject2 != null) {
          if (((acu)localObject2).NkX.SoK == null)
          {
            localObject4 = ((acu)localObject2).NkX.SoD;
            localObject5 = ((csg)localObject3).TAa;
            if (localObject5 != null)
            {
              ((duz)localObject4).TDA.set(0, Integer.valueOf((int)((awc)localObject5).left));
              ((duz)localObject4).TDA.set(1, Integer.valueOf((int)((awc)localObject5).top));
              ((duz)localObject4).TDA.set(2, Integer.valueOf((int)((awc)localObject5).right));
              ((duz)localObject4).TDA.set(3, Integer.valueOf((int)((awc)localObject5).bottom));
            }
            localObject5 = ((duz)localObject4).TDA.get(0);
            kotlin.g.b.p.j(localObject5, "originRect.values[0]");
            i = ((Number)localObject5).intValue();
            localObject5 = ((duz)localObject4).TDA.get(1);
            kotlin.g.b.p.j(localObject5, "originRect.values[1]");
            j = ((Number)localObject5).intValue();
            localObject5 = ((duz)localObject4).TDA.get(2);
            kotlin.g.b.p.j(localObject5, "originRect.values[2]");
            k = ((Number)localObject5).intValue();
            localObject4 = ((duz)localObject4).TDA.get(3);
            kotlin.g.b.p.j(localObject4, "originRect.values[3]");
            localObject4 = new Rect(i, j, k, ((Number)localObject4).intValue());
            locale.aaBB = (((acu)localObject2).Sow - ((acu)localObject2).Sov);
            localObject2 = ((acu)localObject2).NkX;
            if (localObject2 != null)
            {
              i = ((acv)localObject2).targetWidth;
              label1710:
              j = ((Rect)localObject4).height() * i / ((Rect)localObject4).width();
              ((csg)localObject3).height = (((csg)localObject3).width * ((Rect)localObject4).height() / ((Rect)localObject4).width());
              localObject2 = x.aazN;
              k = i;
              i = j;
            }
          }
        }
        for (int j = k;; j = 0)
        {
          localObject2 = (Context)this;
          kotlin.g.b.p.j(localObject3, "media");
          this.AtY = ((com.tencent.mm.plugin.finder.video.q)new com.tencent.mm.plugin.finder.video.b((Context)localObject2, (csg)localObject3));
          f1 = Math.max(eaO() / j, eaP() / i);
          m = (int)(j * f1);
          k = (int)(f1 * i);
          break;
          i = 0;
          break label1710;
          localObject4 = new Rect();
          localObject5 = ((acu)localObject2).NkX.SoK.Sro;
          kotlin.g.b.p.j(localObject5, "compositionInfo.outputConfig.cropConfig.cropRect");
          com.tencent.mm.plugin.vlog.model.i.a((duz)localObject5, (Rect)localObject4);
          localObject5 = x.aazN;
          locale.aaBB = (((acu)localObject2).Sow - ((acu)localObject2).Sov);
          localObject2 = ((acu)localObject2).NkX;
          if (localObject2 != null)
          {
            localObject2 = ((acv)localObject2).SoK;
            if (localObject2 == null) {}
          }
          for (i = ((dhd)localObject2).targetWidth;; i = 0)
          {
            j = ((Rect)localObject4).height() * i / ((Rect)localObject4).width();
            ((csg)localObject3).height = (((csg)localObject3).width * ((Rect)localObject4).height() / ((Rect)localObject4).width());
            break;
          }
          i = 0;
        }
        label1991:
        localObject2 = this.AtZ;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("cropLayout");
        }
        localObject2 = ((CropLayout)localObject2).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = dpI().x;
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(f1 * ((ViewGroup.LayoutParams)localObject2).width));
        localObject4 = this.AtZ;
        if (localObject4 == null) {
          kotlin.g.b.p.bGy("cropLayout");
        }
        ((CropLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.AtZ;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("cropLayout");
        }
        ((CropLayout)localObject2).setEnableTouch(false);
        localObject2 = this.AtZ;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("cropLayout");
        }
        ((CropLayout)localObject2).setEnableFling(false);
        localObject2 = this.AtZ;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("cropLayout");
        }
        ((CropLayout)localObject2).setEnableOverScroll(false);
        continue;
        label2132:
        localObject2 = null;
        continue;
        label2138:
        localObject2 = null;
        continue;
        label2144:
        localObject2 = this.AtZ;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("cropLayout");
        }
        localObject4 = this.AtY;
        if (localObject4 == null) {
          kotlin.g.b.p.bGy("seeker");
        }
        ((CropLayout)localObject2).a(((com.tencent.mm.plugin.finder.video.q)localObject4).getView(), j, i, new Matrix(), CropLayout.e.Ylv, (kotlin.g.a.b)f.Auq);
      }
      Object localObject2 = (LinkedList)localObject2;
      Object localObject4 = Bitmap.createBitmap(k, (int)eaP(), Bitmap.Config.ARGB_8888);
      Object localObject5 = new Canvas((Bitmap)localObject4);
      c localc = this.Aub;
      if (localc != null)
      {
        localc.b((List)localObject2, (m)new g(this, (LinkedList)localObject2, (csg)localObject3, (Canvas)localObject5, (Bitmap)localObject4));
        localObject2 = x.aazN;
      }
      localObject2 = this.AtY;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("seeker");
      }
      ((com.tencent.mm.plugin.finder.video.q)localObject2).a((kotlin.g.a.a)new h(this, locale, (csg)localObject3), (kotlin.g.a.a)new i(this), (kotlin.g.a.b)new j(this, (csg)localObject3));
      localObject2 = this.Aua;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("selectBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new d(this, (csg)localObject3));
      AppMethodBeat.o(283609);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(283608);
    setTheme(b.k.MMTheme_NoTitleTranslucent);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    kotlin.g.b.p.j(paramBundle, "window");
    paramBundle.setStatusBarColor(-16777216);
    updataStatusBarIcon(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    initView();
    AppMethodBeat.o(283608);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(283611);
    super.onDestroy();
    Object localObject = this.AtY;
    if (localObject == null) {
      kotlin.g.b.p.bGy("seeker");
    }
    ((com.tencent.mm.plugin.finder.video.q)localObject).destroy();
    localObject = this.Aub;
    if (localObject != null)
    {
      ((c)localObject).destroy();
      AppMethodBeat.o(283611);
      return;
    }
    AppMethodBeat.o(283611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Float>
  {
    a(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Float>
  {
    b(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274856);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Aun.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274856);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSelectCoverUI paramFinderSelectCoverUI, csg paramcsg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(276984);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      int j;
      Object localObject2;
      Bitmap localBitmap;
      fbq localfbq;
      label310:
      label358:
      boolean bool;
      int k;
      if (FinderSelectCoverUI.d(this.Aun).isEnabled())
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        i = com.tencent.mm.plugin.finder.storage.d.dRJ().lJy;
        j = (int)(i / this.Auo.width * this.Auo.height);
        Log.i(FinderSelectCoverUI.g(this.Aun), "save cover, size: " + i + ", " + j);
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localObject2 = new Canvas((Bitmap)localObject1);
        localBitmap = FinderSelectCoverUI.e(this.Aun).getBitmap();
        if (localBitmap == null)
        {
          this.Aun.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276984);
          return;
        }
        if (!this.Auo.TzU) {
          break label579;
        }
        paramView = this.Auo.zBo;
        float f1 = FinderSelectCoverUI.h(this.Aun).getContentViewScale()[0];
        float f2 = -(FinderSelectCoverUI.h(this.Aun).getContentViewTrans()[1] - FinderSelectCoverUI.i(this.Aun));
        localfbq = new fbq();
        if (paramView == null) {
          break label547;
        }
        paramView = paramView.TAx;
        if (paramView == null) {
          break label552;
        }
        localfbq.left = paramView.left;
        localfbq.right = paramView.right;
        localfbq.top = ((int)(paramView.top - paramView.bottom + f2 / f1));
        localfbq.bottom = ((int)(f2 / f1));
        ((Canvas)localObject2).drawBitmap(localBitmap, new Rect(localfbq.left, localfbq.bottom, localfbq.right, localfbq.top), new Rect(0, 0, i, j), null);
        paramView = new StringBuilder();
        localObject2 = av.AJz;
        paramView = av.egu() + "cover_" + System.currentTimeMillis();
        localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
        bool = BitmapUtil.saveBitmapToImage((Bitmap)localObject1, com.tencent.mm.plugin.finder.storage.d.dSm(), Bitmap.CompressFormat.JPEG, paramView, false);
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dVd()) {
          break label622;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        k = com.tencent.mm.plugin.finder.storage.d.dRM();
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      }
      label547:
      label552:
      label579:
      label622:
      for (int i = AdaptiveAdjustBitrate.getVideoImageQuality(k, 0, i, j, com.tencent.mm.plugin.finder.storage.d.dSm() / 100.0F);; i = 0)
      {
        localObject1 = new Intent();
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.f.Bub;
          ((Intent)localObject1).putExtra(com.tencent.mm.plugin.finder.widget.post.f.emJ(), paramView);
          paramView = com.tencent.mm.plugin.finder.widget.post.f.Bub;
          ((Intent)localObject1).putExtra(com.tencent.mm.plugin.finder.widget.post.f.emK(), i);
          FinderSelectCoverUI.a(this.Aun, (Intent)localObject1);
        }
        this.Aun.setResult(0, (Intent)localObject1);
        this.Aun.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276984);
        return;
        paramView = null;
        break;
        localfbq.left = 0;
        localfbq.right = 0;
        localfbq.top = 0;
        localfbq.bottom = 0;
        break label310;
        ((Canvas)localObject2).drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new Rect(0, 0, i, j), null);
        break label358;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    e(Matrix paramMatrix)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    public static final f Auq;
    
    static
    {
      AppMethodBeat.i(271059);
      Auq = new f();
      AppMethodBeat.o(271059);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements m<Long, Bitmap, x>
  {
    g(FinderSelectCoverUI paramFinderSelectCoverUI, LinkedList paramLinkedList, csg paramcsg, Canvas paramCanvas, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(FinderSelectCoverUI paramFinderSelectCoverUI, aa.e parame, csg paramcsg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, x>
  {
    j(FinderSelectCoverUI paramFinderSelectCoverUI, csg paramcsg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(276580);
      this.Aun.finish();
      AppMethodBeat.o(276580);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(289255);
      if (this.Aun.Aul)
      {
        localObject = FinderSelectCoverUI.c(this.Aun);
        Resources localResources = this.Aun.getResources();
        Bitmap localBitmap = this.Aun.Aud;
        if (localBitmap == null) {
          kotlin.g.b.p.bGy("thumbBitmap");
        }
        ((SeekBar)localObject).setThumb((Drawable)new BitmapDrawable(localResources, localBitmap));
        FinderSelectCoverUI.c(this.Aun).setThumbOffset(0);
        this.Aun.Aul = false;
        AppMethodBeat.o(289255);
        return;
      }
      Object localObject = FinderSelectCoverUI.c(this.Aun).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).invalidateSelf();
        AppMethodBeat.o(289255);
        return;
      }
      AppMethodBeat.o(289255);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Point>
  {
    public static final m AuB;
    
    static
    {
      AppMethodBeat.i(283438);
      AuB = new m();
      AppMethodBeat.o(283438);
    }
    
    m()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI
 * JD-Core Version:    0.7.0.1
 */