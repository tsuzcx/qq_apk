package com.tencent.luggage.sdk.b.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.l.m;
import com.tencent.luggage.m.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.i.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.t.aa;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bp;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.i;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class c
  extends ad
  implements d
{
  private final Runnable eqD;
  private MMHandler eqE;
  
  public c()
  {
    super(bp.class);
    AppMethodBeat.i(146724);
    this.eqD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.arc();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146724);
  }
  
  public c(Class<? extends af> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(146723);
    this.eqD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.arc();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146723);
  }
  
  private void are()
  {
    AppMethodBeat.i(146733);
    Object localObject = this.tuD;
    if (localObject == null)
    {
      Log.i("MicroMsg.AppBrandPageViewLU", "hideScreenshotCover, pageArea is null");
      AppMethodBeat.o(146733);
      return;
    }
    FrameLayout localFrameLayout = (FrameLayout)((FrameLayout)localObject).findViewById(a.d.app_brand_page_view_share_screenshot_cover);
    if (localFrameLayout != null)
    {
      localFrameLayout.setVisibility(8);
      if (!(localFrameLayout.getBackground() instanceof BitmapDrawable)) {
        break label88;
      }
    }
    label88:
    for (localObject = ((BitmapDrawable)localFrameLayout.getBackground()).getBitmap();; localObject = null)
    {
      localFrameLayout.setBackground(null);
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      AppMethodBeat.o(146733);
      return;
    }
  }
  
  private MMHandler arh()
  {
    AppMethodBeat.i(220261);
    if (this.eqE == null) {
      this.eqE = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.eqE;
    AppMethodBeat.o(220261);
    return localMMHandler;
  }
  
  public final void a(bc parambc, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(220284);
    if ((parambc instanceof c.b)) {
      Log.i("MicroMsg.AppBrandPageViewLU", "publish onPageNotFound, appId:%s, webviewId:%d, data:%s", new Object[] { getAppId(), Integer.valueOf(getComponentId()), parambc.getData() });
    }
    super.a(parambc, paramArrayOfInt);
    AppMethodBeat.o(220284);
  }
  
  public com.tencent.luggage.sdk.e.d aqZ()
  {
    AppMethodBeat.i(146725);
    com.tencent.luggage.sdk.e.d locald = (com.tencent.luggage.sdk.e.d)super.getRuntime();
    AppMethodBeat.o(146725);
    return locald;
  }
  
  public com.tencent.luggage.sdk.b.a.d.d ara()
  {
    AppMethodBeat.i(146726);
    com.tencent.luggage.sdk.b.a.d.d locald = (com.tencent.luggage.sdk.b.a.d.d)super.ari();
    AppMethodBeat.o(146726);
    return locald;
  }
  
  public void arb()
  {
    AppMethodBeat.i(146728);
    super.arb();
    cM(false);
    if (this.eqE != null) {
      this.eqE.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(146728);
  }
  
  public final void arc()
  {
    AppMethodBeat.i(146731);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), cgR() });
      AppMethodBeat.o(146731);
      return;
    }
    Log.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), cgR() });
    cER();
    i locali = new i(getContext(), aqZ());
    this.tuD.addView(locali);
    AppMethodBeat.o(146731);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> ard()
  {
    AppMethodBeat.i(146732);
    com.tencent.mm.vending.g.c localc = g.jJU().f(new a() {});
    AppMethodBeat.o(146732);
    return localc;
  }
  
  public final void arf()
  {
    AppMethodBeat.i(220296);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146721);
        if (c.this.tti == null)
        {
          AppMethodBeat.o(146721);
          return;
        }
        if (c.this.tti.getWebScrollY() == 0)
        {
          AppMethodBeat.o(146721);
          return;
        }
        c.b(c.this);
        c.this.tti.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(146721);
      }
    });
    AppMethodBeat.o(220296);
  }
  
  public void arg()
  {
    AppMethodBeat.i(146736);
    if (aqZ().getPageContainer().getPageCount() == 1)
    {
      com.tencent.mm.plugin.appbrand.page.c localc = this.txg;
      if ((localc.trn) || (!localc.ttC)) {}
      for (int i = 1; i != 0; i = 0)
      {
        cEC().setNavHidden(true);
        AppMethodBeat.o(146736);
        return;
      }
    }
    cEC().setNavHidden(false);
    AppMethodBeat.o(146736);
  }
  
  public boolean c(String paramString, cb paramcb)
  {
    int i = 0;
    AppMethodBeat.i(220275);
    boolean bool = super.c(paramString, paramcb);
    if (bool) {
      cM(false);
    }
    for (;;)
    {
      if (i < this.tuD.getChildCount())
      {
        paramString = this.tuD.getChildAt(i);
        if ((paramString instanceof i)) {
          this.tuD.removeView(paramString);
        }
      }
      else
      {
        AppMethodBeat.o(220275);
        return bool;
      }
      i += 1;
    }
  }
  
  public final void cM(boolean paramBoolean)
  {
    AppMethodBeat.i(220287);
    removeCallbacks(this.eqD);
    if (paramBoolean) {
      aeN("cancelShowErrorPageViewRunnable");
    }
    AppMethodBeat.o(220287);
  }
  
  public final void cN(boolean paramBoolean)
  {
    AppMethodBeat.i(146735);
    com.tencent.mm.plugin.appbrand.permission.d locald = aqZ().evw;
    if ((locald.a(ara(), aa.class)) || (locald.a(this, aa.class)))
    {
      super.cN(paramBoolean);
      AppMethodBeat.o(146735);
      return;
    }
    super.cN(true);
    AppMethodBeat.o(146735);
  }
  
  public final void d(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(220307);
    if ((aqZ() != null) && (aqZ().asE()))
    {
      if (paramRunnable != null)
      {
        arh().postDelayed(paramRunnable, paramLong);
        AppMethodBeat.o(220307);
      }
    }
    else {
      super.d(paramRunnable, paramLong);
    }
    AppMethodBeat.o(220307);
  }
  
  public final void fo(String paramString)
  {
    AppMethodBeat.i(146729);
    super.cEF();
    boolean bool = aqZ().evw.a(this, c.b.class);
    Log.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound appId:%s, hasPermission:%b, url:%s", new Object[] { getAppId(), Boolean.valueOf(bool), paramString });
    if (!bool)
    {
      arc();
      AppMethodBeat.o(146729);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", m.fL(paramString));
    localHashMap.put("query", m.fM(paramString));
    localHashMap.put("rawPath", paramString);
    localHashMap.put("isEntryPage", Boolean.valueOf(Util.nullAsNil(paramString).equals(aqZ().cby())));
    a(new c.b((byte)0).K(localHashMap), null);
    d(this.eqD, 2000L);
    AppMethodBeat.o(146729);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(146734);
    h localh = (h)aa(h.class);
    if ((localh != null) && (localh.aqo()))
    {
      AppMethodBeat.o(146734);
      return true;
    }
    AppMethodBeat.o(146734);
    return false;
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(220303);
    if ((aqZ() != null) && (aqZ().asE()))
    {
      if (paramRunnable != null)
      {
        arh().post(paramRunnable);
        AppMethodBeat.o(220303);
      }
    }
    else {
      super.post(paramRunnable);
    }
    AppMethodBeat.o(220303);
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    AppMethodBeat.i(220311);
    if ((this.eqE != null) && (paramRunnable != null)) {
      this.eqE.removeCallbacks(paramRunnable);
    }
    super.removeCallbacks(paramRunnable);
    AppMethodBeat.o(220311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */