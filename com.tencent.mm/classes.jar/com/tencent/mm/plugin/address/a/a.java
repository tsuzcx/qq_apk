package com.tencent.mm.plugin.address.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class a
  implements ar
{
  private l ftd = null;
  private com.tencent.mm.plugin.address.b.a.a fte = null;
  private j ftf = new j();
  private k ftg = new k();
  
  public static a YB()
  {
    au.Hq();
    a locala2 = (a)bu.iR("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      y.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      au.Hq().a("plugin.address", locala1);
    }
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a YC()
  {
    g.DN().CX();
    if (YB().fte == null) {
      YB().fte = new com.tencent.mm.plugin.address.b.a.a();
    }
    return YB().fte;
  }
  
  public static l YD()
  {
    g.DN().CX();
    if (YB().ftd == null) {
      YB().ftd = new l();
    }
    return YB().ftd;
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.udP.c(this.ftf);
    com.tencent.mm.sdk.b.a.udP.c(this.ftg);
    l locall = YD();
    au.Hx();
    String str = c.FU();
    locall.path = (str + "addrmgr");
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.ftf);
    com.tencent.mm.sdk.b.a.udP.d(this.ftg);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */