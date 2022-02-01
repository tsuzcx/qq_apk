package com.tencent.mm.plugin.appbrand.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v.b;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.be;
import java.util.ArrayList;

public class a
  extends ab
{
  public a(com.tencent.mm.plugin.appbrand.v paramv)
  {
    super(paramv);
  }
  
  public final void a(ArrayList<v.b> paramArrayList, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(237781);
    super.a(paramArrayList, paramString1, paramBoolean, paramString2);
    paramArrayList.add(new d.a(this.ntA.Rs() + "shared_buffer.js", com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/shared_buffer.js"), this.ntA.getAppId(), this.ntA.bDU()));
    paramArrayList.add(new d.a(this.ntA.Rs() + "android.js", com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/android.js"), this.ntA.getAppId(), this.ntA.bDU()));
    paramArrayList.add(new d.a(this.ntA.Rs() + "lazy_load.js", com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/lazy_load.js"), this.ntA.getAppId(), this.ntA.bDU()));
    paramArrayList.add(new d.a(this.ntA.Rs() + "WAWorker.js", this.ntA.bBP().acw("WAWorker.js"), this.ntA.getAppId(), this.ntA.bDU()));
    paramString1 = be.b(this.ntA);
    paramArrayList.add(new v.b(this.ntA.Rs() + "WASourceMap.js", paramString1));
    paramString1 = be.getSysInfo();
    paramArrayList.add(new v.b(this.ntA.Rs() + "sourcemapSysinfo", paramString1));
    AppMethodBeat.o(237781);
  }
  
  public final v.b acc(String paramString)
  {
    AppMethodBeat.i(147753);
    paramString = new d.a(super.acc(paramString), be.a(this.ntA.getRuntime(), paramString, this.ntA.Rr()), this.ntA.getAppId(), this.ntA.bDU());
    AppMethodBeat.o(147753);
    return paramString;
  }
  
  public com.tencent.mm.appbrand.v8.v bEe()
  {
    AppMethodBeat.i(147752);
    d locald = new d(bEg());
    AppMethodBeat.o(147752);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.a
 * JD-Core Version:    0.7.0.1
 */