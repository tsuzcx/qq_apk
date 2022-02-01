package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.luggage.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.HuaweiKt;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class bn
  implements com.tencent.mm.plugin.appbrand.page.a.b, com.tencent.mm.plugin.appbrand.page.a.d
{
  private final ad enm;
  volatile String enx;
  private boolean eny;
  private boolean mDestroyed;
  final com.tencent.luggage.sdk.b.a.c.d tAi;
  private boolean tAj;
  private boolean tAk;
  private Configuration tAl;
  private a tAm;
  
  bn(ad paramad)
  {
    AppMethodBeat.i(147449);
    this.eny = false;
    this.mDestroyed = false;
    this.tAj = false;
    this.tAk = false;
    this.enm = paramad;
    this.tAi = new com.tencent.luggage.sdk.b.a.c.d(paramad);
    this.enm.tuD.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(147445);
        if (TextUtils.isEmpty(bn.a(bn.this).cgR()))
        {
          AppMethodBeat.o(147445);
          return;
        }
        if (bn.b(bn.this)) {
          try
          {
            bn.a(bn.this).tuD.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(147445);
            return;
          }
          catch (ConcurrentModificationException paramAnonymousView)
          {
            bn.a(bn.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147444);
                bn.a(bn.this).tuD.removeOnLayoutChangeListener(jdField_this);
                AppMethodBeat.o(147444);
              }
            });
            AppMethodBeat.o(147445);
            return;
          }
        }
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { bn.a(bn.this).getAppId(), bn.a(bn.this).cgR(), Boolean.valueOf(bn.c(bn.this)) });
        if (bn.c(bn.this))
        {
          bn.d(bn.this);
          AppMethodBeat.o(147445);
          return;
        }
        bn.e(bn.this);
        AppMethodBeat.o(147445);
      }
    });
    AppMethodBeat.o(147449);
  }
  
  private void cFP()
  {
    AppMethodBeat.i(185221);
    if (this.enm.ari() == null)
    {
      AppMethodBeat.o(185221);
      return;
    }
    if (this.mDestroyed)
    {
      AppMethodBeat.o(185221);
      return;
    }
    this.tAi.ars();
    AppMethodBeat.o(185221);
  }
  
  private boolean cFQ()
  {
    AppMethodBeat.i(325029);
    if ((e.b.c(getOrientationHandler().cHQ())) && (((com.tencent.luggage.sdk.config.a)this.enm.aN(com.tencent.luggage.sdk.config.a.class)).eoJ))
    {
      AppMethodBeat.o(325029);
      return true;
    }
    AppMethodBeat.o(325029);
    return false;
  }
  
  private boolean cFR()
  {
    AppMethodBeat.i(325031);
    if (this.enm.qwF.asq())
    {
      AppMethodBeat.o(325031);
      return false;
    }
    if ((k.exm.atn()) && (ac.fo(this.enm.getContext())))
    {
      AppMethodBeat.o(325031);
      return true;
    }
    if ((HuaweiKt.hasHuaweiMagicWindowFeature()) && (ac.fo(this.enm.getContext())) && (!k.exm.atn()))
    {
      AppMethodBeat.o(325031);
      return true;
    }
    AppMethodBeat.o(325031);
    return false;
  }
  
  private e getOrientationHandler()
  {
    AppMethodBeat.i(169507);
    e locale = this.enm.qwF.getOrientationHandler();
    AppMethodBeat.o(169507);
    return locale;
  }
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(185220);
    this.tAj = paramBoolean;
    if ((!this.tAj) && (this.tAk))
    {
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.enm.getAppId(), this.enm.cgR(), Boolean.valueOf(this.mDestroyed) });
      cFP();
      this.tAk = false;
    }
    AppMethodBeat.o(185220);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(169508);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.enm.V(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147447);
          bn.this.a(parama);
          AppMethodBeat.o(147447);
        }
      });
      AppMethodBeat.o(169508);
      return;
    }
    if (this.mDestroyed)
    {
      Log.w("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { this.enm.getAppId(), this.enm.cgR() });
      AppMethodBeat.o(169508);
      return;
    }
    ks(true);
    parama = new e.a()
    {
      public final void onOrientationChanged(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(169506);
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { bn.f(bn.this), bn.g(bn.this), paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        if (parama != null) {
          parama.onOrientationChanged(paramAnonymousb, paramAnonymousBoolean);
        }
        bn.h(bn.this);
        AppMethodBeat.o(169506);
      }
    };
    boolean bool = this.enm.qwF instanceof o;
    if ((e.b.c(getOrientationHandler().cHQ())) && (bool) && ((cFQ()) || (cFR())))
    {
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.enm.getAppId(), this.enm.cgR() });
      parama.onOrientationChanged(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    if (this.enm.getRuntime().cbO())
    {
      Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.onOrientationChanged(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.enm.getAppId(), this.enm.cgR(), this.enx });
    String str = Util.nullAs(this.enx, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.enm.getAppId(), this.enm.cgR(), this.enx });
        if (!this.enm.qsQ) {
          break label565;
        }
        parama = new IllegalArgumentException(str);
        AppMethodBeat.o(169508);
        throw parama;
        if (str.equals("auto"))
        {
          i = 0;
          continue;
          if (str.equals("landscape"))
          {
            i = 1;
            continue;
            if (str.equals("portrait"))
            {
              i = 2;
              continue;
              if (str.equals("landscapeLeft")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    getOrientationHandler().a(e.b.tLi, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.tLj, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.tLh, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.tLl, parama);
    AppMethodBeat.o(169508);
    return;
    label565:
    Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", str);
    parama.onOrientationChanged(null, false);
    AppMethodBeat.o(169508);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final boolean apZ()
  {
    AppMethodBeat.i(147450);
    Object localObject;
    if (this.enm.qwF == null)
    {
      localObject = null;
      if ((localObject != null) && (!(localObject instanceof com.tencent.mm.plugin.appbrand.platform.window.c.a.a))) {
        break label95;
      }
      Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.enm.getAppId(), this.enm.cgR() });
    }
    label61:
    for (boolean bool = false;; bool = true)
    {
      this.tAi.esd = bool;
      AppMethodBeat.o(147450);
      return bool;
      localObject = this.enm.qwF.getOrientationHandler();
      break;
      label95:
      e.b localb2 = ((e)localObject).cHQ();
      e.b localb1 = e.b.afK(this.enx);
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.enm.getAppId(), this.enm.cgR(), localb2, localb1 });
      if (e.b.tLi == localb1) {
        break label61;
      }
      if (((this.enm.qwF instanceof o)) && ((cFR()) || (cFQ())))
      {
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], fixed orientation device", new Object[] { this.enm.getAppId(), this.enm.cgR() });
        break label61;
      }
      localObject = localb1;
      if (localb1 == null) {
        localObject = e.b.tLh;
      }
      if (localb2.b((e.b)localObject)) {
        break label61;
      }
    }
  }
  
  public final String aqa()
  {
    return this.enx;
  }
  
  public final void fb(String paramString)
  {
    AppMethodBeat.i(147451);
    this.enx = paramString;
    a(null);
    AppMethodBeat.o(147451);
  }
  
  public final void onBackground()
  {
    this.eny = false;
    this.tAi.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(325155);
    if ((this.eny) && (!this.mDestroyed) && (this.tAl != null) && (this.tAl.orientation != paramConfiguration.orientation))
    {
      this.tAl = new Configuration(paramConfiguration);
      if (this.tAm == null) {
        this.tAm = new a((byte)0);
      }
      paramConfiguration = this.tAm;
      paramConfiguration.tAn.ks(true);
      paramConfiguration.Ma();
      Object localObject = (View)Objects.requireNonNull(paramConfiguration.tAn.enm.getContentView());
      ((View)localObject).postDelayed(paramConfiguration.tAt, 100L);
      localObject = ((View)localObject).getViewTreeObserver();
      bn.a.2 local2 = new bn.a.2(paramConfiguration);
      paramConfiguration.mA = local2;
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
    }
    AppMethodBeat.o(325155);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(325147);
    this.eny = false;
    this.mDestroyed = true;
    if (this.tAm != null)
    {
      a locala = this.tAm;
      locala.Ma();
      locala.mA = null;
      locala.tAt = null;
    }
    AppMethodBeat.o(325147);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147454);
    if (this.tAl == null) {
      this.tAl = new Configuration(((u)Objects.requireNonNull(this.enm.txk)).getResources().getConfiguration());
    }
    this.eny = true;
    if ((this.enm.getFullscreenImpl() != null) && (this.enm.getFullscreenImpl().cHN())) {
      this.enm.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void aqb()
        {
          AppMethodBeat.i(324869);
          bn.a(bn.this).getFullscreenImpl().b(this);
          if ((!bn.b(bn.this)) && (bn.i(bn.this))) {
            bn.this.a(null);
          }
          AppMethodBeat.o(324869);
        }
      });
    }
    for (;;)
    {
      com.tencent.luggage.sdk.b.a.c.d locald = this.tAi;
      if (locald.erZ)
      {
        Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { locald.enm.getAppId(), locald.enm.cgR() });
        locald.art();
        locald.erZ = false;
      }
      locald.foreground = true;
      AppMethodBeat.o(147454);
      return;
      a(null);
    }
  }
  
  public final void r(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147452);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.enm.V(new bn.2(this, paramString, paramMap));
      AppMethodBeat.o(147452);
      return;
    }
    this.tAi.j(paramMap);
    fb(paramString);
    AppMethodBeat.o(147452);
  }
  
  final class a
  {
    ViewTreeObserver.OnGlobalLayoutListener mA;
    Runnable tAt;
    
    private a()
    {
      AppMethodBeat.i(324926);
      this.tAt = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(325059);
          bn.h(bn.this);
          AppMethodBeat.o(325059);
        }
      };
      AppMethodBeat.o(324926);
    }
    
    final void Ma()
    {
      AppMethodBeat.i(324929);
      View localView = bn.a(bn.this).getContentView();
      if (localView != null)
      {
        localView.removeCallbacks(this.tAt);
        if (this.mA != null) {
          localView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mA);
        }
      }
      AppMethodBeat.o(324929);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bn
 * JD-Core Version:    0.7.0.1
 */