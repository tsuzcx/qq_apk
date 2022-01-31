package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.cll;
import com.tencent.mm.protocal.c.cmh;
import com.tencent.mm.protocal.c.cnl;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
  extends com.tencent.mm.ah.a<atk>
{
  private int bOa;
  public final com.tencent.mm.ah.b dmK;
  public com.tencent.mm.plugin.appbrand.widget.j fWT;
  private int fWz;
  
  public a(String paramString, boolean paramBoolean, cnl paramcnl)
  {
    atj localatj = new atj();
    localatj.euK = paramString;
    localatj.tpb = paramcnl;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localatj.tgK = i;
      paramString = new b.a();
      paramString.ecG = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.ecH = localatj;
      paramString.ecI = new atk();
      paramString = paramString.Kt();
      this.dmK = paramString;
      this.dmK = paramString;
      this.fWz = paramcnl.uae;
      this.bOa = com.tencent.mm.plugin.appbrand.dynamic.k.b.bR(this.fWz, paramcnl.tmZ);
      return;
    }
  }
  
  private String getAppId()
  {
    return ((atj)this.dmK.ecE.ecN).euK;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, atk paramatk)
  {
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramatk != null))
    {
      paramString = getAppId();
      this.fWT = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.r(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aaV().a(paramString, this.bOa, this.fWz, paramatk);
      cmh localcmh;
      if (paramatk.tpd != null)
      {
        str = ((c)g.r(c.class)).aaG().aj(paramString, this.bOa);
        localcmh = new cmh();
        localcmh.tZl = str;
        localcmh.sCy = paramatk.tpd.sCy;
        if (this.bOa != 10102) {
          break label193;
        }
        localcmh.tZk = paramatk.tpd.tYH;
        ((c)g.r(c.class)).aaG().a(paramString, localcmh, this.bOa);
      }
      label193:
      while (this.bOa != 10002) {
        return;
      }
      localcmh.tZk = paramatk.tpd.tYG;
      ((c)g.r(c.class)).aaG().a(paramString, localcmh, this.bOa);
      return;
    }
    paramString = com.tencent.mm.plugin.appbrand.dynamic.j.aeZ();
    paramString.C(paramString.sZ(getAppId()), 626, 7);
    paramatk = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.r(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aaV();
    String str = getAppId();
    paramInt1 = this.bOa;
    paramInt2 = this.fWz;
    if (!bk.bl(str))
    {
      paramString = new com.tencent.mm.plugin.appbrand.widget.j();
      paramString.field_appIdHash = str.hashCode();
      paramString.field_appId = str;
      paramString.field_pkgType = paramInt1;
      paramString.field_widgetType = paramInt2;
      if (!paramatk.a(paramString, new String[] { "appId", "pkgType", "widgetType" })) {}
    }
    for (;;)
    {
      this.fWT = paramString;
      return;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */