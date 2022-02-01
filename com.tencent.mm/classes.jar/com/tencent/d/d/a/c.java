package com.tencent.d.d.a;

import android.text.TextUtils;
import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements b
{
  private final List<d.a> LMP;
  
  public c()
  {
    AppMethodBeat.i(138344);
    this.LMP = new ArrayList();
    AppMethodBeat.o(138344);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(138345);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(138345);
      return;
    }
    if ((TextUtils.isEmpty(parama.LMX)) || (!"u:r:zygote:s0".equals(parama.LMX)))
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
    h.fUg();
    this.LMP.add(parama);
    AppMethodBeat.o(138345);
  }
  
  public final boolean fTK()
  {
    AppMethodBeat.i(138346);
    if (this.LMP.size() > 0)
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