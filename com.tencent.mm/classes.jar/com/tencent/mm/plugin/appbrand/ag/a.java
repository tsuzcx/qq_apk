package com.tencent.mm.plugin.appbrand.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.x;
import java.util.ArrayList;

public class a
  extends x
{
  public a(s params)
  {
    super(params);
  }
  
  public final v.a Us(String paramString)
  {
    AppMethodBeat.i(147753);
    paramString = new c.a(super.Us(paramString), bc.a(this.kAr.getRuntime(), paramString, this.kAr.Ot()), this.kAr.getAppId(), this.kAr.bsW());
    AppMethodBeat.o(147753);
    return paramString;
  }
  
  public final void a(ArrayList<v.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(147754);
    super.a(paramArrayList, paramString);
    paramArrayList.add(new c.a(this.kAr.Ou() + "shared_buffer.js", d.afA("wxa_library/shared_buffer.js"), this.kAr.getAppId(), this.kAr.bsW()));
    paramArrayList.add(new c.a(this.kAr.Ou() + "android.js", d.afA("wxa_library/android.js"), this.kAr.getAppId(), this.kAr.bsW()));
    paramArrayList.add(new c.a(this.kAr.Ou() + "lazy_load.js", d.afA("wxa_library/lazy_load.js"), this.kAr.getAppId(), this.kAr.bsW()));
    paramArrayList.add(new c.a(this.kAr.Ou() + "WAWorker.js", this.kAr.bqZ().UM("WAWorker.js"), this.kAr.getAppId(), this.kAr.bsW()));
    paramString = bc.b(this.kAr);
    paramArrayList.add(new v.a(this.kAr.Ou() + "WASourceMap.js", paramString));
    paramString = bc.getSysInfo();
    paramArrayList.add(new v.a(this.kAr.Ou() + "sourcemapSysinfo", paramString));
    AppMethodBeat.o(147754);
  }
  
  public v bti()
  {
    AppMethodBeat.i(147752);
    c localc = new c(this.dra);
    AppMethodBeat.o(147752);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.a
 * JD-Core Version:    0.7.0.1
 */