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
import com.tencent.luggage.game.c.e.1;
import com.tencent.luggage.game.c.e.c;
import com.tencent.luggage.game.c.f;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.wxa.a.a.d;
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
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.threadpool.i;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.c.a<PAGE>
  implements b.b, d
{
  protected WAGamePageViewContainerLayout enB;
  private MagicBrushView enC;
  private ap enD;
  protected b enE;
  private final AtomicBoolean enF;
  private Bitmap enG;
  private Bitmap enH;
  private ImageView enI;
  private final a enJ;
  private double enK;
  private AtomicBoolean enL;
  private final View.OnAttachStateChangeListener enM;
  
  public h(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(130656);
    this.enF = new AtomicBoolean(true);
    this.enK = 60.0D;
    this.enL = new AtomicBoolean(false);
    this.enM = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(130651);
        Log.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
        h.a(h.this).getMagicBrush().avl();
        h.a(h.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(130650);
            h.this.enB.removeOnAttachStateChangeListener(jdField_this);
            AppMethodBeat.o(130650);
          }
        });
        AppMethodBeat.o(130651);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    };
    this.enJ = new a();
    aqc();
    a(paramPAGE.ara().esM);
    AppMethodBeat.o(130656);
  }
  
  protected static void a(MBRuntime paramMBRuntime, List<f> paramList)
  {
    AppMethodBeat.i(220156);
    if (paramMBRuntime == null)
    {
      Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
      AppMethodBeat.o(220156);
      return;
    }
    paramMBRuntime = paramMBRuntime.eod.auZ();
    paramList.add(new f("RT-FPS", Math.round(paramMBRuntime.eGw)));
    paramList.add(new f("EX-FPS", Math.round(paramMBRuntime.eGx)));
    paramList.add(new f("Jank", paramMBRuntime.eGy));
    paramList.add(new f("BigJank", paramMBRuntime.eGz));
    paramList.add(new f("Stutter", String.format(Locale.ENGLISH, "%.2f%%", new Object[] { Float.valueOf(paramMBRuntime.eGA * 100.0F) })));
    AppMethodBeat.o(220156);
  }
  
  private void aqj()
  {
    AppMethodBeat.i(130668);
    Runnable local7;
    if (this.enI != null)
    {
      local7 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220148);
          if (h.c(h.this) == null)
          {
            AppMethodBeat.o(220148);
            return;
          }
          BitmapDrawable localBitmapDrawable;
          if ((h.c(h.this).getDrawable() instanceof BitmapDrawable))
          {
            localBitmapDrawable = (BitmapDrawable)h.c(h.this).getDrawable();
            h.c(h.this).setImageDrawable(null);
          }
          try
          {
            localBitmapDrawable.getBitmap().recycle();
            h.c(h.this).setVisibility(8);
            AppMethodBeat.o(220148);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: cleanupCoverScreenshot error!", new Object[0]);
            }
          }
        }
      };
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label61;
      }
      local7.run();
    }
    for (;;)
    {
      if (this.enG != null) {}
      try
      {
        this.enG.recycle();
        this.enG = null;
        AppMethodBeat.o(130668);
        return;
      }
      catch (Exception localException)
      {
        try
        {
          label61:
          com.tencent.threadpool.h.ahAA.bk(local7).get();
        }
        catch (ExecutionException localExecutionException)
        {
          for (;;)
          {
            Log.e("Luggage.Game.WAGamePageViewRenderer", "cleanupCoverScreenshot await ui get exception %s", new Object[] { localExecutionException });
            break;
            localException = localException;
            Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: cleanupCoverScreenshot error!", new Object[0]);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          label80:
          break label80;
        }
      }
    }
  }
  
  private void aqk()
  {
    AppMethodBeat.i(130673);
    if (this.enH != null) {}
    try
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
      this.enH.recycle();
      this.enH = null;
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
  
  public final boolean H(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220217);
    ((com.tencent.luggage.sdk.b.a.c)aqX()).ara().cJ(paramString1, paramString2);
    AppMethodBeat.o(220217);
    return true;
  }
  
  public final Bitmap K(int paramInt, boolean paramBoolean)
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
    if (this.enC == null) {
      Log.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(130670);
      return localBitmap;
      localBitmap = this.enC.getMagicBrush().eHE.j(this.enC.getVirtualElementId(), paramInt, false);
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(130658);
    paramLayoutInflater = new WAGamePageViewContainerLayout(paramLayoutInflater.getContext());
    this.enB = paramLayoutInflater;
    AppMethodBeat.o(130658);
    return paramLayoutInflater;
  }
  
  public final void apR()
  {
    AppMethodBeat.i(220223);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220144);
        h.d(h.this);
        h.this.enB.setOnConfigurationChangedListener(null);
        AppMethodBeat.o(220144);
      }
    });
    AppMethodBeat.o(220223);
  }
  
  public MagicBrushView apS()
  {
    return this.enC;
  }
  
  public final void apT()
  {
    AppMethodBeat.i(130671);
    Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
    try
    {
      aqk();
      this.enH = com.tencent.magicbrush.b.a(this.enC.getMagicBrush().eHE);
      AppMethodBeat.o(130671);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: captureDefaultWindow error!", new Object[0]);
      AppMethodBeat.o(130671);
    }
  }
  
  public final Bitmap apU()
  {
    AppMethodBeat.i(130672);
    if (this.enH != null)
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
      Bitmap localBitmap = this.enH;
      AppMethodBeat.o(130672);
      return localBitmap;
    }
    AppMethodBeat.o(130672);
    return null;
  }
  
  protected void aqc()
  {
    AppMethodBeat.i(130657);
    b(d.class, this);
    AppMethodBeat.o(130657);
  }
  
  public final bh aqd()
  {
    return this.enE;
  }
  
  public void aqe()
  {
    AppMethodBeat.i(130663);
    super.aqe();
    if (this.enF.get()) {
      aqj();
    }
    aqk();
    this.enC.getMagicBrush().avl();
    AppMethodBeat.o(130663);
  }
  
  public void aqf()
  {
    AppMethodBeat.i(130664);
    super.aqf();
    this.enC.getMagicBrush().avm();
    AppMethodBeat.o(130664);
  }
  
  public final boolean aqg()
  {
    return false;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> aqh()
  {
    AppMethodBeat.i(130666);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(130666);
    return localMap;
  }
  
  public final void aqi() {}
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(130661);
    paramb.setFullscreenMode(true);
    com.tencent.mm.plugin.appbrand.page.capsulebar.p.dG(paramb.getCapsuleView());
    com.tencent.mm.plugin.appbrand.page.capsulebar.p.dH(paramb);
    AppMethodBeat.o(130661);
  }
  
  public final boolean b(String paramString, cb paramcb)
  {
    return true;
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(220248);
    if (this.enB == null)
    {
      AppMethodBeat.o(220248);
      return;
    }
    paramContext = AndroidContextUtil.castActivityOrNull(paramContext);
    if (paramContext != null)
    {
      this.enB.mActivity = paramContext;
      AppMethodBeat.o(220248);
      return;
    }
    this.enB.mActivity = null;
    AppMethodBeat.o(220248);
  }
  
  protected MagicBrushView bn(Context paramContext)
  {
    AppMethodBeat.i(130659);
    paramContext = new MagicBrushView(paramContext, MagicBrushView.h.eKY);
    AppMethodBeat.o(130659);
    return paramContext;
  }
  
  public final bd bo(Context paramContext)
  {
    return this.enJ;
  }
  
  public void cO(View paramView)
  {
    AppMethodBeat.i(220244);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(220244);
      return;
    }
    if (this.enL.compareAndSet(false, true)) {
      ((com.tencent.luggage.sdk.b.a.c)aqX()).aeN("onNativeWidgetViewAdded");
    }
    AppMethodBeat.o(220244);
  }
  
  public final RelativeLayout.LayoutParams cP(View paramView)
  {
    AppMethodBeat.i(220187);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(220187);
    return paramView;
  }
  
  public void dispatchDestroy()
  {
    AppMethodBeat.i(130665);
    super.dispatchDestroy();
    aqj();
    aqk();
    if ((aqX() != null) && (((com.tencent.luggage.sdk.b.a.c)aqX()).ara() != null) && (((com.tencent.luggage.sdk.b.a.c)aqX()).ara().aa(com.tencent.luggage.game.d.a.a.b.class) != null))
    {
      com.tencent.luggage.game.c.e locale = ((com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)aqX()).ara().aa(com.tencent.luggage.game.d.a.a.b.class)).apg();
      locale.mState = 2;
      locale.els.eoq.clear();
      locale.elf = null;
      if (locale.elq != null)
      {
        locale.elq.ekY.destroy();
        locale.elq = null;
      }
      if (locale.elp != null)
      {
        com.tencent.luggage.game.c.d locald = locale.elp;
        locald.eln.stopTimer();
        locald.elm = null;
        locald.ell.clear();
        locale.elp = null;
      }
    }
    if ((this.enB != null) && (this.enB.mActivity != null)) {
      this.enB.mActivity = null;
    }
    AppMethodBeat.o(130665);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(130662);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.luggage.game.page.a.b((ad)aqX()));
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new g((ad)aqX(), aqZ().getAppConfig().qVI.euP));
    if ((((com.tencent.luggage.sdk.b.a.c)aqX()).qwF instanceof o)) {
      this.enB.mActivity = AndroidContextUtil.castActivityOrNull(((o)((com.tencent.luggage.sdk.b.a.c)aqX()).qwF).mContext);
    }
    AppMethodBeat.o(130662);
  }
  
  public final boolean e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(130667);
    ((com.tencent.luggage.sdk.b.a.c)aqX()).ara().f(paramString1, paramString2, paramInt);
    AppMethodBeat.o(130667);
    return true;
  }
  
  public final ap getCustomViewContainer()
  {
    return this.enD;
  }
  
  public final void l(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(220228);
    aqj();
    this.enF.set(paramBoolean1);
    if (!apS().getMagicBrush().eHm.aoN())
    {
      AppMethodBeat.o(220228);
      return;
    }
    Log.i("Luggage.Game.WAGamePageViewRenderer", "hy:markBeforeStartToTransparent");
    Object localObject = (com.tencent.luggage.game.d.a.a.b)aa(com.tencent.luggage.game.d.a.a.b.class);
    if (localObject != null) {}
    for (localObject = ((com.tencent.luggage.game.d.a.a.b)localObject).getMagicBrush();; localObject = null)
    {
      if ((paramBoolean2) && (localObject != null) && (((MBRuntime)localObject).avp()))
      {
        Log.i("Luggage.Game.WAGamePageViewRenderer", "isMali use logo");
        localObject = aqZ().asA().iconUrl;
        com.tencent.mm.plugin.appbrand.utils.g.a(aqZ().ari(), (String)localObject, null, new g.a()
        {
          public final void onLoad(String paramAnonymousString)
          {
            AppMethodBeat.i(220145);
            Log.i("Luggage.Game.WAGamePageViewRenderer", "loadIcon, localPath: ".concat(String.valueOf(paramAnonymousString)));
            h.a(h.this, BitmapUtil.getBitmapNative(paramAnonymousString));
            if (h.e(h.this) == null)
            {
              Log.w("Luggage.Game.WAGamePageViewRenderer", "loadIcon, Bitmap is null");
              AppMethodBeat.o(220145);
              return;
            }
            h.a(h.this, BitmapUtil.fastblur(h.e(h.this), 3));
            h.c(h.this).setScaleType(ImageView.ScaleType.CENTER_CROP);
            h.this.m(this.enR, paramBoolean1);
            AppMethodBeat.o(220145);
          }
        });
        AppMethodBeat.o(220228);
        return;
      }
      if (this.enC == null) {
        Log.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
      }
      for (localObject = null;; localObject = com.tencent.magicbrush.b.a(this.enC.getMagicBrush().eHE))
      {
        this.enG = ((Bitmap)localObject);
        if (this.enG != null) {
          break;
        }
        Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
        AppMethodBeat.o(220228);
        return;
      }
      m(true, paramBoolean1);
      AppMethodBeat.o(220228);
      return;
    }
  }
  
  public final void m(boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(220233);
    com.tencent.mm.plugin.appbrand.platform.window.e.b localb = ((com.tencent.luggage.sdk.b.a.c)aqX()).qwF.getOrientationHandler().cHQ();
    if (org.apache.commons.c.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { com.tencent.mm.plugin.appbrand.platform.window.e.b.tLj, com.tencent.mm.plugin.appbrand.platform.window.e.b.tLk, com.tencent.mm.plugin.appbrand.platform.window.e.b.tLl, com.tencent.mm.plugin.appbrand.platform.window.e.b.tLm }, localb))
    {
      Log.i("Luggage.Game.WAGamePageViewRenderer", "hy:deal with landscape games");
      if (this.enI == null)
      {
        Log.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(220233);
        return;
      }
      this.enB.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a()
      {
        public final void a(WAGamePageViewContainerLayout.b paramAnonymousb1, WAGamePageViewContainerLayout.b paramAnonymousb2)
        {
          AppMethodBeat.i(220146);
          Log.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramAnonymousb1, paramAnonymousb2 });
          if (((h.a(paramAnonymousb1)) && (h.a(paramAnonymousb2))) || ((h.b(paramAnonymousb1)) && (h.b(paramAnonymousb2))))
          {
            AppMethodBeat.o(220146);
            return;
          }
          if (h.a(paramAnonymousb2))
          {
            Matrix localMatrix = new Matrix();
            if (((paramAnonymousb2 == WAGamePageViewContainerLayout.b.enr) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.ens)) || ((paramAnonymousb2 == WAGamePageViewContainerLayout.b.ent) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.enu))) {
              localMatrix.postRotate(90.0F);
            }
            for (;;)
            {
              h.c(h.this).setVisibility(0);
              h.c(h.this).setImageBitmap(Bitmap.createBitmap(h.e(h.this), 0, 0, h.e(h.this).getWidth(), h.e(h.this).getHeight(), localMatrix, true));
              AppMethodBeat.o(220146);
              return;
              localMatrix.postRotate(270.0F);
            }
          }
          if (paramBoolean2)
          {
            h.this.enB.setOnConfigurationChangedListener(null);
            AppMethodBeat.o(220146);
            return;
          }
          h.c(h.this).setImageBitmap(h.e(h.this));
          AppMethodBeat.o(220146);
        }
      });
      AppMethodBeat.o(220233);
      return;
    }
    if (paramBoolean1) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220147);
          h.c(h.this).setVisibility(0);
          h.c(h.this).setImageBitmap(h.e(h.this));
          AppMethodBeat.o(220147);
        }
      });
    }
    AppMethodBeat.o(220233);
  }
  
  public void onViewCreated(View paramView)
  {
    AppMethodBeat.i(130660);
    paramView = (com.tencent.luggage.game.d.a.a.b)aa(com.tencent.luggage.game.d.a.a.b.class);
    if (paramView == null)
    {
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.d(), "hy: not on game service!", new Object[0]);
      AppMethodBeat.o(130660);
      return;
    }
    this.enC = bn(getContext());
    this.enC.setId(a.d.app_brand_game_render_view);
    paramView = paramView.getMagicBrush();
    this.enC.setMagicBrush(paramView);
    paramView.eHC.add(new com.tencent.magicbrush.e.b()
    {
      public final void onFirstFrame()
      {
        AppMethodBeat.i(130652);
        if (h.b(h.this).compareAndSet(false, true))
        {
          ((com.tencent.luggage.sdk.b.a.c)h.this.aqX()).aeN("onFirstFrame");
          com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageReady_Game);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageInit_Game);
        }
        AppMethodBeat.o(130652);
      }
    });
    this.enB.addView(this.enC, 0, new FrameLayout.LayoutParams(-1, -1));
    this.enE = new b(getContext());
    this.enE.setNativeWidgetAddedCallback(this);
    this.enB.addView(this.enE, -1, new ViewGroup.LayoutParams(-1, -1));
    this.enD = new c(this.enE);
    this.enD.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)aqX()).getFullscreenImpl());
    this.enD.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(130653);
        if ((paramAnonymousAppBrandPageFullScreenView != null) && (paramAnonymousAppBrandPageFullScreenView.getParent() == null)) {
          h.this.enB.addView(paramAnonymousAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(130653);
      }
    });
    paramView = this.enD;
    Object localObject1 = new bi()
    {
      public final void a(FrameLayout paramAnonymousFrameLayout)
      {
        AppMethodBeat.i(178040);
        if ((paramAnonymousFrameLayout != null) && (paramAnonymousFrameLayout.getParent() == null)) {
          h.this.enB.addView(paramAnonymousFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(178040);
      }
    };
    Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.TRUE });
    paramView.tzo = ((bi)localObject1);
    if (paramView.tzn != null)
    {
      if ((!ap.$assertionsDisabled) && (paramView.tzo == null))
      {
        paramView = new AssertionError();
        AppMethodBeat.o(130660);
        throw paramView;
      }
      paramView.tzo.a(paramView.tzn);
    }
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ().asz().epz;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)aqX()).aqZ().asz().epz;
    if ((bool1) || (bool2))
    {
      ??? = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)aqX()).ara().aa(com.tencent.luggage.game.d.a.a.b.class);
      if (??? == null) {
        break label893;
      }
      paramView = ((com.tencent.luggage.game.d.a.a.b)???).apg();
      localObject1 = new com.tencent.luggage.game.c.e.b();
      ((com.tencent.luggage.game.c.e.b)localObject1).ekZ = ((com.tencent.mm.plugin.appbrand.jsapi.k)aqX());
      ((com.tencent.luggage.game.c.e.b)localObject1).elA = ((com.tencent.luggage.game.d.a.a.b)???).getMagicBrush();
      ((com.tencent.luggage.game.c.e.b)localObject1).elB = this.enB;
      ((com.tencent.luggage.game.c.e.b)localObject1).elC = bool1;
      ((com.tencent.luggage.game.c.e.b)localObject1).elD = bool2;
      ((com.tencent.luggage.game.c.e.b)localObject1).elE = new e.c()
      {
        public final void ba(List<f> paramAnonymousList)
        {
          AppMethodBeat.i(178041);
          try
          {
            h.a(this.enQ.getMagicBrush(), paramAnonymousList);
            AppMethodBeat.o(178041);
            return;
          }
          catch (Exception paramAnonymousList)
          {
            AppMethodBeat.o(178041);
          }
        }
      };
      paramView.elf = ((com.tencent.luggage.game.c.e.b)localObject1).elA;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(130660);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((com.tencent.luggage.game.c.e.b)localObject1).elB.getContext();
        if (((com.tencent.luggage.game.c.e.b)localObject1).elC)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).elE;
          paramView.elp = new com.tencent.luggage.game.c.d(paramView.mContext);
          paramView.elp.elm = ((e.c)???);
        }
        if (((com.tencent.luggage.game.c.e.b)localObject1).elD)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).ekZ;
          paramView.elq = com.tencent.luggage.game.c.b.a(paramView.elf, paramView.mContext, (com.tencent.mm.plugin.appbrand.jsapi.k)???);
        }
        ??? = ((com.tencent.luggage.game.c.e.b)localObject1).elB;
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        FrameLayout.LayoutParams localLayoutParams;
        if (paramView.elq != null)
        {
          localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.elq.getView(), localLayoutParams);
          localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 8388693;
          localLayoutParams.bottomMargin = ((int)(55.0F * f));
          int i = (int)(15.0F * f);
          localLayoutParams.rightMargin = i;
          localLayoutParams.leftMargin = i;
          ((FrameLayout)???).addView(paramView.elq.elc, localLayoutParams);
        }
        if (paramView.elp != null)
        {
          localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
          localLayoutParams.topMargin = com.tencent.luggage.l.k.exm.bw(paramView.mContext);
          localLayoutParams.leftMargin = ((int)(f * 16.0F));
          ((FrameLayout)???).addView(paramView.elp, localLayoutParams);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.elr)
      {
        if (paramView.mState != 0)
        {
          this.enI = new ImageView(getContext());
          this.enI.setVisibility(8);
          this.enB.addView(this.enI, new FrameLayout.LayoutParams(-1, -1));
          this.enB.addOnAttachStateChangeListener(this.enM);
          AppMethodBeat.o(130660);
          return;
        }
        paramView.mState = 1;
        if ((((com.tencent.luggage.game.c.e.b)localObject1).elD) && (paramView.elq != null)) {
          paramView.elq.post(new e.1(paramView));
        }
      }
      label893:
      Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.d(), "hy: you're not on game service!", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */