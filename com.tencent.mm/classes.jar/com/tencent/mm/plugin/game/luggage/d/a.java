package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends f
{
  public a(g paramg, Bundle paramBundle)
  {
    super(paramg, null, paramBundle);
    AppMethodBeat.i(83116);
    AR();
    ((e)getWebView()).setShouldCleanPkgWhenDestroy(true);
    AppMethodBeat.o(83116);
  }
  
  public final View Ar()
  {
    AppMethodBeat.i(83117);
    View localView = super.Ar();
    this.Clj.setBackgroundColor(0);
    AppMethodBeat.o(83117);
    return localView;
  }
  
  public final void B(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180135);
    gb(false);
    AppMethodBeat.o(180135);
  }
  
  public final void agX(String paramString)
  {
    AppMethodBeat.i(83119);
    this.Cli.setPullDownEnabled(false);
    AppMethodBeat.o(83119);
  }
  
  public final boolean bMn()
  {
    return false;
  }
  
  public final void cOK() {}
  
  public final void dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(83120);
    super.dt("微信游戏", paramInt);
    AppMethodBeat.o(83120);
  }
  
  public final void mG(boolean paramBoolean) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(83118);
    ac.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
    super.onForeground();
    dt("微信游戏", 0);
    k localk = this.Cli;
    localk.setPullDownEnabled(false);
    localk.Cme.setVisibility(8);
    localk.Cmd.setBackgroundColor(0);
    localk.setBackgroundColor(0);
    AppMethodBeat.o(83118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */