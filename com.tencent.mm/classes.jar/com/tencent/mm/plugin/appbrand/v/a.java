package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.t;
import com.tencent.mm.d.a.t.a;
import com.tencent.mm.plugin.appbrand.ag;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.w;
import java.util.ArrayList;

public class a
  extends w
{
  public a(r paramr)
  {
    super(paramr);
  }
  
  public t auk()
  {
    AppMethodBeat.i(140987);
    b localb = new b(this.ccw);
    AppMethodBeat.o(140987);
    return localb;
  }
  
  public final void b(ArrayList<t.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(140989);
    super.b(paramArrayList, paramString);
    paramArrayList.add(new b.a(this.gPA.wH() + "WAWorker.js", ax.c(this.gPA.getRuntime(), "WAWorker.js"), this.gPA.getAppId(), this.gPA.aud()));
    paramString = ag.getSysInfo();
    paramArrayList.add(new t.a(this.gPA.wH() + "sourcemapSysinfo", paramString));
    paramString = ax.c(this.gPA.getRuntime(), "WASourceMap.js");
    paramArrayList.add(new t.a(this.gPA.wH() + "WASourceMap.js", paramString));
    AppMethodBeat.o(140989);
  }
  
  public final t.a yh(String paramString)
  {
    AppMethodBeat.i(140988);
    paramString = new b.a(super.yh(paramString), ag.a(this.gPA.getRuntime(), paramString, this.gPA.wG()), this.gPA.getAppId(), this.gPA.aud());
    AppMethodBeat.o(140988);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a
 * JD-Core Version:    0.7.0.1
 */