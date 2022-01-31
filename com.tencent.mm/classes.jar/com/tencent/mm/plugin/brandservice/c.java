package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.brandservice.ui.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class c
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private c.a ibP;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.a.d ibQ;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.b.c ibR;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.c.e ibS;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("BIZAPPMSGCONTEXT_TABLE".hashCode()), new c.1());
    dgp.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new c.2());
    dgp.put(Integer.valueOf("TMPLINFO_TABLE".hashCode()), new c.3());
  }
  
  private static c axn()
  {
    return (c)p.B(c.class);
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.a.a.d axo()
  {
    g.DN().CX();
    if (axn().ibQ == null) {
      axn().ibQ = new com.tencent.mm.plugin.brandservice.ui.timeline.a.a.d(g.DP().dKu);
    }
    return axn().ibQ;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.a.b.c axp()
  {
    g.DN().CX();
    if (axn().ibR == null) {
      axn().ibR = new com.tencent.mm.plugin.brandservice.ui.timeline.a.b.c(g.DP().dKu);
    }
    return axn().ibR;
  }
  
  public static com.tencent.mm.plugin.brandservice.ui.timeline.a.c.e axq()
  {
    g.DN().CX();
    if (axn().ibS == null) {
      axn().ibS = new com.tencent.mm.plugin.brandservice.ui.timeline.a.c.e(g.DP().dKu);
    }
    return axn().ibS;
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
    if (this.ibP == null) {
      this.ibP = new c.a();
    }
    com.tencent.mm.sdk.b.a.udP.c(this.ibP);
    Object localObject = new com.tencent.mm.plugin.brandservice.ui.a.d();
    ((n)g.t(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new b();
    ((n)g.t(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (this.ibP != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.ibP);
    }
    ((n)g.t(n.class)).unregisterFTSUILogic(96);
    ((n)g.t(n.class)).unregisterFTSUILogic(4208);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c
 * JD-Core Version:    0.7.0.1
 */