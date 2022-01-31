package com.tencent.mm.aa.c;

import com.tencent.mm.aa.b.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private final Map<String, e> dJe = new HashMap();
  
  public final void a(e parame)
  {
    this.dJe.put(parame.getName(), parame);
  }
  
  public final e fO(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return (e)this.dJe.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aa.c.g
 * JD-Core Version:    0.7.0.1
 */