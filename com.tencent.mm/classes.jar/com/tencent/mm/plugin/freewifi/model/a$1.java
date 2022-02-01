package com.tencent.mm.plugin.freewifi.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bs;

final class a$1
  implements g
{
  a$1(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(24760);
    paramString = ((b)paramn).mac;
    if (m.cX(paramString))
    {
      AppMethodBeat.o(24760);
      return;
    }
    if (paramInt2 == -30011)
    {
      this.spY.spW.put(paramString.hashCode(), Long.valueOf(bs.eWj()));
      AppMethodBeat.o(24760);
      return;
    }
    this.spY.spW.remove(paramString.hashCode());
    AppMethodBeat.o(24760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.a.1
 * JD-Core Version:    0.7.0.1
 */