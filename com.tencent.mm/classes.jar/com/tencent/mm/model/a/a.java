package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import java.util.Map;

public final class a
  implements p
{
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(153088);
    paramMap = localObject;
    if (paramString != null)
    {
      paramMap = localObject;
      if (paramString.equals("abtest"))
      {
        paramString = h.d.ck(Integer.valueOf(-1879048184));
        if (paramString != null) {
          break label50;
        }
      }
    }
    label50:
    for (paramMap = localObject;; paramMap = paramString.b(parama))
    {
      AppMethodBeat.o(153088);
      return paramMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.a
 * JD-Core Version:    0.7.0.1
 */