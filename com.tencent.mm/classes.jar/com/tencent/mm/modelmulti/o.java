package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Objects;

public final class o
{
  private static c iiM = null;
  
  public static e Gz(String paramString)
  {
    AppMethodBeat.i(213424);
    d locald = d.iiP;
    e locale = new e();
    locale.toUser = paramString;
    locale.ijg = locald;
    AppMethodBeat.o(213424);
    return locale;
  }
  
  public static e a(d paramd)
  {
    AppMethodBeat.i(213425);
    e locale = new e();
    locale.ijg = paramd;
    AppMethodBeat.o(213425);
    return locale;
  }
  
  static void a(c paramc)
  {
    iiM = paramc;
  }
  
  public static final class a
  {
    public n dpw;
    public long iiN;
  }
  
  public static final class b<T extends n>
  {
    public long iiN;
    public T iiO;
    
    public final boolean execute()
    {
      AppMethodBeat.i(213419);
      if (this.iiO == null) {
        ae.e("SendMsgCgiFactory", "[execute] cgi is null. %s", new Object[] { bu.fpN() });
      }
      Objects.requireNonNull(this.iiO);
      boolean bool = x.hSf.ajk().a(this.iiO, 0);
      AppMethodBeat.o(213419);
      return bool;
    }
  }
  
  public static abstract interface c
  {
    public abstract o.a a(o.e parame);
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(213422);
      iiP = new d("TEXT", 0);
      iiQ = new d("IMAGE", 1);
      iiR = new d("VIDEO", 2);
      iiS = new d("CDN_IMAGE", 3);
      iiT = new d[] { iiP, iiQ, iiR, iiS };
      AppMethodBeat.o(213422);
    }
    
    private d() {}
  }
  
  public static class e
  {
    public String content;
    public float dBu;
    public int dEu;
    public int dyw;
    public float dzE;
    public String dzZ;
    public boolean gzE;
    public int gzx;
    public String icA = "";
    public int icr;
    public String iew;
    public String iey = "";
    public Object iiU;
    public int iiV;
    public g iiW;
    public k iiX;
    public int iiY;
    public boolean iiZ;
    public long ija;
    public long ijb;
    public String ijc;
    public int ijd;
    public boolean ije;
    public int ijf;
    public o.d ijg;
    public long msgId;
    public String thumbPath = "";
    public String toUser;
    public int type;
    
    public final <T extends n> o.b<T> aJO()
    {
      AppMethodBeat.i(213423);
      o.b localb = new o.b();
      if (o.aJN() != null)
      {
        o.a locala = o.aJN().a(this);
        localb.iiO = locala.dpw;
        localb.iiN = locala.iiN;
      }
      AppMethodBeat.o(213423);
      return localb;
    }
    
    public e pn(int paramInt)
    {
      this.gzx = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */