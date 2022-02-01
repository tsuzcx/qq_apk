package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.z.d;
import java.util.ArrayList;

public class a
  extends w
{
  public a(q paramq)
  {
    super(paramq);
  }
  
  public final v.a Hy(String paramString)
  {
    AppMethodBeat.i(147753);
    paramString = new b.a(super.Hy(paramString), ap.a(this.jdy.getRuntime(), paramString, this.jdy.Dq()), this.jdy.getAppId(), this.jdy.aUl());
    AppMethodBeat.o(147753);
    return paramString;
  }
  
  public final void a(ArrayList<v.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(147754);
    super.a(paramArrayList, paramString);
    paramArrayList.add(new b.a(this.jdy.Dr() + "shared_buffer.js", d.Rn("wxa_library/shared_buffer.js"), this.jdy.getAppId(), this.jdy.aUl()));
    paramArrayList.add(new b.a(this.jdy.Dr() + "android.js", d.Rn("wxa_library/android.js"), this.jdy.getAppId(), this.jdy.aUl()));
    paramArrayList.add(new b.a(this.jdy.Dr() + "WAWorker.js", this.jdy.aSt().HL("WAWorker.js"), this.jdy.getAppId(), this.jdy.aUl()));
    paramString = ap.b(this.jdy);
    paramArrayList.add(new v.a(this.jdy.Dr() + "WASourceMap.js", paramString));
    paramString = ap.getSysInfo();
    paramArrayList.add(new v.a(this.jdy.Dr() + "sourcemapSysinfo", paramString));
    AppMethodBeat.o(147754);
  }
  
  public v aUx()
  {
    AppMethodBeat.i(147752);
    b localb = new b(this.cOi);
    AppMethodBeat.o(147752);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.a
 * JD-Core Version:    0.7.0.1
 */