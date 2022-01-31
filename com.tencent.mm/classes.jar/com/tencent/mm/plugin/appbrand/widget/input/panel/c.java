package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.ah;

public class c
{
  Context jpJ;
  boolean jqa = false;
  b jqc;
  f jqd;
  int jqe;
  int jqf;
  
  public static int[] aMu()
  {
    AppMethodBeat.i(134331);
    Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(134331);
    return new int[] { i, j };
  }
  
  public final a aRO()
  {
    AppMethodBeat.i(134330);
    if (this.jqc == null)
    {
      this.jqc = new b();
      this.jqc.jpJ = this.jpJ;
      this.jqc.setPanelManager(this);
    }
    b localb = this.jqc;
    AppMethodBeat.o(134330);
    return localb;
  }
  
  protected e aRy()
  {
    AppMethodBeat.i(134332);
    e locale = e.dve();
    AppMethodBeat.o(134332);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.c
 * JD-Core Version:    0.7.0.1
 */