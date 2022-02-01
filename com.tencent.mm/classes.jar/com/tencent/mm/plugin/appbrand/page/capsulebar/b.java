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
  extends j
  implements a
{
  private final AppBrandRuntime nAt;
  private final i.a qwS;
  private Drawable qwT;
  private CharSequence qwU;
  private int qwV;
  
  public b(AppBrandRuntime paramAppBrandRuntime, i.a parama)
  {
    this.nAt = paramAppBrandRuntime;
    this.qwS = parama;
  }
  
  private boolean cfv()
  {
    AppMethodBeat.i(244127);
    if ((this.nAt == null) || (this.nAt.ntU.get()) || (this.nAt.aol) || (this.nAt.ntG == null))
    {
      AppMethodBeat.o(244127);
      return true;
    }
    AppMethodBeat.o(244127);
    return false;
  }
  
  protected final void Cw(int paramInt)
  {
    AppMethodBeat.i(244135);
    this.qwV = paramInt;
    if (cfv())
    {
      AppMethodBeat.o(244135);
      return;
    }
    this.qwS.setStatus(paramInt);
    AppMethodBeat.o(244135);
  }
  
  protected final void D(Drawable paramDrawable)
  {
    AppMethodBeat.i(244131);
    this.qwT = paramDrawable;
    if (cfv())
    {
      AppMethodBeat.o(244131);
      return;
    }
    this.qwS.setLogo(paramDrawable);
    AppMethodBeat.o(244131);
  }
  
  protected final void L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(244134);
    this.qwU = paramCharSequence;
    if (cfv())
    {
      AppMethodBeat.o(244134);
      return;
    }
    this.qwS.M(paramCharSequence);
    AppMethodBeat.o(244134);
  }
  
  protected final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(244129);
    this.nAt.h(paramRunnable, 0L);
    AppMethodBeat.o(244129);
  }
  
  public final i.a a(a.b paramb)
  {
    AppMethodBeat.i(244137);
    int i = paramb.qwP;
    int j = paramb.qwQ;
    i.a locala = super.cfE();
    locala.setLogo(j);
    locala.Cy(i);
    locala.setStatus(paramb.ordinal());
    AppMethodBeat.o(244137);
    return locala;
  }
  
  public final int cfu()
  {
    return this.qwV;
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(244128);
    try
    {
      Context localContext = this.nAt.bBX().getCurrentPage().getCurrentPageView().cdY().getContext();
      AppMethodBeat.o(244128);
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(this.nAt.mContext);
      AppMethodBeat.o(244128);
      return localActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.b
 * JD-Core Version:    0.7.0.1
 */