package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.aq;
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
  
  public final v.a KK(String paramString)
  {
    AppMethodBeat.i(147753);
    paramString = new b.a(super.KK(paramString), aq.a(this.jwH.getRuntime(), paramString, this.jwH.EP()), this.jwH.getAppId(), this.jwH.aXu());
    AppMethodBeat.o(147753);
    return paramString;
  }
  
  public final void a(ArrayList<v.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(147754);
    super.a(paramArrayList, paramString);
    paramArrayList.add(new b.a(this.jwH.EQ() + "shared_buffer.js", d.UT("wxa_library/shared_buffer.js"), this.jwH.getAppId(), this.jwH.aXu()));
    paramArrayList.add(new b.a(this.jwH.EQ() + "android.js", d.UT("wxa_library/android.js"), this.jwH.getAppId(), this.jwH.aXu()));
    paramArrayList.add(new b.a(this.jwH.EQ() + "WAWorker.js", this.jwH.aVF().Ld("WAWorker.js"), this.jwH.getAppId(), this.jwH.aXu()));
    paramString = aq.b(this.jwH);
    paramArrayList.add(new v.a(this.jwH.EQ() + "WASourceMap.js", paramString));
    paramString = aq.getSysInfo();
    paramArrayList.add(new v.a(this.jwH.EQ() + "sourcemapSysinfo", paramString));
    AppMethodBeat.o(147754);
  }
  
  public v aXJ()
  {
    AppMethodBeat.i(147752);
    b localb = new b(this.cZy);
    AppMethodBeat.o(147752);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.a
 * JD-Core Version:    0.7.0.1
 */