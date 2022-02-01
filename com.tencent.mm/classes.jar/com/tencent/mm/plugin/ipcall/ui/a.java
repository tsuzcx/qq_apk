package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  String countryCode;
  String ihe;
  String ihf;
  private int vam;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.ihe = paramString1;
    this.countryCode = paramString2;
    this.vam = paramInt;
    this.ihf = paramString3;
  }
  
  public final int dhi()
  {
    AppMethodBeat.i(25567);
    if (this.vam == 0)
    {
      AppMethodBeat.o(25567);
      return 0;
    }
    String[] arrayOfString = IPCallCountryCodeScrollbar.vcu;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)this.vam)))
      {
        i = this.vam;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.a
 * JD-Core Version:    0.7.0.1
 */