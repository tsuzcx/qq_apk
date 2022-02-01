package com.tencent.mm.plugin.appbrand.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.b;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bk;
import com.tencent.mm.plugin.appbrand.y;
import java.util.ArrayList;

public class a
  extends af
{
  public a(y paramy)
  {
    super(paramy);
  }
  
  public final v.b UE(String paramString)
  {
    AppMethodBeat.i(147753);
    paramString = new d.a(super.UE(paramString), bk.a(this.qsi.getRuntime(), paramString, this.qsi.arF()), this.qsi.getAppId(), this.qsi.cdi());
    AppMethodBeat.o(147753);
    return paramString;
  }
  
  public final void a(ArrayList<v.b> paramArrayList, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(317839);
    super.a(paramArrayList, paramString1, paramBoolean, paramString2);
    paramArrayList.add(new d.a(this.qsi.arG() + "shared_buffer.js", com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/shared_buffer.js"), this.qsi.getAppId(), this.qsi.cdi()));
    paramArrayList.add(new d.a(this.qsi.arG() + "android.js", com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/android.js"), this.qsi.getAppId(), this.qsi.cdi()));
    paramArrayList.add(new d.a(this.qsi.arG() + "lazy_load.js", com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/lazy_load.js"), this.qsi.getAppId(), this.qsi.cdi()));
    paramArrayList.add(new d.a(this.qsi.arG() + "WAWorker.js", this.qsi.cbl().UW("WAWorker.js"), this.qsi.getAppId(), this.qsi.cdi(), "WAWorker.js", "V" + this.qsi.cbl().cfG()));
    paramString1 = bk.b(this.qsi);
    paramArrayList.add(new v.b(this.qsi.arG() + "WASourceMap.js", paramString1));
    paramString1 = bk.getSysInfo();
    paramArrayList.add(new v.b(this.qsi.arG() + "sourcemapSysinfo", paramString1));
    AppMethodBeat.o(317839);
  }
  
  public v cdq()
  {
    AppMethodBeat.i(147752);
    d locald = new d(cdt());
    AppMethodBeat.o(147752);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai.a
 * JD-Core Version:    0.7.0.1
 */