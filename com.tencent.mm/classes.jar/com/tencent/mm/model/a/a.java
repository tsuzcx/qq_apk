package com.tencent.mm.model.a;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import java.util.Map;

public final class a
  implements n
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    if ((paramString != null) && (paramString.equals("abtest")))
    {
      paramString = e.d.aB(Integer.valueOf(-1879048184));
      if (paramString != null) {}
    }
    else
    {
      return null;
    }
    return paramString.b(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.a.a
 * JD-Core Version:    0.7.0.1
 */