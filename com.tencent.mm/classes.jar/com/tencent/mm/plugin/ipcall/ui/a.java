package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  private int JKa;
  String countryCode;
  String oLl;
  String oLm;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.oLl = paramString1;
    this.countryCode = paramString2;
    this.JKa = paramInt;
    this.oLm = paramString3;
  }
  
  public final int fSa()
  {
    AppMethodBeat.i(25567);
    if (this.JKa == 0)
    {
      AppMethodBeat.o(25567);
      return 0;
    }
    String[] arrayOfString = IPCallCountryCodeScrollbar.JMh;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)this.JKa)))
      {
        i = this.JKa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.a
 * JD-Core Version:    0.7.0.1
 */