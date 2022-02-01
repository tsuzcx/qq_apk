package com.tencent.i.a.c.d;

import com.tencent.i.a.a.c;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.h;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class a
{
  public c SqM;
  public h.a SqZ;
  public b Stj;
  public a Stk;
  
  public a(c paramc)
  {
    this.SqM = paramc;
    this.Stk = new a();
  }
  
  public final class a
  {
    final HashMap<Integer, List<g>> Stl;
    final List<i> Stm;
    final List<h> Stn;
    HashMap<String, ArrayList<Object>> Sto;
    
    a()
    {
      AppMethodBeat.i(214810);
      this.Stl = new HashMap();
      this.Stm = new ArrayList();
      this.Stn = new ArrayList();
      this.Sto = new HashMap();
      AppMethodBeat.o(214810);
    }
    
    static int brb(String paramString)
    {
      AppMethodBeat.i(214814);
      if (paramString.contains("_"))
      {
        i = Integer.valueOf(paramString.split("_")[0]).intValue();
        AppMethodBeat.o(214814);
        return i;
      }
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(214814);
      return i;
    }
    
    public static String mN(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(214813);
      String str2 = String.valueOf(paramInt1);
      String str1 = str2;
      if (paramInt1 == 1) {
        str1 = str2 + "_" + String.valueOf(paramInt2);
      }
      AppMethodBeat.o(214813);
      return str1;
    }
    
    public final ArrayList<Object> bra(String paramString)
    {
      AppMethodBeat.i(214812);
      ArrayList localArrayList2 = (ArrayList)this.Sto.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.Sto.put(paramString, localArrayList1);
      }
      AppMethodBeat.o(214812);
      return localArrayList1;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(214811);
      this.Stl.clear();
      this.Stm.clear();
      this.Stn.clear();
      AppMethodBeat.o(214811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.d.a
 * JD-Core Version:    0.7.0.1
 */