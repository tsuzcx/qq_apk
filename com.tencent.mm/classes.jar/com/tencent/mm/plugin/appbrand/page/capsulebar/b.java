package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;

final class b
  extends o
  implements a
{
  private final AppBrandRuntime qzz;
  private final m.a tBR;
  private Drawable tBS;
  private CharSequence tBT;
  private int tBU;
  
  public b(AppBrandRuntime paramAppBrandRuntime, m.a parama)
  {
    this.qzz = paramAppBrandRuntime;
    this.tBR = parama;
  }
  
  private boolean cGg()
  {
    AppMethodBeat.i(325304);
    if ((this.qzz == null) || (this.qzz.qsE.get()) || (this.qzz.ccV) || (this.qzz.qsp == null))
    {
      AppMethodBeat.o(325304);
      return true;
    }
    AppMethodBeat.o(325304);
    return false;
  }
  
  protected final void CM(int paramInt)
  {
    AppMethodBeat.i(325338);
    this.tBU = paramInt;
    if (cGg())
    {
      AppMethodBeat.o(325338);
      return;
    }
    this.tBR.setStatus(paramInt);
    AppMethodBeat.o(325338);
  }
  
  protected final void M(Drawable paramDrawable)
  {
    AppMethodBeat.i(325323);
    this.tBS = paramDrawable;
    if (cGg())
    {
      AppMethodBeat.o(325323);
      return;
    }
    this.tBR.setLogo(paramDrawable);
    AppMethodBeat.o(325323);
  }
  
  protected final void P(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(325330);
    this.tBT = paramCharSequence;
    if (cGg())
    {
      AppMethodBeat.o(325330);
      return;
    }
    this.tBR.Q(paramCharSequence);
    AppMethodBeat.o(325330);
  }
  
  protected final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(325318);
    this.qzz.i(paramRunnable, 0L);
    AppMethodBeat.o(325318);
  }
  
  public final m.a a(a.b paramb)
  {
    AppMethodBeat.i(325343);
    paramb = a(paramb, false, "");
    AppMethodBeat.o(325343);
    return paramb;
  }
  
  public final m.a a(a.b paramb, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(325348);
    int i = paramb.tBO;
    int j = paramb.tBP;
    m.a locala = super.kA(paramBoolean);
    locala.setTag(paramString);
    locala.setLogo(j);
    locala.CP(i);
    locala.setStatus(paramb.ordinal());
    AppMethodBeat.o(325348);
    return locala;
  }
  
  public final void afa(String paramString)
  {
    AppMethodBeat.i(325352);
    afb(paramString);
    AppMethodBeat.o(325352);
  }
  
  public final int cGf()
  {
    return this.tBU;
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(325312);
    try
    {
      Context localContext = this.qzz.getPageContainer().getCurrentPage().getCurrentPageView().cEC().getContext();
      AppMethodBeat.o(325312);
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(this.qzz.mContext);
      AppMethodBeat.o(325312);
      return localActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.b
 * JD-Core Version:    0.7.0.1
 */