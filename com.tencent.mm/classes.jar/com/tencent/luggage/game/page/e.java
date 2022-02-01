package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ac;

@SuppressLint({"ViewConstructor"})
public final class e
  extends r
{
  private aa caw;
  private String mURL;
  
  public e(Context paramContext, u paramu)
  {
    super(paramContext, paramu);
    AppMethodBeat.i(130628);
    ac.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(130628);
  }
  
  public final View BU()
  {
    AppMethodBeat.i(130629);
    Object localObject = getContainer().bqi();
    this.caw = ((aa)localObject);
    localObject = ((aa)localObject).jHO;
    AppMethodBeat.o(130629);
    return localObject;
  }
  
  public final void BV()
  {
    AppMethodBeat.i(130633);
    super.BV();
    this.caw.onDestroy();
    AppMethodBeat.o(130633);
  }
  
  public final void BW()
  {
    AppMethodBeat.i(130634);
    super.BW();
    setEnableGesture(false);
    this.caw.onForeground();
    AppMethodBeat.o(130634);
  }
  
  public final void BX()
  {
    AppMethodBeat.i(130635);
    super.BX();
    this.caw.onBackground();
    AppMethodBeat.o(130635);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130631);
    this.caw.c(paramString1, paramString2, 0);
    AppMethodBeat.o(130631);
  }
  
  public final boolean cb(String paramString)
  {
    return true;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(130632);
    super.cleanup();
    this.caw.cleanup();
    AppMethodBeat.o(130632);
  }
  
  public final aa getCurrentPageView()
  {
    return this.caw;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(130630);
    this.mURL = paramString;
    this.caw.ci(paramString);
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