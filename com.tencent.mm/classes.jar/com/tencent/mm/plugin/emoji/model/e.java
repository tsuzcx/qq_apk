package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private dm pKK;
  public final Map<String, Integer> pKL;
  
  public e()
  {
    AppMethodBeat.i(108585);
    this.pKL = new HashMap();
    this.pKK = new dm();
    AppMethodBeat.o(108585);
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108586);
    this.pKK.dpo.dpp = paramString1;
    this.pKK.dpo.status = paramInt1;
    this.pKK.dpo.progress = paramInt2;
    this.pKK.dpo.dpq = paramString2;
    a.IvT.l(this.pKK);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.pKL.remove(paramString1);
        AppMethodBeat.o(108586);
        return;
      }
      this.pKL.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(108586);
      return;
    }
    this.pKL.remove(paramString1);
    AppMethodBeat.o(108586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.e
 * JD-Core Version:    0.7.0.1
 */