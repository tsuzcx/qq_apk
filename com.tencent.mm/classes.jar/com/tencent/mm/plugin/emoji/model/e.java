package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.di;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private di paw;
  public final Map<String, Integer> pax;
  
  public e()
  {
    AppMethodBeat.i(108585);
    this.pax = new HashMap();
    this.paw = new di();
    AppMethodBeat.o(108585);
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108586);
    this.paw.dcN.dcO = paramString1;
    this.paw.dcN.status = paramInt1;
    this.paw.dcN.progress = paramInt2;
    this.paw.dcN.dcP = paramString2;
    a.GpY.l(this.paw);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.pax.remove(paramString1);
        AppMethodBeat.o(108586);
        return;
      }
      this.pax.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(108586);
      return;
    }
    this.pax.remove(paramString1);
    AppMethodBeat.o(108586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.e
 * JD-Core Version:    0.7.0.1
 */