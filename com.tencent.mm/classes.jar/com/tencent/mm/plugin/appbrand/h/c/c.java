package com.tencent.mm.plugin.appbrand.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c.a.a;
import com.tencent.mm.plugin.appbrand.h.c.b.e;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private boolean enable;
  private String jjd;
  private int jje;
  Map<String, com.tencent.mm.plugin.appbrand.h.c.b.c> jjf;
  Map<String, com.tencent.mm.plugin.appbrand.h.c.b.c> jjg;
  private a jjh;
  
  private c()
  {
    AppMethodBeat.i(158965);
    this.enable = false;
    this.jjh = new a()
    {
      public final boolean b(com.tencent.mm.plugin.appbrand.h.c.b.d paramAnonymousd)
      {
        AppMethodBeat.i(158963);
        for (;;)
        {
          int i;
          try
          {
            String str1 = paramAnonymousd.jjR.get("SID");
            com.tencent.mm.plugin.appbrand.h.c.b.c localc = null;
            String str2 = paramAnonymousd.jjQ;
            i = -1;
            switch (str2.hashCode())
            {
            case -2006516997: 
              if ((localc != null) && (localc.jjP != null))
              {
                boolean bool = localc.jjP.a(paramAnonymousd);
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
                localc = (com.tencent.mm.plugin.appbrand.h.c.b.c)c.this.jjf.get(str1);
                continue;
                localc = (com.tencent.mm.plugin.appbrand.h.c.b.c)c.this.jjg.get(str1);
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
    this.jjf = new HashMap();
    this.jjg = new HashMap();
    AppMethodBeat.o(158965);
  }
  
  public static c aUT()
  {
    AppMethodBeat.i(202380);
    c localc = b.aUU();
    AppMethodBeat.o(202380);
    return localc;
  }
  
  public final String GM(String paramString)
  {
    AppMethodBeat.i(158969);
    paramString = "http://" + this.jjd + ":" + this.jje + paramString;
    AppMethodBeat.o(158969);
    return paramString;
  }
  
  public final boolean disable()
  {
    AppMethodBeat.i(158968);
    this.enable = false;
    d locald = d.c.aUV();
    locald.jjh = null;
    locald.stop();
    this.jjf.clear();
    this.jjg.clear();
    AppMethodBeat.o(158968);
    return true;
  }
  
  public final boolean enable()
  {
    AppMethodBeat.i(158967);
    this.enable = true;
    d locald = d.c.aUV();
    locald.jjh = this.jjh;
    locald.start();
    this.jjd = locald.ip;
    this.jje = locald.port;
    AppMethodBeat.o(158967);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(com.tencent.mm.plugin.appbrand.h.c.b.d paramd);
  }
  
  public static final class b
  {
    private static c jjn;
    
    static
    {
      AppMethodBeat.i(158964);
      jjn = new c((byte)0);
      AppMethodBeat.o(158964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.c
 * JD-Core Version:    0.7.0.1
 */