package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class b
  extends f
{
  private static final b iuR;
  private static final HashMap<i, b> iuS;
  private final i bAb;
  private Drawable iuT;
  private CharSequence iuU;
  
  static
  {
    AppMethodBeat.i(87036);
    iuR = new b()
    {
      public final c.a a(b.a paramAnonymousa)
      {
        return iAl;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(87022);
        Context localContext = ah.getContext();
        AppMethodBeat.o(87022);
        return localContext;
      }
    };
    iuS = new HashMap();
    AppMethodBeat.o(87036);
  }
  
  private b(i parami)
  {
    AppMethodBeat.i(87029);
    this.bAb = parami;
    if (parami == null)
    {
      AppMethodBeat.o(87029);
      return;
    }
    e.a(parami.mAppId, new b.2(this, parami));
    AppMethodBeat.o(87029);
  }
  
  public static b E(i parami)
  {
    AppMethodBeat.i(87028);
    if ((parami == null) || (parami.mFinished))
    {
      parami = iuR;
      AppMethodBeat.o(87028);
      return parami;
    }
    b localb2 = (b)iuS.get(parami);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(parami);
      iuS.put(parami, localb1);
    }
    AppMethodBeat.o(87028);
    return localb1;
  }
  
  private static void a(Drawable paramDrawable, v paramv)
  {
    AppMethodBeat.i(87032);
    if (paramv == null)
    {
      AppMethodBeat.o(87032);
      return;
    }
    paramv.getActionBar().getCapsuleBar().aKe().setLogo(paramDrawable);
    AppMethodBeat.o(87032);
  }
  
  private static void a(CharSequence paramCharSequence, v paramv)
  {
    AppMethodBeat.i(87034);
    if (paramv == null)
    {
      AppMethodBeat.o(87034);
      return;
    }
    paramv.x(paramCharSequence);
    AppMethodBeat.o(87034);
  }
  
  static void c(v paramv)
  {
    AppMethodBeat.i(87027);
    if (paramv == null)
    {
      AppMethodBeat.o(87027);
      return;
    }
    b localb = E(paramv.getRuntime());
    a(localb.iuT, paramv);
    a(localb.iuU, paramv);
    AppMethodBeat.o(87027);
  }
  
  public c.a a(b.a parama)
  {
    AppMethodBeat.i(87035);
    int i = parama.ivb;
    int j = parama.ivc;
    parama = super.aKe();
    parama.setLogo(j);
    parama.pp(i);
    AppMethodBeat.o(87035);
    return parama;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(87030);
    try
    {
      Context localContext = this.bAb.atj().getCurrentPage().getCurrentPageView().getActionBar().getContext();
      AppMethodBeat.o(87030);
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      Activity localActivity = this.bAb.getContext();
      AppMethodBeat.o(87030);
      return localActivity;
    }
  }
  
  public final void p(Drawable paramDrawable)
  {
    AppMethodBeat.i(87031);
    this.iuT = paramDrawable;
    a(this.iuT, this.bAb.ws().getCurrentPageView());
    AppMethodBeat.o(87031);
  }
  
  public final void w(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(87033);
    this.iuU = paramCharSequence;
    a(this.iuU, this.bAb.ws().getCurrentPageView());
    AppMethodBeat.o(87033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */