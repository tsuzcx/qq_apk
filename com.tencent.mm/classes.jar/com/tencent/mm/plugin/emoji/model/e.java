package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private dh owW;
  public final Map<String, Integer> owX;
  
  public e()
  {
    AppMethodBeat.i(108585);
    this.owX = new HashMap();
    this.owW = new dh();
    AppMethodBeat.o(108585);
  }
  
  public final void g(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108586);
    this.owW.dfs.dft = paramString1;
    this.owW.dfs.status = paramInt1;
    this.owW.dfs.progress = paramInt2;
    this.owW.dfs.dfu = paramString2;
    a.ESL.l(this.owW);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.owX.remove(paramString1);
        AppMethodBeat.o(108586);
        return;
      }
      this.owX.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(108586);
      return;
    }
    this.owX.remove(paramString1);
    AppMethodBeat.o(108586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.e
 * JD-Core Version:    0.7.0.1
 */