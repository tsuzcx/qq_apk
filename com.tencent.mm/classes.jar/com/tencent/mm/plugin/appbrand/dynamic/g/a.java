package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eck;

public final class a
  extends c<bov>
{
  private int dib;
  public k jNO;
  private int jNu;
  public final com.tencent.mm.ak.b rr;
  
  public a(String paramString, boolean paramBoolean, eck parameck)
  {
    AppMethodBeat.i(121417);
    bou localbou = new bou();
    localbou.hOf = paramString;
    localbou.Fel = parameck;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbou.ETI = i;
      paramString = new b.a();
      paramString.funcId = 1181;
      paramString.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
      paramString.hvt = localbou;
      paramString.hvu = new bov();
      paramString = paramString.aAz();
      this.rr = paramString;
      this.rr = paramString;
      this.jNu = parameck.GhR;
      this.dib = com.tencent.mm.plugin.appbrand.dynamic.k.b.dI(this.jNu, parameck.FbR);
      AppMethodBeat.o(121417);
      return;
    }
  }
  
  private String getAppId()
  {
    return ((bou)this.rr.hvr.hvw).hOf;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, bov parambov)
  {
    AppMethodBeat.i(121418);
    u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, getAppId() });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (parambov != null))
    {
      paramString = getAppId();
      this.jNO = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aVw().a(paramString, this.dib, this.jNu, parambov);
      if (parambov.Fen != null)
      {
        String str = ((e)g.ab(e.class)).aVa().aN(paramString, this.dib);
        eaf localeaf = new eaf();
        localeaf.Ggj = str;
        localeaf.Eae = parambov.Fen.Eae;
        if (this.dib == 10102)
        {
          localeaf.Ggi = parambov.Fen.Gfz;
          ((e)g.ab(e.class)).aVa().a(paramString, localeaf, this.dib);
          AppMethodBeat.o(121418);
          return;
        }
        if (this.dib == 10002)
        {
          localeaf.Ggi = parambov.Fen.Gfy;
          ((e)g.ab(e.class)).aVa().a(paramString, localeaf, this.dib);
        }
      }
      AppMethodBeat.o(121418);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.bci().Lc(getAppId());
    this.jNO = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aVw().R(getAppId(), this.dib, this.jNu);
    AppMethodBeat.o(121418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g.a
 * JD-Core Version:    0.7.0.1
 */