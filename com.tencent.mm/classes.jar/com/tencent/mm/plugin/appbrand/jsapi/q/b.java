package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract a FO();
  
  public abstract Boolean FP();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(176553);
      lhS = new a("NONE", 0);
      lhT = new a("PUSH", 1);
      lhU = new a("POP", 2);
      lhV = new a("PUSH_AND_POP", 3);
      lhW = new a[] { lhS, lhT, lhU, lhV };
      AppMethodBeat.o(176553);
    }
    
    private a() {}
    
    public static a Rc(String paramString)
    {
      AppMethodBeat.i(176552);
      paramString = paramString.trim();
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(176552);
          return null;
          if (paramString.equals(""))
          {
            i = 0;
            continue;
            if (paramString.equals("push"))
            {
              i = 1;
              continue;
              if (paramString.equals("pop"))
              {
                i = 2;
                continue;
                if (paramString.equals("pushAndPop")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      paramString = lhS;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = lhT;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = lhU;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = lhV;
      AppMethodBeat.o(176552);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.b
 * JD-Core Version:    0.7.0.1
 */