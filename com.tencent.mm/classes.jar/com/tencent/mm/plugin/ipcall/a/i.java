package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.b.a;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public final class i
  implements ar
{
  private static i lpc = null;
  private static HashMap<Integer, h.d> lpv;
  private g lpd = new g();
  private com.tencent.mm.plugin.ipcall.a.c.a lpe = new com.tencent.mm.plugin.ipcall.a.c.a();
  private com.tencent.mm.plugin.ipcall.a.c.b lpf = new com.tencent.mm.plugin.ipcall.a.c.b();
  private com.tencent.mm.plugin.ipcall.a.b.b lpg = new com.tencent.mm.plugin.ipcall.a.b.b();
  private f lph = new f();
  private com.tencent.mm.plugin.ipcall.c lpi = new com.tencent.mm.plugin.ipcall.c();
  private com.tencent.mm.plugin.ipcall.a.g.d lpj;
  private l lpk;
  private j lpl;
  private com.tencent.mm.plugin.ipcall.a.g.h lpm;
  private com.tencent.mm.plugin.voip.video.i lpn;
  private com.tencent.mm.plugin.voip.video.d lpo;
  private Context lpp;
  private long lpq;
  private com.tencent.mm.sdk.b.c lpr = new i.1(this);
  private com.tencent.mm.sdk.b.c lps = new i.4(this);
  private com.tencent.mm.sdk.b.c lpt = new i.5(this);
  private com.tencent.mm.sdk.b.c lpu = new i.6(this);
  private bx.a lpw = new i.11(this);
  private bx.a lpx = new i.2(this);
  private bx.a lpy = new i.3(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    lpv = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.plugin.ipcall.a.g.d.dXp;
      }
    });
    lpv.put(Integer.valueOf("IPCallRecord".hashCode()), new i.8());
    lpv.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new i.9());
    lpv.put(Integer.valueOf("IPCallMsg".hashCode()), new i.10());
  }
  
  public static i bcf()
  {
    if (lpc == null)
    {
      lpc = new i();
      au.Hq().a("plugin.ipcall", lpc);
    }
    return lpc;
  }
  
  public static g bcg()
  {
    return bcf().lpd;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.c.a bch()
  {
    return bcf().lpe;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.c.b bci()
  {
    return bcf().lpf;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.b.b bcj()
  {
    return bcf().lpg;
  }
  
  public static f bck()
  {
    return bcf().lph;
  }
  
  public static com.tencent.mm.plugin.ipcall.c bcl()
  {
    return bcf().lpi;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.g.d bcm()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bcf().lpj == null)
    {
      i locali = bcf();
      au.Hx();
      locali.lpj = new com.tencent.mm.plugin.ipcall.a.g.d(com.tencent.mm.model.c.Dv());
    }
    return bcf().lpj;
  }
  
  public static l bcn()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bcf().lpk == null)
    {
      i locali = bcf();
      au.Hx();
      locali.lpk = new l(com.tencent.mm.model.c.Dv());
    }
    return bcf().lpk;
  }
  
  public static j bco()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bcf().lpl == null)
    {
      i locali = bcf();
      au.Hx();
      locali.lpl = new j(com.tencent.mm.model.c.Dv());
    }
    return bcf().lpl;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.g.h bcp()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bcf().lpm == null)
    {
      i locali = bcf();
      au.Hx();
      locali.lpm = new com.tencent.mm.plugin.ipcall.a.g.h(com.tencent.mm.model.c.Dv());
    }
    return bcf().lpm;
  }
  
  public static com.tencent.mm.plugin.voip.video.i bcq()
  {
    if (bcf().lpn == null) {
      bcf().lpn = new com.tencent.mm.plugin.voip.video.i(ae.getContext());
    }
    return bcf().lpn;
  }
  
  public static com.tencent.mm.plugin.voip.video.d bcr()
  {
    if (bcf().lpo == null) {
      bcf().lpo = new com.tencent.mm.plugin.voip.video.d(ae.getContext());
    }
    return bcf().lpo;
  }
  
  public final void bh(boolean paramBoolean)
  {
    Object localObject = this.lpd;
    ((g)localObject).loO.init();
    ((g)localObject).loP.init();
    ((g)localObject).loQ.init();
    ((g)localObject).loR.init();
    ((g)localObject).loS.init();
    ((g)localObject).loT.init();
    ((g)localObject).loU.init();
    ((g)localObject).loV.init();
    ((g)localObject).loO.lpA = ((a.a)localObject);
    ((g)localObject).loQ.lpA = ((a.a)localObject);
    ((g)localObject).loR.lpA = ((a.a)localObject);
    ((g)localObject).loT.lpA = ((a.a)localObject);
    ((g)localObject).loV.lpA = ((a.a)localObject);
    ((g)localObject).loP.lpB = ((b.a)localObject);
    ((g)localObject).loS.lpB = ((b.a)localObject);
    au.a(((g)localObject).loZ);
    b.init();
    localObject = d.bbW();
    com.tencent.mm.sdk.b.a.udP.c(((d)localObject).loC);
    localObject = e.bbZ();
    com.tencent.mm.sdk.b.a.udP.c(((e)localObject).fjE);
    au.getSysCmdMsgExtension().a("WeChatOut", this.lpw, true);
    au.getSysCmdMsgExtension().a("WeChatOutMsg", this.lpx, true);
    au.getSysCmdMsgExtension().a("WCONotify", this.lpy, true);
    com.tencent.mm.sdk.b.a.udP.c(this.lpr);
    com.tencent.mm.sdk.b.a.udP.c(this.lps);
    com.tencent.mm.sdk.b.a.udP.c(this.lpt);
    com.tencent.mm.sdk.b.a.udP.c(this.lpu);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (this.lph.bca()) {
      this.lpi.da(0, 0);
    }
    Object localObject = this.lpd;
    ((g)localObject).loO.destroy();
    ((g)localObject).loP.destroy();
    ((g)localObject).loQ.destroy();
    ((g)localObject).loR.destroy();
    ((g)localObject).loS.destroy();
    ((g)localObject).loU.destroy();
    au.b(((g)localObject).loZ);
    b.release();
    localObject = d.bbW();
    au.Dk().b(159, (com.tencent.mm.ah.f)localObject);
    au.Dk().b(160, (com.tencent.mm.ah.f)localObject);
    com.tencent.mm.sdk.b.a.udP.d(((d)localObject).loC);
    localObject = e.bbZ();
    com.tencent.mm.sdk.b.a.udP.d(((e)localObject).fjE);
    au.getSysCmdMsgExtension().b("WeChatOut", this.lpw, true);
    au.getSysCmdMsgExtension().b("WeChatOutMsg", this.lpx, true);
    au.getSysCmdMsgExtension().b("WCONotify", this.lpy, true);
    com.tencent.mm.sdk.b.a.udP.d(this.lpr);
    com.tencent.mm.sdk.b.a.udP.d(this.lps);
    com.tencent.mm.sdk.b.a.udP.d(this.lpt);
    com.tencent.mm.sdk.b.a.udP.d(this.lpu);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return lpv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.i
 * JD-Core Version:    0.7.0.1
 */