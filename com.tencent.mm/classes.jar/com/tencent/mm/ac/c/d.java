package com.tencent.mm.ac.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.b;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  final Map<String, b> mBk;
  
  public d()
  {
    AppMethodBeat.i(144807);
    this.mBk = new HashMap();
    AppMethodBeat.o(144807);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(144808);
    this.mBk.put(paramb.name, paramb);
    AppMethodBeat.o(144808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ac.c.d
 * JD-Core Version:    0.7.0.1
 */