package com.tencent.luggage.sdk.b.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i.e;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p.aa;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bn;
import com.tencent.mm.plugin.appbrand.page.i;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import java.util.HashMap;
import java.util.Map;

public class c
  extends ac
  implements d, k
{
  private final Runnable czo;
  private MMHandler czp;
  
  public c()
  {
    super(bn.class);
    AppMethodBeat.i(146724);
    this.czo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.NS();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146724);
  }
  
  public c(Class<? extends ae> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(146723);
    this.czo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146717);
        c.this.NS();
        AppMethodBeat.o(146717);
      }
    };
    AppMethodBeat.o(146723);
  }
  
  private void NU()
  {
    AppMethodBeat.i(146733);
    FrameLayout localFrameLayout = (FrameLayout)this.noq.findViewById(2131296863);
    if (localFrameLayout != null)
    {
      localFrameLayout.setVisibility(8);
      if (!(localFrameLayout.getBackground() instanceof BitmapDrawable)) {
        break label68;
      }
    }
    label68:
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
  
  private MMHandler NX()
  {
    AppMethodBeat.i(229835);
    if (this.czp == null) {
      this.czp = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.czp;
    AppMethodBeat.o(229835);
    return localMMHandler;
  }
  
  public com.tencent.luggage.sdk.d.d NP()
  {
    AppMethodBeat.i(146725);
    com.tencent.luggage.sdk.d.d locald = (com.tencent.luggage.sdk.d.d)super.getRuntime();
    AppMethodBeat.o(146725);
    return locald;
  }
  
  public com.tencent.luggage.sdk.b.a.c.d NQ()
  {
    AppMethodBeat.i(146726);
    com.tencent.luggage.sdk.b.a.c.d locald = (com.tencent.luggage.sdk.b.a.c.d)super.NY();
    AppMethodBeat.o(146726);
    return locald;
  }
  
  public void NR()
  {
    AppMethodBeat.i(146728);
    super.NR();
    bU(false);
    if (this.czp != null) {
      this.czp.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(146728);
  }
  
  public final void NS()
  {
    AppMethodBeat.i(146731);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), this.lBI });
      AppMethodBeat.o(146731);
      return;
    }
    Log.i("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), this.lBI });
    bRw();
    i locali = new i(getContext(), NP());
    this.noq.addView(locali);
    AppMethodBeat.o(146731);
  }
  
  public com.tencent.mm.vending.g.c<Bitmap> NT()
  {
    AppMethodBeat.i(146732);
    com.tencent.mm.vending.g.c localc = g.hdG().f(new a() {});
    AppMethodBeat.o(146732);
    return localc;
  }
  
  public final void NV()
  {
    AppMethodBeat.i(229834);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146721);
        if (c.this.nmX == null)
        {
          AppMethodBeat.o(146721);
          return;
        }
        if (c.this.nmX.getWebScrollY() == 0)
        {
          AppMethodBeat.o(146721);
          return;
        }
        c.a(c.this);
        c.this.nmX.setVerticalScrollBarEnabled(false);
        AppMethodBeat.o(146721);
      }
    });
    a(new i.e()
    {
      public final void NZ()
      {
        AppMethodBeat.i(169430);
        c.this.b(this);
        c.b(c.this);
        c.this.nmX.setVerticalScrollBarEnabled(true);
        AppMethodBeat.o(169430);
      }
    });
    AppMethodBeat.o(229834);
  }
  
  public void NW()
  {
    AppMethodBeat.i(146736);
    if (NP().brh().getPageCount() == 1)
    {
      com.tencent.mm.plugin.appbrand.page.b localb = this.nqQ;
      if ((localb.nno) || (!localb.nnp)) {}
      for (int i = 1; i != 0; i = 0)
      {
        bRi().setNavHidden(true);
        AppMethodBeat.o(146736);
        return;
      }
    }
    bRi().setNavHidden(false);
    AppMethodBeat.o(146736);
  }
  
  public final void a(bc parambc, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(229832);
    if ((parambc instanceof b)) {
      Log.i("MicroMsg.AppBrandPageViewLU", "publish onPageNotFound, appId:%s, webviewId:%d, data:%s", new Object[] { getAppId(), Integer.valueOf(getComponentId()), parambc.getData() });
    }
    super.a(parambc, paramArrayOfInt);
    AppMethodBeat.o(229832);
  }
  
  public final void bU(boolean paramBoolean)
  {
    AppMethodBeat.i(229833);
    removeCallbacks(this.czo);
    if (paramBoolean) {
      adM("cancelShowErrorPageViewRunnable");
    }
    AppMethodBeat.o(229833);
  }
  
  public final void bV(boolean paramBoolean)
  {
    AppMethodBeat.i(146735);
    com.tencent.mm.plugin.appbrand.permission.d locald = NP().cCn;
    if ((locald.a(NQ(), aa.class)) || (locald.a(this, aa.class)))
    {
      super.bV(paramBoolean);
      AppMethodBeat.o(146735);
      return;
    }
    super.bV(true);
    AppMethodBeat.o(146735);
  }
  
  public final void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(229837);
    if ((NP() != null) && (NP().OS()))
    {
      if (paramRunnable != null)
      {
        NX().postDelayed(paramRunnable, paramLong);
        AppMethodBeat.o(229837);
      }
    }
    else {
      super.c(paramRunnable, paramLong);
    }
    AppMethodBeat.o(229837);
  }
  
  public boolean dE(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(229831);
    boolean bool = super.dE(paramString);
    if (bool) {
      bU(false);
    }
    for (;;)
    {
      if (i < this.noq.getChildCount())
      {
        paramString = this.noq.getChildAt(i);
        if ((paramString instanceof i)) {
          this.noq.removeView(paramString);
        }
      }
      else
      {
        AppMethodBeat.o(229831);
        return bool;
      }
      i += 1;
    }
  }
  
  public final void dF(String paramString)
  {
    AppMethodBeat.i(146729);
    this.nqZ = true;
    boolean bool = NP().cCn.a(this, b.class);
    Log.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound appId:%s, hasPermission:%b, url:%s", new Object[] { getAppId(), Boolean.valueOf(bool), paramString });
    if (!bool)
    {
      NS();
      AppMethodBeat.o(146729);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", l.dM(paramString));
    localHashMap.put("query", l.dN(paramString));
    localHashMap.put("rawPath", paramString);
    localHashMap.put("isEntryPage", Boolean.valueOf(Util.nullAsNil(paramString).equals(NP().brs())));
    a(new b((byte)0).K(localHashMap), null);
    c(this.czo, 2000L);
    AppMethodBeat.o(146729);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(146734);
    h localh = (h)S(h.class);
    if ((localh != null) && (localh.Nm()))
    {
      AppMethodBeat.o(146734);
      return true;
    }
    AppMethodBeat.o(146734);
    return false;
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(229836);
    if ((NP() != null) && (NP().OS()))
    {
      if (paramRunnable != null)
      {
        NX().post(paramRunnable);
        AppMethodBeat.o(229836);
      }
    }
    else {
      super.post(paramRunnable);
    }
    AppMethodBeat.o(229836);
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    AppMethodBeat.i(229838);
    if ((this.czp != null) && (paramRunnable != null)) {
      this.czp.removeCallbacks(paramRunnable);
    }
    super.removeCallbacks(paramRunnable);
    AppMethodBeat.o(229838);
  }
  
  public static final class a
    extends e
  {
    static final int CTRL_INDEX = 237;
    static final String NAME = "config_navigationBarRightButton";
  }
  
  static final class b
    extends s
  {
    static final int CTRL_INDEX = 429;
    static final String NAME = "onPageNotFound";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */