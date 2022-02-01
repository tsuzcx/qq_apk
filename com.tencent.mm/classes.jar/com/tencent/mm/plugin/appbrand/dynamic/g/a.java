package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.protocal.protobuf.dwt;

public final class a
  extends c<bkz>
{
  private int dkC;
  public k jnC;
  private int jnh;
  public final com.tencent.mm.al.b rr;
  
  public a(String paramString, boolean paramBoolean, dwt paramdwt)
  {
    AppMethodBeat.i(121417);
    bky localbky = new bky();
    localbky.hnC = paramString;
    localbky.DIQ = paramdwt;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbky.Dym = i;
      paramString = new b.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.gUU = localbky;
      paramString.gUV = new bkz();
      paramString = paramString.atI();
      this.rr = paramString;
      this.rr = paramString;
      this.jnh = paramdwt.EKF;
      this.dkC = com.tencent.mm.plugin.appbrand.dynamic.k.b.dI(this.jnh, paramdwt.DGx);
      AppMethodBeat.o(121417);
      return;
    }
  }
  
  private String getAppId()
  {
    return ((bky)this.rr.gUS.gUX).hnC;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, bkz parambkz)
  {
    AppMethodBeat.i(121418);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (parambkz != null))
    {
      paramString = getAppId();
      this.jnC = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aOE().a(paramString, this.dkC, this.jnh, parambkz);
      if (parambkz.DIS != null)
      {
        String str = ((e)g.ab(e.class)).aOk().aJ(paramString, this.dkC);
        duo localduo = new duo();
        localduo.EIX = str;
        localduo.CHC = parambkz.DIS.CHC;
        if (this.dkC == 10102)
        {
          localduo.EIW = parambkz.DIS.EIn;
          ((e)g.ab(e.class)).aOk().a(paramString, localduo, this.dkC);
          AppMethodBeat.o(121418);
          return;
        }
        if (this.dkC == 10002)
        {
          localduo.EIW = parambkz.DIS.EIm;
          ((e)g.ab(e.class)).aOk().a(paramString, localduo, this.dkC);
        }
      }
      AppMethodBeat.o(121418);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.aVk().GY(getAppId());
    this.jnC = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aOE().S(getAppId(), this.dkC, this.jnh);
    AppMethodBeat.o(121418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */