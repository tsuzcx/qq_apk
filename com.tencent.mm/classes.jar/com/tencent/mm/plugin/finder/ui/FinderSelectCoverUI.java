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
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.a.ab;
import d.a.j;
import d.f;
import d.g.b.q;
import d.g.b.y.e;
import d.k.h;
import d.l;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "Landroid/view/View;", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder_release"})
public final class FinderSelectCoverUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final LinkedList<bvf> mediaList;
  private SeekBar nka;
  public Paint sFA;
  private final f sFB;
  private final f sFC;
  boolean sFD;
  boolean sFE;
  private n sFu;
  private CropLayout sFv;
  private View sFw;
  private com.tencent.mm.videocomposition.c sFx;
  private Canvas sFy;
  public Bitmap sFz;
  
  public FinderSelectCoverUI()
  {
    AppMethodBeat.i(204129);
    this.TAG = "Finder.FinderSelectCoverUI";
    this.mediaList = new LinkedList();
    this.sFB = d.g.O((d.g.a.a)new b(this));
    this.sFC = d.g.O((d.g.a.a)new a(this));
    this.sFD = true;
    this.sFE = true;
    AppMethodBeat.o(204129);
  }
  
  private static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    AppMethodBeat.i(204127);
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
      AppMethodBeat.o(204127);
      return localRect;
      f1 = paramInt5 / j;
      f2 = (k * f1 - paramInt6) * 0.5F;
      f3 = 0.0F;
      break;
    }
  }
  
  private final float cKg()
  {
    AppMethodBeat.i(204123);
    float f = ((Number)this.sFB.getValue()).floatValue();
    AppMethodBeat.o(204123);
    return f;
  }
  
  private final float cKh()
  {
    AppMethodBeat.i(204124);
    float f = ((Number)this.sFC.getValue()).floatValue();
    AppMethodBeat.o(204124);
    return f;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204137);
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
    AppMethodBeat.o(204137);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496251;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(204126);
    super.initView();
    findViewById(2131307964).setOnClickListener((View.OnClickListener)new c(this));
    Object localObject1 = findViewById(2131307967);
    d.g.b.p.g(localObject1, "findViewById(R.id.select_cover_seekbar)");
    this.nka = ((SeekBar)localObject1);
    localObject1 = findViewById(2131299987);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.sFv = ((CropLayout)localObject1);
    localObject1 = findViewById(2131307966);
    d.g.b.p.g(localObject1, "findViewById(R.id.select_cover_ok)");
    this.sFw = ((View)localObject1);
    localObject1 = (com.tencent.mm.bx.a)new bve();
    Object localObject4 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
      localObject4 = (bve)localObject1;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = new bve();
      }
      this.mediaList.addAll((Collection)((bve)localObject1).mediaList);
      localObject4 = (bvf)this.mediaList.getFirst();
      locale = new y.e();
      locale.MLU = (((bvf)localObject4).videoDuration * 1000L);
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (com.tencent.mm.plugin.finder.utils.p.d((bvf)localObject4))
      {
        localObject1 = (Context)this;
        d.g.b.p.g(localObject4, "media");
        this.sFu = ((n)new com.tencent.mm.plugin.finder.video.e((Context)localObject1, (bvf)localObject4));
        localObject1 = com.tencent.mm.plugin.sight.base.e.axx(((bvf)localObject4).url);
        if (localObject1 != null)
        {
          locale.MLU = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.tQu;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.aiV(((bvf)localObject4).url);
          k = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
          m = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
          j = (int)cKg();
          i = (int)cKh();
          localObject1 = this.nka;
          if (localObject1 == null) {
            d.g.b.p.bcb("seekBar");
          }
          ((SeekBar)localObject1).setMax(bt.Dg(locale.MLU) * 10);
          localObject1 = com.tencent.mm.plugin.finder.video.m.sQc;
          this.sFx = com.tencent.mm.plugin.finder.video.m.f((bvf)localObject4);
          localObject1 = this.sFx;
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.c)localObject1).setSize(j, i);
          }
          f = 1.0F * ((bvf)localObject4).height / ((bvf)localObject4).width;
          cKg();
          cKg();
          localObject1 = this.sFv;
          if (localObject1 == null) {
            d.g.b.p.bcb("cropLayout");
          }
          localObject1 = ((CropLayout)localObject1).getLayoutParams();
          localObject5 = getContext();
          d.g.b.p.g(localObject5, "context");
          localObject5 = ((AppCompatActivity)localObject5).getResources();
          d.g.b.p.g(localObject5, "context.resources");
          ((ViewGroup.LayoutParams)localObject1).width = ((Resources)localObject5).getDisplayMetrics().widthPixels;
          ((ViewGroup.LayoutParams)localObject1).height = ((int)(f * ((ViewGroup.LayoutParams)localObject1).width));
          localObject5 = this.sFv;
          if (localObject5 == null) {
            d.g.b.p.bcb("cropLayout");
          }
          ((CropLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = this.sFv;
          if (localObject1 == null) {
            d.g.b.p.bcb("cropLayout");
          }
          ((CropLayout)localObject1).setEnableTouch(false);
          localObject1 = this.sFv;
          if (localObject1 == null) {
            d.g.b.p.bcb("cropLayout");
          }
          ((CropLayout)localObject1).setEnableScale(false);
          localObject1 = this.sFv;
          if (localObject1 == null) {
            d.g.b.p.bcb("cropLayout");
          }
          ((CropLayout)localObject1).setEnableFling(false);
          localObject1 = this.sFv;
          if (localObject1 == null) {
            d.g.b.p.bcb("cropLayout");
          }
          ((CropLayout)localObject1).setEnableOverScroll(false);
          localObject1 = this.sFv;
          if (localObject1 == null) {
            d.g.b.p.bcb("cropLayout");
          }
          ((CropLayout)localObject1).reset();
          localObject5 = ((bvf)localObject4).skC;
          localObject1 = localObject3;
          if (localObject5 != null) {
            localObject1 = ((bvp)localObject5).GPM;
          }
          if (localObject1 == null) {
            break label1205;
          }
          localObject3 = ((bvf)localObject4).skC.GPM;
          if (((asu)localObject3).GqN.size() == 9)
          {
            localObject1 = new Matrix();
            localObject3 = ((asu)localObject3).GqN;
            d.g.b.p.g(localObject3, "it.value");
            ((Matrix)localObject1).setValues(j.q((Collection)localObject3));
            localObject1 = new Matrix((Matrix)localObject1);
            localObject3 = this.sFv;
            if (localObject3 == null) {
              d.g.b.p.bcb("cropLayout");
            }
            localObject5 = this.sFu;
            if (localObject5 == null) {
              d.g.b.p.bcb("seeker");
            }
            ((CropLayout)localObject3).a(((n)localObject5).getView(), k, m, new Matrix(), CropLayout.e.KVn, (d.g.a.b)new d((Matrix)localObject1));
          }
          localObject1 = this.nka;
          if (localObject1 == null) {
            d.g.b.p.bcb("seekBar");
          }
          ((SeekBar)localObject1).setVisibility(4);
          localObject1 = this.nka;
          if (localObject1 == null) {
            d.g.b.p.bcb("seekBar");
          }
          ((SeekBar)localObject1).setEnabled(false);
          localObject1 = this.sFw;
          if (localObject1 == null) {
            d.g.b.p.bcb("selectBtn");
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
          j = (int)Math.ceil(k / cKg());
          i = j;
          if (j < 2) {
            i = 2;
          }
          long l = locale.MLU / (i - 1);
          localObject3 = (Iterable)h.lo(0, i);
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
      final y.e locale;
      int k;
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        localObject2 = null;
        continue;
        ad.w(this.TAG, "initView: mediaInfo null");
        continue;
        localObject2 = (Context)this;
        d.g.b.p.g(localObject4, "media");
        this.sFu = ((n)new com.tencent.mm.plugin.finder.video.b((Context)localObject2, (bvf)localObject4));
        locale.MLU = (((bvf)localObject4).GPu.FZw - ((bvf)localObject4).GPu.FZv);
        k = ((bvf)localObject4).GPu.BEZ.targetWidth;
        int m = ((bvf)localObject4).GPu.BEZ.targetHeight;
        float f = Math.max(cKg() / k, cKh() / m);
        int j = (int)(k * f);
        int i = (int)(f * m);
        continue;
        label1205:
        localObject2 = this.sFv;
        if (localObject2 == null) {
          d.g.b.p.bcb("cropLayout");
        }
        localObject3 = this.sFu;
        if (localObject3 == null) {
          d.g.b.p.bcb("seeker");
        }
        ((CropLayout)localObject2).a(((n)localObject3).getView(), k, m, new Matrix(), CropLayout.e.KVn, (d.g.a.b)e.sFH);
      }
      Object localObject2 = (LinkedList)localObject2;
      localObject3 = Bitmap.createBitmap(k, (int)cKh(), Bitmap.Config.ARGB_8888);
      Object localObject5 = new Canvas((Bitmap)localObject3);
      com.tencent.mm.videocomposition.c localc = this.sFx;
      if (localc != null) {
        localc.b((List)localObject2, (d.g.a.m)new f(this, (LinkedList)localObject2, (bvf)localObject4, (Canvas)localObject5, (Bitmap)localObject3));
      }
      localObject2 = this.sFu;
      if (localObject2 == null) {
        d.g.b.p.bcb("seeker");
      }
      ((n)localObject2).a((d.g.a.a)new g(this, locale, (bvf)localObject4), (d.g.a.a)new h(this), (d.g.a.b)new i(this, (bvf)localObject4));
      localObject2 = this.sFw;
      if (localObject2 == null) {
        d.g.b.p.bcb("selectBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new j(this, (bvf)localObject4));
      AppMethodBeat.o(204126);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204125);
    setTheme(2131821149);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    initView();
    AppMethodBeat.o(204125);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204128);
    super.onDestroy();
    Object localObject = this.sFu;
    if (localObject == null) {
      d.g.b.p.bcb("seeker");
    }
    ((n)localObject).destroy();
    localObject = this.sFx;
    if (localObject != null)
    {
      ((com.tencent.mm.videocomposition.c)localObject).destroy();
      AppMethodBeat.o(204128);
      return;
    }
    AppMethodBeat.o(204128);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Float>
  {
    a(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Float>
  {
    b(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204106);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sFF.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204106);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Matrix, Boolean>
  {
    d(Matrix paramMatrix)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<Matrix, Boolean>
  {
    public static final e sFH;
    
    static
    {
      AppMethodBeat.i(204109);
      sFH = new e();
      AppMethodBeat.o(204109);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class f
    extends q
    implements d.g.a.m<Long, Bitmap, z>
  {
    f(FinderSelectCoverUI paramFinderSelectCoverUI, LinkedList paramLinkedList, bvf parambvf, Canvas paramCanvas, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(FinderSelectCoverUI paramFinderSelectCoverUI, y.e parame, bvf parambvf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.b<Long, z>
  {
    i(FinderSelectCoverUI paramFinderSelectCoverUI, bvf parambvf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderSelectCoverUI paramFinderSelectCoverUI, bvf parambvf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204120);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      int j;
      Object localObject2;
      boolean bool;
      int k;
      if (FinderSelectCoverUI.d(this.sFF).isEnabled())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        i = com.tencent.mm.plugin.finder.storage.b.cEY().hVp;
        j = (int)(i / this.sFJ.width * this.sFJ.height);
        ad.i(FinderSelectCoverUI.g(this.sFF), "save cover, size: " + i + ", " + j);
        paramView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(paramView);
        localObject2 = FinderSelectCoverUI.e(this.sFF).getBitmap();
        if (localObject2 == null)
        {
          this.sFF.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204120);
          return;
        }
        if (!this.sFJ.GPt) {
          break label429;
        }
        bvp localbvp = this.sFJ.skC;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(localbvp.GPN.left, localbvp.GPN.bottom, localbvp.GPN.right, localbvp.GPN.top), new Rect(0, 0, i, j), null);
        localObject1 = new StringBuilder();
        localObject2 = r.sNc;
        localObject1 = r.cLP() + "cover_" + System.currentTimeMillis();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
        bool = com.tencent.mm.sdk.platformtools.g.a(paramView, com.tencent.mm.plugin.finder.storage.b.cFr(), Bitmap.CompressFormat.JPEG, (String)localObject1, false);
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (!com.tencent.mm.plugin.finder.storage.b.cIh()) {
          break label470;
        }
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        k = com.tencent.mm.plugin.finder.storage.b.cFb();
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
      }
      label429:
      label470:
      for (int i = AdaptiveAdjustBitrate.getVideoImageQuality(k, 0, i, j, com.tencent.mm.plugin.finder.storage.b.cFr() / 100.0F);; i = 0)
      {
        paramView = new Intent();
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.g.tfu;
          paramView.putExtra(com.tencent.mm.plugin.finder.widget.post.g.cOX(), (String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.widget.post.g.tfu;
          paramView.putExtra(com.tencent.mm.plugin.finder.widget.post.g.cOY(), i);
        }
        this.sFF.setResult(0, paramView);
        this.sFF.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204120);
        return;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()), new Rect(0, 0, i, j), null);
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204121);
      this.sFF.finish();
      AppMethodBeat.o(204121);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204122);
      if (this.sFF.sFD)
      {
        localObject = FinderSelectCoverUI.c(this.sFF);
        Resources localResources = this.sFF.getResources();
        Bitmap localBitmap = this.sFF.sFz;
        if (localBitmap == null) {
          d.g.b.p.bcb("thumbBitmap");
        }
        ((SeekBar)localObject).setThumb((Drawable)new BitmapDrawable(localResources, localBitmap));
        FinderSelectCoverUI.c(this.sFF).setThumbOffset(0);
        this.sFF.sFD = false;
        AppMethodBeat.o(204122);
        return;
      }
      Object localObject = FinderSelectCoverUI.c(this.sFF).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).invalidateSelf();
        AppMethodBeat.o(204122);
        return;
      }
      AppMethodBeat.o(204122);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI
 * JD-Core Version:    0.7.0.1
 */