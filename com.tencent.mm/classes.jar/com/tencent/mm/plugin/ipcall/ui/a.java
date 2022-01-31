package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  String countryCode;
  String fHT;
  String fHU;
  private int nQl;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.fHT = paramString1;
    this.countryCode = paramString2;
    this.nQl = paramInt;
    this.fHU = paramString3;
  }
  
  public final int bJY()
  {
    AppMethodBeat.i(21952);
    if (this.nQl == 0)
    {
      AppMethodBeat.o(21952);
      return 0;
    }
    String[] arrayOfString = IPCallCountryCodeScrollbar.nSu;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)this.nQl)))
      {
        i = this.nQl;
        AppMethodBeat.o(21952);
        return i;
      }
      i += 1;
    }
    i = "#".charAt(0);
    AppMethodBeat.o(21952);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.a
 * JD-Core Version:    0.7.0.1
 */