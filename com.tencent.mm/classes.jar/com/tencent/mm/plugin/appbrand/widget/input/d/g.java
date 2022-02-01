package com.tencent.mm.plugin.appbrand.widget.input.d;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class g
  implements f
{
  private int EVk;
  private final int[] Eje;
  private int rzJ;
  
  g()
  {
    AppMethodBeat.i(293205);
    this.Eje = new int[2];
    this.rzJ = -1;
    this.EVk = -1;
    AppMethodBeat.o(293205);
  }
  
  private int[] hcp()
  {
    AppMethodBeat.i(293206);
    int[] arrayOfInt = this.Eje;
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = localDisplay.getWidth();
    arrayOfInt[1] = localDisplay.getHeight();
    AppMethodBeat.o(293206);
    return arrayOfInt;
  }
  
  public final int getPanelDefaultHeightInPort()
  {
    AppMethodBeat.i(293208);
    if (this.EVk < 0) {
      this.EVk = KeyBoardUtil.getValidPanelHeight(MMApplicationContext.getContext());
    }
    if (this.EVk > 0)
    {
      i = this.EVk;
      AppMethodBeat.o(293208);
      return i;
    }
    int[] arrayOfInt = hcp();
    int i = Math.max(arrayOfInt[0], arrayOfInt[1]) / 2 - MMApplicationContext.getContext().getResources().getDimensionPixelSize(au.d.ChattingFootEditMinHeigh);
    this.EVk = i;
    AppMethodBeat.o(293208);
    return i;
  }
  
  public final int getPanelHeightInLandscape()
  {
    AppMethodBeat.i(293207);
    int[] arrayOfInt = hcp();
    if ((this.rzJ > 0) && (this.rzJ < arrayOfInt[1]))
    {
      i = this.rzJ;
      AppMethodBeat.o(293207);
      return i;
    }
    int i = Math.min(arrayOfInt[0], arrayOfInt[1]) / 2;
    int j = MMApplicationContext.getResources().getDimensionPixelSize(au.d.ChattingFootEditMinHeigh);
    AppMethodBeat.o(293207);
    return i - j;
  }
  
  public final void setForceHeight(int paramInt)
  {
    this.rzJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.g
 * JD-Core Version:    0.7.0.1
 */