package com.tencent.mm.plugin.appbrand.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.w;
import java.util.ArrayList;

public class a
  extends w
{
  public a(q paramq)
  {
    super(paramq);
  }
  
  public final v.a Dv(String paramString)
  {
    AppMethodBeat.i(147753);
    paramString = new b.a(super.Dv(paramString), ap.a(this.iDy.getRuntime(), paramString, this.iDy.DN()), this.iDy.getAppId(), this.iDy.aNv());
    AppMethodBeat.o(147753);
    return paramString;
  }
  
  public final void a(ArrayList<v.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(147754);
    super.a(paramArrayList, paramString);
    paramArrayList.add(new b.a(this.iDy.DO() + "shared_buffer.js", d.Ne("wxa_library/shared_buffer.js"), this.iDy.getAppId(), this.iDy.aNv()));
    paramArrayList.add(new b.a(this.iDy.DO() + "android.js", d.Ne("wxa_library/android.js"), this.iDy.getAppId(), this.iDy.aNv()));
    paramArrayList.add(new b.a(this.iDy.DO() + "WAWorker.js", this.iDy.aLC().DH("WAWorker.js"), this.iDy.getAppId(), this.iDy.aNv()));
    paramString = ap.b(this.iDy);
    paramArrayList.add(new v.a(this.iDy.DO() + "WASourceMap.js", paramString));
    paramString = ap.getSysInfo();
    paramArrayList.add(new v.a(this.iDy.DO() + "sourcemapSysinfo", paramString));
    AppMethodBeat.o(147754);
  }
  
  public v aNH()
  {
    AppMethodBeat.i(147752);
    b localb = new b(this.cQN);
    AppMethodBeat.o(147752);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a
 * JD-Core Version:    0.7.0.1
 */