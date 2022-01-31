package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l$c
{
  private int bKp;
  
  static
  {
    AppMethodBeat.i(129565);
    hbr = new c("WXAPP", 0, 1);
    hbs = new c("H5", 1, 2);
    hbt = new c[] { hbr, hbs };
    AppMethodBeat.o(129565);
  }
  
  private l$c(int paramInt)
  {
    this.bKp = paramInt;
  }
  
  public static c nt(int paramInt)
  {
    AppMethodBeat.i(129564);
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (paramInt == localc.bKp)
      {
        AppMethodBeat.o(129564);
        return localc;
      }
      i += 1;
    }
    AppMethodBeat.o(129564);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l.c
 * JD-Core Version:    0.7.0.1
 */