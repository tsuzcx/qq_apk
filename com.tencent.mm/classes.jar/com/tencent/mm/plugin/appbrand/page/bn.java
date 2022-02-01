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
import com.tencent.luggage.k.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.utils.x;
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
  private boolean cvA;
  private final ad cvo;
  volatile String cvz;
  private boolean mDestroyed;
  final com.tencent.luggage.sdk.b.a.b.e qvs;
  private boolean qvt;
  private boolean qvu;
  private Configuration qvv;
  private a qvw;
  
  bn(ad paramad)
  {
    AppMethodBeat.i(147449);
    this.cvA = false;
    this.mDestroyed = false;
    this.qvt = false;
    this.qvu = false;
    this.cvo = paramad;
    this.qvs = new com.tencent.luggage.sdk.b.a.b.e(paramad);
    this.cvo.qpZ.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(147445);
        if (TextUtils.isEmpty(bn.a(bn.this).oxe))
        {
          AppMethodBeat.o(147445);
          return;
        }
        if (bn.b(bn.this)) {
          try
          {
            bn.a(bn.this).qpZ.removeOnLayoutChangeListener(this);
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
                bn.a(bn.this).qpZ.removeOnLayoutChangeListener(jdField_this);
                AppMethodBeat.o(147444);
              }
            });
            AppMethodBeat.o(147445);
            return;
          }
        }
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { bn.a(bn.this).getAppId(), bn.a(bn.this).oxe, Boolean.valueOf(bn.c(bn.this)) });
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
  
  private void cfb()
  {
    AppMethodBeat.i(185221);
    if (this.cvo.QW() == null)
    {
      AppMethodBeat.o(185221);
      return;
    }
    if (this.mDestroyed)
    {
      AppMethodBeat.o(185221);
      return;
    }
    this.qvs.Rc();
    AppMethodBeat.o(185221);
  }
  
  private boolean cfc()
  {
    AppMethodBeat.i(242594);
    if ((e.b.c(getOrientationHandler().cgS())) && (((com.tencent.luggage.sdk.config.a)this.cvo.au(com.tencent.luggage.sdk.config.a.class)).cwJ))
    {
      AppMethodBeat.o(242594);
      return true;
    }
    AppMethodBeat.o(242594);
    return false;
  }
  
  private boolean cfd()
  {
    AppMethodBeat.i(242595);
    if (this.cvo.nxr.RZ())
    {
      AppMethodBeat.o(242595);
      return false;
    }
    if ((j.cEc.SJ()) && (x.es(this.cvo.getContext())))
    {
      AppMethodBeat.o(242595);
      return true;
    }
    if ((HuaweiKt.hasHuaweiMagicWindowFeature()) && (x.es(this.cvo.getContext())) && (!j.cEc.SJ()))
    {
      AppMethodBeat.o(242595);
      return true;
    }
    AppMethodBeat.o(242595);
    return false;
  }
  
  private com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    AppMethodBeat.i(169507);
    com.tencent.mm.plugin.appbrand.platform.window.e locale = this.cvo.nxr.getOrientationHandler();
    AppMethodBeat.o(169507);
    return locale;
  }
  
  private void jh(boolean paramBoolean)
  {
    AppMethodBeat.i(185220);
    this.qvt = paramBoolean;
    if ((!this.qvt) && (this.qvu))
    {
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.cvo.getAppId(), this.cvo.oxe, Boolean.valueOf(this.mDestroyed) });
      cfb();
      this.qvu = false;
    }
    AppMethodBeat.o(185220);
  }
  
  public final boolean PQ()
  {
    AppMethodBeat.i(147450);
    Object localObject;
    if (this.cvo.nxr == null)
    {
      localObject = null;
      if ((localObject != null) && (!(localObject instanceof com.tencent.mm.plugin.appbrand.platform.window.c.a.a))) {
        break label92;
      }
      Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.cvo.getAppId(), this.cvo.oxe });
    }
    label59:
    for (boolean bool = false;; bool = true)
    {
      this.qvs.czI = bool;
      AppMethodBeat.o(147450);
      return bool;
      localObject = this.cvo.nxr.getOrientationHandler();
      break;
      label92:
      e.b localb2 = ((com.tencent.mm.plugin.appbrand.platform.window.e)localObject).cgS();
      e.b localb1 = e.b.amy(this.cvz);
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.cvo.getAppId(), this.cvo.oxe, localb2, localb1 });
      if (e.b.qGw == localb1) {
        break label59;
      }
      if (((this.cvo.nxr instanceof o)) && ((cfd()) || (cfc())))
      {
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], fixed orientation device", new Object[] { this.cvo.getAppId(), this.cvo.oxe });
        break label59;
      }
      localObject = localb1;
      if (localb1 == null) {
        localObject = e.b.qGv;
      }
      if (localb2.b((e.b)localObject)) {
        break label59;
      }
    }
  }
  
  public final String PR()
  {
    return this.cvz;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(169508);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.cvo.P(new Runnable()
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
      Log.w("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { this.cvo.getAppId(), this.cvo.oxe });
      AppMethodBeat.o(169508);
      return;
    }
    jh(true);
    parama = new e.a()
    {
      public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(169506);
        Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { bn.f(bn.this), bn.g(bn.this), paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        if (parama != null) {
          parama.a(paramAnonymousb, paramAnonymousBoolean);
        }
        bn.h(bn.this);
        AppMethodBeat.o(169506);
      }
    };
    boolean bool = this.cvo.nxr instanceof o;
    if ((e.b.c(getOrientationHandler().cgS())) && (bool) && ((cfc()) || (cfd())))
    {
      Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.cvo.getAppId(), this.cvo.oxe });
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    if (this.cvo.getRuntime().bCB())
    {
      Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.cvo.getAppId(), this.cvo.oxe, this.cvz });
    String str = Util.nullAs(this.cvz, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.cvo.getAppId(), this.cvo.oxe, this.cvz });
        if (!this.cvo.nug) {
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
    getOrientationHandler().a(e.b.qGw, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.qGx, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.qGv, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.qGz, parama);
    AppMethodBeat.o(169508);
    return;
    label565:
    Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", str);
    parama.a(null, false);
    AppMethodBeat.o(169508);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void dQ(String paramString)
  {
    AppMethodBeat.i(147451);
    this.cvz = paramString;
    a(null);
    AppMethodBeat.o(147451);
  }
  
  public final void onBackground()
  {
    this.cvA = false;
    this.qvs.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(242598);
    if ((this.cvA) && (!this.mDestroyed) && (this.qvv != null) && (this.qvv.orientation != paramConfiguration.orientation))
    {
      this.qvv = new Configuration(paramConfiguration);
      if (this.qvw == null) {
        this.qvw = new a((byte)0);
      }
      paramConfiguration = this.qvw;
      paramConfiguration.qvx.jh(true);
      paramConfiguration.nx();
      Object localObject = (View)Objects.requireNonNull(paramConfiguration.qvx.cvo.getContentView());
      ((View)localObject).postDelayed(paramConfiguration.qvD, 100L);
      localObject = ((View)localObject).getViewTreeObserver();
      bn.a.2 local2 = new bn.a.2(paramConfiguration);
      paramConfiguration.lE = local2;
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
    }
    AppMethodBeat.o(242598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242597);
    this.cvA = false;
    this.mDestroyed = true;
    if (this.qvw != null)
    {
      a locala = this.qvw;
      locala.nx();
      locala.lE = null;
      locala.qvD = null;
    }
    AppMethodBeat.o(242597);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147454);
    if (this.qvv == null) {
      this.qvv = new Configuration(((u)Objects.requireNonNull(this.cvo.qsG)).getResources().getConfiguration());
    }
    this.cvA = true;
    if ((this.cvo.getFullscreenImpl() != null) && (this.cvo.getFullscreenImpl().cgP())) {
      this.cvo.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void PS()
        {
          AppMethodBeat.i(249904);
          bn.a(bn.this).getFullscreenImpl().b(this);
          if ((!bn.b(bn.this)) && (bn.i(bn.this))) {
            bn.this.a(null);
          }
          AppMethodBeat.o(249904);
        }
      });
    }
    for (;;)
    {
      com.tencent.luggage.sdk.b.a.b.e locale = this.qvs;
      if (locale.czE)
      {
        Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { locale.cvo.getAppId(), locale.cvo.oxe });
        locale.Rd();
        locale.czE = false;
      }
      locale.foreground = true;
      AppMethodBeat.o(147454);
      return;
      a(null);
    }
  }
  
  public final void q(final String paramString, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147452);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.cvo.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147446);
          bn.this.q(paramString, paramMap);
          AppMethodBeat.o(147446);
        }
      });
      AppMethodBeat.o(147452);
      return;
    }
    com.tencent.luggage.sdk.b.a.b.e locale = this.qvs;
    if (paramMap != null) {
      locale.czH.putAll(paramMap);
    }
    dQ(paramString);
    AppMethodBeat.o(147452);
  }
  
  final class a
  {
    ViewTreeObserver.OnGlobalLayoutListener lE;
    Runnable qvD;
    
    private a()
    {
      AppMethodBeat.i(244790);
      this.qvD = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(247172);
          bn.h(bn.this);
          AppMethodBeat.o(247172);
        }
      };
      AppMethodBeat.o(244790);
    }
    
    final void nx()
    {
      AppMethodBeat.i(244792);
      View localView = bn.a(bn.this).getContentView();
      if (localView != null)
      {
        localView.removeCallbacks(this.qvD);
        if (this.lE != null) {
          localView.getViewTreeObserver().removeOnGlobalLayoutListener(this.lE);
        }
      }
      AppMethodBeat.o(244792);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bn
 * JD-Core Version:    0.7.0.1
 */