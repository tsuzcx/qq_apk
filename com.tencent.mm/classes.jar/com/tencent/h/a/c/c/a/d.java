package com.tencent.h.a.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class d
{
  b ZUl;
  a ZUm;
  
  public d(b paramb, a parama)
  {
    this.ZUl = paramb;
    this.ZUm = parama;
  }
  
  public static final class a
  {
    private Map<Integer, Integer> ZUn;
    private int ZUo;
    
    public a()
    {
      AppMethodBeat.i(208114);
      this.ZUn = new HashMap();
      AppMethodBeat.o(208114);
    }
    
    public final int aCr(int paramInt)
    {
      AppMethodBeat.i(208117);
      if (this.ZUn.containsKey(Integer.valueOf(paramInt)))
      {
        paramInt = ((Integer)this.ZUn.get(Integer.valueOf(paramInt))).intValue();
        AppMethodBeat.o(208117);
        return paramInt;
      }
      int i = this.ZUo + 1;
      this.ZUo = i;
      this.ZUn.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(208117);
      return i;
    }
    
    public final void aCs(int paramInt)
    {
      AppMethodBeat.i(208119);
      this.ZUn.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(208119);
    }
    
    public final int iuj()
    {
      AppMethodBeat.i(208120);
      int i = this.ZUn.size();
      AppMethodBeat.o(208120);
      return i;
    }
  }
  
  public static final class b
  {
    Queue<Integer> ZUp;
    Map<Integer, c> ZUq;
    
    public b()
    {
      AppMethodBeat.i(208322);
      this.ZUp = new LinkedList();
      this.ZUq = new HashMap();
      AppMethodBeat.o(208322);
    }
    
    public final c aCt(int paramInt)
    {
      AppMethodBeat.i(208324);
      try
      {
        if (this.ZUp.remove(Integer.valueOf(paramInt)))
        {
          c localc = (c)this.ZUq.remove(Integer.valueOf(paramInt));
          AppMethodBeat.o(208324);
          return localc;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(208324);
      }
      return null;
    }
    
    public final boolean iuk()
    {
      AppMethodBeat.i(208326);
      c localc = (c)this.ZUq.get(this.ZUp.peek());
      if ((localc != null) && (localc.ZUj))
      {
        AppMethodBeat.o(208326);
        return true;
      }
      AppMethodBeat.o(208326);
      return false;
    }
    
    public final void iul()
    {
      AppMethodBeat.i(208327);
      if (iuk())
      {
        AppMethodBeat.o(208327);
        return;
      }
      c localc = (c)this.ZUq.get(this.ZUp.peek());
      if (localc != null) {
        localc.ZUj = true;
      }
      AppMethodBeat.o(208327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.d
 * JD-Core Version:    0.7.0.1
 */