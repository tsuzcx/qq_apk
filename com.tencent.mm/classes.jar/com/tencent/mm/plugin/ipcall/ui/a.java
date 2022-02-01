package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  String countryCode;
  String jbZ;
  String jca;
  private int ysM;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jbZ = paramString1;
    this.countryCode = paramString2;
    this.ysM = paramInt;
    this.jca = paramString3;
  }
  
  public final int ebc()
  {
    AppMethodBeat.i(25567);
    if (this.ysM == 0)
    {
      AppMethodBeat.o(25567);
      return 0;
    }
    String[] arrayOfString = IPCallCountryCodeScrollbar.yuU;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)this.ysM)))
      {
        i = this.ysM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.a
 * JD-Core Version:    0.7.0.1
 */