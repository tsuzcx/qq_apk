package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.v;

@SuppressLint({"ViewConstructor"})
public final class e
  extends o
{
  private v bBK;
  private String mURL;
  
  public e(Context paramContext, r paramr)
  {
    super(paramContext, paramr);
    AppMethodBeat.i(140486);
    com.tencent.luggage.g.d.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    AppMethodBeat.o(140486);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(140489);
    this.bBK.c(paramString1, paramString2, 0);
    AppMethodBeat.o(140489);
  }
  
  public final boolean bV(String paramString)
  {
    return true;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(140490);
    super.cleanup();
    this.bBK.cleanup();
    AppMethodBeat.o(140490);
  }
  
  public final v getCurrentPageView()
  {
    return this.bBK;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140488);
    this.mURL = paramString;
    this.bBK.Em(paramString);
    AppMethodBeat.o(140488);
  }
  
  public final View vs()
  {
    AppMethodBeat.i(140487);
    Object localObject = getContainer().aJb();
    this.bBK = ((v)localObject);
    localObject = ((v)localObject).hmw;
    AppMethodBeat.o(140487);
    return localObject;
  }
  
  public final void vt()
  {
    AppMethodBeat.i(140491);
    super.vt();
    this.bBK.onDestroy();
    AppMethodBeat.o(140491);
  }
  
  public final void vu()
  {
    AppMethodBeat.i(140492);
    super.vu();
    setEnableGesture(false);
    this.bBK.onForeground();
    AppMethodBeat.o(140492);
  }
  
  public final void vv()
  {
    AppMethodBeat.i(140493);
    super.vv();
    this.bBK.onBackground();
    AppMethodBeat.o(140493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.e
 * JD-Core Version:    0.7.0.1
 */