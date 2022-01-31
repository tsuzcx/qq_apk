package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.clw;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;

final class k$2
  extends c
{
  k$2(k paramk) {}
  
  public final void enter()
  {
    super.enter();
    y.i("MicroMsg.LibIncrementalTestCase[incremental]", "DownloadMockLibInfo enter");
    clw localclw = new clw();
    localclw.url = String.format(Locale.US, "https://res.servicewechat.com/weapp/public/commlib/%d.wxapkg", new Object[] { Integer.valueOf(k.a(this.fCg)) });
    localclw.version = k.a(this.fCg);
    localclw.bIW = k.c(this.fCg);
    localclw.tBf = 1;
    e.abb().a(localclw, new PInt());
    at.a(localclw.url, localclw.version, new k.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k.2
 * JD-Core Version:    0.7.0.1
 */