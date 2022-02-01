package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ad;

@SuppressLint({"ViewConstructor"})
public final class e
  extends r
{
  private aa ckN;
  private String mURL;
  
  public e(Context paramContext, u paramu)
  {
    super(paramContext, paramu);
    AppMethodBeat.i(130628);
    ad.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(130628);
  }
  
  public final View Dt()
  {
    AppMethodBeat.i(130629);
    Object localObject = getContainer().bui();
    this.ckN = ((aa)localObject);
    localObject = ((aa)localObject).kca;
    AppMethodBeat.o(130629);
    return localObject;
  }
  
  public final void Du()
  {
    AppMethodBeat.i(130633);
    super.Du();
    this.ckN.onDestroy();
    AppMethodBeat.o(130633);
  }
  
  public final void Dv()
  {
    AppMethodBeat.i(130634);
    super.Dv();
    setEnableGesture(false);
    this.ckN.onForeground();
    AppMethodBeat.o(130634);
  }
  
  public final void Dw()
  {
    AppMethodBeat.i(130635);
    super.Dw();
    this.ckN.onBackground();
    AppMethodBeat.o(130635);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130631);
    this.ckN.c(paramString1, paramString2, 0);
    AppMethodBeat.o(130631);
  }
  
  public final boolean cV(String paramString)
  {
    return true;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(130632);
    super.cleanup();
    this.ckN.cleanup();
    AppMethodBeat.o(130632);
  }
  
  public final aa getCurrentPageView()
  {
    return this.ckN;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(130630);
    this.mURL = paramString;
    this.ckN.dk(paramString);
    AppMethodBeat.o(130630);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.mURL = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.e
 * JD-Core Version:    0.7.0.1
 */