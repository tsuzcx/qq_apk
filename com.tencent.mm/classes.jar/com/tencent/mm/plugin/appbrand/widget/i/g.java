package com.tencent.mm.plugin.appbrand.widget.i;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.m.a;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.r;

public final class g
  extends d
{
  public g(String paramString, c paramc, r paramr)
  {
    super(paramString, paramc, paramr);
  }
  
  public final void aSq()
  {
    AppMethodBeat.i(87567);
    String str = this.jxc;
    a locala = (a)this.hxb.U(a.class);
    if ((locala.ism) && ((!j.c(locala.bDz, str)) || (!URLUtil.isHttpsUrl(str)))) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jxd.a("url not in domain list", this);
      AppMethodBeat.o(87567);
      return;
    }
    if (this.jxc != null) {
      b.acD().a(new g.1(this), this.jxc, null);
    }
    AppMethodBeat.o(87567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.g
 * JD-Core Version:    0.7.0.1
 */