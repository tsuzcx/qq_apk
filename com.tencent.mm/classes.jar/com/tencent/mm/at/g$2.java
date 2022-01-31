package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class g$2
  implements Runnable
{
  g$2(g paramg, String paramString, float paramFloat, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(78204);
    this.fEH.a(this.fEI, true, this.cdS, true, false, this.fEJ, this.fEK);
    g.a(this.fEH).post(new g.2.1(this));
    AppMethodBeat.o(78204);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78205);
    String str = super.toString() + "|loadImginBackground";
    AppMethodBeat.o(78205);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.g.2
 * JD-Core Version:    0.7.0.1
 */