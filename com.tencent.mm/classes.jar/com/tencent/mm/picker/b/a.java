package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;

public final class a
{
  private com.tencent.mm.picker.c.a iOb;
  
  public a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(175328);
    this.iOb = new com.tencent.mm.picker.c.a(1);
    this.iOb.context = paramContext;
    this.iOb.iOc = paramc;
    AppMethodBeat.o(175328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(175329);
    paramb.a(this.iOb);
    AppMethodBeat.o(175329);
  }
  
  public final a qU(int paramInt)
  {
    this.iOb.iNG = paramInt;
    return this;
  }
  
  public final a qV(int paramInt)
  {
    this.iOb.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.b.a
 * JD-Core Version:    0.7.0.1
 */