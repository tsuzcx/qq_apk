package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends f
{
  public a(g paramg, Bundle paramBundle)
  {
    super(paramg, null, paramBundle);
    AppMethodBeat.i(83116);
    Bn();
    ((e)getWebView()).setShouldCleanPkgWhenDestroy(true);
    AppMethodBeat.o(83116);
  }
  
  public final View AN()
  {
    AppMethodBeat.i(83117);
    View localView = super.AN();
    this.ASW.setBackgroundColor(0);
    AppMethodBeat.o(83117);
    return localView;
  }
  
  public final void B(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180135);
    fF(false);
    AppMethodBeat.o(180135);
  }
  
  public final void acf(String paramString)
  {
    AppMethodBeat.i(83119);
    this.ASV.setPullDownEnabled(false);
    AppMethodBeat.o(83119);
  }
  
  public final boolean bEZ()
  {
    return false;
  }
  
  public final void cBz() {}
  
  public final void dn(String paramString, int paramInt)
  {
    AppMethodBeat.i(83120);
    super.dn("微信游戏", paramInt);
    AppMethodBeat.o(83120);
  }
  
  public final void lN(boolean paramBoolean) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(83118);
    ad.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
    super.onForeground();
    dn("微信游戏", 0);
    k localk = this.ASV;
    localk.setPullDownEnabled(false);
    localk.ATR.setVisibility(8);
    localk.ATQ.setBackgroundColor(0);
    localk.setBackgroundColor(0);
    AppMethodBeat.o(83118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */