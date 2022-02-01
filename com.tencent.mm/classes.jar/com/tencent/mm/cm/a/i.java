package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(231121);
    agCH = new i("NORMAL", 0);
    agCI = new i("ROTATION_90", 1);
    agCJ = new i("ROTATION_180", 2);
    agCK = new i("ROTATION_270", 3);
    agCL = new i[] { agCH, agCI, agCJ, agCK };
    AppMethodBeat.o(231121);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.i
 * JD-Core Version:    0.7.0.1
 */