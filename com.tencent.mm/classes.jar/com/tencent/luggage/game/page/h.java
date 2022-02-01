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
import com.tencent.luggage.game.c.f;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements b.b, d
{
  protected WAGamePageViewContainerLayout caK;
  private MagicBrushView caL;
  private am caM;
  protected b caN;
  private Bitmap caO;
  private Bitmap caP;
  private ImageView caQ;
  private final a caR;
  double caS;
  private AtomicBoolean caT;
  private final View.OnAttachStateChangeListener caU;
  
  public h(PAGE arg1)
  {
    super(???);
    AppMethodBeat.i(130656);
    this.caS = 60.0D;
    this.caT = new AtomicBoolean(false);
    this.caU = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(130651);
        ac.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
        h.a(h.this).getMagicBrush().FJ();
        h.a(h.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(130650);
            h.this.caK.removeOnAttachStateChangeListener(jdField_this);
            AppMethodBeat.o(130650);
          }
        });
        AppMethodBeat.o(130651);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    };
    this.caR = new a();
    Cc();
    com.tencent.luggage.sdk.b.a.c.e locale = ???.CP().ceD;
    synchronized (this.ccV)
    {
      this.ccV.putAll(locale.ccV);
      AppMethodBeat.o(130656);
      return;
    }
  }
  
  private void Cj()
  {
    AppMethodBeat.i(130668);
    BitmapDrawable localBitmapDrawable;
    if (this.caQ != null) {
      if ((this.caQ.getDrawable() instanceof BitmapDrawable))
      {
        localBitmapDrawable = (BitmapDrawable)this.caQ.getDrawable();
        this.caQ.setImageDrawable(null);
      }
    }
    try
    {
      localBitmapDrawable.getBitmap().recycle();
      this.caQ.setVisibility(8);
      if (this.caO == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.caO.recycle();
        this.caO = null;
        AppMethodBeat.o(130668);
        return;
        localException1 = localException1;
        ac.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException1, "hy: cleanupCoverScreenshot error!", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException2, "hy: cleanupCoverScreenshot error!", new Object[0]);
        }
      }
    }
  }
  
  private void Ck()
  {
    AppMethodBeat.i(130673);
    if (this.caP != null) {}
    try
    {
      ac.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
      this.caP.recycle();
      this.caP = null;
      AppMethodBeat.o(130673);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: cleanupCanvasSecurityGuard error!", new Object[0]);
      }
    }
  }
  
  public final void BQ()
  {
    AppMethodBeat.i(130669);
    Cj();
    if (!BR().getMagicBrush().clT.AU())
    {
      AppMethodBeat.o(130669);
      return;
    }
    Object localObject = ((com.tencent.luggage.sdk.b.a.c)CM()).jgX.getOrientationHandler().aUB();
    if (org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.r.a.e.b[] { com.tencent.mm.plugin.appbrand.r.a.e.b.lOS, com.tencent.mm.plugin.appbrand.r.a.e.b.lOT, com.tencent.mm.plugin.appbrand.r.a.e.b.lOU, com.tencent.mm.plugin.appbrand.r.a.e.b.lOV }, localObject))
    {
      if (this.caQ == null)
      {
        ac.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(130669);
        return;
      }
      if (this.caL != null) {
        break label151;
      }
      ac.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
    }
    label151:
    for (localObject = null;; localObject = com.tencent.magicbrush.b.a(this.caL.getMagicBrush().cml))
    {
      this.caO = ((Bitmap)localObject);
      this.caK.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a()
      {
        public final void a(WAGamePageViewContainerLayout.b paramAnonymousb1, WAGamePageViewContainerLayout.b paramAnonymousb2)
        {
          AppMethodBeat.i(178042);
          ac.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramAnonymousb1, paramAnonymousb2 });
          if (h.c(h.this) == null)
          {
            ac.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
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
            if (((paramAnonymousb2 == WAGamePageViewContainerLayout.b.caB) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.caC)) || ((paramAnonymousb2 == WAGamePageViewContainerLayout.b.caD) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.caE))) {
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
          h.this.caK.setOnConfigurationChangedListener(null);
          AppMethodBeat.o(178042);
        }
      });
      AppMethodBeat.o(130669);
      return;
    }
  }
  
  public MagicBrushView BR()
  {
    return this.caL;
  }
  
  public final void BS()
  {
    AppMethodBeat.i(130671);
    ac.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
    try
    {
      Ck();
      this.caP = com.tencent.magicbrush.b.a(this.caL.getMagicBrush().cml);
      AppMethodBeat.o(130671);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: captureDefaultWindow error!", new Object[0]);
      AppMethodBeat.o(130671);
    }
  }
  
  public final Bitmap BT()
  {
    AppMethodBeat.i(130672);
    if (this.caP != null)
    {
      ac.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
      Bitmap localBitmap = this.caP;
      AppMethodBeat.o(130672);
      return localBitmap;
    }
    AppMethodBeat.o(130672);
    return null;
  }
  
  protected void Cc()
  {
    AppMethodBeat.i(130657);
    b(d.class, this);
    AppMethodBeat.o(130657);
  }
  
  public final bc Cd()
  {
    return this.caN;
  }
  
  public final am Ce()
  {
    return this.caM;
  }
  
  public final void Cf()
  {
    AppMethodBeat.i(130663);
    super.Cf();
    Cj();
    Ck();
    this.caL.getMagicBrush().FJ();
    AppMethodBeat.o(130663);
  }
  
  public void Cg()
  {
    AppMethodBeat.i(130664);
    super.Cg();
    this.caL.getMagicBrush().FK();
    AppMethodBeat.o(130664);
  }
  
  public final Map<String, m> Ch()
  {
    AppMethodBeat.i(130666);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(130666);
    return localMap;
  }
  
  public final void Ci() {}
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(130658);
    paramLayoutInflater = new WAGamePageViewContainerLayout(paramLayoutInflater.getContext());
    this.caK = paramLayoutInflater;
    AppMethodBeat.o(130658);
    return paramLayoutInflater;
  }
  
  protected MagicBrushView ax(Context paramContext)
  {
    AppMethodBeat.i(130659);
    paramContext = new MagicBrushView(paramContext, MagicBrushView.h.cpy);
    AppMethodBeat.o(130659);
    return paramContext;
  }
  
  public final ay ay(Context paramContext)
  {
    return this.caR;
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
    ((com.tencent.luggage.sdk.b.a.c)CM()).CP().c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(130667);
    return true;
  }
  
  public final boolean cd(String paramString)
  {
    return true;
  }
  
  public void cl(View paramView)
  {
    AppMethodBeat.i(206109);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(206109);
      return;
    }
    if (this.caT.compareAndSet(false, true)) {
      ((com.tencent.luggage.sdk.b.a.c)CM()).onReady();
    }
    AppMethodBeat.o(206109);
  }
  
  public void cm(View paramView)
  {
    AppMethodBeat.i(130660);
    paramView = (com.tencent.luggage.game.d.a.a.b)Q(com.tencent.luggage.game.d.a.a.b.class);
    if (paramView == null)
    {
      ac.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.c(), "hy: not on game service!", new Object[0]);
      AppMethodBeat.o(130660);
      return;
    }
    this.caL = ax(getContext());
    this.caL.setId(2131296729);
    paramView = paramView.getMagicBrush();
    this.caL.setMagicBrush(paramView);
    paramView.cmj.add(new d.b()
    {
      public final void onFirstFrame()
      {
        AppMethodBeat.i(130652);
        if (h.b(h.this).compareAndSet(false, true)) {
          ((com.tencent.luggage.sdk.b.a.c)h.this.CM()).onReady();
        }
        AppMethodBeat.o(130652);
      }
    });
    this.caK.addView(this.caL, 0, new FrameLayout.LayoutParams(-1, -1));
    this.caN = new b(getContext());
    this.caN.setNativeWidgetAddedCallback(this);
    this.caK.addView(this.caN, -1, new ViewGroup.LayoutParams(-1, -1));
    this.caM = new c(this.caN);
    this.caM.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)CM()).getFullscreenImpl());
    this.caM.a(new ba()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(130653);
        if ((paramAnonymousAppBrandPageFullScreenView != null) && (paramAnonymousAppBrandPageFullScreenView.getParent() == null)) {
          h.this.caK.addView(paramAnonymousAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(130653);
      }
    });
    paramView = this.caM;
    Object localObject1 = new bd()
    {
      public final void a(FrameLayout paramAnonymousFrameLayout)
      {
        AppMethodBeat.i(178040);
        if ((paramAnonymousFrameLayout != null) && (paramAnonymousFrameLayout.getParent() == null)) {
          h.this.caK.addView(paramAnonymousFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(178040);
      }
    };
    ac.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.TRUE });
    paramView.lEm = ((bd)localObject1);
    if (paramView.lEl != null)
    {
      if ((!am.$assertionsDisabled) && (paramView.lEm == null))
      {
        paramView = new AssertionError();
        AppMethodBeat.o(130660);
        throw paramView;
      }
      paramView.lEm.a(paramView.lEl);
    }
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)CM()).CO().DB().ccn;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)CM()).CO().DB().ccn;
    if ((bool1) || (bool2))
    {
      ??? = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)CM()).CP().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (??? == null) {
        break label920;
      }
      paramView = ((com.tencent.luggage.game.d.a.a.b)???).Bi();
      localObject1 = new com.tencent.luggage.game.c.e.b();
      ((com.tencent.luggage.game.c.e.b)localObject1).bYB = ((com.tencent.mm.plugin.appbrand.jsapi.h)CM());
      ((com.tencent.luggage.game.c.e.b)localObject1).bZb = ((com.tencent.luggage.game.d.a.a.b)???).getMagicBrush();
      ((com.tencent.luggage.game.c.e.b)localObject1).bZc = this.caK;
      ((com.tencent.luggage.game.c.e.b)localObject1).bZd = bool1;
      ((com.tencent.luggage.game.c.e.b)localObject1).bZe = bool2;
      ((com.tencent.luggage.game.c.e.b)localObject1).bZf = new e.c()
      {
        public final void B(List<f> paramAnonymousList)
        {
          AppMethodBeat.i(178041);
          try
          {
            h localh = h.this;
            Object localObject = this.caY.getMagicBrush();
            if (localObject == null)
            {
              ac.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
              AppMethodBeat.o(178041);
              return;
            }
            localObject = ((MBRuntime)localObject).cbj.Fx();
            paramAnonymousList.add(new f("MinFPS", Math.round(localh.caS)));
            paramAnonymousList.add(new f("RT-FPS", Math.round(((com.tencent.magicbrush.a)localObject).clj)));
            paramAnonymousList.add(new f("EX-FPS", Math.round(((com.tencent.magicbrush.a)localObject).clk)));
            AppMethodBeat.o(178041);
            return;
          }
          catch (Exception paramAnonymousList)
          {
            AppMethodBeat.o(178041);
          }
        }
      };
      paramView.bYG = ((com.tencent.luggage.game.c.e.b)localObject1).bZb;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(130660);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((com.tencent.luggage.game.c.e.b)localObject1).bZc.getContext();
        if (((com.tencent.luggage.game.c.e.b)localObject1).bZd)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).bZf;
          paramView.bYQ = new com.tencent.luggage.game.c.d(paramView.mContext);
          paramView.bYQ.bYN = ((e.c)???);
          paramView.bYQ.setBackground(paramView.mContext.getResources().getDrawable(2131230977));
        }
        Object localObject3;
        if (((com.tencent.luggage.game.c.e.b)localObject1).bZe)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).bYB;
          localObject3 = paramView.bYG;
          Context localContext = paramView.mContext;
          paramView.bYR = new com.tencent.luggage.game.c.b(com.tencent.luggage.game.b.c.AX().bYr, (com.tencent.magicbrush.d)localObject3, localContext, (com.tencent.mm.plugin.appbrand.jsapi.h)???);
        }
        ??? = ((com.tencent.luggage.game.c.e.b)localObject1).bZc;
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        if (paramView.bYR != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.bYR.getView(), (ViewGroup.LayoutParams)localObject3);
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).gravity = 8388693;
          ((FrameLayout.LayoutParams)localObject3).bottomMargin = ((int)(55.0F * f));
          int i = (int)(f * 15.0F);
          ((FrameLayout.LayoutParams)localObject3).rightMargin = i;
          ((FrameLayout.LayoutParams)localObject3).leftMargin = i;
          ((FrameLayout)???).addView(paramView.bYR.bYD, (ViewGroup.LayoutParams)localObject3);
        }
        if (paramView.bYQ != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).topMargin = i.cgk.aF(paramView.mContext);
          ((FrameLayout)???).addView(paramView.bYQ, (ViewGroup.LayoutParams)localObject3);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.bYS)
      {
        if (paramView.mState != 0)
        {
          this.caQ = new ImageView(getContext());
          this.caQ.setVisibility(8);
          this.caK.addView(this.caQ, new FrameLayout.LayoutParams(-1, -1));
          this.caK.addOnAttachStateChangeListener(this.caU);
          AppMethodBeat.o(130660);
          return;
        }
        paramView.mState = 1;
        if ((((com.tencent.luggage.game.c.e.b)localObject1).bZe) && (paramView.bYR != null)) {
          paramView.bYR.post(new e.1(paramView));
        }
      }
      label920:
      ac.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.c(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  public final RelativeLayout.LayoutParams cn(View paramView)
  {
    AppMethodBeat.i(206107);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(206107);
    return paramView;
  }
  
  public void dispatchDestroy()
  {
    AppMethodBeat.i(130665);
    super.dispatchDestroy();
    Cj();
    Ck();
    if ((CM() != null) && (((com.tencent.luggage.sdk.b.a.c)CM()).CP() != null) && (((com.tencent.luggage.sdk.b.a.c)CM()).CP().Q(com.tencent.luggage.game.d.a.a.b.class) != null))
    {
      com.tencent.luggage.game.c.e locale = ((com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)CM()).CP().Q(com.tencent.luggage.game.d.a.a.b.class)).Bi();
      locale.mState = 2;
      locale.bYT.cbB.clear();
      locale.bYG = null;
      if (locale.bYR != null)
      {
        locale.bYR.bYA.destroy();
        locale.bYR = null;
      }
      if (locale.bYQ != null)
      {
        locale.bYQ.bYO.stopTimer();
        locale.bYQ = null;
      }
    }
    AppMethodBeat.o(130665);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(130662);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new com.tencent.luggage.game.page.a.b((aa)CM()));
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, new g((aa)CM(), CO().getAppConfig().jBB.jBP));
    AppMethodBeat.o(130662);
  }
  
  public final Bitmap q(int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(130670);
    ac.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
    if (paramInt == -1)
    {
      ac.e("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
      AppMethodBeat.o(130670);
      return null;
    }
    ac.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.caL == null) {
      ac.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      ac.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(130670);
      return localBitmap;
      localBitmap = this.caL.getMagicBrush().cml.h(this.caL.getVirtualElementId(), paramInt, false);
    }
  }
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206108);
    ((com.tencent.luggage.sdk.b.a.c)CM()).CP().c(paramString1, paramString2, 0);
    AppMethodBeat.o(206108);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */