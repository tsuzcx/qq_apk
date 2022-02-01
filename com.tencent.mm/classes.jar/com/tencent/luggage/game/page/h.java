package com.tencent.luggage.game.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.game.c.e.1;
import com.tencent.luggage.game.c.e.c;
import com.tencent.luggage.h.i;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.d.b;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageFullScreenView;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.ba;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements b.b, d
{
  protected WAGamePageViewContainerLayout clb;
  private MagicBrushView clc;
  private am cld;
  protected b cle;
  private Bitmap clf;
  private Bitmap clg;
  private ImageView clh;
  private final a cli;
  double clj;
  private AtomicBoolean clk;
  private final View.OnAttachStateChangeListener cll;
  
  public h(PAGE arg1)
  {
    super(???);
    AppMethodBeat.i(130656);
    this.clj = 60.0D;
    this.clk = new AtomicBoolean(false);
    this.cll = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(130651);
        ad.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
        h.a(h.this).getMagicBrush().Hd();
        h.a(h.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(130650);
            h.this.clb.removeOnAttachStateChangeListener(jdField_this);
            AppMethodBeat.o(130650);
          }
        });
        AppMethodBeat.o(130651);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    };
    this.cli = new a();
    DB();
    com.tencent.luggage.sdk.b.a.c.e locale = ???.Eo().coU;
    synchronized (this.cnm)
    {
      this.cnm.putAll(locale.cnm);
      AppMethodBeat.o(130656);
      return;
    }
  }
  
  private void DI()
  {
    AppMethodBeat.i(130668);
    BitmapDrawable localBitmapDrawable;
    if (this.clh != null) {
      if ((this.clh.getDrawable() instanceof BitmapDrawable))
      {
        localBitmapDrawable = (BitmapDrawable)this.clh.getDrawable();
        this.clh.setImageDrawable(null);
      }
    }
    try
    {
      localBitmapDrawable.getBitmap().recycle();
      this.clh.setVisibility(8);
      if (this.clf == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.clf.recycle();
        this.clf = null;
        AppMethodBeat.o(130668);
        return;
        localException1 = localException1;
        ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException1, "hy: cleanupCoverScreenshot error!", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException2, "hy: cleanupCoverScreenshot error!", new Object[0]);
        }
      }
    }
  }
  
  private void DJ()
  {
    AppMethodBeat.i(130673);
    if (this.clg != null) {}
    try
    {
      ad.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
      this.clg.recycle();
      this.clg = null;
      AppMethodBeat.o(130673);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: cleanupCanvasSecurityGuard error!", new Object[0]);
      }
    }
  }
  
  protected void DB()
  {
    AppMethodBeat.i(130657);
    b(d.class, this);
    AppMethodBeat.o(130657);
  }
  
  public final bc DC()
  {
    return this.cle;
  }
  
  public final am DD()
  {
    return this.cld;
  }
  
  public final void DE()
  {
    AppMethodBeat.i(130663);
    super.DE();
    DI();
    DJ();
    this.clc.getMagicBrush().Hd();
    AppMethodBeat.o(130663);
  }
  
  public void DF()
  {
    AppMethodBeat.i(130664);
    super.DF();
    this.clc.getMagicBrush().He();
    AppMethodBeat.o(130664);
  }
  
  public final Map<String, m> DG()
  {
    AppMethodBeat.i(130666);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(130666);
    return localMap;
  }
  
  public final void DH() {}
  
  public final void Dq()
  {
    AppMethodBeat.i(130669);
    DI();
    if (!getMagicBrushView().getMagicBrush().cwv.Ct())
    {
      AppMethodBeat.o(130669);
      return;
    }
    Object localObject = ((com.tencent.luggage.sdk.b.a.c)El()).jzX.getOrientationHandler().aXN();
    if (org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.r.a.e.b[] { com.tencent.mm.plugin.appbrand.r.a.e.b.moI, com.tencent.mm.plugin.appbrand.r.a.e.b.moJ, com.tencent.mm.plugin.appbrand.r.a.e.b.moK, com.tencent.mm.plugin.appbrand.r.a.e.b.moL }, localObject))
    {
      if (this.clh == null)
      {
        ad.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(130669);
        return;
      }
      if (this.clc != null) {
        break label151;
      }
      ad.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
    }
    label151:
    for (localObject = null;; localObject = com.tencent.magicbrush.b.a(this.clc.getMagicBrush().cwN))
    {
      this.clf = ((Bitmap)localObject);
      this.clb.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a()
      {
        public final void a(WAGamePageViewContainerLayout.b paramAnonymousb1, WAGamePageViewContainerLayout.b paramAnonymousb2)
        {
          AppMethodBeat.i(178042);
          ad.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramAnonymousb1, paramAnonymousb2 });
          if (h.c(h.this) == null)
          {
            ad.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
            AppMethodBeat.o(178042);
            return;
          }
          if (((h.a(paramAnonymousb1)) && (h.a(paramAnonymousb2))) || ((h.b(paramAnonymousb1)) && (h.b(paramAnonymousb2))))
          {
            AppMethodBeat.o(178042);
            return;
          }
          if (h.a(paramAnonymousb2))
          {
            Matrix localMatrix = new Matrix();
            if (((paramAnonymousb2 == WAGamePageViewContainerLayout.b.ckS) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.ckT)) || ((paramAnonymousb2 == WAGamePageViewContainerLayout.b.ckU) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.ckV))) {
              localMatrix.postRotate(90.0F);
            }
            for (;;)
            {
              h.d(h.this).setVisibility(0);
              h.d(h.this).setImageBitmap(Bitmap.createBitmap(h.c(h.this), 0, 0, h.c(h.this).getWidth(), h.c(h.this).getHeight(), localMatrix, true));
              AppMethodBeat.o(178042);
              return;
              localMatrix.postRotate(270.0F);
            }
          }
          h.this.clb.setOnConfigurationChangedListener(null);
          AppMethodBeat.o(178042);
        }
      });
      AppMethodBeat.o(130669);
      return;
    }
  }
  
  public final void Dr()
  {
    AppMethodBeat.i(130671);
    ad.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
    try
    {
      DJ();
      this.clg = com.tencent.magicbrush.b.a(this.clc.getMagicBrush().cwN);
      AppMethodBeat.o(130671);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: captureDefaultWindow error!", new Object[0]);
      AppMethodBeat.o(130671);
    }
  }
  
  public final Bitmap Ds()
  {
    AppMethodBeat.i(130672);
    if (this.clg != null)
    {
      ad.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
      Bitmap localBitmap = this.clg;
      AppMethodBeat.o(130672);
      return localBitmap;
    }
    AppMethodBeat.o(130672);
    return null;
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(130658);
    paramLayoutInflater = new WAGamePageViewContainerLayout(paramLayoutInflater.getContext());
    this.clb = paramLayoutInflater;
    AppMethodBeat.o(130658);
    return paramLayoutInflater;
  }
  
  protected MagicBrushView ax(Context paramContext)
  {
    AppMethodBeat.i(130659);
    paramContext = new MagicBrushView(paramContext, MagicBrushView.h.cAp);
    AppMethodBeat.o(130659);
    return paramContext;
  }
  
  public final ay ay(Context paramContext)
  {
    return this.cli;
  }
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(130661);
    paramb.setFullscreenMode(true);
    if ((paramb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramb.getLayoutParams();
      localMarginLayoutParams.rightMargin = paramb.getContext().getResources().getDimensionPixelSize(2131165772);
      localMarginLayoutParams.topMargin = paramb.getContext().getResources().getDimensionPixelSize(2131165773);
      paramb.requestLayout();
    }
    AppMethodBeat.o(130661);
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(130667);
    ((com.tencent.luggage.sdk.b.a.c)El()).Eo().c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(130667);
    return true;
  }
  
  public final boolean cX(String paramString)
  {
    return true;
  }
  
  public void cl(View paramView)
  {
    AppMethodBeat.i(190418);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(190418);
      return;
    }
    if (this.clk.compareAndSet(false, true)) {
      ((com.tencent.luggage.sdk.b.a.c)El()).Tn("onNativeWidgetViewAdded");
    }
    AppMethodBeat.o(190418);
  }
  
  public void cm(View paramView)
  {
    AppMethodBeat.i(130660);
    paramView = (com.tencent.luggage.game.d.a.a.b)Q(com.tencent.luggage.game.d.a.a.b.class);
    if (paramView == null)
    {
      ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.c(), "hy: not on game service!", new Object[0]);
      AppMethodBeat.o(130660);
      return;
    }
    this.clc = ax(getContext());
    this.clc.setId(2131296729);
    paramView = paramView.getMagicBrush();
    this.clc.setMagicBrush(paramView);
    paramView.cwL.add(new d.b()
    {
      public final void onFirstFrame()
      {
        AppMethodBeat.i(130652);
        if (h.b(h.this).compareAndSet(false, true)) {
          ((com.tencent.luggage.sdk.b.a.c)h.this.El()).Tn("onFirstFrame");
        }
        AppMethodBeat.o(130652);
      }
    });
    this.clb.addView(this.clc, 0, new FrameLayout.LayoutParams(-1, -1));
    this.cle = new b(getContext());
    this.cle.setNativeWidgetAddedCallback(this);
    this.clb.addView(this.cle, -1, new ViewGroup.LayoutParams(-1, -1));
    this.cld = new c(this.cle);
    this.cld.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)El()).getFullscreenImpl());
    this.cld.a(new ba()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(130653);
        if ((paramAnonymousAppBrandPageFullScreenView != null) && (paramAnonymousAppBrandPageFullScreenView.getParent() == null)) {
          h.this.clb.addView(paramAnonymousAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(130653);
      }
    });
    paramView = this.cld;
    Object localObject1 = new h.4(this);
    ad.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.TRUE });
    paramView.mdQ = ((bd)localObject1);
    if (paramView.mdP != null)
    {
      if ((!am.$assertionsDisabled) && (paramView.mdQ == null))
      {
        paramView = new AssertionError();
        AppMethodBeat.o(130660);
        throw paramView;
      }
      paramView.mdQ.a(paramView.mdP);
    }
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)El()).En().Fa().cmE;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)El()).En().Fa().cmE;
    if ((bool1) || (bool2))
    {
      ??? = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)El()).Eo().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (??? == null) {
        break label920;
      }
      paramView = ((com.tencent.luggage.game.d.a.a.b)???).CH();
      localObject1 = new com.tencent.luggage.game.c.e.b();
      ((com.tencent.luggage.game.c.e.b)localObject1).ciT = ((com.tencent.mm.plugin.appbrand.jsapi.h)El());
      ((com.tencent.luggage.game.c.e.b)localObject1).cjt = ((com.tencent.luggage.game.d.a.a.b)???).getMagicBrush();
      ((com.tencent.luggage.game.c.e.b)localObject1).cju = this.clb;
      ((com.tencent.luggage.game.c.e.b)localObject1).cjv = bool1;
      ((com.tencent.luggage.game.c.e.b)localObject1).cjw = bool2;
      ((com.tencent.luggage.game.c.e.b)localObject1).cjx = new h.5(this, (com.tencent.luggage.game.d.a.a.b)???);
      paramView.ciY = ((com.tencent.luggage.game.c.e.b)localObject1).cjt;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(130660);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((com.tencent.luggage.game.c.e.b)localObject1).cju.getContext();
        if (((com.tencent.luggage.game.c.e.b)localObject1).cjv)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cjx;
          paramView.cji = new com.tencent.luggage.game.c.d(paramView.mContext);
          paramView.cji.cjf = ((e.c)???);
          paramView.cji.setBackground(paramView.mContext.getResources().getDrawable(2131230977));
        }
        Object localObject3;
        if (((com.tencent.luggage.game.c.e.b)localObject1).cjw)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).ciT;
          localObject3 = paramView.ciY;
          Context localContext = paramView.mContext;
          paramView.cjj = new com.tencent.luggage.game.c.b(com.tencent.luggage.game.b.c.Cw().ciJ, (com.tencent.magicbrush.d)localObject3, localContext, (com.tencent.mm.plugin.appbrand.jsapi.h)???);
        }
        ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cju;
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        if (paramView.cjj != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.cjj.getView(), (ViewGroup.LayoutParams)localObject3);
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).gravity = 8388693;
          ((FrameLayout.LayoutParams)localObject3).bottomMargin = ((int)(55.0F * f));
          int i = (int)(f * 15.0F);
          ((FrameLayout.LayoutParams)localObject3).rightMargin = i;
          ((FrameLayout.LayoutParams)localObject3).leftMargin = i;
          ((FrameLayout)???).addView(paramView.cjj.ciV, (ViewGroup.LayoutParams)localObject3);
        }
        if (paramView.cji != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).topMargin = i.cqA.aF(paramView.mContext);
          ((FrameLayout)???).addView(paramView.cji, (ViewGroup.LayoutParams)localObject3);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.cjk)
      {
        if (paramView.mState != 0)
        {
          this.clh = new ImageView(getContext());
          this.clh.setVisibility(8);
          this.clb.addView(this.clh, new FrameLayout.LayoutParams(-1, -1));
          this.clb.addOnAttachStateChangeListener(this.cll);
          AppMethodBeat.o(130660);
          return;
        }
        paramView.mState = 1;
        if ((((com.tencent.luggage.game.c.e.b)localObject1).cjw) && (paramView.cjj != null)) {
          paramView.cjj.post(new e.1(paramView));
        }
      }
      label920:
      ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.c(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  public final RelativeLayout.LayoutParams cn(View paramView)
  {
    AppMethodBeat.i(190416);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(190416);
    return paramView;
  }
  
  public void dispatchDestroy()
  {
    AppMethodBeat.i(130665);
    super.dispatchDestroy();
    DI();
    DJ();
    if ((El() != null) && (((com.tencent.luggage.sdk.b.a.c)El()).Eo() != null) && (((com.tencent.luggage.sdk.b.a.c)El()).Eo().Q(com.tencent.luggage.game.d.a.a.b.class) != null))
    {
      com.tencent.luggage.game.c.e locale = ((com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)El()).Eo().Q(com.tencent.luggage.game.d.a.a.b.class)).CH();
      locale.mState = 2;
      locale.cjl.clS.clear();
      locale.ciY = null;
      if (locale.cjj != null)
      {
        locale.cjj.ciS.destroy();
        locale.cjj = null;
      }
      if (locale.cji != null)
      {
        locale.cji.cjg.stopTimer();
        locale.cji = null;
      }
    }
    AppMethodBeat.o(130665);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(130662);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new com.tencent.luggage.game.page.a.b((aa)El()));
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, new g((aa)El(), En().getAppConfig().jVw.jVL));
    AppMethodBeat.o(130662);
  }
  
  public MagicBrushView getMagicBrushView()
  {
    return this.clc;
  }
  
  public final Bitmap q(int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(130670);
    ad.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
    if (paramInt == -1)
    {
      ad.e("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
      AppMethodBeat.o(130670);
      return null;
    }
    ad.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.clc == null) {
      ad.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      ad.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(130670);
      return localBitmap;
      localBitmap = this.clc.getMagicBrush().cwN.h(this.clc.getVirtualElementId(), paramInt, false);
    }
  }
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190417);
    ((com.tencent.luggage.sdk.b.a.c)El()).Eo().c(paramString1, paramString2, 0);
    AppMethodBeat.o(190417);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */