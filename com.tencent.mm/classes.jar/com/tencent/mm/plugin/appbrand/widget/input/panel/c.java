package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class c
{
  Context owO;
  boolean oxd = false;
  b oxf;
  f oxg;
  int oxh;
  int oxi;
  
  public static int[] ccp()
  {
    AppMethodBeat.i(49955);
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(49955);
    return new int[] { i, j };
  }
  
  protected e cbY()
  {
    AppMethodBeat.i(49956);
    e locale = e.gxR();
    AppMethodBeat.o(49956);
    return locale;
  }
  
  public final a cco()
  {
    AppMethodBeat.i(49954);
    if (this.oxf == null)
    {
      this.oxf = new b();
      this.oxf.owO = this.owO;
      this.oxf.setPanelManager(this);
    }
    b localb = this.oxf;
    AppMethodBeat.o(49954);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.c
 * JD-Core Version:    0.7.0.1
 */