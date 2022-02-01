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
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements b.b, d
{
  protected WAGamePageViewContainerLayout cld;
  private MagicBrushView cle;
  private al clf;
  protected b clg;
  private Bitmap clh;
  private Bitmap cli;
  private ImageView clj;
  private final a clk;
  double cll;
  private AtomicBoolean clm;
  private final View.OnAttachStateChangeListener cln;
  
  public h(PAGE arg1)
  {
    super(???);
    AppMethodBeat.i(130656);
    this.cll = 60.0D;
    this.clm = new AtomicBoolean(false);
    this.cln = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(130651);
        ae.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
        h.a(h.this).getMagicBrush().Hj();
        h.a(h.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(130650);
            h.this.cld.removeOnAttachStateChangeListener(jdField_this);
            AppMethodBeat.o(130650);
          }
        });
        AppMethodBeat.o(130651);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    };
    this.clk = new a();
    DE();
    com.tencent.luggage.sdk.b.a.c.e locale = ???.Er().coW;
    synchronized (this.cno)
    {
      this.cno.putAll(locale.cno);
      AppMethodBeat.o(130656);
      return;
    }
  }
  
  private void DL()
  {
    AppMethodBeat.i(130668);
    BitmapDrawable localBitmapDrawable;
    if (this.clj != null) {
      if ((this.clj.getDrawable() instanceof BitmapDrawable))
      {
        localBitmapDrawable = (BitmapDrawable)this.clj.getDrawable();
        this.clj.setImageDrawable(null);
      }
    }
    try
    {
      localBitmapDrawable.getBitmap().recycle();
      this.clj.setVisibility(8);
      if (this.clh == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.clh.recycle();
        this.clh = null;
        AppMethodBeat.o(130668);
        return;
        localException1 = localException1;
        ae.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException1, "hy: cleanupCoverScreenshot error!", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException2, "hy: cleanupCoverScreenshot error!", new Object[0]);
        }
      }
    }
  }
  
  private void DM()
  {
    AppMethodBeat.i(130673);
    if (this.cli != null) {}
    try
    {
      ae.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
      this.cli.recycle();
      this.cli = null;
      AppMethodBeat.o(130673);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: cleanupCanvasSecurityGuard error!", new Object[0]);
      }
    }
  }
  
  protected void DE()
  {
    AppMethodBeat.i(130657);
    b(d.class, this);
    AppMethodBeat.o(130657);
  }
  
  public final bb DF()
  {
    return this.clg;
  }
  
  public final al DG()
  {
    return this.clf;
  }
  
  public final void DH()
  {
    AppMethodBeat.i(130663);
    super.DH();
    DL();
    DM();
    this.cle.getMagicBrush().Hj();
    AppMethodBeat.o(130663);
  }
  
  public void DI()
  {
    AppMethodBeat.i(130664);
    super.DI();
    this.cle.getMagicBrush().Hk();
    AppMethodBeat.o(130664);
  }
  
  public final Map<String, m> DJ()
  {
    AppMethodBeat.i(130666);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(130666);
    return localMap;
  }
  
  public final void DK() {}
  
  public final void Dt()
  {
    AppMethodBeat.i(130669);
    DL();
    if (!getMagicBrushView().getMagicBrush().cwZ.Cw())
    {
      AppMethodBeat.o(130669);
      return;
    }
    Object localObject = ((com.tencent.luggage.sdk.b.a.c)Eo()).jDa.getOrientationHandler().aYg();
    if (org.apache.commons.b.a.contains(new com.tencent.mm.plugin.appbrand.platform.window.e.b[] { com.tencent.mm.plugin.appbrand.platform.window.e.b.mtF, com.tencent.mm.plugin.appbrand.platform.window.e.b.mtG, com.tencent.mm.plugin.appbrand.platform.window.e.b.mtH, com.tencent.mm.plugin.appbrand.platform.window.e.b.mtI }, localObject))
    {
      if (this.clj == null)
      {
        ae.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(130669);
        return;
      }
      if (this.cle != null) {
        break label151;
      }
      ae.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
    }
    label151:
    for (localObject = null;; localObject = com.tencent.magicbrush.b.a(this.cle.getMagicBrush().cxs))
    {
      this.clh = ((Bitmap)localObject);
      this.cld.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a()
      {
        public final void a(WAGamePageViewContainerLayout.b paramAnonymousb1, WAGamePageViewContainerLayout.b paramAnonymousb2)
        {
          AppMethodBeat.i(178042);
          ae.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramAnonymousb1, paramAnonymousb2 });
          if (h.c(h.this) == null)
          {
            ae.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
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
            if (((paramAnonymousb2 == WAGamePageViewContainerLayout.b.ckU) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.ckV)) || ((paramAnonymousb2 == WAGamePageViewContainerLayout.b.ckW) && (paramAnonymousb1 == WAGamePageViewContainerLayout.b.ckX))) {
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
          h.this.cld.setOnConfigurationChangedListener(null);
          AppMethodBeat.o(178042);
        }
      });
      AppMethodBeat.o(130669);
      return;
    }
  }
  
  public final void Du()
  {
    AppMethodBeat.i(130671);
    ae.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
    try
    {
      DM();
      this.cli = com.tencent.magicbrush.b.a(this.cle.getMagicBrush().cxs);
      AppMethodBeat.o(130671);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", localException, "hy: captureDefaultWindow error!", new Object[0]);
      AppMethodBeat.o(130671);
    }
  }
  
  public final Bitmap Dv()
  {
    AppMethodBeat.i(130672);
    if (this.cli != null)
    {
      ae.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
      Bitmap localBitmap = this.cli;
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
    this.cld = paramLayoutInflater;
    AppMethodBeat.o(130658);
    return paramLayoutInflater;
  }
  
  protected MagicBrushView ay(Context paramContext)
  {
    AppMethodBeat.i(130659);
    paramContext = new MagicBrushView(paramContext, MagicBrushView.h.cAW);
    AppMethodBeat.o(130659);
    return paramContext;
  }
  
  public final ax az(Context paramContext)
  {
    return this.clk;
  }
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(130661);
    paramb.setFullscreenMode(true);
    AppBrandCapsuleBarPlaceHolderView localAppBrandCapsuleBarPlaceHolderView = paramb.getCapsuleView();
    if ((localAppBrandCapsuleBarPlaceHolderView != null) && ((localAppBrandCapsuleBarPlaceHolderView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localAppBrandCapsuleBarPlaceHolderView.getLayoutParams();
      localMarginLayoutParams.rightMargin += paramb.getContext().getResources().getDimensionPixelSize(2131165772);
      localMarginLayoutParams.topMargin += paramb.getContext().getResources().getDimensionPixelSize(2131165773);
      localAppBrandCapsuleBarPlaceHolderView.requestLayout();
    }
    AppMethodBeat.o(130661);
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(130667);
    ((com.tencent.luggage.sdk.b.a.c)Eo()).Er().c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(130667);
    return true;
  }
  
  public final boolean cZ(String paramString)
  {
    return true;
  }
  
  public void cl(View paramView)
  {
    AppMethodBeat.i(220735);
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(220735);
      return;
    }
    if (this.clm.compareAndSet(false, true)) {
      ((com.tencent.luggage.sdk.b.a.c)Eo()).TY("onNativeWidgetViewAdded");
    }
    AppMethodBeat.o(220735);
  }
  
  public void cm(View paramView)
  {
    AppMethodBeat.i(130660);
    paramView = (com.tencent.luggage.game.d.a.a.b)Q(com.tencent.luggage.game.d.a.a.b.class);
    if (paramView == null)
    {
      ae.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.c(), "hy: not on game service!", new Object[0]);
      AppMethodBeat.o(130660);
      return;
    }
    this.cle = ay(getContext());
    this.cle.setId(2131296729);
    paramView = paramView.getMagicBrush();
    this.cle.setMagicBrush(paramView);
    paramView.cxq.add(new d.b()
    {
      public final void onFirstFrame()
      {
        AppMethodBeat.i(130652);
        if (h.b(h.this).compareAndSet(false, true)) {
          ((com.tencent.luggage.sdk.b.a.c)h.this.Eo()).TY("onFirstFrame");
        }
        AppMethodBeat.o(130652);
      }
    });
    this.cld.addView(this.cle, 0, new FrameLayout.LayoutParams(-1, -1));
    this.clg = new b(getContext());
    this.clg.setNativeWidgetAddedCallback(this);
    this.cld.addView(this.clg, -1, new ViewGroup.LayoutParams(-1, -1));
    this.clf = new c(this.clg);
    this.clf.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)Eo()).getFullscreenImpl());
    this.clf.a(new az()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(130653);
        if ((paramAnonymousAppBrandPageFullScreenView != null) && (paramAnonymousAppBrandPageFullScreenView.getParent() == null)) {
          h.this.cld.addView(paramAnonymousAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(130653);
      }
    });
    paramView = this.clf;
    Object localObject1 = new bc()
    {
      public final void a(FrameLayout paramAnonymousFrameLayout)
      {
        AppMethodBeat.i(178040);
        if ((paramAnonymousFrameLayout != null) && (paramAnonymousFrameLayout.getParent() == null)) {
          h.this.cld.addView(paramAnonymousFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(178040);
      }
    };
    ae.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", new Object[] { Boolean.TRUE });
    paramView.mij = ((bc)localObject1);
    if (paramView.mii != null)
    {
      if ((!al.$assertionsDisabled) && (paramView.mij == null))
      {
        paramView = new AssertionError();
        AppMethodBeat.o(130660);
        throw paramView;
      }
      paramView.mij.a(paramView.mii);
    }
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)Eo()).Eq().Ff().cmG;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)Eo()).Eq().Ff().cmG;
    if ((bool1) || (bool2))
    {
      ??? = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)Eo()).Er().Q(com.tencent.luggage.game.d.a.a.b.class);
      if (??? == null) {
        break label920;
      }
      paramView = ((com.tencent.luggage.game.d.a.a.b)???).CK();
      localObject1 = new com.tencent.luggage.game.c.e.b();
      ((com.tencent.luggage.game.c.e.b)localObject1).ciV = ((com.tencent.mm.plugin.appbrand.jsapi.h)Eo());
      ((com.tencent.luggage.game.c.e.b)localObject1).cjv = ((com.tencent.luggage.game.d.a.a.b)???).getMagicBrush();
      ((com.tencent.luggage.game.c.e.b)localObject1).cjw = this.cld;
      ((com.tencent.luggage.game.c.e.b)localObject1).cjx = bool1;
      ((com.tencent.luggage.game.c.e.b)localObject1).cjy = bool2;
      ((com.tencent.luggage.game.c.e.b)localObject1).cjz = new e.c()
      {
        public final void B(List<f> paramAnonymousList)
        {
          AppMethodBeat.i(178041);
          try
          {
            h localh = h.this;
            Object localObject = this.clr.getMagicBrush();
            if (localObject == null)
            {
              ae.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
              AppMethodBeat.o(178041);
              return;
            }
            localObject = ((MBRuntime)localObject).clC.GX();
            paramAnonymousList.add(new f("MinFPS", Math.round(localh.cll)));
            paramAnonymousList.add(new f("RT-FPS", Math.round(((com.tencent.magicbrush.a)localObject).cwp)));
            paramAnonymousList.add(new f("EX-FPS", Math.round(((com.tencent.magicbrush.a)localObject).cwq)));
            AppMethodBeat.o(178041);
            return;
          }
          catch (Exception paramAnonymousList)
          {
            AppMethodBeat.o(178041);
          }
        }
      };
      paramView.cja = ((com.tencent.luggage.game.c.e.b)localObject1).cjv;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(130660);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((com.tencent.luggage.game.c.e.b)localObject1).cjw.getContext();
        if (((com.tencent.luggage.game.c.e.b)localObject1).cjx)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cjz;
          paramView.cjk = new com.tencent.luggage.game.c.d(paramView.mContext);
          paramView.cjk.cjh = ((e.c)???);
          paramView.cjk.setBackground(paramView.mContext.getResources().getDrawable(2131230977));
        }
        Object localObject3;
        if (((com.tencent.luggage.game.c.e.b)localObject1).cjy)
        {
          ??? = ((com.tencent.luggage.game.c.e.b)localObject1).ciV;
          localObject3 = paramView.cja;
          Context localContext = paramView.mContext;
          paramView.cjl = new com.tencent.luggage.game.c.b(com.tencent.luggage.game.b.c.Cz().ciL, (com.tencent.magicbrush.d)localObject3, localContext, (com.tencent.mm.plugin.appbrand.jsapi.h)???);
        }
        ??? = ((com.tencent.luggage.game.c.e.b)localObject1).cjw;
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        if (paramView.cjl != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.cjl.getView(), (ViewGroup.LayoutParams)localObject3);
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).gravity = 8388693;
          ((FrameLayout.LayoutParams)localObject3).bottomMargin = ((int)(55.0F * f));
          int i = (int)(f * 15.0F);
          ((FrameLayout.LayoutParams)localObject3).rightMargin = i;
          ((FrameLayout.LayoutParams)localObject3).leftMargin = i;
          ((FrameLayout)???).addView(paramView.cjl.ciX, (ViewGroup.LayoutParams)localObject3);
        }
        if (paramView.cjk != null)
        {
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).topMargin = i.cre.aG(paramView.mContext);
          ((FrameLayout)???).addView(paramView.cjk, (ViewGroup.LayoutParams)localObject3);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.cjm)
      {
        if (paramView.mState != 0)
        {
          this.clj = new ImageView(getContext());
          this.clj.setVisibility(8);
          this.cld.addView(this.clj, new FrameLayout.LayoutParams(-1, -1));
          this.cld.addOnAttachStateChangeListener(this.cln);
          AppMethodBeat.o(130660);
          return;
        }
        paramView.mState = 1;
        if ((((com.tencent.luggage.game.c.e.b)localObject1).cjy) && (paramView.cjl != null)) {
          paramView.cjl.post(new e.1(paramView));
        }
      }
      label920:
      ae.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.d.a.a.c(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  public final RelativeLayout.LayoutParams cn(View paramView)
  {
    AppMethodBeat.i(220733);
    paramView = new RelativeLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(220733);
    return paramView;
  }
  
  public void dispatchDestroy()
  {
    AppMethodBeat.i(130665);
    super.dispatchDestroy();
    DL();
    DM();
    if ((Eo() != null) && (((com.tencent.luggage.sdk.b.a.c)Eo()).Er() != null) && (((com.tencent.luggage.sdk.b.a.c)Eo()).Er().Q(com.tencent.luggage.game.d.a.a.b.class) != null))
    {
      com.tencent.luggage.game.c.e locale = ((com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c)Eo()).Er().Q(com.tencent.luggage.game.d.a.a.b.class)).CK();
      locale.mState = 2;
      locale.cjn.clU.clear();
      locale.cja = null;
      if (locale.cjl != null)
      {
        locale.cjl.ciU.destroy();
        locale.cjl = null;
      }
      if (locale.cjk != null)
      {
        locale.cjk.cji.stopTimer();
        locale.cjk = null;
      }
    }
    AppMethodBeat.o(130665);
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(130662);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.luggage.game.page.a.b((z)Eo()));
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new g((z)Eo(), Eq().getAppConfig().jYN.cpm));
    AppMethodBeat.o(130662);
  }
  
  public MagicBrushView getMagicBrushView()
  {
    return this.cle;
  }
  
  public final Bitmap q(int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(130670);
    ae.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
    if (paramInt == -1)
    {
      ae.e("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
      AppMethodBeat.o(130670);
      return null;
    }
    ae.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.cle == null) {
      ae.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      ae.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(130670);
      return localBitmap;
      localBitmap = this.cle.getMagicBrush().cxs.h(this.cle.getVirtualElementId(), paramInt, false);
    }
  }
  
  public final boolean y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220734);
    ((com.tencent.luggage.sdk.b.a.c)Eo()).Er().c(paramString1, paramString2, 0);
    AppMethodBeat.o(220734);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */