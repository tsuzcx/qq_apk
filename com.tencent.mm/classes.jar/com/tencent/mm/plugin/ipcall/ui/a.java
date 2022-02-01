package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  private int DSQ;
  String countryCode;
  String lSA;
  String lSz;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.lSz = paramString1;
    this.countryCode = paramString2;
    this.DSQ = paramInt;
    this.lSA = paramString3;
  }
  
  public final int eKa()
  {
    AppMethodBeat.i(25567);
    if (this.DSQ == 0)
    {
      AppMethodBeat.o(25567);
      return 0;
    }
    String[] arrayOfString = IPCallCountryCodeScrollbar.DUY;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)this.DSQ)))
      {
        i = this.DSQ;
        AppMethodBeat.o(25567);
        return i;
      }
      i += 1;
    }
    i = "#".charAt(0);
    AppMethodBeat.o(25567);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.a
 * JD-Core Version:    0.7.0.1
 */