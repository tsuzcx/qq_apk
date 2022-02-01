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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.i;
import com.tencent.luggage.game.c.e.1;
import com.tencent.luggage.game.c.e.c;
import com.tencent.luggage.game.c.f;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.wxa.a.a.c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b.a;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageFullScreenView;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.page.bi;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.capsulebar.k;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements b.b, d
{
  protected WAGamePageViewContainerLayout cvD;
  private MagicBrushView cvE;
  private ap cvF;
  protected b cvG;
  private final AtomicBoolean cvH;
  private Bitmap cvI;
  private Bitmap cvJ;
  private ImageView cvK;
  private final a cvL;
  private double cvM;
  private AtomicBoolean cvN;
  private final View.OnAttachStateChangeListener cvO;
  
  public h(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(130656);
    this.cvH = new AtomicBoolean(true);
    this.cvM = 60.0D;
    this.cvN = new AtomicBoolean(false);
    this.cvO = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(130651);
        Log.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
        h.a(h.this).getMagicBrush().UI();
        h.a(h.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(130650);
            h.this.cvD.removeOnAttachStateChangeListener(jdField_this);
            AppMethodBeat.o(130650);
          }
        });
        AppMethodBeat.o(130651);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    };
    this.cvL = new a();
    PT();
    a(paramPAGE.QN().cAr);
    AppMethodBeat.o(130656);
  }
  
  private void PZ()
  {
    AppMethodBeat.i(130668);
    BitmapDrawable localBitmapDrawable;
    if (this.cvK != null) {
      if ((this.cvK.getDrawable() instanceof BitmapDrawable))
      {
        localBitmapDrawable = (BitmapDrawable)this.cvK.getDrawable();
        this.cvK.setImageDrawable(null);
      }
    }
    try
    {
      localBitmapDrawable.getBitmap().recycle();
      this.cvK.setVisibility(8);
      if (this.cvI == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.cvI.recycle();
        this.cvI = null;
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
  
  private void Qa()
  {
    AppMethodBeat.i(130673);
    if (this.cvJ != null) {}
    try
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
      this.cvJ.recycle();
      this.cvJ = null;
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
  
  protected static void a(MBRuntime paramMBRuntime, List<f> paramList)
  {
    AppMethodBeat.i(247512);
    if (paramMBRuntime == null)
    {
      Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
      AppMethodBeat.o(247512);
      return;
    }
    paramMBRuntime = paramMBRuntime.cwf.Uw();
    paramList.add(new f("RT-FPS", Math.round(paramMBRuntime.cLa)));
    paramList.add(new f("EX-FPS", Math.round(paramMBRuntime.cLb)));
    paramList.add(new f("Jank", paramMBRuntime.cLc));
    paramList.add(new f("BigJank", paramMBRuntime.cLd));
    paramList.add(new f("Stutter", String.format(Locale.ENGLISH, "%.2f%%", new Object[] { Float.valueOf(paramMBRuntime.cLe * 100.0F) })));
    AppMethodBeat.o(247512);
  }
  
  public final boolean C(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247514);
    ((com.tencent.luggage.sdk.b.a.c)QK()).QN().ct(paramString1, paramString2);
    AppMethodBeat.o(247514);
    return true;
  }
  
  public final void PH()
  {
    AppMethodBeat.i(247515);
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247351);
        h.c(h.this);
        h.this.cvD.setOnConfigurationChangedListener(null);
        AppMethodBeat.o(247351);
      }
    });
    AppMethodBeat.o(247515);
  }
  
  public MagicBrushView PI()
  {
    return this.cvE;
  }
  
  public final void PJ()
  {
    AppMethodBeat.i(130671);
    Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
    try
    {
      Qa();
      this.cvJ = com.tencent.magicbrush.b.a(this.cvE.getMagicBrush().cMk);
      AppMethodBeat.o(130671);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: captureDefaultWindow error!", new Object[0]);
      AppMethodBeat.o(130671);
    }
  }
  
  public final Bitmap PK()
  {
    AppMethodBeat.i(130672);
    if (this.cvJ != null)
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
      Bitmap localBitmap = this.cvJ;
      AppMethodBeat.o(130672);
      return localBitmap;
    }
    AppMethodBeat.o(130672);
    return null;
  }
  
  protected void PT()
  {
    AppMethodBeat.i(130657);
    b(d.class, this);
    AppMethodBeat.o(130657);
  }
  
  public final bh PU()
  {
    return this.cvG;
  }
  
  public void PV()
  {
    AppMethodBeat.i(130663);
    super.PV();
    if (this.cvH.get()) {
      PZ();
    }
    Qa();
    this.cvE.getMagicBrush().UI();
    AppMethodBeat.o(130663);
  }
  
  public void PW()
  {
    AppMethodBeat.i(130664);
    super.PW();
    this.cvE.getMagicBrush().UJ();
    AppMethodBeat.o(130664);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> PX()
  {
    AppMethodBeat.i(130666);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(130666);
    return localMap;
  }
  
  public final void PY() {}
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(130658);
    paramLayoutInflater = new WAGamePageViewContainerLayout(paramLayoutInflater.getContext());
    this.cvD = paramLayoutInflater;
    AppMethodBeat.o(130658);
    return paramLayoutInflater;
  }
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(247520);
    if (this.cvD == null)
    {
      AppMethodBeat.o(247520);
      return;
    }
    paramContext = AndroidContextUtil.castActivityOrNull(paramContext);
    if (paramContext != null)
    {
      this.cvD.mActivity = paramContext;
      AppMethodBeat.o(247520);
      return;
    }
    this.cvD.mActivity = null;
    AppMethodBeat.o(247520);
  }
  
  protected MagicBrushView aE(Context paramContext)
  {
    AppMethodBeat.i(130659);
    paramContext = new MagicBrushView(paramContext, MagicBrushView.h.cPT);
    AppMethodBeat.o(130659);
    return paramContext;
  }
  
  public final bd aF(Context paramContext)
  {
    return this.cvL;
  }
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(130661);
    paramb.setFullscreenMode(true);
    k.cZ(paramb.getCapsuleView());
    AppMethodBeat.o(130661);
  }
  
  public final boolean b(String paramString, ca paramca)
  {
    return true;
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(130667);
    ((com.tencent.luggage.sdk.b.a.c)QK()).QN().c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(130667);
    return true;
  }
  
  public void cs(View paramView)
  {
    AppMethodBeat.i(247519);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(247519);
      return;
    }
    if (this.cvN.compareAndSet(false, true)) {
      ((com.tencent.luggage.sdk.b.a.c)QK()).alH("onNativeWidgetViewAdded");
    }
    AppMethodBeat.o(247519);
  }
  
  public void ct(View paramView)
  {
    AppMethodBeat.i(130660);
    paramView = (com.tencent.luggage.game.d.a.a.b)R(com.tencent.luggage.game.d.a.a.b.class);
    if (paramView == null)
    {
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.d(), "hy: not on game service!", new Object[0]);
      AppMethodBeat.o(130660);
      return;
    }
    this.cvE = aE(getContext());
    this.cvE.setId(a.c.app_brand_game_render_view);
    paramView = paramView.getMagicBrush();
    this.cvE.setMagicBrush(paramView);
    paramView.cMi.add(new com.tencent.magicbrush.e.b()
    {
      public final void onFirstFrame()
      {
        AppMethodBeat.i(130652);
        if (h.b(h.this).compareAndSet(false, true))
        {
          ((com.tencent.luggage.sdk.b.a.c)h.this.QK()).alH("onFirstFrame");
          com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageReady_Game);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageInit_Game);
        }
        AppMethodBeat.o(130652);
      }
    });
    this.cvD.addView(this.cvE, 0, new FrameLayout.LayoutParams(-1, -1));
    this.cvG = new b(getContext());
    this.cvG.setNativeWidgetAddedCallback(this);
    this.cvD.addView(this.cvG, -1, new ViewGroup.LayoutParams(-1, -1));
    this.cvF = new c(this.cvG);
    this.cvF.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)QK()).getFullscreenImpl());
    this.cvF.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(130653);
        if ((paramAnonymousAppBrandPageFullScreenView != null) && (paramAnonymousAppBrandPageFullScreenView.getParent() == null)) {
          h.this.cvD.addView(paramAnonymousAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(130653);
      }
    });
    paramView = this.cvF;
    Object localObject1 = new bi()
    {
      public final void a(FrameLayout paramAnonymousFrameLayout)
      {
        AppMethodBeat.i(178040);
        if ((paramAnonymousFrameLayout != null) && (paramAnonymousFrameLayout.getParent() == null)) {
          h.this.cvD.addView(paramAnonymousFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(178040);
      }
    };
    Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.TRUE });
    paramView.qux = ((bi)localObject1);
    if (paramView.quw != null)
    {
      if ((!ap.$assertionsDisabled) && (paramView.qux == null))
      {
        paramView = new AssertionError();
        AppMethodBeat.o(130660);
        throw paramView;
      }
      paramView.qux.a(paramView.quw);
    }
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)QK()).QM().Sj().cxh;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)QK()).QM().Sj().cxh;
    if ((bool1) || (bool2))
    {
      ??? = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)QK()).QN().R(com.tencent.luggage.game.d.a.a.b.class);
      if (??? == null) {
        break label893;
      }
      paramView = ((com.tencent.luggage.game.d.a.a.b)???).OY();
      localObject1 = new com.tencent.luggage.game.c.e.b();
      ((com.tencent.luggage.game.c.e.b)localObject1).cte = ((com.tencent.mm.plugin.appbrand.jsapi.j)QK());
      ((com.tencent.luggage.game.c.e.b)localObject1).ctG = ((com.tencent.luggage.game.d.a.a.b)???).getMagicBrush();
      ((com.tencent.luggage.game.c.e.b)localObject1).ctH = this.cvD;
      ((com.tencent.luggage.game.c.e.b)localObject1).ctI = bool1;
      ((com.tencent.luggage.game.c.e.b)localObject1).ctJ = bool2;
      ((com.tencent.luggage.game.c.e.b)localObject1).ctK = new e.c()
      {
        public final void C(List<f> paramAnonymousList)
        {
          AppMethodBeat.i(178041);
          try
          {
            h.a(this.cvS.getMagicBrush(), paramAnonymousList);
            AppMethodBeat.o(178041);
            return;
          }
          catch (Exception paramAnonymousList)
          {
            AppMethodBeat.o(178041);
          }
        }
      };
      paramView.ctk = ((com.tencent.luggage.game.c.e.b)localObject1).ctG;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(130660);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((com.tencent.luggage.game.c.e.b)localObject1).ctH.getContext();
        if (((com.tencent.luggage.game.c.e.b)localObject1).ctI)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).ctK;
          paramView.ctu = new com.tencent.luggage.game.c.d(paramView.mContext);
          paramView.ctu.ctr = ((e.c)???);
        }
        if (((com.tencent.luggage.game.c.e.b)localObject1).ctJ)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cte;
          paramView.ctv = com.tencent.luggage.game.c.b.a(paramView.ctk, paramView.mContext, (com.tencent.mm.plugin.appbrand.jsapi.j)???);
        }
        ??? = ((com.tencent.luggage.game.c.e.b)localObject1).ctH;
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams;
        if (paramView.ctv != null)
        {
          localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.ctv.getView(), localLayoutParams);
          localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 8388693;
          localLayoutParams.bottomMargin = ((int)(55.0F * f));
          int i = (int)(15.0F * f);
          localLayoutParams.rightMargin = i;
          localLayoutParams.leftMargin = i;
          ((FrameLayout)???).addView(paramView.ctv.cth, localLayoutParams);
        }
        if (paramView.ctu != null)
        {
          localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
          localLayoutParams.topMargin = com.tencent.luggage.k.j.cEc.aM(paramView.mContext);
          localLayoutParams.leftMargin = ((int)(f * 16.0F));
          ((FrameLayout)???).addView(paramView.ctu, localLayoutParams);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.ctw)
      {
        if (paramView.mState != 0)
        {
          this.cvK = new ImageView(getContext());
          this.cvK.setVisibility(8);
          this.cvD.addView(this.cvK, new FrameLayout.LayoutParams(-1, -1));
          this.cvD.addOnAttachStateChangeListener(this.cvO);
          AppMethodBeat.o(130660);
          return;
        }
        paramView.mState = 1;
        if ((((com.tencent.luggage.game.c.e.b)localObject1).ctJ) && (paramView.ctv != null)) {
          paramView.ctv.post(new e.1(paramView));
        }
      }
      label893:
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.d(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  public final RelativeLayout.LayoutParams cu(View paramView)
  {
    AppMethodBeat.i(247510);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(247510);
    return paramView;
  }
  
  public void dispatchDestroy()
  {
    AppMethodBeat.i(130665);
    super.dispatchDestroy();
    PZ();
    Qa();
    if ((QK() != null) && (((com.tencent.luggage.sdk.b.a.c)QK()).QN() != null) && (((com.tencent.luggage.sdk.b.a.c)QK()).QN().R(com.tencent.luggage.game.d.a.a.b.class) != null))
    {
      com.tencent.luggage.game.c.e locale = ((com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)QK()).QN().R(com.tencent.luggage.game.d.a.a.b.class)).OY();
      locale.mState = 2;
      locale.cty.cwr.clear();
      locale.ctk = null;
      if (locale.ctv != null)
      {
        locale.ctv.ctd.destroy();
        locale.ctv = null;
      }
      if (locale.ctu != null)
      {
        locale.ctu.cts.stopTimer();
        locale.ctu = null;
      }
    }
    if ((this.cvD != null) && (this.cvD.mActivity != null)) {
      this.cvD.mActivity = null;
    }
    AppMethodBeat.o(130665);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(130662);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.luggage.game.page.a.b((ad)QK()));
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new g((ad)QK(), QM().getAppConfig().nVY.cCi));
    if ((((com.tencent.luggage.sdk.b.a.c)QK()).nxr instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o)) {
      this.cvD.mActivity = AndroidContextUtil.castActivityOrNull(((com.tencent.mm.plugin.appbrand.platform.window.a.o)((com.tencent.luggage.sdk.b.a.c)QK()).nxr).mContext);
    }
    AppMethodBeat.o(130662);
  }
  
  public final ap getCustomViewContainer()
  {
    return this.cvF;
  }
  
  public final void j(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(247516);
    PZ();
    this.cvH.set(paramBoolean1);
    if (!PI().getMagicBrush().cLS.OF())
    {
      AppMethodBeat.o(247516);
      return;
    }
    Log.i("Luggage.Game.WAGamePageViewRenderer", "hy:markBeforeStartToTransparent");
    Object localObject = (com.tencent.luggage.game.d.a.a.b)R(com.tencent.luggage.game.d.a.a.b.class);
    if (localObject != null) {}
    for (localObject = ((com.tencent.luggage.game.d.a.a.b)localObject).getMagicBrush();; localObject = null)
    {
      if ((paramBoolean2) && (localObject != null) && (((MBRuntime)localObject).UM()))
      {
        Log.i("Luggage.Game.WAGamePageViewRenderer", "isMali use logo");
        localObject = QM().Sk().iconUrl;
        com.tencent.mm.plugin.appbrand.utils.e.a(QM().QW(), (String)localObject, null, new e.a()
        {
          public final void dR(String paramAnonymousString)
          {
            AppMethodBeat.i(246951);
            Log.i("Luggage.Game.WAGamePageViewRenderer", "loadIcon, localPath: ".concat(String.valueOf(paramAnonymousString)));
            h.a(h.this, BitmapUtil.getBitmapNative(paramAnonymousString));
            if (h.d(h.this) == null)
            {
              Log.w("Luggage.Game.WAGamePageViewRenderer", "loadIcon, Bitmap is null");
              AppMethodBeat.o(246951);
              return;
            }
            h.a(h.this, BitmapUtil.fastblur(h.d(h.this), 3));
            h.e(h.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
            h.this.k(this.cvT, paramBoolean1);
            AppMethodBeat.o(246951);
          }
        });
        AppMethodBeat.o(247516);
        return;
      }
      if (this.cvE == null) {
        Log.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
      }
      for (localObject = null;; localObject = com.tencent.magicbrush.b.a(this.cvE.getMagicBrush().cMk))
      {
        this.cvI = ((Bitmap)localObject);
        if (this.cvI != null) {
          break;
        }
        Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
        AppMethodBeat.o(247516);
        return;
      }
      k(true, paramBoolean1);
      AppMethodBeat.o(247516);
      return;
    }
  }
  
  public final void k(boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(247517);
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb = ((com.tencent.luggage.sdk.b.a.c)QK()).nxr.getOrientationHandler().cgS();
    if (org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { com.tencent.mm.plugin.appbrand.platform.window.e.b.qGx, com.tencent.mm.plugin.appbrand.platform.window.e.b.qGy, com.tencent.mm.plugin.appbrand.platform.window.e.b.qGz, com.tencent.mm.plugin.appbrand.platform.window.e.b.qGA }, localb))
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy:deal with landscape games");
      if (this.cvK == null)
      {
        Log.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(247517);
        return;
      }
      this.cvD.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a()
      {
        public final void a(WAGamePageViewContainerLayout.b paramAnonymousb1, WAGamePageViewContainerLayout.b paramAnonymousb2)
        {
          AppMethodBeat.i(247043);
          Log.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramAnonymousb1, paramAnonymousb2 });
          if (((h.a(paramAnonymousb1)) && (h.a(paramAnonymousb2))) || ((h.b(paramAnonymousb1)) && (h.b(paramAnonymousb2))))
          {
            AppMethodBeat.o(247043);
            return;
          }
          if (h.a(paramAnonymousb2))
          {
            Matrix localMatrix = new Matrix();
            if (((paramAnonymousb2 == WAGamePageViewContainerLayout.b.cvt) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.cvu)) || ((paramAnonymousb2 == WAGamePageViewContainerLayout.b.cvw) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.cvx))) {
              localMatrix.postRotate(90.0F);
            }
            for (;;)
            {
              h.e(h.this).setVisibility(0);
              h.e(h.this).setImageBitmap(Bitmap.createBitmap(h.d(h.this), 0, 0, h.d(h.this).getWidth(), h.d(h.this).getHeight(), localMatrix, true));
              AppMethodBeat.o(247043);
              return;
              localMatrix.postRotate(270.0F);
            }
          }
          if (paramBoolean2)
          {
            h.this.cvD.setOnConfigurationChangedListener(null);
            AppMethodBeat.o(247043);
            return;
          }
          h.e(h.this).setImageBitmap(h.d(h.this));
          AppMethodBeat.o(247043);
        }
      });
      AppMethodBeat.o(247517);
      return;
    }
    if (paramBoolean1) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(247183);
          h.e(h.this).setVisibility(0);
          h.e(h.this).setImageBitmap(h.d(h.this));
          AppMethodBeat.o(247183);
        }
      });
    }
    AppMethodBeat.o(247517);
  }
  
  public final Bitmap w(int paramInt, boolean paramBoolean)
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
    if (this.cvE == null) {
      Log.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(130670);
      return localBitmap;
      localBitmap = this.cvE.getMagicBrush().cMk.j(this.cvE.getVirtualElementId(), paramInt, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */