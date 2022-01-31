package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bic;

public final class c
  extends a<bib, bic>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    bib localbib = new bib();
    localbib.bOL = paramString1;
    localbib.txv = paramString2;
    localbib.offset = paramInt;
    this.lKT = localbib;
  }
  
  protected final int HH()
  {
    return 2949;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/querywxaapphbdetail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */