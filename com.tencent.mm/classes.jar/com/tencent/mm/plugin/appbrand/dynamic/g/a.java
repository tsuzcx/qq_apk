package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.plugin.appbrand.widget.p;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.gjb;
import com.tencent.mm.protocal.protobuf.gks;
import com.tencent.mm.protocal.protobuf.gnk;

public final class a
  extends com.tencent.mm.am.b<dgw>
{
  private int hJK;
  private int rmS;
  public p rnm;
  public final c rr;
  
  public a(String paramString, boolean paramBoolean, gnk paramgnk)
  {
    AppMethodBeat.i(121417);
    dgv localdgv = new dgv();
    localdgv.oOI = paramString;
    localdgv.aaMh = paramgnk;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localdgv.aayr = i;
      paramString = new c.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.otE = localdgv;
      paramString.otF = new dgw();
      paramString = paramString.bEF();
      this.rr = paramString;
      c(paramString);
      this.rmS = paramgnk.acis;
      this.hJK = com.tencent.mm.plugin.appbrand.dynamic.k.b.fn(this.rmS, paramgnk.aaJu);
      AppMethodBeat.o(121417);
      return;
    }
  }
  
  private String getAppId()
  {
    AppMethodBeat.i(324803);
    String str = ((dgv)c.b.b(this.rr.otB)).oOI;
    AppMethodBeat.o(324803);
    return str;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, dgw paramdgw)
  {
    AppMethodBeat.i(121418);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramdgw != null))
    {
      paramString = getAppId();
      this.rnm = ((com.tencent.mm.plugin.appbrand.widget.b.b)h.ax(com.tencent.mm.plugin.appbrand.widget.b.b.class)).cfe().a(paramString, this.hJK, this.rmS, paramdgw);
      if (paramdgw.aaMj != null)
      {
        String str = ((e)h.ax(e.class)).ceo().bF(paramString, this.hJK);
        gks localgks = new gks();
        localgks.acgD = str;
        localgks.YQB = paramdgw.aaMj.YQB;
        if (this.hJK == 10102)
        {
          localgks.acgC = paramdgw.aaMj.acfr;
          ((e)h.ax(e.class)).ceo().a(paramString, localgks, this.hJK);
          AppMethodBeat.o(121418);
          return;
        }
        if (this.hJK == 10002)
        {
          localgks.acgC = paramdgw.aaMj.acfq;
          ((e)h.ax(e.class)).ceo().a(paramString, localgks, this.hJK);
        }
      }
      AppMethodBeat.o(121418);
      return;
    }
    j.cny().YZ(getAppId());
    this.rnm = ((com.tencent.mm.plugin.appbrand.widget.b.b)h.ax(com.tencent.mm.plugin.appbrand.widget.b.b.class)).cfe().aa(getAppId(), this.hJK, this.rmS);
    AppMethodBeat.o(121418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */