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
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class bl
  implements com.tencent.mm.plugin.appbrand.page.a.b, com.tencent.mm.plugin.appbrand.page.a.d
{
  private final ac cwK;
  volatile String cwU;
  private boolean cwV;
  private boolean mDestroyed;
  private Configuration ntA;
  private a ntB;
  final com.tencent.luggage.sdk.b.a.b.e ntx;
  private boolean nty;
  private boolean ntz;
  
  bl(ac paramac)
  {
    AppMethodBeat.i(147449);
    this.cwV = false;
    this.mDestroyed = false;
    this.nty = false;
    this.ntz = false;
    this.cwK = paramac;
    this.ntx = new com.tencent.luggage.sdk.b.a.b.e(paramac);
    this.cwK.noq.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(147445);
        if (TextUtils.isEmpty(bl.a(bl.this).lBI))
        {
          AppMethodBeat.o(147445);
          return;
        }
        if (bl.b(bl.this)) {
          try
          {
            bl.a(bl.this).noq.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(147445);
            return;
          }
          catch (ConcurrentModificationException paramAnonymousView)
          {
            bl.a(bl.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(147444);
                bl.a(bl.this).noq.removeOnLayoutChangeListener(jdField_this);
                AppMethodBeat.o(147444);
              }
            });
            AppMethodBeat.o(147445);
            return;
          }
        }
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { bl.a(bl.this).getAppId(), bl.a(bl.this).lBI, Boolean.valueOf(bl.c(bl.this)) });
        if (bl.c(bl.this))
        {
          bl.d(bl.this);
          AppMethodBeat.o(147445);
          return;
        }
        bl.e(bl.this);
        AppMethodBeat.o(147445);
      }
    });
    AppMethodBeat.o(147449);
  }
  
  private void bSd()
  {
    AppMethodBeat.i(185221);
    if (this.cwK.NY() == null)
    {
      AppMethodBeat.o(185221);
      return;
    }
    if (this.mDestroyed)
    {
      AppMethodBeat.o(185221);
      return;
    }
    this.ntx.Oe();
    AppMethodBeat.o(185221);
  }
  
  private com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    AppMethodBeat.i(169507);
    com.tencent.mm.plugin.appbrand.platform.window.e locale = this.cwK.kEb.getOrientationHandler();
    AppMethodBeat.o(169507);
    return locale;
  }
  
  private void ik(boolean paramBoolean)
  {
    AppMethodBeat.i(185220);
    this.nty = paramBoolean;
    if ((!this.nty) && (this.ntz))
    {
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.cwK.getAppId(), this.cwK.lBI, Boolean.valueOf(this.mDestroyed) });
      bSd();
      this.ntz = false;
    }
    AppMethodBeat.o(185220);
  }
  
  public final boolean MY()
  {
    AppMethodBeat.i(147450);
    Object localObject;
    if (this.cwK.kEb == null)
    {
      localObject = null;
      if ((localObject != null) && (!(localObject instanceof com.tencent.mm.plugin.appbrand.platform.window.c.a.a))) {
        break label92;
      }
      Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.cwK.getAppId(), this.cwK.lBI });
    }
    label313:
    for (;;)
    {
      boolean bool = false;
      this.ntx.cAC = bool;
      AppMethodBeat.o(147450);
      return bool;
      localObject = this.cwK.kEb.getOrientationHandler();
      break;
      label92:
      e.b localb = ((com.tencent.mm.plugin.appbrand.platform.window.e)localObject).btm();
      localObject = e.b.aeE(this.cwU);
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.cwK.getAppId(), this.cwK.lBI, localb, localObject });
      if (e.b.nEm != localObject) {
        if ((!this.cwK.kEb.OD()) && (j.cDv.Pj()) && (ai.et(this.cwK.getContext())))
        {
          Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], huawei tabletLandscapeCompatible", new Object[] { this.cwK.getAppId(), this.cwK.lBI });
        }
        else if ((e.b.c(getOrientationHandler().btm())) && (((com.tencent.luggage.sdk.config.a)this.cwK.av(com.tencent.luggage.sdk.config.a.class)).cyg))
        {
          Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.cwK.getAppId(), this.cwK.lBI });
        }
        else
        {
          if (localObject == null) {
            localObject = e.b.nEl;
          }
          for (;;)
          {
            if (localb.b((e.b)localObject)) {
              break label313;
            }
            bool = true;
            break;
          }
        }
      }
    }
  }
  
  public final String MZ()
  {
    return this.cwU;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(169508);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.cwK.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147447);
          bl.this.a(parama);
          AppMethodBeat.o(147447);
        }
      });
      AppMethodBeat.o(169508);
      return;
    }
    if (this.mDestroyed)
    {
      Log.w("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { this.cwK.getAppId(), this.cwK.lBI });
      AppMethodBeat.o(169508);
      return;
    }
    ik(true);
    parama = new e.a()
    {
      public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(169506);
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { bl.f(bl.this), bl.g(bl.this), paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        if (parama != null) {
          parama.a(paramAnonymousb, paramAnonymousBoolean);
        }
        bl.h(bl.this);
        AppMethodBeat.o(169506);
      }
    };
    boolean bool = this.cwK.kEb instanceof o;
    if ((e.b.c(getOrientationHandler().btm())) && (bool) && (((com.tencent.luggage.sdk.config.a)this.cwK.av(com.tencent.luggage.sdk.config.a.class)).cyg))
    {
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.cwK.getAppId(), this.cwK.lBI });
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    if (this.cwK.getRuntime().brM())
    {
      Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.cwK.getAppId(), this.cwK.lBI, this.cwU });
    String str = Util.nullAs(this.cwU, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.cwK.getAppId(), this.cwK.lBI, this.cwU });
        if (!this.cwK.kAU) {
          break label569;
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
    getOrientationHandler().a(e.b.nEm, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.nEn, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.nEl, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.nEp, parama);
    AppMethodBeat.o(169508);
    return;
    label569:
    Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", str);
    parama.a(null, false);
    AppMethodBeat.o(169508);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void dx(String paramString)
  {
    AppMethodBeat.i(147451);
    this.cwU = paramString;
    a(null);
    AppMethodBeat.o(147451);
  }
  
  public final void onBackground()
  {
    this.cwV = false;
    this.ntx.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(229952);
    if ((this.cwV) && (!this.mDestroyed) && (this.ntA != null) && (this.ntA.orientation != paramConfiguration.orientation))
    {
      this.ntA = new Configuration(paramConfiguration);
      if (this.ntB == null) {
        this.ntB = new a((byte)0);
      }
      paramConfiguration = this.ntB;
      paramConfiguration.ntC.ik(true);
      paramConfiguration.dS();
      Object localObject = (View)Objects.requireNonNull(paramConfiguration.ntC.cwK.getContentView());
      ((View)localObject).postDelayed(paramConfiguration.ntI, 100L);
      localObject = ((View)localObject).getViewTreeObserver();
      bl.a.2 local2 = new bl.a.2(paramConfiguration);
      paramConfiguration.afv = local2;
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
    }
    AppMethodBeat.o(229952);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(229951);
    this.cwV = false;
    this.mDestroyed = true;
    if (this.ntB != null)
    {
      a locala = this.ntB;
      locala.dS();
      locala.afv = null;
      locala.ntI = null;
    }
    AppMethodBeat.o(229951);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147454);
    if (this.ntA == null) {
      this.ntA = new Configuration(((t)Objects.requireNonNull(this.cwK.nqU)).getResources().getConfiguration());
    }
    this.cwV = true;
    if ((this.cwK.getFullscreenImpl() != null) && (this.cwK.getFullscreenImpl().bTK())) {
      this.cwK.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void Na()
        {
          AppMethodBeat.i(229946);
          bl.a(bl.this).getFullscreenImpl().b(this);
          if ((!bl.b(bl.this)) && (bl.i(bl.this))) {
            bl.this.a(null);
          }
          AppMethodBeat.o(229946);
        }
      });
    }
    for (;;)
    {
      com.tencent.luggage.sdk.b.a.b.e locale = this.ntx;
      if (locale.cAy)
      {
        Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { locale.cwK.getAppId(), locale.cwK.lBI });
        locale.Of();
        locale.cAy = false;
      }
      locale.foreground = true;
      AppMethodBeat.o(147454);
      return;
      a(null);
    }
  }
  
  public final void r(final String paramString, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147452);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.cwK.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147446);
          bl.this.r(paramString, paramMap);
          AppMethodBeat.o(147446);
        }
      });
      AppMethodBeat.o(147452);
      return;
    }
    com.tencent.luggage.sdk.b.a.b.e locale = this.ntx;
    if (paramMap != null) {
      locale.cAB.putAll(paramMap);
    }
    dx(paramString);
    AppMethodBeat.o(147452);
  }
  
  final class a
  {
    ViewTreeObserver.OnGlobalLayoutListener afv;
    Runnable ntI;
    
    private a()
    {
      AppMethodBeat.i(229949);
      this.ntI = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(229947);
          bl.h(bl.this);
          AppMethodBeat.o(229947);
        }
      };
      AppMethodBeat.o(229949);
    }
    
    final void dS()
    {
      AppMethodBeat.i(229950);
      View localView = bl.a(bl.this).getContentView();
      if (localView != null)
      {
        localView.removeCallbacks(this.ntI);
        if (this.afv != null) {
          localView.getViewTreeObserver().removeOnGlobalLayoutListener(this.afv);
        }
      }
      AppMethodBeat.o(229950);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */