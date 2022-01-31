package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends f
{
  public a(g paramg, Bundle paramBundle)
  {
    super(paramg, null, paramBundle);
    AppMethodBeat.i(135911);
    uy();
    ((e)getWebView()).setShouldCleanPkgWhenDestroy(true);
    AppMethodBeat.o(135911);
  }
  
  public final void PS(String paramString)
  {
    AppMethodBeat.i(135914);
    this.uRl.setPullDownEnabled(false);
    AppMethodBeat.o(135914);
  }
  
  public final boolean aYi()
  {
    return false;
  }
  
  public final void bFr() {}
  
  public final void bFs()
  {
    AppMethodBeat.i(135916);
    finish();
    AppMethodBeat.o(135916);
  }
  
  public final void cr(String paramString, int paramInt)
  {
    AppMethodBeat.i(135915);
    super.cr("微信游戏", paramInt);
    AppMethodBeat.o(135915);
  }
  
  public final void ib(boolean paramBoolean) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(135913);
    ab.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
    super.onForeground();
    cr("微信游戏", 0);
    k localk = this.uRl;
    localk.setPullDownEnabled(false);
    localk.uSp.setVisibility(8);
    localk.uSo.setBackgroundColor(0);
    localk.setBackgroundColor(0);
    AppMethodBeat.o(135913);
  }
  
  public final View tZ()
  {
    AppMethodBeat.i(135912);
    View localView = super.tZ();
    this.uRm.setBackgroundColor(0);
    AppMethodBeat.o(135912);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */