package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class e
  extends t
{
  private ac cwK;
  private String mURL;
  
  public e(Context paramContext, w paramw)
  {
    super(paramContext, paramw);
    AppMethodBeat.i(130628);
    Log.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(130628);
  }
  
  public final View MT()
  {
    AppMethodBeat.i(130629);
    Object localObject = getContainer().bQT();
    this.cwK = ((ac)localObject);
    localObject = ((ac)localObject).getContentView();
    AppMethodBeat.o(130629);
    return localObject;
  }
  
  public final void MU()
  {
    AppMethodBeat.i(130633);
    super.MU();
    this.cwK.onDestroy();
    AppMethodBeat.o(130633);
  }
  
  public final void MV()
  {
    AppMethodBeat.i(130634);
    super.MV();
    setEnableGesture(false);
    this.cwK.onForeground();
    AppMethodBeat.o(130634);
  }
  
  public final void MW()
  {
    AppMethodBeat.i(130635);
    super.MW();
    this.cwK.onBackground();
    AppMethodBeat.o(130635);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130631);
    this.cwK.c(paramString1, paramString2, 0);
    AppMethodBeat.o(130631);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(130632);
    super.cleanup();
    this.cwK.cleanup();
    AppMethodBeat.o(130632);
  }
  
  public final boolean dw(String paramString)
  {
    return true;
  }
  
  public final ac getCurrentPageView()
  {
    return this.cwK;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final ac hL(int paramInt)
  {
    AppMethodBeat.i(222887);
    if (this.cwK.getComponentId() == paramInt)
    {
      ac localac = this.cwK;
      AppMethodBeat.o(222887);
      return localac;
    }
    AppMethodBeat.o(222887);
    return null;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(130630);
    this.mURL = paramString;
    this.cwK.dE(paramString);
    AppMethodBeat.o(130630);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.mURL = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.e
 * JD-Core Version:    0.7.0.1
 */