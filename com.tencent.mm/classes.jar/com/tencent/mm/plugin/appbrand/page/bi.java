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
import com.tencent.luggage.sdk.config.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class bi
  implements com.tencent.mm.plugin.appbrand.page.b.b, com.tencent.mm.plugin.appbrand.page.b.d
{
  private final aa ckN;
  volatile String ckX;
  private boolean ckY;
  private boolean mDestroyed;
  final com.tencent.luggage.sdk.b.a.b.e meI;
  private boolean meJ;
  private boolean meK;
  private Configuration meL;
  private a meM;
  
  bi(aa paramaa)
  {
    AppMethodBeat.i(147449);
    this.ckY = false;
    this.mDestroyed = false;
    this.meJ = false;
    this.meK = false;
    this.ckN = paramaa;
    this.meI = new com.tencent.luggage.sdk.b.a.b.e(paramaa);
    this.ckN.lZG.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(147445);
        if (TextUtils.isEmpty(bi.a(bi.this).kuf))
        {
          AppMethodBeat.o(147445);
          return;
        }
        if (bi.b(bi.this)) {
          try
          {
            bi.a(bi.this).lZG.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(147445);
            return;
          }
          catch (ConcurrentModificationException paramAnonymousView)
          {
            bi.a(bi.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147444);
                bi.a(bi.this).lZG.removeOnLayoutChangeListener(jdField_this);
                AppMethodBeat.o(147444);
              }
            });
            AppMethodBeat.o(147445);
            return;
          }
        }
        ad.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { bi.a(bi.this).getAppId(), bi.a(bi.this).kuf, Boolean.valueOf(bi.c(bi.this)) });
        if (bi.c(bi.this))
        {
          bi.d(bi.this);
          AppMethodBeat.o(147445);
          return;
        }
        bi.e(bi.this);
        AppMethodBeat.o(147445);
      }
    });
    AppMethodBeat.o(147449);
  }
  
  private void bvn()
  {
    AppMethodBeat.i(185221);
    if (this.ckN.Ew() == null)
    {
      AppMethodBeat.o(185221);
      return;
    }
    if (this.mDestroyed)
    {
      AppMethodBeat.o(185221);
      return;
    }
    this.meI.EC();
    AppMethodBeat.o(185221);
  }
  
  private com.tencent.mm.plugin.appbrand.r.a.e getOrientationHandler()
  {
    AppMethodBeat.i(169507);
    com.tencent.mm.plugin.appbrand.r.a.e locale = this.ckN.jzX.getOrientationHandler();
    AppMethodBeat.o(169507);
    return locale;
  }
  
  private void hi(boolean paramBoolean)
  {
    AppMethodBeat.i(185220);
    this.meJ = paramBoolean;
    if ((!this.meJ) && (this.meK))
    {
      ad.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.ckN.getAppId(), this.ckN.kuf, Boolean.valueOf(this.mDestroyed) });
      bvn();
      this.meK = false;
    }
    AppMethodBeat.o(185220);
  }
  
  public final boolean Dy()
  {
    AppMethodBeat.i(147450);
    Object localObject;
    if (this.ckN.jzX == null)
    {
      localObject = null;
      if (localObject != null) {
        break label85;
      }
      ad.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.ckN.getAppId(), this.ckN.kuf });
    }
    label85:
    label235:
    for (;;)
    {
      boolean bool = false;
      this.meI.cov = bool;
      AppMethodBeat.o(147450);
      return bool;
      localObject = this.ckN.jzX.getOrientationHandler();
      break;
      e.b localb = ((com.tencent.mm.plugin.appbrand.r.a.e)localObject).aXN();
      localObject = e.b.Uf(this.ckX);
      ad.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.ckN.getAppId(), this.ckN.kuf, localb, localObject });
      if (e.b.moH != localObject) {
        if ((e.b.c(getOrientationHandler().aXN())) && (((a)this.ckN.ar(a.class)).cmj))
        {
          ad.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.ckN.getAppId(), this.ckN.kuf });
        }
        else
        {
          if (localObject == null) {
            localObject = e.b.moG;
          }
          for (;;)
          {
            if (localb.b((e.b)localObject)) {
              break label235;
            }
            bool = true;
            break;
          }
        }
      }
    }
  }
  
  public final String Dz()
  {
    return this.ckX;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(169508);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.ckN.M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147447);
          bi.this.a(parama);
          AppMethodBeat.o(147447);
        }
      });
      AppMethodBeat.o(169508);
      return;
    }
    if (this.mDestroyed)
    {
      ad.w("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { this.ckN.getAppId(), this.ckN.kuf });
      AppMethodBeat.o(169508);
      return;
    }
    hi(true);
    parama = new e.a()
    {
      public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(169506);
        ad.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { bi.f(bi.this), bi.g(bi.this), paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        if (parama != null) {
          parama.a(paramAnonymousb, paramAnonymousBoolean);
        }
        bi.h(bi.this);
        AppMethodBeat.o(169506);
      }
    };
    boolean bool = this.ckN.jzX instanceof o;
    if ((e.b.c(getOrientationHandler().aXN())) && (bool) && (((a)this.ckN.ar(a.class)).cmj))
    {
      ad.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.ckN.getAppId(), this.ckN.kuf });
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    if (this.ckN.getRuntime().aWo())
    {
      ad.m("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    ad.m("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.ckN.getAppId(), this.ckN.kuf, this.ckX });
    String str = bt.bI(this.ckX, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.ckN.getAppId(), this.ckN.kuf, this.ckX });
        if (!this.ckN.jxf) {
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
    getOrientationHandler().a(e.b.moH, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.moI, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.moG, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.moK, parama);
    AppMethodBeat.o(169508);
    return;
    label564:
    ad.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", str);
    parama.a(null, false);
    AppMethodBeat.o(169508);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void cW(String paramString)
  {
    AppMethodBeat.i(147451);
    this.ckX = paramString;
    a(null);
    AppMethodBeat.o(147451);
  }
  
  public final void onBackground()
  {
    this.ckY = false;
    this.meI.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(192273);
    if ((this.ckY) && (!this.mDestroyed) && (this.meL != null) && (this.meL.orientation != paramConfiguration.orientation))
    {
      this.meL = new Configuration(paramConfiguration);
      if (this.meM == null) {
        this.meM = new a((byte)0);
      }
      paramConfiguration = this.meM;
      paramConfiguration.meN.hi(true);
      paramConfiguration.dO();
      Object localObject = (View)Objects.requireNonNull(paramConfiguration.meN.ckN.kca);
      ((View)localObject).postDelayed(paramConfiguration.meT, 100L);
      localObject = ((View)localObject).getViewTreeObserver();
      bi.a.2 local2 = new bi.a.2(paramConfiguration);
      paramConfiguration.afi = local2;
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
    }
    AppMethodBeat.o(192273);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(192272);
    this.ckY = false;
    this.mDestroyed = true;
    if (this.meM != null)
    {
      a locala = this.meM;
      locala.dO();
      locala.afi = null;
      locala.meT = null;
    }
    AppMethodBeat.o(192272);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147454);
    if (this.meL == null) {
      this.meL = new Configuration(((r)Objects.requireNonNull(this.ckN.mcd)).getResources().getConfiguration());
    }
    this.ckY = true;
    if ((this.ckN.getFullscreenImpl() != null) && (this.ckN.getFullscreenImpl().bwI())) {
      this.ckN.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void DA()
        {
          AppMethodBeat.i(192267);
          bi.a(bi.this).getFullscreenImpl().b(this);
          if ((!bi.b(bi.this)) && (bi.i(bi.this))) {
            bi.this.a(null);
          }
          AppMethodBeat.o(192267);
        }
      });
    }
    for (;;)
    {
      com.tencent.luggage.sdk.b.a.b.e locale = this.meI;
      if (locale.cor)
      {
        ad.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { locale.ckN.getAppId(), locale.ckN.kuf });
        locale.ED();
        locale.cor = false;
      }
      locale.foreground = true;
      AppMethodBeat.o(147454);
      return;
      a(null);
    }
  }
  
  public final void q(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147452);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.ckN.M(new bi.2(this, paramString, paramMap));
      AppMethodBeat.o(147452);
      return;
    }
    com.tencent.luggage.sdk.b.a.b.e locale = this.meI;
    if (paramMap != null) {
      locale.cou.putAll(paramMap);
    }
    cW(paramString);
    AppMethodBeat.o(147452);
  }
  
  final class a
  {
    ViewTreeObserver.OnGlobalLayoutListener afi;
    Runnable meT;
    
    private a()
    {
      AppMethodBeat.i(192270);
      this.meT = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192268);
          bi.h(bi.this);
          AppMethodBeat.o(192268);
        }
      };
      AppMethodBeat.o(192270);
    }
    
    final void dO()
    {
      AppMethodBeat.i(192271);
      ViewGroup localViewGroup = bi.a(bi.this).kca;
      if (localViewGroup != null)
      {
        localViewGroup.removeCallbacks(this.meT);
        if (this.afi != null) {
          localViewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this.afi);
        }
      }
      AppMethodBeat.o(192271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bi
 * JD-Core Version:    0.7.0.1
 */