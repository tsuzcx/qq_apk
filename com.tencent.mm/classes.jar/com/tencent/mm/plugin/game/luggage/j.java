package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.y;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public final class j
  extends d
{
  public j(g paramg, Bundle paramBundle)
  {
    super(paramg, null, paramBundle);
    if (this.biU != null) {
      this.biU.setEnableGesture(false);
    }
  }
  
  protected final void EJ(String paramString)
  {
    this.rbB.setPullDownEnabled(false);
  }
  
  protected final void aYC() {}
  
  protected final boolean aYK()
  {
    return false;
  }
  
  protected final void gv(boolean paramBoolean) {}
  
  protected final void pY()
  {
    y.i("MicroMsg.TransParentWebPage", "onForeground");
    super.pY();
    l locall = this.rbB;
    locall.setPullDownEnabled(false);
    locall.rcD.setVisibility(8);
    locall.rcC.setBackgroundColor(0);
    locall.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.j
 * JD-Core Version:    0.7.0.1
 */