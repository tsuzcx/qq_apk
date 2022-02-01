package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.pk;
import com.tencent.mm.network.j.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class c$4
  extends j.a
{
  public c$4(c paramc) {}
  
  public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132049);
    Log.i("MMKernel.CoreNetwork", "callback, kv:%s", new Object[] { paramString });
    pk localpk = new pk();
    localpk.hSD.status = paramInt1;
    localpk.hSD.hSE = paramInt2;
    localpk.hSD.hSF = paramBoolean;
    localpk.hSD.hSG = paramString;
    localpk.publish();
    AppMethodBeat.o(132049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.kernel.c.4
 * JD-Core Version:    0.7.0.1
 */