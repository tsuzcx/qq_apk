package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.luggage.j.g;
import com.tencent.magicbrush.a.d.f;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.e.b;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.j;
import com.tencent.mm.plugin.appbrand.game.c.d;
import com.tencent.mm.plugin.appbrand.game.c.d.1;
import com.tencent.mm.plugin.appbrand.game.j;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressLint({"ViewConstructor"})
public final class f
  extends s
  implements com.tencent.mm.plugin.appbrand.game.b
{
  private MBCanvasContentHolder gcA;
  private boolean gcB = false;
  private com.tencent.mm.plugin.appbrand.page.y gcC;
  private b gcD;
  private final ConcurrentLinkedQueue<Runnable> gcE = new ConcurrentLinkedQueue();
  private Bitmap gcF = null;
  private final Object gcG = new Object();
  private String gcH;
  WAGamePageViewContainerLayout gcx;
  public j gcy;
  private ImageView gcz;
  private String mUrl;
  
  f(Context paramContext, i parami)
  {
    super.a(paramContext, parami);
  }
  
  private void agP()
  {
    if (!com.tencent.mm.sdk.platformtools.ai.isMainThread())
    {
      com.tencent.mm.sdk.platformtools.ai.d(new f.1(this));
      return;
    }
    this.gcy = new j(this.mContext, getRuntime(), new f.2(this), new f.3(this));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.gcx.addView(this.gcy, 0, localLayoutParams);
  }
  
  private void agU()
  {
    synchronized (this.gcG)
    {
      if ((this.gcF != null) && (!this.gcF.isRecycled()))
      {
        com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: recycling captured screen");
        this.gcF.recycle();
        this.gcF = null;
      }
      return;
    }
  }
  
  private void ahd()
  {
    if (this.gcB)
    {
      this.gcB = false;
      this.gcz.setVisibility(8);
      if ((this.gcA != null) && (this.gcA.content != null))
      {
        this.gcA.content.recycle();
        this.gcA.content = null;
      }
    }
  }
  
  public static MBCanvasContentHolder p(Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap");
    if (paramBundle == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap data is null");
      return null;
    }
    int i = paramBundle.getInt("canvasId", -1);
    boolean bool = paramBundle.getBoolean("sync", true);
    if (i == -1)
    {
      com.tencent.mm.sdk.platformtools.y.e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId is illegal");
      return null;
    }
    com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (bool) {
      paramBundle = com.tencent.mm.plugin.appbrand.game.f.a.gdf;
    }
    for (paramBundle = com.tencent.mm.plugin.appbrand.game.f.a.lb(i);; paramBundle = com.tencent.mm.plugin.appbrand.game.f.a.gdf.la(i))
    {
      com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap end");
      return paramBundle;
    }
  }
  
  private void x(Runnable paramRunnable)
  {
    if (this.gcy != null)
    {
      if (this.gcE.size() > 0)
      {
        synchronized (this.gcE)
        {
          if (this.gcE.size() <= 0) {
            break label115;
          }
          com.tencent.mm.sdk.platformtools.y.v("AppBrandGame.WAGamePageView", "hy: try to render %d", new Object[] { Integer.valueOf(this.gcE.size()) });
          Iterator localIterator = this.gcE.iterator();
          while (localIterator.hasNext())
          {
            Runnable localRunnable = (Runnable)localIterator.next();
            if (localRunnable != null) {
              this.gcy.queueEvent(localRunnable);
            }
          }
        }
        this.gcE.clear();
      }
      label115:
      if (paramRunnable != null) {
        this.gcy.queueEvent(paramRunnable);
      }
      return;
    }
    synchronized (this.gcE)
    {
      com.tencent.mm.sdk.platformtools.y.v("AppBrandGame.WAGamePageView", "hy: add to task first");
      if (paramRunnable != null) {
        this.gcE.add(paramRunnable);
      }
      return;
    }
  }
  
  public final <T> T a(int paramInt, Bundle paramBundle, Object... paramVarArgs)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      com.tencent.mm.sdk.platformtools.y.w("AppBrandGame.WAGamePageView", "hy: not support this command!! %d", new Object[] { Integer.valueOf(paramInt) });
    case 1: 
    case 2: 
      for (;;)
      {
        return super.a(paramInt, paramBundle, paramVarArgs);
        com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: got message beforeShare");
        if (paramBundle == null)
        {
          com.tencent.mm.sdk.platformtools.y.e("AppBrandGame.WAGamePageView", "hy: got message beforeShare data is null");
        }
        else
        {
          int i = paramBundle.getInt("canvasId", -1);
          MBCanvasContentHolder localMBCanvasContentHolder = com.tencent.mm.plugin.appbrand.game.f.a.gdf.la(i);
          com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: got message beforeShare end");
          if ((localMBCanvasContentHolder != null) && (localMBCanvasContentHolder.content != null))
          {
            synchronized (this.gcG)
            {
              this.gcF = localMBCanvasContentHolder.content;
            }
            if (paramBundle != null) {
              bool = paramBundle.getBoolean("needPortraitSnapshot", false);
            }
            if ((this.gcA != null) && (this.gcA.content != null))
            {
              this.gcA.content.recycle();
              this.gcA.content = null;
            }
            if (this.gcz == null) {
              this.gcz = new ImageView(this.mContext);
            }
            if ((e.b.fOs == com.tencent.mm.plugin.appbrand.config.e.r(getRuntime().aai()).cM(com.tencent.mm.plugin.appbrand.config.e.adY())) || (e.b.fOt == com.tencent.mm.plugin.appbrand.config.e.r(getRuntime().aai()).cM(com.tencent.mm.plugin.appbrand.config.e.adY())))
            {
              this.gcA = com.tencent.mm.plugin.appbrand.game.f.a.gdf.ahl();
              this.gcx.setOnConfigurationChangedListener(new f.4(this));
            }
            else if (bool)
            {
              this.gcA = com.tencent.mm.plugin.appbrand.game.f.a.gdf.ahl();
              if ((this.gcA == null) || (this.gcA.content == null))
              {
                com.tencent.mm.sdk.platformtools.y.e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
              }
              else
              {
                com.tencent.mm.sdk.platformtools.ai.d(new f.5(this));
                this.gcB = true;
                com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: vertical game. isRedpackge isPortrait screenshot");
              }
            }
            else
            {
              com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: vertical game. not need screenshot");
            }
          }
        }
      }
    }
    return p(paramBundle);
  }
  
  public final void a(ac paramac)
  {
    com.tencent.mm.sdk.platformtools.y.e("AppBrandGame.WAGamePageView", "dispatch not support");
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    getRuntime().aae().i(paramString1, paramString2, hashCode());
  }
  
  public final ah agN()
  {
    return this.gcD;
  }
  
  public final ViewGroup agO()
  {
    return this.gcD;
  }
  
  protected final void agQ()
  {
    this.gUj.aog();
  }
  
  protected final void agR()
  {
    com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: on perform foreground");
    this.gUj.pY();
    agU();
    ??? = this.gcy;
    d.f.i("MicroMsg.GameGLSurfaceView", "onResume", new Object[0]);
    GameGLSurfaceView.j localj = ((GameGLSurfaceView)???).fYI;
    synchronized (GameGLSurfaceView.afP())
    {
      d.f.i("MicroMsg.GLThread", "onResume tid=" + localj.getId(), new Object[0]);
      localj.fZf = false;
      localj.fZh = false;
      localj.fZp = true;
      localj.fZr = false;
      GameGLSurfaceView.afP().notifyAll();
      for (;;)
      {
        if ((!localj.fZd) && (localj.sn) && (!localj.fZr))
        {
          d.f.i("MicroMsg.GLThread", "onResume waiting for !mPaused.", new Object[0]);
          try
          {
            GameGLSurfaceView.afP().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    this.gTS.agH();
    ahd();
  }
  
  protected final void agS()
  {
    com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: on perform background");
    this.gUj.qa();
    ??? = this.gcy;
    d.f.i("MicroMsg.GameGLSurfaceView", "onPauseAlsoDraw", new Object[0]);
    GameGLSurfaceView.j localj = ((GameGLSurfaceView)???).fYI;
    synchronized (GameGLSurfaceView.afP())
    {
      d.f.i("MicroMsg.GLThread", "onPauseAlsoDoDraw tid=" + localj.getId(), new Object[0]);
      localj.fZh = true;
      localj.fZf = true;
      GameGLSurfaceView.afP().notifyAll();
      for (;;)
      {
        if ((!localj.fZd) && (!localj.sn))
        {
          d.f.i("MicroMsg.GLThread", "onPause waiting for mPaused.", new Object[0]);
          try
          {
            GameGLSurfaceView.afP().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    if (this.gUh != null) {
      this.gUh.dismiss();
    }
  }
  
  protected final void agT()
  {
    super.agT();
    agU();
    j localj = this.gcy;
    d.f.i("MicroMsg.GameGLSurfaceView", "onDestroy", new Object[0]);
    localj.fYI.afX();
    d.release();
  }
  
  public final void agV() {}
  
  public final com.tencent.mm.plugin.appbrand.page.y agW()
  {
    return this.gcC;
  }
  
  public final String agX()
  {
    return null;
  }
  
  public final void agY() {}
  
  public final void agZ() {}
  
  public final FrameLayout aha()
  {
    return this.gcx;
  }
  
  public final View ahb()
  {
    AppBrandActionHeaderLayout localAppBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
    localAppBrandActionHeaderLayout.setAppId(this.mAppId);
    localAppBrandActionHeaderLayout.setActionHeaderStyle(this.gTO);
    com.tencent.mm.sdk.platformtools.y.w("AppBrandGame.WAGamePageView", "getActionSheetHeader orientation:%d,mActionSheetTitleStrId:%d", new Object[] { Integer.valueOf(((MMActivity)this.mContext).getRequestedOrientation()), Integer.valueOf(this.gTP) });
    if (anp())
    {
      if (this.gTP > 0) {
        localAppBrandActionHeaderLayout.setStatusId(this.gTP);
      }
      localAppBrandActionHeaderLayout.bX(getRuntime().aac().iconUrl, getRuntime().aac().bJw);
      return localAppBrandActionHeaderLayout;
    }
    if (this.gTP > 0)
    {
      localAppBrandActionHeaderLayout.setStatusId(this.gTP);
      return localAppBrandActionHeaderLayout;
    }
    return null;
  }
  
  public final String ahc()
  {
    return this.mUrl;
  }
  
  public final Bitmap ahe()
  {
    com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "hy: jsapi enter wait");
    return null;
  }
  
  protected final com.tencent.mm.plugin.appbrand.page.a.c ahf()
  {
    return new com.tencent.mm.plugin.appbrand.game.page.a.a(this);
  }
  
  public final void bu(String paramString1, String paramString2) {}
  
  public final void cS(boolean paramBoolean) {}
  
  public final void cT(boolean paramBoolean) {}
  
  public final af cg(Context paramContext)
  {
    return new a();
  }
  
  protected final com.tencent.mm.plugin.appbrand.page.ai ch(Context paramContext)
  {
    return com.tencent.mm.plugin.appbrand.page.ai.gVK;
  }
  
  public final void g(Runnable paramRunnable)
  {
    x(paramRunnable);
  }
  
  public final View getContentView()
  {
    return this.gcx;
  }
  
  public final String getURL()
  {
    return this.gcH;
  }
  
  public final void hide()
  {
    this.gcx.setVisibility(4);
  }
  
  public final void i(String paramString1, String paramString2, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.e("AppBrandGame.WAGamePageView", "dispatch not support");
  }
  
  protected final void initView()
  {
    int i = 1;
    com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "new Rendder GameView");
    initActionBar();
    this.gcx = new WAGamePageViewContainerLayout(this.mContext);
    agP();
    this.gcD = new b(this.mContext);
    this.gcx.addView(this.gcD, new FrameLayout.LayoutParams(-1, -1));
    this.gcC = new c(this.gcD);
    this.gcC.setFullscreenImpl(anf());
    float f = this.mContext.getResources().getDisplayMetrics().density;
    Object localObject1 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 8388661;
    ((FrameLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.ab(this.mContext, y.e.app_brand_game_mode_icon_margin_right);
    ((FrameLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.ab(this.mContext, y.e.app_brand_game_mode_icon_margin_top);
    this.gcx.addView(this.gTC.getActionView(), (ViewGroup.LayoutParams)localObject1);
    if (getRuntime().aaa().fPN) {}
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = d.agy();
        Object localObject4 = this.mAppId;
        ??? = this.gcx;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          throw new IllegalStateException("You can only init GameInspector in main thread.");
          i = 0;
        }
        else if (((d)localObject1).mState == 0)
        {
          ((d)localObject1).mContext = ((FrameLayout)???).getContext();
          ((d)localObject1).mAppId = ((String)localObject4);
          ((d)localObject1).gbi = new com.tencent.mm.plugin.appbrand.game.c.c(((d)localObject1).mContext, ((d)localObject1).mAppId);
          ((d)localObject1).gbi.setBackground(((d)localObject1).mContext.getResources().getDrawable(y.f.app_brand_game_action_icon_round_rect_background));
          ((d)localObject1).gbj = new com.tencent.mm.plugin.appbrand.game.c.b(((d)localObject1).mContext);
          ((FrameLayout)???).setClipChildren(false);
          f = ((d)localObject1).mContext.getResources().getDisplayMetrics().density;
          if (((d)localObject1).gbj != null)
          {
            localObject4 = new FrameLayout.LayoutParams(-1, -1);
            ((FrameLayout)???).addView(((d)localObject1).gbj, (ViewGroup.LayoutParams)localObject4);
            localObject4 = new FrameLayout.LayoutParams(-2, -2);
            ((FrameLayout.LayoutParams)localObject4).gravity = 8388693;
            ((FrameLayout.LayoutParams)localObject4).bottomMargin = ((int)(25.0F * f));
            i = (int)(f * 15.0F);
            ((FrameLayout.LayoutParams)localObject4).rightMargin = i;
            ((FrameLayout.LayoutParams)localObject4).leftMargin = i;
            ((FrameLayout)???).addView(((d)localObject1).gbj.gbd, (ViewGroup.LayoutParams)localObject4);
          }
          if (((d)localObject1).gbi != null)
          {
            localObject4 = new FrameLayout.LayoutParams(-2, -2);
            ((FrameLayout)???).addView(((d)localObject1).gbi, (ViewGroup.LayoutParams)localObject4);
          }
        }
      }
    }
    synchronized (((d)localObject1).gbl)
    {
      ((d)localObject1).mState = 1;
      if (((d)localObject1).gbj != null) {
        ((d)localObject1).gbj.post(new d.1((d)localObject1));
      }
      this.gcz = new ImageView(this.mContext);
      this.gcx.addView(this.gcz, new FrameLayout.LayoutParams(-1, -1));
      return;
    }
  }
  
  public final boolean isFullScreen()
  {
    return this.gTS.ahi() == c.a.gVY;
  }
  
  public final void kW(int paramInt) {}
  
  public final void kX(int paramInt) {}
  
  public final void kY(int paramInt) {}
  
  public final void kZ(int paramInt)
  {
    this.gTP = paramInt;
  }
  
  public final boolean qc()
  {
    return false;
  }
  
  public final void show()
  {
    this.gcx.setVisibility(0);
  }
  
  public final boolean tB(String paramString)
  {
    this.gUj.wc(paramString);
    this.mUrl = paramString;
    this.gcH = g.bi(paramString);
    com.tencent.mm.sdk.platformtools.y.i("AppBrandGame.WAGamePageView", "loadURL url : " + paramString);
    return true;
  }
  
  public final void tC(String paramString) {}
  
  public final void tD(String paramString) {}
  
  public final void tE(String paramString) {}
  
  public final void tF(String paramString)
  {
    if ((this.mContext instanceof Activity))
    {
      Window localWindow = ((Activity)this.mContext).getWindow();
      if (localWindow != null) {
        l.a(localWindow, "black".equals(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.f
 * JD-Core Version:    0.7.0.1
 */