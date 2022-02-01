package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;

public final class a
{
  private com.tencent.mm.picker.c.a jKP;
  
  public a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(175328);
    this.jKP = new com.tencent.mm.picker.c.a(1);
    this.jKP.context = paramContext;
    this.jKP.jKR = paramc;
    AppMethodBeat.o(175328);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(175329);
    paramb.a(this.jKP);
    AppMethodBeat.o(175329);
  }
  
  public final a uM(int paramInt)
  {
    this.jKP.jKu = paramInt;
    return this;
  }
  
  public final a uN(int paramInt)
  {
    this.jKP.option = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.b.a
 * JD-Core Version:    0.7.0.1
 */