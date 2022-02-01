package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class b
  extends j
  implements a
{
  private final AppBrandRuntime kGM;
  private final i.a nuX;
  private Drawable nuY;
  private CharSequence nuZ;
  private int nva;
  
  public b(AppBrandRuntime paramAppBrandRuntime, i.a parama)
  {
    this.kGM = paramAppBrandRuntime;
    this.nuX = parama;
  }
  
  private boolean bSv()
  {
    AppMethodBeat.i(219466);
    if ((this.kGM == null) || (this.kGM.isDestroyed()) || (this.kGM.SO) || (this.kGM.kAx == null))
    {
      AppMethodBeat.o(219466);
      return true;
    }
    AppMethodBeat.o(219466);
    return false;
  }
  
  protected final void E(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(219470);
    this.nuZ = paramCharSequence;
    if (bSv())
    {
      AppMethodBeat.o(219470);
      return;
    }
    this.nuX.setDescription(paramCharSequence);
    AppMethodBeat.o(219470);
  }
  
  protected final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(219468);
    this.kGM.i(paramRunnable, 0L);
    AppMethodBeat.o(219468);
  }
  
  public final i.a a(a.b paramb)
  {
    AppMethodBeat.i(219472);
    int i = paramb.nuU;
    int j = paramb.nuV;
    i.a locala = super.bSB();
    locala.setLogo(j);
    locala.yT(i);
    locala.setStatus(paramb.ordinal());
    AppMethodBeat.o(219472);
    return locala;
  }
  
  public final int bSu()
  {
    return this.nva;
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(219467);
    try
    {
      Context localContext = this.kGM.brh().getCurrentPage().getCurrentPageView().bRi().getContext();
      AppMethodBeat.o(219467);
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(this.kGM.mContext);
      AppMethodBeat.o(219467);
      return localActivity;
    }
  }
  
  protected final void y(Drawable paramDrawable)
  {
    AppMethodBeat.i(219469);
    this.nuY = paramDrawable;
    if (bSv())
    {
      AppMethodBeat.o(219469);
      return;
    }
    this.nuX.setLogo(paramDrawable);
    AppMethodBeat.o(219469);
  }
  
  protected final void yS(int paramInt)
  {
    AppMethodBeat.i(219471);
    this.nva = paramInt;
    if (bSv())
    {
      AppMethodBeat.o(219471);
      return;
    }
    this.nuX.setStatus(paramInt);
    AppMethodBeat.o(219471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.b
 * JD-Core Version:    0.7.0.1
 */