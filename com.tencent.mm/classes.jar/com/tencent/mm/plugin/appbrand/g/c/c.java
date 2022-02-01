package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private boolean enable;
  private String kgT;
  private int kgU;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> kgV;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> kgW;
  private a kgX;
  
  private c()
  {
    AppMethodBeat.i(158965);
    this.enable = false;
    this.kgX = new a()
    {
      public final boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramAnonymousd)
      {
        AppMethodBeat.i(158963);
        for (;;)
        {
          int i;
          try
          {
            String str1 = paramAnonymousd.khG.get("SID");
            com.tencent.mm.plugin.appbrand.g.c.b.c localc = null;
            String str2 = paramAnonymousd.khF;
            i = -1;
            switch (str2.hashCode())
            {
            case -2006516997: 
              if ((localc != null) && (localc.khE != null))
              {
                boolean bool = localc.khE.a(paramAnonymousd);
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
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.kgV.get(str1);
                continue;
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.kgW.get(str1);
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
    this.kgV = new HashMap();
    this.kgW = new HashMap();
    AppMethodBeat.o(158965);
  }
  
  public static c bgd()
  {
    AppMethodBeat.i(224573);
    c localc = b.bge();
    AppMethodBeat.o(224573);
    return localc;
  }
  
  public final String OR(String paramString)
  {
    AppMethodBeat.i(158969);
    paramString = "http://" + this.kgT + ":" + this.kgU + paramString;
    AppMethodBeat.o(158969);
    return paramString;
  }
  
  public final boolean disable()
  {
    AppMethodBeat.i(158968);
    this.enable = false;
    d locald = d.c.bgf();
    locald.kgX = null;
    locald.stop();
    this.kgV.clear();
    this.kgW.clear();
    AppMethodBeat.o(158968);
    return true;
  }
  
  public final boolean enable()
  {
    AppMethodBeat.i(158967);
    this.enable = true;
    d locald = d.c.bgf();
    locald.kgX = this.kgX;
    locald.start();
    this.kgT = locald.ip;
    this.kgU = locald.port;
    AppMethodBeat.o(158967);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramd);
  }
  
  public static final class b
  {
    private static c khd;
    
    static
    {
      AppMethodBeat.i(158964);
      khd = new c((byte)0);
      AppMethodBeat.o(158964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.c
 * JD-Core Version:    0.7.0.1
 */