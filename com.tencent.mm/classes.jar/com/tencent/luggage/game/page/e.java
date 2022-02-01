package com.tencent.luggage.game.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class e
  extends u
{
  private ad enm;
  private String mURL;
  
  public e(Context paramContext, x paramx)
  {
    super(paramContext, paramx);
    AppMethodBeat.i(130628);
    Log.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(130628);
  }
  
  public final ad L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(220163);
    if (this.enm.getComponentId() == paramInt)
    {
      ad localad = this.enm;
      AppMethodBeat.o(220163);
      return localad;
    }
    AppMethodBeat.o(220163);
    return null;
  }
  
  public final void a(String paramString, ad paramad)
  {
    AppMethodBeat.i(220154);
    paramString = new UnsupportedOperationException();
    AppMethodBeat.o(220154);
    throw paramString;
  }
  
  public final void a(String paramString, cb paramcb)
  {
    AppMethodBeat.i(220152);
    this.mURL = paramString;
    this.enm.c(paramString, paramcb);
    AppMethodBeat.o(220152);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130631);
    this.enm.cJ(paramString1, paramString2);
    AppMethodBeat.o(130631);
  }
  
  public final boolean a(String paramString, cb paramcb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220157);
    paramString = new UnsupportedOperationException();
    AppMethodBeat.o(220157);
    throw paramString;
  }
  
  public final void apV()
  {
    AppMethodBeat.i(130633);
    super.apV();
    this.enm.onDestroy();
    AppMethodBeat.o(130633);
  }
  
  public final void apW()
  {
    AppMethodBeat.i(130634);
    super.apW();
    setEnableGesture(false);
    this.enm.onForeground();
    AppMethodBeat.o(130634);
  }
  
  public final void apX()
  {
    AppMethodBeat.i(130635);
    super.apX();
    this.enm.onBackground();
    AppMethodBeat.o(130635);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(130632);
    super.cleanup();
    this.enm.cleanup();
    AppMethodBeat.o(130632);
  }
  
  public final View createContentView()
  {
    AppMethodBeat.i(130629);
    Object localObject = getContainer().aeI(this.mURL);
    this.enm = ((ad)localObject);
    localObject = ((ad)localObject).getContentView();
    AppMethodBeat.o(130629);
    return localObject;
  }
  
  public final boolean fa(String paramString)
  {
    return true;
  }
  
  public final ad getCurrentPageView()
  {
    return this.enm;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.mURL = paramString;
  }
  
  public final void setInitialUrl(String paramString)
  {
    this.mURL = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.e
 * JD-Core Version:    0.7.0.1
 */