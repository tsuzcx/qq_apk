package com.tencent.mm.live;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import d.g.b.k;
import d.g.b.v.c;
import d.v;
import d.y;
import java.util.HashMap;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "liveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getLiveTipsBarStorage", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"})
public final class PluginLive
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a
{
  public static final a qrE;
  private com.tencent.mm.live.b.c.b qrA;
  private final i qrp;
  private final HashMap<Long, Integer> qrs;
  private final b qrx;
  
  static
  {
    AppMethodBeat.i(202551);
    qrE = new a((byte)0);
    AppMethodBeat.o(202551);
  }
  
  public PluginLive()
  {
    AppMethodBeat.i(202550);
    this.qrp = new i();
    this.qrs = new HashMap();
    this.qrx = new b(this);
    AppMethodBeat.o(202550);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(202544);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), c.qrU);
    AppMethodBeat.o(202544);
    return localHashMap;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final com.tencent.mm.live.b.c.b getLiveTipsBarStorage()
  {
    AppMethodBeat.i(202541);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.qrA == null)
    {
      localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "MMKernel.storage()");
      this.qrA = new com.tencent.mm.live.b.c.b(((com.tencent.mm.kernel.e)localObject).afg());
    }
    Object localObject = this.qrA;
    AppMethodBeat.o(202541);
    return localObject;
  }
  
  public final boolean isAnchorLiving()
  {
    String str = null;
    AppMethodBeat.i(202545);
    Object localObject1 = com.tencent.mm.live.b.f.rGw;
    if (com.tencent.mm.live.b.f.eNG().LwA != 0L)
    {
      localObject1 = com.tencent.mm.live.b.f.rGw;
      if (com.tencent.mm.live.b.f.eNH() != null)
      {
        localObject1 = com.tencent.mm.live.b.f.rGw;
        localObject1 = com.tencent.mm.live.b.f.eNH();
        if (localObject1 != null) {}
        for (localObject1 = ((eaw)localObject1).Lze;; localObject1 = null)
        {
          Object localObject2 = com.tencent.mm.live.b.f.rGw;
          localObject2 = com.tencent.mm.live.b.f.eNH();
          if (localObject2 != null) {
            str = ((eaw)localObject2).Lzw;
          }
          if (!k.g(localObject1, str)) {
            break;
          }
          AppMethodBeat.o(202545);
          return true;
        }
      }
    }
    AppMethodBeat.o(202545);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    AppMethodBeat.i(202548);
    Object localObject = com.tencent.mm.live.core.core.c.b.qOk;
    boolean bool;
    if (com.tencent.mm.live.core.core.c.b.a.cnr())
    {
      localObject = com.tencent.mm.live.core.core.c.b.qOk;
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject).qEd.qzP;
      AppMethodBeat.o(202548);
      return bool;
    }
    localObject = com.tencent.mm.live.core.core.a.b.qym;
    if (com.tencent.mm.live.core.core.a.b.a.cnr())
    {
      localObject = com.tencent.mm.live.core.core.a.b.qym;
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.a.b.a.eG((Context)localObject).qEd.qzP;
      AppMethodBeat.o(202548);
      return bool;
    }
    AppMethodBeat.o(202548);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    String str = null;
    AppMethodBeat.i(202546);
    Object localObject1 = com.tencent.mm.live.b.f.rGw;
    if (com.tencent.mm.live.b.f.eNG().LwA != 0L)
    {
      localObject1 = com.tencent.mm.live.b.f.rGw;
      if (com.tencent.mm.live.b.f.eNH() != null)
      {
        localObject1 = com.tencent.mm.live.b.f.rGw;
        localObject1 = com.tencent.mm.live.b.f.eNH();
        if (localObject1 != null) {}
        for (localObject1 = ((eaw)localObject1).Lze;; localObject1 = null)
        {
          Object localObject2 = com.tencent.mm.live.b.f.rGw;
          localObject2 = com.tencent.mm.live.b.f.eNH();
          if (localObject2 != null) {
            str = ((eaw)localObject2).Lzw;
          }
          if (!(k.g(localObject1, str) ^ true)) {
            break;
          }
          AppMethodBeat.o(202546);
          return true;
        }
      }
    }
    AppMethodBeat.o(202546);
    return false;
  }
  
  public final boolean isVisitorMicing()
  {
    AppMethodBeat.i(202547);
    Object localObject = com.tencent.mm.live.b.f.rGw;
    if (com.tencent.mm.live.b.f.eNG().LwA != 0L)
    {
      localObject = com.tencent.mm.live.core.core.c.b.qOk;
      if (com.tencent.mm.live.core.core.c.b.a.cnr())
      {
        localObject = com.tencent.mm.live.core.core.c.b.qOk;
        localObject = aj.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        if (com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject).col())
        {
          AppMethodBeat.o(202547);
          return true;
        }
      }
    }
    AppMethodBeat.o(202547);
    return false;
  }
  
  public final com.tencent.mm.live.api.a liveEntranceJumper()
  {
    return (com.tencent.mm.live.api.a)com.tencent.mm.live.b.g.ssa;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(202542);
    ad.i("MicroMsg.PluginLive", "onAccountInitialized");
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("ApplyLiveMic", (p)this.qrp);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("AcceptLiveMic", (p)this.qrp);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("CloseLive", (p)this.qrp);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("CloseLiveMic", (p)this.qrp);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("CloseApplyLiveMic", (p)this.qrp);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("BanLiveComment", (p)this.qrp);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("LiveMicSucc", (p)this.qrp);
    AppForegroundDelegate.cKE.a((com.tencent.mm.app.n)this.qrx);
    AppMethodBeat.o(202542);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(202543);
    ad.i("MicroMsg.PluginLive", "onAccountRelease");
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("ApplyLiveMic", (p)this.qrp);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("AcceptLiveMic", (p)this.qrp);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("CloseLive", (p)this.qrp);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("CloseLiveMic", (p)this.qrp);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("CloseApplyLiveMic", (p)this.qrp);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("BanLiveComment", (p)this.qrp);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("LiveMicSucc", (p)this.qrp);
    AppForegroundDelegate.cKE.b((com.tencent.mm.app.n)this.qrx);
    AppMethodBeat.o(202543);
  }
  
  public final void refreshLiveStatus(final long paramLong, String paramString, a.a parama)
  {
    AppMethodBeat.i(202549);
    k.h(paramString, "roomId");
    Object localObject = (Integer)this.qrs.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      if (parama != null)
      {
        parama.ak(paramLong, ((Integer)localObject).intValue());
        AppMethodBeat.o(202549);
        return;
      }
      AppMethodBeat.o(202549);
      return;
    }
    localObject = com.tencent.mm.kernel.g.aeS();
    k.g(localObject, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.al.q)localObject).aeW() != null)
    {
      paramString = new com.tencent.mm.live.b.a.b(paramLong, paramString, true);
      localObject = com.tencent.mm.kernel.g.aeS();
      k.g(localObject, "MMKernel.getNetSceneQueue()");
      paramString.doScene(((com.tencent.mm.al.q)localObject).aeW(), (com.tencent.mm.al.g)new d(this, paramLong, parama));
      AppMethodBeat.o(202549);
      return;
    }
    if (parama != null)
    {
      parama.ak(paramLong, 0);
      AppMethodBeat.o(202549);
      return;
    }
    AppMethodBeat.o(202549);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/PluginLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString) {}
    
    public final void onAppForeground(String paramString)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202537);
      Object localObject2;
      if (((this.qrT.isAnchorLiving()) || (this.qrT.isVisitorLiving())) && (!this.qrT.isFloatMode()))
      {
        paramString = com.tencent.mm.live.b.f.rGw;
        paramString = com.tencent.mm.live.b.f.eNK();
        if (paramString == null) {
          break label289;
        }
        paramString = paramString.qzs;
        if (paramString == null) {
          break label289;
        }
        paramString = paramString.name;
        if (!bt.isNullOrNil(paramString))
        {
          paramString = new StringBuilder("onAppForeground liveId:");
          localObject2 = com.tencent.mm.live.b.f.rGw;
          paramString = paramString.append(com.tencent.mm.live.b.f.eNG().LwA).append(" liveName:");
          localObject2 = com.tencent.mm.live.b.f.rGw;
          localObject2 = paramString.append(com.tencent.mm.live.b.f.eNG().LwZ).append(" jumpName:");
          paramString = com.tencent.mm.live.b.f.rGw;
          paramString = com.tencent.mm.live.b.f.eNK();
          if (paramString == null) {
            break label294;
          }
          paramString = paramString.qzs;
          if (paramString == null) {
            break label294;
          }
        }
      }
      label289:
      label294:
      for (paramString = paramString.name;; paramString = null)
      {
        ad.i("MicroMsg.PluginLive", paramString);
        localObject2 = aj.getContext();
        paramString = com.tencent.mm.live.b.f.rGw;
        Object localObject3 = com.tencent.mm.live.b.f.eNK();
        paramString = (String)localObject1;
        if (localObject3 != null)
        {
          localObject3 = ((d)localObject3).qzs;
          paramString = (String)localObject1;
          if (localObject3 != null) {
            paramString = ((com.tencent.mm.live.core.core.b.a)localObject3).name;
          }
        }
        localObject1 = new Intent((Context)localObject2, Class.forName(paramString));
        ((Intent)localObject1).addFlags(268435456);
        paramString = aj.getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/live/PluginLive$appForegroundListener$1", "onAppForeground", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/live/PluginLive$appForegroundListener$1", "onAppForeground", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(202537);
        return;
        paramString = null;
        break;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c qrU;
    
    static
    {
      AppMethodBeat.i(202538);
      qrU = new c();
      AppMethodBeat.o(202538);
    }
    
    public final String[] getSQLs()
    {
      return com.tencent.mm.live.b.c.b.SQL_CREATE;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class d
    implements com.tencent.mm.al.g
  {
    d(PluginLive paramPluginLive, long paramLong, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(202540);
      paramn.setHasCallbackToQueue(true);
      paramString = new v.c();
      paramString.Jhu = 0;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(202540);
          throw paramString;
        }
        paramn = ((com.tencent.mm.live.b.a.b)paramn).eNG();
        if ((paramn == null) || (paramn.nrv != 0)) {
          paramString.Jhu = 1;
        }
        ((Map)PluginLive.access$getLiveStatusMap$p(this.qrT)).put(Long.valueOf(paramLong), Integer.valueOf(paramString.Jhu));
      }
      com.tencent.mm.ad.c.g((d.g.a.a)new d.g.b.l(paramString) {});
      AppMethodBeat.o(202540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive
 * JD-Core Version:    0.7.0.1
 */