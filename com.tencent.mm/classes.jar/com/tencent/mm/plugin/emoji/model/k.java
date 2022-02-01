package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.du;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  private du uEu;
  public final Map<String, Integer> uEv;
  
  public k()
  {
    AppMethodBeat.i(108585);
    this.uEv = new HashMap();
    this.uEu = new du();
    AppMethodBeat.o(108585);
  }
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108586);
    this.uEu.fzn.productId = paramString1;
    this.uEu.fzn.status = paramInt1;
    this.uEu.fzn.progress = paramInt2;
    this.uEu.fzn.fzo = paramString2;
    EventCenter.instance.publish(this.uEu);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.uEv.remove(paramString1);
        AppMethodBeat.o(108586);
        return;
      }
      this.uEv.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(108586);
      return;
    }
    this.uEv.remove(paramString1);
    AppMethodBeat.o(108586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.k
 * JD-Core Version:    0.7.0.1
 */