package com.tencent.h.a.b;

import com.tencent.h.a.b.c.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public abstract class b
{
  public a ahXh = new a();
  
  public b()
  {
    kdo();
  }
  
  protected abstract void kdo();
  
  public final class a
  {
    public HashMap<Integer, d> HlG;
    
    public a()
    {
      AppMethodBeat.i(212123);
      this.HlG = new HashMap();
      AppMethodBeat.o(212123);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(212128);
      if (!this.HlG.containsKey(paramd)) {
        this.HlG.put(Integer.valueOf(paramd.getTaskId()), paramd);
      }
      AppMethodBeat.o(212128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.b.b
 * JD-Core Version:    0.7.0.1
 */