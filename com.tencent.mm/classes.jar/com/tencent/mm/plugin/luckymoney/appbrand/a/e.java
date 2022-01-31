package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.blq;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends a<blp, blq>
{
  public e(blp paramblp)
  {
    this.lKT = paramblp;
  }
  
  public final int HH()
  {
    return 2857;
  }
  
  protected final void bfl()
  {
    y.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
  }
  
  protected final void bfm()
  {
    y.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/requestwxaapphb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.e
 * JD-Core Version:    0.7.0.1
 */