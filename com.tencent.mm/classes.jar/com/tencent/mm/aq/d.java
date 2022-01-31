package com.tencent.mm.aq;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class d
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private b emG;
  private c emH;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return b.dXp;
      }
    });
  }
  
  private static d On()
  {
    au.Hq();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)bu.iR("plugin.subapp");
    if (locala == null) {}
    for (d locald = null; locald == null; locald = (d)locala.Py(d.class.getName()))
    {
      locald = new d();
      locala.b(d.class.getName(), locald);
      return locald;
    }
    return locald;
  }
  
  public static b Oo()
  {
    g.DN().CX();
    if (On().emG == null)
    {
      d locald = On();
      au.Hx();
      locald.emG = new b(com.tencent.mm.model.c.Dv());
    }
    return On().emG;
  }
  
  public final void bh(boolean paramBoolean)
  {
    if (this.emH == null) {
      this.emH = new c();
    }
    com.tencent.mm.model.am.a.dVy = this.emH;
    y.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.emH });
    g.a(f.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    g.a(com.tencent.mm.pluginsdk.h.class, new com.tencent.mm.pluginsdk.ui.applet.h());
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aq.d
 * JD-Core Version:    0.7.0.1
 */