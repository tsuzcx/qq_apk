package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.protocal.protobuf.eiq;

public final class a
  extends com.tencent.mm.al.a<bti>
{
  private int dtF;
  private int khF;
  public k khZ;
  public final com.tencent.mm.al.b rr;
  
  public a(String paramString, boolean paramBoolean, eiq parameiq)
  {
    AppMethodBeat.i(121417);
    bth localbth = new bth();
    localbth.iht = paramString;
    localbth.GNP = parameiq;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbth.GDf = i;
      paramString = new b.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.hNM = localbth;
      paramString.hNN = new bti();
      paramString = paramString.aDC();
      this.rr = paramString;
      c(paramString);
      this.khF = parameiq.HTf;
      this.dtF = com.tencent.mm.plugin.appbrand.dynamic.k.b.dK(this.khF, parameiq.GLq);
      AppMethodBeat.o(121417);
      return;
    }
  }
  
  private String getAppId()
  {
    return ((bth)this.rr.hNK.hNQ).iht;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, bti parambti)
  {
    AppMethodBeat.i(121418);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (parambti != null))
    {
      paramString = getAppId();
      this.khZ = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aYR().a(paramString, this.dtF, this.khF, parambti);
      if (parambti.GNR != null)
      {
        String str = ((e)g.ab(e.class)).aYu().aP(paramString, this.dtF);
        egj localegj = new egj();
        localegj.HRw = str;
        localegj.FFN = parambti.GNR.FFN;
        if (this.dtF == 10102)
        {
          localegj.HRv = parambti.GNR.HQF;
          ((e)g.ab(e.class)).aYu().a(paramString, localegj, this.dtF);
          AppMethodBeat.o(121418);
          return;
        }
        if (this.dtF == 10002)
        {
          localegj.HRv = parambti.GNR.HQE;
          ((e)g.ab(e.class)).aYu().a(paramString, localegj, this.dtF);
        }
      }
      AppMethodBeat.o(121418);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.bfM().Ow(getAppId());
    this.khZ = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aYR().T(getAppId(), this.dtF, this.khF);
    AppMethodBeat.o(121418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */