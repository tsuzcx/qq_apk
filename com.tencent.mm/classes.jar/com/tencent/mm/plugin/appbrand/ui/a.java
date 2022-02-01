package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.plugin.appbrand.ad.f.a;
import com.tencent.mm.plugin.appbrand.ad.h;
import com.tencent.mm.plugin.appbrand.ad.j;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class a
  extends FrameLayout
  implements q, ai, aj, ak
{
  private w qxC;
  private ah tXp;
  public f tXq;
  private j tXr;
  
  public a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ah paramah, j paramj)
  {
    super(paramContext);
    AppMethodBeat.i(322100);
    this.qxC = ((w)paramAppBrandRuntime);
    this.tXp = paramah;
    this.tXr = paramj;
    paramAppBrandRuntime = this.qxC;
    Log.i("MicroMsg.AppBrandAdLoadingSplash", "initRuntimeAdViewContainer, runtime:%s", new Object[] { paramAppBrandRuntime });
    this.tXq = new f(paramContext, paramAppBrandRuntime);
    this.tXq.cdV();
    this.tXq.cdW();
    this.tXq.setForegroundStyle(false);
    this.tXq.setCloseButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(322451);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (a.a(a.this) != null) {
          a.a(a.this).cee();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(322451);
      }
    });
    this.tXq.setOnHideListener(new f.a()
    {
      public final void UL(String paramAnonymousString)
      {
        AppMethodBeat.i(322445);
        if (a.a(a.this) != null) {
          a.a(a.this).UM(paramAnonymousString);
        }
        AppMethodBeat.o(322445);
      }
    });
    this.tXq.setOptionButtonClickListener(new a.3(this));
    if (this.tXp != null) {
      addView(this.tXp.getView(), new ViewGroup.LayoutParams(-1, -1));
    }
    if (this.tXq != null) {
      addView(this.tXq, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(322100);
  }
  
  public final void B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(322133);
    if (this.tXq != null) {
      this.tXq.B(paramBoolean, paramString);
    }
    AppMethodBeat.o(322133);
  }
  
  public final void Cj(int paramInt)
  {
    AppMethodBeat.i(322159);
    if (this.tXp != null) {
      this.tXp.Cj(paramInt);
    }
    AppMethodBeat.o(322159);
  }
  
  public final void as(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322151);
    if (this.tXp != null) {
      this.tXp.as(parama);
    }
    AppMethodBeat.o(322151);
  }
  
  public final void au(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322123);
    if (this.tXr != null) {
      this.tXr.ced();
    }
    AppMethodBeat.o(322123);
  }
  
  public final void av(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322171);
    if ((this.tXp instanceof aj)) {
      ((aj)this.tXp).av(parama);
    }
    AppMethodBeat.o(322171);
  }
  
  public final void cKm()
  {
    AppMethodBeat.i(322125);
    if (this.tXq != null) {
      this.tXq.cdY();
    }
    AppMethodBeat.o(322125);
  }
  
  public final void cKn()
  {
    AppMethodBeat.i(322136);
    this.qxC.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(322510);
        if ((a.this.getParent() instanceof ViewGroup))
        {
          Log.i("MicroMsg.AppBrandAdLoadingSplash", "remove AdLoadingSplash");
          a.this.setVisibility(8);
          ((ViewGroup)a.this.getParent()).removeView(a.this);
          a.b(a.this).cbP();
        }
        AppMethodBeat.o(322510);
      }
    }, 0L);
    AppMethodBeat.o(322136);
  }
  
  public final boolean cbO()
  {
    AppMethodBeat.i(322139);
    if ((this.tXq != null) && (indexOfChild(this.tXq) >= 0) && (this.tXq.getVisibility() == 0) && (u.Ux(this.qxC.mAppId).quV.qza))
    {
      AppMethodBeat.o(322139);
      return true;
    }
    AppMethodBeat.o(322139);
    return false;
  }
  
  public final void eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(322145);
    if (this.tXp != null) {
      this.tXp.eT(paramString1, paramString2);
    }
    AppMethodBeat.o(322145);
  }
  
  public final ah getInternalLoadingSplash()
  {
    return this.tXp;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(322176);
    if ((this.tXp instanceof AppBrandUILoadingSplash))
    {
      int i = ((AppBrandUILoadingSplash)this.tXp).getProgress();
      AppMethodBeat.o(322176);
      return i;
    }
    AppMethodBeat.o(322176);
    return -2;
  }
  
  public final f getRuntimeAdViewContainer()
  {
    return this.tXq;
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(322112);
    super.onAttachedToWindow();
    for (;;)
    {
      try
      {
        if (h.y(this.qxC)) {
          this.tXq.cdY();
        }
        Object localObject1 = getContext().getResources().getConfiguration();
        if ((this.qxC.getWindowAndroid() instanceof o))
        {
          Object localObject2 = AndroidContextUtil.castActivityOrNull(((o)this.qxC.getWindowAndroid()).mContext);
          if (((Configuration)localObject1).orientation != 2) {
            break label198;
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
              AppMethodBeat.o(322112);
              return;
            }
            if (!this.qxC.aqJ()) {
              ae.a((Window)localObject1, false, false);
            }
          }
        }
        AppMethodBeat.o(322112);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandAdLoadingSplash", "onAttachedToWindow exception", new Object[] { localException });
        AppMethodBeat.o(322112);
        return;
      }
      label198:
      int i = 0;
    }
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(322166);
    if ((this.tXp instanceof ak)) {
      ((ak)this.tXp).setCanShowHideAnimation(paramBoolean);
    }
    AppMethodBeat.o(322166);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(322156);
    if (this.tXp != null) {
      this.tXp.setProgress(paramInt);
    }
    AppMethodBeat.o(322156);
  }
  
  public final void yU(int paramInt)
  {
    AppMethodBeat.i(322162);
    if ((this.tXp instanceof q)) {
      ((q)this.tXp).yU(paramInt);
    }
    AppMethodBeat.o(322162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */