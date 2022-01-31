package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;

final class q$2
  extends c
{
  q$2(q paramq) {}
  
  public final void enter()
  {
    AppMethodBeat.i(129353);
    super.enter();
    ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
    czn localczn = new czn();
    localczn.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[] { Integer.valueOf(q.a(this.gUt)) });
    localczn.version = q.a(this.gUt);
    localczn.cqq = q.c(this.gUt);
    localczn.xCO = 1;
    g.auM().a(localczn, new PInt());
    ba.a(localczn.url, localczn.version, new q.2.1(this));
    AppMethodBeat.o(129353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q.2
 * JD-Core Version:    0.7.0.1
 */