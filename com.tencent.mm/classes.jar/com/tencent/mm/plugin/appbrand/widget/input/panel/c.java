package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.e;
import com.tencent.mm.sdk.platformtools.aj;

public class c
{
  Context mfC;
  boolean mfS = false;
  b mfU;
  f mfV;
  int mfW;
  int mfX;
  
  public static int[] bug()
  {
    AppMethodBeat.i(49955);
    Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(49955);
    return new int[] { i, j };
  }
  
  protected e btP()
  {
    AppMethodBeat.i(49956);
    e locale = e.eHT();
    AppMethodBeat.o(49956);
    return locale;
  }
  
  public final a buf()
  {
    AppMethodBeat.i(49954);
    if (this.mfU == null)
    {
      this.mfU = new b();
      this.mfU.mfC = this.mfC;
      this.mfU.setPanelManager(this);
    }
    b localb = this.mfU;
    AppMethodBeat.o(49954);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.c
 * JD-Core Version:    0.7.0.1
 */