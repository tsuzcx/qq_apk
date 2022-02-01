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
  h.a ZSC;
  c ZSp;
  public b ZUM;
  private a ZUN;
  
  public a(c paramc)
  {
    this.ZSp = paramc;
    this.ZUN = new a();
  }
  
  protected final a iuq()
  {
    return this.ZUN;
  }
  
  final class a
  {
    final HashMap<Integer, List<g>> ZUO;
    final List<i> ZUP;
    final List<h> ZUQ;
    HashMap<String, ArrayList<Object>> ZUR;
    
    a()
    {
      AppMethodBeat.i(207782);
      this.ZUO = new HashMap();
      this.ZUP = new ArrayList();
      this.ZUQ = new ArrayList();
      this.ZUR = new HashMap();
      AppMethodBeat.o(207782);
    }
    
    static int bEa(String paramString)
    {
      AppMethodBeat.i(207787);
      if (paramString.contains("_"))
      {
        i = Integer.valueOf(paramString.split("_")[0]).intValue();
        AppMethodBeat.o(207787);
        return i;
      }
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(207787);
      return i;
    }
    
    static String of(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207786);
      String str2 = String.valueOf(paramInt1);
      String str1 = str2;
      if (paramInt1 == 1) {
        str1 = str2 + "_" + String.valueOf(paramInt2);
      }
      AppMethodBeat.o(207786);
      return str1;
    }
    
    final ArrayList<Object> bDZ(String paramString)
    {
      AppMethodBeat.i(207785);
      ArrayList localArrayList2 = (ArrayList)this.ZUR.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.ZUR.put(paramString, localArrayList1);
      }
      AppMethodBeat.o(207785);
      return localArrayList1;
    }
    
    final void clearAll()
    {
      AppMethodBeat.i(207784);
      this.ZUO.clear();
      this.ZUP.clear();
      this.ZUQ.clear();
      AppMethodBeat.o(207784);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.d.a
 * JD-Core Version:    0.7.0.1
 */