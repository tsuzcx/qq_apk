package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fqb;

public final class a
  extends c<cqc>
{
  private int fES;
  public m ojK;
  private int ojq;
  public final d rr;
  
  public a(String paramString, boolean paramBoolean, fqb paramfqb)
  {
    AppMethodBeat.i(121417);
    cqb localcqb = new cqb();
    localcqb.lVG = paramString;
    localcqb.TxA = paramfqb;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localcqb.TkK = i;
      paramString = new d.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.lBU = localcqb;
      paramString.lBV = new cqc();
      paramString = paramString.bgN();
      this.rr = paramString;
      c(paramString);
      this.ojq = paramfqb.UNQ;
      this.fES = com.tencent.mm.plugin.appbrand.dynamic.k.b.eu(this.ojq, paramfqb.TuP);
      AppMethodBeat.o(121417);
      return;
    }
  }
  
  private String getAppId()
  {
    AppMethodBeat.i(247605);
    String str = ((cqb)d.b.b(this.rr.lBR)).lVG;
    AppMethodBeat.o(247605);
    return str;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, cqc paramcqc)
  {
    AppMethodBeat.i(121418);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramcqc != null))
    {
      paramString = getAppId();
      this.ojK = ((com.tencent.mm.plugin.appbrand.widget.a.b)h.ae(com.tencent.mm.plugin.appbrand.widget.a.b.class)).bFH().a(paramString, this.fES, this.ojq, paramcqc);
      if (paramcqc.TxC != null)
      {
        String str = ((e)h.ae(e.class)).bFb().bo(paramString, this.fES);
        fnt localfnt = new fnt();
        localfnt.UMj = str;
        localfnt.RTb = paramcqc.TxC.RTb;
        if (this.fES == 10102)
        {
          localfnt.UMi = paramcqc.TxC.ULe;
          ((e)h.ae(e.class)).bFb().a(paramString, localfnt, this.fES);
          AppMethodBeat.o(121418);
          return;
        }
        if (this.fES == 10002)
        {
          localfnt.UMi = paramcqc.TxC.ULd;
          ((e)h.ae(e.class)).bFb().a(paramString, localfnt, this.fES);
        }
      }
      AppMethodBeat.o(121418);
      return;
    }
    j.bNj().agd(getAppId());
    this.ojK = ((com.tencent.mm.plugin.appbrand.widget.a.b)h.ae(com.tencent.mm.plugin.appbrand.widget.a.b.class)).bFH().W(getAppId(), this.fES, this.ojq);
    AppMethodBeat.o(121418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */