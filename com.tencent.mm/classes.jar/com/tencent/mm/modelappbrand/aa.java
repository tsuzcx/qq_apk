package com.tencent.mm.modelappbrand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class aa
  implements z
{
  private f eaa;
  protected Map<String, m> eab = new HashMap();
  
  public aa(f paramf)
  {
    this.eaa = paramf;
  }
  
  public aa(z paramz)
  {
    if (paramz == null) {
      return;
    }
    this.eaa = paramz.JA();
    a(paramz);
  }
  
  private void a(z paramz)
  {
    paramz = paramz.JB().iterator();
    while (paramz.hasNext()) {
      a((m)paramz.next());
    }
  }
  
  public final f JA()
  {
    return this.eaa;
  }
  
  public final List<m> JB()
  {
    return new ArrayList(this.eab.values());
  }
  
  public final void a(m paramm)
  {
    this.eab.put(paramm.getName(), paramm);
  }
  
  public final <T> T jC(String paramString)
  {
    return this.eab.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.aa
 * JD-Core Version:    0.7.0.1
 */