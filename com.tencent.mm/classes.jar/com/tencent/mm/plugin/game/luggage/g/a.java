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
    OB();
    ((h)this.PPv).setShouldCleanPkgWhenDestroy(true);
    this.mContentView.setTag("game_float_view_tag");
    AppMethodBeat.o(83116);
  }
  
  public final void G(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180135);
    hS(false);
    AppMethodBeat.o(180135);
  }
  
  public final View NW()
  {
    AppMethodBeat.i(83117);
    View localView = super.NW();
    this.PPx.setBackgroundColor(0);
    AppMethodBeat.o(83117);
    return localView;
  }
  
  public final void aJt(String paramString)
  {
    AppMethodBeat.i(83119);
    this.PPw.setPullDownEnabled(false);
    AppMethodBeat.o(83119);
  }
  
  public final boolean cDX()
  {
    return false;
  }
  
  public final void dwZ() {}
  
  public final void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(83120);
    super.eA("微信游戏", paramInt);
    AppMethodBeat.o(83120);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(232001);
    gUG();
    AppMethodBeat.o(232001);
    return true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(83118);
    Log.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
    super.onForeground();
    eA("微信游戏", 0);
    this.PPw.gUR();
    AppMethodBeat.o(83118);
  }
  
  public final void sg(boolean paramBoolean)
  {
    AppMethodBeat.i(232000);
    super.sg(paramBoolean);
    AppMethodBeat.o(232000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.a
 * JD-Core Version:    0.7.0.1
 */