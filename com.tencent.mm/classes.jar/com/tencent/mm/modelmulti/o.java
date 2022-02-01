package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;

public final class o
{
  private static c jdH = null;
  
  public static e Pl(String paramString)
  {
    AppMethodBeat.i(225966);
    d locald = d.jdK;
    e locale = new e();
    locale.toUser = paramString;
    locale.jec = locald;
    AppMethodBeat.o(225966);
    return locale;
  }
  
  public static e a(d paramd)
  {
    AppMethodBeat.i(225967);
    e locale = new e();
    locale.jec = paramd;
    AppMethodBeat.o(225967);
    return locale;
  }
  
  static void a(c paramc)
  {
    jdH = paramc;
  }
  
  public static final class a
  {
    public q dGJ;
    public long jdI;
  }
  
  public static abstract interface c
  {
    public abstract o.a a(o.e parame);
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(225964);
      jdK = new d("TEXT", 0);
      jdL = new d("IMAGE", 1);
      jdM = new d("VIDEO", 2);
      jdN = new d("CDN_IMAGE", 3);
      jdO = new d("EMOJI", 4);
      jdP = new d[] { jdK, jdL, jdM, jdN, jdO };
      AppMethodBeat.o(225964);
    }
    
    private d() {}
  }
  
  public static class e
  {
    public int cSx;
    public String content;
    public int dQd;
    public String dRL;
    public float dTj;
    public int hmk;
    public boolean hmr;
    public int iXp;
    public String iXy = "";
    public String iZr;
    public String iZt = "";
    public Object jdQ;
    public int jdR;
    public j jdS;
    public n jdT;
    public int jdU;
    public boolean jdV;
    public long jdW;
    public long jdX;
    public String jdY;
    public int jdZ;
    public boolean jea;
    public int jeb;
    public o.d jec;
    public float latitude;
    public long msgId;
    public String thumbPath = "";
    public String toUser;
    public int type;
    
    public final <T extends q> o.b<T> bdQ()
    {
      AppMethodBeat.i(225965);
      o.b localb = new o.b();
      if (o.bdP() != null)
      {
        o.a locala = o.bdP().a(this);
        localb.jdJ = locala.dGJ;
        localb.jdI = locala.jdI;
      }
      AppMethodBeat.o(225965);
      return localb;
    }
    
    public e tD(int paramInt)
    {
      this.type = paramInt;
      return this;
    }
    
    public e tc(int paramInt)
    {
      this.hmk = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */