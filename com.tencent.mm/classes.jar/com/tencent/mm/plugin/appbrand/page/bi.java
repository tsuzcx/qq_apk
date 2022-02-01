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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class bi
  implements com.tencent.mm.plugin.appbrand.page.b.b, com.tencent.mm.plugin.appbrand.page.b.d
{
  volatile String caG;
  private boolean caH;
  private final aa caw;
  final com.tencent.luggage.sdk.b.a.b.e lFe;
  private boolean lFf;
  private boolean lFg;
  private Configuration lFh;
  private a lFi;
  private boolean mDestroyed;
  
  bi(aa paramaa)
  {
    AppMethodBeat.i(147449);
    this.caH = false;
    this.mDestroyed = false;
    this.lFf = false;
    this.lFg = false;
    this.caw = paramaa;
    this.lFe = new com.tencent.luggage.sdk.b.a.b.e(paramaa);
    this.caw.lAi.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(147445);
        if (TextUtils.isEmpty(bi.a(bi.this).jZJ))
        {
          AppMethodBeat.o(147445);
          return;
        }
        if (bi.b(bi.this)) {
          try
          {
            bi.a(bi.this).lAi.removeOnLayoutChangeListener(this);
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
                bi.a(bi.this).lAi.removeOnLayoutChangeListener(jdField_this);
                AppMethodBeat.o(147444);
              }
            });
            AppMethodBeat.o(147445);
            return;
          }
        }
        ac.i("Luggage.MPPageViewOrientationExtensionImpl", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", new Object[] { bi.a(bi.this).getAppId(), bi.a(bi.this).jZJ, Boolean.valueOf(bi.c(bi.this)) });
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
  
  private void brm()
  {
    AppMethodBeat.i(185221);
    if (this.caw.CX() == null)
    {
      AppMethodBeat.o(185221);
      return;
    }
    if (this.mDestroyed)
    {
      AppMethodBeat.o(185221);
      return;
    }
    this.lFe.Dd();
    AppMethodBeat.o(185221);
  }
  
  private com.tencent.mm.plugin.appbrand.r.a.e getOrientationHandler()
  {
    AppMethodBeat.i(169507);
    com.tencent.mm.plugin.appbrand.r.a.e locale = this.caw.jgX.getOrientationHandler();
    AppMethodBeat.o(169507);
    return locale;
  }
  
  private void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(185220);
    this.lFf = paramBoolean;
    if ((!this.lFf) && (this.lFg))
    {
      ac.i("Luggage.MPPageViewOrientationExtensionImpl", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.caw.getAppId(), this.caw.jZJ, Boolean.valueOf(this.mDestroyed) });
      brm();
      this.lFg = false;
    }
    AppMethodBeat.o(185220);
  }
  
  public final boolean BZ()
  {
    AppMethodBeat.i(147450);
    Object localObject;
    if (this.caw.jgX == null)
    {
      localObject = null;
      if (localObject != null) {
        break label85;
      }
      ac.e("Luggage.MPPageViewOrientationExtensionImpl", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.caw.getAppId(), this.caw.jZJ });
    }
    label85:
    label235:
    for (;;)
    {
      boolean bool = false;
      this.lFe.cef = bool;
      AppMethodBeat.o(147450);
      return bool;
      localObject = this.caw.jgX.getOrientationHandler();
      break;
      e.b localb = ((com.tencent.mm.plugin.appbrand.r.a.e)localObject).aUB();
      localObject = e.b.Qz(this.caG);
      ac.i("Luggage.MPPageViewOrientationExtensionImpl", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.caw.getAppId(), this.caw.jZJ, localb, localObject });
      if (e.b.lOR != localObject) {
        if ((e.b.c(getOrientationHandler().aUB())) && (((a)this.caw.ar(a.class)).cbS))
        {
          ac.i("Luggage.MPPageViewOrientationExtensionImpl", "willResizeByOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.caw.getAppId(), this.caw.jZJ });
        }
        else
        {
          if (localObject == null) {
            localObject = e.b.lOQ;
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
  
  public final String Ca()
  {
    return this.caG;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(169508);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.caw.N(new Runnable()
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
      ac.w("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { this.caw.getAppId(), this.caw.jZJ });
      AppMethodBeat.o(169508);
      return;
    }
    ha(true);
    parama = new e.a()
    {
      public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(169506);
        ac.i("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { bi.f(bi.this), bi.g(bi.this), paramAnonymousb, Boolean.valueOf(paramAnonymousBoolean) });
        if (parama != null) {
          parama.a(paramAnonymousb, paramAnonymousBoolean);
        }
        bi.h(bi.this);
        AppMethodBeat.o(169506);
      }
    };
    boolean bool = this.caw.jgX instanceof o;
    if ((e.b.c(getOrientationHandler().aUB())) && (bool) && (((a)this.caw.ar(a.class)).cbS))
    {
      ac.i("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.caw.getAppId(), this.caw.jZJ });
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    if (this.caw.getRuntime().aTe())
    {
      ac.m("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.a(null, false);
      AppMethodBeat.o(169508);
      return;
    }
    ac.m("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.caw.getAppId(), this.caw.jZJ, this.caG });
    String str = bs.bG(this.caG, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.caw.getAppId(), this.caw.jZJ, this.caG });
        if (!this.caw.jdX) {
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
    getOrientationHandler().a(e.b.lOR, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.lOS, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.lOQ, parama);
    AppMethodBeat.o(169508);
    return;
    getOrientationHandler().a(e.b.lOU, parama);
    AppMethodBeat.o(169508);
    return;
    label564:
    ac.e("Luggage.MPPageViewOrientationExtensionImpl", str);
    parama.a(null, false);
    AppMethodBeat.o(169508);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void cc(String paramString)
  {
    AppMethodBeat.i(147451);
    this.caG = paramString;
    a(null);
    AppMethodBeat.o(147451);
  }
  
  public final void o(final String paramString, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(147452);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.caw.N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147446);
          bi.this.o(paramString, paramMap);
          AppMethodBeat.o(147446);
        }
      });
      AppMethodBeat.o(147452);
      return;
    }
    com.tencent.luggage.sdk.b.a.b.e locale = this.lFe;
    if (paramMap != null) {
      locale.cee.putAll(paramMap);
    }
    cc(paramString);
    AppMethodBeat.o(147452);
  }
  
  public final void onBackground()
  {
    this.caH = false;
    this.lFe.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(206182);
    if ((this.caH) && (!this.mDestroyed) && (this.lFh != null) && (this.lFh.orientation != paramConfiguration.orientation))
    {
      this.lFh = new Configuration(paramConfiguration);
      if (this.lFi == null) {
        this.lFi = new a((byte)0);
      }
      paramConfiguration = this.lFi;
      paramConfiguration.lFj.ha(true);
      paramConfiguration.dz();
      Object localObject = (View)Objects.requireNonNull(paramConfiguration.lFj.caw.jHO);
      ((View)localObject).postDelayed(paramConfiguration.lFp, 100L);
      localObject = ((View)localObject).getViewTreeObserver();
      bi.a.2 local2 = new bi.a.2(paramConfiguration);
      paramConfiguration.adr = local2;
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
    }
    AppMethodBeat.o(206182);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206181);
    this.caH = false;
    this.mDestroyed = true;
    if (this.lFi != null)
    {
      a locala = this.lFi;
      locala.dz();
      locala.adr = null;
      locala.lFp = null;
    }
    AppMethodBeat.o(206181);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(147454);
    if (this.lFh == null) {
      this.lFh = new Configuration(((r)Objects.requireNonNull(this.caw.lCC)).getResources().getConfiguration());
    }
    this.caH = true;
    if ((this.caw.getFullscreenImpl() != null) && (this.caw.getFullscreenImpl().bsE())) {
      this.caw.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void Cb()
        {
          AppMethodBeat.i(206176);
          bi.a(bi.this).getFullscreenImpl().b(this);
          if ((!bi.b(bi.this)) && (bi.i(bi.this))) {
            bi.this.a(null);
          }
          AppMethodBeat.o(206176);
        }
      });
    }
    for (;;)
    {
      com.tencent.luggage.sdk.b.a.b.e locale = this.lFe;
      if (locale.ceb)
      {
        ac.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { locale.caw.getAppId(), locale.caw.jZJ });
        locale.De();
        locale.ceb = false;
      }
      locale.foreground = true;
      AppMethodBeat.o(147454);
      return;
      a(null);
    }
  }
  
  final class a
  {
    ViewTreeObserver.OnGlobalLayoutListener adr;
    Runnable lFp;
    
    private a()
    {
      AppMethodBeat.i(206179);
      this.lFp = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206177);
          bi.h(bi.this);
          AppMethodBeat.o(206177);
        }
      };
      AppMethodBeat.o(206179);
    }
    
    final void dz()
    {
      AppMethodBeat.i(206180);
      ViewGroup localViewGroup = bi.a(bi.this).jHO;
      if (localViewGroup != null)
      {
        localViewGroup.removeCallbacks(this.lFp);
        if (this.adr != null) {
          localViewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this.adr);
        }
      }
      AppMethodBeat.o(206180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bi
 * JD-Core Version:    0.7.0.1
 */