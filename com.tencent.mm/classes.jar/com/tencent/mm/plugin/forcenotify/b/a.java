package com.tencent.mm.plugin.forcenotify.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.f;
import d.g.b.p;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
public abstract class a
  implements b, n.b
{
  final String TAG = "MicroMsg.ForceNotifyService";
  private long tjD;
  private final f tjE = d.g.O((d.g.a.a)b.tjM);
  private final ap tjF = new ap(Looper.getMainLooper());
  public final ConcurrentLinkedQueue<String> tjG = new ConcurrentLinkedQueue();
  private final c tjH = new c(this);
  
  private static String ajA(String paramString)
  {
    return ".sysmsg".concat(String.valueOf(paramString));
  }
  
  private final ap cQz()
  {
    return (ap)this.tjE.getValue();
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramn = (String)paramObject + "@wxcontact";
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(bt.bI((String)paramObject, ""));
      if (localObject != null) {
        break label86;
      }
    }
    label86:
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((((am)localObject).adh()) && (!((am)localObject).adk()));
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
      bool = com.tencent.mm.plugin.forcenotify.d.a.ajC(((am)localObject).getUsername() + "@wxcontact");
      ad.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (((am)localObject).adk())
    {
      aJ(paramn, 9);
      return;
    }
    aJ(paramn, 7);
  }
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void bi(String paramString, boolean paramBoolean);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, final e.a parama)
  {
    p.h(paramMap, "map");
    ad.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((p.i(paramString, "NewXmlDelForcePush")) || (p.i(paramString, "NewXmlAddForcePush")))
    {
      parama = new d();
      parama.field_ForcePushId = ((String)paramMap.get(ajA(".forcePushId")));
      ad.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (bt.aRf((String)paramMap.get(ajA(".createTime"))) * 1000L);
      parama.field_ExpiredTime = (bt.aRf((String)paramMap.get(ajA(".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(ajA(".userIcon")));
      parama.field_UserName = ((String)paramMap.get(ajA(".userName")));
      parama.field_Description = ((String)paramMap.get(ajA(".description")));
      parama.field_ExtInfo = ((String)paramMap.get(ajA(".extInfo")));
      if (cf.aCL() < parama.field_ExpiredTime) {
        break label285;
      }
      i = 1;
      if (i != 1) {
        break label291;
      }
      i = 0;
      label248:
      parama.field_Status = i;
      if (!p.i("NewXmlDelForcePush", paramString)) {
        break label297;
      }
      cQz().post((Runnable)new d(this, parama));
    }
    label285:
    label291:
    label297:
    while (!p.i("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label248;
    }
    cQz().post((Runnable)new e(this, parama));
  }
  
  public void release()
  {
    this.tjH.dead();
    aa.a((x)this);
    Object localObject = com.tencent.mm.kernel.g.ad(r.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)localObject).getSysCmdMsgExtension().b("NewXmlAddForcePush", (com.tencent.mm.plugin.messenger.foundation.a.q)this);
    localObject = com.tencent.mm.kernel.g.ad(r.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)localObject).getSysCmdMsgExtension().b("NewXmlDelForcePush", (com.tencent.mm.plugin.messenger.foundation.a.q)this);
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().b((n.b)this);
  }
  
  public void start()
  {
    aa.a(5, (x)this);
    Object localObject = com.tencent.mm.kernel.g.ad(r.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)localObject).getSysCmdMsgExtension().a("NewXmlAddForcePush", (com.tencent.mm.plugin.messenger.foundation.a.q)this);
    localObject = com.tencent.mm.kernel.g.ad(r.class);
    p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)localObject).getSysCmdMsgExtension().a("NewXmlDelForcePush", (com.tencent.mm.plugin.messenger.foundation.a.q)this);
    this.tjH.alive();
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().a((n.b)this);
    cQz().post((Runnable)f.tjO);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama, cv paramcv) {}
    
    public final void run()
    {
      AppMethodBeat.i(149146);
      if (a.a(this.tjI))
      {
        localObject = com.tencent.mm.plugin.forcenotify.d.a.tjV;
        com.tencent.mm.plugin.forcenotify.d.a.cQF();
      }
      Object localObject = bw.M(this.tjJ.Fvn, "ForcePushId");
      if (localObject != null) {
        localObject = (String)((Map)localObject).get(".ForcePushId");
      }
      while (localObject != null)
      {
        ad.i(this.tjI.TAG, "received msg! MsgSource:%s FromUserName:%s source:%s", new Object[] { this.tjJ.Fvn, this.tjJ.Fvi, localObject });
        localObject = z.a(this.tjJ.Fvi);
        if (((p.i(u.aAm(), localObject) ^ true)) && (!a.b(this.tjI).contains(localObject)))
        {
          boolean bool = this.tjI.ajz((String)localObject);
          if (bool)
          {
            ad.i(this.tjI.TAG, "fromUser=" + (String)localObject + " isNeedNotify=" + bool);
            a.b(this.tjI).add(localObject);
            a.c(this.tjI).post((Runnable)new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(149145);
                a locala = this.tjK.tjI;
                String str = this.tjL;
                p.g(str, "fromUser");
                if (a.b(this.tjK.tjI).size() == 1) {}
                for (;;)
                {
                  locala.bi(str, bool);
                  AppMethodBeat.o(149145);
                  return;
                  bool = false;
                }
              }
            });
            AppMethodBeat.o(149146);
            return;
            localObject = null;
          }
          else
          {
            ad.w(this.tjI.TAG, "ERROR! no show!");
            AppMethodBeat.o(149146);
          }
        }
        else
        {
          ad.w(this.tjI.TAG, "ERROR! no show! notifyList=" + a.b(this.tjI));
        }
      }
      AppMethodBeat.o(149146);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<ap>
  {
    public static final b tjM;
    
    static
    {
      AppMethodBeat.i(185651);
      tjM = new b();
      AppMethodBeat.o(185651);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ManualAuthEvent;", "callback", "", "event", "plugin-force-notify_release"})
  public static final class c
    extends c<lr>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149150);
      this.tjI.a(parama, false);
      AppMethodBeat.o(149150);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149151);
      this.tjI.a(parama, true);
      AppMethodBeat.o(149151);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f tjO;
    
    static
    {
      AppMethodBeat.i(149153);
      tjO = new f();
      AppMethodBeat.o(149153);
    }
    
    public final void run()
    {
      AppMethodBeat.i(149152);
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.tjV;
      com.tencent.mm.plugin.forcenotify.d.a.cQF();
      AppMethodBeat.o(149152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */