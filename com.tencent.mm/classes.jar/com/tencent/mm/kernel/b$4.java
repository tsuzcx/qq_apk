package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.j.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b$4
  extends j.a
{
  public b$4(b paramb) {}
  
  public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132049);
    Log.i("MMKernel.CoreNetwork", "callback, kv:%s", new Object[] { paramString });
    b.a(paramInt1, paramInt2, paramBoolean, paramString);
    AppMethodBeat.o(132049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.b.4
 * JD-Core Version:    0.7.0.1
 */