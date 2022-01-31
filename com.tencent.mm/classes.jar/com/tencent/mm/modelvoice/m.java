package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.f.b.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.cd;
import java.util.HashMap;
import junit.framework.Assert;

public class m
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private u eKQ;
  private cd eKR;
  private i eKS;
  private r eKT = new r();
  private c eKU = new m.1(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new m.2());
    dgp.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new m.3());
  }
  
  private static m Tf()
  {
    return (m)p.B(m.class);
  }
  
  public static u Tg()
  {
    g.DN().CX();
    if (Tf().eKQ == null) {
      if (g.DP().dKu == null) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      Tf().eKQ = new u(g.DP().dKu);
      return Tf().eKQ;
    }
  }
  
  public static cd Th()
  {
    g.DN().CX();
    if (Tf().eKR == null) {
      if (g.DP().dKu == null) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dataDB is null ", bool);
      Tf().eKR = new cd(g.DP().dKu);
      return Tf().eKR;
    }
  }
  
  public static i Ti()
  {
    g.DN().CX();
    if (Tf().eKS == null) {
      Tf().eKS = new i();
    }
    return Tf().eKS;
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(34), this.eKT);
    com.tencent.mm.sdk.b.a.udP.c(this.eKU);
    b.a(new m.a(), new String[] { "//voicetrymore" });
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (Tf().eKS != null) {
      Tf().eKS.bDY = 0;
    }
    e.d.b(Integer.valueOf(34), this.eKT);
    com.tencent.mm.sdk.b.a.udP.d(this.eKU);
    b.E(new String[] { "//voicetrymore" });
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.m
 * JD-Core Version:    0.7.0.1
 */