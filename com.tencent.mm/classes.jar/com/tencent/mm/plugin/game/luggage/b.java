package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.game.luggage.c.a;
import com.tencent.mm.plugin.game.luggage.c.a.c;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public final class b
  extends m
{
  private d kMl;
  private com.tencent.mm.plugin.game.luggage.c.a.b kMm;
  private com.tencent.mm.plugin.game.luggage.c.b kMn;
  private c kMo;
  
  public b(d paramd)
  {
    super(paramd);
    this.kMl = paramd;
  }
  
  private com.tencent.mm.plugin.game.luggage.c.a.b getH5GameMenuHelp()
  {
    if (this.kMm == null) {
      this.kMm = new com.tencent.mm.plugin.game.luggage.c.a.b(this.kMl.biV.getString("game_hv_menu_appid"));
    }
    return this.kMm;
  }
  
  public final void aYv()
  {
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).mController.hideVKB();
    }
    b.1 local1 = new b.1(this);
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      ai.l(local1, l);
      return;
    }
  }
  
  public final void aYw()
  {
    if (this.kMn != null) {
      this.kMn.cbq();
    }
    if (this.kMo != null)
    {
      c localc = this.kMo;
      if (localc.kNr != null) {
        localc.kNr.bFp();
      }
    }
  }
  
  protected final l getMenuHelp()
  {
    if (this.rcH == null) {
      this.rcH = new a();
    }
    return this.rcH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b
 * JD-Core Version:    0.7.0.1
 */