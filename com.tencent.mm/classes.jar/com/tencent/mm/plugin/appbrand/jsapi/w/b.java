package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
{
  public abstract a atC();
  
  public abstract Boolean atD();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(176553);
      sqy = new a("NONE", 0);
      sqz = new a("PUSH", 1);
      sqA = new a("POP", 2);
      sqB = new a("PUSH_AND_POP", 3);
      sqC = new a[] { sqy, sqz, sqA, sqB };
      AppMethodBeat.o(176553);
    }
    
    private a() {}
    
    public static a abu(String paramString)
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
      paramString = sqy;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = sqz;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = sqA;
      AppMethodBeat.o(176552);
      return paramString;
      paramString = sqB;
      AppMethodBeat.o(176552);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.b
 * JD-Core Version:    0.7.0.1
 */