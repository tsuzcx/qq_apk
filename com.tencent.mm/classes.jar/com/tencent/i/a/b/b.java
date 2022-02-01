package com.tencent.i.a.b;

import com.tencent.i.a.b.c.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public abstract class b
{
  public a Sre = new a();
  
  public b()
  {
    hql();
  }
  
  protected abstract void hql();
  
  public final class a
  {
    public HashMap<Integer, d> wLb;
    
    public a()
    {
      AppMethodBeat.i(214698);
      this.wLb = new HashMap();
      AppMethodBeat.o(214698);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(214699);
      if (!this.wLb.containsKey(paramd)) {
        this.wLb.put(Integer.valueOf(paramd.getTaskId()), paramd);
      }
      AppMethodBeat.o(214699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.b.b
 * JD-Core Version:    0.7.0.1
 */