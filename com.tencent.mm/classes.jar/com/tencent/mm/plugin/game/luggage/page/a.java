package com.tencent.mm.plugin.game.luggage.page;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends GameWebPage
{
  public a(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(83116);
    aoJ();
    ((h)this.WFO).setShouldCleanPkgWhenDestroy(true);
    this.mContentView.setTag("game_float_view_tag");
    AppMethodBeat.o(83116);
  }
  
  public final void K(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180135);
    iR(false);
    AppMethodBeat.o(180135);
  }
  
  public final void aGf(String paramString)
  {
    AppMethodBeat.i(83119);
    this.WFP.setPullDownEnabled(false);
    AppMethodBeat.o(83119);
  }
  
  public final View aog()
  {
    AppMethodBeat.i(83117);
    View localView = super.aog();
    this.WFQ.setBackgroundColor(0);
    AppMethodBeat.o(83117);
    return localView;
  }
  
  public final boolean dhz()
  {
    return false;
  }
  
  public final void ehG() {}
  
  public final void fq(String paramString, int paramInt)
  {
    AppMethodBeat.i(83120);
    super.fq("微信游戏", paramInt);
    AppMethodBeat.o(83120);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(277059);
    iup();
    AppMethodBeat.o(277059);
    return true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83118);
    Log.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
    super.onForeground();
    fq("微信游戏", 0);
    this.WFP.iuC();
    AppMethodBeat.o(83118);
  }
  
  public final void wl(boolean paramBoolean)
  {
    AppMethodBeat.i(277043);
    super.wl(paramBoolean);
    AppMethodBeat.o(277043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.a
 * JD-Core Version:    0.7.0.1
 */