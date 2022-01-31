package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.db;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private db lhi;
  public final Map<String, Integer> lhj;
  
  public d()
  {
    AppMethodBeat.i(53045);
    this.lhj = new HashMap();
    this.lhi = new db();
    AppMethodBeat.o(53045);
  }
  
  public final void g(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(53046);
    this.lhi.cqw.cqx = paramString1;
    this.lhi.cqw.status = paramInt1;
    this.lhi.cqw.progress = paramInt2;
    this.lhi.cqw.cqy = paramString2;
    a.ymk.l(this.lhi);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.lhj.remove(paramString1);
        AppMethodBeat.o(53046);
        return;
      }
      this.lhj.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(53046);
      return;
    }
    this.lhj.remove(paramString1);
    AppMethodBeat.o(53046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */