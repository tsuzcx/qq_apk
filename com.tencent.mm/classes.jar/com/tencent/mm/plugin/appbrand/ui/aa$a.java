package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa$a
{
  public int PH;
  private int lEl;
  public int lEm;
  private int[] lEn;
  public int lEp;
  public int mOffsetX;
  public int mOffsetY;
  
  public aa$a()
  {
    AppMethodBeat.i(176776);
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.lEl = 1;
    this.lEm = 12;
    this.lEp = Color.parseColor("#4d000000");
    this.PH = 18;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.lEn = new int[1];
    this.lEn[0] = 0;
    AppMethodBeat.o(176776);
  }
  
  public final aa boN()
  {
    AppMethodBeat.i(176777);
    aa localaa = new aa(this.lEl, this.lEn, this.lEm, this.lEp, this.PH, this.mOffsetX, this.mOffsetY, (byte)0);
    AppMethodBeat.o(176777);
    return localaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aa.a
 * JD-Core Version:    0.7.0.1
 */