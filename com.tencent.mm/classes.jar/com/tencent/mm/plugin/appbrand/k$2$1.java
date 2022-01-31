package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

final class k$2$1
  implements Runnable
{
  k$2$1(k.2 param2, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(86711);
    this.gQH.gQE.gPC.setVisibility(8);
    this.gQH.gQD.gQz.remove(this.gQH.gQE);
    this.gQH.gQD.gQA.put(this.gQH.gQE.mAppId, this.gQH.gQE);
    if (this.gQG != null)
    {
      this.gQH.gQD.k(this.gQG);
      this.gQH.gQD.j(this.gQG);
    }
    this.gQH.gQE.atv();
    if ((this.gQH.gQD.bFa) && (this.gQG != null)) {
      this.gQG.atw();
    }
    String str2 = this.gQH.gQE.mAppId;
    if (this.gQG == null) {}
    for (String str1 = "null";; str1 = this.gQG.mAppId)
    {
      com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", new Object[] { str2, str1, Boolean.valueOf(this.gQH.gQD.bFa) });
      AppMethodBeat.o(86711);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.2.1
 * JD-Core Version:    0.7.0.1
 */