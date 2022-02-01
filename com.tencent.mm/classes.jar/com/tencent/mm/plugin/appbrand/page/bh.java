package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class bh
  implements com.tencent.mm.plugin.appbrand.page.a.b, com.tencent.mm.plugin.appbrand.page.a.d
{
  private final z ckP;
  volatile String ckZ;
  private boolean cla;
  private boolean mDestroyed;
  final com.tencent.luggage.sdk.b.a.b.e mjd;
  private boolean mje;
  private boolean mjf;
  private Configuration mjg;
  private a mjh;
  
  bh(z paramz)
  {
    AppMethodBeat.i(147449);
    this.cla = false;
    this.mDestroyed = false;
    this.mje = false;
    this.mjf = false;
    this.ckP = paramz;
    this.mjd = new com.tencent.luggage.sdk.b.a.b.e(paramz);
    this.ckP.mdY.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(147445);
        if (TextUtils.isEmpty(bh.a(bh.this).kxv))
        {
          AppMethodBeat.o(147445);
          return;
        }
        if (bh.b(bh.this)) {
          try
          {
            bh.a(bh.this).mdY.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(147445);
            return;
          }
          catch (ConcurrentModificationException paramAnonymousView)
          {
            bh.a(bh.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147444);
                bh.a(bh.this).mdY.removeOnLayoutChangeListener(jdField_this);
                AppMethodBeat.o(147444);
              }
            });
            AppMethodBeat.o(147445);
            return;
          }
        }
        ae.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { bh.a(bh.this).getAppId(), bh.a(bh.this).kxv, Boolean.valueOf(bh.c(bh.this)) });
        if (bh.c(bh.this))
        {
          bh.d(bh.this);
          AppMethodBeat.o(147445);
          return;
        }
        bh.e(bh.this);
        AppMethodBeat.o(147445);
      }
    });
    AppMethodBeat.o(147449);
  }
  
  private void bvY()
  {
    AppMethodBeat.i(185221);
    if (this.ckP.Ey() == null)
    {
      AppMethodBeat.o(185221);
      return;
    }
    if (this.mDestroyed)
    {
      AppMethodBeat.o(185221);
      return;
    }
    this.mjd.EE();
    AppMethodBeat.o(185221);
  }
  
  private com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    AppMethodBeat.i(169507);
    com.tencent.mm.plugin.appbrand.platform.window.e locale = this.ckP.jDa.getOrientationHandler();
    AppMethodBeat.o(169507);
    return locale;
  }
  
  private void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(185220);
    this.mje = paramBoolean;
    if ((!this.mje) && (this.mjf))
    {
      ae.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.ckP.getAppId(), this.ckP.kxv, Boolean.valueOf(this.mDestroyed) });
      bvY();
      this.mjf = false;
    }
    AppMethodBeat.o(185220);
  }
  
  public final boolean DB()
  {
    AppMethodBeat.i(147450);
    Object localObject;
    if (this.ckP.jDa == null)
    {
      localObject = null;
      if ((localObject != null) && (!(localObject instanceof com.tencent.mm.plugin.appbrand.platform.window.b.a.a))) {
        break label92;
      }
      ae.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.ckP.getAppId(), this.ckP.kxv });
    }
    label92:
    label242:
    for (;;)
    {
      boolean bool = false;
      this.mjd.cox = bool;
      AppMethodBeat.o(147450);
      return bool;
      localObject = this.ckP.jDa.getOrientationHandler();
      break;
      e.b localb = ((com.tencent.mm.plugin.appbrand.platform.window.e)localObject).aYg();
      localObject = e.b.UP(this.ckZ);
      ae.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.ckP.getAppId(), this.ckP.kxv, localb, localObject });
      if (e.b.mtE != localObject) {
        if ((e.b.c(getOrientationHandler().aYg())) && (((com.tencent.luggage.sdk.config.a)this.ckP.ar(com.tencent.luggage.sdk.config.a.class)).cml))
        {
          ae.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.ckP.getAppId(), this.ckP.kxv });
        }
        else
        {
          if (localObject == null) {
            localObject = e.b.mtD;
          }
          for (;;)
          {
            if (localb.b((e.b)localObject)) {
              break label242;
            }
            bool = true;
            break;
          }
        }
      }
    }
  }
  
  public final String DC()
  {
    return this.ckZ;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(169508);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.ckP.K(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147447);
          bh.this.a(parama);
          AppMethodBeat.o(147447);
        }
      });
      AppMethodBeat.o(169508);
      return;
    }
    if (this.mDestroyed)
    {
      ae.w("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { this.ckP.getAppId(), this.ckP.kxv });
      AppMethodBeat.o(169508);
      return;
    }
    hj(true);
    parama = new e.a()
    {
      public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(169506);
        ae.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { bh.f(bh.this), bh.g(bh.this), paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        if (parama != null) {
          parama.a(paramAnonymousb, paramAnonymousBoolean);
        }
        bh.h(bh.this);
        AppMethodBeat.o(169506);
      }
    };
    boolean bool = this.ckP.jDa instanceof o;
    if ((e.b.c(getOrientationHandler().aYg())) && (bool) && (((com.tencent.luggage.sdk.config.a)this.ckP.ar(com.tencent.luggage.sdk.config.a.class)).cml))
    {
      ae.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.ckP.getAppId(), this.ckP.kxv });
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    if (this.ckP.getRuntime().aWP())
    {
      ae.m("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    ae.m("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.ckP.getAppId(), this.ckP.kxv, this.ckZ });
    String str = bu.bI(this.ckZ, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.ckP.getAppId(), this.ckP.kxv, this.ckZ });
        if (!this.ckP.jAe) {
          break label564;
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
    getOrientationHandler().a(e.b.mtE, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.mtF, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.mtD, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.mtH, parama);
    AppMethodBeat.o(169508);
    return;
    label564:
    ae.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", str);
    parama.a(null, false);
    AppMethodBeat.o(169508);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void cY(String paramString)
  {
    AppMethodBeat.i(147451);
    this.ckZ = paramString;
    a(null);
    AppMethodBeat.o(147451);
  }
  
  public final void onBackground()
  {
    this.cla = false;
    this.mjd.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(220846);
    if ((this.cla) && (!this.mDestroyed) && (this.mjg != null) && (this.mjg.orientation != paramConfiguration.orientation))
    {
      this.mjg = new Configuration(paramConfiguration);
      if (this.mjh == null) {
        this.mjh = new a((byte)0);
      }
      paramConfiguration = this.mjh;
      paramConfiguration.mji.hj(true);
      paramConfiguration.dO();
      Object localObject = (View)Objects.requireNonNull(paramConfiguration.mji.ckP.kfr);
      ((View)localObject).postDelayed(paramConfiguration.mjo, 100L);
      localObject = ((View)localObject).getViewTreeObserver();
      bh.a.2 local2 = new bh.a.2(paramConfiguration);
      paramConfiguration.afi = local2;
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
    }
    AppMethodBeat.o(220846);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(220845);
    this.cla = false;
    this.mDestroyed = true;
    if (this.mjh != null)
    {
      a locala = this.mjh;
      locala.dO();
      locala.afi = null;
      locala.mjo = null;
    }
    AppMethodBeat.o(220845);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147454);
    if (this.mjg == null) {
      this.mjg = new Configuration(((q)Objects.requireNonNull(this.ckP.mgv)).getResources().getConfiguration());
    }
    this.cla = true;
    if ((this.ckP.getFullscreenImpl() != null) && (this.ckP.getFullscreenImpl().bxz())) {
      this.ckP.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void DD()
        {
          AppMethodBeat.i(220840);
          bh.a(bh.this).getFullscreenImpl().b(this);
          if ((!bh.b(bh.this)) && (bh.i(bh.this))) {
            bh.this.a(null);
          }
          AppMethodBeat.o(220840);
        }
      });
    }
    for (;;)
    {
      com.tencent.luggage.sdk.b.a.b.e locale = this.mjd;
      if (locale.cot)
      {
        ae.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { locale.ckP.getAppId(), locale.ckP.kxv });
        locale.EF();
        locale.cot = false;
      }
      locale.foreground = true;
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
      this.ckP.K(new bh.2(this, paramString, paramMap));
      AppMethodBeat.o(147452);
      return;
    }
    com.tencent.luggage.sdk.b.a.b.e locale = this.mjd;
    if (paramMap != null) {
      locale.cow.putAll(paramMap);
    }
    cY(paramString);
    AppMethodBeat.o(147452);
  }
  
  final class a
  {
    ViewTreeObserver.OnGlobalLayoutListener afi;
    Runnable mjo;
    
    private a()
    {
      AppMethodBeat.i(220843);
      this.mjo = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220841);
          bh.h(bh.this);
          AppMethodBeat.o(220841);
        }
      };
      AppMethodBeat.o(220843);
    }
    
    final void dO()
    {
      AppMethodBeat.i(220844);
      ViewGroup localViewGroup = bh.a(bh.this).kfr;
      if (localViewGroup != null)
      {
        localViewGroup.removeCallbacks(this.mjo);
        if (this.afi != null) {
          localViewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this.afi);
        }
      }
      AppMethodBeat.o(220844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bh
 * JD-Core Version:    0.7.0.1
 */