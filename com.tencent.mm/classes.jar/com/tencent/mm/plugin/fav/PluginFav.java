package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.g.c.gc;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
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
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, ae
{
  private j.a appForegroundListener;
  private com.tencent.mm.plugin.fav.b.e.b msA;
  private com.tencent.mm.plugin.fav.b.e.c msB;
  private com.tencent.mm.plugin.fav.b.b.a msC;
  private com.tencent.mm.plugin.fav.b.b.b msD;
  private com.tencent.mm.sdk.b.c msE;
  private a msq;
  private x msr;
  private q mss;
  private aa mst;
  private t msu;
  private s msv;
  private l msw;
  private com.tencent.mm.plugin.fav.b.e.e msx;
  private com.tencent.mm.plugin.fav.b.e.d msy;
  private com.tencent.mm.plugin.fav.b.e.a msz;
  
  public PluginFav()
  {
    AppMethodBeat.i(5287);
    this.msC = new com.tencent.mm.plugin.fav.b.b.a();
    this.msD = new com.tencent.mm.plugin.fav.b.b.b();
    this.msE = new PluginFav.4(this);
    this.appForegroundListener = new PluginFav.5(this);
    AppMethodBeat.o(5287);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(5292);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bwe());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      ab.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      localb.mkdirs();
    }
    localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bvW());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      ab.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      localb.mkdirs();
    }
    localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bwd());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      ab.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      localb.mkdirs();
    }
    localb = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bwf());
    if ((!localb.exists()) || (!localb.isDirectory()))
    {
      ab.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      localb.mkdirs();
    }
    AppMethodBeat.o(5292);
  }
  
  public void checkFavItem(act paramact)
  {
    AppMethodBeat.i(5291);
    al.d(new PluginFav.3(this, new com.tencent.mm.plugin.fav.b.d.a(paramact)));
    AppMethodBeat.o(5291);
  }
  
  public void checkFavItem(List<acg> paramList)
  {
    AppMethodBeat.i(5290);
    al.d(new PluginFav.2(this, new com.tencent.mm.plugin.fav.b.d.a(paramList)));
    AppMethodBeat.o(5290);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.msA;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.msB;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.msz;
  }
  
  public q getFavCdnStorage()
  {
    return this.mss;
  }
  
  public s getFavConfigStorage()
  {
    return this.msv;
  }
  
  public t getFavEditInfoStorage()
  {
    return this.msu;
  }
  
  public x getFavItemInfoStorage()
  {
    return this.msr;
  }
  
  public aa getFavSearchStorage()
  {
    return this.mst;
  }
  
  public l getFavTagSetMgr()
  {
    return this.msw;
  }
  
  public com.tencent.mm.plugin.fav.b.e.d getModService()
  {
    return this.msy;
  }
  
  public ac getSendService()
  {
    return this.msx;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(5288);
    this.msq = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("uploadfavitem", this.msq);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("resendfavitem", this.msq);
    this.msr = new com.tencent.mm.plugin.fav.b.f.d(gc.HH());
    this.mss = new com.tencent.mm.plugin.fav.b.f.a(gc.HH());
    this.mst = new com.tencent.mm.plugin.fav.b.f.e(gc.HH());
    this.msu = new com.tencent.mm.plugin.fav.b.f.c(gc.HH());
    this.msv = new com.tencent.mm.plugin.fav.b.f.b(gc.HH());
    this.msx = new com.tencent.mm.plugin.fav.b.e.e();
    this.msy = new com.tencent.mm.plugin.fav.b.e.d();
    this.msz = new com.tencent.mm.plugin.fav.b.e.a();
    this.msA = new com.tencent.mm.plugin.fav.b.e.b();
    this.msB = new com.tencent.mm.plugin.fav.b.e.c();
    this.msw = new l();
    ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSTaskDaemon().a(-86016, new PluginFav.1(this));
    this.msE.alive();
    this.msC.alive();
    this.appForegroundListener.alive();
    this.msD.alive();
    checkDir();
    AppMethodBeat.o(5288);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(5289);
    this.msE.dead();
    this.msC.dead();
    this.msD.dead();
    this.appForegroundListener.dead();
    ah.bwU();
    ((n)com.tencent.mm.kernel.g.G(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.g.G(n.class)).unregisterNativeLogic(6);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("uploadfavitem", this.msq);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("resendfavitem", this.msq);
    this.msq = null;
    Object localObject;
    if (this.msx != null)
    {
      localObject = this.msx;
      ab.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).ET();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).ckR.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).ckM = 0;
      com.tencent.mm.kernel.g.Rc().b(401, (com.tencent.mm.ai.f)localObject);
      this.msx = null;
    }
    if (this.msy != null)
    {
      localObject = this.msy;
      ab.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).ET();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).ckR.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).ckM = 0;
      com.tencent.mm.kernel.g.Rc().b(426, (com.tencent.mm.ai.f)localObject);
      this.msy = null;
    }
    if (this.msz != null)
    {
      localObject = this.msz;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).ET();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).ckR.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).ckM = 0;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).fyJ);
      this.msz = null;
    }
    if (this.msA != null)
    {
      localObject = this.msA;
      ab.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).ET();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).ckR.stopTimer();
      com.tencent.mm.kernel.g.Rc().b(404, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.RK().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).fyJ);
      this.msA = null;
    }
    if (this.msB != null)
    {
      localObject = this.msB;
      ab.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.g.Rc().b(426, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.Rc().b(401, (com.tencent.mm.ai.f)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).mvh.clear();
      this.msB = null;
    }
    this.msr = null;
    this.mss = null;
    this.mst = null;
    this.msu = null;
    this.msv = null;
    this.msw = null;
    AppMethodBeat.o(5289);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */