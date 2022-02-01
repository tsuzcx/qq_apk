package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bg;

final class c$a
  implements u.c
{
  private boolean ehs = false;
  private final ad enm;
  private int moI;
  private final com.tencent.mm.plugin.appbrand.widget.dialog.b srd;
  private int sre = -1;
  
  private c$a(com.tencent.mm.plugin.appbrand.widget.dialog.b paramb, ad paramad)
  {
    this.srd = paramb;
    this.enm = paramad;
  }
  
  private int AW(int paramInt)
  {
    AppMethodBeat.i(325932);
    if (this.sre > 0)
    {
      paramInt = this.sre;
      AppMethodBeat.o(325932);
      return paramInt;
    }
    this.sre = ((com.tencent.mm.plugin.appbrand.utils.aq.d(this.enm)[1] + paramInt - this.enm.cEC().getHeight() - bg.bk(this.enm.getContext()) - this.srd.getContentView().getHeight()) / 2);
    if (this.sre <= paramInt) {
      this.sre = (paramInt + 12);
    }
    paramInt = this.sre;
    AppMethodBeat.o(325932);
    return paramInt;
  }
  
  private void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(325931);
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.srd.getContentView().getLayoutParams();
      localLayoutParams.addRule(14);
      localLayoutParams.removeRule(12);
      localLayoutParams.addRule(13);
      localLayoutParams.bottomMargin = 0;
      this.srd.getContentView().setLayoutParams(localLayoutParams);
      AppMethodBeat.o(325931);
      return;
    }
    if (paramInt > 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.srd.getContentView().getLayoutParams();
      localLayoutParams.removeRule(13);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      localLayoutParams.bottomMargin = AW(paramInt);
      this.srd.getContentView().setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(325931);
  }
  
  public final void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(325939);
    Log.d("MicroMsg.JsApiShowModal", "onKeyboardStateChanged shown:%b, keyboardHeight:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.moI) });
    if (paramBoolean == this.ehs)
    {
      AppMethodBeat.o(325939);
      return;
    }
    this.ehs = paramBoolean;
    p(paramBoolean, this.moI);
    AppMethodBeat.o(325939);
  }
  
  public final int getHeight()
  {
    return this.moI;
  }
  
  public final void mo(int paramInt)
  {
    AppMethodBeat.i(325936);
    Log.d("MicroMsg.JsApiShowModal", "refreshHeight height:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.moI != paramInt) && (this.ehs)) {
      p(true, paramInt);
    }
    this.moI = paramInt;
    AppMethodBeat.o(325936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.c.a
 * JD-Core Version:    0.7.0.1
 */