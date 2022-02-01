package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class z$2
  implements Runnable
{
  z$2(z.a parama, int paramInt1, int paramInt2, String paramString, c paramc, p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(132485);
    this.ovm.callback(this.val$errType, this.val$errCode, this.val$errMsg, this.ovo, this.hxO);
    AppMethodBeat.o(132485);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132486);
    String str = super.toString() + "|tryCallback";
    AppMethodBeat.o(132486);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.z.2
 * JD-Core Version:    0.7.0.1
 */