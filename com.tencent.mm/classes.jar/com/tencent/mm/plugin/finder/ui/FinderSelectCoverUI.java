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
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.video.n;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import d.a.ab;
import d.a.j;
import d.g;
import d.g.b.u;
import d.g.b.v.d;
import d.g.b.w;
import d.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "Landroid/view/View;", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder_release"})
public final class FinderSelectCoverUI
  extends MMFinderUI
{
  private n KYZ;
  private View KZa;
  private com.tencent.mm.plugin.vlog.ui.thumb.c KZb;
  private Canvas KZc;
  public Bitmap KZd;
  public Paint KZe;
  private final d.f KZf;
  private final d.f KZg;
  boolean KZh;
  boolean KZi;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final LinkedList<bmd> mediaList;
  private SeekBar mhD;
  private CropLayout qTx;
  
  static
  {
    AppMethodBeat.i(199350);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderSelectCoverUI.class), "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH()F")), (d.l.k)w.a(new u(w.bk(FinderSelectCoverUI.class), "SEEKBAR_THUMB_HEIGHT", "getSEEKBAR_THUMB_HEIGHT()F")) };
    AppMethodBeat.o(199350);
  }
  
  public FinderSelectCoverUI()
  {
    AppMethodBeat.i(199357);
    this.TAG = "Finder.FinderSelectCoverUI";
    this.mediaList = new LinkedList();
    this.KZf = g.E((d.g.a.a)new b(this));
    this.KZg = g.E((d.g.a.a)new a(this));
    this.KZh = true;
    this.KZi = true;
    AppMethodBeat.o(199357);
  }
  
  private static Rect c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    AppMethodBeat.i(199355);
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
      AppMethodBeat.o(199355);
      return localRect;
      f1 = paramInt5 / j;
      f2 = (k * f1 - paramInt6) * 0.5F;
      f3 = 0.0F;
      break;
    }
  }
  
  private final float fVC()
  {
    AppMethodBeat.i(199351);
    float f = ((Number)this.KZf.getValue()).floatValue();
    AppMethodBeat.o(199351);
    return f;
  }
  
  private final float fVD()
  {
    AppMethodBeat.i(199352);
    float f = ((Number)this.KZg.getValue()).floatValue();
    AppMethodBeat.o(199352);
    return f;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199365);
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
    AppMethodBeat.o(199365);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496250;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(199354);
    super.initView();
    findViewById(2131307856).setOnClickListener((View.OnClickListener)new c(this));
    Object localObject1 = findViewById(2131307859);
    d.g.b.k.g(localObject1, "findViewById(R.id.select_cover_seekbar)");
    this.mhD = ((SeekBar)localObject1);
    localObject1 = findViewById(2131299987);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.qTx = ((CropLayout)localObject1);
    localObject1 = findViewById(2131307858);
    d.g.b.k.g(localObject1, "findViewById(R.id.select_cover_ok)");
    this.KZa = ((View)localObject1);
    localObject1 = (com.tencent.mm.bx.a)new bmc();
    Object localObject4 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
      localObject4 = (bmc)localObject1;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = new bmc();
      }
      this.mediaList.addAll((Collection)((bmc)localObject1).mediaList);
      localObject4 = (bmd)this.mediaList.getFirst();
      locald = new v.d();
      locald.Jhv = (((bmd)localObject4).videoDuration * 1000L);
      localObject1 = i.qTa;
      if (i.c((bmd)localObject4))
      {
        localObject1 = (Context)this;
        d.g.b.k.g(localObject4, "media");
        this.KYZ = ((n)new com.tencent.mm.plugin.finder.video.h((Context)localObject1, (bmd)localObject4));
        localObject1 = com.tencent.mm.plugin.sight.base.e.ano(((bmd)localObject4).url);
        if (localObject1 != null)
        {
          locald.Jhv = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.rMg;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.ZP(((bmd)localObject4).url);
          k = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
          m = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
          j = (int)fVC();
          i = (int)fVD();
          localObject1 = this.mhD;
          if (localObject1 == null) {
            d.g.b.k.aPZ("seekBar");
          }
          ((SeekBar)localObject1).setMax(bt.vN(locald.Jhv) * 10);
          localObject1 = com.tencent.mm.plugin.finder.video.m.LcV;
          this.KZb = com.tencent.mm.plugin.finder.video.m.a((bmd)localObject4, j, i);
          localObject1 = this.KZb;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.vlog.ui.thumb.c)localObject1).setSize(j, i);
          }
          f = 1.0F * ((bmd)localObject4).height / ((bmd)localObject4).width;
          fVC();
          fVC();
          localObject1 = this.qTx;
          if (localObject1 == null) {
            d.g.b.k.aPZ("cropLayout");
          }
          localObject1 = ((CropLayout)localObject1).getLayoutParams();
          localObject5 = getContext();
          d.g.b.k.g(localObject5, "context");
          localObject5 = ((AppCompatActivity)localObject5).getResources();
          d.g.b.k.g(localObject5, "context.resources");
          ((ViewGroup.LayoutParams)localObject1).width = ((Resources)localObject5).getDisplayMetrics().widthPixels;
          ((ViewGroup.LayoutParams)localObject1).height = ((int)(f * ((ViewGroup.LayoutParams)localObject1).width));
          localObject5 = this.qTx;
          if (localObject5 == null) {
            d.g.b.k.aPZ("cropLayout");
          }
          ((CropLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = this.qTx;
          if (localObject1 == null) {
            d.g.b.k.aPZ("cropLayout");
          }
          ((CropLayout)localObject1).setEnableTouch(false);
          localObject1 = this.qTx;
          if (localObject1 == null) {
            d.g.b.k.aPZ("cropLayout");
          }
          ((CropLayout)localObject1).setEnableScale(false);
          localObject1 = this.qTx;
          if (localObject1 == null) {
            d.g.b.k.aPZ("cropLayout");
          }
          ((CropLayout)localObject1).setEnableFling(false);
          localObject1 = this.qTx;
          if (localObject1 == null) {
            d.g.b.k.aPZ("cropLayout");
          }
          ((CropLayout)localObject1).setEnableOverScroll(false);
          localObject1 = this.qTx;
          if (localObject1 == null) {
            d.g.b.k.aPZ("cropLayout");
          }
          ((CropLayout)localObject1).reset();
          localObject5 = ((bmd)localObject4).qDR;
          localObject1 = localObject3;
          if (localObject5 != null) {
            localObject1 = ((bmm)localObject5).DJV;
          }
          if (localObject1 == null) {
            break label1207;
          }
          localObject3 = ((bmd)localObject4).qDR.DJV;
          if (((alw)localObject3).DmV.size() == 9)
          {
            localObject1 = new Matrix();
            localObject3 = ((alw)localObject3).DmV;
            d.g.b.k.g(localObject3, "it.value");
            ((Matrix)localObject1).setValues(j.o((Collection)localObject3));
            localObject1 = new Matrix((Matrix)localObject1);
            localObject3 = this.qTx;
            if (localObject3 == null) {
              d.g.b.k.aPZ("cropLayout");
            }
            localObject5 = this.KYZ;
            if (localObject5 == null) {
              d.g.b.k.aPZ("seeker");
            }
            ((CropLayout)localObject3).a(((n)localObject5).getView(), k, m, new Matrix(), CropLayout.c.HDI, (d.g.a.b)new d((Matrix)localObject1));
          }
          localObject1 = this.mhD;
          if (localObject1 == null) {
            d.g.b.k.aPZ("seekBar");
          }
          ((SeekBar)localObject1).setVisibility(4);
          localObject1 = this.mhD;
          if (localObject1 == null) {
            d.g.b.k.aPZ("seekBar");
          }
          ((SeekBar)localObject1).setEnabled(false);
          localObject1 = this.KZa;
          if (localObject1 == null) {
            d.g.b.k.aPZ("selectBtn");
          }
          ((View)localObject1).setEnabled(false);
          localObject1 = getContext();
          d.g.b.k.g(localObject1, "context");
          localObject1 = ((AppCompatActivity)localObject1).getResources();
          d.g.b.k.g(localObject1, "context.resources");
          i = ((Resources)localObject1).getDisplayMetrics().widthPixels;
          localObject1 = getContext();
          d.g.b.k.g(localObject1, "context");
          k = i - (int)((AppCompatActivity)localObject1).getResources().getDimension(2131165294);
          j = (int)Math.ceil(k / fVC());
          i = j;
          if (j < 2) {
            i = 2;
          }
          long l = locald.Jhv / (i - 1);
          localObject3 = (Iterable)d.k.h.kJ(0, i);
          localObject1 = (Collection)new LinkedList();
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(Long.valueOf(((ab)localObject3).nextInt() * l));
          }
        }
      }
    }
    catch (Exception localException)
    {
      final v.d locald;
      int k;
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        localObject2 = null;
        continue;
        ad.w(this.TAG, "initView: mediaInfo null");
        continue;
        localObject2 = (Context)this;
        d.g.b.k.g(localObject4, "media");
        this.KYZ = ((n)new com.tencent.mm.plugin.finder.video.e((Context)localObject2, (bmd)localObject4));
        locald.Jhv = (((bmd)localObject4).LzL.LwU - ((bmd)localObject4).LzL.LwT);
        k = ((bmd)localObject4).LzL.Lqd.gnh;
        int m = ((bmd)localObject4).LzL.Lqd.gni;
        float f = Math.max(fVC() / k, fVD() / m);
        int j = (int)(k * f);
        int i = (int)(f * m);
        continue;
        label1207:
        localObject2 = this.qTx;
        if (localObject2 == null) {
          d.g.b.k.aPZ("cropLayout");
        }
        localObject3 = this.KYZ;
        if (localObject3 == null) {
          d.g.b.k.aPZ("seeker");
        }
        ((CropLayout)localObject2).a(((n)localObject3).getView(), k, m, new Matrix(), CropLayout.c.HDI, (d.g.a.b)e.KZk);
      }
      Object localObject2 = (LinkedList)localObject2;
      localObject3 = this.KZb;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.vlog.ui.thumb.c)localObject3).init();
      }
      localObject3 = Bitmap.createBitmap(k, (int)fVD(), Bitmap.Config.ARGB_8888);
      Object localObject5 = new Canvas((Bitmap)localObject3);
      com.tencent.mm.plugin.vlog.ui.thumb.c localc = this.KZb;
      if (localc != null) {
        localc.b((List)localObject2, (d.g.a.m)new f(this, (LinkedList)localObject2, (bmd)localObject4, (Canvas)localObject5, (Bitmap)localObject3));
      }
      localObject2 = this.KYZ;
      if (localObject2 == null) {
        d.g.b.k.aPZ("seeker");
      }
      ((n)localObject2).a((d.g.a.a)new g(this, locald, (bmd)localObject4), (d.g.a.a)new h(this), (d.g.a.b)new i(this, (bmd)localObject4));
      localObject2 = this.KZa;
      if (localObject2 == null) {
        d.g.b.k.aPZ("selectBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new j(this, (bmd)localObject4));
      AppMethodBeat.o(199354);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199353);
    setTheme(2131821149);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    initView();
    AppMethodBeat.o(199353);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199356);
    super.onDestroy();
    Object localObject = this.KYZ;
    if (localObject == null) {
      d.g.b.k.aPZ("seeker");
    }
    ((n)localObject).destroy();
    localObject = this.KZb;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.vlog.ui.thumb.c)localObject).destroy();
      AppMethodBeat.o(199356);
      return;
    }
    AppMethodBeat.o(199356);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Float>
  {
    a(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Float>
  {
    b(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199333);
      this.KZj.finish();
      AppMethodBeat.o(199333);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Matrix, Boolean>
  {
    d(Matrix paramMatrix)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Matrix, Boolean>
  {
    public static final e KZk;
    
    static
    {
      AppMethodBeat.i(199336);
      KZk = new e();
      AppMethodBeat.o(199336);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.m<Long, Bitmap, y>
  {
    f(FinderSelectCoverUI paramFinderSelectCoverUI, LinkedList paramLinkedList, bmd parambmd, Canvas paramCanvas, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(FinderSelectCoverUI paramFinderSelectCoverUI, v.d paramd, bmd parambmd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    i(FinderSelectCoverUI paramFinderSelectCoverUI, bmd parambmd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderSelectCoverUI paramFinderSelectCoverUI, bmd parambmd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199347);
      int i;
      int j;
      Object localObject1;
      Object localObject2;
      if (FinderSelectCoverUI.d(this.KZj).isEnabled())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        i = com.tencent.mm.plugin.finder.storage.b.coC().hci;
        j = (int)(i / this.KZm.width * this.KZm.height);
        ad.i(FinderSelectCoverUI.g(this.KZj), "save cover, size: " + i + ", " + j);
        paramView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(paramView);
        localObject2 = FinderSelectCoverUI.e(this.KZj).getBitmap();
        if (localObject2 == null)
        {
          this.KZj.finish();
          AppMethodBeat.o(199347);
          return;
        }
        if (!this.KZm.DJD) {
          break label320;
        }
        bmm localbmm = this.KZm.qDR;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(localbmm.DJW.left, localbmm.DJW.bottom, localbmm.DJW.right, localbmm.DJW.top), new Rect(0, 0, i, j), null);
      }
      for (;;)
      {
        localObject1 = new StringBuilder();
        localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
        localObject1 = com.tencent.mm.plugin.finder.utils.k.csc() + "cover_" + System.currentTimeMillis();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
        boolean bool = com.tencent.mm.sdk.platformtools.f.a(paramView, com.tencent.mm.plugin.finder.storage.b.fUb(), Bitmap.CompressFormat.JPEG, (String)localObject1, false);
        paramView = new Intent();
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.f.raH;
          paramView.putExtra(com.tencent.mm.plugin.finder.widget.post.f.fXO(), (String)localObject1);
        }
        this.KZj.setResult(0, paramView);
        this.KZj.finish();
        AppMethodBeat.o(199347);
        return;
        label320:
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()), new Rect(0, 0, i, j), null);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199348);
      this.KZj.finish();
      AppMethodBeat.o(199348);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(199349);
      if (this.KZj.KZh)
      {
        localObject = FinderSelectCoverUI.c(this.KZj);
        Resources localResources = this.KZj.getResources();
        Bitmap localBitmap = this.KZj.KZd;
        if (localBitmap == null) {
          d.g.b.k.aPZ("thumbBitmap");
        }
        ((SeekBar)localObject).setThumb((Drawable)new BitmapDrawable(localResources, localBitmap));
        FinderSelectCoverUI.c(this.KZj).setThumbOffset(0);
        this.KZj.KZh = false;
        AppMethodBeat.o(199349);
        return;
      }
      Object localObject = FinderSelectCoverUI.c(this.KZj).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).invalidateSelf();
        AppMethodBeat.o(199349);
        return;
      }
      AppMethodBeat.o(199349);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI
 * JD-Core Version:    0.7.0.1
 */