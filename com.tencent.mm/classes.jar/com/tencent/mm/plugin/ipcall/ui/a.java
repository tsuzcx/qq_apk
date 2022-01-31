package com.tencent.mm.plugin.ipcall.ui;

final class a
{
  String countryCode;
  String esg;
  String esh;
  private int lsS;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.esg = paramString1;
    this.countryCode = paramString2;
    this.lsS = paramInt;
    this.esh = paramString3;
  }
  
  public final int bcP()
  {
    if (this.lsS == 0) {
      return 0;
    }
    String[] arrayOfString = IPCallCountryCodeScrollbar.lvd;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(String.valueOf((char)this.lsS))) {
        return this.lsS;
      }
      i += 1;
    }
    return "#".charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.a
 * JD-Core Version:    0.7.0.1
 */