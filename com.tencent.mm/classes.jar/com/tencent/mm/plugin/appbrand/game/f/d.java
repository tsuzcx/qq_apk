package com.tencent.mm.plugin.appbrand.game.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

public final class d
  extends ah
{
  private boolean rrM = false;
  
  d()
  {
    super(e.class);
  }
  
  public final void Ad(int paramInt) {}
  
  public final void Ae(int paramInt) {}
  
  public final void Zy(String paramString) {}
  
  public final void Zz(final String paramString)
  {
    AppMethodBeat.i(45184);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45177);
        Object localObject = d.this;
        if (f.a.agY(paramString) == f.a.uzf) {}
        for (boolean bool = true;; bool = false)
        {
          d.a((d)localObject, bool);
          if ((d.this.getContext() instanceof Activity))
          {
            localObject = ((Activity)d.this.getContext()).getWindow();
            if (localObject != null) {
              ae.c((Window)localObject, d.a(d.this));
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
    setInterceptor(new a((byte)0));
    Log.i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView init cost [%d]ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(45181);
  }
  
  public final com.tencent.mm.vending.g.c<Bitmap> ard()
  {
    AppMethodBeat.i(45186);
    com.tencent.mm.vending.g.c localc = g.jJU().c(new a() {});
    AppMethodBeat.o(45186);
    return localc;
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
    if ((getRuntime() == null) || (getRuntime().ccO() == null))
    {
      Log.w("AppBrandGame.WAGamePageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(45183);
      return;
    }
    getRuntime().ccO().f(paramString1, paramString2, getComponentId());
    AppMethodBeat.o(45183);
  }
  
  public final String coY()
  {
    return null;
  }
  
  public final void coZ()
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
            ae.c(localWindow, d.a(d.this));
          }
        }
        AppMethodBeat.o(45178);
      }
    });
    AppMethodBeat.o(45185);
  }
  
  public final void iU(boolean paramBoolean) {}
  
  static final class a
    implements f.c
  {
    public final void a(bc parambc, o paramo, f.b paramb)
    {
      AppMethodBeat.i(318445);
      paramb.ZJ("UnsupportedOperation");
      AppMethodBeat.o(318445);
    }
    
    public final void a(p paramp, String paramString1, String paramString2, int paramInt, String paramString3) {}
    
    public final boolean a(p paramp, String paramString1, String paramString2, int paramInt, f.b paramb)
    {
      AppMethodBeat.i(318438);
      paramb.ZJ("UnsupportedOperation");
      AppMethodBeat.o(318438);
      return true;
    }
    
    public final void af(int paramInt, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.d
 * JD-Core Version:    0.7.0.1
 */