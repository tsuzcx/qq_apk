package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.a.a;
import com.tencent.mm.plugin.appbrand.g.c.b.e;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private boolean enable;
  private String kdC;
  private int kdD;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> kdE;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> kdF;
  private a kdG;
  
  private c()
  {
    AppMethodBeat.i(158965);
    this.enable = false;
    this.kdG = new a()
    {
      public final boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramAnonymousd)
      {
        AppMethodBeat.i(158963);
        for (;;)
        {
          int i;
          try
          {
            String str1 = paramAnonymousd.kep.get("SID");
            com.tencent.mm.plugin.appbrand.g.c.b.c localc = null;
            String str2 = paramAnonymousd.keo;
            i = -1;
            switch (str2.hashCode())
            {
            case -2006516997: 
              if ((localc != null) && (localc.ken != null))
              {
                boolean bool = localc.ken.a(paramAnonymousd);
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
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.kdE.get(str1);
                continue;
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.kdF.get(str1);
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
    this.kdE = new HashMap();
    this.kdF = new HashMap();
    AppMethodBeat.o(158965);
  }
  
  public static c bfv()
  {
    AppMethodBeat.i(221732);
    c localc = b.bfw();
    AppMethodBeat.o(221732);
    return localc;
  }
  
  public final String Ok(String paramString)
  {
    AppMethodBeat.i(158969);
    paramString = "http://" + this.kdC + ":" + this.kdD + paramString;
    AppMethodBeat.o(158969);
    return paramString;
  }
  
  public final boolean disable()
  {
    AppMethodBeat.i(158968);
    this.enable = false;
    d locald = d.c.bfx();
    locald.kdG = null;
    locald.stop();
    this.kdE.clear();
    this.kdF.clear();
    AppMethodBeat.o(158968);
    return true;
  }
  
  public final boolean enable()
  {
    AppMethodBeat.i(158967);
    this.enable = true;
    d locald = d.c.bfx();
    locald.kdG = this.kdG;
    locald.start();
    this.kdC = locald.ip;
    this.kdD = locald.port;
    AppMethodBeat.o(158967);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramd);
  }
  
  public static final class b
  {
    private static c kdM;
    
    static
    {
      AppMethodBeat.i(158964);
      kdM = new c((byte)0);
      AppMethodBeat.o(158964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.c
 * JD-Core Version:    0.7.0.1
 */