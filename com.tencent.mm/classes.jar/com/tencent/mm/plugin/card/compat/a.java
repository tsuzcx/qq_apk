package com.tencent.mm.plugin.card.compat;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.model.app.m;

public final class a
  implements com.tencent.mm.plugin.card.compat.a.a
{
  public final int a(k.b paramb, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22756);
    paramb = m.a(paramb, paramString1, paramString2, paramString3, null, paramArrayOfByte);
    if (paramb != null)
    {
      i = ((Integer)paramb.first).intValue();
      AppMethodBeat.o(22756);
      return i;
    }
    int i = f.getLine();
    AppMethodBeat.o(22756);
    return 0 - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.compat.a
 * JD-Core Version:    0.7.0.1
 */