package com.tencent.luggage.game.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.luggage.game.d.e.1;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MagicBrushView;
import com.tencent.magicbrush.handler.MBCanvasHandler;
import com.tencent.magicbrush.handler.MBCanvasHandler.3;
import com.tencent.magicbrush.handler.MBJsThreadHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.Map;

public class h<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements d
{
  private WAGamePageViewContainerLayout bBV;
  private MagicBrushView bBW;
  private com.tencent.mm.plugin.appbrand.page.af bBX;
  private b bBY;
  private Bitmap bBZ;
  private ImageView bCa;
  private final a bCb;
  private final View.OnAttachStateChangeListener bCc;
  
  static
  {
    AppMethodBeat.i(140525);
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(140525);
      return;
    }
  }
  
  public h(PAGE arg1)
  {
    super(???);
    AppMethodBeat.i(140510);
    this.bCc = new h.1(this);
    this.bCb = new a();
    vA();
    com.tencent.luggage.sdk.b.a.c.e locale = ???.wk().bEO;
    synchronized (this.bDO)
    {
      this.bDO.putAll(locale.bDO);
      AppMethodBeat.o(140510);
      return;
    }
  }
  
  private void vH()
  {
    AppMethodBeat.i(140522);
    BitmapDrawable localBitmapDrawable;
    if (this.bCa != null) {
      if ((this.bCa.getDrawable() instanceof BitmapDrawable))
      {
        localBitmapDrawable = (BitmapDrawable)this.bCa.getDrawable();
        this.bCa.setImageDrawable(null);
      }
    }
    try
    {
      localBitmapDrawable.getBitmap().recycle();
      label51:
      this.bCa.setVisibility(8);
      if (this.bBZ != null) {}
      try
      {
        this.bBZ.recycle();
        label74:
        this.bBZ = null;
        AppMethodBeat.o(140522);
        return;
      }
      catch (Exception localException1)
      {
        break label74;
      }
    }
    catch (Exception localException2)
    {
      break label51;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(140512);
    paramLayoutInflater = new WAGamePageViewContainerLayout(paramLayoutInflater.getContext());
    this.bBV = paramLayoutInflater;
    AppMethodBeat.o(140512);
    return paramLayoutInflater;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(140515);
    paramb.setFullscreenMode(true);
    Object localObject = paramb;
    if ((paramb.getParent() instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d)) {
      localObject = (View)paramb.getParent();
    }
    if ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      paramb = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      paramb.rightMargin = getContext().getResources().getDimensionPixelSize(2131428001);
      paramb.topMargin = getContext().getResources().getDimensionPixelSize(2131428002);
      ((View)localObject).requestLayout();
    }
    AppMethodBeat.o(140515);
  }
  
  protected MagicBrushView aq(Context paramContext)
  {
    AppMethodBeat.i(140513);
    paramContext = new MagicBrushView(getContext());
    AppMethodBeat.o(140513);
    return paramContext;
  }
  
  public final ap ar(Context paramContext)
  {
    return this.bCb;
  }
  
  public final boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(140521);
    ((com.tencent.luggage.sdk.b.a.c)this.bDN).wk().c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(140521);
    return true;
  }
  
  public final boolean bX(String paramString)
  {
    return true;
  }
  
  public final void ce(View paramView)
  {
    AppMethodBeat.i(140514);
    this.bBW = aq(getContext());
    this.bBW.setId(2131820556);
    paramView = (com.tencent.luggage.game.e.a.a.b)x(com.tencent.luggage.game.e.a.a.b.class);
    if (paramView == null)
    {
      com.tencent.luggage.g.d.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.e.a.a.c(), "hy: not on game service!", new Object[0]);
      AppMethodBeat.o(140514);
      return;
    }
    this.bBW.setMBRuntime(paramView.getMBRuntime());
    this.bBW.registerEventListener(new h.2(this));
    this.bBV.addView(this.bBW, 0, new FrameLayout.LayoutParams(-1, -1));
    this.bBY = new b(getContext());
    this.bBV.addView(this.bBY, -1, new ViewGroup.LayoutParams(-1, -1));
    this.bBX = new c(this.bBY);
    this.bBX.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)this.bDN).getFullscreenImpl());
    this.bBX.a(new h.3(this));
    boolean bool1 = ((com.tencent.luggage.sdk.b.a.c)this.bDN).wj().wR().bDj;
    boolean bool2 = ((com.tencent.luggage.sdk.b.a.c)this.bDN).wj().wR().bDj;
    boolean bool3 = ((com.tencent.luggage.game.b.a)((com.tencent.luggage.sdk.b.a.c)this.bDN).U(com.tencent.luggage.game.b.a.class)).bzS;
    if ((bool1) || (bool2))
    {
      paramView = com.tencent.luggage.game.d.e.uJ();
      ??? = (com.tencent.luggage.game.e.a.a.b)((com.tencent.luggage.sdk.b.a.c)this.bDN).wk().x(com.tencent.luggage.game.e.a.a.b.class);
      if (??? == null) {
        break label757;
      }
      Object localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.h)this.bDN;
      MBRuntime localMBRuntime = ((com.tencent.luggage.game.e.a.a.b)???).getMBRuntime();
      ??? = this.bBV;
      paramView.mbRuntime = localMBRuntime;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramView = new IllegalStateException("You can only init GameInspector in main thread.");
        AppMethodBeat.o(140514);
        throw paramView;
      }
      if (paramView.mState == 0)
      {
        paramView.mContext = ((FrameLayout)???).getContext();
        if (bool1)
        {
          localMBRuntime = paramView.mbRuntime;
          paramView.bAB = new com.tencent.luggage.game.d.d(paramView.mContext, localMBRuntime);
          paramView.bAB.setBackground(paramView.mContext.getResources().getDrawable(2130837740));
          paramView.bAB.bAy = bool3;
        }
        if (bool2)
        {
          localMBRuntime = paramView.mbRuntime;
          Context localContext = paramView.mContext;
          paramView.bAC = new com.tencent.luggage.game.d.b(com.tencent.luggage.game.c.c.uC().bAe, localMBRuntime, localContext, (com.tencent.mm.plugin.appbrand.jsapi.h)localObject2);
        }
        ((FrameLayout)???).setClipChildren(false);
        float f = paramView.mContext.getResources().getDisplayMetrics().density;
        if (paramView.bAC != null)
        {
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout)???).addView(paramView.bAC.bAm.getView(), (ViewGroup.LayoutParams)localObject2);
          localObject2 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject2).gravity = 8388693;
          ((FrameLayout.LayoutParams)localObject2).bottomMargin = ((int)(25.0F * f));
          int i = (int)(f * 15.0F);
          ((FrameLayout.LayoutParams)localObject2).rightMargin = i;
          ((FrameLayout.LayoutParams)localObject2).leftMargin = i;
          ((FrameLayout)???).addView(paramView.bAC.bAp, (ViewGroup.LayoutParams)localObject2);
        }
        if (paramView.bAB != null)
        {
          localObject2 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.ui.af.hV(paramView.mContext);
          ((FrameLayout)???).addView(paramView.bAB, (ViewGroup.LayoutParams)localObject2);
        }
      }
    }
    for (;;)
    {
      synchronized (paramView.bAE)
      {
        if (paramView.mState != 0)
        {
          this.bCa = new ImageView(getContext());
          this.bCa.setVisibility(8);
          this.bBV.addView(this.bCa, new FrameLayout.LayoutParams(-1, -1));
          this.bBV.addOnAttachStateChangeListener(this.bCc);
          AppMethodBeat.o(140514);
          return;
        }
        paramView.mState = 1;
        if ((bool2) && (paramView.bAC != null)) {
          paramView.bAC.post(new e.1(paramView));
        }
      }
      label757:
      com.tencent.luggage.g.d.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.game.e.a.a.c(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  public final void dispatchDestroy()
  {
    AppMethodBeat.i(140519);
    super.dispatchDestroy();
    this.bBW.notifyDestroy();
    vH();
    com.tencent.luggage.game.d.e.release();
    AppMethodBeat.o(140519);
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(140516);
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.f.class, new com.tencent.luggage.game.page.a.b((v)this.bDN));
    super.b(com.tencent.mm.plugin.appbrand.page.b.c.class, new g((v)this.bDN, wj().getAppConfig().hgQ.hha));
    AppMethodBeat.o(140516);
  }
  
  public final Bitmap r(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    Object localObject2 = null;
    AppMethodBeat.i(140524);
    com.tencent.luggage.g.d.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
    if (paramInt == -1)
    {
      com.tencent.luggage.g.d.e("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
      AppMethodBeat.o(140524);
      return null;
    }
    com.tencent.luggage.g.d.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject1;
    if (this.bBW == null)
    {
      com.tencent.luggage.g.d.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = localObject2;
    }
    for (;;)
    {
      com.tencent.luggage.g.d.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
      AppMethodBeat.o(140524);
      return localObject1;
      if ((!$assertionsDisabled) && (this.bBW.getMBRuntime() == null))
      {
        localObject1 = new AssertionError();
        AppMethodBeat.o(140524);
        throw ((Throwable)localObject1);
      }
      MBCanvasHandler localMBCanvasHandler = this.bBW.getMBRuntime().getCanvasHandler();
      localObject1 = localObject2;
      if (paramInt > 0)
      {
        if ((localMBCanvasHandler.mbRuntime.getScreenCanvasId() > 0) && (paramInt > 0) && (localMBCanvasHandler.mbRuntime.getScreenCanvasId() == paramInt)) {}
        for (;;)
        {
          if (i == 0) {
            break label215;
          }
          localObject1 = localMBCanvasHandler.a(null, paramBoolean);
          break;
          i = 0;
        }
        label215:
        if (paramBoolean)
        {
          localObject1 = localObject2;
          if (!localMBCanvasHandler.mbRuntime.isDestroyedUnlock()) {
            localObject1 = localMBCanvasHandler.nativeCaptureCanvas(localMBCanvasHandler.mNativeInst, paramInt);
          }
        }
        else
        {
          localObject1 = (Bitmap)localMBCanvasHandler.mbRuntime.getJsThreadHandler().a(new MBCanvasHandler.3(localMBCanvasHandler, paramInt));
        }
      }
    }
  }
  
  protected void vA()
  {
    AppMethodBeat.i(140511);
    b(d.class, this);
    AppMethodBeat.o(140511);
  }
  
  public final as vB()
  {
    return this.bBY;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.af vC()
  {
    return this.bBX;
  }
  
  public final void vD()
  {
    AppMethodBeat.i(140517);
    super.vD();
    vH();
    this.bBW.notifyForeground();
    AppMethodBeat.o(140517);
  }
  
  public final void vE()
  {
    AppMethodBeat.i(140518);
    super.vE();
    this.bBW.notifyBackground();
    AppMethodBeat.o(140518);
  }
  
  public final Map<String, m> vF()
  {
    AppMethodBeat.i(140520);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(140520);
    return localMap;
  }
  
  public final void vG() {}
  
  public MagicBrushView vI()
  {
    return this.bBW;
  }
  
  public final void vr()
  {
    AppMethodBeat.i(140523);
    vH();
    Object localObject = com.tencent.mm.plugin.appbrand.config.a.a.s(((com.tencent.luggage.sdk.b.a.c)this.bDN).wj().getContext()).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK());
    if ((a.b.hkF == localObject) || (a.b.hkG == localObject) || (a.b.hkH == localObject) || (a.b.hkI == localObject))
    {
      if (this.bCa == null)
      {
        com.tencent.luggage.g.d.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
        AppMethodBeat.o(140523);
        return;
      }
      if (this.bBW != null) {
        break label127;
      }
      ab.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
    }
    for (localObject = null;; localObject = this.bBW.getMBRuntime().getCanvasHandler().a(null, true))
    {
      this.bBZ = ((Bitmap)localObject);
      this.bBV.setOnConfigurationChangedListener(new h.4(this));
      AppMethodBeat.o(140523);
      return;
      label127:
      if ((!$assertionsDisabled) && (this.bBW.getMBRuntime() == null))
      {
        localObject = new AssertionError();
        AppMethodBeat.o(140523);
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.h
 * JD-Core Version:    0.7.0.1
 */