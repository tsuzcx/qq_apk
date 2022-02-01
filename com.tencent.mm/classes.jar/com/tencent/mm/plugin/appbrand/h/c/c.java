package com.tencent.mm.plugin.appbrand.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c.a.a;
import com.tencent.mm.plugin.appbrand.h.c.b.e;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private boolean enable;
  private String jJq;
  private int jJr;
  Map<String, com.tencent.mm.plugin.appbrand.h.c.b.c> jJs;
  Map<String, com.tencent.mm.plugin.appbrand.h.c.b.c> jJt;
  private a jJu;
  
  private c()
  {
    AppMethodBeat.i(158965);
    this.enable = false;
    this.jJu = new a()
    {
      public final boolean b(com.tencent.mm.plugin.appbrand.h.c.b.d paramAnonymousd)
      {
        AppMethodBeat.i(158963);
        for (;;)
        {
          int i;
          try
          {
            String str1 = paramAnonymousd.jKe.get("SID");
            com.tencent.mm.plugin.appbrand.h.c.b.c localc = null;
            String str2 = paramAnonymousd.jKd;
            i = -1;
            switch (str2.hashCode())
            {
            case -2006516997: 
              if ((localc != null) && (localc.jKc != null))
              {
                boolean bool = localc.jKc.a(paramAnonymousd);
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
                localc = (com.tencent.mm.plugin.appbrand.h.c.b.c)c.this.jJs.get(str1);
                continue;
                localc = (com.tencent.mm.plugin.appbrand.h.c.b.c)c.this.jJt.get(str1);
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
    this.jJs = new HashMap();
    this.jJt = new HashMap();
    AppMethodBeat.o(158965);
  }
  
  public static c bbR()
  {
    AppMethodBeat.i(210497);
    c localc = b.bbS();
    AppMethodBeat.o(210497);
    return localc;
  }
  
  public final String KQ(String paramString)
  {
    AppMethodBeat.i(158969);
    paramString = "http://" + this.jJq + ":" + this.jJr + paramString;
    AppMethodBeat.o(158969);
    return paramString;
  }
  
  public final boolean disable()
  {
    AppMethodBeat.i(158968);
    this.enable = false;
    d locald = d.c.bbT();
    locald.jJu = null;
    locald.stop();
    this.jJs.clear();
    this.jJt.clear();
    AppMethodBeat.o(158968);
    return true;
  }
  
  public final boolean enable()
  {
    AppMethodBeat.i(158967);
    this.enable = true;
    d locald = d.c.bbT();
    locald.jJu = this.jJu;
    locald.start();
    this.jJq = locald.ip;
    this.jJr = locald.port;
    AppMethodBeat.o(158967);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(com.tencent.mm.plugin.appbrand.h.c.b.d paramd);
  }
  
  public static final class b
  {
    private static c jJA;
    
    static
    {
      AppMethodBeat.i(158964);
      jJA = new c((byte)0);
      AppMethodBeat.o(158964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.c
 * JD-Core Version:    0.7.0.1
 */