package com.tencent.mm.plugin.fav;

import com.tencent.mm.h.c.fo;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, ae
{
  private a jXW;
  private x jXX;
  private q jXY;
  private aa jXZ;
  private t jYa;
  private s jYb;
  private l jYc;
  private com.tencent.mm.plugin.fav.b.e.e jYd;
  private com.tencent.mm.plugin.fav.b.e.d jYe;
  private com.tencent.mm.plugin.fav.b.e.a jYf;
  private com.tencent.mm.plugin.fav.b.e.b jYg;
  private com.tencent.mm.plugin.fav.b.e.c jYh;
  private com.tencent.mm.plugin.fav.b.b.a jYi = new com.tencent.mm.plugin.fav.b.b.a();
  private com.tencent.mm.plugin.fav.b.b.b jYj = new com.tencent.mm.plugin.fav.b.b.b();
  private com.tencent.mm.sdk.b.c jYk = new PluginFav.4(this);
  
  private static void checkDir()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aPQ());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      y.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      localb.mkdirs();
    }
    localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aPI());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      y.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      localb.mkdirs();
    }
    localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aPP());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      y.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      localb.mkdirs();
    }
    localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aPR());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      y.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      localb.mkdirs();
    }
  }
  
  public void checkFavItem(ym paramym)
  {
    ai.d(new PluginFav.3(this, new com.tencent.mm.plugin.fav.b.d.a(paramym)));
  }
  
  public void checkFavItem(List<yb> paramList)
  {
    ai.d(new PluginFav.2(this, new com.tencent.mm.plugin.fav.b.d.a(paramList)));
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.jYg;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.jYh;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.jYf;
  }
  
  public q getFavCdnStorage()
  {
    return this.jXY;
  }
  
  public s getFavConfigStorage()
  {
    return this.jYb;
  }
  
  public t getFavEditInfoStorage()
  {
    return this.jYa;
  }
  
  public x getFavItemInfoStorage()
  {
    return this.jXX;
  }
  
  public aa getFavSearchStorage()
  {
    return this.jXZ;
  }
  
  public l getFavTagSetMgr()
  {
    return this.jYc;
  }
  
  public com.tencent.mm.plugin.fav.b.e.d getModService()
  {
    return this.jYe;
  }
  
  public ac getSendService()
  {
    return this.jYd;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    this.jXW = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("uploadfavitem", this.jXW);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("resendfavitem", this.jXW);
    this.jXX = new com.tencent.mm.plugin.fav.b.f.d(fo.vy());
    this.jXY = new com.tencent.mm.plugin.fav.b.f.a(fo.vy());
    this.jXZ = new com.tencent.mm.plugin.fav.b.f.e(fo.vy());
    this.jYa = new com.tencent.mm.plugin.fav.b.f.c(fo.vy());
    this.jYb = new com.tencent.mm.plugin.fav.b.f.b(fo.vy());
    this.jYd = new com.tencent.mm.plugin.fav.b.e.e();
    this.jYe = new com.tencent.mm.plugin.fav.b.e.d();
    this.jYf = new com.tencent.mm.plugin.fav.b.e.a();
    this.jYg = new com.tencent.mm.plugin.fav.b.e.b();
    this.jYh = new com.tencent.mm.plugin.fav.b.e.c();
    this.jYc = new l();
    ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSTaskDaemon().a(-86016, new PluginFav.1(this));
    this.jYk.cqo();
    this.jYi.cqo();
    this.jYj.cqo();
    checkDir();
  }
  
  public void onAccountRelease()
  {
    this.jYk.dead();
    this.jYi.dead();
    this.jYj.dead();
    ah.aQF();
    ((n)com.tencent.mm.kernel.g.t(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.g.t(n.class)).unregisterNativeLogic(6);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("uploadfavitem", this.jXW);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("resendfavitem", this.jXW);
    this.jXW = null;
    this.jXX = null;
    this.jXY = null;
    this.jXZ = null;
    this.jYa = null;
    this.jYb = null;
    this.jYc = null;
    Object localObject;
    if (this.jYd != null)
    {
      localObject = this.jYd;
      y.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).uB();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).bEd.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).bDY = 0;
      com.tencent.mm.kernel.g.Dk().b(401, (com.tencent.mm.ah.f)localObject);
      this.jYd = null;
    }
    if (this.jYe != null)
    {
      localObject = this.jYe;
      y.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).uB();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).bEd.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).bDY = 0;
      com.tencent.mm.kernel.g.Dk().b(426, (com.tencent.mm.ah.f)localObject);
      this.jYe = null;
    }
    if (this.jYf != null)
    {
      localObject = this.jYf;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).uB();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).bEd.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).bDY = 0;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).eiF);
      this.jYf = null;
    }
    if (this.jYg != null)
    {
      localObject = this.jYg;
      y.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).uB();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).bEd.stopTimer();
      com.tencent.mm.kernel.g.Dk().b(404, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.DO().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).eiF);
      this.jYg = null;
    }
    if (this.jYh != null)
    {
      localObject = this.jYh;
      y.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.g.Dk().b(426, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.kernel.g.Dk().b(401, (com.tencent.mm.ah.f)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).kaL.clear();
      this.jYh = null;
    }
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */