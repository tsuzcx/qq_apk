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
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.LinkedList;

public class b
  extends f
{
  private static final b lzf;
  private static final HashMap<AppBrandRuntime, b> lzg;
  private final AppBrandRuntime jiI;
  private Drawable lzh;
  private CharSequence lzi;
  private int lzj;
  
  static
  {
    AppMethodBeat.i(134964);
    lzf = new b()
    {
      public final c.a a(b.a paramAnonymousa)
      {
        return lGu;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(134948);
        Context localContext = ai.getContext();
        AppMethodBeat.o(134948);
        return localContext;
      }
    };
    lzg = new HashMap();
    AppMethodBeat.o(134964);
  }
  
  private b(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134955);
    this.jiI = paramAppBrandRuntime;
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
        b localb = (b)b.lzg.remove(paramAppBrandRuntime);
        if (localb != null) {
          localb.lGz.clear();
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
    if (this.jiI.CX() == null)
    {
      AppMethodBeat.o(134958);
      return;
    }
    paramaa.bqy().getCapsuleBar().brA().setLogo(paramDrawable);
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
  
  public static b ai(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134954);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = lzf;
      AppMethodBeat.o(134954);
      return paramAppBrandRuntime;
    }
    b localb2 = (b)lzg.get(paramAppBrandRuntime);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(paramAppBrandRuntime);
      lzg.put(paramAppBrandRuntime, localb1);
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
    paramaa.uk(paramInt);
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
    b localb = ai(paramaa.getRuntime());
    localb.a(localb.lzh, paramaa);
    a(localb.lzi, paramaa);
    b(localb.lzj, paramaa);
    AppMethodBeat.o(134953);
  }
  
  public final void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(134959);
    this.lzi = paramCharSequence;
    if (this.jiI.CX() == null)
    {
      AppMethodBeat.o(134959);
      return;
    }
    a(this.lzi, this.jiI.CX().getCurrentPageView());
    AppMethodBeat.o(134959);
  }
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(160931);
    this.jiI.i(paramRunnable, 0L);
    AppMethodBeat.o(160931);
  }
  
  public c.a a(a parama)
  {
    AppMethodBeat.i(134963);
    int i = parama.lzq;
    int j = parama.lzr;
    c.a locala = super.brA();
    locala.setLogo(j);
    locala.us(i);
    locala.setStatus(parama.ordinal());
    AppMethodBeat.o(134963);
    return locala;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(134956);
    try
    {
      Context localContext = this.jiI.aSA().getCurrentPage().getCurrentPageView().bqy().getContext();
      AppMethodBeat.o(134956);
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      Activity localActivity = a.jg(this.jiI.mContext);
      AppMethodBeat.o(134956);
      return localActivity;
    }
  }
  
  public final void ug(int paramInt)
  {
    AppMethodBeat.i(134960);
    this.lzj = paramInt;
    if (this.jiI.CX() == null)
    {
      AppMethodBeat.o(134960);
      return;
    }
    b(paramInt, this.jiI.CX().getCurrentPageView());
    AppMethodBeat.o(134960);
  }
  
  public final void x(Drawable paramDrawable)
  {
    AppMethodBeat.i(134957);
    this.lzh = paramDrawable;
    if (this.jiI.CX() == null)
    {
      AppMethodBeat.o(134957);
      return;
    }
    a(this.lzh, this.jiI.CX().getCurrentPageView());
    AppMethodBeat.o(134957);
  }
  
  public static enum a
  {
    final int lzq;
    final int lzr;
    
    static
    {
      AppMethodBeat.i(134952);
      lzl = new a("NORMAL", 0, -1, -1);
      lzm = new a("LBS", 1, 2131760995, 2131230948);
      lzn = new a("VOICE", 2, 2131760996, 2131230950);
      lzo = new a("VIDEO", 3, -1, 2131230949);
      lzp = new a("LOADING", 4, -1, -1);
      lzs = new a[] { lzl, lzm, lzn, lzo, lzp };
      AppMethodBeat.o(134952);
    }
    
    private a(int paramInt1, int paramInt2)
    {
      this.lzq = paramInt1;
      this.lzr = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */