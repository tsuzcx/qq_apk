package com.tencent.mm.plugin.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class b
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private c<np> gmQ;
  private c<no> gmR;
  private c<bs> gmS;
  private c<bt> gmT;
  private o gmU;
  c<vo> gmV;
  private d gmW;
  private com.tencent.mm.plugin.aa.a.b.b gmX;
  
  static
  {
    AppMethodBeat.i(40593);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("AARecord".hashCode()), new b.7());
    baseDBFactories.put(Integer.valueOf("AAPayRecord".hashCode()), new b.8());
    AppMethodBeat.o(40593);
  }
  
  public b()
  {
    AppMethodBeat.i(40587);
    this.gmQ = new b.1(this);
    this.gmR = new b.2(this);
    this.gmS = new b.3(this);
    this.gmT = new b.4(this);
    this.gmU = new b.5(this);
    this.gmV = new b.6(this);
    AppMethodBeat.o(40587);
  }
  
  private static b aoG()
  {
    AppMethodBeat.i(40588);
    b localb = (b)q.S(b.class);
    AppMethodBeat.o(40588);
    return localb;
  }
  
  public static d aoH()
  {
    AppMethodBeat.i(40589);
    if (aoG().gmW == null)
    {
      localObject = aoG();
      g.RM();
      ((b)localObject).gmW = new d(g.RL().eHS);
    }
    Object localObject = aoG().gmW;
    AppMethodBeat.o(40589);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.aa.a.b.b aoI()
  {
    AppMethodBeat.i(40590);
    if (aoG().gmX == null)
    {
      localObject = aoG();
      g.RM();
      ((b)localObject).gmX = new com.tencent.mm.plugin.aa.a.b.b(g.RL().eHS);
    }
    Object localObject = aoG().gmX;
    AppMethodBeat.o(40590);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(40591);
    a.ymk.c(this.gmQ);
    a.ymk.c(this.gmR);
    a.ymk.c(this.gmS);
    a.ymk.c(this.gmT);
    a.ymk.c(this.gmV);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("paymsg", this.gmU);
    AppMethodBeat.o(40591);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40592);
    a.ymk.d(this.gmQ);
    a.ymk.d(this.gmR);
    a.ymk.d(this.gmS);
    a.ymk.d(this.gmT);
    a.ymk.d(this.gmV);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("paymsg", this.gmU);
    AppMethodBeat.o(40592);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b
 * JD-Core Version:    0.7.0.1
 */