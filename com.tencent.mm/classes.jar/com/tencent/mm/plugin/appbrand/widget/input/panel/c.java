package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.sdk.platformtools.ai;

public class c
{
  Context mHB;
  boolean mHR = false;
  b mHT;
  f mHU;
  int mHV;
  int mHW;
  
  public static int[] bBf()
  {
    AppMethodBeat.i(49955);
    Display localDisplay = ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(49955);
    return new int[] { i, j };
  }
  
  protected e bAO()
  {
    AppMethodBeat.i(49956);
    e locale = e.eXp();
    AppMethodBeat.o(49956);
    return locale;
  }
  
  public final a bBe()
  {
    AppMethodBeat.i(49954);
    if (this.mHT == null)
    {
      this.mHT = new b();
      this.mHT.mHB = this.mHB;
      this.mHT.setPanelManager(this);
    }
    b localb = this.mHT;
    AppMethodBeat.o(49954);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.c
 * JD-Core Version:    0.7.0.1
 */