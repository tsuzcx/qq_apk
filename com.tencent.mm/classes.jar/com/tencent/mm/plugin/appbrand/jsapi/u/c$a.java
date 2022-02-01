package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ay;

final class c$a
  implements u.c
{
  private boolean cpE = false;
  private final ad cvo;
  private int jPS;
  private final com.tencent.mm.plugin.appbrand.widget.dialog.b pmj;
  private int pmk = -1;
  
  private c$a(com.tencent.mm.plugin.appbrand.widget.dialog.b paramb, ad paramad)
  {
    this.pmj = paramb;
    this.cvo = paramad;
  }
  
  private int AI(int paramInt)
  {
    AppMethodBeat.i(208943);
    if (this.pmk > 0)
    {
      paramInt = this.pmk;
      AppMethodBeat.o(208943);
      return paramInt;
    }
    this.pmk = ((com.tencent.mm.plugin.appbrand.utils.ak.f(this.cvo)[1] + paramInt - this.cvo.cdY().getHeight() - ay.aB(this.cvo.getContext()) - this.pmj.getContentView().getHeight()) / 2);
    if (this.pmk <= paramInt) {
      this.pmk = (paramInt + 12);
    }
    paramInt = this.pmk;
    AppMethodBeat.o(208943);
    return paramInt;
  }
  
  private void r(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(208942);
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.pmj.getContentView().getLayoutParams();
      localLayoutParams.addRule(14);
      localLayoutParams.removeRule(12);
      localLayoutParams.addRule(13);
      localLayoutParams.bottomMargin = 0;
      this.pmj.getContentView().setLayoutParams(localLayoutParams);
      AppMethodBeat.o(208942);
      return;
    }
    if (paramInt > 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.pmj.getContentView().getLayoutParams();
      localLayoutParams.removeRule(13);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      localLayoutParams.bottomMargin = AI(paramInt);
      this.pmj.getContentView().setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(208942);
  }
  
  public final void ca(boolean paramBoolean)
  {
    AppMethodBeat.i(208940);
    Log.d("MicroMsg.JsApiShowModal", "onKeyboardStateChanged shown:%b, keyboardHeight:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jPS) });
    if (paramBoolean == this.cpE)
    {
      AppMethodBeat.o(208940);
      return;
    }
    this.cpE = paramBoolean;
    r(paramBoolean, this.jPS);
    AppMethodBeat.o(208940);
  }
  
  public final int getHeight()
  {
    return this.jPS;
  }
  
  public final void iF(int paramInt)
  {
    AppMethodBeat.i(208938);
    Log.d("MicroMsg.JsApiShowModal", "refreshHeight height:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.jPS != paramInt) && (this.cpE)) {
      r(true, paramInt);
    }
    this.jPS = paramInt;
    AppMethodBeat.o(208938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.c.a
 * JD-Core Version:    0.7.0.1
 */