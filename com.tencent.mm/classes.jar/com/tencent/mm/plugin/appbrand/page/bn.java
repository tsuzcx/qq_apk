package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.luggage.sdk.config.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.s.a.e.a;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;

public final class bn
  implements com.tencent.mm.plugin.appbrand.page.b.b, com.tencent.mm.plugin.appbrand.page.b.d
{
  volatile String cdJ;
  private boolean cdK;
  private final aa cdz;
  final com.tencent.luggage.sdk.b.a.b.e lfo;
  private boolean lfp;
  private boolean lfq;
  private boolean mDestroyed;
  
  bn(aa paramaa)
  {
    AppMethodBeat.i(147449);
    this.cdK = false;
    this.mDestroyed = false;
    this.lfp = false;
    this.lfq = false;
    this.cdz = paramaa;
    this.lfo = new com.tencent.luggage.sdk.b.a.b.e(paramaa);
    this.cdz.kYy.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(147445);
        if (TextUtils.isEmpty(bn.a(bn.this).jzm))
        {
          AppMethodBeat.o(147445);
          return;
        }
        if (bn.b(bn.this)) {
          try
          {
            bn.a(bn.this).kYy.removeOnLayoutChangeListener(this);
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
                bn.a(bn.this).kYy.removeOnLayoutChangeListener(jdField_this);
                AppMethodBeat.o(147444);
              }
            });
            AppMethodBeat.o(147445);
            return;
          }
        }
        ad.i("Luggage.MPPageViewOrientationExtensionImpl", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { bn.a(bn.this).getAppId(), bn.a(bn.this).jzm, Boolean.valueOf(bn.c(bn.this)) });
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
  
  private void bkx()
  {
    AppMethodBeat.i(185221);
    if (this.cdz.Du() == null)
    {
      AppMethodBeat.o(185221);
      return;
    }
    if (this.mDestroyed)
    {
      AppMethodBeat.o(185221);
      return;
    }
    this.lfo.DA();
    AppMethodBeat.o(185221);
  }
  
  private void gG(boolean paramBoolean)
  {
    AppMethodBeat.i(185220);
    this.lfp = paramBoolean;
    if ((!this.lfp) && (this.lfq))
    {
      ad.i("Luggage.MPPageViewOrientationExtensionImpl", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.cdz.getAppId(), this.cdz.jzm, Boolean.valueOf(this.mDestroyed) });
      bkx();
      this.lfq = false;
    }
    AppMethodBeat.o(185220);
  }
  
  private com.tencent.mm.plugin.appbrand.s.a.e getOrientationHandler()
  {
    AppMethodBeat.i(169507);
    com.tencent.mm.plugin.appbrand.s.a.e locale = this.cdz.iGU.getOrientationHandler();
    AppMethodBeat.o(169507);
    return locale;
  }
  
  public final boolean Cv()
  {
    AppMethodBeat.i(147450);
    Object localObject;
    if (this.cdz.iGU == null)
    {
      localObject = null;
      if (localObject != null) {
        break label85;
      }
      ad.e("Luggage.MPPageViewOrientationExtensionImpl", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.cdz.getAppId(), this.cdz.jzm });
    }
    label85:
    label235:
    for (;;)
    {
      boolean bool = false;
      this.lfo.chk = bool;
      AppMethodBeat.o(147450);
      return bool;
      localObject = this.cdz.iGU.getOrientationHandler();
      break;
      e.b localb = ((com.tencent.mm.plugin.appbrand.s.a.e)localObject).aNL();
      localObject = e.b.Mq(this.cdJ);
      ad.i("Luggage.MPPageViewOrientationExtensionImpl", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.cdz.getAppId(), this.cdz.jzm, localb, localObject });
      if (e.b.lmP != localObject) {
        if ((e.b.c(getOrientationHandler().aNL())) && (((a)this.cdz.ar(a.class)).ceV))
        {
          ad.i("Luggage.MPPageViewOrientationExtensionImpl", "willResizeByOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.cdz.getAppId(), this.cdz.jzm });
        }
        else
        {
          if (localObject == null) {
            localObject = e.b.lmO;
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
  
  public final String Cw()
  {
    return this.cdJ;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(169508);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.cdz.L(new Runnable()
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
      ad.w("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { this.cdz.getAppId(), this.cdz.jzm });
      AppMethodBeat.o(169508);
      return;
    }
    gG(true);
    parama = new e.a()
    {
      public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(169506);
        ad.i("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { bn.f(bn.this), bn.g(bn.this), paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        if (parama != null) {
          parama.a(paramAnonymousb, paramAnonymousBoolean);
        }
        bn.h(bn.this);
        AppMethodBeat.o(169506);
      }
    };
    boolean bool = this.cdz.iGU instanceof o;
    if ((e.b.c(getOrientationHandler().aNL())) && (bool) && (((a)this.cdz.ar(a.class)).ceV))
    {
      ad.i("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.cdz.getAppId(), this.cdz.jzm });
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    if (this.cdz.getRuntime().aMo())
    {
      ad.m("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    ad.m("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.cdz.getAppId(), this.cdz.jzm, this.cdJ });
    String str = bt.by(this.cdJ, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.cdz.getAppId(), this.cdz.jzm, this.cdJ });
        if (!this.cdz.iDV) {
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
    getOrientationHandler().a(e.b.lmP, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.lmQ, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.lmO, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.lmS, parama);
    AppMethodBeat.o(169508);
    return;
    label564:
    ad.e("Luggage.MPPageViewOrientationExtensionImpl", str);
    parama.a(null, false);
    AppMethodBeat.o(169508);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void cm(String paramString)
  {
    AppMethodBeat.i(147451);
    this.cdJ = paramString;
    a(null);
    AppMethodBeat.o(147451);
  }
  
  public final void o(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147452);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.cdz.L(new bn.2(this, paramString, paramMap));
      AppMethodBeat.o(147452);
      return;
    }
    com.tencent.luggage.sdk.b.a.b.e locale = this.lfo;
    if (paramMap != null) {
      locale.chj.putAll(paramMap);
    }
    cm(paramString);
    AppMethodBeat.o(147452);
  }
  
  public final void onBackground()
  {
    this.cdK = false;
    this.lfo.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy()
  {
    this.cdK = false;
    this.mDestroyed = true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147454);
    this.cdK = true;
    if ((this.cdz.getFullscreenImpl() != null) && (this.cdz.getFullscreenImpl().blI())) {
      this.cdz.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.s.a.b()
      {
        public final void Cx()
        {
          AppMethodBeat.i(186898);
          bn.a(bn.this).getFullscreenImpl().b(this);
          if ((!bn.b(bn.this)) && (bn.i(bn.this))) {
            bn.this.a(null);
          }
          AppMethodBeat.o(186898);
        }
      });
    }
    for (;;)
    {
      com.tencent.luggage.sdk.b.a.b.e locale = this.lfo;
      if (locale.chg)
      {
        ad.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { locale.cdz.getAppId(), locale.cdz.jzm });
        locale.DB();
        locale.chg = false;
      }
      locale.foreground = true;
      AppMethodBeat.o(147454);
      return;
      a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bn
 * JD-Core Version:    0.7.0.1
 */