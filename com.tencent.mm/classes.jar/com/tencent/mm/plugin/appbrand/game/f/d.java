package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

@SuppressLint({"ViewConstructor"})
public final class d
  extends ad
{
  private boolean kpx = false;
  
  d()
  {
    super(e.class);
  }
  
  public final com.tencent.mm.vending.g.c<Bitmap> Eu()
  {
    AppMethodBeat.i(45186);
    com.tencent.mm.vending.g.c localc = g.fSA().c(new a() {});
    AppMethodBeat.o(45186);
    return localc;
  }
  
  public final void PD(String paramString) {}
  
  public final void PE(final String paramString)
  {
    AppMethodBeat.i(45184);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45177);
        Object localObject = d.this;
        if (e.a.Wa(paramString) == e.a.mZn) {}
        for (boolean bool = true;; bool = false)
        {
          d.a((d)localObject, bool);
          if ((d.this.getContext() instanceof Activity))
          {
            localObject = ((Activity)d.this.getContext()).getWindow();
            if (localObject != null) {
              t.c((Window)localObject, d.a(d.this));
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
    long l = bu.HQ();
    super.a(paramContext, paramAppBrandRuntime);
    this.ktB = new a((byte)0);
    ae.i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView init cost [%d]ms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(45181);
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
    if ((getRuntime() == null) || (getRuntime().aXz() == null))
    {
      ae.w("AppBrandGame.WAGamePageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(45183);
      return;
    }
    getRuntime().aXz().c(paramString1, paramString2, aXX());
    AppMethodBeat.o(45183);
  }
  
  public final String bhY()
  {
    return null;
  }
  
  public final void bhZ()
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
            t.c(localWindow, d.a(d.this));
          }
        }
        AppMethodBeat.o(45178);
      }
    });
    AppMethodBeat.o(45185);
  }
  
  public final void gh(boolean paramBoolean) {}
  
  public final void sD(int paramInt) {}
  
  public final void sE(int paramInt) {}
  
  static final class a
    implements c.b
  {
    public final void S(int paramInt, String paramString) {}
    
    public final void a(at paramat, c.a parama)
    {
      AppMethodBeat.i(45180);
      parama.PL("UnsupportedOperation");
      AppMethodBeat.o(45180);
    }
    
    public final void a(m paramm, String paramString1, int paramInt, String paramString2) {}
    
    public final boolean a(m paramm, String paramString, int paramInt, c.a parama)
    {
      AppMethodBeat.i(45179);
      parama.PL("UnsupportedOperation");
      AppMethodBeat.o(45179);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.d
 * JD-Core Version:    0.7.0.1
 */