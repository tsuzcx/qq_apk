package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class e
  extends u
{
  private ad cvo;
  private String mURL;
  
  public e(Context paramContext, x paramx)
  {
    super(paramContext, paramx);
    AppMethodBeat.i(130628);
    Log.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(130628);
  }
  
  public final View PL()
  {
    AppMethodBeat.i(130629);
    Object localObject = getContainer().cdJ();
    this.cvo = ((ad)localObject);
    localObject = ((ad)localObject).getContentView();
    AppMethodBeat.o(130629);
    return localObject;
  }
  
  public final void PM()
  {
    AppMethodBeat.i(130633);
    super.PM();
    this.cvo.onDestroy();
    AppMethodBeat.o(130633);
  }
  
  public final void PN()
  {
    AppMethodBeat.i(130634);
    super.PN();
    setEnableGesture(false);
    this.cvo.onForeground();
    AppMethodBeat.o(130634);
  }
  
  public final void PO()
  {
    AppMethodBeat.i(130635);
    super.PO();
    this.cvo.onBackground();
    AppMethodBeat.o(130635);
  }
  
  public final void a(String paramString, ca paramca)
  {
    AppMethodBeat.i(247322);
    this.mURL = paramString;
    this.cvo.c(paramString, paramca);
    AppMethodBeat.o(247322);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130631);
    this.cvo.ct(paramString1, paramString2);
    AppMethodBeat.o(130631);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(130632);
    super.cleanup();
    this.cvo.cleanup();
    AppMethodBeat.o(130632);
  }
  
  public final boolean dP(String paramString)
  {
    return true;
  }
  
  public final ad getCurrentPageView()
  {
    return this.cvo;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final ad iL(int paramInt)
  {
    AppMethodBeat.i(247328);
    if (this.cvo.getComponentId() == paramInt)
    {
      ad localad = this.cvo;
      AppMethodBeat.o(247328);
      return localad;
    }
    AppMethodBeat.o(247328);
    return null;
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