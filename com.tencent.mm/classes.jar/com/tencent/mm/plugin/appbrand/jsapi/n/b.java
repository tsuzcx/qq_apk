package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract a Ei();
  
  public abstract Boolean Ej();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(176553);
      kHN = new a("NONE", 0);
      kHO = new a("PUSH", 1);
      kHP = new a("POP", 2);
      kHQ = new a("PUSH_AND_POP", 3);
      kHR = new a[] { kHN, kHO, kHP, kHQ };
      AppMethodBeat.o(176553);
    }
    
    private a() {}
    
    public static a MW(String paramString)
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
      paramString = kHN;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = kHO;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = kHP;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = kHQ;
      AppMethodBeat.o(176552);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.b
 * JD-Core Version:    0.7.0.1
 */