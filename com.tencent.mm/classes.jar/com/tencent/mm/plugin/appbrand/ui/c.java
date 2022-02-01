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
import com.tencent.mm.plugin.appbrand.ad.f;
import com.tencent.mm.plugin.appbrand.ad.f.4;
import com.tencent.mm.plugin.appbrand.ad.f.a;
import com.tencent.mm.plugin.appbrand.ad.j;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

@SuppressLint({"ViewConstructor"})
public final class c
  extends FrameLayout
  implements q, w, x, y, z
{
  private p jFm;
  private w mEs;
  private f mEt;
  private j mEu;
  
  public c(Context paramContext, AppBrandRuntime paramAppBrandRuntime, w paramw, j paramj)
  {
    super(paramContext);
    AppMethodBeat.i(223029);
    this.jFm = ((p)paramAppBrandRuntime);
    this.mEs = paramw;
    this.mEu = paramj;
    paramAppBrandRuntime = this.jFm;
    ae.i("MicroMsg.AppBrandAdLoadingSplash", "initRuntimeAdViewContainer, runtime:%s", new Object[] { paramAppBrandRuntime });
    this.mEt = new f(paramContext, paramAppBrandRuntime);
    this.mEt.aYx();
    this.mEt.aYy();
    this.mEt.setForegroundStyle(false);
    this.mEt.setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(223025);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (c.a(c.this) != null) {
          c.a(c.this).aYG();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223025);
      }
    });
    this.mEt.setOnHideListener(new f.a()
    {
      public final void Ls(String paramAnonymousString)
      {
        AppMethodBeat.i(223026);
        if (c.a(c.this) != null) {
          c.a(c.this).Lt(paramAnonymousString);
        }
        AppMethodBeat.o(223026);
      }
    });
    this.mEt.setOptionButtonClickListener(new c.3(this));
    if (this.mEs != null) {
      addView(this.mEs.getView(), new ViewGroup.LayoutParams(-1, -1));
    }
    if (this.mEt != null) {
      addView(this.mEt, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(223029);
  }
  
  public final boolean aWP()
  {
    AppMethodBeat.i(223035);
    if ((this.mEt != null) && (indexOfChild(this.mEt) >= 0) && (this.mEt.getVisibility() == 0) && (com.tencent.mm.plugin.appbrand.o.Ld(this.jFm.mAppId).jBS.jEG))
    {
      AppMethodBeat.o(223035);
      return true;
    }
    AppMethodBeat.o(223035);
    return false;
  }
  
  public final void aYF()
  {
    AppMethodBeat.i(223031);
    if (this.mEu != null) {
      this.mEu.aYF();
    }
    AppMethodBeat.o(223031);
  }
  
  public final void aYI()
  {
    AppMethodBeat.i(223032);
    if (this.mEt != null)
    {
      f localf = this.mEt;
      if (ar.isMainThread())
      {
        localf.setVisibility(8);
        AppMethodBeat.o(223032);
        return;
      }
      ar.f(new f.4(localf));
    }
    AppMethodBeat.o(223032);
  }
  
  public final void bzO()
  {
    AppMethodBeat.i(223034);
    this.jFm.j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223028);
        if ((c.this.getParent() instanceof ViewGroup))
        {
          ae.i("MicroMsg.AppBrandAdLoadingSplash", "remove AdLoadingSplash");
          c.this.setVisibility(8);
          ((ViewGroup)c.this.getParent()).removeView(c.this);
          c.b(c.this).jzG = null;
        }
        AppMethodBeat.o(223028);
      }
    }, 0L);
    AppMethodBeat.o(223034);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223036);
    if (this.mEs != null) {
      this.mEs.dX(paramString1, paramString2);
    }
    AppMethodBeat.o(223036);
  }
  
  public final w getInternalLoadingSplash()
  {
    return this.mEs;
  }
  
  public final f getRuntimeAdViewContainer()
  {
    return this.mEt;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void l(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(223033);
    if (this.mEt != null) {
      this.mEt.j(paramBoolean, paramString);
    }
    AppMethodBeat.o(223033);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(223030);
    super.onAttachedToWindow();
    for (;;)
    {
      try
      {
        Object localObject1 = getContext().getResources().getConfiguration();
        if ((this.jFm.getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
        {
          Object localObject2 = com.tencent.mm.sdk.f.a.jw(((com.tencent.mm.plugin.appbrand.platform.window.a.o)this.jFm.getWindowAndroid()).mContext);
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
              AppMethodBeat.o(223030);
              return;
            }
            t.a((Window)localObject1, false, false);
          }
        }
        AppMethodBeat.o(223030);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.AppBrandAdLoadingSplash", "onAttachedToWindow exception", new Object[] { localException });
        AppMethodBeat.o(223030);
        return;
      }
      label171:
      int i = 0;
    }
  }
  
  public final void rF(int paramInt)
  {
    AppMethodBeat.i(223040);
    if ((this.mEs instanceof q)) {
      ((q)this.mEs).rF(paramInt);
    }
    AppMethodBeat.o(223040);
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(223041);
    if ((this.mEs instanceof z)) {
      ((z)this.mEs).setCanShowHideAnimation(paramBoolean);
    }
    AppMethodBeat.o(223041);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(223038);
    if (this.mEs != null) {
      this.mEs.setProgress(paramInt);
    }
    AppMethodBeat.o(223038);
  }
  
  public final void uD(int paramInt)
  {
    AppMethodBeat.i(223039);
    if (this.mEs != null) {
      this.mEs.uD(paramInt);
    }
    AppMethodBeat.o(223039);
  }
  
  public final void v(d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(223037);
    if (this.mEs != null) {
      this.mEs.v(parama);
    }
    AppMethodBeat.o(223037);
  }
  
  public final void x(d.g.a.a<d.z> parama)
  {
    AppMethodBeat.i(223042);
    if ((this.mEs instanceof y)) {
      ((y)this.mEs).x(parama);
    }
    AppMethodBeat.o(223042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */