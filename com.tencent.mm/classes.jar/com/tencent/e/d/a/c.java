package com.tencent.e.d.a;

import android.text.TextUtils;
import com.tencent.e.d.b.e.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements b
{
  private final List<e.a> ahtD;
  
  public c()
  {
    AppMethodBeat.i(138344);
    this.ahtD = new ArrayList();
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
    if ((TextUtils.isEmpty(parama.ahtL)) || (!"u:r:zygote:s0".equals(parama.ahtL)))
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
    h.jXC();
    this.ahtD.add(parama);
    AppMethodBeat.o(138345);
  }
  
  public final boolean jXf()
  {
    AppMethodBeat.i(138346);
    if (this.ahtD.size() > 0)
    {
      AppMethodBeat.o(138346);
      return true;
    }
    AppMethodBeat.o(138346);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.d.a.c
 * JD-Core Version:    0.7.0.1
 */