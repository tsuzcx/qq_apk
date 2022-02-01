package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private boolean enable;
  private String lkC;
  private int lkD;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> lkE;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> lkF;
  private a lkG;
  
  private c()
  {
    AppMethodBeat.i(158965);
    this.enable = false;
    this.lkG = new a()
    {
      public final boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramAnonymousd)
      {
        AppMethodBeat.i(158963);
        for (;;)
        {
          int i;
          try
          {
            String str1 = paramAnonymousd.llp.get("SID");
            com.tencent.mm.plugin.appbrand.g.c.b.c localc = null;
            String str2 = paramAnonymousd.llo;
            i = -1;
            switch (str2.hashCode())
            {
            case -2006516997: 
              if ((localc != null) && (localc.lln != null))
              {
                boolean bool = localc.lln.a(paramAnonymousd);
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
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.lkE.get(str1);
                continue;
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.lkF.get(str1);
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
    this.lkE = new HashMap();
    this.lkF = new HashMap();
    AppMethodBeat.o(158965);
  }
  
  public static c bBw()
  {
    AppMethodBeat.i(258731);
    c localc = b.bBx();
    AppMethodBeat.o(258731);
    return localc;
  }
  
  public final String Yc(String paramString)
  {
    AppMethodBeat.i(158969);
    paramString = "http://" + this.lkC + ":" + this.lkD + paramString;
    AppMethodBeat.o(158969);
    return paramString;
  }
  
  public final boolean disable()
  {
    AppMethodBeat.i(158968);
    this.enable = false;
    d locald = d.c.bBy();
    locald.lkG = null;
    locald.stop();
    this.lkE.clear();
    this.lkF.clear();
    AppMethodBeat.o(158968);
    return true;
  }
  
  public final boolean enable()
  {
    AppMethodBeat.i(158967);
    this.enable = true;
    d locald = d.c.bBy();
    locald.lkG = this.lkG;
    locald.start();
    this.lkC = locald.ip;
    this.lkD = locald.port;
    AppMethodBeat.o(158967);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramd);
  }
  
  public static final class b
  {
    private static c lkM;
    
    static
    {
      AppMethodBeat.i(158964);
      lkM = new c((byte)0);
      AppMethodBeat.o(158964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.c
 * JD-Core Version:    0.7.0.1
 */