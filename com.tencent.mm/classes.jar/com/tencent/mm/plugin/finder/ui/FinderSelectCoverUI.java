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
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.video.n;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.a.ab;
import d.f;
import d.g.b.q;
import d.g.b.y.e;
import d.l;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "Landroid/view/View;", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder_release"})
public final class FinderSelectCoverUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final LinkedList<bvz> mediaList;
  private SeekBar npi;
  private final f sQA;
  private final f sQB;
  boolean sQC;
  boolean sQD;
  private n sQt;
  private CropLayout sQu;
  private View sQv;
  private com.tencent.mm.videocomposition.c sQw;
  private Canvas sQx;
  public Bitmap sQy;
  public Paint sQz;
  
  public FinderSelectCoverUI()
  {
    AppMethodBeat.i(204726);
    this.TAG = "Finder.FinderSelectCoverUI";
    this.mediaList = new LinkedList();
    this.sQA = d.g.O((d.g.a.a)new b(this));
    this.sQB = d.g.O((d.g.a.a)new a(this));
    this.sQC = true;
    this.sQD = true;
    AppMethodBeat.o(204726);
  }
  
  private static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    AppMethodBeat.i(204724);
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
      AppMethodBeat.o(204724);
      return localRect;
      f1 = paramInt5 / j;
      f2 = (k * f1 - paramInt6) * 0.5F;
      f3 = 0.0F;
      break;
    }
  }
  
  private final float cMJ()
  {
    AppMethodBeat.i(204720);
    float f = ((Number)this.sQA.getValue()).floatValue();
    AppMethodBeat.o(204720);
    return f;
  }
  
  private final float cMK()
  {
    AppMethodBeat.i(204721);
    float f = ((Number)this.sQB.getValue()).floatValue();
    AppMethodBeat.o(204721);
    return f;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204734);
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
    AppMethodBeat.o(204734);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496251;
  }
  
  public final void initView()
  {
    long l2 = 0L;
    Object localObject3 = null;
    AppMethodBeat.i(204723);
    super.initView();
    findViewById(2131307964).setOnClickListener((View.OnClickListener)new c(this));
    Object localObject1 = findViewById(2131307967);
    d.g.b.p.g(localObject1, "findViewById(R.id.select_cover_seekbar)");
    this.npi = ((SeekBar)localObject1);
    localObject1 = findViewById(2131299987);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.sQu = ((CropLayout)localObject1);
    localObject1 = findViewById(2131307966);
    d.g.b.p.g(localObject1, "findViewById(R.id.select_cover_ok)");
    this.sQv = ((View)localObject1);
    localObject1 = (com.tencent.mm.bw.a)new bvy();
    Object localObject4 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
      localObject4 = (bvy)localObject1;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = new bvy();
      }
      this.mediaList.addAll((Collection)((bvy)localObject1).mediaList);
      localObject4 = (bvz)this.mediaList.getFirst();
      locale = new y.e();
      locale.NiX = (((bvz)localObject4).videoDuration * 1000L);
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (com.tencent.mm.plugin.finder.utils.p.d((bvz)localObject4))
      {
        localObject1 = (Context)this;
        d.g.b.p.g(localObject4, "media");
        this.sQt = ((n)new com.tencent.mm.plugin.finder.video.e((Context)localObject1, (bvz)localObject4));
        localObject1 = com.tencent.mm.plugin.sight.base.e.ayN(((bvz)localObject4).url);
        if (localObject1 != null)
        {
          locale.NiX = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.ubl;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.ajS(((bvz)localObject4).url);
          i = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
          j = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
          m = (int)cMJ();
          k = (int)cMK();
          localObject1 = this.npi;
          if (localObject1 == null) {
            d.g.b.p.bdF("seekBar");
          }
          ((SeekBar)localObject1).setMax(bu.DE(locale.NiX) * 10);
          localObject1 = com.tencent.mm.plugin.finder.video.m.tbn;
          this.sQw = com.tencent.mm.plugin.finder.video.m.f((bvz)localObject4);
          localObject1 = this.sQw;
          if (localObject1 != null)
          {
            ((com.tencent.mm.videocomposition.c)localObject1).setSize(m, k);
            localObject1 = z.Nhr;
          }
          f = 1.0F * ((bvz)localObject4).height / ((bvz)localObject4).width;
          cMJ();
          cMJ();
          localObject1 = this.sQu;
          if (localObject1 == null) {
            d.g.b.p.bdF("cropLayout");
          }
          localObject1 = ((CropLayout)localObject1).getLayoutParams();
          localObject5 = getContext();
          d.g.b.p.g(localObject5, "context");
          localObject5 = ((AppCompatActivity)localObject5).getResources();
          d.g.b.p.g(localObject5, "context.resources");
          ((ViewGroup.LayoutParams)localObject1).width = ((Resources)localObject5).getDisplayMetrics().widthPixels;
          ((ViewGroup.LayoutParams)localObject1).height = ((int)(f * ((ViewGroup.LayoutParams)localObject1).width));
          localObject5 = this.sQu;
          if (localObject5 == null) {
            d.g.b.p.bdF("cropLayout");
          }
          ((CropLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = this.sQu;
          if (localObject1 == null) {
            d.g.b.p.bdF("cropLayout");
          }
          ((CropLayout)localObject1).setEnableTouch(false);
          localObject1 = this.sQu;
          if (localObject1 == null) {
            d.g.b.p.bdF("cropLayout");
          }
          ((CropLayout)localObject1).setEnableScale(false);
          localObject1 = this.sQu;
          if (localObject1 == null) {
            d.g.b.p.bdF("cropLayout");
          }
          ((CropLayout)localObject1).setEnableFling(false);
          localObject1 = this.sQu;
          if (localObject1 == null) {
            d.g.b.p.bdF("cropLayout");
          }
          ((CropLayout)localObject1).setEnableOverScroll(false);
          localObject1 = this.sQu;
          if (localObject1 == null) {
            d.g.b.p.bdF("cropLayout");
          }
          ((CropLayout)localObject1).reset();
          localObject1 = ((bvz)localObject4).stz;
          if (localObject1 == null) {
            break label1301;
          }
          localObject1 = ((bwj)localObject1).Hjo;
          if (localObject1 == null) {
            break label1307;
          }
          localObject5 = ((bvz)localObject4).stz;
          localObject1 = localObject3;
          if (localObject5 != null) {
            localObject1 = ((bwj)localObject5).Hjo;
          }
          if ((localObject1 != null) && (((atk)localObject1).GKl.size() == 9))
          {
            localObject3 = new Matrix();
            localObject1 = ((atk)localObject1).GKl;
            d.g.b.p.g(localObject1, "it.value");
            ((Matrix)localObject3).setValues(d.a.j.q((Collection)localObject1));
            localObject1 = new Matrix((Matrix)localObject3);
            localObject3 = this.sQu;
            if (localObject3 == null) {
              d.g.b.p.bdF("cropLayout");
            }
            localObject5 = this.sQt;
            if (localObject5 == null) {
              d.g.b.p.bdF("seeker");
            }
            ((CropLayout)localObject3).a(((n)localObject5).getView(), i, j, new Matrix(), CropLayout.e.LrL, (d.g.a.b)new FinderSelectCoverUI.d((Matrix)localObject1));
          }
          localObject1 = this.npi;
          if (localObject1 == null) {
            d.g.b.p.bdF("seekBar");
          }
          ((SeekBar)localObject1).setVisibility(4);
          localObject1 = this.npi;
          if (localObject1 == null) {
            d.g.b.p.bdF("seekBar");
          }
          ((SeekBar)localObject1).setEnabled(false);
          localObject1 = this.sQv;
          if (localObject1 == null) {
            d.g.b.p.bdF("selectBtn");
          }
          ((View)localObject1).setEnabled(false);
          localObject1 = getContext();
          d.g.b.p.g(localObject1, "context");
          localObject1 = ((AppCompatActivity)localObject1).getResources();
          d.g.b.p.g(localObject1, "context.resources");
          i = ((Resources)localObject1).getDisplayMetrics().widthPixels;
          localObject1 = getContext();
          d.g.b.p.g(localObject1, "context");
          k = i - (int)((AppCompatActivity)localObject1).getResources().getDimension(2131165294);
          j = (int)Math.ceil(k / cMJ());
          i = j;
          if (j < 2) {
            i = 2;
          }
          l1 = locale.NiX / (i - 1);
          localObject3 = (Iterable)d.k.j.lv(0, i);
          localObject1 = (Collection)new LinkedList();
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(Long.valueOf(((ab)localObject3).nextInt() * l1));
          }
        }
      }
    }
    catch (Exception localException)
    {
      final y.e locale;
      int k;
      for (;;)
      {
        int i;
        int m;
        float f;
        long l1;
        ae.l("safeParser", "", new Object[] { localException });
        localObject2 = null;
        continue;
        ae.w(this.TAG, "initView: mediaInfo null");
        continue;
        localObject2 = (Context)this;
        d.g.b.p.g(localObject4, "media");
        this.sQt = ((n)new com.tencent.mm.plugin.finder.video.b((Context)localObject2, (bvz)localObject4));
        localObject2 = ((bvz)localObject4).HiW;
        if (localObject2 != null)
        {
          l1 = ((aaq)localObject2).GrW;
          label1161:
          localObject2 = ((bvz)localObject4).HiW;
          if (localObject2 != null) {
            l2 = ((aaq)localObject2).GrV;
          }
          locale.NiX = (l1 - l2);
          localObject2 = ((bvz)localObject4).HiW;
          if (localObject2 == null) {
            break label1291;
          }
          localObject2 = ((aaq)localObject2).BWx;
          if (localObject2 == null) {
            break label1291;
          }
          i = ((aar)localObject2).targetWidth;
          label1220:
          localObject2 = ((bvz)localObject4).HiW;
          if (localObject2 == null) {
            break label1296;
          }
          localObject2 = ((aaq)localObject2).BWx;
          if (localObject2 == null) {
            break label1296;
          }
        }
        label1291:
        label1296:
        for (int j = ((aar)localObject2).targetHeight;; j = 0)
        {
          f = Math.max(cMJ() / i, cMK() / j);
          m = (int)(i * f);
          k = (int)(f * j);
          break;
          l1 = 0L;
          break label1161;
          i = 0;
          break label1220;
        }
        label1301:
        localObject2 = null;
        continue;
        label1307:
        localObject2 = this.sQu;
        if (localObject2 == null) {
          d.g.b.p.bdF("cropLayout");
        }
        localObject3 = this.sQt;
        if (localObject3 == null) {
          d.g.b.p.bdF("seeker");
        }
        ((CropLayout)localObject2).a(((n)localObject3).getView(), i, j, new Matrix(), CropLayout.e.LrL, (d.g.a.b)FinderSelectCoverUI.e.sQG);
      }
      Object localObject2 = (LinkedList)localObject2;
      localObject3 = Bitmap.createBitmap(k, (int)cMK(), Bitmap.Config.ARGB_8888);
      Object localObject5 = new Canvas((Bitmap)localObject3);
      com.tencent.mm.videocomposition.c localc = this.sQw;
      if (localc != null)
      {
        localc.b((List)localObject2, (d.g.a.m)new f(this, (LinkedList)localObject2, (bvz)localObject4, (Canvas)localObject5, (Bitmap)localObject3));
        localObject2 = z.Nhr;
      }
      localObject2 = this.sQt;
      if (localObject2 == null) {
        d.g.b.p.bdF("seeker");
      }
      ((n)localObject2).a((d.g.a.a)new g(this, locale, (bvz)localObject4), (d.g.a.a)new h(this), (d.g.a.b)new i(this, (bvz)localObject4));
      localObject2 = this.sQv;
      if (localObject2 == null) {
        d.g.b.p.bdF("selectBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new j(this, (bvz)localObject4));
      AppMethodBeat.o(204723);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204722);
    setTheme(2131821149);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    initView();
    AppMethodBeat.o(204722);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204725);
    super.onDestroy();
    Object localObject = this.sQt;
    if (localObject == null) {
      d.g.b.p.bdF("seeker");
    }
    ((n)localObject).destroy();
    localObject = this.sQw;
    if (localObject != null)
    {
      ((com.tencent.mm.videocomposition.c)localObject).destroy();
      AppMethodBeat.o(204725);
      return;
    }
    AppMethodBeat.o(204725);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Float>
  {
    a(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Float>
  {
    b(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204703);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.sQE.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204703);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class f
    extends q
    implements d.g.a.m<Long, Bitmap, z>
  {
    f(FinderSelectCoverUI paramFinderSelectCoverUI, LinkedList paramLinkedList, bvz parambvz, Canvas paramCanvas, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(FinderSelectCoverUI paramFinderSelectCoverUI, y.e parame, bvz parambvz)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.b<Long, z>
  {
    i(FinderSelectCoverUI paramFinderSelectCoverUI, bvz parambvz)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderSelectCoverUI paramFinderSelectCoverUI, bvz parambvz) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204717);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      int n;
      int i1;
      Object localObject2;
      int j;
      label251:
      int k;
      label275:
      int m;
      label299:
      label333:
      boolean bool;
      if (FinderSelectCoverUI.d(this.sQE).isEnabled())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        n = com.tencent.mm.plugin.finder.storage.b.cGU().hYh;
        i1 = (int)(n / this.sQI.width * this.sQI.height);
        ae.i(FinderSelectCoverUI.g(this.sQE), "save cover, size: " + n + ", " + i1);
        paramView = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(paramView);
        localObject2 = FinderSelectCoverUI.e(this.sQE).getBitmap();
        if (localObject2 == null)
        {
          this.sQE.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204717);
          return;
        }
        if (!this.sQI.HiV) {
          break label528;
        }
        Object localObject3 = this.sQI.stz;
        if (localObject3 == null) {
          break label506;
        }
        dwz localdwz = ((bwj)localObject3).Hjp;
        if (localdwz == null) {
          break label506;
        }
        i = localdwz.left;
        if (localObject3 == null) {
          break label511;
        }
        localdwz = ((bwj)localObject3).Hjp;
        if (localdwz == null) {
          break label511;
        }
        j = localdwz.bottom;
        if (localObject3 == null) {
          break label516;
        }
        localdwz = ((bwj)localObject3).Hjp;
        if (localdwz == null) {
          break label516;
        }
        k = localdwz.right;
        if (localObject3 == null) {
          break label522;
        }
        localObject3 = ((bwj)localObject3).Hjp;
        if (localObject3 == null) {
          break label522;
        }
        m = ((dwz)localObject3).top;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(i, j, k, m), new Rect(0, 0, n, i1), null);
        localObject1 = new StringBuilder();
        localObject2 = r.sYn;
        localObject1 = r.cOx() + "cover_" + System.currentTimeMillis();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
        bool = h.a(paramView, com.tencent.mm.plugin.finder.storage.b.cHo(), Bitmap.CompressFormat.JPEG, (String)localObject1, false);
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cKd()) {
          break label571;
        }
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        i = com.tencent.mm.plugin.finder.storage.b.cGX();
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
      }
      label516:
      label522:
      label528:
      label571:
      for (int i = AdaptiveAdjustBitrate.getVideoImageQuality(i, 0, n, i1, com.tencent.mm.plugin.finder.storage.b.cHo() / 100.0F);; i = 0)
      {
        paramView = new Intent();
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.g.tqn;
          paramView.putExtra(com.tencent.mm.plugin.finder.widget.post.g.cRC(), (String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.widget.post.g.tqn;
          paramView.putExtra(com.tencent.mm.plugin.finder.widget.post.g.cRD(), i);
        }
        this.sQE.setResult(0, paramView);
        this.sQE.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204717);
        return;
        label506:
        i = 0;
        break;
        label511:
        j = 0;
        break label251;
        k = 0;
        break label275;
        m = 0;
        break label299;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()), new Rect(0, 0, n, i1), null);
        break label333;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204718);
      this.sQE.finish();
      AppMethodBeat.o(204718);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204719);
      if (this.sQE.sQC)
      {
        localObject = FinderSelectCoverUI.c(this.sQE);
        Resources localResources = this.sQE.getResources();
        Bitmap localBitmap = this.sQE.sQy;
        if (localBitmap == null) {
          d.g.b.p.bdF("thumbBitmap");
        }
        ((SeekBar)localObject).setThumb((Drawable)new BitmapDrawable(localResources, localBitmap));
        FinderSelectCoverUI.c(this.sQE).setThumbOffset(0);
        this.sQE.sQC = false;
        AppMethodBeat.o(204719);
        return;
      }
      Object localObject = FinderSelectCoverUI.c(this.sQE).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).invalidateSelf();
        AppMethodBeat.o(204719);
        return;
      }
      AppMethodBeat.o(204719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI
 * JD-Core Version:    0.7.0.1
 */