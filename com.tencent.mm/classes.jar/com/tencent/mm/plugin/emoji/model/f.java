package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private dp rbq;
  public final Map<String, Integer> rbr;
  
  public f()
  {
    AppMethodBeat.i(108585);
    this.rbr = new HashMap();
    this.rbq = new dp();
    AppMethodBeat.o(108585);
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108586);
    this.rbq.dGC.productId = paramString1;
    this.rbq.dGC.status = paramInt1;
    this.rbq.dGC.progress = paramInt2;
    this.rbq.dGC.dGD = paramString2;
    EventCenter.instance.publish(this.rbq);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.rbr.remove(paramString1);
        AppMethodBeat.o(108586);
        return;
      }
      this.rbr.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(108586);
      return;
    }
    this.rbr.remove(paramString1);
    AppMethodBeat.o(108586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */