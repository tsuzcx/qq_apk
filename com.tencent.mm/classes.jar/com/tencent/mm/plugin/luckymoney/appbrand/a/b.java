package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends a<bce, bcf>
{
  public b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    bce localbce = new bce();
    localbce.bOL = paramString1;
    localbce.txv = paramString2;
    localbce.txw = com.tencent.mm.bv.b.bk(paramArrayOfByte);
    this.lKT = localbce;
  }
  
  public final int HH()
  {
    return 2701;
  }
  
  protected final void bfl()
  {
    y.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
  }
  
  protected final void bfm()
  {
    y.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/openwxaapphb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.b
 * JD-Core Version:    0.7.0.1
 */