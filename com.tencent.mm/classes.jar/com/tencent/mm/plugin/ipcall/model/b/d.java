package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int ggN;
  public int osF;
  public int tIO;
  
  public final String toString()
  {
    AppMethodBeat.i(25412);
    String str = String.format("IPCallUserInfo, userStatus: %d, syncKey: %d, memberId: %d", new Object[] { Integer.valueOf(this.ggN), Integer.valueOf(this.tIO), Integer.valueOf(this.osF) });
    AppMethodBeat.o(25412);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.d
 * JD-Core Version:    0.7.0.1
 */