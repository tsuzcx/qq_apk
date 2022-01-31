package com.tencent.mm.as;

import android.os.Looper;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.cache.e.a;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class o
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private g eqa;
  private i eqb;
  private c eqc;
  private j eqd = new j();
  private d eqe = null;
  private h eqf = new h();
  private b eqg = null;
  private p eqh = null;
  private com.tencent.mm.sdk.b.c eqi = new o.1(this);
  private com.tencent.mm.as.a.a eqj = null;
  private SFSContext eqk = null;
  private SFSContext eql = null;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new o.2());
  }
  
  private static o OG()
  {
    try
    {
      o localo = (o)com.tencent.mm.model.p.B(o.class);
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static i OH()
  {
    if (OG().eqb == null) {
      OG().eqb = new i();
    }
    return OG().eqb;
  }
  
  public static c OI()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (OG().eqc == null) {
      OG().eqc = new c();
    }
    return OG().eqc;
  }
  
  public static g OJ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (OG().eqa == null) {
      OG().eqa = new g(com.tencent.mm.kernel.g.DP().dKu);
    }
    return OG().eqa;
  }
  
  public static d OK()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (OG().eqe == null) {
      OG().eqe = new d();
    }
    return OG().eqe;
  }
  
  public static b OL()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (OG().eqg == null) {
      OG().eqg = new b(Looper.getMainLooper());
    }
    return OG().eqg;
  }
  
  public static p OM()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (OG().eqh == null) {
      OG().eqh = new p();
    }
    return OG().eqh;
  }
  
  public static com.tencent.mm.as.a.a ON()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (OG().eqj == null) {
      OG().eqj = com.tencent.mm.as.a.a.OT();
    }
    return OG().eqj;
  }
  
  public static SFSContext OO()
  {
    return null;
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(3), this.eqf);
    e.d.a(Integer.valueOf(23), this.eqf);
    e.a.a("local_cdn_img_cache", this.eqd);
    com.tencent.mm.sdk.b.a.udP.c(this.eqi);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    o localo = OG();
    if (localo.eqb != null)
    {
      ??? = localo.eqb;
      ((i)???).bDY = 0;
      com.tencent.mm.kernel.g.DO().dJT.b(110, (com.tencent.mm.ah.f)???);
    }
    b localb;
    if (localo.eqg != null) {
      localb = localo.eqg;
    }
    synchronized (localb.emL)
    {
      localb.emL.clear();
      localb.emM = 0L;
      OK().a(localb);
      com.tencent.mm.sdk.b.a.udP.d(localb.emX);
      com.tencent.mm.sdk.b.a.udP.d(localb.emY);
      if (localo.eqe == null) {
        break label193;
      }
      ??? = localo.eqe;
      y.i("ModelImage.DownloadImgService", "on detach");
      y.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((d)???).eni = true;
      ((d)???).b(((d)???).eng);
      if (((d)???).ene.size() > 0) {
        ((d)???).b((d.b)((d)???).ene.get(0));
      }
    }
    ((d)???).Op();
    com.tencent.mm.kernel.g.DO().dJT.b(109, (com.tencent.mm.ah.f)???);
    label193:
    if (localObject1.eqh != null)
    {
      ??? = localObject1.eqh;
      y.i("MicroMsg.UrlImageCacheService", "detach");
      ((p)???).eqn.clear();
      ((p)???).eqp = true;
    }
    ??? = OG().eqa;
    if (??? != null)
    {
      y.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { bk.csb() });
      ((g)???).enW.clear();
    }
    ??? = OG().eqj;
    if (??? != null) {
      ((com.tencent.mm.as.a.a)???).detach();
    }
    e.d.b(Integer.valueOf(3), this.eqf);
    e.d.b(Integer.valueOf(23), this.eqf);
    e.a.a("local_cdn_img_cache", null);
    com.tencent.mm.sdk.b.a.udP.d(this.eqi);
    if (localObject1.eqj != null)
    {
      localObject1.eqj.detach();
      localObject1.eqj = null;
    }
    if (localObject1.eqk != null)
    {
      localObject1.eqk.release();
      localObject1.eqk = null;
    }
    if (localObject1.eql != null)
    {
      localObject1.eql.release();
      localObject1.eql = null;
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.o
 * JD-Core Version:    0.7.0.1
 */