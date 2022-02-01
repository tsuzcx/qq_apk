package com.tencent.mm.plugin.game.luggage.f;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends g
{
  public a(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(83116);
    Cq();
    ((f)getWebView()).setShouldCleanPkgWhenDestroy(true);
    this.mContentView.setTag("game_float_view_tag");
    AppMethodBeat.o(83116);
  }
  
  public final void A(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180135);
    gg(false);
    AppMethodBeat.o(180135);
  }
  
  public final View BQ()
  {
    AppMethodBeat.i(83117);
    View localView = super.BQ();
    this.DOv.setBackgroundColor(0);
    AppMethodBeat.o(83117);
    return localView;
  }
  
  public final void alu(String paramString)
  {
    AppMethodBeat.i(83119);
    this.DOu.setPullDownEnabled(false);
    AppMethodBeat.o(83119);
  }
  
  public final boolean bQO()
  {
    return false;
  }
  
  public final void cXk() {}
  
  public final void dJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(83120);
    super.dJ("微信游戏", paramInt);
    AppMethodBeat.o(83120);
  }
  
  public final void na(boolean paramBoolean) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(83118);
    ad.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
    super.onForeground();
    dJ("微信游戏", 0);
    l locall = this.DOu;
    locall.setPullDownEnabled(false);
    locall.DPt.setVisibility(8);
    locall.DPs.setBackgroundColor(0);
    locall.setBackgroundColor(0);
    AppMethodBeat.o(83118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.a
 * JD-Core Version:    0.7.0.1
 */