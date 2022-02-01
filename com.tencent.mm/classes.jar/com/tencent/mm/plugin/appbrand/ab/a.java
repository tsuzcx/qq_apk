package com.tencent.mm.plugin.appbrand.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.ar;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y.d;
import java.util.ArrayList;

public class a
  extends w
{
  public a(r paramr)
  {
    super(paramr);
  }
  
  public final v.a Lk(String paramString)
  {
    AppMethodBeat.i(147753);
    paramString = new c.a(super.Lk(paramString), ar.a(this.jzD.getRuntime(), paramString, this.jzD.ER()), this.jzD.getAppId(), this.jzD.aXP());
    AppMethodBeat.o(147753);
    return paramString;
  }
  
  public final void a(ArrayList<v.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(147754);
    super.a(paramArrayList, paramString);
    paramArrayList.add(new c.a(this.jzD.ES() + "shared_buffer.js", d.VE("wxa_library/shared_buffer.js"), this.jzD.getAppId(), this.jzD.aXP()));
    paramArrayList.add(new c.a(this.jzD.ES() + "android.js", d.VE("wxa_library/android.js"), this.jzD.getAppId(), this.jzD.aXP()));
    paramArrayList.add(new c.a(this.jzD.ES() + "WAWorker.js", this.jzD.aWe().LD("WAWorker.js"), this.jzD.getAppId(), this.jzD.aXP()));
    paramString = ar.b(this.jzD);
    paramArrayList.add(new v.a(this.jzD.ES() + "WASourceMap.js", paramString));
    paramString = ar.getSysInfo();
    paramArrayList.add(new v.a(this.jzD.ES() + "sourcemapSysinfo", paramString));
    AppMethodBeat.o(147754);
  }
  
  public v aYc()
  {
    AppMethodBeat.i(147752);
    c localc = new c(this.daw);
    AppMethodBeat.o(147752);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.a
 * JD-Core Version:    0.7.0.1
 */