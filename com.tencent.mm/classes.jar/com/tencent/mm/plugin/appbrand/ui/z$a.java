package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z$a
{
  public int QC;
  public int mOffsetX;
  public int mOffsetY;
  private int mgf;
  public int mgg;
  private int[] mgh;
  public int mgj;
  
  public z$a()
  {
    AppMethodBeat.i(176776);
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mgf = 1;
    this.mgg = 12;
    this.mgj = Color.parseColor("#4d000000");
    this.QC = 18;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mgh = new int[1];
    this.mgh[0] = 0;
    AppMethodBeat.o(176776);
  }
  
  public final z bvI()
  {
    AppMethodBeat.i(176777);
    z localz = new z(this.mgf, this.mgh, this.mgg, this.mgj, this.QC, this.mOffsetX, this.mOffsetY, (byte)0);
    AppMethodBeat.o(176777);
    return localz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.z.a
 * JD-Core Version:    0.7.0.1
 */