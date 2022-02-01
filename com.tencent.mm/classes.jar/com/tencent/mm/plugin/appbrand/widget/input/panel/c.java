package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.sdk.platformtools.aj;

public class c
{
  Context nhZ;
  boolean nip = false;
  b nir;
  f nis;
  int nit;
  int niu;
  
  public static int[] bFh()
  {
    AppMethodBeat.i(49955);
    Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(49955);
    return new int[] { i, j };
  }
  
  protected e bEQ()
  {
    AppMethodBeat.i(49956);
    e locale = e.fmZ();
    AppMethodBeat.o(49956);
    return locale;
  }
  
  public final a bFg()
  {
    AppMethodBeat.i(49954);
    if (this.nir == null)
    {
      this.nir = new b();
      this.nir.nhZ = this.nhZ;
      this.nir.setPanelManager(this);
    }
    b localb = this.nir;
    AppMethodBeat.o(49954);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.c
 * JD-Core Version:    0.7.0.1
 */