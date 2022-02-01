package com.tencent.mm.plugin.appbrand.widget.input.d;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class c
{
  int uKZ;
  private final int[] uLd;
  int uLe;
  
  c()
  {
    AppMethodBeat.i(324612);
    this.uLd = new int[2];
    this.uKZ = -1;
    this.uLe = -1;
    AppMethodBeat.o(324612);
  }
  
  final int[] cSk()
  {
    AppMethodBeat.i(324615);
    int[] arrayOfInt = this.uLd;
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = localDisplay.getWidth();
    arrayOfInt[1] = localDisplay.getHeight();
    AppMethodBeat.o(324615);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.c
 * JD-Core Version:    0.7.0.1
 */