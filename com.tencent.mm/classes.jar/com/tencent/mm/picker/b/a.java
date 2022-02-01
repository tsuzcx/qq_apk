package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.f.b;

public final class a
{
  private com.tencent.mm.picker.c.a pyC;
  
  public a(Context paramContext, d paramd)
  {
    AppMethodBeat.i(175328);
    this.pyC = new com.tencent.mm.picker.c.a(1);
    this.pyC.context = paramContext;
    this.pyC.pyE = paramd;
    AppMethodBeat.o(175328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(175329);
    paramb.a(this.pyC);
    AppMethodBeat.o(175329);
  }
  
  public final a xT(int paramInt)
  {
    this.pyC.pyf = paramInt;
    return this;
  }
  
  public final a xU(int paramInt)
  {
    this.pyC.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.b.a
 * JD-Core Version:    0.7.0.1
 */