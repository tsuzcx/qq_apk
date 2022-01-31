package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;

final class p$1
  extends n.a
{
  p$1(Context paramContext) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(18275);
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(18275);
      return;
    }
    p.aVO();
    AppMethodBeat.o(18275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.p.1
 * JD-Core Version:    0.7.0.1
 */