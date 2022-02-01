package com.tencent.mm.plugin.forcenotify.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import d.f;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getExecutor", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "executor$delegate", "Lkotlin/Lazy;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "modifyForceNotify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "isAdd", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
public abstract class a
  implements b, n.b
{
  final String TAG = "MicroMsg.ForceNotifyService";
  private long ree;
  private final f reg = d.g.E((d.g.a.a)a.b.reo);
  private final ap reh = new ap(Looper.getMainLooper());
  public final ConcurrentLinkedQueue<String> rei = new ConcurrentLinkedQueue();
  private final a.c rej = new a.c(this);
  
  private static String aak(String paramString)
  {
    return ".sysmsg".concat(String.valueOf(paramString));
  }
  
  private final ap cuY()
  {
    return (ap)this.reg.getValue();
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    Object localObject;
    if (((paramObject instanceof String)) && ((paramInt == 5) || (paramInt == 4)))
    {
      paramn = (String)paramObject + "@wxcontact";
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(bt.by((String)paramObject, ""));
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
      } while ((((af)localObject).ZJ()) && (!((af)localObject).ZM()));
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
      bool = com.tencent.mm.plugin.forcenotify.d.a.aam(((af)localObject).getUsername() + "@wxcontact");
      ad.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", new Object[] { paramObject, Boolean.valueOf(bool) });
    } while (!bool);
    if (((af)localObject).ZM())
    {
      aD(paramn, 9);
      return;
    }
    aD(paramn, 7);
  }
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void aX(String paramString, boolean paramBoolean);
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, final f.a parama)
  {
    d.g.b.k.h(paramMap, "map");
    ad.i(this.TAG, "[onNewXmlReceived] type:%s map:%s", new Object[] { paramString, parama });
    int i;
    if ((d.g.b.k.g(paramString, "NewXmlDelForcePush")) || (d.g.b.k.g(paramString, "NewXmlAddForcePush")))
    {
      parama = new d();
      parama.field_ForcePushId = ((String)paramMap.get(aak(".forcePushId")));
      ad.i(this.TAG, "[onNewXmlReceived] forcePushId:%s", new Object[] { parama.field_ForcePushId });
      parama.field_CreateTime = (bt.aGi((String)paramMap.get(aak(".createTime"))) * 1000L);
      parama.field_ExpiredTime = (bt.aGi((String)paramMap.get(aak(".expiredTime"))) * 1000L);
      parama.field_UserIcon = ((String)paramMap.get(aak(".userIcon")));
      parama.field_UserName = ((String)paramMap.get(aak(".userName")));
      parama.field_Description = ((String)paramMap.get(aak(".description")));
      parama.field_ExtInfo = ((String)paramMap.get(aak(".extInfo")));
      if (ce.asR() < parama.field_ExpiredTime) {
        break label285;
      }
      i = 1;
      if (i != 1) {
        break label291;
      }
      i = 0;
      label248:
      parama.field_Status = i;
      if (!d.g.b.k.g("NewXmlDelForcePush", paramString)) {
        break label297;
      }
      cuY().post((Runnable)new d(this, parama));
    }
    label285:
    label291:
    label297:
    while (!d.g.b.k.g("NewXmlAddForcePush", paramString))
    {
      return;
      i = 0;
      break;
      i = 1;
      break label248;
    }
    cuY().post((Runnable)new e(this, parama));
  }
  
  public void release()
  {
    this.rej.dead();
    y.a((v)this);
    Object localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().b("NewXmlAddForcePush", (p)this);
    localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().b("NewXmlDelForcePush", (p)this);
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().b((n.b)this);
  }
  
  public void start()
  {
    y.a(5, (v)this);
    Object localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().a("NewXmlAddForcePush", (p)this);
    localObject = com.tencent.mm.kernel.g.ad(q.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((q)localObject).getSysCmdMsgExtension().a("NewXmlDelForcePush", (p)this);
    this.rej.alive();
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().a((n.b)this);
    cuY().post((Runnable)f.rer);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama, cs paramcs) {}
    
    public final void run()
    {
      AppMethodBeat.i(149146);
      if (a.a(this.rek))
      {
        localObject = com.tencent.mm.plugin.forcenotify.d.a.rez;
        com.tencent.mm.plugin.forcenotify.d.a.cve();
      }
      Object localObject = bw.K(this.rel.CxC, "ForcePushId");
      if (localObject != null) {
        localObject = (String)((Map)localObject).get(".ForcePushId");
      }
      while (localObject != null)
      {
        ad.i(this.rek.TAG, "received msg! MsgSource:%s FromUserName:%s source:%s", new Object[] { this.rel.CxC, this.rel.Cxx, localObject });
        localObject = z.a(this.rel.Cxx);
        if (((d.g.b.k.g(u.aqG(), localObject) ^ true)) && (!a.b(this.rek).contains(localObject)))
        {
          boolean bool = this.rek.aaj((String)localObject);
          if (bool)
          {
            ad.i(this.rek.TAG, "fromUser=" + (String)localObject + " isNeedNotify=" + bool);
            a.b(this.rek).add(localObject);
            a.c(this.rek).post((Runnable)new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(149145);
                a locala = this.rem.rek;
                String str = this.ren;
                d.g.b.k.g(str, "fromUser");
                if (a.b(this.rem.rek).size() == 1) {}
                for (;;)
                {
                  locala.aX(str, bool);
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
            ad.w(this.rek.TAG, "ERROR! no show!");
            AppMethodBeat.o(149146);
          }
        }
        else
        {
          ad.w(this.rek.TAG, "ERROR! no show! notifyList=" + a.b(this.rek));
        }
      }
      AppMethodBeat.o(149146);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149150);
      this.rek.a(parama, false);
      AppMethodBeat.o(149150);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(149151);
      this.rek.a(parama, true);
      AppMethodBeat.o(149151);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f rer;
    
    static
    {
      AppMethodBeat.i(149153);
      rer = new f();
      AppMethodBeat.o(149153);
    }
    
    public final void run()
    {
      AppMethodBeat.i(149152);
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.rez;
      com.tencent.mm.plugin.forcenotify.d.a.cve();
      AppMethodBeat.o(149152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */