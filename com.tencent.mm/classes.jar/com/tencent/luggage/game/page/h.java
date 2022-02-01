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
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.page.bi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements b.b, d
{
  protected WAGamePageViewContainerLayout cdN;
  private MagicBrushView cdO;
  private ar cdP;
  protected b cdQ;
  private Bitmap cdR;
  private Bitmap cdS;
  private ImageView cdT;
  private final a cdU;
  double cdV;
  private AtomicBoolean cdW;
  private final View.OnAttachStateChangeListener cdX;
  
  public h(PAGE arg1)
  {
    super(???);
    AppMethodBeat.i(130656);
    this.cdV = 60.0D;
    this.cdW = new AtomicBoolean(false);
    this.cdX = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(130651);
        ad.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
        h.a(h.this).getMagicBrush().FZ();
        h.a(h.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(130650);
            h.this.cdN.removeOnAttachStateChangeListener(jdField_this);
            AppMethodBeat.o(130650);
          }
        });
        AppMethodBeat.o(130651);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    };
    this.cdU = new a();
    Cy();
    com.tencent.luggage.sdk.b.a.c.e locale = ???.Dm().chI;
    synchronized (this.cfY)
    {
      this.cfY.putAll(locale.cfY);
      AppMethodBeat.o(130656);
      return;
    }
  }
  
  private void CF()
  {
    AppMethodBeat.i(130668);
    BitmapDrawable localBitmapDrawable;
    if (this.cdT != null) {
      if ((this.cdT.getDrawable() instanceof BitmapDrawable))
      {
        localBitmapDrawable = (BitmapDrawable)this.cdT.getDrawable();
        this.cdT.setImageDrawable(null);
      }
    }
    try
    {
      localBitmapDrawable.getBitmap().recycle();
      this.cdT.setVisibility(8);
      if (this.cdR == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.cdR.recycle();
        this.cdR = null;
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
  
  private void CG()
  {
    AppMethodBeat.i(130673);
    if (this.cdS != null) {}
    try
    {
      ad.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
      this.cdS.recycle();
      this.cdS = null;
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
  
  public final ar CA()
  {
    return this.cdP;
  }
  
  public final void CB()
  {
    AppMethodBeat.i(130663);
    super.CB();
    CF();
    CG();
    this.cdO.getMagicBrush().FZ();
    AppMethodBeat.o(130663);
  }
  
  public void CC()
  {
    AppMethodBeat.i(130664);
    super.CC();
    this.cdO.getMagicBrush().Ga();
    AppMethodBeat.o(130664);
  }
  
  public final Map<String, m> CD()
  {
    AppMethodBeat.i(130666);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(130666);
    return localMap;
  }
  
  public final void CE() {}
  
  public final void Cm()
  {
    AppMethodBeat.i(130669);
    CF();
    if (!Cn().getMagicBrush().coO.Bq())
    {
      AppMethodBeat.o(130669);
      return;
    }
    Object localObject = ((com.tencent.luggage.sdk.b.a.c)Dj()).iGU.getOrientationHandler().aNL();
    if (org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.s.a.e.b[] { com.tencent.mm.plugin.appbrand.s.a.e.b.lmQ, com.tencent.mm.plugin.appbrand.s.a.e.b.lmR, com.tencent.mm.plugin.appbrand.s.a.e.b.lmS, com.tencent.mm.plugin.appbrand.s.a.e.b.lmT }, localObject))
    {
      if (this.cdT == null)
      {
        ad.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(130669);
        return;
      }
      if (this.cdO != null) {
        break label151;
      }
      ad.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
    }
    label151:
    for (localObject = null;; localObject = com.tencent.magicbrush.b.a(this.cdO.getMagicBrush().cpg))
    {
      this.cdR = ((Bitmap)localObject);
      this.cdN.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a()
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
            if (((paramAnonymousb2 == WAGamePageViewContainerLayout.b.cdE) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.cdF)) || ((paramAnonymousb2 == WAGamePageViewContainerLayout.b.cdG) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.cdH))) {
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
          h.this.cdN.setOnConfigurationChangedListener(null);
          AppMethodBeat.o(178042);
        }
      });
      AppMethodBeat.o(130669);
      return;
    }
  }
  
  public MagicBrushView Cn()
  {
    return this.cdO;
  }
  
  public final void Co()
  {
    AppMethodBeat.i(130671);
    ad.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
    try
    {
      CG();
      this.cdS = com.tencent.magicbrush.b.a(this.cdO.getMagicBrush().cpg);
      AppMethodBeat.o(130671);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: captureDefaultWindow error!", new Object[0]);
      AppMethodBeat.o(130671);
    }
  }
  
  public final Bitmap Cp()
  {
    AppMethodBeat.i(130672);
    if (this.cdS != null)
    {
      ad.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
      Bitmap localBitmap = this.cdS;
      AppMethodBeat.o(130672);
      return localBitmap;
    }
    AppMethodBeat.o(130672);
    return null;
  }
  
  protected void Cy()
  {
    AppMethodBeat.i(130657);
    b(d.class, this);
    AppMethodBeat.o(130657);
  }
  
  public final bh Cz()
  {
    return this.cdQ;
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(130658);
    paramLayoutInflater = new WAGamePageViewContainerLayout(paramLayoutInflater.getContext());
    this.cdN = paramLayoutInflater;
    AppMethodBeat.o(130658);
    return paramLayoutInflater;
  }
  
  protected MagicBrushView aw(Context paramContext)
  {
    AppMethodBeat.i(130659);
    paramContext = new MagicBrushView(paramContext, MagicBrushView.h.csr);
    AppMethodBeat.o(130659);
    return paramContext;
  }
  
  public final bd ax(Context paramContext)
  {
    return this.cdU;
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
    ((com.tencent.luggage.sdk.b.a.c)Dj()).Dm().c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(130667);
    return true;
  }
  
  public void cl(View paramView)
  {
    AppMethodBeat.i(194661);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(194661);
      return;
    }
    if (this.cdW.compareAndSet(false, true)) {
      ((com.tencent.luggage.sdk.b.a.c)Dj()).onReady();
    }
    AppMethodBeat.o(194661);
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
    this.cdO = aw(getContext());
    this.cdO.setId(2131296729);
    paramView = paramView.getMagicBrush();
    this.cdO.setMagicBrush(paramView);
    paramView.cpe.add(new d.b()
    {
      public final void onFirstFrame()
      {
        AppMethodBeat.i(130652);
        if (h.b(h.this).compareAndSet(false, true)) {
          ((com.tencent.luggage.sdk.b.a.c)h.this.Dj()).onReady();
        }
        AppMethodBeat.o(130652);
      }
    });
    this.cdN.addView(this.cdO, 0, new FrameLayout.LayoutParams(-1, -1));
    this.cdQ = new b(getContext());
    this.cdQ.setNativeWidgetAddedCallback(this);
    this.cdN.addView(this.cdQ, -1, new ViewGroup.LayoutParams(-1, -1));
    this.cdP = new c(this.cdQ);
    this.cdP.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)Dj()).getFullscreenImpl());
    this.cdP.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(130653);
        if ((paramAnonymousAppBrandPageFullScreenView != null) && (paramAnonymousAppBrandPageFullScreenView.getParent() == null)) {
          h.this.cdN.addView(paramAnonymousAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(130653);
      }
    });
    paramView = this.cdP;
    Object localObject1 = new bi()
    {
      public final void a(FrameLayout paramAnonymousFrameLayout)
      {
        AppMethodBeat.i(178040);
        if ((paramAnonymousFrameLayout != null) && (paramAnonymousFrameLayout.getParent() == null)) {
          h.this.cdN.addView(paramAnonymousFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(178040);
      }
    };
    ad.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.TRUE });
    paramView.lew = ((bi)localObject1);
    if (paramView.lev != null)
    {
      if ((!ar.$assertionsDisabled) && (paramView.lew == null))
      {
        paramView = new AssertionError();
        AppMethodBeat.o(130660);
        throw paramView;
      }
      paramView.lew.a(paramView.lev);
    }
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)Dj()).Dl().DY().cfq;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)Dj()).Dl().DY().cfq;
    if ((bool1) || (bool2))
    {
      ??? = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)Dj()).Dm().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (??? == null) {
        break label920;
      }
      paramView = ((com.tencent.luggage.game.d.a.a.b)???).BE();
      localObject1 = new com.tencent.luggage.game.c.e.b();
      ((com.tencent.luggage.game.c.e.b)localObject1).cbE = ((com.tencent.mm.plugin.appbrand.jsapi.h)Dj());
      ((com.tencent.luggage.game.c.e.b)localObject1).cce = ((com.tencent.luggage.game.d.a.a.b)???).getMagicBrush();
      ((com.tencent.luggage.game.c.e.b)localObject1).ccf = this.cdN;
      ((com.tencent.luggage.game.c.e.b)localObject1).ccg = bool1;
      ((com.tencent.luggage.game.c.e.b)localObject1).cch = bool2;
      ((com.tencent.luggage.game.c.e.b)localObject1).cci = new e.c()
      {
        public final void K(List<f> paramAnonymousList)
        {
          AppMethodBeat.i(178041);
          try
          {
            h localh = h.this;
            Object localObject = this.ceb.getMagicBrush();
            if (localObject == null)
            {
              ad.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
              AppMethodBeat.o(178041);
              return;
            }
            localObject = ((MBRuntime)localObject).cem.FO();
            paramAnonymousList.add(new f("MinFPS", Math.round(localh.cdV)));
            paramAnonymousList.add(new f("RT-FPS", Math.round(((com.tencent.magicbrush.a)localObject).coh)));
            paramAnonymousList.add(new f("EX-FPS", Math.round(((com.tencent.magicbrush.a)localObject).coi)));
            AppMethodBeat.o(178041);
            return;
          }
          catch (Exception paramAnonymousList)
          {
            AppMethodBeat.o(178041);
          }
        }
      };
      paramView.cbJ = ((com.tencent.luggage.game.c.e.b)localObject1).cce;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(130660);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((com.tencent.luggage.game.c.e.b)localObject1).ccf.getContext();
        if (((com.tencent.luggage.game.c.e.b)localObject1).ccg)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cci;
          paramView.cbT = new com.tencent.luggage.game.c.d(paramView.mContext);
          paramView.cbT.cbQ = ((e.c)???);
          paramView.cbT.setBackground(paramView.mContext.getResources().getDrawable(2131230977));
        }
        Object localObject3;
        if (((com.tencent.luggage.game.c.e.b)localObject1).cch)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cbE;
          localObject3 = paramView.cbJ;
          Context localContext = paramView.mContext;
          paramView.cbU = new com.tencent.luggage.game.c.b(com.tencent.luggage.game.b.c.Bt().cbu, (com.tencent.magicbrush.d)localObject3, localContext, (com.tencent.mm.plugin.appbrand.jsapi.h)???);
        }
        ??? = ((com.tencent.luggage.game.c.e.b)localObject1).ccf;
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        if (paramView.cbU != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.cbU.getView(), (ViewGroup.LayoutParams)localObject3);
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).gravity = 8388693;
          ((FrameLayout.LayoutParams)localObject3).bottomMargin = ((int)(55.0F * f));
          int i = (int)(f * 15.0F);
          ((FrameLayout.LayoutParams)localObject3).rightMargin = i;
          ((FrameLayout.LayoutParams)localObject3).leftMargin = i;
          ((FrameLayout)???).addView(paramView.cbU.cbG, (ViewGroup.LayoutParams)localObject3);
        }
        if (paramView.cbT != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).topMargin = i.cjn.aE(paramView.mContext);
          ((FrameLayout)???).addView(paramView.cbT, (ViewGroup.LayoutParams)localObject3);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.cbV)
      {
        if (paramView.mState != 0)
        {
          this.cdT = new ImageView(getContext());
          this.cdT.setVisibility(8);
          this.cdN.addView(this.cdT, new FrameLayout.LayoutParams(-1, -1));
          this.cdN.addOnAttachStateChangeListener(this.cdX);
          AppMethodBeat.o(130660);
          return;
        }
        paramView.mState = 1;
        if ((((com.tencent.luggage.game.c.e.b)localObject1).cch) && (paramView.cbU != null)) {
          paramView.cbU.post(new e.1(paramView));
        }
      }
      label920:
      ad.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.c(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  public final RelativeLayout.LayoutParams cn(View paramView)
  {
    AppMethodBeat.i(194659);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(194659);
    return paramView;
  }
  
  public final boolean cn(String paramString)
  {
    return true;
  }
  
  public void dispatchDestroy()
  {
    AppMethodBeat.i(130665);
    super.dispatchDestroy();
    CF();
    CG();
    if ((Dj() != null) && (((com.tencent.luggage.sdk.b.a.c)Dj()).Dm() != null) && (((com.tencent.luggage.sdk.b.a.c)Dj()).Dm().Q(com.tencent.luggage.game.d.a.a.b.class) != null))
    {
      com.tencent.luggage.game.c.e locale = ((com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)Dj()).Dm().Q(com.tencent.luggage.game.d.a.a.b.class)).BE();
      locale.mState = 2;
      locale.cbW.ceE.clear();
      locale.cbJ = null;
      if (locale.cbU != null)
      {
        locale.cbU.cbD.destroy();
        locale.cbU = null;
      }
      if (locale.cbT != null)
      {
        locale.cbT.cbR.stopTimer();
        locale.cbT = null;
      }
    }
    AppMethodBeat.o(130665);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(130662);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new com.tencent.luggage.game.page.a.b((aa)Dj()));
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, new g((aa)Dj(), Dl().getAppConfig().jbo.jbC));
    AppMethodBeat.o(130662);
  }
  
  public final Bitmap r(int paramInt, boolean paramBoolean)
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
    if (this.cdO == null) {
      ad.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      ad.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(130670);
      return localBitmap;
      localBitmap = this.cdO.getMagicBrush().cpg.h(this.cdO.getVirtualElementId(), paramInt, false);
    }
  }
  
  public final boolean x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194660);
    ((com.tencent.luggage.sdk.b.a.c)Dj()).Dm().c(paramString1, paramString2, 0);
    AppMethodBeat.o(194660);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */