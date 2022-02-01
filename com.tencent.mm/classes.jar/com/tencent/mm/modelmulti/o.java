package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.k;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Objects;

public final class o
{
  private static c ifT = null;
  
  public static e FX(String paramString)
  {
    AppMethodBeat.i(192549);
    d locald = d.ifW;
    e locale = new e();
    locale.toUser = paramString;
    locale.ign = locald;
    AppMethodBeat.o(192549);
    return locale;
  }
  
  public static e a(d paramd)
  {
    AppMethodBeat.i(192550);
    e locale = new e();
    locale.ign = paramd;
    AppMethodBeat.o(192550);
    return locale;
  }
  
  static void a(c paramc)
  {
    ifT = paramc;
  }
  
  public static final class a
  {
    public n dor;
    public long ifU;
  }
  
  public static final class b<T extends n>
  {
    public long ifU;
    public T ifV;
    
    public final boolean execute()
    {
      AppMethodBeat.i(192544);
      if (this.ifV == null) {
        ad.e("SendMsgCgiFactory", "[execute] cgi is null. %s", new Object[] { bt.flS() });
      }
      Objects.requireNonNull(this.ifV);
      boolean bool = x.hPm.aiV().a(this.ifV, 0);
      AppMethodBeat.o(192544);
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
      AppMethodBeat.i(192547);
      ifW = new d("TEXT", 0);
      ifX = new d("IMAGE", 1);
      ifY = new d("VIDEO", 2);
      ifZ = new d("CDN_IMAGE", 3);
      iga = new d[] { ifW, ifX, ifY, ifZ };
      AppMethodBeat.o(192547);
    }
    
    private d() {}
  }
  
  public static class e
  {
    public String content;
    public float dAp;
    public int dDp;
    public int dxr;
    public String dyU;
    public float dyz;
    public int gwQ;
    public boolean gwX;
    public String hZI = "";
    public int hZz;
    public String ibD;
    public String ibF = "";
    public Object igb;
    public int igc;
    public g igd;
    public k ige;
    public int igf;
    public boolean igg;
    public long igh;
    public long igi;
    public String igj;
    public int igk;
    public boolean igl;
    public int igm;
    public o.d ign;
    public long msgId;
    public String thumbPath = "";
    public String toUser;
    public int type;
    
    public final <T extends n> o.b<T> aJv()
    {
      AppMethodBeat.i(192548);
      o.b localb = new o.b();
      if (o.aJu() != null)
      {
        o.a locala = o.aJu().a(this);
        localb.ifV = locala.dor;
        localb.ifU = locala.ifU;
      }
      AppMethodBeat.o(192548);
      return localb;
    }
    
    public e pk(int paramInt)
    {
      this.gwQ = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */