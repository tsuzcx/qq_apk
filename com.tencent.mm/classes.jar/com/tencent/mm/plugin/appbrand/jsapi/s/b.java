package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract a Px();
  
  public abstract Boolean Py();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(176553);
      mnq = new a("NONE", 0);
      mnr = new a("PUSH", 1);
      mns = new a("POP", 2);
      mnt = new a("PUSH_AND_POP", 3);
      mnu = new a[] { mnq, mnr, mns, mnt };
      AppMethodBeat.o(176553);
    }
    
    private a() {}
    
    public static a aaE(String paramString)
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
      paramString = mnq;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = mnr;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = mns;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = mnt;
      AppMethodBeat.o(176552);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b
 * JD-Core Version:    0.7.0.1
 */