package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int gAx;
  public int oWb;
  public int uLB;
  
  public final String toString()
  {
    AppMethodBeat.i(25412);
    String str = String.format("IPCallUserInfo, userStatus: %d, syncKey: %d, memberId: %d", new Object[] { Integer.valueOf(this.gAx), Integer.valueOf(this.uLB), Integer.valueOf(this.oWb) });
    AppMethodBeat.o(25412);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.d
 * JD-Core Version:    0.7.0.1
 */