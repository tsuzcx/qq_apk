package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.c;
import com.tencent.mm.plugin.appbrand.ad.f;
import com.tencent.mm.plugin.appbrand.ad.f.4;
import com.tencent.mm.plugin.appbrand.ad.f.a;
import com.tencent.mm.plugin.appbrand.ad.j;
import com.tencent.mm.plugin.appbrand.launching.p;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;

@SuppressLint({"ViewConstructor"})
public final class a
  extends FrameLayout
  implements p, ab, ac, ad
{
  private t nAH;
  private aa qSK;
  private f qSL;
  private j qSM;
  
  public a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, aa paramaa, j paramj)
  {
    super(paramContext);
    AppMethodBeat.i(265625);
    this.nAH = ((t)paramAppBrandRuntime);
    this.qSK = paramaa;
    this.qSM = paramj;
    paramAppBrandRuntime = this.nAH;
    Log.i("MicroMsg.AppBrandAdLoadingSplash", "initRuntimeAdViewContainer, runtime:%s", new Object[] { paramAppBrandRuntime });
    this.qSL = new f(paramContext, paramAppBrandRuntime);
    this.qSL.bEK();
    this.qSL.bEL();
    this.qSL.setForegroundStyle(false);
    this.qSL.setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276258);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (a.a(a.this) != null) {
          a.a(a.this).bER();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276258);
      }
    });
    this.qSL.setOnHideListener(new f.a()
    {
      public final void acl(String paramAnonymousString)
      {
        AppMethodBeat.i(270903);
        if (a.a(a.this) != null) {
          a.a(a.this).acm(paramAnonymousString);
        }
        AppMethodBeat.o(270903);
      }
    });
    this.qSL.setOptionButtonClickListener(new a.3(this));
    if (this.qSK != null) {
      addView(this.qSK.getView(), new ViewGroup.LayoutParams(-1, -1));
    }
    if (this.qSL != null) {
      addView(this.qSL, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(265625);
  }
  
  public final void A(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(265642);
    if ((this.qSK instanceof ac)) {
      ((ac)this.qSK).A(parama);
    }
    AppMethodBeat.o(265642);
  }
  
  public final void BU(int paramInt)
  {
    AppMethodBeat.i(265636);
    if (this.qSK != null) {
      this.qSK.BU(paramInt);
    }
    AppMethodBeat.o(265636);
  }
  
  public final boolean bCB()
  {
    AppMethodBeat.i(265632);
    if ((this.qSL != null) && (indexOfChild(this.qSL) >= 0) && (this.qSL.getVisibility() == 0) && (s.abV(this.nAH.mAppId).nvY.nzX))
    {
      AppMethodBeat.o(265632);
      return true;
    }
    AppMethodBeat.o(265632);
    return false;
  }
  
  public final void cjm()
  {
    AppMethodBeat.i(265629);
    if (this.qSL != null)
    {
      f localf = this.qSL;
      if (MMHandlerThread.isMainThread())
      {
        localf.setVisibility(8);
        AppMethodBeat.o(265629);
        return;
      }
      MMHandlerThread.postToMainThread(new f.4(localf));
    }
    AppMethodBeat.o(265629);
  }
  
  public final void cjn()
  {
    AppMethodBeat.i(265631);
    this.nAH.h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(273311);
        if ((a.this.getParent() instanceof ViewGroup))
        {
          Log.i("MicroMsg.AppBrandAdLoadingSplash", "remove AdLoadingSplash");
          a.this.setVisibility(8);
          ((ViewGroup)a.this.getParent()).removeView(a.this);
          a.b(a.this).bCC();
        }
        AppMethodBeat.o(273311);
      }
    }, 0L);
    AppMethodBeat.o(265631);
  }
  
  public final void eC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265633);
    if (this.qSK != null) {
      this.qSK.eC(paramString1, paramString2);
    }
    AppMethodBeat.o(265633);
  }
  
  public final aa getInternalLoadingSplash()
  {
    return this.qSK;
  }
  
  public final f getRuntimeAdViewContainer()
  {
    return this.qSL;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void o(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(265630);
    if (this.qSL != null) {
      this.qSL.o(paramBoolean, paramString);
    }
    AppMethodBeat.o(265630);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(265627);
    super.onAttachedToWindow();
    for (;;)
    {
      try
      {
        Object localObject1 = getContext().getResources().getConfiguration();
        if ((this.nAH.getWindowAndroid() instanceof o))
        {
          Object localObject2 = AndroidContextUtil.castActivityOrNull(((o)this.nAH.getWindowAndroid()).mContext);
          if (((Configuration)localObject1).orientation != 2) {
            break label171;
          }
          i = 1;
          if (((i == 0) || (localObject2 == null) || (Build.VERSION.SDK_INT < 24) || (!((Activity)localObject2).isInMultiWindowMode()) || (((Activity)localObject2).getRequestedOrientation() != 1)) && (localObject2 != null))
          {
            localObject1 = ((Activity)localObject2).getWindow();
            localObject2 = ((Window)localObject1).getDecorView();
            if (i != 0)
            {
              ((Window)localObject1).addFlags(1024);
              ((View)localObject2).setSystemUiVisibility(((View)localObject2).getSystemUiVisibility() | 0x4 | 0x100);
              AppMethodBeat.o(265627);
              return;
            }
            x.a((Window)localObject1, false, false);
          }
        }
        AppMethodBeat.o(265627);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandAdLoadingSplash", "onAttachedToWindow exception", new Object[] { localException });
        AppMethodBeat.o(265627);
        return;
      }
      label171:
      int i = 0;
    }
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(265639);
    if ((this.qSK instanceof ad)) {
      ((ad)this.qSK).setCanShowHideAnimation(paramBoolean);
    }
    AppMethodBeat.o(265639);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(265635);
    if (this.qSK != null) {
      this.qSK.setProgress(paramInt);
    }
    AppMethodBeat.o(265635);
  }
  
  public final void x(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(265634);
    if (this.qSK != null) {
      this.qSK.x(parama);
    }
    AppMethodBeat.o(265634);
  }
  
  public final void yL(int paramInt)
  {
    AppMethodBeat.i(265638);
    if ((this.qSK instanceof p)) {
      ((p)this.qSK).yL(paramInt);
    }
    AppMethodBeat.o(265638);
  }
  
  public final void z(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(265628);
    if (this.qSM != null) {
      this.qSM.bEQ();
    }
    AppMethodBeat.o(265628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */