package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;

public final class a
{
  private com.tencent.mm.picker.c.a iLi;
  
  public a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(175328);
    this.iLi = new com.tencent.mm.picker.c.a(1);
    this.iLi.context = paramContext;
    this.iLi.iLj = paramc;
    AppMethodBeat.o(175328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(175329);
    paramb.a(this.iLi);
    AppMethodBeat.o(175329);
  }
  
  public final a qR(int paramInt)
  {
    this.iLi.iKN = paramInt;
    return this;
  }
  
  public final a qS(int paramInt)
  {
    this.iLi.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.b.a
 * JD-Core Version:    0.7.0.1
 */