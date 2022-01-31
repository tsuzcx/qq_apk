package com.tencent.mm.plugin.freewifi.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.sdk.platformtools.bo;

final class a$1
  implements f
{
  a$1(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20683);
    paramString = ((b)paramm).mac;
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(paramString))
    {
      AppMethodBeat.o(20683);
      return;
    }
    if (paramInt2 == -30011)
    {
      this.mKa.mJY.put(paramString.hashCode(), Long.valueOf(bo.aoy()));
      AppMethodBeat.o(20683);
      return;
    }
    this.mKa.mJY.remove(paramString.hashCode());
    AppMethodBeat.o(20683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.a.1
 * JD-Core Version:    0.7.0.1
 */