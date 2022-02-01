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
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public final class c
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.launching.q, ab, ac, ad, ae
{
  private com.tencent.mm.plugin.appbrand.q kGW;
  private ab nRh;
  private f nRi;
  private j nRj;
  
  public c(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ab paramab, j paramj)
  {
    super(paramContext);
    AppMethodBeat.i(227546);
    this.kGW = ((com.tencent.mm.plugin.appbrand.q)paramAppBrandRuntime);
    this.nRh = paramab;
    this.nRj = paramj;
    paramAppBrandRuntime = this.kGW;
    Log.i("MicroMsg.AppBrandAdLoadingSplash", "initRuntimeAdViewContainer, runtime:%s", new Object[] { paramAppBrandRuntime });
    this.nRi = new f(paramContext, paramAppBrandRuntime);
    this.nRi.btL();
    this.nRi.btM();
    this.nRi.setForegroundStyle(false);
    this.nRi.setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(227542);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (c.a(c.this) != null) {
          c.a(c.this).btS();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227542);
      }
    });
    this.nRi.setOnHideListener(new f.a()
    {
      public final void UB(String paramAnonymousString)
      {
        AppMethodBeat.i(227543);
        if (c.a(c.this) != null) {
          c.a(c.this).UC(paramAnonymousString);
        }
        AppMethodBeat.o(227543);
      }
    });
    this.nRi.setOptionButtonClickListener(new c.3(this));
    if (this.nRh != null) {
      addView(this.nRh.getView(), new ViewGroup.LayoutParams(-1, -1));
    }
    if (this.nRi != null) {
      addView(this.nRi, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(227546);
  }
  
  public final void B(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(227548);
    if (this.nRj != null) {
      this.nRj.btR();
    }
    AppMethodBeat.o(227548);
  }
  
  public final void C(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(227559);
    if ((this.nRh instanceof ad)) {
      ((ad)this.nRh).C(parama);
    }
    AppMethodBeat.o(227559);
  }
  
  public final void bWI()
  {
    AppMethodBeat.i(227549);
    if (this.nRi != null)
    {
      f localf = this.nRi;
      if (MMHandlerThread.isMainThread())
      {
        localf.setVisibility(8);
        AppMethodBeat.o(227549);
        return;
      }
      MMHandlerThread.postToMainThread(new f.4(localf));
    }
    AppMethodBeat.o(227549);
  }
  
  public final void bWJ()
  {
    AppMethodBeat.i(227551);
    this.kGW.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227545);
        if ((c.this.getParent() instanceof ViewGroup))
        {
          Log.i("MicroMsg.AppBrandAdLoadingSplash", "remove AdLoadingSplash");
          c.this.setVisibility(8);
          ((ViewGroup)c.this.getParent()).removeView(c.this);
          c.b(c.this).brN();
        }
        AppMethodBeat.o(227545);
      }
    }, 0L);
    AppMethodBeat.o(227551);
  }
  
  public final boolean brM()
  {
    AppMethodBeat.i(227552);
    if ((this.nRi != null) && (indexOfChild(this.nRi) >= 0) && (this.nRi.getVisibility() == 0) && (p.Um(this.kGW.mAppId).kCO.kGq))
    {
      AppMethodBeat.o(227552);
      return true;
    }
    AppMethodBeat.o(227552);
    return false;
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227553);
    if (this.nRh != null) {
      this.nRh.eo(paramString1, paramString2);
    }
    AppMethodBeat.o(227553);
  }
  
  public final ab getInternalLoadingSplash()
  {
    return this.nRh;
  }
  
  public final f getRuntimeAdViewContainer()
  {
    return this.nRi;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(227550);
    if (this.nRi != null) {
      this.nRi.k(paramBoolean, paramString);
    }
    AppMethodBeat.o(227550);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(227547);
    super.onAttachedToWindow();
    for (;;)
    {
      try
      {
        Object localObject1 = getContext().getResources().getConfiguration();
        if ((this.kGW.getWindowAndroid() instanceof o))
        {
          Object localObject2 = AndroidContextUtil.castActivityOrNull(((o)this.kGW.getWindowAndroid()).mContext);
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
              AppMethodBeat.o(227547);
              return;
            }
            y.a((Window)localObject1, false, false);
          }
        }
        AppMethodBeat.o(227547);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandAdLoadingSplash", "onAttachedToWindow exception", new Object[] { localException });
        AppMethodBeat.o(227547);
        return;
      }
      label171:
      int i = 0;
    }
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(227558);
    if ((this.nRh instanceof ae)) {
      ((ae)this.nRh).setCanShowHideAnimation(paramBoolean);
    }
    AppMethodBeat.o(227558);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(227555);
    if (this.nRh != null) {
      this.nRh.setProgress(paramInt);
    }
    AppMethodBeat.o(227555);
  }
  
  public final void vy(int paramInt)
  {
    AppMethodBeat.i(227557);
    if ((this.nRh instanceof com.tencent.mm.plugin.appbrand.launching.q)) {
      ((com.tencent.mm.plugin.appbrand.launching.q)this.nRh).vy(paramInt);
    }
    AppMethodBeat.o(227557);
  }
  
  public final void yu(int paramInt)
  {
    AppMethodBeat.i(227556);
    if (this.nRh != null) {
      this.nRh.yu(paramInt);
    }
    AppMethodBeat.o(227556);
  }
  
  public final void z(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(227554);
    if (this.nRh != null) {
      this.nRh.z(parama);
    }
    AppMethodBeat.o(227554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */