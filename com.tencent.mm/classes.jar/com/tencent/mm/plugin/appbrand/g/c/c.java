package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.a.a;
import com.tencent.mm.plugin.appbrand.g.c.b.e;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private boolean enable;
  private String riS;
  private int riT;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> riU;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> riV;
  private a riW;
  
  private c()
  {
    AppMethodBeat.i(158965);
    this.enable = false;
    this.riW = new a()
    {
      public final boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramAnonymousd)
      {
        AppMethodBeat.i(158963);
        for (;;)
        {
          int i;
          try
          {
            String str1 = paramAnonymousd.rjF.get("SID");
            com.tencent.mm.plugin.appbrand.g.c.b.c localc = null;
            String str2 = paramAnonymousd.rjE;
            i = -1;
            switch (str2.hashCode())
            {
            case -2006516997: 
              if ((localc != null) && (localc.rjD != null))
              {
                boolean bool = localc.rjD.a(paramAnonymousd);
                return bool;
                if (!str2.equals("avtEvent")) {
                  break label190;
                }
                i = 0;
              }
              break;
            case -1725405015: 
              if (str2.equals("rdcEvent"))
              {
                i = 1;
                break label190;
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.riU.get(str1);
                continue;
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.riV.get(str1);
                continue;
                return true;
              }
              break;
            }
          }
          finally
          {
            AppMethodBeat.o(158963);
          }
          label190:
          switch (i)
          {
          }
        }
      }
    };
    this.riU = new HashMap();
    this.riV = new HashMap();
    AppMethodBeat.o(158965);
  }
  
  public final String YM(String paramString)
  {
    AppMethodBeat.i(158969);
    paramString = "http://" + this.riS + ":" + this.riT + paramString;
    AppMethodBeat.o(158969);
    return paramString;
  }
  
  public final boolean ceR()
  {
    AppMethodBeat.i(158967);
    this.enable = true;
    d locald = d.c.cnj();
    locald.riW = this.riW;
    locald.start();
    this.riS = locald.ip;
    this.riT = locald.port;
    AppMethodBeat.o(158967);
    return true;
  }
  
  public final boolean cng()
  {
    AppMethodBeat.i(158968);
    this.enable = false;
    d locald = d.c.cnj();
    locald.riW = null;
    locald.stop();
    this.riU.clear();
    this.riV.clear();
    AppMethodBeat.o(158968);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramd);
  }
  
  public static final class b
  {
    private static c rjc;
    
    static
    {
      AppMethodBeat.i(158964);
      rjc = new c((byte)0);
      AppMethodBeat.o(158964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.c
 * JD-Core Version:    0.7.0.1
 */