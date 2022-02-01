package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;

public final class a
{
  private com.tencent.mm.picker.c.a isf;
  
  public a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(175328);
    this.isf = new com.tencent.mm.picker.c.a(1);
    this.isf.context = paramContext;
    this.isf.isg = paramc;
    AppMethodBeat.o(175328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(175329);
    paramb.a(this.isf);
    AppMethodBeat.o(175329);
  }
  
  public final a qr(int paramInt)
  {
    this.isf.irK = paramInt;
    return this;
  }
  
  public final a qs(int paramInt)
  {
    this.isf.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.b.a
 * JD-Core Version:    0.7.0.1
 */