package com.tencent.e.d.a;

import android.text.TextUtils;
import com.tencent.e.d.b.d.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements b
{
  private final List<d.a> Bkl;
  
  public c()
  {
    AppMethodBeat.i(114503);
    this.Bkl = new ArrayList();
    AppMethodBeat.o(114503);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(114504);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(114504);
      return;
    }
    if ((TextUtils.isEmpty(parama.Bkt)) || (!"u:r:zygote:s0".equals(parama.Bkt)))
    {
      AppMethodBeat.o(114504);
      return;
    }
    if ((TextUtils.isEmpty(parama.name)) || ("zygote".equals(parama.name)) || ("zygote64".equals(parama.name)))
    {
      AppMethodBeat.o(114504);
      return;
    }
    new StringBuilder("JavaProcessAnalyzer match : ").append(parama.toString());
    h.dUT();
    this.Bkl.add(parama);
    AppMethodBeat.o(114504);
  }
  
  public final boolean dUx()
  {
    AppMethodBeat.i(114505);
    if (this.Bkl.size() > 0)
    {
      AppMethodBeat.o(114505);
      return true;
    }
    AppMethodBeat.o(114505);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.e.d.a.c
 * JD-Core Version:    0.7.0.1
 */