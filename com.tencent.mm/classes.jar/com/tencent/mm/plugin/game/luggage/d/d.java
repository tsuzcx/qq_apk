package com.tencent.mm.plugin.game.luggage.d;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.c.a.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends com.tencent.mm.plugin.webview.luggage.l
{
  private f njV;
  private com.tencent.mm.plugin.game.luggage.c.a.b nki;
  private com.tencent.mm.plugin.game.luggage.c.b nkj;
  private c nkk;
  
  public d(f paramf)
  {
    super(paramf);
    this.njV = paramf;
  }
  
  private com.tencent.mm.plugin.game.luggage.c.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(135920);
    if (this.nki == null) {
      this.nki = new com.tencent.mm.plugin.game.luggage.c.a.b(this.njV.bzu.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.c.a.b localb = this.nki;
    AppMethodBeat.o(135920);
    return localb;
  }
  
  public final void bFt()
  {
    AppMethodBeat.i(135921);
    if (!(this.njV instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!this.njV.byJ.un().aY(bool)) {
        ((Activity)this.mContext).finish();
      }
      AppMethodBeat.o(135921);
      return;
    }
  }
  
  public final void bFu()
  {
    AppMethodBeat.i(135922);
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).hideVKBHavingResult();
    }
    d.1 local1 = new d.1(this);
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      al.p(local1, l);
      AppMethodBeat.o(135922);
      return;
    }
  }
  
  public final void bFv()
  {
    AppMethodBeat.i(135923);
    if (this.nkj != null) {
      this.nkj.dbu();
    }
    if (this.nkk != null)
    {
      c localc = this.nkk;
      if (localc.njX != null) {
        localc.njX.cre();
      }
    }
    AppMethodBeat.o(135923);
  }
  
  public final com.tencent.mm.plugin.webview.luggage.b.l getMenuHelp()
  {
    AppMethodBeat.i(135919);
    if (this.uSv == null) {
      this.uSv = new com.tencent.mm.plugin.game.luggage.c.a();
    }
    com.tencent.mm.plugin.webview.luggage.b.l locall = this.uSv;
    AppMethodBeat.o(135919);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.d
 * JD-Core Version:    0.7.0.1
 */