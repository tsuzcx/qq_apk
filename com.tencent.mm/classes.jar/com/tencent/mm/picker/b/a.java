package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;

public final class a
{
  private com.tencent.mm.picker.c.a hSa;
  
  public a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(175328);
    this.hSa = new com.tencent.mm.picker.c.a(1);
    this.hSa.context = paramContext;
    this.hSa.hSb = paramc;
    AppMethodBeat.o(175328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(175329);
    paramb.a(this.hSa);
    AppMethodBeat.o(175329);
  }
  
  public final a pE(int paramInt)
  {
    this.hSa.hRF = paramInt;
    return this;
  }
  
  public final a pF(int paramInt)
  {
    this.hSa.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.b.a
 * JD-Core Version:    0.7.0.1
 */