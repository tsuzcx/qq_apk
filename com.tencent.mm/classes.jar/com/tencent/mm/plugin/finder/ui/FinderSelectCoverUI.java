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
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.a.ab;
import d.a.j;
import d.g.b.u;
import d.g.b.v.e;
import d.g.b.w;
import d.k.h;
import d.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "Landroid/view/View;", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder_release"})
public final class FinderSelectCoverUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private SeekBar mJE;
  private final LinkedList<bqs> mediaList;
  private final d.f rKA;
  private final d.f rKB;
  boolean rKC;
  boolean rKD;
  private com.tencent.mm.plugin.finder.video.n rKt;
  private CropLayout rKu;
  private View rKv;
  private com.tencent.mm.plugin.vlog.ui.thumb.c rKw;
  private Canvas rKx;
  public Bitmap rKy;
  public Paint rKz;
  
  static
  {
    AppMethodBeat.i(203321);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderSelectCoverUI.class), "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH()F")), (d.l.k)w.a(new u(w.bn(FinderSelectCoverUI.class), "SEEKBAR_THUMB_HEIGHT", "getSEEKBAR_THUMB_HEIGHT()F")) };
    AppMethodBeat.o(203321);
  }
  
  public FinderSelectCoverUI()
  {
    AppMethodBeat.i(203328);
    this.TAG = "Finder.FinderSelectCoverUI";
    this.mediaList = new LinkedList();
    this.rKA = d.g.K((d.g.a.a)new b(this));
    this.rKB = d.g.K((d.g.a.a)new a(this));
    this.rKC = true;
    this.rKD = true;
    AppMethodBeat.o(203328);
  }
  
  private static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 0;
    AppMethodBeat.i(203326);
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
      AppMethodBeat.o(203326);
      return localRect;
      f1 = paramInt5 / j;
      f2 = (k * f1 - paramInt6) * 0.5F;
      f3 = 0.0F;
      break;
    }
  }
  
  private final float cCh()
  {
    AppMethodBeat.i(203322);
    float f = ((Number)this.rKA.getValue()).floatValue();
    AppMethodBeat.o(203322);
    return f;
  }
  
  private final float cCi()
  {
    AppMethodBeat.i(203323);
    float f = ((Number)this.rKB.getValue()).floatValue();
    AppMethodBeat.o(203323);
    return f;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203336);
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
    AppMethodBeat.o(203336);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496251;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(203325);
    super.initView();
    findViewById(2131307964).setOnClickListener((View.OnClickListener)new c(this));
    Object localObject1 = findViewById(2131307967);
    d.g.b.k.g(localObject1, "findViewById(R.id.select_cover_seekbar)");
    this.mJE = ((SeekBar)localObject1);
    localObject1 = findViewById(2131299987);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_crop_layout)");
    this.rKu = ((CropLayout)localObject1);
    localObject1 = findViewById(2131307966);
    d.g.b.k.g(localObject1, "findViewById(R.id.select_cover_ok)");
    this.rKv = ((View)localObject1);
    localObject1 = (com.tencent.mm.bw.a)new bqr();
    Object localObject4 = getIntent().getByteArrayExtra("media_list_");
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
      localObject4 = (bqr)localObject1;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = new bqr();
      }
      this.mediaList.addAll((Collection)((bqr)localObject1).mediaList);
      localObject4 = (bqs)this.mediaList.getFirst();
      locale = new v.e();
      locale.KUP = (((bqs)localObject4).videoDuration * 1000L);
      localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
      if (com.tencent.mm.plugin.finder.utils.n.c((bqs)localObject4))
      {
        localObject1 = (Context)this;
        d.g.b.k.g(localObject4, "media");
        this.rKt = ((com.tencent.mm.plugin.finder.video.n)new com.tencent.mm.plugin.finder.video.e((Context)localObject1, (bqs)localObject4));
        localObject1 = com.tencent.mm.plugin.sight.base.e.asx(((bqs)localObject4).url);
        if (localObject1 != null)
        {
          locale.KUP = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.sTV;
          localObject1 = com.tencent.mm.plugin.gallery.a.c.aeB(((bqs)localObject4).url);
          k = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
          m = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
          j = (int)cCh();
          i = (int)cCi();
          localObject1 = this.mJE;
          if (localObject1 == null) {
            d.g.b.k.aVY("seekBar");
          }
          ((SeekBar)localObject1).setMax(bs.Aq(locale.KUP) * 10);
          localObject1 = com.tencent.mm.plugin.finder.video.m.rTs;
          this.rKw = com.tencent.mm.plugin.finder.video.m.a((bqs)localObject4, j, i);
          localObject1 = this.rKw;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.vlog.ui.thumb.c)localObject1).setSize(j, i);
          }
          f = 1.0F * ((bqs)localObject4).height / ((bqs)localObject4).width;
          cCh();
          cCh();
          localObject1 = this.rKu;
          if (localObject1 == null) {
            d.g.b.k.aVY("cropLayout");
          }
          localObject1 = ((CropLayout)localObject1).getLayoutParams();
          localObject5 = getContext();
          d.g.b.k.g(localObject5, "context");
          localObject5 = ((AppCompatActivity)localObject5).getResources();
          d.g.b.k.g(localObject5, "context.resources");
          ((ViewGroup.LayoutParams)localObject1).width = ((Resources)localObject5).getDisplayMetrics().widthPixels;
          ((ViewGroup.LayoutParams)localObject1).height = ((int)(f * ((ViewGroup.LayoutParams)localObject1).width));
          localObject5 = this.rKu;
          if (localObject5 == null) {
            d.g.b.k.aVY("cropLayout");
          }
          ((CropLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = this.rKu;
          if (localObject1 == null) {
            d.g.b.k.aVY("cropLayout");
          }
          ((CropLayout)localObject1).setEnableTouch(false);
          localObject1 = this.rKu;
          if (localObject1 == null) {
            d.g.b.k.aVY("cropLayout");
          }
          ((CropLayout)localObject1).setEnableScale(false);
          localObject1 = this.rKu;
          if (localObject1 == null) {
            d.g.b.k.aVY("cropLayout");
          }
          ((CropLayout)localObject1).setEnableFling(false);
          localObject1 = this.rKu;
          if (localObject1 == null) {
            d.g.b.k.aVY("cropLayout");
          }
          ((CropLayout)localObject1).setEnableOverScroll(false);
          localObject1 = this.rKu;
          if (localObject1 == null) {
            d.g.b.k.aVY("cropLayout");
          }
          ((CropLayout)localObject1).reset();
          localObject5 = ((bqs)localObject4).rvh;
          localObject1 = localObject3;
          if (localObject5 != null) {
            localObject1 = ((brc)localObject5).Fgk;
          }
          if (localObject1 == null) {
            break label1207;
          }
          localObject3 = ((bqs)localObject4).rvh.Fgk;
          if (((aoz)localObject3).EHU.size() == 9)
          {
            localObject1 = new Matrix();
            localObject3 = ((aoz)localObject3).EHU;
            d.g.b.k.g(localObject3, "it.value");
            ((Matrix)localObject1).setValues(j.p((Collection)localObject3));
            localObject1 = new Matrix((Matrix)localObject1);
            localObject3 = this.rKu;
            if (localObject3 == null) {
              d.g.b.k.aVY("cropLayout");
            }
            localObject5 = this.rKt;
            if (localObject5 == null) {
              d.g.b.k.aVY("seeker");
            }
            ((CropLayout)localObject3).a(((com.tencent.mm.plugin.finder.video.n)localObject5).getView(), k, m, new Matrix(), CropLayout.e.Jef, (d.g.a.b)new FinderSelectCoverUI.d((Matrix)localObject1));
          }
          localObject1 = this.mJE;
          if (localObject1 == null) {
            d.g.b.k.aVY("seekBar");
          }
          ((SeekBar)localObject1).setVisibility(4);
          localObject1 = this.mJE;
          if (localObject1 == null) {
            d.g.b.k.aVY("seekBar");
          }
          ((SeekBar)localObject1).setEnabled(false);
          localObject1 = this.rKv;
          if (localObject1 == null) {
            d.g.b.k.aVY("selectBtn");
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
          j = (int)Math.ceil(k / cCh());
          i = j;
          if (j < 2) {
            i = 2;
          }
          long l = locale.KUP / (i - 1);
          localObject3 = (Iterable)h.kZ(0, i);
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
      final v.e locale;
      int k;
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { localException });
        localObject2 = null;
        continue;
        ac.w(this.TAG, "initView: mediaInfo null");
        continue;
        localObject2 = (Context)this;
        d.g.b.k.g(localObject4, "media");
        this.rKt = ((com.tencent.mm.plugin.finder.video.n)new com.tencent.mm.plugin.finder.video.b((Context)localObject2, (bqs)localObject4));
        locale.KUP = (((bqs)localObject4).FfQ.Esm - ((bqs)localObject4).FfQ.Esl);
        k = ((bqs)localObject4).FfQ.AmP.gNU;
        int m = ((bqs)localObject4).FfQ.AmP.gNV;
        float f = Math.max(cCh() / k, cCi() / m);
        int j = (int)(k * f);
        int i = (int)(f * m);
        continue;
        label1207:
        localObject2 = this.rKu;
        if (localObject2 == null) {
          d.g.b.k.aVY("cropLayout");
        }
        localObject3 = this.rKt;
        if (localObject3 == null) {
          d.g.b.k.aVY("seeker");
        }
        ((CropLayout)localObject2).a(((com.tencent.mm.plugin.finder.video.n)localObject3).getView(), k, m, new Matrix(), CropLayout.e.Jef, (d.g.a.b)FinderSelectCoverUI.e.rKG);
      }
      Object localObject2 = (LinkedList)localObject2;
      localObject3 = this.rKw;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.vlog.ui.thumb.c)localObject3).init();
      }
      localObject3 = Bitmap.createBitmap(k, (int)cCi(), Bitmap.Config.ARGB_8888);
      Object localObject5 = new Canvas((Bitmap)localObject3);
      com.tencent.mm.plugin.vlog.ui.thumb.c localc = this.rKw;
      if (localc != null) {
        localc.b((List)localObject2, (d.g.a.m)new f(this, (LinkedList)localObject2, (bqs)localObject4, (Canvas)localObject5, (Bitmap)localObject3));
      }
      localObject2 = this.rKt;
      if (localObject2 == null) {
        d.g.b.k.aVY("seeker");
      }
      ((com.tencent.mm.plugin.finder.video.n)localObject2).a((d.g.a.a)new g(this, locale, (bqs)localObject4), (d.g.a.a)new h(this), (d.g.a.b)new i(this, (bqs)localObject4));
      localObject2 = this.rKv;
      if (localObject2 == null) {
        d.g.b.k.aVY("selectBtn");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new j(this, (bqs)localObject4));
      AppMethodBeat.o(203325);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203324);
    setTheme(2131821149);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    initView();
    AppMethodBeat.o(203324);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203327);
    super.onDestroy();
    Object localObject = this.rKt;
    if (localObject == null) {
      d.g.b.k.aVY("seeker");
    }
    ((com.tencent.mm.plugin.finder.video.n)localObject).destroy();
    localObject = this.rKw;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.vlog.ui.thumb.c)localObject).destroy();
      AppMethodBeat.o(203327);
      return;
    }
    AppMethodBeat.o(203327);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Float>
  {
    a(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Float>
  {
    b(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203304);
      this.rKE.finish();
      AppMethodBeat.o(203304);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.m<Long, Bitmap, y>
  {
    f(FinderSelectCoverUI paramFinderSelectCoverUI, LinkedList paramLinkedList, bqs parambqs, Canvas paramCanvas, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(FinderSelectCoverUI paramFinderSelectCoverUI, v.e parame, bqs parambqs)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(FinderSelectCoverUI paramFinderSelectCoverUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    i(FinderSelectCoverUI paramFinderSelectCoverUI, bqs parambqs)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderSelectCoverUI paramFinderSelectCoverUI, bqs parambqs) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203318);
      int i;
      int j;
      Object localObject1;
      Object localObject2;
      if (FinderSelectCoverUI.d(this.rKE).isEnabled())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        i = com.tencent.mm.plugin.finder.storage.b.cxZ().hCK;
        j = (int)(i / this.rKI.width * this.rKI.height);
        ac.i(FinderSelectCoverUI.g(this.rKE), "save cover, size: " + i + ", " + j);
        paramView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(paramView);
        localObject2 = FinderSelectCoverUI.e(this.rKE).getBitmap();
        if (localObject2 == null)
        {
          this.rKE.finish();
          AppMethodBeat.o(203318);
          return;
        }
        if (!this.rKI.FfP) {
          break label320;
        }
        brc localbrc = this.rKI.rvh;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(localbrc.Fgl.left, localbrc.Fgl.bottom, localbrc.Fgl.right, localbrc.Fgl.top), new Rect(0, 0, i, j), null);
      }
      for (;;)
      {
        localObject1 = new StringBuilder();
        localObject2 = p.rQw;
        localObject1 = p.cDv() + "cover_" + System.currentTimeMillis();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
        boolean bool = com.tencent.mm.sdk.platformtools.f.a(paramView, com.tencent.mm.plugin.finder.storage.b.cyp(), Bitmap.CompressFormat.JPEG, (String)localObject1, false);
        paramView = new Intent();
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.g.siT;
          paramView.putExtra(com.tencent.mm.plugin.finder.widget.post.g.cGJ(), (String)localObject1);
        }
        this.rKE.setResult(0, paramView);
        this.rKE.finish();
        AppMethodBeat.o(203318);
        return;
        label320:
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()), new Rect(0, 0, i, j), null);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203319);
      this.rKE.finish();
      AppMethodBeat.o(203319);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderSelectCoverUI paramFinderSelectCoverUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(203320);
      if (this.rKE.rKC)
      {
        localObject = FinderSelectCoverUI.c(this.rKE);
        Resources localResources = this.rKE.getResources();
        Bitmap localBitmap = this.rKE.rKy;
        if (localBitmap == null) {
          d.g.b.k.aVY("thumbBitmap");
        }
        ((SeekBar)localObject).setThumb((Drawable)new BitmapDrawable(localResources, localBitmap));
        FinderSelectCoverUI.c(this.rKE).setThumbOffset(0);
        this.rKE.rKC = false;
        AppMethodBeat.o(203320);
        return;
      }
      Object localObject = FinderSelectCoverUI.c(this.rKE).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).invalidateSelf();
        AppMethodBeat.o(203320);
        return;
      }
      AppMethodBeat.o(203320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI
 * JD-Core Version:    0.7.0.1
 */