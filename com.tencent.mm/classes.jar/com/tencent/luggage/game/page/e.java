package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;

@SuppressLint({"ViewConstructor"})
public final class e
  extends q
{
  private z ckP;
  private String mURL;
  
  public e(Context paramContext, t paramt)
  {
    super(paramContext, paramt);
    AppMethodBeat.i(130628);
    ae.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(130628);
  }
  
  public final View Dw()
  {
    AppMethodBeat.i(130629);
    Object localObject = getContainer().buT();
    this.ckP = ((z)localObject);
    localObject = ((z)localObject).kfr;
    AppMethodBeat.o(130629);
    return localObject;
  }
  
  public final void Dx()
  {
    AppMethodBeat.i(130633);
    super.Dx();
    this.ckP.onDestroy();
    AppMethodBeat.o(130633);
  }
  
  public final void Dy()
  {
    AppMethodBeat.i(130634);
    super.Dy();
    setEnableGesture(false);
    this.ckP.onForeground();
    AppMethodBeat.o(130634);
  }
  
  public final void Dz()
  {
    AppMethodBeat.i(130635);
    super.Dz();
    this.ckP.onBackground();
    AppMethodBeat.o(130635);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130631);
    this.ckP.c(paramString1, paramString2, 0);
    AppMethodBeat.o(130631);
  }
  
  public final boolean cX(String paramString)
  {
    return true;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(130632);
    super.cleanup();
    this.ckP.cleanup();
    AppMethodBeat.o(130632);
  }
  
  public final z getCurrentPageView()
  {
    return this.ckP;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(130630);
    this.mURL = paramString;
    this.ckP.dm(paramString);
    AppMethodBeat.o(130630);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.mURL = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.e
 * JD-Core Version:    0.7.0.1
 */