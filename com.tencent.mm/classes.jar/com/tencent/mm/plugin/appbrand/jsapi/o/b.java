package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract a EG();
  
  public abstract Boolean EH();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(176553);
      kgX = new a("NONE", 0);
      kgY = new a("PUSH", 1);
      kgZ = new a("POP", 2);
      kha = new a("PUSH_AND_POP", 3);
      khb = new a[] { kgX, kgY, kgZ, kha };
      AppMethodBeat.o(176553);
    }
    
    private a() {}
    
    public static a IT(String paramString)
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
      paramString = kgX;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = kgY;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = kgZ;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = kha;
      AppMethodBeat.o(176552);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b
 * JD-Core Version:    0.7.0.1
 */