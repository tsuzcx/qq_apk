package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private dl pEg;
  public final Map<String, Integer> pEh;
  
  public e()
  {
    AppMethodBeat.i(108585);
    this.pEh = new HashMap();
    this.pEg = new dl();
    AppMethodBeat.o(108585);
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108586);
    this.pEg.doj.dok = paramString1;
    this.pEg.doj.status = paramInt1;
    this.pEg.doj.progress = paramInt2;
    this.pEg.doj.dol = paramString2;
    a.IbL.l(this.pEg);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.pEh.remove(paramString1);
        AppMethodBeat.o(108586);
        return;
      }
      this.pEh.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(108586);
      return;
    }
    this.pEh.remove(paramString1);
    AppMethodBeat.o(108586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.e
 * JD-Core Version:    0.7.0.1
 */