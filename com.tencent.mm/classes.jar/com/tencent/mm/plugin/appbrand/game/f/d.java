package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

@SuppressLint({"ViewConstructor"})
public final class d
  extends ag
{
  private boolean ltg = false;
  
  d()
  {
    super(e.class);
  }
  
  public final com.tencent.mm.vending.g.c<Bitmap> NT()
  {
    AppMethodBeat.i(45186);
    com.tencent.mm.vending.g.c localc = g.hdG().c(new a() {});
    AppMethodBeat.o(45186);
    return localc;
  }
  
  public final void YO(String paramString) {}
  
  public final void YP(final String paramString)
  {
    AppMethodBeat.i(45184);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45177);
        Object localObject = d.this;
        if (e.a.afW(paramString) == e.a.oms) {}
        for (boolean bool = true;; bool = false)
        {
          d.a((d)localObject, bool);
          if ((d.this.getContext() instanceof Activity))
          {
            localObject = ((Activity)d.this.getContext()).getWindow();
            if (localObject != null) {
              y.d((Window)localObject, d.a(d.this));
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
    long l = Util.currentTicks();
    super.a(paramContext, paramAppBrandRuntime);
    this.lxr = new a((byte)0);
    Log.i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView init cost [%d]ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
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
    if ((getRuntime() == null) || (getRuntime().bsE() == null))
    {
      Log.w("AppBrandGame.WAGamePageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(45183);
      return;
    }
    getRuntime().bsE().c(paramString1, paramString2, getComponentId());
    AppMethodBeat.o(45183);
  }
  
  public final String bDn()
  {
    return null;
  }
  
  public final void bDo()
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
            y.d(localWindow, d.a(d.this));
          }
        }
        AppMethodBeat.o(45178);
      }
    });
    AppMethodBeat.o(45185);
  }
  
  public final void he(boolean paramBoolean) {}
  
  public final void wA(int paramInt) {}
  
  public final void wz(int paramInt) {}
  
  static final class a
    implements f.b
  {
    public final void V(int paramInt, String paramString) {}
    
    public final void a(bc parambc, f.a parama)
    {
      AppMethodBeat.i(45180);
      parama.Zb("UnsupportedOperation");
      AppMethodBeat.o(45180);
    }
    
    public final void a(p paramp, String paramString1, int paramInt, String paramString2) {}
    
    public final boolean a(p paramp, String paramString, int paramInt, f.a parama)
    {
      AppMethodBeat.i(45179);
      parama.Zb("UnsupportedOperation");
      AppMethodBeat.o(45179);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.d
 * JD-Core Version:    0.7.0.1
 */