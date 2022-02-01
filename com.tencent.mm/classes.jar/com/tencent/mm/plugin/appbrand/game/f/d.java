package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

@SuppressLint({"ViewConstructor"})
public final class d
  extends ah
{
  private boolean ood = false;
  
  d()
  {
    super(e.class);
  }
  
  public final com.tencent.mm.vending.g.c<Bitmap> QQ()
  {
    AppMethodBeat.i(45186);
    com.tencent.mm.vending.g.c localc = g.ieN().c(new a() {});
    AppMethodBeat.o(45186);
    return localc;
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
  
  public final void agC(String paramString) {}
  
  public final void agD(final String paramString)
  {
    AppMethodBeat.i(45184);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45177);
        Object localObject = d.this;
        if (f.a.anB(paramString) == f.a.roU) {}
        for (boolean bool = true;; bool = false)
        {
          d.a((d)localObject, bool);
          if ((d.this.getContext() instanceof Activity))
          {
            localObject = ((Activity)d.this.getContext()).getWindow();
            if (localObject != null) {
              x.d((Window)localObject, d.a(d.this));
            }
          }
          AppMethodBeat.o(45177);
          return;
        }
      }
    });
    AppMethodBeat.o(45184);
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
    if ((getRuntime() == null) || (getRuntime().bDA() == null))
    {
      Log.w("AppBrandGame.WAGamePageView", "publish runtime destroyed, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(45183);
      return;
    }
    getRuntime().bDA().c(paramString1, paramString2, getComponentId());
    AppMethodBeat.o(45183);
  }
  
  public final String bOK()
  {
    return null;
  }
  
  public final void bOL()
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
            x.d(localWindow, d.a(d.this));
          }
        }
        AppMethodBeat.o(45178);
      }
    });
    AppMethodBeat.o(45185);
  }
  
  public final void hV(boolean paramBoolean) {}
  
  public final void zM(int paramInt) {}
  
  public final void zN(int paramInt) {}
  
  static final class a
    implements e.c
  {
    public final void X(int paramInt, String paramString) {}
    
    public final void a(az paramaz, com.tencent.mm.plugin.appbrand.m.o paramo, e.b paramb)
    {
      AppMethodBeat.i(257490);
      paramb.agN("UnsupportedOperation");
      AppMethodBeat.o(257490);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.o paramo, String paramString1, int paramInt, String paramString2) {}
    
    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.o paramo, String paramString, int paramInt, e.b paramb)
    {
      AppMethodBeat.i(45179);
      paramb.agN("UnsupportedOperation");
      AppMethodBeat.o(45179);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.d
 * JD-Core Version:    0.7.0.1
 */