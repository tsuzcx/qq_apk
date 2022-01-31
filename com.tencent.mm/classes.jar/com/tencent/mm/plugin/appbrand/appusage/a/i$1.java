package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;

final class i$1
  implements Runnable
{
  i$1(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj) {}
  
  public final void run()
  {
    AppMethodBeat.i(129754);
    if (this.hdM == 1)
    {
      b.a(i.a(this.hdM, this.hdN, this.hdO, this.hdP).ado(), new i.1.1(this));
      AppMethodBeat.o(129754);
      return;
    }
    new i.1.2(this, this.hdM, this.hdN, this.hdO, this.hdP).adl();
    AppMethodBeat.o(129754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i.1
 * JD-Core Version:    0.7.0.1
 */