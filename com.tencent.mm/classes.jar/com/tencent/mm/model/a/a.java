package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import java.util.Map;

public final class a
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(153088);
    paramMap = localObject;
    if (paramString != null)
    {
      paramMap = localObject;
      if (paramString.equals("abtest"))
      {
        paramString = f.d.bY(Integer.valueOf(-1879048184));
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