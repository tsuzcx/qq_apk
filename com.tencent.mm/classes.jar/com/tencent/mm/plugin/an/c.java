package com.tencent.mm.plugin.an;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final SparseArray<b> PEU;
  
  static
  {
    AppMethodBeat.i(151584);
    PET = new c("INSTANCE");
    PEV = new c[] { PET };
    AppMethodBeat.o(151584);
  }
  
  private c()
  {
    AppMethodBeat.i(151582);
    this.PEU = new SparseArray();
    AppMethodBeat.o(151582);
  }
  
  public static boolean ajm(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(151583);
    this.PEU.put(paramb.getType(), paramb);
    AppMethodBeat.o(151583);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.an.c
 * JD-Core Version:    0.7.0.1
 */