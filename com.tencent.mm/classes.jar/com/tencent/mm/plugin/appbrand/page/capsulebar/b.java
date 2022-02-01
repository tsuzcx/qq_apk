package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;

final class b
  extends j
  implements a
{
  private final AppBrandRuntime jFc;
  private final i.a mkA;
  private Drawable mkB;
  private CharSequence mkC;
  private int mkD;
  
  public b(AppBrandRuntime paramAppBrandRuntime, i.a parama)
  {
    this.jFc = paramAppBrandRuntime;
    this.mkA = parama;
  }
  
  private boolean bwo()
  {
    AppMethodBeat.i(207867);
    if ((this.jFc == null) || (this.jFc.isDestroyed()) || (this.jFc.SB) || (this.jFc.jzJ == null))
    {
      AppMethodBeat.o(207867);
      return true;
    }
    AppMethodBeat.o(207867);
    return false;
  }
  
  protected final void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(207871);
    this.mkC = paramCharSequence;
    if (bwo())
    {
      AppMethodBeat.o(207871);
      return;
    }
    this.mkA.setDescription(paramCharSequence);
    AppMethodBeat.o(207871);
  }
  
  protected final void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(207869);
    this.jFc.j(paramRunnable, 0L);
    AppMethodBeat.o(207869);
  }
  
  public final i.a a(a.b paramb)
  {
    AppMethodBeat.i(207873);
    int i = paramb.mkx;
    int j = paramb.mky;
    i.a locala = super.bwt();
    locala.setLogo(j);
    locala.vb(i);
    locala.setStatus(paramb.ordinal());
    AppMethodBeat.o(207873);
    return locala;
  }
  
  public final int bwn()
  {
    return this.mkD;
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(207868);
    try
    {
      Context localContext = this.jFc.aWm().getCurrentPage().getCurrentPageView().bvi().getContext();
      AppMethodBeat.o(207868);
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      Activity localActivity = com.tencent.mm.sdk.f.a.jw(this.jFc.mContext);
      AppMethodBeat.o(207868);
      return localActivity;
    }
  }
  
  protected final void va(int paramInt)
  {
    AppMethodBeat.i(207872);
    this.mkD = paramInt;
    if (bwo())
    {
      AppMethodBeat.o(207872);
      return;
    }
    this.mkA.setStatus(paramInt);
    AppMethodBeat.o(207872);
  }
  
  protected final void y(Drawable paramDrawable)
  {
    AppMethodBeat.i(207870);
    this.mkB = paramDrawable;
    if (bwo())
    {
      AppMethodBeat.o(207870);
      return;
    }
    this.mkA.setLogo(paramDrawable);
    AppMethodBeat.o(207870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.b
 * JD-Core Version:    0.7.0.1
 */