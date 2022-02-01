package com.tencent.h.a.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class d
{
  b ahYL;
  a ahYM;
  
  public d(b paramb, a parama)
  {
    this.ahYL = paramb;
    this.ahYM = parama;
  }
  
  public static final class a
  {
    private Map<Integer, Integer> ahYN;
    private int ahYO;
    
    public a()
    {
      AppMethodBeat.i(212255);
      this.ahYN = new HashMap();
      AppMethodBeat.o(212255);
    }
    
    public final int aJe(int paramInt)
    {
      AppMethodBeat.i(212259);
      if (this.ahYN.containsKey(Integer.valueOf(paramInt)))
      {
        paramInt = ((Integer)this.ahYN.get(Integer.valueOf(paramInt))).intValue();
        AppMethodBeat.o(212259);
        return paramInt;
      }
      int i = this.ahYO + 1;
      this.ahYO = i;
      this.ahYN.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(212259);
      return i;
    }
    
    public final void aJf(int paramInt)
    {
      AppMethodBeat.i(212264);
      this.ahYN.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(212264);
    }
    
    public final int kdF()
    {
      AppMethodBeat.i(212270);
      int i = this.ahYN.size();
      AppMethodBeat.o(212270);
      return i;
    }
  }
  
  public static final class b
  {
    Queue<Integer> ahYP;
    Map<Integer, c> ahYQ;
    
    public b()
    {
      AppMethodBeat.i(212254);
      this.ahYP = new LinkedList();
      this.ahYQ = new HashMap();
      AppMethodBeat.o(212254);
    }
    
    public final c aJg(int paramInt)
    {
      AppMethodBeat.i(212261);
      try
      {
        if (this.ahYP.remove(Integer.valueOf(paramInt)))
        {
          c localc = (c)this.ahYQ.remove(Integer.valueOf(paramInt));
          return localc;
        }
      }
      finally
      {
        AppMethodBeat.o(212261);
      }
      return null;
    }
    
    public final boolean kdG()
    {
      AppMethodBeat.i(212265);
      c localc = (c)this.ahYQ.get(this.ahYP.peek());
      if ((localc != null) && (localc.ahYJ))
      {
        AppMethodBeat.o(212265);
        return true;
      }
      AppMethodBeat.o(212265);
      return false;
    }
    
    public final void kdH()
    {
      AppMethodBeat.i(212271);
      if (kdG())
      {
        AppMethodBeat.o(212271);
        return;
      }
      c localc = (c)this.ahYQ.get(this.ahYP.peek());
      if (localc != null) {
        localc.ahYJ = true;
      }
      AppMethodBeat.o(212271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.d
 * JD-Core Version:    0.7.0.1
 */