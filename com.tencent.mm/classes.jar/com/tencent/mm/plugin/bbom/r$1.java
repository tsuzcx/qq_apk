package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.p.a;

final class r$1
  extends p.a
{
  r$1(Context paramContext) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(22381);
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(22381);
      return;
    }
    r.ckq();
    AppMethodBeat.o(22381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.r.1
 * JD-Core Version:    0.7.0.1
 */