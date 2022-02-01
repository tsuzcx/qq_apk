package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends i
{
  public a(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(83116);
    LK();
    ((h)this.ITd).setShouldCleanPkgWhenDestroy(true);
    this.mContentView.setTag("game_float_view_tag");
    AppMethodBeat.o(83116);
  }
  
  public final void D(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180135);
    hb(false);
    AppMethodBeat.o(180135);
  }
  
  public final View Lf()
  {
    AppMethodBeat.i(83117);
    View localView = super.Lf();
    this.ITf.setBackgroundColor(0);
    AppMethodBeat.o(83117);
    return localView;
  }
  
  public final void azH(String paramString)
  {
    AppMethodBeat.i(83119);
    this.ITe.setPullDownEnabled(false);
    AppMethodBeat.o(83119);
  }
  
  public final boolean cpz()
  {
    return false;
  }
  
  public final void dTA() {}
  
  public final void ec(String paramString, int paramInt)
  {
    AppMethodBeat.i(83120);
    super.ec("微信游戏", paramInt);
    AppMethodBeat.o(83120);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(186932);
    gbL();
    AppMethodBeat.o(186932);
    return true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83118);
    Log.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
    super.onForeground();
    ec("微信游戏", 0);
    l locall = this.ITe;
    locall.setPullDownEnabled(false);
    locall.IUf.setVisibility(8);
    locall.IUe.setBackgroundColor(0);
    locall.setBackgroundColor(0);
    AppMethodBeat.o(83118);
  }
  
  public final void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(186931);
    super.pJ(paramBoolean);
    AppMethodBeat.o(186931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.a
 * JD-Core Version:    0.7.0.1
 */