package com.tencent.mm.plugin.am;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final SparseArray<b> Jrv;
  
  static
  {
    AppMethodBeat.i(151584);
    Jru = new c("INSTANCE");
    Jrw = new c[] { Jru };
    AppMethodBeat.o(151584);
  }
  
  private c()
  {
    AppMethodBeat.i(151582);
    this.Jrv = new SparseArray();
    AppMethodBeat.o(151582);
  }
  
  public static boolean aeD(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(151583);
    this.Jrv.put(paramb.getType(), paramb);
    AppMethodBeat.o(151583);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.am.c
 * JD-Core Version:    0.7.0.1
 */