package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.ekh;

public final class a
  extends com.tencent.mm.ak.a<buc>
{
  private int duK;
  private int kkV;
  public k klp;
  public final com.tencent.mm.ak.b rr;
  
  public a(String paramString, boolean paramBoolean, ekh paramekh)
  {
    AppMethodBeat.i(121417);
    bub localbub = new bub();
    localbub.ikm = paramString;
    localbub.Hhp = paramekh;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbub.GWF = i;
      paramString = new b.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.hQF = localbub;
      paramString.hQG = new buc();
      paramString = paramString.aDS();
      this.rr = paramString;
      c(paramString);
      this.kkV = paramekh.Inm;
      this.duK = com.tencent.mm.plugin.appbrand.dynamic.k.b.dK(this.kkV, paramekh.HeR);
      AppMethodBeat.o(121417);
      return;
    }
  }
  
  private String getAppId()
  {
    return ((bub)this.rr.hQD.hQJ).ikm;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, buc parambuc)
  {
    AppMethodBeat.i(121418);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (parambuc != null))
    {
      paramString = getAppId();
      this.klp = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aZn().a(paramString, this.duK, this.kkV, parambuc);
      if (parambuc.Hhr != null)
      {
        String str = ((e)g.ab(e.class)).aYP().aS(paramString, this.duK);
        eia localeia = new eia();
        localeia.IlD = str;
        localeia.FYj = parambuc.Hhr.FYj;
        if (this.duK == 10102)
        {
          localeia.IlC = parambuc.Hhr.IkM;
          ((e)g.ab(e.class)).aYP().a(paramString, localeia, this.duK);
          AppMethodBeat.o(121418);
          return;
        }
        if (this.duK == 10002)
        {
          localeia.IlC = parambuc.Hhr.IkL;
          ((e)g.ab(e.class)).aYP().a(paramString, localeia, this.duK);
        }
      }
      AppMethodBeat.o(121418);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.bgu().Pe(getAppId());
    this.klp = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aZn().T(getAppId(), this.duK, this.kkV);
    AppMethodBeat.o(121418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */