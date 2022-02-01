package com.tencent.h.a.c.d;

import com.tencent.h.a.a.c;
import com.tencent.h.a.c.b.g;
import com.tencent.h.a.c.b.h;
import com.tencent.h.a.c.b.i;
import com.tencent.h.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class a
{
  c ahWN;
  h.a ahXc;
  public b ahZl;
  private a ahZm;
  
  public a(c paramc)
  {
    this.ahWN = paramc;
    this.ahZm = new a();
  }
  
  protected final a kdM()
  {
    return this.ahZm;
  }
  
  final class a
  {
    final HashMap<Integer, List<g>> ahZn;
    final List<i> ahZo;
    final List<h> ahZp;
    HashMap<String, ArrayList<Object>> ahZq;
    
    a()
    {
      AppMethodBeat.i(212213);
      this.ahZn = new HashMap();
      this.ahZo = new ArrayList();
      this.ahZp = new ArrayList();
      this.ahZq = new HashMap();
      AppMethodBeat.o(212213);
    }
    
    static int bGz(String paramString)
    {
      AppMethodBeat.i(212224);
      if (paramString.contains("_"))
      {
        i = Integer.valueOf(paramString.split("_")[0]).intValue();
        AppMethodBeat.o(212224);
        return i;
      }
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(212224);
      return i;
    }
    
    static String qc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(212217);
      String str2 = String.valueOf(paramInt1);
      String str1 = str2;
      if (paramInt1 == 1) {
        str1 = str2 + "_" + String.valueOf(paramInt2);
      }
      AppMethodBeat.o(212217);
      return str1;
    }
    
    final ArrayList<Object> bGy(String paramString)
    {
      AppMethodBeat.i(212234);
      ArrayList localArrayList2 = (ArrayList)this.ahZq.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.ahZq.put(paramString, localArrayList1);
      }
      AppMethodBeat.o(212234);
      return localArrayList1;
    }
    
    final void clearAll()
    {
      AppMethodBeat.i(212228);
      this.ahZn.clear();
      this.ahZo.clear();
      this.ahZp.clear();
      AppMethodBeat.o(212228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.d.a
 * JD-Core Version:    0.7.0.1
 */