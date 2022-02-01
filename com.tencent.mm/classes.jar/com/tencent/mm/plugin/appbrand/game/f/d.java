package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

@SuppressLint({"ViewConstructor"})
public final class d
  extends ae
{
  private boolean jrB = false;
  
  d()
  {
    super(e.class);
  }
  
  public final com.tencent.mm.vending.g.c<Bitmap> Dq()
  {
    AppMethodBeat.i(45186);
    com.tencent.mm.vending.g.c localc = g.fhq().c(new a() {});
    AppMethodBeat.o(45186);
    return localc;
  }
  
  public final void Hx(String paramString) {}
  
  public final void Hy(final String paramString)
  {
    AppMethodBeat.i(45184);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45177);
        Object localObject = d.this;
        if (com.tencent.mm.plugin.appbrand.page.a.d.a.LQ(paramString) == com.tencent.mm.plugin.appbrand.page.a.d.a.lgB) {}
        for (boolean bool = true;; bool = false)
        {
          d.a((d)localObject, bool);
          if ((d.this.getContext() instanceof Activity))
          {
            localObject = ((Activity)d.this.getContext()).getWindow();
            if (localObject != null) {
              r.c((Window)localObject, d.a(d.this));
            }
          }
          AppMethodBeat.o(45177);
          return;
        }
      }
    });
    AppMethodBeat.o(45184);
  }
  
  public final void a(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45181);
    long l = bt.GC();
    super.a(paramContext, paramAppBrandRuntime);
    this.jvC = new a((byte)0);
    ad.i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView init cost [%d]ms", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(45181);
  }
  
  public final String aWO()
  {
    return null;
  }
  
  public final void aWP()
  {
    AppMethodBeat.i(45185);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45178);
        if ((d.this.getContext() instanceof Activity))
        {
          Window localWindow = ((Activity)d.this.getContext()).getWindow();
          if (localWindow != null) {
            r.c(localWindow, d.a(d.this));
          }
        }
        AppMethodBeat.o(45178);
      }
    });
    AppMethodBeat.o(45185);
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(45183);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(45183);
      return;
    }
    if (paramString1.startsWith("onAppRoute"))
    {
      AppMethodBeat.o(45183);
      return;
    }
    if ((getRuntime() == null) || (getRuntime().aNe() == null))
    {
      ad.w("AppBrandGame.WAGamePageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(45183);
      return;
    }
    getRuntime().aNe().c(paramString1, paramString2, aOd());
    AppMethodBeat.o(45183);
  }
  
  public final void fI(boolean paramBoolean) {}
  
  public final void rl(int paramInt) {}
  
  public final void rm(int paramInt) {}
  
  static final class a
    implements c.b
  {
    public final void P(int paramInt, String paramString) {}
    
    public final void a(ar paramar, c.a parama)
    {
      AppMethodBeat.i(45180);
      parama.HF("UnsupportedOperation");
      AppMethodBeat.o(45180);
    }
    
    public final void a(m paramm, String paramString1, int paramInt, String paramString2) {}
    
    public final boolean a(m paramm, String paramString, int paramInt, c.a parama)
    {
      AppMethodBeat.i(45179);
      parama.HF("UnsupportedOperation");
      AppMethodBeat.o(45179);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.d
 * JD-Core Version:    0.7.0.1
 */