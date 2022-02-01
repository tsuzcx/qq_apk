package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.am.m;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class t
{
  private static c oMZ = null;
  
  public static e OH(String paramString)
  {
    AppMethodBeat.i(243125);
    d locald = d.oNc;
    e locale = new e();
    locale.toUser = paramString;
    locale.oNu = locald;
    AppMethodBeat.o(243125);
    return locale;
  }
  
  public static e a(d paramd)
  {
    AppMethodBeat.i(243128);
    e locale = new e();
    locale.oNu = paramd;
    AppMethodBeat.o(243128);
    return locale;
  }
  
  static void a(c paramc)
  {
    oMZ = paramc;
  }
  
  public static final class a
  {
    public p hEi;
    public long oNa;
  }
  
  public static final class b<T extends p>
  {
    public long oNa;
    public T oNb;
    
    public final boolean aXz()
    {
      AppMethodBeat.i(243110);
      if (this.oNb == null) {
        Log.e("SendMsgCgiFactory", "[execute] cgi is null. %s", new Object[] { Util.getStack() });
      }
      Objects.requireNonNull(this.oNb);
      boolean bool = z.ovg.aZX().a(this.oNb, 0);
      AppMethodBeat.o(243110);
      return bool;
    }
  }
  
  public static abstract interface c
  {
    public abstract t.a a(t.e parame);
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(243105);
      oNc = new d("TEXT", 0);
      oNd = new d("IMAGE", 1);
      oNe = new d("VIDEO", 2);
      oNf = new d("CDN_IMAGE", 3);
      oNg = new d("EMOJI", 4);
      oNh = new d[] { oNc, oNd, oNe, oNf, oNg };
      AppMethodBeat.o(243105);
    }
    
    private d() {}
  }
  
  public static class e
  {
    public String content;
    public int eQp;
    public int hOX;
    public String hQQ;
    public float latitude;
    public float longitude;
    public long msgId;
    public int mxO;
    public boolean mxV;
    public String oGC = "";
    public int oGu;
    public String oIv;
    public String oIx = "";
    public Object oNi;
    public int oNj;
    public i oNk;
    public m oNl;
    public int oNm;
    public boolean oNn;
    public long oNo;
    public long oNp;
    public String oNq;
    public int oNr;
    public boolean oNs;
    public int oNt;
    public t.d oNu;
    public String thumbPath = "";
    public String toUser;
    public int type;
    
    public final <T extends p> t.b<T> bKW()
    {
      AppMethodBeat.i(243106);
      t.b localb = new t.b();
      if (t.bKV() != null)
      {
        t.a locala = t.bKV().a(this);
        localb.oNb = locala.hEi;
        localb.oNa = locala.oNa;
      }
      AppMethodBeat.o(243106);
      return localb;
    }
    
    public e wF(int paramInt)
    {
      this.type = paramInt;
      return this;
    }
    
    public e wg(int paramInt)
    {
      this.mxO = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.t
 * JD-Core Version:    0.7.0.1
 */