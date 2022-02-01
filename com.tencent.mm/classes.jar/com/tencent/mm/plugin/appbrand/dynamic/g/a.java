package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.protocal.protobuf.ffa;

public final class a
  extends c<chg>
{
  private int dMe;
  private int loG;
  public com.tencent.mm.plugin.appbrand.widget.j lpa;
  public final d rr;
  
  public a(String paramString, boolean paramBoolean, ffa paramffa)
  {
    AppMethodBeat.i(121417);
    chf localchf = new chf();
    localchf.jfi = paramString;
    localchf.MmF = paramffa;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localchf.Mbn = i;
      paramString = new d.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.iLN = localchf;
      paramString.iLO = new chg();
      paramString = paramString.aXF();
      this.rr = paramString;
      c(paramString);
      this.loG = paramffa.NAo;
      this.dMe = com.tencent.mm.plugin.appbrand.dynamic.k.b.dV(this.loG, paramffa.MjZ);
      AppMethodBeat.o(121417);
      return;
    }
  }
  
  private String getAppId()
  {
    return ((chf)this.rr.iLK.iLR).jfi;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, chg paramchg)
  {
    AppMethodBeat.i(121418);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramchg != null))
    {
      paramString = getAppId();
      this.lpa = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buE().a(paramString, this.dMe, this.loG, paramchg);
      if (paramchg.MmH != null)
      {
        String str = ((e)g.af(e.class)).bub().aX(paramString, this.dMe);
        fcs localfcs = new fcs();
        localfcs.NyF = str;
        localfcs.KSa = paramchg.MmH.KSa;
        if (this.dMe == 10102)
        {
          localfcs.NyE = paramchg.MmH.NxN;
          ((e)g.af(e.class)).bub().a(paramString, localfcs, this.dMe);
          AppMethodBeat.o(121418);
          return;
        }
        if (this.dMe == 10002)
        {
          localfcs.NyE = paramchg.MmH.NxM;
          ((e)g.af(e.class)).bub().a(paramString, localfcs, this.dMe);
        }
      }
      AppMethodBeat.o(121418);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.bBN().Yp(getAppId());
    this.lpa = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buE().U(getAppId(), this.dMe, this.loG);
    AppMethodBeat.o(121418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */