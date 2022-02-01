package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.LinkedList;

public class b
  extends f
{
  private static final b lYD;
  private static final HashMap<AppBrandRuntime, b> lYE;
  private final AppBrandRuntime jCe;
  private Drawable lYF;
  private CharSequence lYG;
  private int lYH;
  
  static
  {
    AppMethodBeat.i(134964);
    lYD = new b()
    {
      public final c.a a(b.a paramAnonymousa)
      {
        return mfX;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(134948);
        Context localContext = aj.getContext();
        AppMethodBeat.o(134948);
        return localContext;
      }
    };
    lYE = new HashMap();
    AppMethodBeat.o(134964);
  }
  
  private b(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134955);
    this.jCe = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(134955);
      return;
    }
    g.a(paramAppBrandRuntime.mAppId, new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(134949);
        b localb = (b)b.lYE.remove(paramAppBrandRuntime);
        if (localb != null) {
          localb.mgc.clear();
        }
        AppMethodBeat.o(134949);
      }
    });
    AppMethodBeat.o(134955);
  }
  
  private void a(Drawable paramDrawable, aa paramaa)
  {
    AppMethodBeat.i(134958);
    if (paramaa == null)
    {
      AppMethodBeat.o(134958);
      return;
    }
    if (this.jCe.Ew() == null)
    {
      AppMethodBeat.o(134958);
      return;
    }
    paramaa.bux().getCapsuleBar().bvC().setLogo(paramDrawable);
    AppMethodBeat.o(134958);
  }
  
  private static void a(CharSequence paramCharSequence, aa paramaa)
  {
    AppMethodBeat.i(134961);
    if (paramaa == null)
    {
      AppMethodBeat.o(134961);
      return;
    }
    paramaa.B(paramCharSequence);
    AppMethodBeat.o(134961);
  }
  
  public static b ac(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134954);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = lYD;
      AppMethodBeat.o(134954);
      return paramAppBrandRuntime;
    }
    b localb2 = (b)lYE.get(paramAppBrandRuntime);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(paramAppBrandRuntime);
      lYE.put(paramAppBrandRuntime, localb1);
    }
    AppMethodBeat.o(134954);
    return localb1;
  }
  
  private static void b(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(134962);
    if (paramaa == null)
    {
      AppMethodBeat.o(134962);
      return;
    }
    paramaa.uO(paramInt);
    AppMethodBeat.o(134962);
  }
  
  static void g(aa paramaa)
  {
    AppMethodBeat.i(134953);
    if (paramaa == null)
    {
      AppMethodBeat.o(134953);
      return;
    }
    b localb = ac(paramaa.getRuntime());
    localb.a(localb.lYF, paramaa);
    a(localb.lYG, paramaa);
    b(localb.lYH, paramaa);
    AppMethodBeat.o(134953);
  }
  
  public final void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(134959);
    this.lYG = paramCharSequence;
    if (this.jCe.Ew() == null)
    {
      AppMethodBeat.o(134959);
      return;
    }
    a(this.lYG, this.jCe.Ew().getCurrentPageView());
    AppMethodBeat.o(134959);
  }
  
  public final void M(Runnable paramRunnable)
  {
    AppMethodBeat.i(160931);
    this.jCe.j(paramRunnable, 0L);
    AppMethodBeat.o(160931);
  }
  
  public c.a a(b.a parama)
  {
    AppMethodBeat.i(134963);
    int i = parama.lYO;
    int j = parama.lYP;
    c.a locala = super.bvC();
    locala.setLogo(j);
    locala.uW(i);
    locala.setStatus(parama.ordinal());
    AppMethodBeat.o(134963);
    return locala;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(134956);
    try
    {
      Context localContext = this.jCe.aVN().getCurrentPage().getCurrentPageView().bux().getContext();
      AppMethodBeat.o(134956);
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      Activity localActivity = a.jq(this.jCe.mContext);
      AppMethodBeat.o(134956);
      return localActivity;
    }
  }
  
  public final void uK(int paramInt)
  {
    AppMethodBeat.i(134960);
    this.lYH = paramInt;
    if (this.jCe.Ew() == null)
    {
      AppMethodBeat.o(134960);
      return;
    }
    b(paramInt, this.jCe.Ew().getCurrentPageView());
    AppMethodBeat.o(134960);
  }
  
  public final void x(Drawable paramDrawable)
  {
    AppMethodBeat.i(134957);
    this.lYF = paramDrawable;
    if (this.jCe.Ew() == null)
    {
      AppMethodBeat.o(134957);
      return;
    }
    a(this.lYF, this.jCe.Ew().getCurrentPageView());
    AppMethodBeat.o(134957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */