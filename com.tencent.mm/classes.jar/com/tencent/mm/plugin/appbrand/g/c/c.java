package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private boolean enable;
  private String ofo;
  private int ofp;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> ofq;
  Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> ofr;
  private a ofs;
  
  private c()
  {
    AppMethodBeat.i(158965);
    this.enable = false;
    this.ofs = new a()
    {
      public final boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramAnonymousd)
      {
        AppMethodBeat.i(158963);
        for (;;)
        {
          int i;
          try
          {
            String str1 = paramAnonymousd.ogb.get("SID");
            com.tencent.mm.plugin.appbrand.g.c.b.c localc = null;
            String str2 = paramAnonymousd.oga;
            i = -1;
            switch (str2.hashCode())
            {
            case -2006516997: 
              if ((localc != null) && (localc.ofZ != null))
              {
                boolean bool = localc.ofZ.a(paramAnonymousd);
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
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.ofq.get(str1);
                continue;
                localc = (com.tencent.mm.plugin.appbrand.g.c.b.c)c.this.ofr.get(str1);
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
    this.ofq = new HashMap();
    this.ofr = new HashMap();
    AppMethodBeat.o(158965);
  }
  
  public static c bMR()
  {
    AppMethodBeat.i(292904);
    c localc = b.bMT();
    AppMethodBeat.o(292904);
    return localc;
  }
  
  public final String afQ(String paramString)
  {
    AppMethodBeat.i(158969);
    paramString = "http://" + this.ofo + ":" + this.ofp + paramString;
    AppMethodBeat.o(158969);
    return paramString;
  }
  
  public final boolean bFu()
  {
    AppMethodBeat.i(158967);
    this.enable = true;
    d locald = d.c.bMU();
    locald.ofs = this.ofs;
    locald.start();
    this.ofo = locald.ip;
    this.ofp = locald.port;
    AppMethodBeat.o(158967);
    return true;
  }
  
  public final boolean bMS()
  {
    AppMethodBeat.i(158968);
    this.enable = false;
    d locald = d.c.bMU();
    locald.ofs = null;
    locald.stop();
    this.ofq.clear();
    this.ofr.clear();
    AppMethodBeat.o(158968);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(com.tencent.mm.plugin.appbrand.g.c.b.d paramd);
  }
  
  public static final class b
  {
    private static c ofy;
    
    static
    {
      AppMethodBeat.i(158964);
      ofy = new c((byte)0);
      AppMethodBeat.o(158964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.c
 * JD-Core Version:    0.7.0.1
 */