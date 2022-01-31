package com.tencent.mm.openim;

import com.tencent.mm.ah.m;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.lo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.d.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class PluginOpenIM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  public static HashMap<Integer, h.d> dgp;
  private com.tencent.mm.sdk.b.c ePC = new PluginOpenIM.1(this);
  private com.tencent.mm.sdk.b.c ePD = new PluginOpenIM.2(this);
  private d ePE;
  private com.tencent.mm.openim.d.b ePF;
  private com.tencent.mm.openim.d.f ePG;
  private com.tencent.mm.ah.f eeo = new com.tencent.mm.ah.f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
    {
      if ((paramAnonymousm instanceof j))
      {
        paramAnonymousString = (j)paramAnonymousm;
        paramAnonymousm = new lo();
        paramAnonymousm.bUE.bUF = paramAnonymousString.bUF;
        com.tencent.mm.sdk.b.a.udP.m(paramAnonymousm);
      }
    }
  };
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("OpenIMAccTypeInfo_TABLE".hashCode()), new PluginOpenIM.4());
    dgp.put(Integer.valueOf("OpenIMAppIdInfo_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return d.dXp;
      }
    });
    dgp.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new PluginOpenIM.6());
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return dgp;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.openim.d.b getAccTypeInfoStg()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (this.ePF == null)
    {
      com.tencent.mm.kernel.g.DQ();
      this.ePF = new com.tencent.mm.openim.d.b(com.tencent.mm.kernel.g.DP().dKu);
    }
    return this.ePF;
  }
  
  public d getAppIdInfoStg()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (this.ePF == null)
    {
      com.tencent.mm.kernel.g.DQ();
      this.ePE = new d(com.tencent.mm.kernel.g.DP().dKu);
    }
    return this.ePE;
  }
  
  public com.tencent.mm.openim.d.f getWordingInfoStg()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (this.ePG == null)
    {
      com.tencent.mm.kernel.g.DQ();
      this.ePG = new com.tencent.mm.openim.d.f(com.tencent.mm.kernel.g.DP().dKu);
    }
    return this.ePG;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.udP.b(this.ePC);
    this.ePD.cqo();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.a(com.tencent.mm.openim.a.b.class, new com.tencent.mm.openim.b.s());
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.a(com.tencent.mm.openim.a.a.class, new com.tencent.mm.openim.c.p());
    com.tencent.mm.model.s.a((ag)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.a.class));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(453, (com.tencent.mm.ah.f)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(913, this.eeo);
  }
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.PluginOpenIM", "onAccountRelease");
    com.tencent.mm.sdk.b.a.udP.d(this.ePC);
    this.ePD.dead();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(453, (com.tencent.mm.ah.f)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(913, this.eeo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM
 * JD-Core Version:    0.7.0.1
 */