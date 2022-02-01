package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;

public final class a
{
  private com.tencent.mm.picker.c.a mBU;
  
  public a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(175328);
    this.mBU = new com.tencent.mm.picker.c.a(1);
    this.mBU.context = paramContext;
    this.mBU.mBW = paramc;
    AppMethodBeat.o(175328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(175329);
    paramb.a(this.mBU);
    AppMethodBeat.o(175329);
  }
  
  public final a xO(int paramInt)
  {
    this.mBU.mBx = paramInt;
    return this;
  }
  
  public final a xP(int paramInt)
  {
    this.mBU.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.b.a
 * JD-Core Version:    0.7.0.1
 */