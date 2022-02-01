package com.tencent.d.d.a;

import android.text.TextUtils;
import com.tencent.d.d.b.e.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements b
{
  private final List<e.a> ZoV;
  
  public c()
  {
    AppMethodBeat.i(138344);
    this.ZoV = new ArrayList();
    AppMethodBeat.o(138344);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(138345);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(138345);
      return;
    }
    if ((TextUtils.isEmpty(parama.Zpd)) || (!"u:r:zygote:s0".equals(parama.Zpd)))
    {
      AppMethodBeat.o(138345);
      return;
    }
    if ((TextUtils.isEmpty(parama.name)) || ("zygote".equals(parama.name)) || ("zygote64".equals(parama.name)))
    {
      AppMethodBeat.o(138345);
      return;
    }
    new StringBuilder("JavaProcessAnalyzer match : ").append(parama.toString());
    h.iop();
    this.ZoV.add(parama);
    AppMethodBeat.o(138345);
  }
  
  public final boolean inU()
  {
    AppMethodBeat.i(138346);
    if (this.ZoV.size() > 0)
    {
      AppMethodBeat.o(138346);
      return true;
    }
    AppMethodBeat.o(138346);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.a.c
 * JD-Core Version:    0.7.0.1
 */