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
  private final List<d.a> Iro;
  
  public c()
  {
    AppMethodBeat.i(138344);
    this.Iro = new ArrayList();
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
    if ((TextUtils.isEmpty(parama.Irw)) || (!"u:r:zygote:s0".equals(parama.Irw)))
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
    h.fmy();
    this.Iro.add(parama);
    AppMethodBeat.o(138345);
  }
  
  public final boolean fmd()
  {
    AppMethodBeat.i(138346);
    if (this.Iro.size() > 0)
    {
      AppMethodBeat.o(138346);
      return true;
    }
    AppMethodBeat.o(138346);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.d.a.c
 * JD-Core Version:    0.7.0.1
 */