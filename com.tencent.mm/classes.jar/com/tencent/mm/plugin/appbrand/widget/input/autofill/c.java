package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.k.a;

public final class c
{
  final ab joU;
  final e joV;
  public final k.a jph;
  public v jpi;
  int jpj;
  boolean jpk;
  
  c(ab paramab, e parame)
  {
    AppMethodBeat.i(123901);
    this.jph = new c.1(this);
    this.jpj = -2147483648;
    this.jpk = false;
    this.joU = paramab;
    this.joV = parame;
    AppMethodBeat.o(123901);
  }
  
  final void qD(int paramInt)
  {
    AppMethodBeat.i(123902);
    AutoFillListPopupWindowBase.a locala = this.joV.jpo;
    if (locala == null)
    {
      AppMethodBeat.o(123902);
      return;
    }
    if (!this.joV.aht.isShowing())
    {
      AppMethodBeat.o(123902);
      return;
    }
    if ((1 == paramInt) && (this.jpk))
    {
      this.jpj = -2147483648;
      this.jpk = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new c.3(this, locala, paramInt));
    AppMethodBeat.o(123902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c
 * JD-Core Version:    0.7.0.1
 */