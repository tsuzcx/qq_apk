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
import com.tencent.luggage.h.j;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageFullScreenView;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements b.b, d
{
  protected WAGamePageViewContainerLayout cwY;
  private MagicBrushView cwZ;
  private ao cxa;
  protected b cxb;
  private Bitmap cxc;
  private Bitmap cxd;
  private ImageView cxe;
  private final a cxf;
  double cxg;
  private AtomicBoolean cxh;
  private final View.OnAttachStateChangeListener cxi;
  
  public h(PAGE arg1)
  {
    super(???);
    AppMethodBeat.i(130656);
    this.cxg = 60.0D;
    this.cxh = new AtomicBoolean(false);
    this.cxi = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(130651);
        Log.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
        h.a(h.this).getMagicBrush().Rc();
        h.a(h.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(130650);
            h.this.cwY.removeOnAttachStateChangeListener(jdField_this);
            AppMethodBeat.o(130650);
          }
        });
        AppMethodBeat.o(130651);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    };
    this.cxf = new a();
    Nb();
    com.tencent.luggage.sdk.b.a.c.f localf = ???.NQ().cBj;
    synchronized (this.czn)
    {
      this.czn.putAll(localf.czn);
      AppMethodBeat.o(130656);
      return;
    }
  }
  
  private void Nh()
  {
    AppMethodBeat.i(130668);
    BitmapDrawable localBitmapDrawable;
    if (this.cxe != null) {
      if ((this.cxe.getDrawable() instanceof BitmapDrawable))
      {
        localBitmapDrawable = (BitmapDrawable)this.cxe.getDrawable();
        this.cxe.setImageDrawable(null);
      }
    }
    try
    {
      localBitmapDrawable.getBitmap().recycle();
      this.cxe.setVisibility(8);
      if (this.cxc == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.cxc.recycle();
        this.cxc = null;
        AppMethodBeat.o(130668);
        return;
        localException1 = localException1;
        Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException1, "hy: cleanupCoverScreenshot error!", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException2, "hy: cleanupCoverScreenshot error!", new Object[0]);
        }
      }
    }
  }
  
  private void Ni()
  {
    AppMethodBeat.i(130673);
    if (this.cxd != null) {}
    try
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
      this.cxd.recycle();
      this.cxd = null;
      AppMethodBeat.o(130673);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: cleanupCanvasSecurityGuard error!", new Object[0]);
      }
    }
  }
  
  public final void MP()
  {
    AppMethodBeat.i(130669);
    Nh();
    if (!MQ().getMagicBrush().cLi.LO())
    {
      AppMethodBeat.o(130669);
      return;
    }
    Object localObject = ((com.tencent.luggage.sdk.b.a.c)NN()).kEb.getOrientationHandler().btm();
    if (org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { com.tencent.mm.plugin.appbrand.platform.window.e.b.nEn, com.tencent.mm.plugin.appbrand.platform.window.e.b.nEo, com.tencent.mm.plugin.appbrand.platform.window.e.b.nEp, com.tencent.mm.plugin.appbrand.platform.window.e.b.nEq }, localObject))
    {
      if (this.cxe == null)
      {
        Log.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(130669);
        return;
      }
      if (this.cwZ != null) {
        break label151;
      }
      Log.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
    }
    label151:
    for (localObject = null;; localObject = com.tencent.magicbrush.b.a(this.cwZ.getMagicBrush().cLA))
    {
      this.cxc = ((Bitmap)localObject);
      this.cwY.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a()
      {
        public final void a(WAGamePageViewContainerLayout.b paramAnonymousb1, WAGamePageViewContainerLayout.b paramAnonymousb2)
        {
          AppMethodBeat.i(178042);
          Log.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramAnonymousb1, paramAnonymousb2 });
          if (h.c(h.this) == null)
          {
            Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
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
            if (((paramAnonymousb2 == WAGamePageViewContainerLayout.b.cwP) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.cwQ)) || ((paramAnonymousb2 == WAGamePageViewContainerLayout.b.cwR) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.cwS))) {
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
          h.this.cwY.setOnConfigurationChangedListener(null);
          AppMethodBeat.o(178042);
        }
      });
      AppMethodBeat.o(130669);
      return;
    }
  }
  
  public MagicBrushView MQ()
  {
    return this.cwZ;
  }
  
  public final void MR()
  {
    AppMethodBeat.i(130671);
    Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
    try
    {
      Ni();
      this.cxd = com.tencent.magicbrush.b.a(this.cwZ.getMagicBrush().cLA);
      AppMethodBeat.o(130671);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: captureDefaultWindow error!", new Object[0]);
      AppMethodBeat.o(130671);
    }
  }
  
  public final Bitmap MS()
  {
    AppMethodBeat.i(130672);
    if (this.cxd != null)
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
      Bitmap localBitmap = this.cxd;
      AppMethodBeat.o(130672);
      return localBitmap;
    }
    AppMethodBeat.o(130672);
    return null;
  }
  
  protected void Nb()
  {
    AppMethodBeat.i(130657);
    b(d.class, this);
    AppMethodBeat.o(130657);
  }
  
  public final bf Nc()
  {
    return this.cxb;
  }
  
  public final void Nd()
  {
    AppMethodBeat.i(130663);
    super.Nd();
    Nh();
    Ni();
    this.cwZ.getMagicBrush().Rc();
    AppMethodBeat.o(130663);
  }
  
  public void Ne()
  {
    AppMethodBeat.i(130664);
    super.Ne();
    this.cwZ.getMagicBrush().Rd();
    AppMethodBeat.o(130664);
  }
  
  public final Map<String, p> Nf()
  {
    AppMethodBeat.i(130666);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(130666);
    return localMap;
  }
  
  public final void Ng() {}
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(130658);
    paramLayoutInflater = new WAGamePageViewContainerLayout(paramLayoutInflater.getContext());
    this.cwY = paramLayoutInflater;
    AppMethodBeat.o(130658);
    return paramLayoutInflater;
  }
  
  protected MagicBrushView aH(Context paramContext)
  {
    AppMethodBeat.i(130659);
    paramContext = new MagicBrushView(paramContext, MagicBrushView.h.cPc);
    AppMethodBeat.o(130659);
    return paramContext;
  }
  
  public final bb aI(Context paramContext)
  {
    return this.cxf;
  }
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(130661);
    paramb.setFullscreenMode(true);
    AppBrandCapsuleBarPlaceHolderView localAppBrandCapsuleBarPlaceHolderView = paramb.getCapsuleView();
    if ((localAppBrandCapsuleBarPlaceHolderView != null) && ((localAppBrandCapsuleBarPlaceHolderView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localAppBrandCapsuleBarPlaceHolderView.getLayoutParams();
      localMarginLayoutParams.rightMargin += paramb.getContext().getResources().getDimensionPixelSize(2131165795);
      localMarginLayoutParams.topMargin += paramb.getContext().getResources().getDimensionPixelSize(2131165796);
      localAppBrandCapsuleBarPlaceHolderView.requestLayout();
    }
    AppMethodBeat.o(130661);
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(130667);
    ((com.tencent.luggage.sdk.b.a.c)NN()).NQ().c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(130667);
    return true;
  }
  
  public void ca(View paramView)
  {
    AppMethodBeat.i(222891);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(222891);
      return;
    }
    if (this.cxh.compareAndSet(false, true)) {
      ((com.tencent.luggage.sdk.b.a.c)NN()).adM("onNativeWidgetViewAdded");
    }
    AppMethodBeat.o(222891);
  }
  
  public void cb(View paramView)
  {
    AppMethodBeat.i(130660);
    paramView = (com.tencent.luggage.game.d.a.a.b)S(com.tencent.luggage.game.d.a.a.b.class);
    if (paramView == null)
    {
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.d(), "hy: not on game service!", new Object[0]);
      AppMethodBeat.o(130660);
      return;
    }
    this.cwZ = aH(getContext());
    this.cwZ.setId(2131296811);
    paramView = paramView.getMagicBrush();
    this.cwZ.setMagicBrush(paramView);
    paramView.cLy.add(new com.tencent.magicbrush.e.b()
    {
      public final void onFirstFrame()
      {
        AppMethodBeat.i(130652);
        if (h.b(h.this).compareAndSet(false, true))
        {
          ((com.tencent.luggage.sdk.b.a.c)h.this.NN()).adM("onFirstFrame");
          com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageReady_Game);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageInit_Game);
        }
        AppMethodBeat.o(130652);
      }
    });
    this.cwY.addView(this.cwZ, 0, new FrameLayout.LayoutParams(-1, -1));
    this.cxb = new b(getContext());
    this.cxb.setNativeWidgetAddedCallback(this);
    this.cwY.addView(this.cxb, -1, new ViewGroup.LayoutParams(-1, -1));
    this.cxa = new c(this.cxb);
    this.cxa.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)NN()).getFullscreenImpl());
    this.cxa.a(new bd()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(130653);
        if ((paramAnonymousAppBrandPageFullScreenView != null) && (paramAnonymousAppBrandPageFullScreenView.getParent() == null)) {
          h.this.cwY.addView(paramAnonymousAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(130653);
      }
    });
    paramView = this.cxa;
    Object localObject1 = new bg()
    {
      public final void a(FrameLayout paramAnonymousFrameLayout)
      {
        AppMethodBeat.i(178040);
        if ((paramAnonymousFrameLayout != null) && (paramAnonymousFrameLayout.getParent() == null)) {
          h.this.cwY.addView(paramAnonymousFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(178040);
      }
    };
    Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.TRUE });
    paramView.nsE = ((bg)localObject1);
    if (paramView.nsD != null)
    {
      if ((!ao.$assertionsDisabled) && (paramView.nsE == null))
      {
        paramView = new AssertionError();
        AppMethodBeat.o(130660);
        throw paramView;
      }
      paramView.nsE.a(paramView.nsD);
    }
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)NN()).NP().OM().cyC;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)NN()).NP().OM().cyC;
    if ((bool1) || (bool2))
    {
      ??? = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)NN()).NQ().S(com.tencent.luggage.game.d.a.a.b.class);
      if (??? == null) {
        break label902;
      }
      paramView = ((com.tencent.luggage.game.d.a.a.b)???).Mg();
      localObject1 = new com.tencent.luggage.game.c.e.b();
      ((com.tencent.luggage.game.c.e.b)localObject1).cuQ = ((k)NN());
      ((com.tencent.luggage.game.c.e.b)localObject1).cvr = ((com.tencent.luggage.game.d.a.a.b)???).getMagicBrush();
      ((com.tencent.luggage.game.c.e.b)localObject1).cvs = this.cwY;
      ((com.tencent.luggage.game.c.e.b)localObject1).cvt = bool1;
      ((com.tencent.luggage.game.c.e.b)localObject1).cvu = bool2;
      ((com.tencent.luggage.game.c.e.b)localObject1).cvv = new e.c()
      {
        public final void F(List<com.tencent.luggage.game.c.f> paramAnonymousList)
        {
          AppMethodBeat.i(178041);
          try
          {
            h localh = h.this;
            Object localObject = this.cxm.getMagicBrush();
            if (localObject == null)
            {
              Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
              AppMethodBeat.o(178041);
              return;
            }
            localObject = ((MBRuntime)localObject).cxx.QP();
            paramAnonymousList.add(new com.tencent.luggage.game.c.f("MinFPS", Math.round(localh.cxg)));
            paramAnonymousList.add(new com.tencent.luggage.game.c.f("RT-FPS", Math.round(((com.tencent.magicbrush.a)localObject).cKu)));
            paramAnonymousList.add(new com.tencent.luggage.game.c.f("EX-FPS", Math.round(((com.tencent.magicbrush.a)localObject).cKv)));
            AppMethodBeat.o(178041);
            return;
          }
          catch (Exception paramAnonymousList)
          {
            AppMethodBeat.o(178041);
          }
        }
      };
      paramView.cuW = ((com.tencent.luggage.game.c.e.b)localObject1).cvr;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(130660);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((com.tencent.luggage.game.c.e.b)localObject1).cvs.getContext();
        if (((com.tencent.luggage.game.c.e.b)localObject1).cvt)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cvv;
          paramView.cvg = new com.tencent.luggage.game.c.d(paramView.mContext);
          paramView.cvg.cvd = ((e.c)???);
          paramView.cvg.setBackground(paramView.mContext.getResources().getDrawable(2131231006));
        }
        if (((com.tencent.luggage.game.c.e.b)localObject1).cvu)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cuQ;
          paramView.cvh = com.tencent.luggage.game.c.b.a(paramView.cuW, paramView.mContext, (k)???);
        }
        ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cvs;
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams;
        if (paramView.cvh != null)
        {
          localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.cvh.getView(), localLayoutParams);
          localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 8388693;
          localLayoutParams.bottomMargin = ((int)(55.0F * f));
          int i = (int)(f * 15.0F);
          localLayoutParams.rightMargin = i;
          localLayoutParams.leftMargin = i;
          ((FrameLayout)???).addView(paramView.cvh.cuT, localLayoutParams);
        }
        if (paramView.cvg != null)
        {
          localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
          localLayoutParams.topMargin = j.cDv.aP(paramView.mContext);
          ((FrameLayout)???).addView(paramView.cvg, localLayoutParams);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.cvi)
      {
        if (paramView.mState != 0)
        {
          this.cxe = new ImageView(getContext());
          this.cxe.setVisibility(8);
          this.cwY.addView(this.cxe, new FrameLayout.LayoutParams(-1, -1));
          this.cwY.addOnAttachStateChangeListener(this.cxi);
          AppMethodBeat.o(130660);
          return;
        }
        paramView.mState = 1;
        if ((((com.tencent.luggage.game.c.e.b)localObject1).cvu) && (paramView.cvh != null)) {
          paramView.cvh.post(new e.1(paramView));
        }
      }
      label902:
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.d(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  public final RelativeLayout.LayoutParams cc(View paramView)
  {
    AppMethodBeat.i(222889);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(222889);
    return paramView;
  }
  
  public void dispatchDestroy()
  {
    AppMethodBeat.i(130665);
    super.dispatchDestroy();
    Nh();
    Ni();
    if ((NN() != null) && (((com.tencent.luggage.sdk.b.a.c)NN()).NQ() != null) && (((com.tencent.luggage.sdk.b.a.c)NN()).NQ().S(com.tencent.luggage.game.d.a.a.b.class) != null))
    {
      com.tencent.luggage.game.c.e locale = ((com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)NN()).NQ().S(com.tencent.luggage.game.d.a.a.b.class)).Mg();
      locale.mState = 2;
      locale.cvj.cxP.clear();
      locale.cuW = null;
      if (locale.cvh != null)
      {
        locale.cvh.cuP.destroy();
        locale.cvh = null;
      }
      if (locale.cvg != null)
      {
        locale.cvg.cve.stopTimer();
        locale.cvg = null;
      }
    }
    AppMethodBeat.o(130665);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(130662);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.luggage.game.page.a.b((ac)NN()));
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new g((ac)NN(), NP().getAppConfig().lbP.cBG));
    AppMethodBeat.o(130662);
  }
  
  public final boolean dy(String paramString)
  {
    return true;
  }
  
  public final ao getCustomViewContainer()
  {
    return this.cxa;
  }
  
  public final Bitmap u(int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(130670);
    Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
    if (paramInt == -1)
    {
      Log.e("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
      AppMethodBeat.o(130670);
      return null;
    }
    Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.cwZ == null) {
      Log.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(130670);
      return localBitmap;
      localBitmap = this.cwZ.getMagicBrush().cLA.h(this.cwZ.getVirtualElementId(), paramInt, false);
    }
  }
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222890);
    ((com.tencent.luggage.sdk.b.a.c)NN()).NQ().c(paramString1, paramString2, 0);
    AppMethodBeat.o(222890);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */