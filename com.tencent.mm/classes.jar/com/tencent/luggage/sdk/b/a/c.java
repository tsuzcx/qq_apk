package com.tencent.luggage.sdk.b.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.k.l;
import com.tencent.luggage.l.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.h.e;
import com.tencent.mm.plugin.appbrand.jsapi.q.aa;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bp;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.i;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import java.util.HashMap;
import java.util.Map;

public class c
  extends ad
  implements d
{
  private final Runnable cyk;
  private MMHandler cyl;
  
  public c()
  {
    super(bp.class);
    AppMethodBeat.i(146724);
    this.cyk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.QP();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146724);
  }
  
  public c(Class<? extends af> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(146723);
    this.cyk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.QP();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146723);
  }
  
  private void QR()
  {
    AppMethodBeat.i(146733);
    FrameLayout localFrameLayout = (FrameLayout)this.qpZ.findViewById(a.d.app_brand_page_view_share_screenshot_cover);
    if (localFrameLayout != null)
    {
      localFrameLayout.setVisibility(8);
      if (!(localFrameLayout.getBackground() instanceof BitmapDrawable)) {
        break label69;
      }
    }
    label69:
    for (Bitmap localBitmap = ((BitmapDrawable)localFrameLayout.getBackground()).getBitmap();; localBitmap = null)
    {
      localFrameLayout.setBackground(null);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      AppMethodBeat.o(146733);
      return;
    }
  }
  
  private MMHandler QV()
  {
    AppMethodBeat.i(247555);
    if (this.cyl == null) {
      this.cyl = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.cyl;
    AppMethodBeat.o(247555);
    return localMMHandler;
  }
  
  public com.tencent.luggage.sdk.e.d QM()
  {
    AppMethodBeat.i(146725);
    com.tencent.luggage.sdk.e.d locald = (com.tencent.luggage.sdk.e.d)super.getRuntime();
    AppMethodBeat.o(146725);
    return locald;
  }
  
  public com.tencent.luggage.sdk.b.a.c.d QN()
  {
    AppMethodBeat.i(146726);
    com.tencent.luggage.sdk.b.a.c.d locald = (com.tencent.luggage.sdk.b.a.c.d)super.QW();
    AppMethodBeat.o(146726);
    return locald;
  }
  
  public void QO()
  {
    AppMethodBeat.i(146728);
    super.QO();
    cf(false);
    if (this.cyl != null) {
      this.cyl.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(146728);
  }
  
  public final void QP()
  {
    AppMethodBeat.i(146731);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), this.oxe });
      AppMethodBeat.o(146731);
      return;
    }
    Log.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), this.oxe });
    cen();
    i locali = new i(getContext(), QM());
    this.qpZ.addView(locali);
    AppMethodBeat.o(146731);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> QQ()
  {
    AppMethodBeat.i(146732);
    com.tencent.mm.vending.g.c localc = g.ieN().f(new a() {});
    AppMethodBeat.o(146732);
    return localc;
  }
  
  public final void QS()
  {
    AppMethodBeat.i(247554);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146721);
        if (c.this.qoF == null)
        {
          AppMethodBeat.o(146721);
          return;
        }
        if (c.this.qoF.getWebScrollY() == 0)
        {
          AppMethodBeat.o(146721);
          return;
        }
        c.a(c.this);
        c.this.qoF.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(146721);
      }
    });
    a(new h.e()
    {
      public final void QX()
      {
        AppMethodBeat.i(169430);
        c.this.b(this);
        c.b(c.this);
        c.this.qoF.setVerticalScrollBarEnabled(true);
        AppMethodBeat.o(169430);
      }
    });
    AppMethodBeat.o(247554);
  }
  
  public final boolean QT()
  {
    AppMethodBeat.i(146734);
    h localh = (h)R(h.class);
    if ((localh != null) && (localh.Qe()))
    {
      AppMethodBeat.o(146734);
      return true;
    }
    AppMethodBeat.o(146734);
    return false;
  }
  
  public void QU()
  {
    AppMethodBeat.i(146736);
    if (QM().bBX().getPageCount() == 1)
    {
      com.tencent.mm.plugin.appbrand.page.b localb = this.qsC;
      if ((localb.qmt) || (!localb.qoW)) {}
      for (int i = 1; i != 0; i = 0)
      {
        cdY().setNavHidden(true);
        AppMethodBeat.o(146736);
        return;
      }
    }
    cdY().setNavHidden(false);
    AppMethodBeat.o(146736);
  }
  
  public final void a(az paramaz, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(247548);
    if ((paramaz instanceof c.b)) {
      Log.i("MicroMsg.AppBrandPageViewLU", "publish onPageNotFound, appId:%s, webviewId:%d, data:%s", new Object[] { getAppId(), Integer.valueOf(getComponentId()), paramaz.getData() });
    }
    super.a(paramaz, paramArrayOfInt);
    AppMethodBeat.o(247548);
  }
  
  public final void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(247558);
    if ((QM() != null) && (QM().So()))
    {
      if (paramRunnable != null)
      {
        QV().postDelayed(paramRunnable, paramLong);
        AppMethodBeat.o(247558);
      }
    }
    else {
      super.c(paramRunnable, paramLong);
    }
    AppMethodBeat.o(247558);
  }
  
  public boolean c(String paramString, ca paramca)
  {
    int i = 0;
    AppMethodBeat.i(247545);
    boolean bool = super.c(paramString, paramca);
    if (bool) {
      cf(false);
    }
    for (;;)
    {
      if (i < this.qpZ.getChildCount())
      {
        paramString = this.qpZ.getChildAt(i);
        if ((paramString instanceof i)) {
          this.qpZ.removeView(paramString);
        }
      }
      else
      {
        AppMethodBeat.o(247545);
        return bool;
      }
      i += 1;
    }
  }
  
  public final void cf(boolean paramBoolean)
  {
    AppMethodBeat.i(247552);
    removeCallbacks(this.cyk);
    if (paramBoolean) {
      alH("cancelShowErrorPageViewRunnable");
    }
    AppMethodBeat.o(247552);
  }
  
  public final void cg(boolean paramBoolean)
  {
    AppMethodBeat.i(146735);
    com.tencent.mm.plugin.appbrand.permission.d locald = QM().cCQ;
    if ((locald.a(QN(), aa.class)) || (locald.a(this, aa.class)))
    {
      super.cg(paramBoolean);
      AppMethodBeat.o(146735);
      return;
    }
    super.cg(true);
    AppMethodBeat.o(146735);
  }
  
  public final void dY(String paramString)
  {
    AppMethodBeat.i(146729);
    super.ced();
    boolean bool = QM().cCQ.a(this, c.b.class);
    Log.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound appId:%s, hasPermission:%b, url:%s", new Object[] { getAppId(), Boolean.valueOf(bool), paramString });
    if (!bool)
    {
      QP();
      AppMethodBeat.o(146729);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", l.eo(paramString));
    localHashMap.put("query", l.ep(paramString));
    localHashMap.put("rawPath", paramString);
    localHashMap.put("isEntryPage", Boolean.valueOf(Util.nullAsNil(paramString).equals(QM().bCi())));
    a(new c.b((byte)0).D(localHashMap), null);
    c(this.cyk, 2000L);
    AppMethodBeat.o(146729);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(247556);
    if ((QM() != null) && (QM().So()))
    {
      if (paramRunnable != null)
      {
        QV().post(paramRunnable);
        AppMethodBeat.o(247556);
      }
    }
    else {
      super.post(paramRunnable);
    }
    AppMethodBeat.o(247556);
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    AppMethodBeat.i(247560);
    if ((this.cyl != null) && (paramRunnable != null)) {
      this.cyl.removeCallbacks(paramRunnable);
    }
    super.removeCallbacks(paramRunnable);
    AppMethodBeat.o(247560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */