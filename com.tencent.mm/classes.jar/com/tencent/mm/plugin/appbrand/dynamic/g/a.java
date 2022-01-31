package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.dbt;

public final class a
  extends com.tencent.mm.ai.a<azp>
{
  private int cvs;
  private int hpZ;
  public k hqt;
  public final com.tencent.mm.ai.b rr;
  
  public a(String paramString, boolean paramBoolean, dbt paramdbt)
  {
    AppMethodBeat.i(10936);
    azo localazo = new azo();
    localazo.fKw = paramString;
    localazo.xoZ = paramdbt;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localazo.xfs = i;
      paramString = new b.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.fsX = localazo;
      paramString.fsY = new azp();
      paramString = paramString.ado();
      this.rr = paramString;
      this.rr = paramString;
      this.hpZ = paramdbt.yhX;
      this.cvs = com.tencent.mm.plugin.appbrand.dynamic.k.b.dc(this.hpZ, paramdbt.xmQ);
      AppMethodBeat.o(10936);
      return;
    }
  }
  
  private String getAppId()
  {
    return ((azo)this.rr.fsV.fta).fKw;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, azp paramazp)
  {
    AppMethodBeat.i(10937);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramazp != null))
    {
      paramString = getAppId();
      this.hqt = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.E(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auH().a(paramString, this.cvs, this.hpZ, paramazp);
      if (paramazp.xpb != null)
      {
        String str = ((d)g.E(d.class)).we().au(paramString, this.cvs);
        czy localczy = new czy();
        localczy.ygH = str;
        localczy.wwX = paramazp.xpb.wwX;
        if (this.cvs == 10102)
        {
          localczy.ygG = paramazp.xpb.yga;
          ((d)g.E(d.class)).we().a(paramString, localczy, this.cvs);
          AppMethodBeat.o(10937);
          return;
        }
        if (this.cvs == 10002)
        {
          localczy.ygG = paramazp.xpb.yfZ;
          ((d)g.E(d.class)).we().a(paramString, localczy, this.cvs);
        }
      }
      AppMethodBeat.o(10937);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.azD().Ba(getAppId());
    this.hqt = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.E(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auH().V(getAppId(), this.cvs, this.hpZ);
    AppMethodBeat.o(10937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */