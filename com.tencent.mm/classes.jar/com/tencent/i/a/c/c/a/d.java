package com.tencent.i.a.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class d
{
  b SsI;
  a SsJ;
  
  public d(b paramb, a parama)
  {
    this.SsI = paramb;
    this.SsJ = parama;
  }
  
  public static final class a
  {
    private Map<Integer, Integer> SsK;
    private int SsL;
    
    public a()
    {
      AppMethodBeat.i(214770);
      this.SsK = new HashMap();
      AppMethodBeat.o(214770);
    }
    
    public final int asD(int paramInt)
    {
      AppMethodBeat.i(214771);
      if (this.SsK.containsKey(Integer.valueOf(paramInt)))
      {
        paramInt = ((Integer)this.SsK.get(Integer.valueOf(paramInt))).intValue();
        AppMethodBeat.o(214771);
        return paramInt;
      }
      int i = this.SsL + 1;
      this.SsL = i;
      this.SsK.put(Integer.valueOf(paramInt), Integer.valueOf(i));
      AppMethodBeat.o(214771);
      return i;
    }
    
    public final void asE(int paramInt)
    {
      AppMethodBeat.i(214772);
      this.SsK.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(214772);
    }
    
    public final int hqA()
    {
      AppMethodBeat.i(214773);
      int i = this.SsK.size();
      AppMethodBeat.o(214773);
      return i;
    }
  }
  
  public static final class b
  {
    Queue<Integer> SsM;
    Map<Integer, c> SsN;
    
    public b()
    {
      AppMethodBeat.i(214774);
      this.SsM = new LinkedList();
      this.SsN = new HashMap();
      AppMethodBeat.o(214774);
    }
    
    public final c asF(int paramInt)
    {
      AppMethodBeat.i(214775);
      try
      {
        if (this.SsM.remove(Integer.valueOf(paramInt)))
        {
          c localc = (c)this.SsN.remove(Integer.valueOf(paramInt));
          AppMethodBeat.o(214775);
          return localc;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(214775);
      }
      return null;
    }
    
    public final boolean hqB()
    {
      AppMethodBeat.i(214776);
      c localc = (c)this.SsN.get(this.SsM.peek());
      if ((localc != null) && (localc.SsG))
      {
        AppMethodBeat.o(214776);
        return true;
      }
      AppMethodBeat.o(214776);
      return false;
    }
    
    public final void hqC()
    {
      AppMethodBeat.i(214777);
      if (hqB())
      {
        AppMethodBeat.o(214777);
        return;
      }
      c localc = (c)this.SsN.get(this.SsM.peek());
      if (localc != null) {
        localc.SsG = true;
      }
      AppMethodBeat.o(214777);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c.a.d
 * JD-Core Version:    0.7.0.1
 */