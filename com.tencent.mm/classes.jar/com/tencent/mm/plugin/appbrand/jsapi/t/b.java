package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract a SX();
  
  public abstract Boolean SY();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(176553);
      plw = new a("NONE", 0);
      plx = new a("PUSH", 1);
      ply = new a("POP", 2);
      plz = new a("PUSH_AND_POP", 3);
      plA = new a[] { plw, plx, ply, plz };
      AppMethodBeat.o(176553);
    }
    
    private a() {}
    
    public static a aiw(String paramString)
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
      paramString = plw;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = plx;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = ply;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = plz;
      AppMethodBeat.o(176552);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.b
 * JD-Core Version:    0.7.0.1
 */