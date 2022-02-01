package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.b;
import com.tencent.mm.an.j;
import com.tencent.mm.an.n;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class o
{
  private static c lUg = null;
  
  public static e WI(String paramString)
  {
    AppMethodBeat.i(239005);
    d locald = d.lUj;
    e locale = new e();
    locale.toUser = paramString;
    locale.lUB = locald;
    AppMethodBeat.o(239005);
    return locale;
  }
  
  public static e a(d paramd)
  {
    AppMethodBeat.i(239007);
    e locale = new e();
    locale.lUB = paramd;
    AppMethodBeat.o(239007);
    return locale;
  }
  
  static void a(c paramc)
  {
    lUg = paramc;
  }
  
  public static final class a
  {
    public q fzz;
    public long lUh;
  }
  
  public static final class b<T extends q>
  {
    public long lUh;
    public T lUi;
    
    public final boolean aEv()
    {
      AppMethodBeat.i(239472);
      if (this.lUi == null) {
        Log.e("SendMsgCgiFactory", "[execute] cgi is null. %s", new Object[] { Util.getStack() });
      }
      Objects.requireNonNull(this.lUi);
      boolean bool = aa.lDv.aGZ().a(this.lUi, 0);
      AppMethodBeat.o(239472);
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
      AppMethodBeat.i(241232);
      lUj = new d("TEXT", 0);
      lUk = new d("IMAGE", 1);
      lUl = new d("VIDEO", 2);
      lUm = new d("CDN_IMAGE", 3);
      lUn = new d("EMOJI", 4);
      lUo = new d[] { lUj, lUk, lUl, lUm, lUn };
      AppMethodBeat.o(241232);
    }
    
    private d() {}
  }
  
  public static class e
  {
    public int cUP;
    public String content;
    public int fJu;
    public String fLi;
    public int jXU;
    public boolean jYb;
    public int lNK;
    public String lNS = "";
    public String lPM;
    public String lPO = "";
    public int lUA;
    public o.d lUB;
    public Object lUp;
    public int lUq;
    public j lUr;
    public n lUs;
    public int lUt;
    public boolean lUu;
    public long lUv;
    public long lUw;
    public String lUx;
    public int lUy;
    public boolean lUz;
    public float latitude;
    public float longitude;
    public long msgId;
    public String thumbPath = "";
    public String toUser;
    public int type;
    
    public final <T extends q> o.b<T> bnl()
    {
      AppMethodBeat.i(241148);
      o.b localb = new o.b();
      if (o.bnk() != null)
      {
        o.a locala = o.bnk().a(this);
        localb.lUi = locala.fzz;
        localb.lUh = locala.lUh;
      }
      AppMethodBeat.o(241148);
      return localb;
    }
    
    public e wD(int paramInt)
    {
      this.type = paramInt;
      return this;
    }
    
    public e wb(int paramInt)
    {
      this.jXU = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */