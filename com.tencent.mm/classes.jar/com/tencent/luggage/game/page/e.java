package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.platformtools.ad;

@SuppressLint({"ViewConstructor"})
public final class e
  extends q
{
  private aa cdz;
  private String mURL;
  
  public e(Context paramContext, t paramt)
  {
    super(paramContext, paramt);
    AppMethodBeat.i(130628);
    ad.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(130628);
  }
  
  public final View Cq()
  {
    AppMethodBeat.i(130629);
    Object localObject = getContainer().bjq();
    this.cdz = ((aa)localObject);
    localObject = ((aa)localObject).jhz;
    AppMethodBeat.o(130629);
    return localObject;
  }
  
  public final void Cr()
  {
    AppMethodBeat.i(130633);
    super.Cr();
    this.cdz.onDestroy();
    AppMethodBeat.o(130633);
  }
  
  public final void Cs()
  {
    AppMethodBeat.i(130634);
    super.Cs();
    setEnableGesture(false);
    this.cdz.onForeground();
    AppMethodBeat.o(130634);
  }
  
  public final void Ct()
  {
    AppMethodBeat.i(130635);
    super.Ct();
    this.cdz.onBackground();
    AppMethodBeat.o(130635);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130631);
    this.cdz.c(paramString1, paramString2, 0);
    AppMethodBeat.o(130631);
  }
  
  public final boolean cl(String paramString)
  {
    return true;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(130632);
    super.cleanup();
    this.cdz.cleanup();
    AppMethodBeat.o(130632);
  }
  
  public final aa getCurrentPageView()
  {
    return this.cdz;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(130630);
    this.mURL = paramString;
    this.cdz.ct(paramString);
    AppMethodBeat.o(130630);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.mURL = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.page.e
 * JD-Core Version:    0.7.0.1
 */