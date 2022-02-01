package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String fQg;
  public String hqi;
  public String hqj;
  public String hqk;
  public HashMap<String, e> hql;
  
  public b()
  {
    AppMethodBeat.i(153089);
    this.hql = new HashMap();
    AppMethodBeat.o(153089);
  }
  
  public final e yF(String paramString)
  {
    AppMethodBeat.i(153090);
    if ((this.hql != null) && (this.hql.containsKey(paramString)))
    {
      paramString = (e)this.hql.get(paramString);
      AppMethodBeat.o(153090);
      return paramString;
    }
    AppMethodBeat.o(153090);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.b
 * JD-Core Version:    0.7.0.1
 */